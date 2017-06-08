package com.saidozcan.kiraz.Main;

import com.saidozcan.kiraz.Models.Request;
import com.saidozcan.kiraz.Models.Response;
import com.saidozcan.kiraz.RequestProcessing.RequestDispatcher;

import java.io.IOException;

public class App {
    public static void main( String[] args ) throws IOException {
        String mode = "word";
        String query = "gittik.";

        Request request = new Request(mode, query);
        RequestDispatcher requestDispatcher = new RequestDispatcher(request);
        Response response = requestDispatcher.dispatch();

        System.out.println("INPUT Mode:"+mode);
        System.out.println("INPUT Query:"+query);

        System.out.println("OUTPUT Result:"+response.results);
        System.out.println("OUTPUT Message:"+response.message);
        System.out.println("OUTPUT Status:"+response.status);
    }
}
