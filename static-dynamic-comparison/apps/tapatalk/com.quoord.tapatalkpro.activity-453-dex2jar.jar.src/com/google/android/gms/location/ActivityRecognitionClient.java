package com.google.android.gms.location;

import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.hc;

public class ActivityRecognitionClient
        implements GooglePlayServicesClient {
    private final hc NO;

    public ActivityRecognitionClient(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
        this.NO = new hc(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, "activity_recognition");
    }

    public void connect() {
        this.NO.connect();
    }

    public void disconnect() {
        this.NO.disconnect();
    }

    public boolean isConnected() {
        return this.NO.isConnected();
    }

    public boolean isConnecting() {
        return this.NO.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks) {
        return this.NO.isConnectionCallbacksRegistered(paramConnectionCallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
        return this.NO.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
    }

    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks) {
        this.NO.registerConnectionCallbacks(paramConnectionCallbacks);
    }

    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
        this.NO.registerConnectionFailedListener(paramOnConnectionFailedListener);
    }

    public void removeActivityUpdates(PendingIntent paramPendingIntent) {
        this.NO.removeActivityUpdates(paramPendingIntent);
    }

    public void requestActivityUpdates(long paramLong, PendingIntent paramPendingIntent) {
        this.NO.requestActivityUpdates(paramLong, paramPendingIntent);
    }

    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks) {
        this.NO.unregisterConnectionCallbacks(paramConnectionCallbacks);
    }

    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
        this.NO.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/location/ActivityRecognitionClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */