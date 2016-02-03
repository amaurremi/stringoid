package android.hardware;

@Deprecated
public abstract interface SensorListener {
    public abstract void onSensorChanged(int paramInt, float[] paramArrayOfFloat);

    public abstract void onAccuracyChanged(int paramInt1, int paramInt2);
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/hardware/SensorListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */