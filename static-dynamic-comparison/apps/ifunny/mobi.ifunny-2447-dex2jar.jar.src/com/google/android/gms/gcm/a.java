package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Messenger;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class a {
    static a a;
    final BlockingQueue<Intent> b = new LinkedBlockingQueue();
    private Context c;
    private PendingIntent d;
    private Handler e = new b(this, Looper.getMainLooper());
    private Messenger f = new Messenger(this.e);

    public static a a(Context paramContext) {
        try {
            if (a == null) {
                a = new a();
                a.c = paramContext;
            }
            paramContext = a;
            return paramContext;
        } finally {
        }
    }

    private void c(String... paramVarArgs) {
        paramVarArgs = b(paramVarArgs);
        Intent localIntent = new Intent("com.google.android.c2dm.intent.REGISTER");
        localIntent.setPackage("com.google.android.gms");
        localIntent.putExtra("google.messenger", this.f);
        b(localIntent);
        localIntent.putExtra("sender", paramVarArgs);
        this.c.startService(localIntent);
    }

    public String a(Intent paramIntent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(paramIntent.getAction())) {
            paramIntent = null;
        }
        String str;
        do {
            return paramIntent;
            str = paramIntent.getStringExtra("message_type");
            paramIntent = str;
        } while (str != null);
        return "gcm";
    }

    public String a(String... paramVarArgs) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        this.b.clear();
        c(paramVarArgs);
        try {
            paramVarArgs = (Intent) this.b.poll(5000L, TimeUnit.MILLISECONDS);
            if (paramVarArgs == null) {
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        } catch (InterruptedException paramVarArgs) {
            throw new IOException(paramVarArgs.getMessage());
        }
        String str = paramVarArgs.getStringExtra("registration_id");
        if (str != null) {
            return str;
        }
        paramVarArgs.getStringExtra("error");
        paramVarArgs = paramVarArgs.getStringExtra("error");
        if (paramVarArgs != null) {
            throw new IOException(paramVarArgs);
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    String b(String... paramVarArgs) {
        if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder localStringBuilder = new StringBuilder(paramVarArgs[0]);
        int i = 1;
        while (i < paramVarArgs.length) {
            localStringBuilder.append(',').append(paramVarArgs[i]);
            i += 1;
        }
        return localStringBuilder.toString();
    }

    void b(Intent paramIntent) {
        try {
            if (this.d == null) {
                Intent localIntent = new Intent();
                localIntent.setPackage("com.google.example.invalidpackage");
                this.d = PendingIntent.getBroadcast(this.c, 0, localIntent, 0);
            }
            paramIntent.putExtra("app", this.d);
            return;
        } finally {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/gcm/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */