package br.com.gus.functions;

import br.com.gus.classes.Address;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchAddress {
    private Address address;
    private final List<Address> addressList = new ArrayList<>();


    public void search(String cep){
        try {
            ApiConnect apiConnect = new ApiConnect(cep);
            String json = apiConnect.getResponse().body();

            if (json.startsWith("erro", 5)) {
                System.err.println("Não há nenhum endereço associado a este CEP");
            } else {
                var jsonConv = new ConvertFromJson(apiConnect.getResponse().body());
                Address adrss = jsonConv.getAddress();
                System.out.println(adrss);
                this.address = adrss;
                this.addressList.add(adrss);
            }
        } catch (JsonSyntaxException | IOException | InterruptedException e) {
            System.err.println("CEP inválido, digite novamente outro CEP");
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public Address getAddress() {
        return address;
    }

    public List<Address> getAddressList() {
        return addressList;
    }
}
