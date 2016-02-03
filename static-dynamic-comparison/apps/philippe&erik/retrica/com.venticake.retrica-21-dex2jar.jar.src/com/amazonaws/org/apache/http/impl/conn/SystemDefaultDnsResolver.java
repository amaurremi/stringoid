package com.amazonaws.org.apache.http.impl.conn;

import com.amazonaws.org.apache.http.conn.DnsResolver;
import java.net.InetAddress;

public class SystemDefaultDnsResolver
  implements DnsResolver
{
  public InetAddress[] resolve(String paramString)
  {
    return InetAddress.getAllByName(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/conn/SystemDefaultDnsResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */