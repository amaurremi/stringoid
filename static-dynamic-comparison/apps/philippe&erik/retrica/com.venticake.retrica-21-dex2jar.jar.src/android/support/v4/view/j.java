package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class j
{
  private final Context a;
  private k b;
  private l c;
  
  public Context a()
  {
    return this.a;
  }
  
  public View a(MenuItem paramMenuItem)
  {
    return b();
  }
  
  public void a(k paramk)
  {
    this.b = paramk;
  }
  
  public void a(l paraml)
  {
    if ((this.c != null) && (paraml != null)) {
      Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
    }
    this.c = paraml;
  }
  
  public void a(SubMenu paramSubMenu) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.a(paramBoolean);
    }
  }
  
  public abstract View b();
  
  public boolean c()
  {
    return false;
  }
  
  public boolean d()
  {
    return true;
  }
  
  public void e()
  {
    if ((this.c != null) && (c())) {
      this.c.a(d());
    }
  }
  
  public boolean f()
  {
    return false;
  }
  
  public boolean g()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/view/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */