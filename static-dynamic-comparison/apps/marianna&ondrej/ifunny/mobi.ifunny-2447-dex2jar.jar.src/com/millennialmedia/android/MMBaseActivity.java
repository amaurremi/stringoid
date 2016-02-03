package com.millennialmedia.android;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

import java.io.File;

class MMBaseActivity {
    MMActivity c;

    protected void a() {
        this.c.b();
    }

    protected void a(int paramInt1, int paramInt2, Intent paramIntent) {
        this.c.a(paramInt1, paramInt2, paramIntent);
    }

    protected void a(Bundle paramBundle) {
        this.c.b(paramBundle);
    }

    protected void b(Bundle paramBundle) {
        this.c.c(paramBundle);
    }

    protected void d() {
        this.c.e();
    }

    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
        return this.c.a(paramMotionEvent);
    }

    protected void e() {
        this.c.f();
    }

    protected void f() {
        this.c.c();
    }

    public void finish() {
        this.c.finishSuper();
    }

    public File getCacheDir() {
        return this.c.getCacheDir();
    }

    public ContentResolver getContentResolver() {
        return this.c.getContentResolver();
    }

    public Intent getIntent() {
        return this.c.getIntent();
    }

    public Object getLastNonConfigurationInstance() {
        return this.c.getLastNonConfigurationInstance();
    }

    public Object getSystemService(String paramString) {
        return this.c.getSystemService(paramString);
    }

    public Window getWindow() {
        return this.c.getWindow();
    }

    protected void k() {
        this.c.d();
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        this.c.a(paramConfiguration);
    }

    protected void onCreate(Bundle paramBundle) {
        this.c.a(paramBundle);
    }

    protected void onDestroy() {
        this.c.a();
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        return this.c.a(paramInt, paramKeyEvent);
    }

    public Object onRetainNonConfigurationInstance() {
        return this.c.g();
    }

    public void onWindowFocusChanged(boolean paramBoolean) {
        this.c.a(paramBoolean);
    }

    public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter) {
        return this.c.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
    }

    public final boolean requestWindowFeature(int paramInt) {
        return this.c.requestWindowFeature(paramInt);
    }

    public final void runOnUiThread(Runnable paramRunnable) {
        this.c.runOnUiThread(paramRunnable);
    }

    public void setContentView(View paramView) {
        this.c.setContentView(paramView);
    }

    public void setRequestedOrientation(int paramInt) {
        this.c.setRequestedOrientation(paramInt);
    }

    public final void setResult(int paramInt) {
        this.c.setResult(paramInt);
    }

    public void setTheme(int paramInt) {
        this.c.setTheme(paramInt);
    }

    public void startActivity(Intent paramIntent) {
        this.c.startActivity(paramIntent);
    }

    public void startActivityForResult(Intent paramIntent, int paramInt) {
        this.c.startActivityForResult(paramIntent, paramInt);
    }

    public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver) {
        this.c.unregisterReceiver(paramBroadcastReceiver);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */