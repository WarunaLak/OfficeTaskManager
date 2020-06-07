package com.waruna.officetaskmanager.data.db;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.waruna.officetaskmanager.data.db.entities.Inquiry;
import com.waruna.officetaskmanager.data.db.entities.Task;

@androidx.room.Database(
        entities = {Task.class, Inquiry.class},
        version = 1
)
public abstract class Database extends RoomDatabase {

    private static Database instance;

    public abstract TaskDao taskDao();

    public abstract InquiryDao inquiryDao();

    public static synchronized Database getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    Database.class, "manager_db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
