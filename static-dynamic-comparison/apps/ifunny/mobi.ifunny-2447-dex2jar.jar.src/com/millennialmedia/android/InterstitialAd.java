package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;

class InterstitialAd
        extends CachedAd
        implements Parcelable, Externalizable {
    public static final Parcelable.Creator<InterstitialAd> CREATOR = new InterstitialAd
    .1();
    private static final String j = InterstitialAd.class.getName();
    static final long serialVersionUID = 5158660334173309853L;
    String g;
    String h;
    HttpMMHeaders i;

    public InterstitialAd() {
    }

    InterstitialAd(Parcel paramParcel) {
        super(paramParcel);
        try {
            this.g = paramParcel.readString();
            this.h = paramParcel.readString();
            this.i = ((HttpMMHeaders) paramParcel.readParcelable(HttpMMHeaders.class.getClassLoader()));
            return;
        } catch (Exception paramParcel) {
            MMLog.a(j, "Interstitial problem reading parcel: ", paramParcel);
        }
    }

    private Intent b(Context paramContext, long paramLong) {
        paramContext = new Intent();
        OverlaySettings localOverlaySettings = new OverlaySettings();
        localOverlaySettings.n = paramLong;
        localOverlaySettings.i = this.g;
        localOverlaySettings.j = this.h;
        localOverlaySettings.a(this.i);
        localOverlaySettings.m = true;
        paramContext.putExtra("settings", localOverlaySettings);
        paramContext.putExtra("internalId", paramLong);
        return paramContext;
    }

    void a(Context paramContext, long paramLong) {
        Utils.IntentUtils.a(paramContext, b(paramContext, paramLong));
    }

    boolean a(Context paramContext) {
        return true;
    }

    boolean a(Context paramContext, MMAdImpl paramMMAdImpl, boolean paramBoolean) {
        if (paramBoolean) {
            if ((this.g == null) || (this.g.length() <= 0) || (this.h == null) || (this.h.length() <= 0) || (!HandShake.a(paramContext).a(paramMMAdImpl.f, this.c))) {
            }
        }
        while ((this.g != null) && (this.g.length() > 0) && (this.h != null) && (this.h.length() > 0)) {
            return true;
            return false;
        }
        return false;
    }

    boolean b(Context paramContext) {
        return true;
    }

    int c() {
        return 2;
    }

    String d() {
        return "Interstitial";
    }

    boolean d(Context paramContext) {
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public void readExternal(ObjectInput paramObjectInput) {
        super.readExternal(paramObjectInput);
        this.g = ((String) paramObjectInput.readObject());
        this.h = ((String) paramObjectInput.readObject());
        this.i = ((HttpMMHeaders) paramObjectInput.readObject());
    }

    public void writeExternal(ObjectOutput paramObjectOutput) {
        super.writeExternal(paramObjectOutput);
        paramObjectOutput.writeObject(this.g);
        paramObjectOutput.writeObject(this.h);
        paramObjectOutput.writeObject(this.i);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeString(this.g);
        paramParcel.writeString(this.h);
        paramParcel.writeParcelable(this.i, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/InterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */