package com.example.mydatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    public Database(Context context) {
        super(context, "Login.db", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table USERS(ID INTEGER PRIMARY KEY AUTOINCREMENT,name Text,surname Text,mark INTEGER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USERS");
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from USERS", null);
        return res;
    }
    public Boolean insertdata(String name, String surname, Integer mark) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("surname", surname);
        contentValues.put("mark", mark);
        long result = db.insert("USERS", null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public int deletedata(String name)
    {
    SQLiteDatabase db=this.getWritableDatabase();
    int i =db.delete("USERS","name=?",new String[]{name});
     return i;
      }
    public Boolean updateData(String name, String surname, Integer mark) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name", name);
        contentValues.put("surname",surname);
        contentValues.put("mark",mark);
        int result=db.update("USERS",contentValues,"name=?",new String[]{name});
        if (result>0) {
            return true;
        }
        else
        {
            return false;
        }
    }
}
