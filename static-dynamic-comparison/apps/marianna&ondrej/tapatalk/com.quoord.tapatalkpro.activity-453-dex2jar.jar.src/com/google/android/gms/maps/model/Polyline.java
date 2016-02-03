package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;

import java.util.List;

public final class Polyline {
    private final IPolylineDelegate Tq;

    public Polyline(IPolylineDelegate paramIPolylineDelegate) {
        this.Tq = ((IPolylineDelegate) fq.f(paramIPolylineDelegate));
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof Polyline)) {
            return false;
        }
        try {
            boolean bool = this.Tq.equalsRemote(((Polyline) paramObject).Tq);
            return bool;
        } catch (RemoteException paramObject) {
            throw new RuntimeRemoteException((RemoteException) paramObject);
        }
    }

    public int getColor() {
        try {
            int i = this.Tq.getColor();
            return i;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public String getId() {
        try {
            String str = this.Tq.getId();
            return str;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public List<LatLng> getPoints() {
        try {
            List localList = this.Tq.getPoints();
            return localList;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public float getWidth() {
        try {
            float f = this.Tq.getWidth();
            return f;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public float getZIndex() {
        try {
            float f = this.Tq.getZIndex();
            return f;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public int hashCode() {
        try {
            int i = this.Tq.hashCodeRemote();
            return i;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public boolean isGeodesic() {
        try {
            boolean bool = this.Tq.isGeodesic();
            return bool;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public boolean isVisible() {
        try {
            boolean bool = this.Tq.isVisible();
            return bool;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void remove() {
        try {
            this.Tq.remove();
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void setColor(int paramInt) {
        try {
            this.Tq.setColor(paramInt);
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void setGeodesic(boolean paramBoolean) {
        try {
            this.Tq.setGeodesic(paramBoolean);
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void setPoints(List<LatLng> paramList) {
        try {
            this.Tq.setPoints(paramList);
            return;
        } catch (RemoteException paramList) {
            throw new RuntimeRemoteException(paramList);
        }
    }

    public void setVisible(boolean paramBoolean) {
        try {
            this.Tq.setVisible(paramBoolean);
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void setWidth(float paramFloat) {
        try {
            this.Tq.setWidth(paramFloat);
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void setZIndex(float paramFloat) {
        try {
            this.Tq.setZIndex(paramFloat);
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/model/Polyline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */