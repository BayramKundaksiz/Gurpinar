package com.GurpinarHaber;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class NostaljiAdapter extends RecyclerView.Adapter<NostaljiAdapter.ImageViewHolder> {

    List<NostaljiConstructor> nostaljiConstructors;
    ViewPager2 viewPager2;

    public NostaljiAdapter(List<NostaljiConstructor> nostaljiConstructors, ViewPager2 viewPager2){
        this.nostaljiConstructors = nostaljiConstructors;
        this.viewPager2 = viewPager2;

    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_container, parent, false);

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.kisinin_ismi.setText(nostaljiConstructors.get(position).getKisinin_ismi());
        holder.fotografin_aciklamasi.setText(nostaljiConstructors.get(position).getFotografin_aciklamasi());
        holder.fotografin_tarihi.setText(nostaljiConstructors.get(position).getFotografin_tarihi());




        Glide.with(holder.kisinin_ismi.getContext()).load("http://gilaburu.site/Gurpinar/nostalji/"
                +nostaljiConstructors.get(position).getFotograf()).into(holder.photoView);

        if (position == nostaljiConstructors.size() -2 ){
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {

        return null!=nostaljiConstructors?nostaljiConstructors.size():0;

    }

    class ImageViewHolder extends RecyclerView.ViewHolder{

        RoundedImageView imageViewRounded;
        TextView kisinin_ismi, fotografin_aciklamasi, fotografin_tarihi;
        PhotoView photoView;


        @SuppressLint("WrongViewCast")
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewRounded = itemView.findViewById(R.id.imageViewRounded);
            kisinin_ismi = itemView.findViewById(R.id.kisinin_ismi);
            fotografin_aciklamasi = itemView.findViewById(R.id.fotografin_aciklamasi);
            fotografin_tarihi = itemView.findViewById(R.id.fotografin_tarihi);

            photoView = itemView.findViewById(R.id.photoView);

        }
    }

        private Runnable runnable = new Runnable() {
            @Override
            public void run() {
                nostaljiConstructors.addAll(nostaljiConstructors);
                notifyDataSetChanged();
            }
        };
}
