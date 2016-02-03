package com.amazon.device.ads;

class hk {
    private final int a;
    private final int b;

    public hk(String paramString) {
        int j;
        if (paramString != null) {
            paramString = paramString.split("x");
            if ((paramString != null) && (paramString.length == 2)) {
                j = Math.max(a(paramString[0], 0), 0);
                i = Math.max(a(paramString[1], 0), 0);
            }
        }
        for (; ; ) {
            this.a = j;
            this.b = i;
            return;
            j = 0;
        }
    }

    private static int a(String paramString, int paramInt) {
        try {
            int i = Integer.parseInt(paramString);
            return i;
        } catch (NumberFormatException paramString) {
        }
        return paramInt;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public String toString() {
        return this.a + "x" + this.b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/hk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */