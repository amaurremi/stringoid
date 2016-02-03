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
  private static final String aej = b.aX.toString();
  private static final String aek = b.en.toString();
  static final String ael = "gtm_" + ID + "_unrepeatable";
  private static final Set<String> aem = new HashSet();
  private final a aen;
  private final Context mContext;
  
  public i(Context paramContext)
  {
    this(paramContext, new a()
    {
      public aq ld()
      {
        return y.K(i.this);
      }
    });
  }
  
  i(Context paramContext, a parama)
  {
    super(ID, new String[] { URL });
    this.aen = parama;
    this.mContext = paramContext;
  }
  
  private boolean bB(String paramString)
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        boolean bool2 = bD(paramString);
        if (bool2) {
          return bool1;
        }
        if (bC(paramString)) {
          aem.add(paramString);
        } else {
          bool1 = false;
        }
      }
      finally {}
    }
  }
  
  boolean bC(String paramString)
  {
    return this.mContext.getSharedPreferences(ael, 0).contains(paramString);
  }
  
  boolean bD(String paramString)
  {
    return aem.contains(paramString);
  }
  
  public void y(Map<String, d.a> paramMap)
  {
    String str;
    if (paramMap.get(aek) != null)
    {
      str = dh.j((d.a)paramMap.get(aek));
      if ((str == null) || (!bB(str))) {
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
      paramMap = (d.a)paramMap.get(aej);
      if (paramMap != null)
      {
        paramMap = dh.o(paramMap);
        if (!(paramMap instanceof List))
        {
          bh.A("ArbitraryPixel: additional params not a list: not sending partial hit: " + localBuilder.build().toString());
          return;
        }
        paramMap = ((List)paramMap).iterator();
        while (paramMap.hasNext())
        {
          Object localObject = paramMap.next();
          if (!(localObject instanceof Map))
          {
            bh.A("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + localBuilder.build().toString());
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
      this.aen.ld().bR(paramMap);
      bh.C("ArbitraryPixel: url = " + paramMap);
    } while (str == null);
    try
    {
      aem.add(str);
      cy.a(this.mContext, ael, str, "true");
      return;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract aq ld();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */