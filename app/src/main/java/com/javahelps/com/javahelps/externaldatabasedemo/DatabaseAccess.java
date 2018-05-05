package com.javahelps.com.javahelps.externaldatabasedemo;

/**
 * Created by Admin on 10/03/2018.
 */
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

        import java.util.ArrayList;
        import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */

    public List<String> getUserNames() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM 'employees'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getissecretary() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM 'employees'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(2));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getistech() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM 'employees'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(3));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getismanager() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM 'employees'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(4));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getPasswords() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM 'employees'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getAllFullNames() {
        List<String> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM 'Meirav_table' WHERE ZimonDate='2018-03-13' ORDER BY ZimonTime";
        SQLiteDatabase db = openHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(1)+' '+cursor.getString(2));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }



    // Getting All Shops
    public List<Patient> getAllPatients() {
        List<Patient> PatientList = new ArrayList<Patient>();
// Select All Query
        String selectQuery = "SELECT * FROM 'Meirav_table' WHERE ArrivalTime is null and ZimonDate='2018-03-13' ORDER BY ZimonTime";
        SQLiteDatabase db = openHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Patient patient = new Patient();
                patient.setId(cursor.getString(0));
                patient.setFirstName(cursor.getString(1)+' '+cursor.getString(2));
                patient.setZimonTime(cursor.getString(4));
                patient.setEnterTime(null);
                patient.setTest(null);
// Adding contact to list
                PatientList.add(patient);
            } while (cursor.moveToNext());
        }
// return contact list
        return PatientList;
    }

    public List<Patient> getAllMemoPatients() {
            List<Patient> PatientList = new ArrayList<Patient>();
// Select All Query
            String selectQuery = "SELECT * FROM 'Queue' q join 'Meirav_table' m on q.ID=m.ID WHERE q.Test='1' and q.IsActive='1'";
            SQLiteDatabase db = openHelper.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    Patient patient = new Patient();
                    patient.setId(cursor.getString(0));
                    patient.setFirstName(cursor.getString(6)+' '+cursor.getString(7));
                    patient.setEnterTime(cursor.getString(1));
                    patient.setTest(cursor.getString(3));
                    patient.setIsActive(cursor.getString(4));
// Adding contact to list
                    PatientList.add(patient);
                } while (cursor.moveToNext());
            }



// return contact list
        return PatientList;
    }


    public List<Patient> getAllUltraPatients() {
        List<Patient> PatientList = new ArrayList<Patient>();
// Select All Query
        String selectQuery = "SELECT * FROM 'Queue' q join 'Meirav_table' m on q.ID=m.ID WHERE q.Test='2' and q.IsActive='1'";
        SQLiteDatabase db = openHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Patient patient = new Patient();
                patient.setId(cursor.getString(0));
                patient.setFirstName(cursor.getString(6)+' '+cursor.getString(7));
                patient.setEnterTime(cursor.getString(1));
                patient.setTest(cursor.getString(3));
                patient.setIsActive(cursor.getString(4));
// Adding contact to list
                PatientList.add(patient);
            } while (cursor.moveToNext());
        }
// return contact list
        return PatientList;
    }

    public List<Patient> getAllResultsPatients() {
        List<Patient> PatientList = new ArrayList<Patient>();
// Select All Query
        String selectQuery = "SELECT * FROM 'Queue' q join 'Meirav_table' m on q.ID=m.ID WHERE q.Test='3' and q.IsActive='1'";
        SQLiteDatabase db = openHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Patient patient = new Patient();
                patient.setId(cursor.getString(0));
                patient.setFirstName(cursor.getString(6)+' '+cursor.getString(7));
                patient.setEnterTime(cursor.getString(1));
                patient.setTest(cursor.getString(3));
                patient.setIsActive(cursor.getString(4));
// Adding contact to list
                PatientList.add(patient);
            } while (cursor.moveToNext());
        }
// return contact list
        return PatientList;
    }
}