package com.google.android.gms.common;

import android.os.Bundle;

public abstract interface GooglePlayServicesClient {
    public abstract void connect();

    public abstract void disconnect();

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks paramConnectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener paramOnConnectionFailedListener);

    public abstract void registerConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);

    public abstract void registerConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);

    public abstract void unregisterConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);

    public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);

    public static abstract interface ConnectionCallbacks {
        public abstract void onConnected(Bundle paramBundle);

        public abstract void onDisconnected();
    }

    public static abstract interface OnConnectionFailedListener {
        public abstract void onConnectionFailed(ConnectionResult paramConnectionResult);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/common/GooglePlayServicesClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */