package com.amazon.device.ads;

class Size {
    private final int height;
    private final int width;

    public Size(int paramInt1, int paramInt2) {
        this.width = paramInt1;
        this.height = paramInt2;
    }

    public Size(String paramString) {
        int k = 0;
        int m = 0;
        int j = m;
        int i = k;
        if (paramString != null) {
            paramString = paramString.split("x");
            j = m;
            i = k;
            if (paramString != null) {
                j = m;
                i = k;
                if (paramString.length == 2) {
                    i = Math.max(parseInt(paramString[0], 0), 0);
                    j = Math.max(parseInt(paramString[1], 0), 0);
                }
            }
        }
        this.width = i;
        this.height = j;
    }

    private static int parseInt(String paramString, int paramInt) {
        try {
            int i = Integer.parseInt(paramString);
            return i;
        } catch (NumberFormatException paramString) {
        }
        return paramInt;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return this.width + "x" + this.height;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/Size.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */