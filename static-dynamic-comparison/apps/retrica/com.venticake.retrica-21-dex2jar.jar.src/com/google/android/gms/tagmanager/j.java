package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class j
  extends t
{
  private static final String a = a.Y.toString();
  private static final String b = b.bi.toString();
  private static final String c = b.di.toString();
  private static final String d = b.cH.toString();
  private static final String e = b.dq.toString();
  
  public j()
  {
    super(a, new String[] { b });
  }
  
  public d.a a(Map<String, d.a> paramMap)
  {
    Object localObject = (d.a)paramMap.get(b);
    if ((localObject == null) || (localObject == de.g())) {
      return de.g();
    }
    String str2 = de.a((d.a)localObject);
    localObject = (d.a)paramMap.get(d);
    String str1;
    if (localObject == null)
    {
      str1 = "text";
      localObject = (d.a)paramMap.get(e);
      if (localObject != null) {
        break label148;
      }
      localObject = "base16";
      label75:
      paramMap = (d.a)paramMap.get(c);
      if ((paramMap == null) || (!de.e(paramMap).booleanValue())) {
        break label322;
      }
    }
    label148:
    label257:
    label296:
    label322:
    for (int i = 3;; i = 2)
    {
      for (;;)
      {
        try
        {
          if ("text".equals(str1))
          {
            paramMap = str2.getBytes();
            if (!"base16".equals(localObject)) {
              break label257;
            }
            paramMap = dm.a(paramMap);
            return de.f(paramMap);
            str1 = de.a((d.a)localObject);
            break;
            localObject = de.a((d.a)localObject);
            break label75;
          }
          if ("base16".equals(str1))
          {
            paramMap = dm.a(str2);
            continue;
          }
          if ("base64".equals(str1))
          {
            paramMap = Base64.decode(str2, i);
            continue;
          }
          if ("base64url".equals(str1))
          {
            paramMap = Base64.decode(str2, i | 0x8);
            continue;
          }
          as.a("Encode: unknown input format: " + str1);
          paramMap = de.g();
          return paramMap;
        }
        catch (IllegalArgumentException paramMap)
        {
          as.a("Encode: invalid input:");
          return de.g();
        }
        if ("base64".equals(localObject))
        {
          paramMap = Base64.encodeToString(paramMap, i);
        }
        else
        {
          if (!"base64url".equals(localObject)) {
            break label296;
          }
          paramMap = Base64.encodeToString(paramMap, i | 0x8);
        }
      }
      as.a("Encode: unknown output format: " + (String)localObject);
      return de.g();
    }
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */