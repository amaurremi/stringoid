package com.quoord.tapatalkpro.util;

import com.quoord.xmlrpc.XmlRpcParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.kxml2.io.KXmlParser;

public class DirectoryHttpClient {
    String mUrl;

    public DirectoryHttpClient(String paramString1, String paramString2) {
        this.mUrl = paramString2;
    }

    public Object getResult()
            throws Exception {
        try {
            Object localObject = (HttpURLConnection) new URL(this.mUrl).openConnection();
            if (this.mUrl.contains("cache.tapatalk.com")) {
                ((HttpURLConnection) localObject).setConnectTimeout(7000);
                ((HttpURLConnection) localObject).setReadTimeout(7000);
            }
            ((HttpURLConnection) localObject).setDoInput(true);
            ((HttpURLConnection) localObject).setRequestProperty("User-Agent", "Mozilla/5.0 Firefox/3.5.6");
            ((HttpURLConnection) localObject).setRequestProperty("Content-Encoding", "gzip");
            ((HttpURLConnection) localObject).connect();
            localObject = ((HttpURLConnection) localObject).getInputStream();
            KXmlParser localKXmlParser = new KXmlParser();
            localKXmlParser.setInput(new InputStreamReader((InputStream) localObject));
            localObject = new XmlRpcParser(localKXmlParser).parseResponse();
            return localObject;
        } catch (Exception localException) {
            localException.printStackTrace();
            throw localException;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/DirectoryHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */