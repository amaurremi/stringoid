package com.facebook.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FacebookDialog$PendingCall$1
        implements Parcelable.Creator<FacebookDialog.PendingCall> {
    public FacebookDialog.PendingCall createFromParcel(Parcel paramParcel) {
        return new FacebookDialog.PendingCall(paramParcel, null);
    }

    public FacebookDialog.PendingCall[] newArray(int paramInt) {
        return new FacebookDialog.PendingCall[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/FacebookDialog$PendingCall$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */