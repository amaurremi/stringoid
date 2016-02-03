package com.getjar.sdk.comm;

import android.content.Context;
import com.getjar.sdk.GetjarClient;
import com.getjar.sdk.data.DeviceMetadata;
import com.getjar.sdk.exceptions.CommunicationException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.StringUtility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;

public class CommContext
{
  private final Context _applicationContext;
  private final String _commContextId;
  private ConcurrentLinkedQueue<CommFailureCallbackInterface> _commFailureCallbackInterfaceList = new ConcurrentLinkedQueue();
  private final DeviceMetadata _deviceMetadata;
  private ConcurrentHashMap<Long, Throwable> _epochToException = new ConcurrentHashMap();
  private volatile long _lastUpdated;
  private final GetjarClient _parentGetjarClient;
  private final Object _reAuthLock = new Object();
  private final String _sdkUserAgent;
  private String _webKitUserAgent;
  private HashMap<String, String> nonces = new HashMap();
  private HashMap<String, String> signatures = new HashMap();
  
  protected CommContext(Context paramContext, GetjarClient paramGetjarClient)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    this._parentGetjarClient = paramGetjarClient;
    this._commContextId = UUID.randomUUID().toString();
    Logger.v(Area.COMM.value(), "CommContext: creating DeviceMetadata instance", new Object[0]);
    this._deviceMetadata = new DeviceMetadata(paramContext);
    this._applicationContext = paramContext.getApplicationContext();
    Logger.v(Area.COMM.value(), "CommContext: calling UserAgentValuesManager.getSdkUserAgent()", new Object[0]);
    this._sdkUserAgent = UserAgentValuesManager.getInstance().getSdkUserAgent(paramContext);
    updateLastUpdated();
  }
  
  private static <T extends Comparable<? super T>> List<T> asSortedList(Collection<T> paramCollection)
  {
    paramCollection = new ArrayList(paramCollection);
    Collections.sort(paramCollection);
    return paramCollection;
  }
  
  public void addException(Throwable paramThrowable)
  {
    this._epochToException.put(Long.valueOf(System.currentTimeMillis()), paramThrowable);
  }
  
  protected void clearExceptions()
  {
    this._epochToException.clear();
  }
  
  public Context getApplicationContext()
  {
    return this._applicationContext;
  }
  
  public String getCommContextId()
  {
    return this._commContextId;
  }
  
  public DeviceMetadata getDeviceMetadata()
  {
    return this._deviceMetadata;
  }
  
  protected String getDeviceMetadataJson()
  {
    try
    {
      String str = this._deviceMetadata.toJsonString();
      return str;
    }
    catch (JSONException localJSONException)
    {
      throw new CommunicationException(localJSONException);
    }
  }
  
  protected String getDeviceMetadataJsonWithReliabilities()
  {
    try
    {
      String str = this._deviceMetadata.toJsonStringWithReliabilities();
      return str;
    }
    catch (JSONException localJSONException)
    {
      throw new CommunicationException(localJSONException);
    }
  }
  
  public Map<String, String> getDeviceMetadataValues()
  {
    return this._deviceMetadata.getMetadata();
  }
  
  public Map<Long, Throwable> getExceptions()
  {
    return Collections.unmodifiableMap(this._epochToException);
  }
  
  public GetjarClient getGetjarClient()
  {
    return this._parentGetjarClient;
  }
  
  protected long getLastUpdated()
  {
    return this._lastUpdated;
  }
  
  public Throwable getMostRecentException()
  {
    if (getExceptions().size() > 0)
    {
      List localList = asSortedList(getExceptions().keySet());
      return (Throwable)getExceptions().get(localList.get(0));
    }
    return null;
  }
  
  public Object getReAuthLock()
  {
    return this._reAuthLock;
  }
  
  public String getSdkUserAgent()
  {
    return this._sdkUserAgent;
  }
  
  public String getWebKitUserAgent()
  {
    if (StringUtility.isNullOrEmpty(this._webKitUserAgent)) {
      this._webKitUserAgent = UserAgentValuesManager.getInstance().getWebKitUserAgent(this._applicationContext);
    }
    return this._webKitUserAgent;
  }
  
  public void makeAuthorizationFailureCallbacks(String paramString)
  {
    Logger.d(Area.AUTH.value(), "makeAuthorizationFailureCallbacks() with %1$d call-back interfaces registered [from %2$s]", new Object[] { Integer.valueOf(this._commFailureCallbackInterfaceList.size()), Thread.currentThread().getStackTrace()[3].getMethodName() });
    Iterator localIterator = this._commFailureCallbackInterfaceList.iterator();
    while (localIterator.hasNext())
    {
      CommFailureCallbackInterface localCommFailureCallbackInterface = (CommFailureCallbackInterface)localIterator.next();
      try
      {
        localCommFailureCallbackInterface.authorizationFailure(paramString);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void makeNetworkFailureCallbacks()
  {
    Logger.d(Area.COMM.value(), "makeNetworkFailureCallbacks() with %1$d call-back interfaces registered [from %2$s]", new Object[] { Integer.valueOf(this._commFailureCallbackInterfaceList.size()), Thread.currentThread().getStackTrace()[3].getMethodName() });
    Iterator localIterator = this._commFailureCallbackInterfaceList.iterator();
    while (localIterator.hasNext())
    {
      CommFailureCallbackInterface localCommFailureCallbackInterface = (CommFailureCallbackInterface)localIterator.next();
      try
      {
        localCommFailureCallbackInterface.networkFailure();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void makeServiceFailureCallbacks(Result paramResult)
  {
    Logger.d(Area.COMM.value(), "makeServiceFailureCallbacks() with %1$d call-back interfaces registered [from %2$s]", new Object[] { Integer.valueOf(this._commFailureCallbackInterfaceList.size()), Thread.currentThread().getStackTrace()[3].getMethodName() });
    Iterator localIterator = this._commFailureCallbackInterfaceList.iterator();
    while (localIterator.hasNext())
    {
      CommFailureCallbackInterface localCommFailureCallbackInterface = (CommFailureCallbackInterface)localIterator.next();
      try
      {
        localCommFailureCallbackInterface.serviceFailure(paramResult);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void putNonce(String paramString1, String paramString2)
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("hashKey cannot be null");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("nonce cannot be null");
    }
    this.nonces.put(paramString1, paramString2);
  }
  
  public void putSignature(String paramString1, String paramString2)
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("hashKey cannot be null");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("signature cannot be null");
    }
    this.signatures.put(paramString1, paramString2);
  }
  
  public void registerFailureCallback(CommFailureCallbackInterface paramCommFailureCallbackInterface)
  {
    if (!this._commFailureCallbackInterfaceList.contains(paramCommFailureCallbackInterface)) {
      this._commFailureCallbackInterfaceList.add(paramCommFailureCallbackInterface);
    }
  }
  
  public String removeNonce(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("hashKey cannot be null");
    }
    String str = (String)this.nonces.get(paramString);
    this.nonces.remove(paramString);
    return str;
  }
  
  public String removeSignature(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("hashKey cannot be null");
    }
    String str = (String)this.signatures.get(paramString);
    this.signatures.remove(paramString);
    return str;
  }
  
  protected void updateLastUpdated()
  {
    this._lastUpdated = System.currentTimeMillis();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/CommContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */