package com.everimaging.fotor.picture.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CollectionPicture
        implements Parcelable {
    public static final Parcelable.Creator<CollectionPicture> CREATOR = new Parcelable.Creator() {
        public CollectionPicture a(Parcel paramAnonymousParcel) {
            return new CollectionPicture(paramAnonymousParcel);
        }

        public CollectionPicture[] a(int paramAnonymousInt) {
            return new CollectionPicture[paramAnonymousInt];
        }
    };
    private int a;
    private long b;
    private String c;
    private String d;
    private double e = 0.0D;
    private double f = 0.0D;
    private String g;
    private String h;
    private String i;

    public CollectionPicture() {
    }

    public CollectionPicture(Parcel paramParcel) {
        this.a = paramParcel.readInt();
        this.b = paramParcel.readLong();
        this.c = paramParcel.readString();
        this.d = paramParcel.readString();
        this.e = paramParcel.readDouble();
        this.f = paramParcel.readDouble();
        this.g = paramParcel.readString();
        this.h = paramParcel.readString();
        this.i = paramParcel.readString();
    }

    public int a() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (paramObject == null) {
        }
        while ((!(paramObject instanceof CollectionPicture)) || (((CollectionPicture) paramObject).a() != this.a)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "pic id:" + a();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeInt(this.a);
        paramParcel.writeLong(this.b);
        paramParcel.writeString(this.c);
        paramParcel.writeString(this.d);
        paramParcel.writeDouble(this.e);
        paramParcel.writeDouble(this.f);
        paramParcel.writeString(this.g);
        paramParcel.writeString(this.h);
        paramParcel.writeString(this.i);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/picture/entity/CollectionPicture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */