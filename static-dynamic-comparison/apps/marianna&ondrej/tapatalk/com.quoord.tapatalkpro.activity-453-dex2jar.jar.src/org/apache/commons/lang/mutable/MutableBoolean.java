package org.apache.commons.lang.mutable;

import java.io.Serializable;

import org.apache.commons.lang.BooleanUtils;

public class MutableBoolean
        implements Mutable, Serializable, Comparable {
    private static final long serialVersionUID = -4830728138360036487L;
    private boolean value;

    public MutableBoolean() {
    }

    public MutableBoolean(Boolean paramBoolean) {
        this.value = paramBoolean.booleanValue();
    }

    public MutableBoolean(boolean paramBoolean) {
        this.value = paramBoolean;
    }

    public boolean booleanValue() {
        return this.value;
    }

    public int compareTo(Object paramObject) {
        boolean bool = ((MutableBoolean) paramObject).value;
        if (this.value == bool) {
            return 0;
        }
        if (this.value) {
            return 1;
        }
        return -1;
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((paramObject instanceof MutableBoolean)) {
            bool1 = bool2;
            if (this.value == ((MutableBoolean) paramObject).booleanValue()) {
                bool1 = true;
            }
        }
        return bool1;
    }

    public Object getValue() {
        return BooleanUtils.toBooleanObject(this.value);
    }

    public int hashCode() {
        if (this.value) {
            return Boolean.TRUE.hashCode();
        }
        return Boolean.FALSE.hashCode();
    }

    public boolean isFalse() {
        return !this.value;
    }

    public boolean isTrue() {
        return this.value == true;
    }

    public void setValue(Object paramObject) {
        setValue(((Boolean) paramObject).booleanValue());
    }

    public void setValue(boolean paramBoolean) {
        this.value = paramBoolean;
    }

    public Boolean toBoolean() {
        return BooleanUtils.toBooleanObject(this.value);
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/mutable/MutableBoolean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */