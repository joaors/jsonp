/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jsonp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.json.Json;
import javax.json.stream.JsonGenerator;

/**
 *
 * @author joao.rodrigo
 */
public class WriteStream {

    public static void main(String[] args) throws MalformedURLException, IOException {
        try (JsonGenerator gen = Json.createGenerator(new FileOutputStream("country.json"))) {
            gen.writeStartObject()
                    .write("country", "Brazil")
                    .write("capital", "Brasilia")
                    .write("poulation", 36048521)
                    .writeStartArray("officialLanguages")
                    .writeStartObject()
                    .write("language", "Portuguese")
                    .writeEnd()
                    .writeStartObject()
                    .write("language", "Spanish")
                    .writeEnd()
                    .writeEnd()
                    .writeEnd();
        }
    }

}
