package com.magmamobile.game.engine;

import android.graphics.Bitmap;

public class ImageButton
  extends GameObject
{
  private boolean _clicked;
  private int _fit;
  private Bitmap _icon;
  private Bitmap _iconOff;
  private Bitmap _iconOn;
  private int _iconx;
  private int _icony;
  private boolean _pressed;
  private Sound _sound;
  private Label _text;
  
  public ImageButton()
  {
    int i = Game.getParameters().DEFAULT_BUTTON_SOUND;
    if (i != 0) {}
    for (Sound localSound = Game.getSound(i);; localSound = null)
    {
      this._sound = localSound;
      this._text = new Label();
      this.visible = true;
      this.enabled = true;
      return;
    }
  }
  
  public ImageButton(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, Bitmap paramBitmap)
  {
    this();
    setX(paramInt1);
    setY(paramInt2);
    setSize(paramInt3, paramInt4);
    this._text.setText(paramString);
    this._text.setSize(Game.getParameters().DEFAULT_BUTTON_TEXT_SIZE);
    this._text.setColor(Game.getParameters().DEFAULT_BUTTON_TEXT_COLOR);
    this._icon = paramBitmap;
    this._iconOn = paramBitmap;
    this._iconOff = paramBitmap;
    update();
  }
  
  public ImageButton(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, Bitmap paramBitmap, int paramInt5)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, paramString, paramBitmap);
    this._fit = paramInt5;
  }
  
  public ImageButton(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, paramString, paramBitmap1);
    this._iconOn = paramBitmap2;
  }
  
  private void update()
  {
    if ((this.hasMoved) || (this.isResized)) {
      if (this._icon != null)
      {
        if (this._fit != 1) {
          break label104;
        }
        this._iconx = ((int)this.x);
        this._icony = ((int)this.y);
        this._text.x = ((int)this.x + (this.cw - this._text.cw));
        this._text.setY(this._icony + this.ch + 8);
      }
    }
    for (;;)
    {
      this.hasMoved = false;
      this.isResized = false;
      return;
      label104:
      this._iconx = ((int)this.x + (this.cw - this._icon.getWidth() / 2));
      this._icony = ((int)this.y);
      this._text.x = ((int)this.x + (this.cw - this._text.cw));
      this._text.setY(this._icony + this._icon.getHeight() + 8);
    }
  }
  
  public int getFit()
  {
    return this._fit;
  }
  
  public Bitmap getIconOff()
  {
    return this._iconOff;
  }
  
  public Bitmap getIconOn()
  {
    return this._iconOn;
  }
  
  public Sound getSound()
  {
    return this._sound;
  }
  
  public boolean intersectPoint(int paramInt1, int paramInt2)
  {
    if (this._fit == 1) {
      return MathUtils.PtInRect((int)this.x - this.cw, (int)this.y - this.ch, (int)this.x + this.cw, (int)this.y + this.ch, paramInt1, paramInt2);
    }
    return super.intersectPoint(paramInt1, paramInt2);
  }
  
  public boolean isClicked()
  {
    return this._clicked;
  }
  
  public void onAction()
  {
    if (!this.enabled) {}
    do
    {
      do
      {
        return;
        this._clicked = false;
        if (this.focusClick)
        {
          this.focusClick = false;
          if (this._sound != null) {
            this._sound.play();
          }
          if (Game.opHaptic) {
            Game.vibrate(25L);
          }
          this._pressed = false;
          this._clicked = true;
          return;
        }
        if (this._pressed) {
          break;
        }
      } while ((!TouchScreen.eventDown) || (!intersectPoint(TouchScreen.x, TouchScreen.y)));
      this._pressed = true;
      this._icon = this._iconOn;
      update();
      return;
      if (TouchScreen.eventUp)
      {
        if (this._sound != null) {
          this._sound.play();
        }
        if (Game.opHaptic) {
          Game.vibrate(25L);
        }
        this._pressed = false;
        this._clicked = true;
        this._icon = this._iconOff;
        update();
        return;
      }
    } while ((!TouchScreen.pressed) || (intersectPoint(TouchScreen.x, TouchScreen.y)));
    this._pressed = false;
    this._icon = this._iconOff;
    update();
  }
  
  public boolean onClick()
  {
    return this._clicked;
  }
  
  protected void onDrawFocus()
  {
    Game.drawRect((int)this.x, (int)this.y, this.w, this.h, Debug.focusRect);
  }
  
  public void onRender()
  {
    update();
    if (!this.visible) {
      return;
    }
    if (this._fit == 1) {
      Game.drawBitmap(this._icon, this._iconx - this.cw, this._icony - this.ch, this.w, this.h);
    }
    for (;;)
    {
      if (this.selected) {
        onDrawFocus();
      }
      this._text.onRender();
      return;
      Game.drawBitmap(this._icon, this._iconx, this._icony);
    }
  }
  
  public void setFit(int paramInt)
  {
    this._fit = paramInt;
  }
  
  @Deprecated
  public void setIcon(int paramInt)
  {
    this._icon = getBitmap(paramInt);
    setIconOn(this._icon);
    setIconOff(this._icon);
    this.hasMoved = true;
  }
  
  public void setIcon(Bitmap paramBitmap)
  {
    this._icon = paramBitmap;
    setIconOn(this._icon);
    setIconOff(this._icon);
    this.hasMoved = true;
  }
  
  public void setIconOff(Bitmap paramBitmap)
  {
    this._iconOff = paramBitmap;
    this.hasMoved = true;
  }
  
  public void setIconOn(Bitmap paramBitmap)
  {
    this._iconOn = paramBitmap;
    this.hasMoved = true;
  }
  
  public void setSound(Sound paramSound)
  {
    this._sound = paramSound;
  }
  
  public void setText(int paramInt)
  {
    setText(Game.getResString(paramInt));
  }
  
  public void setText(String paramString)
  {
    this._text.setText(paramString);
    this.hasMoved = true;
  }
  
  public void setTextColor(int paramInt)
  {
    this._text.setColor(paramInt);
    this.hasMoved = true;
  }
  
  public void setTextSize(float paramFloat)
  {
    this._text.setSize(paramFloat);
    this.hasMoved = true;
  }
  
  public static class FIT
  {
    public static final int FIT_AUTO = 1;
    public static final int FIT_NONE = 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/ImageButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */