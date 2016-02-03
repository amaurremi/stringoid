package com.google.android.b.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.AttributeSet;
import android.view.LayoutInflater;

public final class a
  extends bf
{
  private static final Class[] a = { Context.class, AttributeSet.class };
  private final Resources b;
  private final LayoutInflater c;
  private final Resources.Theme d;
  
  public a(Activity paramActivity, Resources paramResources, ClassLoader paramClassLoader, int paramInt)
  {
    super(paramActivity);
    this.b = ((Resources)d.a(paramResources, "resources cannot be null"));
    paramActivity = ((LayoutInflater)super.getSystemService("layout_inflater")).cloneInContext(this);
    paramActivity.setFactory(new b(paramClassLoader));
    this.c = paramActivity;
    this.d = paramResources.newTheme();
    this.d.applyStyle(paramInt, false);
  }
  
  public final Context getApplicationContext()
  {
    return super.getApplicationContext();
  }
  
  public final Context getBaseContext()
  {
    return super.getBaseContext();
  }
  
  public final Resources getResources()
  {
    return this.b;
  }
  
  public final Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString)) {
      return this.c;
    }
    return super.getSystemService(paramString);
  }
  
  public final Resources.Theme getTheme()
  {
    return this.d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */