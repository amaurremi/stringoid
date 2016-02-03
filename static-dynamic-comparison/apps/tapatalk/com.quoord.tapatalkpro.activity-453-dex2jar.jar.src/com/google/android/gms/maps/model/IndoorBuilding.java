package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.model.internal.d;
import com.google.android.gms.maps.model.internal.e.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class IndoorBuilding {
    private final d SY;

    public IndoorBuilding(d paramd) {
        this.SY = ((d) fq.f(paramd));
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof IndoorBuilding)) {
            return false;
        }
        try {
            boolean bool = this.SY.b(((IndoorBuilding) paramObject).SY);
            return bool;
        } catch (RemoteException paramObject) {
            throw new RuntimeRemoteException((RemoteException) paramObject);
        }
    }

    public int getActiveLevelIndex() {
        try {
            int i = this.SY.getActiveLevelIndex();
            return i;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public int getDefaultLevelIndex() {
        try {
            int i = this.SY.getActiveLevelIndex();
            return i;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public List<IndoorLevel> getLevels() {
        try {
            Object localObject = this.SY.getLevels();
            ArrayList localArrayList = new ArrayList(((List) localObject).size());
            localObject = ((List) localObject).iterator();
            while (((Iterator) localObject).hasNext()) {
                localArrayList.add(new IndoorLevel(e.a.aF((IBinder) ((Iterator) localObject).next())));
            }
            return localRemoteException;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public int hashCode() {
        try {
            int i = this.SY.hashCodeRemote();
            return i;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public boolean isUnderground() {
        try {
            boolean bool = this.SY.isUnderground();
            return bool;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/model/IndoorBuilding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */