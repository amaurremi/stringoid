package com.mongodb;

public class CommandResult
  extends BasicDBObject
{
  private static final long serialVersionUID = 1L;
  private final ServerAddress _host;
  
  CommandResult(ServerAddress paramServerAddress)
  {
    if (paramServerAddress == null) {
      throw new IllegalArgumentException("server address is null");
    }
    this._host = paramServerAddress;
    put("serverUsed", paramServerAddress.toString());
  }
  
  int getCode()
  {
    int i = -1;
    if ((get("code") instanceof Number)) {
      i = ((Number)get("code")).intValue();
    }
    return i;
  }
  
  public String getErrorMessage()
  {
    Object localObject = get("errmsg");
    if (localObject == null) {
      return null;
    }
    return localObject.toString();
  }
  
  public MongoException getException()
  {
    if (!ok()) {
      return new CommandFailureException(this);
    }
    if (hasErr())
    {
      if ((getCode() == 11000) || (getCode() == 11001) || (getCode() == 12582)) {
        return new MongoException.DuplicateKey(this);
      }
      return new WriteConcernException(this);
    }
    return null;
  }
  
  public ServerAddress getServerUsed()
  {
    return this._host;
  }
  
  boolean hasErr()
  {
    Object localObject = get("err");
    return (localObject != null) && (((String)localObject).length() > 0);
  }
  
  public boolean ok()
  {
    boolean bool = true;
    Object localObject = get("ok");
    if (localObject == null) {
      throw new IllegalArgumentException("'ok' should never be null...");
    }
    if ((localObject instanceof Boolean)) {
      bool = ((Boolean)localObject).booleanValue();
    }
    do
    {
      return bool;
      if (!(localObject instanceof Number)) {
        break;
      }
    } while (((Number)localObject).intValue() == 1);
    return false;
    throw new IllegalArgumentException("can't figure out what to do with: " + localObject.getClass().getName());
  }
  
  public void throwOnError()
  {
    if ((!ok()) || (hasErr())) {
      throw getException();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/CommandResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */