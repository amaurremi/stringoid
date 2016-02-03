package com.jirbo.adcolony;

import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;

class ADCSkipVideoDialog
  extends ADCDialog
{
  static ADCSkipVideoDialog current;
  static boolean skip_dialog;
  boolean cancel_down;
  boolean confirm_down;
  ADCVideo video;
  
  public ADCSkipVideoDialog(ADCVideo paramADCVideo, AdColonyV4VCAd paramAdColonyV4VCAd)
  {
    this.video = paramADCVideo;
    this.listener = paramAdColonyV4VCAd;
    paramADCVideo.video_view.pause();
    current = this;
    if (!isReady()) {}
  }
  
  void calculatePosition()
  {
    int i = this.video.display_width;
    int j = this.video.display_height;
    this.left_x = ((i - this.img_bg.width) / 2);
    this.top_y = ((j - this.img_bg.height) / 2);
    this.center_x = (this.left_x + this.img_bg.width / 2);
    this.center_y = (this.top_y + this.img_bg.height / 2);
    this.button_y = (this.top_y + (int)(this.img_bg.height - (this.img_confirm_normal.height + scale * 16.0D)));
    this.button_x1 = (this.left_x + (int)(scale * 16.0D));
    this.button_x2 = (this.left_x + (int)(this.img_bg.width - (this.img_confirm_normal.width + scale * 16.0D)));
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.video.video_view == null) {
      return;
    }
    skip_dialog = true;
    calculatePosition();
    int j = (int)(System.currentTimeMillis() - this.start_ms) * 255 / 1000;
    int i = j;
    if (j > 128) {
      i = 128;
    }
    paramCanvas.drawARGB(i, 0, 0, 0);
    this.img_bg.draw(paramCanvas, this.left_x, this.top_y);
    i = fontHeight() * 3 / 2;
    drawEmbossedText("Completion is required to receive", this.center_x, (int)(this.center_y - i * 2.75D), paramCanvas);
    drawEmbossedText("your reward.", this.center_x, this.center_y - i * 2, paramCanvas);
    drawEmbossedText("Are you sure you want to skip?", this.center_x, (int)(this.center_y - i * 1.25D), paramCanvas);
    this.img_logo.draw(paramCanvas, this.center_x - this.img_logo.width / 2, this.center_y - this.img_logo.height / 2);
    if (!this.confirm_down)
    {
      this.img_confirm_normal.draw(paramCanvas, this.button_x1, this.button_y);
      if (this.cancel_down) {
        break label282;
      }
      this.img_cancel_normal.draw(paramCanvas, this.button_x2, this.button_y);
    }
    for (;;)
    {
      drawButtonText("Yes", this.button_x1, this.button_y, paramCanvas);
      drawButtonText("No", this.button_x2, this.button_y, paramCanvas);
      return;
      this.img_confirm_down.draw(paramCanvas, this.button_x1, this.button_y);
      break;
      label282:
      this.img_cancel_down.draw(paramCanvas, this.button_x2, this.button_y);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.video.video_view == null) {}
    while (paramInt != 4) {
      return false;
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    ADCVideo localADCVideo = this.video;
    boolean bool1;
    if (ADCVideo.video_finished)
    {
      current = null;
      bool1 = this.video.hud.onTouchEvent(paramMotionEvent);
    }
    int i;
    int j;
    label157:
    label202:
    do
    {
      return bool1;
      i = (int)paramMotionEvent.getX();
      j = (int)paramMotionEvent.getY();
      if (paramMotionEvent.getAction() == 1)
      {
        if ((!buttonContains(i, j, this.button_x1, this.button_y)) || (!this.confirm_down)) {
          break label157;
        }
        current = null;
        skip_dialog = false;
        ADC.show_post_popup = false;
        ADC.end_card_finished_handler.notify_canceled();
        this.video.finish();
      }
      for (;;)
      {
        this.confirm_down = false;
        this.cancel_down = false;
        invalidate();
        bool1 = bool2;
        if (paramMotionEvent.getAction() != 0) {
          break;
        }
        if (!buttonContains(i, j, this.button_x1, this.button_y)) {
          break label202;
        }
        this.confirm_down = true;
        invalidate();
        return true;
        if ((buttonContains(i, j, this.button_x2, this.button_y)) && (this.cancel_down))
        {
          current = null;
          skip_dialog = false;
          this.video.video_view.start();
        }
      }
      bool1 = bool2;
    } while (!buttonContains(i, j, this.button_x2, this.button_y));
    this.cancel_down = true;
    invalidate();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCSkipVideoDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */