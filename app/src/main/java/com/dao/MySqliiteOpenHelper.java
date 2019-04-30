package com.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.model.UserData;

import java.util.ArrayList;
import java.util.List;

public class MySqliiteOpenHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME="user";
    private static final String COLOUMN_ID="id";
    private static final String COLOUMN_NAME="name";
    private static final String COLOUMN_EMAIL="email";
    private static final String COLOUMN_PASSWORD="password";


    public MySqliiteOpenHelper(Context context) {
        super(context,"mydb",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE="CREATE TABLE "+ TABLE_NAME+"("+COLOUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLOUMN_NAME +"TEXT,"
                + COLOUMN_EMAIL+"TEXT,"+COLOUMN_PASSWORD+ " TEXT" + " )";
        db.execSQL(CREATE_USER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }
    public void addUser(UserData user){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put(COLOUMN_ID,user.getId());
        contentValues.put(COLOUMN_NAME,user.getName());
        contentValues.put(COLOUMN_EMAIL,user.getEmail());
        contentValues.put(COLOUMN_PASSWORD,user.getPass());
    }
    public List<UserData> readAllUser(){
        List<UserData> userDataList=new ArrayList<>();
        String selectQuery="Select * from "+TABLE_NAME;
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(selectQuery,null);

        while (cursor.moveToNext())
    }
}
