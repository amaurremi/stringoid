package android.os;

public abstract interface Parcelable {
    public static final int PARCELABLE_WRITE_RETURN_VALUE = 1;
    public static final int CONTENTS_FILE_DESCRIPTOR = 1;

    public abstract int describeContents();

    public abstract void writeToParcel(Parcel paramParcel, int paramInt);

    public static abstract interface ClassLoaderCreator<T>
            extends Parcelable.Creator<T> {
        public abstract T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader);
    }

    public static abstract interface Creator<T> {
        public abstract T createFromParcel(Parcel paramParcel);

        public abstract T[] newArray(int paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/Parcelable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */