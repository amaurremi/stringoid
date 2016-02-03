package com.chartboost.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBLogging.Level;
import com.chartboost.sdk.Libraries.CBOrientation;
import com.chartboost.sdk.Libraries.CBOrientation.Difference;
import com.chartboost.sdk.Libraries.CBUtility;

public final class CBPreferences
{
  private static volatile CBPreferences m = null;
  private String a;
  private String b;
  private ChartboostDelegate c;
  private int d = 30000;
  private boolean e = false;
  private CBOrientation f;
  private boolean g;
  private boolean h = false;
  private boolean i = false;
  private String j = null;
  private Chartboost k = null;
  private boolean l = false;
  
  public static CBPreferences getInstance()
  {
    Chartboost.sharedChartboost();
    if (m == null) {
      m = new CBPreferences();
    }
    return m;
  }
  
  public boolean getAnimationsOff()
  {
    return this.i;
  }
  
  public String getAppID()
  {
    return this.a;
  }
  
  public String getAppSignature()
  {
    return this.b;
  }
  
  public ChartboostDelegate getDelegate()
  {
    return this.c;
  }
  
  public CBOrientation.Difference getForcedOrientationDifference()
  {
    if (!this.g) {
      return CBOrientation.Difference.ANGLE_0;
    }
    CBOrientation localCBOrientation1 = CBUtility.c(this.k.getContext());
    CBOrientation localCBOrientation2 = getOrientation();
    if ((localCBOrientation2 == CBOrientation.UNSPECIFIED) || (localCBOrientation2 == localCBOrientation1)) {
      return CBOrientation.Difference.ANGLE_0;
    }
    if (localCBOrientation2 == localCBOrientation1.rotate90()) {
      return CBOrientation.Difference.ANGLE_90;
    }
    if (localCBOrientation2 == localCBOrientation1.rotate180()) {
      return CBOrientation.Difference.ANGLE_180;
    }
    return CBOrientation.Difference.ANGLE_270;
  }
  
  public boolean getIgnoreErrors()
  {
    return this.h;
  }
  
  public boolean getImpressionsUseActivities()
  {
    return this.e;
  }
  
  public CBLogging.Level getLoggingLevel()
  {
    return CBLogging.a;
  }
  
  public CBOrientation getOrientation()
  {
    if (this.k.getContext() == null) {
      throw new IllegalStateException("The context must be set through the Chartboost method onCreate() before calling getOrientation().");
    }
    if ((this.g) && (this.f != CBOrientation.UNSPECIFIED)) {
      return this.f;
    }
    return CBUtility.c(this.k.getContext());
  }
  
  public int getTimeout()
  {
    return this.d;
  }
  
  public String getUserAgentSuffix()
  {
    if (this.j == null) {
      return "";
    }
    return this.j;
  }
  
  public void setAnimationsOff(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setAppID(String paramString)
  {
    this.a = paramString;
  }
  
  public void setAppSignature(String paramString)
  {
    this.b = paramString;
  }
  
  public void setDelegate(ChartboostDelegate paramChartboostDelegate)
  {
    this.c = paramChartboostDelegate;
  }
  
  public void setIgnoreErrors(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setImpressionsUseActivities(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setLoggingLevel(CBLogging.Level paramLevel)
  {
    CBLogging.a = paramLevel;
  }
  
  public void setOrientation(CBOrientation paramCBOrientation)
  {
    boolean bool = true;
    if ((!this.l) && (this.k.getContext() != null) && (this.k.getContext().getApplicationInfo().targetSdkVersion >= 14))
    {
      this.l = true;
      CBLogging.a("The CBPreferences.setOrientation method is not supported when you set your app's targetSdkVersion to 14 or higher in your Android Manifest.");
    }
    if (paramCBOrientation != CBOrientation.UNSPECIFIED) {}
    for (;;)
    {
      this.g = bool;
      this.f = paramCBOrientation;
      return;
      bool = false;
    }
  }
  
  public void setTimeout(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setUserAgentSuffix(String paramString)
  {
    this.j = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/CBPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */