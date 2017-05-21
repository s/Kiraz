package com.saidozcan.kiraz;

import zemberek.morphology.analysis.WordAnalysis;
import zemberek.morphology.analysis.tr.TurkishMorphology;

import java.io.IOException;
import java.util.*;

/**
 * Created by mozcan on 21/05/2017.
 */
public class StemFinder {
    TurkishMorphology morphology;
    final static String rootKey = "root";
    final static String lemmaKey = "lemma";
    final static String rawLongStringKey = "raw";

    public StemFinder(TurkishMorphology turkishMorphology) {
        this.morphology = turkishMorphology;
    }

    public List<HashMap<String,String>> analyze(String word) {
        List<WordAnalysis> analyzeResults = morphology.analyze(word);
        List<HashMap<String, String>> allResults = new ArrayList<HashMap<String, String>>();

        for (WordAnalysis aResult : analyzeResults) {
            HashMap <String, String> oneResult = new HashMap<String, String>();

            String root = aResult.getRoot();
            String lemma = aResult.getLemma();
            String rawLongString  = aResult.formatLong();

            oneResult.put(rootKey, root);
            oneResult.put(lemmaKey, lemma);
            oneResult.put(rawLongStringKey, rawLongString);

            allResults.add(oneResult);
        }

        return allResults;
    }
}
