package logo.quiz.commons;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;
import com.bubble.bugsense.BugSense;
import logo.quiz.commons.utils.menu.MenuService;

public abstract class LevelsActivityCommons
  extends LogoQuizAbstractActivity
{
  public static final String LOGOS_LIST_ACTIVITY_NAME = "LOGOS_LIST_ACTIVITY_NAME";
  protected int levelBg = R.drawable.bg_level_repeat;
  protected String logosListActivityName = "LogosListActivity";
  protected int scrollPosition = 0;
  protected int topScroll = 0;
  
  protected abstract ConstantsProvider getConstants();
  
  public int getLevelBg()
  {
    return this.levelBg;
  }
  
  protected LevelListAdapter getLevelListAdapter()
  {
    return new LevelListAdapter(this, getLogosListActivityName(), getScoreUtilProvider(), getOnLevelClickListener());
  }
  
  public String getLogosListActivityName()
  {
    return this.logosListActivityName;
  }
  
  protected OnLevelClickListener getOnLevelClickListener()
  {
    new OnLevelClickListener()
    {
      public void onClick(int paramAnonymousInt, View paramAnonymousView)
      {
        LevelsActivityCommons.this.startLevel(paramAnonymousInt, paramAnonymousView);
      }
    };
  }
  
  protected abstract ScoreUtilProvider getScoreUtilProvider();
  
  public void onCreate(Bundle paramBundle)
  {
    overridePendingTransition(0, 0);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    super.onCreate(paramBundle, R.layout.levels);
    paramBundle = (ListView)findViewById(R.id.levels_list_view);
    if (Build.VERSION.SDK_INT > 10) {
      paramBundle.setOverScrollMode(2);
    }
    TextView localTextView = new TextView(this);
    localTextView.setHeight(DeviceUtilCommons.dp(8.0F, getApplicationContext()));
    localTextView.setBackgroundColor(16777215);
    paramBundle.addHeaderView(localTextView);
    paramBundle.addFooterView(localTextView);
    ((TextView)findViewById(R.id.menuInfo)).setText(getString(R.string.levels));
    ((TextView)findViewById(R.id.hintsLabelLevel)).setText(getResources().getString(R.string.logos));
  }
  
  public void onResume()
  {
    super.onResume();
    if (LevelUtil.getActiveLevel() == 1)
    {
      this.scrollPosition = 0;
      this.topScroll = 0;
    }
    this.bugSense.addCrashExtraData("activity", getClass().getSimpleName());
    ListView localListView = (ListView)findViewById(R.id.levels_list_view);
    localListView.setAdapter(getLevelListAdapter());
    localListView.setSelectionFromTop(this.scrollPosition, this.topScroll);
    getMenuService().refreshScore(this);
  }
  
  protected void startLevel(int paramInt, View paramView)
  {
    this.scrollPosition = paramInt;
    this.topScroll = paramView.getTop();
    LevelUtil.setActiveLevel(getApplicationContext(), paramInt);
    paramView = new Intent(getApplicationContext(), DeviceUtilCommons.getClassByName(getApplicationContext(), getLogosListActivityName()));
    paramView.setFlags(335544320);
    paramView.putExtra("LOGOS_LIST_ACTIVITY_NAME", getLogosListActivityName());
    startActivity(paramView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/LevelsActivityCommons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */