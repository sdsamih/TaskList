package com.example.tasklist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class TaskDAO {

    private SQLiteDatabase db;

    public TaskDAO(Context context){
        DBHelper helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    public void addTask(String name){
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        db.insert("tasks", null, cv);
    }

    public ArrayList<Task> getTasks(){
        ArrayList<Task> list = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT id, name FROM tasks",null);

        if (c.moveToFirst()) {

            do{
                int id = c.getInt(0);
                String name = c.getString(1);

                list.add (new Task(name,id));

            }while (c.moveToNext());
        }
        c.close();
        return list;

    }

    public void deleteTask(int id) {
        db.delete("tasks", "id = ?", new String[]{ String.valueOf(id) });
    }

}
