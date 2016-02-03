package com.getjar.sdk.data;

import com.getjar.sdk.OnGetjarVoucherRedeemedListener;
import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.comm.TransactionManager;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.StringUtility;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RedemptionEngine
{
  public static final String EXTRA_MANAGED_CHECKOUT_DATA = "EXTRA_MANAGED_CHECKOUT_DATA";
  public static final String IntentVoucherTokenKey = "voucherToken";
  public static final String TestVoucherAlreadyRedeemedFailure = "00000000-0000-0000-0000-000000000003";
  public static final String TestVoucherAuthFailure = "00000000-0000-0000-0000-000000000002";
  public static final String TestVoucherUnknownFailure = "00000000-0000-0000-0000-000000000001";
  private static final ExecutorService _ExecutorService = ;
  
  public static void confirmVoucher(CommContext paramCommContext, String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'voucherToken' cannot be null or empty");
    }
    try
    {
      new TransactionManager(paramCommContext.getApplicationContext()).runConfirmVoucherTransaction(paramCommContext, UUID.randomUUID().toString(), paramString);
      return;
    }
    catch (IOException paramCommContext)
    {
      Logger.w(Area.REDEEM.value(), "Unable to confirm voucher [voucher token:%1$s]", new Object[] { paramString });
    }
  }
  
  private static boolean handleTestVouchers(String paramString1, String paramString2, OnGetjarVoucherRedeemedListener paramOnGetjarVoucherRedeemedListener)
  {
    if ("00000000-0000-0000-0000-000000000001".equals(paramString2))
    {
      paramOnGetjarVoucherRedeemedListener.onVoucherRedeemed(1, null);
      return true;
    }
    if ("00000000-0000-0000-0000-000000000002".equals(paramString2))
    {
      paramOnGetjarVoucherRedeemedListener.onVoucherRedeemed(2, null);
      return true;
    }
    if ("00000000-0000-0000-0000-000000000003".equals(paramString2))
    {
      paramOnGetjarVoucherRedeemedListener.onVoucherRedeemed(3, null);
      return true;
    }
    return false;
  }
  
  public static void redeemVoucher(final CommContext paramCommContext, String paramString1, final String paramString2, final OnGetjarVoucherRedeemedListener paramOnGetjarVoucherRedeemedListener)
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'voucherToken' cannot be null or empty");
    }
    if (paramOnGetjarVoucherRedeemedListener == null) {
      throw new IllegalArgumentException("'redeemListener' cannot be null");
    }
    try
    {
      UUID.fromString(paramString1);
      _ExecutorService.execute(new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: invokestatic 43	java/util/UUID:randomUUID	()Ljava/util/UUID;
          //   3: invokevirtual 47	java/util/UUID:toString	()Ljava/lang/String;
          //   6: astore 4
          //   8: getstatic 53	com/getjar/sdk/logging/Area:REDEEM	Lcom/getjar/sdk/logging/Area;
          //   11: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   14: getstatic 60	com/getjar/sdk/logging/Area:OFFER	Lcom/getjar/sdk/logging/Area;
          //   17: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   20: lor
          //   21: ldc 62
          //   23: iconst_0
          //   24: anewarray 4	java/lang/Object
          //   27: invokestatic 68	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
          //   30: aload 4
          //   32: aload_0
          //   33: getfield 22	com/getjar/sdk/data/RedemptionEngine$1:val$voucherToken	Ljava/lang/String;
          //   36: aload_0
          //   37: getfield 24	com/getjar/sdk/data/RedemptionEngine$1:val$redeemListener	Lcom/getjar/sdk/OnGetjarVoucherRedeemedListener;
          //   40: invokestatic 72	com/getjar/sdk/data/RedemptionEngine:access$000	(Ljava/lang/String;Ljava/lang/String;Lcom/getjar/sdk/OnGetjarVoucherRedeemedListener;)Z
          //   43: ifeq +58 -> 101
          //   46: getstatic 53	com/getjar/sdk/logging/Area:REDEEM	Lcom/getjar/sdk/logging/Area;
          //   49: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   52: getstatic 60	com/getjar/sdk/logging/Area:OFFER	Lcom/getjar/sdk/logging/Area;
          //   55: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   58: lor
          //   59: ldc 74
          //   61: iconst_1
          //   62: anewarray 4	java/lang/Object
          //   65: dup
          //   66: iconst_0
          //   67: aload 4
          //   69: aastore
          //   70: invokestatic 77	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
          //   73: getstatic 53	com/getjar/sdk/logging/Area:REDEEM	Lcom/getjar/sdk/logging/Area;
          //   76: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   79: getstatic 60	com/getjar/sdk/logging/Area:OFFER	Lcom/getjar/sdk/logging/Area;
          //   82: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   85: lor
          //   86: ldc 79
          //   88: iconst_1
          //   89: anewarray 4	java/lang/Object
          //   92: dup
          //   93: iconst_0
          //   94: aload 4
          //   96: aastore
          //   97: invokestatic 68	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
          //   100: return
          //   101: getstatic 53	com/getjar/sdk/logging/Area:REDEEM	Lcom/getjar/sdk/logging/Area;
          //   104: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   107: getstatic 60	com/getjar/sdk/logging/Area:OFFER	Lcom/getjar/sdk/logging/Area;
          //   110: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   113: lor
          //   114: ldc 81
          //   116: iconst_1
          //   117: anewarray 4	java/lang/Object
          //   120: dup
          //   121: iconst_0
          //   122: aload 4
          //   124: aastore
          //   125: invokestatic 77	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
          //   128: invokestatic 87	com/getjar/sdk/comm/VoucherServiceProxy:getInstance	()Lcom/getjar/sdk/comm/VoucherServiceProxy;
          //   131: aload_0
          //   132: getfield 26	com/getjar/sdk/data/RedemptionEngine$1:val$commContext	Lcom/getjar/sdk/comm/CommContext;
          //   135: aload_0
          //   136: getfield 22	com/getjar/sdk/data/RedemptionEngine$1:val$voucherToken	Ljava/lang/String;
          //   139: aload_0
          //   140: getfield 28	com/getjar/sdk/data/RedemptionEngine$1:val$developerPayload	Ljava/lang/String;
          //   143: aload 4
          //   145: iconst_1
          //   146: invokevirtual 90	com/getjar/sdk/comm/VoucherServiceProxy:redeemVoucher	(Lcom/getjar/sdk/comm/CommContext;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/getjar/sdk/comm/Operation;
          //   149: invokevirtual 96	com/getjar/sdk/comm/Operation:get	()Lcom/getjar/sdk/comm/Result;
          //   152: astore 5
          //   154: aload 5
          //   156: ifnull +11 -> 167
          //   159: aload 5
          //   161: invokevirtual 102	com/getjar/sdk/comm/Result:isSuccessfulResponse	()Z
          //   164: ifne +190 -> 354
          //   167: aload 5
          //   169: ifnull +90 -> 259
          //   172: aload 5
          //   174: invokevirtual 105	com/getjar/sdk/comm/Result:getErrorResponseSubcode	()Ljava/lang/String;
          //   177: ifnull +82 -> 259
          //   180: aload 5
          //   182: invokevirtual 105	com/getjar/sdk/comm/Result:getErrorResponseSubcode	()Ljava/lang/String;
          //   185: ldc 107
          //   187: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   190: ifeq +69 -> 259
          //   193: aload_0
          //   194: getfield 24	com/getjar/sdk/data/RedemptionEngine$1:val$redeemListener	Lcom/getjar/sdk/OnGetjarVoucherRedeemedListener;
          //   197: iconst_3
          //   198: aconst_null
          //   199: invokeinterface 119 3 0
          //   204: getstatic 53	com/getjar/sdk/logging/Area:REDEEM	Lcom/getjar/sdk/logging/Area;
          //   207: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   210: getstatic 60	com/getjar/sdk/logging/Area:OFFER	Lcom/getjar/sdk/logging/Area;
          //   213: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   216: lor
          //   217: ldc 121
          //   219: iconst_1
          //   220: anewarray 4	java/lang/Object
          //   223: dup
          //   224: iconst_0
          //   225: aload 4
          //   227: aastore
          //   228: invokestatic 124	com/getjar/sdk/logging/Logger:e	(JLjava/lang/String;[Ljava/lang/Object;)V
          //   231: getstatic 53	com/getjar/sdk/logging/Area:REDEEM	Lcom/getjar/sdk/logging/Area;
          //   234: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   237: getstatic 60	com/getjar/sdk/logging/Area:OFFER	Lcom/getjar/sdk/logging/Area;
          //   240: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   243: lor
          //   244: ldc 79
          //   246: iconst_1
          //   247: anewarray 4	java/lang/Object
          //   250: dup
          //   251: iconst_0
          //   252: aload 4
          //   254: aastore
          //   255: invokestatic 68	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
          //   258: return
          //   259: new 126	com/getjar/sdk/exceptions/CommunicationException
          //   262: dup
          //   263: getstatic 132	java/util/Locale:US	Ljava/util/Locale;
          //   266: ldc -122
          //   268: iconst_1
          //   269: anewarray 4	java/lang/Object
          //   272: dup
          //   273: iconst_0
          //   274: aload_0
          //   275: getfield 22	com/getjar/sdk/data/RedemptionEngine$1:val$voucherToken	Ljava/lang/String;
          //   278: aastore
          //   279: invokestatic 138	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
          //   282: invokespecial 141	com/getjar/sdk/exceptions/CommunicationException:<init>	(Ljava/lang/String;)V
          //   285: athrow
          //   286: astore_2
          //   287: aload_0
          //   288: getfield 24	com/getjar/sdk/data/RedemptionEngine$1:val$redeemListener	Lcom/getjar/sdk/OnGetjarVoucherRedeemedListener;
          //   291: iconst_2
          //   292: aconst_null
          //   293: invokeinterface 119 3 0
          //   298: getstatic 53	com/getjar/sdk/logging/Area:REDEEM	Lcom/getjar/sdk/logging/Area;
          //   301: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   304: getstatic 60	com/getjar/sdk/logging/Area:OFFER	Lcom/getjar/sdk/logging/Area;
          //   307: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   310: lor
          //   311: aload_2
          //   312: ldc 121
          //   314: iconst_1
          //   315: anewarray 4	java/lang/Object
          //   318: dup
          //   319: iconst_0
          //   320: aload 4
          //   322: aastore
          //   323: invokestatic 144	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   326: getstatic 53	com/getjar/sdk/logging/Area:REDEEM	Lcom/getjar/sdk/logging/Area;
          //   329: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   332: getstatic 60	com/getjar/sdk/logging/Area:OFFER	Lcom/getjar/sdk/logging/Area;
          //   335: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   338: lor
          //   339: ldc 79
          //   341: iconst_1
          //   342: anewarray 4	java/lang/Object
          //   345: dup
          //   346: iconst_0
          //   347: aload 4
          //   349: aastore
          //   350: invokestatic 68	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
          //   353: return
          //   354: aload 5
          //   356: invokevirtual 148	com/getjar/sdk/comm/Result:getResponseJson	()Lorg/json/JSONObject;
          //   359: ldc -106
          //   361: invokevirtual 156	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
          //   364: astore_2
          //   365: aload_2
          //   366: ldc -98
          //   368: invokevirtual 162	org/json/JSONObject:has	(Ljava/lang/String;)Z
          //   371: ifeq +161 -> 532
          //   374: aload_2
          //   375: ldc -98
          //   377: invokevirtual 166	org/json/JSONObject:getInt	(Ljava/lang/String;)I
          //   380: istore_1
          //   381: aload 5
          //   383: invokevirtual 169	com/getjar/sdk/comm/Result:getSignedTransactionData	()Ljava/lang/String;
          //   386: astore 6
          //   388: aload 5
          //   390: invokevirtual 172	com/getjar/sdk/comm/Result:getTransactionSignature	()Ljava/lang/String;
          //   393: astore 7
          //   395: aconst_null
          //   396: astore_3
          //   397: aconst_null
          //   398: astore_2
          //   399: aload 5
          //   401: invokevirtual 176	com/getjar/sdk/comm/Result:getSignedLicenseData	()Ljava/util/List;
          //   404: astore 9
          //   406: aload 5
          //   408: invokevirtual 179	com/getjar/sdk/comm/Result:getLicenseSignatures	()Ljava/util/List;
          //   411: astore 8
          //   413: aload 9
          //   415: invokeinterface 185 1 0
          //   420: ifle +15 -> 435
          //   423: aload 9
          //   425: iconst_0
          //   426: invokeinterface 188 2 0
          //   431: checkcast 109	java/lang/String
          //   434: astore_2
          //   435: aload 8
          //   437: invokeinterface 185 1 0
          //   442: ifle +15 -> 457
          //   445: aload 8
          //   447: iconst_0
          //   448: invokeinterface 188 2 0
          //   453: checkcast 109	java/lang/String
          //   456: astore_3
          //   457: aload_2
          //   458: invokestatic 193	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
          //   461: ifne +19 -> 480
          //   464: aload_0
          //   465: getfield 26	com/getjar/sdk/data/RedemptionEngine$1:val$commContext	Lcom/getjar/sdk/comm/CommContext;
          //   468: invokestatic 199	com/getjar/sdk/data/LicenseEngine:initialize	(Lcom/getjar/sdk/comm/CommContext;)V
          //   471: invokestatic 202	com/getjar/sdk/data/LicenseEngine:getInstance	()Lcom/getjar/sdk/data/LicenseEngine;
          //   474: aload 5
          //   476: invokevirtual 206	com/getjar/sdk/data/LicenseEngine:updateLicenseState	(Lcom/getjar/sdk/comm/Result;)Lcom/getjar/sdk/data/LicenseInternal;
          //   479: pop
          //   480: aload_0
          //   481: getfield 24	com/getjar/sdk/data/RedemptionEngine$1:val$redeemListener	Lcom/getjar/sdk/OnGetjarVoucherRedeemedListener;
          //   484: iconst_0
          //   485: new 208	com/getjar/sdk/GetjarVoucherRedeemedResult
          //   488: dup
          //   489: iload_1
          //   490: aload 7
          //   492: aload 6
          //   494: aload_3
          //   495: aload_2
          //   496: invokespecial 211	com/getjar/sdk/GetjarVoucherRedeemedResult:<init>	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   499: invokeinterface 119 3 0
          //   504: getstatic 53	com/getjar/sdk/logging/Area:REDEEM	Lcom/getjar/sdk/logging/Area;
          //   507: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   510: getstatic 60	com/getjar/sdk/logging/Area:OFFER	Lcom/getjar/sdk/logging/Area;
          //   513: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   516: lor
          //   517: ldc 79
          //   519: iconst_1
          //   520: anewarray 4	java/lang/Object
          //   523: dup
          //   524: iconst_0
          //   525: aload 4
          //   527: aastore
          //   528: invokestatic 68	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
          //   531: return
          //   532: iconst_0
          //   533: istore_1
          //   534: goto -153 -> 381
          //   537: astore_2
          //   538: aload_0
          //   539: getfield 24	com/getjar/sdk/data/RedemptionEngine$1:val$redeemListener	Lcom/getjar/sdk/OnGetjarVoucherRedeemedListener;
          //   542: iconst_1
          //   543: aconst_null
          //   544: invokeinterface 119 3 0
          //   549: getstatic 53	com/getjar/sdk/logging/Area:REDEEM	Lcom/getjar/sdk/logging/Area;
          //   552: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   555: getstatic 60	com/getjar/sdk/logging/Area:OFFER	Lcom/getjar/sdk/logging/Area;
          //   558: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   561: lor
          //   562: aload_2
          //   563: ldc 121
          //   565: iconst_1
          //   566: anewarray 4	java/lang/Object
          //   569: dup
          //   570: iconst_0
          //   571: aload 4
          //   573: aastore
          //   574: invokestatic 144	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   577: getstatic 53	com/getjar/sdk/logging/Area:REDEEM	Lcom/getjar/sdk/logging/Area;
          //   580: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   583: getstatic 60	com/getjar/sdk/logging/Area:OFFER	Lcom/getjar/sdk/logging/Area;
          //   586: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   589: lor
          //   590: ldc 79
          //   592: iconst_1
          //   593: anewarray 4	java/lang/Object
          //   596: dup
          //   597: iconst_0
          //   598: aload 4
          //   600: aastore
          //   601: invokestatic 68	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
          //   604: return
          //   605: astore_2
          //   606: getstatic 53	com/getjar/sdk/logging/Area:REDEEM	Lcom/getjar/sdk/logging/Area;
          //   609: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   612: getstatic 60	com/getjar/sdk/logging/Area:OFFER	Lcom/getjar/sdk/logging/Area;
          //   615: invokevirtual 57	com/getjar/sdk/logging/Area:value	()J
          //   618: lor
          //   619: ldc 79
          //   621: iconst_1
          //   622: anewarray 4	java/lang/Object
          //   625: dup
          //   626: iconst_0
          //   627: aload 4
          //   629: aastore
          //   630: invokestatic 68	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
          //   633: aload_2
          //   634: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	635	0	this	1
          //   380	154	1	i	int
          //   286	26	2	localAuthException	com.getjar.sdk.exceptions.AuthException
          //   364	132	2	localObject1	Object
          //   537	26	2	localException	Exception
          //   605	29	2	localObject2	Object
          //   396	99	3	str1	String
          //   6	622	4	str2	String
          //   152	323	5	localResult	com.getjar.sdk.comm.Result
          //   386	107	6	str3	String
          //   393	98	7	str4	String
          //   411	35	8	localList1	java.util.List
          //   404	20	9	localList2	java.util.List
          // Exception table:
          //   from	to	target	type
          //   8	73	286	com/getjar/sdk/exceptions/AuthException
          //   101	154	286	com/getjar/sdk/exceptions/AuthException
          //   159	167	286	com/getjar/sdk/exceptions/AuthException
          //   172	231	286	com/getjar/sdk/exceptions/AuthException
          //   259	286	286	com/getjar/sdk/exceptions/AuthException
          //   354	381	286	com/getjar/sdk/exceptions/AuthException
          //   381	395	286	com/getjar/sdk/exceptions/AuthException
          //   399	413	286	com/getjar/sdk/exceptions/AuthException
          //   413	435	286	com/getjar/sdk/exceptions/AuthException
          //   435	457	286	com/getjar/sdk/exceptions/AuthException
          //   457	480	286	com/getjar/sdk/exceptions/AuthException
          //   480	504	286	com/getjar/sdk/exceptions/AuthException
          //   8	73	537	java/lang/Exception
          //   101	154	537	java/lang/Exception
          //   159	167	537	java/lang/Exception
          //   172	231	537	java/lang/Exception
          //   259	286	537	java/lang/Exception
          //   354	381	537	java/lang/Exception
          //   381	395	537	java/lang/Exception
          //   399	413	537	java/lang/Exception
          //   413	435	537	java/lang/Exception
          //   435	457	537	java/lang/Exception
          //   457	480	537	java/lang/Exception
          //   480	504	537	java/lang/Exception
          //   8	73	605	finally
          //   101	154	605	finally
          //   159	167	605	finally
          //   172	231	605	finally
          //   259	286	605	finally
          //   287	326	605	finally
          //   354	381	605	finally
          //   381	395	605	finally
          //   399	413	605	finally
          //   413	435	605	finally
          //   435	457	605	finally
          //   457	480	605	finally
          //   480	504	605	finally
          //   538	577	605	finally
        }
      });
      return;
    }
    catch (IllegalArgumentException paramCommContext)
    {
      throw new IllegalArgumentException(String.format(Locale.US, "'getjarIntent' 'voucherToken' extra does not contain a valid UUID [%1$s]", new Object[] { paramString1 }));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/RedemptionEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */