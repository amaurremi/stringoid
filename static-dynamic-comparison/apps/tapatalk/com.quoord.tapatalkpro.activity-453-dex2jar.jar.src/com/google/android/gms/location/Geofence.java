package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.hd;

public abstract interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1L;

    public abstract String getRequestId();

    public static final class Builder {
        private String Jo = null;
        private int NU = 0;
        private long NV = Long.MIN_VALUE;
        private short NW = -1;
        private double NX;
        private double NY;
        private float NZ;
        private int Oa = 0;
        private int Ob = -1;

        public Geofence build() {
            if (this.Jo == null) {
                throw new IllegalArgumentException("Request ID not set.");
            }
            if (this.NU == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            }
            if (((this.NU & 0x4) != 0) && (this.Ob < 0)) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            }
            if (this.NV == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            }
            if (this.NW == -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            }
            if (this.Oa < 0) {
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            }
            return new hd(this.Jo, this.NU, (short) 1, this.NX, this.NY, this.NZ, this.NV, this.Oa, this.Ob);
        }

        public Builder setCircularRegion(double paramDouble1, double paramDouble2, float paramFloat) {
            this.NW = 1;
            this.NX = paramDouble1;
            this.NY = paramDouble2;
            this.NZ = paramFloat;
            return this;
        }

        public Builder setExpirationDuration(long paramLong) {
            if (paramLong < 0L) {
                this.NV = -1L;
                return this;
            }
            this.NV = (SystemClock.elapsedRealtime() + paramLong);
            return this;
        }

        public Builder setLoiteringDelay(int paramInt) {
            this.Ob = paramInt;
            return this;
        }

        public Builder setNotificationResponsiveness(int paramInt) {
            this.Oa = paramInt;
            return this;
        }

        public Builder setRequestId(String paramString) {
            this.Jo = paramString;
            return this;
        }

        public Builder setTransitionTypes(int paramInt) {
            this.NU = paramInt;
            return this;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/location/Geofence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */