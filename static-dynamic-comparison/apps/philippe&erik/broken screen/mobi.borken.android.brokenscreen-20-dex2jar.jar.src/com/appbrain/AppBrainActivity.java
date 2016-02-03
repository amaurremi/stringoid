package com.appbrain;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import com.appbrain.a.cz;

public class AppBrainActivity
  extends Activity
{
  private a a;
  private long b;
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.a.c();
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
      this.a.f();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool1 = true;
    if ((this.a.d()) && (paramInt == 4) && (SystemClock.elapsedRealtime() < this.b + 1500L)) {}
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
    cz.a().g();
    return bool2;
  }
  
  protected void onPause()
  {
    this.a.b();
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.a.a();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.a.b(paramBundle);
  }
  
  protected void onStart()
  {
    super.onStart();
    a locala = this.a;
  }
  
  public void onStop()
  {
    this.a.e();
    super.onStop();
  }
  
  public static abstract class a
  {
    public void a() {}
    
    public abstract void a(Bundle paramBundle);
    
    public boolean a(int paramInt)
    {
      return false;
    }
    
    public void b() {}
    
    public void b(Bundle paramBundle) {}
    
    public void c() {}
    
    public boolean d()
    {
      return false;
    }
    
    public void e() {}
    
    public void f() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/AppBrainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */