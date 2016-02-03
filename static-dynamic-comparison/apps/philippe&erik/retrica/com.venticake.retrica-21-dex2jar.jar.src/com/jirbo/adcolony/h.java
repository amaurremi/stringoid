package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;

class h
  extends View
{
  static double o;
  static String p = "";
  static String q = "";
  static boolean r = true;
  static Paint s = new Paint(1);
  static float[] t = new float[80];
  int A;
  int B;
  int C;
  int D;
  String E;
  AdColonyV4VCAd F;
  ADCImage a;
  ADCImage b;
  ADCImage c;
  ADCImage d;
  ADCImage e;
  ADCImage f;
  ADCImage g;
  ADCImage h;
  double i = 2.8D;
  double j = 2.05D;
  double k = 1.3D;
  double l = 2.5D;
  double m = 1.5D;
  boolean n;
  AdColonyInterstitialAd u;
  long v = System.currentTimeMillis();
  int w;
  int x;
  int y;
  int z;
  
  h()
  {
    super(a.b());
  }
  
  public h(String paramString, int paramInt, AdColonyInterstitialAd paramAdColonyInterstitialAd)
  {
    super(AdColony.activity());
    this.E = paramString;
    this.D = paramInt;
    this.u = paramAdColonyInterstitialAd;
    if (!a()) {
      return;
    }
    AdColony.activity().addContentView(this, new FrameLayout.LayoutParams(-1, -1, 17));
  }
  
  int a(String paramString)
  {
    s.getTextWidths(paramString, t);
    float f1 = 0.0F;
    int i2 = paramString.length();
    int i1 = 0;
    while (i1 < i2)
    {
      f1 += t[i1];
      i1 += 1;
    }
    return (int)f1;
  }
  
  void a(String paramString, int paramInt1, int paramInt2, Canvas paramCanvas)
  {
    paramInt1 -= a(paramString) / 2;
    s.setColor(-986896);
    paramCanvas.drawText(paramString, paramInt1 + 1, paramInt2 + 1, s);
    s.setColor(-8355712);
    paramCanvas.drawText(paramString, paramInt1, paramInt2, s);
  }
  
  void a(String paramString1, String paramString2)
  {
    int i1 = a(paramString1);
    p = "";
    q = "";
    if (i1 > this.a.f - a("WW") - a(paramString2))
    {
      r = false;
      int i3 = 0;
      String str = "";
      for (i1 = 0; i1 < this.a.f - a("WW") - a(paramString2); i1 = a(str))
      {
        str = str + paramString1.charAt(i3);
        i3 += 1;
      }
      i1 = 0;
      int i2 = 0;
      while (i1 < i3) {
        if ((str.charAt(i1) == ' ') && (i1 >= 5))
        {
          p = paramString1.substring(0, i1);
          i2 = i1;
          i1 += 1;
        }
        else
        {
          if (i2 < 5) {}
          for (paramString2 = paramString1.substring(0, i3);; paramString2 = p)
          {
            p = paramString2;
            break;
          }
        }
      }
      if (i2 < 5) {}
      for (paramString1 = paramString1.substring(i3);; paramString1 = paramString1.substring(i2))
      {
        q = paramString1;
        return;
      }
    }
    r = true;
    p = paramString1;
    q = "";
  }
  
  public boolean a()
  {
    double d3 = 2.5D;
    double d2 = 0.8D;
    if (this.a != null) {
      return true;
    }
    this.a = new ADCImage(a.j("pre_popup_bg"));
    this.b = new ADCImage(a.j("v4vc_logo"));
    this.c = new ADCImage(a.j("yes_button_normal"));
    this.d = new ADCImage(a.j("yes_button_down"));
    this.e = new ADCImage(a.j("no_button_normal"));
    this.f = new ADCImage(a.j("no_button_down"));
    this.h = new ADCImage(a.j("done_button_normal"));
    this.g = new ADCImage(a.j("done_button_down"));
    Display localDisplay = a.b().getWindowManager().getDefaultDisplay();
    int i1 = localDisplay.getWidth();
    int i2 = localDisplay.getHeight();
    double d1;
    if (i2 > i1)
    {
      d1 = (i2 - i1) / 360.0D;
      if ((d1 < 0.8D) && (!a.m)) {
        this.n = true;
      }
      if (d1 <= 2.5D) {
        break label441;
      }
      d1 = d3;
    }
    label441:
    for (;;)
    {
      if (d1 < 0.8D) {
        if (a.m) {
          d1 = d2;
        }
      }
      for (;;)
      {
        o = d1;
        if (this.n)
        {
          this.i = 2.6D;
          this.j = 1.8D;
          this.k = 1.0D;
          this.l = 2.2D;
          this.m = 1.2D;
        }
        this.a.a(d1 / 1.8D);
        this.b.a(d1 / 1.8D);
        this.d.a(d1 / 1.8D);
        this.f.a(d1 / 1.8D);
        this.c.a(d1 / 1.8D);
        this.e.a(d1 / 1.8D);
        this.g.a(d1 / 1.8D);
        this.h.a(d1 / 1.8D);
        s.setTextSize((float)(18.0D * d1));
        if (this.n) {
          s.setTextSize((float)(d1 * 9.0D));
        }
        s.setFakeBoldText(true);
        return true;
        d1 = (i1 - i2) / 360.0D;
        break;
        d1 = 1.7D;
      }
    }
  }
  
  boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 < paramInt3) {}
    while ((paramInt2 < paramInt4) || (paramInt1 >= this.c.f + paramInt3) || (paramInt2 >= this.c.g + paramInt4)) {
      return false;
    }
    return true;
  }
  
  int b()
  {
    return (int)s.getTextSize();
  }
  
  void b(String paramString, int paramInt1, int paramInt2, Canvas paramCanvas)
  {
    paramInt1 -= a(paramString) / 2;
    s.setColor(-8355712);
    paramCanvas.drawText(paramString, paramInt1 + 2, paramInt2 + 2, s);
    s.setColor(-1);
    paramCanvas.drawText(paramString, paramInt1, paramInt2, s);
  }
  
  void c()
  {
    if (this.n) {}
    for (double d1 = 12.0D;; d1 = 16.0D)
    {
      Display localDisplay = a.b().getWindowManager().getDefaultDisplay();
      int i1 = localDisplay.getWidth();
      int i2 = localDisplay.getHeight();
      this.w = ((i1 - this.a.f) / 2);
      this.x = ((i2 - this.a.g) / 2 - 80);
      this.y = (this.w + this.a.f / 2);
      this.z = (this.x + this.a.g / 2);
      this.C = (this.x + (int)(this.a.g - (this.c.g + o * d1)));
      this.A = (this.w + (int)(o * d1));
      i1 = this.w;
      double d2 = this.a.f;
      double d3 = this.c.f;
      this.B = ((int)(d2 - (d1 * o + d3)) + i1);
      return;
    }
  }
  
  void c(String paramString, int paramInt1, int paramInt2, Canvas paramCanvas)
  {
    b(paramString, this.c.f / 2 + paramInt1, this.c.g / 2 + paramInt2 + b() * 4 / 10, paramCanvas);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */