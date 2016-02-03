package mobi.beyondpod.services.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public class MediaButtonIntentReceiver
  extends BroadcastReceiver
{
  public static MediaButtonIntentReceiver Instance;
  private static final int LONG_PRESS_DELAY = 1000;
  private static final int MSG_LONGPRESS_TIMEOUT = 1;
  private static final String TAG = MediaButtonIntentReceiver.class.getSimpleName();
  private static boolean _IsListening;
  private static boolean mDown;
  private static Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        return;
      } while (MediaButtonIntentReceiver.mLaunched);
      CoreHelper.WriteTraceEntry(MediaButtonIntentReceiver.TAG, "*** Long Press Detected! Skipping Forward...");
      paramAnonymousMessage = (Context)paramAnonymousMessage.obj;
      Intent localIntent = new Intent(paramAnonymousMessage, MediaPlaybackService.class);
      localIntent.setAction("mobi.beyondpod.services.musicservicecommand");
      localIntent.putExtra("command", MediaButtonIntentReceiver.translateCommand(Configuration.WRLongPressButtonAction()));
      localIntent.putExtra("commandOption", "play");
      MediaButtonIntentReceiver.PublishMediaButtonEvent(paramAnonymousMessage, localIntent);
      MediaButtonIntentReceiver.mLaunched = true;
    }
  };
  private static long mLastClickTime = 0L;
  private static boolean mLaunched;
  
  static
  {
    mDown = false;
    mLaunched = false;
    _IsListening = false;
    Instance = new MediaButtonIntentReceiver();
    CoreHelper.WriteTraceEntry(TAG, "****** Static Constructor Called *********");
  }
  
  public static void PublishMediaButtonEvent(Context paramContext, Intent paramIntent)
  {
    CoreHelper.WriteTraceEntry(TAG, "***========> Media button receiver executing action: " + paramIntent.getStringExtra("command"));
    if (!BeyondPodApplication.GetInstance().SendCommandToVideoPlayer(paramIntent)) {
      paramContext.startService(paramIntent);
    }
  }
  
  public static void StartListeningForMediaButton()
  {
    TransportFocusHelper.getInstance().StartListeningForMediaButton();
    _IsListening = true;
  }
  
  public static void StopListeningForMediaButton()
  {
    if (!_IsListening) {
      return;
    }
    TransportFocusHelper.getInstance().StopListeningForMediaButton();
    _IsListening = false;
  }
  
  public static void Touch() {}
  
  private static String translateCommand(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "pause";
    case 1: 
      return "playnext";
    case 2: 
      return "playprevious";
    case 3: 
      return "skipforward";
    case 4: 
      return "skipbackword";
    }
    return "skiptoend";
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    CoreHelper.WriteTraceEntry(TAG, "****** Media button receiver got event: " + (String)localObject);
    if ("android.media.AUDIO_BECOMING_NOISY".equals(localObject))
    {
      mHandler.removeMessages(1);
      if (Configuration.PauseOnHeadsetDisconnect()) {
        if (!PlayList.IsCurrentlyPlaying()) {
          CoreHelper.WriteTraceEntry(TAG, "**** We got headset disconnected but we are not playing. Nothing to do!");
        }
      }
    }
    int i;
    int j;
    long l;
    label364:
    do
    {
      do
      {
        return;
        CoreHelper.WriteTraceEntry(TAG, "*** Sending Pause command to the player...");
        paramIntent = new Intent(paramContext, MediaPlaybackService.class);
        paramIntent.setAction("mobi.beyondpod.services.musicservicecommand");
        paramIntent.putExtra("command", "pause");
        PublishMediaButtonEvent(paramContext, paramIntent);
        return;
        CoreHelper.WriteTraceEntry(TAG, "*** Pause on Headset Disconnect is Diasabled in settings!");
        return;
        if (!Configuration.EnableHeadsetButton())
        {
          CoreHelper.WriteTraceEntry(TAG, "****** Media button disabled! Ignoring..." + (String)localObject);
          return;
        }
      } while (!"android.intent.action.MEDIA_BUTTON".equals(localObject));
      paramIntent = (KeyEvent)paramIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
      CoreHelper.WriteTraceEntry(TAG, "****** Media button event FLAGS: " + paramIntent.getFlags());
      if ((paramIntent == null) || ((paramIntent.getFlags() & 0x20) != 0))
      {
        CoreHelper.WriteTraceEntry(TAG, "****** Media button event was cancelled! Ignoring..." + (String)localObject);
        return;
      }
      i = paramIntent.getKeyCode();
      j = paramIntent.getAction();
      l = paramIntent.getEventTime();
      paramIntent = null;
      switch (i)
      {
      default: 
        CoreHelper.WriteTraceEntry(TAG, "*** Media Button KEY => " + i + " (unknown) " + j);
      }
    } while (paramIntent == null);
    if (j == 0) {
      if (mDown) {
        if (("togglepause".equals(paramIntent)) && (mLastClickTime != 0L) && (l - mLastClickTime > 1000L)) {
          mHandler.sendMessage(mHandler.obtainMessage(1, paramContext));
        }
      }
    }
    while (isOrderedBroadcast())
    {
      abortBroadcast();
      return;
      CoreHelper.WriteTraceEntry(TAG, "*** Media Button KEY => MEDIA_STOP " + j);
      paramIntent = "pause";
      break label364;
      CoreHelper.WriteTraceEntry(TAG, "*** Media Button KEY => HEADSETHOOK " + j);
      paramIntent = "togglepause";
      break label364;
      CoreHelper.WriteTraceEntry(TAG, "*** Media Button KEY => MEDIA_PLAY_PAUSE " + j);
      paramIntent = "togglepause";
      break label364;
      CoreHelper.WriteTraceEntry(TAG, "*** Media Button KEY => MEDIA_PLAY " + j);
      paramIntent = "resume";
      break label364;
      CoreHelper.WriteTraceEntry(TAG, "*** Media Button KEY => MEDIA_PAUSE " + j);
      paramIntent = "pause";
      break label364;
      CoreHelper.WriteTraceEntry(TAG, "*** Media Button KEY => KEYCODE_MEDIA_FAST_FORWARD " + j);
      if (Configuration.BTNextButtonAction() == 2) {}
      for (paramIntent = "skipbackword";; paramIntent = "skipforward") {
        break;
      }
      CoreHelper.WriteTraceEntry(TAG, "*** Media Button KEY => MEDIA_NEXT " + j);
      paramIntent = translateCommand(Configuration.BTNextButtonAction());
      break label364;
      CoreHelper.WriteTraceEntry(TAG, "*** Media Button KEY => KEYCODE_MEDIA_REWIND " + j);
      if (Configuration.BTPreviousButtonAction() == 1) {}
      for (paramIntent = "skipforward";; paramIntent = "skipbackword") {
        break;
      }
      CoreHelper.WriteTraceEntry(TAG, "*** Media Button KEY => MEDIA_PREVIOUS " + j);
      paramIntent = translateCommand(Configuration.BTPreviousButtonAction());
      break label364;
      localObject = new Intent(paramContext, MediaPlaybackService.class);
      ((Intent)localObject).setAction("mobi.beyondpod.services.musicservicecommand");
      if ((i == 79) && (l - mLastClickTime < 300L))
      {
        ((Intent)localObject).putExtra("command", translateCommand(Configuration.WRDoubleClickButtonAction()));
        ((Intent)localObject).putExtra("commandOption", "play");
        PublishMediaButtonEvent(paramContext, (Intent)localObject);
        mLastClickTime = 0L;
      }
      for (;;)
      {
        mLaunched = false;
        mDown = true;
        break;
        ((Intent)localObject).putExtra("command", paramIntent);
        PublishMediaButtonEvent(paramContext, (Intent)localObject);
        mLastClickTime = l;
        if ("togglepause".equals(paramIntent))
        {
          mHandler.removeMessages(1);
          mHandler.sendMessageDelayed(mHandler.obtainMessage(1, paramContext), 1000L);
        }
      }
      mHandler.removeMessages(1);
      mDown = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/MediaButtonIntentReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */