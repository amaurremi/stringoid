package com.magmamobile.mmusia.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabWidget;
import com.magmamobile.mmusia.MMUSIA;

public class MainView
  extends LinearLayout
{
  private Context mContext;
  
  public MainView(Context paramContext)
  {
    super(paramContext);
    setBackgroundColor(-16777216);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    setOrientation(1);
    buildView(paramContext);
  }
  
  public MainView(Context paramContext, AttributeSet paramAttributeSet)
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
    TabHost localTabHost = new TabHost(paramContext, null);
    localTabHost.setId(MMUSIA.RES_ID_LISTVIEW_MAINTAB);
    localTabHost.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    LinearLayout localLinearLayout1 = new LinearLayout(paramContext);
    localLinearLayout1.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    localLinearLayout1.setOrientation(1);
    FrameLayout localFrameLayout = new FrameLayout(paramContext);
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.setBackgroundColor(16777215);
    localFrameLayout.setId(16908305);
    LinearLayout localLinearLayout2 = new LinearLayout(paramContext);
    localLinearLayout2.setId(MMUSIA.RES_ID_TAB_UPDATE);
    localLinearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    localLinearLayout2.setOrientation(1);
    ListView localListView1 = new ListView(paramContext);
    localListView1.setId(MMUSIA.RES_ID_LISTVIEW_APPUPDATE);
    localListView1.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    localListView1.setBackgroundColor(-1);
    localListView1.setCacheColorHint(-1);
    localListView1.setDividerHeight(0);
    localListView1.setClickable(true);
    LinearLayout localLinearLayout3 = new LinearLayout(paramContext);
    localLinearLayout3.setId(MMUSIA.RES_ID_TAB_NEWS);
    localLinearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    localLinearLayout3.setOrientation(1);
    ListView localListView2 = new ListView(paramContext);
    localListView2.setId(MMUSIA.RES_ID_LISTVIEW_NEWSLIST);
    localListView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    localListView2.setBackgroundColor(-1);
    localListView2.setCacheColorHint(-1);
    localListView2.setDividerHeight(0);
    localListView2.setClickable(true);
    paramContext = new TabWidget(paramContext);
    paramContext.setId(16908307);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramContext.setBackgroundColor(0);
    paramContext.setBaselineAligned(false);
    paramContext.setClipToPadding(true);
    paramContext.setDrawingCacheQuality(1048576);
    localLinearLayout2.addView(localListView1);
    localLinearLayout3.addView(localListView2);
    localFrameLayout.addView(localLinearLayout2);
    localFrameLayout.addView(localLinearLayout3);
    localLinearLayout1.addView(paramContext);
    localLinearLayout1.addView(localFrameLayout);
    localTabHost.addView(localLinearLayout1);
    addView(localTabHost);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/views/MainView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */