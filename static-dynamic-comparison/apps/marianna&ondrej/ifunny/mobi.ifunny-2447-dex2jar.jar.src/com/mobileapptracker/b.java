package com.mobileapptracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.concurrent.Semaphore;

public class b {
    private SharedPreferences a;
    private Semaphore b;
    private g c;

    public b(Context paramContext, g paramg) {
        this.a = paramContext.getSharedPreferences("mat_queue", 0);
        this.b = new Semaphore(1, true);
        this.c = paramg;
    }

    protected int a() {
        try {
            int i = this.a.getInt("queuesize", 0);
            return i;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    protected void a(int paramInt) {
        try {
            SharedPreferences.Editor localEditor = this.a.edit();
            int i = paramInt;
            if (paramInt < 0) {
                i = 0;
            }
            localEditor.putInt("queuesize", i);
            localEditor.commit();
            return;
        } finally {
        }
    }

    protected void a(String paramString) {
        try {
            a(a() - 1);
            SharedPreferences.Editor localEditor = this.a.edit();
            localEditor.remove(paramString);
            localEditor.commit();
            return;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mobileapptracker/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */