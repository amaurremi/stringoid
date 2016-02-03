package com.parse;

import com.parse.codec.digest.DigestUtils;
import com.parse.signpost.OAuthConsumer;
import com.parse.signpost.commonshttp.CommonsHttpOAuthConsumer;
import com.parse.signpost.exception.OAuthCommunicationException;
import com.parse.signpost.exception.OAuthExpectationFailedException;
import com.parse.signpost.exception.OAuthMessageSignerException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

class ParseCommand
{
  private static int CONNECTION_TIMEOUT = 10000;
  private static int INITIAL_DELAY = 1000;
  private static int SOCKET_TIMEOUT;
  static final ScheduledExecutorService networkThreadPool = Executors.newScheduledThreadPool(5);
  static HttpClient testClient = null;
  private int attemptsMade = 0;
  private HttpClient client;
  private AtomicReference<Task<Object>.TaskCompletionSource> currentTask = new AtomicReference();
  private long delay = 0L;
  private String localId;
  String op;
  JSONObject params;
  private HttpPost post;
  private boolean retryEnabled = false;
  private final String sessionToken;
  
  static
  {
    SOCKET_TIMEOUT = 10000;
  }
  
  ParseCommand(String paramString1, String paramString2)
  {
    this.op = paramString1;
    this.params = new JSONObject();
    this.sessionToken = paramString2;
    paramString1 = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(paramString1, CONNECTION_TIMEOUT);
    HttpConnectionParams.setSoTimeout(paramString1, SOCKET_TIMEOUT);
    if (testClient != null) {}
    for (paramString1 = testClient;; paramString1 = new DefaultHttpClient(paramString1))
    {
      this.client = paramString1;
      maybeSetupHttpProxy();
      return;
    }
  }
  
  ParseCommand(JSONObject paramJSONObject)
    throws JSONException
  {
    this.op = paramJSONObject.getString("op");
    this.params = paramJSONObject.getJSONObject("params");
    this.localId = paramJSONObject.optString("localId", null);
    Object localObject = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, CONNECTION_TIMEOUT);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject, SOCKET_TIMEOUT);
    if (testClient != null) {}
    for (localObject = testClient;; localObject = new DefaultHttpClient((HttpParams)localObject))
    {
      this.client = ((HttpClient)localObject);
      maybeSetupHttpProxy();
      if (!paramJSONObject.has("session_token")) {
        break;
      }
      this.sessionToken = paramJSONObject.getString("session_token");
      return;
    }
    this.sessionToken = ParseUser.getCurrentSessionToken();
  }
  
  static void addToStringer(JSONStringer paramJSONStringer, Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof JSONObject))
    {
      paramJSONStringer.object();
      paramObject = (JSONObject)paramObject;
      Iterator localIterator = ((JSONObject)paramObject).keys();
      Object localObject = new ArrayList();
      if (!localIterator.hasNext())
      {
        Collections.sort((List)localObject);
        localIterator = ((ArrayList)localObject).iterator();
      }
      for (;;)
      {
        if (!localIterator.hasNext())
        {
          paramJSONStringer.endObject();
          return;
          ((ArrayList)localObject).add((String)localIterator.next());
          break;
        }
        localObject = (String)localIterator.next();
        paramJSONStringer.key((String)localObject);
        addToStringer(paramJSONStringer, ((JSONObject)paramObject).opt((String)localObject));
      }
    }
    if ((paramObject instanceof JSONArray))
    {
      paramObject = (JSONArray)paramObject;
      paramJSONStringer.array();
      int i = 0;
      for (;;)
      {
        if (i >= ((JSONArray)paramObject).length())
        {
          paramJSONStringer.endArray();
          return;
        }
        addToStringer(paramJSONStringer, ((JSONArray)paramObject).get(i));
        i += 1;
      }
    }
    paramJSONStringer.value(paramObject);
  }
  
  private void calculateNextDelay()
  {
    this.delay *= 2L;
  }
  
  private static void getLocalPointersIn(Object paramObject, ArrayList<JSONObject> paramArrayList)
    throws JSONException
  {
    JSONObject localJSONObject;
    Iterator localIterator;
    if ((paramObject instanceof JSONObject))
    {
      localJSONObject = (JSONObject)paramObject;
      if (("Pointer".equals(localJSONObject.opt("__type"))) && (localJSONObject.has("localId")))
      {
        paramArrayList.add((JSONObject)paramObject);
        return;
      }
      localIterator = localJSONObject.keys();
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (!(paramObject instanceof JSONArray)) {
          break;
        }
        paramObject = (JSONArray)paramObject;
        int i = 0;
        while (i < ((JSONArray)paramObject).length())
        {
          getLocalPointersIn(((JSONArray)paramObject).get(i), paramArrayList);
          i += 1;
        }
        break;
      }
      getLocalPointersIn(localJSONObject.get((String)localIterator.next()), paramArrayList);
    }
  }
  
  private void maybeSetupHttpProxy()
  {
    Object localObject = System.getProperty("http.proxyHost");
    String str = System.getProperty("http.proxyPort");
    if ((localObject == null) || (((String)localObject).length() == 0) || (str == null) || (str.length() == 0)) {
      return;
    }
    localObject = new HttpHost((String)localObject, Integer.parseInt(str), "http");
    this.client.getParams().setParameter("http.route.default-proxy", localObject);
  }
  
  private Task<JSONObject> sendRequestAsync(final HttpClient paramHttpClient, final HttpPost paramHttpPost)
  {
    if (((Task.TaskCompletionSource)this.currentTask.get()).getTask().isCancelled()) {
      return Task.cancelled();
    }
    Task.call(new Callable()
    {
      /* Error */
      public JSONObject call()
        throws Exception
      {
        // Byte code:
        //   0: new 46	java/io/BufferedReader
        //   3: dup
        //   4: new 48	java/io/InputStreamReader
        //   7: dup
        //   8: aload_0
        //   9: getfield 24	com/parse/ParseCommand$6:val$client	Lorg/apache/http/client/HttpClient;
        //   12: aload_0
        //   13: getfield 26	com/parse/ParseCommand$6:val$post	Lorg/apache/http/client/methods/HttpPost;
        //   16: invokeinterface 54 2 0
        //   21: invokeinterface 60 1 0
        //   26: invokeinterface 66 1 0
        //   31: ldc 68
        //   33: invokespecial 71	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
        //   36: sipush 8192
        //   39: invokespecial 74	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
        //   42: invokevirtual 78	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   45: astore_1
        //   46: new 80	org/json/JSONObject
        //   49: dup
        //   50: new 82	org/json/JSONTokener
        //   53: dup
        //   54: aload_1
        //   55: invokespecial 85	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
        //   58: invokespecial 88	org/json/JSONObject:<init>	(Lorg/json/JSONTokener;)V
        //   61: astore_1
        //   62: aload_1
        //   63: areturn
        //   64: astore_1
        //   65: aload_0
        //   66: getfield 22	com/parse/ParseCommand$6:this$0	Lcom/parse/ParseCommand;
        //   69: ldc 90
        //   71: aload_1
        //   72: invokevirtual 94	com/parse/ParseCommand:connectionFailed	(Ljava/lang/String;Ljava/lang/Exception;)Lcom/parse/ParseException;
        //   75: athrow
        //   76: astore_1
        //   77: aload_0
        //   78: getfield 22	com/parse/ParseCommand$6:this$0	Lcom/parse/ParseCommand;
        //   81: ldc 96
        //   83: aload_1
        //   84: invokevirtual 94	com/parse/ParseCommand:connectionFailed	(Ljava/lang/String;Ljava/lang/Exception;)Lcom/parse/ParseException;
        //   87: athrow
        //   88: astore_1
        //   89: aload_0
        //   90: getfield 22	com/parse/ParseCommand$6:this$0	Lcom/parse/ParseCommand;
        //   93: ldc 98
        //   95: aload_1
        //   96: invokevirtual 94	com/parse/ParseCommand:connectionFailed	(Ljava/lang/String;Ljava/lang/Exception;)Lcom/parse/ParseException;
        //   99: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	100	0	this	6
        //   45	18	1	localObject	Object
        //   64	8	1	localClientProtocolException	org.apache.http.client.ClientProtocolException
        //   76	8	1	localIOException	java.io.IOException
        //   88	8	1	localJSONException	JSONException
        // Exception table:
        //   from	to	target	type
        //   0	46	64	org/apache/http/client/ClientProtocolException
        //   0	46	76	java/io/IOException
        //   46	62	88	org/json/JSONException
      }
    }, networkThreadPool);
  }
  
  private Task<JSONObject> sendRequestWithRetriesAsync()
  {
    sendRequestAsync(this.client, this.post).continueWithTask(new Continuation()
    {
      public Task<JSONObject> then(final Task<JSONObject> paramAnonymousTask)
      {
        Object localObject;
        if (((Task.TaskCompletionSource)ParseCommand.this.currentTask.get()).getTask().isCancelled()) {
          localObject = Task.cancelled();
        }
        do
        {
          do
          {
            do
            {
              do
              {
                return (Task<JSONObject>)localObject;
                localObject = ParseCommand.this;
                ((ParseCommand)localObject).attemptsMade += 1;
                localObject = paramAnonymousTask;
              } while (!paramAnonymousTask.isFaulted());
              localObject = paramAnonymousTask;
            } while (!(paramAnonymousTask.getError() instanceof ParseException));
            localObject = paramAnonymousTask;
          } while (!ParseCommand.this.retryEnabled);
          localObject = paramAnonymousTask;
        } while (ParseCommand.this.attemptsMade >= 5);
        Parse.logI("com.parse.ParseCommand", "Fetch failed. Waiting " + ParseCommand.this.delay + " milliseconds before attempt #" + (ParseCommand.this.attemptsMade + 1));
        paramAnonymousTask = Task.create();
        ParseCommand.networkThreadPool.schedule(new Runnable()
        {
          public void run()
          {
            paramAnonymousTask.setResult(null);
          }
        }, ParseCommand.this.delay, TimeUnit.MILLISECONDS);
        paramAnonymousTask.getTask().continueWithTask(new Continuation()
        {
          public Task<JSONObject> then(Task<Void> paramAnonymous2Task)
          {
            ParseCommand.this.calculateNextDelay();
            return ParseCommand.this.sendRequestWithRetriesAsync();
          }
        });
      }
    });
  }
  
  public static void setInitialDelay(double paramDouble)
  {
    INITIAL_DELAY = (int)(1000.0D * paramDouble);
  }
  
  static String toDeterministicString(Object paramObject)
    throws JSONException
  {
    JSONStringer localJSONStringer = new JSONStringer();
    addToStringer(localJSONStringer, paramObject);
    return localJSONStringer.toString();
  }
  
  public void cancel()
  {
    Task.TaskCompletionSource localTaskCompletionSource = (Task.TaskCompletionSource)this.currentTask.get();
    if (localTaskCompletionSource != null) {
      localTaskCompletionSource.trySetCancelled();
    }
    if (this.post != null) {
      this.post.abort();
    }
  }
  
  ParseException connectionFailed(String paramString, Exception paramException)
  {
    return new ParseException(100, paramString + ": " + paramException.getClass().getName() + ": " + paramException.getMessage());
  }
  
  public void enableRetrying()
  {
    this.retryEnabled = true;
    this.delay = (INITIAL_DELAY + (INITIAL_DELAY * Math.random()));
  }
  
  String getCacheKey()
  {
    try
    {
      String str1 = toDeterministicString(this.params);
      String str2 = str1;
      if (this.sessionToken != null) {
        str2 = str1 + this.sessionToken;
      }
      return "ParseCommand." + this.op + "." + "2" + "." + DigestUtils.md5Hex(str2);
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException.getMessage());
    }
  }
  
  String getLocalId()
  {
    return this.localId;
  }
  
  public void maybeChangeServerOperation()
    throws JSONException
  {
    if (this.localId != null)
    {
      String str = LocalIdManager.getDefaultInstance().getObjectId(this.localId);
      if (str != null)
      {
        this.localId = null;
        JSONObject localJSONObject = this.params.optJSONObject("data");
        if (localJSONObject != null) {
          localJSONObject.put("objectId", str);
        }
        if (this.op.equals("create")) {
          this.op = "update";
        }
      }
    }
  }
  
  Task<Object> performAsync()
  {
    return performAsync(false);
  }
  
  Task<Object> performAsync(final boolean paramBoolean)
  {
    Parse.checkInit();
    final Task.TaskCompletionSource localTaskCompletionSource = Task.create();
    this.currentTask.set(localTaskCompletionSource);
    Task.call(new Callable()
    {
      public Void call()
        throws Exception
      {
        ParseCommand.this.resolveLocalIds();
        if ((ParseCommand.this.post == null) || (!ParseCommand.this.post.getURI().getHost().equals(ParseObject.server))) {
          ParseCommand.this.preparePost();
        }
        return null;
      }
    }).continueWithTask(new Continuation()
    {
      public Task<JSONObject> then(Task<Void> paramAnonymousTask)
        throws Exception
      {
        return ParseCommand.this.sendRequestWithRetriesAsync();
      }
    }).onSuccess(new Continuation()
    {
      public Object then(Task<JSONObject> paramAnonymousTask)
        throws Exception
      {
        paramAnonymousTask = (JSONObject)paramAnonymousTask.getResult();
        try
        {
          if (paramAnonymousTask.has("error")) {
            throw new ParseException(paramAnonymousTask.getInt("code"), paramAnonymousTask.getString("error"));
          }
        }
        catch (JSONException paramAnonymousTask)
        {
          throw ParseCommand.this.connectionFailed("corrupted json", paramAnonymousTask);
        }
        paramAnonymousTask = paramAnonymousTask.get("result");
        if (paramBoolean) {
          Parse.saveToKeyValueCache(ParseCommand.this.getCacheKey(), paramAnonymousTask.toString());
        }
        return paramAnonymousTask;
      }
    }).continueWithTask(new Continuation()
    {
      public Task<Void> then(Task<Object> paramAnonymousTask)
        throws Exception
      {
        if (paramAnonymousTask.isCancelled()) {
          localTaskCompletionSource.trySetCancelled();
        }
        for (;;)
        {
          return null;
          if (paramAnonymousTask.isFaulted()) {
            localTaskCompletionSource.trySetError(paramAnonymousTask.getError());
          } else {
            localTaskCompletionSource.trySetResult(paramAnonymousTask.getResult());
          }
        }
      }
    });
    return localTaskCompletionSource.getTask();
  }
  
  void preparePost()
    throws ParseException
  {
    Object localObject = this.params.keys();
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (!((Iterator)localObject).hasNext())
        {
          localJSONObject.put("v", "a1.3.0");
          localJSONObject.put("iid", ParseInstallation.getCurrentInstallation().getInstallationId());
          localJSONObject.put("uuid", UUID.randomUUID().toString());
          if (this.sessionToken != null) {
            localJSONObject.put("session_token", this.sessionToken);
          }
          this.post = new HttpPost(String.format("%s/%s/%s", new Object[] { ParseObject.server, "2", this.op }));
        }
      }
      catch (JSONException localJSONException)
      {
        String str;
        throw new RuntimeException(localJSONException.getMessage());
      }
      try
      {
        localObject = new StringEntity(localJSONObject.toString(), "UTF8");
        ((StringEntity)localObject).setContentType("application/json");
        this.post.setEntity((HttpEntity)localObject);
        localObject = new CommonsHttpOAuthConsumer(Parse.applicationId, Parse.clientKey);
        ((OAuthConsumer)localObject).setTokenWithSecret(null, "");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new RuntimeException(localUnsupportedEncodingException.getMessage());
      }
      try
      {
        ((OAuthConsumer)localObject).sign(this.post);
        return;
      }
      catch (OAuthMessageSignerException localOAuthMessageSignerException)
      {
        throw new ParseException(109, localOAuthMessageSignerException.getMessage());
      }
      catch (OAuthExpectationFailedException localOAuthExpectationFailedException)
      {
        throw new ParseException(109, localOAuthExpectationFailedException.getMessage());
      }
      catch (OAuthCommunicationException localOAuthCommunicationException)
      {
        throw new ParseException(109, localOAuthCommunicationException.getMessage());
      }
      str = (String)((Iterator)localObject).next();
      localJSONObject.put(str, this.params.get(str));
    }
  }
  
  void put(String paramString, int paramInt)
  {
    try
    {
      this.params.put(paramString, paramInt);
      return;
    }
    catch (JSONException paramString)
    {
      throw new RuntimeException(paramString.getMessage());
    }
  }
  
  void put(String paramString, long paramLong)
  {
    try
    {
      this.params.put(paramString, paramLong);
      return;
    }
    catch (JSONException paramString)
    {
      throw new RuntimeException(paramString.getMessage());
    }
  }
  
  void put(String paramString1, String paramString2)
  {
    try
    {
      this.params.put(paramString1, paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      throw new RuntimeException(paramString1.getMessage());
    }
  }
  
  void put(String paramString, JSONArray paramJSONArray)
  {
    try
    {
      this.params.put(paramString, paramJSONArray);
      return;
    }
    catch (JSONException paramString)
    {
      throw new RuntimeException(paramString.getMessage());
    }
  }
  
  void put(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      this.params.put(paramString, paramJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      throw new RuntimeException(paramString.getMessage());
    }
  }
  
  public void releaseLocalIds()
  {
    if (this.localId != null) {
      LocalIdManager.getDefaultInstance().releaseLocalIdOnDisk(this.localId);
    }
    try
    {
      Object localObject1 = this.params.get("data");
      Object localObject2 = new ArrayList();
      getLocalPointersIn(localObject1, (ArrayList)localObject2);
      localObject1 = ((ArrayList)localObject2).iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          return;
        }
        localObject2 = (String)((JSONObject)((Iterator)localObject1).next()).get("localId");
        LocalIdManager.getDefaultInstance().releaseLocalIdOnDisk((String)localObject2);
      }
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  public void resolveLocalIds()
  {
    try
    {
      Object localObject1 = this.params.get("data");
      Object localObject2 = new ArrayList();
      getLocalPointersIn(localObject1, (ArrayList)localObject2);
      localObject1 = ((ArrayList)localObject2).iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext())
        {
          maybeChangeServerOperation();
          return;
        }
        localObject2 = (JSONObject)((Iterator)localObject1).next();
        String str = (String)((JSONObject)localObject2).get("localId");
        str = LocalIdManager.getDefaultInstance().getObjectId(str);
        if (str == null) {
          throw new IllegalStateException("Tried to serialize a command referencing a new, unsaved object.");
        }
        ((JSONObject)localObject2).put("objectId", str);
        ((JSONObject)localObject2).remove("localId");
      }
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  public void retainLocalIds()
  {
    if (this.localId != null) {
      LocalIdManager.getDefaultInstance().retainLocalIdOnDisk(this.localId);
    }
    try
    {
      Object localObject1 = this.params.get("data");
      Object localObject2 = new ArrayList();
      getLocalPointersIn(localObject1, (ArrayList)localObject2);
      localObject1 = ((ArrayList)localObject2).iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          return;
        }
        localObject2 = (String)((JSONObject)((Iterator)localObject1).next()).get("localId");
        LocalIdManager.getDefaultInstance().retainLocalIdOnDisk((String)localObject2);
      }
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  void setLocalId(String paramString)
  {
    this.localId = paramString;
  }
  
  void setOp(String paramString)
  {
    this.op = paramString;
  }
  
  /* Error */
  JSONObject toJSONObject()
  {
    // Byte code:
    //   0: new 83	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 84	org/json/JSONObject:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc 114
    //   11: aload_0
    //   12: getfield 81	com/parse/ParseCommand:op	Ljava/lang/String;
    //   15: invokevirtual 431	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   18: pop
    //   19: aload_2
    //   20: ldc 119
    //   22: aload_0
    //   23: getfield 86	com/parse/ParseCommand:params	Lorg/json/JSONObject;
    //   26: invokevirtual 431	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload_0
    //   31: getfield 130	com/parse/ParseCommand:localId	Ljava/lang/String;
    //   34: ifnull +14 -> 48
    //   37: aload_2
    //   38: ldc 124
    //   40: aload_0
    //   41: getfield 130	com/parse/ParseCommand:localId	Ljava/lang/String;
    //   44: invokevirtual 431	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   47: pop
    //   48: aload_0
    //   49: getfield 88	com/parse/ParseCommand:sessionToken	Ljava/lang/String;
    //   52: ifnull +18 -> 70
    //   55: aload_0
    //   56: getfield 88	com/parse/ParseCommand:sessionToken	Ljava/lang/String;
    //   59: astore_1
    //   60: aload_2
    //   61: ldc -124
    //   63: aload_1
    //   64: invokevirtual 431	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   67: pop
    //   68: aload_2
    //   69: areturn
    //   70: getstatic 589	org/json/JSONObject:NULL	Ljava/lang/Object;
    //   73: astore_1
    //   74: goto -14 -> 60
    //   77: astore_1
    //   78: new 407	java/lang/RuntimeException
    //   81: dup
    //   82: aload_1
    //   83: invokevirtual 408	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   86: invokespecial 409	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	ParseCommand
    //   59	15	1	localObject	Object
    //   77	6	1	localJSONException	JSONException
    //   7	62	2	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	48	77	org/json/JSONException
    //   48	60	77	org/json/JSONException
    //   60	68	77	org/json/JSONException
    //   70	74	77	org/json/JSONException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */