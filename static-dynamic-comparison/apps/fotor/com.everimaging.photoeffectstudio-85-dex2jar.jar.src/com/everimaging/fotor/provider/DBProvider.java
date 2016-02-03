package com.everimaging.fotor.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.everimaging.fotor.b.a;
import com.everimaging.fotor.b.b;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;
import com.everimaging.fotorsdk.utils.PackageManagerUtils;

public class DBProvider
        extends ContentProvider {
    private static final String a = DBProvider.class.getSimpleName();
    private static final LoggerFactory.c b = LoggerFactory.a(a, LoggerFactory.LoggerType.CONSOLE);
    private static String c;
    private b d = null;
    private UriMatcher e;

    public static String a(Context paramContext) {
        if (c == null) {
            c = c(paramContext);
        }
        return c;
    }

    private void b(Context paramContext) {
        c = c(paramContext);
        if (c == null) {
            b.e(new Object[]{"The ContentProvider AUTHORITY is null! Checkout your AndroidManifest.xml"});
            throw new IllegalStateException("Failed to retrieve the 'authorities' from the AndroidManifest");
        }
        this.e = new UriMatcher(-1);
        this.e.addURI(c, "Analytics", 1);
        this.e.addURI(c, "Analytics/#", 2);
    }

    private static String c(Context paramContext) {
        int i = 0;
        b.b(new Object[]{"####loadAuthority####"});
        String str = DBProvider.class.getName();
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
        return paramContext.getPackageName() + "." + DBProvider.class.getSimpleName();
    }

    public int delete(Uri paramUri, String paramString, String[] paramArrayOfString) {
        SQLiteDatabase localSQLiteDatabase = this.d.getWritableDatabase();
        switch (this.e.match(paramUri)) {
            default:
                throw new IllegalArgumentException("Unknown URI " + paramUri);
        }
        int i = localSQLiteDatabase.delete("Analytics", paramString, paramArrayOfString);
        getContext().getContentResolver().notifyChange(paramUri, null);
        return i;
    }

    public String getType(Uri paramUri) {
        return null;
    }

    public Uri insert(Uri paramUri, ContentValues paramContentValues) {
        if (paramContentValues != null) {
        }
        SQLiteDatabase localSQLiteDatabase;
        for (paramContentValues = new ContentValues(paramContentValues); ; paramContentValues = new ContentValues()) {
            localSQLiteDatabase = this.d.getWritableDatabase();
            switch (this.e.match(paramUri)) {
                default:
                    throw new IllegalArgumentException("Unknown URI " + paramUri);
            }
        }
        long l = localSQLiteDatabase.insert("Analytics", null, paramContentValues);
        paramUri = a.a(getContext(), l);
        if (l > 0L) {
            paramUri = ContentUris.withAppendedId(paramUri, l);
            getContext().getContentResolver().notifyChange(paramUri, null);
            return paramUri;
        }
        return null;
    }

    public boolean onCreate() {
        b(getContext());
        this.d = new b(getContext());
        return this.d.getReadableDatabase() != null;
    }

    public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2) {
        SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
        switch (this.e.match(paramUri)) {
            default:
                throw new IllegalArgumentException("Unknown URI " + paramUri);
        }
        localSQLiteQueryBuilder.setTables("Analytics");
        paramArrayOfString1 = localSQLiteQueryBuilder.query(this.d.getReadableDatabase(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
        paramArrayOfString1.setNotificationUri(getContext().getContentResolver(), paramUri);
        return paramArrayOfString1;
    }

    public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString) {
        SQLiteDatabase localSQLiteDatabase = this.d.getWritableDatabase();
        switch (this.e.match(paramUri)) {
            default:
                throw new IllegalArgumentException("Unknown URI " + paramUri);
        }
        int i = localSQLiteDatabase.update("Analytics", paramContentValues, paramString, paramArrayOfString);
        getContext().getContentResolver().notifyChange(paramUri, null);
        return i;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/provider/DBProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */