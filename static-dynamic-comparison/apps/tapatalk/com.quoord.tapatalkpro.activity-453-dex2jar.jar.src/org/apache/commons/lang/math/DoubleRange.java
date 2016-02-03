package org.apache.commons.lang.math;

import java.io.Serializable;

public final class DoubleRange
        extends Range
        implements Serializable {
    private static final long serialVersionUID = 71849363892740L;
    private transient int hashCode = 0;
    private final double max;
    private transient Double maxObject = null;
    private final double min;
    private transient Double minObject = null;
    private transient String toString = null;

    public DoubleRange(double paramDouble) {
        if (Double.isNaN(paramDouble)) {
            throw new IllegalArgumentException("The number must not be NaN");
        }
        this.min = paramDouble;
        this.max = paramDouble;
    }

    public DoubleRange(double paramDouble1, double paramDouble2) {
        if ((Double.isNaN(paramDouble1)) || (Double.isNaN(paramDouble2))) {
            throw new IllegalArgumentException("The numbers must not be NaN");
        }
        if (paramDouble2 < paramDouble1) {
            this.min = paramDouble2;
            this.max = paramDouble1;
            return;
        }
        this.min = paramDouble1;
        this.max = paramDouble2;
    }

    public DoubleRange(Number paramNumber) {
        if (paramNumber == null) {
            throw new IllegalArgumentException("The number must not be null");
        }
        this.min = paramNumber.doubleValue();
        this.max = paramNumber.doubleValue();
        if ((Double.isNaN(this.min)) || (Double.isNaN(this.max))) {
            throw new IllegalArgumentException("The number must not be NaN");
        }
        if ((paramNumber instanceof Double)) {
            this.minObject = ((Double) paramNumber);
            this.maxObject = ((Double) paramNumber);
        }
    }

    public DoubleRange(Number paramNumber1, Number paramNumber2) {
        if ((paramNumber1 == null) || (paramNumber2 == null)) {
            throw new IllegalArgumentException("The numbers must not be null");
        }
        double d1 = paramNumber1.doubleValue();
        double d2 = paramNumber2.doubleValue();
        if ((Double.isNaN(d1)) || (Double.isNaN(d2))) {
            throw new IllegalArgumentException("The numbers must not be NaN");
        }
        if (d2 < d1) {
            this.min = d2;
            this.max = d1;
            if ((paramNumber2 instanceof Double)) {
                this.minObject = ((Double) paramNumber2);
            }
            if ((paramNumber1 instanceof Double)) {
                this.maxObject = ((Double) paramNumber1);
            }
        }
        do {
            return;
            this.min = d1;
            this.max = d2;
            if ((paramNumber1 instanceof Double)) {
                this.minObject = ((Double) paramNumber1);
            }
        } while (!(paramNumber2 instanceof Double));
        this.maxObject = ((Double) paramNumber2);
    }

    public boolean containsDouble(double paramDouble) {
        return (paramDouble >= this.min) && (paramDouble <= this.max);
    }

    public boolean containsNumber(Number paramNumber) {
        if (paramNumber == null) {
            return false;
        }
        return containsDouble(paramNumber.doubleValue());
    }

    public boolean containsRange(Range paramRange) {
        if (paramRange == null) {
        }
        while ((!containsDouble(paramRange.getMinimumDouble())) || (!containsDouble(paramRange.getMaximumDouble()))) {
            return false;
        }
        return true;
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (!(paramObject instanceof DoubleRange)) {
                return false;
            }
            paramObject = (DoubleRange) paramObject;
        }
        while ((Double.doubleToLongBits(this.min) == Double.doubleToLongBits(((DoubleRange) paramObject).min)) && (Double.doubleToLongBits(this.max) == Double.doubleToLongBits(((DoubleRange) paramObject).max)));
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
            this.maxObject = new Double(this.max);
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
            this.minObject = new Double(this.min);
        }
        return this.minObject;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 17;
            this.hashCode = (this.hashCode * 37 + getClass().hashCode());
            long l = Double.doubleToLongBits(this.min);
            this.hashCode = (this.hashCode * 37 + (int) (l >> 32 ^ l));
            l = Double.doubleToLongBits(this.max);
            this.hashCode = (this.hashCode * 37 + (int) (l >> 32 ^ l));
        }
        return this.hashCode;
    }

    public boolean overlapsRange(Range paramRange) {
        if (paramRange == null) {
        }
        while ((!paramRange.containsDouble(this.min)) && (!paramRange.containsDouble(this.max)) && (!containsDouble(paramRange.getMinimumDouble()))) {
            return false;
        }
        return true;
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/math/DoubleRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */