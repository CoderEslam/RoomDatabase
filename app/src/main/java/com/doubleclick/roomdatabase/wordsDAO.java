package com.doubleclick.roomdatabase;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao //DataAccessObject
public interface wordsDAO {

    @Insert
    void insert(Words words);

    @Update
    void update(Words words);

    @Delete
    void delete(Words words);

    @Query("DELETE FROM Words") // to delete all data in table
    void deleteAllData();

    @Query("SELECT * FROM Words")
    //to observ all data as change
    LiveData<List<Words>> getAllWord();




}
