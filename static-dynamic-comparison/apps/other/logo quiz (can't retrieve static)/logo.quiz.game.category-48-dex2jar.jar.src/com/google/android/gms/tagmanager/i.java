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
  extends dg
{
  private static final String ID = a.ay.toString();
  private static final String URL = b.eX.toString();
  private static final String anK = b.bl.toString();
  private static final String anL = b.eW.toString();
  static final String anM = "gtm_" + ID + "_unrepeatable";
  private static final Set<String> anN = new HashSet();
  private final a anO;
  private final Context mContext;
  
  public i(Context paramContext)
  {
    this(paramContext, new a()
    {
      public aq nM()
      {
        return y.W(i.this);
      }
    });
  }
  
  i(Context paramContext, a parama)
  {
    super(ID, new String[] { URL });
    this.anO = parama;
    this.mContext = paramContext;
  }
  
  private boolean cg(String paramString)
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        boolean bool2 = ci(paramString);
        if (bool2) {
          return bool1;
        }
        if (ch(paramString)) {
          anN.add(paramString);
        } else {
          bool1 = false;
        }
      }
      finally {}
    }
  }
  
  public void E(Map<String, d.a> paramMap)
  {
    String str;
    if (paramMap.get(anL) != null)
    {
      str = di.j((d.a)paramMap.get(anL));
      if ((str == null) || (!cg(str))) {
        break label46;
      }
    }
    label46:
    do
    {
      return;
      str = null;
      break;
      Uri.Builder localBuilder = Uri.parse(di.j((d.a)paramMap.get(URL))).buildUpon();
      paramMap = (d.a)paramMap.get(anK);
      if (paramMap != null)
      {
        paramMap = di.o(paramMap);
        if (!(paramMap instanceof List))
        {
          bh.T("ArbitraryPixel: additional params not a list: not sending partial hit: " + localBuilder.build().toString());
          return;
        }
        paramMap = ((List)paramMap).iterator();
        while (paramMap.hasNext())
        {
          Object localObject = paramMap.next();
          if (!(localObject instanceof Map))
          {
            bh.T("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + localBuilder.build().toString());
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
      this.anO.nM().cw(paramMap);
      bh.V("ArbitraryPixel: url = " + paramMap);
    } while (str == null);
    try
    {
      anN.add(str);
      cz.a(this.mContext, anM, str, "true");
      return;
    }
    finally {}
  }
  
  boolean ch(String paramString)
  {
    return this.mContext.getSharedPreferences(anM, 0).contains(paramString);
  }
  
  boolean ci(String paramString)
  {
    return anN.contains(paramString);
  }
  
  public static abstract interface a
  {
    public abstract aq nM();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */