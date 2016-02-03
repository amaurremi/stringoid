package com.appbrain.a;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import cmn.aj;

public class br
  implements bf
{
  public final ViewGroup a(Context paramContext, be parambe)
  {
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(1);
    paramContext.setGravity(1);
    paramContext.setPadding(aj.b(8.0F), aj.b(8.0F), aj.b(8.0F), aj.b(8.0F));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = aj.b(8.0F);
    localLayoutParams.gravity = 5;
    paramContext.addView(parambe.c, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = aj.b(36.0F);
    paramContext.addView(parambe.a, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(aj.b(16.0F), 0, aj.b(16.0F), aj.b(16.0F));
    paramContext.addView(parambe.d, localLayoutParams);
    parambe.d.setGravity(1);
    localLayoutParams = new LinearLayout.LayoutParams(aj.b(128.0F), aj.b(128.0F));
    localLayoutParams.bottomMargin = aj.b(16.0F);
    paramContext.addView(parambe.f, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(aj.b(16.0F), 0, aj.b(16.0F), aj.b(16.0F));
    paramContext.addView(parambe.e, localLayoutParams);
    parambe.e.setGravity(1);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = aj.b(16.0F);
    paramContext.addView(parambe.b, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    paramContext.addView(parambe.g, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = aj.b(16.0F);
    paramContext.addView(parambe.h, localLayoutParams);
    parambe.h.setGravity(1);
    return paramContext;
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public final ViewGroup b(Context paramContext, be parambe)
  {
    LinearLayout localLinearLayout1 = new LinearLayout(paramContext);
    localLinearLayout1.setOrientation(1);
    localLinearLayout1.setPadding(aj.b(8.0F), aj.b(8.0F), aj.b(8.0F), aj.b(8.0F));
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    LinearLayout localLinearLayout2 = new LinearLayout(paramContext);
    localLinearLayout2.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-2, -2);
    LinearLayout localLinearLayout3 = new LinearLayout(paramContext);
    localLinearLayout3.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(aj.b(128.0F), aj.b(128.0F));
    localLayoutParams3.bottomMargin = aj.b(8.0F);
    localLinearLayout3.addView(parambe.f, localLayoutParams3);
    localLayoutParams3 = new LinearLayout.LayoutParams(-2, -2);
    localLinearLayout3.addView(parambe.g, localLayoutParams3);
    localLinearLayout2.addView(localLinearLayout3, localLayoutParams2);
    localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams2.leftMargin = aj.b(8.0F);
    localLinearLayout3 = new LinearLayout(paramContext);
    localLinearLayout3.setOrientation(1);
    localLayoutParams3 = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams3.bottomMargin = aj.b(8.0F);
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams4 = new LinearLayout.LayoutParams(0, -2);
    localLayoutParams4.weight = 1.0F;
    paramContext.addView(parambe.d, localLayoutParams4);
    parambe.d.setVisibility(4);
    localLayoutParams4 = new LinearLayout.LayoutParams(-2, -2);
    paramContext.addView(parambe.c, localLayoutParams4);
    localLinearLayout3.addView(paramContext, localLayoutParams3);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.bottomMargin = aj.b(16.0F);
    localLinearLayout3.addView(parambe.e, paramContext);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    localLinearLayout3.addView(parambe.b, paramContext);
    localLinearLayout2.addView(localLinearLayout3, localLayoutParams2);
    localLinearLayout1.addView(localLinearLayout2, localLayoutParams1);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.bottomMargin = aj.b(36.0F);
    paramContext.gravity = 1;
    localLinearLayout1.addView(parambe.a, paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.topMargin = aj.b(8.0F);
    localLinearLayout1.addView(parambe.h, paramContext);
    return localLinearLayout1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */