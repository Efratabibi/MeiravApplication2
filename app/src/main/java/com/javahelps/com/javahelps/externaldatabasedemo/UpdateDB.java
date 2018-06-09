package com.javahelps.com.javahelps.externaldatabasedemo;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;



/**
 * Created by ProgrammingKnowledge on 4/3/2015.
 */
public class UpdateDB extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Meirav3.db";
    public static final String TABLE_NAME = "Meirav_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FirstName";
    public static final String COL_3 = "LastName";
    public static final String COL_4 = "ZimonDate";
    public static final String COL_5 = "ZimonTime";
    public static final String COL_6 = "ArrivalTime";
    public static final String COL_7 = "Type";
    public static final String COL_8 = "Memo";
    public static final String COL_9 = "Us";
    public static final String COL_10 = "Doctor";
    public static final String COL_11 = "Tech";

    public UpdateDB(SecMainActivity context) {
        super((Context) context, DATABASE_NAME, null, 1);
    }

    public UpdateDB(AddPatient context) {
        super((Context) context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String ID,String FirstName,String LastName,String ZimonDate,String ZimonTime,String Type,String Memo,String Us,String Doctor,String Tech) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,ID);
        contentValues.put(COL_2,FirstName);
        contentValues.put(COL_3,LastName);
        contentValues.put(COL_4,ZimonDate);
        contentValues.put(COL_5,ZimonTime);
        contentValues.put(COL_7,Type);
        contentValues.put(COL_8,Memo);
        contentValues.put(COL_9,Us);
        contentValues.put(COL_10,Doctor);
        contentValues.put(COL_10,Tech);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id, String ArrivalTime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_6, ArrivalTime);
        //db.update(TABLE_NAME,contentValues,"ID="+id,null);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        return true;
    }


    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }


}