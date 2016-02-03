package com.parse;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SimpleTimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseObject
{
  static final String API_VERSION = "2";
  private static final String AUTO_CLASS_NAME = "_Automatic";
  private static final String TAG = "com.parse.ParseObject";
  static final String VERSION_NAME = "1.3.0";
  private static final Map<Class<? extends ParseObject>, String> classNames;
  private static final DateFormat impreciseDateFormat;
  private static final ThreadLocal<Boolean> isCreatingPointer = new ThreadLocal()
  {
    protected Boolean initialValue()
    {
      return Boolean.valueOf(false);
    }
  };
  private static final Map<String, Class<? extends ParseObject>> objectTypes;
  static String server = "https://api.parse.com";
  private String className;
  private Date createdAt;
  private final Map<String, Boolean> dataAvailability;
  boolean dirty;
  private final Map<String, Object> estimatedData;
  private boolean hasBeenFetched;
  private final Map<Object, ParseJSONCacheItem> hashedObjects;
  private String localId;
  final Object mutex = new Object();
  private String objectId;
  final LinkedList<Map<String, ParseFieldOperation>> operationSetQueue;
  private final ParseMulticastDelegate<ParseObject> saveEvent = new ParseMulticastDelegate();
  private final Map<String, Object> serverData;
  final TaskQueue taskQueue = new TaskQueue();
  private Date updatedAt;
  
  static
  {
    classNames = new ConcurrentHashMap();
    objectTypes = new ConcurrentHashMap();
    registerSubclass(ParseUser.class);
    registerSubclass(ParseRole.class);
    registerSubclass(ParseInstallation.class);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
    impreciseDateFormat = localSimpleDateFormat;
  }
  
  protected ParseObject()
  {
    this("_Automatic");
  }
  
  public ParseObject(String paramString)
  {
    boolean bool = ((Boolean)isCreatingPointer.get()).booleanValue();
    isCreatingPointer.set(Boolean.valueOf(false));
    if (paramString == null) {
      throw new IllegalArgumentException("You must specify a Parse class name when creating a new ParseObject.");
    }
    String str = paramString;
    if ("_Automatic".equals(paramString)) {
      str = getClassName(getClass());
    }
    if ((getClass().equals(ParseObject.class)) && (objectTypes.containsKey(str)) && (!((Class)objectTypes.get(str)).isInstance(this))) {
      throw new IllegalArgumentException("You must create this type of ParseObject using ParseObject.create() or the proper subclass.");
    }
    if ((!getClass().equals(ParseObject.class)) && (!getClass().equals(objectTypes.get(str)))) {
      throw new IllegalArgumentException("You must register this ParseObject subclass before instantiating it.");
    }
    this.localId = null;
    this.serverData = new HashMap();
    this.operationSetQueue = new LinkedList();
    this.operationSetQueue.add(new HashMap());
    this.estimatedData = new HashMap();
    this.hashedObjects = new IdentityHashMap();
    this.dataAvailability = new HashMap();
    this.className = str;
    if (!bool)
    {
      setDefaultValues();
      this.hasBeenFetched = true;
      this.dirty = true;
      return;
    }
    this.dirty = false;
    this.hasBeenFetched = false;
  }
  
  private void applyOperations(Map<String, ParseFieldOperation> paramMap, Map<String, Object> paramMap1)
  {
    for (;;)
    {
      String str;
      synchronized (this.mutex)
      {
        Iterator localIterator = paramMap.keySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
        Object localObject2 = ((ParseFieldOperation)paramMap.get(str)).apply(paramMap1.get(str), this, str);
        if (localObject2 != null) {
          paramMap1.put(str, localObject2);
        }
      }
      paramMap1.remove(str);
    }
  }
  
  private boolean canBeSerialized()
  {
    synchronized (this.mutex)
    {
      if (!canBeSerializedAsValue(this.estimatedData)) {
        return false;
      }
      if ((isDataAvailable("ACL")) && (getACL(false) != null) && (getACL(false).hasUnresolvedUser())) {
        return false;
      }
    }
    return true;
  }
  
  private static boolean canBeSerializedAsValue(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramObject instanceof ParseObject)) {
      if (((ParseObject)paramObject).getObjectId() != null) {
        bool1 = true;
      }
    }
    do
    {
      for (;;)
      {
        return bool1;
        bool1 = false;
        continue;
        if ((paramObject instanceof Map))
        {
          paramObject = ((Map)paramObject).values().iterator();
          do
          {
            if (!((Iterator)paramObject).hasNext()) {
              break;
            }
          } while (canBeSerializedAsValue(((Iterator)paramObject).next()));
          return false;
        }
        if ((paramObject instanceof JSONArray))
        {
          paramObject = (JSONArray)paramObject;
          int i = 0;
          if (i >= ((JSONArray)paramObject).length()) {
            break label225;
          }
          try
          {
            boolean bool3 = canBeSerializedAsValue(((JSONArray)paramObject).get(i));
            bool1 = bool2;
            if (bool3) {
              i += 1;
            }
          }
          catch (JSONException paramObject)
          {
            throw new RuntimeException("Unable to find related objects for saving.", (Throwable)paramObject);
          }
        }
      }
      if ((paramObject instanceof JSONObject))
      {
        paramObject = (JSONObject)paramObject;
        Iterator localIterator = ((JSONObject)paramObject).keys();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label225;
          }
          try
          {
            bool1 = canBeSerializedAsValue(((JSONObject)paramObject).get((String)localIterator.next()));
            if (!bool1) {
              return false;
            }
          }
          catch (JSONException paramObject)
          {
            throw new RuntimeException("Unable to find related objects for saving.", (Throwable)paramObject);
          }
        }
      }
      if ((!(paramObject instanceof ParseACL)) || (!((ParseACL)paramObject).hasUnresolvedUser())) {
        break;
      }
      bool1 = bool2;
    } while (!canBeSerializedAsValue(ParseUser.getCurrentUser()));
    label225:
    return true;
  }
  
  private void checkForChangesToMutableContainer(String paramString, Object paramObject)
  {
    ParseJSONCacheItem localParseJSONCacheItem1;
    synchronized (this.mutex)
    {
      if (Parse.isContainerObject(paramObject))
      {
        localParseJSONCacheItem1 = (ParseJSONCacheItem)this.hashedObjects.get(paramObject);
        if (localParseJSONCacheItem1 == null) {
          throw new IllegalArgumentException("ParseObject contains container item that isn't cached.");
        }
      }
    }
    for (;;)
    {
      try
      {
        ParseJSONCacheItem localParseJSONCacheItem2 = new ParseJSONCacheItem(paramObject);
        if (!localParseJSONCacheItem1.equals(localParseJSONCacheItem2)) {
          performOperation(paramString, new ParseSetOperation(paramObject));
        }
        return;
      }
      catch (JSONException paramString)
      {
        throw new RuntimeException(paramString);
      }
      this.hashedObjects.remove(paramObject);
    }
  }
  
  private void checkGetAccess(String paramString)
  {
    if (!isDataAvailable(paramString)) {
      throw new IllegalStateException("ParseObject has no data for this key.  Call fetchIfNeeded() to get the data.");
    }
  }
  
  private void checkpointAllMutableContainers()
  {
    synchronized (this.mutex)
    {
      Iterator localIterator = this.estimatedData.values().iterator();
      if (localIterator.hasNext()) {
        checkpointMutableContainer(localIterator.next());
      }
    }
  }
  
  private void checkpointMutableContainer(Object paramObject)
  {
    synchronized (this.mutex)
    {
      boolean bool = Parse.isContainerObject(paramObject);
      if (bool) {}
      try
      {
        ParseJSONCacheItem localParseJSONCacheItem = new ParseJSONCacheItem(paramObject);
        this.hashedObjects.put(paramObject, localParseJSONCacheItem);
        return;
      }
      catch (JSONException paramObject)
      {
        throw new RuntimeException((Throwable)paramObject);
      }
    }
  }
  
  private static void collectDirtyChildren(Object paramObject, List<ParseObject> paramList, List<ParseFile> paramList1)
  {
    collectDirtyChildren(paramObject, paramList, paramList1, new IdentityHashMap(), new IdentityHashMap());
  }
  
  private static void collectDirtyChildren(Object paramObject, List<ParseObject> paramList, List<ParseFile> paramList1, IdentityHashMap<ParseObject, ParseObject> paramIdentityHashMap1, IdentityHashMap<ParseObject, ParseObject> paramIdentityHashMap2)
  {
    if ((paramObject instanceof List))
    {
      paramObject = ((List)paramObject).iterator();
      while (((Iterator)paramObject).hasNext()) {
        collectDirtyChildren(((Iterator)paramObject).next(), paramList, paramList1, paramIdentityHashMap1, paramIdentityHashMap2);
      }
    }
    if ((paramObject instanceof Map))
    {
      paramObject = ((Map)paramObject).values().iterator();
      while (((Iterator)paramObject).hasNext()) {
        collectDirtyChildren(((Iterator)paramObject).next(), paramList, paramList1, paramIdentityHashMap1, paramIdentityHashMap2);
      }
    }
    if ((paramObject instanceof JSONArray))
    {
      paramObject = (JSONArray)paramObject;
      int i = 0;
      for (;;)
      {
        if (i >= ((JSONArray)paramObject).length()) {
          break label245;
        }
        try
        {
          collectDirtyChildren(((JSONArray)paramObject).get(i), paramList, paramList1, paramIdentityHashMap1, paramIdentityHashMap2);
          i += 1;
        }
        catch (JSONException paramObject)
        {
          throw new RuntimeException("Invalid JSONArray on object.", (Throwable)paramObject);
        }
      }
    }
    Object localObject;
    if ((paramObject instanceof JSONObject))
    {
      paramObject = (JSONObject)paramObject;
      localObject = ((JSONObject)paramObject).keys();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label245;
        }
        try
        {
          collectDirtyChildren(((JSONObject)paramObject).get((String)((Iterator)localObject).next()), paramList, paramList1, paramIdentityHashMap1, paramIdentityHashMap2);
        }
        catch (JSONException paramObject)
        {
          throw new RuntimeException("Invalid JSONDictionary on object.", (Throwable)paramObject);
        }
      }
    }
    if ((paramObject instanceof ParseACL)) {
      if (((ParseACL)paramObject).hasUnresolvedUser()) {
        collectDirtyChildren(ParseUser.getCurrentUser(), paramList, paramList1, paramIdentityHashMap1, paramIdentityHashMap2);
      }
    }
    label245:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!(paramObject instanceof ParseObject)) {
            break;
          }
          localObject = (ParseObject)paramObject;
          if (((ParseObject)localObject).getObjectId() != null) {
            paramObject = new IdentityHashMap();
          }
          while (!paramIdentityHashMap1.containsKey(localObject))
          {
            paramIdentityHashMap1 = new IdentityHashMap(paramIdentityHashMap1);
            paramIdentityHashMap1.put(localObject, localObject);
            collectDirtyChildren(((ParseObject)localObject).estimatedData, paramList, paramList1, paramIdentityHashMap1, (IdentityHashMap)paramObject);
            if (((ParseObject)localObject).isDirty(false)) {
              paramList.add(localObject);
            }
            return;
            if (paramIdentityHashMap2.containsKey(localObject)) {
              throw new RuntimeException("Found a circular dependency while saving.");
            }
            paramObject = new IdentityHashMap(paramIdentityHashMap2);
            ((IdentityHashMap)paramObject).put(localObject, localObject);
          }
        }
      } while (!(paramObject instanceof ParseFile));
      paramObject = (ParseFile)paramObject;
    } while (((ParseFile)paramObject).getUrl() != null);
    paramList1.add(paramObject);
  }
  
  private ParseCommand constructDeleteCommand(boolean paramBoolean, String paramString)
    throws ParseException
  {
    synchronized (this.mutex)
    {
      paramString = new ParseCommand("delete", paramString);
      paramString.enableRetrying();
      paramString.put("classname", this.className);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("objectId", this.objectId);
        paramString.put("data", localJSONObject);
        return paramString;
      }
      catch (JSONException paramString)
      {
        throw new RuntimeException(paramString.getMessage());
      }
    }
  }
  
  public static <T extends ParseObject> T create(Class<T> paramClass)
  {
    return create(getClassName(paramClass));
  }
  
  public static ParseObject create(String paramString)
  {
    if (objectTypes.containsKey(paramString)) {
      try
      {
        paramString = (ParseObject)((Class)objectTypes.get(paramString)).newInstance();
        return paramString;
      }
      catch (Exception paramString)
      {
        if ((paramString instanceof RuntimeException)) {
          throw ((RuntimeException)paramString);
        }
        throw new RuntimeException("Failed to create instance of subclass.", paramString);
      }
    }
    return new ParseObject(paramString);
  }
  
  public static <T extends ParseObject> T createWithoutData(Class<T> paramClass, String paramString)
  {
    return createWithoutData(getClassName(paramClass), paramString);
  }
  
  public static ParseObject createWithoutData(String paramString1, String paramString2)
  {
    try
    {
      isCreatingPointer.set(Boolean.valueOf(true));
      paramString1 = create(paramString1);
      paramString1.setObjectId(paramString2);
      paramString1.dirty = false;
      if (paramString1.isDirty()) {
        throw new IllegalStateException("A ParseObject subclass default constructor must not make changes to the object that cause it to be dirty.");
      }
    }
    catch (Exception paramString1)
    {
      if (!(paramString1 instanceof RuntimeException)) {
        break label81;
      }
      throw ((RuntimeException)paramString1);
    }
    finally
    {
      isCreatingPointer.set(Boolean.valueOf(false));
    }
    isCreatingPointer.set(Boolean.valueOf(false));
    return paramString1;
    label81:
    throw new RuntimeException("Failed to create instance of subclass.", paramString1);
  }
  
  private Map<String, ParseFieldOperation> currentOperations()
  {
    synchronized (this.mutex)
    {
      Map localMap = (Map)this.operationSetQueue.getLast();
      return localMap;
    }
  }
  
  private static Task<Void> deepSaveAsync(Object paramObject, final String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList();
    collectDirtyChildren(paramObject, localArrayList, (List)localObject);
    paramObject = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((List)paramObject).add(((ParseFile)((Iterator)localObject).next()).saveAsync(null));
    }
    Task.whenAll((Collection)paramObject).onSuccessTask(new Continuation()
    {
      public Task<Void> then(final Task<Void> paramAnonymousTask)
        throws Exception
      {
        paramAnonymousTask = new IdentityHashMap();
        Iterator localIterator = this.val$objects.iterator();
        while (localIterator.hasNext()) {
          paramAnonymousTask.put((ParseObject)localIterator.next(), Boolean.valueOf(true));
        }
        paramAnonymousTask = new Capture(new ArrayList(paramAnonymousTask.keySet()));
        Task.forResult(null).continueWhile(new Callable()new Continuation
        {
          public Boolean call()
            throws Exception
          {
            if (((List)paramAnonymousTask.get()).size() > 0) {}
            for (boolean bool = true;; bool = false) {
              return Boolean.valueOf(bool);
            }
          }
        }, new Continuation()
        {
          public Task<Void> then(Task<Void> paramAnonymous2Task)
            throws Exception
          {
            final ArrayList localArrayList = new ArrayList();
            paramAnonymous2Task = new ArrayList();
            final Object localObject = ((List)paramAnonymousTask.get()).iterator();
            while (((Iterator)localObject).hasNext())
            {
              ParseObject localParseObject = (ParseObject)((Iterator)localObject).next();
              if (localParseObject.canBeSerialized()) {
                localArrayList.add(localParseObject);
              } else {
                paramAnonymous2Task.add(localParseObject);
              }
            }
            paramAnonymousTask.set(paramAnonymous2Task);
            if (localArrayList.size() == 0) {
              throw new RuntimeException("Unable to save a PFObject with a relation to a cycle.");
            }
            localObject = Task.forResult(null);
            paramAnonymous2Task = (Task<Void>)localObject;
            if (ParseUser.getCurrentUser() != null)
            {
              paramAnonymous2Task = (Task<Void>)localObject;
              if (ParseUser.getCurrentUser().isLazy())
              {
                paramAnonymous2Task = (Task<Void>)localObject;
                if (localArrayList.contains(ParseUser.getCurrentUser())) {
                  paramAnonymous2Task = ((Task)localObject).onSuccessTask(new Continuation()
                  {
                    public Task<Void> then(Task<Void> paramAnonymous3Task)
                      throws Exception
                    {
                      return ParseUser.getCurrentUser().saveAsync();
                    }
                  }).onSuccess(new Continuation()
                  {
                    public Void then(Task<Void> paramAnonymous3Task)
                      throws Exception
                    {
                      localArrayList.remove(ParseUser.getCurrentUser());
                      return null;
                    }
                  });
                }
              }
            }
            localObject = new ArrayList();
            paramAnonymous2Task.onSuccessTask(new Continuation()
            {
              public Task<Void> then(Task<Void> paramAnonymous3Task)
                throws Exception
              {
                if (localArrayList.size() == 0) {
                  return Task.forResult(null);
                }
                ParseObject.enqueueForAll(localArrayList, new Continuation()
                {
                  public Task<Void> then(Task<Void> paramAnonymous4Task)
                    throws Exception
                  {
                    Iterator localIterator = ParseObject.19.2.3.this.val$current.iterator();
                    while (localIterator.hasNext())
                    {
                      ParseObject localParseObject = (ParseObject)localIterator.next();
                      synchronized (localParseObject.mutex)
                      {
                        localParseObject.validateSave();
                        ParseObject.19.2.3.this.val$operations.add(localParseObject.startSave());
                      }
                    }
                    paramAnonymous4Task.continueWithTask(new Continuation()
                    {
                      public Task<Void> then(Task<Void> paramAnonymous5Task)
                        throws Exception
                      {
                        paramAnonymous5Task = new JSONArray();
                        int i = 0;
                        while (i < ParseObject.19.2.3.this.val$current.size())
                        {
                          localParseCommand = ((ParseObject)ParseObject.19.2.3.this.val$current.get(i)).constructSaveCommand((Map)ParseObject.19.2.3.this.val$operations.get(i), ParseObject.19.this.val$sessionToken);
                          paramAnonymous5Task.put(localParseCommand.toJSONObject());
                          ParseObject.19.2.3.this.val$ops.add(localParseCommand.op);
                          i += 1;
                        }
                        ParseCommand localParseCommand = new ParseCommand("multi", ParseObject.19.this.val$sessionToken);
                        localParseCommand.put("commands", paramAnonymous5Task);
                        localParseCommand.performAsync().cast().onSuccess(new Continuation()
                        {
                          public Void then(Task<JSONArray> paramAnonymous6Task)
                            throws Exception
                          {
                            int i = 0;
                            while (i < ParseObject.19.2.3.this.val$current.size())
                            {
                              String str = (String)ParseObject.19.2.3.this.val$ops.get(i);
                              JSONObject localJSONObject = ((JSONArray)paramAnonymous6Task.getResult()).getJSONObject(i);
                              ((ParseObject)ParseObject.19.2.3.this.val$current.get(i)).handleSaveResult(str, localJSONObject, (Map)ParseObject.19.2.3.this.val$operations.get(i));
                              i += 1;
                            }
                            return null;
                          }
                        });
                      }
                    });
                  }
                });
              }
            });
          }
        });
      }
    });
  }
  
  private Task<Void> deleteAsync()
  {
    this.taskQueue.enqueue(new Continuation()
    {
      public Task<Void> then(Task<Void> paramAnonymousTask)
        throws Exception
      {
        return ParseObject.this.deleteAsync(paramAnonymousTask);
      }
    });
  }
  
  private Task<Void> deleteAsync(Task<Void> paramTask)
  {
    Task.call(new Callable()
    {
      public ParseCommand call()
        throws Exception
      {
        synchronized (ParseObject.this.mutex)
        {
          ParseObject.this.validateDelete();
          if (ParseObject.this.objectId == null) {
            return null;
          }
          ParseCommand localParseCommand = ParseObject.this.constructDeleteCommand(true, this.val$sessionToken);
          return localParseCommand;
        }
      }
    }).onSuccessTask(TaskQueue.waitFor(paramTask)).onSuccessTask(new Continuation()
    {
      public Task<Object> then(Task<ParseCommand> paramAnonymousTask)
        throws Exception
      {
        return ((ParseCommand)paramAnonymousTask.getResult()).performAsync();
      }
    }).onSuccess(new Continuation()
    {
      public Void then(Task<Object> arg1)
        throws Exception
      {
        synchronized (ParseObject.this.mutex)
        {
          ParseObject.this.dirty = true;
          return null;
        }
      }
    });
  }
  
  static void deleteDiskObject(Context paramContext, String paramString)
  {
    try
    {
      Parse.setContextIfNeeded(paramContext);
      paramContext = new File(Parse.getParseDir(), paramString);
      if (paramContext != null) {
        paramContext.delete();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  static <T> Task<T> enqueueForAll(List<? extends ParseObject> paramList, final Continuation<Void, Task<T>> paramContinuation)
  {
    // Byte code:
    //   0: invokestatic 628	com/parse/Task:create	()Lcom/parse/Task$TaskCompletionSource;
    //   3: astore_3
    //   4: new 557	java/util/ArrayList
    //   7: dup
    //   8: aload_0
    //   9: invokeinterface 631 1 0
    //   14: invokespecial 634	java/util/ArrayList:<init>	(I)V
    //   17: astore_2
    //   18: aload_0
    //   19: invokeinterface 473 1 0
    //   24: astore 4
    //   26: aload 4
    //   28: invokeinterface 359 1 0
    //   33: ifeq +29 -> 62
    //   36: aload_2
    //   37: aload 4
    //   39: invokeinterface 362 1 0
    //   44: checkcast 2	com/parse/ParseObject
    //   47: getfield 197	com/parse/ParseObject:taskQueue	Lcom/parse/TaskQueue;
    //   50: invokevirtual 638	com/parse/TaskQueue:getLock	()Ljava/util/concurrent/locks/Lock;
    //   53: invokeinterface 487 2 0
    //   58: pop
    //   59: goto -33 -> 26
    //   62: new 640	com/parse/LockSet
    //   65: dup
    //   66: aload_2
    //   67: invokespecial 643	com/parse/LockSet:<init>	(Ljava/util/Collection;)V
    //   70: astore_2
    //   71: aload_2
    //   72: invokevirtual 646	com/parse/LockSet:lock	()V
    //   75: aload_1
    //   76: aload_3
    //   77: invokevirtual 651	com/parse/Task$TaskCompletionSource:getTask	()Lcom/parse/Task;
    //   80: invokeinterface 657 2 0
    //   85: checkcast 566	com/parse/Task
    //   88: astore_1
    //   89: new 557	java/util/ArrayList
    //   92: dup
    //   93: invokespecial 558	java/util/ArrayList:<init>	()V
    //   96: astore 4
    //   98: aload_0
    //   99: invokeinterface 473 1 0
    //   104: astore_0
    //   105: aload_0
    //   106: invokeinterface 359 1 0
    //   111: ifeq +52 -> 163
    //   114: aload_0
    //   115: invokeinterface 362 1 0
    //   120: checkcast 2	com/parse/ParseObject
    //   123: getfield 197	com/parse/ParseObject:taskQueue	Lcom/parse/TaskQueue;
    //   126: new 44	com/parse/ParseObject$2
    //   129: dup
    //   130: aload 4
    //   132: aload_1
    //   133: invokespecial 660	com/parse/ParseObject$2:<init>	(Ljava/util/List;Lcom/parse/Task;)V
    //   136: invokevirtual 585	com/parse/TaskQueue:enqueue	(Lcom/parse/Continuation;)Lcom/parse/Task;
    //   139: pop
    //   140: goto -35 -> 105
    //   143: astore_0
    //   144: aload_2
    //   145: invokevirtual 663	com/parse/LockSet:unlock	()V
    //   148: aload_0
    //   149: athrow
    //   150: astore_0
    //   151: aload_0
    //   152: athrow
    //   153: astore_0
    //   154: new 411	java/lang/RuntimeException
    //   157: dup
    //   158: aload_0
    //   159: invokespecial 454	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   162: athrow
    //   163: aload 4
    //   165: invokestatic 570	com/parse/Task:whenAll	(Ljava/util/Collection;)Lcom/parse/Task;
    //   168: new 58	com/parse/ParseObject$3
    //   171: dup
    //   172: aload_3
    //   173: invokespecial 666	com/parse/ParseObject$3:<init>	(Lcom/parse/Task$TaskCompletionSource;)V
    //   176: invokevirtual 669	com/parse/Task:continueWith	(Lcom/parse/Continuation;)Lcom/parse/Task;
    //   179: pop
    //   180: aload_2
    //   181: invokevirtual 663	com/parse/LockSet:unlock	()V
    //   184: aload_1
    //   185: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	paramList	List<? extends ParseObject>
    //   0	186	1	paramContinuation	Continuation<Void, Task<T>>
    //   17	164	2	localObject1	Object
    //   3	170	3	localTaskCompletionSource	Task.TaskCompletionSource
    //   24	140	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   75	89	143	finally
    //   89	105	143	finally
    //   105	140	143	finally
    //   151	153	143	finally
    //   154	163	143	finally
    //   163	180	143	finally
    //   75	89	150	java/lang/RuntimeException
    //   75	89	153	java/lang/Exception
  }
  
  public static List<ParseObject> fetchAll(List<ParseObject> paramList)
    throws ParseException
  {
    return (List)Parse.waitForTask(fetchAllAsync(paramList));
  }
  
  private static <T extends ParseObject> Task<List<T>> fetchAllAsync(List<T> paramList)
  {
    enqueueForAll(paramList, new Continuation()
    {
      public Task<List<T>> then(Task<Void> paramAnonymousTask)
        throws Exception
      {
        return ParseObject.fetchAllAsync(this.val$objects, paramAnonymousTask);
      }
    });
  }
  
  private static <T extends ParseObject> Task<List<T>> fetchAllAsync(List<T> paramList, Task<Void> paramTask)
  {
    if (paramList.size() == 0) {
      return Task.forResult(paramList);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((ParseObject)paramList.get(0)).getClassName();
    int i = 0;
    while (i < paramList.size())
    {
      if (!((ParseObject)paramList.get(i)).getClassName().equals(localObject)) {
        throw new IllegalArgumentException("All objects should have the same class");
      }
      if (((ParseObject)paramList.get(i)).getObjectId() == null) {
        throw new IllegalArgumentException("All objects must exist on the server");
      }
      localArrayList.add(((ParseObject)paramList.get(i)).getObjectId());
      i += 1;
    }
    localObject = ParseQuery.getQuery((String)localObject);
    ((ParseQuery)localObject).whereContainedIn("objectId", localArrayList);
    paramTask.continueWithTask(new Continuation()
    {
      public Task<List<T>> then(Task<Void> paramAnonymousTask)
        throws Exception
      {
        return this.val$query.findAsync();
      }
    }).onSuccess(new Continuation()
    {
      public List<T> then(Task<List<T>> paramAnonymousTask)
        throws Exception
      {
        HashMap localHashMap = new HashMap();
        paramAnonymousTask = ((List)paramAnonymousTask.getResult()).iterator();
        while (paramAnonymousTask.hasNext())
        {
          ParseObject localParseObject = (ParseObject)paramAnonymousTask.next();
          localHashMap.put(localParseObject.getObjectId(), localParseObject);
        }
        int i = 0;
        while (i < this.val$objects.size())
        {
          paramAnonymousTask = (ParseObject)localHashMap.get(((ParseObject)this.val$objects.get(i)).getObjectId());
          if (paramAnonymousTask == null) {
            throw new RuntimeException("Object id " + ((ParseObject)this.val$objects.get(i)).getObjectId() + " does not exist");
          }
          ((ParseObject)this.val$objects.get(i)).mergeFromObject(paramAnonymousTask);
          ParseObject.access$902((ParseObject)this.val$objects.get(i), true);
          i += 1;
        }
        return this.val$objects;
      }
    });
  }
  
  public static <T extends ParseObject> List<T> fetchAllIfNeeded(List<T> paramList)
    throws ParseException
  {
    return (List)Parse.waitForTask(fetchAllIfNeededAsync(paramList));
  }
  
  private static <T extends ParseObject> Task<List<T>> fetchAllIfNeededAsync(List<T> paramList)
  {
    enqueueForAll(paramList, new Continuation()
    {
      public Task<List<T>> then(Task<Void> paramAnonymousTask)
        throws Exception
      {
        return ParseObject.fetchAllIfNeededAsync(this.val$objects, paramAnonymousTask);
      }
    });
  }
  
  private static <T extends ParseObject> Task<List<T>> fetchAllIfNeededAsync(List<T> paramList, Task<Void> paramTask)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = null;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (ParseObject)localIterator.next();
      if (!((ParseObject)localObject2).isDataAvailable())
      {
        if ((localObject1 != null) && (!((String)localObject1).equals(((ParseObject)localObject2).getClassName()))) {
          throw new IllegalArgumentException("All objects should have the same class");
        }
        String str = ((ParseObject)localObject2).getClassName();
        localObject2 = ((ParseObject)localObject2).getObjectId();
        localObject1 = str;
        if (localObject2 != null)
        {
          localArrayList.add(localObject2);
          localObject1 = str;
        }
      }
    }
    if (localArrayList.size() == 0) {
      return Task.forResult(paramList);
    }
    localObject1 = ParseQuery.getQuery((String)localObject1);
    ((ParseQuery)localObject1).whereContainedIn("objectId", localArrayList);
    paramTask.continueWithTask(new Continuation()
    {
      public Task<List<T>> then(Task<Void> paramAnonymousTask)
        throws Exception
      {
        return this.val$query.findAsync();
      }
    }).onSuccess(new Continuation()
    {
      public List<T> then(Task<List<T>> paramAnonymousTask)
        throws Exception
      {
        HashMap localHashMap = new HashMap();
        paramAnonymousTask = ((List)paramAnonymousTask.getResult()).iterator();
        while (paramAnonymousTask.hasNext())
        {
          ParseObject localParseObject = (ParseObject)paramAnonymousTask.next();
          localHashMap.put(localParseObject.getObjectId(), localParseObject);
        }
        int i = 0;
        if (i < this.val$objects.size())
        {
          if (((ParseObject)this.val$objects.get(i)).isDataAvailable()) {}
          for (;;)
          {
            i += 1;
            break;
            paramAnonymousTask = (ParseObject)localHashMap.get(((ParseObject)this.val$objects.get(i)).getObjectId());
            if (paramAnonymousTask == null) {
              throw new RuntimeException("Object id " + ((ParseObject)this.val$objects.get(i)).getObjectId() + " does not exist");
            }
            ((ParseObject)this.val$objects.get(i)).mergeFromObject(paramAnonymousTask);
            ParseObject.access$902((ParseObject)this.val$objects.get(i), true);
          }
        }
        return this.val$objects;
      }
    });
  }
  
  public static <T extends ParseObject> void fetchAllIfNeededInBackground(List<T> paramList, FindCallback<T> paramFindCallback)
  {
    Parse.callbackOnMainThreadAsync(fetchAllIfNeededAsync(paramList), paramFindCallback);
  }
  
  public static <T extends ParseObject> void fetchAllInBackground(List<T> paramList, FindCallback<T> paramFindCallback)
  {
    Parse.callbackOnMainThreadAsync(fetchAllAsync(paramList), paramFindCallback);
  }
  
  private static void findUnsavedChildren(Object paramObject, List<ParseObject> paramList)
  {
    if ((paramObject instanceof List))
    {
      paramObject = ((List)paramObject).iterator();
      while (((Iterator)paramObject).hasNext()) {
        findUnsavedChildren(((Iterator)paramObject).next(), paramList);
      }
    }
    if ((paramObject instanceof Map))
    {
      paramObject = ((Map)paramObject).values().iterator();
      while (((Iterator)paramObject).hasNext()) {
        findUnsavedChildren(((Iterator)paramObject).next(), paramList);
      }
    }
    if ((paramObject instanceof ParseObject))
    {
      paramObject = (ParseObject)paramObject;
      if (((ParseObject)paramObject).isDirty()) {
        paramList.add(paramObject);
      }
    }
  }
  
  private ParseACL getACL(boolean paramBoolean)
  {
    synchronized (this.mutex)
    {
      checkGetAccess("ACL");
      Object localObject2 = this.estimatedData.get("ACL");
      if (localObject2 == null) {
        return null;
      }
      if (!(localObject2 instanceof ParseACL)) {
        throw new RuntimeException("only ACLs can be stored in the ACL key");
      }
    }
    if ((paramBoolean) && (((ParseACL)localObject3).isShared()))
    {
      localParseACL = ((ParseACL)localObject3).copy();
      this.estimatedData.put("ACL", localParseACL);
      addToHashedObjects(localParseACL);
      return localParseACL;
    }
    ParseACL localParseACL = (ParseACL)localParseACL;
    return localParseACL;
  }
  
  static String getApplicationId()
  {
    Parse.checkInit();
    return Parse.applicationId;
  }
  
  static String getClassName(Class<? extends ParseObject> paramClass)
  {
    String str = (String)classNames.get(paramClass);
    Object localObject = str;
    if (str == null)
    {
      localObject = (ParseClassName)paramClass.getAnnotation(ParseClassName.class);
      if (localObject == null) {
        return null;
      }
      localObject = ((ParseClassName)localObject).value();
      classNames.put(paramClass, localObject);
    }
    return (String)localObject;
  }
  
  static JSONObject getDiskObject(Context paramContext, String paramString)
  {
    try
    {
      Parse.setContextIfNeeded(paramContext);
      paramContext = getDiskObject(new File(Parse.getParseDir(), paramString));
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  static JSONObject getDiskObject(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: invokevirtual 777	java/io/File:exists	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifne +10 -> 21
    //   14: aload_2
    //   15: astore_0
    //   16: ldc 2
    //   18: monitorexit
    //   19: aload_0
    //   20: areturn
    //   21: new 779	java/io/RandomAccessFile
    //   24: dup
    //   25: aload_0
    //   26: ldc_w 781
    //   29: invokespecial 782	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   32: astore_0
    //   33: aload_0
    //   34: invokevirtual 785	java/io/RandomAccessFile:length	()J
    //   37: l2i
    //   38: newarray <illegal type>
    //   40: astore_3
    //   41: aload_0
    //   42: aload_3
    //   43: invokevirtual 789	java/io/RandomAccessFile:readFully	([B)V
    //   46: aload_0
    //   47: invokevirtual 792	java/io/RandomAccessFile:close	()V
    //   50: new 224	java/lang/String
    //   53: dup
    //   54: aload_3
    //   55: ldc_w 794
    //   58: invokespecial 797	java/lang/String:<init>	([BLjava/lang/String;)V
    //   61: astore_0
    //   62: new 799	org/json/JSONTokener
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 800	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
    //   70: astore_0
    //   71: new 418	org/json/JSONObject
    //   74: dup
    //   75: aload_0
    //   76: invokespecial 803	org/json/JSONObject:<init>	(Lorg/json/JSONTokener;)V
    //   79: astore_0
    //   80: goto -64 -> 16
    //   83: astore_0
    //   84: aload_2
    //   85: astore_0
    //   86: goto -70 -> 16
    //   89: astore_0
    //   90: aload_2
    //   91: astore_0
    //   92: goto -76 -> 16
    //   95: astore_0
    //   96: ldc 2
    //   98: monitorexit
    //   99: aload_0
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramFile	File
    //   9	2	1	bool	boolean
    //   1	90	2	localObject	Object
    //   40	15	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   21	62	83	java/io/IOException
    //   71	80	89	org/json/JSONException
    //   5	10	95	finally
    //   21	62	95	finally
    //   62	71	95	finally
    //   71	80	95	finally
  }
  
  static ParseObject getFromDisk(Context paramContext, String paramString)
  {
    paramContext = getDiskObject(paramContext, paramString);
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramString = createWithoutData(paramContext.getString("classname"), null);
      paramString.mergeFromServer(paramContext, true);
      return paramString;
    }
    catch (JSONException paramContext) {}
    return null;
  }
  
  private boolean hasDirtyChildren()
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        ArrayList localArrayList = new ArrayList();
        findUnsavedChildren(this.estimatedData, localArrayList);
        if (localArrayList.size() > 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private static Date impreciseParseDate(String paramString)
  {
    try
    {
      Date localDate = impreciseDateFormat.parse(paramString);
      paramString = localDate;
    }
    catch (java.text.ParseException localParseException)
    {
      for (;;)
      {
        Parse.logE("com.parse.ParseObject", "could not parse date: " + paramString, localParseException);
        paramString = null;
      }
    }
    finally {}
    return paramString;
  }
  
  private static boolean isAccessible(Member paramMember)
  {
    return (Modifier.isPublic(paramMember.getModifiers())) || ((paramMember.getDeclaringClass().getPackage().getName().equals("com.parse")) && (!Modifier.isPrivate(paramMember.getModifiers())) && (!Modifier.isProtected(paramMember.getModifiers())));
  }
  
  private boolean isDataAvailable(String paramString)
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        if (!isDataAvailable())
        {
          if ((!this.dataAvailability.containsKey(paramString)) || (!((Boolean)this.dataAvailability.get(paramString)).booleanValue())) {
            break label63;
          }
          break label58;
          return bool;
        }
      }
      label58:
      boolean bool = true;
      continue;
      label63:
      bool = false;
    }
  }
  
  private boolean isDirty(boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        checkForChangesToMutableContainers();
        if ((!this.dirty) && (currentOperations().size() <= 0))
        {
          if ((!paramBoolean) || (!hasDirtyChildren())) {
            break label58;
          }
          break label53;
          return paramBoolean;
        }
      }
      label53:
      paramBoolean = true;
      continue;
      label58:
      paramBoolean = false;
    }
  }
  
  private void mergeAfterSave(JSONObject paramJSONObject, boolean paramBoolean, Map<String, ParseFieldOperation> paramMap)
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        Object localObject2 = this.operationSetQueue.listIterator(this.operationSetQueue.indexOf(paramMap));
        ((ListIterator)localObject2).next();
        ((ListIterator)localObject2).remove();
        localObject2 = (Map)((ListIterator)localObject2).next();
        if (paramJSONObject != null) {
          break;
        }
        Iterator localIterator = paramMap.keySet().iterator();
        if (!localIterator.hasNext()) {
          break label186;
        }
        String str = (String)localIterator.next();
        paramJSONObject = (ParseFieldOperation)paramMap.get(str);
        ParseFieldOperation localParseFieldOperation = (ParseFieldOperation)((Map)localObject2).get(str);
        if (localParseFieldOperation != null)
        {
          paramJSONObject = localParseFieldOperation.mergeWithPrevious(paramJSONObject);
          ((Map)this.operationSetQueue.getFirst()).put(str, paramJSONObject);
        }
      }
    }
    applyOperations(paramMap, this.serverData);
    mergeFromServer(paramJSONObject, false);
    rebuildEstimatedData();
    checkpointAllMutableContainers();
    label186:
  }
  
  private void rebuildEstimatedData()
  {
    synchronized (this.mutex)
    {
      this.estimatedData.clear();
      this.estimatedData.putAll(this.serverData);
      Iterator localIterator = this.operationSetQueue.iterator();
      if (localIterator.hasNext()) {
        applyOperations((Map)localIterator.next(), this.estimatedData);
      }
    }
  }
  
  public static void registerSubclass(Class<? extends ParseObject> paramClass)
  {
    String str = getClassName(paramClass);
    if (str == null) {
      throw new IllegalArgumentException("No ParseClassName annoation provided on " + paramClass);
    }
    if (paramClass.getDeclaredConstructors().length > 0) {
      try
      {
        if (!isAccessible(paramClass.getDeclaredConstructor(new Class[0]))) {
          throw new IllegalArgumentException("Default constructor for " + paramClass + " is not accessible.");
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        throw new IllegalArgumentException("No default constructor provided for " + paramClass);
      }
    }
    Class localClass = (Class)objectTypes.get(localNoSuchMethodException);
    if ((localClass != null) && (paramClass.isAssignableFrom(localClass))) {}
    do
    {
      do
      {
        return;
        objectTypes.put(localNoSuchMethodException, paramClass);
      } while ((localClass == null) || (paramClass.equals(localClass)));
      if (localNoSuchMethodException.equals(getClassName(ParseUser.class)))
      {
        ParseUser.clearCurrentUserFromMemory();
        return;
      }
    } while (!localNoSuchMethodException.equals(getClassName(ParseInstallation.class)));
    ParseInstallation.clearCurrentInstallationFromMemory();
  }
  
  public static void saveAll(List<ParseObject> paramList)
    throws ParseException
  {
    Parse.waitForTask(saveAllAsync(paramList));
  }
  
  private static Task<Void> saveAllAsync(List<ParseObject> paramList)
  {
    return deepSaveAsync(paramList, ParseUser.getCurrentSessionToken());
  }
  
  public static void saveAllInBackground(List<ParseObject> paramList)
  {
    saveAllInBackground(paramList, null);
  }
  
  public static void saveAllInBackground(List<ParseObject> paramList, SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(saveAllAsync(paramList), paramSaveCallback);
  }
  
  static void saveDiskObject(Context paramContext, String paramString, JSONObject paramJSONObject)
  {
    try
    {
      Parse.setContextIfNeeded(paramContext);
      saveDiskObject(new File(Parse.getParseDir(), paramString), paramJSONObject);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  static void saveDiskObject(File paramFile, JSONObject paramJSONObject)
  {
    try
    {
      paramFile = new FileOutputStream(paramFile);
      paramFile.write(paramJSONObject.toString().getBytes("UTF-8"));
      paramFile.close();
      return;
    }
    catch (UnsupportedEncodingException paramFile)
    {
      for (;;)
      {
        paramFile = paramFile;
      }
    }
    catch (IOException paramFile)
    {
      for (;;)
      {
        paramFile = paramFile;
      }
    }
    finally
    {
      paramFile = finally;
      throw paramFile;
    }
  }
  
  private void setObjectIdInternal(String paramString)
  {
    synchronized (this.mutex)
    {
      this.objectId = paramString;
      if (this.localId != null)
      {
        LocalIdManager.getDefaultInstance().setObjectId(this.localId, this.objectId);
        this.localId = null;
      }
      return;
    }
  }
  
  static void unregisterSubclass(String paramString)
  {
    objectTypes.remove(paramString);
  }
  
  public void add(String paramString, Object paramObject)
  {
    addAll(paramString, Arrays.asList(new Object[] { paramObject }));
  }
  
  public void addAll(String paramString, Collection<?> paramCollection)
  {
    performOperation(paramString, new ParseAddOperation(paramCollection));
  }
  
  public void addAllUnique(String paramString, Collection<?> paramCollection)
  {
    performOperation(paramString, new ParseAddUniqueOperation(paramCollection));
  }
  
  void addToHashedObjects(Object paramObject)
  {
    synchronized (this.mutex)
    {
      try
      {
        this.hashedObjects.put(paramObject, new ParseJSONCacheItem(paramObject));
        return;
      }
      catch (JSONException paramObject)
      {
        throw new IllegalArgumentException("Couldn't serialize container value to JSON.");
      }
    }
  }
  
  public void addUnique(String paramString, Object paramObject)
  {
    addAllUnique(paramString, Arrays.asList(new Object[] { paramObject }));
  }
  
  void checkForChangesToMutableContainers()
  {
    synchronized (this.mutex)
    {
      Iterator localIterator = this.estimatedData.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        checkForChangesToMutableContainer(str, this.estimatedData.get(str));
      }
    }
    this.hashedObjects.keySet().retainAll(this.estimatedData.values());
  }
  
  ParseCommand constructSaveCommand(Map<String, ParseFieldOperation> paramMap, String paramString)
    throws ParseException
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        JSONObject localJSONObject = toJSONObjectForSaving(paramMap);
        if (this.objectId == null)
        {
          paramMap = "create";
          paramMap = new ParseCommand(paramMap, paramString);
          paramMap.enableRetrying();
          paramMap.put("classname", this.className);
          try
          {
            paramMap.put("data", localJSONObject.getJSONObject("data"));
            return paramMap;
          }
          catch (JSONException paramMap)
          {
            throw new RuntimeException("could not decode data");
          }
        }
      }
      paramMap = "update";
    }
  }
  
  public boolean containsKey(String paramString)
  {
    synchronized (this.mutex)
    {
      boolean bool = this.estimatedData.containsKey(paramString);
      return bool;
    }
  }
  
  void copyChangesFrom(ParseObject paramParseObject)
  {
    synchronized (this.mutex)
    {
      paramParseObject = (Map)paramParseObject.operationSetQueue.getFirst();
      Iterator localIterator = paramParseObject.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        performOperation(str, (ParseFieldOperation)paramParseObject.get(str));
      }
    }
  }
  
  public final void delete()
    throws ParseException
  {
    Parse.waitForTask(deleteAsync());
  }
  
  public final void deleteEventually()
  {
    deleteEventually(null);
  }
  
  public final void deleteEventually(DeleteCallback paramDeleteCallback)
  {
    synchronized (this.mutex)
    {
      final ParseCommandCache localParseCommandCache = Parse.getCommandCache();
      try
      {
        Parse.callbackOnMainThreadAsync(localParseCommandCache.runEventuallyAsync(constructDeleteCommand(false, ParseUser.getCurrentSessionToken()), this).makeVoid(), paramDeleteCallback).continueWithTask(new Continuation()
        {
          public Task<Void> then(Task<Void> paramAnonymousTask)
            throws Exception
          {
            localParseCommandCache.getTestHelper().notify(6);
            return paramAnonymousTask;
          }
        });
        this.dirty = true;
        return;
      }
      catch (ParseException paramDeleteCallback)
      {
        throw new IllegalStateException("Cannot deleteEventually this object.", paramDeleteCallback);
      }
    }
  }
  
  public final void deleteInBackground()
  {
    deleteInBackground(null);
  }
  
  public final void deleteInBackground(DeleteCallback paramDeleteCallback)
  {
    Parse.callbackOnMainThreadAsync(deleteAsync(), paramDeleteCallback);
  }
  
  public <T extends ParseObject> T fetch()
    throws ParseException
  {
    return (ParseObject)Parse.waitForTask(fetchAsync());
  }
  
  final <T extends ParseObject> Task<T> fetchAsync()
  {
    this.taskQueue.enqueue(new Continuation()
    {
      public Task<T> then(Task<Void> paramAnonymousTask)
        throws Exception
      {
        return ParseObject.this.fetchAsync(paramAnonymousTask);
      }
    });
  }
  
  <T extends ParseObject> Task<T> fetchAsync(Task<Void> paramTask)
  {
    Task.call(new Callable()
    {
      public ParseCommand call()
        throws Exception
      {
        synchronized (ParseObject.this.mutex)
        {
          ParseCommand localParseCommand = new ParseCommand("get", this.val$sessionToken);
          localParseCommand.enableRetrying();
          localParseCommand.put("classname", ParseObject.this.className);
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("objectId", ParseObject.this.objectId);
            localParseCommand.put("data", localJSONObject);
            return localParseCommand;
          }
          catch (JSONException localJSONException)
          {
            throw new RuntimeException(localJSONException.getMessage());
          }
        }
      }
    }).onSuccessTask(TaskQueue.waitFor(paramTask)).onSuccessTask(new Continuation()
    {
      public Task<Object> then(Task<ParseCommand> paramAnonymousTask)
        throws Exception
      {
        return ((ParseCommand)paramAnonymousTask.getResult()).performAsync();
      }
    }).onSuccess(new Continuation()
    {
      public T then(Task<Object> paramAnonymousTask)
        throws Exception
      {
        ParseObject.this.handleFetchResult((JSONObject)paramAnonymousTask.getResult());
        return ParseObject.this;
      }
    });
  }
  
  public ParseObject fetchIfNeeded()
    throws ParseException
  {
    return (ParseObject)Parse.waitForTask(fetchIfNeededAsync());
  }
  
  final Task<ParseObject> fetchIfNeededAsync()
  {
    synchronized (this.mutex)
    {
      if (isDataAvailable())
      {
        localTask = Task.forResult(this);
        return localTask;
      }
      Task localTask = fetchAsync();
      return localTask;
    }
  }
  
  public final void fetchIfNeededInBackground(GetCallback<ParseObject> paramGetCallback)
  {
    Parse.callbackOnMainThreadAsync(fetchIfNeededAsync(), paramGetCallback);
  }
  
  public final <T extends ParseObject> void fetchInBackground(GetCallback<T> paramGetCallback)
  {
    Parse.callbackOnMainThreadAsync(fetchAsync(), paramGetCallback);
  }
  
  public Object get(String paramString)
  {
    Object localObject2;
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      if (!this.estimatedData.containsKey(paramString)) {
        return null;
      }
      localObject2 = this.estimatedData.get(paramString);
      if (((localObject2 instanceof ParseACL)) && (paramString.equals("ACL")))
      {
        ParseACL localParseACL = (ParseACL)localObject2;
        if (localParseACL.isShared())
        {
          paramString = localParseACL.copy();
          this.estimatedData.put("ACL", paramString);
          addToHashedObjects(paramString);
          paramString = getACL();
          return paramString;
        }
      }
    }
    if ((localObject2 instanceof ParseRelation)) {
      ((ParseRelation)localObject2).ensureParentAndKey(this, paramString);
    }
    return localObject2;
  }
  
  public ParseACL getACL()
  {
    return getACL(true);
  }
  
  public boolean getBoolean(String paramString)
  {
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      if (!this.estimatedData.containsKey(paramString)) {
        return false;
      }
      paramString = this.estimatedData.get(paramString);
      if (!(paramString instanceof Boolean)) {
        return false;
      }
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    return bool;
  }
  
  public byte[] getBytes(String paramString)
  {
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      if (!this.estimatedData.containsKey(paramString)) {
        return null;
      }
      paramString = this.estimatedData.get(paramString);
      if (!(paramString instanceof byte[])) {
        return null;
      }
      paramString = (byte[])paramString;
      return paramString;
    }
  }
  
  public String getClassName()
  {
    synchronized (this.mutex)
    {
      String str = this.className;
      return str;
    }
  }
  
  public Date getCreatedAt()
  {
    synchronized (this.mutex)
    {
      Date localDate = this.createdAt;
      return localDate;
    }
  }
  
  public Date getDate(String paramString)
  {
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      if (!this.estimatedData.containsKey(paramString)) {
        return null;
      }
      paramString = this.estimatedData.get(paramString);
      if (!(paramString instanceof Date)) {
        return null;
      }
      paramString = (Date)paramString;
      return paramString;
    }
  }
  
  public double getDouble(String paramString)
  {
    paramString = getNumber(paramString);
    if (paramString == null) {
      return 0.0D;
    }
    return paramString.doubleValue();
  }
  
  public int getInt(String paramString)
  {
    paramString = getNumber(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  public JSONArray getJSONArray(String paramString)
  {
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      if (!this.estimatedData.containsKey(paramString)) {
        return null;
      }
      Object localObject2 = this.estimatedData.get(paramString);
      Object localObject1 = localObject2;
      if ((localObject2 instanceof List))
      {
        localObject1 = Parse.encodeAsJSONArray((List)localObject2, true);
        put(paramString, localObject1);
      }
      if (!(localObject1 instanceof JSONArray)) {
        return null;
      }
      paramString = (JSONArray)localObject1;
      return paramString;
    }
  }
  
  public JSONObject getJSONObject(String paramString)
  {
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      if (!this.estimatedData.containsKey(paramString)) {
        return null;
      }
      Object localObject2 = this.estimatedData.get(paramString);
      Object localObject1 = localObject2;
      if ((localObject2 instanceof Map))
      {
        localObject1 = Parse.encodeJSONObject(localObject2, true);
        put(paramString, localObject1);
      }
      if (!(localObject1 instanceof JSONObject)) {
        return null;
      }
      paramString = (JSONObject)localObject1;
      return paramString;
    }
  }
  
  public <T> List<T> getList(String paramString)
  {
    Object localObject1;
    synchronized (this.mutex)
    {
      if (!this.estimatedData.containsKey(paramString)) {
        return null;
      }
      Object localObject2 = this.estimatedData.get(paramString);
      localObject1 = localObject2;
      if ((localObject2 instanceof JSONArray))
      {
        localObject1 = Parse.convertArrayToList((JSONArray)localObject2);
        put(paramString, localObject1);
      }
      if (!(localObject1 instanceof List)) {
        return null;
      }
    }
    paramString = (List)localObject1;
    return paramString;
  }
  
  public long getLong(String paramString)
  {
    paramString = getNumber(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.longValue();
  }
  
  public <V> Map<String, V> getMap(String paramString)
  {
    Object localObject1;
    synchronized (this.mutex)
    {
      if (!this.estimatedData.containsKey(paramString)) {
        return null;
      }
      Object localObject2 = this.estimatedData.get(paramString);
      localObject1 = localObject2;
      if ((localObject2 instanceof JSONObject))
      {
        localObject1 = Parse.convertJSONObjectToMap((JSONObject)localObject2);
        put(paramString, localObject1);
      }
      if (!(localObject1 instanceof Map)) {
        return null;
      }
    }
    paramString = (Map)localObject1;
    return paramString;
  }
  
  public Number getNumber(String paramString)
  {
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      if (!this.estimatedData.containsKey(paramString)) {
        return null;
      }
      paramString = this.estimatedData.get(paramString);
      if (!(paramString instanceof Number)) {
        return null;
      }
      paramString = (Number)paramString;
      return paramString;
    }
  }
  
  public String getObjectId()
  {
    synchronized (this.mutex)
    {
      String str = this.objectId;
      return str;
    }
  }
  
  String getOrCreateLocalId()
  {
    try
    {
      synchronized (this.mutex)
      {
        if (this.localId != null) {
          break label54;
        }
        if (this.objectId != null) {
          throw new IllegalStateException("Attempted to get a localId for an object with an objectId.");
        }
      }
      this.localId = LocalIdManager.getDefaultInstance().createLocalId();
    }
    finally {}
    label54:
    String str = this.localId;
    return str;
  }
  
  public ParseFile getParseFile(String paramString)
  {
    paramString = get(paramString);
    if (!(paramString instanceof ParseFile)) {
      return null;
    }
    return (ParseFile)paramString;
  }
  
  public ParseGeoPoint getParseGeoPoint(String paramString)
  {
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      if (!this.estimatedData.containsKey(paramString)) {
        return null;
      }
      paramString = this.estimatedData.get(paramString);
      if (!(paramString instanceof ParseGeoPoint)) {
        return null;
      }
      paramString = (ParseGeoPoint)paramString;
      return paramString;
    }
  }
  
  public ParseObject getParseObject(String paramString)
  {
    paramString = get(paramString);
    if (!(paramString instanceof ParseObject)) {
      return null;
    }
    return (ParseObject)paramString;
  }
  
  public ParseUser getParseUser(String paramString)
  {
    paramString = get(paramString);
    if (!(paramString instanceof ParseUser)) {
      return null;
    }
    return (ParseUser)paramString;
  }
  
  public <T extends ParseObject> ParseRelation<T> getRelation(String paramString)
  {
    synchronized (this.mutex)
    {
      ParseRelation localParseRelation = new ParseRelation(this, paramString);
      paramString = this.estimatedData.get(paramString);
      if ((paramString instanceof ParseRelation)) {
        localParseRelation.setTargetClass(((ParseRelation)paramString).getTargetClass());
      }
      return localParseRelation;
    }
  }
  
  public String getString(String paramString)
  {
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      if (!this.estimatedData.containsKey(paramString)) {
        return null;
      }
      paramString = this.estimatedData.get(paramString);
      if (!(paramString instanceof String)) {
        return null;
      }
      paramString = (String)paramString;
      return paramString;
    }
  }
  
  public Date getUpdatedAt()
  {
    synchronized (this.mutex)
    {
      Date localDate = this.updatedAt;
      return localDate;
    }
  }
  
  void handleFetchResult(JSONObject paramJSONObject)
  {
    synchronized (this.mutex)
    {
      mergeAfterFetch(paramJSONObject, true);
      return;
    }
  }
  
  void handleSaveResult(String paramString, JSONObject paramJSONObject, Map<String, ParseFieldOperation> paramMap)
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        if (!paramString.equals("create"))
        {
          if (!paramString.equals("user_signup")) {
            break label65;
          }
          break label59;
          mergeAfterSave(paramJSONObject, bool, paramMap);
          this.saveEvent.invoke(this, null);
          return;
        }
      }
      label59:
      boolean bool = true;
      continue;
      label65:
      bool = false;
    }
  }
  
  public boolean has(String paramString)
  {
    return containsKey(paramString);
  }
  
  public boolean hasSameId(ParseObject paramParseObject)
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        if ((getClassName() != null) && (getObjectId() != null) && (getClassName().equals(paramParseObject.getClassName())) && (getObjectId().equals(paramParseObject.getObjectId())))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void increment(String paramString)
  {
    increment(paramString, Integer.valueOf(1));
  }
  
  public void increment(String paramString, Number paramNumber)
  {
    performOperation(paramString, new ParseIncrementOperation(paramNumber));
  }
  
  public boolean isDataAvailable()
  {
    synchronized (this.mutex)
    {
      boolean bool = this.hasBeenFetched;
      return bool;
    }
  }
  
  boolean isDirty()
  {
    return isDirty(true);
  }
  
  public Set<String> keySet()
  {
    synchronized (this.mutex)
    {
      Set localSet = Collections.unmodifiableSet(this.estimatedData.keySet());
      return localSet;
    }
  }
  
  void mergeAfterFetch(JSONObject paramJSONObject, boolean paramBoolean)
  {
    synchronized (this.mutex)
    {
      mergeFromServer(paramJSONObject, paramBoolean);
      rebuildEstimatedData();
      checkpointAllMutableContainers();
      return;
    }
  }
  
  void mergeFromObject(ParseObject paramParseObject)
  {
    synchronized (this.mutex)
    {
      this.objectId = paramParseObject.objectId;
      this.createdAt = paramParseObject.createdAt;
      this.updatedAt = paramParseObject.updatedAt;
      this.serverData.clear();
      this.serverData.putAll(paramParseObject.serverData);
      if (this.operationSetQueue.size() != 1) {
        throw new IllegalStateException("Attempt to mergeFromObject during a save.");
      }
    }
    this.operationSetQueue.clear();
    this.operationSetQueue.add(new HashMap());
    this.dirty = false;
    rebuildEstimatedData();
  }
  
  void mergeFromServer(JSONObject paramJSONObject, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      Object localObject4;
      Object localObject5;
      synchronized (this.mutex)
      {
        this.dirty = false;
        if (this.hasBeenFetched) {
          break label667;
        }
        if (paramBoolean)
        {
          break label667;
          this.hasBeenFetched = paramBoolean;
          try
          {
            if ((paramJSONObject.has("id")) && (this.objectId == null)) {
              setObjectIdInternal(paramJSONObject.getString("id"));
            }
            if (paramJSONObject.has("created_at"))
            {
              localObject1 = paramJSONObject.getString("created_at");
              if (localObject1 != null) {
                this.createdAt = impreciseParseDate((String)localObject1);
              }
            }
            if (paramJSONObject.has("updated_at"))
            {
              localObject1 = paramJSONObject.getString("updated_at");
              if (localObject1 != null) {
                this.updatedAt = impreciseParseDate((String)localObject1);
              }
            }
            if (!paramJSONObject.has("pointers")) {
              break label226;
            }
            localObject1 = paramJSONObject.getJSONObject("pointers");
            localObject2 = ((JSONObject)localObject1).keys();
            if (!((Iterator)localObject2).hasNext()) {
              break label226;
            }
            localObject4 = (String)((Iterator)localObject2).next();
            localObject5 = ((JSONObject)localObject1).getJSONArray((String)localObject4);
            this.serverData.put(localObject4, createWithoutData(((JSONArray)localObject5).optString(0), ((JSONArray)localObject5).optString(1)));
            continue;
            paramJSONObject = finally;
          }
          catch (JSONException paramJSONObject)
          {
            throw new RuntimeException(paramJSONObject);
          }
        }
      }
      paramBoolean = false;
      continue;
      label226:
      if (paramJSONObject.has("data"))
      {
        localObject4 = paramJSONObject.getJSONObject("data");
        localObject5 = ((JSONObject)localObject4).keys();
        while (((Iterator)localObject5).hasNext())
        {
          String str = (String)((Iterator)localObject5).next();
          this.dataAvailability.put(str, Boolean.valueOf(true));
          if (str.equals("objectId"))
          {
            setObjectIdInternal(((JSONObject)localObject4).getString(str));
          }
          else if (str.equals("createdAt"))
          {
            this.createdAt = Parse.parseDate(((JSONObject)localObject4).getString(str));
          }
          else if (str.equals("updatedAt"))
          {
            this.updatedAt = Parse.parseDate(((JSONObject)localObject4).getString(str));
          }
          else if (str.equals("ACL"))
          {
            paramJSONObject = ParseACL.createACLFromJSONObject(((JSONObject)localObject4).getJSONObject(str));
            this.serverData.put("ACL", paramJSONObject);
            addToHashedObjects(paramJSONObject);
          }
          else if ((!str.equals("__type")) && (!str.equals("className")))
          {
            localObject1 = ((JSONObject)localObject4).get(str);
            localObject2 = Parse.decodeJSONObject(localObject1);
            if (localObject2 != null)
            {
              paramJSONObject = (JSONObject)localObject2;
              if (Parse.isContainerObject(localObject2))
              {
                paramJSONObject = (JSONObject)localObject2;
                if ((localObject2 instanceof JSONArray)) {
                  paramJSONObject = Parse.convertArrayToList((JSONArray)localObject2);
                }
                addToHashedObjects(paramJSONObject);
              }
              this.serverData.put(str, paramJSONObject);
            }
            else
            {
              paramJSONObject = (JSONObject)localObject1;
              if (Parse.isContainerObject(localObject1))
              {
                paramJSONObject = (JSONObject)localObject1;
                if ((localObject1 instanceof JSONArray)) {
                  paramJSONObject = Parse.convertArrayToList((JSONArray)localObject1);
                }
                localObject1 = paramJSONObject;
                if ((paramJSONObject instanceof JSONObject))
                {
                  localObject2 = (JSONObject)paramJSONObject;
                  localObject1 = paramJSONObject;
                  if (((JSONObject)localObject2).has("__type"))
                  {
                    localObject1 = paramJSONObject;
                    if (((JSONObject)localObject2).getString("__type").equals("Relation"))
                    {
                      paramJSONObject = ((JSONObject)localObject2).getString("className");
                      localObject1 = new ParseRelation(this, str);
                      ((ParseRelation)localObject1).setTargetClass(paramJSONObject);
                    }
                  }
                }
                addToHashedObjects(localObject1);
                paramJSONObject = (JSONObject)localObject1;
              }
              this.serverData.put(str, paramJSONObject);
            }
          }
        }
      }
      if ((this.updatedAt == null) && (this.createdAt != null)) {
        this.updatedAt = this.createdAt;
      }
      this.dirty = false;
      rebuildEstimatedData();
      return;
      label667:
      paramBoolean = true;
    }
  }
  
  boolean needsDefaultACL()
  {
    return true;
  }
  
  void performOperation(String paramString, ParseFieldOperation paramParseFieldOperation)
  {
    synchronized (this.mutex)
    {
      Object localObject2 = paramParseFieldOperation.apply(this.estimatedData.get(paramString), this, paramString);
      if (localObject2 != null)
      {
        this.estimatedData.put(paramString, localObject2);
        paramParseFieldOperation = paramParseFieldOperation.mergeWithPrevious((ParseFieldOperation)currentOperations().get(paramString));
        currentOperations().put(paramString, paramParseFieldOperation);
        checkpointMutableContainer(localObject2);
        this.dataAvailability.put(paramString, Boolean.TRUE);
        return;
      }
      this.estimatedData.remove(paramString);
    }
  }
  
  public void put(String paramString, Object paramObject)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("key may not be null.");
    }
    if (paramObject == null) {
      throw new IllegalArgumentException("value may not be null.");
    }
    if (!Parse.isValidType(paramObject)) {
      throw new IllegalArgumentException("invalid type for value: " + paramObject.getClass().toString());
    }
    performOperation(paramString, new ParseSetOperation(paramObject));
  }
  
  public final void refresh()
    throws ParseException
  {
    fetch();
  }
  
  public final void refreshInBackground(RefreshCallback paramRefreshCallback)
  {
    Parse.callbackOnMainThreadAsync(fetchAsync(), paramRefreshCallback);
  }
  
  void registerSaveListener(GetCallback<ParseObject> paramGetCallback)
  {
    synchronized (this.mutex)
    {
      this.saveEvent.subscribe(paramGetCallback);
      return;
    }
  }
  
  public void remove(String paramString)
  {
    synchronized (this.mutex)
    {
      if (get(paramString) != null) {
        performOperation(paramString, ParseDeleteOperation.getInstance());
      }
      return;
    }
  }
  
  public void removeAll(String paramString, Collection<?> paramCollection)
  {
    performOperation(paramString, new ParseRemoveOperation(paramCollection));
  }
  
  void revert()
  {
    synchronized (this.mutex)
    {
      currentOperations().clear();
      rebuildEstimatedData();
      return;
    }
  }
  
  public final void save()
    throws ParseException
  {
    Parse.waitForTask(saveAsync());
  }
  
  final Task<Void> saveAsync()
  {
    this.taskQueue.enqueue(new Continuation()
    {
      public Task<Void> then(Task<Void> paramAnonymousTask)
        throws Exception
      {
        return ParseObject.this.saveAsync(paramAnonymousTask);
      }
    });
  }
  
  Task<Void> saveAsync(Task<Void> paramTask)
  {
    final Capture localCapture = new Capture();
    if (!isDirty()) {
      return Task.forResult(null);
    }
    final String str = ParseUser.getCurrentSessionToken();
    Task.forResult(null).onSuccessTask(new Continuation()
    {
      public Task<Void> then(Task<Void> paramAnonymousTask)
        throws Exception
      {
        synchronized (ParseObject.this.mutex)
        {
          ParseObject.this.validateSave();
          localCapture.set(ParseObject.this.startSave());
          if ((ParseObject.this.isDataAvailable("ACL")) && (ParseObject.this.getACL(false) != null) && (ParseObject.this.getACL(false).hasUnresolvedUser()))
          {
            paramAnonymousTask = ParseUser.getCurrentUser().saveAsync().onSuccess(new Continuation()
            {
              public Void then(Task<Void> paramAnonymous2Task)
                throws Exception
              {
                if (ParseObject.this.getACL(false).hasUnresolvedUser()) {
                  throw new IllegalStateException("ACL has an unresolved ParseUser. Save or sign up before attempting to serialize the ACL.");
                }
                return null;
              }
            });
            return paramAnonymousTask;
          }
          return paramAnonymousTask;
        }
      }
    }).onSuccessTask(new Continuation()
    {
      public Task<Void> then(Task<Void> arg1)
        throws Exception
      {
        synchronized (ParseObject.this.mutex)
        {
          Task localTask = ParseObject.deepSaveAsync(ParseObject.this.estimatedData, str);
          return localTask;
        }
      }
    }).onSuccessTask(TaskQueue.waitFor(paramTask)).onSuccessTask(new Continuation()
    {
      public Task<Void> then(final Task<Void> paramAnonymousTask)
        throws Exception
      {
        paramAnonymousTask = ParseObject.this.constructSaveCommand((Map)localCapture.get(), str);
        paramAnonymousTask.performAsync().continueWithTask(new Continuation()
        {
          public Task<Void> then(Task<Object> paramAnonymous2Task)
            throws Exception
          {
            ParseObject.this.handleSaveResult(paramAnonymousTask.op, (JSONObject)paramAnonymous2Task.getResult(), (Map)ParseObject.4.this.val$operations.get());
            return paramAnonymous2Task.makeVoid();
          }
        });
      }
    });
  }
  
  public final void saveEventually()
  {
    saveEventually(null);
  }
  
  public void saveEventually(SaveCallback paramSaveCallback)
  {
    final Map localMap;
    final ParseCommandCache localParseCommandCache;
    final ParseCommand localParseCommand;
    synchronized (this.mutex)
    {
      ArrayList localArrayList = new ArrayList();
      findUnsavedChildren(this.estimatedData, localArrayList);
      localObject1 = null;
      if (getObjectId() == null) {
        localObject1 = getOrCreateLocalId();
      }
      localMap = startSave();
      localParseCommandCache = Parse.getCommandCache();
      try
      {
        localParseCommand = constructSaveCommand(localMap, ParseUser.getCurrentSessionToken());
        localParseCommand.setLocalId((String)localObject1);
        localParseCommand.retainLocalIds();
        localObject1 = localArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ((ParseObject)((Iterator)localObject1).next()).saveEventually();
          continue;
          paramSaveCallback = finally;
        }
      }
      catch (ParseException paramSaveCallback)
      {
        throw new IllegalStateException("Unable to saveEventually.", paramSaveCallback);
      }
    }
    final Object localObject1 = new Capture(Boolean.valueOf(false));
    Parse.callbackOnMainThreadAsync(localParseCommandCache.runEventuallyAsync(localParseCommand, this).continueWith(new Continuation()
    {
      public Void then(Task<Object> paramAnonymousTask)
        throws Exception
      {
        if (paramAnonymousTask.getResult() != null)
        {
          ParseObject.this.handleSaveResult(localParseCommand.op, (JSONObject)paramAnonymousTask.getResult(), localMap);
          localObject1.set(Boolean.valueOf(true));
        }
        return null;
      }
    }), paramSaveCallback).continueWithTask(new Continuation()
    {
      public Task<Void> then(Task<Void> paramAnonymousTask)
        throws Exception
      {
        if (((Boolean)localObject1.get()).booleanValue()) {
          localParseCommandCache.getTestHelper().notify(5);
        }
        return paramAnonymousTask;
      }
    });
    localParseCommand.releaseLocalIds();
  }
  
  public final void saveInBackground()
  {
    saveInBackground(null);
  }
  
  public final void saveInBackground(SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(saveAsync(), paramSaveCallback);
  }
  
  void saveToDisk(Context paramContext, String paramString)
  {
    synchronized (this.mutex)
    {
      saveDiskObject(paramContext, paramString, toJSONObjectForDataFile());
      return;
    }
  }
  
  public void setACL(ParseACL paramParseACL)
  {
    put("ACL", paramParseACL);
  }
  
  void setDefaultValues()
  {
    if ((needsDefaultACL()) && (ParseACL.getDefaultACL() != null)) {
      setACL(ParseACL.getDefaultACL());
    }
  }
  
  public void setObjectId(String paramString)
  {
    synchronized (this.mutex)
    {
      this.dirty = true;
      setObjectIdInternal(paramString);
      return;
    }
  }
  
  Map<String, ParseFieldOperation> startSave()
  {
    synchronized (this.mutex)
    {
      Map localMap = currentOperations();
      this.operationSetQueue.addLast(new HashMap());
      return localMap;
    }
  }
  
  JSONObject toJSONObjectForDataFile()
  {
    JSONObject localJSONObject3;
    for (;;)
    {
      String str;
      Object localObject2;
      synchronized (this.mutex)
      {
        checkForChangesToMutableContainers();
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject3 = new JSONObject();
        try
        {
          Iterator localIterator = this.serverData.keySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          str = (String)localIterator.next();
          localObject2 = this.serverData.get(str);
          if ((Parse.isContainerObject(localObject2)) && (this.hashedObjects.containsKey(localObject2)))
          {
            localJSONObject3.put(str, ((ParseJSONCacheItem)this.hashedObjects.get(localObject2)).getJSONObject());
            continue;
            localJSONObject2 = finally;
          }
        }
        catch (JSONException localJSONException)
        {
          throw new RuntimeException("could not serialize object to JSON");
        }
      }
      localJSONObject3.put(str, Parse.maybeEncodeJSONObject(localObject2, true));
    }
    if (this.createdAt != null) {
      localJSONObject3.put("createdAt", Parse.encodeDate(this.createdAt));
    }
    if (this.updatedAt != null) {
      localJSONObject3.put("updatedAt", Parse.encodeDate(this.updatedAt));
    }
    if (this.objectId != null) {
      localJSONObject3.put("objectId", this.objectId);
    }
    localJSONObject2.put("data", localJSONObject3);
    localJSONObject2.put("classname", this.className);
    return localJSONObject2;
  }
  
  JSONObject toJSONObjectForSaving(Map<String, ParseFieldOperation> paramMap)
  {
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    synchronized (this.mutex)
    {
      localJSONObject1 = new JSONObject();
      localJSONObject2 = new JSONObject();
      try
      {
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (String)localIterator.next();
          ParseFieldOperation localParseFieldOperation = (ParseFieldOperation)paramMap.get(localObject2);
          localJSONObject2.put((String)localObject2, Parse.maybeEncodeJSONObject(localParseFieldOperation, true));
          if ((localParseFieldOperation instanceof ParseSetOperation))
          {
            localObject2 = ((ParseSetOperation)localParseFieldOperation).getValue();
            if ((Parse.isContainerObject(localObject2)) && (this.hashedObjects.containsKey(localObject2)))
            {
              this.hashedObjects.put(localObject2, new ParseJSONCacheItem(localObject2));
              continue;
              paramMap = finally;
            }
          }
        }
      }
      catch (JSONException paramMap)
      {
        throw new RuntimeException("could not serialize object to JSON");
      }
    }
    if (this.objectId != null) {
      localJSONObject2.put("objectId", this.objectId);
    }
    localJSONObject1.put("data", localJSONObject2);
    localJSONObject1.put("classname", this.className);
    return localJSONObject1;
  }
  
  void unregisterSaveListener(GetCallback<ParseObject> paramGetCallback)
  {
    synchronized (this.mutex)
    {
      this.saveEvent.unsubscribe(paramGetCallback);
      return;
    }
  }
  
  void validateDelete() {}
  
  void validateSave() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */