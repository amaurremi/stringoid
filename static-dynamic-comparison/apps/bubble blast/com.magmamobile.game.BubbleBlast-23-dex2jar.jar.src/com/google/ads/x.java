package com.google.ads;

import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.internal.ActivationOverlay;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.d;
import com.google.ads.internal.h;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.g;
import com.google.ads.util.i.b;
import com.google.ads.util.i.c;
import java.util.HashMap;

public class x
  implements o
{
  private void a(HashMap<String, String> paramHashMap, String paramString, i.c<Integer> paramc)
  {
    try
    {
      paramHashMap = (String)paramHashMap.get(paramString);
      if (!TextUtils.isEmpty(paramHashMap)) {
        paramc.a(Integer.valueOf(paramHashMap));
      }
      return;
    }
    catch (NumberFormatException paramHashMap)
    {
      b.a("Could not parse \"" + paramString + "\" constant.");
    }
  }
  
  private void b(HashMap<String, String> paramHashMap, String paramString, i.c<Long> paramc)
  {
    try
    {
      paramHashMap = (String)paramHashMap.get(paramString);
      if (!TextUtils.isEmpty(paramHashMap)) {
        paramc.a(Long.valueOf(paramHashMap));
      }
      return;
    }
    catch (NumberFormatException paramHashMap)
    {
      b.a("Could not parse \"" + paramString + "\" constant.");
    }
  }
  
  private void c(HashMap<String, String> paramHashMap, String paramString, i.c<String> paramc)
  {
    paramHashMap = (String)paramHashMap.get(paramString);
    if (!TextUtils.isEmpty(paramHashMap)) {
      paramc.a(paramHashMap);
    }
  }
  
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    n localn = paramd.i();
    m.a locala = (m.a)((m)localn.d.a()).b.a();
    c(paramHashMap, "as_domains", locala.a);
    c(paramHashMap, "bad_ad_report_path", locala.h);
    a(paramHashMap, "min_hwa_banner", locala.b);
    a(paramHashMap, "min_hwa_activation_overlay", locala.c);
    a(paramHashMap, "min_hwa_overlay", locala.d);
    c(paramHashMap, "mraid_banner_path", locala.e);
    c(paramHashMap, "mraid_expanded_banner_path", locala.f);
    c(paramHashMap, "mraid_interstitial_path", locala.g);
    b(paramHashMap, "ac_max_size", locala.i);
    b(paramHashMap, "ac_padding", locala.j);
    b(paramHashMap, "ac_total_quota", locala.k);
    b(paramHashMap, "db_total_quota", locala.l);
    b(paramHashMap, "db_quota_per_origin", locala.m);
    b(paramHashMap, "db_quota_step_size", locala.n);
    paramd = paramd.l();
    if (AdUtil.a >= 11)
    {
      g.a(paramd.getSettings(), localn);
      g.a(paramWebView.getSettings(), localn);
    }
    boolean bool;
    int i;
    if (!((h)localn.g.a()).a())
    {
      bool = paramd.k();
      if (AdUtil.a < ((Integer)locala.b.a()).intValue())
      {
        i = 1;
        if ((i != 0) || (!bool)) {
          break label432;
        }
        b.a("Re-enabling hardware acceleration for a banner after reading constants.");
        paramd.h();
      }
    }
    else
    {
      label292:
      paramd = (ActivationOverlay)localn.e.a();
      if ((!((h)localn.g.a()).b()) && (paramd != null))
      {
        bool = paramd.k();
        if (AdUtil.a >= ((Integer)locala.c.a()).intValue()) {
          break label454;
        }
        i = 1;
        label354:
        if ((i != 0) || (!bool)) {
          break label460;
        }
        b.a("Re-enabling hardware acceleration for an activation overlay after reading constants.");
        paramd.h();
      }
    }
    for (;;)
    {
      paramd = (String)locala.a.a();
      paramHashMap = (al)localn.s.a();
      if ((paramHashMap != null) && (!TextUtils.isEmpty(paramd))) {
        paramHashMap.a(paramd);
      }
      locala.o.a(Boolean.valueOf(true));
      return;
      i = 0;
      break;
      label432:
      if ((i == 0) || (bool)) {
        break label292;
      }
      b.a("Disabling hardware acceleration for a banner after reading constants.");
      paramd.g();
      break label292;
      label454:
      i = 0;
      break label354;
      label460:
      if ((i != 0) && (!bool))
      {
        b.a("Disabling hardware acceleration for an activation overlay after reading constants.");
        paramd.g();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */