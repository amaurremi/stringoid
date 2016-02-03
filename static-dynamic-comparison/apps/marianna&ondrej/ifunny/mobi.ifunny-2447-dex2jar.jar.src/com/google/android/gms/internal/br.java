package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import com.google.android.gms.common.internal.ag;

import java.util.List;

@ii
public class br {
    private final Context a;

    public br(Context paramContext) {
        ag.a(paramContext, "Context can not be null");
        this.a = paramContext;
    }

    public static boolean e() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public boolean a() {
        Intent localIntent = new Intent("android.intent.action.DIAL");
        localIntent.setData(Uri.parse("tel:"));
        return a(localIntent);
    }

    public boolean a(Intent paramIntent) {
        boolean bool = false;
        ag.a(paramIntent, "Intent can not be null");
        if (!this.a.getPackageManager().queryIntentActivities(paramIntent, 0).isEmpty()) {
            bool = true;
        }
        return bool;
    }

    public boolean b() {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(Uri.parse("sms:"));
        return a(localIntent);
    }

    public boolean c() {
        return (e()) && (this.a.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0);
    }

    public boolean d() {
        return false;
    }

    public boolean f() {
        Intent localIntent = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event");
        return (Build.VERSION.SDK_INT >= 14) && (a(localIntent));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */