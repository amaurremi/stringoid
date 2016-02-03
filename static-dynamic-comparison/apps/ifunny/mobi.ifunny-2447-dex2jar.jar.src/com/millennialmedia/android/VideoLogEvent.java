package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.json.JSONArray;
import org.json.JSONObject;

class VideoLogEvent
        implements Parcelable, Externalizable {
    public static final Parcelable.Creator<VideoLogEvent> CREATOR = new VideoLogEvent
    .1();
    private static final String c = VideoLogEvent.class.getName();
    static final long serialVersionUID = 795553873017368584L;
    long a;
    String[] b;

    public VideoLogEvent() {
    }

    VideoLogEvent(Parcel paramParcel) {
        try {
            this.a = paramParcel.readLong();
            this.b = new String[paramParcel.readInt()];
            paramParcel.readStringArray(this.b);
            return;
        } catch (Exception paramParcel) {
            MMLog.a(c, "VideoLogEvent parcel creation exception: ", paramParcel);
        }
    }

    VideoLogEvent(JSONObject paramJSONObject) {
        a(paramJSONObject);
    }

    private void a(JSONObject paramJSONObject) {
        int i = 0;
        if (paramJSONObject == null) {
        }
        for (; ; ) {
            return;
            this.a = (paramJSONObject.optInt("time") * 1000);
            paramJSONObject = paramJSONObject.optJSONArray("urls");
            if (paramJSONObject == null) {
                break;
            }
            this.b = new String[paramJSONObject.length()];
            while (i < paramJSONObject.length()) {
                this.b[i] = paramJSONObject.optString(i);
                i += 1;
            }
        }
        this.b = new String[0];
    }

    public int describeContents() {
        return 0;
    }

    public void readExternal(ObjectInput paramObjectInput) {
        this.a = paramObjectInput.readLong();
        int j = paramObjectInput.readInt();
        this.b = new String[j];
        int i = 0;
        while (i < j) {
            this.b[i] = ((String) paramObjectInput.readObject());
            i += 1;
        }
    }

    public void writeExternal(ObjectOutput paramObjectOutput) {
        paramObjectOutput.writeLong(this.a);
        paramObjectOutput.writeInt(this.b.length);
        String[] arrayOfString = this.b;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j) {
            paramObjectOutput.writeObject(arrayOfString[i]);
            i += 1;
        }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeLong(this.a);
        paramParcel.writeInt(this.b.length);
        paramParcel.writeStringArray(this.b);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/VideoLogEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */