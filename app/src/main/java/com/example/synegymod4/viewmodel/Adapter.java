package com.example.synegymod4.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.synegymod4.R;
import com.example.synegymod4.model.Notebook;
import com.example.synegymod4.view.SecnodActivity;
import com.example.synegymod4.view.UpdateActivity;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private Activity activity;
    private List<Notebook> notesList;
    private List<Notebook> newList;

    public Adapter(Context context, Activity activity, List<Notebook> notesList) {
        this.context = context;
        this.activity = activity;
        this.notesList = notesList;
        newList = new ArrayList<>(notesList);
    }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_recycler_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(notesList.get(position).getTitle());
        holder.description.setText(notesList.get(position).getDescription());

        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);

                intent.putExtra("title",notesList.get(position).getTitle());
                intent.putExtra("description",notesList.get(position).getDescription());
                intent.putExtra("id",notesList.get(position).getId());

                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,description;
        ConstraintLayout mLayout;

        ViewHolder(@NonNull View view) {
            super(view);
            title = view.findViewById(R.id.title);
            description = view.findViewById(R.id.description);
            mLayout = view.findViewById(R.id.mLayout);

        }
    }
}
