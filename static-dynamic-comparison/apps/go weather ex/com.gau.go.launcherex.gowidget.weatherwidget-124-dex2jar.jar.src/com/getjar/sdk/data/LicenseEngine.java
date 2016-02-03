package com.getjar.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.getjar.sdk.GetjarException;
import com.getjar.sdk.GetjarLicense;
import com.getjar.sdk.GetjarLicense.Scope;
import com.getjar.sdk.OnGetjarLicensesReceivedListener;
import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.comm.LicenseCachingManager;
import com.getjar.sdk.comm.LicenseCachingManager.LicensesWithETag;
import com.getjar.sdk.comm.Result;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.comm.auth.AuthManager.AuthListener;
import com.getjar.sdk.comm.auth.ClaimsManager;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.SetExceptionFutureTask;
import com.getjar.sdk.utilities.StringUtility;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LicenseEngine
{
  public static final String PREFS_LICENSE_CHECK_TIMESTAMP = "licenseCheckTimestamp";
  private static volatile LicenseEngine _Instance = null;
  private static final Object _InstanceLock = new Object();
  private final AuthManager.AuthListener _authListener = new AuthManager.AuthListener()
  {
    private final String _id = UUID.randomUUID().toString();
    
    public int compare(AuthManager.AuthListener paramAnonymousAuthListener1, AuthManager.AuthListener paramAnonymousAuthListener2)
    {
      return paramAnonymousAuthListener1.getUniqueId().compareTo(paramAnonymousAuthListener2.getUniqueId());
    }
    
    public boolean equals(Object paramAnonymousObject)
    {
      if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof AuthManager.AuthListener))) {
        return false;
      }
      return getUniqueId().equals(((AuthManager.AuthListener)paramAnonymousObject).getUniqueId());
    }
    
    public String getUniqueId()
    {
      return this._id;
    }
    
    public int hashCode()
    {
      return getUniqueId().hashCode();
    }
    
    public void notifyAuthCompleted(boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean) {}
      try
      {
        LicenseEngine.this._executorService.execute(new Runnable()
        {
          /* Error */
          public void run()
          {
            // Byte code:
            //   0: aload_0
            //   1: getfield 17	com/getjar/sdk/data/LicenseEngine$1$1:this$1	Lcom/getjar/sdk/data/LicenseEngine$1;
            //   4: getfield 28	com/getjar/sdk/data/LicenseEngine$1:this$0	Lcom/getjar/sdk/data/LicenseEngine;
            //   7: invokestatic 34	com/getjar/sdk/data/LicenseEngine:access$000	(Lcom/getjar/sdk/data/LicenseEngine;)V
            //   10: aload_0
            //   11: getfield 17	com/getjar/sdk/data/LicenseEngine$1$1:this$1	Lcom/getjar/sdk/data/LicenseEngine$1;
            //   14: getfield 28	com/getjar/sdk/data/LicenseEngine$1:this$0	Lcom/getjar/sdk/data/LicenseEngine;
            //   17: invokestatic 38	com/getjar/sdk/data/LicenseEngine:access$100	(Lcom/getjar/sdk/data/LicenseEngine;)Ljava/lang/Object;
            //   20: astore_1
            //   21: aload_1
            //   22: monitorenter
            //   23: aload_0
            //   24: getfield 17	com/getjar/sdk/data/LicenseEngine$1$1:this$1	Lcom/getjar/sdk/data/LicenseEngine$1;
            //   27: getfield 28	com/getjar/sdk/data/LicenseEngine$1:this$0	Lcom/getjar/sdk/data/LicenseEngine;
            //   30: invokestatic 41	com/getjar/sdk/data/LicenseEngine:access$200	(Lcom/getjar/sdk/data/LicenseEngine;)V
            //   33: aload_0
            //   34: getfield 17	com/getjar/sdk/data/LicenseEngine$1$1:this$1	Lcom/getjar/sdk/data/LicenseEngine$1;
            //   37: getfield 28	com/getjar/sdk/data/LicenseEngine$1:this$0	Lcom/getjar/sdk/data/LicenseEngine;
            //   40: invokestatic 44	com/getjar/sdk/data/LicenseEngine:access$300	(Lcom/getjar/sdk/data/LicenseEngine;)V
            //   43: aload_0
            //   44: getfield 17	com/getjar/sdk/data/LicenseEngine$1$1:this$1	Lcom/getjar/sdk/data/LicenseEngine$1;
            //   47: getfield 28	com/getjar/sdk/data/LicenseEngine$1:this$0	Lcom/getjar/sdk/data/LicenseEngine;
            //   50: invokestatic 48	com/getjar/sdk/data/LicenseEngine:access$400	(Lcom/getjar/sdk/data/LicenseEngine;)Lcom/getjar/sdk/comm/LicenseCachingManager;
            //   53: pop
            //   54: aload_0
            //   55: getfield 17	com/getjar/sdk/data/LicenseEngine$1$1:this$1	Lcom/getjar/sdk/data/LicenseEngine$1;
            //   58: getfield 28	com/getjar/sdk/data/LicenseEngine$1:this$0	Lcom/getjar/sdk/data/LicenseEngine;
            //   61: invokestatic 41	com/getjar/sdk/data/LicenseEngine:access$200	(Lcom/getjar/sdk/data/LicenseEngine;)V
            //   64: aload_0
            //   65: getfield 17	com/getjar/sdk/data/LicenseEngine$1$1:this$1	Lcom/getjar/sdk/data/LicenseEngine$1;
            //   68: getfield 28	com/getjar/sdk/data/LicenseEngine$1:this$0	Lcom/getjar/sdk/data/LicenseEngine;
            //   71: iconst_1
            //   72: invokestatic 52	com/getjar/sdk/data/LicenseEngine:access$500	(Lcom/getjar/sdk/data/LicenseEngine;Z)Ljava/util/List;
            //   75: astore_2
            //   76: aload_1
            //   77: monitorexit
            //   78: getstatic 58	com/getjar/sdk/logging/Area:LICENSING	Lcom/getjar/sdk/logging/Area;
            //   81: invokevirtual 62	com/getjar/sdk/logging/Area:value	()J
            //   84: getstatic 65	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
            //   87: invokevirtual 62	com/getjar/sdk/logging/Area:value	()J
            //   90: lor
            //   91: ldc 67
            //   93: iconst_1
            //   94: anewarray 4	java/lang/Object
            //   97: dup
            //   98: iconst_0
            //   99: aload_2
            //   100: invokeinterface 73 1 0
            //   105: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
            //   108: aastore
            //   109: invokestatic 85	com/getjar/sdk/logging/Logger:i	(JLjava/lang/String;[Ljava/lang/Object;)V
            //   112: aload_2
            //   113: invokeinterface 89 1 0
            //   118: astore_1
            //   119: aload_1
            //   120: invokeinterface 95 1 0
            //   125: ifeq +88 -> 213
            //   128: aload_1
            //   129: invokeinterface 99 1 0
            //   134: checkcast 101	com/getjar/sdk/GetjarLicense
            //   137: astore_2
            //   138: aload_0
            //   139: getfield 17	com/getjar/sdk/data/LicenseEngine$1$1:this$1	Lcom/getjar/sdk/data/LicenseEngine$1;
            //   142: getfield 28	com/getjar/sdk/data/LicenseEngine$1:this$0	Lcom/getjar/sdk/data/LicenseEngine;
            //   145: invokestatic 105	com/getjar/sdk/data/LicenseEngine:access$600	(Lcom/getjar/sdk/data/LicenseEngine;)Lcom/getjar/sdk/comm/CommContext;
            //   148: invokevirtual 111	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
            //   151: aload_2
            //   152: invokestatic 117	com/getjar/sdk/utilities/IntentsUtility:getLicenseUpdatedIntent	(Landroid/content/Context;Lcom/getjar/sdk/GetjarLicense;)Landroid/content/Intent;
            //   155: invokestatic 123	com/getjar/sdk/comm/CommManager:sendIntentToFirstRegisteredGetjarClient	(Landroid/content/Intent;)Z
            //   158: pop
            //   159: goto -40 -> 119
            //   162: astore_2
            //   163: getstatic 58	com/getjar/sdk/logging/Area:LICENSING	Lcom/getjar/sdk/logging/Area;
            //   166: invokevirtual 62	com/getjar/sdk/logging/Area:value	()J
            //   169: getstatic 65	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
            //   172: invokevirtual 62	com/getjar/sdk/logging/Area:value	()J
            //   175: lor
            //   176: aload_2
            //   177: ldc 125
            //   179: iconst_0
            //   180: anewarray 4	java/lang/Object
            //   183: invokestatic 129	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
            //   186: goto -67 -> 119
            //   189: astore_1
            //   190: getstatic 58	com/getjar/sdk/logging/Area:LICENSING	Lcom/getjar/sdk/logging/Area;
            //   193: invokevirtual 62	com/getjar/sdk/logging/Area:value	()J
            //   196: getstatic 65	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
            //   199: invokevirtual 62	com/getjar/sdk/logging/Area:value	()J
            //   202: lor
            //   203: aload_1
            //   204: ldc -125
            //   206: iconst_0
            //   207: anewarray 4	java/lang/Object
            //   210: invokestatic 129	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
            //   213: return
            //   214: astore_2
            //   215: aload_1
            //   216: monitorexit
            //   217: aload_2
            //   218: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	219	0	this	1
            //   189	27	1	localException1	Exception
            //   75	77	2	localObject2	Object
            //   162	15	2	localException2	Exception
            //   214	4	2	localObject3	Object
            // Exception table:
            //   from	to	target	type
            //   138	159	162	java/lang/Exception
            //   0	23	189	java/lang/Exception
            //   78	119	189	java/lang/Exception
            //   119	138	189	java/lang/Exception
            //   163	186	189	java/lang/Exception
            //   217	219	189	java/lang/Exception
            //   23	78	214	finally
            //   215	217	214	finally
          }
        });
        return;
      }
      catch (Exception localException)
      {
        Logger.e(Area.LICENSING.value() | Area.AUTH.value(), localException, "LicenseEngine.AuthListener.notifyAuthCompleted() failed", new Object[0]);
      }
    }
    
    public String toString()
    {
      return getUniqueId();
    }
  };
  private ClaimsManager _claimsManager;
  private CommContext _commContext;
  private final ExecutorService _executorService = Executors.newCachedThreadPool();
  private volatile LicenseCachingManager _licenseCachingManager = null;
  private final Object _licenseCachingManagerLock = new Object();
  private final Object _retrieveLock = new Object();
  
  private LicenseEngine(CommContext paramCommContext)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' can not be NULL");
    }
    this._commContext = paramCommContext;
    AuthManager.initialize(paramCommContext.getApplicationContext());
    this._claimsManager = AuthManager.getInstance().getClaimsManager(this._commContext.getApplicationContext());
    AuthManager.getInstance().registerCallbacks(this._authListener);
  }
  
  private void clearLicenseCachingManager()
  {
    if (this._licenseCachingManager != null) {
      synchronized (this._licenseCachingManagerLock)
      {
        if (this._licenseCachingManager != null) {
          this._licenseCachingManager = null;
        }
        return;
      }
    }
  }
  
  private void clearLicenseCachingManagerData()
  {
    if (this._licenseCachingManager != null) {
      synchronized (this._licenseCachingManagerLock)
      {
        if (this._licenseCachingManager != null) {
          this._licenseCachingManager.removeCachedLicenses();
        }
        return;
      }
    }
  }
  
  public static LicenseEngine getInstance()
  {
    if (_Instance == null) {
      throw new IllegalStateException("initialize() must be called before using AdManager");
    }
    return _Instance;
  }
  
  private LicenseCachingManager getLicenseCachingManager()
  {
    if (this._licenseCachingManager == null) {}
    synchronized (this._licenseCachingManagerLock)
    {
      if (this._licenseCachingManager == null)
      {
        this._licenseCachingManager = new LicenseCachingManager(this._commContext);
        if (this._licenseCachingManager.isCacheNewVersion())
        {
          resetServiceRequestThrottleTimestamp();
          Logger.d(Area.LICENSING.value(), "LicenseEngine: getLicenseCachingManager() resulted in a locale data dump, service request throttling reset", new Object[0]);
        }
      }
      return this._licenseCachingManager;
    }
  }
  
  private static LicenseInternal getLicenseInternal(int paramInt, String paramString1, String paramString2)
    throws JSONException
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("keyIndex cannot be less than 0");
    }
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("signedLicenseData cannot be null or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("licenseSignature cannot be null or empty");
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
    try
    {
      Object localObject = new JSONObject(paramString1);
      String str1 = ((JSONObject)localObject).getString("developer_product_id");
      String str2 = ((JSONObject)localObject).getString("license_creation_timestamp");
      localObject = ((JSONObject)localObject).getString("license_modification_timestamp");
      paramString1 = new LicenseInternal(str1, paramInt, paramString1, paramString2, localSimpleDateFormat.parse(str2), localSimpleDateFormat.parse((String)localObject), new Date());
      return paramString1;
    }
    catch (ParseException paramString1)
    {
      throw new GetjarException(paramString1);
    }
  }
  
  private ArrayList<LicenseInternal> getLicensesFromResult(Result paramResult)
  {
    if (paramResult == null) {
      throw new IllegalArgumentException("result cannot be null");
    }
    localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = paramResult.getResponseJson().getJSONObject("return").getJSONArray("licenses");
      List localList = paramResult.getSignedLicenseData();
      paramResult = paramResult.getLicenseSignatures();
      int i = 0;
      while (i < localJSONArray.length())
      {
        localArrayList.add(getLicenseInternal(localJSONArray.getJSONObject(i).getInt("key_index"), (String)localList.get(i), (String)paramResult.get(i)));
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramResult)
    {
      throw new GetjarException(paramResult);
    }
  }
  
  private ArrayList<LicenseInternal> getUnmanagedProductLicensesInternal(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      throw new IllegalArgumentException("itemIds cannot be null or empty");
    }
    Logger.i(Area.LICENSING.value(), "LicenseEngine -- getUnmanagedProductLicensesInternal started", new Object[0]);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      GetjarLicense.Scope[] arrayOfScope = GetjarLicense.Scope.values();
      int j = arrayOfScope.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfScope[i];
        localObject = getLicenseCachingManager().getValidCachedLicense(str, (GetjarLicense.Scope)localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static void initialize(CommContext paramCommContext)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' can not be NULL");
    }
    if (_Instance == null) {
      synchronized (_InstanceLock)
      {
        if (_Instance == null)
        {
          _Instance = new LicenseEngine(paramCommContext);
          _Instance.getLicenseCachingManager();
        }
        return;
      }
    }
  }
  
  private void resetServiceRequestThrottleTimestamp()
  {
    SharedPreferences.Editor localEditor = this._commContext.getApplicationContext().getSharedPreferences("GetJarClientPrefs", 0).edit();
    localEditor.remove("licenseCheckTimestamp").commit();
    localEditor.commit();
  }
  
  /* Error */
  private List<GetjarLicense> retrieveServerProductLicensesInternal(boolean paramBoolean)
    throws InterruptedException
  {
    // Byte code:
    //   0: getstatic 152	com/getjar/sdk/logging/Area:LICENSING	Lcom/getjar/sdk/logging/Area;
    //   3: invokevirtual 156	com/getjar/sdk/logging/Area:value	()J
    //   6: ldc_w 354
    //   9: iconst_0
    //   10: anewarray 4	java/lang/Object
    //   13: invokestatic 164	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   16: new 231	java/util/ArrayList
    //   19: dup
    //   20: invokespecial 232	java/util/ArrayList:<init>	()V
    //   23: astore 18
    //   25: aload_0
    //   26: getfield 92	com/getjar/sdk/data/LicenseEngine:_claimsManager	Lcom/getjar/sdk/comm/auth/ClaimsManager;
    //   29: invokevirtual 359	com/getjar/sdk/comm/auth/ClaimsManager:canUseUnmanagedLicenses	()Z
    //   32: ifeq +828 -> 860
    //   35: aload_0
    //   36: getfield 70	com/getjar/sdk/data/LicenseEngine:_commContext	Lcom/getjar/sdk/comm/CommContext;
    //   39: invokevirtual 76	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
    //   42: ldc_w 327
    //   45: iconst_0
    //   46: invokevirtual 333	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   49: astore 19
    //   51: aload 19
    //   53: ldc 15
    //   55: lconst_0
    //   56: invokeinterface 363 4 0
    //   61: lstore 6
    //   63: invokestatic 368	java/lang/System:currentTimeMillis	()J
    //   66: ldc2_w 369
    //   69: ldiv
    //   70: lstore 8
    //   72: aload_0
    //   73: getfield 70	com/getjar/sdk/data/LicenseEngine:_commContext	Lcom/getjar/sdk/comm/CommContext;
    //   76: iconst_0
    //   77: invokestatic 375	com/getjar/sdk/config/GetJarConfig:getInstance	(Lcom/getjar/sdk/comm/CommContext;Z)Lcom/getjar/sdk/config/GetJarConfig;
    //   80: ldc_w 377
    //   83: getstatic 383	com/getjar/sdk/config/SettingsManager$Scope:CLIENT	Lcom/getjar/sdk/config/SettingsManager$Scope;
    //   86: invokevirtual 387	com/getjar/sdk/config/GetJarConfig:getDirectiveValue	(Ljava/lang/String;Lcom/getjar/sdk/config/SettingsManager$Scope;)Ljava/lang/String;
    //   89: invokestatic 393	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   92: invokevirtual 396	java/lang/Long:longValue	()J
    //   95: lstore_2
    //   96: aload_0
    //   97: getfield 70	com/getjar/sdk/data/LicenseEngine:_commContext	Lcom/getjar/sdk/comm/CommContext;
    //   100: iconst_0
    //   101: invokestatic 375	com/getjar/sdk/config/GetJarConfig:getInstance	(Lcom/getjar/sdk/comm/CommContext;Z)Lcom/getjar/sdk/config/GetJarConfig;
    //   104: ldc_w 398
    //   107: getstatic 383	com/getjar/sdk/config/SettingsManager$Scope:CLIENT	Lcom/getjar/sdk/config/SettingsManager$Scope;
    //   110: invokevirtual 387	com/getjar/sdk/config/GetJarConfig:getDirectiveValue	(Ljava/lang/String;Lcom/getjar/sdk/config/SettingsManager$Scope;)Ljava/lang/String;
    //   113: invokestatic 393	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   116: invokevirtual 396	java/lang/Long:longValue	()J
    //   119: lstore 4
    //   121: aload_0
    //   122: invokespecial 116	com/getjar/sdk/data/LicenseEngine:getLicenseCachingManager	()Lcom/getjar/sdk/comm/LicenseCachingManager;
    //   125: invokevirtual 401	com/getjar/sdk/comm/LicenseCachingManager:hasExpiredEntry	()Z
    //   128: ifne +28 -> 156
    //   131: lload 8
    //   133: lload 6
    //   135: lsub
    //   136: lload_2
    //   137: lcmp
    //   138: ifgt +18 -> 156
    //   141: iload_1
    //   142: ifeq +686 -> 828
    //   145: lload 8
    //   147: lload 6
    //   149: lsub
    //   150: lload 4
    //   152: lcmp
    //   153: ifle +675 -> 828
    //   156: aload_0
    //   157: invokespecial 116	com/getjar/sdk/data/LicenseEngine:getLicenseCachingManager	()Lcom/getjar/sdk/comm/LicenseCachingManager;
    //   160: invokevirtual 405	com/getjar/sdk/comm/LicenseCachingManager:getAllLicenses	()Lcom/getjar/sdk/comm/LicenseCachingManager$LicensesWithETag;
    //   163: astore 20
    //   165: new 231	java/util/ArrayList
    //   168: dup
    //   169: invokespecial 232	java/util/ArrayList:<init>	()V
    //   172: astore 14
    //   174: aconst_null
    //   175: astore 17
    //   177: aconst_null
    //   178: astore 15
    //   180: aconst_null
    //   181: astore 16
    //   183: invokestatic 410	com/getjar/sdk/comm/LicenseServiceProxy:getInstance	()Lcom/getjar/sdk/comm/LicenseServiceProxy;
    //   186: aload_0
    //   187: getfield 70	com/getjar/sdk/data/LicenseEngine:_commContext	Lcom/getjar/sdk/comm/CommContext;
    //   190: aconst_null
    //   191: aload 17
    //   193: bipush 50
    //   195: aload 20
    //   197: getfield 415	com/getjar/sdk/comm/LicenseCachingManager$LicensesWithETag:eTag	Ljava/lang/String;
    //   200: invokevirtual 419	com/getjar/sdk/comm/LicenseServiceProxy:getUnmanagedProductLicenses	(Lcom/getjar/sdk/comm/CommContext;Lcom/getjar/sdk/GetjarLicense$Scope;Ljava/lang/String;ILjava/lang/String;)Lcom/getjar/sdk/comm/Operation;
    //   203: astore 10
    //   205: aconst_null
    //   206: astore 11
    //   208: aload 10
    //   210: invokevirtual 424	com/getjar/sdk/comm/Operation:get	()Lcom/getjar/sdk/comm/Result;
    //   213: astore 17
    //   215: aload 15
    //   217: astore 12
    //   219: aload 15
    //   221: ifnonnull +10 -> 231
    //   224: aload 10
    //   226: invokestatic 430	com/getjar/sdk/comm/ResultCachingManager:getTtlFromResult	(Lcom/getjar/sdk/comm/Operation;)Ljava/lang/Long;
    //   229: astore 12
    //   231: aload 16
    //   233: astore 13
    //   235: aload 16
    //   237: invokestatic 178	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   240: ifeq +10 -> 250
    //   243: aload 10
    //   245: invokestatic 434	com/getjar/sdk/comm/ResultCachingManager:getETagFromResult	(Lcom/getjar/sdk/comm/Operation;)Ljava/lang/String;
    //   248: astore 13
    //   250: aload 17
    //   252: ifnull +418 -> 670
    //   255: aload 17
    //   257: invokevirtual 437	com/getjar/sdk/comm/Result:isSuccessfulResponse	()Z
    //   260: ifeq +363 -> 623
    //   263: aload_0
    //   264: aload 17
    //   266: invokespecial 439	com/getjar/sdk/data/LicenseEngine:getLicensesFromResult	(Lcom/getjar/sdk/comm/Result;)Ljava/util/ArrayList;
    //   269: astore 10
    //   271: getstatic 152	com/getjar/sdk/logging/Area:LICENSING	Lcom/getjar/sdk/logging/Area;
    //   274: invokevirtual 156	com/getjar/sdk/logging/Area:value	()J
    //   277: ldc_w 441
    //   280: iconst_1
    //   281: anewarray 4	java/lang/Object
    //   284: dup
    //   285: iconst_0
    //   286: aload 10
    //   288: invokevirtual 442	java/util/ArrayList:size	()I
    //   291: invokestatic 447	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   294: aastore
    //   295: invokestatic 164	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   298: aload 17
    //   300: invokevirtual 238	com/getjar/sdk/comm/Result:getResponseJson	()Lorg/json/JSONObject;
    //   303: ldc -16
    //   305: invokevirtual 244	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   308: ldc_w 449
    //   311: invokevirtual 204	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   314: astore 11
    //   316: aload 14
    //   318: invokevirtual 452	java/util/ArrayList:isEmpty	()Z
    //   321: ifeq +287 -> 608
    //   324: aload 11
    //   326: invokestatic 178	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   329: ifne +30 -> 359
    //   332: aload 11
    //   334: astore 17
    //   336: aload 13
    //   338: astore 16
    //   340: aload 10
    //   342: astore 14
    //   344: aload 12
    //   346: astore 15
    //   348: aload 11
    //   350: ldc_w 454
    //   353: invokevirtual 457	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   356: ifeq -173 -> 183
    //   359: aload 10
    //   361: ifnull +422 -> 783
    //   364: aload 10
    //   366: invokevirtual 452	java/util/ArrayList:isEmpty	()Z
    //   369: ifne +414 -> 783
    //   372: getstatic 152	com/getjar/sdk/logging/Area:LICENSING	Lcom/getjar/sdk/logging/Area;
    //   375: invokevirtual 156	com/getjar/sdk/logging/Area:value	()J
    //   378: new 459	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   385: ldc_w 462
    //   388: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload 10
    //   393: invokevirtual 442	java/util/ArrayList:size	()I
    //   396: invokevirtual 469	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   399: invokevirtual 473	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: iconst_0
    //   403: anewarray 4	java/lang/Object
    //   406: invokestatic 164	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   409: new 475	java/util/HashSet
    //   412: dup
    //   413: invokespecial 476	java/util/HashSet:<init>	()V
    //   416: astore 11
    //   418: aload 10
    //   420: invokevirtual 477	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   423: astore 10
    //   425: aload 10
    //   427: invokeinterface 309 1 0
    //   432: ifeq +261 -> 693
    //   435: aload 10
    //   437: invokeinterface 313 1 0
    //   442: checkcast 210	com/getjar/sdk/data/LicenseInternal
    //   445: astore 14
    //   447: aload 11
    //   449: new 197	org/json/JSONObject
    //   452: dup
    //   453: aload 14
    //   455: invokevirtual 479	com/getjar/sdk/data/LicenseInternal:getSignedLicenseData	()Ljava/lang/String;
    //   458: invokespecial 198	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   461: ldc_w 481
    //   464: invokevirtual 204	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   467: invokevirtual 482	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   470: pop
    //   471: aload_0
    //   472: invokespecial 116	com/getjar/sdk/data/LicenseEngine:getLicenseCachingManager	()Lcom/getjar/sdk/comm/LicenseCachingManager;
    //   475: aload 14
    //   477: aload 12
    //   479: aload 13
    //   481: invokevirtual 486	com/getjar/sdk/comm/LicenseCachingManager:addLicenseToCache	(Lcom/getjar/sdk/data/LicenseInternal;Ljava/lang/Long;Ljava/lang/String;)Z
    //   484: ifeq -59 -> 425
    //   487: aload 18
    //   489: aload 14
    //   491: invokeinterface 487 2 0
    //   496: pop
    //   497: goto -72 -> 425
    //   500: astore 10
    //   502: new 137	java/lang/IllegalStateException
    //   505: dup
    //   506: ldc_w 489
    //   509: aload 10
    //   511: invokespecial 492	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   514: athrow
    //   515: astore 10
    //   517: getstatic 152	com/getjar/sdk/logging/Area:LICENSING	Lcom/getjar/sdk/logging/Area;
    //   520: invokevirtual 156	com/getjar/sdk/logging/Area:value	()J
    //   523: aload 10
    //   525: ldc_w 494
    //   528: iconst_0
    //   529: anewarray 4	java/lang/Object
    //   532: invokestatic 498	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   535: ldc2_w 499
    //   538: lstore_2
    //   539: goto -443 -> 96
    //   542: astore 10
    //   544: getstatic 152	com/getjar/sdk/logging/Area:LICENSING	Lcom/getjar/sdk/logging/Area;
    //   547: invokevirtual 156	com/getjar/sdk/logging/Area:value	()J
    //   550: aload 10
    //   552: ldc_w 494
    //   555: iconst_0
    //   556: anewarray 4	java/lang/Object
    //   559: invokestatic 498	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   562: ldc2_w 501
    //   565: lstore 4
    //   567: goto -446 -> 121
    //   570: astore 10
    //   572: new 504	com/getjar/sdk/exceptions/CommunicationException
    //   575: dup
    //   576: aload 10
    //   578: invokespecial 505	com/getjar/sdk/exceptions/CommunicationException:<init>	(Ljava/lang/Throwable;)V
    //   581: athrow
    //   582: astore 15
    //   584: aconst_null
    //   585: astore 11
    //   587: getstatic 152	com/getjar/sdk/logging/Area:LICENSING	Lcom/getjar/sdk/logging/Area;
    //   590: invokevirtual 156	com/getjar/sdk/logging/Area:value	()J
    //   593: aload 15
    //   595: ldc_w 507
    //   598: iconst_0
    //   599: anewarray 4	java/lang/Object
    //   602: invokestatic 509	com/getjar/sdk/logging/Logger:d	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   605: goto -289 -> 316
    //   608: aload 14
    //   610: aload 10
    //   612: invokevirtual 513	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   615: pop
    //   616: aload 14
    //   618: astore 10
    //   620: goto -296 -> 324
    //   623: aload 17
    //   625: invokevirtual 516	com/getjar/sdk/comm/Result:getResponseCode	()I
    //   628: sipush 304
    //   631: if_icmpne +16 -> 647
    //   634: aload 20
    //   636: getfield 519	com/getjar/sdk/comm/LicenseCachingManager$LicensesWithETag:licenses	Ljava/util/List;
    //   639: checkcast 231	java/util/ArrayList
    //   642: astore 10
    //   644: goto -320 -> 324
    //   647: getstatic 152	com/getjar/sdk/logging/Area:LICENSING	Lcom/getjar/sdk/logging/Area;
    //   650: invokevirtual 156	com/getjar/sdk/logging/Area:value	()J
    //   653: ldc_w 521
    //   656: iconst_0
    //   657: anewarray 4	java/lang/Object
    //   660: invokestatic 523	com/getjar/sdk/logging/Logger:e	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   663: aload 14
    //   665: astore 10
    //   667: goto -343 -> 324
    //   670: getstatic 152	com/getjar/sdk/logging/Area:LICENSING	Lcom/getjar/sdk/logging/Area;
    //   673: invokevirtual 156	com/getjar/sdk/logging/Area:value	()J
    //   676: ldc_w 525
    //   679: iconst_0
    //   680: anewarray 4	java/lang/Object
    //   683: invokestatic 164	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   686: aload 14
    //   688: astore 10
    //   690: goto -366 -> 324
    //   693: aload_0
    //   694: invokespecial 116	com/getjar/sdk/data/LicenseEngine:getLicenseCachingManager	()Lcom/getjar/sdk/comm/LicenseCachingManager;
    //   697: invokevirtual 405	com/getjar/sdk/comm/LicenseCachingManager:getAllLicenses	()Lcom/getjar/sdk/comm/LicenseCachingManager$LicensesWithETag;
    //   700: getfield 519	com/getjar/sdk/comm/LicenseCachingManager$LicensesWithETag:licenses	Ljava/util/List;
    //   703: invokeinterface 304 1 0
    //   708: astore 10
    //   710: aload 10
    //   712: invokeinterface 309 1 0
    //   717: ifeq +82 -> 799
    //   720: aload 10
    //   722: invokeinterface 313 1 0
    //   727: checkcast 210	com/getjar/sdk/data/LicenseInternal
    //   730: astore 12
    //   732: aload 11
    //   734: new 197	org/json/JSONObject
    //   737: dup
    //   738: aload 12
    //   740: invokevirtual 479	com/getjar/sdk/data/LicenseInternal:getSignedLicenseData	()Ljava/lang/String;
    //   743: invokespecial 198	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   746: ldc_w 481
    //   749: invokevirtual 204	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   752: invokevirtual 528	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   755: ifne -45 -> 710
    //   758: aload_0
    //   759: invokespecial 116	com/getjar/sdk/data/LicenseEngine:getLicenseCachingManager	()Lcom/getjar/sdk/comm/LicenseCachingManager;
    //   762: aload 12
    //   764: invokevirtual 532	com/getjar/sdk/comm/LicenseCachingManager:removeCachedLicense	(Lcom/getjar/sdk/data/LicenseInternal;)V
    //   767: goto -57 -> 710
    //   770: astore 10
    //   772: new 63	java/lang/IllegalArgumentException
    //   775: dup
    //   776: ldc_w 534
    //   779: invokespecial 68	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   782: athrow
    //   783: getstatic 152	com/getjar/sdk/logging/Area:LICENSING	Lcom/getjar/sdk/logging/Area;
    //   786: invokevirtual 156	com/getjar/sdk/logging/Area:value	()J
    //   789: ldc_w 536
    //   792: iconst_0
    //   793: anewarray 4	java/lang/Object
    //   796: invokestatic 164	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   799: aload 19
    //   801: invokeinterface 339 1 0
    //   806: astore 10
    //   808: aload 10
    //   810: ldc 15
    //   812: lload 8
    //   814: invokeinterface 540 4 0
    //   819: pop
    //   820: aload 10
    //   822: invokeinterface 348 1 0
    //   827: pop
    //   828: getstatic 152	com/getjar/sdk/logging/Area:LICENSING	Lcom/getjar/sdk/logging/Area;
    //   831: invokevirtual 156	com/getjar/sdk/logging/Area:value	()J
    //   834: ldc_w 542
    //   837: iconst_1
    //   838: anewarray 4	java/lang/Object
    //   841: dup
    //   842: iconst_0
    //   843: aload 18
    //   845: invokeinterface 293 1 0
    //   850: invokestatic 447	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   853: aastore
    //   854: invokestatic 164	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   857: aload 18
    //   859: areturn
    //   860: getstatic 152	com/getjar/sdk/logging/Area:LICENSING	Lcom/getjar/sdk/logging/Area;
    //   863: invokevirtual 156	com/getjar/sdk/logging/Area:value	()J
    //   866: ldc_w 544
    //   869: iconst_0
    //   870: anewarray 4	java/lang/Object
    //   873: invokestatic 523	com/getjar/sdk/logging/Logger:e	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   876: goto -48 -> 828
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	879	0	this	LicenseEngine
    //   0	879	1	paramBoolean	boolean
    //   95	444	2	l1	long
    //   119	447	4	l2	long
    //   61	87	6	l3	long
    //   70	743	8	l4	long
    //   203	233	10	localObject1	Object
    //   500	10	10	localJSONException1	JSONException
    //   515	9	10	localNumberFormatException1	NumberFormatException
    //   542	9	10	localNumberFormatException2	NumberFormatException
    //   570	41	10	localExecutionException	java.util.concurrent.ExecutionException
    //   618	103	10	localObject2	Object
    //   770	1	10	localJSONException2	JSONException
    //   806	15	10	localEditor	SharedPreferences.Editor
    //   206	527	11	localObject3	Object
    //   217	546	12	localObject4	Object
    //   233	247	13	localObject5	Object
    //   172	515	14	localObject6	Object
    //   178	169	15	localObject7	Object
    //   582	12	15	localJSONException3	JSONException
    //   181	158	16	localObject8	Object
    //   175	449	17	localObject9	Object
    //   23	835	18	localArrayList	ArrayList
    //   49	751	19	localSharedPreferences	SharedPreferences
    //   163	472	20	localLicensesWithETag	LicenseCachingManager.LicensesWithETag
    // Exception table:
    //   from	to	target	type
    //   447	497	500	org/json/JSONException
    //   72	96	515	java/lang/NumberFormatException
    //   96	121	542	java/lang/NumberFormatException
    //   208	215	570	java/util/concurrent/ExecutionException
    //   298	316	582	org/json/JSONException
    //   732	767	770	org/json/JSONException
  }
  
  public ArrayList<LicenseInternal> getLicenses()
    throws InterruptedException
  {
    retrieveServerProductLicenses(true);
    synchronized (this._retrieveLock)
    {
      ArrayList localArrayList = new ArrayList(getLicenseCachingManager().getAllLicenses().licenses);
      return localArrayList;
    }
  }
  
  public ArrayList<LicenseInternal> getLicenses(List<String> paramList)
    throws InterruptedException
  {
    Logger.i(Area.LICENSING.value(), "LicenseEngine -- getUnmanagedProductLicenses started", new Object[0]);
    if (this._claimsManager.canUseUnmanagedLicenses()) {
      synchronized (this._retrieveLock)
      {
        ArrayList localArrayList2 = getUnmanagedProductLicensesInternal(paramList);
        ArrayList localArrayList1 = localArrayList2;
        if (localArrayList2.isEmpty())
        {
          retrieveServerProductLicenses(true);
          localArrayList1 = getUnmanagedProductLicensesInternal(paramList);
        }
        return localArrayList1;
      }
    }
    Logger.e(Area.LICENSING.value(), "LicenseEngine getUnmanagedProductLicenses Not having required claims!!", new Object[0]);
    return null;
  }
  
  public void getLicenses(List<String> paramList, OnGetjarLicensesReceivedListener paramOnGetjarLicensesReceivedListener)
  {
    if (paramOnGetjarLicensesReceivedListener == null) {
      throw new IllegalArgumentException("licensingListener cannot be null");
    }
    Logger.i(Area.LICENSING.value(), "LicenseEngine getLicenses started", new Object[0]);
    paramList = new SetExceptionFutureTask(new GetLicensesCallable(paramList, paramOnGetjarLicensesReceivedListener));
    this._executorService.execute(paramList);
  }
  
  public List<GetjarLicense> retrieveServerProductLicenses(boolean paramBoolean)
    throws InterruptedException
  {
    synchronized (this._retrieveLock)
    {
      List localList = retrieveServerProductLicensesInternal(paramBoolean);
      return localList;
    }
  }
  
  /* Error */
  public LicenseInternal updateLicenseState(Result arg1)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_2
    //   6: astore_3
    //   7: aload_1
    //   8: ifnull +141 -> 149
    //   11: aload_2
    //   12: astore_3
    //   13: aload_1
    //   14: invokevirtual 238	com/getjar/sdk/comm/Result:getResponseJson	()Lorg/json/JSONObject;
    //   17: ifnull +132 -> 149
    //   20: aload_2
    //   21: astore_3
    //   22: aload_0
    //   23: getfield 92	com/getjar/sdk/data/LicenseEngine:_claimsManager	Lcom/getjar/sdk/comm/auth/ClaimsManager;
    //   26: invokevirtual 585	com/getjar/sdk/comm/auth/ClaimsManager:canModifyUnmanagedLicenses	()Z
    //   29: ifeq +120 -> 149
    //   32: aload_1
    //   33: invokestatic 588	com/getjar/sdk/comm/ResultCachingManager:getETagFromResult	(Lcom/getjar/sdk/comm/Result;)Ljava/lang/String;
    //   36: astore 5
    //   38: aload_1
    //   39: invokestatic 591	com/getjar/sdk/comm/ResultCachingManager:getTtlFromResult	(Lcom/getjar/sdk/comm/Result;)Ljava/lang/Long;
    //   42: astore 6
    //   44: aload 4
    //   46: astore_2
    //   47: aload_1
    //   48: invokevirtual 238	com/getjar/sdk/comm/Result:getResponseJson	()Lorg/json/JSONObject;
    //   51: ldc -16
    //   53: invokevirtual 594	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   56: ifeq +63 -> 119
    //   59: aload_1
    //   60: invokevirtual 238	com/getjar/sdk/comm/Result:getResponseJson	()Lorg/json/JSONObject;
    //   63: ldc -16
    //   65: invokevirtual 244	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   68: astore_3
    //   69: aload 4
    //   71: astore_2
    //   72: aload_3
    //   73: ldc_w 596
    //   76: invokevirtual 594	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   79: ifeq +40 -> 119
    //   82: aload_3
    //   83: ldc_w 268
    //   86: invokevirtual 272	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   89: aload_1
    //   90: invokevirtual 254	com/getjar/sdk/comm/Result:getSignedLicenseData	()Ljava/util/List;
    //   93: iconst_0
    //   94: invokeinterface 278 2 0
    //   99: checkcast 280	java/lang/String
    //   102: aload_1
    //   103: invokevirtual 257	com/getjar/sdk/comm/Result:getLicenseSignatures	()Ljava/util/List;
    //   106: iconst_0
    //   107: invokeinterface 278 2 0
    //   112: checkcast 280	java/lang/String
    //   115: invokestatic 282	com/getjar/sdk/data/LicenseEngine:getLicenseInternal	(ILjava/lang/String;Ljava/lang/String;)Lcom/getjar/sdk/data/LicenseInternal;
    //   118: astore_2
    //   119: aload_2
    //   120: astore_3
    //   121: aload_2
    //   122: ifnull +27 -> 149
    //   125: aload_0
    //   126: getfield 48	com/getjar/sdk/data/LicenseEngine:_retrieveLock	Ljava/lang/Object;
    //   129: astore_1
    //   130: aload_1
    //   131: monitorenter
    //   132: aload_0
    //   133: invokespecial 116	com/getjar/sdk/data/LicenseEngine:getLicenseCachingManager	()Lcom/getjar/sdk/comm/LicenseCachingManager;
    //   136: aload_2
    //   137: aload 6
    //   139: aload 5
    //   141: invokevirtual 486	com/getjar/sdk/comm/LicenseCachingManager:addLicenseToCache	(Lcom/getjar/sdk/data/LicenseInternal;Ljava/lang/Long;Ljava/lang/String;)Z
    //   144: pop
    //   145: aload_1
    //   146: monitorexit
    //   147: aload_2
    //   148: astore_3
    //   149: aload_3
    //   150: areturn
    //   151: astore_1
    //   152: getstatic 152	com/getjar/sdk/logging/Area:LICENSING	Lcom/getjar/sdk/logging/Area;
    //   155: invokevirtual 156	com/getjar/sdk/logging/Area:value	()J
    //   158: ldc_w 598
    //   161: iconst_0
    //   162: anewarray 4	java/lang/Object
    //   165: invokestatic 601	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   168: aload 4
    //   170: astore_2
    //   171: goto -52 -> 119
    //   174: astore_2
    //   175: aload_1
    //   176: monitorexit
    //   177: aload_2
    //   178: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	LicenseEngine
    //   1	170	2	localObject1	Object
    //   174	4	2	localObject2	Object
    //   6	144	3	localObject3	Object
    //   3	166	4	localObject4	Object
    //   36	104	5	str	String
    //   42	96	6	localLong	Long
    // Exception table:
    //   from	to	target	type
    //   47	69	151	org/json/JSONException
    //   72	119	151	org/json/JSONException
    //   132	147	174	finally
    //   175	177	174	finally
  }
  
  private class GetLicensesCallable
    implements Callable<Void>
  {
    private final List<String> developerProductIDs;
    private OnGetjarLicensesReceivedListener licensingListener = null;
    
    public GetLicensesCallable(OnGetjarLicensesReceivedListener paramOnGetjarLicensesReceivedListener)
    {
      OnGetjarLicensesReceivedListener localOnGetjarLicensesReceivedListener;
      if (localOnGetjarLicensesReceivedListener == null) {
        throw new IllegalArgumentException("licensingListener cannot be null");
      }
      this.developerProductIDs = paramOnGetjarLicensesReceivedListener;
      this.licensingListener = localOnGetjarLicensesReceivedListener;
    }
    
    public Void call()
      throws Exception
    {
      int k = 0;
      int j = 0;
      int i = j;
      try
      {
        if (this.developerProductIDs != null)
        {
          i = j;
          if (!this.developerProductIDs.isEmpty()) {
            break label177;
          }
        }
        i = j;
        Logger.v(Area.LICENSING.value(), "LicenseEngine GetLicensesCallable getting all licenses", new Object[0]);
        i = j;
        localObject = LicenseEngine.this.getLicenses();
      }
      catch (Exception localException1)
      {
        Object localObject;
        ArrayList localArrayList2;
        Logger.e(Area.LICENSING.value(), localException1, "LicenseEngine: Unknown failure", new Object[0]);
        if (i != 0) {
          break label175;
        }
        do
        {
          try
          {
            this.licensingListener.onLicensesReceived(1, null);
            return null;
          }
          catch (Exception localException3)
          {
            ArrayList localArrayList1;
            Logger.e(Area.LICENSING.value(), localException3, "OnGetjarLicensesReceivedListener.onLicensesReceived failed to handle callback properly.", new Object[0]);
          }
          i = j;
          Logger.v(Area.LICENSING.value(), "LicenseEngine GetLicensesCallable getting licenses for provided productIDs", new Object[0]);
          i = j;
          localArrayList1 = LicenseEngine.this.getLicenses(this.developerProductIDs);
          break;
          i = j;
        } while (this.licensingListener == null);
        i = j;
        Logger.v(Area.LICENSING.value(), "LicenseEngine GetLicensesCallable sending callback", new Object[0]);
        try
        {
          this.licensingListener.onLicensesReceived(0, localArrayList2);
          i = 1;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            i = j;
            Logger.e(Area.LICENSING.value(), localException2, "OnGetjarLicensesReceivedListener.onLicensesReceived failed to handle callback properly.", new Object[0]);
            i = k;
          }
        }
        Logger.v(Area.LICENSING.value(), "LicenseEngine GetLicensesCallable callback sent", new Object[0]);
        return null;
      }
      i = j;
      Logger.v(Area.LICENSING.value(), "LicenseEngine GetLicensesCallable got %1$d licenses", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
      i = j;
      localArrayList2 = new ArrayList(((ArrayList)localObject).size());
      i = j;
      localObject = ((ArrayList)localObject).iterator();
      for (;;)
      {
        i = j;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        i = j;
        localArrayList2.add((LicenseInternal)((Iterator)localObject).next());
      }
      label175:
      label177:
      return null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/LicenseEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */