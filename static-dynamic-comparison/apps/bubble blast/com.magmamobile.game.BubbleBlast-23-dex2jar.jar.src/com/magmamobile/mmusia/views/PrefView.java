package com.magmamobile.mmusia.views;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import com.magmamobile.mmusia.MMUSIA;
import com.magmamobile.mmusia.data.LanguageBase;

public class PrefView
  extends LinearLayout
{
  public PrefView(Context paramContext)
  {
    super(paramContext);
    setOrientation(1);
    buildView(paramContext);
  }
  
  public void buildView(Context paramContext)
  {
    paramContext = new CheckBox(paramContext);
    paramContext.setText(LanguageBase.DIALOG_SETTINGS_CHKTEXT);
    paramContext.setId(MMUSIA.RES_ID_PREF_CHECK_ENABLE);
    addView(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/views/PrefView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */