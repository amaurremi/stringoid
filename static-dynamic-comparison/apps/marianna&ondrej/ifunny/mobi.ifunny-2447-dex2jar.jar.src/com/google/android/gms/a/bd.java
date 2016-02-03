package com.google.android.gms.a;

import com.google.android.gms.internal.pq;

import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

class bd
        extends TimerTask {
    private bd(az paramaz) {
    }

    public void run() {
        if ((az.b(this.a) == bc.b) && (az.e(this.a).isEmpty()) && (az.f(this.a) + az.g(this.a) < az.h(this.a).b())) {
            bt.c("Disconnecting due to inactivity");
            az.i(this.a);
            return;
        }
        az.j(this.a).schedule(new bd(this.a), az.g(this.a));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */