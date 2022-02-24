package com.doubleclick.roomdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {

    private List<Words> mWordsList = new ArrayList<>();
    private Context context;
    private onItemClickListener mListener;

//    public WordAdapter(Context context,List<Words> mWordsList) {
//        this.mWordsList = mWordsList;
//        this.context = context;
//    }


    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_list_item,parent,false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {

        Words currentWord = mWordsList.get(position);
        holder.textWord.setText(currentWord.getWordName());
        holder.textMeaning.setText(currentWord.getWordMeaning());
        holder.textType.setText(currentWord.getWordType());

    }

    @Override
    public int getItemCount() {
        return mWordsList.size();
    }

    public void setWords(List<Words> words){
        mWordsList = words;
        notifyDataSetChanged();
    }

    public interface onItemClickListener {
        void onItemClick(Words words);
    }

    public void onItemClickListener(onItemClickListener listener){
        mListener = listener;
    }

    public Words getWordAt(int pos){
        return mWordsList.get(pos);
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {

        public TextView textWord,textMeaning,textType;
        public WordViewHolder(View itemView) {
            super(itemView);
            textWord = itemView.findViewById(R.id.word_text);
            textMeaning = itemView.findViewById(R.id.meaning_text);
            textType = itemView.findViewById(R.id.noun);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = getAdapterPosition();
                    if (mListener != null && index != RecyclerView.NO_POSITION){
                        mListener.onItemClick(mWordsList.get(index));
                    }
                }
            });
        }

    }

}
