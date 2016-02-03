package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

public final class am
{
  public static final an fn = new an()
  {
    public void a(cw paramAnonymouscw, Map<String, String> paramAnonymousMap)
    {
      paramAnonymousMap = (String)paramAnonymousMap.get("urls");
      if (paramAnonymousMap == null)
      {
        ct.v("URLs missing in canOpenURLs GMSG.");
        return;
      }
      String[] arrayOfString = paramAnonymousMap.split(",");
      HashMap localHashMap = new HashMap();
      PackageManager localPackageManager = paramAnonymouscw.getContext().getPackageManager();
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        String str1 = arrayOfString[i];
        paramAnonymousMap = str1.split(";", 2);
        String str2 = paramAnonymousMap[0].trim();
        if (paramAnonymousMap.length > 1)
        {
          paramAnonymousMap = paramAnonymousMap[1].trim();
          label97:
          if (localPackageManager.resolveActivity(new Intent(paramAnonymousMap, Uri.parse(str2)), 65536) == null) {
            break label149;
          }
        }
        label149:
        for (boolean bool = true;; bool = false)
        {
          localHashMap.put(str1, Boolean.valueOf(bool));
          i += 1;
          break;
          paramAnonymousMap = "android.intent.action.VIEW";
          break label97;
        }
      }
      paramAnonymouscw.a("openableURLs", localHashMap);
    }
  };
  public static final an fo = new an()
  {
    public void a(cw paramAnonymouscw, Map<String, String> paramAnonymousMap)
    {
      str = (String)paramAnonymousMap.get("u");
      if (str == null)
      {
        ct.v("URL missing from click GMSG.");
        return;
      }
      paramAnonymousMap = Uri.parse(str);
      try
      {
        Object localObject = paramAnonymouscw.aD();
        if ((localObject == null) || (!((h)localObject).a(paramAnonymousMap))) {
          break label111;
        }
        localObject = ((h)localObject).a(paramAnonymousMap, paramAnonymouscw.getContext());
        paramAnonymousMap = (Map<String, String>)localObject;
      }
      catch (i locali)
      {
        for (;;)
        {
          ct.v("Unable to append parameter to URL: " + str);
        }
      }
      paramAnonymousMap = paramAnonymousMap.toString();
      new cr(paramAnonymouscw.getContext(), paramAnonymouscw.aE().iJ, paramAnonymousMap).start();
    }
  };
  public static final an fp = new an()
  {
    public void a(cw paramAnonymouscw, Map<String, String> paramAnonymousMap)
    {
      paramAnonymouscw = paramAnonymouscw.aB();
      if (paramAnonymouscw == null)
      {
        ct.v("A GMSG tried to close something that wasn't an overlay.");
        return;
      }
      paramAnonymouscw.close();
    }
  };
  public static final an fq = new an()
  {
    public void a(cw paramAnonymouscw, Map<String, String> paramAnonymousMap)
    {
      paramAnonymouscw = paramAnonymouscw.aB();
      if (paramAnonymouscw == null)
      {
        ct.v("A GMSG tried to use a custom close button on something that wasn't an overlay.");
        return;
      }
      paramAnonymouscw.g("1".equals(paramAnonymousMap.get("custom_close")));
    }
  };
  public static final an fr = new an()
  {
    public void a(cw paramAnonymouscw, Map<String, String> paramAnonymousMap)
    {
      paramAnonymousMap = (String)paramAnonymousMap.get("u");
      if (paramAnonymousMap == null)
      {
        ct.v("URL missing from httpTrack GMSG.");
        return;
      }
      new cr(paramAnonymouscw.getContext(), paramAnonymouscw.aE().iJ, paramAnonymousMap).start();
    }
  };
  public static final an fs = new an()
  {
    public void a(cw paramAnonymouscw, Map<String, String> paramAnonymousMap)
    {
      ct.t("Received log message: " + (String)paramAnonymousMap.get("string"));
    }
  };
  public static final an ft = new ao();
  public static final an fu = new an()
  {
    public void a(cw paramAnonymouscw, Map<String, String> paramAnonymousMap)
    {
      String str1 = (String)paramAnonymousMap.get("tx");
      String str2 = (String)paramAnonymousMap.get("ty");
      paramAnonymousMap = (String)paramAnonymousMap.get("td");
      try
      {
        int i = Integer.parseInt(str1);
        int j = Integer.parseInt(str2);
        int k = Integer.parseInt(paramAnonymousMap);
        paramAnonymouscw = paramAnonymouscw.aD();
        if (paramAnonymouscw != null) {
          paramAnonymouscw.g().a(i, j, k);
        }
        return;
      }
      catch (NumberFormatException paramAnonymouscw)
      {
        ct.v("Could not parse touch parameters from gmsg.");
      }
    }
  };
  public static final an fv = new ap();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */