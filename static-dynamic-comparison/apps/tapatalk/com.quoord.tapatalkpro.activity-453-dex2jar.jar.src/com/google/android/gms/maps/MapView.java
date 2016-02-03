package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapView
        extends FrameLayout {
    private GoogleMap RT;
    private final b RW;

    public MapView(Context paramContext) {
        super(paramContext);
        this.RW = new b(this, paramContext, null);
    }

    public MapView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.RW = new b(this, paramContext, GoogleMapOptions.createFromAttributes(paramContext, paramAttributeSet));
    }

    public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        this.RW = new b(this, paramContext, GoogleMapOptions.createFromAttributes(paramContext, paramAttributeSet));
    }

    public MapView(Context paramContext, GoogleMapOptions paramGoogleMapOptions) {
        super(paramContext);
        this.RW = new b(this, paramContext, paramGoogleMapOptions);
    }

    public final GoogleMap getMap() {
        if (this.RT != null) {
            return this.RT;
        }
        this.RW.ip();
        if (this.RW.fW() == null) {
            return null;
        }
        try {
            this.RT = new GoogleMap(((a) this.RW.fW()).iq().getMap());
            return this.RT;
        } catch (RemoteException localRemoteException) {
            throw new RuntimeRemoteException(localRemoteException);
        }
    }

    public final void onCreate(Bundle paramBundle) {
        this.RW.onCreate(paramBundle);
        if (this.RW.fW() == null) {
            paramBundle = this.RW;
            b.b(this);
        }
    }

    public final void onDestroy() {
        this.RW.onDestroy();
    }

    public final void onLowMemory() {
        this.RW.onLowMemory();
    }

    public final void onPause() {
        this.RW.onPause();
    }

    public final void onResume() {
        this.RW.onResume();
    }

    public final void onSaveInstanceState(Bundle paramBundle) {
        this.RW.onSaveInstanceState(paramBundle);
    }

    static class a
            implements LifecycleDelegate {
        private final ViewGroup RX;
        private final IMapViewDelegate RY;
        private View RZ;

        public a(ViewGroup paramViewGroup, IMapViewDelegate paramIMapViewDelegate) {
            this.RY = ((IMapViewDelegate) fq.f(paramIMapViewDelegate));
            this.RX = ((ViewGroup) fq.f(paramViewGroup));
        }

        public IMapViewDelegate iq() {
            return this.RY;
        }

        public void onCreate(Bundle paramBundle) {
            try {
                this.RY.onCreate(paramBundle);
                this.RZ = ((View) e.d(this.RY.getView()));
                this.RX.removeAllViews();
                this.RX.addView(this.RZ);
                return;
            } catch (RemoteException paramBundle) {
                throw new RuntimeRemoteException(paramBundle);
            }
        }

        public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy() {
            try {
                this.RY.onDestroy();
                return;
            } catch (RemoteException localRemoteException) {
                throw new RuntimeRemoteException(localRemoteException);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.RY.onLowMemory();
                return;
            } catch (RemoteException localRemoteException) {
                throw new RuntimeRemoteException(localRemoteException);
            }
        }

        public void onPause() {
            try {
                this.RY.onPause();
                return;
            } catch (RemoteException localRemoteException) {
                throw new RuntimeRemoteException(localRemoteException);
            }
        }

        public void onResume() {
            try {
                this.RY.onResume();
                return;
            } catch (RemoteException localRemoteException) {
                throw new RuntimeRemoteException(localRemoteException);
            }
        }

        public void onSaveInstanceState(Bundle paramBundle) {
            try {
                this.RY.onSaveInstanceState(paramBundle);
                return;
            } catch (RemoteException paramBundle) {
                throw new RuntimeRemoteException(paramBundle);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    static class b
            extends a<MapView.a> {
        protected f<MapView.a> RV;
        private final ViewGroup Sa;
        private final GoogleMapOptions Sb;
        private final Context mContext;

        b(ViewGroup paramViewGroup, Context paramContext, GoogleMapOptions paramGoogleMapOptions) {
            this.Sa = paramViewGroup;
            this.mContext = paramContext;
            this.Sb = paramGoogleMapOptions;
        }

        protected void a(f<MapView.a> paramf) {
            this.RV = paramf;
            ip();
        }

        public void ip() {
            if ((this.RV != null) && (fW() == null)) {
            }
            try {
                IMapViewDelegate localIMapViewDelegate = u.A(this.mContext).a(e.h(this.mContext), this.Sb);
                this.RV.a(new MapView.a(this.Sa, localIMapViewDelegate));
                return;
            } catch (RemoteException localRemoteException) {
                throw new RuntimeRemoteException(localRemoteException);
            } catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/MapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */