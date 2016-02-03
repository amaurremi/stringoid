package com.everimaging.fotor;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;
import com.everimaging.fotorsdk.store.h;
import com.everimaging.fotorsdk.utils.DeviceUtils;

import java.util.Map;

public abstract class b
        extends ActionBarActivity {
    private static final String a = b.class.getSimpleName();
    private static final LoggerFactory.c b = LoggerFactory.a(a, LoggerFactory.LoggerType.CONSOLE);

    protected void a(Activity paramActivity) {
        a.a(paramActivity);
    }

    protected void a(String paramString) {
        a.a(this, paramString);
    }

    protected void a(String paramString, Map<String, String> paramMap) {
        a.a(this, paramString, paramMap);
    }

    protected void b(Activity paramActivity) {
        a.b(paramActivity);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        DeviceUtils.init(this);
        if (!DeviceUtils.isTablet(this)) {
            setRequestedOrientation(1);
        }
        b.c(new Object[]{"====onCreate===:" + this});
        h.a(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        h.b(this);
    }

    protected void onPause() {
        super.onPause();
        ((App) getApplication()).a(null);
    }

    protected void onResume() {
        super.onResume();
        ((App) getApplication()).a(this);
    }

    protected void onStart() {
        super.onStart();
        a(this);
    }

    protected void onStop() {
        super.onStop();
        b(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */