package com.flurry.android.monolithic.sdk.impl;

import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ck
{
  private static final String a = ck.class.getSimpleName();
  private final FlurryAdModule b;
  
  public ck(FlurryAdModule paramFlurryAdModule)
  {
    this.b = paramFlurryAdModule;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    return paramString2.equals("%{" + paramString1 + "}");
  }
  
  public String a(m paramm, AdUnit paramAdUnit, i parami, String paramString1, String paramString2)
  {
    if (a("fids", paramString2))
    {
      paramm = new StringBuilder();
      paramm.append(eg.i()).append(":").append(this.b.l());
      paramAdUnit = this.b.m();
      if (paramAdUnit != null)
      {
        paramAdUnit = paramAdUnit.entrySet().iterator();
        while (paramAdUnit.hasNext())
        {
          parami = (Map.Entry)paramAdUnit.next();
          paramm.append(",").append(((ie)parami.getKey()).c).append(":");
          if (((ie)parami.getKey()).d) {
            paramm.append(((ByteBuffer)parami.getValue()).array());
          } else {
            paramm.append(je.a(((ByteBuffer)parami.getValue()).array()));
          }
        }
      }
      ja.a(3, a, "Replacing param fids with: " + paramm.toString());
      paramAdUnit = paramString1.replace(paramString2, je.b(paramm.toString()));
    }
    do
    {
      do
      {
        return paramAdUnit;
        if (a("sid", paramString2))
        {
          paramm = String.valueOf(this.b.d());
          ja.a(3, a, "Replacing param sid with: " + paramm);
          return paramString1.replace(paramString2, je.b(paramm));
        }
        if (a("lid", paramString2))
        {
          paramm = String.valueOf(paramm.a());
          ja.a(3, a, "Replacing param lid with: " + paramm);
          return paramString1.replace(paramString2, je.b(paramm));
        }
        if (a("guid", paramString2))
        {
          paramm = paramm.b();
          ja.a(3, a, "Replacing param guid with: " + paramm);
          return paramString1.replace(paramString2, je.b(paramm));
        }
        if (a("ats", paramString2))
        {
          paramm = String.valueOf(System.currentTimeMillis());
          ja.a(3, a, "Replacing param ats with: " + paramm);
          return paramString1.replace(paramString2, je.b(paramm));
        }
        if (a("apik", paramString2))
        {
          paramm = this.b.f();
          ja.a(3, a, "Replacing param apik with: " + paramm);
          return paramString1.replace(paramString2, je.b(paramm));
        }
        if (a("hid", paramString2))
        {
          paramm = paramAdUnit.b().toString();
          ja.a(3, a, "Replacing param hid with: " + paramm);
          return paramString1.replace(paramString2, je.b(paramm));
        }
        if (a("eso", paramString2))
        {
          paramm = Long.toString(System.currentTimeMillis() - this.b.d());
          ja.a(3, a, "Replacing param eso with: " + paramm);
          return paramString1.replace(paramString2, je.b(paramm));
        }
        if (!a("uc", paramString2)) {
          break;
        }
        paramAdUnit = this.b.v().entrySet().iterator();
        for (paramm = ""; paramAdUnit.hasNext(); paramm = paramm + "c_" + je.b((String)parami.getKey()) + "=" + je.b((String)parami.getValue()) + "&") {
          parami = (Map.Entry)paramAdUnit.next();
        }
        ja.a(3, a, "Replacing param uc with: " + paramm);
        parami = paramString1.replace(paramString2, paramm);
        paramAdUnit = parami;
      } while (!paramm.equals(""));
      paramAdUnit = parami;
    } while (parami.length() <= 0);
    return parami.substring(0, parami.length() - 1);
    ja.a(3, a, "Unknown param: " + paramString2);
    return paramString1.replace(paramString2, "");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */