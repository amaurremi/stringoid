package com.getjar.sdk.comm.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.data.DeviceMetadata;
import com.getjar.sdk.data.MetadataValue;
import com.getjar.sdk.data.MetadataValue.MetadataReliability;
import com.getjar.sdk.data.cache.BasicCache;
import com.getjar.sdk.data.cache.CacheEntry;
import com.getjar.sdk.exceptions.AuthException;
import com.getjar.sdk.exceptions.CachingException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.Base64;
import com.getjar.sdk.utilities.CryptoUtility;
import com.getjar.sdk.utilities.ScreenUtility;
import com.getjar.sdk.utilities.StringUtility;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class AndroidAccountUserAuthProvider
  implements UserAuthProvider
{
  public static final String KeyProviderHintUsernameDataHash = "android_account.username_data_hash";
  public static final String KeySkipCacheFlag = "provider.skip_cache";
  private static final String _CacheName = "androidAccountUserAuthCache";
  private static final String _KeyProviderDataName = "android.account.name";
  private static final String _KeyProviderDataType = "android.account.type";
  private static final String _KeyUserAuthProviderAndData = "userAuthProviderAndData";
  private final AndroidAccountResolver _accountResolver = new AndroidAccountResolver(null);
  
  /* Error */
  public static String getAccountNameFromHash(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   3: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   6: ldc 76
    //   8: iconst_0
    //   9: anewarray 4	java/lang/Object
    //   12: invokestatic 82	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   15: aload_0
    //   16: ifnonnull +13 -> 29
    //   19: new 84	java/lang/IllegalArgumentException
    //   22: dup
    //   23: ldc 86
    //   25: invokespecial 89	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   28: athrow
    //   29: aload_1
    //   30: invokestatic 95	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   33: ifeq +20 -> 53
    //   36: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   39: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   42: ldc 97
    //   44: iconst_0
    //   45: anewarray 4	java/lang/Object
    //   48: invokestatic 100	com/getjar/sdk/logging/Logger:w	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   51: aconst_null
    //   52: areturn
    //   53: aconst_null
    //   54: astore 4
    //   56: aload_0
    //   57: invokestatic 106	android/accounts/AccountManager:get	(Landroid/content/Context;)Landroid/accounts/AccountManager;
    //   60: ldc 108
    //   62: invokevirtual 112	android/accounts/AccountManager:getAccountsByType	(Ljava/lang/String;)[Landroid/accounts/Account;
    //   65: astore 5
    //   67: aload 4
    //   69: astore_0
    //   70: aload 5
    //   72: ifnull +65 -> 137
    //   75: iconst_0
    //   76: istore_2
    //   77: aload 4
    //   79: astore_0
    //   80: iload_2
    //   81: aload 5
    //   83: arraylength
    //   84: if_icmpge +53 -> 137
    //   87: aload 5
    //   89: iload_2
    //   90: aaload
    //   91: ifnull +127 -> 218
    //   94: aload 5
    //   96: iload_2
    //   97: aaload
    //   98: getfield 117	android/accounts/Account:name	Ljava/lang/String;
    //   101: invokestatic 95	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   104: ifeq +6 -> 110
    //   107: goto +111 -> 218
    //   110: aload 5
    //   112: iload_2
    //   113: aaload
    //   114: getfield 117	android/accounts/Account:name	Ljava/lang/String;
    //   117: getstatic 123	java/util/Locale:US	Ljava/util/Locale;
    //   120: invokevirtual 129	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   123: astore_0
    //   124: aload_0
    //   125: invokestatic 135	com/getjar/sdk/utilities/CryptoUtility:getSHA256	(Ljava/lang/String;)Ljava/lang/String;
    //   128: aload_1
    //   129: invokevirtual 138	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   132: istore_3
    //   133: iload_3
    //   134: ifeq +84 -> 218
    //   137: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   140: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   143: ldc -116
    //   145: iconst_1
    //   146: anewarray 4	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload_0
    //   152: aastore
    //   153: invokestatic 82	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   156: aload_0
    //   157: areturn
    //   158: astore_0
    //   159: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   162: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   165: aload_0
    //   166: ldc -114
    //   168: iconst_0
    //   169: anewarray 4	java/lang/Object
    //   172: invokestatic 146	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   178: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   181: ldc -116
    //   183: iconst_1
    //   184: anewarray 4	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aconst_null
    //   190: aastore
    //   191: invokestatic 82	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   194: aconst_null
    //   195: areturn
    //   196: astore_0
    //   197: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   200: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   203: ldc -116
    //   205: iconst_1
    //   206: anewarray 4	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: aconst_null
    //   212: aastore
    //   213: invokestatic 82	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   216: aload_0
    //   217: athrow
    //   218: iload_2
    //   219: iconst_1
    //   220: iadd
    //   221: istore_2
    //   222: goto -145 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramContext	Context
    //   0	225	1	paramString	String
    //   76	146	2	i	int
    //   132	2	3	bool	boolean
    //   54	24	4	localObject	Object
    //   65	46	5	arrayOfAccount	Account[]
    // Exception table:
    //   from	to	target	type
    //   56	67	158	java/lang/Exception
    //   80	87	158	java/lang/Exception
    //   94	107	158	java/lang/Exception
    //   110	133	158	java/lang/Exception
    //   56	67	196	finally
    //   80	87	196	finally
    //   94	107	196	finally
    //   110	133	196	finally
    //   159	175	196	finally
  }
  
  public static CharSequence[] getAndroidAccountNames(Context paramContext)
  {
    Account[] arrayOfAccount = getAndroidAccounts(paramContext);
    paramContext = null;
    if (arrayOfAccount != null)
    {
      CharSequence[] arrayOfCharSequence = new CharSequence[arrayOfAccount.length];
      int i = 0;
      paramContext = arrayOfCharSequence;
      if (i < arrayOfAccount.length)
      {
        if ((arrayOfAccount[i] == null) || (StringUtility.isNullOrEmpty(arrayOfAccount[i].name))) {}
        for (;;)
        {
          i += 1;
          break;
          arrayOfCharSequence[i] = arrayOfAccount[i].name;
        }
      }
    }
    return paramContext;
  }
  
  public static Account[] getAndroidAccounts(Context paramContext)
  {
    return AccountManager.get(paramContext).getAccountsByType("com.google");
  }
  
  private Map<String, MetadataValue> getProviderData(CommContext paramCommContext, AuthUIParentInterface paramAuthUIParentInterface, ProviderHint paramProviderHint)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' cannot be NULL");
    }
    validateProviderHint(paramProviderHint);
    Object localObject1 = paramCommContext.getDeviceMetadata().getMetadataWithReliability();
    if ((localObject1 == null) || (((Map)localObject1).size() <= 0))
    {
      Logger.w(Area.AUTH.value(), "AuthFlow: AndroidAccountUserAuthProvider: getProviderData() failed to get device metadata", new Object[0]);
      return null;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.putAll((Map)localObject1);
    localObject1 = null;
    Object localObject3;
    if (paramProviderHint != null)
    {
      localObject2 = localObject1;
      if (isProviderHintForMe(paramProviderHint))
      {
        localObject2 = localObject1;
        if (paramProviderHint.getData().containsKey("provider.skip_cache")) {}
      }
    }
    else
    {
      localObject3 = getUserAuthProviderAndData(paramCommContext.getApplicationContext());
      localObject2 = localObject1;
      if (validateUserAuthProviderAndDataCacheEntry((UserAuthProviderAndDataCacheEntry)localObject3)) {
        localObject2 = (String)((UserAuthProviderAndDataCacheEntry)localObject3).getCachedProviderData().get("android.account.name");
      }
    }
    localObject1 = null;
    if (!StringUtility.isNullOrEmpty((String)localObject2))
    {
      localObject3 = this._accountResolver.getAndroidAccountFromName((String)localObject2, paramCommContext);
      localObject1 = localObject3;
      if (localObject3 != null)
      {
        Logger.d(Area.AUTH.value(), "AuthFlow: AndroidAccountUserAuthProvider: getProviderData() [account:'%1$s'] [source:cache]", new Object[] { localObject2 });
        localObject1 = localObject3;
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (isProviderHintForMe(paramProviderHint))
      {
        localObject3 = this._accountResolver.getAndroidAccountNameViaHint(paramCommContext, paramProviderHint);
        localObject2 = localObject1;
        if (!StringUtility.isNullOrEmpty((String)localObject3))
        {
          paramProviderHint = this._accountResolver.getAndroidAccountFromName((String)localObject3, paramCommContext);
          localObject2 = paramProviderHint;
          if (paramProviderHint != null)
          {
            Logger.d(Area.AUTH.value(), "AuthFlow: AndroidAccountUserAuthProvider: getProviderData() [account:'%1$s'] [source:hint]", new Object[] { localObject3 });
            setUserAuthProviderAndData(paramCommContext, (String)localObject3);
            localObject2 = paramProviderHint;
          }
        }
      }
      paramProviderHint = (ProviderHint)localObject2;
      if (localObject2 == null)
      {
        localObject1 = this._accountResolver.getAndroidAccountNameViaUI(paramCommContext, paramAuthUIParentInterface);
        paramProviderHint = (ProviderHint)localObject2;
        if (!StringUtility.isNullOrEmpty((String)localObject1))
        {
          paramAuthUIParentInterface = this._accountResolver.getAndroidAccountFromName((String)localObject1, paramCommContext);
          paramProviderHint = paramAuthUIParentInterface;
          if (paramAuthUIParentInterface != null)
          {
            Logger.d(Area.AUTH.value(), "AuthFlow: AndroidAccountUserAuthProvider: getProviderData() [account:'%1$s'] [source:ui]", new Object[] { localObject1 });
            setUserAuthProviderAndData(paramCommContext, (String)localObject1);
            paramProviderHint = paramAuthUIParentInterface;
          }
        }
      }
      localObject2 = paramProviderHint;
      if (paramProviderHint == null)
      {
        setUserAuthProviderAndData(paramCommContext, (String)null);
        Logger.w(Area.AUTH.value(), "AuthFlow: AndroidAccountUserAuthProvider: getProviderData() failed to get android account name", new Object[0]);
        return null;
      }
    }
    if (StringUtility.isNullOrEmpty(((Account)localObject2).name))
    {
      localHashMap.put("android.account.name", new MetadataValue(((Account)localObject2).name, MetadataValue.MetadataReliability.NOT_AVAILABLE));
      if (!StringUtility.isNullOrEmpty(((Account)localObject2).type)) {
        break label534;
      }
      localHashMap.put("android.account.type", new MetadataValue(((Account)localObject2).type, MetadataValue.MetadataReliability.NOT_AVAILABLE));
    }
    for (;;)
    {
      localHashMap.putAll(ScreenUtility.getDisplayDetails(paramCommContext.getApplicationContext()));
      AuthMetadataUtility.addSDKMetadataValues(localHashMap, paramCommContext.getApplicationContext());
      return localHashMap;
      localHashMap.put("android.account.name", new MetadataValue(((Account)localObject2).name, MetadataValue.MetadataReliability.AVAILABLE));
      break;
      label534:
      localHashMap.put("android.account.type", new MetadataValue(((Account)localObject2).type, MetadataValue.MetadataReliability.AVAILABLE));
    }
  }
  
  private UserAuthProviderAndDataCacheEntry getUserAuthProviderAndData(Context paramContext)
  {
    paramContext = new BasicCache(paramContext.getApplicationContext(), "androidAccountUserAuthCache", 6, false).getCacheEntry("userAuthProviderAndData");
    if (paramContext == null) {}
    Object localObject;
    do
    {
      return null;
      localObject = paramContext.getValue();
    } while (StringUtility.isNullOrEmpty((String)localObject));
    paramContext = null;
    try
    {
      localObject = (UserAuthProviderAndDataCacheEntry)Base64.decodeToObject((String)localObject);
      paramContext = (Context)localObject;
      Logger.d(Area.AUTH.value() | Area.STORAGE.value(), "AuthFlow: AndroidAccountUserAuthProvider: Using cached UserAuthProviderAndDataCacheEntry [%1$s]", new Object[] { ((UserAuthProviderAndDataCacheEntry)localObject).getUserAuthProviderType().getName() });
      return (UserAuthProviderAndDataCacheEntry)localObject;
    }
    catch (Exception localException)
    {
      Logger.e(Area.AUTH.value() | Area.STORAGE.value(), localException, "AuthFlow: AndroidAccountUserAuthProvider: Deserialization of UserAuthProviderAndDataCacheEntry failed", new Object[0]);
    }
    return paramContext;
  }
  
  private boolean isProviderHintForMe(ProviderHint paramProviderHint)
  {
    return (paramProviderHint != null) && (paramProviderHint.getFilter().equals(getProviderFilter()));
  }
  
  private void setUserAuthProviderAndData(CommContext paramCommContext, String paramString)
  {
    Logger.v(Area.AUTH.value() | Area.STORAGE.value(), "AuthFlow: AndroidAccountUserAuthProvider: Updating cached UserAuthProviderAndDataCacheEntry [type:%1$s data:%2$s]", new Object[] { AndroidAccountUserAuthProvider.class.getName(), paramString });
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("android.account.name", paramString);
    paramString = new UserAuthProviderAndDataCacheEntry(AndroidAccountUserAuthProvider.class, localHashMap);
    try
    {
      paramString = Base64.encodeObject(paramString);
      new BasicCache(paramCommContext.getApplicationContext(), "androidAccountUserAuthCache", 6, false).updateCache("userAuthProviderAndData", paramString, Long.valueOf(Long.MAX_VALUE), null, null);
      return;
    }
    catch (IOException paramCommContext)
    {
      throw new CachingException(paramCommContext);
    }
  }
  
  private void validateProviderHint(ProviderHint paramProviderHint)
  {
    if ((isProviderHintForMe(paramProviderHint)) && ((!paramProviderHint.getData().containsKey("android_account.username_data_hash")) || (StringUtility.isNullOrEmpty((String)paramProviderHint.getData().get("android_account.username_data_hash"))))) {
      throw new IllegalArgumentException("'providerHint' does not contain required data");
    }
  }
  
  private boolean validateUserAuthProviderAndDataCacheEntry(UserAuthProviderAndDataCacheEntry paramUserAuthProviderAndDataCacheEntry)
  {
    if (paramUserAuthProviderAndDataCacheEntry == null)
    {
      Logger.v(Area.AUTH.value() | Area.STORAGE.value(), "AuthFlow: AndroidAccountUserAuthProvider: validateUserAuthProviderAndDataCacheEntry(): No cached provider data found", new Object[0]);
      return false;
    }
    if (!paramUserAuthProviderAndDataCacheEntry.getUserAuthProviderType().isInstance(this))
    {
      Logger.v(Area.AUTH.value() | Area.STORAGE.value(), "AuthFlow: AndroidAccountUserAuthProvider: validateUserAuthProviderAndDataCacheEntry(): Cached provider data is for '%1$s' and is not usable by '%2$s'", new Object[] { paramUserAuthProviderAndDataCacheEntry.getUserAuthProviderType().getName(), getClass().getName() });
      return false;
    }
    if ((paramUserAuthProviderAndDataCacheEntry.getCachedProviderData() == null) || (paramUserAuthProviderAndDataCacheEntry.getCachedProviderData().size() <= 0) || (!paramUserAuthProviderAndDataCacheEntry.getCachedProviderData().containsKey("android.account.name")) || (StringUtility.isNullOrEmpty((String)paramUserAuthProviderAndDataCacheEntry.getCachedProviderData().get("android.account.name"))))
    {
      Logger.v(Area.AUTH.value() | Area.STORAGE.value(), "AuthFlow: AndroidAccountUserAuthProvider: validateUserAuthProviderAndDataCacheEntry(): Cached provider data found without required content", new Object[0]);
      return false;
    }
    return true;
  }
  
  /* Error */
  public UserAuthResult ensureUser(String paramString1, CommContext paramCommContext, String paramString2, AuthUIParentInterface paramAuthUIParentInterface, ProviderHint paramProviderHint)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 95	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   4: ifeq +14 -> 18
    //   7: new 84	java/lang/IllegalArgumentException
    //   10: dup
    //   11: ldc_w 383
    //   14: invokespecial 89	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: aload_2
    //   19: ifnonnull +13 -> 32
    //   22: new 84	java/lang/IllegalArgumentException
    //   25: dup
    //   26: ldc 86
    //   28: invokespecial 89	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   31: athrow
    //   32: aload_3
    //   33: invokestatic 95	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   36: ifeq +14 -> 50
    //   39: new 84	java/lang/IllegalArgumentException
    //   42: dup
    //   43: ldc_w 385
    //   46: invokespecial 89	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   49: athrow
    //   50: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   53: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   56: ldc_w 387
    //   59: iconst_0
    //   60: anewarray 4	java/lang/Object
    //   63: invokestatic 82	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   66: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   69: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   72: ldc_w 389
    //   75: iconst_0
    //   76: anewarray 4	java/lang/Object
    //   79: invokestatic 82	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   82: invokestatic 395	com/getjar/sdk/comm/AuthorizationServiceProxy:getInstance	()Lcom/getjar/sdk/comm/AuthorizationServiceProxy;
    //   85: aload_2
    //   86: aload_3
    //   87: aload_1
    //   88: aload_0
    //   89: aload_2
    //   90: aload 4
    //   92: aload 5
    //   94: invokespecial 397	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider:getProviderData	(Lcom/getjar/sdk/comm/CommContext;Lcom/getjar/sdk/comm/auth/AuthUIParentInterface;Lcom/getjar/sdk/comm/auth/ProviderHint;)Ljava/util/Map;
    //   97: aload_0
    //   98: invokevirtual 322	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider:getProviderFilter	()Ljava/lang/String;
    //   101: invokevirtual 401	com/getjar/sdk/comm/AuthorizationServiceProxy:userAccessEnsure	(Lcom/getjar/sdk/comm/CommContext;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Lcom/getjar/sdk/comm/Operation;
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual 406	com/getjar/sdk/comm/Operation:get	()Lcom/getjar/sdk/comm/Result;
    //   109: astore 4
    //   111: aload 4
    //   113: ifnonnull +154 -> 267
    //   116: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   119: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   122: ldc_w 408
    //   125: iconst_0
    //   126: anewarray 4	java/lang/Object
    //   129: invokestatic 410	com/getjar/sdk/logging/Logger:e	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   132: new 412	com/getjar/sdk/comm/auth/UserAuthResult
    //   135: dup
    //   136: aload_0
    //   137: invokevirtual 322	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider:getProviderFilter	()Ljava/lang/String;
    //   140: getstatic 418	com/getjar/sdk/comm/auth/AuthResult$State:NETWORK_FAILURE	Lcom/getjar/sdk/comm/auth/AuthResult$State;
    //   143: invokespecial 421	com/getjar/sdk/comm/auth/UserAuthResult:<init>	(Ljava/lang/String;Lcom/getjar/sdk/comm/auth/AuthResult$State;)V
    //   146: astore_1
    //   147: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   150: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   153: ldc_w 423
    //   156: iconst_0
    //   157: anewarray 4	java/lang/Object
    //   160: invokestatic 82	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   163: aload_1
    //   164: areturn
    //   165: astore_1
    //   166: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   169: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   172: aload_1
    //   173: ldc_w 425
    //   176: iconst_0
    //   177: anewarray 4	java/lang/Object
    //   180: invokestatic 146	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: new 412	com/getjar/sdk/comm/auth/UserAuthResult
    //   186: dup
    //   187: aload_0
    //   188: invokevirtual 322	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider:getProviderFilter	()Ljava/lang/String;
    //   191: getstatic 428	com/getjar/sdk/comm/auth/AuthResult$State:UNKNOWN_FAILURE	Lcom/getjar/sdk/comm/auth/AuthResult$State;
    //   194: invokespecial 421	com/getjar/sdk/comm/auth/UserAuthResult:<init>	(Ljava/lang/String;Lcom/getjar/sdk/comm/auth/AuthResult$State;)V
    //   197: astore_1
    //   198: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   201: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   204: ldc_w 423
    //   207: iconst_0
    //   208: anewarray 4	java/lang/Object
    //   211: invokestatic 82	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   214: aload_1
    //   215: areturn
    //   216: astore_1
    //   217: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   220: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   223: aload_1
    //   224: ldc_w 425
    //   227: iconst_0
    //   228: anewarray 4	java/lang/Object
    //   231: invokestatic 146	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: new 412	com/getjar/sdk/comm/auth/UserAuthResult
    //   237: dup
    //   238: aload_0
    //   239: invokevirtual 322	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider:getProviderFilter	()Ljava/lang/String;
    //   242: getstatic 428	com/getjar/sdk/comm/auth/AuthResult$State:UNKNOWN_FAILURE	Lcom/getjar/sdk/comm/auth/AuthResult$State;
    //   245: invokespecial 421	com/getjar/sdk/comm/auth/UserAuthResult:<init>	(Ljava/lang/String;Lcom/getjar/sdk/comm/auth/AuthResult$State;)V
    //   248: astore_1
    //   249: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   252: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   255: ldc_w 423
    //   258: iconst_0
    //   259: anewarray 4	java/lang/Object
    //   262: invokestatic 82	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   265: aload_1
    //   266: areturn
    //   267: aload 4
    //   269: invokevirtual 434	com/getjar/sdk/comm/Result:isSuccessfulResponse	()Z
    //   272: ifeq +341 -> 613
    //   275: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   278: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   281: ldc_w 436
    //   284: iconst_0
    //   285: anewarray 4	java/lang/Object
    //   288: invokestatic 82	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   291: aload 4
    //   293: invokestatic 442	com/getjar/sdk/comm/auth/AuthUtilities:getClaimsFromResult	(Lcom/getjar/sdk/comm/Result;)Ljava/util/Map;
    //   296: astore 5
    //   298: aload 4
    //   300: invokestatic 445	com/getjar/sdk/comm/auth/AuthUtilities:getSettingsFromResult	(Lcom/getjar/sdk/comm/Result;)Ljava/util/Map;
    //   303: astore 10
    //   305: aload 4
    //   307: invokestatic 449	com/getjar/sdk/comm/auth/AuthUtilities:getAuthTokenFromHeaders	(Lcom/getjar/sdk/comm/Result;)Ljava/lang/String;
    //   310: astore 11
    //   312: aload 5
    //   314: ldc2_w 450
    //   317: invokestatic 455	com/getjar/sdk/comm/auth/AuthUtilities:getTTLFromClaims	(Ljava/util/Map;J)J
    //   320: lstore 6
    //   322: aload 4
    //   324: invokestatic 461	com/getjar/sdk/comm/ResultCachingManager:getTtlFromResult	(Lcom/getjar/sdk/comm/Result;)Ljava/lang/Long;
    //   327: invokevirtual 464	java/lang/Long:longValue	()J
    //   330: lstore 8
    //   332: aconst_null
    //   333: astore_1
    //   334: aconst_null
    //   335: astore_3
    //   336: aload 5
    //   338: ifnull +31 -> 369
    //   341: aload 5
    //   343: ldc_w 466
    //   346: invokeinterface 467 2 0
    //   351: checkcast 125	java/lang/String
    //   354: astore_1
    //   355: aload 5
    //   357: ldc_w 469
    //   360: invokeinterface 467 2 0
    //   365: checkcast 125	java/lang/String
    //   368: astore_3
    //   369: aload_0
    //   370: getfield 53	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider:_accountResolver	Lcom/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider$AndroidAccountResolver;
    //   373: aload_2
    //   374: invokevirtual 205	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
    //   377: invokestatic 473	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider$AndroidAccountResolver:access$100	(Lcom/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider$AndroidAccountResolver;Landroid/content/Context;)Ljava/lang/String;
    //   380: astore 12
    //   382: aload_2
    //   383: invokevirtual 205	com/getjar/sdk/comm/CommContext:getApplicationContext	()Landroid/content/Context;
    //   386: invokestatic 479	com/getjar/sdk/comm/auth/AccountHistoryManager:initialize	(Landroid/content/Context;)V
    //   389: invokestatic 482	com/getjar/sdk/comm/auth/AccountHistoryManager:getInstance	()Lcom/getjar/sdk/comm/auth/AccountHistoryManager;
    //   392: aload_1
    //   393: aload_3
    //   394: aload 12
    //   396: aload_0
    //   397: invokevirtual 322	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider:getProviderFilter	()Ljava/lang/String;
    //   400: invokevirtual 486	com/getjar/sdk/comm/auth/AccountHistoryManager:ensureAccountEntry	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   403: aload 4
    //   405: invokevirtual 489	com/getjar/sdk/comm/Result:isSuccessfulCreationResponse	()Z
    //   408: ifeq +122 -> 530
    //   411: invokestatic 482	com/getjar/sdk/comm/auth/AccountHistoryManager:getInstance	()Lcom/getjar/sdk/comm/auth/AccountHistoryManager;
    //   414: aload_1
    //   415: getstatic 495	com/getjar/sdk/comm/auth/AccountEventType:AUTH_FIRST_TIME	Lcom/getjar/sdk/comm/auth/AccountEventType;
    //   418: invokevirtual 499	com/getjar/sdk/comm/auth/AccountHistoryManager:addEvent	(Ljava/lang/String;Lcom/getjar/sdk/comm/auth/AccountEventType;)V
    //   421: new 412	com/getjar/sdk/comm/auth/UserAuthResult
    //   424: dup
    //   425: aload_0
    //   426: invokevirtual 322	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider:getProviderFilter	()Ljava/lang/String;
    //   429: aload_1
    //   430: aload_3
    //   431: aload 4
    //   433: invokevirtual 489	com/getjar/sdk/comm/Result:isSuccessfulCreationResponse	()Z
    //   436: aload 11
    //   438: aload 5
    //   440: aload 10
    //   442: lload 6
    //   444: lload 8
    //   446: invokespecial 502	com/getjar/sdk/comm/auth/UserAuthResult:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;Ljava/util/Map;JJ)V
    //   449: astore_1
    //   450: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   453: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   456: ldc_w 504
    //   459: iconst_5
    //   460: anewarray 4	java/lang/Object
    //   463: dup
    //   464: iconst_0
    //   465: aload_1
    //   466: invokevirtual 507	com/getjar/sdk/comm/auth/UserAuthResult:getUserAccessId	()Ljava/lang/String;
    //   469: aastore
    //   470: dup
    //   471: iconst_1
    //   472: aload_1
    //   473: invokevirtual 510	com/getjar/sdk/comm/auth/UserAuthResult:getUserDeviceId	()Ljava/lang/String;
    //   476: aastore
    //   477: dup
    //   478: iconst_2
    //   479: aload_1
    //   480: invokevirtual 513	com/getjar/sdk/comm/auth/UserAuthResult:getAuthToken	()Ljava/lang/String;
    //   483: aastore
    //   484: dup
    //   485: iconst_3
    //   486: aload_1
    //   487: invokevirtual 516	com/getjar/sdk/comm/auth/UserAuthResult:getClaims	()Ljava/util/Map;
    //   490: invokeinterface 178 1 0
    //   495: invokestatic 521	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   498: aastore
    //   499: dup
    //   500: iconst_4
    //   501: aload_1
    //   502: invokevirtual 524	com/getjar/sdk/comm/auth/UserAuthResult:getTTL	()J
    //   505: invokestatic 351	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   508: aastore
    //   509: invokestatic 82	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   512: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   515: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   518: ldc_w 423
    //   521: iconst_0
    //   522: anewarray 4	java/lang/Object
    //   525: invokestatic 82	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   528: aload_1
    //   529: areturn
    //   530: invokestatic 482	com/getjar/sdk/comm/auth/AccountHistoryManager:getInstance	()Lcom/getjar/sdk/comm/auth/AccountHistoryManager;
    //   533: aload_1
    //   534: getstatic 526	com/getjar/sdk/comm/auth/AccountEventType:AUTH	Lcom/getjar/sdk/comm/auth/AccountEventType;
    //   537: invokevirtual 499	com/getjar/sdk/comm/auth/AccountHistoryManager:addEvent	(Ljava/lang/String;Lcom/getjar/sdk/comm/auth/AccountEventType;)V
    //   540: goto -119 -> 421
    //   543: astore_2
    //   544: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   547: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   550: aload_2
    //   551: ldc_w 528
    //   554: iconst_0
    //   555: anewarray 4	java/lang/Object
    //   558: invokestatic 146	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   561: goto -140 -> 421
    //   564: astore_1
    //   565: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   568: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   571: aload_1
    //   572: ldc_w 530
    //   575: iconst_0
    //   576: anewarray 4	java/lang/Object
    //   579: invokestatic 146	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   582: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   585: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   588: ldc_w 423
    //   591: iconst_0
    //   592: anewarray 4	java/lang/Object
    //   595: invokestatic 82	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   598: new 412	com/getjar/sdk/comm/auth/UserAuthResult
    //   601: dup
    //   602: aload_0
    //   603: invokevirtual 322	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider:getProviderFilter	()Ljava/lang/String;
    //   606: getstatic 428	com/getjar/sdk/comm/auth/AuthResult$State:UNKNOWN_FAILURE	Lcom/getjar/sdk/comm/auth/AuthResult$State;
    //   609: invokespecial 421	com/getjar/sdk/comm/auth/UserAuthResult:<init>	(Ljava/lang/String;Lcom/getjar/sdk/comm/auth/AuthResult$State;)V
    //   612: areturn
    //   613: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   616: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   619: ldc_w 532
    //   622: iconst_0
    //   623: anewarray 4	java/lang/Object
    //   626: invokestatic 100	com/getjar/sdk/logging/Logger:w	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   629: aload 4
    //   631: invokestatic 538	com/getjar/sdk/comm/RequestUtilities:getServicesException	(Lcom/getjar/sdk/comm/Result;)Lcom/getjar/sdk/exceptions/ServiceException;
    //   634: astore_1
    //   635: aload_1
    //   636: ifnull +8 -> 644
    //   639: aload_2
    //   640: aload_1
    //   641: invokevirtual 541	com/getjar/sdk/comm/CommContext:addException	(Ljava/lang/Throwable;)V
    //   644: aload 4
    //   646: aload_2
    //   647: invokevirtual 545	com/getjar/sdk/comm/Result:checkForNonReAuthableSubCodesAndMakeCallbacks	(Lcom/getjar/sdk/comm/CommContext;)Z
    //   650: ifeq +52 -> 702
    //   653: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   656: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   659: ldc_w 547
    //   662: iconst_0
    //   663: anewarray 4	java/lang/Object
    //   666: invokestatic 82	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   669: new 412	com/getjar/sdk/comm/auth/UserAuthResult
    //   672: dup
    //   673: aload_0
    //   674: invokevirtual 322	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider:getProviderFilter	()Ljava/lang/String;
    //   677: getstatic 550	com/getjar/sdk/comm/auth/AuthResult$State:UNSUPPORTED	Lcom/getjar/sdk/comm/auth/AuthResult$State;
    //   680: invokespecial 421	com/getjar/sdk/comm/auth/UserAuthResult:<init>	(Ljava/lang/String;Lcom/getjar/sdk/comm/auth/AuthResult$State;)V
    //   683: astore_1
    //   684: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   687: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   690: ldc_w 423
    //   693: iconst_0
    //   694: anewarray 4	java/lang/Object
    //   697: invokestatic 82	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   700: aload_1
    //   701: areturn
    //   702: new 412	com/getjar/sdk/comm/auth/UserAuthResult
    //   705: dup
    //   706: aload_0
    //   707: invokevirtual 322	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider:getProviderFilter	()Ljava/lang/String;
    //   710: getstatic 428	com/getjar/sdk/comm/auth/AuthResult$State:UNKNOWN_FAILURE	Lcom/getjar/sdk/comm/auth/AuthResult$State;
    //   713: invokespecial 421	com/getjar/sdk/comm/auth/UserAuthResult:<init>	(Ljava/lang/String;Lcom/getjar/sdk/comm/auth/AuthResult$State;)V
    //   716: astore_1
    //   717: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   720: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   723: ldc_w 423
    //   726: iconst_0
    //   727: anewarray 4	java/lang/Object
    //   730: invokestatic 82	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   733: aload_1
    //   734: areturn
    //   735: astore_1
    //   736: getstatic 70	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   739: invokevirtual 74	com/getjar/sdk/logging/Area:value	()J
    //   742: ldc_w 423
    //   745: iconst_0
    //   746: anewarray 4	java/lang/Object
    //   749: invokestatic 82	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   752: aload_1
    //   753: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	754	0	this	AndroidAccountUserAuthProvider
    //   0	754	1	paramString1	String
    //   0	754	2	paramCommContext	CommContext
    //   0	754	3	paramString2	String
    //   0	754	4	paramAuthUIParentInterface	AuthUIParentInterface
    //   0	754	5	paramProviderHint	ProviderHint
    //   320	123	6	l1	long
    //   330	115	8	l2	long
    //   303	138	10	localMap	Map
    //   310	127	11	str1	String
    //   380	15	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   105	111	165	java/lang/InterruptedException
    //   105	111	216	java/util/concurrent/ExecutionException
    //   369	421	543	java/lang/Exception
    //   530	540	543	java/lang/Exception
    //   66	105	564	java/lang/Exception
    //   105	111	564	java/lang/Exception
    //   116	147	564	java/lang/Exception
    //   166	198	564	java/lang/Exception
    //   217	249	564	java/lang/Exception
    //   267	332	564	java/lang/Exception
    //   341	369	564	java/lang/Exception
    //   421	512	564	java/lang/Exception
    //   544	561	564	java/lang/Exception
    //   613	635	564	java/lang/Exception
    //   639	644	564	java/lang/Exception
    //   644	684	564	java/lang/Exception
    //   702	717	564	java/lang/Exception
    //   66	105	735	finally
    //   105	111	735	finally
    //   116	147	735	finally
    //   166	198	735	finally
    //   217	249	735	finally
    //   267	332	735	finally
    //   341	369	735	finally
    //   369	421	735	finally
    //   421	512	735	finally
    //   530	540	735	finally
    //   544	561	735	finally
    //   565	582	735	finally
    //   613	635	735	finally
    //   639	644	735	finally
    //   644	684	735	finally
    //   702	717	735	finally
  }
  
  public String getCachedAccountName(Context paramContext)
  {
    if (this._accountResolver == null) {
      return null;
    }
    return this._accountResolver.getCachedAccountName(paramContext);
  }
  
  public String getProviderFilter()
  {
    return "android_account";
  }
  
  public Map<String, String> getProxiableAuthData(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' cannot be NULL");
    }
    paramContext = this._accountResolver.getCachedAccountName(paramContext);
    if (StringUtility.isNullOrEmpty(paramContext)) {
      throw new IllegalStateException("The provider does not currently have the data needed");
    }
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("provider_filter", getProviderFilter());
    try
    {
      localHashMap.put("android_account.username_data_hash", CryptoUtility.getSHA256(paramContext.toLowerCase(Locale.US)));
      return localHashMap;
    }
    catch (NoSuchAlgorithmException paramContext)
    {
      throw new AuthException(paramContext);
    }
    catch (UnsupportedEncodingException paramContext)
    {
      throw new AuthException(paramContext);
    }
  }
  
  public boolean isUINeeded(CommContext paramCommContext, String paramString, ProviderHint paramProviderHint)
  {
    boolean bool2 = false;
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' cannot be NULL");
    }
    validateProviderHint(paramProviderHint);
    CharSequence[] arrayOfCharSequence = getAndroidAccountNames(paramCommContext.getApplicationContext());
    boolean bool1;
    if ((arrayOfCharSequence == null) || (arrayOfCharSequence.length <= 0)) {
      bool1 = true;
    }
    label130:
    do
    {
      do
      {
        return bool1;
        paramString = null;
        UserAuthProviderAndDataCacheEntry localUserAuthProviderAndDataCacheEntry = getUserAuthProviderAndData(paramCommContext.getApplicationContext());
        if (validateUserAuthProviderAndDataCacheEntry(localUserAuthProviderAndDataCacheEntry)) {
          paramString = (String)localUserAuthProviderAndDataCacheEntry.getCachedProviderData().get("android.account.name");
        }
        if (!StringUtility.isNullOrEmpty(paramString))
        {
          int j = arrayOfCharSequence.length;
          int i = 0;
          for (;;)
          {
            if (i >= j) {
              break label130;
            }
            bool1 = bool2;
            if (paramString.equals(arrayOfCharSequence[i])) {
              break;
            }
            i += 1;
          }
        }
        if (arrayOfCharSequence.length != 1) {
          break;
        }
        bool1 = bool2;
      } while (this._accountResolver.validateAccountAgainstCache(paramCommContext, arrayOfCharSequence[0]));
      if (!isProviderHintForMe(paramProviderHint)) {
        break;
      }
      bool1 = bool2;
    } while (!StringUtility.isNullOrEmpty(this._accountResolver.getAndroidAccountNameViaHint(paramCommContext, paramProviderHint)));
    return true;
  }
  
  private class AndroidAccountResolver
  {
    private String _accountNameFromUI = null;
    private volatile Object _asyncAccountResolutionMonitorObject = new Object();
    private volatile boolean _asyncAccountResolutionWasSignalled = false;
    private volatile Object _asyncDialogCreationMonitorObject = new Object();
    private volatile boolean _asyncDialogCreationWasSignalled = false;
    private AlertDialog _createdDialog = null;
    
    private AndroidAccountResolver() {}
    
    /* Error */
    private void accountResolved(CommContext paramCommContext, CharSequence paramCharSequence)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_2
      //   3: ifnull +40 -> 43
      //   6: aload_0
      //   7: aload_2
      //   8: invokevirtual 111	java/lang/Object:toString	()Ljava/lang/String;
      //   11: putfield 40	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider$AndroidAccountResolver:_accountNameFromUI	Ljava/lang/String;
      //   14: getstatic 117	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
      //   17: invokevirtual 121	com/getjar/sdk/logging/Area:value	()J
      //   20: ldc 123
      //   22: iconst_1
      //   23: anewarray 4	java/lang/Object
      //   26: dup
      //   27: iconst_0
      //   28: aload_0
      //   29: getfield 40	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider$AndroidAccountResolver:_accountNameFromUI	Ljava/lang/String;
      //   32: aastore
      //   33: invokestatic 129	com/getjar/sdk/logging/Logger:i	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   36: aload_0
      //   37: invokespecial 95	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider$AndroidAccountResolver:asyncAccountResolutionNotify	()V
      //   40: aload_0
      //   41: monitorexit
      //   42: return
      //   43: aload_0
      //   44: aconst_null
      //   45: putfield 40	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider$AndroidAccountResolver:_accountNameFromUI	Ljava/lang/String;
      //   48: getstatic 117	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
      //   51: invokevirtual 121	com/getjar/sdk/logging/Area:value	()J
      //   54: ldc -125
      //   56: iconst_0
      //   57: anewarray 4	java/lang/Object
      //   60: invokestatic 129	com/getjar/sdk/logging/Logger:i	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   63: aload_0
      //   64: invokespecial 95	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider$AndroidAccountResolver:asyncAccountResolutionNotify	()V
      //   67: goto -27 -> 40
      //   70: astore_1
      //   71: aload_0
      //   72: monitorexit
      //   73: aload_1
      //   74: athrow
      //   75: astore_1
      //   76: aload_0
      //   77: invokespecial 95	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider$AndroidAccountResolver:asyncAccountResolutionNotify	()V
      //   80: aload_1
      //   81: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	82	0	this	AndroidAccountResolver
      //   0	82	1	paramCommContext	CommContext
      //   0	82	2	paramCharSequence	CharSequence
      // Exception table:
      //   from	to	target	type
      //   36	40	70	finally
      //   63	67	70	finally
      //   76	82	70	finally
      //   6	36	75	finally
      //   43	63	75	finally
    }
    
    private void accountSelected(CharSequence paramCharSequence, CommContext paramCommContext)
    {
      accountResolved(paramCommContext, paramCharSequence);
    }
    
    private void asyncAccountResolutionNotify()
    {
      synchronized (this._asyncAccountResolutionMonitorObject)
      {
        this._asyncAccountResolutionWasSignalled = true;
        this._asyncAccountResolutionMonitorObject.notify();
        return;
      }
    }
    
    private void asyncAccountResolutionWait()
      throws InterruptedException
    {
      synchronized (this._asyncAccountResolutionMonitorObject)
      {
        for (;;)
        {
          boolean bool = this._asyncAccountResolutionWasSignalled;
          if (!bool) {
            try
            {
              this._asyncAccountResolutionMonitorObject.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }
      }
      this._asyncAccountResolutionWasSignalled = false;
    }
    
    private void asyncDialogCreationNotify()
    {
      synchronized (this._asyncDialogCreationMonitorObject)
      {
        this._asyncDialogCreationWasSignalled = true;
        this._asyncDialogCreationMonitorObject.notify();
        return;
      }
    }
    
    private void asyncDialogCreationWait()
      throws InterruptedException
    {
      synchronized (this._asyncDialogCreationMonitorObject)
      {
        for (;;)
        {
          boolean bool = this._asyncDialogCreationWasSignalled;
          if (!bool) {
            try
            {
              this._asyncDialogCreationMonitorObject.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }
      }
      this._asyncDialogCreationWasSignalled = false;
    }
    
    private Account getAndroidAccountFromName(String paramString, CommContext paramCommContext)
    {
      paramCommContext = AndroidAccountUserAuthProvider.getAndroidAccounts(paramCommContext.getApplicationContext());
      int j = paramCommContext.length;
      int i = 0;
      while (i < j)
      {
        Account localAccount = paramCommContext[i];
        if (localAccount.name.equals(paramString)) {
          return localAccount;
        }
        i += 1;
      }
      return null;
    }
    
    private String getAndroidAccountNameViaHint(CommContext paramCommContext, ProviderHint paramProviderHint)
    {
      Logger.d(Area.AUTH.value(), "AuthFlow: AndroidAccountResolver: getAndroidAccountNameViaHint() START", new Object[0]);
      if (paramCommContext == null) {
        throw new IllegalArgumentException("'commContext' cannot be NULL");
      }
      if (paramProviderHint == null) {
        throw new IllegalArgumentException("'providerHint' cannot be NULL");
      }
      return AndroidAccountUserAuthProvider.getAccountNameFromHash(paramCommContext.getApplicationContext(), (String)paramProviderHint.getData().get("android_account.username_data_hash"));
    }
    
    private String getAndroidAccountNameViaUI(final CommContext paramCommContext, AuthUIParentInterface paramAuthUIParentInterface)
    {
      Logger.d(Area.AUTH.value() | Area.UI.value(), "AuthFlow: AndroidAccountResolver: getAndroidAccountNameViaUI() START", new Object[0]);
      Object localObject1 = AndroidAccountUserAuthProvider.getAndroidAccountNames(paramCommContext.getApplicationContext());
      if ((localObject1.length == 1) && (validateAccountAgainstCache(paramCommContext, localObject1[0])))
      {
        accountResolved(paramCommContext, localObject1[0]);
        return this._accountNameFromUI;
      }
      if (paramAuthUIParentInterface != null)
      {
        this._accountNameFromUI = null;
        paramCommContext = getAndroidAccountUI(paramCommContext, paramAuthUIParentInterface);
        if (paramCommContext != null)
        {
          localObject1 = new ArrayList(1);
          ((List)localObject1).add(paramCommContext);
          paramAuthUIParentInterface.takeoverUI((List)localObject1);
        }
        if (paramCommContext != null) {}
        try
        {
          new Handler(Looper.getMainLooper()).post(new Runnable()
          {
            public void run()
            {
              try
              {
                Logger.d(Area.AUTH.value() | Area.UI.value(), "AuthFlow: AndroidAccountResolver: getAndroidAccountNameViaUI() Showing dialog", new Object[0]);
                paramCommContext.show();
                return;
              }
              catch (Exception localException)
              {
                Logger.e(Area.AUTH.value() | Area.UI.value(), localException, "AuthFlow: AndroidAccountResolver: getAndroidAccountNameViaUI() dialog.show() failed", new Object[0]);
                AndroidAccountUserAuthProvider.AndroidAccountResolver.this.asyncAccountResolutionNotify();
                return;
              }
              finally
              {
                Logger.d(Area.AUTH.value() | Area.UI.value(), "AuthFlow: AndroidAccountResolver: getAndroidAccountNameViaUI() Done showing dialog", new Object[0]);
              }
            }
          });
          try
          {
            asyncAccountResolutionWait();
            if (paramCommContext != null) {
              paramAuthUIParentInterface.relinquishUI();
            }
            Logger.d(Area.AUTH.value() | Area.UI.value(), "AuthFlow: AndroidAccountResolver: getAndroidAccountNameViaUI() FINISHED Returning %1$s", new Object[] { this._accountNameFromUI });
            return this._accountNameFromUI;
          }
          catch (InterruptedException localInterruptedException)
          {
            throw new AuthException(localInterruptedException);
          }
          Logger.d(Area.AUTH.value() | Area.UI.value(), "AuthFlow: AndroidAccountResolver: getAndroidAccountNameViaUI() FINISHED Returning NULL", new Object[0]);
        }
        finally
        {
          if (paramCommContext != null) {
            paramAuthUIParentInterface.relinquishUI();
          }
        }
      }
      return null;
    }
    
    private AlertDialog getAndroidAccountUI(final CommContext paramCommContext, final AuthUIParentInterface paramAuthUIParentInterface)
    {
      Logger.v(Area.AUTH.value() | Area.UI.value(), "AuthFlow: AndroidAccountResolver: getAndroidAccountUI() starting", new Object[0]);
      Object localObject1 = null;
      final CharSequence[] arrayOfCharSequence = AndroidAccountUserAuthProvider.getAndroidAccountNames(paramCommContext.getApplicationContext());
      if ((arrayOfCharSequence == null) || (arrayOfCharSequence.length <= 0))
      {
        localObject1 = new AlertDialog.Builder(paramAuthUIParentInterface.getParentActivity());
        ((AlertDialog.Builder)localObject1).setMessage("You must create or sign in to a GMail account in order to use Getjar.");
        ((AlertDialog.Builder)localObject1).setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            try
            {
              AndroidAccountUserAuthProvider.AndroidAccountResolver.this.accountResolved(paramCommContext, null);
              paramAuthUIParentInterface.getParentActivity().finish();
              return;
            }
            catch (Exception paramAnonymousDialogInterface)
            {
              Logger.e(Area.AUTH.value() | Area.UI.value(), paramAnonymousDialogInterface, "AuthFlow: AndroidAccountResolver: AlertDialog onClick() failed", new Object[0]);
            }
          }
        });
        ((AlertDialog.Builder)localObject1).setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            try
            {
              AndroidAccountUserAuthProvider.AndroidAccountResolver.this.accountResolved(paramCommContext, null);
              paramAuthUIParentInterface.getParentActivity().finish();
              paramAnonymousDialogInterface = new Intent("android.settings.ADD_ACCOUNT_SETTINGS");
              paramCommContext.getApplicationContext().startActivity(paramAnonymousDialogInterface);
              return;
            }
            catch (Exception paramAnonymousDialogInterface)
            {
              Logger.e(Area.AUTH.value() | Area.UI.value(), paramAnonymousDialogInterface, "AuthFlow: AndroidAccountResolver: AlertDialog onClick() failed", new Object[0]);
            }
          }
        });
        paramCommContext = getDialogInstance((AlertDialog.Builder)localObject1);
      }
      while (paramCommContext != null)
      {
        Logger.v(Area.AUTH.value() | Area.UI.value(), "AuthFlow: AndroidAccountResolver: getAndroidAccountUI() returning an AlertDialog instance", new Object[0]);
        return paramCommContext;
        if ((arrayOfCharSequence.length == 1) && (validateAccountAgainstCache(paramCommContext, arrayOfCharSequence[0])))
        {
          accountResolved(paramCommContext, arrayOfCharSequence[0]);
          paramCommContext = (CommContext)localObject1;
        }
        else
        {
          Object localObject2 = paramAuthUIParentInterface.getTheTitle();
          localObject1 = localObject2;
          if (arrayOfCharSequence.length == 1)
          {
            localObject1 = localObject2;
            if (!validateAccountAgainstCache(paramCommContext, arrayOfCharSequence[0])) {
              localObject1 = "Account missing. Restore or pick new account.";
            }
          }
          localObject2 = new AlertDialog.Builder(paramAuthUIParentInterface.getParentActivity());
          ((AlertDialog.Builder)localObject2).setTitle((CharSequence)localObject1);
          ((AlertDialog.Builder)localObject2).setItems(arrayOfCharSequence, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              try
              {
                AndroidAccountUserAuthProvider.AndroidAccountResolver.this.accountSelected(arrayOfCharSequence[paramAnonymousInt], paramCommContext);
                return;
              }
              catch (Exception paramAnonymousDialogInterface)
              {
                Logger.e(Area.AUTH.value() | Area.UI.value(), paramAnonymousDialogInterface, "AuthFlow: AndroidAccountResolver: AlertDialog onClick() failed", new Object[0]);
              }
            }
          });
          ((AlertDialog.Builder)localObject2).setOnCancelListener(new DialogInterface.OnCancelListener()
          {
            public void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              try
              {
                AndroidAccountUserAuthProvider.AndroidAccountResolver.this.accountResolved(paramCommContext, null);
                paramAuthUIParentInterface.getParentActivity().finish();
                return;
              }
              catch (Exception paramAnonymousDialogInterface)
              {
                Logger.e(Area.AUTH.value() | Area.UI.value(), paramAnonymousDialogInterface, "AuthFlow: AndroidAccountResolver: AlertDialog onCancel() failed", new Object[0]);
              }
            }
          });
          paramCommContext = getDialogInstance((AlertDialog.Builder)localObject2);
        }
      }
      Logger.v(Area.AUTH.value() | Area.UI.value(), "AuthFlow: AndroidAccountResolver: getAndroidAccountUI() returning null", new Object[0]);
      return paramCommContext;
    }
    
    private String getCachedAccountName(Context paramContext)
    {
      paramContext = AndroidAccountUserAuthProvider.this.getUserAuthProviderAndData(paramContext);
      if ((paramContext != null) && (paramContext.getCachedProviderData() != null))
      {
        paramContext = (String)paramContext.getCachedProviderData().get("android.account.name");
        if (!StringUtility.isNullOrEmpty(paramContext)) {
          return paramContext;
        }
      }
      return null;
    }
    
    /* Error */
    private AlertDialog getDialogInstance(final AlertDialog.Builder paramBuilder)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: getstatic 117	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
      //   5: invokevirtual 121	com/getjar/sdk/logging/Area:value	()J
      //   8: getstatic 201	com/getjar/sdk/logging/Area:UI	Lcom/getjar/sdk/logging/Area;
      //   11: invokevirtual 121	com/getjar/sdk/logging/Area:value	()J
      //   14: lor
      //   15: ldc_w 336
      //   18: iconst_0
      //   19: anewarray 4	java/lang/Object
      //   22: invokestatic 264	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   25: aload_0
      //   26: aconst_null
      //   27: putfield 46	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider$AndroidAccountResolver:_createdDialog	Landroid/app/AlertDialog;
      //   30: new 229	android/os/Handler
      //   33: dup
      //   34: invokestatic 235	android/os/Looper:getMainLooper	()Landroid/os/Looper;
      //   37: invokespecial 238	android/os/Handler:<init>	(Landroid/os/Looper;)V
      //   40: new 19	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider$AndroidAccountResolver$6
      //   43: dup
      //   44: aload_0
      //   45: aload_1
      //   46: invokespecial 339	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider$AndroidAccountResolver$6:<init>	(Lcom/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider$AndroidAccountResolver;Landroid/app/AlertDialog$Builder;)V
      //   49: invokevirtual 245	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   52: pop
      //   53: aload_0
      //   54: invokespecial 341	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider$AndroidAccountResolver:asyncDialogCreationWait	()V
      //   57: getstatic 117	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
      //   60: invokevirtual 121	com/getjar/sdk/logging/Area:value	()J
      //   63: getstatic 201	com/getjar/sdk/logging/Area:UI	Lcom/getjar/sdk/logging/Area;
      //   66: invokevirtual 121	com/getjar/sdk/logging/Area:value	()J
      //   69: lor
      //   70: ldc_w 343
      //   73: iconst_0
      //   74: anewarray 4	java/lang/Object
      //   77: invokestatic 264	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   80: aload_0
      //   81: getfield 46	com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider$AndroidAccountResolver:_createdDialog	Landroid/app/AlertDialog;
      //   84: astore_1
      //   85: aload_0
      //   86: monitorexit
      //   87: aload_1
      //   88: areturn
      //   89: astore_1
      //   90: new 254	com/getjar/sdk/exceptions/AuthException
      //   93: dup
      //   94: aload_1
      //   95: invokespecial 257	com/getjar/sdk/exceptions/AuthException:<init>	(Ljava/lang/Throwable;)V
      //   98: athrow
      //   99: astore_1
      //   100: aload_0
      //   101: monitorexit
      //   102: aload_1
      //   103: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	104	0	this	AndroidAccountResolver
      //   0	104	1	paramBuilder	AlertDialog.Builder
      // Exception table:
      //   from	to	target	type
      //   53	57	89	java/lang/InterruptedException
      //   2	53	99	finally
      //   53	57	99	finally
      //   57	85	99	finally
      //   90	99	99	finally
    }
    
    private boolean validateAccountAgainstCache(CommContext paramCommContext, CharSequence paramCharSequence)
    {
      paramCommContext = getCachedAccountName(paramCommContext.getApplicationContext());
      if ((!StringUtility.isNullOrEmpty(paramCommContext)) && (!paramCommContext.equals(paramCharSequence.toString())))
      {
        Logger.v(Area.AUTH.value() | Area.STORAGE.value(), "AuthFlow: AndroidAccountResolver: getAndroidAccountNameViaUI() cached account and available account do not match [cache:%1$s available:%2$s]", new Object[] { paramCommContext, paramCharSequence });
        return false;
      }
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/auth/AndroidAccountUserAuthProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */