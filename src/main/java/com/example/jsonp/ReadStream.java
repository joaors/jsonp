/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jsonp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.json.Json;
import javax.json.stream.JsonParser;

/**
 *
 * @author joao.rodrigo
 */
public class ReadStream {
    
    
    public static void main(String[] args) throws IOException {
        
        try (InputStream is = new FileInputStream("country.json");
                JsonParser parser = Json.createParser(is)) {
            while (parser.hasNext()) {
                JsonParser.Event e = parser.next();
                if (e == JsonParser.Event.KEY_NAME) {
                    System.out.println(parser.getString());
                    JsonParser.Event t = parser.next();
                    if (t != JsonParser.Event.START_ARRAY) {
                        System.out.println(parser.getString());
                    }
                }
            }
        }        
        
    }
}
