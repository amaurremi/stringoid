package com.parse;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.parse.codec.binary.Base64;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SimpleTimeZone;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Parse
{
  public static final int LOG_LEVEL_DEBUG = 3;
  public static final int LOG_LEVEL_ERROR = 6;
  public static final int LOG_LEVEL_INFO = 4;
  public static final int LOG_LEVEL_NONE = Integer.MAX_VALUE;
  public static final int LOG_LEVEL_VERBOSE = 2;
  public static final int LOG_LEVEL_WARNING = 5;
  private static final String TAG = "com.parse.Parse";
  static Context applicationContext;
  static String applicationId;
  static String clientKey;
  static ParseCommandCache commandCache;
  private static final DateFormat dateFormat;
  static final Object lock;
  private static int logLevel = 6;
  static int maxKeyValueCacheBytes;
  static int maxKeyValueCacheFiles;
  static int maxParseFileSize = 10485760;
  static Executor uiThreadExecutor = new Executor()
  {
    public void execute(Runnable paramAnonymousRunnable)
    {
      new Handler(Looper.getMainLooper()).post(paramAnonymousRunnable);
    }
  };
  
  static
  {
    maxKeyValueCacheBytes = 2097152;
    maxKeyValueCacheFiles = 1000;
    commandCache = null;
    lock = new Object();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
    dateFormat = localSimpleDateFormat;
  }
  
  private Parse()
  {
    throw new AssertionError();
  }
  
  static Number addNumbers(Number paramNumber1, Number paramNumber2)
  {
    if ((paramNumber1 instanceof Double)) {
      return Double.valueOf(paramNumber1.doubleValue() + paramNumber2.doubleValue());
    }
    if ((paramNumber1 instanceof Long)) {
      return Long.valueOf(paramNumber1.longValue() + paramNumber2.longValue());
    }
    if ((paramNumber1 instanceof Float)) {
      return Float.valueOf(paramNumber1.floatValue() + paramNumber2.floatValue());
    }
    if ((paramNumber1 instanceof Short)) {
      return Integer.valueOf(paramNumber1.shortValue() + paramNumber2.shortValue());
    }
    if ((paramNumber1 instanceof Byte)) {
      return Integer.valueOf(paramNumber1.byteValue() + paramNumber2.byteValue());
    }
    return Integer.valueOf(paramNumber1.intValue() + paramNumber2.intValue());
  }
  
  static <T> Task<T> callbackOnMainThreadAsync(Task<T> paramTask, ParseCallback<T> paramParseCallback)
  {
    return callbackOnMainThreadAsync(paramTask, paramParseCallback, false);
  }
  
  static <T> Task<T> callbackOnMainThreadAsync(Task<T> paramTask, final ParseCallback<T> paramParseCallback, boolean paramBoolean)
  {
    if (paramParseCallback == null) {
      return paramTask;
    }
    final Task.TaskCompletionSource localTaskCompletionSource = Task.create();
    paramTask.continueWith(new Continuation()
    {
      public Void then(final Task<T> paramAnonymousTask)
        throws Exception
      {
        if ((paramAnonymousTask.isCancelled()) && (!this.val$reportCancellation))
        {
          localTaskCompletionSource.setCancelled();
          return null;
        }
        Parse.uiThreadExecutor.execute(new Runnable()
        {
          public void run()
          {
            try
            {
              Exception localException = paramAnonymousTask.getError();
              if ((localException != null) && (!(paramAnonymousTask.getError() instanceof ParseException))) {
                if ((localException instanceof RuntimeException)) {
                  throw ((RuntimeException)localException);
                }
              }
            }
            finally
            {
              if (paramAnonymousTask.isCancelled()) {
                this.val$tcs.setCancelled();
              }
              for (;;)
              {
                throw localThrowable;
                throw new RuntimeException(localThrowable);
                this.val$callback.internalDone(paramAnonymousTask.getResult(), (ParseException)localThrowable);
                if (!paramAnonymousTask.isCancelled()) {
                  break;
                }
                this.val$tcs.setCancelled();
                return;
                if (paramAnonymousTask.isFaulted()) {
                  this.val$tcs.setError(paramAnonymousTask.getError());
                } else {
                  this.val$tcs.setResult(paramAnonymousTask.getResult());
                }
              }
              if (paramAnonymousTask.isFaulted())
              {
                this.val$tcs.setError(paramAnonymousTask.getError());
                return;
              }
              this.val$tcs.setResult(paramAnonymousTask.getResult());
            }
          }
        });
        return null;
      }
    });
    return localTaskCompletionSource.getTask();
  }
  
  static void checkCacheApplicationId()
  {
    Object localObject2;
    synchronized (lock)
    {
      boolean bool1;
      if (applicationId != null)
      {
        localObject2 = new File(getParseDir(), "applicationId");
        bool1 = ((File)localObject2).exists();
        if (bool1) {
          bool1 = false;
        }
      }
      try
      {
        localObject2 = new RandomAccessFile((File)localObject2, "r");
        byte[] arrayOfByte = new byte[(int)((RandomAccessFile)localObject2).length()];
        ((RandomAccessFile)localObject2).readFully(arrayOfByte);
        ((RandomAccessFile)localObject2).close();
        boolean bool2 = new String(arrayOfByte, "UTF-8").equals(applicationId);
        bool1 = bool2;
      }
      catch (IOException localIOException2)
      {
        for (;;) {}
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        for (;;) {}
      }
      if (!bool1) {
        recursiveDelete(getParseDir());
      }
      localObject2 = new File(getParseDir(), "applicationId");
    }
    try
    {
      localObject2 = new FileOutputStream((File)localObject2);
      ((FileOutputStream)localObject2).write(applicationId.getBytes("UTF-8"));
      ((FileOutputStream)localObject2).close();
      return;
      localObject3 = finally;
      throw ((Throwable)localObject3);
    }
    catch (IOException localIOException1)
    {
      for (;;) {}
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;) {}
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      for (;;) {}
    }
  }
  
  static void checkContext()
  {
    if (applicationContext == null) {
      throw new RuntimeException("applicationContext is null. You must call Parse.initialize(context, applicationId, clientKey) before using the Parse library.");
    }
  }
  
  static void checkInit()
  {
    if (applicationId == null) {
      throw new RuntimeException("applicationId is null. You must call Parse.initialize(context, applicationId, clientKey) before using the Parse library.");
    }
    if (clientKey == null) {
      throw new RuntimeException("clientKey is null. You must call Parse.initialize(context, applicationId, clientKey) before using the Parse library.");
    }
  }
  
  static void clearCacheDir()
  {
    File[] arrayOfFile = getKeyValueCacheDir().listFiles();
    if (arrayOfFile == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < arrayOfFile.length)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
  }
  
  static void clearFromKeyValueCache(String paramString)
  {
    paramString = getKeyValueCacheFile(paramString);
    if (paramString != null) {
      paramString.delete();
    }
  }
  
  static List<Object> convertArrayToList(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i >= paramJSONArray.length()) {
      return localArrayList;
    }
    Object localObject1 = paramJSONArray.opt(i);
    Object localObject2 = decodeJSONObject(localObject1);
    if (localObject2 != null) {
      localArrayList.add(localObject2);
    }
    for (;;)
    {
      i += 1;
      break;
      localArrayList.add(localObject1);
    }
  }
  
  static Map<String, Object> convertJSONObjectToMap(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localHashMap;
      }
      String str = (String)localIterator.next();
      Object localObject1 = paramJSONObject.opt(str);
      Object localObject2 = decodeJSONObject(localObject1);
      if (localObject2 != null) {
        localHashMap.put(str, localObject2);
      } else if ((localObject1 instanceof JSONArray)) {
        localHashMap.put(str, convertArrayToList((JSONArray)localObject1));
      } else {
        localHashMap.put(str, localObject1);
      }
    }
  }
  
  static File createKeyValueCacheFile(String paramString)
  {
    paramString = String.valueOf(new Date().getTime()) + '.' + paramString;
    return new File(getKeyValueCacheDir(), paramString);
  }
  
  static JSONObject dateToObject(Date paramDate)
  {
    JSONObject localJSONObject = new JSONObject();
    paramDate = encodeDate(paramDate);
    try
    {
      localJSONObject.put("__type", "Date");
      localJSONObject.put("iso", paramDate);
      return localJSONObject;
    }
    catch (JSONException paramDate)
    {
      throw new RuntimeException(paramDate);
    }
  }
  
  static Object decodeJSONObject(Object paramObject)
  {
    if ((paramObject instanceof JSONObject))
    {
      paramObject = (JSONObject)paramObject;
      if (((JSONObject)paramObject).optString("__op", null) == null) {}
    }
    else
    {
      try
      {
        paramObject = ParseFieldOperations.decode((JSONObject)paramObject);
        return paramObject;
      }
      catch (JSONException paramObject)
      {
        throw new RuntimeException((Throwable)paramObject);
      }
      return null;
    }
    Object localObject = ((JSONObject)paramObject).optString("__type", null);
    if (localObject == null) {
      return convertJSONObjectToMap((JSONObject)paramObject);
    }
    if (((String)localObject).equals("Date")) {
      return parseDate(((JSONObject)paramObject).optString("iso"));
    }
    if (((String)localObject).equals("Bytes")) {
      return Base64.decodeBase64(((JSONObject)paramObject).optString("base64"));
    }
    if (((String)localObject).equals("Pointer")) {
      return ParseObject.createWithoutData(((JSONObject)paramObject).optString("className"), ((JSONObject)paramObject).optString("objectId"));
    }
    if (((String)localObject).equals("File")) {
      return new ParseFile(((JSONObject)paramObject).optString("name"), ((JSONObject)paramObject).optString("url"));
    }
    if (((String)localObject).equals("GeoPoint")) {
      try
      {
        double d1 = ((JSONObject)paramObject).getDouble("latitude");
        double d2 = ((JSONObject)paramObject).getDouble("longitude");
        return new ParseGeoPoint(d1, d2);
      }
      catch (JSONException paramObject)
      {
        throw new RuntimeException((Throwable)paramObject);
      }
    }
    if (((String)localObject).equals("Object"))
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("data", paramObject);
        paramObject = ParseObject.createWithoutData(((JSONObject)paramObject).optString("className"), null);
        ((ParseObject)paramObject).mergeAfterFetch((JSONObject)localObject, true);
        return paramObject;
      }
      catch (JSONException paramObject)
      {
        throw new RuntimeException((Throwable)paramObject);
      }
    }
    if (((String)localObject).equals("Relation")) {
      return new ParseRelation(((JSONObject)paramObject).optString("className", null));
    }
    return null;
  }
  
  static JSONArray encodeAsJSONArray(List<Object> paramList, boolean paramBoolean)
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        return localJSONArray;
      }
      Object localObject = paramList.next();
      if (!isValidType(localObject)) {
        throw new IllegalArgumentException("invalid type for value in array: " + localObject.getClass().toString());
      }
      localJSONArray.put(maybeEncodeJSONObject(localObject, paramBoolean));
    }
  }
  
  static String encodeDate(Date paramDate)
  {
    synchronized (lock)
    {
      paramDate = dateFormat.format(paramDate);
      return paramDate;
    }
  }
  
  static JSONObject encodeJSONObject(Object paramObject, boolean paramBoolean)
  {
    JSONObject localJSONObject;
    try
    {
      if ((paramObject instanceof Date)) {
        return dateToObject((Date)paramObject);
      }
      if ((paramObject instanceof byte[]))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("__type", "Bytes");
        localJSONObject.put("base64", Base64.encodeBase64String((byte[])paramObject));
        return localJSONObject;
      }
    }
    catch (JSONException paramObject)
    {
      throw new RuntimeException((Throwable)paramObject);
    }
    if ((paramObject instanceof ParseObject))
    {
      if (!paramBoolean) {
        throw new IllegalArgumentException("ParseObjects not allowed here");
      }
      return parseObjectToJSONPointer((ParseObject)paramObject);
    }
    if ((paramObject instanceof ParseFile))
    {
      paramObject = (ParseFile)paramObject;
      localJSONObject = new JSONObject();
      localJSONObject.put("__type", "File");
      localJSONObject.put("url", ((ParseFile)paramObject).getUrl());
      localJSONObject.put("name", ((ParseFile)paramObject).getName());
      return localJSONObject;
    }
    if ((paramObject instanceof ParseGeoPoint))
    {
      paramObject = (ParseGeoPoint)paramObject;
      localJSONObject = new JSONObject();
      localJSONObject.put("__type", "GeoPoint");
      localJSONObject.put("latitude", ((ParseGeoPoint)paramObject).getLatitude());
      localJSONObject.put("longitude", ((ParseGeoPoint)paramObject).getLongitude());
      return localJSONObject;
    }
    if ((paramObject instanceof ParseACL)) {
      return ((ParseACL)paramObject).toJSONObject();
    }
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      localJSONObject = new JSONObject();
      Iterator localIterator = ((Map)paramObject).entrySet().iterator();
      for (;;)
      {
        paramObject = localJSONObject;
        if (!localIterator.hasNext()) {
          break;
        }
        paramObject = (Map.Entry)localIterator.next();
        localJSONObject.put((String)((Map.Entry)paramObject).getKey(), maybeEncodeJSONObject(((Map.Entry)paramObject).getValue(), paramBoolean));
      }
    }
    if ((paramObject instanceof ParseRelation))
    {
      paramObject = ((ParseRelation)paramObject).encodeToJSON();
      return (JSONObject)paramObject;
    }
    paramObject = null;
    return (JSONObject)paramObject;
  }
  
  static ParseCommandCache getCommandCache()
  {
    synchronized (lock)
    {
      if (commandCache == null)
      {
        checkContext();
        commandCache = new ParseCommandCache(applicationContext);
      }
      ParseCommandCache localParseCommandCache = commandCache;
      return localParseCommandCache;
    }
  }
  
  static long getKeyValueCacheAge(File paramFile)
  {
    paramFile = paramFile.getName();
    try
    {
      long l = Long.parseLong(paramFile.substring(0, paramFile.indexOf('.')));
      return l;
    }
    catch (NumberFormatException paramFile) {}
    return 0L;
  }
  
  static File getKeyValueCacheDir()
  {
    synchronized (lock)
    {
      checkContext();
      File localFile = new File(applicationContext.getCacheDir(), "ParseKeyValueCache");
      if ((localFile.isDirectory()) || (localFile.mkdir())) {
        return localFile;
      }
      throw new RuntimeException("could not create Parse cache directory");
    }
  }
  
  static File getKeyValueCacheFile(String paramString)
  {
    paramString = '.' + paramString;
    paramString = getKeyValueCacheDir().listFiles(new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return paramAnonymousString.endsWith(Parse.this);
      }
    });
    if (paramString.length == 0) {
      return null;
    }
    return paramString[0];
  }
  
  public static int getLogLevel()
  {
    return logLevel;
  }
  
  static File getParseDir()
  {
    synchronized (lock)
    {
      checkContext();
      File localFile = applicationContext.getDir("Parse", 0);
      return localFile;
    }
  }
  
  static boolean hasPermission(String paramString)
  {
    checkContext();
    return applicationContext.checkCallingOrSelfPermission(paramString) == 0;
  }
  
  public static void initialize(Context paramContext, String paramString1, String paramString2)
  {
    applicationId = paramString1;
    clientKey = paramString2;
    if (paramContext != null)
    {
      applicationContext = paramContext.getApplicationContext();
      checkCacheApplicationId();
      new Thread("Parse.initialize Disk Check & Starting Command Cache")
      {
        public void run()
        {
          Parse.getCommandCache();
        }
      }.start();
    }
  }
  
  static boolean isContainerObject(Object paramObject)
  {
    return ((paramObject instanceof JSONObject)) || ((paramObject instanceof JSONArray)) || ((paramObject instanceof ParseACL)) || ((paramObject instanceof ParseGeoPoint)) || ((paramObject instanceof List)) || ((paramObject instanceof Map));
  }
  
  static boolean isValidType(Object paramObject)
  {
    return ((paramObject instanceof JSONObject)) || ((paramObject instanceof JSONArray)) || ((paramObject instanceof String)) || ((paramObject instanceof Number)) || ((paramObject instanceof Boolean)) || (paramObject == JSONObject.NULL) || ((paramObject instanceof ParseObject)) || ((paramObject instanceof ParseACL)) || ((paramObject instanceof ParseFile)) || ((paramObject instanceof ParseGeoPoint)) || ((paramObject instanceof Date)) || ((paramObject instanceof byte[])) || ((paramObject instanceof List)) || ((paramObject instanceof Map)) || ((paramObject instanceof ParseRelation));
  }
  
  static String join(Collection<String> paramCollection, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramCollection = paramCollection.iterator();
    if (paramCollection.hasNext()) {
      localStringBuffer.append((String)paramCollection.next());
    }
    for (;;)
    {
      if (!paramCollection.hasNext()) {
        return localStringBuffer.toString();
      }
      localStringBuffer.append(paramString);
      localStringBuffer.append((String)paramCollection.next());
    }
  }
  
  static Object jsonFromKeyValueCache(String paramString, long paramLong)
  {
    Object localObject = loadFromKeyValueCache(paramString, paramLong);
    if (localObject == null) {
      return null;
    }
    localObject = new JSONTokener((String)localObject);
    try
    {
      localObject = ((JSONTokener)localObject).nextValue();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      logE("com.parse.Parse", "corrupted cache for " + paramString, localJSONException);
      clearFromKeyValueCache(paramString);
    }
    return null;
  }
  
  static Iterable<String> keys(JSONObject paramJSONObject)
  {
    new Iterable()
    {
      public Iterator<String> iterator()
      {
        return Parse.this.keys();
      }
    };
  }
  
  static String loadFromKeyValueCache(String paramString, long paramLong)
  {
    paramString = getKeyValueCacheFile(paramString);
    if (paramString == null) {}
    Object localObject;
    do
    {
      return null;
      localObject = new Date();
      paramLong = Math.max(0L, ((Date)localObject).getTime() - paramLong);
    } while (getKeyValueCacheAge(paramString) < paramLong);
    paramString.setLastModified(((Date)localObject).getTime());
    try
    {
      paramString = new RandomAccessFile(paramString, "r");
      localObject = new byte[(int)paramString.length()];
      paramString.readFully((byte[])localObject);
      paramString.close();
      paramString = new String((byte[])localObject, "UTF-8");
      return paramString;
    }
    catch (IOException paramString)
    {
      logE("com.parse.Parse", "error reading from cache", paramString);
    }
    return null;
  }
  
  private static void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramInt >= logLevel)
    {
      if (paramThrowable == null) {
        Log.println(logLevel, paramString1, paramString2);
      }
    }
    else {
      return;
    }
    Log.println(logLevel, paramString1, paramString2 + '\n' + Log.getStackTraceString(paramThrowable));
  }
  
  static void logD(String paramString1, String paramString2)
  {
    logD(paramString1, paramString2, null);
  }
  
  static void logD(String paramString1, String paramString2, Throwable paramThrowable)
  {
    log(3, paramString1, paramString2, paramThrowable);
  }
  
  static void logE(String paramString1, String paramString2)
  {
    logE(paramString1, paramString2, null);
  }
  
  static void logE(String paramString1, String paramString2, Throwable paramThrowable)
  {
    log(6, paramString1, paramString2, paramThrowable);
  }
  
  static void logI(String paramString1, String paramString2)
  {
    logI(paramString1, paramString2, null);
  }
  
  static void logI(String paramString1, String paramString2, Throwable paramThrowable)
  {
    log(4, paramString1, paramString2, paramThrowable);
  }
  
  static void logV(String paramString1, String paramString2)
  {
    logV(paramString1, paramString2, null);
  }
  
  static void logV(String paramString1, String paramString2, Throwable paramThrowable)
  {
    log(2, paramString1, paramString2, paramThrowable);
  }
  
  static void logW(String paramString1, String paramString2)
  {
    logW(paramString1, paramString2, null);
  }
  
  static void logW(String paramString1, String paramString2, Throwable paramThrowable)
  {
    log(5, paramString1, paramString2, paramThrowable);
  }
  
  static Object maybeEncodeJSONObject(Object paramObject, boolean paramBoolean)
  {
    if ((paramObject instanceof List)) {
      paramObject = encodeAsJSONArray((List)paramObject, paramBoolean);
    }
    JSONObject localJSONObject;
    do
    {
      return paramObject;
      if ((paramObject instanceof ParseFieldOperation)) {
        try
        {
          paramObject = ((ParseFieldOperation)paramObject).encode();
          return paramObject;
        }
        catch (JSONException paramObject)
        {
          throw new RuntimeException((Throwable)paramObject);
        }
      }
      localJSONObject = encodeJSONObject(paramObject, paramBoolean);
    } while (localJSONObject == null);
    return localJSONObject;
  }
  
  static Object maybeReferenceAndEncode(Object paramObject)
  {
    if (((paramObject instanceof ParseObject)) && (((ParseObject)paramObject).getObjectId() == null)) {
      throw new IllegalStateException("unable to encode an association with an unsaved ParseObject");
    }
    return maybeEncodeJSONObject(paramObject, true);
  }
  
  static Date parseDate(String paramString)
  {
    synchronized (lock)
    {
      try
      {
        Date localDate = dateFormat.parse(paramString);
        return localDate;
      }
      catch (java.text.ParseException localParseException)
      {
        logE("com.parse.Parse", "could not parse date: " + paramString, localParseException);
        return null;
      }
    }
  }
  
  static JSONObject parseObjectToJSONPointer(ParseObject paramParseObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (paramParseObject.getObjectId() != null)
      {
        localJSONObject.put("__type", "Pointer");
        localJSONObject.put("className", paramParseObject.getClassName());
        localJSONObject.put("objectId", paramParseObject.getObjectId());
        return localJSONObject;
      }
      localJSONObject.put("__type", "Pointer");
      localJSONObject.put("className", paramParseObject.getClassName());
      localJSONObject.put("localId", paramParseObject.getOrCreateLocalId());
      return localJSONObject;
    }
    catch (JSONException paramParseObject)
    {
      throw new RuntimeException(paramParseObject);
    }
  }
  
  static void recursiveDelete(File paramFile)
  {
    for (;;)
    {
      int j;
      int i;
      synchronized (lock)
      {
        File[] arrayOfFile;
        if (paramFile.isDirectory())
        {
          arrayOfFile = paramFile.listFiles();
          j = arrayOfFile.length;
          i = 0;
        }
        else
        {
          paramFile.delete();
          return;
          recursiveDelete(arrayOfFile[i]);
          i += 1;
        }
      }
      if (i < j) {}
    }
  }
  
  static void requirePermission(String paramString)
  {
    if (!hasPermission(paramString)) {
      throw new IllegalStateException("To use this functionality, add this to your AndroidManifest.xml:\n<uses-permission android:name=\"" + paramString + "\" />");
    }
  }
  
  static void saveToKeyValueCache(String paramString1, String paramString2)
  {
    int m = 0;
    File localFile = getKeyValueCacheFile(paramString1);
    if (localFile != null) {
      localFile.delete();
    }
    paramString1 = createKeyValueCacheFile(paramString1);
    try
    {
      paramString1 = new FileOutputStream(paramString1);
      paramString1.write(paramString2.getBytes("UTF-8"));
      paramString1.close();
      paramString1 = getKeyValueCacheDir().listFiles();
      int k = paramString1.length;
      int i = 0;
      int n = paramString1.length;
      int j = 0;
      if (j >= n) {
        if ((k > maxKeyValueCacheFiles) || (i > maxKeyValueCacheBytes))
        {
          Arrays.sort(paramString1, new Comparator()
          {
            public int compare(File paramAnonymousFile1, File paramAnonymousFile2)
            {
              int i = Long.valueOf(paramAnonymousFile1.lastModified()).compareTo(Long.valueOf(paramAnonymousFile2.lastModified()));
              if (i != 0) {
                return i;
              }
              return paramAnonymousFile1.getName().compareTo(paramAnonymousFile2.getName());
            }
          });
          n = paramString1.length;
          j = m;
        }
      }
      for (;;)
      {
        if (j >= n) {}
        do
        {
          return;
          paramString2 = paramString1[j];
          i = (int)(i + paramString2.length());
          j += 1;
          break;
          paramString2 = paramString1[j];
          k -= 1;
          i = (int)(i - paramString2.length());
          paramString2.delete();
        } while ((k <= maxKeyValueCacheFiles) && (i <= maxKeyValueCacheBytes));
        j += 1;
      }
    }
    catch (IOException paramString1)
    {
      for (;;) {}
    }
    catch (UnsupportedEncodingException paramString1)
    {
      for (;;) {}
    }
  }
  
  static void setContextIfNeeded(Context paramContext)
  {
    if (applicationContext == null) {
      applicationContext = paramContext;
    }
  }
  
  public static void setLogLevel(int paramInt)
  {
    logLevel = paramInt;
  }
  
  static <T> T waitForTask(Task<T> paramTask)
    throws ParseException
  {
    try
    {
      paramTask.waitForCompletion();
      if (!paramTask.isFaulted()) {
        break label59;
      }
      paramTask = paramTask.getError();
      if ((paramTask instanceof ParseException)) {
        throw ((ParseException)paramTask);
      }
    }
    catch (InterruptedException paramTask)
    {
      throw new RuntimeException(paramTask);
    }
    if ((paramTask instanceof RuntimeException)) {
      throw ((RuntimeException)paramTask);
    }
    throw new RuntimeException(paramTask);
    label59:
    if (paramTask.isCancelled()) {
      throw new RuntimeException(new CancellationException());
    }
    paramTask = paramTask.getResult();
    return paramTask;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/Parse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */