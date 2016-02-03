package org.apache.commons.lang.math;

import java.io.Serializable;

public final class NumberRange
        extends Range
        implements Serializable {
    private static final long serialVersionUID = 71849363892710L;
    private transient int hashCode = 0;
    private final Number max;
    private final Number min;
    private transient String toString = null;

    public NumberRange(Number paramNumber) {
        if (paramNumber == null) {
            throw new IllegalArgumentException("The number must not be null");
        }
        if (!(paramNumber instanceof Comparable)) {
            throw new IllegalArgumentException("The number must implement Comparable");
        }
        if (((paramNumber instanceof Double)) && (((Double) paramNumber).isNaN())) {
            throw new IllegalArgumentException("The number must not be NaN");
        }
        if (((paramNumber instanceof Float)) && (((Float) paramNumber).isNaN())) {
            throw new IllegalArgumentException("The number must not be NaN");
        }
        this.min = paramNumber;
        this.max = paramNumber;
    }

    public NumberRange(Number paramNumber1, Number paramNumber2) {
        if ((paramNumber1 == null) || (paramNumber2 == null)) {
            throw new IllegalArgumentException("The numbers must not be null");
        }
        if (paramNumber1.getClass() != paramNumber2.getClass()) {
            throw new IllegalArgumentException("The numbers must be of the same type");
        }
        if (!(paramNumber1 instanceof Comparable)) {
            throw new IllegalArgumentException("The numbers must implement Comparable");
        }
        if ((paramNumber1 instanceof Double)) {
            if ((((Double) paramNumber1).isNaN()) || (((Double) paramNumber2).isNaN())) {
                throw new IllegalArgumentException("The number must not be NaN");
            }
        } else if (((paramNumber1 instanceof Float)) && ((((Float) paramNumber1).isNaN()) || (((Float) paramNumber2).isNaN()))) {
            throw new IllegalArgumentException("The number must not be NaN");
        }
        int i = ((Comparable) paramNumber1).compareTo(paramNumber2);
        if (i == 0) {
            this.min = paramNumber1;
            this.max = paramNumber1;
            return;
        }
        if (i > 0) {
            this.min = paramNumber2;
            this.max = paramNumber1;
            return;
        }
        this.min = paramNumber1;
        this.max = paramNumber2;
    }

    public boolean containsNumber(Number paramNumber) {
        if (paramNumber == null) {
            return false;
        }
        if (paramNumber.getClass() != this.min.getClass()) {
            throw new IllegalArgumentException("The number must be of the same type as the range numbers");
        }
        int i = ((Comparable) this.min).compareTo(paramNumber);
        int j = ((Comparable) this.max).compareTo(paramNumber);
        if ((i <= 0) && (j >= 0)) {
        }
        for (boolean bool = true; ; bool = false) {
            return bool;
        }
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (!(paramObject instanceof NumberRange)) {
                return false;
            }
            paramObject = (NumberRange) paramObject;
        }
        while ((this.min.equals(((NumberRange) paramObject).min)) && (this.max.equals(((NumberRange) paramObject).max)));
        return false;
    }

    public Number getMaximumNumber() {
        return this.max;
    }

    public Number getMinimumNumber() {
        return this.min;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 17;
            this.hashCode = (this.hashCode * 37 + getClass().hashCode());
            this.hashCode = (this.hashCode * 37 + this.min.hashCode());
            this.hashCode = (this.hashCode * 37 + this.max.hashCode());
        }
        return this.hashCode;
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/math/NumberRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */