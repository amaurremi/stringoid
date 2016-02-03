package android.support.v7.a;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ab;
import android.support.v4.app.ac;
import android.support.v4.app.h;
import android.support.v4.app.u;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class f
  extends h
  implements ac, b
{
  g n;
  
  public Intent a()
  {
    return u.a(this);
  }
  
  void a(int paramInt)
  {
    super.setContentView(paramInt);
  }
  
  public void a(ab paramab)
  {
    paramab.a(this);
  }
  
  public void a(android.support.v7.c.a parama) {}
  
  void a(View paramView)
  {
    super.setContentView(paramView);
  }
  
  void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(paramView, paramLayoutParams);
  }
  
  boolean a(int paramInt, Menu paramMenu)
  {
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  boolean a(int paramInt, MenuItem paramMenuItem)
  {
    return super.onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  boolean a(int paramInt, View paramView, Menu paramMenu)
  {
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public boolean a(Intent paramIntent)
  {
    return u.a(this, paramIntent);
  }
  
  protected boolean a(View paramView, Menu paramMenu)
  {
    return this.n.a(paramView, paramMenu);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.n.b(paramView, paramLayoutParams);
  }
  
  public void b(Intent paramIntent)
  {
    u.b(this, paramIntent);
  }
  
  public void b(ab paramab) {}
  
  public void b(android.support.v7.c.a parama) {}
  
  void b(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addContentView(paramView, paramLayoutParams);
  }
  
  boolean b(View paramView, Menu paramMenu)
  {
    return super.a(paramView, paramMenu);
  }
  
  public void c()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.c();
    }
    this.n.f();
  }
  
  public a f()
  {
    return this.n.b();
  }
  
  public boolean g()
  {
    Object localObject = a();
    if (localObject != null)
    {
      if (a((Intent)localObject))
      {
        localObject = ab.a(this);
        a((ab)localObject);
        b((ab)localObject);
        ((ab)localObject).a();
      }
      for (;;)
      {
        try
        {
          android.support.v4.app.a.a(this);
          return true;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          finish();
          continue;
        }
        b(localIllegalStateException);
      }
    }
    return false;
  }
  
  public MenuInflater getMenuInflater()
  {
    return this.n.c();
  }
  
  public void h() {}
  
  public void onBackPressed()
  {
    if (!this.n.g()) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.n.a(paramConfiguration);
  }
  
  public final void onContentChanged()
  {
    this.n.h();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.n = g.a(this);
    super.onCreate(paramBundle);
    this.n.a(paramBundle);
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    return this.n.a(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    if (paramInt == 0) {
      return this.n.b(paramInt);
    }
    return super.onCreatePanelView(paramInt);
  }
  
  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (this.n.a(paramInt, paramMenuItem)) {
      return true;
    }
    a locala = f();
    if ((paramMenuItem.getItemId() == 16908332) && (locala != null) && ((locala.a() & 0x4) != 0)) {
      return g();
    }
    return false;
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    this.n.e();
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    return this.n.a(paramInt, paramView, paramMenu);
  }
  
  protected void onStop()
  {
    super.onStop();
    this.n.d();
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    this.n.a(paramCharSequence);
  }
  
  public void setContentView(int paramInt)
  {
    this.n.a(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    this.n.a(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.n.a(paramView, paramLayoutParams);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */