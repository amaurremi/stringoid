package org.apache.commons.lang.math;

public abstract class Range {
    public boolean containsDouble(double paramDouble) {
        int i = NumberUtils.compare(getMinimumDouble(), paramDouble);
        int j = NumberUtils.compare(getMaximumDouble(), paramDouble);
        return (i <= 0) && (j >= 0);
    }

    public boolean containsDouble(Number paramNumber) {
        if (paramNumber == null) {
            return false;
        }
        return containsDouble(paramNumber.doubleValue());
    }

    public boolean containsFloat(float paramFloat) {
        int i = NumberUtils.compare(getMinimumFloat(), paramFloat);
        int j = NumberUtils.compare(getMaximumFloat(), paramFloat);
        return (i <= 0) && (j >= 0);
    }

    public boolean containsFloat(Number paramNumber) {
        if (paramNumber == null) {
            return false;
        }
        return containsFloat(paramNumber.floatValue());
    }

    public boolean containsInteger(int paramInt) {
        return (paramInt >= getMinimumInteger()) && (paramInt <= getMaximumInteger());
    }

    public boolean containsInteger(Number paramNumber) {
        if (paramNumber == null) {
            return false;
        }
        return containsInteger(paramNumber.intValue());
    }

    public boolean containsLong(long paramLong) {
        return (paramLong >= getMinimumLong()) && (paramLong <= getMaximumLong());
    }

    public boolean containsLong(Number paramNumber) {
        if (paramNumber == null) {
            return false;
        }
        return containsLong(paramNumber.longValue());
    }

    public abstract boolean containsNumber(Number paramNumber);

    public boolean containsRange(Range paramRange) {
        if (paramRange == null) {
        }
        while ((!containsNumber(paramRange.getMinimumNumber())) || (!containsNumber(paramRange.getMaximumNumber()))) {
            return false;
        }
        return true;
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if ((paramObject == null) || (paramObject.getClass() != getClass())) {
                return false;
            }
            paramObject = (Range) paramObject;
        }
        while ((getMinimumNumber().equals(((Range) paramObject).getMinimumNumber())) && (getMaximumNumber().equals(((Range) paramObject).getMaximumNumber())));
        return false;
    }

    public double getMaximumDouble() {
        return getMaximumNumber().doubleValue();
    }

    public float getMaximumFloat() {
        return getMaximumNumber().floatValue();
    }

    public int getMaximumInteger() {
        return getMaximumNumber().intValue();
    }

    public long getMaximumLong() {
        return getMaximumNumber().longValue();
    }

    public abstract Number getMaximumNumber();

    public double getMinimumDouble() {
        return getMinimumNumber().doubleValue();
    }

    public float getMinimumFloat() {
        return getMinimumNumber().floatValue();
    }

    public int getMinimumInteger() {
        return getMinimumNumber().intValue();
    }

    public long getMinimumLong() {
        return getMinimumNumber().longValue();
    }

    public abstract Number getMinimumNumber();

    public int hashCode() {
        return ((getClass().hashCode() + 629) * 37 + getMinimumNumber().hashCode()) * 37 + getMaximumNumber().hashCode();
    }

    public boolean overlapsRange(Range paramRange) {
        if (paramRange == null) {
        }
        while ((!paramRange.containsNumber(getMinimumNumber())) && (!paramRange.containsNumber(getMaximumNumber())) && (!containsNumber(paramRange.getMinimumNumber()))) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuffer localStringBuffer = new StringBuffer(32);
        localStringBuffer.append("Range[");
        localStringBuffer.append(getMinimumNumber());
        localStringBuffer.append(',');
        localStringBuffer.append(getMaximumNumber());
        localStringBuffer.append(']');
        return localStringBuffer.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/math/Range.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */