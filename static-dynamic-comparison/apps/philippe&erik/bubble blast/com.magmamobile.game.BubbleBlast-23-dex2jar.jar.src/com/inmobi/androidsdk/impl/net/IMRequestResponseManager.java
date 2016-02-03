package com.inmobi.androidsdk.impl.net;

import android.util.Log;
import android.view.MotionEvent;
import com.inmobi.androidsdk.impl.IMAdException;
import com.inmobi.androidsdk.impl.IMAdUnit;
import com.inmobi.androidsdk.impl.IMNiceInfo;
import com.inmobi.androidsdk.impl.IMUserInfo;
import com.inmobi.androidsdk.impl.IMXMLParser;
import com.inmobi.commons.internal.IMLog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class IMRequestResponseManager
{
  private String a = null;
  private AtomicBoolean b = new AtomicBoolean();
  private HttpURLConnection c;
  
  private IMAdUnit a(IMUserInfo paramIMUserInfo)
    throws IMAdException, IOException
  {
    IMAdUnit localIMAdUnit = null;
    IMLog.debug("InMobiAndroidSDK_3.6.1", "Http Status Code: " + this.c.getResponseCode());
    if (this.c.getResponseCode() == 200) {}
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(this.c.getInputStream(), "UTF-8"));
      try
      {
        localObject1 = new StringBuilder();
        for (;;)
        {
          String str = localBufferedReader.readLine();
          if (str == null)
          {
            str = ((StringBuilder)localObject1).toString();
            Log.d("InMobiAndroidSDK_3.6.1", "Ad Response: " + str);
            Object localObject2 = this.c.getHeaderFields();
            localObject1 = localIMAdUnit;
            if (localObject2 != null)
            {
              localObject1 = localIMAdUnit;
              if (((Map)localObject2).containsKey("x-mkhoj-ph"))
              {
                localObject2 = (List)((Map)localObject2).get("x-mkhoj-ph");
                localObject1 = localIMAdUnit;
                if (localObject2 != null)
                {
                  localObject1 = localIMAdUnit;
                  if (((List)localObject2).size() == 1) {
                    localObject1 = ((String)((List)localObject2).get(0)).trim();
                  }
                }
              }
            }
            localIMAdUnit = IMXMLParser.buildAdUnitFromResponseData(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str.getBytes()), "UTF-8")));
            IMLog.debug("InMobiAndroidSDK_3.6.1", "Retrieved AdUnit: " + localIMAdUnit);
            a(localIMAdUnit, paramIMUserInfo, (String)localObject1);
            this.c.disconnect();
            a(localBufferedReader);
            return localIMAdUnit;
          }
          ((StringBuilder)localObject1).append(str).append("\n");
        }
        this.c.disconnect();
      }
      finally
      {
        localObject1 = localBufferedReader;
      }
    }
    finally
    {
      Object localObject1 = null;
    }
    a((Closeable)localObject1);
    throw paramIMUserInfo;
    IMLog.debug("InMobiAndroidSDK_3.6.1", "Invalid Request. This may be because of invalid appId or appId might not be in 'active' state.");
    throw new IMAdException("Server did not return 200.", 300);
  }
  
  private String a(IMUserInfo paramIMUserInfo, String paramString1, String paramString2)
  {
    if (paramIMUserInfo.isTestMode()) {
      return paramString2;
    }
    return paramString1;
  }
  
  private String a(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    try
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "HTTP Response Code: " + paramHttpURLConnection.getResponseCode());
      if ((0 != 0) && (!paramString.equalsIgnoreCase(null))) {
        break label158;
      }
      str = paramHttpURLConnection.getURL().toString();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        String str;
        IMLog.debug("InMobiAndroidSDK_3.6.1", "Exception getting response code for redirection URL", localIOException);
        label158:
        Object localObject = null;
        continue;
        paramString = (String)localObject;
      }
    }
    if ((str == null) || (paramString.equalsIgnoreCase(str)))
    {
      paramString = paramHttpURLConnection.getHeaderField("location");
      paramHttpURLConnection = paramHttpURLConnection.getHeaderFields();
      if ((paramHttpURLConnection != null) && (paramHttpURLConnection.containsKey("action-name")))
      {
        paramHttpURLConnection = (List)paramHttpURLConnection.get("action-name");
        if ((paramHttpURLConnection != null) && (paramHttpURLConnection.size() == 1)) {
          setNewAdActionType(((String)paramHttpURLConnection.get(0)).trim());
        }
      }
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Redirection URL: " + paramString);
      return paramString;
    }
  }
  
  private HttpURLConnection a(String paramString, IMUserInfo paramIMUserInfo, ActionType paramActionType)
    throws IOException
  {
    this.c = ((HttpURLConnection)new URL(paramString).openConnection());
    a(this.c, paramIMUserInfo, paramActionType);
    return this.c;
  }
  
  private void a(int paramInt, Object paramObject, IMHttpRequestCallback paramIMHttpRequestCallback)
  {
    if (this.b.get()) {}
    while (paramIMHttpRequestCallback == null) {
      return;
    }
    paramIMHttpRequestCallback.notifyResult(paramInt, paramObject);
  }
  
  private void a(IMAdUnit paramIMAdUnit, IMUserInfo paramIMUserInfo, String paramString)
  {
    if (paramIMAdUnit == null) {
      return;
    }
    paramIMAdUnit.setSendDeviceInfo(true);
    paramIMAdUnit.setDeviceInfoUploadUrl(paramString);
  }
  
  private void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Exception closing resource: " + paramCloseable, localIOException);
    }
  }
  
  private void a(String paramString)
    throws IOException
  {
    this.c.setRequestProperty("Content-Length", Integer.toString(paramString.length()));
    try
    {
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(this.c.getOutputStream()));
      a(localBufferedWriter);
    }
    finally
    {
      try
      {
        localBufferedWriter.write(paramString);
        a(localBufferedWriter);
        return;
      }
      finally {}
      paramString = finally;
      localBufferedWriter = null;
    }
    throw paramString;
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection, IMUserInfo paramIMUserInfo, ActionType paramActionType)
    throws ProtocolException
  {
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setReadTimeout(30000);
    paramHttpURLConnection.setRequestProperty("user-agent", paramIMUserInfo.getPhoneDefaultUserAgent());
    String str;
    if (paramIMUserInfo.isTestMode())
    {
      str = "YES";
      paramHttpURLConnection.setRequestProperty("x-mkhoj-testmode", str);
      paramHttpURLConnection.setUseCaches(false);
      if (paramActionType != ActionType.AdClick) {
        break label98;
      }
      paramHttpURLConnection.setRequestMethod("GET");
      label63:
      if (paramIMUserInfo.isTestMode()) {
        if (paramIMUserInfo.getTestModeAdActionType() == null) {
          break label128;
        }
      }
    }
    label98:
    label128:
    for (paramIMUserInfo = paramIMUserInfo.getTestModeAdActionType();; paramIMUserInfo = "web")
    {
      paramHttpURLConnection.setRequestProperty("x-mkhoj-adactiontype", paramIMUserInfo);
      return;
      str = "NO";
      break;
      paramHttpURLConnection.setDoOutput(true);
      paramHttpURLConnection.setDoInput(true);
      paramHttpURLConnection.setRequestMethod("POST");
      paramHttpURLConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
      break label63;
    }
  }
  
  public void asyncRequestAd(final IMUserInfo paramIMUserInfo, final IMNiceInfo paramIMNiceInfo, final ActionType paramActionType, final String paramString1, final String paramString2, final IMHttpRequestCallback paramIMHttpRequestCallback)
  {
    new Thread()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   4: aload_0
        //   5: getfield 30	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:c	Lcom/inmobi/androidsdk/impl/IMUserInfo;
        //   8: aload_0
        //   9: getfield 32	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:d	Ljava/lang/String;
        //   12: aload_0
        //   13: getfield 34	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:e	Ljava/lang/String;
        //   16: invokestatic 52	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;Lcom/inmobi/androidsdk/impl/IMUserInfo;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   19: astore_2
        //   20: ldc 54
        //   22: new 56	java/lang/StringBuilder
        //   25: dup
        //   26: ldc 58
        //   28: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   31: aload_2
        //   32: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   35: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   38: invokestatic 75	com/inmobi/commons/internal/IMLog:debug	(Ljava/lang/String;Ljava/lang/String;)V
        //   41: aload_0
        //   42: getfield 30	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:c	Lcom/inmobi/androidsdk/impl/IMUserInfo;
        //   45: aload_0
        //   46: getfield 36	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:f	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager$ActionType;
        //   49: invokestatic 80	com/inmobi/androidsdk/impl/net/IMHttpRequestBuilder:a	(Lcom/inmobi/androidsdk/impl/IMUserInfo;Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager$ActionType;)Ljava/lang/String;
        //   52: astore_3
        //   53: ldc 54
        //   55: aload_3
        //   56: invokestatic 85	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   59: pop
        //   60: aload_0
        //   61: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   64: aload_0
        //   65: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   68: aload_2
        //   69: aload_0
        //   70: getfield 30	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:c	Lcom/inmobi/androidsdk/impl/IMUserInfo;
        //   73: aload_0
        //   74: getfield 36	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:f	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager$ActionType;
        //   77: invokestatic 88	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;Ljava/lang/String;Lcom/inmobi/androidsdk/impl/IMUserInfo;Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager$ActionType;)Ljava/net/HttpURLConnection;
        //   80: invokestatic 91	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;Ljava/net/HttpURLConnection;)V
        //   83: aload_0
        //   84: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   87: aload_3
        //   88: invokestatic 94	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;Ljava/lang/String;)V
        //   91: aload_0
        //   92: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   95: aload_0
        //   96: getfield 30	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:c	Lcom/inmobi/androidsdk/impl/IMUserInfo;
        //   99: invokestatic 97	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;Lcom/inmobi/androidsdk/impl/IMUserInfo;)Lcom/inmobi/androidsdk/impl/IMAdUnit;
        //   102: astore_2
        //   103: aload_0
        //   104: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   107: iconst_0
        //   108: aload_2
        //   109: aload_0
        //   110: getfield 38	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:g	Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;
        //   113: invokestatic 100	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;ILjava/lang/Object;Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;)V
        //   116: aload_0
        //   117: getfield 28	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:b	Lcom/inmobi/androidsdk/impl/IMNiceInfo;
        //   120: aload_0
        //   121: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   124: invokestatic 103	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;)Ljava/net/HttpURLConnection;
        //   127: invokevirtual 109	com/inmobi/androidsdk/impl/IMNiceInfo:processNiceParams	(Ljava/net/HttpURLConnection;)V
        //   130: return
        //   131: astore_2
        //   132: ldc 54
        //   134: ldc 111
        //   136: aload_2
        //   137: invokestatic 114	com/inmobi/commons/internal/IMLog:debug	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   140: aload_2
        //   141: invokevirtual 118	com/inmobi/androidsdk/impl/IMAdException:getCode	()I
        //   144: istore_1
        //   145: iload_1
        //   146: lookupswitch	default:+74->220, 100:+124->270, 200:+142->288, 300:+89->235, 400:+160->306, 500:+178->324, 600:+196->342, 700:+214->360, 800:+232->378
        //   220: aload_0
        //   221: getfield 28	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:b	Lcom/inmobi/androidsdk/impl/IMNiceInfo;
        //   224: aload_0
        //   225: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   228: invokestatic 103	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;)Ljava/net/HttpURLConnection;
        //   231: invokevirtual 109	com/inmobi/androidsdk/impl/IMNiceInfo:processNiceParams	(Ljava/net/HttpURLConnection;)V
        //   234: return
        //   235: aload_0
        //   236: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   239: iconst_1
        //   240: getstatic 124	com/inmobi/androidsdk/IMAdRequest$ErrorCode:INVALID_REQUEST	Lcom/inmobi/androidsdk/IMAdRequest$ErrorCode;
        //   243: aload_0
        //   244: getfield 38	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:g	Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;
        //   247: invokestatic 100	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;ILjava/lang/Object;Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;)V
        //   250: goto -30 -> 220
        //   253: astore_2
        //   254: aload_0
        //   255: getfield 28	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:b	Lcom/inmobi/androidsdk/impl/IMNiceInfo;
        //   258: aload_0
        //   259: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   262: invokestatic 103	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;)Ljava/net/HttpURLConnection;
        //   265: invokevirtual 109	com/inmobi/androidsdk/impl/IMNiceInfo:processNiceParams	(Ljava/net/HttpURLConnection;)V
        //   268: aload_2
        //   269: athrow
        //   270: aload_0
        //   271: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   274: iconst_1
        //   275: getstatic 127	com/inmobi/androidsdk/IMAdRequest$ErrorCode:NO_FILL	Lcom/inmobi/androidsdk/IMAdRequest$ErrorCode;
        //   278: aload_0
        //   279: getfield 38	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:g	Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;
        //   282: invokestatic 100	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;ILjava/lang/Object;Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;)V
        //   285: goto -65 -> 220
        //   288: aload_0
        //   289: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   292: iconst_1
        //   293: getstatic 130	com/inmobi/androidsdk/IMAdRequest$ErrorCode:INTERNAL_ERROR	Lcom/inmobi/androidsdk/IMAdRequest$ErrorCode;
        //   296: aload_0
        //   297: getfield 38	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:g	Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;
        //   300: invokestatic 100	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;ILjava/lang/Object;Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;)V
        //   303: goto -83 -> 220
        //   306: aload_0
        //   307: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   310: iconst_1
        //   311: getstatic 124	com/inmobi/androidsdk/IMAdRequest$ErrorCode:INVALID_REQUEST	Lcom/inmobi/androidsdk/IMAdRequest$ErrorCode;
        //   314: aload_0
        //   315: getfield 38	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:g	Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;
        //   318: invokestatic 100	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;ILjava/lang/Object;Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;)V
        //   321: goto -101 -> 220
        //   324: aload_0
        //   325: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   328: iconst_1
        //   329: getstatic 124	com/inmobi/androidsdk/IMAdRequest$ErrorCode:INVALID_REQUEST	Lcom/inmobi/androidsdk/IMAdRequest$ErrorCode;
        //   332: aload_0
        //   333: getfield 38	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:g	Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;
        //   336: invokestatic 100	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;ILjava/lang/Object;Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;)V
        //   339: goto -119 -> 220
        //   342: aload_0
        //   343: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   346: iconst_1
        //   347: getstatic 124	com/inmobi/androidsdk/IMAdRequest$ErrorCode:INVALID_REQUEST	Lcom/inmobi/androidsdk/IMAdRequest$ErrorCode;
        //   350: aload_0
        //   351: getfield 38	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:g	Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;
        //   354: invokestatic 100	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;ILjava/lang/Object;Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;)V
        //   357: goto -137 -> 220
        //   360: aload_0
        //   361: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   364: iconst_1
        //   365: getstatic 124	com/inmobi/androidsdk/IMAdRequest$ErrorCode:INVALID_REQUEST	Lcom/inmobi/androidsdk/IMAdRequest$ErrorCode;
        //   368: aload_0
        //   369: getfield 38	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:g	Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;
        //   372: invokestatic 100	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;ILjava/lang/Object;Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;)V
        //   375: goto -155 -> 220
        //   378: aload_0
        //   379: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   382: iconst_1
        //   383: getstatic 133	com/inmobi/androidsdk/IMAdRequest$ErrorCode:INVALID_APP_ID	Lcom/inmobi/androidsdk/IMAdRequest$ErrorCode;
        //   386: aload_0
        //   387: getfield 38	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:g	Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;
        //   390: invokestatic 100	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;ILjava/lang/Object;Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;)V
        //   393: goto -173 -> 220
        //   396: astore_2
        //   397: ldc 54
        //   399: ldc 111
        //   401: aload_2
        //   402: invokestatic 114	com/inmobi/commons/internal/IMLog:debug	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   405: aload_2
        //   406: instanceof 135
        //   409: ifeq +33 -> 442
        //   412: aload_0
        //   413: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   416: iconst_1
        //   417: getstatic 138	com/inmobi/androidsdk/IMAdRequest$ErrorCode:AD_FETCH_TIMEOUT	Lcom/inmobi/androidsdk/IMAdRequest$ErrorCode;
        //   420: aload_0
        //   421: getfield 38	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:g	Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;
        //   424: invokestatic 100	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;ILjava/lang/Object;Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;)V
        //   427: aload_0
        //   428: getfield 28	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:b	Lcom/inmobi/androidsdk/impl/IMNiceInfo;
        //   431: aload_0
        //   432: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   435: invokestatic 103	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;)Ljava/net/HttpURLConnection;
        //   438: invokevirtual 109	com/inmobi/androidsdk/impl/IMNiceInfo:processNiceParams	(Ljava/net/HttpURLConnection;)V
        //   441: return
        //   442: aload_0
        //   443: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   446: iconst_1
        //   447: getstatic 141	com/inmobi/androidsdk/IMAdRequest$ErrorCode:NETWORK_ERROR	Lcom/inmobi/androidsdk/IMAdRequest$ErrorCode;
        //   450: aload_0
        //   451: getfield 38	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:g	Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;
        //   454: invokestatic 100	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;ILjava/lang/Object;Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;)V
        //   457: goto -30 -> 427
        //   460: astore_2
        //   461: ldc 54
        //   463: ldc 111
        //   465: aload_2
        //   466: invokestatic 114	com/inmobi/commons/internal/IMLog:debug	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   469: aload_0
        //   470: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   473: iconst_1
        //   474: getstatic 130	com/inmobi/androidsdk/IMAdRequest$ErrorCode:INTERNAL_ERROR	Lcom/inmobi/androidsdk/IMAdRequest$ErrorCode;
        //   477: aload_0
        //   478: getfield 38	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:g	Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;
        //   481: invokestatic 100	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;ILjava/lang/Object;Lcom/inmobi/androidsdk/impl/net/IMHttpRequestCallback;)V
        //   484: aload_0
        //   485: getfield 28	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:b	Lcom/inmobi/androidsdk/impl/IMNiceInfo;
        //   488: aload_0
        //   489: getfield 26	com/inmobi/androidsdk/impl/net/IMRequestResponseManager$1:a	Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;
        //   492: invokestatic 103	com/inmobi/androidsdk/impl/net/IMRequestResponseManager:a	(Lcom/inmobi/androidsdk/impl/net/IMRequestResponseManager;)Ljava/net/HttpURLConnection;
        //   495: invokevirtual 109	com/inmobi/androidsdk/impl/IMNiceInfo:processNiceParams	(Ljava/net/HttpURLConnection;)V
        //   498: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	499	0	this	1
        //   144	2	1	i	int
        //   19	90	2	localObject1	Object
        //   131	10	2	localIMAdException	IMAdException
        //   253	16	2	localObject2	Object
        //   396	10	2	localIOException	IOException
        //   460	6	2	localException	Exception
        //   52	36	3	str	String
        // Exception table:
        //   from	to	target	type
        //   0	116	131	com/inmobi/androidsdk/impl/IMAdException
        //   0	116	253	finally
        //   132	145	253	finally
        //   235	250	253	finally
        //   270	285	253	finally
        //   288	303	253	finally
        //   306	321	253	finally
        //   324	339	253	finally
        //   342	357	253	finally
        //   360	375	253	finally
        //   378	393	253	finally
        //   397	427	253	finally
        //   442	457	253	finally
        //   461	484	253	finally
        //   0	116	396	java/io/IOException
        //   0	116	460	java/lang/Exception
      }
    }.start();
  }
  
  public void doCancel()
  {
    this.b.set(true);
    if (this.c != null) {
      this.c.disconnect();
    }
  }
  
  public String getNewAdActionType()
  {
    return this.a;
  }
  
  public String initiateClick(String paramString, IMUserInfo paramIMUserInfo, MotionEvent paramMotionEvent, List<?> paramList)
    throws IOException
  {
    String str = IMHttpRequestBuilder.appendClickParams(paramString, paramMotionEvent, paramIMUserInfo.getScreenDensity());
    IMLog.debug("InMobiAndroidSDK_3.6.1", ">>> Enter initiateClick, clickURL : " + str);
    HttpURLConnection.setFollowRedirects(false);
    paramMotionEvent = null;
    paramString = paramMotionEvent;
    if (paramList != null)
    {
      paramString = paramMotionEvent;
      if (!paramList.isEmpty())
      {
        paramString = paramMotionEvent;
        if ("x-mkhoj-adactiontype".equals(paramList.get(0))) {
          paramString = (String)paramList.get(1);
        }
      }
    }
    paramMotionEvent = a(str, paramIMUserInfo, ActionType.AdClick);
    if ((paramString != null) && (!paramIMUserInfo.isTestMode())) {
      paramMotionEvent.setRequestProperty("x-mkhoj-adactionType", paramString);
    }
    return a(paramMotionEvent, str);
  }
  
  public void setNewAdActionType(String paramString)
  {
    this.a = paramString;
  }
  
  public static enum ActionType {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/impl/net/IMRequestResponseManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */