package logo.quiz.commons.utils;

import android.app.Activity;
import android.view.View;
import com.bubble.adserwer.AdserwerBubble;
import com.bubble.adserwer.HouseAd;
import logo.quiz.commons.DeviceUtilCommons;
import logo.quiz.commons.R.id;

public class HouseAdUtils
{
  private Activity activity;
  private AdserwerBubble adserwer;
  private boolean showCloseButton = true;
  
  public HouseAdUtils(AdserwerBubble paramAdserwerBubble, Activity paramActivity)
  {
    this.adserwer = paramAdserwerBubble;
    this.activity = paramActivity;
  }
  
  private void showAd(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    label104:
    for (;;)
    {
      try
      {
        if (this.activity.findViewById(R.id.adContainer) != null)
        {
          if (!paramBoolean2) {
            break label104;
          }
          if ((!paramBoolean2) || (DeviceUtilCommons.isOnline(this.activity))) {
            continue;
          }
          break label104;
          if ((i != 0) && (new HouseAd(this.adserwer, this.activity).showAdForHints(paramInt, paramBoolean1)) && ((!DeviceUtilCommons.isOnline(this.activity)) || (!this.showCloseButton))) {
            this.activity.findViewById(R.id.todaysOfferClose).setVisibility(8);
          }
        }
        return;
        int i = 0;
        continue;
        i = 1;
      }
      catch (Exception localException)
      {
        return;
      }
    }
  }
  
  public void anim()
  {
    showAd(0, true, false);
  }
  
  public void anim(int paramInt)
  {
    showAd(paramInt, true, false);
  }
  
  public void animOnlyOffline()
  {
    showAd(0, true, true);
  }
  
  public void animOnlyOffline(int paramInt)
  {
    showAd(paramInt, true, true);
  }
  
  public void setShowCloseButton(boolean paramBoolean)
  {
    this.showCloseButton = paramBoolean;
  }
  
  public void show()
  {
    showAd(0, false, false);
  }
  
  public void show(int paramInt)
  {
    showAd(paramInt, false, false);
  }
  
  public void showOnlyOffline()
  {
    showAd(0, false, true);
  }
  
  public void showOnlyOffline(int paramInt)
  {
    showAd(paramInt, false, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/HouseAdUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */