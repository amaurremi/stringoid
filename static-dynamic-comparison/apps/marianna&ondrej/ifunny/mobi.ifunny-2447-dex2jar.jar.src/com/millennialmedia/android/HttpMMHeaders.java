package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import java.io.Serializable;

import org.apache.http.Header;

class HttpMMHeaders
        implements Parcelable, Serializable {
    public static final Parcelable.Creator<HttpMMHeaders> CREATOR = new HttpMMHeaders
    .1();
    private static final String g = HttpMMHeaders.class.getName();
    static final long serialVersionUID = 3168621112125974L;
    boolean a;
    long b;
    String c;
    boolean d;
    boolean e;
    String f;

    public HttpMMHeaders(Parcel paramParcel) {
        try {
            boolean[] arrayOfBoolean = new boolean[3];
            paramParcel.readBooleanArray(arrayOfBoolean);
            this.a = arrayOfBoolean[0];
            this.d = arrayOfBoolean[1];
            this.e = arrayOfBoolean[2];
            this.c = paramParcel.readString();
            this.f = paramParcel.readString();
            this.b = paramParcel.readLong();
            return;
        } catch (Exception paramParcel) {
            MMLog.a(g, "Header serializing failed", paramParcel);
        }
    }

    public HttpMMHeaders(Header[] paramArrayOfHeader) {
        int j = paramArrayOfHeader.length;
        int i = 0;
        while (i < j) {
            Header localHeader = paramArrayOfHeader[i];
            a(localHeader);
            b(localHeader);
            c(localHeader);
            d(localHeader);
            e(localHeader);
            f(localHeader);
            i += 1;
        }
    }

    private void a(Header paramHeader) {
        if ("X-MM-TRANSPARENT".equalsIgnoreCase(paramHeader.getName())) {
            paramHeader = paramHeader.getValue();
            if (paramHeader != null) {
                this.a = Boolean.parseBoolean(paramHeader);
            }
        }
    }

    private void b(Header paramHeader) {
        if ("X-MM-TRANSITION".equalsIgnoreCase(paramHeader.getName())) {
            this.c = paramHeader.getValue();
        }
    }

    private void c(Header paramHeader) {
        if ("X-MM-TRANSITION-DURATION".equalsIgnoreCase(paramHeader.getName())) {
            paramHeader = paramHeader.getValue();
            if (paramHeader != null) {
                this.b = ((Float.parseFloat(paramHeader) * 1000.0F));
            }
        }
    }

    private void d(Header paramHeader) {
        if ("X-MM-USE-CUSTOM-CLOSE".equalsIgnoreCase(paramHeader.getName())) {
            this.d = Boolean.parseBoolean(paramHeader.getValue());
        }
    }

    private void e(Header paramHeader) {
        if ("X-MM-ENABLE-HARDWARE-ACCELERATION".equalsIgnoreCase(paramHeader.getName())) {
            this.e = Boolean.parseBoolean(paramHeader.getValue());
        }
    }

    private void f(Header paramHeader) {
        if ("X-MM-ACID".equalsIgnoreCase(paramHeader.getName())) {
            this.f = paramHeader.getValue();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeBooleanArray(new boolean[]{this.a, this.d, this.e});
        paramParcel.writeString(this.c);
        paramParcel.writeString(this.f);
        paramParcel.writeLong(this.b);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/HttpMMHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */