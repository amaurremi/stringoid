package logo.quiz.commons.utils.menu;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.bubble.adserwer.utils.DeviceUtils;
import java.io.Serializable;
import logo.quiz.commons.DeviceUtilCommons;
import logo.quiz.commons.R.bool;
import logo.quiz.commons.R.drawable;
import logo.quiz.commons.R.id;
import logo.quiz.commons.R.string;
import logo.quiz.commons.ScoreUtilProvider;
import logo.quiz.commons.utils.hints.HintsService;
import logo.quiz.commons.utils.hints.HintsServiceFactory;
import logo.quiz.commons.utils.score.ScoreService;
import logo.quiz.commons.utils.score.ScoreServiceFactory;

public class DefaultMenuService
  implements MenuService, Serializable
{
  static final long serialVersionUID = 2349003828846222884L;
  protected HintsService defaultHintsService = HintsServiceFactory.getInstance();
  protected ScoreService defaultScoreService = getScoreService(paramScoreUtilProvider);
  
  public DefaultMenuService(ScoreUtilProvider paramScoreUtilProvider) {}
  
  protected ScoreService getScoreService(ScoreUtilProvider paramScoreUtilProvider)
  {
    return ScoreServiceFactory.getInstance(paramScoreUtilProvider);
  }
  
  protected void refreshScore(int paramInt1, int paramInt2, Activity paramActivity, boolean paramBoolean)
  {
    int i = R.id.hintsLabelLevel;
    int j = R.id.hintsContainerLevel;
    int k = R.id.hintsCountLevel;
    int m = DeviceUtilCommons.getIdByName("hintsImg", paramActivity);
    int n = DeviceUtilCommons.getIdByName("hintsPlus", paramActivity);
    TextView localTextView1 = (TextView)paramActivity.findViewById(i);
    ViewGroup localViewGroup = (ViewGroup)paramActivity.findViewById(j);
    TextView localTextView2 = (TextView)paramActivity.findViewById(k);
    Object localObject = null;
    if (m != 0) {
      localObject = paramActivity.findViewById(m);
    }
    View localView = null;
    if (n != 0) {
      localView = paramActivity.findViewById(n);
    }
    if (localTextView1 != null)
    {
      boolean bool = paramActivity.getResources().getString(R.string.hints).equals(localTextView1.getText());
      if (((!paramBoolean) || (bool)) && ((paramBoolean) || (!bool))) {
        break label316;
      }
      localTextView1.setText(paramActivity.getResources().getString(R.string.logos));
      localTextView1.setTextScaleX(Float.valueOf(paramActivity.getResources().getString(R.string.scoreTextScaleX)).floatValue());
      localViewGroup.setBackgroundDrawable(paramActivity.getResources().getDrawable(DeviceUtilCommons.getDrawableIdByName("icon_score", paramActivity)));
      if (localObject != null)
      {
        ((ImageView)localObject).setImageResource(R.drawable.icon_score_img);
        if (!paramActivity.getResources().getBoolean(R.bool.isScoreIconVisible)) {
          break label305;
        }
        paramInt2 = 0;
        ((View)localObject).setVisibility(paramInt2);
      }
      localTextView2.setText(String.valueOf(paramInt1));
      if (localView != null)
      {
        localView.setVisibility(8);
        localObject = (ViewGroup.MarginLayoutParams)localViewGroup.getLayoutParams();
        paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        i = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
        if (!DeviceUtils.isTablet(paramActivity)) {
          break label311;
        }
        paramInt1 = 8;
        label286:
        ((ViewGroup.MarginLayoutParams)localObject).setMargins(paramInt2, i, DeviceUtilCommons.dip(paramInt1, paramActivity), ((ViewGroup.MarginLayoutParams)localObject).bottomMargin);
      }
    }
    label305:
    label311:
    label316:
    do
    {
      return;
      paramInt2 = 8;
      break;
      paramInt1 = 5;
      break label286;
      localTextView1.setText(paramActivity.getResources().getString(R.string.hints));
      localTextView1.setTextScaleX(Float.valueOf(paramActivity.getResources().getString(R.string.hintsTextScaleX)).floatValue());
      localViewGroup.setBackgroundDrawable(paramActivity.getResources().getDrawable(DeviceUtilCommons.getDrawableIdByName("icon_hint", paramActivity)));
      if (localObject != null)
      {
        ((ImageView)localObject).setImageResource(R.drawable.icon_hint_img);
        if (!paramActivity.getResources().getBoolean(R.bool.isHintsIconVisible)) {
          break label479;
        }
        paramInt1 = 0;
        ((View)localObject).setVisibility(paramInt1);
      }
      localTextView2.setText(String.valueOf(paramInt2));
    } while (localView == null);
    localView.setVisibility(0);
    localObject = (ViewGroup.MarginLayoutParams)localViewGroup.getLayoutParams();
    paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
    i = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
    if (DeviceUtils.isTablet(paramActivity)) {}
    for (paramInt1 = 38;; paramInt1 = 31)
    {
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(paramInt2, i, DeviceUtilCommons.dip(paramInt1, paramActivity), ((ViewGroup.MarginLayoutParams)localObject).bottomMargin);
      return;
      label479:
      paramInt1 = 8;
      break;
    }
  }
  
  public void refreshScore(Activity paramActivity)
  {
    refreshScore(paramActivity, true);
  }
  
  protected void refreshScore(Activity paramActivity, boolean paramBoolean)
  {
    refreshScore(this.defaultScoreService.getCompletedLogosCount(paramActivity.getApplicationContext()), this.defaultHintsService.getAvailibleHintsCount(paramActivity.getApplicationContext()), paramActivity, paramBoolean);
  }
  
  public void switchScore(Activity paramActivity)
  {
    refreshScore(paramActivity, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/menu/DefaultMenuService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */