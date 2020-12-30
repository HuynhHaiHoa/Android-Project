package com.example.androidnotes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;


public class AndroidNotesAdapter extends RecyclerView.Adapter<AndroidNotesAdapter.ViewHolder> {
    Context context;
    int resource;
    ArrayList<Notes> nodeArrayList;
    public AndroidNotesAdapter(Context context, int resource, ArrayList<Notes> nodeArrayList){
        this.context=context;
        this.resource=resource;
        this.nodeArrayList=nodeArrayList;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, content, date;
        LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
            date = itemView.findViewById(R.id.date);
            layout = itemView.findViewById(R.id.Layout);

        }
    }
    @NonNull
    @Override
    public AndroidNotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AndroidNotesAdapter.ViewHolder holder, int i) {
        Notes note = nodeArrayList.get(i);
        holder.title.setText(note.getTitle());
        holder.content.setText(note.getContent());
        holder.date.setText(note.getDate());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("title", holder.title.getText());
                intent.putExtra("content", holder.content.getText());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return nodeArrayList.size();
    }

}
