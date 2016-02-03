package android.content;

import android.content.res.Configuration;

public abstract interface ComponentCallbacks {
    public abstract void onConfigurationChanged(Configuration paramConfiguration);

    public abstract void onLowMemory();
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/ComponentCallbacks.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */