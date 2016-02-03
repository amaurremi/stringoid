package a.a.a.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class c
        extends SQLiteOpenHelper {
    c(Context paramContext) {
        super(paramContext, "countly", null, 1);
    }

    private e a(JSONObject paramJSONObject) {
        e locale = new e();
        try {
            locale.a = paramJSONObject.get("key").toString();
            locale.c = Integer.valueOf(paramJSONObject.get("count").toString()).intValue();
            locale.d = Double.valueOf(paramJSONObject.get("sum").toString()).doubleValue();
            locale.e = Integer.valueOf(paramJSONObject.get("timestamp").toString()).intValue();
            HashMap localHashMap = new HashMap();
            Iterator localIterator = ((JSONObject) paramJSONObject.get("segmentation")).keys();
            while (localIterator.hasNext()) {
                String str = (String) localIterator.next();
                localHashMap.put(str, ((JSONObject) paramJSONObject.get("segmentation")).getString(str));
            }
            locale.b = localHashMap;
        } catch (JSONException paramJSONObject) {
            paramJSONObject.printStackTrace();
            return locale;
        }
        return locale;
    }

    private JSONObject a(e parame) {
        JSONObject localJSONObject = new JSONObject();
        try {
            localJSONObject.put("key", parame.a);
            localJSONObject.put("count", parame.c);
            localJSONObject.put("sum", parame.d);
            localJSONObject.put("timestamp", parame.e);
            if (parame.b != null) {
                localJSONObject.put("segmentation", new JSONObject(parame.b));
            }
            return localJSONObject;
        } catch (JSONException parame) {
            parame.printStackTrace();
        }
        return localJSONObject;
    }

    public void a(String paramString) {
        getWritableDatabase().execSQL("DELETE FROM CONNECTIONS WHERE ID = " + paramString + ";");
    }

    public void a(ArrayList<e> paramArrayList) {
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject = new JSONObject();
        int i = 0;
        while (i < paramArrayList.size()) {
            localJSONArray.put(a((e) paramArrayList.get(i)));
            i += 1;
        }
        try {
            localJSONObject.put("events", localJSONArray);
            getWritableDatabase().rawQuery("INSERT OR REPLACE INTO EVENTS(ID, EVENT) VALUES(1, ?);", new String[]{localJSONObject.toString()});
            return;
        } catch (JSONException paramArrayList) {
            for (; ; ) {
                paramArrayList.printStackTrace();
            }
        }
    }

    public String[] a() {
        try {
            Cursor localCursor = getReadableDatabase().query("CONNECTIONS", null, null, null, null, null, "ID DESC", "1");
            String[] arrayOfString = new String[2];
            if ((localCursor != null) && (localCursor.getCount() > 0)) {
                localCursor.moveToFirst();
                arrayOfString[0] = localCursor.getString(0);
                arrayOfString[1] = localCursor.getString(1);
            }
            localCursor.close();
            return arrayOfString;
        } finally {
        }
    }

    public void b(String paramString) {
        getWritableDatabase().execSQL("INSERT INTO CONNECTIONS(CONNECTION) VALUES('" + paramString + "');");
    }

    public boolean b() {
        Cursor localCursor = getReadableDatabase().query("CONNECTIONS", null, null, null, null, null, "ID DESC", "1");
        if ((localCursor == null) || (localCursor.getCount() <= 0)) {
        }
        for (boolean bool = true; ; bool = false) {
            localCursor.close();
            return bool;
        }
    }

    public ArrayList<e> c() {
        Cursor localCursor = getReadableDatabase().query("EVENTS", null, null, null, null, null, "ID = 1", "1");
        ArrayList localArrayList = new ArrayList();
        Object localObject1;
        if ((localCursor != null) && (localCursor.getCount() > 0)) {
            localCursor.moveToFirst();
            Object localObject2 = localCursor.getString(1);
            localObject1 = new JSONObject();
            try {
                localObject2 = new JSONObject((String) localObject2);
                localObject1 = localObject2;
            } catch (JSONException localJSONException1) {
                try {
                    for (; ; ) {
                        int i;
                        localArrayList.add(a(new JSONObject(((JSONArray) localObject1).get(i).toString())));
                        i += 1;
                    }
                    localJSONException1 = localJSONException1;
                    localJSONException1.printStackTrace();
                } catch (JSONException localJSONException2) {
                    for (; ; ) {
                        localJSONException2.printStackTrace();
                    }
                }
            }
            localObject1 = ((JSONObject) localObject1).optJSONArray("events");
            if (localObject1 != null) {
                i = 0;
                if (i >= ((JSONArray) localObject1).length()) {
                }
            }
        }
        localCursor.close();
        return localArrayList;
    }

    public void d() {
        getWritableDatabase().execSQL("DELETE FROM EVENTS;");
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
        paramSQLiteDatabase.execSQL("CREATE TABLE CONNECTIONS (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, CONNECTION TEXT NOT NULL);");
        paramSQLiteDatabase.execSQL("CREATE TABLE EVENTS (ID INTEGER UNIQUE NOT NULL, EVENT TEXT NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/a/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */