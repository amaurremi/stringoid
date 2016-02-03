package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
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
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.t;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class StreetViewPanoramaFragment
        extends Fragment {
    private final b Si = new b(this);
    private StreetViewPanorama Sj;

    public static StreetViewPanoramaFragment newInstance() {
        return new StreetViewPanoramaFragment();
    }

    public static StreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions paramStreetViewPanoramaOptions) {
        StreetViewPanoramaFragment localStreetViewPanoramaFragment = new StreetViewPanoramaFragment();
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("StreetViewPanoramaOptions", paramStreetViewPanoramaOptions);
        localStreetViewPanoramaFragment.setArguments(localBundle);
        return localStreetViewPanoramaFragment;
    }

    public final StreetViewPanorama getStreetViewPanorama() {
        Object localObject = is();
        if (localObject == null) {
        }
        for (; ; ) {
            return null;
            try {
                localObject = ((IStreetViewPanoramaFragmentDelegate) localObject).getStreetViewPanorama();
                if (localObject == null) {
                    continue;
                }
                if ((this.Sj == null) || (this.Sj.ir().asBinder() != ((IStreetViewPanoramaDelegate) localObject).asBinder())) {
                    this.Sj = new StreetViewPanorama((IStreetViewPanoramaDelegate) localObject);
                }
                return this.Sj;
            } catch (RemoteException localRemoteException) {
                throw new RuntimeRemoteException(localRemoteException);
            }
        }
    }

    protected IStreetViewPanoramaFragmentDelegate is() {
        this.Si.ip();
        if (this.Si.fW() == null) {
            return null;
        }
        return ((a) this.Si.fW()).is();
    }

    public void onActivityCreated(Bundle paramBundle) {
        if (paramBundle != null) {
            paramBundle.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(paramBundle);
    }

    public void onAttach(Activity paramActivity) {
        super.onAttach(paramActivity);
        b.a(this.Si, paramActivity);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.Si.onCreate(paramBundle);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return this.Si.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    }

    public void onDestroy() {
        this.Si.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.Si.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle) {
        super.onInflate(paramActivity, paramAttributeSet, paramBundle);
        b.a(this.Si, paramActivity);
        paramAttributeSet = new Bundle();
        this.Si.onInflate(paramActivity, paramAttributeSet, paramBundle);
    }

    public void onLowMemory() {
        this.Si.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.Si.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.Si.onResume();
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        if (paramBundle != null) {
            paramBundle.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(paramBundle);
        this.Si.onSaveInstanceState(paramBundle);
    }

    public void setArguments(Bundle paramBundle) {
        super.setArguments(paramBundle);
    }

    static class a
            implements LifecycleDelegate {
        private final Fragment Hv;
        private final IStreetViewPanoramaFragmentDelegate Sk;

        public a(Fragment paramFragment, IStreetViewPanoramaFragmentDelegate paramIStreetViewPanoramaFragmentDelegate) {
            this.Sk = ((IStreetViewPanoramaFragmentDelegate) fq.f(paramIStreetViewPanoramaFragmentDelegate));
            this.Hv = ((Fragment) fq.f(paramFragment));
        }

        public IStreetViewPanoramaFragmentDelegate is() {
            return this.Sk;
        }

        public void onCreate(Bundle paramBundle) {
            Bundle localBundle = paramBundle;
            if (paramBundle == null) {
            }
            try {
                localBundle = new Bundle();
                paramBundle = this.Hv.getArguments();
                if ((paramBundle != null) && (paramBundle.containsKey("StreetViewPanoramaOptions"))) {
                    t.a(localBundle, "StreetViewPanoramaOptions", paramBundle.getParcelable("StreetViewPanoramaOptions"));
                }
                this.Sk.onCreate(localBundle);
                return;
            } catch (RemoteException paramBundle) {
                throw new RuntimeRemoteException(paramBundle);
            }
        }

        public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
            try {
                paramLayoutInflater = this.Sk.onCreateView(e.h(paramLayoutInflater), e.h(paramViewGroup), paramBundle);
                return (View) e.d(paramLayoutInflater);
            } catch (RemoteException paramLayoutInflater) {
                throw new RuntimeRemoteException(paramLayoutInflater);
            }
        }

        public void onDestroy() {
            try {
                this.Sk.onDestroy();
                return;
            } catch (RemoteException localRemoteException) {
                throw new RuntimeRemoteException(localRemoteException);
            }
        }

        public void onDestroyView() {
            try {
                this.Sk.onDestroyView();
                return;
            } catch (RemoteException localRemoteException) {
                throw new RuntimeRemoteException(localRemoteException);
            }
        }

        public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2) {
            try {
                this.Sk.onInflate(e.h(paramActivity), null, paramBundle2);
                return;
            } catch (RemoteException paramActivity) {
                throw new RuntimeRemoteException(paramActivity);
            }
        }

        public void onLowMemory() {
            try {
                this.Sk.onLowMemory();
                return;
            } catch (RemoteException localRemoteException) {
                throw new RuntimeRemoteException(localRemoteException);
            }
        }

        public void onPause() {
            try {
                this.Sk.onPause();
                return;
            } catch (RemoteException localRemoteException) {
                throw new RuntimeRemoteException(localRemoteException);
            }
        }

        public void onResume() {
            try {
                this.Sk.onResume();
                return;
            } catch (RemoteException localRemoteException) {
                throw new RuntimeRemoteException(localRemoteException);
            }
        }

        public void onSaveInstanceState(Bundle paramBundle) {
            try {
                this.Sk.onSaveInstanceState(paramBundle);
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
            extends a<StreetViewPanoramaFragment.a> {
        private final Fragment Hv;
        protected f<StreetViewPanoramaFragment.a> RV;
        private Activity nS;

        b(Fragment paramFragment) {
            this.Hv = paramFragment;
        }

        private void setActivity(Activity paramActivity) {
            this.nS = paramActivity;
            ip();
        }

        protected void a(f<StreetViewPanoramaFragment.a> paramf) {
            this.RV = paramf;
            ip();
        }

        public void ip() {
            if ((this.nS != null) && (this.RV != null) && (fW() == null)) {
            }
            try {
                MapsInitializer.initialize(this.nS);
                IStreetViewPanoramaFragmentDelegate localIStreetViewPanoramaFragmentDelegate = u.A(this.nS).i(e.h(this.nS));
                this.RV.a(new StreetViewPanoramaFragment.a(this.Hv, localIStreetViewPanoramaFragmentDelegate));
                return;
            } catch (RemoteException localRemoteException) {
                throw new RuntimeRemoteException(localRemoteException);
            } catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/StreetViewPanoramaFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */