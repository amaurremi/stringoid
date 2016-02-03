package android.support.v7.a;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.internal.view.b;
import android.support.v7.internal.view.menu.af;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.Window.Callback;

class j
  extends g
{
  Menu d;
  
  j(f paramf)
  {
    super(paramf);
  }
  
  public a a()
  {
    return new p(this.a, this.a);
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new k(this, paramCallback);
  }
  
  public void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(Bundle paramBundle)
  {
    if ("splitActionBarWhenNarrow".equals(i())) {
      this.a.getWindow().setUiOptions(1, 1);
    }
    super.a(paramBundle);
    if (this.b) {
      this.a.requestWindowFeature(8);
    }
    if (this.c) {
      this.a.requestWindowFeature(9);
    }
    paramBundle = this.a.getWindow();
    paramBundle.setCallback(a(paramBundle.getCallback()));
  }
  
  public void a(ActionMode paramActionMode)
  {
    this.a.a(new b(j(), paramActionMode));
  }
  
  public void a(View paramView)
  {
    this.a.a(paramView);
  }
  
  public void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.a.a(paramView, paramLayoutParams);
  }
  
  public void a(CharSequence paramCharSequence) {}
  
  public boolean a(int paramInt, Menu paramMenu)
  {
    if ((paramInt == 0) || (paramInt == 8))
    {
      if (this.d == null) {
        this.d = af.a(paramMenu);
      }
      return this.a.a(paramInt, this.d);
    }
    return this.a.a(paramInt, paramMenu);
  }
  
  public boolean a(int paramInt, MenuItem paramMenuItem)
  {
    MenuItem localMenuItem = paramMenuItem;
    if (paramInt == 0) {
      localMenuItem = af.a(paramMenuItem);
    }
    return this.a.a(paramInt, localMenuItem);
  }
  
  public boolean a(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) || (paramInt == 8)) {
      return this.a.a(paramInt, paramView, this.d);
    }
    return this.a.a(paramInt, paramView, paramMenu);
  }
  
  public View b(int paramInt)
  {
    return null;
  }
  
  public void b(ActionMode paramActionMode)
  {
    this.a.b(new b(j(), paramActionMode));
  }
  
  public void b(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.a.b(paramView, paramLayoutParams);
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    this.d = null;
  }
  
  public boolean g()
  {
    return false;
  }
  
  public void h()
  {
    this.a.h();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */