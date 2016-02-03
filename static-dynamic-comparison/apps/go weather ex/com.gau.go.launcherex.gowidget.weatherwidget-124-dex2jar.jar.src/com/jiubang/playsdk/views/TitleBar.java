package com.jiubang.playsdk.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.d;
import com.jiubang.playsdk.f;
import com.jiubang.playsdk.main.c;

public class TitleBar
  extends RelativeLayout
{
  public View a = null;
  protected ImageButton b;
  protected TextView c = null;
  protected ImageView d = null;
  protected ImageView e;
  private ae f;
  private ad g;
  private Context h;
  private LinearLayout i;
  private RelativeLayout j;
  
  public TitleBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.h = paramContext;
  }
  
  public void a()
  {
    this.b.setVisibility(0);
  }
  
  public void a(ad paramad)
  {
    this.g = paramad;
  }
  
  public void a(ae paramae)
  {
    this.f = paramae;
  }
  
  public void a(String paramString)
  {
    this.c.setText(paramString);
  }
  
  public void a(int[] paramArrayOfInt, View.OnClickListener paramOnClickListener)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      this.i.removeAllViews();
    }
    for (;;)
    {
      return;
      this.i.removeAllViews();
      int m = this.h.getResources().getDimensionPixelSize(d.a);
      int k = 0;
      while (k < paramArrayOfInt.length)
      {
        ImageView localImageView = new ImageView(this.h);
        localImageView.setBackgroundResource(aa.a().b().l());
        localImageView.setId(paramArrayOfInt[k]);
        localImageView.setOnClickListener(paramOnClickListener);
        localImageView.setImageResource(paramArrayOfInt[k]);
        localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(m, -1);
        this.i.addView(localImageView, localLayoutParams);
        k += 1;
      }
    }
  }
  
  public void b()
  {
    this.b.setVisibility(8);
  }
  
  protected void onFinishInflate()
  {
    setBackgroundResource(aa.a().b().c());
    this.b = ((ImageButton)findViewById(f.h));
    this.b.setBackgroundResource(aa.a().b().l());
    this.b.setOnClickListener(new ab(this));
    this.a = findViewById(f.e).findViewById(f.b);
    this.a.setOnClickListener(new ac(this));
    this.c = ((TextView)this.a.findViewById(f.f));
    this.c.setTextColor(getContext().getResources().getColor(aa.a().b().b()));
    this.e = ((ImageView)this.a.findViewById(f.c));
    this.e.setImageResource(aa.a().b().j());
    this.d = ((ImageView)this.a.findViewById(f.d));
    this.j = ((RelativeLayout)this.a.findViewById(f.a));
    this.j.setBackgroundResource(aa.a().b().l());
    if (aa.a().b().a() != 0) {
      this.d.setImageResource(aa.a().b().a());
    }
    for (;;)
    {
      this.i = ((LinearLayout)findViewById(f.g));
      return;
      this.d.setVisibility(8);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/TitleBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */