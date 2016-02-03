package com.google.analytics.tracking.android;

import java.io.IOException;
import java.util.Map;

public abstract interface Tracker
{
  public abstract boolean anonymizeIpEnabled();
  
  public abstract void close();
  
  public abstract Map<String, String> constructEvent(String paramString1, String paramString2, String paramString3, Long paramLong);
  
  public abstract Map<String, String> constructException(String paramString, boolean paramBoolean);
  
  public abstract Map<String, String> constructRawException(String paramString, Throwable paramThrowable, boolean paramBoolean)
    throws IOException;
  
  public abstract Map<String, String> constructSocial(String paramString1, String paramString2, String paramString3);
  
  public abstract Map<String, String> constructTiming(String paramString1, long paramLong, String paramString2, String paramString3);
  
  public abstract Map<String, String> constructTransaction(Transaction paramTransaction);
  
  public abstract String get(String paramString);
  
  public abstract String getAppId();
  
  public abstract String getAppInstallerId();
  
  public abstract ExceptionParser getExceptionParser();
  
  public abstract double getSampleRate();
  
  public abstract String getTrackingId();
  
  public abstract boolean getUseSecure();
  
  public abstract void send(String paramString, Map<String, String> paramMap);
  
  public abstract void set(String paramString1, String paramString2);
  
  public abstract void setAnonymizeIp(boolean paramBoolean);
  
  public abstract void setAppId(String paramString);
  
  public abstract void setAppInstallerId(String paramString);
  
  public abstract void setAppName(String paramString);
  
  public abstract void setAppScreen(String paramString);
  
  public abstract void setAppVersion(String paramString);
  
  public abstract void setCampaign(String paramString);
  
  public abstract void setCustomDimension(int paramInt, String paramString);
  
  public abstract void setCustomDimensionsAndMetrics(Map<Integer, String> paramMap, Map<Integer, Long> paramMap1);
  
  public abstract void setCustomMetric(int paramInt, Long paramLong);
  
  public abstract void setExceptionParser(ExceptionParser paramExceptionParser);
  
  public abstract void setReferrer(String paramString);
  
  public abstract void setSampleRate(double paramDouble);
  
  public abstract void setStartSession(boolean paramBoolean);
  
  public abstract void setUseSecure(boolean paramBoolean);
  
  public abstract void trackEvent(String paramString1, String paramString2, String paramString3, Long paramLong);
  
  public abstract void trackException(String paramString, Throwable paramThrowable, boolean paramBoolean);
  
  public abstract void trackException(String paramString, boolean paramBoolean);
  
  public abstract void trackSocial(String paramString1, String paramString2, String paramString3);
  
  public abstract void trackTiming(String paramString1, long paramLong, String paramString2, String paramString3);
  
  public abstract void trackTransaction(Transaction paramTransaction);
  
  public abstract void trackView();
  
  public abstract void trackView(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/analytics/tracking/android/Tracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */