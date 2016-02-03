package com.flurry.android.monolithic.sdk.impl;

import android.location.Criteria;

public class ib
{
  public static final Integer a = Integer.valueOf(151);
  public static final String b = null;
  public static final Boolean c = Boolean.valueOf(true);
  public static final Boolean d = Boolean.valueOf(false);
  public static final String e = null;
  public static final Boolean f = Boolean.valueOf(true);
  public static final Criteria g = null;
  public static final Long h = Long.valueOf(10000L);
  public static final Boolean i = Boolean.valueOf(true);
  public static final Long j = Long.valueOf(0L);
  public static final Byte k = Byte.valueOf((byte)-1);
  private static ic l;
  
  public static ic a()
  {
    try
    {
      if (l == null)
      {
        l = new ic();
        b();
      }
      ic localic = l;
      return localic;
    }
    finally {}
  }
  
  private static void b()
  {
    if (l == null) {
      l = new ic();
    }
    l.a("AgentVersion", a);
    l.a("VesionName", b);
    l.a("CaptureUncaughtExceptions", c);
    l.a("UseHttps", d);
    l.a("ReportUrl", e);
    l.a("ReportLocation", f);
    l.a("LocationCriteria", g);
    l.a("ContinueSessionMillis", h);
    l.a("LogEvents", i);
    l.a("Age", j);
    l.a("Gender", k);
    l.a("UserId", "");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */