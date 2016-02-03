package com.quoord.tapatalkpro.sqlhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.quoord.tapatalkpro.bean.TapatalkForum;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FavoriateSqlHelper
        extends SQLiteOpenHelper {
    public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS favorite (id INTEGER PRIMARY KEY,forum_name VARCHAR,description VARCHAR,url VARCHAR, extra BLOB,usericon BLOB);";
    public static final String DESCPRITION = "description";
    public static final String EXTRA = "extra";
    public static final String FORUM_NAME = "forum_name";
    public static final String ID = "id";
    public static final String TB_NAME = "favorite";
    public static final String URL = "url";
    public static final String USERICON = "usericon";
    private Context mContext;
    private SQLiteDatabase mDb;

    public FavoriateSqlHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt) {
        super(paramContext, paramString, paramCursorFactory, paramInt);
        this.mContext = paramContext;
    }

    public void close() {
        try {
            if (this.mDb != null) {
                this.mDb.close();
            }
            return;
        } catch (Exception localException) {
        }
    }

    public boolean deleteAllFavoriate() {
        try {
            SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
            localSQLiteDatabase.execSQL("delete from favorite");
            localSQLiteDatabase.close();
            return true;
        } catch (Exception localException) {
        }
        return false;
    }

    public boolean deleteFavoriate(TapatalkForum paramTapatalkForum) {
        try {
            SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
            int i = localSQLiteDatabase.delete("favorite", "id = ?", new String[]{paramTapatalkForum.getId().toString()});
            localSQLiteDatabase.close();
            return i != 0;
        } catch (Exception paramTapatalkForum) {
        }
        return false;
    }

    public TapatalkForum getFavrivate(String paramString) {
        try {
            SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
            Cursor localCursor = localSQLiteDatabase.query("favorite", null, "forum_name = ?", new String[]{paramString}, null, null, "id DESC");
            localCursor.getColumnIndexOrThrow("id");
            localCursor.getColumnIndexOrThrow("forum_name");
            localCursor.getColumnIndexOrThrow("description");
            if (localCursor.getCount() > 0) {
                localCursor.moveToFirst();
                new TapatalkForum();
                paramString = localCursor.getBlob(localCursor.getColumnIndex("extra"));
                Object localObject1 = new Object();
                Object localObject2 = new ByteArrayInputStream(paramString);
                paramString = (String) localObject1;
                try {
                    localObject2 = new ObjectInputStream((InputStream) localObject2);
                    paramString = (String) localObject1;
                    localObject1 = ((ObjectInputStream) localObject2).readObject();
                    paramString = (String) localObject1;
                    ((ObjectInputStream) localObject2).close();
                    paramString = (String) localObject1;
                } catch (Exception localException) {
                    for (; ; ) {
                        localException.printStackTrace();
                    }
                }
                paramString = (TapatalkForum) paramString;
                localCursor.close();
                localSQLiteDatabase.close();
                return paramString;
            }
            localCursor.close();
            localSQLiteDatabase.close();
            return null;
        } catch (Exception paramString) {
        }
        return null;
    }

    public ArrayList<TapatalkForum> getFavrivate() {
        for (; ; ) {
            try {
                SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
                localArrayList = new ArrayList();
                localCursor = localSQLiteDatabase.query("favorite", null, null, null, null, null, "id DESC");
                i = localCursor.getColumnIndexOrThrow("id");
                j = localCursor.getColumnIndexOrThrow("forum_name");
                k = localCursor.getColumnIndexOrThrow("description");
                m = localCursor.getColumnIndexOrThrow("usericon");
                localCursor.moveToFirst();
                if (localCursor.isAfterLast()) {
                    localCursor.close();
                    localSQLiteDatabase.close();
                    return localArrayList;
                }
                new TapatalkForum();
                localObject1 = localCursor.getBlob(localCursor.getColumnIndex("extra"));
                localObject2 = new Object();
                localObject3 = new ByteArrayInputStream((byte[]) localObject1);
                localObject1 = localObject2;
            } catch (Exception localException1) {
                ArrayList localArrayList;
                Cursor localCursor;
                int i;
                int j;
                int k;
                int m;
                Object localObject1;
                Object localObject2;
                Object localObject3;
                localException1.printStackTrace();
                return null;
            }
            try {
                localObject3 = new ObjectInputStream((InputStream) localObject3);
                localObject1 = localObject2;
                localObject2 = ((ObjectInputStream) localObject3).readObject();
                localObject1 = localObject2;
                ((ObjectInputStream) localObject3).close();
                localObject1 = localObject2;
            } catch (Exception localException2) {
                localException2.printStackTrace();
                continue;
            }
            localObject1 = (TapatalkForum) localObject1;
            ((TapatalkForum) localObject1).setId(Integer.valueOf(localCursor.getInt(i)));
            ((TapatalkForum) localObject1).setName(localCursor.getString(j));
            ((TapatalkForum) localObject1).setUrl(localCursor.getString(localCursor.getColumnIndex("url")));
            ((TapatalkForum) localObject1).setDescription(localCursor.getString(k));
            localArrayList.add(localObject1);
            localObject2 = localCursor.getBlob(m);
            if ((localObject2 != null) && (localObject2.length > 0)) {
                ((TapatalkForum) localObject1).setUserIcon(BitmapFactory.decodeByteArray((byte[]) localObject2, 0, localObject2.length));
            }
            localCursor.moveToNext();
        }
    }

    public TapatalkForum getFavrivateById(String paramString) {
        try {
            SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
            Cursor localCursor = localSQLiteDatabase.query("favorite", null, "id = ?", new String[]{paramString}, null, null, "id DESC");
            if (localCursor.getCount() > 0) {
                localCursor.getColumnIndexOrThrow("id");
                localCursor.getColumnIndexOrThrow("forum_name");
                localCursor.getColumnIndexOrThrow("description");
                localCursor.moveToFirst();
                if (localCursor.isAfterLast()) {
                    return null;
                }
                new TapatalkForum();
                paramString = localCursor.getBlob(localCursor.getColumnIndex("extra"));
                Object localObject1 = new Object();
                Object localObject2 = new ByteArrayInputStream(paramString);
                paramString = (String) localObject1;
                try {
                    localObject2 = new ObjectInputStream((InputStream) localObject2);
                    paramString = (String) localObject1;
                    localObject1 = ((ObjectInputStream) localObject2).readObject();
                    paramString = (String) localObject1;
                    ((ObjectInputStream) localObject2).close();
                    paramString = (String) localObject1;
                } catch (Exception localException) {
                    for (; ; ) {
                        localException.printStackTrace();
                    }
                }
                paramString = (TapatalkForum) paramString;
                localCursor.close();
                localSQLiteDatabase.close();
                return paramString;
            }
            localCursor.close();
            localSQLiteDatabase.close();
            return null;
        } catch (Exception paramString) {
        }
        return null;
    }

    public TapatalkForum getFavrivateByIdSequence(String paramString) {
        try {
            if (this.mDb == null) {
                open();
            }
            Cursor localCursor = this.mDb.query("favorite", null, "id = ?", new String[]{paramString}, null, null, "id DESC");
            if (localCursor.getCount() > 0) {
                localCursor.getColumnIndexOrThrow("id");
                localCursor.getColumnIndexOrThrow("forum_name");
                localCursor.getColumnIndexOrThrow("description");
                localCursor.moveToFirst();
                if (localCursor.isAfterLast()) {
                    return null;
                }
                new TapatalkForum();
                paramString = localCursor.getBlob(localCursor.getColumnIndex("extra"));
                Object localObject1 = new Object();
                Object localObject2 = new ByteArrayInputStream(paramString);
                paramString = (String) localObject1;
                try {
                    localObject2 = new ObjectInputStream((InputStream) localObject2);
                    paramString = (String) localObject1;
                    localObject1 = ((ObjectInputStream) localObject2).readObject();
                    paramString = (String) localObject1;
                    ((ObjectInputStream) localObject2).close();
                    paramString = (String) localObject1;
                } catch (Exception localException) {
                    for (; ; ) {
                        localException.printStackTrace();
                    }
                }
                paramString = (TapatalkForum) paramString;
                localCursor.close();
                return paramString;
            }
            localCursor.close();
            return null;
        } catch (Exception paramString) {
        }
        return null;
    }

    public TapatalkForum getFavrivateByUrl(String paramString) {
        try {
            SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
            Cursor localCursor = localSQLiteDatabase.query("favorite", null, "url like '%" + paramString + "%'", null, null, null, "id DESC");
            localCursor.getColumnIndexOrThrow("id");
            localCursor.getColumnIndexOrThrow("forum_name");
            localCursor.getColumnIndexOrThrow("description");
            localCursor.moveToFirst();
            new TapatalkForum();
            if (localCursor.getCount() > 0) {
                paramString = localCursor.getBlob(localCursor.getColumnIndex("extra"));
                Object localObject1 = new Object();
                Object localObject2 = new ByteArrayInputStream(paramString);
                paramString = (String) localObject1;
                try {
                    localObject2 = new ObjectInputStream((InputStream) localObject2);
                    paramString = (String) localObject1;
                    localObject1 = ((ObjectInputStream) localObject2).readObject();
                    paramString = (String) localObject1;
                    ((ObjectInputStream) localObject2).close();
                    paramString = (String) localObject1;
                } catch (Exception localException) {
                    for (; ; ) {
                        localException.printStackTrace();
                    }
                }
                paramString = (TapatalkForum) paramString;
                localCursor.close();
                localSQLiteDatabase.close();
                return paramString;
            }
            localCursor.close();
            localSQLiteDatabase.close();
            return null;
        } catch (Exception paramString) {
        }
        return null;
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS favorite (id INTEGER PRIMARY KEY,forum_name VARCHAR,description VARCHAR,url VARCHAR, extra BLOB,usericon BLOB);");
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS subscribeforum (id INTEGER PRIMARY KEY AUTOINCREMENT,forumid VARCHER,tapforumurl VARCHAR,name VARCHAR,subonly INTEGER,logourl VARCHAR,subforum BLOB)");
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS favorite (id INTEGER PRIMARY KEY,forum_name VARCHAR,description VARCHAR,url VARCHAR, extra BLOB,usericon BLOB);");
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS subscribeforum (id INTEGER PRIMARY KEY AUTOINCREMENT,forumid VARCHER,tapforumurl VARCHAR,name VARCHAR,subonly INTEGER,logourl VARCHAR,subforum BLOB)");
    }

    public void open() {
        try {
            this.mDb = getWritableDatabase();
            return;
        } catch (Exception localException) {
        }
    }

    /* Error */
    public void saveFavoriate(TapatalkForum paramTapatalkForum) {
        // Byte code:
        //   0: ldc -33
        //   2: new 200	java/lang/StringBuilder
        //   5: dup
        //   6: ldc -31
        //   8: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   11: aload_1
        //   12: invokevirtual 228	com/quoord/tapatalkpro/bean/TapatalkForum:getUserNameOrDisplayName	()Ljava/lang/String;
        //   15: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   18: ldc -26
        //   20: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   23: aload_1
        //   24: invokevirtual 233	com/quoord/tapatalkpro/bean/TapatalkForum:getPassword	()Ljava/lang/String;
        //   27: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   30: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   33: invokestatic 239	com/quoord/tools/TapatalkLog:v	(Ljava/lang/String;Ljava/lang/String;)V
        //   36: aload_0
        //   37: invokevirtual 56	com/quoord/tapatalkpro/sqlhelper/FavoriateSqlHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
        //   40: astore_2
        //   41: aload_2
        //   42: ldc 23
        //   44: aconst_null
        //   45: new 200	java/lang/StringBuilder
        //   48: dup
        //   49: ldc -15
        //   51: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   54: aload_1
        //   55: invokevirtual 74	com/quoord/tapatalkpro/bean/TapatalkForum:getId	()Ljava/lang/Integer;
        //   58: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   61: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   64: aconst_null
        //   65: aconst_null
        //   66: aconst_null
        //   67: ldc 93
        //   69: invokevirtual 97	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   72: astore_3
        //   73: new 246	android/content/ContentValues
        //   76: dup
        //   77: invokespecial 247	android/content/ContentValues:<init>	()V
        //   80: astore 4
        //   82: aload_1
        //   83: invokevirtual 251	com/quoord/tapatalkpro/bean/TapatalkForum:getUserIcon	()Landroid/graphics/Bitmap;
        //   86: ifnull +44 -> 130
        //   89: new 253	java/io/ByteArrayOutputStream
        //   92: dup
        //   93: invokespecial 254	java/io/ByteArrayOutputStream:<init>	()V
        //   96: astore 5
        //   98: aload_1
        //   99: invokevirtual 251	com/quoord/tapatalkpro/bean/TapatalkForum:getUserIcon	()Landroid/graphics/Bitmap;
        //   102: getstatic 260	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
        //   105: bipush 100
        //   107: aload 5
        //   109: invokevirtual 266	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   112: pop
        //   113: aload 4
        //   115: ldc 29
        //   117: aload 5
        //   119: invokevirtual 270	java/io/ByteArrayOutputStream:toByteArray	()[B
        //   122: invokevirtual 274	android/content/ContentValues:put	(Ljava/lang/String;[B)V
        //   125: aload_1
        //   126: aconst_null
        //   127: invokevirtual 187	com/quoord/tapatalkpro/bean/TapatalkForum:setUserIcon	(Landroid/graphics/Bitmap;)V
        //   130: new 253	java/io/ByteArrayOutputStream
        //   133: dup
        //   134: invokespecial 254	java/io/ByteArrayOutputStream:<init>	()V
        //   137: astore 5
        //   139: new 276	java/io/ObjectOutputStream
        //   142: dup
        //   143: new 278	java/io/BufferedOutputStream
        //   146: dup
        //   147: aload 5
        //   149: invokespecial 281	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   152: invokespecial 282	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   155: astore 6
        //   157: aload 6
        //   159: aload_1
        //   160: invokevirtual 286	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
        //   163: aload 6
        //   165: invokevirtual 287	java/io/ObjectOutputStream:close	()V
        //   168: aload 4
        //   170: ldc 17
        //   172: aload_1
        //   173: invokevirtual 290	com/quoord/tapatalkpro/bean/TapatalkForum:getName	()Ljava/lang/String;
        //   176: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
        //   179: aload 4
        //   181: ldc 11
        //   183: aload_1
        //   184: invokevirtual 295	com/quoord/tapatalkpro/bean/TapatalkForum:getDescription	()Ljava/lang/String;
        //   187: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
        //   190: aload 4
        //   192: ldc 14
        //   194: aload 5
        //   196: invokevirtual 270	java/io/ByteArrayOutputStream:toByteArray	()[B
        //   199: invokevirtual 274	android/content/ContentValues:put	(Ljava/lang/String;[B)V
        //   202: aload 4
        //   204: ldc 26
        //   206: aload_1
        //   207: invokevirtual 298	com/quoord/tapatalkpro/bean/TapatalkForum:getUrl	()Ljava/lang/String;
        //   210: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
        //   213: aload_3
        //   214: invokeinterface 107 1 0
        //   219: ifle +121 -> 340
        //   222: aload_2
        //   223: ldc 23
        //   225: aload 4
        //   227: ldc 66
        //   229: iconst_1
        //   230: anewarray 68	java/lang/String
        //   233: dup
        //   234: iconst_0
        //   235: aload_1
        //   236: invokevirtual 74	com/quoord/tapatalkpro/bean/TapatalkForum:getId	()Ljava/lang/Integer;
        //   239: invokevirtual 80	java/lang/Integer:toString	()Ljava/lang/String;
        //   242: aastore
        //   243: invokevirtual 302	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
        //   246: pop
        //   247: aload 5
        //   249: invokevirtual 303	java/io/ByteArrayOutputStream:close	()V
        //   252: aload_3
        //   253: invokeinterface 138 1 0
        //   258: aload_2
        //   259: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
        //   262: aload_0
        //   263: getfield 39	com/quoord/tapatalkpro/sqlhelper/FavoriateSqlHelper:mContext	Landroid/content/Context;
        //   266: invokestatic 309	com/quoord/tapatalkpro/util/Prefs:get	(Landroid/content/Context;)Landroid/content/SharedPreferences;
        //   269: invokeinterface 315 1 0
        //   274: astore_2
        //   275: aload_2
        //   276: new 200	java/lang/StringBuilder
        //   279: dup
        //   280: ldc_w 317
        //   283: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   286: aload_1
        //   287: invokevirtual 74	com/quoord/tapatalkpro/bean/TapatalkForum:getId	()Ljava/lang/Integer;
        //   290: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   293: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   296: aload_1
        //   297: invokevirtual 320	com/quoord/tapatalkpro/bean/TapatalkForum:getUserName	()Ljava/lang/String;
        //   300: invokeinterface 326 3 0
        //   305: pop
        //   306: aload_2
        //   307: invokeinterface 329 1 0
        //   312: pop
        //   313: return
        //   314: astore 6
        //   316: aload 6
        //   318: invokevirtual 330	java/io/IOException:printStackTrace	()V
        //   321: goto -153 -> 168
        //   324: astore_3
        //   325: ldc -33
        //   327: ldc_w 332
        //   330: invokestatic 239	com/quoord/tools/TapatalkLog:v	(Ljava/lang/String;Ljava/lang/String;)V
        //   333: aload_2
        //   334: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
        //   337: goto -75 -> 262
        //   340: aload 4
        //   342: ldc 20
        //   344: aload_1
        //   345: invokevirtual 74	com/quoord/tapatalkpro/bean/TapatalkForum:getId	()Ljava/lang/Integer;
        //   348: invokevirtual 335	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
        //   351: aload_2
        //   352: ldc 23
        //   354: ldc 20
        //   356: aload 4
        //   358: invokevirtual 339	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
        //   361: pop2
        //   362: goto -115 -> 247
        //   365: astore 4
        //   367: aload 4
        //   369: invokevirtual 330	java/io/IOException:printStackTrace	()V
        //   372: goto -120 -> 252
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	375	0	this	FavoriateSqlHelper
        //   0	375	1	paramTapatalkForum	TapatalkForum
        //   40	312	2	localObject	Object
        //   72	181	3	localCursor	Cursor
        //   324	1	3	localException	Exception
        //   80	277	4	localContentValues	ContentValues
        //   365	3	4	localIOException1	IOException
        //   96	152	5	localByteArrayOutputStream	ByteArrayOutputStream
        //   155	9	6	localObjectOutputStream	ObjectOutputStream
        //   314	3	6	localIOException2	IOException
        // Exception table:
        //   from	to	target	type
        //   139	168	314	java/io/IOException
        //   41	130	324	java/lang/Exception
        //   130	139	324	java/lang/Exception
        //   139	168	324	java/lang/Exception
        //   168	247	324	java/lang/Exception
        //   247	252	324	java/lang/Exception
        //   252	262	324	java/lang/Exception
        //   316	321	324	java/lang/Exception
        //   340	362	324	java/lang/Exception
        //   367	372	324	java/lang/Exception
        //   247	252	365	java/io/IOException
    }

    public void saveFavoriateSequence(TapatalkForum paramTapatalkForum) {
        try {
            Cursor localCursor = this.mDb.query("favorite", null, "id = " + paramTapatalkForum.getId(), null, null, null, "id DESC");
            ContentValues localContentValues = new ContentValues();
            if (paramTapatalkForum.getUserIcon() != null) {
                localByteArrayOutputStream = new ByteArrayOutputStream();
                paramTapatalkForum.getUserIcon().compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
                localContentValues.put("usericon", localByteArrayOutputStream.toByteArray());
                paramTapatalkForum.setUserIcon(null);
            }
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(new BufferedOutputStream(localByteArrayOutputStream));
                localObjectOutputStream.writeObject(paramTapatalkForum);
                localObjectOutputStream.close();
                localContentValues.put("forum_name", paramTapatalkForum.getName());
                localContentValues.put("description", paramTapatalkForum.getDescription());
                localContentValues.put("extra", localByteArrayOutputStream.toByteArray());
                localContentValues.put("url", paramTapatalkForum.getUrl());
                if (localCursor.getCount() > 0) {
                    paramTapatalkForum = paramTapatalkForum.getId().toString();
                    this.mDb.update("favorite", localContentValues, "id = ?", new String[]{paramTapatalkForum});
                }
            } catch (IOException localIOException) {
                try {
                    for (; ; ) {
                        localByteArrayOutputStream.close();
                        localCursor.close();
                        return;
                        localIOException = localIOException;
                        localIOException.printStackTrace();
                        continue;
                        localContentValues.put("id", paramTapatalkForum.getId());
                        this.mDb.insert("favorite", "id", localContentValues);
                    }
                } catch (IOException paramTapatalkForum) {
                    for (; ; ) {
                        paramTapatalkForum.printStackTrace();
                    }
                }
            }
            return;
        } catch (Exception paramTapatalkForum) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/sqlhelper/FavoriateSqlHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */