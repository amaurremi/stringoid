package mobi.beyondpod.rsscore.helpers;

import android.content.Context;
import com.flurry.android.FlurryAgent;
import java.util.HashMap;
import java.util.Map;
import mobi.beyondpod.rsscore.Configuration;

public class AnalyticsTracker
{
  static final String CATEGORY_APPLICATION_STARTS = "Application Starts";
  static final String CATEGORY_COMMAND = "Commands Executed";
  static final String CATEGORY_MEDIA_PLAYBACK = "Media Playback";
  static final String CATEGORY_REPOSITORY = "Repository Loads";
  static final String CATEGORY_TASK_SCHEDULER = "Scheduled Tasks";
  static final String CATEGORY_UPDATE_DOWNLOAD = "Update and Downloads";
  private static final String PARAM_COMMAND_ACTION = "Command Action";
  private static final String PARAM_COMMAND_TYPE = "Command Type";
  private static final String PARAM_FEEDS_LOADED = "Feeds Loaded";
  private static final String PARAM_LICENSE_TYPE = "License Type";
  private static final String PARAM_QUEUE_COUNT = "Queue Count";
  private static final String PARAM_START_VERSION = "Start Version";
  private static final String PARAM_TASK_ID = "Task ID";
  private static final String PARAM_TRACKS_LOADED = "Tracks Loaded";
  private static final String PARAM_UPDATE_TYPE = "Event Type";
  
  public static void Dispatch() {}
  
  public static void EndSession(Context paramContext)
  {
    if (!Configuration.GatherAnalyticsData()) {
      return;
    }
    FlurryAgent.onEndSession(paramContext);
  }
  
  public static void LogError(String paramString1, String paramString2, String paramString3)
  {
    if (!Configuration.GatherAnalyticsData()) {
      return;
    }
    FlurryAgent.onError(paramString3, paramString2, paramString1);
  }
  
  public static void OnApplicationStartedLocked()
  {
    OnEvent("Application Starts", new String[] { "License Type", "Trial", "Start Version", Configuration.ProductVersion() });
  }
  
  public static void OnApplicationStartedUnlocked(String paramString)
  {
    OnEvent("Application Starts", new String[] { "License Type", paramString, "Start Version", Configuration.ProductVersion() });
  }
  
  public static void OnBPScheduledTaskStarted(String paramString)
  {
    OnEvent("Scheduled Tasks", new String[] { "Event Type", "ScheduledTask", "Task ID", paramString });
  }
  
  public static void OnBatchDownloadStarted(int paramInt)
  {
    OnEvent("Update and Downloads", new String[] { "Event Type", "Batch Download", "Queue Count", Integer.toString(paramInt) });
  }
  
  public static void OnBatchUpdateStarted(int paramInt)
  {
    OnEvent("Update and Downloads", new String[] { "Event Type", "Batch Update Started", "Queue Count", Integer.toString(paramInt) });
  }
  
  public static void OnChangeSync(int paramInt)
  {
    OnEvent("Update and Downloads", new String[] { "Event Type", "Change Tracking Sync", "Queue Count", Integer.toString(paramInt) });
  }
  
  public static void OnCommand(String paramString1, String paramString2)
  {
    OnEvent("Commands Executed", new String[] { "Command Type", paramString1, "Command Action", paramString2 });
  }
  
  public static void OnEvent(String paramString, String... paramVarArgs)
  {
    if (!Configuration.GatherAnalyticsData()) {
      return;
    }
    HashMap localHashMap = new HashMap();
    int i;
    if (paramVarArgs != null)
    {
      i = 0;
      if (i < paramVarArgs.length) {}
    }
    else
    {
      FlurryAgent.onEvent(paramString, localHashMap);
      return;
    }
    int j = i + 1;
    String str2 = paramVarArgs[i];
    if (j < paramVarArgs.length) {}
    for (String str1 = paramVarArgs[j];; str1 = "")
    {
      localHashMap.put(str2, str1);
      i = j + 1;
      break;
    }
  }
  
  public static void OnGReaderSync(int paramInt)
  {
    OnEvent("Update and Downloads", new String[] { "Event Type", "Google Reader Sync", "Queue Count", Integer.toString(paramInt) });
  }
  
  public static void OnPlaybackStarted(String paramString)
  {
    OnEvent("Media Playback", new String[] { "Content Type", paramString });
  }
  
  public static void OnRepositoryFeedsLoaded(int paramInt)
  {
    OnEvent("Repository Loads", new String[] { "Feeds Loaded", Integer.toString(paramInt) });
  }
  
  public static void OnRepositoryTracksLoaded(int paramInt)
  {
    OnEvent("Repository Loads", new String[] { "Tracks Loaded", Integer.toString(paramInt) });
  }
  
  public static void OnSystemScheduledTaskStarted(String paramString)
  {
    OnEvent("Scheduled Tasks", new String[] { "Event Type", "System Broadcast", "Task ID", paramString });
  }
  
  public static void OnViewDisplayed(String paramString)
  {
    if (!Configuration.GatherAnalyticsData()) {
      return;
    }
    FlurryAgent.onEvent(paramString);
  }
  
  public static void OnWidgetCommand(String paramString)
  {
    OnEvent("Commands Executed", new String[] { "Command Type", "Widget Command", "Command Action", paramString });
  }
  
  public static void StartSession(Context paramContext)
  {
    if (!Configuration.GatherAnalyticsData()) {
      return;
    }
    FlurryAgent.onStartSession(paramContext, "7LADPEK1N38CRZHL38NY");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/helpers/AnalyticsTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */