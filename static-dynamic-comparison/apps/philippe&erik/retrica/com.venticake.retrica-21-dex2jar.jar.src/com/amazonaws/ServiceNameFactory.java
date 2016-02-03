package com.amazonaws;

import com.amazonaws.internal.config.HttpClientConfig;
import com.amazonaws.internal.config.InternalConfig;
import com.amazonaws.internal.config.InternalConfig.Factory;

 enum ServiceNameFactory
{
  static String getServiceName(String paramString)
  {
    paramString = InternalConfig.Factory.getInternalConfig().getHttpClientConfig(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.getServiceName();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/ServiceNameFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */