package com.getjar.sdk.comm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Process;
import com.getjar.sdk.GetjarClient;
import com.getjar.sdk.GetjarException;
import com.getjar.sdk.OnGetjarWorkFinishedListener;
import com.getjar.sdk.comm.auth.ApplicationTokenDatabase;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.data.metadata.PackageMonitor;
import com.getjar.sdk.exceptions.AuthException;
import com.getjar.sdk.exceptions.ServiceException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.rewards.GetJarActivity;
import com.getjar.sdk.rewards.GetJarReceiver;
import com.getjar.sdk.rewards.GetJarService;
import com.getjar.sdk.utilities.OverridesUtility;
import com.getjar.sdk.utilities.RewardUtility;
import com.getjar.sdk.utilities.StringUtility;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import org.json.JSONException;
import org.json.JSONObject;

public class CommManager
{
  public static final String AuthProviderFilterDataKey = "auth.provider_filter.data";
  public static final String AuthProviderFilterNameKey = "auth.provider_filter.name";
  private static ArrayList<Operation> _ActiveRequests;
  private static final String _CacheNamespace = "commResultCache";
  private static final int _ConnectionTimeout = 30000;
  private static final ExecutorService _ExecutorService;
  private static ConcurrentHashMap<String, CommContext> _IdentifierToCommContextMap;
  private static volatile CommManager _Instance = null;
  private static final int _MaxNumberOfSimultaneousRequests = 2;
  private static volatile Object _RequestPipelineLock = new Object();
  private static LinkedList<Operation> _RequestQueue;
  private static ArrayList<Operation> _RetryRequests;
  private static final int _SocketTimeout = 30000;
  private static Thread _WorkerThread;
  private static Object _WorkerThreadLock;
  private static volatile boolean _WorkerThreadStopping;
  private final ResultCachingManager _cachingManager;
  private final Context _context;
  
  static
  {
    _IdentifierToCommContextMap = new ConcurrentHashMap();
    _WorkerThread = null;
    _WorkerThreadLock = new Object();
    _WorkerThreadStopping = false;
    _ExecutorService = Executors.newFixedThreadPool(2);
    _RequestQueue = new LinkedList();
    _ActiveRequests = new ArrayList();
    _RetryRequests = new ArrayList();
  }
  
  private CommManager(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'androidContext' can not be NULL");
    }
    this._cachingManager = new ResultCachingManager(paramContext, "commResultCache");
    this._context = paramContext;
    OverridesUtility.initialize(paramContext);
    startWorker();
  }
  
  public static CommContext createContext(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'androidContext' cannot be NULL");
    }
    String str = ApplicationTokenDatabase.getInstance(paramContext).getApplicationToken();
    if (StringUtility.isNullOrEmpty(str)) {
      throw new IllegalStateException("Application Token is not set");
    }
    UUID.fromString(str);
    Logger.v(Area.COMM.value(), "%1$s Calling configureAppenders()", new Object[] { getLoggingPrefix() });
    try
    {
      Logger.getInstance().configureAppenders(paramContext);
      Logger.v(Area.COMM.value(), "%1$s Creating CommContext instance", new Object[] { getLoggingPrefix() });
      localCommContext = new CommContext(paramContext, null);
      _IdentifierToCommContextMap.put(localCommContext.getCommContextId(), localCommContext);
      Logger.i(Area.COMM.value(), "%1$s Created a NEW CommContext from %2$s.%3$s() [PID:%4$d] [AppToken:%5$s] [CommContext.Id:%6$s]", new Object[] { getLoggingPrefix(), Thread.currentThread().getStackTrace()[3].getClassName(), Thread.currentThread().getStackTrace()[3].getMethodName(), Integer.valueOf(Process.myPid()), str, localCommContext.getCommContextId() });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          CommContext localCommContext;
          AuthManager.initialize(paramContext);
          AuthManager.getInstance().ensureAuth();
          if (RewardUtility.checkPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkStateReceiver.getInstance().registerReceiver(paramContext);
          }
          return localCommContext;
        }
        catch (RuntimeException paramContext)
        {
          Logger.w(Area.COMM.value(), paramContext, "CommManager: createContext() failed", new Object[0]);
          throw paramContext;
        }
        catch (Exception paramContext)
        {
          Logger.w(Area.COMM.value(), paramContext, "CommManager: createContext() failed", new Object[0]);
          throw new AuthException(paramContext);
        }
        localException = localException;
        Logger.e(Area.COMM.value() | Area.CONFIG.value(), localException, "configureAppenders() failed", new Object[0]);
      }
    }
  }
  
  public static CommContext createContextForAuth(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'androidContext' can not be NULL");
    }
    String str = ApplicationTokenDatabase.getInstance(paramContext).getApplicationToken();
    if (StringUtility.isNullOrEmpty(str)) {
      throw new IllegalStateException("'applicationKey' can not be NULL or empty");
    }
    paramContext = new CommContext(paramContext, null);
    _IdentifierToCommContextMap.put(paramContext.getCommContextId(), paramContext);
    Logger.d(Area.COMM.value(), "%1$s Created a NEW CommContext for Auth from %2$s.%3$s() [PID:%4$d] [AppToken:%5$s] [CommContext.Id:%6$s]", new Object[] { getLoggingPrefix(), Thread.currentThread().getStackTrace()[3].getClassName(), Thread.currentThread().getStackTrace()[3].getMethodName(), Integer.valueOf(Process.myPid()), str, paramContext.getCommContextId() });
    return paramContext;
  }
  
  public static CommContext createContextForGetjarClient(Context paramContext, GetjarClient paramGetjarClient)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'androidContext' cannot be NULL");
    }
    if (paramGetjarClient == null) {
      throw new IllegalArgumentException("'getjarClient' cannot be null");
    }
    String str = ApplicationTokenDatabase.getInstance(paramContext).getApplicationToken();
    if (StringUtility.isNullOrEmpty(str)) {
      throw new IllegalStateException("The Application Token is not set");
    }
    paramContext = new CommContext(paramContext, paramGetjarClient);
    _IdentifierToCommContextMap.put(paramContext.getCommContextId(), paramContext);
    Logger.d(Area.COMM.value(), "%1$s Created a NEW CommContext for GetjarClient from %2$s.%3$s() [PID:%4$d] [AppToken:%5$s] [CommContext.Id:%6$s]", new Object[] { getLoggingPrefix(), Thread.currentThread().getStackTrace()[3].getClassName(), Thread.currentThread().getStackTrace()[3].getMethodName(), Integer.valueOf(Process.myPid()), str, paramContext.getCommContextId() });
    return paramContext;
  }
  
  private Operation enqueueOperationForRetry(Operation paramOperation)
  {
    if (paramOperation == null) {
      throw new IllegalArgumentException("'operation' can not be NULL");
    }
    if ((paramOperation.getState() != Operation.Status.RETRYING) && (paramOperation.getState() != Operation.Status.REDIRECTING)) {
      throw new IllegalStateException("enqueueOperationForRetry() can not be called on an operation that is not in the RETRYING or REDIRECTING state");
    }
    return enqueueRequest(paramOperation, true);
  }
  
  private Operation enqueueRequest(Operation paramOperation, boolean paramBoolean)
  {
    if (paramOperation == null) {
      throw new IllegalArgumentException("'newOperation' can not be NULL");
    }
    if ((paramOperation.getState() != Operation.Status.CREATED) && (paramOperation.getState() != Operation.Status.RETRYING) && (paramOperation.getState() != Operation.Status.REDIRECTING)) {
      throw new IllegalStateException("enqueueRequest() can not be called on an operation that is not in the CREATED, RETRYING, or REDIRECTING state");
    }
    int j = 0;
    int i = 0;
    Operation.Status localStatus = paramOperation.getState();
    Logger.v(Area.COMM.value(), "%1$s Adding [isRetry:%2$s]", new Object[] { getLoggingPrefix(paramOperation), Boolean.valueOf(paramBoolean) });
    Object localObject2 = _RequestPipelineLock;
    Object localObject1 = null;
    try
    {
      int k = _ActiveRequests.indexOf(paramOperation);
      if (k >= 0)
      {
        localObject1 = (Operation)_ActiveRequests.get(k);
        if (localObject1 == null) {
          break label277;
        }
        paramOperation = (Operation)localObject1;
        localObject1 = String.format(Locale.US, "%1$s Returning preexisting enqueued", new Object[] { getLoggingPrefix((Operation)localObject1) });
        if (!paramBoolean) {
          break label253;
        }
        Logger.w(Area.COMM.value(), (String)localObject1, new Object[0]);
      }
      for (;;)
      {
        if (i != 0)
        {
          Logger.v(Area.COMM.value(), "%1$s kicking worker thread", new Object[] { getLoggingPrefix(paramOperation) });
          _RequestPipelineLock.notify();
        }
        return paramOperation;
        k = _RequestQueue.indexOf(paramOperation);
        if (k < 0) {
          break;
        }
        localObject1 = (Operation)_RequestQueue.get(k);
        break;
        label253:
        Logger.v(Area.COMM.value(), (String)localObject1, new Object[0]);
      }
      localObject1 = null;
    }
    finally {}
    label277:
    if (!paramOperation.isDoNotCache()) {
      localObject1 = this._cachingManager.getRequestResult(paramOperation);
    }
    if (localObject1 != null)
    {
      paramOperation.setResult((Result)localObject1);
      paramOperation.setState(Operation.Status.COMPLETED);
      localObject1 = String.format(Locale.US, "%1$s Returning cached results", new Object[] { getLoggingPrefix(paramOperation) });
      if (paramBoolean)
      {
        Logger.w(Area.COMM.value(), (String)localObject1, new Object[0]);
        i = j;
      }
      else
      {
        Logger.v(Area.COMM.value(), (String)localObject1, new Object[0]);
        i = j;
      }
    }
    else
    {
      paramOperation.setFuture(new FutureTask(new RequestCallable(paramOperation, null)));
      if (paramBoolean)
      {
        _RetryRequests.add(paramOperation);
        paramOperation.setState(localStatus);
        Logger.v(Area.COMM.value(), "%1$s Returning new Request, added to retry pool", new Object[] { getLoggingPrefix(paramOperation) });
        break label492;
      }
      _RequestQueue.add(paramOperation);
      paramOperation.setState(Operation.Status.WAITING);
      Logger.v(Area.COMM.value(), "%1$s Returning new Request, added to priority queue", new Object[] { getLoggingPrefix(paramOperation) });
      break label492;
    }
    for (;;)
    {
      break;
      label492:
      i = 1;
    }
  }
  
  public static List<GetjarClient> getAllRegisteredGetjarClients()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = _IdentifierToCommContextMap.values().iterator();
    while (localIterator.hasNext())
    {
      CommContext localCommContext = (CommContext)localIterator.next();
      if (localCommContext.getGetjarClient() != null) {
        localArrayList.add(localCommContext.getGetjarClient());
      }
    }
    return localArrayList;
  }
  
  public static CommManager getInstance()
  {
    if (_Instance == null) {
      throw new IllegalStateException("CommManager.initialize() must be called first");
    }
    return _Instance;
  }
  
  private static final String getLoggingPrefix()
  {
    String str2 = "";
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    String str1 = str2;
    if (arrayOfStackTraceElement != null)
    {
      str1 = str2;
      if (arrayOfStackTraceElement.length >= 3) {
        str1 = arrayOfStackTraceElement[3].getMethodName();
      }
    }
    return String.format(Locale.US, "CommManager: %1$s() [thread:%2$d]", new Object[] { str1, Long.valueOf(Thread.currentThread().getId()) });
  }
  
  private static final String getLoggingPrefix(Operation paramOperation)
  {
    String str2 = "";
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    String str1 = str2;
    if (arrayOfStackTraceElement != null)
    {
      str1 = str2;
      if (arrayOfStackTraceElement.length >= 3) {
        str1 = arrayOfStackTraceElement[3].getMethodName();
      }
    }
    str2 = "";
    if (paramOperation != null) {
      str2 = String.format(Locale.US, " [request:%1$d]", new Object[] { Integer.valueOf(paramOperation.getId()) });
    }
    return String.format(Locale.US, "CommManager: %1$s() [thread:%2$d]%3$s", new Object[] { str1, Long.valueOf(Thread.currentThread().getId()), str2 });
  }
  
  private long getSleepTime()
  {
    long l1 = Long.MAX_VALUE;
    long l3 = System.currentTimeMillis();
    Iterator localIterator = _RetryRequests.iterator();
    while (localIterator.hasNext())
    {
      l2 = ((Operation)localIterator.next()).getRetryAfterTimestamp() - l3;
      if (l2 < l1) {
        l1 = l2;
      }
    }
    long l2 = l1;
    if (l1 < 10L) {
      l2 = 10L;
    }
    if (l2 == Long.MAX_VALUE)
    {
      Logger.v(Area.COMM.value(), "%1$s returning a sleep time of MAX_VALUE", new Object[] { getLoggingPrefix() });
      return l2;
    }
    Logger.v(Area.COMM.value(), "%1$s returning a sleep time of %2$d milliseconds", new Object[] { getLoggingPrefix(), Long.valueOf(l2) });
    return l2;
  }
  
  public static void initialize(Context paramContext)
  {
    try
    {
      if (_Instance == null) {
        _Instance = new CommManager(paramContext);
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  private Result processesRequest(Operation paramOperation, int paramInt)
    throws Exception
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 97	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 331
    //   11: invokespecial 102	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: invokestatic 497	java/lang/System:currentTimeMillis	()J
    //   18: lstore 5
    //   20: aload_1
    //   21: invokevirtual 525	com/getjar/sdk/comm/Operation:getRequest	()Lcom/getjar/sdk/comm/Request;
    //   24: invokevirtual 531	com/getjar/sdk/comm/Request:getUriForRequest	()Ljava/net/URI;
    //   27: astore 15
    //   29: aload_1
    //   30: invokevirtual 337	com/getjar/sdk/comm/Operation:getState	()Lcom/getjar/sdk/comm/Operation$Status;
    //   33: getstatic 534	com/getjar/sdk/comm/Operation$Status:CANCELLED	Lcom/getjar/sdk/comm/Operation$Status;
    //   36: if_acmpne +31 -> 67
    //   39: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   42: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   45: ldc_w 536
    //   48: iconst_1
    //   49: anewarray 4	java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: aload_1
    //   55: invokestatic 146	com/getjar/sdk/comm/CommManager:getLoggingPrefix	(Lcom/getjar/sdk/comm/Operation;)Ljava/lang/String;
    //   58: aastore
    //   59: invokestatic 390	com/getjar/sdk/logging/Logger:w	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   62: aload_1
    //   63: invokevirtual 540	com/getjar/sdk/comm/Operation:getResult	()Lcom/getjar/sdk/comm/Result;
    //   66: areturn
    //   67: aload_1
    //   68: invokevirtual 337	com/getjar/sdk/comm/Operation:getState	()Lcom/getjar/sdk/comm/Operation$Status;
    //   71: getstatic 543	com/getjar/sdk/comm/Operation$Status:RUNNING	Lcom/getjar/sdk/comm/Operation$Status;
    //   74: if_acmpeq +44 -> 118
    //   77: new 186	java/lang/IllegalStateException
    //   80: dup
    //   81: getstatic 380	java/util/Locale:US	Ljava/util/Locale;
    //   84: ldc_w 545
    //   87: iconst_1
    //   88: anewarray 4	java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: aload_1
    //   94: invokevirtual 337	com/getjar/sdk/comm/Operation:getState	()Lcom/getjar/sdk/comm/Operation$Status;
    //   97: invokevirtual 548	com/getjar/sdk/comm/Operation$Status:name	()Ljava/lang/String;
    //   100: aastore
    //   101: invokestatic 388	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   104: invokespecial 189	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   107: athrow
    //   108: astore_1
    //   109: new 550	com/getjar/sdk/exceptions/CommunicationException
    //   112: dup
    //   113: aload_1
    //   114: invokespecial 551	com/getjar/sdk/exceptions/CommunicationException:<init>	(Ljava/lang/Throwable;)V
    //   117: athrow
    //   118: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   121: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   124: ldc_w 553
    //   127: iconst_2
    //   128: anewarray 4	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: aload_1
    //   134: invokestatic 146	com/getjar/sdk/comm/CommManager:getLoggingPrefix	(Lcom/getjar/sdk/comm/Operation;)Ljava/lang/String;
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: aload_1
    //   141: invokevirtual 488	com/getjar/sdk/comm/Operation:getId	()I
    //   144: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   147: aastore
    //   148: invokestatic 267	com/getjar/sdk/logging/Logger:i	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   151: sipush 418
    //   154: istore_3
    //   155: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   158: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   161: ldc_w 555
    //   164: iconst_2
    //   165: anewarray 4	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: aload_1
    //   171: invokestatic 146	com/getjar/sdk/comm/CommManager:getLoggingPrefix	(Lcom/getjar/sdk/comm/Operation;)Ljava/lang/String;
    //   174: aastore
    //   175: dup
    //   176: iconst_1
    //   177: aload 15
    //   179: aastore
    //   180: invokestatic 319	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   183: aload_0
    //   184: getfield 111	com/getjar/sdk/comm/CommManager:_context	Landroid/content/Context;
    //   187: aload_1
    //   188: invokevirtual 559	com/getjar/sdk/comm/Operation:getCommContext	()Lcom/getjar/sdk/comm/CommContext;
    //   191: invokevirtual 562	com/getjar/sdk/comm/CommContext:getSdkUserAgent	()Ljava/lang/String;
    //   194: sipush 30000
    //   197: sipush 30000
    //   200: invokestatic 568	com/getjar/sdk/comm/GetJarHttpClient:newInstance	(Landroid/content/Context;Ljava/lang/String;II)Lcom/getjar/sdk/comm/GetJarHttpClient;
    //   203: astore 16
    //   205: getstatic 574	com/getjar/sdk/comm/Request$HttpMethod:POST	Lcom/getjar/sdk/comm/Request$HttpMethod;
    //   208: aload_1
    //   209: invokevirtual 525	com/getjar/sdk/comm/Operation:getRequest	()Lcom/getjar/sdk/comm/Request;
    //   212: invokevirtual 578	com/getjar/sdk/comm/Request:getHttpMethod	()Lcom/getjar/sdk/comm/Request$HttpMethod;
    //   215: invokevirtual 581	com/getjar/sdk/comm/Request$HttpMethod:equals	(Ljava/lang/Object;)Z
    //   218: ifeq +776 -> 994
    //   221: new 583	org/apache/http/client/methods/HttpPost
    //   224: dup
    //   225: aload 15
    //   227: invokespecial 586	org/apache/http/client/methods/HttpPost:<init>	(Ljava/net/URI;)V
    //   230: astore 11
    //   232: aload_1
    //   233: invokevirtual 525	com/getjar/sdk/comm/Operation:getRequest	()Lcom/getjar/sdk/comm/Request;
    //   236: invokevirtual 590	com/getjar/sdk/comm/Request:getPostData	()Ljava/util/Map;
    //   239: ifnull +1872 -> 2111
    //   242: aload_1
    //   243: invokevirtual 525	com/getjar/sdk/comm/Operation:getRequest	()Lcom/getjar/sdk/comm/Request;
    //   246: invokevirtual 590	com/getjar/sdk/comm/Request:getPostData	()Ljava/util/Map;
    //   249: invokeinterface 595 1 0
    //   254: ifle +1857 -> 2111
    //   257: aload_1
    //   258: invokevirtual 525	com/getjar/sdk/comm/Operation:getRequest	()Lcom/getjar/sdk/comm/Request;
    //   261: invokevirtual 590	com/getjar/sdk/comm/Request:getPostData	()Ljava/util/Map;
    //   264: invokestatic 601	com/getjar/sdk/comm/RequestUtilities:getPostDataBlob	(Ljava/util/Map;)Ljava/lang/String;
    //   267: astore 14
    //   269: aload 14
    //   271: invokestatic 184	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   274: ifne +235 -> 509
    //   277: aload 14
    //   279: ldc_w 603
    //   282: invokevirtual 607	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   285: astore 17
    //   287: aload 11
    //   289: checkcast 583	org/apache/http/client/methods/HttpPost
    //   292: ldc_w 609
    //   295: ldc_w 611
    //   298: invokevirtual 615	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: aload 11
    //   303: checkcast 583	org/apache/http/client/methods/HttpPost
    //   306: ldc_w 617
    //   309: ldc_w 619
    //   312: invokevirtual 615	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: iconst_0
    //   316: istore 9
    //   318: aload_1
    //   319: invokevirtual 559	com/getjar/sdk/comm/Operation:getCommContext	()Lcom/getjar/sdk/comm/CommContext;
    //   322: iconst_0
    //   323: invokestatic 624	com/getjar/sdk/config/GetJarConfig:getInstance	(Lcom/getjar/sdk/comm/CommContext;Z)Lcom/getjar/sdk/config/GetJarConfig;
    //   326: ldc_w 626
    //   329: getstatic 632	com/getjar/sdk/config/SettingsManager$Scope:CLIENT	Lcom/getjar/sdk/config/SettingsManager$Scope;
    //   332: invokevirtual 636	com/getjar/sdk/config/GetJarConfig:getDirectiveValue	(Ljava/lang/String;Lcom/getjar/sdk/config/SettingsManager$Scope;)Ljava/lang/String;
    //   335: invokestatic 639	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   338: istore 10
    //   340: iload 10
    //   342: istore 9
    //   344: sipush 256
    //   347: istore_2
    //   348: aload_1
    //   349: invokevirtual 559	com/getjar/sdk/comm/Operation:getCommContext	()Lcom/getjar/sdk/comm/CommContext;
    //   352: iconst_0
    //   353: invokestatic 624	com/getjar/sdk/config/GetJarConfig:getInstance	(Lcom/getjar/sdk/comm/CommContext;Z)Lcom/getjar/sdk/config/GetJarConfig;
    //   356: ldc_w 641
    //   359: getstatic 632	com/getjar/sdk/config/SettingsManager$Scope:CLIENT	Lcom/getjar/sdk/config/SettingsManager$Scope;
    //   362: invokevirtual 636	com/getjar/sdk/config/GetJarConfig:getDirectiveValue	(Ljava/lang/String;Lcom/getjar/sdk/config/SettingsManager$Scope;)Ljava/lang/String;
    //   365: invokestatic 645	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   368: istore 4
    //   370: iload 4
    //   372: istore_2
    //   373: iload 9
    //   375: ifeq +562 -> 937
    //   378: aload 17
    //   380: arraylength
    //   381: iload_2
    //   382: if_icmple +555 -> 937
    //   385: aload 11
    //   387: checkcast 583	org/apache/http/client/methods/HttpPost
    //   390: ldc_w 647
    //   393: ldc_w 649
    //   396: invokevirtual 615	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   399: new 651	java/io/ByteArrayOutputStream
    //   402: dup
    //   403: invokespecial 652	java/io/ByteArrayOutputStream:<init>	()V
    //   406: astore 18
    //   408: aconst_null
    //   409: astore 12
    //   411: new 654	java/util/zip/GZIPOutputStream
    //   414: dup
    //   415: aload 18
    //   417: invokespecial 657	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   420: astore 13
    //   422: aload 13
    //   424: aload 17
    //   426: invokevirtual 661	java/util/zip/GZIPOutputStream:write	([B)V
    //   429: aload 13
    //   431: ifnull +8 -> 439
    //   434: aload 13
    //   436: invokevirtual 664	java/util/zip/GZIPOutputStream:close	()V
    //   439: aload 18
    //   441: invokevirtual 668	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   444: astore 12
    //   446: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   449: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   452: ldc_w 670
    //   455: iconst_4
    //   456: anewarray 4	java/lang/Object
    //   459: dup
    //   460: iconst_0
    //   461: aload_1
    //   462: invokestatic 146	com/getjar/sdk/comm/CommManager:getLoggingPrefix	(Lcom/getjar/sdk/comm/Operation;)Ljava/lang/String;
    //   465: aastore
    //   466: dup
    //   467: iconst_1
    //   468: aload 17
    //   470: arraylength
    //   471: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   474: aastore
    //   475: dup
    //   476: iconst_2
    //   477: aload 12
    //   479: arraylength
    //   480: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   483: aastore
    //   484: dup
    //   485: iconst_3
    //   486: aload 14
    //   488: aastore
    //   489: invokestatic 319	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   492: aload 11
    //   494: checkcast 583	org/apache/http/client/methods/HttpPost
    //   497: new 672	org/apache/http/entity/ByteArrayEntity
    //   500: dup
    //   501: aload 12
    //   503: invokespecial 674	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   506: invokevirtual 678	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   509: aload 11
    //   511: ldc_w 680
    //   514: ldc_w 649
    //   517: invokevirtual 683	org/apache/http/client/methods/HttpRequestBase:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   520: aload 11
    //   522: ldc_w 685
    //   525: ldc_w 687
    //   528: invokevirtual 683	org/apache/http/client/methods/HttpRequestBase:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   531: getstatic 692	com/getjar/sdk/comm/ExternalRequestProxy:REQUEST_TYPE	Ljava/lang/String;
    //   534: aload_1
    //   535: invokevirtual 525	com/getjar/sdk/comm/Operation:getRequest	()Lcom/getjar/sdk/comm/Request;
    //   538: invokevirtual 695	com/getjar/sdk/comm/Request:getRequestType	()Ljava/lang/String;
    //   541: invokevirtual 696	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   544: ifeq +464 -> 1008
    //   547: aload 11
    //   549: ldc_w 698
    //   552: aload_1
    //   553: invokevirtual 559	com/getjar/sdk/comm/Operation:getCommContext	()Lcom/getjar/sdk/comm/CommContext;
    //   556: invokevirtual 701	com/getjar/sdk/comm/CommContext:getWebKitUserAgent	()Ljava/lang/String;
    //   559: invokevirtual 683	org/apache/http/client/methods/HttpRequestBase:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   562: aload_1
    //   563: invokevirtual 525	com/getjar/sdk/comm/Operation:getRequest	()Lcom/getjar/sdk/comm/Request;
    //   566: invokevirtual 704	com/getjar/sdk/comm/Request:getRequestHeaders	()Ljava/util/Map;
    //   569: ifnull +493 -> 1062
    //   572: aload_1
    //   573: invokevirtual 525	com/getjar/sdk/comm/Operation:getRequest	()Lcom/getjar/sdk/comm/Request;
    //   576: invokevirtual 704	com/getjar/sdk/comm/Request:getRequestHeaders	()Ljava/util/Map;
    //   579: invokeinterface 708 1 0
    //   584: invokeinterface 711 1 0
    //   589: astore 12
    //   591: aload 12
    //   593: invokeinterface 457 1 0
    //   598: ifeq +464 -> 1062
    //   601: aload 12
    //   603: invokeinterface 460 1 0
    //   608: checkcast 384	java/lang/String
    //   611: astore 13
    //   613: aload_1
    //   614: invokevirtual 525	com/getjar/sdk/comm/Operation:getRequest	()Lcom/getjar/sdk/comm/Request;
    //   617: invokevirtual 704	com/getjar/sdk/comm/Request:getRequestHeaders	()Ljava/util/Map;
    //   620: aload 13
    //   622: invokeinterface 714 2 0
    //   627: checkcast 384	java/lang/String
    //   630: astore 14
    //   632: aload 13
    //   634: invokestatic 184	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   637: ifne -46 -> 591
    //   640: aload 14
    //   642: invokestatic 184	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   645: ifne -54 -> 591
    //   648: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   651: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   654: ldc_w 716
    //   657: iconst_3
    //   658: anewarray 4	java/lang/Object
    //   661: dup
    //   662: iconst_0
    //   663: aload_1
    //   664: invokestatic 146	com/getjar/sdk/comm/CommManager:getLoggingPrefix	(Lcom/getjar/sdk/comm/Operation;)Ljava/lang/String;
    //   667: aastore
    //   668: dup
    //   669: iconst_1
    //   670: aload 13
    //   672: aastore
    //   673: dup
    //   674: iconst_2
    //   675: aload 14
    //   677: aastore
    //   678: invokestatic 212	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   681: aload 11
    //   683: aload 13
    //   685: aload 14
    //   687: invokevirtual 683	org/apache/http/client/methods/HttpRequestBase:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   690: goto -99 -> 591
    //   693: astore 14
    //   695: aconst_null
    //   696: astore 11
    //   698: aload 11
    //   700: astore 13
    //   702: aload 11
    //   704: astore 12
    //   706: aload 16
    //   708: invokevirtual 720	com/getjar/sdk/comm/GetJarHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   711: invokeinterface 725 1 0
    //   716: aload 11
    //   718: astore 13
    //   720: aload 11
    //   722: astore 12
    //   724: aload 14
    //   726: athrow
    //   727: astore 11
    //   729: aload 13
    //   731: astore 12
    //   733: new 550	com/getjar/sdk/exceptions/CommunicationException
    //   736: dup
    //   737: aload 11
    //   739: invokespecial 551	com/getjar/sdk/exceptions/CommunicationException:<init>	(Ljava/lang/Throwable;)V
    //   742: athrow
    //   743: astore 11
    //   745: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   748: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   751: ldc_w 727
    //   754: iconst_1
    //   755: anewarray 4	java/lang/Object
    //   758: dup
    //   759: iconst_0
    //   760: aload_1
    //   761: invokestatic 146	com/getjar/sdk/comm/CommManager:getLoggingPrefix	(Lcom/getjar/sdk/comm/Operation;)Ljava/lang/String;
    //   764: aastore
    //   765: invokestatic 267	com/getjar/sdk/logging/Logger:i	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   768: invokestatic 497	java/lang/System:currentTimeMillis	()J
    //   771: lload 5
    //   773: lsub
    //   774: l2i
    //   775: istore_2
    //   776: aload 12
    //   778: ifnull +9 -> 787
    //   781: aload 12
    //   783: iload_2
    //   784: invokevirtual 733	com/getjar/sdk/comm/Result:setResponseTime	(I)V
    //   787: getstatic 380	java/util/Locale:US	Ljava/util/Locale;
    //   790: astore 12
    //   792: aload_1
    //   793: invokestatic 146	com/getjar/sdk/comm/CommManager:getLoggingPrefix	(Lcom/getjar/sdk/comm/Operation;)Ljava/lang/String;
    //   796: astore_1
    //   797: aload 15
    //   799: ifnull +1334 -> 2133
    //   802: aload 12
    //   804: ldc_w 735
    //   807: iconst_3
    //   808: anewarray 4	java/lang/Object
    //   811: dup
    //   812: iconst_0
    //   813: aload_1
    //   814: aastore
    //   815: dup
    //   816: iconst_1
    //   817: iload_2
    //   818: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   821: aastore
    //   822: dup
    //   823: iconst_2
    //   824: aload 15
    //   826: aastore
    //   827: invokestatic 388	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   830: astore_1
    //   831: iload_2
    //   832: sipush 1000
    //   835: if_icmple +1219 -> 2054
    //   838: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   841: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   844: aload_1
    //   845: iconst_0
    //   846: anewarray 4	java/lang/Object
    //   849: invokestatic 390	com/getjar/sdk/logging/Logger:w	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   852: aload 11
    //   854: athrow
    //   855: astore_1
    //   856: goto -747 -> 109
    //   859: astore 12
    //   861: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   864: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   867: ldc_w 737
    //   870: iconst_0
    //   871: anewarray 4	java/lang/Object
    //   874: invokestatic 390	com/getjar/sdk/logging/Logger:w	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   877: goto -533 -> 344
    //   880: astore 12
    //   882: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   885: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   888: ldc_w 739
    //   891: iconst_0
    //   892: anewarray 4	java/lang/Object
    //   895: invokestatic 390	com/getjar/sdk/logging/Logger:w	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   898: goto -525 -> 373
    //   901: astore 12
    //   903: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   906: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   909: ldc_w 739
    //   912: iconst_0
    //   913: anewarray 4	java/lang/Object
    //   916: invokestatic 390	com/getjar/sdk/logging/Logger:w	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   919: goto -546 -> 373
    //   922: astore 11
    //   924: aload 12
    //   926: ifnull +8 -> 934
    //   929: aload 12
    //   931: invokevirtual 664	java/util/zip/GZIPOutputStream:close	()V
    //   934: aload 11
    //   936: athrow
    //   937: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   940: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   943: ldc_w 741
    //   946: iconst_3
    //   947: anewarray 4	java/lang/Object
    //   950: dup
    //   951: iconst_0
    //   952: aload_1
    //   953: invokestatic 146	com/getjar/sdk/comm/CommManager:getLoggingPrefix	(Lcom/getjar/sdk/comm/Operation;)Ljava/lang/String;
    //   956: aastore
    //   957: dup
    //   958: iconst_1
    //   959: aload 17
    //   961: arraylength
    //   962: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   965: aastore
    //   966: dup
    //   967: iconst_2
    //   968: aload 14
    //   970: aastore
    //   971: invokestatic 319	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   974: aload 11
    //   976: checkcast 583	org/apache/http/client/methods/HttpPost
    //   979: new 743	org/apache/http/entity/StringEntity
    //   982: dup
    //   983: aload 14
    //   985: invokespecial 744	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;)V
    //   988: invokevirtual 678	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   991: goto -482 -> 509
    //   994: new 746	org/apache/http/client/methods/HttpGet
    //   997: dup
    //   998: aload 15
    //   1000: invokespecial 747	org/apache/http/client/methods/HttpGet:<init>	(Ljava/net/URI;)V
    //   1003: astore 11
    //   1005: goto -496 -> 509
    //   1008: aload 11
    //   1010: ldc_w 698
    //   1013: aload_1
    //   1014: invokevirtual 559	com/getjar/sdk/comm/Operation:getCommContext	()Lcom/getjar/sdk/comm/CommContext;
    //   1017: invokevirtual 562	com/getjar/sdk/comm/CommContext:getSdkUserAgent	()Ljava/lang/String;
    //   1020: invokevirtual 683	org/apache/http/client/methods/HttpRequestBase:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   1023: aload_1
    //   1024: invokevirtual 559	com/getjar/sdk/comm/Operation:getCommContext	()Lcom/getjar/sdk/comm/CommContext;
    //   1027: invokevirtual 751	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
    //   1030: invokestatic 270	com/getjar/sdk/comm/auth/AuthManager:initialize	(Landroid/content/Context;)V
    //   1033: invokestatic 273	com/getjar/sdk/comm/auth/AuthManager:getInstance	()Lcom/getjar/sdk/comm/auth/AuthManager;
    //   1036: invokevirtual 754	com/getjar/sdk/comm/auth/AuthManager:getAuthToken	()Ljava/lang/String;
    //   1039: astore 12
    //   1041: aload 12
    //   1043: invokestatic 184	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   1046: ifne -484 -> 562
    //   1049: aload 11
    //   1051: ldc_w 756
    //   1054: aload 12
    //   1056: invokevirtual 683	org/apache/http/client/methods/HttpRequestBase:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   1059: goto -497 -> 562
    //   1062: aload_1
    //   1063: invokevirtual 400	com/getjar/sdk/comm/Operation:isDoNotCache	()Z
    //   1066: ifne +59 -> 1125
    //   1069: aload_0
    //   1070: getfield 109	com/getjar/sdk/comm/CommManager:_cachingManager	Lcom/getjar/sdk/comm/ResultCachingManager;
    //   1073: aload_1
    //   1074: invokevirtual 759	com/getjar/sdk/comm/ResultCachingManager:getETagFromCache	(Lcom/getjar/sdk/comm/Operation;)Ljava/lang/String;
    //   1077: astore 12
    //   1079: aload 12
    //   1081: invokestatic 184	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   1084: ifne +41 -> 1125
    //   1087: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   1090: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   1093: ldc_w 761
    //   1096: iconst_2
    //   1097: anewarray 4	java/lang/Object
    //   1100: dup
    //   1101: iconst_0
    //   1102: aload_1
    //   1103: invokestatic 146	com/getjar/sdk/comm/CommManager:getLoggingPrefix	(Lcom/getjar/sdk/comm/Operation;)Ljava/lang/String;
    //   1106: aastore
    //   1107: dup
    //   1108: iconst_1
    //   1109: aload 12
    //   1111: aastore
    //   1112: invokestatic 212	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   1115: aload 11
    //   1117: ldc_w 763
    //   1120: aload 12
    //   1122: invokevirtual 683	org/apache/http/client/methods/HttpRequestBase:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   1125: new 765	org/apache/http/HttpHost
    //   1128: dup
    //   1129: aload 11
    //   1131: invokevirtual 768	org/apache/http/client/methods/HttpRequestBase:getURI	()Ljava/net/URI;
    //   1134: invokevirtual 773	java/net/URI:getHost	()Ljava/lang/String;
    //   1137: aload 11
    //   1139: invokevirtual 768	org/apache/http/client/methods/HttpRequestBase:getURI	()Ljava/net/URI;
    //   1142: invokevirtual 776	java/net/URI:getPort	()I
    //   1145: aload 11
    //   1147: invokevirtual 768	org/apache/http/client/methods/HttpRequestBase:getURI	()Ljava/net/URI;
    //   1150: invokevirtual 779	java/net/URI:getScheme	()Ljava/lang/String;
    //   1153: invokespecial 782	org/apache/http/HttpHost:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   1156: astore 12
    //   1158: aload 16
    //   1160: invokevirtual 786	com/getjar/sdk/comm/GetJarHttpClient:getRoutePlanner	()Lorg/apache/http/conn/routing/HttpRoutePlanner;
    //   1163: aload 12
    //   1165: aload 11
    //   1167: aconst_null
    //   1168: invokeinterface 792 4 0
    //   1173: astore 12
    //   1175: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   1178: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   1181: ldc_w 794
    //   1184: bipush 6
    //   1186: anewarray 4	java/lang/Object
    //   1189: dup
    //   1190: iconst_0
    //   1191: aload_1
    //   1192: invokestatic 146	com/getjar/sdk/comm/CommManager:getLoggingPrefix	(Lcom/getjar/sdk/comm/Operation;)Ljava/lang/String;
    //   1195: aastore
    //   1196: dup
    //   1197: iconst_1
    //   1198: aload 11
    //   1200: invokevirtual 768	org/apache/http/client/methods/HttpRequestBase:getURI	()Ljava/net/URI;
    //   1203: invokevirtual 773	java/net/URI:getHost	()Ljava/lang/String;
    //   1206: invokestatic 800	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   1209: invokevirtual 803	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1212: aastore
    //   1213: dup
    //   1214: iconst_2
    //   1215: aload 12
    //   1217: invokevirtual 809	org/apache/http/conn/routing/HttpRoute:getProxyHost	()Lorg/apache/http/HttpHost;
    //   1220: aastore
    //   1221: dup
    //   1222: iconst_3
    //   1223: aload 12
    //   1225: invokevirtual 812	org/apache/http/conn/routing/HttpRoute:getTargetHost	()Lorg/apache/http/HttpHost;
    //   1228: aastore
    //   1229: dup
    //   1230: iconst_4
    //   1231: aload 12
    //   1233: invokevirtual 815	org/apache/http/conn/routing/HttpRoute:isSecure	()Z
    //   1236: invokestatic 366	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1239: aastore
    //   1240: dup
    //   1241: iconst_5
    //   1242: aload 12
    //   1244: invokevirtual 818	org/apache/http/conn/routing/HttpRoute:isTunnelled	()Z
    //   1247: invokestatic 366	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1250: aastore
    //   1251: invokestatic 212	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   1254: aload 11
    //   1256: aload_1
    //   1257: invokevirtual 525	com/getjar/sdk/comm/Operation:getRequest	()Lcom/getjar/sdk/comm/Request;
    //   1260: invokevirtual 819	com/getjar/sdk/comm/Request:getId	()I
    //   1263: invokestatic 823	com/getjar/sdk/comm/RequestUtilities:debugDumpRequestProperties	(Lorg/apache/http/client/methods/HttpRequestBase;I)V
    //   1266: aload 16
    //   1268: aload 11
    //   1270: invokevirtual 827	com/getjar/sdk/comm/GetJarHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   1273: astore 14
    //   1275: aload 14
    //   1277: ifnonnull +64 -> 1341
    //   1280: new 186	java/lang/IllegalStateException
    //   1283: dup
    //   1284: getstatic 380	java/util/Locale:US	Ljava/util/Locale;
    //   1287: ldc_w 829
    //   1290: iconst_1
    //   1291: anewarray 4	java/lang/Object
    //   1294: dup
    //   1295: iconst_0
    //   1296: aload 15
    //   1298: aastore
    //   1299: invokestatic 388	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1302: invokespecial 189	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   1305: athrow
    //   1306: astore 12
    //   1308: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   1311: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   1314: aload 12
    //   1316: ldc_w 831
    //   1319: iconst_2
    //   1320: anewarray 4	java/lang/Object
    //   1323: dup
    //   1324: iconst_0
    //   1325: aload_1
    //   1326: invokestatic 146	com/getjar/sdk/comm/CommManager:getLoggingPrefix	(Lcom/getjar/sdk/comm/Operation;)Ljava/lang/String;
    //   1329: aastore
    //   1330: dup
    //   1331: iconst_1
    //   1332: aload 15
    //   1334: aastore
    //   1335: invokestatic 301	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1338: goto -84 -> 1254
    //   1341: iload_3
    //   1342: istore_2
    //   1343: aload 14
    //   1345: invokeinterface 837 1 0
    //   1350: ifnull +16 -> 1366
    //   1353: aload 14
    //   1355: invokeinterface 837 1 0
    //   1360: invokeinterface 842 1 0
    //   1365: istore_2
    //   1366: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   1369: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   1372: ldc_w 844
    //   1375: iconst_2
    //   1376: anewarray 4	java/lang/Object
    //   1379: dup
    //   1380: iconst_0
    //   1381: aload_1
    //   1382: invokestatic 146	com/getjar/sdk/comm/CommManager:getLoggingPrefix	(Lcom/getjar/sdk/comm/Operation;)Ljava/lang/String;
    //   1385: aastore
    //   1386: dup
    //   1387: iconst_1
    //   1388: iload_2
    //   1389: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1392: aastore
    //   1393: invokestatic 319	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   1396: aconst_null
    //   1397: astore 12
    //   1399: aload 14
    //   1401: invokeinterface 848 1 0
    //   1406: astore 13
    //   1408: aload 13
    //   1410: ifnull +185 -> 1595
    //   1413: aload 13
    //   1415: invokeinterface 854 1 0
    //   1420: astore 12
    //   1422: aload 14
    //   1424: ldc_w 647
    //   1427: invokeinterface 858 2 0
    //   1432: astore 13
    //   1434: aload 13
    //   1436: ifnull +120 -> 1556
    //   1439: aload 13
    //   1441: invokeinterface 863 1 0
    //   1446: invokestatic 184	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   1449: ifne +107 -> 1556
    //   1452: aload 13
    //   1454: invokeinterface 863 1 0
    //   1459: ldc_w 649
    //   1462: invokevirtual 866	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1465: ifeq +91 -> 1556
    //   1468: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   1471: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   1474: ldc_w 868
    //   1477: iconst_0
    //   1478: anewarray 4	java/lang/Object
    //   1481: invokestatic 267	com/getjar/sdk/logging/Logger:i	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   1484: new 870	java/util/zip/GZIPInputStream
    //   1487: dup
    //   1488: aload 12
    //   1490: invokespecial 873	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   1493: astore 12
    //   1495: new 651	java/io/ByteArrayOutputStream
    //   1498: dup
    //   1499: invokespecial 652	java/io/ByteArrayOutputStream:<init>	()V
    //   1502: astore 13
    //   1504: sipush 1024
    //   1507: newarray <illegal type>
    //   1509: astore 17
    //   1511: aload 12
    //   1513: aload 17
    //   1515: invokevirtual 879	java/io/InputStream:read	([B)I
    //   1518: istore_3
    //   1519: iload_3
    //   1520: iconst_m1
    //   1521: if_icmpeq +54 -> 1575
    //   1524: aload 13
    //   1526: aload 17
    //   1528: iconst_0
    //   1529: iload_3
    //   1530: invokevirtual 882	java/io/ByteArrayOutputStream:write	([BII)V
    //   1533: goto -22 -> 1511
    //   1536: astore 13
    //   1538: aload 11
    //   1540: invokevirtual 885	org/apache/http/client/methods/HttpRequestBase:abort	()V
    //   1543: aload 13
    //   1545: athrow
    //   1546: astore 11
    //   1548: aload 12
    //   1550: invokevirtual 886	java/io/InputStream:close	()V
    //   1553: aload 11
    //   1555: athrow
    //   1556: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   1559: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   1562: ldc_w 888
    //   1565: iconst_0
    //   1566: anewarray 4	java/lang/Object
    //   1569: invokestatic 267	com/getjar/sdk/logging/Logger:i	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   1572: goto -77 -> 1495
    //   1575: aload 13
    //   1577: invokevirtual 668	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1580: astore 13
    //   1582: aload 13
    //   1584: astore 11
    //   1586: aload 12
    //   1588: invokevirtual 886	java/io/InputStream:close	()V
    //   1591: aload 11
    //   1593: astore 12
    //   1595: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   1598: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   1601: lstore 7
    //   1603: aload_1
    //   1604: invokestatic 146	com/getjar/sdk/comm/CommManager:getLoggingPrefix	(Lcom/getjar/sdk/comm/Operation;)Ljava/lang/String;
    //   1607: astore 11
    //   1609: aload 12
    //   1611: ifnonnull +143 -> 1754
    //   1614: iconst_0
    //   1615: istore_3
    //   1616: lload 7
    //   1618: ldc_w 890
    //   1621: iconst_2
    //   1622: anewarray 4	java/lang/Object
    //   1625: dup
    //   1626: iconst_0
    //   1627: aload 11
    //   1629: aastore
    //   1630: dup
    //   1631: iconst_1
    //   1632: iload_3
    //   1633: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1636: aastore
    //   1637: invokestatic 319	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   1640: new 892	java/util/HashMap
    //   1643: dup
    //   1644: invokespecial 893	java/util/HashMap:<init>	()V
    //   1647: astore 11
    //   1649: aload 14
    //   1651: invokeinterface 897 1 0
    //   1656: astore 13
    //   1658: aload 13
    //   1660: arraylength
    //   1661: istore 4
    //   1663: iconst_0
    //   1664: istore_3
    //   1665: iload_3
    //   1666: iload 4
    //   1668: if_icmpge +93 -> 1761
    //   1671: aload 13
    //   1673: iload_3
    //   1674: aaload
    //   1675: astore 14
    //   1677: aload 11
    //   1679: aload 14
    //   1681: invokeinterface 900 1 0
    //   1686: invokeinterface 903 2 0
    //   1691: ifne +26 -> 1717
    //   1694: aload 11
    //   1696: aload 14
    //   1698: invokeinterface 900 1 0
    //   1703: new 86	java/util/ArrayList
    //   1706: dup
    //   1707: iconst_1
    //   1708: invokespecial 905	java/util/ArrayList:<init>	(I)V
    //   1711: invokeinterface 906 3 0
    //   1716: pop
    //   1717: aload 11
    //   1719: aload 14
    //   1721: invokeinterface 900 1 0
    //   1726: invokeinterface 714 2 0
    //   1731: checkcast 466	java/util/List
    //   1734: aload 14
    //   1736: invokeinterface 863 1 0
    //   1741: invokeinterface 467 2 0
    //   1746: pop
    //   1747: iload_3
    //   1748: iconst_1
    //   1749: iadd
    //   1750: istore_3
    //   1751: goto -86 -> 1665
    //   1754: aload 12
    //   1756: arraylength
    //   1757: istore_3
    //   1758: goto -142 -> 1616
    //   1761: new 729	com/getjar/sdk/comm/Result
    //   1764: dup
    //   1765: aload 12
    //   1767: aload 11
    //   1769: iload_2
    //   1770: aload_1
    //   1771: invokevirtual 488	com/getjar/sdk/comm/Operation:getId	()I
    //   1774: invokestatic 910	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1777: aload_1
    //   1778: invokevirtual 913	com/getjar/sdk/comm/Operation:getSuppressInternalCallbacks	()Z
    //   1781: invokespecial 916	com/getjar/sdk/comm/Result:<init>	([BLjava/util/Map;ILjava/lang/String;Z)V
    //   1784: astore 11
    //   1786: aload_1
    //   1787: aload 11
    //   1789: invokevirtual 407	com/getjar/sdk/comm/Operation:setResult	(Lcom/getjar/sdk/comm/Result;)V
    //   1792: getstatic 692	com/getjar/sdk/comm/ExternalRequestProxy:REQUEST_TYPE	Ljava/lang/String;
    //   1795: aload_1
    //   1796: invokevirtual 525	com/getjar/sdk/comm/Operation:getRequest	()Lcom/getjar/sdk/comm/Request;
    //   1799: invokevirtual 695	com/getjar/sdk/comm/Request:getRequestType	()Ljava/lang/String;
    //   1802: invokevirtual 696	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1805: ifne +73 -> 1878
    //   1808: aload 11
    //   1810: invokevirtual 919	com/getjar/sdk/comm/Result:isSuccessfulResponse	()Z
    //   1813: ifeq +65 -> 1878
    //   1816: aload 11
    //   1818: invokevirtual 922	com/getjar/sdk/comm/Result:getResponseBody	()Ljava/lang/String;
    //   1821: invokestatic 184	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   1824: ifne +54 -> 1878
    //   1827: aload 11
    //   1829: invokevirtual 926	com/getjar/sdk/comm/Result:getResponseJson	()Lorg/json/JSONObject;
    //   1832: ifnonnull +46 -> 1878
    //   1835: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   1838: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   1841: ldc_w 928
    //   1844: iconst_4
    //   1845: anewarray 4	java/lang/Object
    //   1848: dup
    //   1849: iconst_0
    //   1850: aload_1
    //   1851: invokestatic 146	com/getjar/sdk/comm/CommManager:getLoggingPrefix	(Lcom/getjar/sdk/comm/Operation;)Ljava/lang/String;
    //   1854: aastore
    //   1855: dup
    //   1856: iconst_1
    //   1857: aload 15
    //   1859: aastore
    //   1860: dup
    //   1861: iconst_2
    //   1862: iload_2
    //   1863: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1866: aastore
    //   1867: dup
    //   1868: iconst_3
    //   1869: aload 11
    //   1871: invokevirtual 922	com/getjar/sdk/comm/Result:getResponseBody	()Ljava/lang/String;
    //   1874: aastore
    //   1875: invokestatic 390	com/getjar/sdk/logging/Logger:w	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   1878: aload 11
    //   1880: astore 13
    //   1882: aload 11
    //   1884: astore 12
    //   1886: aload 16
    //   1888: invokevirtual 720	com/getjar/sdk/comm/GetJarHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   1891: invokeinterface 725 1 0
    //   1896: aload 11
    //   1898: astore 13
    //   1900: aload 11
    //   1902: astore 12
    //   1904: aload_1
    //   1905: invokevirtual 400	com/getjar/sdk/comm/Operation:isDoNotCache	()Z
    //   1908: ifne +19 -> 1927
    //   1911: aload 11
    //   1913: astore 13
    //   1915: aload 11
    //   1917: astore 12
    //   1919: aload_0
    //   1920: getfield 109	com/getjar/sdk/comm/CommManager:_cachingManager	Lcom/getjar/sdk/comm/ResultCachingManager;
    //   1923: aload_1
    //   1924: invokevirtual 931	com/getjar/sdk/comm/ResultCachingManager:addResultToCache	(Lcom/getjar/sdk/comm/Operation;)V
    //   1927: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   1930: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   1933: ldc_w 727
    //   1936: iconst_1
    //   1937: anewarray 4	java/lang/Object
    //   1940: dup
    //   1941: iconst_0
    //   1942: aload_1
    //   1943: invokestatic 146	com/getjar/sdk/comm/CommManager:getLoggingPrefix	(Lcom/getjar/sdk/comm/Operation;)Ljava/lang/String;
    //   1946: aastore
    //   1947: invokestatic 267	com/getjar/sdk/logging/Logger:i	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   1950: invokestatic 497	java/lang/System:currentTimeMillis	()J
    //   1953: lload 5
    //   1955: lsub
    //   1956: l2i
    //   1957: istore_2
    //   1958: aload 11
    //   1960: ifnull +9 -> 1969
    //   1963: aload 11
    //   1965: iload_2
    //   1966: invokevirtual 733	com/getjar/sdk/comm/Result:setResponseTime	(I)V
    //   1969: getstatic 380	java/util/Locale:US	Ljava/util/Locale;
    //   1972: astore 12
    //   1974: aload_1
    //   1975: invokestatic 146	com/getjar/sdk/comm/CommManager:getLoggingPrefix	(Lcom/getjar/sdk/comm/Operation;)Ljava/lang/String;
    //   1978: astore_1
    //   1979: aload 15
    //   1981: ifnull +144 -> 2125
    //   1984: aload 12
    //   1986: ldc_w 735
    //   1989: iconst_3
    //   1990: anewarray 4	java/lang/Object
    //   1993: dup
    //   1994: iconst_0
    //   1995: aload_1
    //   1996: aastore
    //   1997: dup
    //   1998: iconst_1
    //   1999: iload_2
    //   2000: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2003: aastore
    //   2004: dup
    //   2005: iconst_2
    //   2006: aload 15
    //   2008: aastore
    //   2009: invokestatic 388	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2012: astore_1
    //   2013: iload_2
    //   2014: sipush 1000
    //   2017: if_icmple +20 -> 2037
    //   2020: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   2023: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   2026: aload_1
    //   2027: iconst_0
    //   2028: anewarray 4	java/lang/Object
    //   2031: invokestatic 390	com/getjar/sdk/logging/Logger:w	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   2034: goto +88 -> 2122
    //   2037: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   2040: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   2043: aload_1
    //   2044: iconst_0
    //   2045: anewarray 4	java/lang/Object
    //   2048: invokestatic 319	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   2051: goto +71 -> 2122
    //   2054: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   2057: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   2060: aload_1
    //   2061: iconst_0
    //   2062: anewarray 4	java/lang/Object
    //   2065: invokestatic 319	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   2068: goto -1216 -> 852
    //   2071: astore 12
    //   2073: goto -1634 -> 439
    //   2076: astore 12
    //   2078: goto -1144 -> 934
    //   2081: astore 11
    //   2083: aconst_null
    //   2084: astore 12
    //   2086: goto -1341 -> 745
    //   2089: astore 11
    //   2091: aconst_null
    //   2092: astore 12
    //   2094: goto -1361 -> 733
    //   2097: astore 14
    //   2099: goto -1401 -> 698
    //   2102: astore 11
    //   2104: aload 13
    //   2106: astore 12
    //   2108: goto -1184 -> 924
    //   2111: goto -1602 -> 509
    //   2114: astore 14
    //   2116: aconst_null
    //   2117: astore 11
    //   2119: goto -1421 -> 698
    //   2122: aload 11
    //   2124: areturn
    //   2125: ldc_w 474
    //   2128: astore 15
    //   2130: goto -146 -> 1984
    //   2133: ldc_w 474
    //   2136: astore 15
    //   2138: goto -1336 -> 802
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2141	0	this	CommManager
    //   0	2141	1	paramOperation	Operation
    //   0	2141	2	paramInt	int
    //   154	1604	3	i	int
    //   368	1301	4	j	int
    //   18	1936	5	l1	long
    //   1601	16	7	l2	long
    //   316	58	9	k	int
    //   338	3	10	bool	boolean
    //   230	491	11	localHttpPost	org.apache.http.client.methods.HttpPost
    //   727	11	11	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   743	110	11	localObject1	Object
    //   922	53	11	localObject2	Object
    //   1003	536	11	localHttpGet	org.apache.http.client.methods.HttpGet
    //   1546	8	11	localObject3	Object
    //   1584	380	11	localObject4	Object
    //   2081	1	11	localObject5	Object
    //   2089	1	11	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   2102	1	11	localObject6	Object
    //   2117	6	11	localResult	Result
    //   409	394	12	localObject7	Object
    //   859	1	12	localConfigurationException1	com.getjar.sdk.exceptions.ConfigurationException
    //   880	1	12	localConfigurationException2	com.getjar.sdk.exceptions.ConfigurationException
    //   901	29	12	localNumberFormatException	NumberFormatException
    //   1039	204	12	localObject8	Object
    //   1306	9	12	localException	Exception
    //   1397	588	12	localObject9	Object
    //   2071	1	12	localIOException1	java.io.IOException
    //   2076	1	12	localIOException2	java.io.IOException
    //   2084	23	12	localObject10	Object
    //   420	1105	13	localObject11	Object
    //   1536	40	13	localRuntimeException	RuntimeException
    //   1580	525	13	localObject12	Object
    //   267	419	14	str1	String
    //   693	291	14	str2	String
    //   1273	462	14	localHttpResponse	org.apache.http.HttpResponse
    //   2097	1	14	localObject13	Object
    //   2114	1	14	localObject14	Object
    //   27	2110	15	localObject15	Object
    //   203	1684	16	localGetJarHttpClient	GetJarHttpClient
    //   285	1242	17	arrayOfByte	byte[]
    //   406	34	18	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   20	67	108	java/net/URISyntaxException
    //   67	108	108	java/net/URISyntaxException
    //   118	151	108	java/net/URISyntaxException
    //   205	232	693	finally
    //   509	562	693	finally
    //   562	591	693	finally
    //   591	690	693	finally
    //   994	1005	693	finally
    //   1008	1059	693	finally
    //   1062	1125	693	finally
    //   1125	1254	693	finally
    //   1254	1275	693	finally
    //   1280	1306	693	finally
    //   1308	1338	693	finally
    //   1343	1366	693	finally
    //   1366	1396	693	finally
    //   1399	1408	693	finally
    //   1413	1434	693	finally
    //   1439	1495	693	finally
    //   1548	1556	693	finally
    //   1556	1572	693	finally
    //   1586	1591	693	finally
    //   1595	1609	693	finally
    //   1616	1663	693	finally
    //   1677	1717	693	finally
    //   1717	1747	693	finally
    //   1754	1758	693	finally
    //   1761	1786	693	finally
    //   706	716	727	java/io/UnsupportedEncodingException
    //   724	727	727	java/io/UnsupportedEncodingException
    //   1886	1896	727	java/io/UnsupportedEncodingException
    //   1904	1911	727	java/io/UnsupportedEncodingException
    //   1919	1927	727	java/io/UnsupportedEncodingException
    //   706	716	743	finally
    //   724	727	743	finally
    //   733	743	743	finally
    //   1886	1896	743	finally
    //   1904	1911	743	finally
    //   1919	1927	743	finally
    //   745	776	855	java/net/URISyntaxException
    //   781	787	855	java/net/URISyntaxException
    //   787	797	855	java/net/URISyntaxException
    //   802	831	855	java/net/URISyntaxException
    //   838	852	855	java/net/URISyntaxException
    //   852	855	855	java/net/URISyntaxException
    //   1927	1958	855	java/net/URISyntaxException
    //   1963	1969	855	java/net/URISyntaxException
    //   1969	1979	855	java/net/URISyntaxException
    //   1984	2013	855	java/net/URISyntaxException
    //   2020	2034	855	java/net/URISyntaxException
    //   2037	2051	855	java/net/URISyntaxException
    //   2054	2068	855	java/net/URISyntaxException
    //   318	340	859	com/getjar/sdk/exceptions/ConfigurationException
    //   348	370	880	com/getjar/sdk/exceptions/ConfigurationException
    //   348	370	901	java/lang/NumberFormatException
    //   411	422	922	finally
    //   1125	1254	1306	java/lang/Exception
    //   1495	1511	1536	java/lang/RuntimeException
    //   1511	1519	1536	java/lang/RuntimeException
    //   1524	1533	1536	java/lang/RuntimeException
    //   1575	1582	1536	java/lang/RuntimeException
    //   1495	1511	1546	finally
    //   1511	1519	1546	finally
    //   1524	1533	1546	finally
    //   1538	1546	1546	finally
    //   1575	1582	1546	finally
    //   434	439	2071	java/io/IOException
    //   929	934	2076	java/io/IOException
    //   155	205	2081	finally
    //   155	205	2089	java/io/UnsupportedEncodingException
    //   1786	1878	2097	finally
    //   422	429	2102	finally
    //   232	315	2114	finally
    //   318	340	2114	finally
    //   348	370	2114	finally
    //   378	408	2114	finally
    //   434	439	2114	finally
    //   439	509	2114	finally
    //   861	877	2114	finally
    //   882	898	2114	finally
    //   903	919	2114	finally
    //   929	934	2114	finally
    //   934	937	2114	finally
    //   937	991	2114	finally
  }
  
  private Result processesRequestWithRetries(Operation paramOperation)
  {
    if (paramOperation == null) {
      throw new IllegalArgumentException("'operation' can not be NULL");
    }
    Object localObject3;
    if (paramOperation.getState() == Operation.Status.CANCELLED)
    {
      Logger.w(Area.COMM.value(), "%1$s Operation was cancelled, returning last result", new Object[] { getLoggingPrefix(paramOperation) });
      localObject3 = paramOperation.getResult();
      return (Result)localObject3;
    }
    if (paramOperation.getState() != Operation.Status.RUNNING) {
      throw new IllegalStateException(String.format(Locale.US, "processesRequestWithRetries() for an operation in the %1$s state", new Object[] { paramOperation.getState().name() }));
    }
    Object localObject1 = null;
    int k = 0;
    for (;;)
    {
      boolean bool2 = false;
      int i = 0;
      int j = 0;
      localObject3 = localObject1;
      try
      {
        String str = Integer.toString(paramOperation.getId());
        localObject3 = localObject1;
        if (paramOperation.isCancelled())
        {
          localObject3 = localObject1;
          Logger.w(Area.COMM.value(), "%1$s Operation was cancelled, returning NULL", new Object[] { getLoggingPrefix(paramOperation) });
          return null;
        }
        localObject3 = localObject1;
        str = String.format(Locale.US, "%1$s Starting request %2$s for CommContext %3$s [Attempt %4$d]", new Object[] { getLoggingPrefix(paramOperation), str, paramOperation.getCommContext().getCommContextId(), Integer.valueOf(k + 1) });
        if (k > 0)
        {
          localObject3 = localObject1;
          Logger.w(Area.COMM.value(), str, new Object[0]);
        }
        for (;;)
        {
          localObject3 = localObject1;
          if (!paramOperation.isCancelled()) {
            break;
          }
          localObject3 = localObject1;
          Logger.w(Area.COMM.value(), "%1$s Operation was cancelled, returning NULL", new Object[] { getLoggingPrefix(paramOperation) });
          return null;
          localObject3 = localObject1;
          Logger.d(Area.COMM.value(), str, new Object[0]);
        }
      }
      catch (Exception localException)
      {
        Logger.e(Area.COMM.value(), "%1$s Operation failed [failureRetryCount:%2$d details:'%3$s - %4$s']", new Object[] { getLoggingPrefix(paramOperation), Integer.valueOf(k), localException.getClass().getName(), localException.getMessage() });
        i = 1;
        j = 0;
        boolean bool1 = RequestUtilities.checkForRetryOnException(localException, paramOperation.isIdempotent());
        if ((!bool1) || (k >= 5))
        {
          Logger.e(Area.COMM.value(), "%1$s Operation failed, not retrying, returning NULL", new Object[] { getLoggingPrefix(paramOperation) });
          localObject1 = null;
          paramOperation.setException(localException);
        }
        while (paramOperation.isCancelled())
        {
          Logger.w(Area.COMM.value(), "%1$s Operation was cancelled, returning NULL", new Object[] { getLoggingPrefix(paramOperation) });
          return null;
          localObject3 = localObject1;
          Result localResult = processesRequest(paramOperation, k);
          ServiceException localServiceException;
          if (localResult == null)
          {
            localObject3 = localResult;
            Logger.w(Area.COMM.value(), "%1$s processesRequest() returned NULL", new Object[] { getLoggingPrefix(paramOperation) });
            localObject3 = localResult;
            localObject1 = localResult;
            bool1 = bool2;
            if (paramOperation.getException() != null)
            {
              localObject3 = localResult;
              throw paramOperation.getException();
            }
          }
          else
          {
            localObject3 = localResult;
            localServiceException = RequestUtilities.getServicesException(localResult);
            localObject1 = localResult;
            bool1 = bool2;
            if (localServiceException != null)
            {
              bool1 = false;
              localObject3 = localResult;
            }
          }
          try
          {
            boolean bool3 = localServiceException.getRequestResult().checkForNonReAuthableSubCodes();
            bool1 = bool3;
          }
          catch (JSONException localJSONException)
          {
            Object localObject2;
            for (;;) {}
            k += 1;
          }
          localObject3 = localResult;
          localObject1 = localServiceException.getRequestResult();
          if ((localObject1 != null) && (bool1))
          {
            i = 0;
            j = 0;
            localObject1 = localResult;
            bool1 = bool2;
          }
          else
          {
            i = 0;
            j = 1;
            localObject1 = localResult;
            bool1 = bool2;
            continue;
            if (paramOperation.isCancelled())
            {
              Logger.w(Area.COMM.value(), "%1$s Operation was cancelled, returning NULL", new Object[] { getLoggingPrefix(paramOperation) });
              return null;
            }
            try
            {
              Thread.sleep(2000L);
              localObject1 = localObject3;
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
              localObject2 = localObject3;
            }
          }
        }
        if ((!bool1) || (k >= 5))
        {
          if ((i != 0) && (!paramOperation.getSuppressInternalCallbacks()))
          {
            paramOperation.getCommContext().makeNetworkFailureCallbacks();
            return (Result)localObject2;
          }
          localObject3 = localObject2;
          if (j == 0) {
            break;
          }
          localObject3 = localObject2;
          if (paramOperation.getSuppressInternalCallbacks()) {
            break;
          }
          paramOperation.getCommContext().makeServiceFailureCallbacks((Result)localObject2);
          return (Result)localObject2;
        }
      }
    }
  }
  
  public static CommContext retrieveContext(String paramString)
  {
    return (CommContext)_IdentifierToCommContextMap.get(paramString);
  }
  
  public static boolean sendIntentToFirstRegisteredGetjarClient(Intent paramIntent)
  {
    boolean bool1 = false;
    ArrayList localArrayList = new ArrayList();
    Logger.d(Area.COMM.value(), "CommManager: sendIntentToFirstRegisteredGetjarClient -- Found %1$d registered CommContexts", new Object[] { Integer.valueOf(getAllRegisteredGetjarClients().size()) });
    Iterator localIterator = getAllRegisteredGetjarClients().iterator();
    while (localIterator.hasNext())
    {
      GetjarClient localGetjarClient = (GetjarClient)localIterator.next();
      if (localGetjarClient.getGetjarWorkListener() != null)
      {
        boolean bool2 = bool1;
        try
        {
          if (!localArrayList.contains(localGetjarClient.getClientId()))
          {
            bool2 = bool1;
            localGetjarClient.getGetjarWorkListener().onWorkFinished(paramIntent);
            boolean bool3 = true;
            bool1 = true;
            bool2 = bool3;
            localArrayList.add(localGetjarClient.getClientId());
            bool2 = bool3;
            Logger.d(Area.COMM.value(), "CommManager: GetjarClient.getGetjarWorkListener().onWorkFinished() called for client %1$s", new Object[] { localGetjarClient.getClientId() });
          }
        }
        catch (Exception localException)
        {
          Logger.e(Area.COMM.value(), localException, "CommManager: GetjarClient.getGetjarWorkListener().onWorkFinished() failed", new Object[0]);
          bool1 = bool2;
        }
      }
    }
    return bool1;
  }
  
  private void startWorker()
  {
    Logger.i(Area.COMM.value(), "%1$s startWorker()", new Object[] { getLoggingPrefix() });
    synchronized (_WorkerThreadLock)
    {
      _WorkerThreadStopping = false;
      if (_WorkerThread == null) {
        _WorkerThread = new Thread(new RequestPipelineManagementRunnable(null), "CommManager Worker Thread");
      }
      if (!_WorkerThread.isAlive())
      {
        _WorkerThread.start();
        Logger.i(Area.COMM.value(), "%1$s Thread started", new Object[] { getLoggingPrefix() });
        return;
      }
      Logger.v(Area.COMM.value(), "%1$s Thread already running", new Object[] { getLoggingPrefix() });
    }
  }
  
  /* Error */
  private void stopWorker()
  {
    // Byte code:
    //   0: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   3: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   6: ldc_w 1060
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: invokestatic 126	com/getjar/sdk/comm/CommManager:getLoggingPrefix	()Ljava/lang/String;
    //   18: aastore
    //   19: invokestatic 267	com/getjar/sdk/logging/Logger:i	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   22: getstatic 69	com/getjar/sdk/comm/CommManager:_WorkerThreadLock	Ljava/lang/Object;
    //   25: astore_1
    //   26: aload_1
    //   27: monitorenter
    //   28: getstatic 66	com/getjar/sdk/comm/CommManager:_WorkerThread	Ljava/lang/Thread;
    //   31: ifnonnull +28 -> 59
    //   34: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   37: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   40: ldc_w 1062
    //   43: iconst_1
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: invokestatic 126	com/getjar/sdk/comm/CommManager:getLoggingPrefix	()Ljava/lang/String;
    //   52: aastore
    //   53: invokestatic 212	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   56: aload_1
    //   57: monitorexit
    //   58: return
    //   59: iconst_1
    //   60: putstatic 71	com/getjar/sdk/comm/CommManager:_WorkerThreadStopping	Z
    //   63: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   66: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   69: ldc_w 392
    //   72: iconst_1
    //   73: anewarray 4	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: invokestatic 126	com/getjar/sdk/comm/CommManager:getLoggingPrefix	()Ljava/lang/String;
    //   81: aastore
    //   82: invokestatic 212	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   85: getstatic 93	com/getjar/sdk/comm/CommManager:_RequestPipelineLock	Ljava/lang/Object;
    //   88: astore_2
    //   89: aload_2
    //   90: monitorenter
    //   91: getstatic 93	com/getjar/sdk/comm/CommManager:_RequestPipelineLock	Ljava/lang/Object;
    //   94: invokevirtual 395	java/lang/Object:notify	()V
    //   97: aload_2
    //   98: monitorexit
    //   99: getstatic 66	com/getjar/sdk/comm/CommManager:_WorkerThread	Ljava/lang/Thread;
    //   102: ldc2_w 990
    //   105: invokevirtual 1065	java/lang/Thread:join	(J)V
    //   108: getstatic 66	com/getjar/sdk/comm/CommManager:_WorkerThread	Ljava/lang/Thread;
    //   111: invokevirtual 1068	java/lang/Thread:interrupt	()V
    //   114: getstatic 66	com/getjar/sdk/comm/CommManager:_WorkerThread	Ljava/lang/Thread;
    //   117: invokevirtual 1070	java/lang/Thread:join	()V
    //   120: aconst_null
    //   121: putstatic 66	com/getjar/sdk/comm/CommManager:_WorkerThread	Ljava/lang/Thread;
    //   124: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   127: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   130: ldc_w 1072
    //   133: iconst_1
    //   134: anewarray 4	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: invokestatic 126	com/getjar/sdk/comm/CommManager:getLoggingPrefix	()Ljava/lang/String;
    //   142: aastore
    //   143: invokestatic 267	com/getjar/sdk/logging/Logger:i	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   146: aload_1
    //   147: monitorexit
    //   148: return
    //   149: astore_2
    //   150: aload_1
    //   151: monitorexit
    //   152: aload_2
    //   153: athrow
    //   154: astore_3
    //   155: aload_2
    //   156: monitorexit
    //   157: aload_3
    //   158: athrow
    //   159: astore_2
    //   160: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   163: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   166: aload_2
    //   167: ldc_w 1074
    //   170: iconst_2
    //   171: anewarray 4	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: invokestatic 126	com/getjar/sdk/comm/CommManager:getLoggingPrefix	()Ljava/lang/String;
    //   179: aastore
    //   180: dup
    //   181: iconst_1
    //   182: invokestatic 240	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   185: invokevirtual 1075	java/lang/Thread:getName	()Ljava/lang/String;
    //   188: aastore
    //   189: invokestatic 301	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: aconst_null
    //   193: putstatic 66	com/getjar/sdk/comm/CommManager:_WorkerThread	Ljava/lang/Thread;
    //   196: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   199: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   202: ldc_w 1072
    //   205: iconst_1
    //   206: anewarray 4	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: invokestatic 126	com/getjar/sdk/comm/CommManager:getLoggingPrefix	()Ljava/lang/String;
    //   214: aastore
    //   215: invokestatic 267	com/getjar/sdk/logging/Logger:i	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   218: goto -72 -> 146
    //   221: astore_2
    //   222: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   225: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   228: aload_2
    //   229: ldc_w 1077
    //   232: iconst_1
    //   233: anewarray 4	java/lang/Object
    //   236: dup
    //   237: iconst_0
    //   238: invokestatic 126	com/getjar/sdk/comm/CommManager:getLoggingPrefix	()Ljava/lang/String;
    //   241: aastore
    //   242: invokestatic 301	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: aconst_null
    //   246: putstatic 66	com/getjar/sdk/comm/CommManager:_WorkerThread	Ljava/lang/Thread;
    //   249: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   252: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   255: ldc_w 1072
    //   258: iconst_1
    //   259: anewarray 4	java/lang/Object
    //   262: dup
    //   263: iconst_0
    //   264: invokestatic 126	com/getjar/sdk/comm/CommManager:getLoggingPrefix	()Ljava/lang/String;
    //   267: aastore
    //   268: invokestatic 267	com/getjar/sdk/logging/Logger:i	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   271: goto -125 -> 146
    //   274: astore_2
    //   275: aconst_null
    //   276: putstatic 66	com/getjar/sdk/comm/CommManager:_WorkerThread	Ljava/lang/Thread;
    //   279: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   282: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   285: ldc_w 1072
    //   288: iconst_1
    //   289: anewarray 4	java/lang/Object
    //   292: dup
    //   293: iconst_0
    //   294: invokestatic 126	com/getjar/sdk/comm/CommManager:getLoggingPrefix	()Ljava/lang/String;
    //   297: aastore
    //   298: invokestatic 267	com/getjar/sdk/logging/Logger:i	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   301: aload_2
    //   302: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	CommManager
    //   25	126	1	localObject1	Object
    //   88	10	2	localObject2	Object
    //   149	7	2	localObject3	Object
    //   159	8	2	localInterruptedException	InterruptedException
    //   221	8	2	localException	Exception
    //   274	28	2	localObject4	Object
    //   154	4	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   28	58	149	finally
    //   59	91	149	finally
    //   120	146	149	finally
    //   146	148	149	finally
    //   150	152	149	finally
    //   157	159	149	finally
    //   192	218	149	finally
    //   245	271	149	finally
    //   275	303	149	finally
    //   91	99	154	finally
    //   155	157	154	finally
    //   99	120	159	java/lang/InterruptedException
    //   99	120	221	java/lang/Exception
    //   99	120	274	finally
    //   160	192	274	finally
    //   222	245	274	finally
  }
  
  private void updateOperationStateFromResult(Operation paramOperation)
  {
    if (paramOperation == null) {
      throw new IllegalArgumentException("'operation' can not be NULL");
    }
    if (paramOperation.getResult() == null) {}
    for (;;)
    {
      return;
      if ((paramOperation.getRetryAfterCount() < 5) && ((paramOperation.getResult().getResponseCode() == 202) || (paramOperation.getResult().getResponseCode() == 503)))
      {
        paramOperation.setState(Operation.Status.RETRYING);
        return;
      }
      if ((paramOperation.getRedirectCount() < 5) && ((paramOperation.getResult().getResponseCode() == 301) || (paramOperation.getResult().getResponseCode() == 302) || (paramOperation.getResult().getResponseCode() == 303) || (paramOperation.getResult().getResponseCode() == 307) || (paramOperation.getResult().getResponseCode() == 308)))
      {
        paramOperation.setState(Operation.Status.REDIRECTING);
        return;
      }
      if (paramOperation.getResult().getResponseCode() == 304)
      {
        if (!paramOperation.isDoNotCache()) {
          this._cachingManager.refreshCacheEntry(paramOperation);
        }
        paramOperation.setState(Operation.Status.COMPLETED);
        return;
      }
      if (paramOperation.getResult().isSuccessfulResponse())
      {
        paramOperation.setState(Operation.Status.COMPLETED);
        return;
      }
      try
      {
        if ((paramOperation.getReauthThenRetryCount() < 2) && (paramOperation.getResult().checkForUnauthorizedAndOKToReAuth(paramOperation.getCommContext())))
        {
          paramOperation.updateStateForRetryAfterReauth();
          AuthManager.initialize(paramOperation.getCommContext().getApplicationContext());
          new Thread(new Runnable()
          {
            public void run()
            {
              AuthManager.getInstance().reAuth();
            }
          }, "Re-Auth Thread").start();
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        Logger.e(Area.COMM.value(), localJSONException, "%1$s updateOperationStateFromResult() re-auth retry check failed", new Object[] { getLoggingPrefix(paramOperation) });
      }
    }
  }
  
  public static boolean validateManifestFile(Context paramContext)
  {
    Logger.i(Area.COMM.value(), "CommManager checkManifestFile started", new Object[0]);
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' cannot be null");
    }
    boolean bool = true;
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (!RewardUtility.checkPermission(paramContext, "android.permission.INTERNET"))
    {
      Logger.e(Area.COMM.value(), "Your application MUST have the 'android.permission.INTERNET' permission to use the GetJar Rewards SDK", new Object[0]);
      throw new GetjarException("Your application MUST have the 'android.permission.INTERNET' permission to use the GetJar Rewards SDK");
    }
    if (localPackageManager.queryBroadcastReceivers(new Intent(paramContext, PackageMonitor.class), 65536).isEmpty())
    {
      Logger.e(Area.COMM.value(), "Could not find the com.getjar.sdk.data.metadata.PackageMonitor defined inside AndroidManifest.xml", new Object[0]);
      bool = false;
    }
    if (localPackageManager.queryIntentActivities(new Intent(paramContext, GetJarActivity.class), 65536).isEmpty())
    {
      Logger.e(Area.COMM.value(), "Could not find the com.getjar.sdk.rewards.GetJarActivity defined inside AndroidManifest.xml", new Object[0]);
      throw new GetjarException("Could not find the com.getjar.sdk.rewards.GetJarActivity defined inside AndroidManifest.xml");
    }
    if (!RewardUtility.checkPermission(paramContext, "android.permission.GET_ACCOUNTS")) {
      Logger.w(Area.COMM.value(), "[OPTIONAL] The 'android.permission.GET_ACCOUNTS' permission not found in AndroidManifest.xml", new Object[0]);
    }
    if (!RewardUtility.checkPermission(paramContext, "android.permission.GET_TASKS")) {
      Logger.w(Area.COMM.value(), "[OPTIONAL] The 'android.permission.GET_TASKS' permission not found in AndroidManifest.xml", new Object[0]);
    }
    if (localPackageManager.queryIntentServices(new Intent(paramContext, GetJarService.class), 65536).isEmpty()) {
      Logger.w(Area.COMM.value(), "[OPTIONAL] Could not find the com.getjar.sdk.rewards.GetJarService defined inside AndroidManifest.xml", new Object[0]);
    }
    if (!RewardUtility.checkPermission(paramContext, "android.permission.READ_PHONE_STATE")) {
      Logger.w(Area.COMM.value(), "[OPTIONAL] The READ_PHONE_STATE permission not found in AndroidManifest.xml. It helps Getjar SDK detect unique devices that the app is running on.", new Object[0]);
    }
    if (!RewardUtility.checkPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {
      Logger.w(Area.COMM.value(), "[OPTIONAL] The ACCESS_NETWORK_STATE permission not found in AndroidManifest.xml. It helps the Getjar SDK run efficiently by detecting whether the device is connected to the internet.", new Object[0]);
    }
    if (localPackageManager.queryBroadcastReceivers(new Intent(paramContext, GetJarReceiver.class), 65536).isEmpty()) {
      Logger.d(Area.COMM.value(), "[OPTIONAL] Could not find the com.getjar.sdk.rewards.GetJarReceiver defined inside AndroidManifest.xml. It is required if there is no other implementation of Google Play billing.", new Object[0]);
    }
    return bool;
  }
  
  protected boolean cancelRequest(Operation paramOperation)
  {
    synchronized (_RequestPipelineLock)
    {
      if ((paramOperation.getState() == Operation.Status.RUNNING) || (paramOperation.getState() == Operation.Status.COMPLETED)) {
        return false;
      }
      _ActiveRequests.remove(paramOperation);
      _RequestQueue.remove(paramOperation);
      _RetryRequests.remove(paramOperation);
      paramOperation.setState(Operation.Status.CANCELLED);
      return true;
    }
  }
  
  public Operation enqueueOperation(Request.ServiceName paramServiceName, String paramString1, URI paramURI, Request.HttpMethod paramHttpMethod, Map<String, String> paramMap1, Map<String, String> paramMap2, Operation.Priority paramPriority, CommContext paramCommContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
  {
    return enqueueRequest(new Operation(paramServiceName, paramString1, paramURI, paramHttpMethod, paramMap1, paramMap2, paramPriority, paramCommContext, paramBoolean1, paramBoolean2, paramBoolean3, paramString2), false);
  }
  
  /* Error */
  protected Result waitOnOperation(Operation paramOperation)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 97	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 331
    //   11: invokespecial 102	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_1
    //   16: invokevirtual 337	com/getjar/sdk/comm/Operation:getState	()Lcom/getjar/sdk/comm/Operation$Status;
    //   19: getstatic 410	com/getjar/sdk/comm/Operation$Status:COMPLETED	Lcom/getjar/sdk/comm/Operation$Status;
    //   22: if_acmpeq +13 -> 35
    //   25: aload_1
    //   26: invokevirtual 337	com/getjar/sdk/comm/Operation:getState	()Lcom/getjar/sdk/comm/Operation$Status;
    //   29: getstatic 534	com/getjar/sdk/comm/Operation$Status:CANCELLED	Lcom/getjar/sdk/comm/Operation$Status;
    //   32: if_acmpne +8 -> 40
    //   35: aload_1
    //   36: invokevirtual 540	com/getjar/sdk/comm/Operation:getResult	()Lcom/getjar/sdk/comm/Result;
    //   39: areturn
    //   40: aload_1
    //   41: invokevirtual 337	com/getjar/sdk/comm/Operation:getState	()Lcom/getjar/sdk/comm/Operation$Status;
    //   44: getstatic 343	com/getjar/sdk/comm/Operation$Status:RETRYING	Lcom/getjar/sdk/comm/Operation$Status;
    //   47: if_acmpeq +64 -> 111
    //   50: aload_1
    //   51: invokevirtual 337	com/getjar/sdk/comm/Operation:getState	()Lcom/getjar/sdk/comm/Operation$Status;
    //   54: getstatic 346	com/getjar/sdk/comm/Operation$Status:REDIRECTING	Lcom/getjar/sdk/comm/Operation$Status;
    //   57: if_acmpeq +54 -> 111
    //   60: aload_1
    //   61: invokevirtual 337	com/getjar/sdk/comm/Operation:getState	()Lcom/getjar/sdk/comm/Operation$Status;
    //   64: getstatic 543	com/getjar/sdk/comm/Operation$Status:RUNNING	Lcom/getjar/sdk/comm/Operation$Status;
    //   67: if_acmpeq +44 -> 111
    //   70: aload_1
    //   71: invokevirtual 337	com/getjar/sdk/comm/Operation:getState	()Lcom/getjar/sdk/comm/Operation$Status;
    //   74: getstatic 438	com/getjar/sdk/comm/Operation$Status:WAITING	Lcom/getjar/sdk/comm/Operation$Status;
    //   77: if_acmpeq +34 -> 111
    //   80: new 186	java/lang/IllegalStateException
    //   83: dup
    //   84: getstatic 380	java/util/Locale:US	Ljava/util/Locale;
    //   87: ldc_w 1193
    //   90: iconst_1
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload_1
    //   97: invokevirtual 337	com/getjar/sdk/comm/Operation:getState	()Lcom/getjar/sdk/comm/Operation$Status;
    //   100: invokevirtual 548	com/getjar/sdk/comm/Operation$Status:name	()Ljava/lang/String;
    //   103: aastore
    //   104: invokestatic 388	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   107: invokespecial 189	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   110: athrow
    //   111: aload_1
    //   112: invokevirtual 1197	com/getjar/sdk/comm/Operation:getFuture	()Ljava/util/concurrent/FutureTask;
    //   115: astore 11
    //   117: aload 11
    //   119: monitorenter
    //   120: aload_1
    //   121: invokevirtual 1197	com/getjar/sdk/comm/Operation:getFuture	()Ljava/util/concurrent/FutureTask;
    //   124: invokevirtual 1199	java/util/concurrent/FutureTask:get	()Ljava/lang/Object;
    //   127: checkcast 729	com/getjar/sdk/comm/Result
    //   130: astore 8
    //   132: aload_0
    //   133: aload_1
    //   134: invokespecial 154	com/getjar/sdk/comm/CommManager:updateOperationStateFromResult	(Lcom/getjar/sdk/comm/Operation;)V
    //   137: aload_1
    //   138: invokevirtual 540	com/getjar/sdk/comm/Operation:getResult	()Lcom/getjar/sdk/comm/Result;
    //   141: astore 8
    //   143: aload_1
    //   144: invokevirtual 337	com/getjar/sdk/comm/Operation:getState	()Lcom/getjar/sdk/comm/Operation$Status;
    //   147: getstatic 346	com/getjar/sdk/comm/Operation$Status:REDIRECTING	Lcom/getjar/sdk/comm/Operation$Status;
    //   150: if_acmpne +346 -> 496
    //   153: aload 8
    //   155: astore 9
    //   157: aload_1
    //   158: invokevirtual 337	com/getjar/sdk/comm/Operation:getState	()Lcom/getjar/sdk/comm/Operation$Status;
    //   161: getstatic 346	com/getjar/sdk/comm/Operation$Status:REDIRECTING	Lcom/getjar/sdk/comm/Operation$Status;
    //   164: if_acmpne +120 -> 284
    //   167: aconst_null
    //   168: astore 10
    //   170: aload 10
    //   172: astore 9
    //   174: aload 8
    //   176: invokevirtual 1202	com/getjar/sdk/comm/Result:getHeaders	()Ljava/util/Map;
    //   179: ifnull +59 -> 238
    //   182: aload 8
    //   184: invokevirtual 1202	com/getjar/sdk/comm/Result:getHeaders	()Ljava/util/Map;
    //   187: ldc_w 1204
    //   190: invokeinterface 903 2 0
    //   195: istore_3
    //   196: aload 10
    //   198: astore 9
    //   200: iload_3
    //   201: ifeq +37 -> 238
    //   204: new 770	java/net/URI
    //   207: dup
    //   208: aload 8
    //   210: invokevirtual 1202	com/getjar/sdk/comm/Result:getHeaders	()Ljava/util/Map;
    //   213: ldc_w 1204
    //   216: invokeinterface 714 2 0
    //   221: checkcast 466	java/util/List
    //   224: iconst_0
    //   225: invokeinterface 1205 2 0
    //   230: checkcast 384	java/lang/String
    //   233: invokespecial 1206	java/net/URI:<init>	(Ljava/lang/String;)V
    //   236: astore 9
    //   238: aload 9
    //   240: ifnonnull +113 -> 353
    //   243: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   246: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   249: ldc_w 1208
    //   252: iconst_2
    //   253: anewarray 4	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: aload_1
    //   259: invokevirtual 488	com/getjar/sdk/comm/Operation:getId	()I
    //   262: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: aastore
    //   266: dup
    //   267: iconst_1
    //   268: aload 8
    //   270: invokevirtual 1083	com/getjar/sdk/comm/Result:getResponseCode	()I
    //   273: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   276: aastore
    //   277: invokestatic 390	com/getjar/sdk/logging/Logger:w	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   280: aload 8
    //   282: astore 9
    //   284: aload 11
    //   286: monitorexit
    //   287: aload 9
    //   289: areturn
    //   290: astore_1
    //   291: aload 11
    //   293: monitorexit
    //   294: aload_1
    //   295: athrow
    //   296: astore_1
    //   297: new 550	com/getjar/sdk/exceptions/CommunicationException
    //   300: dup
    //   301: aload_1
    //   302: invokespecial 551	com/getjar/sdk/exceptions/CommunicationException:<init>	(Ljava/lang/Throwable;)V
    //   305: athrow
    //   306: astore_1
    //   307: new 550	com/getjar/sdk/exceptions/CommunicationException
    //   310: dup
    //   311: aload_1
    //   312: invokespecial 551	com/getjar/sdk/exceptions/CommunicationException:<init>	(Ljava/lang/Throwable;)V
    //   315: athrow
    //   316: astore 9
    //   318: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   321: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   324: aload 9
    //   326: ldc_w 1210
    //   329: iconst_1
    //   330: anewarray 4	java/lang/Object
    //   333: dup
    //   334: iconst_0
    //   335: aload_1
    //   336: invokevirtual 488	com/getjar/sdk/comm/Operation:getId	()I
    //   339: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: aastore
    //   343: invokestatic 301	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   346: aload 10
    //   348: astore 9
    //   350: goto -112 -> 238
    //   353: aload_1
    //   354: invokevirtual 488	com/getjar/sdk/comm/Operation:getId	()I
    //   357: istore_2
    //   358: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   361: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   364: ldc_w 1212
    //   367: iconst_3
    //   368: anewarray 4	java/lang/Object
    //   371: dup
    //   372: iconst_0
    //   373: iload_2
    //   374: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   377: aastore
    //   378: dup
    //   379: iconst_1
    //   380: aload 8
    //   382: invokevirtual 1083	com/getjar/sdk/comm/Result:getResponseCode	()I
    //   385: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   388: aastore
    //   389: dup
    //   390: iconst_2
    //   391: aload 9
    //   393: invokevirtual 1214	java/net/URI:toString	()Ljava/lang/String;
    //   396: aastore
    //   397: invokestatic 212	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   400: aload_1
    //   401: invokevirtual 525	com/getjar/sdk/comm/Operation:getRequest	()Lcom/getjar/sdk/comm/Request;
    //   404: aload 9
    //   406: invokevirtual 1217	com/getjar/sdk/comm/Request:setUriForRequest	(Ljava/net/URI;)V
    //   409: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   412: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   415: ldc_w 1219
    //   418: iconst_2
    //   419: anewarray 4	java/lang/Object
    //   422: dup
    //   423: iconst_0
    //   424: iload_2
    //   425: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   428: aastore
    //   429: dup
    //   430: iconst_1
    //   431: aload_1
    //   432: invokevirtual 488	com/getjar/sdk/comm/Operation:getId	()I
    //   435: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   438: aastore
    //   439: invokestatic 212	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   442: aload_1
    //   443: invokevirtual 1222	com/getjar/sdk/comm/Operation:tickRedirectCount	()V
    //   446: aload_1
    //   447: invokevirtual 1225	com/getjar/sdk/comm/Operation:tickRetryAfterCount	()V
    //   450: aload_1
    //   451: lconst_1
    //   452: invokevirtual 1228	com/getjar/sdk/comm/Operation:updateRetryAfterTimestamp	(J)V
    //   455: aload_0
    //   456: aload_1
    //   457: invokespecial 1230	com/getjar/sdk/comm/CommManager:enqueueOperationForRetry	(Lcom/getjar/sdk/comm/Operation;)Lcom/getjar/sdk/comm/Operation;
    //   460: pop
    //   461: aload_1
    //   462: invokevirtual 1197	com/getjar/sdk/comm/Operation:getFuture	()Ljava/util/concurrent/FutureTask;
    //   465: invokevirtual 1199	java/util/concurrent/FutureTask:get	()Ljava/lang/Object;
    //   468: checkcast 729	com/getjar/sdk/comm/Result
    //   471: astore 8
    //   473: goto -320 -> 153
    //   476: astore_1
    //   477: new 550	com/getjar/sdk/exceptions/CommunicationException
    //   480: dup
    //   481: aload_1
    //   482: invokespecial 551	com/getjar/sdk/exceptions/CommunicationException:<init>	(Ljava/lang/Throwable;)V
    //   485: athrow
    //   486: astore_1
    //   487: new 550	com/getjar/sdk/exceptions/CommunicationException
    //   490: dup
    //   491: aload_1
    //   492: invokespecial 551	com/getjar/sdk/exceptions/CommunicationException:<init>	(Ljava/lang/Throwable;)V
    //   495: athrow
    //   496: aload 8
    //   498: astore 9
    //   500: aload_1
    //   501: invokevirtual 337	com/getjar/sdk/comm/Operation:getState	()Lcom/getjar/sdk/comm/Operation$Status;
    //   504: getstatic 343	com/getjar/sdk/comm/Operation$Status:RETRYING	Lcom/getjar/sdk/comm/Operation$Status;
    //   507: if_acmpne -223 -> 284
    //   510: aload 8
    //   512: astore 9
    //   514: aload_1
    //   515: invokevirtual 337	com/getjar/sdk/comm/Operation:getState	()Lcom/getjar/sdk/comm/Operation$Status;
    //   518: getstatic 343	com/getjar/sdk/comm/Operation$Status:RETRYING	Lcom/getjar/sdk/comm/Operation$Status;
    //   521: if_acmpne -237 -> 284
    //   524: ldc2_w 1231
    //   527: lstore 6
    //   529: lload 6
    //   531: lstore 4
    //   533: aload 8
    //   535: invokevirtual 1202	com/getjar/sdk/comm/Result:getHeaders	()Ljava/util/Map;
    //   538: ifnull +55 -> 593
    //   541: aload 8
    //   543: invokevirtual 1202	com/getjar/sdk/comm/Result:getHeaders	()Ljava/util/Map;
    //   546: ldc_w 1234
    //   549: invokeinterface 903 2 0
    //   554: istore_3
    //   555: lload 6
    //   557: lstore 4
    //   559: iload_3
    //   560: ifeq +33 -> 593
    //   563: aload 8
    //   565: invokevirtual 1202	com/getjar/sdk/comm/Result:getHeaders	()Ljava/util/Map;
    //   568: ldc_w 1234
    //   571: invokeinterface 714 2 0
    //   576: checkcast 466	java/util/List
    //   579: iconst_0
    //   580: invokeinterface 1205 2 0
    //   585: checkcast 384	java/lang/String
    //   588: invokestatic 1238	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   591: lstore 4
    //   593: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   596: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   599: ldc_w 1240
    //   602: iconst_3
    //   603: anewarray 4	java/lang/Object
    //   606: dup
    //   607: iconst_0
    //   608: aload_1
    //   609: invokevirtual 488	com/getjar/sdk/comm/Operation:getId	()I
    //   612: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   615: aastore
    //   616: dup
    //   617: iconst_1
    //   618: aload 8
    //   620: invokevirtual 1083	com/getjar/sdk/comm/Result:getResponseCode	()I
    //   623: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   626: aastore
    //   627: dup
    //   628: iconst_2
    //   629: lload 4
    //   631: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   634: aastore
    //   635: invokestatic 212	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   638: aload_1
    //   639: invokevirtual 1225	com/getjar/sdk/comm/Operation:tickRetryAfterCount	()V
    //   642: aload_1
    //   643: ldc2_w 1241
    //   646: lload 4
    //   648: lmul
    //   649: invokevirtual 1228	com/getjar/sdk/comm/Operation:updateRetryAfterTimestamp	(J)V
    //   652: aload_0
    //   653: aload_1
    //   654: invokespecial 1230	com/getjar/sdk/comm/CommManager:enqueueOperationForRetry	(Lcom/getjar/sdk/comm/Operation;)Lcom/getjar/sdk/comm/Operation;
    //   657: pop
    //   658: aload_1
    //   659: invokevirtual 1197	com/getjar/sdk/comm/Operation:getFuture	()Ljava/util/concurrent/FutureTask;
    //   662: invokevirtual 1199	java/util/concurrent/FutureTask:get	()Ljava/lang/Object;
    //   665: checkcast 729	com/getjar/sdk/comm/Result
    //   668: astore 8
    //   670: goto -160 -> 510
    //   673: astore 9
    //   675: getstatic 201	com/getjar/sdk/logging/Area:COMM	Lcom/getjar/sdk/logging/Area;
    //   678: invokevirtual 204	com/getjar/sdk/logging/Area:value	()J
    //   681: aload 9
    //   683: ldc_w 1244
    //   686: iconst_0
    //   687: anewarray 4	java/lang/Object
    //   690: invokestatic 301	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   693: lload 6
    //   695: lstore 4
    //   697: goto -104 -> 593
    //   700: astore_1
    //   701: new 550	com/getjar/sdk/exceptions/CommunicationException
    //   704: dup
    //   705: aload_1
    //   706: invokespecial 551	com/getjar/sdk/exceptions/CommunicationException:<init>	(Ljava/lang/Throwable;)V
    //   709: athrow
    //   710: astore_1
    //   711: new 550	com/getjar/sdk/exceptions/CommunicationException
    //   714: dup
    //   715: aload_1
    //   716: invokespecial 551	com/getjar/sdk/exceptions/CommunicationException:<init>	(Ljava/lang/Throwable;)V
    //   719: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	720	0	this	CommManager
    //   0	720	1	paramOperation	Operation
    //   357	68	2	i	int
    //   195	365	3	bool	boolean
    //   531	165	4	l1	long
    //   527	167	6	l2	long
    //   130	539	8	localResult	Result
    //   155	133	9	localObject1	Object
    //   316	9	9	localException1	Exception
    //   348	165	9	localObject2	Object
    //   673	9	9	localException2	Exception
    //   168	179	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   120	132	290	finally
    //   132	153	290	finally
    //   157	167	290	finally
    //   174	196	290	finally
    //   204	238	290	finally
    //   243	280	290	finally
    //   284	287	290	finally
    //   291	294	290	finally
    //   297	306	290	finally
    //   307	316	290	finally
    //   318	346	290	finally
    //   353	461	290	finally
    //   461	473	290	finally
    //   477	486	290	finally
    //   487	496	290	finally
    //   500	510	290	finally
    //   514	524	290	finally
    //   533	555	290	finally
    //   563	593	290	finally
    //   593	658	290	finally
    //   658	670	290	finally
    //   675	693	290	finally
    //   701	710	290	finally
    //   711	720	290	finally
    //   120	132	296	java/lang/InterruptedException
    //   120	132	306	java/util/concurrent/ExecutionException
    //   204	238	316	java/lang/Exception
    //   461	473	476	java/lang/InterruptedException
    //   461	473	486	java/util/concurrent/ExecutionException
    //   563	593	673	java/lang/Exception
    //   658	670	700	java/lang/InterruptedException
    //   658	670	710	java/util/concurrent/ExecutionException
  }
  
  private class RequestCallable
    implements Callable<Result>
  {
    private Operation _operation = null;
    
    private RequestCallable(Operation paramOperation)
    {
      if (paramOperation == null) {
        throw new IllegalArgumentException("'operation' can not be NULL");
      }
      this._operation = paramOperation;
    }
    
    private void cleanup()
    {
      for (;;)
      {
        synchronized (CommManager._RequestPipelineLock)
        {
          Logger.d(Area.COMM.value(), "%1$s RequestFutureTask has completed work, doing cleanup work [state:%2$s]", new Object[] { CommManager.getLoggingPrefix(this._operation), this._operation.getState() });
          try
          {
            CommManager.this.updateOperationStateFromResult(this._operation);
            if (CommManager._ActiveRequests.remove(this._operation))
            {
              Logger.i(Area.COMM.value(), "%1$s Completed Request has been removed from _ActiveRequests", new Object[] { CommManager.getLoggingPrefix(this._operation) });
              if ((!Operation.Status.RETRYING.equals(this._operation.getState())) && (!Operation.Status.REDIRECTING.equals(this._operation.getState())))
              {
                if (CommManager._RequestQueue.remove(this._operation)) {
                  Logger.e(Area.COMM.value(), "%1$s Found completed Request in _RequestQueue", new Object[] { CommManager.getLoggingPrefix(this._operation) });
                }
                if (CommManager._RetryRequests.remove(this._operation)) {
                  Logger.e(Area.COMM.value(), "%1$s Found completed Request in _RetryRequests", new Object[] { CommManager.getLoggingPrefix(this._operation) });
                }
              }
              Logger.v(Area.COMM.value(), "%1$s kicking worker thread", new Object[] { CommManager.getLoggingPrefix(this._operation) });
              CommManager._RequestPipelineLock.notify();
              return;
            }
          }
          catch (Exception localException)
          {
            Logger.e(Area.COMM.value(), localException, "%1$s updateOperationStateFromResult() failed", new Object[] { CommManager.getLoggingPrefix(this._operation) });
            continue;
          }
        }
        Logger.i(Area.COMM.value(), "%1$s Completed Request was not found in _ActiveRequests", new Object[] { CommManager.getLoggingPrefix(this._operation) });
      }
    }
    
    public Result call()
      throws Exception
    {
      Result localResult = CommManager.this.processesRequestWithRetries(this._operation);
      if (localResult == null) {
        Logger.e(Area.COMM.value(), "%1$s Received a NULL result", new Object[] { CommManager.getLoggingPrefix(this._operation) });
      }
      for (;;)
      {
        cleanup();
        return localResult;
        if (Logger.getInstance().shouldLog(3, Area.COMM.value()))
        {
          Logger.d(Area.COMM.value(), "%1$s Received response code: %2$d", new Object[] { CommManager.getLoggingPrefix(this._operation), Integer.valueOf(localResult.getResponseCode()) });
          if (localResult.getResponseJson() != null) {
            Logger.d(Area.COMM.value(), "%1$s Received response body:\r\n%2$s", new Object[] { CommManager.getLoggingPrefix(this._operation), localResult.getResponseJson().toString(4) });
          }
          StringBuilder localStringBuilder;
          while ((localResult.getHeaders() != null) && (localResult.getHeaders().size() > 0))
          {
            localStringBuilder = new StringBuilder(CommManager.getLoggingPrefix(this._operation));
            localStringBuilder.append(" Received response headers:\r\n");
            Iterator localIterator1 = localResult.getHeaders().keySet().iterator();
            while (localIterator1.hasNext())
            {
              String str1 = (String)localIterator1.next();
              Iterator localIterator2 = ((List)localResult.getHeaders().get(str1)).iterator();
              while (localIterator2.hasNext())
              {
                String str2 = (String)localIterator2.next();
                localStringBuilder.append(Area.COMM.name());
                localStringBuilder.append(":      [request:");
                localStringBuilder.append(this._operation.getRequest().getId());
                localStringBuilder.append("] ");
                localStringBuilder.append(str1);
                localStringBuilder.append(" = ");
                localStringBuilder.append(str2);
                localStringBuilder.append("\r\n");
              }
            }
            if (!StringUtility.isNullOrEmpty(localResult.getResponseBody())) {
              Logger.d(Area.COMM.value(), "%1$s Received response body:\r\n%2$s", new Object[] { CommManager.getLoggingPrefix(this._operation), localResult.getResponseBody() });
            }
          }
          continue;
          Logger.d(Area.COMM.value(), localStringBuilder.toString(), new Object[0]);
        }
      }
    }
  }
  
  private class RequestPipelineManagementRunnable
    implements Runnable
  {
    private RequestPipelineManagementRunnable() {}
    
    public void run()
    {
      AuthManager.initialize(CommManager.this._context);
      if (!CommManager._WorkerThreadStopping) {}
      for (;;)
      {
        Object localObject4;
        Operation localOperation;
        try
        {
          bool = CommManager._WorkerThreadStopping;
          if (bool)
          {
            Logger.i(Area.COMM.value(), "%1$s Worker Thread exited", new Object[] { CommManager.access$1100() });
            return;
          }
          synchronized (CommManager._RequestPipelineLock)
          {
            Logger.v(Area.COMM.value(), "%1$s queued:%2$d active:%3$d retry:%4$d", new Object[] { CommManager.access$1100(), Integer.valueOf(CommManager._RequestQueue.size()), Integer.valueOf(CommManager._ActiveRequests.size()), Integer.valueOf(CommManager._RetryRequests.size()) });
            l = System.currentTimeMillis();
            ArrayList localArrayList = new ArrayList();
            localObject4 = CommManager._RetryRequests.iterator();
            if (!((Iterator)localObject4).hasNext()) {
              break label252;
            }
            localOperation = (Operation)((Iterator)localObject4).next();
            if (localOperation.getRetryAfterTimestamp() > l) {
              continue;
            }
            if ((!AuthManager.getInstance().isAuthed()) && (!localOperation.isAuthRelated())) {
              break label241;
            }
            localArrayList.add(localOperation);
          }
        }
        catch (Exception localException1)
        {
          Logger.e(Area.COMM.value(), localException1, "%1$s failure", new Object[] { CommManager.access$1100() });
          try
          {
            Thread.sleep(5000L);
          }
          catch (Exception localException2) {}
        }
        break;
        label241:
        localOperation.updateRetryAfterTimestamp(2000L);
        continue;
        label252:
        Object localObject3 = ((List)localObject2).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Operation)((Iterator)localObject3).next();
          CommManager._RetryRequests.remove(localObject4);
          CommManager._RequestQueue.add(localObject4);
          ((Operation)localObject4).setState(Operation.Status.WAITING);
          Logger.v(Area.COMM.value(), "%1$s moved request from retry to queue", new Object[] { CommManager.getLoggingPrefix((Operation)localObject4) });
        }
        for (;;)
        {
          Collections.sort(CommManager._RequestQueue, OperationPriorityComparator.getInstance());
          localObject3 = (Operation)CommManager._RequestQueue.remove();
          CommManager._ActiveRequests.add(localObject3);
          ((Operation)localObject3).setState(Operation.Status.RUNNING);
          CommManager._ExecutorService.execute(((Operation)localObject3).getFuture());
          if ((CommManager._ActiveRequests.size() >= 2) || (CommManager._RequestQueue.size() <= 0)) {
            break;
          }
          localObject3 = CommManager._RequestQueue.iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Operation)((Iterator)localObject3).next()).promotePriority();
          }
        }
        CommManager.this._cachingManager.trimLruEntries();
        long l = CommManager.this.getSleepTime();
        Logger.v(Area.COMM.value(), "%1$s Worker Thread is waiting to be notified", new Object[] { CommManager.access$1100() });
        CommManager._RequestPipelineLock.wait(l);
        Logger.v(Area.COMM.value(), "%1$s Worker Thread is awake", new Object[] { CommManager.access$1100() });
        boolean bool = CommManager._WorkerThreadStopping;
        if (!bool) {
          break;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/CommManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */