package com.jiubang.playsdk.detail;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.a.k;
import com.jiubang.playsdk.f;
import com.jiubang.playsdk.views.HorizontalListView;

public class ThemePreviewLastItemView
  extends LinearLayout
{
  private HorizontalListView a;
  private ViewGroup b;
  private k c = new o(this);
  
  public ThemePreviewLastItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    this.b.setVisibility(8);
  }
  
  private void b()
  {
    if (getResources().getConfiguration().orientation == 1) {
      this.b.setVisibility(0);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    aa.a().a(paramString, 0, paramInt, this.c);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((HorizontalListView)findViewById(f.Y));
    this.b = ((ViewGroup)findViewById(f.Z));
    a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/ThemePreviewLastItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */