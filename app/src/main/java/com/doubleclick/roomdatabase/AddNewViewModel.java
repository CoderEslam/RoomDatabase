package com.doubleclick.roomdatabase;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AddNewViewModel extends AndroidViewModel {

    private WordRepositry mRepositry;
    private Context context;
    private LiveData<List<Words>> mAllWords;

    public AddNewViewModel(Application application) {
        super(application);
        context = application;
        mRepositry = new WordRepositry(application);
        mAllWords = mRepositry.getAllWords();
        Toast.makeText(application.getApplicationContext(),"AddNewViewModel  = 23 ," + application,Toast.LENGTH_LONG).show();
    }

    public void insert(Words word) {
        mRepositry.insert(word);
        Toast.makeText(context.getApplicationContext(),"AddNewViewModel = insert, 28 ,"+word.getWordName()+"\n "+
                word.getWordMeaning()
                +"\n"+word.getWordType()
                ,Toast.LENGTH_LONG).show();
    }

    public void update(Words word) { //done
        mRepositry.update(word);
        Toast.makeText(context.getApplicationContext(),"AddNewViewModel = update,  36 ,"+word.getWordName()+"\n "+
                        word.getWordMeaning()
                        +"\n"+word.getWordType()
                ,Toast.LENGTH_LONG).show();
    }

    public void delete(Words word) {
        mRepositry.delete(word);
        Toast.makeText(context.getApplicationContext(),"AddNewViewModel = delete,  44 ,"+word.getWordName()+"\n "+
                        word.getWordMeaning()
                        +"\n"+word.getWordType()
                ,Toast.LENGTH_LONG).show();
    }

    public LiveData<List<Words>> getAllWords() {
        Toast.makeText(context.getApplicationContext(),"Getting All Data",Toast.LENGTH_LONG).show();
        return mAllWords;
    }

}
