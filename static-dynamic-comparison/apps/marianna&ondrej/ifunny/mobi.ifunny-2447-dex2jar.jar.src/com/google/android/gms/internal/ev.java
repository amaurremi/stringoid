package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.c;

import java.util.Map;

@ii
public class ev {
    private final mz a;
    private final Map<String, String> b;
    private final Context c;
    private String d;
    private long e;
    private long f;
    private String g;
    private String h;

    public ev(mz parammz, Map<String, String> paramMap) {
        this.a = parammz;
        this.b = paramMap;
        this.c = parammz.k();
        c();
    }

    private String a(String paramString) {
        if (TextUtils.isEmpty((CharSequence) this.b.get(paramString))) {
            return "";
        }
        return (String) this.b.get(paramString);
    }

    private void c() {
        this.d = a("description");
        this.g = a("summary");
        this.e = lw.d((String) this.b.get("start"));
        this.f = lw.d((String) this.b.get("end"));
        this.h = a("location");
    }

    public void a() {
        if (!new br(this.c).f()) {
            mx.e("This feature is not available on this version of the device.");
            return;
        }
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.c);
        localBuilder.setTitle(lj.a(c.create_calendar_title, "Create calendar event"));
        localBuilder.setMessage(lj.a(c.create_calendar_message, "Allow Ad to create a calendar event?"));
        localBuilder.setPositiveButton(lj.a(c.accept, "Accept"), new ew(this));
        localBuilder.setNegativeButton(lj.a(c.decline, "Decline"), new ex(this));
        localBuilder.create().show();
    }

    Intent b() {
        Intent localIntent = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        localIntent.putExtra("title", this.g);
        localIntent.putExtra("eventLocation", this.h);
        localIntent.putExtra("description", this.d);
        localIntent.putExtra("beginTime", this.e);
        localIntent.putExtra("endTime", this.f);
        localIntent.setFlags(268435456);
        return localIntent;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */