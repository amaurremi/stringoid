package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.Context;
import com.gau.go.launcherex.gowidget.weather.view.dh;
import com.go.gl.view.GLFrameLayout;
import com.go.gl.view.GLLayoutInflater;
import com.go.gl.view.GLView;

public abstract class GLWidgetChildView
  extends GLFrameLayout
{
  private dh a;
  protected GLLayoutInflater mInflater;
  
  public GLWidgetChildView(Context paramContext, dh paramdh)
  {
    super(paramContext);
    this.mInflater = GLLayoutInflater.from(paramContext);
    this.mInflater.inflate(getContentViewLayoutId(), this);
    this.a = paramdh;
  }
  
  public void cleanUp() {}
  
  public dh getChildViewType()
  {
    return this.a;
  }
  
  public abstract int getContentViewLayoutId();
  
  protected final void unSetComponentOnClickListener(GLView paramGLView)
  {
    if (paramGLView != null) {
      paramGLView.setOnClickListener(null);
    }
  }
  
  protected final void unSetComponentOnLongClickListener(GLView paramGLView)
  {
    if (paramGLView != null) {
      paramGLView.setOnLongClickListener(null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/GLWidgetChildView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */