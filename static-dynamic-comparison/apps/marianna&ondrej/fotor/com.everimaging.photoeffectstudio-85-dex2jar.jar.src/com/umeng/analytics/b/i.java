package com.umeng.analytics.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.umeng.a.a.a.b.a.a;
import com.umeng.a.a.a.g;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.a;
import com.umeng.analytics.a.f;
import com.umeng.analytics.d.v;
import com.umeng.common.Log;
import com.umeng.common.b;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class i {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    private final int d = 1;
    private String e;
    private String f = "10.0.0.172";
    private int g = 80;
    private Context h;
    private o i;
    private f j;

    public i(Context paramContext) {
        this.h = paramContext;
        this.j = com.umeng.analytics.a.h.b(paramContext);
        this.e = a(paramContext);
    }

    private String a(Context paramContext) {
        StringBuffer localStringBuffer1 = new StringBuffer();
        localStringBuffer1.append("Android");
        localStringBuffer1.append("/");
        localStringBuffer1.append("5.2.2");
        localStringBuffer1.append(" ");
        try {
            StringBuffer localStringBuffer2 = new StringBuffer();
            localStringBuffer2.append(b.v(paramContext));
            localStringBuffer2.append("/");
            localStringBuffer2.append(b.d(paramContext));
            localStringBuffer2.append(" ");
            localStringBuffer2.append(Build.MODEL);
            localStringBuffer2.append("/");
            localStringBuffer2.append(Build.VERSION.RELEASE);
            localStringBuffer2.append(" ");
            localStringBuffer2.append(com.umeng.common.util.h.a(AnalyticsConfig.getAppkey(paramContext)));
            localStringBuffer1.append(URLEncoder.encode(localStringBuffer2.toString(), "UTF-8"));
            return localStringBuffer1.toString();
        } catch (Exception paramContext) {
            for (; ; ) {
                paramContext.printStackTrace();
            }
        }
    }

    private boolean a() {
        if (this.h.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.h.getPackageName()) != 0) {
            return false;
        }
        try {
            Object localObject = ((ConnectivityManager) this.h.getSystemService("connectivity")).getActiveNetworkInfo();
            if ((localObject != null) && (((NetworkInfo) localObject).getType() != 1)) {
                localObject = ((NetworkInfo) localObject).getExtraInfo();
                if (localObject != null) {
                    if ((!((String) localObject).equals("cmwap")) && (!((String) localObject).equals("3gwap"))) {
                        boolean bool = ((String) localObject).equals("uniwap");
                        if (!bool) {
                        }
                    } else {
                        return true;
                    }
                }
            }
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return false;
    }

    private byte[] a(byte[] paramArrayOfByte, String paramString) {
        HttpPost localHttpPost = new HttpPost(paramString);
        Object localObject = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout((HttpParams) localObject, 10000);
        HttpConnectionParams.setSoTimeout((HttpParams) localObject, 30000);
        localObject = new DefaultHttpClient((HttpParams) localObject);
        localHttpPost.addHeader("X-Umeng-Sdk", this.e);
        localHttpPost.addHeader("Msg-Type", "envelope");
        try {
            if (a()) {
                HttpHost localHttpHost = new HttpHost(this.f, this.g);
                ((HttpClient) localObject).getParams().setParameter("http.route.default-proxy", localHttpHost);
            }
            localHttpPost.setEntity(new InputStreamEntity(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length));
            if (this.i != null) {
                this.i.e();
            }
            paramArrayOfByte = ((HttpClient) localObject).execute(localHttpPost);
            if (this.i != null) {
                this.i.f();
            }
            int k = paramArrayOfByte.getStatusLine().getStatusCode();
            Log.a("MobclickAgent", "status code : " + k);
            if (paramArrayOfByte.getStatusLine().getStatusCode() == 200) {
                Log.a("MobclickAgent", "Sent message to " + paramString);
                paramArrayOfByte = paramArrayOfByte.getEntity();
                if (paramArrayOfByte != null) {
                    paramArrayOfByte = paramArrayOfByte.getContent();
                    try {
                        paramString = com.umeng.common.util.h.b(paramArrayOfByte);
                        return paramString;
                    } finally {
                        com.umeng.common.util.h.c(paramArrayOfByte);
                    }
                }
            }
            return null;
        } catch (ClientProtocolException paramArrayOfByte) {
            Log.b("MobclickAgent", "ClientProtocolException,Failed to send message.", paramArrayOfByte);
            return null;
            return null;
            return null;
        } catch (IOException paramArrayOfByte) {
            Log.b("MobclickAgent", "IOException,Failed to send message.", paramArrayOfByte);
        }
    }

    private int b(byte[] paramArrayOfByte) {
        v localv = new v();
        g localg = new g(new a.a());
        try {
            localg.a(localv, paramArrayOfByte);
            if (localv.a == 1) {
                this.j.b(localv.j());
                this.j.c();
            }
            Log.a("MobclickAgent", "send log:" + localv.f());
        } catch (Exception paramArrayOfByte) {
            for (; ; ) {
                paramArrayOfByte.printStackTrace();
            }
        }
        if (localv.a == 1) {
            return 2;
        }
        return 3;
    }

    public int a(byte[] paramArrayOfByte) {
        byte[] arrayOfByte1 = null;
        int k = 0;
        byte[] arrayOfByte2;
        for (; ; ) {
            arrayOfByte2 = arrayOfByte1;
            if (k < a.f.length) {
                arrayOfByte1 = a(paramArrayOfByte, a.f[k]);
                if (arrayOfByte1 == null) {
                    break label57;
                }
                arrayOfByte2 = arrayOfByte1;
                if (this.i != null) {
                    this.i.c();
                    arrayOfByte2 = arrayOfByte1;
                }
            }
            if (arrayOfByte2 != null) {
                break;
            }
            return 1;
            label57:
            if (this.i != null) {
                this.i.d();
            }
            k += 1;
        }
        return b(arrayOfByte2);
    }

    public void a(o paramo) {
        this.i = paramo;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */