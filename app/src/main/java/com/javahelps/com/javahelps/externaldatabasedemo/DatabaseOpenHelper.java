package com.javahelps.com.javahelps.externaldatabasedemo;


/**
 * Created by Admin on 10/03/2018.
 */
        import android.content.Context;

        import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "Meirav3.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}