package com.magmamobile.mmusia.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import com.magmamobile.mmusia.MMUSIA;

public class MoreGamesDialogView
  extends LinearLayout
{
  private Context mContext;
  
  public MoreGamesDialogView(Context paramContext)
  {
    super(paramContext);
    setBackgroundColor(-16777216);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    setOrientation(1);
    buildView(paramContext);
  }
  
  public MoreGamesDialogView(Context paramContext, AttributeSet paramAttributeSet)
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
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    localLinearLayout.setOrientation(1);
    paramContext = new ListView(paramContext);
    paramContext.setId(MMUSIA.RES_ID_LISTVIEW_MOREGAMES);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramContext.setBackgroundColor(-1);
    paramContext.setCacheColorHint(-1);
    paramContext.setDividerHeight(0);
    paramContext.setClickable(true);
    localLinearLayout.addView(paramContext);
    addView(localLinearLayout);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/views/MoreGamesDialogView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */