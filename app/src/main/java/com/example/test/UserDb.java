package com.example.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class UserDb extends dbHalper{

    public UserDb(Context context) {
        super(context);
    }

   public void insertUser(model model){
       SQLiteDatabase db =getWritableDatabase();
       ContentValues cv = new ContentValues();
       cv.put(dbHalper.COL_NAME,model.name);
       cv.put(dbHalper.COL_EMAIL,model.email);
       cv.put(dbHalper.COL_PHONE,model.phone);

       db.insert(dbHalper.TAB_USER,null,cv);

       db.close();

   }
}
