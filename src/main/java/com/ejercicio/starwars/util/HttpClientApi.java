package com.ejercicio.starwars.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class HttpClientApi {
    /**
     * Método que crea un cliente para conectar con el api
     * @param urlInicial
     * @return
     */
    public static JsonArray getDataApi(String urlInicial) {
        JsonObject jsonObject = new JsonObject();
        JsonArray results = null;
        try {
            //Creamos un cliente http
            HttpClient client = HttpClientBuilder.create().build();
            //Nos creamos una request con la url
            HttpGet request = new HttpGet(urlInicial);
            // Ejecutar petición HTTP
            HttpResponse resultadoHttp = client.execute(request);
            //Convertimos el string a json
            JsonParser parser = new JsonParser();
            jsonObject = parser.parse(new InputStreamReader(resultadoHttp.getEntity().getContent(), "UTF-8")).getAsJsonObject();
            results = jsonObject.getAsJsonArray("results");
            //Cerramos el cliente
            ((CloseableHttpClient) client).close();

            //Creamos otro cliente porque, cuando hay más registros páginados tenemos que volver a llamar a la api para
            //recuperar la siguiente página
            while (results.size() < jsonObject.get("count").getAsLong()) {
                HttpClient clientAux = HttpClientBuilder.create().build();
                String url = jsonObject.get("next").getAsString();
                jsonObject = parser.parse(new InputStreamReader(clientAux.execute(new HttpGet(url)).getEntity().getContent(), "UTF-8")).getAsJsonObject();
                results.addAll(jsonObject.getAsJsonArray("results"));
                ((CloseableHttpClient) clientAux).close();
            }
            System.out.println("Url: " +  urlInicial + " Total resultados: " + results.size());
        } catch (IOException io) {
            System.err.println(io.getMessage());
        }
        return results;
    }
}
