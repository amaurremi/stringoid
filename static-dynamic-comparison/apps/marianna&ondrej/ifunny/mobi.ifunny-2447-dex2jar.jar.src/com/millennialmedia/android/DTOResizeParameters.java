package com.millennialmedia.android;

class DTOResizeParameters {
    int a;
    int b;
    String c;
    int d;
    int e;
    boolean f;
    int g;
    int h;

    DTOResizeParameters(float paramFloat, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6) {
        this.a = ((int) (paramInt1 * paramFloat));
        this.b = ((int) (paramInt2 * paramFloat));
        this.c = paramString;
        this.d = ((int) (paramInt3 * paramFloat));
        this.e = ((int) (paramInt4 * paramFloat));
        this.f = paramBoolean;
        this.g = paramInt5;
        this.h = paramInt6;
    }

    public String toString() {
        return String.format("width[%d] height[%d] offsetX[%d] offsetY[%d] allowOffScreen[%b] customClosePosition[%s] maxX[%d] maxY[%d]", new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.d), Integer.valueOf(this.e), Boolean.valueOf(this.f), this.c, Integer.valueOf(this.g), Integer.valueOf(this.h)});
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/DTOResizeParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */