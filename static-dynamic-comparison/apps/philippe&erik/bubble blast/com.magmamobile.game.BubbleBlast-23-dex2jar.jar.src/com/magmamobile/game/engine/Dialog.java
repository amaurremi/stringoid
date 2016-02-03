package com.magmamobile.game.engine;

import android.graphics.Bitmap;
import android.graphics.Paint;

public class Dialog
  extends GameObject
{
  public static final int BUTTON1 = 1;
  public static final int BUTTON2 = 2;
  public static final int NONE = 0;
  private Bitmap background;
  private Button btn1;
  private Button btn2;
  private int clicked;
  private Label label = new Label();
  private Paint shadow;
  
  public Dialog(String paramString1, String paramString2, String paramString3, boolean paramBoolean, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    this.label.setMinWidth(Game.mBufferCW);
    this.label.setAutoSize(true);
    this.label.setText(paramString1);
    this.label.setColor(-1);
    this.background = paramBitmap1;
    if (paramBoolean)
    {
      this.shadow = new Paint();
      this.shadow.setColor(Integer.MIN_VALUE);
    }
    computeSize();
    if (paramString2 != null) {
      this.btn1 = new Button(0, 0, 0, 0, false, paramString2, null, paramBitmap2, paramBitmap3, null, null);
    }
    if (paramString3 != null) {
      this.btn2 = new Button(0, 0, 0, 0, false, paramString3, null, paramBitmap2, paramBitmap3, null, null);
    }
  }
  
  public void computeSize()
  {
    int i = 0;
    int j = this.label.h;
    if ((this.btn1 != null) || (this.btn2 != null)) {
      i = 60;
    }
    this.w = (this.label.w + 40);
    this.h = (j + 40 + i);
    this.cw = (this.w >> 1);
    this.ch = (this.h >> 1);
    this.x = (Game.mBufferWidth - this.w >> 1);
    this.y = (Game.mBufferHeight - this.h >> 1);
    if (this.btn1 != null)
    {
      if (this.btn2 != null) {
        break label265;
      }
      this.btn1.setW(MathUtils.maxi(this.cw - 20, 48));
      this.btn1.setX((int)this.x + (this.cw - this.btn1.cw));
    }
    for (;;)
    {
      this.btn1.setY((int)this.y + j + 40);
      this.btn1.setH(i - 20);
      if (this.btn2 != null)
      {
        this.btn2.setX((int)this.x + this.cw + 5);
        this.btn2.setY((int)this.y + j + 40);
        this.btn2.setW(MathUtils.maxi(this.cw - 20, 48));
        this.btn2.setH(i - 20);
      }
      return;
      label265:
      this.btn1.setX((int)this.x + 15);
      this.btn1.setW(MathUtils.maxi(this.cw - 20, 48));
    }
  }
  
  public final void dissmiss()
  {
    this.enabled = false;
    this.visible = false;
    this.clicked = 0;
  }
  
  public Button getButton(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return this.btn1;
    }
    return this.btn2;
  }
  
  public Label getLabel()
  {
    return this.label;
  }
  
  public final int getResult()
  {
    return this.clicked;
  }
  
  public String getText()
  {
    return this.label.getText();
  }
  
  public void onAction()
  {
    if (!this.enabled) {}
    do
    {
      do
      {
        return;
        this.clicked = 0;
        if (this.btn1 != null)
        {
          this.btn1.onAction();
          if (this.btn1.onClick)
          {
            this.clicked = 1;
            this.visible = false;
            this.enabled = false;
            return;
          }
        }
      } while (this.btn2 == null);
      this.btn2.onAction();
    } while (!this.btn2.onClick);
    this.clicked = 2;
    this.visible = false;
    this.enabled = false;
  }
  
  public void onRender()
  {
    if ((!this.visible) || (!this.enabled)) {}
    do
    {
      return;
      if (this.shadow != null) {
        Game.drawPaint(this.shadow);
      }
      if (this.background != null) {
        Game.drawBitmap9(this.background, (int)this.x, (int)this.y, this.w, this.h, null);
      }
      if (this.label != null)
      {
        this.label.x = (this.x + (this.cw - this.label.cw));
        this.label.y = (this.y + 20.0F);
        this.label.onRender();
      }
      if (this.btn1 != null) {
        this.btn1.onRender();
      }
    } while (this.btn2 == null);
    this.btn2.onRender();
  }
  
  public void setText(String paramString)
  {
    this.label.setText(paramString);
  }
  
  public final void show()
  {
    computeSize();
    this.enabled = true;
    this.visible = true;
    this.clicked = 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/Dialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */