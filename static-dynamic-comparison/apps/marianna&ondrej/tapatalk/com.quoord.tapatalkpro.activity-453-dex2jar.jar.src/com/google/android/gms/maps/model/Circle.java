package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.model.internal.b;

public final class Circle {
    private final b SH;

    public Circle(b paramb) {
        this.SH = ((b) fq.f(paramb));
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof Circle)) {
            return false;
        }
        try {
            boolean bool = this.SH.a(((Circle) paramObject).SH);
            return bool;
        } catch (RemoteException paramObject) {
            throw new RuntimeRemoteException((RemoteException) paramObject);
        }
    }

    public LatLng getCenter() {
        try {
            LatLng localLatLng = this.SH.getCenter();
            return localLatLng;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public int getFillColor() {
        try {
            int i = this.SH.getFillColor();
            return i;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public String getId() {
        try {
            String str = this.SH.getId();
            return str;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public double getRadius() {
        try {
            double d = this.SH.getRadius();
            return d;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public int getStrokeColor() {
        try {
            int i = this.SH.getStrokeColor();
            return i;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public float getStrokeWidth() {
        try {
            float f = this.SH.getStrokeWidth();
            return f;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public float getZIndex() {
        try {
            float f = this.SH.getZIndex();
            return f;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public int hashCode() {
        try {
            int i = this.SH.hashCodeRemote();
            return i;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public boolean isVisible() {
        try {
            boolean bool = this.SH.isVisible();
            return bool;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void remove() {
        try {
            this.SH.remove();
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void setCenter(LatLng paramLatLng) {
        try {
            this.SH.setCenter(paramLatLng);
            return;
        } catch (RemoteException paramLatLng) {
            throw new RuntimeRemoteException(paramLatLng);
        }
    }

    public void setFillColor(int paramInt) {
        try {
            this.SH.setFillColor(paramInt);
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void setRadius(double paramDouble) {
        try {
            this.SH.setRadius(paramDouble);
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void setStrokeColor(int paramInt) {
        try {
            this.SH.setStrokeColor(paramInt);
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void setStrokeWidth(float paramFloat) {
        try {
            this.SH.setStrokeWidth(paramFloat);
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void setVisible(boolean paramBoolean) {
        try {
            this.SH.setVisible(paramBoolean);
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void setZIndex(float paramFloat) {
        try {
            this.SH.setZIndex(paramFloat);
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/model/Circle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */