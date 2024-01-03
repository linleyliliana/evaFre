package com.example.evaluacinfrecuente.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.contentcapture.ContentCaptureCondition;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.evaluacinfrecuente.R;
import com.example.evaluacinfrecuente.entity.Product;
import com.example.evaluacinfrecuente.util.ConnectionRest;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    private Context context;
    private List<Product> products;
    public ProductAdapter(@NonNull Context context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
        this.context = context;
        this.products= objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.activity_list_item,parent,false);

        TextView txtID = (TextView) row.findViewById(R.id.txtListID);
        TextView txtTitle = (TextView) row.findViewById(R.id.txtListTitle);
        TextView txtPrice = (TextView) row.findViewById(R.id.txtPrice);
        TextView txtDescrip = (TextView) row.findViewById(R.id.txtListDescription);
        TextView txtCate = (TextView) row.findViewById(R.id.txtListCategory);
        //TextView txtImg = (TextView) row.findViewById(R.id.txtListImage);
        ImageView imgView = row.findViewById(R.id.imgProduct);
        TextView txtRat = (TextView) row.findViewById(R.id.txtListRating);

        txtID.setText(("ID: " + products.get(position).getId()));
        txtTitle.setText(("TITLE: " + products.get(position).getTitle()));
        txtPrice.setText(("PRICE: " + products.get(position).getPrice()));
        txtDescrip.setText(("DESCRIPTION: " + products.get(position).getDescription()));
        txtCate.setText(("CATEGORY: " + products.get(position).getCategory()));
        // txtImg.setText(("IMAGE: " + products.get(position).getImage()));
        txtRat.setText(("RATING: " + products.get(position).getRating()));

        Picasso.get().load(products.get(position).getImage()).into(imgView);

        return row;
    }
}
