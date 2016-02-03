package com.flurry.sdk;

public final class se
        extends sc {
    final int c;
    final int d;

    se(String paramString, int paramInt1, int paramInt2, int paramInt3) {
        super(paramString, paramInt1);
        this.c = paramInt2;
        this.d = paramInt3;
    }

    public boolean a(int paramInt) {
        return false;
    }

    public boolean a(int paramInt1, int paramInt2) {
        return (paramInt1 == this.c) && (paramInt2 == this.d);
    }

    public boolean a(int[] paramArrayOfInt, int paramInt) {
        return (paramInt == 2) && (paramArrayOfInt[0] == this.c) && (paramArrayOfInt[1] == this.d);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/se.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */