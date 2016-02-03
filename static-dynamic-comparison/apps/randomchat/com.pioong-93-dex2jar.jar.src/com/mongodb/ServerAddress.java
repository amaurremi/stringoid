package com.mongodb;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class ServerAddress
{
  volatile InetSocketAddress _address;
  final String _host;
  final int _port;
  
  public ServerAddress()
    throws UnknownHostException
  {
    this(defaultHost(), defaultPort());
  }
  
  public ServerAddress(String paramString)
    throws UnknownHostException
  {
    this(paramString, defaultPort());
  }
  
  public ServerAddress(String paramString, int paramInt)
    throws UnknownHostException
  {
    String str = paramString;
    if (paramString == null) {
      str = defaultHost();
    }
    str = str.trim();
    paramString = str;
    if (str.length() == 0) {
      paramString = defaultHost();
    }
    int j = paramString.indexOf(":");
    str = paramString;
    int i = paramInt;
    if (j > 0)
    {
      if (paramInt != defaultPort()) {
        throw new IllegalArgumentException("can't specify port in construct and via host");
      }
      i = Integer.parseInt(paramString.substring(j + 1));
      str = paramString.substring(0, j).trim();
    }
    this._host = str;
    this._port = i;
    updateInetAddress();
  }
  
  public ServerAddress(InetAddress paramInetAddress)
  {
    this(new InetSocketAddress(paramInetAddress, defaultPort()));
  }
  
  public ServerAddress(InetAddress paramInetAddress, int paramInt)
  {
    this(new InetSocketAddress(paramInetAddress, paramInt));
  }
  
  public ServerAddress(InetSocketAddress paramInetSocketAddress)
  {
    this._address = paramInetSocketAddress;
    this._host = this._address.getHostName();
    this._port = this._address.getPort();
  }
  
  public static String defaultHost()
  {
    return "127.0.0.1";
  }
  
  public static int defaultPort()
  {
    return 27017;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramObject instanceof ServerAddress))
    {
      paramObject = (ServerAddress)paramObject;
      bool1 = bool2;
      if (((ServerAddress)paramObject)._port == this._port)
      {
        bool1 = bool2;
        if (((ServerAddress)paramObject)._host.equals(this._host)) {
          bool1 = true;
        }
      }
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!(paramObject instanceof InetSocketAddress));
    return this._address.equals(paramObject);
  }
  
  public String getHost()
  {
    return this._host;
  }
  
  public int getPort()
  {
    return this._port;
  }
  
  public InetSocketAddress getSocketAddress()
  {
    return this._address;
  }
  
  public int hashCode()
  {
    return this._host.hashCode() + this._port;
  }
  
  public boolean sameHost(String paramString)
  {
    boolean bool2 = false;
    int j = paramString.indexOf(":");
    int i = defaultPort();
    String str = paramString;
    if (j > 0)
    {
      i = Integer.parseInt(paramString.substring(j + 1));
      str = paramString.substring(0, j);
    }
    boolean bool1 = bool2;
    if (this._port == i)
    {
      bool1 = bool2;
      if (this._host.equalsIgnoreCase(str)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    return this._address.toString();
  }
  
  boolean updateInetAddress()
    throws UnknownHostException
  {
    InetSocketAddress localInetSocketAddress = this._address;
    this._address = new InetSocketAddress(InetAddress.getByName(this._host), this._port);
    return !this._address.equals(localInetSocketAddress);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/ServerAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */