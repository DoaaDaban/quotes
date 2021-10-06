///*
// * This Java source file was generated by the Gradle 'init' task.
// */
//
///*
// * This Java source file was generated by the Gradle 'init' task.
// */
//package quotes;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//
//import java.util.List;
//
//public class App {
//    public String getGreeting() {
//        return "Hello World!";
//    }
//
//    public static void main(String[] args) throws IOException {
//        System.out.println(new App().getGreeting());
//
//
//        Gson gson = new Gson();
//
//        BufferedReader reader = new BufferedReader(new FileReader("app/src/recentquotes.json"));
//        List<Quote> quote = gson.fromJson(reader, new TypeToken<List<Quote>>() {}.getType());
//        int min = 0;
//        int max = quote.size()-1 ;
//        System.out.println(quote.get((int) (Math.random()*(max- min+1)+ min)).toString());
//    }
//}

package quotes;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;


import java.io.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws IOException {

        System.out.println(new App().getGreeting());


        Gson gson = new Gson();

        BufferedReader reader = new BufferedReader(new FileReader("app/src/recentquotes.json"));
        List<Quote> quote = gson.fromJson(reader, new TypeToken<List<Quote>>() {}.getType());
        int min = 0;
        int max = quote.size()-1 ;
        System.out.println(quote.get((int) (Math.random()*(max- min+1)+ min)).toString());

//=====================================================lab9=============================================
        try{
            URL url = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


            QuoteAPI qutApi = gson.fromJson(bufferedReader,QuoteAPI.class);
            Quote quotLocal = new Quote(null, qutApi.getAuthor(), null,qutApi.getQuote());
            quote.add(quotLocal);
            gson = gson.newBuilder().setPrettyPrinting().create();


            System.out.println("Quote from API: "+quotLocal);


            bufferedReader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter("app/src/NewRecentquotes.json"));
            gson.toJson(qutApi, writer);
            writer.close();

        }catch (Exception e){
            System.out.println(quote.get((int) (Math.random()*(max- min+1)+ min)).toString());
        }

    }

}
