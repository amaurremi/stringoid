package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;

import java.util.ArrayList;

public class aw {
    Context a;
    CharSequence b;
    CharSequence c;
    PendingIntent d;
    PendingIntent e;
    RemoteViews f;
    Bitmap g;
    CharSequence h;
    int i;
    int j;
    boolean k;
    bh l;
    CharSequence m;
    int n;
    int o;
    boolean p;
    String q;
    boolean r;
    String s;
    ArrayList<as> t = new ArrayList();
    boolean u = false;
    Bundle v;
    Notification w = new Notification();

    public aw(Context paramContext) {
        this.a = paramContext;
        this.w.when = System.currentTimeMillis();
        this.w.audioStreamType = -1;
        this.j = 0;
    }

    private void a(int paramInt, boolean paramBoolean) {
        if (paramBoolean) {
            localNotification = this.w;
            localNotification.flags |= paramInt;
            return;
        }
        Notification localNotification = this.w;
        localNotification.flags &= (paramInt ^ 0xFFFFFFFF);
    }

    public Bundle a() {
        if (this.v == null) {
            this.v = new Bundle();
        }
        return this.v;
    }

    public aw a(int paramInt) {
        this.w.icon = paramInt;
        return this;
    }

    public aw a(int paramInt1, int paramInt2, boolean paramBoolean) {
        this.n = paramInt1;
        this.o = paramInt2;
        this.p = paramBoolean;
        return this;
    }

    public aw a(PendingIntent paramPendingIntent) {
        this.d = paramPendingIntent;
        return this;
    }

    public aw a(Bitmap paramBitmap) {
        this.g = paramBitmap;
        return this;
    }

    public aw a(ax paramax) {
        paramax.a(this);
        return this;
    }

    public aw a(bh parambh) {
        if (this.l != parambh) {
            this.l = parambh;
            if (this.l != null) {
                this.l.a(this);
            }
        }
        return this;
    }

    public aw a(CharSequence paramCharSequence) {
        this.b = paramCharSequence;
        return this;
    }

    public aw a(boolean paramBoolean) {
        a(2, paramBoolean);
        return this;
    }

    public Notification b() {
        return ar.a().a(this);
    }

    public aw b(CharSequence paramCharSequence) {
        this.c = paramCharSequence;
        return this;
    }

    public aw b(boolean paramBoolean) {
        a(8, paramBoolean);
        return this;
    }

    public aw c(CharSequence paramCharSequence) {
        this.w.tickerText = paramCharSequence;
        return this;
    }

    public aw c(boolean paramBoolean) {
        a(16, paramBoolean);
        return this;
    }

    public aw d(boolean paramBoolean) {
        this.u = paramBoolean;
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */