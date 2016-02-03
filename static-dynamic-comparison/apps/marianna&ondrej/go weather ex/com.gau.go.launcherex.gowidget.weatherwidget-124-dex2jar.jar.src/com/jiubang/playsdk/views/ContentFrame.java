package com.jiubang.playsdk.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.jiubang.playsdk.g;
import com.jiubang.playsdk.k;

public class ContentFrame
  extends FrameLayout
{
  private ViewGroup a;
  private final LayoutInflater b;
  
  public ContentFrame(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ContentFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContentFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, k.a);
    this.b = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    paramContext = this.b.inflate(g.C, this, false);
    ((FrameLayout.LayoutParams)paramContext.getLayoutParams()).gravity = 17;
    paramContext.setVisibility(8);
    addView(paramContext);
    paramContext = this.b.inflate(g.n, this, false);
    paramContext.setVisibility(8);
    addView(paramContext);
    paramAttributeSet.recycle();
  }
  
  public ViewGroup a()
  {
    return this.a;
  }
  
  public void a(LayoutInflater paramLayoutInflater, int paramInt)
  {
    if (paramInt == 0) {}
    do
    {
      return;
      this.a = ((ViewGroup)paramLayoutInflater.inflate(paramInt, this, false));
    } while (this.a == null);
    addView(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/ContentFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */