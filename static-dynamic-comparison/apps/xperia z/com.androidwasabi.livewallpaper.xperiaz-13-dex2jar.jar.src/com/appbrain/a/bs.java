package com.appbrain.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import cmn.aj;

public class bs
  implements bf
{
  private static ViewGroup c(Context paramContext, be parambe)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLinearLayout.addView(parambe.b, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(0, 0);
    localLayoutParams.weight = 1.0F;
    localLinearLayout.addView(new View(paramContext), localLayoutParams);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    localLinearLayout.addView(parambe.c, paramContext);
    return localLinearLayout;
  }
  
  public final ViewGroup a(Context paramContext, be parambe)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(1);
    localLinearLayout.setPadding(0, aj.b(8.0F), 0, aj.b(8.0F));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(aj.b(8.0F), 0, aj.b(8.0F), aj.b(16.0F));
    localLinearLayout.addView(c(paramContext, parambe), localLayoutParams);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.bottomMargin = aj.b(36.0F);
    localLinearLayout.addView(parambe.a, paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.setMargins(aj.b(16.0F), 0, aj.b(16.0F), aj.b(16.0F));
    localLinearLayout.addView(parambe.d, paramContext);
    parambe.d.setGravity(1);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.bottomMargin = aj.b(16.0F);
    localLinearLayout.addView(parambe.f, paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.setMargins(aj.b(16.0F), 0, aj.b(16.0F), aj.b(16.0F));
    localLinearLayout.addView(parambe.e, paramContext);
    parambe.e.setGravity(1);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    localLinearLayout.addView(parambe.g, paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.setMargins(aj.b(8.0F), aj.b(16.0F), aj.b(8.0F), 0);
    localLinearLayout.addView(parambe.h, paramContext);
    parambe.h.setGravity(1);
    return localLinearLayout;
  }
  
  public final boolean a()
  {
    return true;
  }
  
  public final ViewGroup b(Context paramContext, be parambe)
  {
    LinearLayout localLinearLayout1 = new LinearLayout(paramContext);
    localLinearLayout1.setOrientation(1);
    localLinearLayout1.setPadding(aj.b(8.0F), aj.b(8.0F), aj.b(8.0F), aj.b(8.0F));
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams1.bottomMargin = aj.b(8.0F);
    localLinearLayout1.addView(c(paramContext, parambe), localLayoutParams1);
    localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams1.bottomMargin = aj.b(36.0F);
    localLayoutParams1.gravity = 1;
    localLinearLayout1.addView(parambe.a, localLayoutParams1);
    localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams1.bottomMargin = aj.b(16.0F);
    localLinearLayout1.addView(parambe.d, localLayoutParams1);
    localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    LinearLayout localLinearLayout2 = new LinearLayout(paramContext);
    localLinearLayout2.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(0, 0);
    localLayoutParams2.weight = 1.0F;
    localLinearLayout2.addView(parambe.f, localLayoutParams2);
    localLayoutParams2 = new LinearLayout.LayoutParams(0, -2);
    localLayoutParams2.leftMargin = aj.b(8.0F);
    localLayoutParams2.weight = 1.0F;
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(-1, -2);
    paramContext.addView(parambe.e, localLayoutParams3);
    localLayoutParams3 = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams3.topMargin = aj.b(16.0F);
    paramContext.addView(parambe.g, localLayoutParams3);
    localLinearLayout2.addView(paramContext, localLayoutParams2);
    localLinearLayout1.addView(localLinearLayout2, localLayoutParams1);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.topMargin = aj.b(8.0F);
    localLinearLayout1.addView(parambe.h, paramContext);
    parambe.h.setGravity(1);
    return localLinearLayout1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */