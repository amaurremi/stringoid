package com.magmamobile.mmusia.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.magmamobile.mmusia.MCommon;
import com.magmamobile.mmusia.MMUSIA;

public class ItemView
  extends LinearLayout
{
  private Context mContext;
  
  public ItemView(Context paramContext)
  {
    super(paramContext);
    setOrientation(1);
    buildView(paramContext);
  }
  
  public ItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    buildView(paramContext);
  }
  
  public void buildView(Context paramContext)
  {
    LinearLayout localLinearLayout1 = new LinearLayout(paramContext);
    localLinearLayout1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localLinearLayout1.setOrientation(0);
    localLinearLayout1.setGravity(16);
    localLinearLayout1.setMinimumHeight(MCommon.dpi(48));
    localLinearLayout1.setId(MMUSIA.RES_ID_ITEM_LINEARITEM);
    ImageViewEx localImageViewEx = new ImageViewEx(paramContext);
    localImageViewEx.setLayoutParams(new ViewGroup.LayoutParams(MCommon.dpi(48), MCommon.dpi(48)));
    localImageViewEx.setId(MMUSIA.RES_ID_ITEM_IMG);
    localImageViewEx.setPadding(MCommon.dpi(5), MCommon.dpi(5), MCommon.dpi(10), MCommon.dpi(5));
    LinearLayout localLinearLayout2 = new LinearLayout(paramContext);
    localLinearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localLinearLayout2.setOrientation(1);
    TextView localTextView1 = new TextView(paramContext);
    localTextView1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView1.setId(MMUSIA.RES_ID_ITEM_TITLE);
    localTextView1.setTextColor(-16777088);
    localTextView1.setTypeface(Typeface.DEFAULT, 1);
    localTextView1.setMaxLines(2);
    TextView localTextView2 = new TextView(paramContext);
    localTextView2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    localTextView2.setId(MMUSIA.RES_ID_ITEM_DATE);
    localTextView2.setTextColor(-6250336);
    localTextView2.setTypeface(Typeface.DEFAULT, 0);
    localTextView2.setMaxLines(1);
    TextView localTextView3 = new TextView(paramContext);
    localTextView3.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView3.setId(MMUSIA.RES_ID_ITEM_DESC);
    localTextView3.setTextColor(-4144960);
    localTextView3.setTypeface(Typeface.DEFAULT, 0);
    localTextView3.setMaxLines(3);
    paramContext = new View(paramContext);
    paramContext.setBackgroundColor(-4144960);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
    localLinearLayout2.addView(localTextView1);
    localLinearLayout2.addView(localTextView2);
    localLinearLayout2.addView(localTextView3);
    localLinearLayout1.addView(localImageViewEx);
    localLinearLayout1.addView(localLinearLayout2);
    addView(localLinearLayout1);
    addView(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/views/ItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */