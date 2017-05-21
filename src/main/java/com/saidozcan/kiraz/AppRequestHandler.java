package com.saidozcan.kiraz;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;
import zemberek.morphology.analysis.tr.TurkishMorphology;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mozcan on 21/05/2017.
 */

public class AppRequestHandler implements RequestHandler<Request, Response> {

    public Response handleRequest(Request request, Context context) {
        TurkishMorphology morphology = null;
        try {
            morphology = TurkishMorphology.createWithDefaults();
        } catch (IOException e) {
            return new Response(e.toString());
        }

        StemFinder stemFinder = new StemFinder(morphology);
        List<HashMap<String, String>> list = stemFinder.analyze(request.queryWord);

        JSONEncoder encoder = new JSONEncoder();
        String jsonString = encoder.encodeJsonFromList(list);
        return new Response(jsonString);
    }
}