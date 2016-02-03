package com.facebook.widget;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import java.util.UUID;

public class FacebookDialog$PendingCall
        implements Parcelable {
    public static final Parcelable.Creator<PendingCall> CREATOR = new FacebookDialog.PendingCall
    .1();
    private UUID callId;
    private int requestCode;
    private Intent requestIntent;

    public FacebookDialog$PendingCall(int paramInt) {
        this.callId = UUID.randomUUID();
        this.requestCode = paramInt;
    }

    private FacebookDialog$PendingCall(Parcel paramParcel) {
        this.callId = UUID.fromString(paramParcel.readString());
        this.requestIntent = ((Intent) paramParcel.readParcelable(null));
        this.requestCode = paramParcel.readInt();
    }

    private void setRequestCode(int paramInt) {
        this.requestCode = paramInt;
    }

    private void setRequestIntent(Intent paramIntent) {
        this.requestIntent = paramIntent;
    }

    public int describeContents() {
        return 0;
    }

    public UUID getCallId() {
        return this.callId;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    public Intent getRequestIntent() {
        return this.requestIntent;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.callId.toString());
        paramParcel.writeParcelable(this.requestIntent, 0);
        paramParcel.writeInt(this.requestCode);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/FacebookDialog$PendingCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */