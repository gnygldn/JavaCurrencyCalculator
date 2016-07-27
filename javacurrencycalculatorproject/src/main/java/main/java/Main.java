package main.java;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import static org.apache.http.protocol.HTTP.USER_AGENT;

public class Main {
   /* public static void main(String[] args) throws IOException {
        InputStream is = new URL("http://api.dev.paximum.com/v1/currency/GetExchangeRates?basecurrency=USD&access_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2F1dGgucGF4aW11bS5jb20iLCJhdWQiOiJodHRwczovL2FwaS5wYXhpbXVtLmNvbSIsIm5iZiI6MTQ2ODMxMDQ5MiwiZXhwIjoxNDcyNjg4MDAwLCJzdWIiOiI0MzZiYWYwNy01ZTRmLTQyMDEtYjBlNS01Njk3NzUyZGI3NmUiLCJyb2xlIjoicGF4OmRldmVsb3BlciJ9.jnHkmkXThdVZAwzr38lgqi3ZnnXEM3fpY-XeZsQyfnw").openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JsonDeserializer jsonList = new JsonDeserializer(jsonText);
            Calculation calculation = new Calculation(new ExchangeRateProvider(jsonList.ConvertedList));
            calculation.Calculate("USD", "TRY", 100, 0.1);
        } finally {
            is.close();
        }
    }
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }*/
   public static void main(String[] args) throws IOException {

       String basecurrency = "EUR";
       CloseableHttpClient httpClient = HttpClients.createDefault();
       HttpGet httpGet = new HttpGet("http://api.dev.paximum.com/v1/currency/GetExchangeRates?basecurrency="+basecurrency+"&access_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2F1dGgucGF4aW11bS5jb20iLCJhdWQiOiJodHRwczovL2FwaS5wYXhpbXVtLmNvbSIsIm5iZiI6MTQ2ODMxMDQ5MiwiZXhwIjoxNDcyNjg4MDAwLCJzdWIiOiI0MzZiYWYwNy01ZTRmLTQyMDEtYjBlNS01Njk3NzUyZGI3NmUiLCJyb2xlIjoicGF4OmRldmVsb3BlciJ9.jnHkmkXThdVZAwzr38lgqi3ZnnXEM3fpY-XeZsQyfnw");
       httpGet.addHeader("User-Agent", USER_AGENT);
       httpGet.addHeader("Authorization", "Bearer ");
       httpGet.addHeader("Connection", "Keep-Alive" );
       CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

       /*System.out.println("GET Response Status:: "
               + httpResponse.getStatusLine().getStatusCode());*/

       BufferedReader reader = new BufferedReader(new InputStreamReader(
               httpResponse.getEntity().getContent()));

       String inputLine;
       StringBuffer response = new StringBuffer();

       while ((inputLine = reader.readLine()) != null) {
           response.append(inputLine);
       }



       JsonDeserializer jsonList = new JsonDeserializer(response.toString());

       Calculation calculation = new Calculation(new ExchangeRateProvider(jsonList.ConvertedList));
       calculation.Calculate(basecurrency, "TRY", 100, 0.1);
       System.out.println(calculation.result);
       reader.close();

   }
}