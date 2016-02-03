package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fo;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage
        implements SafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new b();
    private final Uri Cu;
    private final int kr;
    private final int ks;
    private final int xH;

    WebImage(int paramInt1, Uri paramUri, int paramInt2, int paramInt3) {
        this.xH = paramInt1;
        this.Cu = paramUri;
        this.kr = paramInt2;
        this.ks = paramInt3;
    }

    public WebImage(Uri paramUri)
            throws IllegalArgumentException {
        this(paramUri, 0, 0);
    }

    public WebImage(Uri paramUri, int paramInt1, int paramInt2)
            throws IllegalArgumentException {
        this(1, paramUri, paramInt1, paramInt2);
        if (paramUri == null) {
            throw new IllegalArgumentException("url cannot be null");
        }
        if ((paramInt1 < 0) || (paramInt2 < 0)) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject paramJSONObject)
            throws IllegalArgumentException {
        this(d(paramJSONObject), paramJSONObject.optInt("width", 0), paramJSONObject.optInt("height", 0));
    }

    private static Uri d(JSONObject paramJSONObject) {
        Uri localUri = null;
        if (paramJSONObject.has("url")) {
        }
        try {
            localUri = Uri.parse(paramJSONObject.getString("url"));
            return localUri;
        } catch (JSONException paramJSONObject) {
        }
        return null;
    }

    public JSONObject dB() {
        JSONObject localJSONObject = new JSONObject();
        try {
            localJSONObject.put("url", this.Cu.toString());
            localJSONObject.put("width", this.kr);
            localJSONObject.put("height", this.ks);
            return localJSONObject;
        } catch (JSONException localJSONException) {
        }
        return localJSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if ((paramObject == null) || (!(paramObject instanceof WebImage))) {
                return false;
            }
            paramObject = (WebImage) paramObject;
        }
        while ((fo.equal(this.Cu, ((WebImage) paramObject).Cu)) && (this.kr == ((WebImage) paramObject).kr) && (this.ks == ((WebImage) paramObject).ks));
        return false;
    }

    public int getHeight() {
        return this.ks;
    }

    public Uri getUrl() {
        return this.Cu;
    }

    int getVersionCode() {
        return this.xH;
    }

    public int getWidth() {
        return this.kr;
    }

    public int hashCode() {
        return fo.hashCode(new Object[]{this.Cu, Integer.valueOf(this.kr), Integer.valueOf(this.ks)});
    }

    public String toString() {
        return String.format("Image %dx%d %s", new Object[]{Integer.valueOf(this.kr), Integer.valueOf(this.ks), this.Cu.toString()});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/common/images/WebImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */