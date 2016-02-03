package com.magmamobile.game.engine;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.magmamobile.game.engine.thirdparty.GoogleAnalytics;

public final class AskForRateManager
{
  private static final int COUNTER = 10;
  private static final String RES_ABOUT = "res_about";
  private static final String RES_APPNAME = "app_name";
  private static final String RES_ASKAGAIN = "chkNeverAskAgain";
  private static final String RES_ASKNO = "btnAskNo";
  private static final String RES_ASKRATING = "txtAskRating";
  private static final String RES_ASKYES = "btnAskYes";
  private static final String RES_ICON = "icon";
  private static final String RES_LAYOUT = "ask4rate";
  private static final String RES_RATETEXT = "ask4rate_text";
  private static boolean prefAsk4RateNeverAskAgain = false;
  private static int prefAskedMarketCount = 0;
  private static int prefGameCount = 0;
  
  private static void savePref()
  {
    Game.setPrefInt("prefGameCount", prefGameCount);
    Game.setPrefInt("prefAskedMarketCount", prefAskedMarketCount);
    Game.setPrefBoolean("prefAsk4RateNeverAskAgain", prefAsk4RateNeverAskAgain);
  }
  
  public static void show()
  {
    Game.postRunnable(new Runnable()
    {
      public void run() {}
    });
  }
  
  private static void showAsk4Rate()
  {
    Object localObject = Game.getContext();
    AlertDialog.Builder localBuilder = new AlertDialog.Builder((Context)localObject);
    View localView = LayoutInflater.from((Context)localObject).inflate(Game.getRLayout("ask4rate"), null);
    TextView localTextView = (TextView)localView.findViewById(Game.getRId("txtAskRating"));
    Button localButton1 = (Button)localView.findViewById(Game.getRId("btnAskYes"));
    Button localButton2 = (Button)localView.findViewById(Game.getRId("btnAskNo"));
    final CheckBox localCheckBox = (CheckBox)localView.findViewById(Game.getRId("chkNeverAskAgain"));
    localTextView.setText(Game.getResString(Game.getRString("ask4rate_text")).replace("¤1¤", Game.getResString(Game.getRString("app_name"))));
    localCheckBox.setChecked(false);
    localBuilder.setView(localView);
    localBuilder.setIcon(Game.getRDrawable("icon"));
    localBuilder.setCancelable(true);
    localBuilder.setTitle(((Context)localObject).getString(Game.getRString("res_about")));
    localObject = localBuilder.show();
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AskForRateManager.this.dismiss();
        Game.showMarketUpdate();
        AskForRateManager.prefAsk4RateNeverAskAgain = true;
        AskForRateManager.access$2();
        GoogleAnalytics.trackAndDispatch("Ask4Rate/Yes");
      }
    });
    localButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AskForRateManager.this.dismiss();
        AskForRateManager.prefAsk4RateNeverAskAgain = localCheckBox.isChecked();
        AskForRateManager.access$2();
        if (AskForRateManager.prefAsk4RateNeverAskAgain)
        {
          GoogleAnalytics.trackAndDispatch("Ask4Rate/Later/NeverAgain");
          return;
        }
        GoogleAnalytics.trackAndDispatch("Ask4Rate/Later");
      }
    });
  }
  
  public static void start()
  {
    prefGameCount = Game.getPrefInt("prefGameCount", 0);
    prefAskedMarketCount = Game.getPrefInt("prefAskedMarketCount", 0);
    prefAsk4RateNeverAskAgain = Game.getPrefBoolean("prefAsk4RateNeverAskAgain", false);
    if ((prefGameCount / 10 != prefAskedMarketCount) && (!prefAsk4RateNeverAskAgain) && (prefGameCount / 10 > 0))
    {
      prefAskedMarketCount = prefGameCount / 10;
      showAsk4Rate();
      savePref();
    }
    prefGameCount += 1;
    savePref();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/AskForRateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */