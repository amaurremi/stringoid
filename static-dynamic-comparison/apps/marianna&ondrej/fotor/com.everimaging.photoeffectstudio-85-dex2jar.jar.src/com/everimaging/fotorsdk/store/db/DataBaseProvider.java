package com.everimaging.fotorsdk.store.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.PackageManagerUtils;

import java.util.HashMap;

public class DataBaseProvider
        extends ContentProvider {
    private static final String a = DataBaseProvider.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private static String c;
    private a d;
    private UriMatcher e;
    private HashMap<String, String> f;

    public static String a(Context paramContext) {
        if (c == null) {
            c = c(paramContext);
        }
        return c;
    }

    private void b(Context paramContext) {
        c = c(paramContext);
        this.e = new UriMatcher(-1);
        this.e.addURI(c, "purchased_packs", 1);
        this.e.addURI(c, "purchased_packs/#", 2);
        this.e.addURI(c, "purchased_packs/resource_id/#", 3);
        this.e.addURI(c, "purchased_packs/pack_type/*", 4);
        this.f = b.a();
    }

    private static String c(Context paramContext) {
        int i = 0;
        b.b(new Object[]{"####loadAuthority####"});
        String str = DataBaseProvider.class.getName();
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
        return paramContext.getPackageName() + "." + DataBaseProvider.class.getSimpleName();
    }

    public int delete(Uri paramUri, String paramString, String[] paramArrayOfString) {
        return 0;
    }

    public String getType(Uri paramUri) {
        return null;
    }

    public Uri insert(Uri paramUri, ContentValues paramContentValues) {
        Object localObject = null;
        SQLiteDatabase localSQLiteDatabase = this.d.getWritableDatabase();
        switch (this.e.match(paramUri)) {
            default:
                throw new IllegalStateException("This uri is invalid:" + paramUri);
        }
        paramUri = new ContentValues(paramContentValues);
        paramUri.put("purchase_date", Long.valueOf(System.currentTimeMillis()));
        long l = localSQLiteDatabase.insert("purchased_packs", null, paramUri);
        paramUri = (Uri) localObject;
        if (l > 0L) {
            paramUri = b.a(getContext(), l);
        }
        return paramUri;
    }

    public boolean onCreate() {
        b(getContext());
        this.d = new a(getContext());
        return this.d.getReadableDatabase() != null;
    }

    public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2) {
        SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
        switch (this.e.match(paramUri)) {
            case 2:
            default:
                throw new IllegalStateException("This uri is invalid:" + paramUri);
            case 1:
                localSQLiteQueryBuilder.setTables("purchased_packs");
                localSQLiteQueryBuilder.setProjectionMap(this.f);
        }
        for (; ; ) {
            return localSQLiteQueryBuilder.query(this.d.getReadableDatabase(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
            localSQLiteQueryBuilder.setTables("purchased_packs");
            localSQLiteQueryBuilder.setProjectionMap(this.f);
            localSQLiteQueryBuilder.appendWhere("resource_id=" + paramUri.getLastPathSegment());
            continue;
            localSQLiteQueryBuilder.setTables("purchased_packs");
            localSQLiteQueryBuilder.setProjectionMap(this.f);
            localSQLiteQueryBuilder.appendWhere("pack_type='" + paramUri.getLastPathSegment() + "'");
        }
    }

    public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString) {
        paramString = this.d.getWritableDatabase();
        switch (this.e.match(paramUri)) {
            default:
                throw new IllegalStateException("This uri is invalid:" + paramUri);
            case 2:
                return paramString.update("purchased_packs", paramContentValues, "id=?", new String[]{paramUri.getLastPathSegment()});
        }
        return paramString.update("purchased_packs", paramContentValues, "resource_id=?", new String[]{paramUri.getLastPathSegment()});
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/db/DataBaseProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */