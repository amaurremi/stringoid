package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.a;

public final class Status
        implements Result, SafeParcelable {
    public static final Status Bv = new Status(0);
    public static final Status Bw = new Status(14);
    public static final Status Bx = new Status(8);
    public static final Status By = new Status(15);
    public static final Status Bz = new Status(16);
    public static final StatusCreator CREATOR = new StatusCreator();
    private final int Ah;
    private final String BA;
    private final PendingIntent mPendingIntent;
    private final int xH;

    public Status(int paramInt) {
        this(1, paramInt, null, null);
    }

    Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent) {
        this.xH = paramInt1;
        this.Ah = paramInt2;
        this.BA = paramString;
        this.mPendingIntent = paramPendingIntent;
    }

    public Status(int paramInt, String paramString, PendingIntent paramPendingIntent) {
        this(1, paramInt, paramString, paramPendingIntent);
    }

    private String dW() {
        if (this.BA != null) {
            return this.BA;
        }
        return CommonStatusCodes.getStatusCodeString(this.Ah);
    }

    public int describeContents() {
        return 0;
    }

    PendingIntent eo() {
        return this.mPendingIntent;
    }

    String ep() {
        return this.BA;
    }

    @Deprecated
    public ConnectionResult eq() {
        return new ConnectionResult(this.Ah, this.mPendingIntent);
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof Status)) {
        }
        do {
            return false;
            paramObject = (Status) paramObject;
        }
        while ((this.xH != ((Status) paramObject).xH) || (this.Ah != ((Status) paramObject).Ah) || (!fo.equal(this.BA, ((Status) paramObject).BA)) || (!fo.equal(this.mPendingIntent, ((Status) paramObject).mPendingIntent)));
        return true;
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.Ah;
    }

    int getVersionCode() {
        return this.xH;
    }

    public boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public int hashCode() {
        return fo.hashCode(new Object[]{Integer.valueOf(this.xH), Integer.valueOf(this.Ah), this.BA, this.mPendingIntent});
    }

    public boolean isCanceled() {
        return this.Ah == 16;
    }

    public boolean isInterrupted() {
        return this.Ah == 14;
    }

    public boolean isSuccess() {
        return this.Ah <= 0;
    }

    public void startResolutionForResult(Activity paramActivity, int paramInt)
            throws IntentSender.SendIntentException {
        if (!hasResolution()) {
            return;
        }
        paramActivity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
    }

    public String toString() {
        return fo.e(this).a("statusCode", dW()).a("resolution", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        StatusCreator.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/common/api/Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */