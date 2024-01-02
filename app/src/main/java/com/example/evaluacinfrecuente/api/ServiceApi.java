package com.example.evaluacinfrecuente.api;

import com.example.evaluacinfrecuente.entity.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceApi {

    @GET("/products/")
   public abstract Call<List<Product>> listaProductos();

}
