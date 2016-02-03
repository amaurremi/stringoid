package com.mongodb;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DBAddress
  extends ServerAddress
{
  final String _db;
  
  public DBAddress(DBAddress paramDBAddress, String paramString)
    throws UnknownHostException
  {
    this(paramDBAddress._host, paramDBAddress._port, paramString);
  }
  
  public DBAddress(String paramString)
    throws UnknownHostException
  {
    super(_getHostSection(paramString));
    _check(paramString, "urlFormat");
    this._db = _fixName(_getDBSection(paramString));
    _check(this._host, "host");
    _check(this._db, "db");
  }
  
  public DBAddress(String paramString1, int paramInt, String paramString2)
    throws UnknownHostException
  {
    super(paramString1, paramInt);
    this._db = paramString2.trim();
  }
  
  public DBAddress(String paramString1, String paramString2)
    throws UnknownHostException
  {
    this(paramString1, 27017, paramString2);
  }
  
  public DBAddress(InetAddress paramInetAddress, int paramInt, String paramString)
  {
    super(paramInetAddress, paramInt);
    _check(paramString, "name");
    this._db = paramString.trim();
  }
  
  static void _check(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new NullPointerException(paramString2 + " can't be null ");
    }
    if (paramString1.trim().length() == 0) {
      throw new IllegalArgumentException(paramString2 + " can't be empty");
    }
  }
  
  static String _fixName(String paramString)
  {
    return paramString.replace('.', '-');
  }
  
  static String _getDBSection(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("urlFormat can't be null");
    }
    int i = paramString.indexOf("/");
    String str = paramString;
    if (i >= 0) {
      str = paramString.substring(i + 1);
    }
    return str;
  }
  
  static String _getHostSection(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("urlFormat can't be null");
    }
    int i = paramString.indexOf("/");
    if (i >= 0) {
      return paramString.substring(0, i);
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramObject instanceof DBAddress))
    {
      paramObject = (DBAddress)paramObject;
      bool1 = bool2;
      if (((DBAddress)paramObject)._port == this._port)
      {
        bool1 = bool2;
        if (((DBAddress)paramObject)._db.equals(this._db))
        {
          bool1 = bool2;
          if (((DBAddress)paramObject)._host.equals(this._host)) {
            bool1 = true;
          }
        }
      }
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!(paramObject instanceof ServerAddress));
    return paramObject.equals(this);
  }
  
  public String getDBName()
  {
    return this._db;
  }
  
  public DBAddress getSister(String paramString)
  {
    try
    {
      paramString = new DBAddress(this._host, this._port, paramString);
      return paramString;
    }
    catch (UnknownHostException paramString)
    {
      throw new MongoInternalException("shouldn't be possible", paramString);
    }
  }
  
  public int hashCode()
  {
    return super.hashCode() + this._db.hashCode();
  }
  
  public String toString()
  {
    return super.toString() + "/" + this._db;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/DBAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */