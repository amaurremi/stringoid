/*    */
package android.os;
/*    */ 
/*    */

import java.util.ArrayList;

/*    */
/*  5 */ public final class Bundle implements Parcelable, Cloneable {
    public Bundle() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public Bundle(ClassLoader loader) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public Bundle(int capacity) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public Bundle(Bundle b) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void setClassLoader(ClassLoader loader) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public ClassLoader getClassLoader() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int size() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean isEmpty() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void clear() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public boolean containsKey(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public Object get(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void remove(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void putAll(Bundle map) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public java.util.Set<String> keySet() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public boolean hasFileDescriptors() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void putBoolean(String key, boolean value) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void putByte(String key, byte value) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void putChar(String key, char value) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void putShort(String key, short value) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void putInt(String key, int value) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void putLong(String key, long value) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void putFloat(String key, float value) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void putDouble(String key, double value) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void putString(String key, String value) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void putCharSequence(String key, CharSequence value) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void putParcelable(String key, Parcelable value) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void putParcelableArray(String key, Parcelable[] value) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void putParcelableArrayList(String key, ArrayList<? extends Parcelable> value) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void putSparseParcelableArray(String key, android.util.SparseArray<? extends Parcelable> value) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void putIntegerArrayList(String key, ArrayList<Integer> value) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void putStringArrayList(String key, ArrayList<String> value) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void putCharSequenceArrayList(String key, ArrayList<CharSequence> value) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void putSerializable(String key, java.io.Serializable value) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void putBooleanArray(String key, boolean[] value) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void putByteArray(String key, byte[] value) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public void putShortArray(String key, short[] value) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public void putCharArray(String key, char[] value) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public void putIntArray(String key, int[] value) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void putLongArray(String key, long[] value) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public void putFloatArray(String key, float[] value) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public void putDoubleArray(String key, double[] value) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public void putStringArray(String key, String[] value) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public void putCharSequenceArray(String key, CharSequence[] value) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public void putBundle(String key, Bundle value) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public boolean getBoolean(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public boolean getBoolean(String key, boolean defaultValue) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public byte getByte(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public Byte getByte(String key, byte defaultValue) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public char getChar(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public char getChar(String key, char defaultValue) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public short getShort(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public short getShort(String key, short defaultValue) {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public int getInt(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public int getInt(String key, int defaultValue) {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public long getLong(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public long getLong(String key, long defaultValue) {
        throw new RuntimeException("Stub!");
    }

    /* 62 */
    public float getFloat(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 63 */
    public float getFloat(String key, float defaultValue) {
        throw new RuntimeException("Stub!");
    }

    /* 64 */
    public double getDouble(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 65 */
    public double getDouble(String key, double defaultValue) {
        throw new RuntimeException("Stub!");
    }

    /* 66 */
    public String getString(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 67 */
    public String getString(String key, String defaultValue) {
        throw new RuntimeException("Stub!");
    }

    /* 68 */
    public CharSequence getCharSequence(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 69 */
    public CharSequence getCharSequence(String key, CharSequence defaultValue) {
        throw new RuntimeException("Stub!");
    }

    /* 70 */
    public Bundle getBundle(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 71 */
    public <T extends Parcelable> T getParcelable(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 72 */
    public Parcelable[] getParcelableArray(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 73 */
    public <T extends Parcelable> ArrayList<T> getParcelableArrayList(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 74 */
    public <T extends Parcelable> android.util.SparseArray<T> getSparseParcelableArray(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 75 */
    public java.io.Serializable getSerializable(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 76 */
    public ArrayList<Integer> getIntegerArrayList(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 77 */
    public ArrayList<String> getStringArrayList(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 78 */
    public ArrayList<CharSequence> getCharSequenceArrayList(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 79 */
    public boolean[] getBooleanArray(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 80 */
    public byte[] getByteArray(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 81 */
    public short[] getShortArray(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 82 */
    public char[] getCharArray(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 83 */
    public int[] getIntArray(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 84 */
    public long[] getLongArray(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 85 */
    public float[] getFloatArray(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 86 */
    public double[] getDoubleArray(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 87 */
    public String[] getStringArray(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 88 */
    public CharSequence[] getCharSequenceArray(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 89 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 90 */
    public void writeToParcel(Parcel parcel, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 91 */
    public void readFromParcel(Parcel parcel) {
        throw new RuntimeException("Stub!");
    }

    /* 92 */
    public synchronized String toString() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/* 95 */   public static final Parcelable.Creator<Bundle> CREATOR = null;
    public static final Bundle EMPTY = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/Bundle.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */