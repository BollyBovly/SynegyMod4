package com.example.synegymod4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Animal> animals;

    public AnimalAdapter(Context context, List<Animal> animals) {
        this.inflater = LayoutInflater.from(context);
        this.animals = animals;
    }

    @Override
    public AnimalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(AnimalAdapter.ViewHolder holder, int position) {
        Animal animal = animals.get(position);
        holder.animalView.setImageResource(animal.getAnimalResource());
        holder.nameView.setText(animal.getName());
        holder.animalDescriptionView.setText(animal.getAnimalDiscription());
        holder.populationSizeView.setText(animal.getPopulationSize());
    }


    @Override
    public int getItemCount() {
        return animals.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView animalView;
        final TextView nameView, animalDescriptionView, populationSizeView;

        ViewHolder(View view){
            super(view);
            animalView = view.findViewById(R.id.animalResource);
            nameView = view.findViewById(R.id.name);
            animalDescriptionView = view.findViewById(R.id.animalDescription);
            populationSizeView = view.findViewById(R.id.populationSize);
        }
    }
}
