package com.GurpinarHaber;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BildirimlerAlimSatimAdapter extends RecyclerView.Adapter<BildirimlerAlimSatimAdapter.myviewholder>
{

    List<BildirimlerAlimSatimConstructor> bildirimlerAlimSatimConstructors;

    private final IBildirimlerAlimSatimInterface iBildirimlerAlimSatimInterface;

    Context context;

    public BildirimlerAlimSatimAdapter(List<BildirimlerAlimSatimConstructor> bildirimlerAlimSatimConstructors,
                                       IBildirimlerAlimSatimInterface iBildirimlerAlimSatimInterface,
                                       Context context) {
        this.bildirimlerAlimSatimConstructors = bildirimlerAlimSatimConstructors;
        this.iBildirimlerAlimSatimInterface = iBildirimlerAlimSatimInterface;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alimsatim,parent,false);
        return new myviewholder(view,iBildirimlerAlimSatimInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.t1.setText(bildirimlerAlimSatimConstructors.get(position).getUrunadi());
        holder.t2.setText(bildirimlerAlimSatimConstructors.get(position).getUrundetaylari());
        Glide.with(holder.t1.getContext()).load("http://gilaburu.site/Gurpinar/bildirimler/alimsatim/" +bildirimlerAlimSatimConstructors.get(position).getUrunfotografi()).into(holder.img);

    }

    @Override
    public int getItemCount() {

        return null!=bildirimlerAlimSatimConstructors?bildirimlerAlimSatimConstructors.size():0;

    }

    class myviewholder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView t1,t2;

        public myviewholder(@NonNull View itemView, IBildirimlerAlimSatimInterface iBildirimlerAlimSatimInterface) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (iBildirimlerAlimSatimInterface != null){

                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION);
                        iBildirimlerAlimSatimInterface.onItemClick(position);
                        Intent intent = new Intent(context,BildirimlerAlimSatimDetaylari.class);

                        intent.putExtra("alimsatimadi",bildirimlerAlimSatimConstructors.get(position).getUrunadi());
                        intent.putExtra("alimsatimbilgisi",bildirimlerAlimSatimConstructors.get(position).getUrundetaylari());
                        intent.putExtra("alimsatimfotografi",bildirimlerAlimSatimConstructors.get(position).getUrunfotografi());

                        context.startActivity(intent);
                    }
                }
            });

        }
    }
}