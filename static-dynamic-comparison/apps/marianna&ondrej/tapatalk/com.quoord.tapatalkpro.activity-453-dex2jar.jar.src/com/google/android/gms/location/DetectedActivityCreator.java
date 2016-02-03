package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class DetectedActivityCreator
        implements Parcelable.Creator<DetectedActivity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(DetectedActivity paramDetectedActivity, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        b.c(paramParcel, 1, paramDetectedActivity.NS);
        b.c(paramParcel, 1000, paramDetectedActivity.getVersionCode());
        b.c(paramParcel, 2, paramDetectedActivity.NT);
        b.F(paramParcel, paramInt);
    }

    public DetectedActivity createFromParcel(Parcel paramParcel) {
        int k = 0;
        int m = a.o(paramParcel);
        int j = 0;
        int i = 0;
        while (paramParcel.dataPosition() < m) {
            int n = a.n(paramParcel);
            switch (a.R(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    j = a.g(paramParcel, n);
                    break;
                case 1000:
                    i = a.g(paramParcel, n);
                    break;
                case 2:
                    k = a.g(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new a.a("Overread allowed size end=" + m, paramParcel);
        }
        return new DetectedActivity(i, j, k);
    }

    public DetectedActivity[] newArray(int paramInt) {
        return new DetectedActivity[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/location/DetectedActivityCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */