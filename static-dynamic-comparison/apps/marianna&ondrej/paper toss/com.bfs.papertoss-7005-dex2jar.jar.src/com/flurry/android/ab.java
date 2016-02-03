package com.flurry.android;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.Html;
import android.text.SpannedString;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

final class ab
  extends RelativeLayout
{
  private final SpannedString a = new SpannedString(Html.fromHtml("<html><div='style:font-size:7px'>&lt; Previous</div></html>"));
  private final SpannedString b = new SpannedString(Html.fromHtml("<html><div='style:font-size:7px;color:#ffA500'>&lt; Previous</div></html>"));
  
  public ab(CatalogActivity paramCatalogActivity, Context paramContext)
  {
    super(paramContext);
    setBackgroundColor(-16777216);
    paramContext = new TextView(paramContext);
    paramContext.setTextColor(ColorStateList.valueOf(-1));
    paramContext.setId(10001);
    paramContext.setText(this.a);
    paramContext.setPadding(5, 2, 5, 2);
    paramContext.setFocusable(true);
    paramContext.setOnFocusChangeListener(new ac(this, paramContext));
    paramContext.setOnClickListener(paramCatalogActivity);
    paramContext.setEnabled(true);
    paramCatalogActivity = new RelativeLayout.LayoutParams(-2, -2);
    paramCatalogActivity.setMargins(0, 0, 0, 0);
    setLayoutParams(paramCatalogActivity);
    paramCatalogActivity = new RelativeLayout.LayoutParams(-2, -2);
    paramCatalogActivity.setMargins(2, 0, 0, 0);
    paramCatalogActivity.addRule(4);
    addView(paramContext, paramCatalogActivity);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */