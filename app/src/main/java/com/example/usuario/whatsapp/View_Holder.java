package com.example.usuario.whatsapp;

import android.content.Intent;
//import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class View_Holder extends RecyclerView.ViewHolder {
    //CardView cv;
    TextView contacto;
    public TextView botonMenu;
    View_Holder(final View itemView){
        super(itemView);
        //cv = (CardView) itemView.findViewById(R.id.itemCategoria);
        contacto = (TextView)itemView.findViewById(R.id.categoria);
        botonMenu = (TextView) itemView.findViewById(R.id.textViewOptions);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(itemView.getContext(),Mensaje.class);
                i.putExtra("nom", contacto.getText().toString());
                i.putExtra("id",contacto.getTag().toString());
                itemView.getContext().startActivity(i);
            }
        });
    }

}
