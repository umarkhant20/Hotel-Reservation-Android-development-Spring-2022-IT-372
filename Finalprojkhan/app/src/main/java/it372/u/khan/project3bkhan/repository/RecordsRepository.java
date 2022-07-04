package it372.u.khan.project3bkhan.repository;
// Umar Khan
// IT-372
// Final Project

import android.content.Context;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.room.Room;
import it372.u.khan.project3bkhan.db.RecordDatabase;
import it372.u.khan.project3bkhan.model.ModelClass;
import java.util.List;

public class RecordsRepository {

  private String DB_NAME = "db_task";

  private RecordDatabase noteDatabase;

  public RecordsRepository(Context context) {
    noteDatabase = Room.databaseBuilder(context, RecordDatabase.class, DB_NAME).build();
  }

  public void insertRecord(String name, String age, String phone, String date, String guests,
                         String status, String room,
                         String total) {

    ModelClass record = new ModelClass(name, age, phone, date, guests, status, room, total);
    insertRecord(record);
  }

  public void insertRecord(final ModelClass record) {
    new AsyncTask<Void, Void, Void>() {
      @Override
      protected Void doInBackground(Void... voids) {
        noteDatabase.daoAccess().insertRecord(record);
        return null;
      }
    }.execute();
  }

  public void updateRecord(final ModelClass record) {

    new AsyncTask<Void, Void, Void>() {
      @Override
      protected Void doInBackground(Void... voids) {
        noteDatabase.daoAccess().updateRecord(record);
        return null;
      }
    }.execute();
  }

  public void deleteRecord(final String name) {
    final LiveData<ModelClass> Record = getRecord(name);
    if (Record != null) {
      new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... voids) {
          noteDatabase.daoAccess().deleteRecord(Record.getValue());
          return null;
        }
      }.execute();
    }
  }

  public void deleteRecord(final ModelClass record) {
    new AsyncTask<Void, Void, Void>() {
      @Override
      protected Void doInBackground(Void... voids) {
        noteDatabase.daoAccess().deleteRecord(record);
        return null;
      }
    }.execute();
  }

  public LiveData<ModelClass> getRecord(String name) {
    return noteDatabase.daoAccess().getRecord(name);
  }

  public LiveData<List<ModelClass>> getRecords() {
    return noteDatabase.daoAccess().fetchAllRecords();
  }
}
