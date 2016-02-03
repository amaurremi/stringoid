package com.parse;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;
import org.json.JSONObject;

public class ParseTestUtils
{
  private static final String TAG = "com.parse.ParseTestUtils";
  private static int serverPort = 9000;
  private static Synchronizer synchronizer;
  
  public static void allowSleep(int paramInt)
  {
    PushService.sleepSemaphore.release(paramInt);
  }
  
  public static void assertFinishes()
  {
    synchronizer.assertFinishes();
  }
  
  public static void assertSlept()
  {
    for (;;)
    {
      if (PushService.sleepSemaphore.availablePermits() == 0) {
        return;
      }
      try
      {
        Thread.sleep(50L);
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new RuntimeException(localInterruptedException.getMessage());
      }
    }
  }
  
  public static void beginFakeSleep()
  {
    PushService.sleepSemaphore = new Semaphore(0);
  }
  
  public static void clearApp()
  {
    ParseCommand localParseCommand = new ParseCommand("clear_app", null);
    try
    {
      Parse.waitForTask(localParseCommand.performAsync());
      return;
    }
    catch (ParseException localParseException)
    {
      throw new RuntimeException(localParseException.getMessage());
    }
  }
  
  public static void clearCurrentInstallationFromMemory()
  {
    ParseInstallation.currentInstallation = null;
  }
  
  public static void clearFiles()
  {
    recursiveDelete(Parse.getParseDir());
    recursiveDelete(Parse.getKeyValueCacheDir());
    if (Parse.commandCache != null)
    {
      Parse.commandCache.pause();
      Parse.commandCache = null;
    }
  }
  
  public static void clearPushRouterStateFromMemory() {}
  
  public static int commandCacheUnexpectedEvents()
  {
    return Parse.getCommandCache().getTestHelper().unexpectedEvents();
  }
  
  public static int consecutiveFailures()
  {
    return PushService.consecutiveFailures;
  }
  
  public static void disconnectCommandCache()
  {
    Parse.getCommandCache().setConnected(false);
  }
  
  public static void endFakeSleep()
  {
    PushService.sleepSemaphore.release(1000000);
  }
  
  public static void finish()
  {
    synchronizer.finish();
  }
  
  public static String getIgnoreAfterTime()
  {
    return ParsePushRouter.ignoreAfter;
  }
  
  public static String getInstallationId(Context paramContext)
  {
    return ParseInstallation.getCurrentInstallation().getInstallationId();
  }
  
  public static String getLastTime()
  {
    return ParsePushRouter.lastTime;
  }
  
  public static ParseObject getObjectFromDisk(Context paramContext, String paramString)
  {
    return ParseObject.getFromDisk(paramContext, paramString);
  }
  
  static File getParseDir(Context paramContext)
  {
    return paramContext.getDir("Parse", 0);
  }
  
  public static JSONObject getPushRequestJSON(Context paramContext)
  {
    return ParsePushRouter.getPushRequestJSON(paramContext);
  }
  
  public static ParseUser getUserObjectFromDisk(Context paramContext, String paramString)
  {
    return (ParseUser)ParseObject.getFromDisk(paramContext, paramString);
  }
  
  public static void initSynchronizer()
  {
    synchronizer = new Synchronizer();
  }
  
  public static Set<String> keySet(ParseObject paramParseObject)
  {
    return paramParseObject.keySet();
  }
  
  public static ServerSocket mockPushServer()
  {
    serverPort += 1;
    PushService.usePort(serverPort);
    Parse.logI("com.parse.ParseTestUtils", "running mockPushServer on port " + serverPort);
    try
    {
      ServerSocket localServerSocket = new ServerSocket(serverPort);
      return localServerSocket;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException.getMessage());
    }
  }
  
  public static void mockV8Client()
  {
    ParseCommand localParseCommand = new ParseCommand("mock_v8_client", null);
    try
    {
      Parse.waitForTask(localParseCommand.performAsync());
      return;
    }
    catch (ParseException localParseException)
    {
      throw new RuntimeException(localParseException);
    }
  }
  
  public static int numKeyValueCacheFiles()
  {
    return Parse.getKeyValueCacheDir().listFiles().length;
  }
  
  public static void onPush(Context paramContext, String paramString, PushCallback paramPushCallback)
  {
    ParsePushRouter.addSingletonRoute(paramContext, paramString, paramPushCallback);
    PushService.startServiceIfRequired(paramContext);
  }
  
  public static Set<String> pushRoutes(Context paramContext)
  {
    ParsePushRouter.ensureStateIsLoaded(paramContext);
    return ParsePushRouter.channelRoutes.keySet();
  }
  
  public static void reconnectCommandCache()
  {
    Parse.getCommandCache().setConnected(true);
  }
  
  public static void recursiveDelete(File paramFile)
  {
    if (!paramFile.exists()) {
      return;
    }
    File[] arrayOfFile;
    int j;
    int i;
    if (paramFile.isDirectory())
    {
      arrayOfFile = paramFile.listFiles();
      j = arrayOfFile.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j)
      {
        paramFile.delete();
        return;
      }
      recursiveDelete(arrayOfFile[i]);
      i += 1;
    }
  }
  
  public static void resetCommandCache()
  {
    ParseCommandCache localParseCommandCache = Parse.getCommandCache();
    ParseCommandCache.TestHelper localTestHelper = localParseCommandCache.getTestHelper();
    localParseCommandCache.clear();
    localTestHelper.clear();
  }
  
  public static void saveObjectToDisk(ParseObject paramParseObject, Context paramContext, String paramString)
  {
    paramParseObject.saveToDisk(paramContext, paramString);
  }
  
  public static void saveStringToDisk(String paramString1, Context paramContext, String paramString2)
  {
    paramContext = new File(getParseDir(paramContext), paramString2);
    try
    {
      paramContext = new FileOutputStream(paramContext);
      paramContext.write(paramString1.getBytes("UTF-8"));
      paramContext.close();
      return;
    }
    catch (UnsupportedEncodingException paramString1) {}catch (IOException paramString1) {}
  }
  
  public static void setCommandInitialDelay(double paramDouble)
  {
    ParseCommand.setInitialDelay(paramDouble);
  }
  
  public static void setMaxKeyValueCacheBytes(int paramInt)
  {
    Parse.maxKeyValueCacheBytes = paramInt;
  }
  
  public static void setMaxKeyValueCacheFiles(int paramInt)
  {
    Parse.maxKeyValueCacheFiles = paramInt;
  }
  
  public static int setPushHistoryLength(int paramInt)
  {
    int i = ParsePushRouter.maxHistory;
    ParsePushRouter.maxHistory = paramInt;
    return i;
  }
  
  public static void setUpPushTest(Context paramContext)
  {
    StandardPushCallback.disableNotifications = true;
    StandardPushCallback.totalNotifications = 0;
    PushService.sleepSemaphore = null;
    PushService.useServer("localhost");
    useServer("http://10.0.2.2:3000");
    ParsePushRouter.clearStateFromDisk(paramContext);
    ParseInstallation.clearCurrentInstallationFromDisk(paramContext);
    initSynchronizer();
    PushConnection.generalTimeout = 60000L;
    PushConnection.connectTimeout = 60000;
  }
  
  public static void start(int paramInt)
  {
    synchronizer.start(paramInt);
  }
  
  public static void startServiceIfRequired(Context paramContext)
  {
    PushService.startServiceIfRequired(paramContext);
  }
  
  public static void tearDownPushTest(Context paramContext)
  {
    clearFiles();
    ParseInstallation.clearCurrentInstallationFromDisk(paramContext);
    ParsePushRouter.clearStateFromDisk(paramContext);
    if (PushService.connection != null) {
      PushService.connection.close();
    }
  }
  
  public static int totalNotifications()
  {
    return StandardPushCallback.totalNotifications;
  }
  
  public static void unmockV8Client()
  {
    ParseCommand localParseCommand = new ParseCommand("unmock_v8_client", null);
    try
    {
      Parse.waitForTask(localParseCommand.performAsync());
      return;
    }
    catch (ParseException localParseException)
    {
      throw new RuntimeException(localParseException);
    }
  }
  
  public static String useBadServerPort(String paramString)
  {
    String str = "http://10.0.2.2:6000";
    try
    {
      paramString = new URL(paramString);
      paramString = paramString.getProtocol() + "://" + paramString.getHost() + ":" + (paramString.getPort() + 999);
      return useServer(paramString);
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        paramString = str;
      }
    }
  }
  
  public static void useDevPushServer()
  {
    PushService.useServer("10.0.2.2");
  }
  
  public static String useInvalidServer()
  {
    return useServer("http://invalid.server:3000");
  }
  
  public static String useServer(String paramString)
  {
    String str = ParseObject.server;
    ParseObject.server = paramString;
    return str;
  }
  
  public static boolean waitForCommandCacheEnqueue()
  {
    return Parse.getCommandCache().getTestHelper().waitFor(3);
  }
  
  public static boolean waitForCommandCacheFailure()
  {
    return Parse.getCommandCache().getTestHelper().waitFor(2);
  }
  
  public static boolean waitForCommandCacheSuccess()
  {
    return (Parse.getCommandCache().getTestHelper().waitFor(1)) && (Parse.getCommandCache().getTestHelper().waitFor(5));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseTestUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */