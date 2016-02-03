package com.umeng.a.a.a;

public class b {
    private short[] a;
    private int b = -1;

    public b(int paramInt) {
        this.a = new short[paramInt];
    }

    private void d() {
        short[] arrayOfShort = new short[this.a.length * 2];
        System.arraycopy(this.a, 0, arrayOfShort, 0, this.a.length);
        this.a = arrayOfShort;
    }

    public short a() {
        short[] arrayOfShort = this.a;
        int i = this.b;
        this.b = (i - 1);
        return arrayOfShort[i];
    }

    public void a(short paramShort) {
        if (this.a.length == this.b + 1) {
            d();
        }
        short[] arrayOfShort = this.a;
        int i = this.b + 1;
        this.b = i;
        arrayOfShort[i] = paramShort;
    }

    public short b() {
        return this.a[this.b];
    }

    public void c() {
        this.b = -1;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<ShortStack vector:[");
        int i = 0;
        while (i < this.a.length) {
            if (i != 0) {
                localStringBuilder.append(" ");
            }
            if (i == this.b) {
                localStringBuilder.append(">>");
            }
            localStringBuilder.append(this.a[i]);
            if (i == this.b) {
                localStringBuilder.append("<<");
            }
            i += 1;
        }
        localStringBuilder.append("]>");
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */