package com.mongodb;

import java.io.IOException;
import org.bson.BSONObject;

public class MongoException
  extends RuntimeException
{
  private static final long serialVersionUID = -4415279469780082174L;
  final int _code;
  
  public MongoException(int paramInt, String paramString)
  {
    super(paramString);
    this._code = paramInt;
  }
  
  public MongoException(int paramInt, String paramString, Throwable paramThrowable)
  {
    super(paramString, _massage(paramThrowable));
    this._code = paramInt;
  }
  
  public MongoException(String paramString)
  {
    super(paramString);
    this._code = -3;
  }
  
  public MongoException(String paramString, Throwable paramThrowable)
  {
    super(paramString, _massage(paramThrowable));
    this._code = -4;
  }
  
  public MongoException(BSONObject paramBSONObject)
  {
    this(ServerError.getCode(paramBSONObject), ServerError.getMsg(paramBSONObject, "UNKNOWN"));
  }
  
  static Throwable _massage(Throwable paramThrowable)
  {
    Object localObject = paramThrowable;
    if ((paramThrowable instanceof Network)) {
      localObject = ((Network)paramThrowable)._ioe;
    }
    return (Throwable)localObject;
  }
  
  static MongoException parse(BSONObject paramBSONObject)
  {
    String str = ServerError.getMsg(paramBSONObject, null);
    if (str == null) {
      return null;
    }
    return new MongoException(ServerError.getCode(paramBSONObject), str);
  }
  
  public int getCode()
  {
    return this._code;
  }
  
  public static class CursorNotFound
    extends MongoException
  {
    private static final long serialVersionUID = -4415279469780082174L;
    private final long cursorId;
    private final ServerAddress serverAddress;
    
    public CursorNotFound(long paramLong, ServerAddress paramServerAddress)
    {
      super("cursor " + paramLong + " not found on server " + paramServerAddress);
      this.cursorId = paramLong;
      this.serverAddress = paramServerAddress;
    }
    
    public long getCursorId()
    {
      return this.cursorId;
    }
    
    public ServerAddress getServerAddress()
    {
      return this.serverAddress;
    }
  }
  
  public static class DuplicateKey
    extends WriteConcernException
  {
    private static final long serialVersionUID = -4415279469780082174L;
    
    public DuplicateKey(CommandResult paramCommandResult)
    {
      super();
    }
  }
  
  public static class Network
    extends MongoException
  {
    private static final long serialVersionUID = -4415279469780082174L;
    final IOException _ioe;
    
    public Network(IOException paramIOException)
    {
      super(paramIOException);
      this._ioe = paramIOException;
    }
    
    public Network(String paramString, IOException paramIOException)
    {
      super(paramString, paramIOException);
      this._ioe = paramIOException;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/MongoException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */