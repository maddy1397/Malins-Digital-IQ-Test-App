package com.example.madhav.loginandreg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper{

    String DB_PATH = "/data/data/" + "com.example.madhav.loginandreg" + "/"+"databases/" ;
    private static String DB_NAME = "score.db";
    private SQLiteDatabase myDataBase;
    private Context myContext = null;
    public static final String TABLE_NAME="Clientinfo";
    public static final String Column_fname="fname";
    public static final String Column_lname="lname";
    public static final String Column_contact="contact";
    public static final String Column_dob="dob";
    public static final String Column_email="email";
    public static final String Column_pass="pass";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 10);
        this.myContext=context;
        Log.e("Path 1",DB_PATH);
        File file = new File(DB_PATH);
        if (file.exists() && !file.isDirectory());
        Log.d("AAAA","file exists");
    }

    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if (dbExist) {
        }
        else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                Log.d("COPYING ERROR",e.getMessage().toString());
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    private void copyDataBase() throws IOException {
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[10];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }


    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }


    public void openDataBase() throws SQLException {
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return myDataBase.query("age10", null, null, null, null, null, null);
    }

    public String getiqscore(int score,String condition,String age,String what){
        File dbFile = myContext.getDatabasePath("score.db");
        Log.d("ADDRESS",dbFile.getPath().toString());
        String data="";
        myDataBase=this.getReadableDatabase();
        String query="Select "+what+" from "+age+" where "+condition+"="+score+";";
        Log.d("QUERY",query);
        try{
            Cursor cursor=myDataBase.rawQuery(query,null);
            cursor.moveToFirst();
            if (cursor.getString(cursor.getColumnIndex(what)) != null)
                data += cursor.getString(cursor.getColumnIndex(what));
            cursor.close();
            myDataBase.close();
        }catch (Exception e){}
        return  data;
    }

    public long addInfo(info in)
    {   long i=0;
        ContentValues values= new ContentValues();
        values.put(Column_fname,in.getFname());
        values.put(Column_lname,in.getLname());
        values.put(Column_contact,in.getContact());
        values.put(Column_dob,in.getDob());
        values.put(Column_email,in.getEmail());
        values.put(Column_pass,in.getPass());
        try {
            myDataBase= getWritableDatabase();
            i =  myDataBase.insert("clientinfo", null, values);
            myDataBase.close();
        } catch (Exception e) {
            Log.d("error", e.getStackTrace().toString());
        }
        return i;
    }
    public  String getpass(String compareemail){
        String compare=compareemail;
        String data="";
        myDataBase= this.getReadableDatabase();
        String query="SELECT "+ Column_pass+ " FROM "+ TABLE_NAME +" WHERE " + Column_email+" = "+ "'" + compare +"'" ;
        Cursor cursor =myDataBase.rawQuery(query, null);
        cursor.moveToFirst();
        if (cursor.getString(cursor.getColumnIndex(Column_pass)) != null)
            data += cursor.getString(cursor.getColumnIndex(Column_pass));
        cursor.close();
        myDataBase.close();
        return  data;
    }

    public  String getalldata(){
        String email="";
        SQLiteDatabase database= getWritableDatabase();
        String query="Select " + Column_email + " from "+ TABLE_NAME +" where 1";
        Cursor cursor=database.rawQuery(query,null);
        try{
            cursor.moveToFirst();
        } catch (Exception e)
        {
            Log.d("ERROR","WRONG INPUT");
        }
        try {
            while(!cursor.isAfterLast()){
                if(cursor.getString(cursor.getColumnIndex(Column_email))!=null){

                    email += cursor.getString(cursor.getColumnIndex(Column_email));
                    email += "\n";
                    cursor.moveToNext();
                }

            }
            cursor.close();
            database.close();
            return email;
        } catch (Exception e){
            Log.d("Error IN GETALLDATA",e.toString());
        }
        return email;
    }

    public String putinDatabase(String user_id, String TQ, String test){
       // insert into preprocess(infotq) values(TQ)
        String query="insert into preprocess("+test+") values("+TQ+") where username="+user_id;
        myDataBase.rawQuery(query,null);
        return "done";

    }
    public String getTQ(String username,String testname){
        String data="";
        myDataBase= this.getReadableDatabase();
        String query="SELECT "+ testname+ " FROM PreProcess WHERE username = "+ "'" + username +"'" ;
        Cursor cursor;
        cursor =myDataBase.rawQuery(query, null);
        cursor.moveToFirst();
        if (cursor.getString(cursor.getColumnIndex(Column_pass)) != null)
            data += cursor.getString(cursor.getColumnIndex(Column_pass));
        cursor.close();
        myDataBase.close();

        return  data;

    }




}