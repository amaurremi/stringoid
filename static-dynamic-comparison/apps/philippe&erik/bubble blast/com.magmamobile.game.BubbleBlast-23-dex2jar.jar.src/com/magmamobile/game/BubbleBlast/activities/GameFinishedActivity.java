package com.magmamobile.game.BubbleBlast.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.magmamobile.game.BubbleBlast.activities.adapters.ScoreloopScoresAdapter;
import com.magmamobile.game.BubbleBlast.engine.Enums.enumGameMode;
import com.magmamobile.game.BubbleBlast.engine.ScoreloopUtils;
import com.magmamobile.game.BubbleBlast.modPreferences;
import com.magmamobile.game.BubbleBlast.utils.GoogleAnalytics;
import com.magmamobile.game.BubbleBlast.utils.ScoreloopManager;
import com.magmamobile.game.BubbleBlast.utils.ScoreloopManager.BestScoresRetreiver;
import com.magmamobile.game.BubbleBlast.utils.ScoreloopManager.EventListener;

public class GameFinishedActivity
  extends Activity
  implements View.OnClickListener, ScoreloopManager.EventListener
{
  private TextView txtHighscoreMode;
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903043);
    this.txtHighscoreMode = ((TextView)findViewById(2131099694));
    Object localObject = getIntent().getExtras();
    int i = ((Bundle)localObject).getInt("score");
    int j = ((Bundle)localObject).getInt("level");
    paramBundle = Enums.enumGameMode.valueOf(((Bundle)localObject).getString("mode"));
    int k = ((Bundle)localObject).getInt("levelpack");
    ((TextView)findViewById(2131099675)).setText(i);
    findViewById(2131099676).setVisibility(0);
    findViewById(2131099677).setVisibility(0);
    ((TextView)findViewById(2131099677)).setText(j);
    switch (paramBundle)
    {
    }
    for (;;)
    {
      k = ScoreloopUtils.getScoreloopMode(paramBundle, k);
      saveBestPref(paramBundle, i, j);
      if ((i > 0) && (paramBundle == Enums.enumGameMode.arcade)) {
        ScoreloopManager.submitScore(1, i, k);
      }
      localObject = new ScoreloopManager.BestScoresRetreiver(k, this);
      try
      {
        ((ScoreloopManager.BestScoresRetreiver)localObject).retreive();
        modPreferences.savePreferences(this);
        GoogleAnalytics.trackAndDispatch("Finished/" + paramBundle.toString() + "/Level/" + j + "/Score/" + i);
        return;
        this.txtHighscoreMode.setText(getString(2131034149));
        continue;
        this.txtHighscoreMode.setText(getString(2131034148));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void onFail(Object paramObject)
  {
    findViewById(2131099663).setVisibility(8);
    paramObject = (ScoreloopManager.BestScoresRetreiver)paramObject;
  }
  
  public void onSucceed(Object paramObject)
  {
    findViewById(2131099663).setVisibility(8);
    paramObject = (ScoreloopManager.BestScoresRetreiver)paramObject;
    ListView localListView = (ListView)findViewById(2131099695);
    ScoreloopScoresAdapter localScoreloopScoresAdapter = new ScoreloopScoresAdapter(this);
    localScoreloopScoresAdapter.setData(((ScoreloopManager.BestScoresRetreiver)paramObject).getResults());
    localListView.setAdapter(localScoreloopScoresAdapter);
  }
  
  public void saveBestPref(Enums.enumGameMode paramenumGameMode, int paramInt1, int paramInt2)
  {
    switch (paramenumGameMode)
    {
    }
    for (;;)
    {
      modPreferences.savePreferences(this);
      return;
      if (modPreferences.prefBestArcadeLevel < paramInt2) {
        modPreferences.prefBestArcadeLevel = paramInt2;
      }
      if (modPreferences.prefBestArcadeScore < paramInt1) {
        modPreferences.prefBestArcadeScore = paramInt1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/activities/GameFinishedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */