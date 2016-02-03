package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class ao
  extends aj
{
  private static final String ID = a.aa.toString();
  private static final String XQ = b.bi.toString();
  private static final String XS = b.cH.toString();
  private static final String XW = b.aZ.toString();
  
  public ao()
  {
    super(ID, new String[] { XQ });
  }
  
  private byte[] c(String paramString, byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException
  {
    paramString = MessageDigest.getInstance(paramString);
    paramString.update(paramArrayOfByte);
    return paramString.digest();
  }
  
  public boolean jX()
  {
    return true;
  }
  
  public d.a x(Map<String, d.a> paramMap)
  {
    Object localObject = (d.a)paramMap.get(XQ);
    if ((localObject == null) || (localObject == dh.lT())) {
      return dh.lT();
    }
    String str = dh.j((d.a)localObject);
    localObject = (d.a)paramMap.get(XW);
    if (localObject == null)
    {
      localObject = "MD5";
      paramMap = (d.a)paramMap.get(XS);
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
        paramMap = dh.r(j.d(c((String)localObject, paramMap)));
        return paramMap;
      }
      catch (NoSuchAlgorithmException paramMap)
      {
        label110:
        label118:
        bh.w("Hash: unknown algorithm: " + (String)localObject);
      }
      localObject = dh.j((d.a)localObject);
      break;
      paramMap = dh.j(paramMap);
      break label73;
      if ("base16".equals(paramMap))
      {
        paramMap = j.bm(str);
      }
      else
      {
        bh.w("Hash: unknown input format: " + paramMap);
        return dh.lT();
      }
    }
    return dh.lT();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */