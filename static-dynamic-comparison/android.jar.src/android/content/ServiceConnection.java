package android.content;

import android.os.IBinder;

public abstract interface ServiceConnection {
    public abstract void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder);

    public abstract void onServiceDisconnected(ComponentName paramComponentName);
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/ServiceConnection.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */