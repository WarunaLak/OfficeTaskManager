package com.waruna.officetaskmanager.ui.task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.waruna.officetaskmanager.R;
import com.waruna.officetaskmanager.data.db.entities.Task;

import java.util.List;

public class TaskActivity extends AppCompatActivity {

    private TaskViewModel taskViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        taskViewModel = ViewModelProviders.of(this).get(TaskViewModel.class);
        taskViewModel.getAllTasks().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {
                // update recycler view
                Toast.makeText(TaskActivity.this, "onChange", Toast.LENGTH_SHORT).show();
            }
        });
    }
}