package com.everimaging.fotorsdk.store;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v8.renderscript.RenderScript;
import com.everimaging.fotorsdk.FotorSDKInitiator;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.services.PluginService;
import com.everimaging.fotorsdk.store.billing.c;
import com.everimaging.fotorsdk.store.iap.a;
import com.everimaging.fotorsdk.store.iap.a.a;
import com.everimaging.fotorsdk.store.iap.a.c;

public class FotorStoreActivity
        extends com.everimaging.fotorsdk.engine.b
        implements FotorStoreFragment.b, i {
    private static final String a = FotorStoreActivity.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private FotorStoreFragment c;
    private Handler d = new Handler();
    private a e;

    private Bundle f() {
        Bundle localBundle = new Bundle();
        Intent localIntent = getIntent();
        if (localIntent.hasExtra("arg_feature_type")) {
            localBundle.putString("arg_feature_type", localIntent.getStringExtra("arg_feature_type"));
        }
        if (localIntent.hasExtra("arg_package_info")) {
            localBundle.putParcelable("arg_package_info", localIntent.getParcelableExtra("arg_package_info"));
        }
        if (localIntent.hasExtra("arg_preview_src")) {
            localBundle.putString("arg_preview_src", localIntent.getStringExtra("arg_preview_src"));
        }
        return localBundle;
    }

    public <T> T a(Class<T> paramClass) {
        try {
            paramClass = com.everimaging.fotorsdk.services.b.a().b(paramClass);
            return paramClass;
        } catch (Exception paramClass) {
            paramClass.printStackTrace();
        }
        return null;
    }

    public void a() {
        if (this.c != null) {
            this.c = null;
        }
        finish();
    }

    public PluginService b() {
        return (PluginService) a(PluginService.class);
    }

    public RenderScript c() {
        return FotorSDKInitiator.a();
    }

    public com.everimaging.fotorsdk.algorithms.filter.d d() {
        return FotorSDKInitiator.b();
    }

    public Handler e() {
        return this.d;
    }

    public FragmentActivity g() {
        return this;
    }

    public boolean l() {
        return true;
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if (this.e == null) {
            return;
        }
        if (!this.e.a(paramInt1, paramInt2, paramIntent)) {
            super.onActivityResult(paramInt1, paramInt2, paramIntent);
            return;
        }
        b.c(new Object[]{"onActivityResult handled  by IabManager"});
    }

    public void onBackPressed() {
        if (this.c != null) {
            this.c.b();
            return;
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        h.a(this);
        paramBundle = f();
        this.e = a.a();
        this.c = FotorStoreFragment.c();
        this.c.setArguments(paramBundle);
        this.c.a(this);
        this.c.a(getSupportFragmentManager());
        this.e.a(this, h.a(), new a.a() new a.c
        {
            public void a (c paramAnonymousc)
            {
                if (FotorStoreActivity.a(FotorStoreActivity.this) != null) {
                    FotorStoreActivity.a(FotorStoreActivity.this).a(paramAnonymousc.b());
                }
            }
        },new a.c() {
            public void a(com.everimaging.fotorsdk.store.billing.d paramAnonymousd, c paramAnonymousc) {
                if (FotorStoreActivity.a(FotorStoreActivity.this) != null) {
                    FotorStoreActivity.a(FotorStoreActivity.this).b(paramAnonymousc.b());
                }
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        h.b(this);
        if (this.e != null) {
            this.e.c();
        }
        this.e = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/FotorStoreActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */