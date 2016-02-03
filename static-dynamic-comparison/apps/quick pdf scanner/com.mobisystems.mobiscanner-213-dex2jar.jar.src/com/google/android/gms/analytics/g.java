package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.internal.dc;
import java.util.HashMap;
import java.util.Map;

public class g
{
  private final z mA;
  private a mB;
  private final h mv;
  private final Map<String, String> mw = new HashMap();
  private m mx;
  private final aa my;
  private final n mz;
  
  g(String paramString, h paramh)
  {
    this(paramString, paramh, aa.lk(), n.kX(), z.lj(), new ap("tracking"));
  }
  
  g(String paramString, h paramh, aa paramaa, n paramn, z paramz, m paramm)
  {
    this.mv = paramh;
    if (paramString != null) {
      this.mw.put("&tid", paramString);
    }
    this.mw.put("useSecure", "1");
    this.my = paramaa;
    this.mz = paramn;
    this.mA = paramz;
    this.mx = paramm;
    this.mB = new a();
  }
  
  public void c(Map<String, String> paramMap)
  {
    u.lF().a(u.a.oO);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.mw);
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    if (TextUtils.isEmpty((CharSequence)localHashMap.get("&tid"))) {
      j.D(String.format("Missing tracking id (%s) parameter.", new Object[] { "&tid" }));
    }
    String str = (String)localHashMap.get("&t");
    paramMap = str;
    if (TextUtils.isEmpty(str))
    {
      j.D(String.format("Missing hit type (%s) parameter.", new Object[] { "&t" }));
      paramMap = "";
    }
    if (this.mB.kM()) {
      localHashMap.put("&sc", "start");
    }
    if ((!paramMap.equals("transaction")) && (!paramMap.equals("item")) && (!this.mx.kW()))
    {
      j.D("Too many hits sent too quickly, rate limiting invoked.");
      return;
    }
    this.mv.i(localHashMap);
  }
  
  public void set(String paramString1, String paramString2)
  {
    dc.e(paramString1, "Key should be non-null");
    u.lF().a(u.a.oN);
    this.mw.put(paramString1, paramString2);
  }
  
  private class a
  {
    private boolean mC = false;
    private boolean mD = false;
    private int mE = 0;
    private long mF = -1L;
    private boolean mG = false;
    private ab mH = new ab()
    {
      public long currentTimeMillis()
      {
        return System.currentTimeMillis();
      }
    };
    
    public a() {}
    
    public boolean kM()
    {
      boolean bool = this.mG;
      this.mG = false;
      return bool;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */