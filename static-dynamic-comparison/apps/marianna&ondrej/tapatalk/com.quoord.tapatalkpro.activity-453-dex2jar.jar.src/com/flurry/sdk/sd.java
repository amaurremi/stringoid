package com.flurry.sdk;

public final class sd
        extends sc {
    static final sd c = new sd("", 0, 0);
    final int d;

    sd(String paramString, int paramInt1, int paramInt2) {
        super(paramString, paramInt1);
        this.d = paramInt2;
    }

    static final sd b() {
        return c;
    }

    public boolean a(int paramInt) {
        return paramInt == this.d;
    }

    public boolean a(int paramInt1, int paramInt2) {
        return (paramInt1 == this.d) && (paramInt2 == 0);
    }

    public boolean a(int[] paramArrayOfInt, int paramInt) {
        return (paramInt == 1) && (paramArrayOfInt[0] == this.d);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/sd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */