package com.millennialmedia.android;

import android.content.Context;
import android.os.Parcel;

import java.io.Externalizable;
import java.io.File;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

abstract class CachedAd
        implements Externalizable {
    static final long serialVersionUID = 316862728709355974L;
    String a;
    Date b;
    long c;
    String d;
    int e;
    boolean f = false;
    private String g;

    CachedAd() {
        this.c = System.currentTimeMillis();
    }

    protected CachedAd(Parcel paramParcel) {
        try {
            this.g = paramParcel.readString();
            this.a = paramParcel.readString();
            this.b = ((Date) paramParcel.readSerializable());
            this.c = paramParcel.readLong();
            boolean[] arrayOfBoolean = new boolean[1];
            paramParcel.readBooleanArray(arrayOfBoolean);
            this.f = arrayOfBoolean[0];
            this.d = paramParcel.readString();
            this.e = paramParcel.readInt();
            return;
        } catch (Exception paramParcel) {
            paramParcel.printStackTrace();
        }
    }

    static CachedAd a(String paramString) {
        int i;
        int j;
        int k;
        if (MMSDK.a >= 5) {
            MMLog.a("CachedAd", "Received cached ad.");
            int m = paramString.length();
            if (m <= 1000) {
                break label97;
            }
            i = 999;
            j = 0;
            if (i >= m) {
                break label117;
            }
            MMLog.a("CachedAd", paramString.substring(j, i));
            j = i + 1000;
            if (j <= m) {
                break label108;
            }
            k = m - 1;
            j = i;
        }
        for (; ; ) {
            MMLog.a("CachedAd", paramString.substring(j, k));
            while (paramString.length() > 0) {
                return new VideoAd(paramString);
                label97:
                MMLog.a("CachedAd", paramString);
            }
            return null;
            label108:
            k = i;
            i = j;
            j = k;
            break;
            label117:
            k = i;
        }
    }

    abstract void a(Context paramContext, long paramLong);

    protected void a(JSONObject paramJSONObject) {
        this.g = paramJSONObject.optString("id", null);
        this.a = paramJSONObject.optString("vid", null);
        this.d = paramJSONObject.optString("content-url", null);
        paramJSONObject = paramJSONObject.optString("expiration", null);
        SimpleDateFormat localSimpleDateFormat;
        if (paramJSONObject != null) {
            localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ZZZZ");
        }
        try {
            this.b = localSimpleDateFormat.parse(paramJSONObject);
            return;
        } catch (ParseException paramJSONObject) {
            MMLog.a("CachedAd", "Exception deserializing cached ad: ", paramJSONObject);
        }
    }

    boolean a() {
        return (this.b != null) && (this.b.getTime() <= System.currentTimeMillis());
    }

    abstract boolean a(Context paramContext);

    abstract boolean a(Context paramContext, MMAdImpl paramMMAdImpl, boolean paramBoolean);

    void b(String paramString) {
        this.g = paramString;
    }

    boolean b() {
        return (this.g != null) && (this.g.length() > 0) && (this.d != null) && (this.d.length() > 0);
    }

    abstract boolean b(Context paramContext);

    abstract int c();

    void c(Context paramContext) {
        int i = 0;
        paramContext = AdCache.h(paramContext);
        if ((paramContext != null) && (paramContext.isDirectory())) {
            try {
                paramContext = paramContext.listFiles(new CachedAd .1 (this));
                MMLog.a("CachedAd", String.format("Deleting %d files for %s.", new Object[]{Integer.valueOf(paramContext.length), this.g}));
                while (i < paramContext.length) {
                    paramContext[i].delete();
                    i += 1;
                }
                return;
            } catch (Exception paramContext) {
                MMLog.a("CachedAd", "Exception deleting cached ad: ", paramContext);
            }
        }
    }

    abstract String d();

    abstract boolean d(Context paramContext);

    String e() {
        return this.g;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
            return true;
        }
        if (!(paramObject instanceof CachedAd)) {
            return false;
        }
        paramObject = (CachedAd) paramObject;
        return this.g.equals(((CachedAd) paramObject).g);
    }

    public void readExternal(ObjectInput paramObjectInput) {
        this.g = ((String) paramObjectInput.readObject());
        this.a = ((String) paramObjectInput.readObject());
        this.b = ((Date) paramObjectInput.readObject());
        this.c = paramObjectInput.readLong();
        this.d = ((String) paramObjectInput.readObject());
    }

    public void writeExternal(ObjectOutput paramObjectOutput) {
        paramObjectOutput.writeObject(this.g);
        paramObjectOutput.writeObject(this.a);
        paramObjectOutput.writeObject(this.b);
        paramObjectOutput.writeLong(this.c);
        paramObjectOutput.writeObject(this.d);
    }

    protected void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.g);
        paramParcel.writeString(this.a);
        paramParcel.writeSerializable(this.b);
        paramParcel.writeLong(this.c);
        paramParcel.writeBooleanArray(new boolean[]{this.f});
        paramParcel.writeString(this.d);
        paramParcel.writeInt(this.e);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/CachedAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */