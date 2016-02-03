package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class b
        implements Parcelable.Creator<ParcelableEvent> {
    static void a(ParcelableEvent paramParcelableEvent, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramParcelableEvent.a);
        c.a(paramParcel, 2, paramParcelableEvent.b, false);
        c.a(paramParcel, 3, paramParcelableEvent.c, false);
        c.b(paramParcel, 4, paramParcelableEvent.d, false);
        c.a(paramParcel, 5, paramParcelableEvent.e);
        c.a(paramParcel, 6, paramParcelableEvent.f, false);
        c.a(paramParcel, 7, paramParcelableEvent.g, false);
        c.a(paramParcel, 8, paramParcelableEvent.h, paramInt, false);
        c.a(paramParcel, 9, paramParcelableEvent.i, paramInt, false);
        c.a(paramParcel, 10, paramParcelableEvent.j, paramInt, false);
        c.a(paramParcel, 11, paramParcelableEvent.k, paramInt, false);
        c.a(paramParcel, 12, paramParcelableEvent.l, paramInt, false);
        c.a(paramParcel, 13, paramParcelableEvent.m, paramInt, false);
        c.a(paramParcel, 14, paramParcelableEvent.n, paramInt, false);
        c.a(paramParcel, 15, paramParcelableEvent.o, paramInt, false);
        c.a(paramParcel, i);
    }

    public ParcelableEvent a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        String str4 = null;
        String str3 = null;
        ArrayList localArrayList = null;
        boolean bool = false;
        String str2 = null;
        String str1 = null;
        TextInsertedDetails localTextInsertedDetails = null;
        TextDeletedDetails localTextDeletedDetails = null;
        ValuesAddedDetails localValuesAddedDetails = null;
        ValuesRemovedDetails localValuesRemovedDetails = null;
        ValuesSetDetails localValuesSetDetails = null;
        ValueChangedDetails localValueChangedDetails = null;
        ReferenceShiftedDetails localReferenceShiftedDetails = null;
        ObjectChangedDetails localObjectChangedDetails = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    str4 = a.o(paramParcel, k);
                    break;
                case 3:
                    str3 = a.o(paramParcel, k);
                    break;
                case 4:
                    localArrayList = a.C(paramParcel, k);
                    break;
                case 5:
                    bool = a.c(paramParcel, k);
                    break;
                case 6:
                    str2 = a.o(paramParcel, k);
                    break;
                case 7:
                    str1 = a.o(paramParcel, k);
                    break;
                case 8:
                    localTextInsertedDetails = (TextInsertedDetails) a.a(paramParcel, k, TextInsertedDetails.CREATOR);
                    break;
                case 9:
                    localTextDeletedDetails = (TextDeletedDetails) a.a(paramParcel, k, TextDeletedDetails.CREATOR);
                    break;
                case 10:
                    localValuesAddedDetails = (ValuesAddedDetails) a.a(paramParcel, k, ValuesAddedDetails.CREATOR);
                    break;
                case 11:
                    localValuesRemovedDetails = (ValuesRemovedDetails) a.a(paramParcel, k, ValuesRemovedDetails.CREATOR);
                    break;
                case 12:
                    localValuesSetDetails = (ValuesSetDetails) a.a(paramParcel, k, ValuesSetDetails.CREATOR);
                    break;
                case 13:
                    localValueChangedDetails = (ValueChangedDetails) a.a(paramParcel, k, ValueChangedDetails.CREATOR);
                    break;
                case 14:
                    localReferenceShiftedDetails = (ReferenceShiftedDetails) a.a(paramParcel, k, ReferenceShiftedDetails.CREATOR);
                    break;
                case 15:
                    localObjectChangedDetails = (ObjectChangedDetails) a.a(paramParcel, k, ObjectChangedDetails.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + j, paramParcel);
        }
        return new ParcelableEvent(i, str4, str3, localArrayList, bool, str2, str1, localTextInsertedDetails, localTextDeletedDetails, localValuesAddedDetails, localValuesRemovedDetails, localValuesSetDetails, localValueChangedDetails, localReferenceShiftedDetails, localObjectChangedDetails);
    }

    public ParcelableEvent[] a(int paramInt) {
        return new ParcelableEvent[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */