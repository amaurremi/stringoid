package com.amazonaws.org.apache.http.conn;

import java.net.InetAddress;

public abstract interface DnsResolver
{
  public abstract InetAddress[] resolve(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/DnsResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */