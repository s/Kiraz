package com.saidozcan.kiraz.Main;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.saidozcan.kiraz.Models.Request;
import com.saidozcan.kiraz.Models.Response;
import com.saidozcan.kiraz.RequestProcessing.RequestDispatcher;

/**
 * Created by mozcan on 21/05/2017.
 */

public class AppRequestHandler implements RequestHandler<Request, Response>
{
    public Response handleRequest(Request request, Context context)
    {
        RequestDispatcher requestDispatcher = new RequestDispatcher(request);
        return requestDispatcher.dispatch();
    }
}