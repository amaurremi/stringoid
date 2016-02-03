package com.millennialmedia.android;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.json.JSONArray;
import org.json.JSONObject;

class VideoImage
        implements Parcelable, Externalizable {
    public static final Parcelable.Creator<VideoImage> CREATOR = new VideoImage
    .1();
    static final long serialVersionUID = 808334584720834205L;
    private static final String v = VideoImage.class.getName();
    String a;
    long b;
    String[] c;
    String d;
    String e;
    int f = 0;
    int g = 0;
    int h = 0;
    int i = 0;
    int j;
    int k;
    int l;
    int m;
    long n;
    long o;
    float p = 1.0F;
    float q = 1.0F;
    long r = 1000L;
    boolean s;
    ImageButton t;
    RelativeLayout.LayoutParams u;

    public VideoImage() {
    }

    VideoImage(Parcel paramParcel) {
        try {
            this.a = paramParcel.readString();
            this.b = paramParcel.readLong();
            this.c = new String[paramParcel.readInt()];
            paramParcel.readStringArray(this.c);
            this.d = paramParcel.readString();
            this.e = paramParcel.readString();
            this.f = paramParcel.readInt();
            this.g = paramParcel.readInt();
            this.h = paramParcel.readInt();
            this.i = paramParcel.readInt();
            this.j = paramParcel.readInt();
            this.k = paramParcel.readInt();
            this.l = paramParcel.readInt();
            this.m = paramParcel.readInt();
            this.n = paramParcel.readLong();
            this.o = paramParcel.readLong();
            this.p = paramParcel.readFloat();
            this.q = paramParcel.readFloat();
            this.r = paramParcel.readLong();
            if (paramParcel.readInt() == 1) {
            }
            for (; ; ) {
                this.s = bool;
                return;
                bool = false;
            }
            return;
        } catch (Exception paramParcel) {
            MMLog.a(v, "VideoImage parcel creation exception: ", paramParcel);
        }
    }

    VideoImage(JSONObject paramJSONObject) {
        a(paramJSONObject);
    }

    private void a(JSONObject paramJSONObject) {
        int i1 = 0;
        if (paramJSONObject == null) {
            return;
        }
        this.a = paramJSONObject.optString("image", null);
        this.b = paramJSONObject.optLong("contentLength");
        Object localObject = paramJSONObject.optJSONArray("activity");
        if (localObject != null) {
            this.c = new String[((JSONArray) localObject).length()];
            while (i1 < ((JSONArray) localObject).length()) {
                this.c[i1] = ((JSONArray) localObject).optString(i1);
                i1 += 1;
            }
        }
        this.c = new String[0];
        this.d = paramJSONObject.optString("url", null);
        this.e = paramJSONObject.optString("overlayOrientation", null);
        this.j = paramJSONObject.optInt("android-layout");
        this.k = paramJSONObject.optInt("android-layoutAnchor");
        this.l = paramJSONObject.optInt("android-layout2");
        this.m = paramJSONObject.optInt("android-layoutAnchor2");
        this.f = paramJSONObject.optInt("android-paddingTop");
        this.h = paramJSONObject.optInt("android-paddingLeft");
        this.i = paramJSONObject.optInt("android-paddingRight");
        this.g = paramJSONObject.optInt("android-paddingBottom");
        this.n = ((paramJSONObject.optDouble("appearanceDelay", 0.0D) * 1000.0D));
        this.o = ((paramJSONObject.optDouble("inactivityTimeout", 0.0D) * 1000.0D));
        localObject = paramJSONObject.optJSONObject("opacity");
        if (localObject != null) {
            this.p = ((float) ((JSONObject) localObject).optDouble("start", 1.0D));
            this.q = ((float) ((JSONObject) localObject).optDouble("end", 1.0D));
            this.r = ((((JSONObject) localObject).optDouble("fadeDuration", 1.0D) * 1000.0D));
        }
        this.s = paramJSONObject.optBoolean("is_leavebehind");
    }

    String a() {
        if (this.a != null) {
            Uri localUri = Uri.parse(this.a);
            if ((localUri != null) && (localUri.getLastPathSegment() != null)) {
                return localUri.getLastPathSegment().replaceFirst("\\.[^\\.]*$", ".dat");
            }
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void readExternal(ObjectInput paramObjectInput) {
        this.a = ((String) paramObjectInput.readObject());
        this.b = paramObjectInput.readLong();
        int i2 = paramObjectInput.readInt();
        this.c = new String[i2];
        int i1 = 0;
        while (i1 < i2) {
            this.c[i1] = ((String) paramObjectInput.readObject());
            i1 += 1;
        }
        this.d = ((String) paramObjectInput.readObject());
        this.e = ((String) paramObjectInput.readObject());
        this.f = paramObjectInput.readInt();
        this.g = paramObjectInput.readInt();
        this.h = paramObjectInput.readInt();
        this.i = paramObjectInput.readInt();
        this.j = paramObjectInput.readInt();
        this.k = paramObjectInput.readInt();
        this.l = paramObjectInput.readInt();
        this.m = paramObjectInput.readInt();
        this.n = paramObjectInput.readLong();
        this.o = paramObjectInput.readLong();
        this.p = paramObjectInput.readFloat();
        this.q = paramObjectInput.readFloat();
        this.r = paramObjectInput.readLong();
        this.s = paramObjectInput.readBoolean();
    }

    public void writeExternal(ObjectOutput paramObjectOutput) {
        paramObjectOutput.writeObject(this.a);
        paramObjectOutput.writeLong(this.b);
        paramObjectOutput.writeInt(this.c.length);
        String[] arrayOfString = this.c;
        int i2 = arrayOfString.length;
        int i1 = 0;
        while (i1 < i2) {
            paramObjectOutput.writeObject(arrayOfString[i1]);
            i1 += 1;
        }
        paramObjectOutput.writeObject(this.d);
        paramObjectOutput.writeObject(this.e);
        paramObjectOutput.writeInt(this.f);
        paramObjectOutput.writeInt(this.g);
        paramObjectOutput.writeInt(this.h);
        paramObjectOutput.writeInt(this.i);
        paramObjectOutput.writeInt(this.j);
        paramObjectOutput.writeInt(this.k);
        paramObjectOutput.writeInt(this.l);
        paramObjectOutput.writeInt(this.m);
        paramObjectOutput.writeLong(this.n);
        paramObjectOutput.writeLong(this.o);
        paramObjectOutput.writeFloat(this.p);
        paramObjectOutput.writeFloat(this.q);
        paramObjectOutput.writeLong(this.r);
        paramObjectOutput.writeBoolean(this.s);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.a);
        paramParcel.writeLong(this.b);
        paramParcel.writeInt(this.c.length);
        paramParcel.writeStringArray(this.c);
        paramParcel.writeString(this.d);
        paramParcel.writeString(this.e);
        paramParcel.writeInt(this.f);
        paramParcel.writeInt(this.g);
        paramParcel.writeInt(this.h);
        paramParcel.writeInt(this.i);
        paramParcel.writeInt(this.j);
        paramParcel.writeInt(this.k);
        paramParcel.writeInt(this.l);
        paramParcel.writeInt(this.m);
        paramParcel.writeLong(this.n);
        paramParcel.writeLong(this.o);
        paramParcel.writeFloat(this.p);
        paramParcel.writeFloat(this.q);
        paramParcel.writeLong(this.r);
        if (this.s) {
        }
        for (paramInt = 1; ; paramInt = 0) {
            paramParcel.writeInt(paramInt);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/VideoImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */