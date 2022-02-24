package com.doubleclick.roomdatabase;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel {
    //extends AndroidViewModel {

    private WordRepositry mRepositry;

    private LiveData<List<Words>> mAllWords;
    private Context context;

    /*public WordViewModel(Application application) {
        super(application);
        context = application;
        mRepositry = new WordRepositry(application);
        mAllWords = mRepositry.getAllWords();
    }*/

//    public void insert(Words word) {
//        mRepositry.insert(word);
//        Toast.makeText(context.getApplicationContext(),"WordViewModel = insert, 29 ,"+word.getWordName()+"\n "+
//                        word.getWordMeaning()
//                        +"\n"+word.getWordType()
//                ,Toast.LENGTH_LONG).show();
//    }
//
   /* public void delete(Words word) {
        mRepositry.delete(word);
        Toast.makeText(context.getApplicationContext(),"WordViewModel = delete,  37 ,"+word.getWordName()+"\n "+
                        word.getWordMeaning()
                        +"\n"+word.getWordType()
                ,Toast.LENGTH_LONG).show();
    }*/

    /*public void update(Words word) {
        mRepositry.update(word);
    }

    public void deleteAllWords() {
        mRepositry.deleteAllWords();
    }*/

    /*public LiveData<List<Words>> getAllWords() {
        return mAllWords;
    }*/


}
