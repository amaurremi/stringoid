package com.gtp.nextlauncher.widget.weatherwidget;

import android.content.Context;
import android.util.AttributeSet;
import com.go.gl.graphics.GLCanvas;
import com.go.gl.graphics.GLDrawable;
import com.go.gl.view.GLLinearLayout;
import com.go.gl.widget.GLImageView;

public class HourBottom
  extends GLLinearLayout
{
  private GLImageView a;
  private SizeAdapterTextView b;
  private SizeAdapterTextView c;
  private SizeAdapterTextView d;
  private final int e = 8;
  private GLDrawable[] f = new GLDrawable[8];
  private final int g = 2;
  private int[] h = { -1, 0, 1, -1, -1, -1, -1, -1 };
  private GLDrawable[] i = new GLDrawable[2];
  private String j;
  private GLDrawable k = null;
  
  public HourBottom(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    int n = 0;
    int m = 0;
    while (m < 8)
    {
      this.f[m] = p.a(paramContext, new int[] { 2130838176, 2130838170, 2130838156, 2130838160, 2130838168, 2130838162, 2130838166, 2130838174 }[m]);
      m += 1;
    }
    m = n;
    while (m < 2)
    {
      this.i[m] = p.a(paramContext, new int[] { 2130838172, 2130838158 }[m]);
      m += 1;
    }
  }
  
  public void cleanup()
  {
    int i1 = 0;
    int m = 0;
    int n;
    for (;;)
    {
      n = i1;
      if (m >= 8) {
        break;
      }
      this.f[m].clear();
      m += 1;
    }
    while (n < 2)
    {
      this.i[n].clear();
      n += 1;
    }
    super.cleanup();
  }
  
  public void clearData()
  {
    this.a.setImageDrawable(this.f[0]);
    this.k = this.f[0];
    this.d.setText("N/A");
    this.b.setText("N/A");
    this.j = "N/A";
    this.c.setText("N/A");
  }
  
  public void clearFouse()
  {
    this.b.setVisibility(0);
    this.a.setVisibility(0);
    this.c.setTextColor(16777215);
    this.d.setTextColor(-10790310);
  }
  
  protected void dispatchDraw(GLCanvas paramGLCanvas)
  {
    super.dispatchDraw(paramGLCanvas);
  }
  
  public void draw(GLCanvas paramGLCanvas)
  {
    super.draw(paramGLCanvas);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((GLImageView)findViewById(2131231203));
    this.b = ((SizeAdapterTextView)findViewById(2131230839));
    this.d = ((SizeAdapterTextView)findViewById(2131230840));
    this.a.setIsClearForUpdate(false);
    this.c = ((SizeAdapterTextView)findViewById(2131231684));
    this.c.setMaxTextSize(25);
    this.c.setTextColor(16777215);
    this.b.setMaxTextSize(18);
    this.d.setMaxTextSize(18);
  }
  
  public void setFoucse()
  {
    this.a.setVisibility(4);
    this.b.setVisibility(4);
    this.c.setVisibility(0);
    this.c.setText(this.j);
    this.c.setTextColor(-1);
    this.d.setTextColor(-1);
    this.c.invalidate();
  }
  
  public void setWeather(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    this.j = paramString1;
    this.b.setText(paramString1);
    this.c.setText(paramString1);
    this.d.setText(paramString2);
    if ((paramInt < 0) || (paramInt >= 8)) {
      return;
    }
    int n = 0;
    int m = n;
    if (paramBoolean)
    {
      int i1 = this.h[paramInt];
      m = n;
      if (i1 > -1) {
        if (this.k != null)
        {
          m = n;
          if (this.i[i1] == null) {}
        }
        else
        {
          this.k = this.i[i1];
          this.a.setImageDrawable(this.k);
          m = 1;
        }
      }
    }
    if ((m == 0) && ((this.k == null) || (this.f[paramInt] != null)))
    {
      this.k = this.f[paramInt];
      this.a.setImageDrawable(this.k);
    }
    invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/HourBottom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */