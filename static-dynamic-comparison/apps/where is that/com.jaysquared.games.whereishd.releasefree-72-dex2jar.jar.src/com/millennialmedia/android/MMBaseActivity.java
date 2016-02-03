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

class MMBaseActivity
{
  MMActivity activity;
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.activity.dispatchTouchEventSuper(paramMotionEvent);
  }
  
  public void finish()
  {
    this.activity.finishSuper();
  }
  
  public File getCacheDir()
  {
    return this.activity.getCacheDir();
  }
  
  public ContentResolver getContentResolver()
  {
    return this.activity.getContentResolver();
  }
  
  public Intent getIntent()
  {
    return this.activity.getIntent();
  }
  
  public Object getLastNonConfigurationInstance()
  {
    return this.activity.getLastNonConfigurationInstance();
  }
  
  public Object getSystemService(String paramString)
  {
    return this.activity.getSystemService(paramString);
  }
  
  public Window getWindow()
  {
    return this.activity.getWindow();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.activity.onActivityResultSuper(paramInt1, paramInt2, paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.activity.onConfigurationChangedSuper(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.activity.onCreateSuper(paramBundle);
  }
  
  protected void onDestroy()
  {
    this.activity.onDestroySuper();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.activity.onKeyDownSuper(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    this.activity.onPauseSuper();
  }
  
  protected void onRestart()
  {
    this.activity.onRestartSuper();
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    this.activity.onRestoreInstanceStateSuper(paramBundle);
  }
  
  protected void onResume()
  {
    this.activity.onResumeSuper();
  }
  
  public Object onRetainNonConfigurationInstance()
  {
    return this.activity.onRetainNonConfigurationInstanceSuper();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    this.activity.onSaveInstanceStateSuper(paramBundle);
  }
  
  protected void onStart()
  {
    this.activity.onStartSuper();
  }
  
  protected void onStop()
  {
    this.activity.onStopSuper();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    this.activity.onWindowFocusChangedSuper(paramBoolean);
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    return this.activity.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
  }
  
  public final boolean requestWindowFeature(int paramInt)
  {
    return this.activity.requestWindowFeature(paramInt);
  }
  
  public final void runOnUiThread(Runnable paramRunnable)
  {
    this.activity.runOnUiThread(paramRunnable);
  }
  
  public void setContentView(View paramView)
  {
    this.activity.setContentView(paramView);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    this.activity.setRequestedOrientation(paramInt);
  }
  
  public final void setResult(int paramInt)
  {
    this.activity.setResult(paramInt);
  }
  
  public void setTheme(int paramInt)
  {
    this.activity.setTheme(paramInt);
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.activity.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.activity.startActivityForResult(paramIntent, paramInt);
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    this.activity.unregisterReceiver(paramBroadcastReceiver);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/MMBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */