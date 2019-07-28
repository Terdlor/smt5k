package com.example.smt5k.bd;

import android.content.Context;
import com.j256.ormlite.android.apptools.OpenHelperManager;

public class HelperFactory {

    String dd;

    private static DatabaseHelper databaseHelper;

    public static DatabaseHelper getHelper(){
        return databaseHelper;
    }
    public static void setHelper(Context context){
        databaseHelper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
    }
    public static void releaseHelper(){
        OpenHelperManager.releaseHelper();
        databaseHelper = null;
    }
}
