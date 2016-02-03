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

public class FeedForumHelper
        extends SQLiteOpenHelper {
    public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS feed (id INTEGER PRIMARY KEY,forum_name VARCHAR,description VARCHAR,url VARCHAR, extra BLOB,usericon BLOB);";
    public static final String DESCPRITION = "description";
    public static final String EXTRA = "extra";
    public static final String FORUM_NAME = "forum_name";
    public static final String ID = "id";
    public static final String TB_NAME = "feed";
    public static final String URL = "url";
    public static final String USERICON = "usericon";
    private Context mContext;
    private SQLiteDatabase mDb;

    public FeedForumHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt) {
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
            localSQLiteDatabase.execSQL("delete from feed");
            localSQLiteDatabase.close();
            return true;
        } catch (Exception localException) {
        }
        return false;
    }

    public boolean deleteFavoriate(TapatalkForum paramTapatalkForum) {
        try {
            SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
            int i = localSQLiteDatabase.delete("feed", "id = ?", new String[]{paramTapatalkForum.getId().toString()});
            localSQLiteDatabase.close();
            return i != 0;
        } catch (Exception paramTapatalkForum) {
        }
        return false;
    }

    public TapatalkForum getFavrivate(String paramString) {
        try {
            SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
            Cursor localCursor = localSQLiteDatabase.query("feed", null, "forum_name = ?", new String[]{paramString}, null, null, "id DESC");
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
        try {
            SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
            ArrayList localArrayList = new ArrayList();
            Cursor localCursor = localSQLiteDatabase.query("feed", null, null, null, null, null, "id DESC");
            int i = localCursor.getColumnIndexOrThrow("id");
            int j = localCursor.getColumnIndexOrThrow("forum_name");
            int k = localCursor.getColumnIndexOrThrow("description");
            int m = localCursor.getColumnIndexOrThrow("usericon");
            localCursor.moveToFirst();
            for (; ; ) {
                if (localCursor.isAfterLast()) {
                    localCursor.close();
                    localSQLiteDatabase.close();
                    return localArrayList;
                }
                new TapatalkForum();
                Object localObject1 = localCursor.getBlob(localCursor.getColumnIndex("extra"));
                Object localObject2 = new Object();
                Object localObject3 = new ByteArrayInputStream((byte[]) localObject1);
                localObject1 = localObject2;
                try {
                    localObject3 = new ObjectInputStream((InputStream) localObject3);
                    localObject1 = localObject2;
                    localObject2 = ((ObjectInputStream) localObject3).readObject();
                    localObject1 = localObject2;
                    ((ObjectInputStream) localObject3).close();
                    localObject1 = localObject2;
                } catch (Exception localException2) {
                    for (; ; ) {
                        localException2.printStackTrace();
                    }
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
            return null;
        } catch (Exception localException1) {
        }
    }

    public TapatalkForum getFavrivateById(String paramString) {
        try {
            SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
            Cursor localCursor = localSQLiteDatabase.query("feed", null, "id = ?", new String[]{paramString}, null, null, "id DESC");
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
            Cursor localCursor = this.mDb.query("feed", null, "id = ?", new String[]{paramString}, null, null, "id DESC");
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
            Cursor localCursor = localSQLiteDatabase.query("feed", null, "url like '%" + paramString + "%'", null, null, null, "id DESC");
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
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS feed (id INTEGER PRIMARY KEY,forum_name VARCHAR,description VARCHAR,url VARCHAR, extra BLOB,usericon BLOB);");
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS feed (id INTEGER PRIMARY KEY,forum_name VARCHAR,description VARCHAR,url VARCHAR, extra BLOB,usericon BLOB);");
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
        //   0: aload_0
        //   1: invokevirtual 56	com/quoord/tapatalkpro/sqlhelper/FeedForumHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
        //   4: astore_2
        //   5: aload_2
        //   6: ldc 23
        //   8: aconst_null
        //   9: new 200	java/lang/StringBuilder
        //   12: dup
        //   13: ldc -35
        //   15: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   18: aload_1
        //   19: invokevirtual 74	com/quoord/tapatalkpro/bean/TapatalkForum:getId	()Ljava/lang/Integer;
        //   22: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   25: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   28: aconst_null
        //   29: aconst_null
        //   30: aconst_null
        //   31: ldc 93
        //   33: invokevirtual 97	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   36: astore_3
        //   37: new 226	android/content/ContentValues
        //   40: dup
        //   41: invokespecial 227	android/content/ContentValues:<init>	()V
        //   44: astore 4
        //   46: aload_1
        //   47: invokevirtual 231	com/quoord/tapatalkpro/bean/TapatalkForum:getUserIcon	()Landroid/graphics/Bitmap;
        //   50: ifnull +44 -> 94
        //   53: new 233	java/io/ByteArrayOutputStream
        //   56: dup
        //   57: invokespecial 234	java/io/ByteArrayOutputStream:<init>	()V
        //   60: astore 5
        //   62: aload_1
        //   63: invokevirtual 231	com/quoord/tapatalkpro/bean/TapatalkForum:getUserIcon	()Landroid/graphics/Bitmap;
        //   66: getstatic 240	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
        //   69: bipush 100
        //   71: aload 5
        //   73: invokevirtual 246	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   76: pop
        //   77: aload 4
        //   79: ldc 29
        //   81: aload 5
        //   83: invokevirtual 250	java/io/ByteArrayOutputStream:toByteArray	()[B
        //   86: invokevirtual 254	android/content/ContentValues:put	(Ljava/lang/String;[B)V
        //   89: aload_1
        //   90: aconst_null
        //   91: invokevirtual 187	com/quoord/tapatalkpro/bean/TapatalkForum:setUserIcon	(Landroid/graphics/Bitmap;)V
        //   94: new 233	java/io/ByteArrayOutputStream
        //   97: dup
        //   98: invokespecial 234	java/io/ByteArrayOutputStream:<init>	()V
        //   101: astore 5
        //   103: new 256	java/io/ObjectOutputStream
        //   106: dup
        //   107: new 258	java/io/BufferedOutputStream
        //   110: dup
        //   111: aload 5
        //   113: invokespecial 261	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   116: invokespecial 262	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   119: astore 6
        //   121: aload 6
        //   123: aload_1
        //   124: invokevirtual 266	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
        //   127: aload 6
        //   129: invokevirtual 267	java/io/ObjectOutputStream:close	()V
        //   132: aload 4
        //   134: ldc 17
        //   136: aload_1
        //   137: invokevirtual 270	com/quoord/tapatalkpro/bean/TapatalkForum:getName	()Ljava/lang/String;
        //   140: invokevirtual 273	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
        //   143: aload 4
        //   145: ldc 11
        //   147: aload_1
        //   148: invokevirtual 276	com/quoord/tapatalkpro/bean/TapatalkForum:getDescription	()Ljava/lang/String;
        //   151: invokevirtual 273	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
        //   154: aload 4
        //   156: ldc 14
        //   158: aload 5
        //   160: invokevirtual 250	java/io/ByteArrayOutputStream:toByteArray	()[B
        //   163: invokevirtual 254	android/content/ContentValues:put	(Ljava/lang/String;[B)V
        //   166: aload 4
        //   168: ldc 26
        //   170: aload_1
        //   171: invokevirtual 279	com/quoord/tapatalkpro/bean/TapatalkForum:getUrl	()Ljava/lang/String;
        //   174: invokevirtual 273	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
        //   177: aload_3
        //   178: invokeinterface 107 1 0
        //   183: ifle +66 -> 249
        //   186: aload_2
        //   187: ldc 23
        //   189: aload 4
        //   191: ldc 66
        //   193: iconst_1
        //   194: anewarray 68	java/lang/String
        //   197: dup
        //   198: iconst_0
        //   199: aload_1
        //   200: invokevirtual 74	com/quoord/tapatalkpro/bean/TapatalkForum:getId	()Ljava/lang/Integer;
        //   203: invokevirtual 80	java/lang/Integer:toString	()Ljava/lang/String;
        //   206: aastore
        //   207: invokevirtual 283	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
        //   210: pop
        //   211: aload 5
        //   213: invokevirtual 284	java/io/ByteArrayOutputStream:close	()V
        //   216: aload_3
        //   217: invokeinterface 138 1 0
        //   222: aload_2
        //   223: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
        //   226: return
        //   227: astore 6
        //   229: aload 6
        //   231: invokevirtual 285	java/io/IOException:printStackTrace	()V
        //   234: goto -102 -> 132
        //   237: astore_1
        //   238: aload_2
        //   239: ldc 8
        //   241: invokevirtual 62	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
        //   244: aload_2
        //   245: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
        //   248: return
        //   249: aload 4
        //   251: ldc 20
        //   253: aload_1
        //   254: invokevirtual 74	com/quoord/tapatalkpro/bean/TapatalkForum:getId	()Ljava/lang/Integer;
        //   257: invokevirtual 288	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
        //   260: aload_2
        //   261: ldc 23
        //   263: ldc 20
        //   265: aload 4
        //   267: invokevirtual 292	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
        //   270: pop2
        //   271: goto -60 -> 211
        //   274: astore_1
        //   275: aload_1
        //   276: invokevirtual 285	java/io/IOException:printStackTrace	()V
        //   279: goto -63 -> 216
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	282	0	this	FeedForumHelper
        //   0	282	1	paramTapatalkForum	TapatalkForum
        //   4	257	2	localSQLiteDatabase	SQLiteDatabase
        //   36	181	3	localCursor	Cursor
        //   44	222	4	localContentValues	ContentValues
        //   60	152	5	localByteArrayOutputStream	ByteArrayOutputStream
        //   119	9	6	localObjectOutputStream	ObjectOutputStream
        //   227	3	6	localIOException	IOException
        // Exception table:
        //   from	to	target	type
        //   103	132	227	java/io/IOException
        //   5	94	237	java/lang/Exception
        //   94	103	237	java/lang/Exception
        //   103	132	237	java/lang/Exception
        //   132	211	237	java/lang/Exception
        //   211	216	237	java/lang/Exception
        //   216	226	237	java/lang/Exception
        //   229	234	237	java/lang/Exception
        //   249	271	237	java/lang/Exception
        //   275	279	237	java/lang/Exception
        //   211	216	274	java/io/IOException
    }

    public void saveFavoriateSequence(TapatalkForum paramTapatalkForum) {
        try {
            Cursor localCursor = this.mDb.query("feed", null, "id = " + paramTapatalkForum.getId(), null, null, null, "id DESC");
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
                    this.mDb.update("feed", localContentValues, "id = ?", new String[]{paramTapatalkForum});
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
                        this.mDb.insert("feed", "id", localContentValues);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/sqlhelper/FeedForumHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */