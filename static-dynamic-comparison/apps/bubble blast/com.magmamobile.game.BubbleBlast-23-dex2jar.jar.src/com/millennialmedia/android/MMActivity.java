package com.millennialmedia.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class MMActivity
  extends Activity
{
  private MMBaseActivity activity;
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.activity != null) {
      return this.activity.dispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  boolean dispatchTouchEventSuper(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.activity != null)
    {
      this.activity.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  void onActivityResultSuper(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject = null;
    try
    {
      String str = getIntent().getStringExtra("class");
      localObject = str;
      this.activity = ((MMBaseActivity)Class.forName(str).newInstance());
      localObject = str;
      this.activity.activity = this;
      localObject = str;
      this.activity.onCreate(paramBundle);
      return;
    }
    catch (Exception localException)
    {
      MMAdViewSDK.Log.e("Could not start activity for %s. %s", new Object[] { localObject, localException.getMessage() });
      localException.printStackTrace();
      super.onCreate(paramBundle);
      finish();
    }
  }
  
  void onCreateSuper(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    if (this.activity != null)
    {
      this.activity.onDestroy();
      return;
    }
    super.onDestroy();
  }
  
  void onDestroySuper()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.activity != null) {
      return this.activity.onKeyDown(paramInt, paramKeyEvent);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  boolean onKeyDownSuper(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    if (this.activity != null)
    {
      this.activity.onPause();
      return;
    }
    super.onPause();
  }
  
  void onPauseSuper()
  {
    super.onPause();
  }
  
  protected void onRestart()
  {
    if (this.activity != null)
    {
      this.activity.onRestart();
      return;
    }
    super.onRestart();
  }
  
  void onRestartSuper()
  {
    super.onRestart();
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    if (this.activity != null)
    {
      this.activity.onRestoreInstanceState(paramBundle);
      return;
    }
    super.onRestoreInstanceState(paramBundle);
  }
  
  void onRestoreInstanceStateSuper(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
  }
  
  protected void onResume()
  {
    if (this.activity != null)
    {
      this.activity.onResume();
      return;
    }
    super.onResume();
  }
  
  void onResumeSuper()
  {
    super.onResume();
  }
  
  public Object onRetainNonConfigurationInstance()
  {
    if (this.activity != null) {
      return this.activity.onRetainNonConfigurationInstance();
    }
    return super.onRetainNonConfigurationInstance();
  }
  
  Object onRetainNonConfigurationInstanceSuper()
  {
    return super.onRetainNonConfigurationInstance();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.activity != null)
    {
      this.activity.onSaveInstanceState(paramBundle);
      return;
    }
    super.onSaveInstanceState(paramBundle);
  }
  
  void onSaveInstanceStateSuper(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void onStart()
  {
    if (this.activity != null)
    {
      this.activity.onStart();
      return;
    }
    super.onStart();
  }
  
  void onStartSuper()
  {
    super.onStart();
  }
  
  protected void onStop()
  {
    if (this.activity != null)
    {
      this.activity.onStop();
      return;
    }
    super.onStop();
  }
  
  void onStopSuper()
  {
    super.onStop();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/millennialmedia/android/MMActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */