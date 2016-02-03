package com.jiubang.playsdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

public class ListViewPage
  extends ListView
  implements AbsListView.OnScrollListener
{
  private boolean a = true;
  private boolean b = true;
  private r c = null;
  
  public ListViewPage(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ListViewPage(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ListViewPage(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    this.a = false;
  }
  
  public void a(r paramr)
  {
    this.c = paramr;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void b()
  {
    this.a = true;
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  protected void layoutChildren()
  {
    try
    {
      super.layoutChildren();
      return;
    }
    catch (IllegalStateException localIllegalStateException) {}
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    super.setOnScrollListener(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    super.setOnScrollListener(null);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.c != null) && (this.b)) {
      this.c.a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.b) && (paramAbsListView.getLastVisiblePosition() >= paramAbsListView.getCount() - 1) && (this.a) && (this.c != null))
    {
      this.a = false;
      this.c.d();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/ListViewPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */