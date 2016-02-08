package com.google.android.gms.maps;

import android.location.Location;

public abstract interface LocationSource {
    public abstract void activate(OnLocationChangedListener paramOnLocationChangedListener);

    public abstract void deactivate();

    public static abstract interface OnLocationChangedListener {
        public abstract void onLocationChanged(Location paramLocation);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/LocationSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */