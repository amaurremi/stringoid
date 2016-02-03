package org.apache.commons.lang.mutable;

public class MutableByte
        extends Number
        implements Comparable, Mutable {
    private static final long serialVersionUID = -1585823265L;
    private byte value;

    public MutableByte() {
    }

    public MutableByte(byte paramByte) {
        this.value = paramByte;
    }

    public MutableByte(Number paramNumber) {
        this.value = paramNumber.byteValue();
    }

    public MutableByte(String paramString)
            throws NumberFormatException {
        this.value = Byte.parseByte(paramString);
    }

    public void add(byte paramByte) {
        this.value = ((byte) (this.value + paramByte));
    }

    public void add(Number paramNumber) {
        this.value = ((byte) (this.value + paramNumber.byteValue()));
    }

    public byte byteValue() {
        return this.value;
    }

    public int compareTo(Object paramObject) {
        int i = ((MutableByte) paramObject).value;
        if (this.value < i) {
            return -1;
        }
        if (this.value == i) {
            return 0;
        }
        return 1;
    }

    public void decrement() {
        this.value = ((byte) (this.value - 1));
    }

    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((paramObject instanceof MutableByte)) {
            bool1 = bool2;
            if (this.value == ((MutableByte) paramObject).byteValue()) {
                bool1 = true;
            }
        }
        return bool1;
    }

    public float floatValue() {
        return this.value;
    }

    public Object getValue() {
        return new Byte(this.value);
    }

    public int hashCode() {
        return this.value;
    }

    public void increment() {
        this.value = ((byte) (this.value + 1));
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return this.value;
    }

    public void setValue(byte paramByte) {
        this.value = paramByte;
    }

    public void setValue(Object paramObject) {
        setValue(((Number) paramObject).byteValue());
    }

    public void subtract(byte paramByte) {
        this.value = ((byte) (this.value - paramByte));
    }

    public void subtract(Number paramNumber) {
        this.value = ((byte) (this.value - paramNumber.byteValue()));
    }

    public Byte toByte() {
        return new Byte(byteValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/mutable/MutableByte.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */