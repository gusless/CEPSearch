package br.com.gus.functions;

import br.com.gus.classes.Address;
import br.com.gus.classes.AddressRecord;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConvertFromJson {
    private final Address address;

    public ConvertFromJson(String json){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        AddressRecord addressRecord = gson.fromJson(json, AddressRecord.class);
        this.address = new Address(addressRecord);
    }

    public Address getAddress() {
        return address;
    }
}
