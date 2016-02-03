package com.appbrain.a;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import cmn.q;

public class ao
  implements ae.c
{
  public final ViewGroup a(Context paramContext, ae.b paramb)
  {
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(1);
    paramContext.setGravity(1);
    paramContext.setPadding(q.b(8.0F), q.b(8.0F), q.b(8.0F), q.b(8.0F));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = q.b(8.0F);
    localLayoutParams.gravity = 5;
    paramContext.addView(paramb.c, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = q.b(36.0F);
    paramContext.addView(paramb.a, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(q.b(16.0F), 0, q.b(16.0F), q.b(16.0F));
    paramContext.addView(paramb.d, localLayoutParams);
    paramb.d.setGravity(1);
    localLayoutParams = new LinearLayout.LayoutParams(q.b(128.0F), q.b(128.0F));
    localLayoutParams.bottomMargin = q.b(16.0F);
    paramContext.addView(paramb.f, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(q.b(16.0F), 0, q.b(16.0F), q.b(16.0F));
    paramContext.addView(paramb.e, localLayoutParams);
    paramb.e.setGravity(1);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = q.b(16.0F);
    paramContext.addView(paramb.b, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    paramContext.addView(paramb.g, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = q.b(16.0F);
    paramContext.addView(paramb.h, localLayoutParams);
    paramb.h.setGravity(1);
    return paramContext;
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public final ViewGroup b(Context paramContext, ae.b paramb)
  {
    LinearLayout localLinearLayout1 = new LinearLayout(paramContext);
    localLinearLayout1.setOrientation(1);
    localLinearLayout1.setPadding(q.b(8.0F), q.b(8.0F), q.b(8.0F), q.b(8.0F));
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    LinearLayout localLinearLayout2 = new LinearLayout(paramContext);
    localLinearLayout2.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-2, -2);
    LinearLayout localLinearLayout3 = new LinearLayout(paramContext);
    localLinearLayout3.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(q.b(128.0F), q.b(128.0F));
    localLayoutParams3.bottomMargin = q.b(8.0F);
    localLinearLayout3.addView(paramb.f, localLayoutParams3);
    localLayoutParams3 = new LinearLayout.LayoutParams(-2, -2);
    localLinearLayout3.addView(paramb.g, localLayoutParams3);
    localLinearLayout2.addView(localLinearLayout3, localLayoutParams2);
    localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams2.leftMargin = q.b(8.0F);
    localLinearLayout3 = new LinearLayout(paramContext);
    localLinearLayout3.setOrientation(1);
    localLayoutParams3 = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams3.bottomMargin = q.b(8.0F);
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams4 = new LinearLayout.LayoutParams(0, -2);
    localLayoutParams4.weight = 1.0F;
    paramContext.addView(paramb.d, localLayoutParams4);
    paramb.d.setVisibility(4);
    localLayoutParams4 = new LinearLayout.LayoutParams(-2, -2);
    paramContext.addView(paramb.c, localLayoutParams4);
    localLinearLayout3.addView(paramContext, localLayoutParams3);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.bottomMargin = q.b(16.0F);
    localLinearLayout3.addView(paramb.e, paramContext);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    localLinearLayout3.addView(paramb.b, paramContext);
    localLinearLayout2.addView(localLinearLayout3, localLayoutParams2);
    localLinearLayout1.addView(localLinearLayout2, localLayoutParams1);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.bottomMargin = q.b(36.0F);
    paramContext.gravity = 1;
    localLinearLayout1.addView(paramb.a, paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.topMargin = q.b(8.0F);
    localLinearLayout1.addView(paramb.h, paramContext);
    return localLinearLayout1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */