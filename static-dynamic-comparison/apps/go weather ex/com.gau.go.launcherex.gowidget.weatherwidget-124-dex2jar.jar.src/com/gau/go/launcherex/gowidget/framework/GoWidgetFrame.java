package com.gau.go.launcherex.gowidget.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.gau.go.launcherex.gowidget.language.b;
import com.gau.go.launcherex.gowidget.language.d;

public abstract class GoWidgetFrame
  extends FrameLayout
{
  private static d b;
  protected Context a;
  private BroadcastReceiver c;
  
  public GoWidgetFrame(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    b = d.a(paramContext);
    d();
  }
  
  public GoWidgetFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.a = paramContext;
    b = d.a(paramContext);
    d();
  }
  
  public GoWidgetFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    b = d.a(paramContext);
    d();
  }
  
  private void d()
  {
    if (this.c == null)
    {
      this.c = new f(this);
      IntentFilter localIntentFilter = new IntentFilter("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USER_LANGUAGE_CHANGED");
      this.a.registerReceiver(this.c, localIntentFilter);
    }
  }
  
  protected void a() {}
  
  protected void b() {}
  
  public b getResources()
  {
    if (b == null) {
      b = d.a(getContext());
    }
    return b.a();
  }
  
  public String getString(int paramInt)
  {
    return getResources().getString(paramInt);
  }
  
  public void onDelete(int paramInt)
  {
    if (this.c != null)
    {
      this.a.unregisterReceiver(this.c);
      this.c = null;
    }
  }
  
  public void onLanguageChanged(b paramb)
  {
    a();
    b();
  }
  
  public void onRemove(int paramInt)
  {
    if (this.c != null)
    {
      this.a.unregisterReceiver(this.c);
      this.c = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/framework/GoWidgetFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */