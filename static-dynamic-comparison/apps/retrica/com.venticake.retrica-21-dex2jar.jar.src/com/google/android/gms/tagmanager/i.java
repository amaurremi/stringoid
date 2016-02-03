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
  extends dc
{
  static final String a = "gtm_" + b + "_unrepeatable";
  private static final String b = a.ap.toString();
  private static final String c = b.eo.toString();
  private static final String d = b.aX.toString();
  private static final String e = b.en.toString();
  private static final Set<String> f = new HashSet();
  private final i.a g;
  private final Context h;
  
  public i(Context paramContext)
  {
    this(paramContext, new i.a()
    {
      public aa li()
      {
        return eh.a(i.this);
      }
    });
  }
  
  i(Context paramContext, i.a parama)
  {
    super(b, new String[] { c });
    this.g = parama;
    this.h = paramContext;
  }
  
  private boolean c(String paramString)
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        boolean bool2 = b(paramString);
        if (bool2) {
          return bool1;
        }
        if (a(paramString)) {
          f.add(paramString);
        } else {
          bool1 = false;
        }
      }
      finally {}
    }
  }
  
  boolean a(String paramString)
  {
    return this.h.getSharedPreferences(a, 0).contains(paramString);
  }
  
  public void b(Map<String, d.a> paramMap)
  {
    String str;
    if (paramMap.get(e) != null)
    {
      str = de.a((d.a)paramMap.get(e));
      if ((str == null) || (!c(str))) {
        break label46;
      }
    }
    label46:
    do
    {
      return;
      str = null;
      break;
      Uri.Builder localBuilder = Uri.parse(de.a((d.a)paramMap.get(c))).buildUpon();
      paramMap = (d.a)paramMap.get(d);
      if (paramMap != null)
      {
        paramMap = de.f(paramMap);
        if (!(paramMap instanceof List))
        {
          as.a("ArbitraryPixel: additional params not a list: not sending partial hit: " + localBuilder.build().toString());
          return;
        }
        paramMap = ((List)paramMap).iterator();
        while (paramMap.hasNext())
        {
          Object localObject = paramMap.next();
          if (!(localObject instanceof Map))
          {
            as.a("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + localBuilder.build().toString());
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
      this.g.li().a(paramMap);
      as.e("ArbitraryPixel: url = " + paramMap);
    } while (str == null);
    try
    {
      f.add(str);
      ct.a(this.h, a, str, "true");
      return;
    }
    finally {}
  }
  
  boolean b(String paramString)
  {
    return f.contains(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */