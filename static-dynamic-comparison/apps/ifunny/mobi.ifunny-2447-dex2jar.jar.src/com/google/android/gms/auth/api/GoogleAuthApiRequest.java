package com.google.android.gms.auth.api;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.List;

public class GoogleAuthApiRequest
        implements SafeParcelable {
    public static final a CREATOR = new a();
    final int a;
    String b;
    String c;
    String d;
    String e;
    Bundle f;
    String g;
    List<String> h;
    String i;
    int j;
    Bundle k;
    byte[] l;
    long m;

    GoogleAuthApiRequest(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle1, String paramString5, List<String> paramList, String paramString6, int paramInt2, Bundle paramBundle2, byte[] paramArrayOfByte, long paramLong) {
        this.a = paramInt1;
        this.b = paramString1;
        this.c = paramString2;
        this.d = paramString3;
        this.e = paramString4;
        this.f = paramBundle1;
        this.g = paramString5;
        this.h = paramList;
        this.i = paramString6;
        this.j = paramInt2;
        this.k = paramBundle2;
        this.l = paramArrayOfByte;
        this.m = paramLong;
    }

    public String a() {
        return this.g;
    }

    public String b() {
        if (this.h.size() == 0) {
            return null;
        }
        StringBuffer localStringBuffer = new StringBuffer();
        int n = 0;
        while (n < this.h.size()) {
            localStringBuffer.append((String) this.h.get(n));
            if (n != this.h.size() - 1) {
                localStringBuffer.append(" ");
            }
            n += 1;
        }
        return localStringBuffer.toString();
    }

    public String c() {
        String str = b();
        if (str == null) {
            return null;
        }
        return this.i + str;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "{ API: " + this.b + "/" + this.c + ", Scope: " + c() + ", Account: " + a() + " }";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/auth/api/GoogleAuthApiRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */