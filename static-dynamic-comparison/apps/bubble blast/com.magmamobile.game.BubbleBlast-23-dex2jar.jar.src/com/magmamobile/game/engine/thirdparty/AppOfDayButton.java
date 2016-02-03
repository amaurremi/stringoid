package com.magmamobile.game.engine.thirdparty;

import android.graphics.Bitmap;
import android.graphics.Paint;
import com.magmamobile.game.engine.AppParameters;
import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.GameObject;
import com.magmamobile.game.engine.MathUtils;
import com.magmamobile.game.engine.Sound;
import com.magmamobile.game.engine.TouchScreen;
import com.magmamobile.mmusia.MMUSIA;
import com.magmamobile.mmusia.image.ImageCache;
import com.magmamobile.mmusia.parser.data.ApiBase;

public class AppOfDayButton
  extends GameObject
{
  protected Bitmap background;
  protected Bitmap curBitmap;
  protected int innerHeight;
  protected int innerWidth;
  protected Bitmap oldBitmap;
  protected float paddingLeft;
  protected float paddingTop;
  protected Paint paint;
  protected Sound sound;
  
  public AppOfDayButton()
  {
    this.visible = true;
    this.enabled = true;
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setFilterBitmap(true);
    if (Game.getParameters().DEFAULT_BUTTON_SOUND != 0) {}
    for (Sound localSound = Game.getSound(Game.getParameters().DEFAULT_BUTTON_SOUND);; localSound = null)
    {
      this.sound = localSound;
      request();
      return;
    }
  }
  
  public AppOfDayButton(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.visible = true;
    this.enabled = true;
    this.x = paramInt1;
    this.y = paramInt2;
    this.w = paramInt3;
    this.h = paramInt4;
    this.innerWidth = paramInt3;
    this.innerHeight = paramInt4;
    this.paddingLeft = 0.0F;
    this.paddingTop = 0.0F;
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setFilterBitmap(true);
    if (Game.getParameters().DEFAULT_BUTTON_SOUND != 0) {}
    for (Sound localSound = Game.getSound(Game.getParameters().DEFAULT_BUTTON_SOUND);; localSound = null)
    {
      this.sound = localSound;
      request();
      return;
    }
  }
  
  public AppOfDayButton(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.visible = true;
    this.enabled = true;
    this.x = paramInt1;
    this.y = paramInt2;
    this.w = paramInt3;
    this.h = paramInt4;
    this.innerWidth = paramInt5;
    this.innerHeight = paramInt6;
    this.paddingLeft = ((paramInt3 - paramInt5) / 2);
    this.paddingTop = ((paramInt3 - paramInt6) / 2);
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setFilterBitmap(true);
    if (Game.getParameters().DEFAULT_BUTTON_SOUND != 0) {}
    for (Sound localSound = Game.getSound(Game.getParameters().DEFAULT_BUTTON_SOUND);; localSound = null)
    {
      this.sound = localSound;
      request();
      return;
    }
  }
  
  private void releasePreviousBitmap()
  {
    if ((this.oldBitmap != null) && (!this.oldBitmap.isRecycled()))
    {
      this.oldBitmap.recycle();
      this.oldBitmap = null;
      System.gc();
    }
  }
  
  private void request()
  {
    new Thread(new Runnable()
    {
      public int load(int paramAnonymousInt)
      {
        int i = 1;
        for (;;)
        {
          if (i < 5) {}
          try
          {
            ApiBase localApiBase = MMUSIA.api;
            if (localApiBase == null) {
              break label36;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            do
            {
              for (;;)
              {
                long l;
                localInterruptedException.printStackTrace();
              }
              i = paramAnonymousInt;
            } while (MMUSIA.api.appodayId == paramAnonymousInt);
            AppOfDayButton.this.oldBitmap = AppOfDayButton.this.curBitmap;
            Bitmap localBitmap = ImageCache.requestAppOfTheDayBitmap(Game.getContext());
            if (localBitmap == null) {
              break label112;
            }
            AppOfDayButton.this.curBitmap = localBitmap;
            AppOfDayButton.this.releasePreviousBitmap();
          }
          if ((MMUSIA.api != null) && (MMUSIA.api.appodayIconUrl != null)) {
            break;
          }
          i = -1;
          return i;
          label36:
          l = i * 1000;
          Thread.sleep(l);
          i += 1;
        }
        label112:
        return MMUSIA.api.appodayId;
      }
      
      public void run()
      {
        int i = load(-1);
        try
        {
          Thread.sleep(10000L);
          load(i);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }).start();
  }
  
  public Bitmap getBackround()
  {
    return this.background;
  }
  
  public float getInnerHeight()
  {
    return this.innerHeight;
  }
  
  public float getInnerWidth()
  {
    return this.innerWidth;
  }
  
  public float getPaddingLeft()
  {
    return this.paddingLeft;
  }
  
  public float getPaddingTop()
  {
    return this.paddingTop;
  }
  
  public Sound getSound()
  {
    return this.sound;
  }
  
  public void onAction()
  {
    if ((!this.visible) || (!this.enabled)) {}
    while ((this.curBitmap == null) || (!TouchScreen.eventUp) || (!MathUtils.PtInRect((int)this.x, (int)this.y, (int)(this.x + this.w), (int)(this.y + this.h), TouchScreen.x, TouchScreen.y))) {
      return;
    }
    if (this.sound != null) {
      this.sound.play();
    }
    GoogleAnalytics.trackAndDispatch("appoftheday");
    MMUSIA.openAppOfTheDay(Game.getContext());
  }
  
  public void onRender()
  {
    if ((!this.visible) || (!this.enabled)) {}
    do
    {
      return;
      if (this.background != null) {
        Game.drawBitmap(this.background, this.x, this.y);
      }
    } while ((this.curBitmap == null) || (this.curBitmap.isRecycled()));
    if (this.angle == 0.0F)
    {
      Game.drawBitmap(this.curBitmap, (int)(this.x + this.paddingLeft), (int)(this.y + this.paddingTop), this.innerWidth, this.innerHeight, this.paint);
      return;
    }
    Game.drawBitmap(this.curBitmap, (int)(this.x + this.paddingLeft + this.innerWidth / 2), (int)(this.y + this.paddingTop + this.innerHeight / 2), (int)this.angle, 1.0F, this.paint);
  }
  
  public void setBackground(Bitmap paramBitmap)
  {
    this.background = paramBitmap;
  }
  
  public void setInnerHeight(int paramInt)
  {
    this.innerHeight = paramInt;
  }
  
  public void setInnerWidth(int paramInt)
  {
    this.innerWidth = paramInt;
  }
  
  public void setPaddingLeft(float paramFloat)
  {
    this.paddingLeft = paramFloat;
  }
  
  public void setPaddingTop(float paramFloat)
  {
    this.paddingTop = paramFloat;
  }
  
  public void setSound(Sound paramSound)
  {
    this.sound = paramSound;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/thirdparty/AppOfDayButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */