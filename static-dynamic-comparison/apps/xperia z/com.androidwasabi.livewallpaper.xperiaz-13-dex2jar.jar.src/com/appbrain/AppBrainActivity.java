package com.appbrain;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import com.appbrain.a.ao;

public class AppBrainActivity
  extends Activity
{
  private f a;
  private long b;
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.a.a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    cmn.a.a().a(this);
    super.onCreate(paramBundle);
    this.b = SystemClock.elapsedRealtime();
    this.a = com.appbrain.a.a.a(this);
    if (this.a == null)
    {
      finish();
      return;
    }
    this.a.a(paramBundle);
  }
  
  protected void onDestroy()
  {
    if (this.a != null) {
      this.a.d();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool1 = true;
    if ((this.a.c()) && (paramInt == 4) && (SystemClock.elapsedRealtime() < this.b + 1500L)) {}
    boolean bool2;
    do
    {
      do
      {
        return bool1;
      } while (this.a.a(paramInt));
      bool2 = super.onKeyDown(paramInt, paramKeyEvent);
      bool1 = bool2;
    } while (!bool2);
    ao.a().g();
    return bool2;
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.a.b(paramBundle);
  }
  
  public void onStop()
  {
    this.a.b();
    super.onStop();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/AppBrainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */