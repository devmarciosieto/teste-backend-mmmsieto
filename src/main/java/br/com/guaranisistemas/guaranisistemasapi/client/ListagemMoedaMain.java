package br.com.guaranisistemas.guaranisistemasapi.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

public class ListagemMoedaMain {

    public static void main(String[] args) {

        Gson gson = new Gson();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        try{
            URL url = new URL("https://economia.awesomeapi.com.br/json/usd");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() != 200) {
                System.out.print("deu erro... HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output,json="";
            while ((output = br.readLine()) != null) {
                json+= output;
            }
            System.out.println(json);
            conn.disconnect();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
