package com.flurry.sdk;

public final class sg
        extends sc {
    final int[] c;
    final int d;

    sg(String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2) {
        super(paramString, paramInt1);
        if (paramInt2 < 3) {
            throw new IllegalArgumentException("Qlen must >= 3");
        }
        this.c = paramArrayOfInt;
        this.d = paramInt2;
    }

    public boolean a(int paramInt) {
        return false;
    }

    public boolean a(int paramInt1, int paramInt2) {
        return false;
    }

    public boolean a(int[] paramArrayOfInt, int paramInt) {
        if (paramInt != this.d) {
            return false;
        }
        int i = 0;
        for (; ; ) {
            if (i >= paramInt) {
                break label36;
            }
            if (paramArrayOfInt[i] != this.c[i]) {
                break;
            }
            i += 1;
        }
        label36:
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/sg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */