package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.util.i;
import com.ideashower.readitlater.util.j;
import com.pocket.widget.RainbowProgressCircleView;

public class EmptyListLayout
  extends ResizeDetectRelativeLayout
  implements com.pocket.list.g
{
  protected ViewGroup a;
  protected ViewGroup b;
  private final k c = new k();
  private RainbowProgressCircleView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private ViewGroup h;
  private l i;
  
  public EmptyListLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public EmptyListLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public EmptyListLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2130903136, this, true);
    this.d = ((RainbowProgressCircleView)findViewById(2131231033));
    this.b = ((ViewGroup)findViewById(2131231030));
    this.a = ((ViewGroup)findViewById(2131231029));
    this.h = ((ViewGroup)findViewById(2131231032));
    this.e = ((TextView)findViewById(2131230768));
    this.f = ((TextView)findViewById(2131230963));
    this.g = ((Button)findViewById(2131231031));
    i.a(i.a, this.e);
    i.a(i.c, this.f);
  }
  
  private void b()
  {
    Object localObject;
    if (k.b(this.c) != 0)
    {
      localObject = BitmapFactory.decodeResource(com.ideashower.readitlater.a.g.m().getResources(), k.b(this.c));
      this.e.setCompoundDrawablesWithIntrinsicBounds(new p((Bitmap)localObject, getContext(), getResources().getColorStateList(2131165802)), null, null, null);
      this.e.setCompoundDrawablePadding(j.a(16.0F));
      this.e.setText(k.c(this.c));
      TextView localTextView = this.f;
      if (k.d(this.c) == null) {
        break label181;
      }
      localObject = Html.fromHtml(k.d(this.c).toString());
      label113:
      localTextView.setText((CharSequence)localObject);
      if (k.e(this.c) == null) {
        break label186;
      }
      this.g.setText(k.f(this.c));
      this.g.setVisibility(0);
    }
    for (;;)
    {
      a(false, true, false, false);
      return;
      this.e.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.e.setCompoundDrawablePadding(0);
      break;
      label181:
      localObject = null;
      break label113;
      label186:
      this.g.setText(null);
      this.g.setVisibility(8);
    }
  }
  
  public void C()
  {
    a(false, false, true, false);
  }
  
  public void D()
  {
    a(true, false, false, false);
  }
  
  public void E()
  {
    if (this.i != null) {
      this.i.a(this.c);
    }
    for (;;)
    {
      b();
      return;
      k.a(this.c);
    }
  }
  
  public void F()
  {
    a(false, false, false, true);
  }
  
  public void a(View paramView)
  {
    this.a.addView(paramView);
  }
  
  public void a(boolean paramBoolean, ErrorReport paramErrorReport)
  {
    if (this.i != null) {
      this.i.a(this.c, paramBoolean, paramErrorReport);
    }
    for (;;)
    {
      b();
      return;
      k.a(this.c);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    int j = 0;
    if (paramBoolean1)
    {
      this.d.setVisibility(8);
      this.b.setVisibility(8);
      this.h.setVisibility(8);
      return;
    }
    if (paramBoolean3)
    {
      this.d.setVisibility(0);
      this.b.setVisibility(8);
      this.h.setVisibility(8);
      return;
    }
    if (paramBoolean2)
    {
      this.d.setVisibility(8);
      this.b.setVisibility(0);
      this.h.setVisibility(8);
      return;
    }
    this.d.setVisibility(8);
    this.b.setVisibility(8);
    ViewGroup localViewGroup = this.h;
    if (paramBoolean4) {}
    for (;;)
    {
      localViewGroup.setVisibility(j);
      return;
      j = 8;
    }
  }
  
  public ViewGroup getDisabledViewParent()
  {
    return this.h;
  }
  
  public void setDisabledView(View paramView)
  {
    this.h.removeAllViews();
    if (paramView != null) {
      this.h.addView(paramView);
    }
  }
  
  public void setEmptyStateHandler(l paraml)
  {
    this.i = paraml;
  }
  
  public void setOnButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.g.setOnClickListener(paramOnClickListener);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/EmptyListLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */