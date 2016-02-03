package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.millennialmedia.a.a.a.b;

class OverlaySettings
        implements Parcelable {
    public static final Parcelable.Creator<OverlaySettings> CREATOR = new OverlaySettings
    .1();
    boolean a;
    int b;
    String c = "";
    String d = "";
    int e;
    int f;
    boolean g;
    boolean h = true;
    String i = "";
    String j = "";
    HttpMMHeaders k;
    boolean l = false;
    boolean m;
    long n;
    private boolean o;
    @b(a = "transparent")
    private boolean p;
    @b(a = "transitionDuration")
    private long q;
    private String r = "";

    OverlaySettings() {
    }

    OverlaySettings(Parcel paramParcel) {
        try {
            boolean[] arrayOfBoolean = new boolean[6];
            paramParcel.readBooleanArray(arrayOfBoolean);
            this.a = arrayOfBoolean[0];
            this.p = arrayOfBoolean[1];
            this.o = arrayOfBoolean[2];
            this.g = arrayOfBoolean[3];
            this.m = arrayOfBoolean[4];
            this.h = arrayOfBoolean[5];
            this.b = paramParcel.readInt();
            this.r = paramParcel.readString();
            this.q = paramParcel.readLong();
            if (this.q < 0L) {
            }
            for (; ; ) {
                this.q = l1;
                this.c = paramParcel.readString();
                this.n = paramParcel.readLong();
                this.d = paramParcel.readString();
                this.e = paramParcel.readInt();
                this.f = paramParcel.readInt();
                this.i = paramParcel.readString();
                this.j = paramParcel.readString();
                this.k = ((HttpMMHeaders) paramParcel.readParcelable(HttpMMHeaders.class.getClassLoader()));
                return;
                l1 = this.q;
            }
            return;
        } catch (Exception paramParcel) {
            MMLog.a("OverlaySettings", "Exception Overlaysettings creationg from parcel: ", paramParcel);
        }
    }

    void a() {
        MMLog.a("OverlaySettings", toString());
    }

    void a(long paramLong) {
        this.q = paramLong;
    }

    void a(HttpMMHeaders paramHttpMMHeaders) {
        this.k = paramHttpMMHeaders;
    }

    void a(String paramString) {
        this.r = paramString;
    }

    void a(boolean paramBoolean) {
        this.o = paramBoolean;
    }

    void b(boolean paramBoolean) {
        this.p = paramBoolean;
    }

    boolean b() {
        return (!this.m) && (this.n != 0L);
    }

    boolean c() {
        return (this.m) && (this.n != 0L);
    }

    boolean d() {
        return (this.d != null) && (!this.d.equals(""));
    }

    public int describeContents() {
        return 0;
    }

    boolean e() {
        boolean bool = true;
        if (!this.l) {
            this.l = true;
            bool = false;
        }
        return bool;
    }

    long f() {
        long l1 = 0L;
        if (this.q > 0L) {
            l1 = this.q;
        }
        while (this.k == null) {
            return l1;
        }
        return this.k.b;
    }

    String g() {
        if (!TextUtils.isEmpty(this.r)) {
            return this.r;
        }
        if ((this.k != null) && (!TextUtils.isEmpty(this.k.c))) {
            return this.k.c;
        }
        return "none";
    }

    boolean h() {
        return (this.o) || ((this.k != null) && (this.k.d));
    }

    boolean i() {
        return (this.p) || ((this.k != null) && (this.k.a));
    }

    boolean j() {
        return (this.k != null) && (this.k.e);
    }

    public String toString() {
        return String.format("height %d width %d modal %b urlToLoad %s creatorAdImplId %s shouldResizeOverlay: %d transitionTime: %d overlayTransition: %s shouldMakeOverlayTransparent: %b shouldShowCustomClose: %b Orientation: %s", new Object[]{Integer.valueOf(this.e), Integer.valueOf(this.f), Boolean.valueOf(this.g), this.d, Long.valueOf(this.n), Integer.valueOf(this.b), Long.valueOf(this.q), this.r, Boolean.valueOf(this.p), Boolean.valueOf(this.o), this.c});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeBooleanArray(new boolean[]{this.a, this.p, this.o, this.g, this.m, this.h});
        paramParcel.writeInt(this.b);
        paramParcel.writeString(this.r);
        paramParcel.writeLong(this.q);
        paramParcel.writeString(this.c);
        paramParcel.writeLong(this.n);
        paramParcel.writeString(this.d);
        paramParcel.writeInt(this.e);
        paramParcel.writeInt(this.f);
        paramParcel.writeString(this.i);
        paramParcel.writeString(this.j);
        paramParcel.writeParcelable(this.k, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/OverlaySettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */