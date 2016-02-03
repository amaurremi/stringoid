package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;

public class j
        implements Parcelable.Creator<OnEventResponse> {
    static void a(OnEventResponse paramOnEventResponse, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramOnEventResponse.a);
        c.a(paramParcel, 2, paramOnEventResponse.b);
        c.a(paramParcel, 3, paramOnEventResponse.c, paramInt, false);
        c.a(paramParcel, 5, paramOnEventResponse.d, paramInt, false);
        c.a(paramParcel, i);
    }

    public OnEventResponse a(Parcel paramParcel) {
        CompletionEvent localCompletionEvent = null;
        int j = 0;
        int m = a.b(paramParcel);
        ChangeEvent localChangeEvent = null;
        int i = 0;
        if (paramParcel.dataPosition() < m) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                case 4:
                default:
                    a.b(paramParcel, k);
                    k = j;
                    j = i;
                    i = k;
            }
            for (; ; ) {
                k = j;
                j = i;
                i = k;
                break;
                k = a.g(paramParcel, k);
                i = j;
                j = k;
                continue;
                k = a.g(paramParcel, k);
                j = i;
                i = k;
                continue;
                localChangeEvent = (ChangeEvent) a.a(paramParcel, k, ChangeEvent.CREATOR);
                k = i;
                i = j;
                j = k;
                continue;
                localCompletionEvent = (CompletionEvent) a.a(paramParcel, k, CompletionEvent.CREATOR);
                k = i;
                i = j;
                j = k;
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new OnEventResponse(i, j, localChangeEvent, localCompletionEvent);
    }

    public OnEventResponse[] a(int paramInt) {
        return new OnEventResponse[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */