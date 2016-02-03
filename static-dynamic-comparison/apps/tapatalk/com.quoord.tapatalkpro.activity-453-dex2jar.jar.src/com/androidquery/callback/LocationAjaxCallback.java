package com.androidquery.callback;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.androidquery.util.AQUtility;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class LocationAjaxCallback
        extends AbstractAjaxCallback<Location, LocationAjaxCallback> {
    private float accuracy = 1000.0F;
    private boolean gpsEnabled = false;
    private Listener gpsListener;
    private long initTime;
    private long interval = 1000L;
    private int iteration = 3;
    private LocationManager lm;
    private int n = 0;
    private boolean networkEnabled = false;
    private Listener networkListener;
    private long timeout = 30000L;
    private float tolerance = 10.0F;

    public LocationAjaxCallback() {
        ((LocationAjaxCallback) type(Location.class)).url("device");
    }

    private void callback(Location paramLocation) {
        this.result = paramLocation;
        status(paramLocation, 200);
        callback();
    }

    private void check(Location paramLocation) {
        int i;
        boolean bool2;
        boolean bool3;
        if ((paramLocation != null) && (isBetter(paramLocation))) {
            this.n += 1;
            if (this.n < this.iteration) {
                break label134;
            }
            i = 1;
            bool2 = isAccurate(paramLocation);
            bool3 = isDiff(paramLocation);
            if ((!this.gpsEnabled) || ("gps".equals(paramLocation.getProvider()))) {
                break label139;
            }
        }
        label134:
        label139:
        for (boolean bool1 = false; ; bool1 = true) {
            AQUtility.debug(Integer.valueOf(this.n), Integer.valueOf(this.iteration));
            AQUtility.debug("acc", Boolean.valueOf(bool2));
            AQUtility.debug("best", Boolean.valueOf(bool1));
            if (bool3) {
                if (i == 0) {
                    break label144;
                }
                if ((bool2) && (bool1)) {
                    stop();
                    callback(paramLocation);
                }
            }
            return;
            i = 0;
            break;
        }
        label144:
        if ((bool2) && (bool1)) {
            stop();
        }
        callback(paramLocation);
    }

    private static float distFrom(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
        double d = Math.toRadians(paramDouble3 - paramDouble1);
        paramDouble2 = Math.toRadians(paramDouble4 - paramDouble2);
        paramDouble1 = Math.sin(d / 2.0D) * Math.sin(d / 2.0D) + Math.cos(Math.toRadians(paramDouble1)) * Math.cos(Math.toRadians(paramDouble3)) * Math.sin(paramDouble2 / 2.0D) * Math.sin(paramDouble2 / 2.0D);
        return (float) (3958.75D * (2.0D * Math.atan2(Math.sqrt(paramDouble1), Math.sqrt(1.0D - paramDouble1)))) * 'ى';
    }

    private void failure() {
        if ((this.gpsListener == null) && (this.networkListener == null)) {
            return;
        }
        AQUtility.debug("fail");
        this.result = null;
        status(null, -103);
        stop();
        callback();
    }

    private Location getBestLocation() {
        Location localLocation1 = this.lm.getLastKnownLocation("gps");
        Location localLocation2 = this.lm.getLastKnownLocation("network");
        if (localLocation2 == null) {
        }
        do {
            return localLocation1;
            if (localLocation1 == null) {
                return localLocation2;
            }
        } while (localLocation1.getTime() > localLocation2.getTime());
        return localLocation2;
    }

    private boolean isAccurate(Location paramLocation) {
        return paramLocation.getAccuracy() < this.accuracy;
    }

    private boolean isBetter(Location paramLocation) {
        if (this.result == null) {
            return true;
        }
        if ((((Location) this.result).getTime() > this.initTime) && (((Location) this.result).getProvider().equals("gps")) && (paramLocation.getProvider().equals("network"))) {
            AQUtility.debug("inferior location");
            return false;
        }
        return true;
    }

    private boolean isDiff(Location paramLocation) {
        if (this.result == null) {
            return true;
        }
        if (distFrom(((Location) this.result).getLatitude(), ((Location) this.result).getLongitude(), paramLocation.getLatitude(), paramLocation.getLongitude()) < this.tolerance) {
            AQUtility.debug("duplicate location");
            return false;
        }
        return true;
    }

    private void status(Location paramLocation, int paramInt) {
        if (this.status == null) {
            this.status = new AjaxStatus();
        }
        if (paramLocation != null) {
            this.status.time(new Date(paramLocation.getTime()));
        }
        this.status.code(paramInt).done().source(5);
    }

    private void work() {
        Location localLocation = getBestLocation();
        Timer localTimer = new Timer(false);
        if (this.networkEnabled) {
            AQUtility.debug("register net");
            this.networkListener = new Listener(null);
            this.lm.requestLocationUpdates("network", this.interval, 0.0F, this.networkListener, Looper.getMainLooper());
            localTimer.schedule(this.networkListener, this.timeout);
        }
        if (this.gpsEnabled) {
            AQUtility.debug("register gps");
            this.gpsListener = new Listener(null);
            this.lm.requestLocationUpdates("gps", this.interval, 0.0F, this.gpsListener, Looper.getMainLooper());
            localTimer.schedule(this.gpsListener, this.timeout);
        }
        if ((this.iteration > 1) && (localLocation != null)) {
            this.n += 1;
            callback(localLocation);
        }
        this.initTime = System.currentTimeMillis();
    }

    public LocationAjaxCallback accuracy(float paramFloat) {
        this.accuracy = paramFloat;
        return this;
    }

    public void async(Context paramContext) {
        this.lm = ((LocationManager) paramContext.getSystemService("location"));
        this.gpsEnabled = this.lm.isProviderEnabled("gps");
        this.networkEnabled = this.lm.isProviderEnabled("network");
        work();
    }

    public LocationAjaxCallback iteration(int paramInt) {
        this.iteration = paramInt;
        return this;
    }

    public void stop() {
        AQUtility.debug("stop");
        Listener localListener = this.gpsListener;
        if (localListener != null) {
            this.lm.removeUpdates(localListener);
            localListener.cancel();
        }
        localListener = this.networkListener;
        if (localListener != null) {
            this.lm.removeUpdates(localListener);
            localListener.cancel();
        }
        this.gpsListener = null;
        this.networkListener = null;
    }

    public LocationAjaxCallback timeout(long paramLong) {
        this.timeout = paramLong;
        return this;
    }

    public LocationAjaxCallback tolerance(float paramFloat) {
        this.tolerance = paramFloat;
        return this;
    }

    private class Listener
            extends TimerTask
            implements LocationListener {
        private Listener() {
        }

        public void onLocationChanged(Location paramLocation) {
            AQUtility.debug("changed", paramLocation);
            LocationAjaxCallback.this.check(paramLocation);
        }

        public void onProviderDisabled(String paramString) {
            AQUtility.debug("onProviderDisabled");
        }

        public void onProviderEnabled(String paramString) {
            AQUtility.debug("onProviderEnabled");
            LocationAjaxCallback.this.check(LocationAjaxCallback.access$1(LocationAjaxCallback.this));
            LocationAjaxCallback.this.lm.removeUpdates(this);
        }

        public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {
            AQUtility.debug("onStatusChanged");
        }

        public void run() {
            LocationAjaxCallback.this.failure();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/callback/LocationAjaxCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */