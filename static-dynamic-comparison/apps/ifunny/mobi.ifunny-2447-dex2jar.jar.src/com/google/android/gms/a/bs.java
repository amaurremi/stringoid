package com.google.android.gms.a;

class bs
        implements t {
    private final long a;
    private final int b;
    private double c;
    private long d;
    private final Object e = new Object();
    private final String f;

    public bs(int paramInt, long paramLong, String paramString) {
        this.b = paramInt;
        this.c = this.b;
        this.a = paramLong;
        this.f = paramString;
    }

    public bs(String paramString) {
        this(60, 2000L, paramString);
    }

    public boolean a() {
        synchronized (this.e) {
            long l = System.currentTimeMillis();
            if (this.c < this.b) {
                double d1 = (l - this.d) / this.a;
                if (d1 > 0.0D) {
                    this.c = Math.min(this.b, d1 + this.c);
                }
            }
            this.d = l;
            if (this.c >= 1.0D) {
                this.c -= 1.0D;
                return true;
            }
            bt.d("Excessive " + this.f + " detected; call ignored.");
            return false;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */