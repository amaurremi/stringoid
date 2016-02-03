package org.apache.commons.lang;

public final class NumberRange {
    private final Number max;
    private final Number min;

    public NumberRange(Number paramNumber) {
        if (paramNumber == null) {
            throw new NullPointerException("The number must not be null");
        }
        this.min = paramNumber;
        this.max = paramNumber;
    }

    public NumberRange(Number paramNumber1, Number paramNumber2) {
        if (paramNumber1 == null) {
            throw new NullPointerException("The minimum value must not be null");
        }
        if (paramNumber2 == null) {
            throw new NullPointerException("The maximum value must not be null");
        }
        if (paramNumber2.doubleValue() < paramNumber1.doubleValue()) {
            this.max = paramNumber1;
            this.min = paramNumber1;
            return;
        }
        this.min = paramNumber1;
        this.max = paramNumber2;
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

    public Number getMaximum() {
        return this.max;
    }

    public Number getMinimum() {
        return this.min;
    }

    public int hashCode() {
        return (this.min.hashCode() + 629) * 37 + this.max.hashCode();
    }

    public boolean includesNumber(Number paramNumber) {
        if (paramNumber == null) {
        }
        while ((this.min.doubleValue() > paramNumber.doubleValue()) || (this.max.doubleValue() < paramNumber.doubleValue())) {
            return false;
        }
        return true;
    }

    public boolean includesRange(NumberRange paramNumberRange) {
        if (paramNumberRange == null) {
        }
        while ((!includesNumber(paramNumberRange.min)) || (!includesNumber(paramNumberRange.max))) {
            return false;
        }
        return true;
    }

    public boolean overlaps(NumberRange paramNumberRange) {
        if (paramNumberRange == null) {
        }
        while ((!paramNumberRange.includesNumber(this.min)) && (!paramNumberRange.includesNumber(this.max)) && (!includesRange(paramNumberRange))) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuffer localStringBuffer = new StringBuffer();
        if (this.min.doubleValue() < 0.0D) {
            localStringBuffer.append('(').append(this.min).append(')');
            localStringBuffer.append('-');
            if (this.max.doubleValue() >= 0.0D) {
                break label94;
            }
            localStringBuffer.append('(').append(this.max).append(')');
        }
        for (; ; ) {
            return localStringBuffer.toString();
            localStringBuffer.append(this.min);
            break;
            label94:
            localStringBuffer.append(this.max);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/NumberRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */