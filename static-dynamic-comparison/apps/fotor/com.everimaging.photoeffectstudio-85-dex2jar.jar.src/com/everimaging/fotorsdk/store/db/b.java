package com.everimaging.fotorsdk.store.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import java.util.HashMap;

public class b {
    private static Uri a;

    public static Uri a(Context paramContext) {
        if (a == null) {
            a = Uri.parse("content://" + DataBaseProvider.a(paramContext) + "/" + "purchased_packs");
        }
        return a;
    }

    public static Uri a(Context paramContext, long paramLong) {
        return Uri.parse(a(paramContext) + "/" + paramLong);
    }

    public static HashMap<String, String> a() {
        HashMap localHashMap = new HashMap();
        localHashMap.put("id", "purchased_packs.id");
        localHashMap.put("install_date", "purchased_packs.install_date");
        localHashMap.put("installed", "purchased_packs.installed");
        localHashMap.put("pack_name", "purchased_packs.pack_name");
        localHashMap.put("low_default", "purchased_packs.low_default");
        localHashMap.put("low_pressed", "purchased_packs.low_pressed");
        localHashMap.put("high_default", "purchased_packs.high_default");
        localHashMap.put("high_pressed", "purchased_packs.high_pressed");
        localHashMap.put("purchase_date", "purchased_packs.purchase_date");
        localHashMap.put("resource_id", "purchased_packs.resource_id");
        localHashMap.put("resource_url", "purchased_packs.resource_url");
        localHashMap.put("pack_type", "purchased_packs.pack_type");
        return localHashMap;
    }

    public static void a(SQLiteDatabase paramSQLiteDatabase) {
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS purchased_packs(id INTEGER PRIMARY KEY AUTOINCREMENT,resource_id INTEGER NOT NULL UNIQUE,pack_name VARCHAR(255) NOT NULL,pack_type VARCHAR(255) NOT NULL,low_default TEXT,low_pressed TEXT,high_default TEXT,high_pressed TEXT,resource_url TEXT,installed NUMERIC NOT NULL,purchase_date INTEGER NOT NULL,install_date INTEGER NOT NULL);");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/db/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */