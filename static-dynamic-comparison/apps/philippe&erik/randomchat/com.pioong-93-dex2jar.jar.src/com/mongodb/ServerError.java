package com.mongodb;

import org.bson.BSONObject;

public class ServerError
{
  final int _code;
  final String _err;
  
  ServerError(DBObject paramDBObject)
  {
    this._err = getMsg(paramDBObject, null);
    if (this._err == null) {
      throw new IllegalArgumentException("need to have $err");
    }
    this._code = getCode(paramDBObject);
  }
  
  static int getCode(BSONObject paramBSONObject)
  {
    Object localObject2 = paramBSONObject.get("code");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramBSONObject.get("$code");
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramBSONObject.get("assertionCode");
    }
    if (localObject2 == null) {
      return -5;
    }
    return ((Number)localObject2).intValue();
  }
  
  static String getMsg(BSONObject paramBSONObject, String paramString)
  {
    Object localObject2 = paramBSONObject.get("$err");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramBSONObject.get("err");
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramBSONObject.get("errmsg");
    }
    if (localObject2 == null) {
      return paramString;
    }
    return localObject2.toString();
  }
  
  public int getCode()
  {
    return this._code;
  }
  
  public String getError()
  {
    return this._err;
  }
  
  public boolean isNotMasterError()
  {
    switch (this._code)
    {
    default: 
      return this._err.startsWith("not master");
    }
    return true;
  }
  
  public String toString()
  {
    if (this._code > 0) {
      return this._code + " " + this._err;
    }
    return this._err;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/ServerError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */