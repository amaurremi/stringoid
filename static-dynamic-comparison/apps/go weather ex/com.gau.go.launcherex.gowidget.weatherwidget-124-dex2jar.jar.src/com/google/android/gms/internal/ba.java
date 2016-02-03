package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class ba
{
  public static final bb mG = new bb()
  {
    public void b(dz paramAnonymousdz, Map<String, String> paramAnonymousMap) {}
  };
  public static final bb mH = new bb()
  {
    public void b(dz paramAnonymousdz, Map<String, String> paramAnonymousMap)
    {
      paramAnonymousMap = (String)paramAnonymousMap.get("urls");
      if (TextUtils.isEmpty(paramAnonymousMap))
      {
        dw.z("URLs missing in canOpenURLs GMSG.");
        return;
      }
      String[] arrayOfString = paramAnonymousMap.split(",");
      HashMap localHashMap = new HashMap();
      PackageManager localPackageManager = paramAnonymousdz.getContext().getPackageManager();
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
          label100:
          if (localPackageManager.resolveActivity(new Intent(paramAnonymousMap, Uri.parse(str2)), 65536) == null) {
            break label152;
          }
        }
        label152:
        for (boolean bool = true;; bool = false)
        {
          localHashMap.put(str1, Boolean.valueOf(bool));
          i += 1;
          break;
          paramAnonymousMap = "android.intent.action.VIEW";
          break label100;
        }
      }
      paramAnonymousdz.a("openableURLs", localHashMap);
    }
  };
  public static final bb mI = new bb()
  {
    public void b(dz paramAnonymousdz, Map<String, String> paramAnonymousMap)
    {
      str = (String)paramAnonymousMap.get("u");
      if (str == null)
      {
        dw.z("URL missing from click GMSG.");
        return;
      }
      paramAnonymousMap = Uri.parse(str);
      try
      {
        Object localObject = paramAnonymousdz.bJ();
        if ((localObject == null) || (!((l)localObject).a(paramAnonymousMap))) {
          break label111;
        }
        localObject = ((l)localObject).a(paramAnonymousMap, paramAnonymousdz.getContext());
        paramAnonymousMap = (Map<String, String>)localObject;
      }
      catch (m localm)
      {
        for (;;)
        {
          dw.z("Unable to append parameter to URL: " + str);
        }
      }
      paramAnonymousMap = paramAnonymousMap.toString();
      new du(paramAnonymousdz.getContext(), paramAnonymousdz.bK().rq, paramAnonymousMap).start();
    }
  };
  public static final bb mJ = new bb()
  {
    public void b(dz paramAnonymousdz, Map<String, String> paramAnonymousMap)
    {
      paramAnonymousdz = paramAnonymousdz.bH();
      if (paramAnonymousdz == null)
      {
        dw.z("A GMSG tried to close something that wasn't an overlay.");
        return;
      }
      paramAnonymousdz.close();
    }
  };
  public static final bb mK = new bb()
  {
    public void b(dz paramAnonymousdz, Map<String, String> paramAnonymousMap)
    {
      paramAnonymousdz = paramAnonymousdz.bH();
      if (paramAnonymousdz == null)
      {
        dw.z("A GMSG tried to use a custom close button on something that wasn't an overlay.");
        return;
      }
      paramAnonymousdz.i("1".equals(paramAnonymousMap.get("custom_close")));
    }
  };
  public static final bb mL = new bb()
  {
    public void b(dz paramAnonymousdz, Map<String, String> paramAnonymousMap)
    {
      paramAnonymousMap = (String)paramAnonymousMap.get("u");
      if (paramAnonymousMap == null)
      {
        dw.z("URL missing from httpTrack GMSG.");
        return;
      }
      new du(paramAnonymousdz.getContext(), paramAnonymousdz.bK().rq, paramAnonymousMap).start();
    }
  };
  public static final bb mM = new bb()
  {
    public void b(dz paramAnonymousdz, Map<String, String> paramAnonymousMap)
    {
      dw.x("Received log message: " + (String)paramAnonymousMap.get("string"));
    }
  };
  public static final bb mN = new bb()
  {
    public void b(dz paramAnonymousdz, Map<String, String> paramAnonymousMap)
    {
      String str1 = (String)paramAnonymousMap.get("tx");
      String str2 = (String)paramAnonymousMap.get("ty");
      paramAnonymousMap = (String)paramAnonymousMap.get("td");
      try
      {
        int i = Integer.parseInt(str1);
        int j = Integer.parseInt(str2);
        int k = Integer.parseInt(paramAnonymousMap);
        paramAnonymousdz = paramAnonymousdz.bJ();
        if (paramAnonymousdz != null) {
          paramAnonymousdz.y().a(i, j, k);
        }
        return;
      }
      catch (NumberFormatException paramAnonymousdz)
      {
        dw.z("Could not parse touch parameters from gmsg.");
      }
    }
  };
  public static final bb mO = new be();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */