package com.vungle.publisher.reporting;

import com.vungle.publisher.ac;
import com.vungle.publisher.ad;
import com.vungle.publisher.ae;
import com.vungle.publisher.af;
import com.vungle.publisher.bg;
import com.vungle.publisher.bh;
import com.vungle.publisher.bt;
import com.vungle.publisher.db.model.Ad;
import com.vungle.publisher.db.model.AdPlay;
import com.vungle.publisher.db.model.AdReport;
import com.vungle.publisher.db.model.AdReportEvent.a;
import com.vungle.publisher.db.model.EventTracking.a;
import com.vungle.publisher.log.Logger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

public class AdReportingHandler
  extends bh
{
  private static final EventTracking.a[] h = { EventTracking.a.c, EventTracking.a.d, EventTracking.a.e, EventTracking.a.f, EventTracking.a.g, EventTracking.a.h };
  public Ad a;
  public AdReport b;
  public AdPlay c;
  @Inject
  AdServiceReportingHandler d;
  @Inject
  public bt e;
  @Inject
  public ReportManager g;
  private int i;
  private final HashSet<EventTracking.a> j = new HashSet();
  
  public final void a(AdReportEvent.a parama, Object paramObject)
  {
    try
    {
      this.c.a(parama, paramObject);
      return;
    }
    catch (Exception parama)
    {
      Logger.w("VungleReport", "error reporting event", parama);
    }
  }
  
  public final void a(EventTracking.a parama)
  {
    if (this.a == null) {
      Logger.w("VungleReport", "ad was not set in AdReportingHandler. Cannot track event");
    }
    while (this.j.contains(parama)) {
      return;
    }
    Logger.v("VungleReport", "tpat event: " + parama.name());
    bt localbt = this.e;
    String[] arrayOfString = this.a.a(parama);
    HashMap localHashMap = new HashMap();
    localHashMap.put("%timestamp%", String.valueOf(System.currentTimeMillis()));
    localbt.a(localHashMap, arrayOfString);
    this.j.add(parama);
  }
  
  public void onEvent(ac paramac)
  {
    try
    {
      this.b.a(Integer.valueOf(paramac.a));
      return;
    }
    catch (Exception paramac)
    {
      Logger.w("VungleReport", "error updating video duration millis", paramac);
    }
  }
  
  public void onEvent(ae paramae)
  {
    int m = 0;
    int n = 0;
    for (;;)
    {
      int i1;
      boolean bool;
      Object localObject;
      try
      {
        i1 = paramae.a;
        if (this.i >= h.length) {
          break label338;
        }
        k = 1;
        bool = paramae instanceof ad;
        if ((k == 0) && (!bool)) {
          break label337;
        }
        localObject = this.b.h();
        if (localObject == null)
        {
          Logger.d("VungleReport", "null video duration millis for " + this.b.u());
          return;
        }
        if (((Integer)localObject).intValue() == 0)
        {
          Logger.w("VungleReport", "video duration millis 0 for " + this.b.u());
          return;
        }
      }
      catch (Exception paramae)
      {
        Logger.w("VungleReport", "error handling video view progress", paramae);
        return;
      }
      if (k != 0)
      {
        float f = i1;
        f /= ((Integer)localObject).intValue();
        localObject = h[this.i];
        k = n;
        if (f >= ((EventTracking.a)localObject).p) {
          k = 1;
        }
        m = k;
        if (k != 0)
        {
          this.i += 1;
          a((EventTracking.a)localObject);
          m = k;
        }
      }
      if ((m != 0) || (bool)) {
        for (;;)
        {
          Integer localInteger;
          try
          {
            localObject = this.c;
            localInteger = Integer.valueOf(paramae.a);
            if ((((AdPlay)localObject).b == null) || ((localInteger != null) && (localInteger.intValue() > ((AdPlay)localObject).b.intValue())))
            {
              Logger.d("VungleAd", "setting watched millis " + localInteger);
              ((AdPlay)localObject).b = localInteger;
              this.c.l();
              this.b.a(Long.valueOf(paramae.c));
              return;
            }
          }
          catch (Exception paramae)
          {
            Logger.w("VungleReport", "error updating video view progress", paramae);
            return;
          }
          Logger.w("VungleAd", "ignoring decreased watched millis " + localInteger);
        }
      }
      label337:
      return;
      label338:
      int k = 0;
    }
  }
  
  public void onEvent(af paramaf)
  {
    try
    {
      this.c.c = Long.valueOf(paramaf.c);
      this.c.l();
      return;
    }
    catch (Exception paramaf)
    {
      Logger.w("VungleReport", "error updating play start millis", paramaf);
    }
  }
  
  @Singleton
  public static class Factory
  {
    @Inject
    public Provider<AdReportingHandler> a;
    @Inject
    public ReportManager b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/reporting/AdReportingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */