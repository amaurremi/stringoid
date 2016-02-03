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
  private static final String ID = a.ac.toString();
  private static final String aoU = b.bw.toString();
  private static final String aoW = b.de.toString();
  private static final String apa = b.bn.toString();
  
  public ao()
  {
    super(ID, new String[] { aoU });
  }
  
  private byte[] d(String paramString, byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException
  {
    paramString = MessageDigest.getInstance(paramString);
    paramString.update(paramArrayOfByte);
    return paramString.digest();
  }
  
  public d.a C(Map<String, d.a> paramMap)
  {
    Object localObject = (d.a)paramMap.get(aoU);
    if ((localObject == null) || (localObject == di.pI())) {
      return di.pI();
    }
    String str = di.j((d.a)localObject);
    localObject = (d.a)paramMap.get(apa);
    if (localObject == null)
    {
      localObject = "MD5";
      paramMap = (d.a)paramMap.get(aoW);
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
        paramMap = di.u(j.d(d((String)localObject, paramMap)));
        return paramMap;
      }
      catch (NoSuchAlgorithmException paramMap)
      {
        label110:
        label118:
        bh.T("Hash: unknown algorithm: " + (String)localObject);
      }
      localObject = di.j((d.a)localObject);
      break;
      paramMap = di.j(paramMap);
      break label73;
      if ("base16".equals(paramMap))
      {
        paramMap = j.cj(str);
      }
      else
      {
        bh.T("Hash: unknown input format: " + paramMap);
        return di.pI();
      }
    }
    return di.pI();
  }
  
  public boolean nL()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */