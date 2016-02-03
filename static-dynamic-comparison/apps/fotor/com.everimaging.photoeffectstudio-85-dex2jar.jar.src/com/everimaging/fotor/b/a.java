package com.everimaging.fotor.b;

import android.content.Context;
import android.net.Uri;
import com.everimaging.fotor.provider.DBProvider;

import java.util.HashMap;
import java.util.Map;

public class a
        extends c {
    private static Uri b;
    private static final Map<String, String> c = new HashMap();

    public static final Uri a(Context paramContext) {
        if (b == null) {
            b = Uri.parse("content://" + DBProvider.a(paramContext) + "/" + "Analytics");
        }
        return b;
    }

    public static final Uri a(Context paramContext, long paramLong) {
        return Uri.parse(a(paramContext) + "/" + paramLong);
    }

    public String a() {
        return "Analytics";
    }

    protected Map<String, String> b() {
        c.put("_id", "integer primary key autoincrement  not null");
        c.put("date", "TEXT NOT NULL");
        c.put("type", "TEXT NOT NULL");
        c.put("params", "TEXT");
        return c;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */