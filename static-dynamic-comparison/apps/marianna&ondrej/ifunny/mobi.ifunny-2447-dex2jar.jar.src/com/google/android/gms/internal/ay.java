package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.e;
import com.google.android.gms.ads.h;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ii
public final class ay
        implements SafeParcelable {
    public static final au CREATOR = new au();
    public final int a;
    public final String b;
    public final int c;
    public final int d;
    public final boolean e;
    public final int f;
    public final int g;
    public final ay[] h;

    public ay() {
        this(2, "interstitial_mb", 0, 0, true, 0, 0, null);
    }

    ay(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, ay[] paramArrayOfay) {
        this.a = paramInt1;
        this.b = paramString;
        this.c = paramInt2;
        this.d = paramInt3;
        this.e = paramBoolean;
        this.f = paramInt4;
        this.g = paramInt5;
        this.h = paramArrayOfay;
    }

    public ay(Context paramContext, e parame) {
        this(paramContext, new e[]{parame});
    }

    public ay(Context paramContext, e[] paramArrayOfe) {
        e locale = paramArrayOfe[0];
        this.a = 2;
        this.e = false;
        this.f = locale.b();
        this.c = locale.a();
        int i;
        int j;
        label62:
        DisplayMetrics localDisplayMetrics;
        int k;
        label98:
        int m;
        if (this.f == -1) {
            i = 1;
            if (this.c != -2) {
                break label217;
            }
            j = 1;
            localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
            if (i == 0) {
                break label223;
            }
            this.g = a(localDisplayMetrics);
            k = (int) (this.g / localDisplayMetrics.density);
            if (j == 0) {
                break label245;
            }
            m = c(localDisplayMetrics);
            label110:
            this.d = mv.a(localDisplayMetrics, m);
            if ((i == 0) && (j == 0)) {
                break label254;
            }
        }
        label217:
        label223:
        label245:
        label254:
        for (this.b = (k + "x" + m + "_as"); ; this.b = locale.toString()) {
            if (paramArrayOfe.length <= 1) {
                break label266;
            }
            this.h = new ay[paramArrayOfe.length];
            i = n;
            while (i < paramArrayOfe.length) {
                this.h[i] = new ay(paramContext, paramArrayOfe[i]);
                i += 1;
            }
            i = 0;
            break;
            j = 0;
            break label62;
            k = this.f;
            this.g = mv.a(localDisplayMetrics, this.f);
            break label98;
            m = this.c;
            break label110;
        }
        label266:
        this.h = null;
    }

    public ay(ay paramay, ay[] paramArrayOfay) {
        this(2, paramay.b, paramay.c, paramay.d, paramay.e, paramay.f, paramay.g, paramArrayOfay);
    }

    public static int a(DisplayMetrics paramDisplayMetrics) {
        return paramDisplayMetrics.widthPixels;
    }

    public static int b(DisplayMetrics paramDisplayMetrics) {
        return (int) (c(paramDisplayMetrics) * paramDisplayMetrics.density);
    }

    private static int c(DisplayMetrics paramDisplayMetrics) {
        int i = (int) (paramDisplayMetrics.heightPixels / paramDisplayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        if (i <= 720) {
            return 50;
        }
        return 90;
    }

    public e a() {
        return h.a(this.f, this.c, this.b);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        au.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */