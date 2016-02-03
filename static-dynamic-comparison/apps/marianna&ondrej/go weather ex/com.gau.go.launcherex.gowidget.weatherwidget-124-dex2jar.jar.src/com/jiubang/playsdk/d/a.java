package com.jiubang.playsdk.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.d;
import com.jiubang.playsdk.j;

public abstract class a
  extends b
{
  protected h a;
  protected e b;
  
  public a(Context paramContext)
  {
    this.c = paramContext;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = new h(paramContext);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    this.a.setLayoutParams(localLayoutParams);
    this.a.setOnKeyListener(this);
    this.a.setBackgroundResource(com.jiubang.playsdk.e.s);
    this.a.setDivider(new ColorDrawable(this.c.getResources().getColor(com.jiubang.playsdk.c.g)));
    this.a.setDividerHeight(this.c.getResources().getDimensionPixelSize(d.z));
    this.a.setVerticalScrollBarEnabled(false);
    this.a.setHorizontalScrollBarEnabled(false);
    this.a.setAlwaysDrawnWithCacheEnabled(true);
    this.a.setSelectionAfterHeaderView();
    this.a.setSmoothScrollbarEnabled(true);
    this.a.setSelector(aa.a().b().l());
    this.b = new e(paramContext);
    this.a.setAdapter(this.b);
  }
  
  private void a(PopupWindow paramPopupWindow)
  {
    if (paramPopupWindow != null) {
      paramPopupWindow.setAnimationStyle(j.a);
    }
  }
  
  public void a()
  {
    if (this.d != null) {
      this.d.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.clearFocus();
    if ((this.d != null) && (b()))
    {
      a();
      return;
    }
    this.d = new PopupWindow(this.a, paramInt3, paramInt4, true);
    a(this.d);
    this.a.a(this);
    this.d.setFocusable(false);
    this.d.showAtLocation(paramView, 53, paramInt1, this.c.getResources().getDimensionPixelSize(d.A) + paramInt2);
    this.d.setFocusable(true);
    this.d.update();
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.a.setOnItemClickListener(paramOnItemClickListener);
  }
  
  public void a(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null) {
      this.b.a(paramArrayOfInt);
    }
    this.b.notifyDataSetChanged();
  }
  
  public boolean b()
  {
    if (this.d != null) {
      return this.d.isShowing();
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */