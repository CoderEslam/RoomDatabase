package com.doubleclick.roomdatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {


    private EditText WordName, MeaningName, NounName;
    private Button Add;
    private boolean editMode;
    private int mId;
    private AddNewViewModel addNewViewModel;
    public static  final String EXTRA_ID = "com.doubleclick.extraid";
    public static  final String EXTRA_MEANING = "com.doubleclick.extrameaning";
    public static  final String EXTRA_WORD = "com.doubleclick.extraword";
    public static  final String EXTRA_TYPE = "com.doubleclick.extratype";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        WordName = findViewById(R.id.WordName);
        MeaningName = findViewById(R.id.MeaningName);
        NounName = findViewById(R.id.NounName);
        Add = findViewById(R.id.Done);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable._exit);

        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_ID)){
            //update word
            setTitle("Edit Word");
            editMode = true;
            mId = intent.getIntExtra(EXTRA_ID,-1);
            WordName.setText(intent.getStringExtra(EXTRA_WORD));
            MeaningName.setText(intent.getStringExtra(EXTRA_MEANING));
            NounName.setText(intent.getStringExtra(EXTRA_TYPE));


        }else {
            //insert new word
            setTitle("Add new Activity");
            editMode = false;
        }

        addNewViewModel = ViewModelProviders.of(this).get(AddNewViewModel.class);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.save:
                SaveWord();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    private void SaveWord() {

        String word = WordName.getText().toString().trim();
        String meaning = MeaningName.getText().toString().trim();
        String type = NounName.getText().toString().trim();

        Words words = new Words(word,meaning,type);

        if(word.isEmpty()||meaning.isEmpty()||type.isEmpty()){
            Toast.makeText(AddActivity.this,"Empity",Toast.LENGTH_LONG).show();
            return;
        }
        if(editMode){
            words.setId(mId);
            addNewViewModel.update(words );

        }else {
            addNewViewModel.insert(words);

        }
        finish();
    }
}