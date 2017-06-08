package com.saidozcan.kiraz.RequestProcessing;

import com.saidozcan.kiraz.Core.Analyzer;
import com.saidozcan.kiraz.Models.ProcessingMode;
import com.saidozcan.kiraz.Models.Request;
import com.saidozcan.kiraz.Models.Response;
import com.saidozcan.kiraz.Models.ValidationResult;
import zemberek.morphology.ambiguity.Z3MarkovModelDisambiguator;
import zemberek.morphology.analysis.tr.TurkishMorphology;
import zemberek.morphology.analysis.tr.TurkishSentenceAnalyzer;

import java.io.IOException;

/**
 * Created by mozcan on 22/05/2017.
 */
public class RequestDispatcher {

    private Request request;

    public RequestDispatcher(Request request) {
        this.request = request;
    }

    public Response dispatch() {
        ValidationResult validationResult = this.request.validate();
        if (!validationResult.isValid()) {
            return new Response(validationResult.getValidationErrorMessage());
        }

        return this.process();
    }

    private Response process() {
        try {
            TurkishMorphology turkishMorphology = TurkishMorphology.createWithDefaults();
            Z3MarkovModelDisambiguator disambiguator = new Z3MarkovModelDisambiguator();
            TurkishSentenceAnalyzer turkishSentenceAnalyzer = new TurkishSentenceAnalyzer(turkishMorphology, disambiguator);
            Analyzer analyzer = new Analyzer(turkishMorphology, turkishSentenceAnalyzer);

            String query = this.request.getQuery();
            ProcessingMode mode = this.request.getCurrentMode();

            switch (mode) {
                case WORD:
                    return new Response(analyzer.analyzeWord(query));
                case SENTENCE:
                    return new Response(analyzer.analyzeSentence(query));
                default:
                    break;
            }
        } catch (IOException e) {
            return new Response("An internal error occured: -1.");
        }
        return new Response();
    }
}
