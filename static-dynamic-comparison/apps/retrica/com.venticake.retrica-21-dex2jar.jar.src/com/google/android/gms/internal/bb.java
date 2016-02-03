package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class bb
{
  public static final bc mT = new bc()
  {
    public void b(ex paramAnonymousex, Map<String, String> paramAnonymousMap) {}
  };
  public static final bc mU = new bc()
  {
    public void b(ex paramAnonymousex, Map<String, String> paramAnonymousMap)
    {
      paramAnonymousMap = (String)paramAnonymousMap.get("urls");
      if (TextUtils.isEmpty(paramAnonymousMap))
      {
        eu.D("URLs missing in canOpenURLs GMSG.");
        return;
      }
      String[] arrayOfString = paramAnonymousMap.split(",");
      HashMap localHashMap = new HashMap();
      PackageManager localPackageManager = paramAnonymousex.getContext().getPackageManager();
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
      paramAnonymousex.a("openableURLs", localHashMap);
    }
  };
  public static final bc mV = new bc()
  {
    public void b(ex paramAnonymousex, Map<String, String> paramAnonymousMap)
    {
      str = (String)paramAnonymousMap.get("u");
      if (str == null)
      {
        eu.D("URL missing from click GMSG.");
        return;
      }
      paramAnonymousMap = Uri.parse(str);
      try
      {
        Object localObject = paramAnonymousex.cc();
        if ((localObject == null) || (!((k)localObject).b(paramAnonymousMap))) {
          break label111;
        }
        localObject = ((k)localObject).a(paramAnonymousMap, paramAnonymousex.getContext());
        paramAnonymousMap = (Map<String, String>)localObject;
      }
      catch (l locall)
      {
        for (;;)
        {
          eu.D("Unable to append parameter to URL: " + str);
        }
      }
      paramAnonymousMap = paramAnonymousMap.toString();
      new es(paramAnonymousex.getContext(), paramAnonymousex.cd().sw, paramAnonymousMap).start();
    }
  };
  public static final bc mW = new bc()
  {
    public void b(ex paramAnonymousex, Map<String, String> paramAnonymousMap)
    {
      paramAnonymousex = paramAnonymousex.ca();
      if (paramAnonymousex == null)
      {
        eu.D("A GMSG tried to close something that wasn't an overlay.");
        return;
      }
      paramAnonymousex.close();
    }
  };
  public static final bc mX = new bc()
  {
    public void b(ex paramAnonymousex, Map<String, String> paramAnonymousMap)
    {
      paramAnonymousex = paramAnonymousex.ca();
      if (paramAnonymousex == null)
      {
        eu.D("A GMSG tried to use a custom close button on something that wasn't an overlay.");
        return;
      }
      paramAnonymousex.j("1".equals(paramAnonymousMap.get("custom_close")));
    }
  };
  public static final bc mY = new bc()
  {
    public void b(ex paramAnonymousex, Map<String, String> paramAnonymousMap)
    {
      paramAnonymousMap = (String)paramAnonymousMap.get("u");
      if (paramAnonymousMap == null)
      {
        eu.D("URL missing from httpTrack GMSG.");
        return;
      }
      new es(paramAnonymousex.getContext(), paramAnonymousex.cd().sw, paramAnonymousMap).start();
    }
  };
  public static final bc mZ = new bc()
  {
    public void b(ex paramAnonymousex, Map<String, String> paramAnonymousMap)
    {
      eu.B("Received log message: " + (String)paramAnonymousMap.get("string"));
    }
  };
  public static final bc na = new bc()
  {
    public void b(ex paramAnonymousex, Map<String, String> paramAnonymousMap)
    {
      String str1 = (String)paramAnonymousMap.get("tx");
      String str2 = (String)paramAnonymousMap.get("ty");
      paramAnonymousMap = (String)paramAnonymousMap.get("td");
      try
      {
        int i = Integer.parseInt(str1);
        int j = Integer.parseInt(str2);
        int k = Integer.parseInt(paramAnonymousMap);
        paramAnonymousex = paramAnonymousex.cc();
        if (paramAnonymousex != null) {
          paramAnonymousex.z().a(i, j, k);
        }
        return;
      }
      catch (NumberFormatException paramAnonymousex)
      {
        eu.D("Could not parse touch parameters from gmsg.");
      }
    }
  };
  public static final bc nb = new bh();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */