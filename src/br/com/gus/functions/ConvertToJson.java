package br.com.gus.functions;

import br.com.gus.classes.Address;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ConvertToJson {
    public ConvertToJson(List<Address> ad, String filename) throws IOException {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter writer = new FileWriter(String.format("%s.json",filename));
            writer.write(gson.toJson(ad));
            writer.close();
            System.out.println("Arquivo criado com sucesso!");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
