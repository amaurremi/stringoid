package com.inmobi.monetization.internal.carb;

import android.os.Handler;
import android.os.Looper;
import com.inmobi.commons.internal.EncryptionUtils;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import com.inmobi.monetization.internal.configs.PkInitilaizer;
import com.inmobi.monetization.internal.configs.PkParams;

import java.util.ArrayList;

import org.json.JSONArray;

class CARB$b
        implements Runnable {
    int a = 1;

    CARB$b(CARB paramCARB, ArrayList paramArrayList, String paramString, int paramInt) {
    }

    /* Error */
    private int a(String paramString) {
        // Byte code:
        //   0: invokestatic 44	com/inmobi/commons/internal/InternalSDKUtil:getContext	()Landroid/content/Context;
        //   3: invokestatic 48	com/inmobi/commons/internal/InternalSDKUtil:checkNetworkAvailibility	(Landroid/content/Context;)Z
        //   6: ifne +5 -> 11
        //   9: iconst_m1
        //   10: ireturn
        //   11: new 50	java/net/URL
        //   14: dup
        //   15: invokestatic 56	com/inmobi/monetization/internal/carb/CarbInitializer:getConfigParams	()Lcom/inmobi/monetization/internal/carb/CarbConfigParams;
        //   18: invokevirtual 62	com/inmobi/monetization/internal/carb/CarbConfigParams:getCarbPostpoint	()Ljava/lang/String;
        //   21: invokespecial 65	java/net/URL:<init>	(Ljava/lang/String;)V
        //   24: astore 5
        //   26: aload 5
        //   28: invokevirtual 69	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   31: checkcast 71	java/net/HttpURLConnection
        //   34: astore 6
        //   36: aload 6
        //   38: ldc 73
        //   40: invokestatic 76	com/inmobi/commons/internal/InternalSDKUtil:getUserAgent	()Ljava/lang/String;
        //   43: invokevirtual 80	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   46: invokestatic 56	com/inmobi/monetization/internal/carb/CarbInitializer:getConfigParams	()Lcom/inmobi/monetization/internal/carb/CarbConfigParams;
        //   49: invokevirtual 84	com/inmobi/monetization/internal/carb/CarbConfigParams:getTimeoutInterval	()J
        //   52: ldc2_w 85
        //   55: lmul
        //   56: lstore_3
        //   57: aload 6
        //   59: lload_3
        //   60: l2i
        //   61: invokevirtual 90	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   64: aload 6
        //   66: lload_3
        //   67: l2i
        //   68: invokevirtual 93	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   71: aload 6
        //   73: ldc 95
        //   75: invokestatic 100	com/inmobi/commons/data/DeviceInfo:getPhoneDefaultUserAgent	()Ljava/lang/String;
        //   78: invokevirtual 80	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   81: aload 6
        //   83: iconst_0
        //   84: invokevirtual 104	java/net/HttpURLConnection:setUseCaches	(Z)V
        //   87: aload 6
        //   89: iconst_1
        //   90: invokevirtual 107	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   93: aload 6
        //   95: iconst_1
        //   96: invokevirtual 110	java/net/HttpURLConnection:setDoInput	(Z)V
        //   99: aload 6
        //   101: ldc 112
        //   103: invokevirtual 115	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   106: aload 6
        //   108: ldc 117
        //   110: ldc 119
        //   112: invokevirtual 80	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   115: aload 6
        //   117: ldc 121
        //   119: aload_1
        //   120: invokevirtual 127	java/lang/String:length	()I
        //   123: invokestatic 133	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   126: invokevirtual 80	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   129: aload 5
        //   131: invokevirtual 136	java/net/URL:getHost	()Ljava/lang/String;
        //   134: invokestatic 142	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
        //   137: pop
        //   138: new 144	java/io/BufferedWriter
        //   141: dup
        //   142: new 146	java/io/OutputStreamWriter
        //   145: dup
        //   146: aload 6
        //   148: invokevirtual 150	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   151: invokespecial 153	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
        //   154: invokespecial 156	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
        //   157: astore 5
        //   159: aload 5
        //   161: aload_1
        //   162: invokevirtual 159	java/io/BufferedWriter:write	(Ljava/lang/String;)V
        //   165: aload 5
        //   167: ifnull +8 -> 175
        //   170: aload 5
        //   172: invokevirtual 162	java/io/BufferedWriter:close	()V
        //   175: aload 6
        //   177: invokevirtual 165	java/net/HttpURLConnection:getResponseCode	()I
        //   180: sipush 200
        //   183: if_icmpne +131 -> 314
        //   186: sipush 200
        //   189: ireturn
        //   190: astore_1
        //   191: new 34	java/net/MalformedURLException
        //   194: dup
        //   195: new 167	java/lang/StringBuilder
        //   198: dup
        //   199: invokespecial 168	java/lang/StringBuilder:<init>	()V
        //   202: ldc -86
        //   204: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   207: aload 5
        //   209: invokevirtual 176	java/net/URL:toString	()Ljava/lang/String;
        //   212: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   215: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   218: invokespecial 178	java/net/MalformedURLException:<init>	(Ljava/lang/String;)V
        //   221: athrow
        //   222: astore_1
        //   223: ldc -76
        //   225: ldc -74
        //   227: invokestatic 187	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   230: iconst_m1
        //   231: ireturn
        //   232: astore_1
        //   233: ldc -67
        //   235: new 167	java/lang/StringBuilder
        //   238: dup
        //   239: invokespecial 168	java/lang/StringBuilder:<init>	()V
        //   242: ldc -65
        //   244: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   247: aload 5
        //   249: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   252: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   255: aload_1
        //   256: invokestatic 197	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   259: goto -84 -> 175
        //   262: astore_1
        //   263: goto -33 -> 230
        //   266: astore_1
        //   267: aconst_null
        //   268: astore 5
        //   270: aload 5
        //   272: ifnull +8 -> 280
        //   275: aload 5
        //   277: invokevirtual 162	java/io/BufferedWriter:close	()V
        //   280: aload_1
        //   281: athrow
        //   282: astore 6
        //   284: ldc -67
        //   286: new 167	java/lang/StringBuilder
        //   289: dup
        //   290: invokespecial 168	java/lang/StringBuilder:<init>	()V
        //   293: ldc -65
        //   295: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   298: aload 5
        //   300: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   303: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   306: aload 6
        //   308: invokestatic 197	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   311: goto -31 -> 280
        //   314: aload 6
        //   316: invokevirtual 165	java/net/HttpURLConnection:getResponseCode	()I
        //   319: istore_2
        //   320: iload_2
        //   321: ireturn
        //   322: astore_1
        //   323: goto -53 -> 270
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	326	0	this	b
        //   0	326	1	paramString	String
        //   319	2	2	i	int
        //   56	11	3	l	long
        //   24	275	5	localObject	Object
        //   34	142	6	localHttpURLConnection	java.net.HttpURLConnection
        //   282	33	6	localIOException	java.io.IOException
        // Exception table:
        //   from	to	target	type
        //   129	138	190	java/net/UnknownHostException
        //   11	129	222	java/net/MalformedURLException
        //   129	138	222	java/net/MalformedURLException
        //   170	175	222	java/net/MalformedURLException
        //   175	186	222	java/net/MalformedURLException
        //   191	222	222	java/net/MalformedURLException
        //   233	259	222	java/net/MalformedURLException
        //   275	280	222	java/net/MalformedURLException
        //   280	282	222	java/net/MalformedURLException
        //   284	311	222	java/net/MalformedURLException
        //   314	320	222	java/net/MalformedURLException
        //   170	175	232	java/io/IOException
        //   11	129	262	java/io/IOException
        //   129	138	262	java/io/IOException
        //   175	186	262	java/io/IOException
        //   191	222	262	java/io/IOException
        //   233	259	262	java/io/IOException
        //   280	282	262	java/io/IOException
        //   284	311	262	java/io/IOException
        //   314	320	262	java/io/IOException
        //   138	159	266	finally
        //   275	280	282	java/io/IOException
        //   159	165	322	finally
    }

    private String a(ArrayList<CarbInfo> paramArrayList, String paramString, int paramInt) {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("req_id=");
        localStringBuffer.append(CARB.getURLEncoded(paramString));
        paramString = new JSONArray();
        int j = paramArrayList.size();
        int i = 0;
        while (i < j) {
            paramString.put(((CarbInfo) paramArrayList.get(i)).getInmId());
            i += 1;
        }
        localStringBuffer.append("&p_a_apps=");
        localStringBuffer.append(CARB.getURLEncoded(paramString.toString()));
        localStringBuffer.append("&i_till=");
        localStringBuffer.append(paramInt);
        paramArrayList = CarbInitializer.getConfigParams().getDeviceIdMaskMap();
        paramArrayList = UID.getInstance().getJSON(paramArrayList);
        localStringBuffer.append("&u-id-map=");
        localStringBuffer.append(CARB.getURLEncoded(paramArrayList));
        return localStringBuffer.toString();
    }

    public void run() {
        CARB.h(this.e);
        CARB.b(this.e, EncryptionUtils.keag());
        this.e.c = PkInitilaizer.getConfigParams().getExponent();
        this.e.d = PkInitilaizer.getConfigParams().getModulus();
        this.e.e = PkInitilaizer.getConfigParams().getVersion();
        if ((this.e.c.equals("")) || (this.e.d.equals("")) || (this.e.e.equals(""))) {
            Log.internal("[InMobi]-[CARB]-4.5.1", "Exception retreiving Carb info due to key problem");
            CARB.f(this.e);
            return;
        }
        String str = a(this.b, this.c, this.d);
        Log.internal("[InMobi]-[CARB]-4.5.1", "PostBody Before encryption: " + str);
        str = CARB.a(this.e, str, CARB.i(this.e), CARB.j(this.e), this.e.b, this.e.d, this.e.c);
        if (str == null) {
            Log.internal("[InMobi]-[CARB]-4.5.1", "POST message cannot be encrypted");
            CARB.b(this.e);
            return;
        }
        int i = a(str);
        Log.internal("[InMobi]-[CARB]-4.5.1", "Post Response to CARB server: " + i);
        if (200 == i) {
            if (this.e.f != null) {
                this.e.f.postSuccess();
            }
            CARB.f(this.e);
            return;
        }
        if (this.e.f != null) {
            this.e.f.postFailed();
        }
        i = CarbInitializer.getConfigParams().getRetryCount();
        long l = CarbInitializer.getConfigParams().getRetryInterval();
        if (this.a <= i) {
        }
        try {
            Thread.sleep(this.a * (l * 1000L));
            Log.internal("[InMobi]-[CARB]-4.5.1", "POSt to carb failed. Retrying count: " + this.a);
            this.a += 1;
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            new Handler().postDelayed(this, 0L);
            Looper.loop();
            Looper.myLooper().quit();
            return;
            this.a = 0;
            CARB.f(this.e);
            return;
        } catch (InterruptedException localInterruptedException) {
            for (; ; ) {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/carb/CARB$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */