package com.ideashower.readitlater.views.toolbars;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.ideashower.readitlater.views.ThemedImageView;
import com.ideashower.readitlater.views.p;

public class SaveCancelToolbar
  extends StyledToolbar
  implements View.OnClickListener
{
  private View s;
  private View t;
  private a u;
  
  public SaveCancelToolbar(Context paramContext)
  {
    super(paramContext);
  }
  
  public SaveCancelToolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject = (TextView)paramView.findViewById(2131230902);
    ((TextView)localObject).setText(getResources().getString(paramInt2).toUpperCase());
    p localp = new p(paramInt1, getContext());
    localp.a();
    ((TextView)localObject).setCompoundDrawables(localp, null, null, null);
    paramView.setOnClickListener(this);
    localObject = new LinearLayout.LayoutParams(0, -1);
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(paramView);
  }
  
  private void g()
  {
    p localp = new p(2130837504, getContext());
    int j = getChildCount();
    int i = 1;
    while (i < j)
    {
      ThemedImageView localThemedImageView = new ThemedImageView(getContext());
      localThemedImageView.setImageDrawable(localp);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 16;
      localThemedImageView.setLayoutParams(localLayoutParams);
      addView(localThemedImageView, i);
      i += 1;
    }
  }
  
  protected void a()
  {
    super.a();
    LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
    this.s = localLayoutInflater.inflate(2130903188, null);
    a(this.s, 2130837638, 2131492871);
    this.t = localLayoutInflater.inflate(2130903188, null);
    a(this.t, 2130837639, 2131492933);
    g();
  }
  
  public void onClick(View paramView)
  {
    if (this.u == null) {}
    do
    {
      return;
      if (paramView == this.t)
      {
        this.u.a(true);
        return;
      }
    } while (paramView != this.s);
    this.u.a(false);
  }
  
  public void setOnActionTakenListener(a parama)
  {
    this.u = parama;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/toolbars/SaveCancelToolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */