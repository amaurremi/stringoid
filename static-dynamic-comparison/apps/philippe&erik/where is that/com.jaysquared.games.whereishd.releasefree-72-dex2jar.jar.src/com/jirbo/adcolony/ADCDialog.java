package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;

class ADCDialog
  extends View
{
  static String amount_line_1 = "";
  static String amount_line_2 = "";
  static boolean one_line = true;
  static double scale;
  static Paint text_paint = new Paint(1);
  static float[] widths = new float[80];
  AdColonyVideoAd ad;
  String amount;
  int button_x1;
  int button_x2;
  int button_y;
  int center_x;
  int center_y;
  int dialog_type;
  ADCImage img_bg;
  ADCImage img_cancel_down;
  ADCImage img_cancel_normal;
  ADCImage img_confirm_down;
  ADCImage img_confirm_normal;
  ADCImage img_done_down;
  ADCImage img_done_normal;
  ADCImage img_logo;
  int left_x;
  AdColonyV4VCAd listener;
  long start_ms = System.currentTimeMillis();
  int top_y;
  
  ADCDialog()
  {
    super(ADC.activity());
  }
  
  public ADCDialog(String paramString, int paramInt, AdColonyVideoAd paramAdColonyVideoAd)
  {
    super(AdColony.activity());
    this.amount = paramString;
    this.dialog_type = paramInt;
    this.ad = paramAdColonyVideoAd;
    if (!isReady()) {
      return;
    }
    AdColony.activity().addContentView(this, new FrameLayout.LayoutParams(-1, -1, 17));
  }
  
  boolean buttonContains(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 < paramInt3) {}
    while ((paramInt2 < paramInt4) || (paramInt1 >= this.img_confirm_normal.width + paramInt3) || (paramInt2 >= this.img_confirm_normal.height + paramInt4)) {
      return false;
    }
    return true;
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
    this.button_y = (this.top_y + (int)(this.img_bg.height - (this.img_confirm_normal.height + scale * 16.0D)));
    this.button_x1 = (this.left_x + (int)(scale * 16.0D));
    this.button_x2 = (this.left_x + (int)(this.img_bg.width - (this.img_confirm_normal.width + scale * 16.0D)));
  }
  
  void drawButtonText(String paramString, int paramInt1, int paramInt2, Canvas paramCanvas)
  {
    drawShadowText(paramString, paramInt1 + this.img_confirm_normal.width / 2, paramInt2 + this.img_confirm_normal.height / 2 + fontHeight() * 4 / 10, paramCanvas);
  }
  
  void drawEmbossedText(String paramString, int paramInt1, int paramInt2, Canvas paramCanvas)
  {
    paramInt1 -= textWidthOf(paramString) / 2;
    text_paint.setColor(-986896);
    paramCanvas.drawText(paramString, paramInt1 + 1, paramInt2 + 1, text_paint);
    text_paint.setColor(-8355712);
    paramCanvas.drawText(paramString, paramInt1, paramInt2, text_paint);
  }
  
  void drawShadowText(String paramString, int paramInt1, int paramInt2, Canvas paramCanvas)
  {
    paramInt1 -= textWidthOf(paramString) / 2;
    text_paint.setColor(-8355712);
    paramCanvas.drawText(paramString, paramInt1 + 2, paramInt2 + 2, text_paint);
    text_paint.setColor(-1);
    paramCanvas.drawText(paramString, paramInt1, paramInt2, text_paint);
  }
  
  int fontHeight()
  {
    return (int)text_paint.getTextSize();
  }
  
  public boolean isReady()
  {
    if (this.img_bg != null) {
      return true;
    }
    this.img_bg = new ADCImage(ADC.get_String("pre_popup_bg"));
    this.img_logo = new ADCImage(ADC.get_String("v4vc_logo"));
    this.img_confirm_normal = new ADCImage(ADC.get_String("yes_button_normal"));
    this.img_confirm_down = new ADCImage(ADC.get_String("yes_button_down"));
    this.img_cancel_normal = new ADCImage(ADC.get_String("no_button_normal"));
    this.img_cancel_down = new ADCImage(ADC.get_String("no_button_down"));
    this.img_done_normal = new ADCImage(ADC.get_String("done_button_normal"));
    this.img_done_down = new ADCImage(ADC.get_String("done_button_down"));
    Display localDisplay = ADC.activity().getWindowManager().getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    if (j > i) {}
    for (double d2 = (j - i) / 360.0D;; d2 = (i - j) / 360.0D)
    {
      double d1 = d2;
      if (d2 > 2.5D) {
        d1 = 2.5D;
      }
      d2 = d1;
      if (d1 < 0.8D) {
        d2 = 0.8D;
      }
      scale = d2;
      this.img_bg.resize(d2 / 1.8D);
      this.img_logo.resize(d2 / 1.8D);
      this.img_confirm_down.resize(d2 / 1.8D);
      this.img_cancel_down.resize(d2 / 1.8D);
      this.img_confirm_normal.resize(d2 / 1.8D);
      this.img_cancel_normal.resize(d2 / 1.8D);
      this.img_done_down.resize(d2 / 1.8D);
      this.img_done_normal.resize(d2 / 1.8D);
      text_paint.setTextSize((float)(18.0D * d2));
      text_paint.setFakeBoldText(true);
      return true;
    }
  }
  
  void splitLine(String paramString1, String paramString2)
  {
    int i = textWidthOf(paramString1);
    amount_line_1 = "";
    amount_line_2 = "";
    String str = "";
    if (i > this.img_bg.width - textWidthOf("WW") - textWidthOf(paramString2))
    {
      int k = 0;
      int j = 0;
      one_line = false;
      for (i = 0; i < this.img_bg.width - textWidthOf("WW") - textWidthOf(paramString2); i = textWidthOf(str))
      {
        str = str + paramString1.charAt(j);
        j += 1;
      }
      i = 0;
      while (i < j) {
        if ((str.charAt(i) == ' ') && (i >= 5))
        {
          k = i;
          amount_line_1 = paramString1.substring(0, k);
          i += 1;
        }
        else
        {
          if (k < 5) {}
          for (paramString2 = paramString1.substring(0, j);; paramString2 = amount_line_1)
          {
            amount_line_1 = paramString2;
            break;
          }
        }
      }
      if (k < 5) {}
      for (paramString1 = paramString1.substring(j);; paramString1 = paramString1.substring(k))
      {
        amount_line_2 = paramString1;
        return;
      }
    }
    one_line = true;
    amount_line_1 = paramString1;
    amount_line_2 = "";
  }
  
  int textWidthOf(String paramString)
  {
    text_paint.getTextWidths(paramString, widths);
    float f = 0.0F;
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      f += widths[i];
      i += 1;
    }
    return (int)f;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */