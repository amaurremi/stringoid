package com.amazonaws.org.apache.http.impl.conn;

import com.amazonaws.org.apache.http.conn.scheme.PlainSocketFactory;
import com.amazonaws.org.apache.http.conn.scheme.Scheme;
import com.amazonaws.org.apache.http.conn.scheme.SchemeRegistry;
import com.amazonaws.org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public final class SchemeRegistryFactory
{
  public static SchemeRegistry createDefault()
  {
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
    localSchemeRegistry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));
    return localSchemeRegistry;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/conn/SchemeRegistryFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */