package com.doubleclick.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity //Annotition , to transform all variables in the class into fildes
// @Entity(tableName  = "WordsTable")// to change table name , the dafulte name is class name
public class Words {


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @PrimaryKey(autoGenerate = true)// to defined id as a primary key
    private  int id;

    public Words(String wordName, String wordMeaning, String wordType) {
        this.wordName = wordName;
        this.wordMeaning = wordMeaning;
        this.wordType = wordType;
    }

    public String getWordName() {
        return wordName;
    }

    public String getWordMeaning() {
        return wordMeaning;
    }

    public String getWordType() {
        return wordType;
    }

    private String wordName;
    private String wordMeaning;
    @ColumnInfo(name = "Type" )//to change the column Name  , if I wouldn't the dafilte name is a variable name
    private String wordType;

}
