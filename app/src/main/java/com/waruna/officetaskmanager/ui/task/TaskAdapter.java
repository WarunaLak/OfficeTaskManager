package com.waruna.officetaskmanager.ui.task;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.waruna.officetaskmanager.R;
import com.waruna.officetaskmanager.data.db.entities.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {

    private List<Task> tasks = new ArrayList<>();

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new TaskHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
        Task currentTask = tasks.get(position);
        holder.tvTaskInfo.setText(currentTask.getTaskDetails());
        if (currentTask.getStatus() == 1) {
            holder.tvStatus.setText("Done");
        } else {
            holder.tvStatus.setText("Pending");
        }
        holder.pbProgress.setProgress(currentTask.getProgress());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void setTasks(List<Task> tasks){
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    class TaskHolder extends RecyclerView.ViewHolder{

        private TextView tvTaskInfo, tvStatus;
        private ProgressBar pbProgress;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);
            tvTaskInfo = itemView.findViewById(R.id.tv_task_info);
            tvStatus = itemView.findViewById(R.id.tv_status);
            pbProgress = itemView.findViewById(R.id.pb_progress);
        }

    }

}
