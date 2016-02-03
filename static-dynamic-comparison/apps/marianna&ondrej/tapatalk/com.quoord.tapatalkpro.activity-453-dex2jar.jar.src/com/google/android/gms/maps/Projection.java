package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;

public final class Projection {
    private final IProjectionDelegate Sc;

    Projection(IProjectionDelegate paramIProjectionDelegate) {
        this.Sc = paramIProjectionDelegate;
    }

    public LatLng fromScreenLocation(Point paramPoint) {
        try {
            paramPoint = this.Sc.fromScreenLocation(e.h(paramPoint));
            return paramPoint;
        } catch (RemoteException paramPoint) {
            throw new RuntimeRemoteException(paramPoint);
        }
    }

    public VisibleRegion getVisibleRegion() {
        try {
            VisibleRegion localVisibleRegion = this.Sc.getVisibleRegion();
            return localVisibleRegion;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public Point toScreenLocation(LatLng paramLatLng) {
        try {
            paramLatLng = (Point) e.d(this.Sc.toScreenLocation(paramLatLng));
            return paramLatLng;
        } catch (RemoteException paramLatLng) {
            throw new RuntimeRemoteException(paramLatLng);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/Projection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */