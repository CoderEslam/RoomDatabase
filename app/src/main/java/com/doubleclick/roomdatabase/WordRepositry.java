package com.doubleclick.roomdatabase;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepositry {

    private wordsDAO mWordsDAO;
    private LiveData<List<Words>> getAllWords;
    private Context context;

    public WordRepositry(Application app) {
        context = app;
        WordsRoomDB db = WordsRoomDB.getInstance(app);
        mWordsDAO = db.wordsDAO();
        getAllWords = mWordsDAO.getAllWord();
    }
    //operation


    //insert
    public void insert(Words word) {

        new InsertAsyncTask(mWordsDAO).execute(word);

        Toast.makeText(context.getApplicationContext(),"Word Repository =insert,  32 ,"+word.getWordName()+"\n "+
                        word.getWordMeaning()
                        +"\n"+word.getWordType()
                ,Toast.LENGTH_LONG).show();
    }

    //delete
    public void delete(Words word) {
        new DeleteAsyncTask(mWordsDAO).execute(word);
        Toast.makeText(context.getApplicationContext(),"Word Repository = 41 ,"+word.getWordName()+"\n "+
                        word.getWordMeaning()
                        +"\n"+word.getWordType()
                ,Toast.LENGTH_LONG).show();
    }

    //update
    public void update(Words word) { //done

        new UpdatetAsyncTask(mWordsDAO).execute(word);

        Toast.makeText(context.getApplicationContext(),"Word Repository = update 52 ,"+word.getWordName()+"\n "+
                        word.getWordMeaning()
                        +"\n"+word.getWordType()
                ,Toast.LENGTH_LONG).show();
    }

    //getAllWords
    public LiveData<List<Words>> getAllWords() {

        return getAllWords;
    }

    //deleteAllWords
    public void deleteAllWords() {

        new DeleteAllAsyncTask(mWordsDAO).execute();

    }

    private static class InsertAsyncTask extends AsyncTask<Words, Void, Void> {

        private wordsDAO mWordsDAO;

        public InsertAsyncTask(wordsDAO wordsDAO) {
            mWordsDAO = wordsDAO;
        }

        @Override
        protected Void doInBackground(Words... words) {
            mWordsDAO.insert(words[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<Words, Void, Void> {

        private wordsDAO mWordsDAO;

        public DeleteAsyncTask(wordsDAO wordsDAO) {
            mWordsDAO = wordsDAO;
        }

        @Override
        protected Void doInBackground(Words... words) {
            mWordsDAO.delete(words[0]);
            return null;
        }
    }

    private static class UpdatetAsyncTask extends AsyncTask<Words, Void, Void> {

        private wordsDAO mWordsDAO;

        public UpdatetAsyncTask(wordsDAO wordsDAO) {
            mWordsDAO = wordsDAO;
        }

        @Override
        protected Void doInBackground(Words... words) {
            mWordsDAO.update(words[0]);
            return null;
        }
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {

        private wordsDAO mWordsDAO;

        public DeleteAllAsyncTask(wordsDAO wordsDAO) {
            mWordsDAO = wordsDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            mWordsDAO.deleteAllData();

            return null;
        }
    }


}
