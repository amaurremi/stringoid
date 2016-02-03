package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.List;

public class ParcelableEvent
        implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableEvent> CREATOR = new b();
    final int a;
    final String b;
    final String c;
    final List<String> d;
    final boolean e;
    final String f;
    final String g;
    final TextInsertedDetails h;
    final TextDeletedDetails i;
    final ValuesAddedDetails j;
    final ValuesRemovedDetails k;
    final ValuesSetDetails l;
    final ValueChangedDetails m;
    final ReferenceShiftedDetails n;
    final ObjectChangedDetails o;

    ParcelableEvent(int paramInt, String paramString1, String paramString2, List<String> paramList, boolean paramBoolean, String paramString3, String paramString4, TextInsertedDetails paramTextInsertedDetails, TextDeletedDetails paramTextDeletedDetails, ValuesAddedDetails paramValuesAddedDetails, ValuesRemovedDetails paramValuesRemovedDetails, ValuesSetDetails paramValuesSetDetails, ValueChangedDetails paramValueChangedDetails, ReferenceShiftedDetails paramReferenceShiftedDetails, ObjectChangedDetails paramObjectChangedDetails) {
        this.a = paramInt;
        this.b = paramString1;
        this.c = paramString2;
        this.d = paramList;
        this.e = paramBoolean;
        this.f = paramString3;
        this.g = paramString4;
        this.h = paramTextInsertedDetails;
        this.i = paramTextDeletedDetails;
        this.j = paramValuesAddedDetails;
        this.k = paramValuesRemovedDetails;
        this.l = paramValuesSetDetails;
        this.m = paramValueChangedDetails;
        this.n = paramReferenceShiftedDetails;
        this.o = paramObjectChangedDetails;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/ParcelableEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */