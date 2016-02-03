package com.google.android.gms.tagmanager;

class dg
        extends Number
        implements Comparable<dg> {
    private double aaC;
    private long aaD;
    private boolean aaE;

    private dg(double paramDouble) {
        this.aaC = paramDouble;
        this.aaE = false;
    }

    private dg(long paramLong) {
        this.aaD = paramLong;
        this.aaE = true;
    }

    public static dg a(Double paramDouble) {
        return new dg(paramDouble.doubleValue());
    }

    public static dg bW(String paramString)
            throws NumberFormatException {
        try {
            dg localdg1 = new dg(Long.parseLong(paramString));
            return localdg1;
        } catch (NumberFormatException localNumberFormatException1) {
            try {
                dg localdg2 = new dg(Double.parseDouble(paramString));
                return localdg2;
            } catch (NumberFormatException localNumberFormatException2) {
                throw new NumberFormatException(paramString + " is not a valid TypedNumber");
            }
        }
    }

    public static dg w(long paramLong) {
        return new dg(paramLong);
    }

    public int a(dg paramdg) {
        if ((lJ()) && (paramdg.lJ())) {
            return new Long(this.aaD).compareTo(Long.valueOf(paramdg.aaD));
        }
        return Double.compare(doubleValue(), paramdg.doubleValue());
    }

    public byte byteValue() {
        return (byte) (int) longValue();
    }

    public double doubleValue() {
        if (lJ()) {
            return this.aaD;
        }
        return this.aaC;
    }

    public boolean equals(Object paramObject) {
        return ((paramObject instanceof dg)) && (a((dg) paramObject) == 0);
    }

    public float floatValue() {
        return (float) doubleValue();
    }

    public int hashCode() {
        return new Long(longValue()).hashCode();
    }

    public int intValue() {
        return lL();
    }

    public boolean lI() {
        return !lJ();
    }

    public boolean lJ() {
        return this.aaE;
    }

    public long lK() {
        if (lJ()) {
            return this.aaD;
        }
        return this.aaC;
    }

    public int lL() {
        return (int) longValue();
    }

    public short lM() {
        return (short) (int) longValue();
    }

    public long longValue() {
        return lK();
    }

    public short shortValue() {
        return lM();
    }

    public String toString() {
        if (lJ()) {
            return Long.toString(this.aaD);
        }
        return Double.toString(this.aaC);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */