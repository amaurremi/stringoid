package com.everimaging.fotor.a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class a {
    private static final String a = a.class.getSimpleName();
    private static final LoggerFactory.c b = LoggerFactory.a(a, LoggerFactory.LoggerType.CONSOLE);

    public static int a(Context paramContext, Date paramDate) {
        ContentResolver localContentResolver = paramContext.getContentResolver();
        paramContext = com.everimaging.fotor.b.a.a(paramContext);
        paramDate = a(paramDate);
        paramContext = localContentResolver.query(paramContext, new String[]{" count(*) as count "}, "date > ? AND type = ?", new String[]{paramDate, "launch"}, null);
        if (paramContext != null) {
            if (paramContext.moveToFirst()) {
            }
            for (int i = paramContext.getInt(0); ; i = 0) {
                paramContext.close();
                return i;
            }
        }
        return 0;
    }

    private static String a() {
        return a(new Date(Calendar.getInstance().getTimeInMillis()));
    }

    private static String a(Date paramDate) {
        paramDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH).format(paramDate);
        b.c(new Object[]{"getCurrentTime:" + paramDate});
        return paramDate;
    }

    public static void a(Context paramContext) {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("type", "launch");
        localContentValues.put("date", a());
        paramContext = paramContext.getContentResolver().insert(com.everimaging.fotor.b.a.a(paramContext), localContentValues);
        b.c(new Object[]{"onSplash -> insertUri:" + paramContext});
    }

    public static void a(Context paramContext, String paramString) {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("type", "share");
        localContentValues.put("date", a());
        localContentValues.put("params", paramString);
        paramContext = paramContext.getContentResolver().insert(com.everimaging.fotor.b.a.a(paramContext), localContentValues);
        b.c(new Object[]{"onShare -> insertUri:" + paramContext});
    }

    public static int b(Context paramContext, Date paramDate) {
        ContentResolver localContentResolver = paramContext.getContentResolver();
        paramContext = com.everimaging.fotor.b.a.a(paramContext);
        paramDate = a(paramDate);
        paramContext = localContentResolver.query(paramContext, new String[]{" count(*) as count "}, "date > ? AND type = ?", new String[]{paramDate, "share"}, null);
        if (paramContext != null) {
            if (paramContext.moveToFirst()) {
            }
            for (int i = paramContext.getInt(0); ; i = 0) {
                paramContext.close();
                return i;
            }
        }
        return 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */