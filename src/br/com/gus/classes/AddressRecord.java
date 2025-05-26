package br.com.gus.classes;

public record AddressRecord(String cep, String logradouro, String complemento, String unidade,
                            String bairro, String localidade, String estado, String uf, String regiao) {
}
