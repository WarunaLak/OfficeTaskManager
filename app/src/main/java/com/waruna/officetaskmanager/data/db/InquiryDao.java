package com.waruna.officetaskmanager.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.waruna.officetaskmanager.data.db.entities.Inquiry;

import java.util.List;

public interface InquiryDao {

    @Insert
    void insert(Inquiry inquiry);

    @Update
    void update(Inquiry inquiry);

    @Delete
    void delete(Inquiry inquiry);

    @Query("DELETE FROM inquiry")
    void deleteAllInquiries();

    @Query("SELECT * FROM inquiry ORDER BY date DESC")
    LiveData<List<Inquiry>> getAllInquiries();

}
