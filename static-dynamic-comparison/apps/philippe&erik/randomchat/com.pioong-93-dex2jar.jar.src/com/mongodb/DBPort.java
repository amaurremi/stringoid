package com.mongodb;

import com.mongodb.util.ThreadUtil;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.Sasl;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslException;
import org.ietf.jgss.GSSCredential;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.GSSManager;
import org.ietf.jgss.GSSName;
import org.ietf.jgss.Oid;

public class DBPort
{
  static final long CONN_RETRY_TIME_MS = 15000L;
  public static final int PORT = 27017;
  static final boolean USE_NAGLE = false;
  private static Logger _rootLogger = Logger.getLogger("com.mongodb.port");
  private volatile ActiveState _activeState;
  final InetSocketAddress _addr;
  final AtomicLong _calls = new AtomicLong();
  final DBDecoder _decoder;
  final int _hashCode;
  private volatile InputStream _in;
  volatile int _lastThread;
  final Logger _logger;
  final MongoOptions _options;
  private volatile OutputStream _out;
  final DBPortPool _pool;
  private volatile boolean _processingResponse;
  final ServerAddress _sa;
  private volatile Socket _socket;
  final Set<String> authenticatedDatabases = Collections.synchronizedSet(new HashSet());
  private volatile Boolean useCRAMAuthenticationProtocol;
  
  public DBPort(ServerAddress paramServerAddress)
  {
    this(paramServerAddress, null, new MongoOptions());
  }
  
  DBPort(ServerAddress paramServerAddress, DBPortPool paramDBPortPool, MongoOptions paramMongoOptions)
  {
    this._options = paramMongoOptions;
    this._sa = paramServerAddress;
    this._addr = paramServerAddress.getSocketAddress();
    this._pool = paramDBPortPool;
    this._hashCode = this._addr.hashCode();
    this._logger = Logger.getLogger(_rootLogger.getName() + "." + paramServerAddress.toString());
    this._decoder = this._options.dbDecoderFactory.create();
  }
  
  private CommandResult convertToCommandResult(DBObject paramDBObject, Response paramResponse)
  {
    if (paramResponse.size() == 0) {
      return null;
    }
    if (paramResponse.size() > 1) {
      throw new MongoInternalException("something is wrong.  size:" + paramResponse.size());
    }
    paramDBObject = paramResponse.get(0);
    if (paramDBObject == null) {
      throw new MongoInternalException("something is wrong, no command result");
    }
    paramResponse = new CommandResult(paramResponse.serverUsed());
    paramResponse.putAll(paramDBObject);
    return paramResponse;
  }
  
  /* Error */
  private Response findOne(DB paramDB, String paramString, DBObject paramDBObject)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: aload_2
    //   4: invokevirtual 203	com/mongodb/DB:getCollection	(Ljava/lang/String;)Lcom/mongodb/DBCollection;
    //   7: iconst_0
    //   8: iconst_0
    //   9: iconst_m1
    //   10: aload_3
    //   11: aconst_null
    //   12: invokestatic 209	com/mongodb/OutMessage:query	(Lcom/mongodb/DBCollection;IIILcom/mongodb/DBObject;Lcom/mongodb/DBObject;)Lcom/mongodb/OutMessage;
    //   15: astore_3
    //   16: aload_0
    //   17: aload_3
    //   18: aload_1
    //   19: aload_2
    //   20: invokevirtual 203	com/mongodb/DB:getCollection	(Ljava/lang/String;)Lcom/mongodb/DBCollection;
    //   23: aconst_null
    //   24: invokespecial 213	com/mongodb/DBPort:go	(Lcom/mongodb/OutMessage;Lcom/mongodb/DBCollection;Lcom/mongodb/DBDecoder;)Lcom/mongodb/Response;
    //   27: astore_1
    //   28: aload_3
    //   29: invokevirtual 216	com/mongodb/OutMessage:doneWithMessage	()V
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: areturn
    //   36: astore_1
    //   37: aload_3
    //   38: invokevirtual 216	com/mongodb/OutMessage:doneWithMessage	()V
    //   41: aload_1
    //   42: athrow
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	DBPort
    //   0	48	1	paramDB	DB
    //   0	48	2	paramString	String
    //   0	48	3	paramDBObject	DBObject
    // Exception table:
    //   from	to	target	type
    //   16	28	36	finally
    //   2	16	43	finally
    //   28	32	43	finally
    //   37	43	43	finally
  }
  
  private Response go(OutMessage paramOutMessage, DBCollection paramDBCollection)
    throws IOException
  {
    try
    {
      paramOutMessage = go(paramOutMessage, paramDBCollection, false, null);
      return paramOutMessage;
    }
    finally
    {
      paramOutMessage = finally;
      throw paramOutMessage;
    }
  }
  
  private Response go(OutMessage paramOutMessage, DBCollection paramDBCollection, DBDecoder paramDBDecoder)
    throws IOException
  {
    try
    {
      paramOutMessage = go(paramOutMessage, paramDBCollection, false, paramDBDecoder);
      return paramOutMessage;
    }
    finally
    {
      paramOutMessage = finally;
      throw paramOutMessage;
    }
  }
  
  /* Error */
  private Response go(OutMessage paramOutMessage, DBCollection paramDBCollection, boolean paramBoolean, DBDecoder paramDBDecoder)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 223	com/mongodb/DBPort:_processingResponse	Z
    //   9: ifeq +7 -> 16
    //   12: aload_2
    //   13: ifnonnull +44 -> 57
    //   16: aload_0
    //   17: getfield 105	com/mongodb/DBPort:_calls	Ljava/util/concurrent/atomic/AtomicLong;
    //   20: invokevirtual 227	java/util/concurrent/atomic/AtomicLong:incrementAndGet	()J
    //   23: pop2
    //   24: aload_0
    //   25: getfield 229	com/mongodb/DBPort:_socket	Ljava/net/Socket;
    //   28: ifnonnull +7 -> 35
    //   31: aload_0
    //   32: invokevirtual 232	com/mongodb/DBPort:_open	()V
    //   35: aload_0
    //   36: getfield 234	com/mongodb/DBPort:_out	Ljava/io/OutputStream;
    //   39: ifnonnull +28 -> 67
    //   42: new 236	java/lang/IllegalStateException
    //   45: dup
    //   46: ldc -18
    //   48: invokespecial 239	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   51: athrow
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    //   57: new 236	java/lang/IllegalStateException
    //   60: dup
    //   61: ldc -15
    //   63: invokespecial 239	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   66: athrow
    //   67: aload_1
    //   68: invokevirtual 244	com/mongodb/OutMessage:prepare	()V
    //   71: aload_0
    //   72: new 6	com/mongodb/DBPort$ActiveState
    //   75: dup
    //   76: aload_0
    //   77: aload_1
    //   78: invokespecial 247	com/mongodb/DBPort$ActiveState:<init>	(Lcom/mongodb/DBPort;Lcom/mongodb/OutMessage;)V
    //   81: putfield 249	com/mongodb/DBPort:_activeState	Lcom/mongodb/DBPort$ActiveState;
    //   84: aload_1
    //   85: aload_0
    //   86: getfield 234	com/mongodb/DBPort:_out	Ljava/io/OutputStream;
    //   89: invokevirtual 253	com/mongodb/OutMessage:pipe	(Ljava/io/OutputStream;)V
    //   92: aload_0
    //   93: getfield 119	com/mongodb/DBPort:_pool	Lcom/mongodb/DBPortPool;
    //   96: ifnull +11 -> 107
    //   99: aload_0
    //   100: getfield 119	com/mongodb/DBPort:_pool	Lcom/mongodb/DBPortPool;
    //   103: iconst_1
    //   104: putfield 258	com/mongodb/DBPortPool:_everWorked	Z
    //   107: aload_2
    //   108: ifnonnull +24 -> 132
    //   111: iload_3
    //   112: ifne +20 -> 132
    //   115: aload_0
    //   116: aconst_null
    //   117: putfield 249	com/mongodb/DBPort:_activeState	Lcom/mongodb/DBPort$ActiveState;
    //   120: aload_0
    //   121: iconst_0
    //   122: putfield 223	com/mongodb/DBPort:_processingResponse	Z
    //   125: aload 5
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: areturn
    //   132: aload_0
    //   133: iconst_1
    //   134: putfield 223	com/mongodb/DBPort:_processingResponse	Z
    //   137: aload_0
    //   138: getfield 109	com/mongodb/DBPort:_sa	Lcom/mongodb/ServerAddress;
    //   141: astore 5
    //   143: aload_0
    //   144: getfield 260	com/mongodb/DBPort:_in	Ljava/io/InputStream;
    //   147: astore 6
    //   149: aload 4
    //   151: astore_1
    //   152: aload 4
    //   154: ifnonnull +8 -> 162
    //   157: aload_0
    //   158: getfield 158	com/mongodb/DBPort:_decoder	Lcom/mongodb/DBDecoder;
    //   161: astore_1
    //   162: new 162	com/mongodb/Response
    //   165: dup
    //   166: aload 5
    //   168: aload_2
    //   169: aload 6
    //   171: aload_1
    //   172: invokespecial 263	com/mongodb/Response:<init>	(Lcom/mongodb/ServerAddress;Lcom/mongodb/DBCollection;Ljava/io/InputStream;Lcom/mongodb/DBDecoder;)V
    //   175: astore_1
    //   176: aload_0
    //   177: aconst_null
    //   178: putfield 249	com/mongodb/DBPort:_activeState	Lcom/mongodb/DBPort$ActiveState;
    //   181: aload_0
    //   182: iconst_0
    //   183: putfield 223	com/mongodb/DBPort:_processingResponse	Z
    //   186: goto -58 -> 128
    //   189: astore_1
    //   190: aload_0
    //   191: invokevirtual 266	com/mongodb/DBPort:close	()V
    //   194: aload_1
    //   195: athrow
    //   196: astore_1
    //   197: aload_0
    //   198: aconst_null
    //   199: putfield 249	com/mongodb/DBPort:_activeState	Lcom/mongodb/DBPort$ActiveState;
    //   202: aload_0
    //   203: iconst_0
    //   204: putfield 223	com/mongodb/DBPort:_processingResponse	Z
    //   207: aload_1
    //   208: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	DBPort
    //   0	209	1	paramOutMessage	OutMessage
    //   0	209	2	paramDBCollection	DBCollection
    //   0	209	3	paramBoolean	boolean
    //   0	209	4	paramDBDecoder	DBDecoder
    //   1	166	5	localServerAddress	ServerAddress
    //   147	23	6	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   5	12	52	finally
    //   16	35	52	finally
    //   35	52	52	finally
    //   57	67	52	finally
    //   115	125	52	finally
    //   176	186	52	finally
    //   197	209	52	finally
    //   67	107	189	java/io/IOException
    //   132	149	189	java/io/IOException
    //   157	162	189	java/io/IOException
    //   162	176	189	java/io/IOException
    //   67	107	196	finally
    //   132	149	196	finally
    //   157	162	196	finally
    //   162	176	196	finally
    //   190	196	196	finally
  }
  
  void _open()
    throws IOException
  {
    l1 = 100L;
    l2 = 15000L;
    if (this._options.maxAutoConnectRetryTime > 0L) {
      l2 = this._options.maxAutoConnectRetryTime;
    }
    i = 0;
    l4 = System.currentTimeMillis();
    do
    {
      try
      {
        this._socket = this._options.socketFactory.createSocket();
        this._socket.connect(this._addr, this._options.connectTimeout);
        this._socket.setTcpNoDelay(true);
        this._socket.setKeepAlive(this._options.socketKeepAlive);
        this._socket.setSoTimeout(this._options.socketTimeout);
        this._in = new BufferedInputStream(this._socket.getInputStream());
        this._out = this._socket.getOutputStream();
        j = 1;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          close();
          if ((!this._options.autoConnectRetry) || ((this._pool != null) && (!this._pool._everWorked))) {
            throw localIOException;
          }
          long l5 = System.currentTimeMillis() - l4;
          if (l5 >= l2) {
            throw localIOException;
          }
          long l3 = l1;
          if (l1 + l5 > l2) {
            l3 = l2 - l5;
          }
          this._logger.log(Level.WARNING, "Exception connecting to " + serverAddress().getHost() + ": " + localIOException + ".  Total wait time so far is " + l5 + " ms.  Will retry after sleeping for " + l3 + " ms.");
          ThreadUtil.sleep(l3);
          l1 = l3 * 2L;
          int j = i;
        }
      }
      i = j;
    } while (j == 0);
  }
  
  CommandResult authenticate(Mongo paramMongo, MongoCredential paramMongoCredential)
  {
    if (paramMongoCredential.getMechanism().equals("MONGODB-CR")) {}
    for (paramMongo = new NativeAuthenticator(paramMongo, paramMongoCredential);; paramMongo = new GSSAPIAuthenticator(paramMongo, paramMongoCredential))
    {
      paramMongo = paramMongo.authenticate();
      this.authenticatedDatabases.add(paramMongoCredential.getSource());
      return paramMongo;
      if (!paramMongoCredential.getMechanism().equals("GSSAPI")) {
        break;
      }
    }
    throw new IllegalArgumentException("Unsupported authentication protocol: " + paramMongoCredential.getMechanism());
  }
  
  Response call(OutMessage paramOutMessage, DBCollection paramDBCollection)
    throws IOException
  {
    return go(paramOutMessage, paramDBCollection);
  }
  
  Response call(OutMessage paramOutMessage, DBCollection paramDBCollection, DBDecoder paramDBDecoder)
    throws IOException
  {
    return go(paramOutMessage, paramDBCollection, false, paramDBDecoder);
  }
  
  void checkAuth(Mongo paramMongo)
    throws IOException
  {
    Object localObject = new HashSet(paramMongo.getAuthority().getCredentialsStore().getDatabases());
    ((Set)localObject).removeAll(this.authenticatedDatabases);
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      authenticate(paramMongo, paramMongo.getAuthority().getCredentialsStore().get(str));
    }
  }
  
  protected void close()
  {
    this.authenticatedDatabases.clear();
    if (this._socket != null) {}
    try
    {
      this._socket.close();
      this._in = null;
      this._out = null;
      this._socket = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public void ensureOpen()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 229	com/mongodb/DBPort:_socket	Ljava/net/Socket;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokevirtual 232	com/mongodb/DBPort:_open	()V
    //   18: goto -7 -> 11
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	26	0	this	DBPort
    //   6	2	1	localSocket	Socket
    //   21	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	21	finally
    //   14	18	21	finally
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    close();
  }
  
  ActiveState getActiveState()
  {
    return this._activeState;
  }
  
  CommandResult getLastError(DB paramDB, WriteConcern paramWriteConcern)
    throws IOException
  {
    try
    {
      paramDB = runCommand((DBApiLayer)paramDB, paramWriteConcern.getCommand());
      return paramDB;
    }
    finally
    {
      paramDB = finally;
      throw paramDB;
    }
  }
  
  int getLocalPort()
  {
    if (this._socket != null) {
      return this._socket.getLocalPort();
    }
    return -1;
  }
  
  public DBPortPool getPool()
  {
    return this._pool;
  }
  
  public int hashCode()
  {
    return this._hashCode;
  }
  
  public String host()
  {
    return this._addr.toString();
  }
  
  CommandResult runCommand(DB paramDB, DBObject paramDBObject)
    throws IOException
  {
    try
    {
      paramDB = convertToCommandResult(paramDBObject, findOne(paramDB, "$cmd", paramDBObject));
      return paramDB;
    }
    finally
    {
      paramDB = finally;
      throw paramDB;
    }
  }
  
  void say(OutMessage paramOutMessage)
    throws IOException
  {
    go(paramOutMessage, null);
  }
  
  public ServerAddress serverAddress()
  {
    return this._sa;
  }
  
  public String toString()
  {
    return "{DBPort  " + host() + "}";
  }
  
  /* Error */
  CommandResult tryGetLastError(DB paramDB, long paramLong, WriteConcern paramWriteConcern)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 105	com/mongodb/DBPort:_calls	Ljava/util/concurrent/atomic/AtomicLong;
    //   6: invokevirtual 507	java/util/concurrent/atomic/AtomicLong:get	()J
    //   9: lstore 5
    //   11: lload_2
    //   12: lload 5
    //   14: lcmp
    //   15: ifeq +9 -> 24
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: areturn
    //   24: aload_0
    //   25: aload_1
    //   26: aload 4
    //   28: invokevirtual 509	com/mongodb/DBPort:getLastError	(Lcom/mongodb/DB;Lcom/mongodb/WriteConcern;)Lcom/mongodb/CommandResult;
    //   31: astore_1
    //   32: goto -12 -> 20
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	DBPort
    //   0	40	1	paramDB	DB
    //   0	40	2	paramLong	long
    //   0	40	4	paramWriteConcern	WriteConcern
    //   9	4	5	l	long
    // Exception table:
    //   from	to	target	type
    //   2	11	35	finally
    //   24	32	35	finally
  }
  
  class ActiveState
  {
    final OutMessage outMessage;
    final long startTime;
    final String threadName;
    
    ActiveState(OutMessage paramOutMessage)
    {
      this.outMessage = paramOutMessage;
      this.startTime = System.nanoTime();
      this.threadName = Thread.currentThread().getName();
    }
  }
  
  abstract class Authenticator
  {
    protected final MongoCredential credential;
    protected final Mongo mongo;
    
    Authenticator(Mongo paramMongo, MongoCredential paramMongoCredential)
    {
      this.mongo = paramMongo;
      this.credential = paramMongoCredential;
    }
    
    abstract CommandResult authenticate();
  }
  
  class GSSAPIAuthenticator
    extends DBPort.SaslAuthenticator
  {
    public static final String GSSAPI_MECHANISM = "GSSAPI";
    public static final String GSSAPI_OID = "1.2.840.113554.1.2.2";
    
    GSSAPIAuthenticator(Mongo paramMongo, MongoCredential paramMongoCredential)
    {
      super(paramMongo, paramMongoCredential);
      if (!this.credential.getMechanism().equals("GSSAPI")) {
        throw new MongoException("Incorrect mechanism: " + this.credential.getMechanism());
      }
    }
    
    private GSSCredential getGSSCredential(String paramString)
      throws GSSException
    {
      Oid localOid = new Oid("1.2.840.113554.1.2.2");
      GSSManager localGSSManager = GSSManager.getInstance();
      return localGSSManager.createCredential(localGSSManager.createName(paramString, GSSName.NT_USER_NAME), Integer.MAX_VALUE, localOid, 1);
    }
    
    protected SaslClient createSaslClient()
    {
      try
      {
        Object localObject = new HashMap();
        ((Map)localObject).put("javax.security.sasl.credentials", getGSSCredential(this.credential.getUserName()));
        String str1 = this.credential.getUserName();
        String str2 = DBPort.this.serverAddress().getHost();
        localObject = Sasl.createSaslClient(new String[] { "GSSAPI" }, str1, "mongodb", str2, (Map)localObject, null);
        return (SaslClient)localObject;
      }
      catch (SaslException localSaslException)
      {
        throw new MongoException("Exception initializing SASL client", localSaslException);
      }
      catch (GSSException localGSSException)
      {
        throw new MongoException("Exception initializing GSSAPI credentials", localGSSException);
      }
    }
    
    protected DB getDatabase()
    {
      return this.mongo.getDB(this.credential.getSource());
    }
    
    public String getMechanismName()
    {
      return "GSSAPI";
    }
  }
  
  class GenericSaslAuthenticator
    extends DBPort.SaslAuthenticator
  {
    static final String CRAM_MD5 = "CRAM-MD5";
    private final String mechanism;
    
    GenericSaslAuthenticator(Mongo paramMongo, MongoCredential paramMongoCredential, String paramString)
    {
      super(paramMongo, paramMongoCredential);
      this.mechanism = paramString;
    }
    
    protected SaslClient createSaslClient()
    {
      try
      {
        Object localObject = this.mechanism;
        String str1 = this.credential.getUserName();
        String str2 = DBPort.this.serverAddress().getHost();
        CredentialsHandlingCallbackHandler localCredentialsHandlingCallbackHandler = new CredentialsHandlingCallbackHandler();
        localObject = Sasl.createSaslClient(new String[] { localObject }, str1, "mongodb", str2, null, localCredentialsHandlingCallbackHandler);
        return (SaslClient)localObject;
      }
      catch (SaslException localSaslException)
      {
        throw new MongoException("Exception initializing SASL client", localSaslException);
      }
    }
    
    protected DB getDatabase()
    {
      return this.mongo.getDB(this.credential.getSource());
    }
    
    public String getMechanismName()
    {
      return this.mechanism;
    }
    
    class CredentialsHandlingCallbackHandler
      implements CallbackHandler
    {
      CredentialsHandlingCallbackHandler() {}
      
      public void handle(Callback[] paramArrayOfCallback)
        throws IOException, UnsupportedCallbackException
      {
        int j = paramArrayOfCallback.length;
        int i = 0;
        while (i < j)
        {
          Callback localCallback = paramArrayOfCallback[i];
          if ((localCallback instanceof NameCallback)) {
            ((NameCallback)localCallback).setName(DBPort.GenericSaslAuthenticator.this.credential.getUserName());
          }
          if ((localCallback instanceof PasswordCallback)) {
            ((PasswordCallback)localCallback).setPassword(new String(NativeAuthenticationHelper.createHash(DBPort.GenericSaslAuthenticator.this.credential.getUserName(), DBPort.GenericSaslAuthenticator.this.credential.getPassword())).toCharArray());
          }
          i += 1;
        }
      }
    }
  }
  
  class NativeAuthenticator
    extends DBPort.Authenticator
  {
    NativeAuthenticator(Mongo paramMongo, MongoCredential paramMongoCredential)
    {
      super(paramMongo, paramMongoCredential);
    }
    
    public CommandResult authenticate()
    {
      try
      {
        Object localObject = this.mongo.getDB(this.credential.getSource());
        CommandResult localCommandResult = DBPort.this.runCommand((DB)localObject, NativeAuthenticationHelper.getNonceCommand());
        localCommandResult.throwOnError();
        localObject = DBPort.this.runCommand((DB)localObject, NativeAuthenticationHelper.getAuthCommand(this.credential.getUserName(), this.credential.getPassword(), localCommandResult.getString("nonce")));
        ((CommandResult)localObject).throwOnError();
        return (CommandResult)localObject;
      }
      catch (IOException localIOException)
      {
        throw new MongoException.Network("IOException authenticating the connection", localIOException);
      }
    }
  }
  
  abstract class SaslAuthenticator
    extends DBPort.Authenticator
  {
    public static final String MONGODB_PROTOCOL = "mongodb";
    
    SaslAuthenticator(Mongo paramMongo, MongoCredential paramMongoCredential)
    {
      super(paramMongo, paramMongoCredential);
    }
    
    private CommandResult sendSaslContinue(int paramInt, byte[] paramArrayOfByte)
      throws IOException
    {
      DB localDB = getDatabase();
      paramArrayOfByte = new BasicDBObject("saslContinue", Integer.valueOf(1)).append("conversationId", Integer.valueOf(paramInt)).append("payload", paramArrayOfByte);
      return DBPort.this.runCommand(localDB, paramArrayOfByte);
    }
    
    private CommandResult sendSaslStart(byte[] paramArrayOfByte)
      throws IOException
    {
      BasicDBObject localBasicDBObject = new BasicDBObject("saslStart", Integer.valueOf(1)).append("mechanism", getMechanismName());
      if (paramArrayOfByte != null) {}
      for (;;)
      {
        paramArrayOfByte = localBasicDBObject.append("payload", paramArrayOfByte);
        return DBPort.this.runCommand(getDatabase(), paramArrayOfByte);
        paramArrayOfByte = new byte[0];
      }
    }
    
    public CommandResult authenticate()
    {
      SaslClient localSaslClient = createSaslClient();
      for (;;)
      {
        int i;
        try
        {
          if (localSaslClient.hasInitialResponse())
          {
            Object localObject1 = localSaslClient.evaluateChallenge(new byte[0]);
            localObject1 = sendSaslStart((byte[])localObject1);
            ((CommandResult)localObject1).throwOnError();
            i = ((Integer)((CommandResult)localObject1).get("conversationId")).intValue();
            if (((Boolean)((CommandResult)localObject1).get("done")).booleanValue()) {
              break label135;
            }
            localObject1 = localSaslClient.evaluateChallenge((byte[])((CommandResult)localObject1).get("payload"));
            if (localObject1 != null) {
              break label121;
            }
            throw new MongoException("SASL protocol error: no client response to challenge");
          }
        }
        catch (IOException localIOException)
        {
          localIOException = localIOException;
          throw new MongoException.Network("IOException authenticating the connection", localIOException);
        }
        finally {}
        try
        {
          localSaslClient.dispose();
          throw ((Throwable)localObject2);
          Object localObject3 = null;
          continue;
          label121:
          localObject3 = sendSaslContinue(i, (byte[])localObject3);
          ((CommandResult)localObject3).throwOnError();
          continue;
          try
          {
            label135:
            localSaslClient.dispose();
            return (CommandResult)localObject3;
          }
          catch (SaslException localSaslException1)
          {
            return (CommandResult)localObject3;
          }
        }
        catch (SaslException localSaslException2)
        {
          for (;;) {}
        }
      }
    }
    
    protected abstract SaslClient createSaslClient();
    
    protected abstract DB getDatabase();
    
    public abstract String getMechanismName();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/DBPort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */