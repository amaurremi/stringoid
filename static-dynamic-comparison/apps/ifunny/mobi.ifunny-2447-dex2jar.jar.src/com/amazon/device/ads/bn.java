package com.amazon.device.ads;

import java.util.Locale;

public class bn {
    public static final bn a = new bn(300, 50);
    public static final bn b = new bn(320, 50);
    public static final bn c = new bn(300, 250);
    public static final bn d = new bn(600, 90);
    public static final bn e = new bn(728, 90);
    public static final bn f = new bn(1024, 50);
    public static final bn g = new bn(bp.b);
    static final bn h = new bn(bp.c);
    private int i;
    private int j;
    private bp k;

    public bn(int paramInt1, int paramInt2) {
        a(paramInt1, paramInt2);
    }

    bn(bp parambp) {
        this.k = parambp;
    }

    private void a(int paramInt1, int paramInt2) {
        if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
            dv.c("AdSize", "The width and height must be positive integers.");
            throw new IllegalArgumentException("The width and height must be positive integers.");
        }
        this.i = paramInt1;
        this.j = paramInt2;
        this.k = bp.a;
    }

    public boolean a() {
        return this.k == bp.b;
    }

    public String toString() {
        switch (bo.a[this.k.ordinal()]) {
            default:
                return null;
            case 1:
                return String.format(Locale.US, "%dx%d", new Object[]{Integer.valueOf(this.i), Integer.valueOf(this.j)});
            case 2:
                return "auto";
        }
        return "interstitial";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */