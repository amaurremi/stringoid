package com.everimaging.fotorsdk.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.everimaging.fotorsdk.database.b;
import com.everimaging.fotorsdk.database.c;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.PackageManagerUtils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FotorContentProvider
        extends ContentProvider {
    private static final String a = FotorContentProvider.class.getSimpleName();
    private static FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private static String e;
    private b c;
    private UriMatcher d;
    private HashMap<String, String> f;
    private HashMap<String, String> g;

    private long a(String paramString) {
        SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
        localSQLiteQueryBuilder.setTables("sessions");
        localSQLiteQueryBuilder.appendWhere("session_id='" + paramString + "'");
        localSQLiteQueryBuilder.setProjectionMap(this.f);
        paramString = localSQLiteQueryBuilder.query(this.c.getReadableDatabase(), null, null, null, null, null, null);
        if (paramString != null) {
            if (paramString.moveToFirst()) {
            }
            for (long l = paramString.getLong(paramString.getColumnIndex("_id")); ; l = -1L) {
                paramString.close();
                return l;
            }
        }
        return -1L;
    }

    public static String a(Context paramContext) {
        if (e == null) {
            e = c(paramContext);
        }
        return e;
    }

    public static String a(String paramString1, String paramString2) {
        if (TextUtils.isEmpty(paramString1)) {
            return paramString2;
        }
        if (TextUtils.isEmpty(paramString2)) {
            return paramString1;
        }
        return "(" + paramString1 + ") AND (" + paramString2 + ")";
    }

    private void a() {
        Object localObject = getContext();
        if (localObject != null) {
            localObject = new File(((Context) localObject).getExternalCacheDir(), "FotorSDK_WS");
            if ((((File) localObject).exists()) && (((File) localObject).isDirectory())) {
                localObject = new File((File) localObject, "mosaic");
                if ((((File) localObject).exists()) && (((File) localObject).isDirectory())) {
                    String[] arrayOfString = ((File) localObject).list();
                    if (arrayOfString != null) {
                        int j = arrayOfString.length;
                        int i = 0;
                        while (i < j) {
                            File localFile = new File((File) localObject, arrayOfString[i]);
                            if (localFile.exists()) {
                                localFile.delete();
                            }
                            i += 1;
                        }
                    }
                }
            }
        }
    }

    private void b(Context paramContext) {
        e = c(paramContext);
        if (e == null) {
            b.e(new Object[]{"The ContentProvider AUTHORITY is null! Checkout your AndroidManifest.xml"});
            throw new IllegalStateException("Failed to retrieve the 'authorities' from the AndroidManifest");
        }
        this.d = new UriMatcher(-1);
        this.d.addURI(e, "sessions", 1);
        this.d.addURI(e, "sessions/#", 2);
        this.d.addURI(e, "sessions/fsid/*", 3);
        this.d.addURI(e, "sessions/fsid/*/actions", 4);
        this.d.addURI(e, "sessions/fsid/*/actions/#", 5);
        this.f = new HashMap();
        this.f.put("_id", "sessions._id");
        this.f.put("session_id", "sessions.session_id");
        this.f.put("creation_time", "sessions.creation_time");
        this.f.put("file_path", "sessions.file_path");
        this.g = new HashMap();
        this.g.put("_id", "actions._id");
        this.g.put("session_id", "actions.session_id");
        this.g.put("creation_time", "actions.creation_time");
        this.g.put("params", "actions.params");
    }

    private static String c(Context paramContext) {
        int i = 0;
        b.b(new Object[]{"####loadAuthority####"});
        String str = FotorContentProvider.class.getName();
        Object localObject1 = PackageManagerUtils.getPackageInfo(paramContext, 8);
        if (localObject1 != null) {
            localObject1 = ((PackageInfo) localObject1).providers;
            if (localObject1 != null) {
                int j = localObject1.length;
                while (i < j) {
                    Object localObject2 = localObject1[i];
                    if (str.equals(((ProviderInfo) localObject2).name)) {
                        return ((ProviderInfo) localObject2).authority;
                    }
                    i += 1;
                }
            }
        }
        return paramContext.getPackageName() + "." + FotorContentProvider.class.getSimpleName();
    }

    public int delete(Uri paramUri, String paramString, String[] paramArrayOfString) {
        b.c(new Object[]{"delete->uri:" + paramUri + ",selection:" + paramString + ",args:" + paramArrayOfString});
        int i = this.d.match(paramUri);
        SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
        Object localObject;
        switch (i) {
            default:
                throw new IllegalStateException("Un supoort uri:" + paramUri);
            case 3:
                localObject = paramUri.getLastPathSegment();
        }
        for (i = localSQLiteDatabase.delete("sessions", a("session_id='" + (String) localObject + "'", paramString), paramArrayOfString); ; i = localSQLiteDatabase.delete("actions", a("_id=" + (String) localObject, paramString), paramArrayOfString)) {
            getContext().getContentResolver().notifyChange(paramUri, null);
            a();
            return i;
            localObject = paramUri.getPathSegments();
            if ((localObject == null) || (((List) localObject).size() < 2)) {
                break;
            }
            localObject = (String) ((List) localObject).get(((List) localObject).size() - 2);
            localSQLiteDatabase.delete("actions", a("session_id='" + (String) localObject + "'", paramString), paramArrayOfString);
            localObject = paramUri.getLastPathSegment();
        }
        throw new IllegalStateException("the uri segments not container fsid");
    }

    public String getType(Uri paramUri) {
        return null;
    }

    public Uri insert(Uri paramUri, ContentValues paramContentValues) {
        b.c(new Object[]{"insert->uri:" + paramUri});
        int i = this.d.match(paramUri);
        SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
        switch (i) {
            default:
                throw new IllegalStateException("Un support uri:" + paramUri);
            case 3:
                paramContentValues = new ContentValues(paramContentValues);
                paramUri = paramUri.getLastPathSegment();
                paramContentValues.put("session_id", paramUri);
                paramContentValues.put("creation_time", Long.valueOf(System.currentTimeMillis()));
        }
        for (; ; ) {
            try {
                l = localSQLiteDatabase.insertOrThrow("sessions", null, paramContentValues);
                paramUri = SessionColumns.getContentUri(getContext(), l);
                if (l > 0L) {
                    getContext().getContentResolver().notifyChange(paramUri, null);
                }
                return paramUri;
            } catch (SQLiteException paramContentValues) {
                b.e(new Object[]{"session id" + paramUri + " exsits"});
                l = a(paramUri);
                continue;
            }
            paramUri = paramUri.getPathSegments();
            if ((paramUri == null) || (paramUri.size() < 2)) {
                break;
            }
            paramUri = (String) paramUri.get(paramUri.size() - 2);
            if (a(paramUri) <= 0L) {
                throw new IllegalStateException("fotor session id not exists,");
            }
            paramContentValues = new ContentValues(paramContentValues);
            paramContentValues.put("session_id", paramUri);
            paramContentValues.put("creation_time", Long.valueOf(System.currentTimeMillis()));
            long l = localSQLiteDatabase.insert("actions", null, paramContentValues);
            paramUri = ActionsColumns.getContentUri(getContext(), paramUri, l);
        }
        throw new IllegalStateException("the uri segments not container fsid");
    }

    public boolean onCreate() {
        b(getContext());
        this.c = new b(getContext());
        return this.c.getReadableDatabase() != null;
    }

    public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2) {
        b.c(new Object[]{"query->uri:" + paramUri + ",projection:" + paramArrayOfString1});
        SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
        int i = this.d.match(paramUri);
        switch (i) {
            default:
                throw new IllegalStateException("This uri is invalid:" + paramUri);
            case 1:
                localSQLiteQueryBuilder.setTables("sessions");
                localSQLiteQueryBuilder.setProjectionMap(this.f);
        }
        for (; ; ) {
            paramArrayOfString1 = localSQLiteQueryBuilder.query(this.c.getReadableDatabase(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
            paramArrayOfString1.setNotificationUri(getContext().getContentResolver(), paramUri);
            return paramArrayOfString1;
            localSQLiteQueryBuilder.setTables("sessions");
            localSQLiteQueryBuilder.setProjectionMap(this.f);
            localSQLiteQueryBuilder.appendWhere("_id=" + paramUri.getLastPathSegment());
            continue;
            localSQLiteQueryBuilder.setTables("sessions");
            localSQLiteQueryBuilder.setProjectionMap(this.f);
            localSQLiteQueryBuilder.appendWhere("session_id='" + paramUri.getLastPathSegment() + "'");
            continue;
            localSQLiteQueryBuilder.setTables("sessions,actions");
            localSQLiteQueryBuilder.setProjectionMap(this.g);
            paramString2 = paramUri.getPathSegments();
            if ((paramString2 == null) || (paramString2.size() < 2)) {
                break;
            }
            localSQLiteQueryBuilder.appendWhere(String.format("%s.%s='%s' AND %s.%s=%s.%s", new Object[]{"sessions", "session_id", (String) paramString2.get(paramString2.size() - 2), "sessions", "session_id", "actions", "session_id"}));
            if (i == 5) {
                localSQLiteQueryBuilder.appendWhere("_id=" + paramUri.getLastPathSegment());
            }
            paramString2 = String.format("%s.%s ASC", new Object[]{"actions", "creation_time"});
        }
        throw new IllegalStateException("the uri segments not container fsid");
    }

    public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString) {
        b.c(new Object[]{"update-> uri:" + paramUri + ",valus"});
        b.e(new Object[]{"update not be supported ."});
        return 0;
    }

    public static class ActionsColumns
            extends c {
        private static final String CREATION_TIME = "creation_time";
        public static final String PARAMS = "params";
        public static final String PATH_SESSION_ACTIONS = "sessions/fsid/*/actions";
        public static final String PATH_SESSION_ACTION_ID = "sessions/fsid/*/actions/#";
        public static final String SESSION_ID = "session_id";
        private static final Map<String, String> TABLE_CREATER_MAP = new HashMap();
        public static final String TABLE_NAME = "actions";
        private static Uri mBaseContentUri;

        private static Uri getContentBaseUri(Context paramContext) {
            if (mBaseContentUri == null) {
                mBaseContentUri = FotorContentProvider.SessionColumns.getContentUri(paramContext);
            }
            return mBaseContentUri;
        }

        public static Uri getContentUri(Context paramContext, String paramString) {
            return Uri.parse(getContentBaseUri(paramContext) + "/fsid/" + paramString + "/" + "actions");
        }

        public static Uri getContentUri(Context paramContext, String paramString, long paramLong) {
            return Uri.parse(getContentBaseUri(paramContext) + "/fsid/" + paramString + "/" + "actions" + "/" + paramLong);
        }

        protected Map<String, String> getTableMap() {
            TABLE_CREATER_MAP.put("_id", "integer primary key autoincrement  not null");
            TABLE_CREATER_MAP.put("session_id", "TEXT REFERENCES " + "sessions(session_id)" + " NOT NULL");
            TABLE_CREATER_MAP.put("creation_time", "INTEGER NOT NULL");
            TABLE_CREATER_MAP.put("params", "TEXT NOT NULL");
            return TABLE_CREATER_MAP;
        }

        public String getTableName() {
            return "actions";
        }

        public static class Action {
            public long creation_time;
            public int id;
            public String params;
            public String session_id;

            public static Action create(Cursor paramCursor) {
                if (paramCursor != null) {
                    Action localAction = new Action();
                    localAction.id = paramCursor.getInt(paramCursor.getColumnIndex("_id"));
                    localAction.session_id = paramCursor.getString(paramCursor.getColumnIndex("session_id"));
                    localAction.creation_time = paramCursor.getLong(paramCursor.getColumnIndex("creation_time"));
                    localAction.params = paramCursor.getString(paramCursor.getColumnIndex("params"));
                    return localAction;
                }
                return null;
            }

            public String toString() {
                return "Action[id:" + this.id + ",session_id:" + this.session_id + ",params:" + this.params + "]";
            }
        }
    }

    public static class SessionColumns
            extends c {
        private static final String CREATION_TIME = "creation_time";
        public static final String FILE_PATH = "file_path";
        public static final String PATH_SESSION = "sessions";
        public static final String PATH_SESSION_FSID = "sessions/fsid/*";
        public static final String PATH_SESSION_FSID_STR = "/fsid/";
        public static final String PATH_SESSION_ID = "sessions/#";
        public static final String SESSION_ID = "session_id";
        private static final Map<String, String> TABLE_CREATER_MAP = new HashMap();
        public static final String TABLE_NAME = "sessions";
        private static Uri mBaseContentUri;

        public static Uri getContentUri(Context paramContext) {
            if (mBaseContentUri == null) {
                mBaseContentUri = Uri.parse("content://" + FotorContentProvider.a(paramContext) + "/" + "sessions");
            }
            return mBaseContentUri;
        }

        public static Uri getContentUri(Context paramContext, long paramLong) {
            return Uri.parse(getContentUri(paramContext) + "/" + paramLong);
        }

        public static Uri getContentUri(Context paramContext, String paramString) {
            return Uri.parse(getContentUri(paramContext) + "/fsid/" + paramString);
        }

        protected Map<String, String> getTableMap() {
            TABLE_CREATER_MAP.put("_id", "integer primary key autoincrement  not null");
            TABLE_CREATER_MAP.put("session_id", "TEXT UNIQUE NOT NULL");
            TABLE_CREATER_MAP.put("creation_time", "INTEGER NOT NULL");
            TABLE_CREATER_MAP.put("file_path", "TEXT");
            return TABLE_CREATER_MAP;
        }

        public String getTableName() {
            return "sessions";
        }

        public static class Session {
            public long creation_time;
            public String file_name;
            public int id;
            public String session_id;

            public static Session create(Cursor paramCursor) {
                if (paramCursor != null) {
                    if (paramCursor.moveToFirst()) {
                        Session localSession = new Session();
                        localSession.id = paramCursor.getInt(paramCursor.getColumnIndex("_id"));
                        localSession.session_id = paramCursor.getString(paramCursor.getColumnIndex("session_id"));
                        localSession.creation_time = paramCursor.getLong(paramCursor.getColumnIndex("creation_time"));
                        localSession.file_name = paramCursor.getString(paramCursor.getColumnIndex("file_path"));
                        return localSession;
                    }
                    paramCursor.close();
                }
                return null;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/provider/FotorContentProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */