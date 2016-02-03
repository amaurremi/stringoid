package com.millennialmedia.android;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class MMActivity
        extends Activity {
    long a;
    GestureDetector b;
    private MMBaseActivity c;

    void a() {
        super.onDestroy();
    }

    void a(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    void a(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
    }

    void a(Bundle paramBundle) {
        super.onCreate(paramBundle);
    }

    void a(boolean paramBoolean) {
        super.onWindowFocusChanged(paramBoolean);
    }

    boolean a(int paramInt, KeyEvent paramKeyEvent) {
        return super.onKeyDown(paramInt, paramKeyEvent);
    }

    boolean a(MotionEvent paramMotionEvent) {
        return super.dispatchTouchEvent(paramMotionEvent);
    }

    void b() {
        super.onStart();
    }

    void b(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
    }

    void c() {
        super.onStop();
    }

    void c(Bundle paramBundle) {
        super.onRestoreInstanceState(paramBundle);
    }

    void d() {
        super.onRestart();
    }

    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
        if (this.b != null) {
            this.b.onTouchEvent(paramMotionEvent);
        }
        if (this.c != null) {
            return this.c.dispatchTouchEvent(paramMotionEvent);
        }
        return super.dispatchTouchEvent(paramMotionEvent);
    }

    void e() {
        super.onResume();
    }

    void f() {
        super.onPause();
    }

    public void finish() {
        if (this.c != null) {
            this.c.finish();
            return;
        }
        MMSDK.Event.e(MMAdImplController.a(this.a));
        super.finish();
    }

    public void finishSuper() {
        MMSDK.Event.e(MMAdImplController.a(this.a));
        super.finish();
    }

    Object g() {
        return super.onRetainNonConfigurationInstance();
    }

    protected MMBaseActivity h() {
        return this.c;
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if (this.c != null) {
            this.c.a(paramInt1, paramInt2, paramIntent);
            return;
        }
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        if (this.c != null) {
            this.c.onConfigurationChanged(paramConfiguration);
            return;
        }
        super.onConfigurationChanged(paramConfiguration);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        Object localObject = null;
        this.a = getIntent().getLongExtra("internalId", -4L);
        try {
            String str = getIntent().getStringExtra("class");
            localObject = str;
            this.c = ((MMBaseActivity) Class.forName(str).newInstance());
            localObject = str;
            this.c.c = this;
            localObject = str;
            this.c.onCreate(paramBundle);
            localObject = str;
            this.b = new GestureDetector(getApplicationContext(), new MMActivity.InterstitialGestureListener(this));
            return;
        } catch (Exception paramBundle) {
            MMLog.a("MMActivity", String.format("Could not start activity for %s. ", new Object[]{localObject}), paramBundle);
            paramBundle.printStackTrace();
            finish();
        }
    }

    protected void onDestroy() {
        if (this.c != null) {
            this.c.onDestroy();
            return;
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if (this.c != null) {
            return this.c.onKeyDown(paramInt, paramKeyEvent);
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }

    protected void onPause() {
        if (this.c != null) {
            this.c.e();
            return;
        }
        super.onPause();
    }

    protected void onRestart() {
        if (this.c != null) {
            this.c.k();
            return;
        }
        super.onRestart();
    }

    protected void onRestoreInstanceState(Bundle paramBundle) {
        if (this.c != null) {
            this.c.b(paramBundle);
            return;
        }
        super.onRestoreInstanceState(paramBundle);
    }

    protected void onResume() {
        if (this.c != null) {
            this.c.d();
            return;
        }
        super.onResume();
    }

    public Object onRetainNonConfigurationInstance() {
        if (this.c != null) {
            return this.c.onRetainNonConfigurationInstance();
        }
        return super.onRetainNonConfigurationInstance();
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        if (this.c != null) {
            this.c.a(paramBundle);
            return;
        }
        super.onSaveInstanceState(paramBundle);
    }

    protected void onStart() {
        if (this.c != null) {
            this.c.a();
            return;
        }
        super.onStart();
    }

    protected void onStop() {
        if (this.c != null) {
            this.c.f();
            return;
        }
        super.onStop();
    }

    public void onWindowFocusChanged(boolean paramBoolean) {
        if (this.c != null) {
            this.c.onWindowFocusChanged(paramBoolean);
            return;
        }
        super.onWindowFocusChanged(paramBoolean);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */