package com.waruna.officetaskmanager.data.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

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
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private TaskDao taskDao;
        private InquiryDao inquiryDao;

        public PopulateDbAsyncTask(Database database) {
            taskDao = database.taskDao();
            inquiryDao = database.inquiryDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            taskDao.insert(new Task(1,100,20,1,"First task","2020/01/02","2020/01/05"));
            taskDao.insert(new Task(2,100,20,1,"Second task","2020/01/02","2020/01/05"));
            taskDao.insert(new Task(3,100,20,1,"Third task","2020/01/02","2020/01/05"));
            taskDao.insert(new Task(4,100,20,1,"Fourth task","2020/01/02","2020/01/05"));

            inquiryDao.insert(new Inquiry(1, 100,1,"Ixxxx 1","2020/02/05"));
            inquiryDao.insert(new Inquiry(2, 100,1,"Ixxxx 2","2020/02/05"));
            inquiryDao.insert(new Inquiry(3, 100,1,"Ixxxx 3","2020/02/05"));
            inquiryDao.insert(new Inquiry(4, 100,1,"Ixxxx 4","2020/02/05"));
            return null;
        }
    }
}
