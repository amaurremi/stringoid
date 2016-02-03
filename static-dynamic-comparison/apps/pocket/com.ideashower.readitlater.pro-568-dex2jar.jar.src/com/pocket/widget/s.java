package com.pocket.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.ResizeDetectRelativeLayout;
import com.ideashower.readitlater.views.d;

public class s
  extends ag
{
  private final TextView A;
  private final TextView B;
  private ResizeDetectRelativeLayout C;
  protected final ViewGroup a;
  public ViewGroup d;
  public ViewGroup e;
  
  private s(r paramr, View paramView)
  {
    super(paramr, paramView);
    this.a = ((ViewGroup)paramView.findViewById(2131231062));
    this.d = ((ViewGroup)paramView.findViewById(2131231135));
    this.e = ((ViewGroup)paramView.findViewById(2131230890));
    this.A = ((TextView)paramView.findViewById(2131230891));
    this.B = ((TextView)paramView.findViewById(2131230892));
    paramView = new d(paramr.b(), 18.0F, 18.0F, true, false);
    z.a(this.d, paramView);
    a(r.c(paramr), this.a);
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    if (this.w != null)
    {
      this.A.setText(this.w.t());
      this.B.setText(this.w.o());
    }
    if (this.C != null) {
      this.C.setVisibility(8);
    }
    this.a.setVisibility(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */