package it372.u.khan.project3bkhan.dao;
// Umar Khan
// IT-372
// Final Project

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import it372.u.khan.project3bkhan.model.ModelClass;
import java.util.List;

@Dao
public interface DaoAccess {

    @Insert
    Long insertRecord(ModelClass note);


    @Query("SELECT * FROM ModelClass")
    LiveData<List<ModelClass>> fetchAllRecords();


    @Query("SELECT * FROM ModelClass WHERE name =:name")
    LiveData<ModelClass> getRecord(String name);


    @Update
    void updateRecord(ModelClass note);


    @Delete
    void deleteRecord(ModelClass note);
}
