package org.apache.commons.lang.mutable;

public class MutableLong
        extends Number
        implements Comparable, Mutable {
    private static final long serialVersionUID = 62986528375L;
    private long value;

    public MutableLong() {
    }

    public MutableLong(long paramLong) {
        this.value = paramLong;
    }

    public MutableLong(Number paramNumber) {
        this.value = paramNumber.longValue();
    }

    public MutableLong(String paramString)
            throws NumberFormatException {
        this.value = Long.parseLong(paramString);
    }

    public void add(long paramLong) {
        this.value += paramLong;
    }

    public void add(Number paramNumber) {
        this.value += paramNumber.longValue();
    }

    public int compareTo(Object paramObject) {
        long l = ((MutableLong) paramObject).value;
        if (this.value < l) {
            return -1;
        }
        if (this.value == l) {
            return 0;
        }
        return 1;
    }

    public void decrement() {
        this.value -= 1L;
    }

    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((paramObject instanceof MutableLong)) {
            bool1 = bool2;
            if (this.value == ((MutableLong) paramObject).longValue()) {
                bool1 = true;
            }
        }
        return bool1;
    }

    public float floatValue() {
        return (float) this.value;
    }

    public Object getValue() {
        return new Long(this.value);
    }

    public int hashCode() {
        return (int) (this.value ^ this.value >>> 32);
    }

    public void increment() {
        this.value += 1L;
    }

    public int intValue() {
        return (int) this.value;
    }

    public long longValue() {
        return this.value;
    }

    public void setValue(long paramLong) {
        this.value = paramLong;
    }

    public void setValue(Object paramObject) {
        setValue(((Number) paramObject).longValue());
    }

    public void subtract(long paramLong) {
        this.value -= paramLong;
    }

    public void subtract(Number paramNumber) {
        this.value -= paramNumber.longValue();
    }

    public Long toLong() {
        return new Long(longValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/mutable/MutableLong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */