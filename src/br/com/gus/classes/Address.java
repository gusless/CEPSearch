package br.com.gus.classes;

public class Address {
    private final String cep;
    private final String city;
    private final String neighborhood;
    private final String state;
    private final String uf;
    private final String region;
    private final String place;
    private final String unity;
    private final String complement;

    public Address(AddressRecord address){
        this.cep = address.cep();
        this.city = address.localidade();
        this.neighborhood = address.bairro();
        this.state = address.estado();
        this.uf = address.uf();
        this.region = address.regiao();
        this.place = address.logradouro(); // streets, boulevards, public square, etc
        this.unity = address.unidade();
        this.complement = address.complemento();
    }

    @Override
    public String toString() {
        String stringAdress = String.format("CEP %s: ", cep);
        if (!place.isEmpty()){
            stringAdress = stringAdress.concat(place);
            if (!unity.isEmpty()){
                stringAdress = stringAdress.concat(String.format("(%s), ",unity));
            } else {
                stringAdress = stringAdress.concat(", ");
            }
        }
        if (!neighborhood.isEmpty()){
            stringAdress = stringAdress.concat(neighborhood+", ");
        }
        if (!complement.isEmpty()){
            stringAdress = stringAdress.concat(complement+", ");
        }

        stringAdress = stringAdress.concat(String.format("%s, %s (%s), %s.",city, state, uf, region));

        return stringAdress;
    }

    public String getCep() {
        return cep;
    }

    public String getCity() {
        return city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getState() {
        return state;
    }

    public String getUf() {
        return uf;
    }

    public String getRegion() {
        return region;
    }

    public String getPlace() {
        return place;
    }

    public String getUnity() {
        return unity;
    }

    public String getComplement() {
        return complement;
    }
}
