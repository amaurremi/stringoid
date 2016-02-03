package com.everimaging.fotorsdk.imagepicker;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.MediaStore.Images.Media;

public class Picture
        implements Parcelable {
    public static final Parcelable.Creator<Picture> CREATOR = new Parcelable.Creator() {
        public Picture a(Parcel paramAnonymousParcel) {
            return new Picture(paramAnonymousParcel);
        }

        public Picture[] a(int paramAnonymousInt) {
            return new Picture[paramAnonymousInt];
        }
    };
    private String a;
    private String b;
    private String c;
    private int d;
    private String e;
    private int f;
    private int g;
    private int h;
    private int i;

    public Picture() {
    }

    public Picture(Parcel paramParcel) {
        this.a = paramParcel.readString();
        this.b = paramParcel.readString();
        this.d = paramParcel.readInt();
        this.c = paramParcel.readString();
        this.e = paramParcel.readString();
        this.f = paramParcel.readInt();
        this.g = paramParcel.readInt();
        this.h = paramParcel.readInt();
        this.i = paramParcel.readInt();
    }

    public String a() {
        return this.a;
    }

    public void a(int paramInt) {
        this.f = paramInt;
    }

    public void a(String paramString) {
        this.a = paramString;
    }

    public String b() {
        return this.b;
    }

    public void b(int paramInt) {
        this.g = paramInt;
    }

    public void b(String paramString) {
        this.b = paramString;
    }

    public String c() {
        return this.e;
    }

    public void c(int paramInt) {
        this.d = paramInt;
    }

    public void c(String paramString) {
        this.e = paramString;
    }

    public int d() {
        return this.f;
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.g;
    }

    public boolean equals(Object paramObject) {
        if ((paramObject == null) || (!(paramObject instanceof Picture))) {
        }
        while (((Picture) paramObject).f() != this.d) {
            return false;
        }
        return true;
    }

    public int f() {
        return this.d;
    }

    public Uri g() {
        return Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, String.valueOf(f()));
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.a);
        paramParcel.writeString(this.b);
        paramParcel.writeInt(this.d);
        paramParcel.writeString(this.c);
        paramParcel.writeString(this.e);
        paramParcel.writeInt(this.f);
        paramParcel.writeInt(this.g);
        paramParcel.writeInt(this.h);
        paramParcel.writeInt(this.i);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/imagepicker/Picture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */