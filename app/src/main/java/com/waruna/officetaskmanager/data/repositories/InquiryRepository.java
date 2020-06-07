package com.waruna.officetaskmanager.data.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.waruna.officetaskmanager.data.db.Database;
import com.waruna.officetaskmanager.data.db.InquiryDao;
import com.waruna.officetaskmanager.data.db.TaskDao;
import com.waruna.officetaskmanager.data.db.entities.Inquiry;
import com.waruna.officetaskmanager.data.db.entities.Task;

import java.util.List;

public class InquiryRepository {
    private InquiryDao inquiryDao;
    private LiveData<List<Inquiry>> allInquiries;

    public InquiryRepository(Application application){
        Database database = Database.getInstance(application);
        inquiryDao = database.inquiryDao();
        allInquiries = inquiryDao.getAllInquiries();
    }

    public void insert(Inquiry inquiry){
        new InsertInquiryAsyncTask(inquiryDao).execute(inquiry);
    }

    public void update(Inquiry inquiry){
        new UpdateInquiryAsyncTask(inquiryDao).execute(inquiry);
    }

    public void delete(Inquiry inquiry){
        new DeleteInquiryAsyncTask(inquiryDao).execute(inquiry);
    }

    public void deleteAllTasks(){
        new DeleteAllInquiriesAsyncTask(inquiryDao).execute();
    }

    public LiveData<List<Inquiry>> getAllInquiries(){
        return allInquiries;
    }

    private static class InsertInquiryAsyncTask extends AsyncTask<Inquiry,Void,Void>{

        private InquiryDao inquiryDao;

        private InsertInquiryAsyncTask(InquiryDao inquiryDao){
            this.inquiryDao = inquiryDao;
        }

        @Override
        protected Void doInBackground(Inquiry... inquiries) {
            inquiryDao.insert(inquiries[0]);
            return null;
        }
    }

    private static class UpdateInquiryAsyncTask extends AsyncTask<Inquiry,Void,Void>{

        private InquiryDao inquiryDao;

        private UpdateInquiryAsyncTask(InquiryDao inquiryDao){
            this.inquiryDao = inquiryDao;
        }

        @Override
        protected Void doInBackground(Inquiry... inquiries) {
            inquiryDao.update(inquiries[0]);
            return null;
        }
    }

    private static class DeleteInquiryAsyncTask extends AsyncTask<Inquiry,Void,Void>{

        private InquiryDao inquiryDao;

        private DeleteInquiryAsyncTask(InquiryDao inquiryDao){
            this.inquiryDao = inquiryDao;
        }

        @Override
        protected Void doInBackground(Inquiry... inquiries) {
            inquiryDao.delete(inquiries[0]);
            return null;
        }
    }

    private static class DeleteAllInquiriesAsyncTask extends AsyncTask<Void,Void,Void>{

        private InquiryDao inquiryDao;

        private DeleteAllInquiriesAsyncTask(InquiryDao inquiryDao){
            this.inquiryDao = inquiryDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            inquiryDao.deleteAllInquiries();
            return null;
        }
    }

}
