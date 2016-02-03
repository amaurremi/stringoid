package logo.quiz.commons.tapjoy;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.tapjoy.TapjoyEarnedPointsNotifier;
import logo.quiz.commons.R.string;
import logo.quiz.commons.utils.menu.MenuService;

public class TapjoyEarnedPointsNotifierImpl
  implements TapjoyEarnedPointsNotifier
{
  private Activity activity;
  private MenuService menuService;
  
  public TapjoyEarnedPointsNotifierImpl(MenuService paramMenuService, Activity paramActivity)
  {
    this.menuService = paramMenuService;
    this.activity = paramActivity;
  }
  
  private void updateUiAfterTapJoy(final int paramInt)
  {
    this.activity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(TapjoyEarnedPointsNotifierImpl.this.activity.getApplicationContext());
        SharedPreferences.Editor localEditor = localSharedPreferences.edit();
        if (paramInt > 0)
        {
          int i = localSharedPreferences.getInt("allHints", 0);
          localEditor.putInt("allHints", paramInt + i);
          localEditor.commit();
          Toast.makeText(TapjoyEarnedPointsNotifierImpl.this.activity.getApplicationContext(), TapjoyEarnedPointsNotifierImpl.this.activity.getString(R.string.adserwer_you_get_x_new_hints, new Object[] { Integer.valueOf(paramInt) }), 1).show();
          TapjoyEarnedPointsNotifierImpl.this.menuService.refreshScore(TapjoyEarnedPointsNotifierImpl.this.activity);
        }
      }
    });
  }
  
  public void earnedTapPoints(int paramInt)
  {
    updateUiAfterTapJoy(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/tapjoy/TapjoyEarnedPointsNotifierImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */