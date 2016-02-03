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
  private static final String afB = b.aZ.toString();
  private static final String afv = b.bi.toString();
  private static final String afx = b.cH.toString();
  
  public ao()
  {
    super(ID, new String[] { afv });
  }
  
  private byte[] c(String paramString, byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException
  {
    paramString = MessageDigest.getInstance(paramString);
    paramString.update(paramArrayOfByte);
    return paramString.digest();
  }
  
  public boolean lc()
  {
    return true;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    Object localObject = (d.a)paramMap.get(afv);
    if ((localObject == null) || (localObject == dh.mY())) {
      return dh.mY();
    }
    String str = dh.j((d.a)localObject);
    localObject = (d.a)paramMap.get(afB);
    if (localObject == null)
    {
      localObject = "MD5";
      paramMap = (d.a)paramMap.get(afx);
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
        bh.A("Hash: unknown algorithm: " + (String)localObject);
      }
      localObject = dh.j((d.a)localObject);
      break;
      paramMap = dh.j(paramMap);
      break label73;
      if ("base16".equals(paramMap))
      {
        paramMap = j.bE(str);
      }
      else
      {
        bh.A("Hash: unknown input format: " + paramMap);
        return dh.mY();
      }
    }
    return dh.mY();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */