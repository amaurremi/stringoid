package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

public final class r
{
  public static final s xK = new s()
  {
    public void a(dd paramAnonymousdd, Map<String, String> paramAnonymousMap)
    {
      paramAnonymousMap = (String)paramAnonymousMap.get("urls");
      if (paramAnonymousMap == null)
      {
        ce.D("URLs missing in canOpenURLs GMSG.");
        return;
      }
      String[] arrayOfString = paramAnonymousMap.split(",");
      HashMap localHashMap = new HashMap();
      PackageManager localPackageManager = paramAnonymousdd.getContext().getPackageManager();
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
      paramAnonymousdd.a("openableURLs", localHashMap);
    }
  };
  public static final s xL = new s()
  {
    public void a(dd paramAnonymousdd, Map<String, String> paramAnonymousMap)
    {
      str = (String)paramAnonymousMap.get("u");
      if (str == null)
      {
        ce.D("URL missing from click GMSG.");
        return;
      }
      paramAnonymousMap = Uri.parse(str);
      try
      {
        Object localObject = paramAnonymousdd.pY();
        if ((localObject == null) || (!((gn)localObject).e(paramAnonymousMap))) {
          break label111;
        }
        localObject = ((gn)localObject).a(paramAnonymousMap, paramAnonymousdd.getContext());
        paramAnonymousMap = (Map<String, String>)localObject;
      }
      catch (m localm)
      {
        for (;;)
        {
          ce.D("Unable to append parameter to URL: " + str);
        }
      }
      paramAnonymousMap = paramAnonymousMap.toString();
      new ca(paramAnonymousdd.getContext(), paramAnonymousdd.pZ().FK, paramAnonymousMap).start();
    }
  };
  public static final s xM = new s()
  {
    public void a(dd paramAnonymousdd, Map<String, String> paramAnonymousMap)
    {
      paramAnonymousdd = paramAnonymousdd.pW();
      if (paramAnonymousdd == null)
      {
        ce.D("A GMSG tried to close something that wasn't an overlay.");
        return;
      }
      paramAnonymousdd.close();
    }
  };
  public static final s xN = new s()
  {
    public void a(dd paramAnonymousdd, Map<String, String> paramAnonymousMap)
    {
      paramAnonymousdd = paramAnonymousdd.pW();
      if (paramAnonymousdd == null)
      {
        ce.D("A GMSG tried to use a custom close button on something that wasn't an overlay.");
        return;
      }
      paramAnonymousdd.x("1".equals(paramAnonymousMap.get("custom_close")));
    }
  };
  public static final s xO = new s()
  {
    public void a(dd paramAnonymousdd, Map<String, String> paramAnonymousMap)
    {
      paramAnonymousMap = (String)paramAnonymousMap.get("u");
      if (paramAnonymousMap == null)
      {
        ce.D("URL missing from httpTrack GMSG.");
        return;
      }
      new ca(paramAnonymousdd.getContext(), paramAnonymousdd.pZ().FK, paramAnonymousMap).start();
    }
  };
  public static final s xP = new s()
  {
    public void a(dd paramAnonymousdd, Map<String, String> paramAnonymousMap)
    {
      ce.aa("Received log message: " + (String)paramAnonymousMap.get("string"));
    }
  };
  public static final s xQ = new t();
  public static final s xR = new s()
  {
    public void a(dd paramAnonymousdd, Map<String, String> paramAnonymousMap)
    {
      String str1 = (String)paramAnonymousMap.get("tx");
      String str2 = (String)paramAnonymousMap.get("ty");
      paramAnonymousMap = (String)paramAnonymousMap.get("td");
      try
      {
        int i = Integer.parseInt(str1);
        int j = Integer.parseInt(str2);
        int k = Integer.parseInt(paramAnonymousMap);
        paramAnonymousdd = paramAnonymousdd.pY();
        if (paramAnonymousdd != null) {
          paramAnonymousdd.tA().e(i, j, k);
        }
        return;
      }
      catch (NumberFormatException paramAnonymousdd)
      {
        ce.D("Could not parse touch parameters from gmsg.");
      }
    }
  };
  public static final s xS = new u();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */