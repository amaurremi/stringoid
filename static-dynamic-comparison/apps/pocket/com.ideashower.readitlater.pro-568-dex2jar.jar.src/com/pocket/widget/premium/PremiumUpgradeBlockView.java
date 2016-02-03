package com.pocket.widget.premium;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.ideashower.readitlater.b;
import com.ideashower.readitlater.views.ResizeDetectRelativeLayout;

public class PremiumUpgradeBlockView
  extends ResizeDetectRelativeLayout
{
  View a;
  ImageView b;
  TextView c;
  TextView d;
  String e = "";
  String f = "";
  int g = -1;
  boolean h;
  private int i;
  
  public PremiumUpgradeBlockView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public PremiumUpgradeBlockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public PremiumUpgradeBlockView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903094, this, true);
    this.a = paramContext.findViewById(2131230939);
    this.b = ((ImageView)paramContext.findViewById(2131230942));
    this.c = ((TextView)paramContext.findViewById(2131230943));
    this.d = ((TextView)paramContext.findViewById(2131230944));
    if (this.g != -1) {
      this.b.setImageResource(this.g);
    }
    for (;;)
    {
      if (!this.h) {
        this.a.setVisibility(8);
      }
      this.c.setText(this.e);
      this.d.setText(this.f);
      return;
      if (this.i > 0)
      {
        paramContext = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
        paramContext.width = this.i;
        paramContext.height = this.i;
        this.b.setLayoutParams(paramContext);
        this.b.setVisibility(4);
      }
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.PremiumUpgradeBlockView, 0, 0);
    this.e = paramContext.getString(0);
    this.f = paramContext.getString(1);
    this.g = paramContext.getResourceId(2, -1);
    this.h = paramContext.getBoolean(3, true);
    this.i = paramContext.getDimensionPixelSize(4, 0);
    paramContext.recycle();
  }
  
  public ImageView getImageView()
  {
    return this.b;
  }
  
  public void setDescription(String paramString)
  {
    this.f = paramString;
    this.d.setText(paramString);
  }
  
  public void setImage(int paramInt)
  {
    this.g = paramInt;
    this.b.setImageResource(paramInt);
  }
  
  public void setTitle(String paramString)
  {
    this.e = paramString;
    this.c.setText(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/premium/PremiumUpgradeBlockView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */