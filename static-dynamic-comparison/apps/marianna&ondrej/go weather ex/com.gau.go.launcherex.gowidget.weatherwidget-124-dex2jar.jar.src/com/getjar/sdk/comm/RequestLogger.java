package com.getjar.sdk.comm;

import android.accounts.AccountManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.StringUtility;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;

public class RequestLogger
{
  private static volatile Integer _AccountsCount;
  private static volatile Object _AccountsCountLock;
  private static int _ConnectionTimeout = 60000;
  private static final ThreadPoolExecutor _ExecutorService = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
  private static final int _MaxQueueSize = 100;
  private static String _PrefesFileName;
  private static String _PrefsKeyInstallationId;
  private static volatile Object _PrefsLock;
  private static int _SocketTimeout = 60000;
  private String _authFlowId = null;
  private final String _commContextId;
  private final Context _context;
  private String _installationId = null;
  private final String _loggingEndPoint;
  private final long _requestId;
  private String _sdkUserAgent = null;
  private final String _serviceEndPoint;
  private Long _timestampBefore = null;
  private final String _uniqueRequestId;
  
  static
  {
    _AccountsCount = null;
    _AccountsCountLock = new Object();
    _PrefesFileName = "RequestLoggerPrefs";
    _PrefsKeyInstallationId = "installationId";
    _PrefsLock = new Object();
  }
  
  public RequestLogger(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    this(paramContext, paramString1, null, paramString2, paramLong);
  }
  
  private RequestLogger(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    this._context = paramContext;
    this._serviceEndPoint = paramString3;
    this._requestId = paramLong;
    this._uniqueRequestId = UUID.randomUUID().toString();
    this._commContextId = paramString2;
    resolveAccountsCount();
    resolveInstallationID();
    this._loggingEndPoint = paramString1;
  }
  
  public RequestLogger(CommContext paramCommContext, String paramString, long paramLong)
  {
    this(paramCommContext.getApplicationContext(), GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.logging.endpoint", SettingsManager.Scope.CLIENT), paramCommContext.getCommContextId(), paramString, paramLong);
  }
  
  public RequestLogger(CommContext paramCommContext, String paramString1, long paramLong, String paramString2)
  {
    this(paramCommContext, paramString1, paramLong);
  }
  
  private void addCommonArgs(Map<String, String> paramMap)
  {
    paramMap.put("pid", Integer.toString(Process.myPid()));
    paramMap.put("uniqueRequestId", this._uniqueRequestId);
    paramMap.put("installationId", this._installationId);
    paramMap.put("requestId", Long.toString(this._requestId));
    paramMap.put("packageName", this._context.getPackageName());
    if (!StringUtility.isNullOrEmpty(this._commContextId)) {
      paramMap.put("contextId", this._commContextId);
    }
    AuthManager.initialize(this._context);
    if (!StringUtility.isNullOrEmpty(AuthManager.getInstance().getUserAccessId())) {
      paramMap.put("userAccessId", AuthManager.getInstance().getUserAccessId());
    }
    if (!StringUtility.isNullOrEmpty(AuthManager.getInstance().getUserDeviceId())) {
      paramMap.put("userDeviceId", AuthManager.getInstance().getUserDeviceId());
    }
    paramMap.put("endPoint", this._serviceEndPoint);
    if (!StringUtility.isNullOrEmpty(this._authFlowId))
    {
      paramMap.put("authFlowId", this._authFlowId);
      paramMap.put("accountsCount", Integer.toString(_AccountsCount.intValue()));
    }
  }
  
  private int getAndroidAccountsCount()
  {
    try
    {
      int i = AccountManager.get(this._context).getAccountsByType("com.google").length;
      return i;
    }
    catch (Exception localException)
    {
      Logger.e(Area.COMM.value(), localException, "RequestLogger: getAndroidAccounts() failed", new Object[0]);
    }
    return 0;
  }
  
  private void logRequestBefore(Operation paramOperation, final String paramString1, final String paramString2)
  {
    if (_ExecutorService.getActiveCount() > 100)
    {
      Logger.w(Area.COMM.value(), "RequestLogger: queue of length %1$d exteeds max of %2$d", new Object[] { Integer.valueOf(_ExecutorService.getActiveCount()), Integer.valueOf(100) });
      return;
    }
    this._timestampBefore = Long.valueOf(System.currentTimeMillis());
    final long l = Thread.currentThread().getId();
    _ExecutorService.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("op", "pre");
          localHashMap.put("timestamp", Long.toString(RequestLogger.this._timestampBefore.longValue()));
          localHashMap.put("tid", Long.toString(l));
          RequestLogger.this.addCommonArgs(localHashMap);
          localObject3 = null;
          Operation localOperation = paramString1;
          Object localObject1 = localObject3;
          if (localOperation != null) {}
          try
          {
            int i = paramString1.getRequest().getEstimatedRequestSizeInBytes();
            localObject1 = Integer.valueOf(i);
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              Logger.w(Area.COMM.value(), "RequestLogger: logRequestBefore() operation.getRequest().getEstimatedRequestSizeInBytes() failed", new Object[0]);
              Object localObject2 = localObject3;
            }
          }
          if (localObject1 != null) {
            localHashMap.put("requestSize", Integer.toString(((Integer)localObject1).intValue()));
          }
          AuthManager.initialize(RequestLogger.this._context);
          localObject1 = AuthManager.getInstance().getAuthToken();
          if (!StringUtility.isNullOrEmpty((String)localObject1)) {
            localHashMap.put("authToken", localObject1);
          }
          if (!StringUtility.isNullOrEmpty(paramString2)) {
            localHashMap.put("stackTrace", paramString2);
          }
          if (!StringUtility.isNullOrEmpty(this.val$authState)) {
            localHashMap.put("authState", this.val$authState);
          }
          RequestLogger.this.pushLogMessage(localHashMap);
          return;
        }
        catch (Exception localException2)
        {
          Object localObject3;
          Logger.e(Area.COMM.value(), localException2, "RequestLogger: logRequestBefore() failed", new Object[0]);
        }
      }
    });
  }
  
  private void pushLogMessage(Map<String, String> paramMap)
  {
    for (;;)
    {
      try
      {
        localObject1 = new StringBuilder(this._loggingEndPoint);
        if ((!this._loggingEndPoint.endsWith("?")) && (!this._loggingEndPoint.endsWith("&")))
        {
          if (this._loggingEndPoint.contains("?")) {
            ((StringBuilder)localObject1).append("&");
          }
        }
        else
        {
          int i = paramMap.size();
          localObject2 = paramMap.keySet().iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          String str1 = (String)((Iterator)localObject2).next();
          int j = i - 1;
          String str2 = (String)paramMap.get(str1);
          i = j;
          if (StringUtility.isNullOrEmpty(str1)) {
            continue;
          }
          i = j;
          if (StringUtility.isNullOrEmpty(str2)) {
            continue;
          }
          ((StringBuilder)localObject1).append(str1);
          ((StringBuilder)localObject1).append("=");
          ((StringBuilder)localObject1).append(URLEncoder.encode(str2, "UTF-8"));
          i = j;
          if (j <= 0) {
            continue;
          }
          ((StringBuilder)localObject1).append("&");
          i = j;
          continue;
        }
        ((StringBuilder)localObject1).append("?");
      }
      catch (Exception paramMap)
      {
        Logger.e(Area.COMM.value(), paramMap, "RequestLogger: failed", new Object[0]);
        return;
      }
    }
    paramMap = ((StringBuilder)localObject1).toString();
    Object localObject1 = resolveUserAgent();
    localObject1 = GetJarHttpClient.newInstance(this._context, (String)localObject1, _ConnectionTimeout, _SocketTimeout);
    Object localObject2 = new HttpGet(paramMap);
    RequestUtilities.debugDumpRequestProperties((HttpRequestBase)localObject2, -1);
    localObject1 = ((GetJarHttpClient)localObject1).execute((HttpUriRequest)localObject2);
    if (localObject1 == null)
    {
      Logger.w(Area.COMM.value(), "RequestLogger: failed [URL:%1$s]", new Object[] { paramMap });
      return;
    }
    Logger.v(Area.COMM.value(), "RequestLogger: logged [URL:%1$s]", new Object[] { paramMap });
    paramMap = null;
    if (((HttpResponse)localObject1).getStatusLine() != null) {
      paramMap = Integer.valueOf(((HttpResponse)localObject1).getStatusLine().getStatusCode());
    }
    if (paramMap != null)
    {
      Logger.d(Area.COMM.value(), "RequestLogger: result code: %1$d", new Object[] { paramMap });
      return;
    }
    Logger.w(Area.COMM.value(), "RequestLogger: failed to get result code", new Object[0]);
  }
  
  private void resolveAccountsCount()
  {
    if (_AccountsCount == null) {
      synchronized (_AccountsCountLock)
      {
        if (_AccountsCount == null) {
          _AccountsCount = Integer.valueOf(getAndroidAccountsCount());
        }
        return;
      }
    }
  }
  
  private void resolveInstallationID()
  {
    for (;;)
    {
      try
      {
        localSharedPreferences = this._context.getSharedPreferences(_PrefesFileName, 0);
        if (localSharedPreferences.contains(_PrefsKeyInstallationId)) {}
      }
      catch (Exception localException)
      {
        SharedPreferences localSharedPreferences;
        Logger.e(Area.COMM.value(), localException, "RequestLogger failed", new Object[0]);
        if (!StringUtility.isNullOrEmpty(this._installationId)) {
          continue;
        }
        this._installationId = "failedToGetInstallationId";
        continue;
      }
      synchronized (_PrefsLock)
      {
        if (!localSharedPreferences.contains(_PrefsKeyInstallationId))
        {
          this._installationId = UUID.randomUUID().toString();
          SharedPreferences.Editor localEditor = localSharedPreferences.edit();
          localEditor.putString(_PrefsKeyInstallationId, this._installationId).commit();
          localEditor.commit();
        }
        if (StringUtility.isNullOrEmpty(this._installationId)) {
          this._installationId = localSharedPreferences.getString(_PrefsKeyInstallationId, "failedToGetInstallationId");
        }
        Logger.d(Area.COMM.value(), "RequestLogger:_installation ID = '%1$s'", new Object[] { this._installationId });
        return;
      }
    }
  }
  
  private String resolveUserAgent()
  {
    try
    {
      if (!StringUtility.isNullOrEmpty(this._sdkUserAgent)) {
        return this._sdkUserAgent;
      }
      this._sdkUserAgent = UserAgentValuesManager.getInstance().getSdkUserAgent(this._context);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.w(Area.COMM.value(), localException, "RequestLogger: resolveUserAgent() failed", new Object[0]);
      }
    }
    if (!StringUtility.isNullOrEmpty(this._sdkUserAgent)) {
      return this._sdkUserAgent;
    }
    return "UNRESOLVED";
  }
  
  public void logAuthStateBefore(String paramString)
  {
    logRequestBefore(null, null, paramString);
  }
  
  public void logAuthStateBeforeWithStack(String paramString)
  {
    logRequestBefore(null, Logger.getShortStack(), paramString);
  }
  
  public void logRequestAfter(Operation paramOperation, Integer paramInteger1, Integer paramInteger2, Exception paramException, int paramInt1, int paramInt2)
  {
    logRequestAfter(paramOperation, paramInteger1, paramInteger2, paramException, paramInt1, paramInt2, null);
  }
  
  public void logRequestAfter(final Operation paramOperation, final Integer paramInteger1, final Integer paramInteger2, Exception paramException, int paramInt1, final int paramInt2, final String paramString)
  {
    if (_ExecutorService.getActiveCount() > 100)
    {
      Logger.w(Area.COMM.value(), "RequestLogger: queue of length %1$d exceeds max of %2$d", new Object[] { Integer.valueOf(_ExecutorService.getActiveCount()), Integer.valueOf(100) });
      return;
    }
    final long l1 = System.currentTimeMillis();
    long l2 = this._timestampBefore.longValue();
    final long l3 = Thread.currentThread().getId();
    _ExecutorService.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("op", "post");
          localHashMap.put("timestamp", Long.toString(l1));
          localHashMap.put("reauthCount", Integer.toString(paramInt2));
          localHashMap.put("exceptionCount", Integer.toString(l3));
          localHashMap.put("tid", Long.toString(paramOperation));
          RequestLogger.this.addCommonArgs(localHashMap);
          localObject3 = null;
          Operation localOperation = paramInteger1;
          Object localObject1 = localObject3;
          if (localOperation != null) {}
          try
          {
            int i = paramInteger1.getResult().getEstimatedResponseSizeInBytes();
            localObject1 = Integer.valueOf(i);
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              Logger.w(Area.COMM.value(), "RequestLogger: logRequestAfter() operation.getResult().getEstimatedResponseSizeInBytes() failed", new Object[0]);
              Object localObject2 = localObject3;
            }
          }
          if (localObject1 != null) {
            localHashMap.put("responseSize", Integer.toString(((Integer)localObject1).intValue()));
          }
          localHashMap.put("timeDelta", Long.toString(paramInteger2));
          if (paramString != null) {
            localHashMap.put("responseCode", Integer.toString(paramString.intValue()));
          }
          if (this.val$executionTime != null) {
            localHashMap.put("executionTime", Integer.toString(this.val$executionTime.intValue()));
          }
          if (this.val$exception != null)
          {
            localHashMap.put("exception", this.val$exception.getClass().getName());
            localHashMap.put("stackTrace", Logger.getShortStack(this.val$exception.getStackTrace()));
          }
          if (!StringUtility.isNullOrEmpty(this.val$authState)) {
            localHashMap.put("authState", this.val$authState);
          }
          RequestLogger.this.pushLogMessage(localHashMap);
          return;
        }
        catch (Exception localException2)
        {
          Object localObject3;
          Logger.e(Area.COMM.value(), localException2, "RequestLogger: logRequestAfter() failed", new Object[0]);
        }
      }
    });
  }
  
  public void logRequestBefore()
  {
    logRequestBefore(null, Logger.getShortStack(), null);
  }
  
  public void logRequestBefore(Operation paramOperation)
  {
    logRequestBefore(paramOperation, null, null);
  }
  
  public void logRewardsWallShow()
  {
    if (_ExecutorService.getActiveCount() > 100)
    {
      Logger.w(Area.COMM.value(), "RequestLogger: queue of length %1$d exteeds max of %2$d", new Object[] { Integer.valueOf(_ExecutorService.getActiveCount()), Integer.valueOf(100) });
      return;
    }
    final long l1 = System.currentTimeMillis();
    long l2 = Thread.currentThread().getId();
    _ExecutorService.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("op", "pre");
          localHashMap.put("timestamp", Long.toString(l1));
          localHashMap.put("tid", Long.toString(this.val$tid));
          RequestLogger.this.addCommonArgs(localHashMap);
          AuthManager.initialize(RequestLogger.this._context);
          String str = AuthManager.getInstance().getAuthToken();
          if (!StringUtility.isNullOrEmpty(str)) {
            localHashMap.put("authToken", str);
          }
          RequestLogger.this.pushLogMessage(localHashMap);
          return;
        }
        catch (Exception localException)
        {
          Logger.e(Area.COMM.value(), localException, "RequestLogger: logRequestBefore() failed", new Object[0]);
        }
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/RequestLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */