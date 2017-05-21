package com.saidozcan.kiraz;

/**
 * Created by mozcan on 21/05/2017.
 */
public class Response {
    String responseJson;

    public String getResponseJson() {
        return responseJson;
    }

    public void setResponseJson(String responseJson) {
        this.responseJson = responseJson;
    }

    public Response(String responseJson) {
        this.responseJson = responseJson;
    }

    public Response() {

    }
}
