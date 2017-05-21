package com.saidozcan.kiraz;

/**
 * Created by mozcan on 21/05/2017.
 */
public class Request {
    String queryWord;

    public String getQueryWord() {
        return queryWord;
    }

    public void setQueryWord(String queryWord) {
        this.queryWord = queryWord;
    }

    public Request(String queryWord) {
        this.queryWord = queryWord;
    }

    public Request() {

    }
}
