package com.gau.go.launcherex.gowidget.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.util.AttributeSet;
import com.gau.go.launcherex.gowidget.language.b;
import com.gau.go.launcherex.gowidget.language.d;
import com.go.gl.view.GLFrameLayout;
import com.go.gowidget.core.IGoWidget3D;
import java.io.PrintStream;

public abstract class GLGoWidgetFrame
  extends GLFrameLayout
  implements IGoWidget3D
{
  private static d a;
  private BroadcastReceiver b;
  
  public GLGoWidgetFrame(Context paramContext)
  {
    super(paramContext);
    a = d.a(paramContext);
    a();
    System.out.println("========= GLGoWidgetFrame =========");
  }
  
  public GLGoWidgetFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    a = d.a(paramContext);
    a();
  }
  
  public GLGoWidgetFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a = d.a(paramContext);
    a();
  }
  
  private void a()
  {
    if (this.b == null)
    {
      this.b = new a(this);
      IntentFilter localIntentFilter = new IntentFilter("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USER_LANGUAGE_CHANGED");
      this.mContext.registerReceiver(this.b, localIntentFilter);
    }
  }
  
  public b getResources()
  {
    if (a == null) {
      a = d.a(getContext());
    }
    return a.a();
  }
  
  public String getString(int paramInt)
  {
    return getResources().getString(paramInt);
  }
  
  protected void initData() {}
  
  protected void initViews() {}
  
  public void onDelete()
  {
    if (this.b != null)
    {
      this.mContext.unregisterReceiver(this.b);
      this.b = null;
    }
  }
  
  public void onLanguageChanged(b paramb)
  {
    initViews();
    initData();
  }
  
  public void onRemove()
  {
    if (this.b != null)
    {
      this.mContext.unregisterReceiver(this.b);
      this.b = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/framework/GLGoWidgetFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */