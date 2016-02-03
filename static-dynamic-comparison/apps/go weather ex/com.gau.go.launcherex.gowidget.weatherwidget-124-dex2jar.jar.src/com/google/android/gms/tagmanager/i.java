package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class i
  extends df
{
  private static final String ID = a.ap.toString();
  private static final String URL = b.eo.toString();
  private static final String WC = b.aX.toString();
  private static final String WD = b.en.toString();
  static final String WE = "gtm_" + ID + "_unrepeatable";
  private static final Set<String> WF = new HashSet();
  private final a WG;
  private final Context mContext;
  
  public i(Context paramContext)
  {
    this(paramContext, new a()
    {
      public aq jY()
      {
        return y.F(i.this);
      }
    });
  }
  
  i(Context paramContext, a parama)
  {
    super(ID, new String[] { URL });
    this.WG = parama;
    this.mContext = paramContext;
  }
  
  private boolean bj(String paramString)
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        boolean bool2 = bl(paramString);
        if (bool2) {
          return bool1;
        }
        if (bk(paramString)) {
          WF.add(paramString);
        } else {
          bool1 = false;
        }
      }
      finally {}
    }
  }
  
  boolean bk(String paramString)
  {
    return this.mContext.getSharedPreferences(WE, 0).contains(paramString);
  }
  
  boolean bl(String paramString)
  {
    return WF.contains(paramString);
  }
  
  public void z(Map<String, d.a> paramMap)
  {
    String str;
    if (paramMap.get(WD) != null)
    {
      str = dh.j((d.a)paramMap.get(WD));
      if ((str == null) || (!bj(str))) {
        break label46;
      }
    }
    label46:
    do
    {
      return;
      str = null;
      break;
      Uri.Builder localBuilder = Uri.parse(dh.j((d.a)paramMap.get(URL))).buildUpon();
      paramMap = (d.a)paramMap.get(WC);
      if (paramMap != null)
      {
        paramMap = dh.o(paramMap);
        if (!(paramMap instanceof List))
        {
          bh.w("ArbitraryPixel: additional params not a list: not sending partial hit: " + localBuilder.build().toString());
          return;
        }
        paramMap = ((List)paramMap).iterator();
        while (paramMap.hasNext())
        {
          Object localObject = paramMap.next();
          if (!(localObject instanceof Map))
          {
            bh.w("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + localBuilder.build().toString());
            return;
          }
          localObject = ((Map)localObject).entrySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            localBuilder.appendQueryParameter(localEntry.getKey().toString(), localEntry.getValue().toString());
          }
        }
      }
      paramMap = localBuilder.build().toString();
      this.WG.jY().bz(paramMap);
      bh.y("ArbitraryPixel: url = " + paramMap);
    } while (str == null);
    try
    {
      WF.add(str);
      cy.a(this.mContext, WE, str, "true");
      return;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract aq jY();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */