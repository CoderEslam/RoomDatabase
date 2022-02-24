package com.doubleclick.roomdatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WordViewModel mWordViewModel;
    private AddNewViewModel mAddNewViewModel;
    private FloatingActionButton floatingActionButton;
    private RecyclerView recyclerView;
    private WordAdapter mWordAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        recyclerView = findViewById(R.id.RecyclerViewWords);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to the add Activity.
                Intent intent = new Intent(MainActivity.this,AddActivity.class);
                startActivityForResult(intent,1);

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //connect RecyclerView with Adapter
        mWordAdapter = new WordAdapter();
        recyclerView.setAdapter(mWordAdapter);

//        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
//        mWordViewModel.getAllWords().observe(this, new Observer<List<Words>>() {
//            @Override
//            public void onChanged(List<Words> words) {
//                //Update UI
//                //RecyclerView
//                //put data in Adapter
//                mWordAdapter.setWords(words);
//                Toast.makeText(getApplicationContext(), "on change Worked", Toast.LENGTH_LONG).show();
//
//            }
//        });

        mAddNewViewModel = new  ViewModelProvider(this).get(AddNewViewModel.class);

        mAddNewViewModel.getAllWords().observe(this, new Observer<List<Words>>() {
            @Override
            public void onChanged(List<Words> words) {
                //Update UI
                //RecyclerView
                //put data in Adapter
                mWordAdapter.setWords(words);
                Toast.makeText(getApplicationContext(), "on change Worked", Toast.LENGTH_LONG).show();
            }
        });

        mWordAdapter.onItemClickListener(new WordAdapter.onItemClickListener() {
            @Override
            public void onItemClick(Words words) {
                Intent intent = new Intent(MainActivity.this,AddActivity.class);
                intent.putExtra(AddActivity.EXTRA_ID,words.getId());
                intent.putExtra(AddActivity.EXTRA_WORD,words.getWordName());
                intent.putExtra(AddActivity.EXTRA_MEANING,words.getWordMeaning());
                intent.putExtra(AddActivity.EXTRA_TYPE,words.getWordType());
                startActivity(intent);

            }
        });
        //to swipe to delete
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT){

            @Override
            public boolean onMove(RecyclerView recyclerView,  RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped( RecyclerView.ViewHolder viewHolder, int direction) {

                int position =  viewHolder.getAdapterPosition();
//                mWordViewModel.delete(mWordAdapter.getWordAt(position));
                mAddNewViewModel.delete(mWordAdapter.getWordAt(position));

            }
        }).attachToRecyclerView(recyclerView);
    }
}