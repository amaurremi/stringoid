package mobi.beyondpod.services.player;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.services.player.impl.ChromecastDevice;

public abstract class AudioFocusHelper
{
  private static String TAG = AudioFocusHelper.class.getSimpleName();
  
  public static AudioFocusHelper getInstance()
  {
    return AudioFocusHelper.AudioFocus.Holder.sInstance;
  }
  
  abstract void ReleaseAudioFocus();
  
  abstract boolean TrySetAudioFocus();
  
  private static class AudioFocus
    extends AudioFocusHelper
  {
    AudioManager.OnAudioFocusChangeListener _AudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener()
    {
      public void onAudioFocusChange(int paramAnonymousInt)
      {
        if (!Configuration.PauseOnNotification())
        {
          CoreHelper.WriteTraceEntry(AudioFocusHelper.TAG, "**** Audiofocus changed but pause on notification is Disabled");
          return;
        }
        switch (paramAnonymousInt)
        {
        case 0: 
        default: 
          return;
        case -3: 
          if (ChromecastDevice.IsConnected())
          {
            CoreHelper.WriteTraceEntry(AudioFocusHelper.TAG, "**** Audiofocus change: AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK! Currently playing on Chromecast player. Ignoring...");
            return;
          }
          break;
        case 1: 
          CoreHelper.WriteTraceEntry(AudioFocusHelper.TAG, "**** Audiofocus change: AUDIOFOCUS_GAIN. Is Playing:" + AudioFocusHelper.AudioFocus.this.isPlaying() + ", Was playing when audiofocus was lost:" + AudioFocusHelper.AudioFocus.this._WasPlayingOnTransientAudioFocusLoss + ", Was Connected to Chromecast on focus lost: " + AudioFocusHelper.AudioFocus.this._WasConnectedToCrhomecastOnTransientAudioFocusLoss + ", Is conencted now: " + ChromecastDevice.IsConnected());
          if ((!AudioFocusHelper.AudioFocus.this.isPlaying()) && (AudioFocusHelper.AudioFocus.this._WasPlayingOnTransientAudioFocusLoss) && ((!AudioFocusHelper.AudioFocus.this._WasConnectedToCrhomecastOnTransientAudioFocusLoss) || ((AudioFocusHelper.AudioFocus.this._WasConnectedToCrhomecastOnTransientAudioFocusLoss) && (ChromecastDevice.IsConnected())))) {
            AudioFocusHelper.AudioFocus.this.play();
          }
          AudioFocusHelper.AudioFocus.this._WasPlayingOnTransientAudioFocusLoss = false;
          return;
        case -1: 
          CoreHelper.WriteTraceEntry(AudioFocusHelper.TAG, "**** Audiofocus change: AUDIOFOCUS_LOSS. Is Playing:" + AudioFocusHelper.AudioFocus.this.isPlaying() + ", Is Connected to Chromecast: " + ChromecastDevice.IsConnected());
          AudioFocusHelper.AudioFocus.this.pause();
          return;
        case -2: 
          AudioFocusHelper.AudioFocus.this._WasPlayingOnTransientAudioFocusLoss = AudioFocusHelper.AudioFocus.this.isPlaying();
          AudioFocusHelper.AudioFocus.this._WasConnectedToCrhomecastOnTransientAudioFocusLoss = ChromecastDevice.IsConnected();
          CoreHelper.WriteTraceEntry(AudioFocusHelper.TAG, "**** Audiofocus change: AUDIOFOCUS_LOSS_TRANSIENT. Is Playing:" + AudioFocusHelper.AudioFocus.this._WasPlayingOnTransientAudioFocusLoss + ", Is Connected to Chromecast: " + ChromecastDevice.IsConnected());
          AudioFocusHelper.AudioFocus.this.pause();
          return;
        }
        AudioFocusHelper.AudioFocus.this._WasPlayingOnTransientAudioFocusLoss = AudioFocusHelper.AudioFocus.this.isPlaying();
        AudioFocusHelper.AudioFocus.this._WasConnectedToCrhomecastOnTransientAudioFocusLoss = ChromecastDevice.IsConnected();
        CoreHelper.WriteTraceEntry(AudioFocusHelper.TAG, "**** Audiofocus change: AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK. Is Playing: " + AudioFocusHelper.AudioFocus.this._WasPlayingOnTransientAudioFocusLoss + ", Connected to Chromecast: " + AudioFocusHelper.AudioFocus.this._WasConnectedToCrhomecastOnTransientAudioFocusLoss);
        AudioFocusHelper.AudioFocus.this.pause();
      }
    };
    private boolean _WasConnectedToCrhomecastOnTransientAudioFocusLoss = false;
    private boolean _WasPlayingOnTransientAudioFocusLoss = false;
    
    void ReleaseAudioFocus() {}
    
    @SuppressLint({"NewApi"})
    boolean TrySetAudioFocus()
    {
      int i = ((AudioManager)BeyondPodApplication.GetInstance().getSystemService("audio")).requestAudioFocus(this._AudioFocusChangeListener, 3, 1);
      String str = AudioFocusHelper.TAG;
      StringBuilder localStringBuilder = new StringBuilder("**** Requesting Audiofocus... . Requested:");
      if (i == 1) {}
      for (boolean bool = true;; bool = false)
      {
        CoreHelper.WriteTraceEntry(str, bool);
        if (i != 1) {
          break;
        }
        return true;
      }
      return false;
    }
    
    protected boolean isPlaying()
    {
      return PlayList.IsCurrentlyPlaying();
    }
    
    protected void pause()
    {
      if (!isPlaying())
      {
        CoreHelper.WriteTraceEntry(AudioFocusHelper.TAG, "**** We lost audiofocus but we are not playing. Nothing to do!");
        return;
      }
      Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), MediaPlaybackService.class);
      localIntent.setAction("mobi.beyondpod.services.musicservicecommand");
      localIntent.putExtra("command", "pause");
      BeyondPodApplication.GetInstance().startService(localIntent);
    }
    
    protected void play()
    {
      Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), MediaPlaybackService.class);
      localIntent.setAction("mobi.beyondpod.services.musicservicecommand");
      localIntent.putExtra("command", "resume");
      BeyondPodApplication.GetInstance().startService(localIntent);
    }
    
    private static class Holder
    {
      private static final AudioFocusHelper.AudioFocus sInstance = new AudioFocusHelper.AudioFocus(null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/AudioFocusHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */