package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class y
  extends t
{
  private static final String a = a.aa.toString();
  private static final String b = b.bi.toString();
  private static final String c = b.aZ.toString();
  private static final String d = b.cH.toString();
  
  public y()
  {
    super(a, new String[] { b });
  }
  
  private byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    paramString = MessageDigest.getInstance(paramString);
    paramString.update(paramArrayOfByte);
    return paramString.digest();
  }
  
  public d.a a(Map<String, d.a> paramMap)
  {
    Object localObject = (d.a)paramMap.get(b);
    if ((localObject == null) || (localObject == de.g())) {
      return de.g();
    }
    String str = de.a((d.a)localObject);
    localObject = (d.a)paramMap.get(c);
    if (localObject == null)
    {
      localObject = "MD5";
      paramMap = (d.a)paramMap.get(d);
      if (paramMap != null) {
        break label110;
      }
      paramMap = "text";
      label73:
      if (!"text".equals(paramMap)) {
        break label118;
      }
      paramMap = str.getBytes();
    }
    for (;;)
    {
      try
      {
        paramMap = de.f(dm.a(a((String)localObject, paramMap)));
        return paramMap;
      }
      catch (NoSuchAlgorithmException paramMap)
      {
        label110:
        label118:
        as.a("Hash: unknown algorithm: " + (String)localObject);
      }
      localObject = de.a((d.a)localObject);
      break;
      paramMap = de.a(paramMap);
      break label73;
      if ("base16".equals(paramMap))
      {
        paramMap = dm.a(str);
      }
      else
      {
        as.a("Hash: unknown input format: " + paramMap);
        return de.g();
      }
    }
    return de.g();
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */