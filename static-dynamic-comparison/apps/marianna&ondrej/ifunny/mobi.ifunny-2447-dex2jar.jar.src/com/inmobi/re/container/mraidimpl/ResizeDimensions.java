package com.inmobi.re.container.mraidimpl;

public class ResizeDimensions {
    int a;
    int b;
    int c;
    int d;

    public ResizeDimensions(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramInt3;
        this.d = paramInt4;
    }

    public int getHeight() {
        return this.d;
    }

    public int getWidth() {
        return this.c;
    }

    public int getX() {
        return this.a;
    }

    public int getY() {
        return this.b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/mraidimpl/ResizeDimensions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */