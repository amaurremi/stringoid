package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.t;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class SupportMapFragment
        extends Fragment {
    private GoogleMap RT;
    private final b Sw = new b(this);

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(GoogleMapOptions paramGoogleMapOptions) {
        SupportMapFragment localSupportMapFragment = new SupportMapFragment();
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("MapOptions", paramGoogleMapOptions);
        localSupportMapFragment.setArguments(localBundle);
        return localSupportMapFragment;
    }

    public final GoogleMap getMap() {
        Object localObject = io();
        if (localObject == null) {
        }
        for (; ; ) {
            return null;
            try {
                localObject = ((IMapFragmentDelegate) localObject).getMap();
                if (localObject == null) {
                    continue;
                }
                if ((this.RT == null) || (this.RT.jdMethod_if().asBinder() != ((IGoogleMapDelegate) localObject).asBinder())) {
                    this.RT = new GoogleMap((IGoogleMapDelegate) localObject);
                }
                return this.RT;
            } catch (RemoteException localRemoteException) {
                throw new RuntimeRemoteException(localRemoteException);
            }
        }
    }

    protected IMapFragmentDelegate io() {
        this.Sw.ip();
        if (this.Sw.fW() == null) {
            return null;
        }
        return ((a) this.Sw.fW()).io();
    }

    public void onActivityCreated(Bundle paramBundle) {
        if (paramBundle != null) {
            paramBundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(paramBundle);
    }

    public void onAttach(Activity paramActivity) {
        super.onAttach(paramActivity);
        b.a(this.Sw, paramActivity);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.Sw.onCreate(paramBundle);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return this.Sw.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    }

    public void onDestroy() {
        this.Sw.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.Sw.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle) {
        super.onInflate(paramActivity, paramAttributeSet, paramBundle);
        b.a(this.Sw, paramActivity);
        paramAttributeSet = GoogleMapOptions.createFromAttributes(paramActivity, paramAttributeSet);
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("MapOptions", paramAttributeSet);
        this.Sw.onInflate(paramActivity, localBundle, paramBundle);
    }

    public void onLowMemory() {
        this.Sw.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.Sw.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.Sw.onResume();
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        if (paramBundle != null) {
            paramBundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(paramBundle);
        this.Sw.onSaveInstanceState(paramBundle);
    }

    public void setArguments(Bundle paramBundle) {
        super.setArguments(paramBundle);
    }

    static class a
            implements LifecycleDelegate {
        private final Fragment Hz;
        private final IMapFragmentDelegate RU;

        public a(Fragment paramFragment, IMapFragmentDelegate paramIMapFragmentDelegate) {
            this.RU = ((IMapFragmentDelegate) fq.f(paramIMapFragmentDelegate));
            this.Hz = ((Fragment) fq.f(paramFragment));
        }

        public IMapFragmentDelegate io() {
            return this.RU;
        }

        public void onCreate(Bundle paramBundle) {
            Bundle localBundle = paramBundle;
            if (paramBundle == null) {
            }
            try {
                localBundle = new Bundle();
                paramBundle = this.Hz.getArguments();
                if ((paramBundle != null) && (paramBundle.containsKey("MapOptions"))) {
                    t.a(localBundle, "MapOptions", paramBundle.getParcelable("MapOptions"));
                }
                this.RU.onCreate(localBundle);
                return;
            } catch (RemoteException paramBundle) {
                throw new RuntimeRemoteException(paramBundle);
            }
        }

        public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
            try {
                paramLayoutInflater = this.RU.onCreateView(e.h(paramLayoutInflater), e.h(paramViewGroup), paramBundle);
                return (View) e.d(paramLayoutInflater);
            } catch (RemoteException paramLayoutInflater) {
                throw new RuntimeRemoteException(paramLayoutInflater);
            }
        }

        public void onDestroy() {
            try {
                this.RU.onDestroy();
                return;
            } catch (RemoteException localRemoteException) {
                throw new RuntimeRemoteException(localRemoteException);
            }
        }

        public void onDestroyView() {
            try {
                this.RU.onDestroyView();
                return;
            } catch (RemoteException localRemoteException) {
                throw new RuntimeRemoteException(localRemoteException);
            }
        }

        public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2) {
            paramBundle1 = (GoogleMapOptions) paramBundle1.getParcelable("MapOptions");
            try {
                this.RU.onInflate(e.h(paramActivity), paramBundle1, paramBundle2);
                return;
            } catch (RemoteException paramActivity) {
                throw new RuntimeRemoteException(paramActivity);
            }
        }

        public void onLowMemory() {
            try {
                this.RU.onLowMemory();
                return;
            } catch (RemoteException localRemoteException) {
                throw new RuntimeRemoteException(localRemoteException);
            }
        }

        public void onPause() {
            try {
                this.RU.onPause();
                return;
            } catch (RemoteException localRemoteException) {
                throw new RuntimeRemoteException(localRemoteException);
            }
        }

        public void onResume() {
            try {
                this.RU.onResume();
                return;
            } catch (RemoteException localRemoteException) {
                throw new RuntimeRemoteException(localRemoteException);
            }
        }

        public void onSaveInstanceState(Bundle paramBundle) {
            try {
                this.RU.onSaveInstanceState(paramBundle);
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
            extends a<SupportMapFragment.a> {
        private final Fragment Hz;
        protected f<SupportMapFragment.a> RV;
        private Activity nS;

        b(Fragment paramFragment) {
            this.Hz = paramFragment;
        }

        private void setActivity(Activity paramActivity) {
            this.nS = paramActivity;
            ip();
        }

        protected void a(f<SupportMapFragment.a> paramf) {
            this.RV = paramf;
            ip();
        }

        public void ip() {
            if ((this.nS != null) && (this.RV != null) && (fW() == null)) {
            }
            try {
                MapsInitializer.initialize(this.nS);
                IMapFragmentDelegate localIMapFragmentDelegate = u.A(this.nS).h(e.h(this.nS));
                this.RV.a(new SupportMapFragment.a(this.Hz, localIMapFragmentDelegate));
                return;
            } catch (RemoteException localRemoteException) {
                throw new RuntimeRemoteException(localRemoteException);
            } catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/SupportMapFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */