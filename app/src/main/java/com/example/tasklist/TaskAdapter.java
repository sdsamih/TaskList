package com.example.tasklist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {


    private ArrayList<Task> list;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;


    public interface OnItemClickListener {
        void onItemClick(Task task);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(Task task);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        this.onItemLongClickListener = listener;
    }



    public TaskAdapter(ArrayList<Task> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_card, parent, false);
        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task currentTask = list.get(position);
        holder.txtTitleTask.setText(currentTask.getname());

        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(currentTask);
            }
        });

        holder.itemView.setOnLongClickListener(v -> {
            if (onItemLongClickListener != null) {
                onItemLongClickListener.onItemLongClick(currentTask);
            }
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTitleTask;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitleTask = itemView.findViewById(R.id.txt_task_name);
        }
    }
}
