package org.apache.commons.lang.math;

import java.io.Serializable;

public final class FloatRange
        extends Range
        implements Serializable {
    private static final long serialVersionUID = 71849363892750L;
    private transient int hashCode = 0;
    private final float max;
    private transient Float maxObject = null;
    private final float min;
    private transient Float minObject = null;
    private transient String toString = null;

    public FloatRange(float paramFloat) {
        if (Float.isNaN(paramFloat)) {
            throw new IllegalArgumentException("The number must not be NaN");
        }
        this.min = paramFloat;
        this.max = paramFloat;
    }

    public FloatRange(float paramFloat1, float paramFloat2) {
        if ((Float.isNaN(paramFloat1)) || (Float.isNaN(paramFloat2))) {
            throw new IllegalArgumentException("The numbers must not be NaN");
        }
        if (paramFloat2 < paramFloat1) {
            this.min = paramFloat2;
            this.max = paramFloat1;
            return;
        }
        this.min = paramFloat1;
        this.max = paramFloat2;
    }

    public FloatRange(Number paramNumber) {
        if (paramNumber == null) {
            throw new IllegalArgumentException("The number must not be null");
        }
        this.min = paramNumber.floatValue();
        this.max = paramNumber.floatValue();
        if ((Float.isNaN(this.min)) || (Float.isNaN(this.max))) {
            throw new IllegalArgumentException("The number must not be NaN");
        }
        if ((paramNumber instanceof Float)) {
            this.minObject = ((Float) paramNumber);
            this.maxObject = ((Float) paramNumber);
        }
    }

    public FloatRange(Number paramNumber1, Number paramNumber2) {
        if ((paramNumber1 == null) || (paramNumber2 == null)) {
            throw new IllegalArgumentException("The numbers must not be null");
        }
        float f1 = paramNumber1.floatValue();
        float f2 = paramNumber2.floatValue();
        if ((Float.isNaN(f1)) || (Float.isNaN(f2))) {
            throw new IllegalArgumentException("The numbers must not be NaN");
        }
        if (f2 < f1) {
            this.min = f2;
            this.max = f1;
            if ((paramNumber2 instanceof Float)) {
                this.minObject = ((Float) paramNumber2);
            }
            if ((paramNumber1 instanceof Float)) {
                this.maxObject = ((Float) paramNumber1);
            }
        }
        do {
            return;
            this.min = f1;
            this.max = f2;
            if ((paramNumber1 instanceof Float)) {
                this.minObject = ((Float) paramNumber1);
            }
        } while (!(paramNumber2 instanceof Float));
        this.maxObject = ((Float) paramNumber2);
    }

    public boolean containsFloat(float paramFloat) {
        return (paramFloat >= this.min) && (paramFloat <= this.max);
    }

    public boolean containsNumber(Number paramNumber) {
        if (paramNumber == null) {
            return false;
        }
        return containsFloat(paramNumber.floatValue());
    }

    public boolean containsRange(Range paramRange) {
        if (paramRange == null) {
        }
        while ((!containsFloat(paramRange.getMinimumFloat())) || (!containsFloat(paramRange.getMaximumFloat()))) {
            return false;
        }
        return true;
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (!(paramObject instanceof FloatRange)) {
                return false;
            }
            paramObject = (FloatRange) paramObject;
        }
        while ((Float.floatToIntBits(this.min) == Float.floatToIntBits(((FloatRange) paramObject).min)) && (Float.floatToIntBits(this.max) == Float.floatToIntBits(((FloatRange) paramObject).max)));
        return false;
    }

    public double getMaximumDouble() {
        return this.max;
    }

    public float getMaximumFloat() {
        return this.max;
    }

    public int getMaximumInteger() {
        return (int) this.max;
    }

    public long getMaximumLong() {
        return this.max;
    }

    public Number getMaximumNumber() {
        if (this.maxObject == null) {
            this.maxObject = new Float(this.max);
        }
        return this.maxObject;
    }

    public double getMinimumDouble() {
        return this.min;
    }

    public float getMinimumFloat() {
        return this.min;
    }

    public int getMinimumInteger() {
        return (int) this.min;
    }

    public long getMinimumLong() {
        return this.min;
    }

    public Number getMinimumNumber() {
        if (this.minObject == null) {
            this.minObject = new Float(this.min);
        }
        return this.minObject;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 17;
            this.hashCode = (this.hashCode * 37 + getClass().hashCode());
            this.hashCode = (this.hashCode * 37 + Float.floatToIntBits(this.min));
            this.hashCode = (this.hashCode * 37 + Float.floatToIntBits(this.max));
        }
        return this.hashCode;
    }

    public boolean overlapsRange(Range paramRange) {
        if (paramRange == null) {
        }
        while ((!paramRange.containsFloat(this.min)) && (!paramRange.containsFloat(this.max)) && (!containsFloat(paramRange.getMinimumFloat()))) {
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/math/FloatRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */