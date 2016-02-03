package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;

import java.util.ArrayList;

public final class bi
        implements ax {
    private ArrayList<as> a = new ArrayList();
    private int b = 1;
    private PendingIntent c;
    private ArrayList<Notification> d = new ArrayList();
    private Bitmap e;
    private int f;
    private int g = 8388613;
    private int h = -1;
    private int i = 0;
    private int j;
    private int k = 80;

    private void a(int paramInt, boolean paramBoolean) {
        if (paramBoolean) {
            this.b |= paramInt;
            return;
        }
        this.b &= (paramInt ^ 0xFFFFFFFF);
    }

    public aw a(aw paramaw) {
        Bundle localBundle = new Bundle();
        if (!this.a.isEmpty()) {
            localBundle.putParcelableArrayList("actions", ar.a().a((as[]) this.a.toArray(new as[this.a.size()])));
        }
        if (this.b != 1) {
            localBundle.putInt("flags", this.b);
        }
        if (this.c != null) {
            localBundle.putParcelable("displayIntent", this.c);
        }
        if (!this.d.isEmpty()) {
            localBundle.putParcelableArray("pages", (Parcelable[]) this.d.toArray(new Notification[this.d.size()]));
        }
        if (this.e != null) {
            localBundle.putParcelable("background", this.e);
        }
        if (this.f != 0) {
            localBundle.putInt("contentIcon", this.f);
        }
        if (this.g != 8388613) {
            localBundle.putInt("contentIconGravity", this.g);
        }
        if (this.h != -1) {
            localBundle.putInt("contentActionIndex", this.h);
        }
        if (this.i != 0) {
            localBundle.putInt("customSizePreset", this.i);
        }
        if (this.j != 0) {
            localBundle.putInt("customContentHeight", this.j);
        }
        if (this.k != 80) {
            localBundle.putInt("gravity", this.k);
        }
        paramaw.a().putBundle("android.wearable.EXTENSIONS", localBundle);
        return paramaw;
    }

    public bi a() {
        bi localbi = new bi();
        localbi.a = new ArrayList(this.a);
        localbi.b = this.b;
        localbi.c = this.c;
        localbi.d = new ArrayList(this.d);
        localbi.e = this.e;
        localbi.f = this.f;
        localbi.g = this.g;
        localbi.h = this.h;
        localbi.i = this.i;
        localbi.j = this.j;
        localbi.k = this.k;
        return localbi;
    }

    public bi a(int paramInt) {
        this.i = paramInt;
        return this;
    }

    public bi a(Bitmap paramBitmap) {
        this.e = paramBitmap;
        return this;
    }

    public bi a(boolean paramBoolean) {
        a(2, paramBoolean);
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */