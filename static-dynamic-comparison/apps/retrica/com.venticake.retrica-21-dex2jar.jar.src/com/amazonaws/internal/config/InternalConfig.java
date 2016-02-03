package com.amazonaws.internal.config;

import com.amazonaws.util.ClassLoaderHelper;
import com.amazonaws.util.json.Jackson;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.Immutable;

@Immutable
public class InternalConfig
{
  static final String CONFIG_OVERRIDE_RESOURCE = "awssdk_config_override.json";
  static final String DEFAULT_CONFIG_RESOURCE = "awssdk_config_default.json";
  private static final String SERVICE_REGION_DELIMITOR = "/";
  private static final Log log = LogFactory.getLog(InternalConfig.class);
  private final SignerConfig defaultSignerConfig;
  private final Map<String, HttpClientConfig> httpClients;
  private final Map<String, SignerConfig> regionSigners;
  private final Map<String, SignerConfig> serviceRegionSigners;
  private final Map<String, SignerConfig> serviceSigners;
  
  InternalConfig(InternalConfigJsonHelper paramInternalConfigJsonHelper1, InternalConfigJsonHelper paramInternalConfigJsonHelper2)
  {
    Object localObject = paramInternalConfigJsonHelper1.getDefaultSigner();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((SignerConfigJsonHelper)localObject).build())
    {
      this.defaultSignerConfig = ((SignerConfig)localObject);
      this.regionSigners = mergeSignerMap(paramInternalConfigJsonHelper1.getRegionSigners(), paramInternalConfigJsonHelper2.getRegionSigners(), "region");
      this.serviceSigners = mergeSignerMap(paramInternalConfigJsonHelper1.getServiceSigners(), paramInternalConfigJsonHelper2.getServiceSigners(), "service");
      this.serviceRegionSigners = mergeSignerMap(paramInternalConfigJsonHelper1.getServiceRegionSigners(), paramInternalConfigJsonHelper2.getServiceRegionSigners(), "service/region");
      this.httpClients = merge(paramInternalConfigJsonHelper1.getHttpClients(), paramInternalConfigJsonHelper2.getHttpClients());
      return;
    }
  }
  
  private <C extends Builder<T>, T> Map<String, T> buildMap(JsonIndex<C, T>[] paramArrayOfJsonIndex)
  {
    HashMap localHashMap = new HashMap();
    if (paramArrayOfJsonIndex != null)
    {
      int j = paramArrayOfJsonIndex.length;
      int i = 0;
      while (i < j)
      {
        JsonIndex<C, T> localJsonIndex = paramArrayOfJsonIndex[i];
        if (localHashMap.put(localJsonIndex.getKey(), localJsonIndex.newReadOnlyConfig()) != null) {
          log.warn("Duplicate definition of signer for " + localJsonIndex.getKey());
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  private Map<String, SignerConfig> buildSignerMap(JsonIndex<SignerConfigJsonHelper, SignerConfig>[] paramArrayOfJsonIndex, String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramArrayOfJsonIndex != null)
    {
      int j = paramArrayOfJsonIndex.length;
      int i = 0;
      while (i < j)
      {
        JsonIndex<SignerConfigJsonHelper, SignerConfig> localJsonIndex = paramArrayOfJsonIndex[i];
        if ((SignerConfig)localHashMap.put(localJsonIndex.getKey(), localJsonIndex.newReadOnlyConfig()) != null) {
          log.warn("Duplicate definition of signer for " + paramString + " " + localJsonIndex.getKey());
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  static InternalConfig load()
  {
    URL localURL = ClassLoaderHelper.getResource("/awssdk_config_default.json", new Class[] { InternalConfig.class });
    Object localObject = localURL;
    if (localURL == null) {
      localObject = ClassLoaderHelper.getResource("awssdk_config_default.json", new Class[] { InternalConfig.class });
    }
    InternalConfigJsonHelper localInternalConfigJsonHelper = loadfrom((URL)localObject);
    localURL = ClassLoaderHelper.getResource("/awssdk_config_override.json", new Class[] { InternalConfig.class });
    localObject = localURL;
    if (localURL == null) {
      localObject = ClassLoaderHelper.getResource("awssdk_config_override.json", new Class[] { InternalConfig.class });
    }
    if (localObject == null) {
      log.debug("Configuration override awssdk_config_override.json not found.");
    }
    for (localObject = new InternalConfigJsonHelper();; localObject = loadfrom((URL)localObject)) {
      return new InternalConfig(localInternalConfigJsonHelper, (InternalConfigJsonHelper)localObject);
    }
  }
  
  static InternalConfigJsonHelper loadfrom(URL paramURL)
  {
    if (paramURL == null) {
      throw new IllegalArgumentException();
    }
    return (InternalConfigJsonHelper)Jackson.getObjectMapper().readValue(paramURL, InternalConfigJsonHelper.class);
  }
  
  private <C extends Builder<T>, T> Map<String, T> merge(JsonIndex<C, T>[] paramArrayOfJsonIndex1, JsonIndex<C, T>[] paramArrayOfJsonIndex2)
  {
    paramArrayOfJsonIndex1 = buildMap(paramArrayOfJsonIndex1);
    paramArrayOfJsonIndex1.putAll(buildMap(paramArrayOfJsonIndex2));
    return Collections.unmodifiableMap(paramArrayOfJsonIndex1);
  }
  
  private Map<String, SignerConfig> mergeSignerMap(JsonIndex<SignerConfigJsonHelper, SignerConfig>[] paramArrayOfJsonIndex1, JsonIndex<SignerConfigJsonHelper, SignerConfig>[] paramArrayOfJsonIndex2, String paramString)
  {
    paramArrayOfJsonIndex1 = buildSignerMap(paramArrayOfJsonIndex1, paramString);
    paramArrayOfJsonIndex1.putAll(buildSignerMap(paramArrayOfJsonIndex2, paramString));
    return Collections.unmodifiableMap(paramArrayOfJsonIndex1);
  }
  
  void dump()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("defaultSignerConfig: ").append(this.defaultSignerConfig).append("\n").append("serviceRegionSigners: ").append(this.serviceRegionSigners).append("\n").append("regionSigners: ").append(this.regionSigners).append("\n").append("serviceSigners: ").append(this.serviceSigners);
    log.debug(localStringBuilder.toString());
  }
  
  public HttpClientConfig getHttpClientConfig(String paramString)
  {
    return (HttpClientConfig)this.httpClients.get(paramString);
  }
  
  public SignerConfig getSignerConfig(String paramString)
  {
    return getSignerConfig(paramString, null);
  }
  
  public SignerConfig getSignerConfig(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException();
    }
    Object localObject;
    if (paramString2 != null)
    {
      localObject = paramString1 + "/" + paramString2;
      localObject = (SignerConfig)this.serviceRegionSigners.get(localObject);
      if (localObject != null) {
        paramString2 = (String)localObject;
      }
    }
    do
    {
      do
      {
        return paramString2;
        localObject = (SignerConfig)this.regionSigners.get(paramString2);
        paramString2 = (String)localObject;
      } while (localObject != null);
      paramString1 = (SignerConfig)this.serviceSigners.get(paramString1);
      paramString2 = paramString1;
    } while (paramString1 != null);
    return this.defaultSignerConfig;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/internal/config/InternalConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */