package com.amazonaws.auth;

import com.amazonaws.internal.config.InternalConfig;
import com.amazonaws.internal.config.InternalConfig.Factory;
import com.amazonaws.internal.config.SignerConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class SignerFactory
{
  private static final Map<String, Class<? extends Signer>> SIGNERS = new ConcurrentHashMap();
  
  static
  {
    SIGNERS.put("QueryStringSignerType", QueryStringSigner.class);
    SIGNERS.put("AWS3SignerType", AWS3Signer.class);
    SIGNERS.put("AWS4SignerType", AWS4Signer.class);
    SIGNERS.put("NoOpSignerType", NoOpSigner.class);
  }
  
  private static Signer createSigner(String paramString1, String paramString2)
  {
    paramString1 = (Class)SIGNERS.get(paramString1);
    if (paramString1 == null) {
      throw new IllegalArgumentException();
    }
    try
    {
      Signer localSigner = (Signer)paramString1.newInstance();
      if ((localSigner instanceof ServiceAwareSigner)) {
        ((ServiceAwareSigner)localSigner).setServiceName(paramString2);
      }
      return localSigner;
    }
    catch (InstantiationException paramString2)
    {
      throw new IllegalStateException("Cannot create an instance of " + paramString1.getName(), paramString2);
    }
    catch (IllegalAccessException paramString2)
    {
      throw new IllegalStateException("Cannot create an instance of " + paramString1.getName(), paramString2);
    }
  }
  
  public static Signer getSigner(String paramString1, String paramString2)
  {
    return lookupAndCreateSigner(paramString1, paramString2);
  }
  
  public static Signer getSignerByTypeAndService(String paramString1, String paramString2)
  {
    return createSigner(paramString1, paramString2);
  }
  
  private static Signer lookupAndCreateSigner(String paramString1, String paramString2)
  {
    return createSigner(InternalConfig.Factory.getInternalConfig().getSignerConfig(paramString1, paramString2).getSignerType(), paramString1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/auth/SignerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */