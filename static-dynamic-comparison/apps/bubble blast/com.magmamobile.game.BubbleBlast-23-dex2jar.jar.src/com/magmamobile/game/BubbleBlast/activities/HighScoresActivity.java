package com.magmamobile.game.BubbleBlast.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.magmamobile.game.BubbleBlast.activities.adapters.ScoreloopScoresAdapter;
import com.magmamobile.game.BubbleBlast.engine.Enums.enumGameMode;
import com.magmamobile.game.BubbleBlast.engine.ScoreloopUtils;
import com.magmamobile.game.BubbleBlast.utils.ScoreloopManager.BestScoresRetreiver;
import com.magmamobile.game.BubbleBlast.utils.ScoreloopManager.EventListener;

public class HighScoresActivity
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
    setContentView(2130903045);
    this.txtHighscoreMode = ((TextView)findViewById(2131099694));
    paramBundle = getIntent().getExtras();
    Enums.enumGameMode localenumGameMode = Enums.enumGameMode.valueOf(paramBundle.getString("mode"));
    int i = paramBundle.getInt("levelpack");
    switch (localenumGameMode)
    {
    }
    for (;;)
    {
      i = ScoreloopUtils.getScoreloopMode(localenumGameMode, i);
      try
      {
        new ScoreloopManager.BestScoresRetreiver(i, this).retreive();
        return;
      }
      catch (Exception paramBundle)
      {
        Toast.makeText(this, "Error occured while getting scores", 1).show();
        paramBundle.printStackTrace();
      }
      this.txtHighscoreMode.setText(getString(2131034149));
      continue;
      this.txtHighscoreMode.setText(getString(2131034148));
    }
  }
  
  public void onFail(Object paramObject)
  {
    paramObject = (ScoreloopManager.BestScoresRetreiver)paramObject;
    findViewById(2131099663).setVisibility(8);
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/activities/HighScoresActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */