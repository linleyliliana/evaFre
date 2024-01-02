package com.example.evaluacinfrecuente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.evaluacinfrecuente.adapter.ProductAdapter;
import com.example.evaluacinfrecuente.api.ServiceApi;
import com.example.evaluacinfrecuente.entity.Product;
import com.example.evaluacinfrecuente.util.ConnectionRest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Product> productos = new ArrayList<Product>();
    ListView lstPro = null;
    ProductAdapter adaptador = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    adaptador=new ProductAdapter(this, android.R.layout.activity_list_item,productos);
        lstPro=(ListView) findViewById(R.id.lstProductos);
        lstPro.setAdapter(adaptador);

        cargaProductos();
    }

    void cargaProductos(){
        ServiceApi api = ConnectionRest.getConnection()
                .create(ServiceApi.class);
        Call<List<Product>> call = api.listaProductos();
        call.enqueue(new Callback<List<Product>>() {
            @Override

            //Cuando todo sale bien al conectarse a la API
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> data = response.body();
                productos.addAll(data);
                adaptador.notifyDataSetChanged();
            }
            //Cuando hay error al conectarse a la API
            @Override
            public void onFailure(Call<List<Product>> call, Throwable t)  {}
        });
    }
}