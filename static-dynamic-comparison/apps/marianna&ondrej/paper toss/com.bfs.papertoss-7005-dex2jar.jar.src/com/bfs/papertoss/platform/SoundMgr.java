package com.bfs.papertoss.platform;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.AsyncPlayer;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.util.Log;
import java.io.IOException;
import java.util.HashMap;

public class SoundMgr
{
  public static int m_background_stread_id = -1;
  public static boolean m_sound = true;
  AsyncPlayer asyncPlayer;
  BackgroundSound backgroundSound = new BackgroundSound(null);
  String current_background_filename = new String();
  int m_current_background = -1;
  private String m_current_background_sound = "";
  MediaPlayer m_player = null;
  HashMap<String, Integer> map = new HashMap();
  PlaySound playSound = new PlaySound(null);
  SetSound setSound = new SetSound(null);
  SoundPool soundPool = new SoundPool(5, 3, 0);
  
  public SoundMgr()
  {
    preloadAllSounds();
    Evt.getInstance().subscribe("paperTossPlaySound", this.playSound);
    Evt.getInstance().subscribe("setBackgroundSound", this.backgroundSound);
    Evt.getInstance().subscribe("setSound", this.setSound);
  }
  
  private void preloadAllSounds()
  {
    try
    {
      String[] arrayOfString = Globals.m_context.getAssets().list("sounds");
      int j = arrayOfString.length;
      int i = 0;
      String str1;
      while (i < j)
      {
        String str2 = arrayOfString[i];
        str1 = str2;
        try
        {
          if (!str2.contains(".raw"))
          {
            str1 = str2;
            str2 = "sounds/" + str2;
            str1 = str2;
            int k = this.soundPool.load(Globals.m_context.getAssets().openFd(str2), 1);
            str1 = str2;
            this.map.put(str2, Integer.valueOf(k));
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.d("BFS", "Could not pre-load sound: " + str1, localException);
          }
        }
        i += 1;
      }
      return;
    }
    catch (IOException localIOException)
    {
      Log.d("BFS", "Could not locate sounds directory", localIOException);
    }
  }
  
  public void startBackgroundSound()
  {
    this.backgroundSound.run(this.m_current_background_sound);
  }
  
  public void stopBackgroundSound()
  {
    if ((this.m_player != null) && (this.m_player.isPlaying()))
    {
      this.m_player.stop();
      this.m_player.release();
      this.m_player = null;
    }
  }
  
  private class BackgroundSound
    implements EvtListener
  {
    private BackgroundSound() {}
    
    public void run(Object paramObject)
    {
      paramObject = ("sounds/" + (String)paramObject).replace(".mp3", ".OGG");
      int i = 0;
      if (((String)paramObject).contains("OfficeNoise")) {
        i = 2130968580;
      }
      for (;;)
      {
        if (!((String)paramObject).equals(SoundMgr.this.m_current_background_sound)) {
          SoundMgr.access$102(SoundMgr.this, (String)paramObject);
        }
        try
        {
          if ((SoundMgr.this.m_player != null) && (SoundMgr.this.m_player.isPlaying()))
          {
            SoundMgr.this.m_player.stop();
            SoundMgr.this.m_player.release();
            SoundMgr.this.m_player = null;
          }
          if ((SoundMgr.m_sound) && (i != 0))
          {
            SoundMgr.this.m_player = MediaPlayer.create(Globals.m_context, i);
            SoundMgr.this.m_player.setLooping(true);
            SoundMgr.this.m_player.start();
          }
          return;
        }
        catch (Exception localException)
        {
          Log.d("BFS", "Could not play background sound: " + (String)paramObject, localException);
        }
        if (((String)paramObject).contains("AirportNoise")) {
          i = 2130968576;
        } else if (((String)paramObject).contains("BasementAmbient")) {
          i = 2130968577;
        } else if (((String)paramObject).contains("Bathroom Background")) {
          i = 2130968578;
        }
      }
    }
  }
  
  private class PlaySound
    implements EvtListener
  {
    private PlaySound() {}
    
    public void run(Object paramObject)
    {
      if (!SoundMgr.m_sound) {
        return;
      }
      paramObject = ("sounds/" + (String)paramObject).replace(".wav", ".OGG");
      if (!SoundMgr.this.map.containsKey(paramObject)) {}
      try
      {
        int i = SoundMgr.this.soundPool.load(Globals.m_context.getAssets().openFd((String)paramObject), 1);
        SoundMgr.this.map.put(paramObject, Integer.valueOf(i));
        i = ((Integer)SoundMgr.this.map.get(paramObject)).intValue();
        SoundMgr.this.soundPool.play(i, 1.0F, 1.0F, 1, 0, 1.0F);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.d("BFS", "Could not lazily-load sound: " + (String)paramObject, localIOException);
        }
      }
    }
  }
  
  private class SetSound
    implements EvtListener
  {
    private SetSound() {}
    
    public void run(Object paramObject)
    {
      SoundMgr.m_sound = ((Boolean)paramObject).booleanValue();
      if (SoundMgr.m_sound)
      {
        SoundMgr.this.startBackgroundSound();
        return;
      }
      SoundMgr.this.stopBackgroundSound();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/platform/SoundMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */