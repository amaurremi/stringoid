package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import java.util.ArrayList;

class ADCV4VCResultsDialog
  extends ADCDialog
{
  boolean done_down;
  
  public ADCV4VCResultsDialog(String paramString, AdColonyV4VCAd paramAdColonyV4VCAd)
  {
    this.amount = paramString;
    this.listener = paramAdColonyV4VCAd;
    if (!isReady()) {
      return;
    }
    AdColony.activity().addContentView(this, new FrameLayout.LayoutParams(-1, -1, 17));
  }
  
  void calculatePosition()
  {
    Display localDisplay = ADC.activity().getWindowManager().getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    this.left_x = ((i - this.img_bg.width) / 2);
    this.top_y = ((j - this.img_bg.height) / 2 - 80);
    this.center_x = (this.left_x + this.img_bg.width / 2);
    this.center_y = (this.top_y + this.img_bg.height / 2);
    this.button_y = (this.top_y + (int)(this.img_bg.height - (this.img_done_normal.height + scale * 16.0D)));
    this.button_x1 = (this.center_x - this.img_done_normal.width / 2);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    calculatePosition();
    int j = (int)(System.currentTimeMillis() - this.start_ms) * 255 / 1000;
    int i = j;
    if (j > 128) {
      i = 128;
    }
    paramCanvas.drawARGB(i, 0, 0, 0);
    this.img_bg.draw(paramCanvas, this.left_x, this.top_y);
    j = fontHeight() * 3 / 2;
    int k = this.listener.getRemainingViewsUntilReward();
    if ((k == this.listener.getViewsPerReward()) || (k == 0))
    {
      splitLine(this.amount, "video. You earned");
      if (one_line)
      {
        drawEmbossedText("Thanks for watching the sponsored", this.center_x, (int)(this.center_y - j * 2.5D), paramCanvas);
        drawEmbossedText("video. You earned " + amount_line_1 + ".", this.center_x, (int)(this.center_y - j * 1.5D), paramCanvas);
        this.img_logo.draw(paramCanvas, this.center_x - this.img_logo.width / 2, this.center_y - this.img_logo.height / 2);
        if (this.done_down) {
          break label658;
        }
        this.img_done_normal.draw(paramCanvas, this.button_x1, this.button_y);
      }
    }
    for (;;)
    {
      drawButtonText("Ok", this.button_x1, this.button_y, paramCanvas);
      if (i != 128) {
        invalidate();
      }
      return;
      drawEmbossedText("Thanks for watching the sponsored", this.center_x, (int)(this.center_y - j * 2.8D), paramCanvas);
      drawEmbossedText("video. You earned " + amount_line_1, this.center_x, (int)(this.center_y - j * 2.05D), paramCanvas);
      drawEmbossedText(amount_line_2 + ".", this.center_x, (int)(this.center_y - j * 1.3D), paramCanvas);
      break;
      splitLine(this.amount, "to earn ");
      if (k == 1) {}
      for (String str = "video";; str = "videos")
      {
        if (!one_line) {
          break label517;
        }
        drawEmbossedText("Thank you. Watch " + k + " more " + str, this.center_x, (int)(this.center_y - j * 2.5D), paramCanvas);
        drawEmbossedText("to earn " + amount_line_1 + ".", this.center_x, (int)(this.center_y - j * 1.5D), paramCanvas);
        break;
      }
      label517:
      drawEmbossedText("Thank you. Watch " + k + " more " + str, this.center_x, (int)(this.center_y - j * 2.8D), paramCanvas);
      drawEmbossedText("to earn " + amount_line_1, this.center_x, (int)(this.center_y - j * 2.05D), paramCanvas);
      drawEmbossedText(amount_line_2 + ".", this.center_x, (int)(this.center_y - j * 1.3D), paramCanvas);
      break;
      label658:
      this.img_done_down.draw(paramCanvas, this.button_x1, this.button_y);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if (paramMotionEvent.getAction() == 1)
    {
      if ((buttonContains(j, k, this.button_x1, this.button_y)) && (this.done_down))
      {
        ADC.current_dialog = null;
        ((ViewGroup)getParent()).removeView(this);
        int i = 0;
        while (i < ADC.bitmaps.size())
        {
          ((Bitmap)ADC.bitmaps.get(i)).recycle();
          i += 1;
        }
        ADC.bitmaps.clear();
        ADC.show = true;
      }
      this.done_down = false;
      invalidate();
    }
    if ((paramMotionEvent.getAction() == 0) && (buttonContains(j, k, this.button_x1, this.button_y)))
    {
      this.done_down = true;
      invalidate();
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCV4VCResultsDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */