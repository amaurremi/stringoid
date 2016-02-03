package mobi.beyondpod.services.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import mobi.beyondpod.aggregators.AggregatorLoginHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.schedulercore.ScheduledTasksManager;
import mobi.beyondpod.services.player.MediaPlaybackService;

public class CommandReceiver
  extends BroadcastReceiver
{
  public static final String CMD_INVALIDATE_TOKEN = "mobi.beyondpod.command.SIMULATE_INVALID_READER_TOKEN";
  public static final String CMD_PAUSE = "mobi.beyondpod.command.PAUSE";
  public static final String CMD_PLAY = "mobi.beyondpod.command.PLAY";
  public static final String CMD_PLAY_NEXT = "mobi.beyondpod.command.PLAY_NEXT";
  public static final String CMD_PLAY_PREVIOUS = "mobi.beyondpod.command.PLAY_PREVIOUS";
  public static final String CMD_SET_PLAYBACK_SPEED_1 = "mobi.beyondpod.command.SET_PLAYBACK_SPEED_1";
  public static final String CMD_SET_PLAYBACK_SPEED_2 = "mobi.beyondpod.command.SET_PLAYBACK_SPEED_2";
  public static final String CMD_SET_PLAYBACK_SPEED_NORMAL = "mobi.beyondpod.command.SET_PLAYBACK_SPEED_NORMAL";
  public static final String CMD_SKIP_BACKWARD = "mobi.beyondpod.command.SKIP_BACKWARD";
  public static final String CMD_SKIP_FORWARD = "mobi.beyondpod.command.SKIP_FORWARD";
  public static final String CMD_SKIP_TO_END = "mobi.beyondpod.command.SKIP_TO_END";
  public static final String CMD_START_SMART_PLAY = "mobi.beyondpod.command.START_SMART_PLAY";
  public static final String CMD_START_SYNC = "mobi.beyondpod.command.START_SYNC";
  public static final String CMD_UPDATE_UPDATE_CATEGORY = "mobi.beyondpod.command.UPDATE_CATEGORY";
  public static final String CMD_UPDATE_UPDATE_SMART_PLAY = "mobi.beyondpod.command.UPDATE_SMART_PLAY";
  private static String TAG = CommandReceiver.class.getSimpleName();
  
  private void CallMediaPlayer(Context paramContext, String paramString)
  {
    try
    {
      Intent localIntent = new Intent(paramContext, MediaPlaybackService.class);
      if ("mobi.beyondpod.services.musicservicewidgetcommand.startsmartplay".equals(paramString)) {
        localIntent.setAction("mobi.beyondpod.services.musicservicewidgetcommand.startsmartplay");
      }
      for (;;)
      {
        paramContext.startService(localIntent);
        return;
        localIntent.setAction("mobi.beyondpod.services.musicservicecommand");
        localIntent.putExtra("command", paramString);
      }
      return;
    }
    catch (Exception paramContext)
    {
      CoreHelper.LogException(TAG, "Failed to start player command!", paramContext);
    }
  }
  
  public static void StartScheduledTask(Context paramContext, String paramString)
  {
    try
    {
      Intent localIntent = new Intent(paramContext, SchedulingService.class);
      localIntent.setAction(paramString);
      paramContext.startService(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      CoreHelper.LogException(TAG, "Command Receiver failed to start sheduled task: " + paramString, paramContext);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    CoreHelper.WriteTraceEntry(TAG, "###### External Command received: " + str);
    if ("mobi.beyondpod.command.UPDATE_CATEGORY".equals(str))
    {
      paramIntent = paramIntent.getStringExtra("category");
      if (StringUtils.IsNullOrEmpty(paramIntent)) {
        CoreHelper.WriteTraceEntry(TAG, "###### mobi.beyondpod.command.UPDATE_CATEGORY was invoked without specifying a category! (Did you forget to specify the 'category' string extra ?)");
      }
    }
    do
    {
      return;
      StartScheduledTask(paramContext, ScheduledTasksManager.BuildAdHockCategoryUpdateTaskID(paramIntent));
      return;
      if ("mobi.beyondpod.command.UPDATE_SMART_PLAY".equals(str))
      {
        StartScheduledTask(paramContext, "BPT#UPDATE_SMARTPLAY_FEEDS");
        return;
      }
      if ("mobi.beyondpod.command.PLAY".equals(str))
      {
        CallMediaPlayer(paramContext, "resume");
        return;
      }
      if ("mobi.beyondpod.command.START_SMART_PLAY".equals(str))
      {
        CallMediaPlayer(paramContext, "mobi.beyondpod.services.musicservicewidgetcommand.startsmartplay");
        return;
      }
      if ("mobi.beyondpod.command.PAUSE".equals(str))
      {
        CallMediaPlayer(paramContext, "pause");
        return;
      }
      if ("mobi.beyondpod.command.PLAY_NEXT".equals(str))
      {
        CallMediaPlayer(paramContext, "playnext");
        return;
      }
      if ("mobi.beyondpod.command.PLAY_PREVIOUS".equals(str))
      {
        CallMediaPlayer(paramContext, "playprevious");
        return;
      }
      if ("mobi.beyondpod.command.SKIP_FORWARD".equals(str))
      {
        CallMediaPlayer(paramContext, "skipforward");
        return;
      }
      if ("mobi.beyondpod.command.SKIP_BACKWARD".equals(str))
      {
        CallMediaPlayer(paramContext, "skipbackword");
        return;
      }
      if ("mobi.beyondpod.command.SKIP_TO_END".equals(str))
      {
        CallMediaPlayer(paramContext, "skiptoend");
        return;
      }
      if ("mobi.beyondpod.command.SET_PLAYBACK_SPEED_NORMAL".equals(str))
      {
        CallMediaPlayer(paramContext, "setPlaybackSpeedNormal");
        return;
      }
      if ("mobi.beyondpod.command.SET_PLAYBACK_SPEED_1".equals(str))
      {
        CallMediaPlayer(paramContext, "setPlaybackSpeedSpeed1");
        return;
      }
      if ("mobi.beyondpod.command.SET_PLAYBACK_SPEED_2".equals(str))
      {
        CallMediaPlayer(paramContext, "setPlaybackSpeedSpeed2");
        return;
      }
      if ("mobi.beyondpod.command.SIMULATE_INVALID_READER_TOKEN".equals(str))
      {
        AggregatorLoginHelper.SimulateInvalidToken();
        return;
      }
    } while (!"mobi.beyondpod.command.START_SYNC".equals(str));
    StartScheduledTask(paramContext, "BPT#SYNC_CHANGE_TRACKING");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/scheduler/CommandReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */