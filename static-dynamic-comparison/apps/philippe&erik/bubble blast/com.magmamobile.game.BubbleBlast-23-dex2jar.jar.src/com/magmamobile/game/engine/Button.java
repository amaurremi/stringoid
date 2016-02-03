package com.magmamobile.game.engine;

import android.graphics.Bitmap;
import android.graphics.Typeface;

public class Button
  extends GameObject
{
  public static final int ICON_BOTTOM = 8;
  public static final int ICON_CENTER = 0;
  public static final int ICON_CENTER_HORIZONTAL = 0;
  public static final int ICON_CENTER_VERTICAL = 0;
  public static final int ICON_LEFT = 1;
  public static final int ICON_RIGHT = 2;
  public static final int ICON_TOP = 4;
  protected int _bevelX;
  protected int _bevelY;
  protected int _iconAlign;
  protected int _iconOfsX;
  protected int _iconOfsY;
  protected int _iconPadding;
  protected boolean _iconTextAlign;
  protected Label _label;
  protected Sound _sound;
  protected Bitmap bmpDisabled;
  protected Bitmap bmpIcon;
  protected Bitmap bmpNormal;
  protected Bitmap bmpPressed;
  protected Bitmap bmpSelected;
  public boolean ninePatch;
  public boolean onClick;
  public boolean pressed;
  public boolean switchable;
  public boolean switched;
  
  public Button()
  {
    makeLabel(null, -1);
    this._iconTextAlign = true;
    this.switchable = false;
    this.switched = false;
    this.onClick = false;
    this.visible = true;
    this.enabled = true;
    this.ninePatch = true;
    this._sound = null;
    this._bevelX = Game.scalei(1);
    this._bevelY = Game.scalei(1);
  }
  
  public Button(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramString, paramBitmap1, paramBitmap2, paramBitmap3, paramBitmap4, null, getDefaultTextColor(), getDefaultSound());
  }
  
  public Button(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, int paramInt5)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramString, paramBitmap1, paramBitmap2, paramBitmap3, paramBitmap4, null, paramInt5, getDefaultSound());
  }
  
  public Button(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramString, paramBitmap1, paramBitmap2, paramBitmap3, paramBitmap4, paramBitmap5, getDefaultTextColor(), getDefaultSound());
  }
  
  public Button(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, int paramInt5)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramString, paramBitmap1, paramBitmap2, paramBitmap3, paramBitmap4, paramBitmap5, paramInt5, getDefaultSound());
  }
  
  public Button(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, int paramInt5, int paramInt6)
  {
    this._bevelX = Game.scalei(1);
    this._bevelY = Game.scalei(1);
    this._iconTextAlign = true;
    this.switchable = paramBoolean;
    this.switched = false;
    this.onClick = false;
    this.visible = true;
    this.enabled = true;
    this.ninePatch = true;
    this.bmpIcon = paramBitmap1;
    this.bmpNormal = paramBitmap2;
    this.bmpPressed = paramBitmap3;
    this.bmpSelected = paramBitmap4;
    if (paramInt6 != 0) {}
    for (paramBitmap1 = Game.getSound(paramInt6);; paramBitmap1 = null)
    {
      this._sound = paramBitmap1;
      makeLabel(paramString, paramInt5);
      paramInt5 = paramInt3;
      if (paramInt3 == Integer.MIN_VALUE) {
        paramInt5 = this._label.w + Game.scalei(20);
      }
      this.w = paramInt5;
      paramInt3 = paramInt4;
      if (paramInt4 == Integer.MIN_VALUE) {
        paramInt3 = this._label.h + Game.scalei(20);
      }
      this.h = paramInt3;
      this.cw = (this.w >> 1);
      this.ch = (this.h >> 1);
      paramInt3 = paramInt1;
      if (paramInt1 == Integer.MIN_VALUE) {
        paramInt3 = Game.centerX(this.w);
      }
      this.x = paramInt3;
      paramInt1 = paramInt2;
      if (paramInt2 == Integer.MIN_VALUE) {
        paramInt1 = Game.centerY(this.h);
      }
      this.y = paramInt1;
      setBackgrounds(paramBitmap2, paramBitmap4, paramBitmap3, paramBitmap5);
      computeTextOffsets();
      computeIconOffsets();
      return;
    }
  }
  
  private void computeIconOffsets()
  {
    int i;
    int j;
    if (this.bmpIcon != null)
    {
      i = this._iconAlign & 0x3;
      j = this._iconAlign >> 3 & 0x3;
      if (!this._iconTextAlign) {
        break label242;
      }
      switch (i)
      {
      default: 
        switch (j)
        {
        }
        break;
      }
    }
    for (;;)
    {
      if (this.pressed)
      {
        this._iconOfsX += this._bevelX;
        this._iconOfsY += this._bevelY;
      }
      return;
      this._iconOfsX = (this.w - this.bmpIcon.getWidth() >> 1);
      break;
      this._iconOfsX = (this.cw - this._label.cw - this.bmpIcon.getWidth() - this._iconPadding);
      break;
      this._iconOfsX = (this.cw + this._label.cw + this._iconPadding);
      break;
      this._iconOfsY = (this.h - this.bmpIcon.getHeight() >> 1);
      continue;
      this._iconOfsY = (this.h >> 1);
      continue;
      this._iconOfsY = (this.h >> 1);
      continue;
      label242:
      switch (i)
      {
      }
      for (;;)
      {
        switch (j)
        {
        default: 
          break;
        case 0: 
          this._iconOfsY = (this.h - this.bmpIcon.getHeight() >> 1);
          break;
          this._iconOfsX = (this.w - this.bmpIcon.getWidth() >> 1);
          continue;
          this._iconOfsX = this._iconPadding;
          continue;
          this._iconOfsX = (this.w - this.bmpIcon.getWidth() - this._iconPadding);
        }
      }
      this._iconOfsY = (this.h >> 1);
      continue;
      this._iconOfsY = (this.h >> 1);
    }
  }
  
  private void computeTextOffsets()
  {
    if (!this.pressed)
    {
      this._label.x = (this.x + this.cw - this._label.cw);
      this._label.y = (this.y + this.ch - this._label.ch);
      return;
    }
    this._label.x = (this.x + this.cw - this._label.cw + this._bevelX);
    this._label.y = (this.y + this.ch - this._label.ch + this._bevelY);
  }
  
  public static final GameArray<Button> createArray(int paramInt)
  {
    new GameArray(paramInt)
    {
      public Button[] createArray(int paramAnonymousInt)
      {
        return new Button[paramAnonymousInt];
      }
      
      public Button createObject()
      {
        return new Button();
      }
    };
  }
  
  private void drawBackGround(Bitmap paramBitmap)
  {
    if (this.ninePatch)
    {
      Game.drawBitmap9(paramBitmap, (int)this.x, (int)this.y, this.w, this.h, null);
      return;
    }
    Game.drawBitmap(paramBitmap, (int)this.x, (int)this.y);
  }
  
  @Deprecated
  public static final int getDefaultSound()
  {
    return Game.parameters.DEFAULT_BUTTON_SOUND;
  }
  
  @Deprecated
  public static final int getDefaultTextColor()
  {
    return Game.parameters.DEFAULT_BUTTON_TEXT_COLOR;
  }
  
  private void makeLabel(String paramString, int paramInt)
  {
    this._label = new Label();
    this._label.setText(paramString);
    this._label.setAutoSize(true);
    this._label.setColor(paramInt);
    this._label.setSize(Game.getParameters().DEFAULT_BUTTON_TEXT_SIZE);
  }
  
  @Deprecated
  public static final void setDefaultSound(int paramInt)
  {
    Game.parameters.DEFAULT_BUTTON_SOUND = paramInt;
  }
  
  @Deprecated
  public static final void setDefaultTextColor(int paramInt)
  {
    Game.parameters.DEFAULT_BUTTON_TEXT_COLOR = paramInt;
  }
  
  public int getBevel()
  {
    return this._bevelX;
  }
  
  public int getBevelY()
  {
    return this._bevelY;
  }
  
  public boolean getClickAndRelease()
  {
    boolean bool = this.onClick;
    this.onClick = false;
    return bool;
  }
  
  public Bitmap getIcon()
  {
    return this.bmpIcon;
  }
  
  public int getIconAlign()
  {
    return this._iconAlign;
  }
  
  public int getIconPadding()
  {
    return this._iconPadding;
  }
  
  public boolean getIconTextAlign()
  {
    return this._iconTextAlign;
  }
  
  public Label getLabel()
  {
    return this._label;
  }
  
  public Painter getPainter()
  {
    return this._label.getPainter();
  }
  
  public Sound getSound()
  {
    return this._sound;
  }
  
  public String getText()
  {
    return this._label.getText();
  }
  
  public int getTextColor()
  {
    return this._label.getColor();
  }
  
  public Typeface getTypeface()
  {
    return this._label.getTypeface();
  }
  
  public void onAction()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((!this.visible) || (!this.enabled)) {}
    label192:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            applyAnimation();
            this.onClick = false;
            if (!this.focusClick) {
              break;
            }
            this.focusClick = false;
            this.pressed = false;
            this.onClick = true;
          } while (!this.switchable);
          if (this.switched) {}
          for (;;)
          {
            this.switched = bool1;
            return;
            bool1 = true;
          }
          if (!this.pressed) {
            break label192;
          }
          if (!TouchScreen.eventUp) {
            break;
          }
          if (this._sound != null) {
            this._sound.play();
          }
          if (Game.opHaptic) {
            Game.vibrate(25L);
          }
          this.pressed = false;
          this.onClick = true;
          computeTextOffsets();
          computeIconOffsets();
        } while (!this.switchable);
        if (this.switched) {}
        for (bool1 = bool2;; bool1 = true)
        {
          this.switched = bool1;
          return;
        }
      } while ((!TouchScreen.pressed) || (intersectPoint(TouchScreen.x, TouchScreen.y)));
      this.pressed = false;
      computeTextOffsets();
      computeIconOffsets();
      return;
    } while ((!TouchScreen.eventDown) || (!intersectPoint(TouchScreen.x, TouchScreen.y)));
    this.pressed = true;
    computeTextOffsets();
    computeIconOffsets();
  }
  
  protected void onDrawFocus()
  {
    Game.drawRect((int)this.x, (int)this.y, this.w, this.h, Debug.focusRect);
  }
  
  public void onRender()
  {
    if (!this.visible) {
      return;
    }
    update();
    if (!this.enabled) {
      if (this.bmpDisabled != null) {
        drawBackGround(this.bmpDisabled);
      }
    }
    for (;;)
    {
      if (this.selected) {
        onDrawFocus();
      }
      if (this.bmpIcon != null) {
        Game.drawBitmap(this.bmpIcon, (int)this.x + this._iconOfsX, (int)this.y + this._iconOfsY);
      }
      if (this._label.getText() == null) {
        break;
      }
      this._label.onRender();
      return;
      if (this.pressed)
      {
        if (this.bmpPressed != null) {
          drawBackGround(this.bmpPressed);
        }
      }
      else if (this.switched)
      {
        if (this.bmpSelected != null) {
          drawBackGround(this.bmpSelected);
        }
      }
      else if (this.bmpNormal != null) {
        drawBackGround(this.bmpNormal);
      }
    }
  }
  
  public void setBackgrounds(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4)
  {
    this.bmpNormal = paramBitmap1;
    this.bmpPressed = paramBitmap3;
    this.bmpSelected = paramBitmap2;
    this.bmpDisabled = paramBitmap4;
    if (this.bmpSelected == null) {
      this.bmpSelected = this.bmpNormal;
    }
    if (this.bmpPressed == null) {
      this.bmpPressed = this.bmpNormal;
    }
    if (this.bmpDisabled == null) {
      this.bmpDisabled = this.bmpNormal;
    }
  }
  
  public void setBevelX(int paramInt)
  {
    this._bevelX = paramInt;
  }
  
  public void setBevelY(int paramInt)
  {
    this._bevelY = paramInt;
  }
  
  public void setIcon(Bitmap paramBitmap)
  {
    this.bmpIcon = paramBitmap;
    computeIconOffsets();
  }
  
  public void setIconAlign(int paramInt)
  {
    this._iconAlign = paramInt;
    computeIconOffsets();
  }
  
  public void setIconPadding(int paramInt)
  {
    this._iconPadding = paramInt;
    computeIconOffsets();
  }
  
  public void setIconTextAlign(boolean paramBoolean)
  {
    this._iconTextAlign = paramBoolean;
    computeIconOffsets();
  }
  
  public void setNinePatch(boolean paramBoolean)
  {
    this.ninePatch = paramBoolean;
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
    this._label.setText(paramString);
    computeTextOffsets();
    computeIconOffsets();
  }
  
  public void setTextColor(int paramInt)
  {
    this._label.setColor(paramInt);
  }
  
  public void setTextSize(float paramFloat)
  {
    this._label.setSize(paramFloat);
    computeTextOffsets();
    computeIconOffsets();
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    this._label.setTypeface(paramTypeface);
    computeTextOffsets();
    computeIconOffsets();
  }
  
  public void setVisible(boolean paramBoolean)
  {
    super.setVisible(paramBoolean);
    if (!paramBoolean) {
      this.onClick = false;
    }
  }
  
  public void update()
  {
    if ((this.hasMoved) || (this.isResized))
    {
      computeTextOffsets();
      computeIconOffsets();
      this.hasMoved = false;
      this.isResized = false;
    }
  }
  
  public boolean useNinePatch()
  {
    return this.ninePatch;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/Button.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */