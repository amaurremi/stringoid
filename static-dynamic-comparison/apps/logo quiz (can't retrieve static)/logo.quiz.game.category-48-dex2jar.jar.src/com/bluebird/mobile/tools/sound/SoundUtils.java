package com.bluebird.mobile.tools.sound;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.util.Log;

public class SoundUtils
{
  private final Context context;
  private MediaPlayer mp;
  private final SharedPreferences sharedPreferences;
  private final String soundOnPreferenceName = "soundOn";
  
  SoundUtils(Context paramContext)
  {
    this.sharedPreferences = paramContext.getSharedPreferences("sound_utils", 0);
    this.context = paramContext;
  }
  
  public void changeSettingToOpposite()
  {
    if (isSoundOn())
    {
      turnOffSoundOn();
      return;
    }
    turnOnSound();
  }
  
  public boolean isSoundOn()
  {
    return this.sharedPreferences.getBoolean("soundOn", true);
  }
  
  public void playSound(int paramInt)
  {
    try
    {
      if (isSoundOn())
      {
        this.mp = MediaPlayer.create(this.context, paramInt);
        this.mp.start();
        this.mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
          public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            paramAnonymousMediaPlayer.release();
          }
        });
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("SoundUtils", "Error while playing sound", localException);
    }
  }
  
  public void turnOffSoundOn()
  {
    SharedPreferences.Editor localEditor = this.sharedPreferences.edit();
    localEditor.putBoolean("soundOn", false);
    localEditor.commit();
  }
  
  public void turnOnSound()
  {
    SharedPreferences.Editor localEditor = this.sharedPreferences.edit();
    localEditor.putBoolean("soundOn", true);
    localEditor.commit();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/sound/SoundUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */