package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Conection conection = new Conection();
        Datum datum = new Datum();
        Conection.URL = "https://api.coinlore.net/api/tickers/?start=200&limit=5";
        conection.run();

        String JsonStr = conection.jsonIn;
        Database databaseList = new Database();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        ArrayList<JSON_DATA> datalist = objectMapper.reader()
                .forType(new TypeReference<ArrayList<JSON_DATA>>() {
                })
                .readValue(JsonStr);
        for(JSON_DATA json_data : datalist){
            databaseList.add(json_data);
        }
        System.out.println(databaseList);
    }
}
