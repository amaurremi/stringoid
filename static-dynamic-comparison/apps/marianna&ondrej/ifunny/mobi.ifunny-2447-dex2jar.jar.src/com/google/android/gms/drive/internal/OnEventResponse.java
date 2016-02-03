package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;

public class OnEventResponse
        implements SafeParcelable {
    public static final Parcelable.Creator<OnEventResponse> CREATOR = new j();
    final int a;
    final int b;
    final ChangeEvent c;
    final CompletionEvent d;

    OnEventResponse(int paramInt1, int paramInt2, ChangeEvent paramChangeEvent, CompletionEvent paramCompletionEvent) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramChangeEvent;
        this.d = paramCompletionEvent;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        j.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/OnEventResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */