package com.everimaging.fotor.picture.entity;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PictureInfo
        implements Parcelable {
    public static final Parcelable.Creator<PictureInfo> CREATOR = new Parcelable.Creator() {
        public PictureInfo a(Parcel paramAnonymousParcel) {
            return new PictureInfo(paramAnonymousParcel);
        }

        public PictureInfo[] a(int paramAnonymousInt) {
            return new PictureInfo[paramAnonymousInt];
        }
    };
    private String a;
    private Bitmap b;
    private int c;
    private boolean d;
    private String e;
    private boolean f = false;
    private String g;
    private int h;
    private int i;
    private double j;
    private double k;

    public PictureInfo() {
    }

    public PictureInfo(Parcel paramParcel) {
        this.a = paramParcel.readString();
        this.c = paramParcel.readInt();
        this.e = paramParcel.readString();
        this.i = paramParcel.readInt();
        this.h = paramParcel.readInt();
        this.j = paramParcel.readDouble();
        this.k = paramParcel.readDouble();
        this.g = paramParcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "path:" + this.a + ",sharePath:" + this.e + ",thumbnail:" + this.b + ",shareThumbnailPath:" + this.g + ",isSaved:" + this.d + ",orientation:" + this.c;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.a);
        paramParcel.writeInt(this.c);
        paramParcel.writeString(this.e);
        paramParcel.writeInt(this.i);
        paramParcel.writeInt(this.i);
        paramParcel.writeDouble(this.j);
        paramParcel.writeDouble(this.k);
        paramParcel.writeString(this.g);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/picture/entity/PictureInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */