package com.saidozcan.kiraz.Models;

import java.util.HashMap;
import java.util.List;

/**
 * Created by mozcan on 21/05/2017.
 */
public class Response {
    public String status;
    public String message;
    public HashMap<String, String> results;


    public Response(String validationErrorMessage) {
        this.results = null;
        this.status = "failed";
        this.message = validationErrorMessage;
    }

    public Response(HashMap<String, String> results) {
        this.results = results;
        this.status = "succeeded";
        this.message = null;
    }

    public Response() {

    }
}
