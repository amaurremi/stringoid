package com.tapjoy;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class TapjoyDisplayMetricsUtil
{
  private Configuration configuration;
  private Context context;
  private DisplayMetrics metrics;
  
  public TapjoyDisplayMetricsUtil(Context paramContext)
  {
    this.context = paramContext;
    this.metrics = new DisplayMetrics();
    ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getMetrics(this.metrics);
    this.configuration = this.context.getResources().getConfiguration();
  }
  
  public int getScreenDensity()
  {
    return this.metrics.densityDpi;
  }
  
  public int getScreenLayoutSize()
  {
    return this.configuration.screenLayout & 0xF;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TapjoyDisplayMetricsUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */