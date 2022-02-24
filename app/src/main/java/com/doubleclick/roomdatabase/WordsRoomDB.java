package com.doubleclick.roomdatabase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;


@Database(entities = Words.class,version = 1) // for more than one of table => @Database(entities = {Words.class , ......,.....},version = 1)
public abstract class WordsRoomDB extends RoomDatabase  {

    private static WordsRoomDB instance;

    public abstract wordsDAO wordsDAO();

    //Singlton
     public static synchronized WordsRoomDB getInstance(Context context){
         if (instance == null){
             instance = Room.databaseBuilder(context.getApplicationContext(),
             WordsRoomDB.class,"word-database")
//                     .fallbackToDestructiveMigration()
//                     .addCallback(roomCallBack)
                     .build();
         }
         return instance;
     }

//     private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
//
//         @Override
//         public void onCreate(SupportSQLiteDatabase db) {
//             super.onCreate(db);
//             new pupulatDataAsyncTask(instance).execute();
//         }
//
//         @Override
//         public void onOpen( SupportSQLiteDatabase db) {
//             super.onOpen(db);
//         }
//
//     };
//
//
//    private static class pupulatDataAsyncTask extends AsyncTask<Void,Void,Void>{
//
//         private wordsDAO mwordsDAO;
//
//         pupulatDataAsyncTask(WordsRoomDB db){
//             mwordsDAO = db.wordsDAO();
//         }
//
//         @Override
//         protected Void doInBackground(Void... voids) {
//             mwordsDAO.insert(new Words("Book","Book","noun"));
//             mwordsDAO.insert(new Words("Book","Book","noun"));
//             mwordsDAO.insert(new Words("Book","Book","noun"));
//
//             return null;
//         }
//     }

}
