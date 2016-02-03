package com.jiubang.playsdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.e;
import com.jiubang.playsdk.f;

public class DependentAppView
  extends TouchMaskFrameLayout
  implements View.OnClickListener
{
  private ImageView a;
  private String b;
  private int c = 2;
  
  public DependentAppView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DependentAppView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
    this.a.setImageResource(e.x);
  }
  
  public void onClick(View paramView)
  {
    aa.a().a(getContext(), this.c, this.b);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((ImageView)findViewById(f.u));
    setOnClickListener(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/DependentAppView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */