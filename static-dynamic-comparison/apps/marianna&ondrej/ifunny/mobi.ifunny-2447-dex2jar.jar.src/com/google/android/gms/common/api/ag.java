package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.a.l;
import com.google.android.gms.common.a;

class ag
        extends l<a>
        implements m, n {
    public final k a;
    private boolean b;
    private a c;

    public ag(Context paramContext, k paramk) {
        super(paramContext);
        this.a = paramk;
    }

    private void b(a parama) {
        this.c = parama;
        if ((isStarted()) && (!isAbandoned())) {
            deliverResult(parama);
        }
    }

    public void a() {
        if (this.b) {
            this.b = false;
            if ((isStarted()) && (!isAbandoned())) {
                this.a.a();
            }
        }
    }

    public void a(int paramInt) {
    }

    public void a(Bundle paramBundle) {
        this.b = false;
        b(a.a);
    }

    public void a(a parama) {
        this.b = true;
        b(parama);
    }

    protected void onReset() {
        this.c = null;
        this.b = false;
        this.a.b(this);
        this.a.b(this);
        this.a.b();
    }

    protected void onStartLoading() {
        super.onStartLoading();
        this.a.a(this);
        this.a.a(this);
        if (this.c != null) {
            deliverResult(this.c);
        }
        if ((!this.a.c()) && (!this.a.d()) && (!this.b)) {
            this.a.a();
        }
    }

    protected void onStopLoading() {
        this.a.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/api/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */