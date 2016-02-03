package com.flurry.sdk;

public final class sf
        extends sc {
    final int c;
    final int d;
    final int e;

    sf(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super(paramString, paramInt1);
        this.c = paramInt2;
        this.d = paramInt3;
        this.e = paramInt4;
    }

    public boolean a(int paramInt) {
        return false;
    }

    public boolean a(int paramInt1, int paramInt2) {
        return false;
    }

    public boolean a(int[] paramArrayOfInt, int paramInt) {
        return (paramInt == 3) && (paramArrayOfInt[0] == this.c) && (paramArrayOfInt[1] == this.d) && (paramArrayOfInt[2] == this.e);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/sf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */