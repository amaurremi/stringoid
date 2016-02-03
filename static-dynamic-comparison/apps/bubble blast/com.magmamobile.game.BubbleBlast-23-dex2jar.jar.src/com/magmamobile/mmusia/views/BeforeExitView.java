package com.magmamobile.mmusia.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.magmamobile.mmusia.MCommon;
import com.magmamobile.mmusia.MMUSIA;

public class BeforeExitView
  extends LinearLayout
{
  private Context mContext;
  
  public BeforeExitView(Context paramContext)
  {
    super(paramContext);
    setBackgroundColor(-16777216);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    setOrientation(1);
    buildView(paramContext);
  }
  
  public BeforeExitView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    setBackgroundColor(-16777216);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    setOrientation(1);
    buildView(paramContext);
  }
  
  public void buildView(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    Object localObject1 = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, 0, MCommon.dpi(50));
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localLinearLayout.setOrientation(1);
    localObject1 = new LinearLayout(paramContext);
    ((LinearLayout)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    ((LinearLayout)localObject1).setOrientation(0);
    ((LinearLayout)localObject1).setGravity(16);
    ((LinearLayout)localObject1).setMinimumHeight(MCommon.dpi(48));
    ((LinearLayout)localObject1).setId(MMUSIA.RES_ID_ITEM_LINEARITEM);
    ((LinearLayout)localObject1).setBackgroundColor(-16777216);
    Object localObject2 = new ImageViewEx(paramContext);
    ((ImageViewEx)localObject2).setLayoutParams(new ViewGroup.LayoutParams(MCommon.dpi(64), MCommon.dpi(64)));
    ((ImageViewEx)localObject2).setId(MMUSIA.RES_ID_IMG_MOREGAMES_HEAD);
    ((ImageViewEx)localObject2).setPadding(MCommon.dpi(5), MCommon.dpi(5), MCommon.dpi(10), MCommon.dpi(5));
    Object localObject3 = new TextView(paramContext);
    ((TextView)localObject3).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    ((TextView)localObject3).setId(MMUSIA.RES_ID_TITLE_MOREGAMES_HEAD);
    ((TextView)localObject3).setTextColor(-1);
    ((TextView)localObject3).setTextSize(MCommon.dpi(14));
    ((TextView)localObject3).setTypeface(MMUSIA.getTypeFace(), 1);
    ((TextView)localObject3).setMaxLines(2);
    ((LinearLayout)localObject1).addView((View)localObject2);
    ((LinearLayout)localObject1).addView((View)localObject3);
    addView((View)localObject1);
    localObject1 = new GridView(paramContext);
    ((GridView)localObject1).setId(MMUSIA.RES_ID_LISTVIEW_MOREGAMES);
    ((GridView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    ((GridView)localObject1).setBackgroundColor(-1);
    ((GridView)localObject1).setCacheColorHint(-1);
    ((GridView)localObject1).setClickable(true);
    ((GridView)localObject1).setNumColumns(3);
    localObject2 = new LinearLayout(paramContext);
    localObject3 = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout.LayoutParams)localObject3).setMargins(0, MCommon.dpi(-50), 0, 0);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((LinearLayout)localObject2).setOrientation(0);
    ((LinearLayout)localObject2).setBackgroundColor(-3487030);
    paramContext = new Button(paramContext);
    localObject3 = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout.LayoutParams)localObject3).gravity = 5;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    paramContext.setId(MMUSIA.RES_ID_BEFOREEXIT_BTN_CLOSE);
    paramContext.setText("Close");
    localLinearLayout.addView((View)localObject1);
    ((LinearLayout)localObject2).addView(paramContext);
    addView(localLinearLayout);
    addView((View)localObject2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/views/BeforeExitView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */