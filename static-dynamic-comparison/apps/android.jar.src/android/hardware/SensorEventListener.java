package android.hardware;

public abstract interface SensorEventListener {
    public abstract void onSensorChanged(SensorEvent paramSensorEvent);

    public abstract void onAccuracyChanged(Sensor paramSensor, int paramInt);
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/hardware/SensorEventListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */