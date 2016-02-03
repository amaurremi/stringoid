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
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.t;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class SupportStreetViewPanoramaFragment
        extends Fragment {
    private StreetViewPanorama Sj;
    private final b Sx = new b(this);

    public static SupportStreetViewPanoramaFragment newInstance() {
        return new SupportStreetViewPanoramaFragment();
    }

    public static SupportStreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions paramStreetViewPanoramaOptions) {
        SupportStreetViewPanoramaFragment localSupportStreetViewPanoramaFragment = new SupportStreetViewPanoramaFragment();
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("StreetViewPanoramaOptions", paramStreetViewPanoramaOptions);
        localSupportStreetViewPanoramaFragment.setArguments(localBundle);
        return localSupportStreetViewPanoramaFragment;
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
        this.Sx.ip();
        if (this.Sx.fW() == null) {
            return null;
        }
        return ((a) this.Sx.fW()).is();
    }

    public void onActivityCreated(Bundle paramBundle) {
        if (paramBundle != null) {
            paramBundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(paramBundle);
    }

    public void onAttach(Activity paramActivity) {
        super.onAttach(paramActivity);
        b.a(this.Sx, paramActivity);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.Sx.onCreate(paramBundle);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return this.Sx.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    }

    public void onDestroy() {
        this.Sx.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.Sx.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle) {
        super.onInflate(paramActivity, paramAttributeSet, paramBundle);
        b.a(this.Sx, paramActivity);
        paramAttributeSet = new Bundle();
        this.Sx.onInflate(paramActivity, paramAttributeSet, paramBundle);
    }

    public void onLowMemory() {
        this.Sx.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.Sx.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.Sx.onResume();
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        if (paramBundle != null) {
            paramBundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(paramBundle);
        this.Sx.onSaveInstanceState(paramBundle);
    }

    public void setArguments(Bundle paramBundle) {
        super.setArguments(paramBundle);
    }

    static class a
            implements LifecycleDelegate {
        private final Fragment Hz;
        private final IStreetViewPanoramaFragmentDelegate Sk;

        public a(Fragment paramFragment, IStreetViewPanoramaFragmentDelegate paramIStreetViewPanoramaFragmentDelegate) {
            this.Sk = ((IStreetViewPanoramaFragmentDelegate) fq.f(paramIStreetViewPanoramaFragmentDelegate));
            this.Hz = ((Fragment) fq.f(paramFragment));
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
                paramBundle = this.Hz.getArguments();
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
            extends a<SupportStreetViewPanoramaFragment.a> {
        private final Fragment Hz;
        protected f<SupportStreetViewPanoramaFragment.a> RV;
        private Activity nS;

        b(Fragment paramFragment) {
            this.Hz = paramFragment;
        }

        private void setActivity(Activity paramActivity) {
            this.nS = paramActivity;
            ip();
        }

        protected void a(f<SupportStreetViewPanoramaFragment.a> paramf) {
            this.RV = paramf;
            ip();
        }

        public void ip() {
            if ((this.nS != null) && (this.RV != null) && (fW() == null)) {
            }
            try {
                MapsInitializer.initialize(this.nS);
                IStreetViewPanoramaFragmentDelegate localIStreetViewPanoramaFragmentDelegate = u.A(this.nS).i(e.h(this.nS));
                this.RV.a(new SupportStreetViewPanoramaFragment.a(this.Hz, localIStreetViewPanoramaFragmentDelegate));
                return;
            } catch (RemoteException localRemoteException) {
                throw new RuntimeRemoteException(localRemoteException);
            } catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/SupportStreetViewPanoramaFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */