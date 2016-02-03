package com.mongodb;

public class MongoInterruptedException
  extends MongoException
{
  private static final long serialVersionUID = -4110417867718417860L;
  
  public MongoInterruptedException(InterruptedException paramInterruptedException)
  {
    super("A driver operation has been interrupted", paramInterruptedException);
  }
  
  public MongoInterruptedException(String paramString, InterruptedException paramInterruptedException)
  {
    super(paramString, paramInterruptedException);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/MongoInterruptedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */