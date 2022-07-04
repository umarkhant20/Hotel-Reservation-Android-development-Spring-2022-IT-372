package it372.u.khan.project3bkhan.db;
// Umar Khan
// IT-372
// Final Project

import androidx.room.Database;
import androidx.room.RoomDatabase;
import it372.u.khan.project3bkhan.dao.DaoAccess;
import it372.u.khan.project3bkhan.model.ModelClass;


@Database(entities = {ModelClass.class}, version = 1, exportSchema = false)
public abstract class RecordDatabase extends RoomDatabase {

    public abstract DaoAccess daoAccess();
}
