package com.mongodb;

public class MongoInternalException
  extends MongoException
{
  private static final long serialVersionUID = -4415279469780082174L;
  
  public MongoInternalException(String paramString)
  {
    super(paramString);
  }
  
  public MongoInternalException(String paramString, Throwable paramThrowable)
  {
    super(paramString, MongoException._massage(paramThrowable));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/MongoInternalException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */