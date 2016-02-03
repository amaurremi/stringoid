package org.apache.commons.lang.mutable;

import java.io.Serializable;

public class MutableObject
        implements Mutable, Serializable {
    private static final long serialVersionUID = 86241875189L;
    private Object value;

    public MutableObject() {
    }

    public MutableObject(Object paramObject) {
        this.value = paramObject;
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((paramObject instanceof MutableObject)) {
            paramObject = ((MutableObject) paramObject).value;
            if (this.value != paramObject) {
                bool1 = bool2;
                if (this.value != null) {
                    bool1 = bool2;
                    if (!this.value.equals(paramObject)) {
                    }
                }
            } else {
                bool1 = true;
            }
        }
        return bool1;
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        if (this.value == null) {
            return 0;
        }
        return this.value.hashCode();
    }

    public void setValue(Object paramObject) {
        this.value = paramObject;
    }

    public String toString() {
        if (this.value == null) {
            return "null";
        }
        return this.value.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/mutable/MutableObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */