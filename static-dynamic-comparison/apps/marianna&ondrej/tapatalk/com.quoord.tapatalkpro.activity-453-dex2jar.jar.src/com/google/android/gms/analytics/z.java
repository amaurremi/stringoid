package com.google.android.gms.analytics;

class z
        implements ad {
    private final long vm;
    private final int vn;
    private double vo;
    private long vp;
    private final Object vq = new Object();
    private final String vr;

    public z(int paramInt, long paramLong, String paramString) {
        this.vn = paramInt;
        this.vo = this.vn;
        this.vm = paramLong;
        this.vr = paramString;
    }

    public z(String paramString) {
        this(60, 2000L, paramString);
    }

    public boolean cS() {
        synchronized (this.vq) {
            long l = System.currentTimeMillis();
            if (this.vo < this.vn) {
                double d = (l - this.vp) / this.vm;
                if (d > 0.0D) {
                    this.vo = Math.min(this.vn, d + this.vo);
                }
            }
            this.vp = l;
            if (this.vo >= 1.0D) {
                this.vo -= 1.0D;
                return true;
            }
            aa.z("Excessive " + this.vr + " detected; call ignored.");
            return false;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/analytics/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */