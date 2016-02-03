package com.umeng.common.net;

import com.umeng.common.Log;
import com.umeng.common.util.f;
import com.umeng.common.util.h;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

public class k {
    private static final String a = k.class.getName();
    private Map<String, String> b;

    private static String a(InputStream paramInputStream) {
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 8192);
        StringBuilder localStringBuilder = new StringBuilder();
        try {
            for (; ; ) {
                String str = localBufferedReader.readLine();
                if (str == null) {
                    break;
                }
                localStringBuilder.append(str + "\n");
            }
            return null;
        } catch (IOException localIOException) {
            Log.b(a, "Caught IOException in convertStreamToString()", localIOException);
            for (; ; ) {
                try {
                    paramInputStream.close();
                    return null;
                } catch (IOException paramInputStream) {
                    Log.b(a, "Caught IOException in convertStreamToString()", paramInputStream);
                    return null;
                }
                try {
                    paramInputStream.close();
                    return localStringBuilder.toString();
                } catch (IOException paramInputStream) {
                    Log.b(a, "Caught IOException in convertStreamToString()", paramInputStream);
                    return null;
                }
            }
        } finally {
            try {
                paramInputStream.close();
                throw ((Throwable) localObject);
            } catch (IOException paramInputStream) {
                Log.b(a, "Caught IOException in convertStreamToString()", paramInputStream);
            }
        }
    }

    private HttpParams a() {
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
        HttpProtocolParams.setUserAgent(localBasicHttpParams, System.getProperty("http.agent"));
        return localBasicHttpParams;
    }

    private JSONObject a(String paramString) {
        int i = new Random().nextInt(1000);
        label522:
        label524:
        for (; ; ) {
            Object localObject2;
            try {
                String str1 = System.getProperty("line.separator");
                if (paramString.length() <= 1) {
                    Log.b(a, i + ":\tInvalid baseUrl.");
                    return null;
                }
                Log.a(a, i + ":\tget: " + paramString);
                HttpGet localHttpGet = new HttpGet(paramString);
                if ((this.b != null) && (this.b.size() > 0)) {
                    localObject2 = this.b.keySet().iterator();
                    if (((Iterator) localObject2).hasNext()) {
                        String str2 = (String) ((Iterator) localObject2).next();
                        localHttpGet.addHeader(str2, (String) this.b.get(str2));
                        continue;
                    }
                }
                Object localObject1;
                return new JSONObject(localException);
            } catch (ClientProtocolException localClientProtocolException) {
                Log.c(a, i + ":\tClientProtocolException,Failed to send message." + paramString, localClientProtocolException);
                return null;
                localObject2 = new DefaultHttpClient(a()).execute(localClientProtocolException);
                if (((HttpResponse) localObject2).getStatusLine().getStatusCode() == 200) {
                    localObject1 = ((HttpResponse) localObject2).getEntity();
                    if (localObject1 == null) {
                        break label522;
                    }
                    localObject1 = ((HttpEntity) localObject1).getContent();
                    localObject2 = ((HttpResponse) localObject2).getFirstHeader("Content-Encoding");
                    if ((localObject2 != null) && (((Header) localObject2).getValue().equalsIgnoreCase("gzip"))) {
                        Log.a(a, i + "  Use GZIPInputStream get data....");
                        localObject1 = new GZIPInputStream((InputStream) localObject1);
                        localObject1 = a((InputStream) localObject1);
                        Log.a(a, i + ":\tresponse: " + str1 + (String) localObject1);
                        if (localObject1 == null) {
                            return null;
                        }
                    } else {
                        if ((localObject2 == null) || (!((Header) localObject2).getValue().equalsIgnoreCase("deflate"))) {
                            break label524;
                        }
                        Log.a(a, i + "  Use InflaterInputStream get data....");
                        localObject1 = new InflaterInputStream((InputStream) localObject1);
                        continue;
                    }
                }
            } catch (Exception localException) {
                Log.c(a, i + ":\tIOException,Failed to send message." + paramString, localException);
                return null;
            }
            Log.c(a, i + ":\tFailed to send message. StatusCode = " + ((HttpResponse) localObject2).getStatusLine().getStatusCode() + h.a + paramString);
            return null;
        }
    }

    private JSONObject a(String paramString, JSONObject paramJSONObject) {
        Object localObject2 = paramJSONObject.toString();
        int i = new Random().nextInt(1000);
        Log.c(a, i + ":\trequest: " + paramString + h.a + (String) localObject2);
        paramJSONObject = new HttpPost(paramString);
        Object localObject1 = new DefaultHttpClient(a());
        try {
            if (shouldCompressData()) {
                localObject2 = f.a("content=" + (String) localObject2, Charset.defaultCharset().toString());
                paramJSONObject.addHeader("Content-Encoding", "deflate");
                paramJSONObject.setEntity(new InputStreamEntity(new ByteArrayInputStream((byte[]) localObject2), localObject2.length));
                localObject1 = ((HttpClient) localObject1).execute(paramJSONObject);
                if (((HttpResponse) localObject1).getStatusLine().getStatusCode() != 200) {
                    break label377;
                }
                paramJSONObject = ((HttpResponse) localObject1).getEntity();
                if (paramJSONObject == null) {
                    break label498;
                }
                paramJSONObject = paramJSONObject.getContent();
                localObject1 = ((HttpResponse) localObject1).getFirstHeader("Content-Encoding");
                if ((localObject1 == null) || (!((Header) localObject1).getValue().equalsIgnoreCase("deflate"))) {
                    break label495;
                }
                paramJSONObject = new InflaterInputStream(paramJSONObject);
            }
            label377:
            for (; ; ) {
                paramJSONObject = a(paramJSONObject);
                Log.a(a, i + ":\tresponse: " + h.a + paramJSONObject);
                if (paramJSONObject == null) {
                    return null;
                    ArrayList localArrayList = new ArrayList(1);
                    localArrayList.add(new BasicNameValuePair("content", (String) localObject2));
                    paramJSONObject.setEntity(new UrlEncodedFormEntity(localArrayList, "UTF-8"));
                    break;
                }
            }
        } catch (ClientProtocolException paramJSONObject) {
            Log.c(a, i + ":\tClientProtocolException,Failed to send message." + paramString, paramJSONObject);
            return null;
            return new JSONObject(paramJSONObject);
            Log.c(a, i + ":\tFailed to send message. StatusCode = " + ((HttpResponse) localObject1).getStatusLine().getStatusCode() + h.a + paramString);
            return null;
        } catch (IOException paramJSONObject) {
            Log.c(a, i + ":\tIOException,Failed to send message." + paramString, paramJSONObject);
            return null;
        } catch (JSONException paramJSONObject) {
            Log.c(a, i + ":\tIOException,Failed to send message." + paramString, paramJSONObject);
            return null;
        }
        label495:
        label498:
        return null;
    }

    private void b(String paramString) {
        if ((h.d(paramString)) || (!(l.c.equals(paramString.trim()) ^ l.b.equals(paramString.trim())))) {
            throw new RuntimeException("验证请求方式失败[" + paramString + "]");
        }
    }

    public <T extends m> T execute(l paraml, Class<T> paramClass) {
        String str = paraml.c().trim();
        b(str);
        if (l.c.equals(str)) {
            paraml = a(paraml.b());
        }
        for (; ; ) {
            if (paraml == null) {
                return null;
                if (l.b.equals(str)) {
                    paraml = a(paraml.d, paraml.a());
                }
            } else {
                try {
                    paraml = (m) paramClass.getConstructor(new Class[]{JSONObject.class}).newInstance(new Object[]{paraml});
                    return paraml;
                } catch (SecurityException paraml) {
                    Log.b(a, "SecurityException", paraml);
                    return null;
                } catch (NoSuchMethodException paraml) {
                    for (; ; ) {
                        Log.b(a, "NoSuchMethodException", paraml);
                    }
                } catch (IllegalArgumentException paraml) {
                    for (; ; ) {
                        Log.b(a, "IllegalArgumentException", paraml);
                    }
                } catch (InstantiationException paraml) {
                    for (; ; ) {
                        Log.b(a, "InstantiationException", paraml);
                    }
                } catch (IllegalAccessException paraml) {
                    for (; ; ) {
                        Log.b(a, "IllegalAccessException", paraml);
                    }
                } catch (InvocationTargetException paraml) {
                    for (; ; ) {
                        Log.b(a, "InvocationTargetException", paraml);
                    }
                }
            }
            paraml = null;
        }
    }

    public k setHeader(Map<String, String> paramMap) {
        this.b = paramMap;
        return this;
    }

    public boolean shouldCompressData() {
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/common/net/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */