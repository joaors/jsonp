/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jsonp;

import java.io.File;
import java.io.FileReader;
import java.util.stream.Collectors;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author joao.rodrigo
 */
public class ReadObject {
    
    public static void main(String[] args) {
        
        try {
            File file = new File("country.json");
            // creates the file
            file.createNewFile();        
            JsonReader jsonReader =
                Json.createReader(new FileReader(file));
            JsonObject country = jsonReader.readObject();

            System.out.println("Country: " + country.getString("country", "empty!"));

            int population = country.getInt("population", 0);
            if (population > 0 ) {
                System.out.println("Population: " + population);
            }

            JsonArray langs = country.getJsonArray("officialLanguages");                        
            String offLangs = langs.getValuesAs(JsonObject.class)
                                .stream()
                                .map(lang -> lang.getString("language",""))
                                .collect(Collectors.joining(", "));
            System.out.println("Official languages: " + offLangs);
        } catch (Exception e) {
            e.printStackTrace();
        }

                
    }
    
}
