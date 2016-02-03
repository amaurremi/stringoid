package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class UiSettings {
    private final IUiSettingsDelegate Sy;

    UiSettings(IUiSettingsDelegate paramIUiSettingsDelegate) {
        this.Sy = paramIUiSettingsDelegate;
    }

    public boolean isCompassEnabled() {
        try {
            boolean bool = this.Sy.isCompassEnabled();
            return bool;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public boolean isIndoorLevelPickerEnabled() {
        try {
            boolean bool = this.Sy.isIndoorLevelPickerEnabled();
            return bool;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public boolean isMyLocationButtonEnabled() {
        try {
            boolean bool = this.Sy.isMyLocationButtonEnabled();
            return bool;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public boolean isRotateGesturesEnabled() {
        try {
            boolean bool = this.Sy.isRotateGesturesEnabled();
            return bool;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public boolean isScrollGesturesEnabled() {
        try {
            boolean bool = this.Sy.isScrollGesturesEnabled();
            return bool;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public boolean isTiltGesturesEnabled() {
        try {
            boolean bool = this.Sy.isTiltGesturesEnabled();
            return bool;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public boolean isZoomControlsEnabled() {
        try {
            boolean bool = this.Sy.isZoomControlsEnabled();
            return bool;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            boolean bool = this.Sy.isZoomGesturesEnabled();
            return bool;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void setAllGesturesEnabled(boolean paramBoolean) {
        try {
            this.Sy.setAllGesturesEnabled(paramBoolean);
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void setCompassEnabled(boolean paramBoolean) {
        try {
            this.Sy.setCompassEnabled(paramBoolean);
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void setIndoorLevelPickerEnabled(boolean paramBoolean) {
        try {
            this.Sy.setIndoorLevelPickerEnabled(paramBoolean);
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void setMyLocationButtonEnabled(boolean paramBoolean) {
        try {
            this.Sy.setMyLocationButtonEnabled(paramBoolean);
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void setRotateGesturesEnabled(boolean paramBoolean) {
        try {
            this.Sy.setRotateGesturesEnabled(paramBoolean);
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void setScrollGesturesEnabled(boolean paramBoolean) {
        try {
            this.Sy.setScrollGesturesEnabled(paramBoolean);
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void setTiltGesturesEnabled(boolean paramBoolean) {
        try {
            this.Sy.setTiltGesturesEnabled(paramBoolean);
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void setZoomControlsEnabled(boolean paramBoolean) {
        try {
            this.Sy.setZoomControlsEnabled(paramBoolean);
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public void setZoomGesturesEnabled(boolean paramBoolean) {
        try {
            this.Sy.setZoomGesturesEnabled(paramBoolean);
            return;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/UiSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */