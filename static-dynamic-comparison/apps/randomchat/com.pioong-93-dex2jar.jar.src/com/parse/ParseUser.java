package com.parse;

import com.parse.auth.ParseAuthenticationProvider;
import com.parse.auth.ParseAuthenticationProvider.ParseAuthenticationCallback;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParseClassName("_User")
public class ParseUser
  extends ParseObject
{
  private static final String CURRENT_USER_FILENAME = "currentUser";
  private static Map<String, ParseAuthenticationProvider> authenticationProviders = new HashMap();
  private static boolean autoUserEnabled;
  private static ParseUser currentUser;
  private static boolean currentUserMatchesDisk = false;
  private static final Object currentUserMutex = new Object();
  private final JSONObject authData = new JSONObject();
  private boolean isCurrentUser = false;
  private boolean isLazy = false;
  private boolean isNew;
  private final Set<String> linkedServiceNames = new HashSet();
  private String password;
  private final Set<String> readOnlyLinkedServiceNames = Collections.unmodifiableSet(this.linkedServiceNames);
  private String sessionToken;
  
  private static Task<JSONObject> authenticateAsync(ParseAuthenticationProvider paramParseAuthenticationProvider)
  {
    Task.TaskCompletionSource localTaskCompletionSource = Task.create();
    paramParseAuthenticationProvider.authenticate(new ParseAuthenticationProvider.ParseAuthenticationCallback()
    {
      public void onCancel()
      {
        ParseUser.this.setCancelled();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        ParseUser.this.setError(new ParseException(paramAnonymousThrowable));
      }
      
      public void onSuccess(JSONObject paramAnonymousJSONObject)
      {
        ParseUser.this.setResult(paramAnonymousJSONObject);
      }
    });
    return localTaskCompletionSource.getTask();
  }
  
  private static void checkApplicationContext()
  {
    if (Parse.applicationContext == null) {
      throw new RuntimeException("You must call Parse.initialize(context, oauthKey, oauthSecret) before using the Parse library.");
    }
  }
  
  static void clearCurrentUserFromMemory()
  {
    synchronized (currentUserMutex)
    {
      currentUser = null;
      currentUserMatchesDisk = false;
      return;
    }
  }
  
  private static ParseCommand constructLogInCommand(String paramString1, String paramString2)
  {
    ParseCommand localParseCommand = new ParseCommand("user_login", null);
    localParseCommand.put("username", paramString1);
    localParseCommand.put("user_password", paramString2);
    return localParseCommand;
  }
  
  private static ParseCommand constructPasswordResetCommand(String paramString1, String paramString2)
  {
    paramString2 = new ParseCommand("user_request_password_reset", paramString2);
    paramString2.put("email", paramString1);
    return paramString2;
  }
  
  private ParseCommand constructSignUpCommand(Map<String, ParseFieldOperation> paramMap, String paramString)
    throws ParseException
  {
    paramMap = constructSaveCommand(paramMap, paramString);
    paramMap.setOp("user_signup");
    return paramMap;
  }
  
  private ParseCommand constructSignUpOrLoginCommand(Map<String, ParseFieldOperation> paramMap)
    throws ParseException
  {
    for (;;)
    {
      ParseCommand localParseCommand;
      String str;
      synchronized (this.mutex)
      {
        localParseCommand = new ParseCommand("user_signup_or_login", null);
        paramMap = toJSONObjectForSaving(paramMap);
        Iterator localIterator = paramMap.keys();
        if (!localIterator.hasNext())
        {
          if (this.password != null) {
            localParseCommand.put("user_password", this.password);
          }
          return localParseCommand;
        }
        str = (String)localIterator.next();
      }
      try
      {
        Object localObject2 = paramMap.get(str);
        if ((localObject2 instanceof JSONObject))
        {
          localParseCommand.put(str, (JSONObject)localObject2);
        }
        else if ((localObject2 instanceof JSONArray))
        {
          localParseCommand.put(str, (JSONArray)localObject2);
          continue;
          paramMap = finally;
          throw paramMap;
        }
        else if ((localObject2 instanceof String))
        {
          localParseCommand.put(str, (String)localObject2);
        }
        else
        {
          localParseCommand.put(str, paramMap.getInt(str));
        }
      }
      catch (JSONException localJSONException) {}
    }
  }
  
  static void disableAutomaticUser()
  {
    autoUserEnabled = false;
  }
  
  public static void enableAutomaticUser()
  {
    autoUserEnabled = true;
  }
  
  static String getCurrentSessionToken()
  {
    synchronized (currentUserMutex)
    {
      if (getCurrentUser() != null)
      {
        String str = getCurrentUser().getSessionToken();
        return str;
      }
      return null;
    }
  }
  
  public static ParseUser getCurrentUser()
  {
    synchronized (currentUserMutex)
    {
      checkApplicationContext();
      ParseUser localParseUser;
      if (currentUser != null)
      {
        localParseUser = currentUser;
        return localParseUser;
      }
      if (currentUserMatchesDisk)
      {
        if (isAutomaticUserEnabled()) {
          ParseAnonymousUtils.lazyLogIn();
        }
        localParseUser = currentUser;
        return localParseUser;
      }
    }
    currentUserMatchesDisk = true;
    Object localObject3 = getFromDisk(Parse.applicationContext, "currentUser");
    if (localObject3 == null)
    {
      if (isAutomaticUserEnabled()) {
        ParseAnonymousUtils.lazyLogIn();
      }
      localObject3 = currentUser;
      return (ParseUser)localObject3;
    }
    currentUser = (ParseUser)localObject3;
    currentUser.isCurrentUser = true;
    localObject3 = currentUser;
    return (ParseUser)localObject3;
  }
  
  public static ParseQuery<ParseUser> getQuery()
  {
    return ParseQuery.getQuery(ParseUser.class);
  }
  
  static boolean isAutomaticUserEnabled()
  {
    return autoUserEnabled;
  }
  
  private Task<Void> linkWithAsync(final ParseAuthenticationProvider paramParseAuthenticationProvider)
  {
    authenticateAsync(paramParseAuthenticationProvider).onSuccessTask(new Continuation()
    {
      public Task<Void> then(Task<JSONObject> paramAnonymousTask)
        throws Exception
      {
        return ParseUser.this.linkWithAsync(paramParseAuthenticationProvider.getAuthType(), (JSONObject)paramAnonymousTask.getResult());
      }
    });
  }
  
  private Task<Void> linkWithAsync(final String paramString, final JSONObject paramJSONObject, final Task<Void> paramTask)
  {
    final JSONObject localJSONObject = paramJSONObject.optJSONObject("anonymous");
    synchronized (this.mutex)
    {
      paramString = Task.call(new Callable()
      {
        public Void call()
          throws Exception
        {
          synchronized (ParseUser.this.mutex)
          {
            ParseUser.this.authData.put(paramString, paramJSONObject);
            ParseUser.this.linkedServiceNames.add(paramString);
            ParseUser.this.stripAnonymity();
            ParseUser.this.dirty = true;
            return null;
          }
        }
      }).onSuccessTask(new Continuation()
      {
        public Task<Void> then(Task<Void> paramAnonymousTask)
          throws Exception
        {
          return ParseUser.this.saveAsync(paramTask);
        }
      }).continueWithTask(new Continuation()
      {
        public Task<Void> then(Task<Void> paramAnonymousTask)
          throws Exception
        {
          synchronized (ParseUser.this.mutex)
          {
            if ((paramAnonymousTask.isFaulted()) || (paramAnonymousTask.isCancelled()))
            {
              ParseUser.this.restoreAnonymity(localJSONObject);
              return paramAnonymousTask;
            }
            ParseUser.this.synchronizeAuthData(paramString);
            return paramAnonymousTask;
          }
        }
      });
      return paramString;
    }
  }
  
  public static ParseUser logIn(String paramString1, String paramString2)
    throws ParseException
  {
    return (ParseUser)Parse.waitForTask(logInAsync(paramString1, paramString2));
  }
  
  private static Task<ParseUser> logInAsync(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Must specify a username for the user to log in with");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("Must specify a password for the user to log in with");
    }
    constructLogInCommand(paramString1, paramString2).performAsync().onSuccess(new Continuation()
    {
      public ParseUser then(Task<Object> paramAnonymousTask)
        throws Exception
      {
        if (paramAnonymousTask.getResult() == JSONObject.NULL) {
          throw new ParseException(101, "invalid login credentials");
        }
        ParseUser localParseUser = (ParseUser)ParseObject.create(ParseUser.class);
        localParseUser.handleFetchResult((JSONObject)paramAnonymousTask.getResult());
        ParseUser.saveCurrentUser(localParseUser);
        return localParseUser;
      }
    });
  }
  
  public static void logInInBackground(String paramString1, String paramString2, LogInCallback paramLogInCallback)
  {
    Parse.callbackOnMainThreadAsync(logInAsync(paramString1, paramString2), paramLogInCallback);
  }
  
  static ParseUser logInLazyUser(String paramString, JSONObject paramJSONObject)
  {
    synchronized (currentUserMutex)
    {
      ParseUser localParseUser = (ParseUser)ParseObject.create(ParseUser.class);
      localParseUser.isCurrentUser = true;
      localParseUser.isLazy = true;
      try
      {
        localParseUser.authData.put(paramString, paramJSONObject);
        localParseUser.linkedServiceNames.add(paramString);
        currentUser = localParseUser;
        currentUserMatchesDisk = false;
        return localParseUser;
      }
      catch (JSONException paramString)
      {
        throw new RuntimeException(paramString);
      }
    }
  }
  
  private static Task<ParseUser> logInWithAsync(ParseAuthenticationProvider paramParseAuthenticationProvider)
  {
    authenticateAsync(paramParseAuthenticationProvider).onSuccessTask(new Continuation()
    {
      public Task<ParseUser> then(Task<JSONObject> paramAnonymousTask)
        throws Exception
      {
        return ParseUser.logInWithAsync(ParseUser.this.getAuthType(), (JSONObject)paramAnonymousTask.getResult());
      }
    });
  }
  
  static Task<ParseUser> logInWithAsync(String paramString)
  {
    if (!authenticationProviders.containsKey(paramString)) {
      throw new IllegalArgumentException("No authentication provider could be found for the provided authType");
    }
    return logInWithAsync((ParseAuthenticationProvider)authenticationProviders.get(paramString));
  }
  
  static Task<ParseUser> logInWithAsync(final String paramString, final JSONObject paramJSONObject)
  {
    final Object localObject2 = new Continuation()
    {
      public Task<ParseUser> then(final Task<Void> paramAnonymousTask)
        throws Exception
      {
        paramAnonymousTask = (ParseUser)ParseObject.create(ParseUser.class);
        try
        {
          paramAnonymousTask.authData.put(ParseUser.this, paramJSONObject);
          paramAnonymousTask.linkedServiceNames.add(ParseUser.this);
          final Map localMap = paramAnonymousTask.startSave();
          final ParseCommand localParseCommand = paramAnonymousTask.constructSignUpOrLoginCommand(localMap);
          localParseCommand.performAsync().continueWithTask(new Continuation()
          {
            public Task<Object> then(Task<Object> paramAnonymous2Task)
              throws Exception
            {
              paramAnonymousTask.handleSaveResult(localParseCommand.op, (JSONObject)paramAnonymous2Task.getResult(), localMap);
              return null;
            }
          }).onSuccess(new Continuation()
          {
            public ParseUser then(Task<Object> arg1)
              throws Exception
            {
              synchronized (paramAnonymousTask.mutex)
              {
                paramAnonymousTask.synchronizeAuthData(this.val$authType);
                ParseUser.saveCurrentUser(paramAnonymousTask);
                ParseUser localParseUser = paramAnonymousTask;
                return localParseUser;
              }
            }
          });
        }
        catch (JSONException paramAnonymousTask)
        {
          throw new ParseException(paramAnonymousTask);
        }
      }
    };
    final ParseUser localParseUser = getCurrentUser();
    if (localParseUser != null) {
      synchronized (localParseUser.mutex)
      {
        if (ParseAnonymousUtils.isLinked(localParseUser))
        {
          if (localParseUser.isLazy())
          {
            localObject2 = localParseUser.authData.optJSONObject("anonymous");
            paramString = localParseUser.taskQueue.enqueue(new Continuation()
            {
              public Task<ParseUser> then(Task<Void> paramAnonymousTask)
                throws Exception
              {
                Task.forResult(null).continueWithTask(new Continuation()
                {
                  public Task<Void> then(Task<Void> paramAnonymous2Task)
                    throws Exception
                  {
                    synchronized (this.val$user.mutex)
                    {
                      this.val$user.stripAnonymity();
                      this.val$user.authData.put(this.val$authType, this.val$authData);
                      this.val$user.linkedServiceNames.add(this.val$authType);
                      paramAnonymous2Task = this.val$user.resolveLazinessAsync(paramAnonymous2Task);
                      return paramAnonymous2Task;
                    }
                  }
                }).continueWithTask(new Continuation()
                {
                  public Task<ParseUser> then(Task<Void> paramAnonymous2Task)
                    throws Exception
                  {
                    synchronized (this.val$user.mutex)
                    {
                      if (paramAnonymous2Task.isFaulted())
                      {
                        this.val$user.authData.remove(this.val$authType);
                        this.val$user.linkedServiceNames.remove(this.val$authType);
                        this.val$user.restoreAnonymity(this.val$oldAnonymousData);
                        paramAnonymous2Task = Task.forError(paramAnonymous2Task.getError());
                        return paramAnonymous2Task;
                      }
                      if (paramAnonymous2Task.isCancelled())
                      {
                        paramAnonymous2Task = Task.cancelled();
                        return paramAnonymous2Task;
                      }
                    }
                    paramAnonymous2Task = Task.forResult(this.val$user);
                    return paramAnonymous2Task;
                  }
                });
              }
            });
            return paramString;
          }
          paramString = localParseUser.linkWithAsync(paramString, paramJSONObject).continueWithTask(new Continuation()
          {
            public Task<ParseUser> then(Task<Void> paramAnonymousTask)
              throws Exception
            {
              if ((paramAnonymousTask.isFaulted()) && ((paramAnonymousTask.getError() instanceof ParseException)) && (((ParseException)paramAnonymousTask.getError()).getCode() == 208)) {
                return Task.forResult(null).continueWithTask(ParseUser.this);
              }
              if (paramAnonymousTask.isCancelled()) {
                return Task.cancelled();
              }
              return Task.forResult(localParseUser);
            }
          });
          return paramString;
        }
      }
    }
    return Task.forResult(null).continueWithTask((Continuation)localObject2);
  }
  
  public static void logOut()
  {
    synchronized (currentUserMutex)
    {
      checkApplicationContext();
      if (currentUser != null) {}
      synchronized (currentUser.mutex)
      {
        Iterator localIterator = currentUser.getLinkedServiceNames().iterator();
        if (!localIterator.hasNext())
        {
          currentUser.isCurrentUser = false;
          currentUser.sessionToken = null;
          currentUserMatchesDisk = true;
          currentUser = null;
          new File(Parse.getParseDir(), "currentUser").delete();
          return;
        }
        String str = (String)localIterator.next();
        currentUser.logOutWith(str);
      }
    }
  }
  
  private void logOutWith(ParseAuthenticationProvider paramParseAuthenticationProvider)
  {
    paramParseAuthenticationProvider.deauthenticate();
  }
  
  static void registerAuthenticationProvider(ParseAuthenticationProvider paramParseAuthenticationProvider)
  {
    authenticationProviders.put(paramParseAuthenticationProvider.getAuthType(), paramParseAuthenticationProvider);
    if (getCurrentUser() != null) {
      getCurrentUser().synchronizeAuthData(paramParseAuthenticationProvider.getAuthType());
    }
  }
  
  public static void requestPasswordReset(String paramString)
    throws ParseException
  {
    Parse.waitForTask(requestPasswordResetAsync(paramString));
  }
  
  private static Task<Void> requestPasswordResetAsync(String paramString)
  {
    return constructPasswordResetCommand(paramString, getCurrentSessionToken()).performAsync().makeVoid();
  }
  
  public static void requestPasswordResetInBackground(String paramString, RequestPasswordResetCallback paramRequestPasswordResetCallback)
  {
    Parse.callbackOnMainThreadAsync(requestPasswordResetAsync(paramString), paramRequestPasswordResetCallback);
  }
  
  private Task<Void> resolveLazinessAsync(Task<Void> paramTask)
  {
    synchronized (this.mutex)
    {
      if (!isLazy())
      {
        paramTask = Task.forResult(null);
        return paramTask;
      }
      if (this.linkedServiceNames.size() == 0)
      {
        paramTask = signUpAsync(paramTask).onSuccess(new Continuation()
        {
          public Void then(Task<Void> arg1)
            throws Exception
          {
            synchronized (ParseUser.this.mutex)
            {
              ParseUser.this.isLazy = false;
              return null;
            }
          }
        });
        return paramTask;
      }
    }
    final Capture localCapture = new Capture();
    paramTask = Task.call(new Callable()
    {
      public Map<String, ParseFieldOperation> call()
        throws Exception
      {
        return ParseUser.this.startSave();
      }
    }).onSuccessTask(TaskQueue.waitFor(paramTask)).onSuccessTask(new Continuation()
    {
      public Task<Object> then(Task<Map<String, ParseFieldOperation>> paramAnonymousTask)
        throws Exception
      {
        localCapture.set((Map)paramAnonymousTask.getResult());
        return ParseUser.this.constructSignUpOrLoginCommand((Map)localCapture.get()).performAsync();
      }
    }).onSuccess(new Continuation()
    {
      public Void then(Task<Object> paramAnonymousTask)
        throws Exception
      {
        synchronized (ParseUser.this.mutex)
        {
          paramAnonymousTask = (JSONObject)paramAnonymousTask.getResult();
          ParseUser.this.handleSaveResult("create", paramAnonymousTask, (Map)localCapture.get());
          if (paramAnonymousTask.optBoolean("is_new"))
          {
            ParseUser.this.isLazy = false;
            return null;
          }
          ParseUser localParseUser = (ParseUser)ParseObject.create(ParseUser.class);
          localParseUser.handleFetchResult(paramAnonymousTask);
          ParseUser.saveCurrentUser(localParseUser);
        }
      }
    });
    return paramTask;
  }
  
  /* Error */
  private void restoreAnonymity(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 262	com/parse/ParseUser:mutex	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnull +28 -> 36
    //   11: aload_0
    //   12: getfield 117	com/parse/ParseUser:linkedServiceNames	Ljava/util/Set;
    //   15: ldc_w 353
    //   18: invokeinterface 421 2 0
    //   23: pop
    //   24: aload_0
    //   25: getfield 112	com/parse/ParseUser:authData	Lorg/json/JSONObject;
    //   28: ldc_w 353
    //   31: aload_1
    //   32: invokevirtual 415	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   35: pop
    //   36: aload_2
    //   37: monitorexit
    //   38: return
    //   39: astore_1
    //   40: new 220	java/lang/RuntimeException
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 424	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   48: athrow
    //   49: astore_1
    //   50: aload_2
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	ParseUser
    //   0	54	1	paramJSONObject	JSONObject
    //   4	47	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   24	36	39	org/json/JSONException
    //   11	24	49	finally
    //   24	36	49	finally
    //   36	38	49	finally
    //   40	49	49	finally
    //   50	52	49	finally
  }
  
  private static void saveCurrentUser(ParseUser paramParseUser)
  {
    synchronized (currentUserMutex)
    {
      checkApplicationContext();
      if (currentUser != paramParseUser) {
        logOut();
      }
      synchronized (paramParseUser.mutex)
      {
        paramParseUser.isCurrentUser = true;
        paramParseUser.synchronizeAllAuthData();
        paramParseUser.saveToDisk(Parse.applicationContext, "currentUser");
        currentUserMatchesDisk = true;
        currentUser = paramParseUser;
        return;
      }
    }
  }
  
  private Task<Void> signUpAsync()
  {
    this.taskQueue.enqueue(new Continuation()
    {
      public Task<Void> then(Task<Void> paramAnonymousTask)
        throws Exception
      {
        return ParseUser.this.signUpAsync(paramAnonymousTask);
      }
    });
  }
  
  private Task<Void> signUpAsync(Task<Void> paramTask)
  {
    final String str1;
    String str2;
    synchronized (this.mutex)
    {
      str1 = getCurrentSessionToken();
      if ((getUsername() == null) || (getUsername().length() == 0)) {
        throw new IllegalArgumentException("Username cannot be missing or blank");
      }
    }
    return paramTask;
  }
  
  private void stripAnonymity()
  {
    synchronized (this.mutex)
    {
      if (ParseAnonymousUtils.isLinked(this)) {
        this.linkedServiceNames.remove("anonymous");
      }
      try
      {
        this.authData.put("anonymous", JSONObject.NULL);
        this.dirty = true;
        return;
      }
      catch (JSONException localJSONException)
      {
        throw new RuntimeException(localJSONException);
      }
    }
  }
  
  private void synchronizeAllAuthData()
  {
    synchronized (this.mutex)
    {
      Iterator localIterator;
      if (this.authData != null)
      {
        localIterator = this.authData.keys();
        if (localIterator.hasNext()) {}
      }
      else
      {
        return;
      }
      synchronizeAuthData((String)localIterator.next());
    }
  }
  
  private void synchronizeAuthData(String paramString)
  {
    synchronized (this.mutex)
    {
      if (!isCurrentUser()) {
        return;
      }
      if (!authenticationProviders.containsKey(paramString)) {
        return;
      }
    }
    ParseAuthenticationProvider localParseAuthenticationProvider = (ParseAuthenticationProvider)authenticationProviders.get(paramString);
    if (!localParseAuthenticationProvider.restoreAuthentication(this.authData.optJSONObject(localParseAuthenticationProvider.getAuthType()))) {
      unlinkFromAsync(paramString);
    }
  }
  
  void cleanUpAuthData()
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        if (!isCurrentUser()) {
          return;
        }
        Iterator localIterator = this.authData.keys();
        if (!localIterator.hasNext()) {
          return;
        }
      }
      String str = (String)((Iterator)localObject2).next();
      if (this.authData.isNull(str))
      {
        ((Iterator)localObject2).remove();
        this.linkedServiceNames.remove(str);
        if (authenticationProviders.containsKey(str)) {
          ((ParseAuthenticationProvider)authenticationProviders.get(str)).restoreAuthentication(null);
        }
      }
    }
  }
  
  ParseCommand constructSaveCommand(Map<String, ParseFieldOperation> paramMap, String paramString)
    throws ParseException
  {
    synchronized (this.mutex)
    {
      paramMap = super.constructSaveCommand(paramMap, paramString);
      if (paramMap == null) {
        return null;
      }
      if (this.password != null) {
        paramMap.put("user_password", this.password);
      }
      if (this.authData.length() > 0) {
        paramMap.put("auth_data", this.authData);
      }
      return paramMap;
    }
  }
  
  public ParseUser fetch()
    throws ParseException
  {
    return (ParseUser)super.fetch();
  }
  
  <T extends ParseObject> Task<T> fetchAsync(Task<Void> paramTask)
  {
    synchronized (this.mutex)
    {
      if (isLazy())
      {
        paramTask = Task.forResult(this);
        return paramTask;
      }
      paramTask = super.fetchAsync(paramTask).onSuccessTask(new Continuation()
      {
        public Task<T> then(Task<T> paramAnonymousTask)
          throws Exception
        {
          synchronized (ParseUser.this.mutex)
          {
            ParseUser.this.cleanUpAuthData();
            if (ParseUser.this.isCurrentUser()) {
              ParseUser.saveCurrentUser(ParseUser.this);
            }
            return paramAnonymousTask;
          }
        }
      });
      return paramTask;
    }
  }
  
  public ParseUser fetchIfNeeded()
    throws ParseException
  {
    return (ParseUser)super.fetchIfNeeded();
  }
  
  public String getEmail()
  {
    return getString("email");
  }
  
  Set<String> getLinkedServiceNames()
  {
    synchronized (this.mutex)
    {
      Set localSet = this.readOnlyLinkedServiceNames;
      return localSet;
    }
  }
  
  public String getSessionToken()
  {
    synchronized (this.mutex)
    {
      String str = this.sessionToken;
      return str;
    }
  }
  
  public String getUsername()
  {
    return getString("username");
  }
  
  public boolean isAuthenticated()
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        if (isLazy()) {
          break label60;
        }
        if ((this.sessionToken != null) && (getCurrentUser() != null))
        {
          if (getObjectId().equals(getCurrentUser().getObjectId())) {
            break label60;
          }
          break label55;
          return bool;
        }
      }
      label55:
      boolean bool = false;
      continue;
      label60:
      bool = true;
    }
  }
  
  boolean isCurrentUser()
  {
    synchronized (this.mutex)
    {
      boolean bool = this.isCurrentUser;
      return bool;
    }
  }
  
  boolean isLazy()
  {
    synchronized (this.mutex)
    {
      boolean bool = this.isLazy;
      return bool;
    }
  }
  
  public boolean isNew()
  {
    synchronized (this.mutex)
    {
      boolean bool = this.isNew;
      return bool;
    }
  }
  
  Task<Void> linkWithAsync(String paramString)
  {
    if (!authenticationProviders.containsKey(paramString)) {
      throw new IllegalArgumentException("No authentication provider could be found for the provided authType");
    }
    return linkWithAsync((ParseAuthenticationProvider)authenticationProviders.get(paramString));
  }
  
  Task<Void> linkWithAsync(final String paramString, final JSONObject paramJSONObject)
  {
    this.taskQueue.enqueue(new Continuation()
    {
      public Task<Void> then(Task<Void> paramAnonymousTask)
        throws Exception
      {
        return ParseUser.this.linkWithAsync(paramString, paramJSONObject, paramAnonymousTask);
      }
    });
  }
  
  void logOutWith(String paramString)
  {
    synchronized (this.mutex)
    {
      if ((authenticationProviders.containsKey(paramString)) && (this.linkedServiceNames.contains(paramString))) {
        logOutWith((ParseAuthenticationProvider)authenticationProviders.get(paramString));
      }
      return;
    }
  }
  
  void mergeFromObject(ParseObject paramParseObject)
  {
    for (;;)
    {
      Iterator localIterator;
      synchronized (this.mutex)
      {
        super.mergeFromObject(paramParseObject);
        if ((paramParseObject instanceof ParseUser))
        {
          this.sessionToken = ((ParseUser)paramParseObject).sessionToken;
          this.isNew = ((ParseUser)paramParseObject).isNew();
          localIterator = this.authData.keys();
          if (!localIterator.hasNext())
          {
            localIterator = ((ParseUser)paramParseObject).authData.keys();
            if (localIterator.hasNext()) {
              break label128;
            }
            this.linkedServiceNames.clear();
            this.linkedServiceNames.addAll(((ParseUser)paramParseObject).linkedServiceNames);
          }
        }
        else
        {
          return;
        }
        localIterator.next();
        localIterator.remove();
      }
      label128:
      String str = (String)localIterator.next();
      try
      {
        Object localObject2 = ((ParseUser)paramParseObject).authData.get(str);
        this.authData.put(str, localObject2);
      }
      catch (JSONException paramParseObject)
      {
        throw new RuntimeException("A JSONException occurred where one was not possible.");
      }
    }
  }
  
  void mergeFromServer(JSONObject paramJSONObject, boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        super.mergeFromServer(paramJSONObject, paramBoolean);
        paramBoolean = paramJSONObject.has("session_token");
        if (paramBoolean) {}
        try
        {
          this.sessionToken = paramJSONObject.getString("session_token");
          paramBoolean = paramJSONObject.has("auth_data");
          if (paramBoolean) {}
          paramJSONObject = finally;
        }
        catch (JSONException paramJSONObject)
        {
          try
          {
            localJSONObject = paramJSONObject.getJSONObject("auth_data");
            localIterator = localJSONObject.keys();
            paramBoolean = localIterator.hasNext();
            if (!paramBoolean)
            {
              paramBoolean = paramJSONObject.has("is_new");
              if (!paramBoolean) {}
            }
          }
          catch (JSONException paramJSONObject)
          {
            JSONObject localJSONObject;
            Iterator localIterator;
            String str;
            throw new RuntimeException(paramJSONObject);
          }
          try
          {
            this.isNew = paramJSONObject.getBoolean("is_new");
            return;
          }
          catch (JSONException paramJSONObject)
          {
            throw new RuntimeException(paramJSONObject);
          }
          paramJSONObject = paramJSONObject;
          throw new RuntimeException(paramJSONObject.getMessage());
        }
      }
      str = (String)localIterator.next();
      this.authData.put(str, localJSONObject.get(str));
      if (!localJSONObject.isNull(str)) {
        this.linkedServiceNames.add(str);
      }
      synchronizeAuthData(str);
    }
  }
  
  boolean needsDefaultACL()
  {
    return false;
  }
  
  public void put(String paramString, Object paramObject)
  {
    synchronized (this.mutex)
    {
      if ("username".equals(paramString)) {
        stripAnonymity();
      }
      super.put(paramString, paramObject);
      return;
    }
  }
  
  public void remove(String paramString)
  {
    if ("username".equals(paramString)) {
      throw new IllegalArgumentException("Can't remove the username key.");
    }
    super.remove(paramString);
  }
  
  Task<Void> saveAsync(Task<Void> paramTask)
  {
    synchronized (this.mutex)
    {
      if (isLazy())
      {
        paramTask = resolveLazinessAsync(paramTask);
        return paramTask;
      }
      paramTask = super.saveAsync(paramTask).onSuccess(new Continuation()
      {
        public Void then(Task<Void> arg1)
          throws Exception
        {
          synchronized (ParseUser.this.mutex)
          {
            ParseUser.this.cleanUpAuthData();
            if (ParseUser.this.isCurrentUser()) {
              ParseUser.saveCurrentUser(ParseUser.this);
            }
            return null;
          }
        }
      });
      return paramTask;
    }
  }
  
  public void setEmail(String paramString)
  {
    put("email", paramString);
  }
  
  public void setPassword(String paramString)
  {
    synchronized (this.mutex)
    {
      this.password = paramString;
      this.dirty = true;
      return;
    }
  }
  
  public void setUsername(String paramString)
  {
    put("username", paramString);
  }
  
  public void signUp()
    throws ParseException
  {
    Parse.waitForTask(signUpAsync());
  }
  
  public void signUpInBackground(SignUpCallback paramSignUpCallback)
  {
    Parse.callbackOnMainThreadAsync(signUpAsync(), paramSignUpCallback);
  }
  
  JSONObject toJSONObjectForDataFile()
  {
    synchronized (this.mutex)
    {
      JSONObject localJSONObject = super.toJSONObjectForDataFile();
      String str = this.sessionToken;
      if (str != null) {}
      try
      {
        localJSONObject.put("session_token", this.sessionToken);
        int i = this.authData.length();
        if (i > 0) {}
        localObject2 = finally;
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          localJSONObject.put("auth_data", this.authData);
          return localJSONObject;
        }
        catch (JSONException localJSONException2)
        {
          throw new RuntimeException("could not attach key: auth_data");
        }
        localJSONException1 = localJSONException1;
        throw new RuntimeException("could not encode value for key: sessionToken");
      }
    }
  }
  
  JSONObject toJSONObjectForSaving(Map<String, ParseFieldOperation> paramMap)
  {
    synchronized (this.mutex)
    {
      paramMap = super.toJSONObjectForSaving(paramMap);
      String str = this.sessionToken;
      if (str != null) {}
      try
      {
        paramMap.put("session_token", this.sessionToken);
        int i = this.authData.length();
        if (i > 0) {}
        paramMap = finally;
      }
      catch (JSONException paramMap)
      {
        try
        {
          paramMap.put("auth_data", this.authData);
          return paramMap;
        }
        catch (JSONException paramMap)
        {
          throw new RuntimeException("could not attach key: auth_data");
        }
        paramMap = paramMap;
        throw new RuntimeException("could not encode value for key: sessionToken");
      }
    }
  }
  
  Task<Void> unlinkFromAsync(final String paramString)
  {
    localObject = this.mutex;
    if (paramString == null) {}
    try
    {
      paramString = Task.forResult(null);
      return paramString;
    }
    finally {}
    paramString = Task.forResult(null).continueWithTask(new Continuation()
    {
      public Task<Void> then(Task<Void> arg1)
        throws Exception
      {
        synchronized (ParseUser.this.mutex)
        {
          if (ParseUser.this.authData.has(paramString))
          {
            ParseUser.this.authData.put(paramString, JSONObject.NULL);
            ParseUser.this.dirty = true;
            localTask = ParseUser.this.saveAsync();
            return localTask;
          }
          Task localTask = Task.forResult(null);
          return localTask;
        }
      }
    });
    return paramString;
  }
  
  void validateDelete()
  {
    synchronized (this.mutex)
    {
      super.validateDelete();
      if ((!isAuthenticated()) && (isDirty())) {
        throw new IllegalArgumentException("Cannot delete a ParseUser that is not authenticated.");
      }
    }
  }
  
  void validateSave()
  {
    synchronized (this.mutex)
    {
      if (getObjectId() == null) {
        throw new IllegalArgumentException("Cannot save a ParseUser until it has been signed up. Call signUp first.");
      }
    }
    if ((!isAuthenticated()) && (isDirty()) && (!getObjectId().equals(getCurrentUser().getObjectId()))) {
      throw new IllegalArgumentException("Cannot save a ParseUser that is not authenticated.");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseUser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */