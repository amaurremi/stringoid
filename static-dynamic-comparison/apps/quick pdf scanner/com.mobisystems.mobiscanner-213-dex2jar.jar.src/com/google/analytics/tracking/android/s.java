package com.google.analytics.tracking.android;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class s
  extends ag
{
  private static s kT;
  private boolean kO;
  private e kP;
  private volatile Boolean kQ = Boolean.valueOf(false);
  private final Map<String, af> kR = new HashMap();
  private Logger kS;
  private Context mContext;
  
  protected s(Context paramContext)
  {
    this(paramContext, r.h(paramContext));
  }
  
  private s(Context paramContext, e parame)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
    this.kP = parame;
    f.d(this.mContext);
    aa.d(this.mContext);
    g.d(this.mContext);
    this.kS = new i();
  }
  
  public static s j(Context paramContext)
  {
    try
    {
      if (kT == null) {
        kT = new s(paramContext);
      }
      paramContext = kT;
      return paramContext;
    }
    finally {}
  }
  
  static s jX()
  {
    try
    {
      s locals = kT;
      return locals;
    }
    finally {}
  }
  
  void b(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      try
      {
        throw new IllegalArgumentException("hit cannot be null");
      }
      finally {}
    }
    ah.a(paramMap, "&ul", ah.a(Locale.getDefault()));
    ah.a(paramMap, "&sr", aa.kl().getValue("&sr"));
    paramMap.put("&_u", GAUsage.jU().jW());
    GAUsage.jU().jV();
    this.kP.b(paramMap);
  }
  
  public boolean jY()
  {
    GAUsage.jU().a(GAUsage.Field.kF);
    return this.kO;
  }
  
  public boolean jZ()
  {
    GAUsage.jU().a(GAUsage.Field.ks);
    return this.kQ.booleanValue();
  }
  
  public Logger ka()
  {
    return this.kS;
  }
  
  public void p(boolean paramBoolean)
  {
    GAUsage.jU().a(GAUsage.Field.kE);
    this.kO = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */