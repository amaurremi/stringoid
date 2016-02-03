package com.parse;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONObject;

public class ParseFile
{
  private Set<Task<?>.TaskCompletionSource> currentTasks = Collections.synchronizedSet(new HashSet());
  private byte[] data;
  private boolean dirty = false;
  private HttpPost fileUploadPost = null;
  private String name = null;
  final TaskQueue taskQueue = new TaskQueue();
  private String url = null;
  
  ParseFile(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.url = paramString2;
  }
  
  public ParseFile(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > Parse.maxParseFileSize) {
      throw new IllegalArgumentException(String.format("ParseFile must be less than %i bytes", new Object[] { Integer.valueOf(Parse.maxParseFileSize) }));
    }
    this.name = paramString;
    this.data = paramArrayOfByte;
    this.dirty = true;
  }
  
  public ParseFile(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > Parse.maxParseFileSize) {
      throw new IllegalArgumentException(String.format("ParseFile must be less than %i bytes", new Object[] { Integer.valueOf(Parse.maxParseFileSize) }));
    }
    this.dirty = true;
    this.data = paramArrayOfByte;
  }
  
  private ParseCommand constructFileUploadCommand(String paramString)
  {
    paramString = new ParseCommand("upload_file", paramString);
    paramString.enableRetrying();
    if (this.name != null) {
      paramString.put("name", this.name);
    }
    return paramString;
  }
  
  private Task<byte[]> getDataAsync(final ProgressCallback paramProgressCallback, Task<Void> paramTask)
  {
    if (isDataAvailable()) {
      return Task.forResult(this.data);
    }
    final Task.TaskCompletionSource localTaskCompletionSource = Task.create();
    this.currentTasks.add(localTaskCompletionSource);
    paramTask.continueWith(new Continuation()
    {
      public Void then(Task<Void> paramAnonymousTask)
        throws Exception
      {
        new ParseRequestRetryer(new HttpGet(ParseFile.this.url), 1000L, 5).goAsync(paramProgressCallback).continueWithTask(new Continuation()
        {
          public Task<byte[]> then(Task<byte[]> paramAnonymous2Task)
            throws Exception
          {
            if ((paramAnonymous2Task.isFaulted()) && ((paramAnonymous2Task.getError() instanceof IllegalStateException))) {
              return Task.forError(new ParseException(100, paramAnonymous2Task.getError().getMessage()));
            }
            if (this.val$tcs.getTask().isCancelled()) {
              return this.val$tcs.getTask();
            }
            ParseFile.this.data = ((byte[])paramAnonymous2Task.getResult());
            return paramAnonymous2Task;
          }
        }).continueWith(new Continuation()
        {
          public Void then(Task<byte[]> paramAnonymous2Task)
            throws Exception
          {
            ParseFile.this.currentTasks.remove(this.val$tcs);
            if (paramAnonymous2Task.isCancelled()) {
              this.val$tcs.trySetCancelled();
            }
            for (;;)
            {
              return null;
              if (paramAnonymous2Task.isFaulted()) {
                this.val$tcs.trySetError(paramAnonymous2Task.getError());
              } else {
                this.val$tcs.trySetResult((byte[])paramAnonymous2Task.getResult());
              }
            }
          }
        });
        return null;
      }
    });
    return localTaskCompletionSource.getTask();
  }
  
  private Task<Void> handleFileUploadResultAsync(JSONObject paramJSONObject, ProgressCallback paramProgressCallback)
  {
    if (this.fileUploadPost == null) {
      prepareFileUploadPost(paramJSONObject, paramProgressCallback);
    }
    return new ParseRequestRetryer(this.fileUploadPost, 1000L, 5).goAsync(null).makeVoid();
  }
  
  /* Error */
  private void prepareFileUploadPost(JSONObject paramJSONObject, ProgressCallback paramProgressCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: ldc -119
    //   4: invokevirtual 204	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7: putfield 51	com/parse/ParseFile:name	Ljava/lang/String;
    //   10: aload_0
    //   11: aload_1
    //   12: ldc -51
    //   14: invokevirtual 204	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   17: putfield 53	com/parse/ParseFile:url	Ljava/lang/String;
    //   20: aload_1
    //   21: ldc -49
    //   23: invokevirtual 211	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   26: astore 4
    //   28: aconst_null
    //   29: astore_3
    //   30: new 213	com/parse/CountingMultipartEntity
    //   33: dup
    //   34: getstatic 219	com/parse/entity/mime/HttpMultipartMode:BROWSER_COMPATIBLE	Lcom/parse/entity/mime/HttpMultipartMode;
    //   37: aload_2
    //   38: invokespecial 222	com/parse/CountingMultipartEntity:<init>	(Lcom/parse/entity/mime/HttpMultipartMode;Lcom/parse/ProgressCallback;)V
    //   41: astore 5
    //   43: aload_3
    //   44: astore_2
    //   45: aload_0
    //   46: getfield 51	com/parse/ParseFile:name	Ljava/lang/String;
    //   49: ldc -32
    //   51: invokevirtual 228	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   54: iconst_m1
    //   55: if_icmpeq +30 -> 85
    //   58: aload_0
    //   59: getfield 51	com/parse/ParseFile:name	Ljava/lang/String;
    //   62: aload_0
    //   63: getfield 51	com/parse/ParseFile:name	Ljava/lang/String;
    //   66: ldc -32
    //   68: invokevirtual 228	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   71: iconst_1
    //   72: iadd
    //   73: invokevirtual 232	java/lang/String:substring	(I)Ljava/lang/String;
    //   76: astore_2
    //   77: invokestatic 238	android/webkit/MimeTypeMap:getSingleton	()Landroid/webkit/MimeTypeMap;
    //   80: aload_2
    //   81: invokevirtual 241	android/webkit/MimeTypeMap:getMimeTypeFromExtension	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore_2
    //   85: aload_2
    //   86: astore_3
    //   87: aload_2
    //   88: ifnonnull +6 -> 94
    //   91: ldc -13
    //   93: astore_3
    //   94: aload 5
    //   96: ldc -11
    //   98: new 247	com/parse/entity/mime/content/StringBody
    //   101: dup
    //   102: aload_3
    //   103: invokespecial 248	com/parse/entity/mime/content/StringBody:<init>	(Ljava/lang/String;)V
    //   106: invokevirtual 252	com/parse/CountingMultipartEntity:addPart	(Ljava/lang/String;Lcom/parse/entity/mime/content/ContentBody;)V
    //   109: aload 4
    //   111: invokevirtual 256	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   114: astore_2
    //   115: aload_2
    //   116: invokeinterface 261 1 0
    //   121: ifne +80 -> 201
    //   124: aload 5
    //   126: ldc_w 263
    //   129: new 265	com/parse/entity/mime/content/ByteArrayBody
    //   132: dup
    //   133: aload_0
    //   134: getfield 100	com/parse/ParseFile:data	[B
    //   137: aload_3
    //   138: ldc_w 263
    //   141: invokespecial 268	com/parse/entity/mime/content/ByteArrayBody:<init>	([BLjava/lang/String;Ljava/lang/String;)V
    //   144: invokevirtual 252	com/parse/CountingMultipartEntity:addPart	(Ljava/lang/String;Lcom/parse/entity/mime/content/ContentBody;)V
    //   147: aload_0
    //   148: new 270	org/apache/http/client/methods/HttpPost
    //   151: dup
    //   152: aload_1
    //   153: ldc_w 272
    //   156: invokevirtual 204	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   159: invokespecial 273	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   162: putfield 55	com/parse/ParseFile:fileUploadPost	Lorg/apache/http/client/methods/HttpPost;
    //   165: aload_0
    //   166: getfield 55	com/parse/ParseFile:fileUploadPost	Lorg/apache/http/client/methods/HttpPost;
    //   169: aload 5
    //   171: invokevirtual 277	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   174: return
    //   175: astore_1
    //   176: new 279	java/lang/RuntimeException
    //   179: dup
    //   180: aload_1
    //   181: invokevirtual 283	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   184: invokespecial 284	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   187: athrow
    //   188: astore_1
    //   189: new 279	java/lang/RuntimeException
    //   192: dup
    //   193: aload_1
    //   194: invokevirtual 285	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   197: invokespecial 284	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   200: athrow
    //   201: aload_2
    //   202: invokeinterface 289 1 0
    //   207: checkcast 91	java/lang/String
    //   210: astore 6
    //   212: aload 5
    //   214: aload 6
    //   216: new 247	com/parse/entity/mime/content/StringBody
    //   219: dup
    //   220: aload 4
    //   222: aload 6
    //   224: invokevirtual 204	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   227: invokespecial 248	com/parse/entity/mime/content/StringBody:<init>	(Ljava/lang/String;)V
    //   230: invokevirtual 252	com/parse/CountingMultipartEntity:addPart	(Ljava/lang/String;Lcom/parse/entity/mime/content/ContentBody;)V
    //   233: goto -118 -> 115
    //   236: astore_1
    //   237: new 279	java/lang/RuntimeException
    //   240: dup
    //   241: aload_1
    //   242: invokevirtual 285	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   245: invokespecial 284	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   248: athrow
    //   249: astore_1
    //   250: new 279	java/lang/RuntimeException
    //   253: dup
    //   254: aload_1
    //   255: invokevirtual 283	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   258: invokespecial 284	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   261: athrow
    //   262: astore_1
    //   263: new 279	java/lang/RuntimeException
    //   266: dup
    //   267: aload_1
    //   268: invokevirtual 283	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   271: invokespecial 284	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   274: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	ParseFile
    //   0	275	1	paramJSONObject	JSONObject
    //   0	275	2	paramProgressCallback	ProgressCallback
    //   29	109	3	localObject	Object
    //   26	195	4	localJSONObject	JSONObject
    //   41	172	5	localCountingMultipartEntity	CountingMultipartEntity
    //   210	13	6	str	String
    // Exception table:
    //   from	to	target	type
    //   0	28	175	org/json/JSONException
    //   94	109	188	java/io/UnsupportedEncodingException
    //   212	233	236	java/io/UnsupportedEncodingException
    //   212	233	249	org/json/JSONException
    //   147	165	262	org/json/JSONException
  }
  
  private void save(ProgressCallback paramProgressCallback)
    throws ParseException
  {
    Parse.waitForTask(saveAsync(paramProgressCallback));
  }
  
  public void cancel()
  {
    HashSet localHashSet = new HashSet(this.currentTasks);
    Iterator localIterator = localHashSet.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        this.currentTasks.removeAll(localHashSet);
        return;
      }
      ((Task.TaskCompletionSource)localIterator.next()).trySetCancelled();
    }
  }
  
  public byte[] getData()
    throws ParseException
  {
    return (byte[])Parse.waitForTask(getDataAsync(null));
  }
  
  Task<byte[]> getDataAsync(final ProgressCallback paramProgressCallback)
  {
    this.taskQueue.enqueue(new Continuation()
    {
      public Task<byte[]> then(Task<Void> paramAnonymousTask)
        throws Exception
      {
        return ParseFile.this.getDataAsync(paramProgressCallback, paramAnonymousTask);
      }
    });
  }
  
  public void getDataInBackground(GetDataCallback paramGetDataCallback)
  {
    getDataInBackground(paramGetDataCallback, null);
  }
  
  public void getDataInBackground(GetDataCallback paramGetDataCallback, ProgressCallback paramProgressCallback)
  {
    Parse.callbackOnMainThreadAsync(getDataAsync(paramProgressCallback), paramGetDataCallback);
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public boolean isDataAvailable()
  {
    return this.data != null;
  }
  
  public boolean isDirty()
  {
    return this.dirty;
  }
  
  public void save()
    throws ParseException
  {
    save(null);
  }
  
  Task<Void> saveAsync(final ProgressCallback paramProgressCallback)
  {
    this.taskQueue.enqueue(new Continuation()
    {
      public Task<Void> then(Task<Void> paramAnonymousTask)
        throws Exception
      {
        return ParseFile.this.saveAsync(paramProgressCallback, paramAnonymousTask);
      }
    });
  }
  
  Task<Void> saveAsync(final ProgressCallback paramProgressCallback, Task<Void> paramTask)
  {
    if (!isDirty()) {
      return Task.forResult(null);
    }
    final Task.TaskCompletionSource localTaskCompletionSource = Task.create();
    this.currentTasks.add(localTaskCompletionSource);
    paramTask.continueWith(new Continuation()
    {
      public Void then(Task<Void> paramAnonymousTask)
        throws Exception
      {
        if (!ParseFile.this.isDirty())
        {
          localTaskCompletionSource.trySetResult(null);
          return null;
        }
        Task.call(new Callable()
        {
          public ParseCommand call()
            throws Exception
          {
            final ParseCommand localParseCommand = ParseFile.this.constructFileUploadCommand(this.val$sessionToken);
            this.val$tcs.getTask().continueWith(new Continuation()
            {
              public Void then(Task<Void> paramAnonymous3Task)
                throws Exception
              {
                if (paramAnonymous3Task.isCancelled()) {
                  localParseCommand.cancel();
                }
                return null;
              }
            });
            return localParseCommand;
          }
        }).onSuccessTask(new Continuation()
        {
          public Task<Object> then(Task<ParseCommand> paramAnonymous2Task)
            throws Exception
          {
            return ((ParseCommand)paramAnonymous2Task.getResult()).performAsync();
          }
        }).onSuccessTask(new Continuation()
        {
          public Task<Void> then(Task<Object> paramAnonymous2Task)
            throws Exception
          {
            return ParseFile.this.handleFileUploadResultAsync((JSONObject)paramAnonymous2Task.getResult(), this.val$progressCallback);
          }
        }).continueWithTask(new Continuation()
        {
          public Task<Void> then(Task<Void> paramAnonymous2Task)
            throws Exception
          {
            if (!paramAnonymous2Task.isFaulted()) {
              ParseFile.this.dirty = false;
            }
            return paramAnonymous2Task;
          }
        }).continueWith(new Continuation()
        {
          public Void then(Task<Void> paramAnonymous2Task)
            throws Exception
          {
            ParseFile.this.currentTasks.remove(this.val$tcs);
            if (paramAnonymous2Task.isCancelled()) {
              this.val$tcs.trySetCancelled();
            }
            for (;;)
            {
              return null;
              if (paramAnonymous2Task.isFaulted()) {
                this.val$tcs.trySetError(paramAnonymous2Task.getError());
              } else {
                this.val$tcs.trySetResult((Void)paramAnonymous2Task.getResult());
              }
            }
          }
        });
        return null;
      }
    });
    return localTaskCompletionSource.getTask();
  }
  
  public void saveInBackground()
  {
    saveInBackground(null);
  }
  
  public void saveInBackground(SaveCallback paramSaveCallback)
  {
    saveInBackground(paramSaveCallback, null);
  }
  
  public void saveInBackground(SaveCallback paramSaveCallback, ProgressCallback paramProgressCallback)
  {
    try
    {
      Parse.callbackOnMainThreadAsync(saveAsync(paramProgressCallback), paramSaveCallback);
      return;
    }
    finally
    {
      paramSaveCallback = finally;
      throw paramSaveCallback;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */