package com.facebook;

class FacebookRequestError$Range {
    private final int end;
    private final int start;

    private FacebookRequestError$Range(int paramInt1, int paramInt2) {
        this.start = paramInt1;
        this.end = paramInt2;
    }

    boolean contains(int paramInt) {
        return (this.start <= paramInt) && (paramInt <= this.end);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/FacebookRequestError$Range.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */