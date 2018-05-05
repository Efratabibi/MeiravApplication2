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
public class UpdateQueue extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Meirav.db";
    public static final String TABLE_NAME = "Queue";
    public static final String COL_1 = "ID";
    public static final String COL_3 = "EnterTime";
    public static final String COL_4 = "LeaveTime";
    public static final String COL_5 = "Test";
    public static final String COL_6 = "IsActive";


    public UpdateQueue(SecMainActivity context) {
        super((Context) context, DATABASE_NAME, null, 1);
    }

    public UpdateQueue(WhatsNext context) {
        super((Context) context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID STRING PRIMARY KEY AUTOINCREMENT,ENTERTIME TEXT, LEAVETIME TEXT, TEST TEXT, ISACTIVE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String id, String EnterTime,String LeaveTime, String Test, String IsActive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_3,EnterTime);
        contentValues.put(COL_4,LeaveTime);
        contentValues.put(COL_5,Test);
        contentValues.put(COL_6,IsActive);
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

    public boolean updateEnterTime(String id, String EnterTime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_3, EnterTime);
        //db.update(TABLE_NAME,contentValues,"ID="+id,null);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        return true;
    }

    public boolean updateLeaveTime(String id, String LeaveTime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_4, LeaveTime);
        //db.update(TABLE_NAME,contentValues,"ID="+id,null);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        return true;
    }

    public boolean updateTest(String id, String Test) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_5, Test);
        //db.update(TABLE_NAME,contentValues,"ID="+id,null);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        return true;
    }

    public boolean updateIsActive(String id, String IsActive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_6, IsActive);
        //db.update(TABLE_NAME,contentValues,"ID="+id,null);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }


}