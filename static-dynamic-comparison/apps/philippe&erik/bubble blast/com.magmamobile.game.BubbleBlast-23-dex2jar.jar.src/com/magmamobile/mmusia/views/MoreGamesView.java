package com.magmamobile.mmusia.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.magmamobile.mmusia.MCommon;
import com.magmamobile.mmusia.MMUSIA;

public class MoreGamesView
  extends LinearLayout
{
  private Context mContext;
  
  public MoreGamesView(Context paramContext)
  {
    super(paramContext);
    setBackgroundColor(-16777216);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    setOrientation(1);
    buildView(paramContext);
  }
  
  public MoreGamesView(Context paramContext, AttributeSet paramAttributeSet)
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
    LinearLayout localLinearLayout1 = new LinearLayout(paramContext);
    localLinearLayout1.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    localLinearLayout1.setOrientation(1);
    LinearLayout localLinearLayout2 = new LinearLayout(paramContext);
    localLinearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localLinearLayout2.setOrientation(0);
    localLinearLayout2.setGravity(16);
    localLinearLayout2.setMinimumHeight(MCommon.dpi(48));
    localLinearLayout2.setId(MMUSIA.RES_ID_ITEM_LINEARITEM);
    localLinearLayout2.setBackgroundColor(-16777216);
    ImageViewEx localImageViewEx = new ImageViewEx(paramContext);
    localImageViewEx.setLayoutParams(new ViewGroup.LayoutParams(MCommon.dpi(64), MCommon.dpi(64)));
    localImageViewEx.setId(MMUSIA.RES_ID_IMG_MOREGAMES_HEAD);
    localImageViewEx.setPadding(MCommon.dpi(5), MCommon.dpi(5), MCommon.dpi(10), MCommon.dpi(5));
    Object localObject = new LinearLayout(paramContext);
    ((LinearLayout)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    ((LinearLayout)localObject).setOrientation(1);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    ((TextView)localObject).setId(MMUSIA.RES_ID_TITLE_MOREGAMES_HEAD);
    ((TextView)localObject).setTextColor(-1);
    ((TextView)localObject).setTextSize(MCommon.dpi(14));
    ((TextView)localObject).setTypeface(MMUSIA.getTypeFace(), 1);
    ((TextView)localObject).setMaxLines(2);
    localLinearLayout2.addView(localImageViewEx);
    localLinearLayout2.addView((View)localObject);
    addView(localLinearLayout2);
    paramContext = new ListView(paramContext);
    paramContext.setId(MMUSIA.RES_ID_LISTVIEW_MOREGAMES);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramContext.setBackgroundColor(-1);
    paramContext.setCacheColorHint(-1);
    paramContext.setDividerHeight(0);
    paramContext.setClickable(true);
    localLinearLayout1.addView(paramContext);
    addView(localLinearLayout1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/views/MoreGamesView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */