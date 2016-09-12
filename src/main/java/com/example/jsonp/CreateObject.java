/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jsonp;

import java.io.IOException;
import java.net.MalformedURLException;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author joao.rodrigo
 */
public class CreateObject {
    
    
    public static void main(String[] args) throws MalformedURLException, IOException {
        // 1) get a JSON object builder
        JsonObject country = Json.createObjectBuilder()
                                    .add("country", "Brazil")
                                    .add("population", 20000000)
                                    .add("officialLanguages", 
                                            Json.createArrayBuilder()
                                                .add(Json.createObjectBuilder()
                                                        .add("language", "Portuguese")
                                                    )
                                                .add(Json.createObjectBuilder()
                                                        .add("language", "Spanish")
                                                    )
                                        )
                                    .build();
        String c = country.getString("country", "Not found!!");
        System.out.println(c);        
        System.out.print(country.toString());
        
    }
    
}
