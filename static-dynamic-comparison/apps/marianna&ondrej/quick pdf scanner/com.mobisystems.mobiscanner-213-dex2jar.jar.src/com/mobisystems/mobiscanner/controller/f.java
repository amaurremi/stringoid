package com.mobisystems.mobiscanner.controller;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaActionSound;
import android.media.MediaPlayer;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.common.d;

@TargetApi(16)
public class f
{
  private static boolean azw = true;
  private static boolean azx = false;
  private MediaPlayer azA = null;
  private MediaActionSound azy = null;
  private MediaPlayer azz = null;
  private Context mContext;
  private final c mLog = new c(this);
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
    if (d.Dz())
    {
      this.azy = new MediaActionSound();
      this.azy.load(1);
      this.azy.load(0);
    }
  }
  
  public void Fe()
  {
    if (azw)
    {
      if (this.azy == null) {
        break label22;
      }
      this.azy.play(0);
    }
    label22:
    while (((AudioManager)this.mContext.getSystemService("audio")).getStreamVolume(5) == 0) {
      return;
    }
    if (this.azz == null) {
      this.azz = MediaPlayer.create(this.mContext, 2131099654);
    }
    if (this.azz != null)
    {
      this.azz.start();
      return;
    }
    this.mLog.A("Could not create camera shutter media player");
  }
  
  public void Ff()
  {
    if (azx)
    {
      if (this.azy == null) {
        break label22;
      }
      this.azy.play(1);
    }
    label22:
    while (((AudioManager)this.mContext.getSystemService("audio")).getStreamVolume(5) == 0) {
      return;
    }
    if (this.azA == null) {
      this.azA = MediaPlayer.create(this.mContext, 2131099652);
    }
    if (this.azA != null)
    {
      this.azA.start();
      return;
    }
    this.mLog.A("Could not create camera shutter media player");
  }
  
  public void release()
  {
    if (this.azy != null)
    {
      this.azy.release();
      this.azy = null;
    }
    if (this.azz != null)
    {
      this.azz.release();
      this.azz = null;
    }
    if (this.azA != null)
    {
      this.azA.release();
      this.azA = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */