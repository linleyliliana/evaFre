package com.example.evaluacinfrecuente.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectionRest {
    private static Retrofit retrofit = null;
    private static final String RUTA_API = "https://fakestoreapi.com";

    public static Retrofit getConnection(){
        if(retrofit==null){
        retrofit= new Retrofit.Builder().baseUrl(RUTA_API)
                .addConverterFactory(GsonConverterFactory
                        .create()).build();
        }
        return retrofit;
    }

}
