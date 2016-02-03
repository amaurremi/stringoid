package com.appbrain.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import cmn.q;

public class ap
  implements ae.c
{
  private static ViewGroup c(Context paramContext, ae.b paramb)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLinearLayout.addView(paramb.b, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(0, 0);
    localLayoutParams.weight = 1.0F;
    localLinearLayout.addView(new View(paramContext), localLayoutParams);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    localLinearLayout.addView(paramb.c, paramContext);
    return localLinearLayout;
  }
  
  public final ViewGroup a(Context paramContext, ae.b paramb)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(1);
    localLinearLayout.setPadding(0, q.b(8.0F), 0, q.b(8.0F));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(q.b(8.0F), 0, q.b(8.0F), q.b(16.0F));
    localLinearLayout.addView(c(paramContext, paramb), localLayoutParams);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.bottomMargin = q.b(36.0F);
    localLinearLayout.addView(paramb.a, paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.setMargins(q.b(16.0F), 0, q.b(16.0F), q.b(16.0F));
    localLinearLayout.addView(paramb.d, paramContext);
    paramb.d.setGravity(1);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.bottomMargin = q.b(16.0F);
    localLinearLayout.addView(paramb.f, paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.setMargins(q.b(16.0F), 0, q.b(16.0F), q.b(16.0F));
    localLinearLayout.addView(paramb.e, paramContext);
    paramb.e.setGravity(1);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    localLinearLayout.addView(paramb.g, paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.setMargins(q.b(8.0F), q.b(16.0F), q.b(8.0F), 0);
    localLinearLayout.addView(paramb.h, paramContext);
    paramb.h.setGravity(1);
    return localLinearLayout;
  }
  
  public final boolean a()
  {
    return true;
  }
  
  public final ViewGroup b(Context paramContext, ae.b paramb)
  {
    LinearLayout localLinearLayout1 = new LinearLayout(paramContext);
    localLinearLayout1.setOrientation(1);
    localLinearLayout1.setPadding(q.b(8.0F), q.b(8.0F), q.b(8.0F), q.b(8.0F));
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams1.bottomMargin = q.b(8.0F);
    localLinearLayout1.addView(c(paramContext, paramb), localLayoutParams1);
    localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams1.bottomMargin = q.b(36.0F);
    localLayoutParams1.gravity = 1;
    localLinearLayout1.addView(paramb.a, localLayoutParams1);
    localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams1.bottomMargin = q.b(16.0F);
    localLinearLayout1.addView(paramb.d, localLayoutParams1);
    localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    LinearLayout localLinearLayout2 = new LinearLayout(paramContext);
    localLinearLayout2.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(0, 0);
    localLayoutParams2.weight = 1.0F;
    localLinearLayout2.addView(paramb.f, localLayoutParams2);
    localLayoutParams2 = new LinearLayout.LayoutParams(0, -2);
    localLayoutParams2.leftMargin = q.b(8.0F);
    localLayoutParams2.weight = 1.0F;
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(-1, -2);
    paramContext.addView(paramb.e, localLayoutParams3);
    localLayoutParams3 = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams3.topMargin = q.b(16.0F);
    paramContext.addView(paramb.g, localLayoutParams3);
    localLinearLayout2.addView(paramContext, localLayoutParams2);
    localLinearLayout1.addView(localLinearLayout2, localLayoutParams1);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.topMargin = q.b(8.0F);
    localLinearLayout1.addView(paramb.h, paramContext);
    paramb.h.setGravity(1);
    return localLinearLayout1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */