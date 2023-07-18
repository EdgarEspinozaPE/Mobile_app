package com.example.ingeniadores;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 = "create table users(username text,email text, password text)";
        sqLiteDatabase.execSQL(qry1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void register(String username,String email, String password){
        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("email",email);
        cv.put("password",password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users",null,cv);
        db.close();
    }
    public int login(String email, String password){
        int result = 0;
        SQLiteDatabase db = getReadableDatabase();
        String qry[]= new String[2];
        qry[0]=email;
        qry[1]=password;
        Cursor c = db.rawQuery("select * from users where email=? and password=?",qry);
        if(c.moveToFirst()){
            result = 1;
        }
        return result;
    }

    public String getuser(String email){
        String user = "";
        String qry[]= new String[1];
        qry[0]=email;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select username from users where email=?",qry);
        if(c.moveToFirst()) {
            user = c.getString(0);
        }
        return user;
    }
}
