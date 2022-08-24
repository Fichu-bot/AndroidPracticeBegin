package com.example.webview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalRowHolder>{

    ArrayList<Animal> animalData;
    Context context;
    MyClickInterface myClickInterface;

    public AnimalAdapter(ArrayList<Animal> animalData, Context context,MyClickInterface myClickInterface) {
        this.context = context;
        this.animalData = animalData;
        this.myClickInterface = myClickInterface;
    }

    @NonNull
    @Override
    public AnimalRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.animal_row,parent,false); //View displaying animal row

        return new AnimalRowHolder(view); //extract textview and imgview and initialises them
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalRowHolder holder, int position) { //hold data created onCreateViewHolder - scrolling content
        //binds data to
        holder.txtAnimalName.setText(animalData.get(position).getName());
        holder.imgAnimal.setImageResource(animalData.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return animalData.size(); //size of the array list
    }

    class AnimalRowHolder extends RecyclerView.ViewHolder {

        TextView txtAnimalName;
        ImageView imgAnimal;
        public AnimalRowHolder(@NonNull View itemView) {
            super(itemView);
            txtAnimalName = itemView.findViewById(R.id.txtAnimalName); //look for textview inside item view therefore need to specify
            imgAnimal = itemView.findViewById(R.id.img_animal);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myClickInterface.onItemClick(getAdapterPosition());
                }
            });
        }

    }
    interface MyClickInterface {
        void onItemClick(int positionOfTheAnimal);
    }
}
