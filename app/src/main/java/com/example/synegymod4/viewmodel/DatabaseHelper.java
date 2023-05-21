package com.example.synegymod4.viewmodel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context context;

    private static  final String Databasename = "MyNotes";
    private static final int DatabaseVersion = 1;

    private static final String tableName = "myNotes";
    private static final String columnId = "id";
    private static final String columnTitle = "title";
    private static final String columnDescription = "description";

    public DatabaseHelper(@Nullable Context context) {
        super(context,Databasename, null, DatabaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + tableName + " (" + columnId + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + columnTitle + " TEXT, " + columnDescription + " Text);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ tableName);
        onCreate(db);
    }

    public void addNote(String title, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(columnTitle, title);
        cv.put(columnDescription, description);

        long resultValue = db.insert(tableName, null, cv);

        if (resultValue == -1) {
            Toast.makeText(context, "Данные в БД не добавлены", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Данные в БД добавлены", Toast.LENGTH_SHORT).show();
        }

    }

    public Cursor readNotes() {
        String query = "SELECT * FROM " + tableName;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    public void deleteNote() {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "DELETE FROM " + tableName;
        db.execSQL(query);
    }

    public void updateNote(String title, String description, String id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(columnTitle, title);
        cv.put(columnDescription, description);

        long result = db.update(tableName, cv, "id =?", new String[]{id});

        if (result == -1) {
            Toast.makeText(context, "Обновление не получилось", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Обновление получилось", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteSingleItems(String id) {
        SQLiteDatabase db = this.getWritableDatabase();

        long result = db.delete(tableName, "id =?", new String[]{id});

        if (result == -1) {
            Toast.makeText(context, "Удаление не получилось", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Удаление получилось", Toast.LENGTH_SHORT).show();
        }
    }
}
