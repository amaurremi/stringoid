package mobi.beyondpod.rsscore;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import mobi.beyondpod.ui.commands.CommandManager;

public class AggregatorPreference
  extends Preference
{
  public static final String KEY = "DisconnectAggregatorFeeds";
  
  public AggregatorPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onBindView(View paramView)
  {
    super.onBindView(paramView);
  }
  
  protected void onClick() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/AggregatorPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */