package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class d
{
  public static class a
    extends d.c<a>
  {
    public a()
    {
      u.lF().a(u.a.pB);
      e("&t", "event");
    }
    
    public a O(String paramString)
    {
      e("&ec", paramString);
      return this;
    }
    
    public a P(String paramString)
    {
      e("&ea", paramString);
      return this;
    }
    
    public a Q(String paramString)
    {
      e("&el", paramString);
      return this;
    }
  }
  
  public static class b
    extends d.c<b>
  {
    public b()
    {
      u.lF().a(u.a.pk);
      e("&t", "exception");
    }
    
    public b R(String paramString)
    {
      e("&exd", paramString);
      return this;
    }
    
    public b q(boolean paramBoolean)
    {
      e("&exf", r.s(paramBoolean));
      return this;
    }
  }
  
  protected static class c<T extends c>
  {
    private Map<String, String> mt = new HashMap();
    
    public T S(String paramString)
    {
      u.lF().a(u.a.oG);
      paramString = r.ae(paramString);
      if (TextUtils.isEmpty(paramString)) {
        return this;
      }
      paramString = r.ad(paramString);
      e("&cc", (String)paramString.get("utm_content"));
      e("&cm", (String)paramString.get("utm_medium"));
      e("&cn", (String)paramString.get("utm_campaign"));
      e("&cs", (String)paramString.get("utm_source"));
      e("&ck", (String)paramString.get("utm_term"));
      e("&ci", (String)paramString.get("utm_id"));
      e("&gclid", (String)paramString.get("gclid"));
      e("&dclid", (String)paramString.get("dclid"));
      e("&gmob_t", (String)paramString.get("gmob_t"));
      return this;
    }
    
    public final T e(String paramString1, String paramString2)
    {
      u.lF().a(u.a.oD);
      if (paramString1 != null)
      {
        this.mt.put(paramString1, paramString2);
        return this;
      }
      j.D(" HitBuilder.set() called with a null paramName.");
      return this;
    }
    
    public Map<String, String> kg()
    {
      return this.mt;
    }
  }
  
  public static class d
    extends d.c<d>
  {
    public d()
    {
      u.lF().a(u.a.pC);
      e("&t", "item");
    }
    
    public d T(String paramString)
    {
      e("&ti", paramString);
      return this;
    }
    
    public d U(String paramString)
    {
      e("&in", paramString);
      return this;
    }
    
    public d V(String paramString)
    {
      e("&ic", paramString);
      return this;
    }
    
    public d c(long paramLong)
    {
      e("&iq", Long.toString(paramLong));
      return this;
    }
    
    public d e(double paramDouble)
    {
      e("&ip", Double.toString(paramDouble));
      return this;
    }
  }
  
  public static class e
    extends d.c<e>
  {
    public e()
    {
      u.lF().a(u.a.pj);
      e("&t", "transaction");
    }
    
    public e W(String paramString)
    {
      e("&ti", paramString);
      return this;
    }
    
    public e X(String paramString)
    {
      e("&ta", paramString);
      return this;
    }
    
    public e Y(String paramString)
    {
      e("&cu", paramString);
      return this;
    }
    
    public e f(double paramDouble)
    {
      e("&tr", Double.toString(paramDouble));
      return this;
    }
    
    public e g(double paramDouble)
    {
      e("&tt", Double.toString(paramDouble));
      return this;
    }
    
    public e h(double paramDouble)
    {
      e("&ts", Double.toString(paramDouble));
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */