package org.apache.commons.lang.math;

import java.io.Serializable;

public final class LongRange
        extends Range
        implements Serializable {
    private static final long serialVersionUID = 71849363892720L;
    private transient int hashCode = 0;
    private final long max;
    private transient Long maxObject = null;
    private final long min;
    private transient Long minObject = null;
    private transient String toString = null;

    public LongRange(long paramLong) {
        this.min = paramLong;
        this.max = paramLong;
    }

    public LongRange(long paramLong1, long paramLong2) {
        if (paramLong2 < paramLong1) {
            this.min = paramLong2;
            this.max = paramLong1;
            return;
        }
        this.min = paramLong1;
        this.max = paramLong2;
    }

    public LongRange(Number paramNumber) {
        if (paramNumber == null) {
            throw new IllegalArgumentException("The number must not be null");
        }
        this.min = paramNumber.longValue();
        this.max = paramNumber.longValue();
        if ((paramNumber instanceof Long)) {
            this.minObject = ((Long) paramNumber);
            this.maxObject = ((Long) paramNumber);
        }
    }

    public LongRange(Number paramNumber1, Number paramNumber2) {
        if ((paramNumber1 == null) || (paramNumber2 == null)) {
            throw new IllegalArgumentException("The numbers must not be null");
        }
        long l1 = paramNumber1.longValue();
        long l2 = paramNumber2.longValue();
        if (l2 < l1) {
            this.min = l2;
            this.max = l1;
            if ((paramNumber2 instanceof Long)) {
                this.minObject = ((Long) paramNumber2);
            }
            if ((paramNumber1 instanceof Long)) {
                this.maxObject = ((Long) paramNumber1);
            }
        }
        do {
            return;
            this.min = l1;
            this.max = l2;
            if ((paramNumber1 instanceof Long)) {
                this.minObject = ((Long) paramNumber1);
            }
        } while (!(paramNumber2 instanceof Long));
        this.maxObject = ((Long) paramNumber2);
    }

    public boolean containsLong(long paramLong) {
        return (paramLong >= this.min) && (paramLong <= this.max);
    }

    public boolean containsNumber(Number paramNumber) {
        if (paramNumber == null) {
            return false;
        }
        return containsLong(paramNumber.longValue());
    }

    public boolean containsRange(Range paramRange) {
        if (paramRange == null) {
        }
        while ((!containsLong(paramRange.getMinimumLong())) || (!containsLong(paramRange.getMaximumLong()))) {
            return false;
        }
        return true;
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (!(paramObject instanceof LongRange)) {
                return false;
            }
            paramObject = (LongRange) paramObject;
        } while ((this.min == ((LongRange) paramObject).min) && (this.max == ((LongRange) paramObject).max));
        return false;
    }

    public double getMaximumDouble() {
        return this.max;
    }

    public float getMaximumFloat() {
        return (float) this.max;
    }

    public int getMaximumInteger() {
        return (int) this.max;
    }

    public long getMaximumLong() {
        return this.max;
    }

    public Number getMaximumNumber() {
        if (this.maxObject == null) {
            this.maxObject = new Long(this.max);
        }
        return this.maxObject;
    }

    public double getMinimumDouble() {
        return this.min;
    }

    public float getMinimumFloat() {
        return (float) this.min;
    }

    public int getMinimumInteger() {
        return (int) this.min;
    }

    public long getMinimumLong() {
        return this.min;
    }

    public Number getMinimumNumber() {
        if (this.minObject == null) {
            this.minObject = new Long(this.min);
        }
        return this.minObject;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 17;
            this.hashCode = (this.hashCode * 37 + getClass().hashCode());
            this.hashCode = (this.hashCode * 37 + (int) (this.min ^ this.min >> 32));
            this.hashCode = (this.hashCode * 37 + (int) (this.max ^ this.max >> 32));
        }
        return this.hashCode;
    }

    public boolean overlapsRange(Range paramRange) {
        if (paramRange == null) {
        }
        while ((!paramRange.containsLong(this.min)) && (!paramRange.containsLong(this.max)) && (!containsLong(paramRange.getMinimumLong()))) {
            return false;
        }
        return true;
    }

    public long[] toArray() {
        long[] arrayOfLong = new long[(int) (this.max - this.min + 1L)];
        int i = 0;
        while (i < arrayOfLong.length) {
            arrayOfLong[i] = (this.min + i);
            i += 1;
        }
        return arrayOfLong;
    }

    public String toString() {
        if (this.toString == null) {
            StringBuffer localStringBuffer = new StringBuffer(32);
            localStringBuffer.append("Range[");
            localStringBuffer.append(this.min);
            localStringBuffer.append(',');
            localStringBuffer.append(this.max);
            localStringBuffer.append(']');
            this.toString = localStringBuffer.toString();
        }
        return this.toString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/math/LongRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */