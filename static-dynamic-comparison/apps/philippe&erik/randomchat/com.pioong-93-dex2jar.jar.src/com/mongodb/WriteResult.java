package com.mongodb;

import java.util.concurrent.atomic.AtomicLong;

public class WriteResult
{
  private final DB _db;
  private long _lastCall;
  private WriteConcern _lastConcern;
  private CommandResult _lastErrorResult;
  private final boolean _lazy;
  private final DBPort _port;
  
  WriteResult(CommandResult paramCommandResult, WriteConcern paramWriteConcern)
  {
    this._lastErrorResult = paramCommandResult;
    this._lastConcern = paramWriteConcern;
    this._lazy = false;
    this._port = null;
    this._db = null;
  }
  
  WriteResult(DB paramDB, DBPort paramDBPort, WriteConcern paramWriteConcern)
  {
    this._db = paramDB;
    this._port = paramDBPort;
    this._lastCall = paramDBPort._calls.get();
    this._lastConcern = paramWriteConcern;
    this._lazy = true;
  }
  
  public CommandResult getCachedLastError()
  {
    return this._lastErrorResult;
  }
  
  public String getError()
  {
    Object localObject = getField("err");
    if (localObject == null) {
      return null;
    }
    return localObject.toString();
  }
  
  public Object getField(String paramString)
  {
    return getLastError().get(paramString);
  }
  
  public WriteConcern getLastConcern()
  {
    return this._lastConcern;
  }
  
  public CommandResult getLastError()
  {
    try
    {
      CommandResult localCommandResult = getLastError(null);
      return localCommandResult;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public CommandResult getLastError(WriteConcern paramWriteConcern)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/mongodb/WriteResult:_lastErrorResult	Lcom/mongodb/CommandResult;
    //   6: ifnull +37 -> 43
    //   9: aload_1
    //   10: ifnull +24 -> 34
    //   13: aload_0
    //   14: getfield 25	com/mongodb/WriteResult:_lastConcern	Lcom/mongodb/WriteConcern;
    //   17: ifnull +26 -> 43
    //   20: aload_0
    //   21: getfield 25	com/mongodb/WriteResult:_lastConcern	Lcom/mongodb/WriteConcern;
    //   24: invokevirtual 80	com/mongodb/WriteConcern:getW	()I
    //   27: aload_1
    //   28: invokevirtual 80	com/mongodb/WriteConcern:getW	()I
    //   31: if_icmplt +12 -> 43
    //   34: aload_0
    //   35: getfield 23	com/mongodb/WriteResult:_lastErrorResult	Lcom/mongodb/CommandResult;
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: areturn
    //   43: aload_0
    //   44: getfield 29	com/mongodb/WriteResult:_port	Lcom/mongodb/DBPort;
    //   47: astore 4
    //   49: aload 4
    //   51: ifnull +112 -> 163
    //   54: aload_0
    //   55: getfield 29	com/mongodb/WriteResult:_port	Lcom/mongodb/DBPort;
    //   58: astore 5
    //   60: aload_0
    //   61: getfield 31	com/mongodb/WriteResult:_db	Lcom/mongodb/DB;
    //   64: astore 6
    //   66: aload_0
    //   67: getfield 47	com/mongodb/WriteResult:_lastCall	J
    //   70: lstore_2
    //   71: aload_1
    //   72: ifnonnull +48 -> 120
    //   75: new 76	com/mongodb/WriteConcern
    //   78: dup
    //   79: invokespecial 81	com/mongodb/WriteConcern:<init>	()V
    //   82: astore 4
    //   84: aload_0
    //   85: aload 5
    //   87: aload 6
    //   89: lload_2
    //   90: aload 4
    //   92: invokevirtual 85	com/mongodb/DBPort:tryGetLastError	(Lcom/mongodb/DB;JLcom/mongodb/WriteConcern;)Lcom/mongodb/CommandResult;
    //   95: putfield 23	com/mongodb/WriteResult:_lastErrorResult	Lcom/mongodb/CommandResult;
    //   98: aload_0
    //   99: getfield 23	com/mongodb/WriteResult:_lastErrorResult	Lcom/mongodb/CommandResult;
    //   102: ifnonnull +38 -> 140
    //   105: new 87	java/lang/IllegalStateException
    //   108: dup
    //   109: ldc 89
    //   111: invokespecial 92	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   114: athrow
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_1
    //   119: athrow
    //   120: aload_1
    //   121: astore 4
    //   123: goto -39 -> 84
    //   126: astore_1
    //   127: new 94	com/mongodb/MongoException$Network
    //   130: dup
    //   131: aload_1
    //   132: invokevirtual 97	java/io/IOException:getMessage	()Ljava/lang/String;
    //   135: aload_1
    //   136: invokespecial 100	com/mongodb/MongoException$Network:<init>	(Ljava/lang/String;Ljava/io/IOException;)V
    //   139: athrow
    //   140: aload_0
    //   141: aload_1
    //   142: putfield 25	com/mongodb/WriteResult:_lastConcern	Lcom/mongodb/WriteConcern;
    //   145: aload_0
    //   146: aload_0
    //   147: getfield 47	com/mongodb/WriteResult:_lastCall	J
    //   150: lconst_1
    //   151: ladd
    //   152: putfield 47	com/mongodb/WriteResult:_lastCall	J
    //   155: aload_0
    //   156: getfield 23	com/mongodb/WriteResult:_lastErrorResult	Lcom/mongodb/CommandResult;
    //   159: astore_1
    //   160: goto -121 -> 39
    //   163: new 87	java/lang/IllegalStateException
    //   166: dup
    //   167: ldc 102
    //   169: invokespecial 92	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	WriteResult
    //   0	173	1	paramWriteConcern	WriteConcern
    //   70	20	2	l	long
    //   47	75	4	localObject	Object
    //   58	28	5	localDBPort	DBPort
    //   64	24	6	localDB	DB
    // Exception table:
    //   from	to	target	type
    //   2	9	115	finally
    //   13	34	115	finally
    //   34	39	115	finally
    //   43	49	115	finally
    //   54	71	115	finally
    //   75	84	115	finally
    //   84	98	115	finally
    //   98	115	115	finally
    //   127	140	115	finally
    //   140	160	115	finally
    //   163	173	115	finally
    //   54	71	126	java/io/IOException
    //   75	84	126	java/io/IOException
    //   84	98	126	java/io/IOException
  }
  
  public int getN()
  {
    return getLastError().getInt("n");
  }
  
  public boolean isLazy()
  {
    return this._lazy;
  }
  
  public String toString()
  {
    CommandResult localCommandResult = getCachedLastError();
    if (localCommandResult != null) {
      return localCommandResult.toString();
    }
    return "N/A";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/WriteResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */