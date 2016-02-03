package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import java.util.ArrayList;

class ADCV4VCConfirmationDialog
  extends ADCDialog
{
  boolean cancel_down;
  boolean confirm_down;
  
  public ADCV4VCConfirmationDialog(String paramString, AdColonyV4VCAd paramAdColonyV4VCAd)
  {
    this.amount = paramString;
    this.listener = paramAdColonyV4VCAd;
    if (!isReady()) {
      return;
    }
    AdColony.activity().addContentView(this, new FrameLayout.LayoutParams(-1, -1, 17));
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
    if (this.listener.getViewsPerReward() == 1)
    {
      splitLine(this.amount, "");
      if (!one_line)
      {
        drawEmbossedText("Watch a video to earn", this.center_x, (int)(this.center_y - j * 2.8D), paramCanvas);
        drawEmbossedText(amount_line_1, this.center_x, (int)(this.center_y - j * 2.05D), paramCanvas);
        drawEmbossedText(amount_line_2 + ".", this.center_x, (int)(this.center_y - j * 1.3D), paramCanvas);
        this.img_logo.draw(paramCanvas, this.center_x - this.img_logo.width / 2, this.center_y - this.img_logo.height / 2);
        if (this.confirm_down) {
          break label684;
        }
        this.img_confirm_normal.draw(paramCanvas, this.button_x1, this.button_y);
        label255:
        if (this.cancel_down) {
          break label703;
        }
        this.img_cancel_normal.draw(paramCanvas, this.button_x2, this.button_y);
      }
    }
    for (;;)
    {
      drawButtonText("Yes", this.button_x1, this.button_y, paramCanvas);
      drawButtonText("No", this.button_x2, this.button_y, paramCanvas);
      if (i != 128) {
        invalidate();
      }
      return;
      drawEmbossedText("Watch a video to earn", this.center_x, (int)(this.center_y - j * 2.5D), paramCanvas);
      drawEmbossedText(amount_line_1 + ".", this.center_x, (int)(this.center_y - j * 1.5D), paramCanvas);
      break;
      if (k == 1) {}
      for (String str = "video";; str = "videos")
      {
        splitLine(this.amount, "" + k + " more " + str + " to earn )?");
        if (one_line) {
          break label589;
        }
        drawEmbossedText("Watch a sponsored video now (Only", this.center_x, (int)(this.center_y - j * 2.8D), paramCanvas);
        drawEmbossedText("" + k + " more " + str + " to earn " + amount_line_1, this.center_x, (int)(this.center_y - j * 2.05D), paramCanvas);
        drawEmbossedText(amount_line_2 + ")?", this.center_x, (int)(this.center_y - j * 1.3D), paramCanvas);
        break;
      }
      label589:
      drawEmbossedText("Watch a sponsored video now (Only", this.center_x, (int)(this.center_y - j * 2.5D), paramCanvas);
      drawEmbossedText("" + k + " more " + str + " to earn " + amount_line_1 + ")?", this.center_x, (int)(this.center_y - j * 1.5D), paramCanvas);
      break;
      label684:
      this.img_confirm_down.draw(paramCanvas, this.button_x1, this.button_y);
      break label255;
      label703:
      this.img_cancel_down.draw(paramCanvas, this.button_x2, this.button_y);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if (paramMotionEvent.getAction() == 1)
    {
      if ((buttonContains(j, k, this.button_x1, this.button_y)) && (this.confirm_down))
      {
        ADC.current_dialog = null;
        ((ViewGroup)getParent()).removeView(this);
        this.listener.on_dialog_finished(true);
        this.cancel_down = false;
        this.confirm_down = false;
        invalidate();
      }
    }
    else if (paramMotionEvent.getAction() == 0)
    {
      if (!buttonContains(j, k, this.button_x1, this.button_y)) {
        break label212;
      }
      this.confirm_down = true;
      invalidate();
    }
    label212:
    while (!buttonContains(j, k, this.button_x2, this.button_y))
    {
      return true;
      if ((!buttonContains(j, k, this.button_x2, this.button_y)) || (!this.cancel_down)) {
        break;
      }
      ADC.current_dialog = null;
      ((ViewGroup)getParent()).removeView(this);
      this.listener.on_dialog_finished(false);
      ADC.show = true;
      int i = 0;
      while (i < ADC.bitmaps.size())
      {
        ((Bitmap)ADC.bitmaps.get(i)).recycle();
        i += 1;
      }
      ADC.bitmaps.clear();
      break;
    }
    this.cancel_down = true;
    invalidate();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCV4VCConfirmationDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */