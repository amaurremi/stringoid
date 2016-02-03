package com.gtp.nextlauncher.widget.nextpanel;

import android.content.Context;
import com.go.gl.view.GLRelativeLayout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Wall
  extends GLRelativeLayout
{
  protected ExecutorService mScheduledExecutorService = Executors.newFixedThreadPool(3, new k(this));
  protected l mWallHoder;
  
  public Wall(Context paramContext)
  {
    super(paramContext);
  }
  
  public abstract void clearDrawable();
  
  public abstract void forceAnimationStop();
  
  public abstract void initDrawable();
  
  public void setWallHodler(l paraml)
  {
    this.mWallHoder = paraml;
  }
  
  public abstract boolean startForeAnimation(boolean paramBoolean);
  
  public abstract void startWeatherAnimaiton();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/nextpanel/Wall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */