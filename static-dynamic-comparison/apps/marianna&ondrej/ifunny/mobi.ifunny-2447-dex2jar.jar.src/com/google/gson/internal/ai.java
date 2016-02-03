package com.google.gson.internal;

class ai
        implements CharSequence {
    char[] a;

    public char charAt(int paramInt) {
        return this.a[paramInt];
    }

    public int length() {
        return this.a.length;
    }

    public CharSequence subSequence(int paramInt1, int paramInt2) {
        return new String(this.a, paramInt1, paramInt2 - paramInt1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */