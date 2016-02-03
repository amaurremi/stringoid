package com.bluebird.mobile.tools.autopromotion;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bluebird.mobile.tools.commonutils.GoogleAnalyticsUtils;
import java.util.Iterator;
import java.util.List;

public class ApplicationsListView
  extends ScrollView
{
  public ApplicationsListView(Context paramContext, int paramInt, List<? extends Application> paramList)
  {
    super(paramContext);
    LayoutInflater localLayoutInflater = (LayoutInflater)paramContext.getSystemService("layout_inflater");
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    localLinearLayout.setOrientation(1);
    setVerticalFadingEdgeEnabled(true);
    setVerticalScrollBarEnabled(false);
    addView(localLinearLayout);
    addApplicationsToScrollView(paramContext, paramInt, paramList, localLayoutInflater, localLinearLayout);
  }
  
  private void addApplicationsToScrollView(final Context paramContext, int paramInt, List<? extends Application> paramList, LayoutInflater paramLayoutInflater, LinearLayout paramLinearLayout)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      final Application localApplication = (Application)paramList.next();
      if (!localApplication.getAppPackage().equals(paramContext.getPackageName()))
      {
        View localView = paramLayoutInflater.inflate(paramInt, paramLinearLayout, false);
        ((ImageView)localView.findViewById(getResourceId("app_logo"))).setImageResource(localApplication.getIconResourceId());
        ((TextView)localView.findViewById(getResourceId("app_name"))).setText(localApplication.getUserFriendlyName());
        ((TextView)localView.findViewById(getResourceId("app_recommendation"))).setText(localApplication.getRecommendation());
        localView.findViewById(getResourceId("download_button")).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            paramAnonymousView = GoogleAnalyticsUtils.getIntentToAppWithAnalytics(localApplication.getAppPackage(), "our_apps", paramContext);
            paramContext.startActivity(paramAnonymousView);
          }
        });
        paramLinearLayout.addView(localView);
      }
    }
  }
  
  private int getResourceId(String paramString)
  {
    return getContext().getResources().getIdentifier(paramString, "id", getContext().getPackageName());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/autopromotion/ApplicationsListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */