package com.waruna.officetaskmanager.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.waruna.officetaskmanager.R;
import com.waruna.officetaskmanager.ui.task.TaskActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, TaskActivity.class));
    }
}