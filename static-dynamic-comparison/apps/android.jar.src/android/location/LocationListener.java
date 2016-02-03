package android.location;

import android.os.Bundle;

public abstract interface LocationListener {
    public abstract void onLocationChanged(Location paramLocation);

    public abstract void onStatusChanged(String paramString, int paramInt, Bundle paramBundle);

    public abstract void onProviderEnabled(String paramString);

    public abstract void onProviderDisabled(String paramString);
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/location/LocationListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */