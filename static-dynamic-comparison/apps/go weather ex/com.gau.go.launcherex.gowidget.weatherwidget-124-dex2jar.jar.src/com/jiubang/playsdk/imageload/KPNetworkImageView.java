package com.jiubang.playsdk.imageload;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

public class KPNetworkImageView
  extends ImageView
{
  private String a;
  private int b;
  private int c;
  private d d;
  private j e;
  private boolean f;
  private boolean g;
  private boolean h = true;
  private o i;
  
  public KPNetworkImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public KPNetworkImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public KPNetworkImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    if (this.b != 0) {
      setImageResource(this.b);
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      bool = false;
      if (this.i != null) {
        bool = this.i.a(paramBitmap);
      }
      if (!bool) {
        setImageBitmap(paramBitmap);
      }
    }
    while (this.b == 0)
    {
      boolean bool;
      return;
    }
    setImageResource(this.b);
  }
  
  private void b(boolean paramBoolean)
  {
    int k = getWidth();
    int m = getHeight();
    int j;
    if ((getLayoutParams() != null) && (getLayoutParams().height == -2) && (getLayoutParams().width == -2))
    {
      j = 1;
      if ((k != 0) || (m != 0) || (j != 0)) {
        break label63;
      }
    }
    label63:
    do
    {
      return;
      j = 0;
      break;
      if ((TextUtils.isEmpty(this.a)) || (this.d == null) || (Uri.parse(this.a).getHost() == null))
      {
        if (this.e != null)
        {
          this.e.a();
          this.e = null;
        }
        a();
        return;
      }
      if ((this.e == null) || (this.e.c() == null)) {
        break label162;
      }
    } while (this.e.c().equals(this.a));
    this.e.a();
    a();
    label162:
    if (this.h) {}
    for (j localj = this.d.a(this.a, new l(this), k, m, this.f, this.g);; localj = this.d.a(this.a, new m(this, paramBoolean), this.f, this.g))
    {
      this.e = localj;
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(o paramo)
  {
    this.i = paramo;
  }
  
  public void a(String paramString)
  {
    a(paramString, c.a().b(), true, true);
  }
  
  public void a(String paramString, d paramd, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramString;
    this.d = paramd;
    this.f = paramBoolean1;
    this.g = paramBoolean2;
    b(false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    invalidate();
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.e != null)
    {
      this.e.a();
      setImageBitmap(null);
      this.e = null;
    }
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    b(true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/imageload/KPNetworkImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */