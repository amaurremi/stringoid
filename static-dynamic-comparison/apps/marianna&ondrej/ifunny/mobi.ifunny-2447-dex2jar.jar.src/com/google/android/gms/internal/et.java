package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.h;

import java.util.Date;
import java.util.HashSet;

@ii
public final class et {
    public static int a(AdRequest.ErrorCode paramErrorCode) {
        switch (eu.b[paramErrorCode.ordinal()]) {
            default:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
        }
        return 3;
    }

    public static AdRequest.Gender a(int paramInt) {
        switch (paramInt) {
            default:
                return AdRequest.Gender.UNKNOWN;
            case 2:
                return AdRequest.Gender.FEMALE;
        }
        return AdRequest.Gender.MALE;
    }

    public static AdSize a(ay paramay) {
        int i = 0;
        AdSize[] arrayOfAdSize = new AdSize[6];
        arrayOfAdSize[0] = AdSize.SMART_BANNER;
        arrayOfAdSize[1] = AdSize.BANNER;
        arrayOfAdSize[2] = AdSize.IAB_MRECT;
        arrayOfAdSize[3] = AdSize.IAB_BANNER;
        arrayOfAdSize[4] = AdSize.IAB_LEADERBOARD;
        arrayOfAdSize[5] = AdSize.IAB_WIDE_SKYSCRAPER;
        while (i < arrayOfAdSize.length) {
            if ((arrayOfAdSize[i].getWidth() == paramay.f) && (arrayOfAdSize[i].getHeight() == paramay.c)) {
                return arrayOfAdSize[i];
            }
            i += 1;
        }
        return new AdSize(h.a(paramay.f, paramay.c, paramay.b));
    }

    public static MediationAdRequest a(av paramav) {
        if (paramav.e != null) {
        }
        for (HashSet localHashSet = new HashSet(paramav.e); ; localHashSet = null) {
            return new MediationAdRequest(new Date(paramav.b), a(paramav.d), localHashSet, paramav.f, paramav.k);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/et.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */