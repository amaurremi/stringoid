package com.jiubang.core.util;

import com.gtp.a.a.b.c;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;

class HttpUtils
{
  private static final AllowAllHostnameVerifier HOSTNAME_VERIFIER = new AllowAllHostnameVerifier();
  private static final String LOG_TAG = "ACRA";
  private static final int SOCKET_TIMEOUT = 3000;
  private static final TrustManager[] TRUST_MANAGER = { new NaiveTrustManager() };
  
  static void doPost(Map paramMap, URL paramURL)
  {
    paramURL = getConnection(paramURL);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append('&');
      }
      String str = (String)localIterator.next();
      localStringBuilder.append(URLEncoder.encode(str, "UTF-8")).append('=').append(URLEncoder.encode((String)paramMap.get(str), "UTF-8"));
    }
    paramURL.setDoOutput(true);
    paramMap = new OutputStreamWriter(paramURL.getOutputStream());
    c.a("ACRA", "Posting crash report data");
    paramMap.write(localStringBuilder.toString());
    paramMap.flush();
    paramMap.close();
    c.a("ACRA", "Reading response");
    paramMap = new BufferedReader(new InputStreamReader(paramURL.getInputStream()));
    for (;;)
    {
      paramURL = paramMap.readLine();
      if (paramURL == null) {
        break;
      }
      c.a("ACRA", paramURL);
    }
    paramMap.close();
  }
  
  private static URLConnection getConnection(URL paramURL)
  {
    paramURL = paramURL.openConnection();
    if ((paramURL instanceof HttpsURLConnection))
    {
      Object localObject = SSLContext.getInstance("TLS");
      TrustManager[] arrayOfTrustManager = TRUST_MANAGER;
      SecureRandom localSecureRandom = new SecureRandom();
      ((SSLContext)localObject).init(new KeyManager[0], arrayOfTrustManager, localSecureRandom);
      localObject = ((SSLContext)localObject).getSocketFactory();
      ((HttpsURLConnection)paramURL).setSSLSocketFactory((SSLSocketFactory)localObject);
      ((HttpsURLConnection)paramURL).setHostnameVerifier(HOSTNAME_VERIFIER);
    }
    paramURL.setConnectTimeout(3000);
    paramURL.setReadTimeout(3000);
    return paramURL;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/util/HttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */