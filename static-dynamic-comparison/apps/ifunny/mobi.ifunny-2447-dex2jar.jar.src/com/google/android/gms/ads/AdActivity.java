package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.internal.fw;
import com.google.android.gms.internal.fy;
import com.google.android.gms.internal.mx;

public final class AdActivity
        extends Activity {
    private fy a;

    private void a() {
        if (this.a != null) {
        }
        try {
            this.a.j();
            return;
        } catch (RemoteException localRemoteException) {
            mx.d("Could not forward setContentViewSet to ad overlay:", localRemoteException);
        }
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.a = fw.a(this);
        if (this.a == null) {
            mx.e("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.a.a(paramBundle);
            return;
        } catch (RemoteException paramBundle) {
            mx.d("Could not forward onCreate to ad overlay:", paramBundle);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.a != null) {
                this.a.i();
            }
            super.onDestroy();
            return;
        } catch (RemoteException localRemoteException) {
            for (; ; ) {
                mx.d("Could not forward onDestroy to ad overlay:", localRemoteException);
            }
        }
    }

    protected void onPause() {
        try {
            if (this.a != null) {
                this.a.g();
            }
            super.onPause();
            return;
        } catch (RemoteException localRemoteException) {
            for (; ; ) {
                mx.d("Could not forward onPause to ad overlay:", localRemoteException);
                finish();
            }
        }
    }

    protected void onRestart() {
        super.onRestart();
        try {
            if (this.a != null) {
                this.a.d();
            }
            return;
        } catch (RemoteException localRemoteException) {
            mx.d("Could not forward onRestart to ad overlay:", localRemoteException);
            finish();
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            if (this.a != null) {
                this.a.f();
            }
            return;
        } catch (RemoteException localRemoteException) {
            mx.d("Could not forward onResume to ad overlay:", localRemoteException);
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        try {
            if (this.a != null) {
                this.a.b(paramBundle);
            }
            super.onSaveInstanceState(paramBundle);
            return;
        } catch (RemoteException localRemoteException) {
            for (; ; ) {
                mx.d("Could not forward onSaveInstanceState to ad overlay:", localRemoteException);
                finish();
            }
        }
    }

    protected void onStart() {
        super.onStart();
        try {
            if (this.a != null) {
                this.a.e();
            }
            return;
        } catch (RemoteException localRemoteException) {
            mx.d("Could not forward onStart to ad overlay:", localRemoteException);
            finish();
        }
    }

    protected void onStop() {
        try {
            if (this.a != null) {
                this.a.h();
            }
            super.onStop();
            return;
        } catch (RemoteException localRemoteException) {
            for (; ; ) {
                mx.d("Could not forward onStop to ad overlay:", localRemoteException);
                finish();
            }
        }
    }

    public void setContentView(int paramInt) {
        super.setContentView(paramInt);
        a();
    }

    public void setContentView(View paramView) {
        super.setContentView(paramView);
        a();
    }

    public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
        super.setContentView(paramView, paramLayoutParams);
        a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/ads/AdActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */