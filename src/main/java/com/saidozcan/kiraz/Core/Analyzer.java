package com.saidozcan.kiraz.Core;

import zemberek.morphology.analysis.WordAnalysis;
import zemberek.morphology.analysis.SentenceAnalysis;
import zemberek.morphology.analysis.tr.TurkishMorphology;
import zemberek.morphology.analysis.tr.TurkishSentenceAnalyzer;

import java.util.*;

/**
 * Created by mozcan on 22/05/2017.
 */
public class Analyzer {
    private TurkishMorphology turkishMorphology;
    private TurkishSentenceAnalyzer turkishSentenceAnalyzer;

    public Analyzer(TurkishMorphology turkishMorphology, TurkishSentenceAnalyzer turkishSentenceAnalyzer){
        this.turkishMorphology = turkishMorphology;
        this.turkishSentenceAnalyzer = turkishSentenceAnalyzer;
    }

    public HashMap<String, String> analyzeWord(String word) {
        word = word.replaceAll("[^a-zA-Z\\s]", "");

        List<WordAnalysis> analyzeResults = this.turkishMorphology.analyze(word);
        HashMap<String, String> finalResult = new HashMap();

        HashSet<String> roots = new HashSet();
        HashSet<String> stems = new HashSet();
        HashSet<String> lemmas = new HashSet();
        
        for (WordAnalysis result : analyzeResults) {
            roots.add(result.root);

            for (String stem : result.getStems()) {
                stems.add(stem);
            }

            for (String lemma : result.getLemmas()) {
                lemmas.add(lemma);
            }
        }

        finalResult.put("roots", this.hashSetToString(roots));
        finalResult.put("stems", this.hashSetToString(stems));
        finalResult.put("lemmas", this.hashSetToString(lemmas));
        return finalResult;
    }

    public HashMap<String, String> analyzeSentence(String sentence) {
        List<String> results = new ArrayList();
        HashMap<String, String> result = new HashMap();
        SentenceAnalysis sentenceAnalysis = this.turkishSentenceAnalyzer.analyze(sentence);
        Iterator iterator = sentenceAnalysis.iterator();

        while(iterator.hasNext()) {
            SentenceAnalysis.Entry entry = (SentenceAnalysis.Entry) iterator.next();
            WordAnalysis wordAnalysis = entry.parses.get(0);
            results.add(wordAnalysis.root);
        }

        String cleanedString = this.cleanBracketsInString(results.toString());
        cleanedString = cleanedString.replace(",", "");

        result.put("original", sentence);
        result.put("processed", cleanedString);
        return result;
    }

    private String cleanBracketsInString(String inputString) {
        return inputString.replace("[", "").replace("]", "").trim();
    }

    private String hashSetToString(HashSet<String> hashSet) {
        return this.cleanBracketsInString(hashSet.toString());
    }
}
