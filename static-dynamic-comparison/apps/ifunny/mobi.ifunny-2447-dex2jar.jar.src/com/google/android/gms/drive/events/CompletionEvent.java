package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

import java.util.ArrayList;
import java.util.Locale;

public final class CompletionEvent
        implements SafeParcelable, ResourceEvent {
    public static final Parcelable.Creator<CompletionEvent> CREATOR = new b();
    final int a;
    final DriveId b;
    final String c;
    final ParcelFileDescriptor d;
    final ParcelFileDescriptor e;
    final MetadataBundle f;
    final ArrayList<String> g;
    final int h;
    final IBinder i;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;

    CompletionEvent(int paramInt1, DriveId paramDriveId, String paramString, ParcelFileDescriptor paramParcelFileDescriptor1, ParcelFileDescriptor paramParcelFileDescriptor2, MetadataBundle paramMetadataBundle, ArrayList<String> paramArrayList, int paramInt2, IBinder paramIBinder) {
        this.a = paramInt1;
        this.b = paramDriveId;
        this.c = paramString;
        this.d = paramParcelFileDescriptor1;
        this.e = paramParcelFileDescriptor2;
        this.f = paramMetadataBundle;
        this.g = paramArrayList;
        this.h = paramInt2;
        this.i = paramIBinder;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        if (this.g == null) {
        }
        for (String str = "<null>"; ; str = "'" + TextUtils.join("','", this.g) + "'") {
            return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", new Object[]{this.b, Integer.valueOf(this.h), str});
        }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/events/CompletionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */