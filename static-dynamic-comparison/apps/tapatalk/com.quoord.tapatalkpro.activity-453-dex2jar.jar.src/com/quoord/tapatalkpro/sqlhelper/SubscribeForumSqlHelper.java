package com.quoord.tapatalkpro.sqlhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.quoord.tapatalkpro.bean.Forum;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;

public class SubscribeForumSqlHelper
        extends SQLiteOpenHelper {
    public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS subscribeforum (id INTEGER PRIMARY KEY AUTOINCREMENT,forumid VARCHER,tapforumurl VARCHAR,name VARCHAR,subonly INTEGER,logourl VARCHAR,subforum BLOB)";
    public static final String FORUM_ID = "forumid";
    public static final String FORUM_NAME = "name";
    public static final String ID = "id";
    public static final String LOGO_URL = "logourl";
    public static final String SUB_FORUMS = "subforum";
    public static final String SUB_ONLY = "subonly";
    public static final String TAP_FORUM_URL = "tapforumurl";
    public static final String TB_NAME = "subscribeforum";

    public SubscribeForumSqlHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt) {
        super(paramContext, paramString, paramCursorFactory, paramInt);
    }

    public boolean delete(Forum paramForum, String paramString) {
        try {
            SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
            int i = localSQLiteDatabase.delete("subscribeforum", "forumid = ? AND tapforumurl = ?", new String[]{paramForum.getId().toString(), paramString});
            localSQLiteDatabase.close();
            return i != 0;
        } catch (Exception paramForum) {
        }
        return false;
    }

    public ArrayList<Forum> get(String paramString) {
        for (; ; ) {
            try {
                SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
                ArrayList localArrayList = new ArrayList();
                paramString = localSQLiteDatabase.query("subscribeforum", null, "tapforumurl like '%" + paramString + "%'", null, null, null, "id DESC");
                int i = paramString.getColumnIndexOrThrow("forumid");
                int j = paramString.getColumnIndexOrThrow("name");
                int k = paramString.getColumnIndexOrThrow("subonly");
                int m = paramString.getColumnIndexOrThrow("subforum");
                paramString.moveToFirst();
                if (paramString.isAfterLast()) {
                    paramString.close();
                    localSQLiteDatabase.close();
                    return localArrayList;
                }
                Forum localForum = new Forum();
                localForum.setId(paramString.getString(i));
                localForum.setName(paramString.getString(j));
                localForum.setSubscribe(true);
                localForum.setLogoURL(paramString.getString(paramString.getColumnIndex("logourl")));
                boolean bool;
                if (paramString.getInt(k) == 1) {
                    bool = true;
                    localForum.setSubOnly(bool);
                    byte[] arrayOfByte = paramString.getBlob(m);
                    if (arrayOfByte != null) {
                        int n = arrayOfByte.length;
                        if (n <= 0) {
                        }
                    }
                    try {
                        localForum.setChildForum((ArrayList) new DecompressibleInputStream(new ByteArrayInputStream(arrayOfByte)).readObject());
                        localArrayList.add(localForum);
                        paramString.moveToNext();
                    } catch (Exception localException) {
                        localException.printStackTrace();
                        continue;
                    }
                } else {
                    bool = false;
                }
            } catch (Exception paramString) {
                return null;
            }
        }
    }

    public ArrayList<String> getIds(String paramString) {
        try {
            SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
            ArrayList localArrayList = new ArrayList();
            paramString = localSQLiteDatabase.query("subscribeforum", null, "tapforumurl like '%" + paramString + "%'", null, null, null, "id DESC");
            int i = paramString.getColumnIndexOrThrow("forumid");
            paramString.moveToFirst();
            for (; ; ) {
                if (paramString.isAfterLast()) {
                    paramString.close();
                    localSQLiteDatabase.close();
                    return localArrayList;
                }
                localArrayList.add(paramString.getString(i));
                paramString.moveToNext();
            }
            return null;
        } catch (Exception paramString) {
        }
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS favorite (id INTEGER PRIMARY KEY,forum_name VARCHAR,description VARCHAR,url VARCHAR, extra BLOB,usericon BLOB);");
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS subscribeforum (id INTEGER PRIMARY KEY AUTOINCREMENT,forumid VARCHER,tapforumurl VARCHAR,name VARCHAR,subonly INTEGER,logourl VARCHAR,subforum BLOB)");
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS favorite (id INTEGER PRIMARY KEY,forum_name VARCHAR,description VARCHAR,url VARCHAR, extra BLOB,usericon BLOB);");
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS subscribeforum (id INTEGER PRIMARY KEY AUTOINCREMENT,forumid VARCHER,tapforumurl VARCHAR,name VARCHAR,subonly INTEGER,logourl VARCHAR,subforum BLOB)");
    }

    public void save(Forum paramForum, String paramString) {
        try {
            SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
            Cursor localCursor = localSQLiteDatabase.query("subscribeforum", null, "forumid = '" + paramForum.getId() + "' AND " + "tapforumurl" + " = '" + paramString + "'", null, null, null, "id DESC");
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("name", paramForum.getName());
            if (paramForum.isSubOnly()) {
            }
            for (int i = 1; ; i = 0) {
                localContentValues.put("subonly", Integer.valueOf(i));
                localContentValues.put("logourl", paramForum.getLogoURL());
                ByteArrayOutputStream localByteArrayOutputStream;
                if ((paramForum.getChildForums() != null) && (paramForum.getChildForums().size() > 0)) {
                    localByteArrayOutputStream = new ByteArrayOutputStream(1024);
                }
                try {
                    ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
                    localObjectOutputStream.writeObject(paramForum.getChildForums());
                    if (localObjectOutputStream != null) {
                        localObjectOutputStream.close();
                    }
                    if (localByteArrayOutputStream != null) {
                        localByteArrayOutputStream.close();
                    }
                } catch (IOException localIOException) {
                    for (; ; ) {
                        localIOException.printStackTrace();
                        continue;
                        localContentValues.put("forumid", paramForum.getId());
                        localContentValues.put("tapforumurl", paramString);
                        localSQLiteDatabase.insert("subscribeforum", null, localContentValues);
                    }
                }
                localContentValues.put("subforum", localByteArrayOutputStream.toByteArray());
                if (localCursor.getCount() > 0) {
                    localSQLiteDatabase.update("subscribeforum", localContentValues, "forumid = ? AND tapforumurl = ?", new String[]{paramForum.getId().toString(), paramString});
                    localCursor.close();
                    localSQLiteDatabase.close();
                    return;
                }
            }
            return;
        } catch (Exception paramForum) {
        }
    }

    public class DecompressibleInputStream
            extends ObjectInputStream {
        public DecompressibleInputStream(InputStream paramInputStream)
                throws IOException {
            super();
        }

        protected ObjectStreamClass readClassDescriptor()
                throws IOException, ClassNotFoundException {
            ObjectStreamClass localObjectStreamClass1 = super.readClassDescriptor();
            try {
                Object localObject = Class.forName(localObjectStreamClass1.getName());
                ObjectStreamClass localObjectStreamClass2 = ObjectStreamClass.lookup((Class) localObject);
                localObject = localObjectStreamClass1;
                if (localObjectStreamClass2 != null) {
                    long l1 = localObjectStreamClass2.getSerialVersionUID();
                    long l2 = localObjectStreamClass1.getSerialVersionUID();
                    localObject = localObjectStreamClass1;
                    if (l2 != l1) {
                        localObject = new StringBuffer("Overriding serialized class version mismatch: ");
                        ((StringBuffer) localObject).append("local serialVersionUID = ").append(l1);
                        ((StringBuffer) localObject).append(" stream serialVersionUID = ").append(l2);
                        new InvalidClassException(((StringBuffer) localObject).toString());
                        localObject = localObjectStreamClass2;
                    }
                }
                return (ObjectStreamClass) localObject;
            } catch (ClassNotFoundException localClassNotFoundException) {
            }
            return localObjectStreamClass1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/sqlhelper/SubscribeForumSqlHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */