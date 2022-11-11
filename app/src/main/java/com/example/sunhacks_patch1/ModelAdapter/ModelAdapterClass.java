package com.example.sunhacks_patch1.ModelAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sunhacks_patch1.ExploreActivity;
import com.example.sunhacks_patch1.ModelClass;
import com.example.sunhacks_patch1.R;

import java.util.List;

public class ModelAdapterClass extends RecyclerView.Adapter<MyViewHolder> {

    List<ModelClass> list;
    Context context;
    public ModelAdapterClass(List<ModelClass> list, Context context)
    {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.model_single_list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ModelClass item = list.get(position);
        String title = item.getTitle();
        String name  = item.getName();
        String about = item.getAbout();
        double Latitude = item.getLatitude();
        double longitude = item.getLongitude();

        Glide.with(context).load(item.getImageUrl()).into(holder.background);
        holder.title.setText(title);
        holder.about.setText(about);

        holder.readmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(context, ExploreActivity.class);
                intent.putExtra("ModelObject",list.get(holder.getAdapterPosition()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    TextView title,about,latitude,longitude;
    ImageView background;
    Button readmore;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.title);
        about = itemView.findViewById(R.id.about);
        background = itemView.findViewById(R.id.imageView);
        readmore = itemView.findViewById(R.id.ReadMore);
    }
}
