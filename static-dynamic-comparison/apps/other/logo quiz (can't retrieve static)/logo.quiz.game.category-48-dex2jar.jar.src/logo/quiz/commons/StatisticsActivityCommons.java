package logo.quiz.commons;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.bubble.bugsense.BugSense;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import logo.quiz.commons.utils.menu.MenuService;
import logo.quiz.commons.utils.score.ScoreService;

public abstract class StatisticsActivityCommons
  extends LogoQuizAbstractActivity
{
  private int daysBetween(Date paramDate1, Date paramDate2)
  {
    return (int)((paramDate2.getTime() - paramDate1.getTime()) / 86400000L);
  }
  
  public static long getInstallTime(Context paramContext)
  {
    long l = -1L;
    try
    {
      if (Build.VERSION.SDK_INT >= 9) {
        l = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).firstInstallTime;
      }
      return l;
    }
    catch (NoSuchFieldError paramContext)
    {
      return -1L;
    }
    catch (Exception paramContext) {}
    return -1L;
  }
  
  protected int countAllScore(ScoreUtilProvider paramScoreUtilProvider)
  {
    int j = 0;
    paramScoreUtilProvider = paramScoreUtilProvider.getBrands(this);
    int k = paramScoreUtilProvider.length;
    int i = 0;
    while (i < k)
    {
      j += paramScoreUtilProvider[i].getLevel(getApplicationContext());
      i += 1;
    }
    return j;
  }
  
  protected int countLevelsCompleted(ScoreUtilProvider paramScoreUtilProvider)
  {
    int j = 0;
    paramScoreUtilProvider = paramScoreUtilProvider.getLevelsInfo(getApplicationContext());
    int m = paramScoreUtilProvider.length;
    int i = 0;
    while (i < m)
    {
      Object localObject = paramScoreUtilProvider[i];
      int k = j;
      if (((LevelInterface)localObject).getLogosCount() == getScoreService().getCompletedLogosCount(getApplicationContext(), ((LevelInterface)localObject).getId())) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  protected int countLevelsUnlocked(int paramInt, ScoreUtilProvider paramScoreUtilProvider)
  {
    int j = 0;
    paramScoreUtilProvider = paramScoreUtilProvider.getLevelsInfo(getApplicationContext());
    int m = paramScoreUtilProvider.length;
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (paramInt >= paramScoreUtilProvider[i].getUnlockLimit()) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  protected int countUsedHints()
  {
    return HintsUtil.getUsedHints(getApplicationContext());
  }
  
  protected abstract ScoreUtilProvider getScoreUtilProvider();
  
  public void onCreate(Bundle paramBundle)
  {
    overridePendingTransition(0, 0);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    super.onCreate(paramBundle, R.layout.statistics);
    if (!getResources().getBoolean(R.bool.isPoints))
    {
      findViewById(R.id.stats_points_container).setVisibility(8);
      findViewById(R.id.stats_points_separator).setVisibility(8);
    }
    Object localObject2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    Object localObject3 = (TextView)findViewById(R.id.statsGuessedLogos);
    TextView localTextView3 = (TextView)findViewById(R.id.statsGuessedLogosPercent);
    TextView localTextView4 = (TextView)findViewById(R.id.statsScore);
    TextView localTextView5 = (TextView)findViewById(R.id.statsScorePercent);
    TextView localTextView6 = (TextView)findViewById(R.id.statsLevelsUnlocked);
    TextView localTextView7 = (TextView)findViewById(R.id.statsLevelsUnlockedPercent);
    TextView localTextView8 = (TextView)findViewById(R.id.statsLevelsCompleted);
    TextView localTextView9 = (TextView)findViewById(R.id.statsLevelsCompletedPercent);
    TextView localTextView10 = (TextView)findViewById(R.id.statsAllHints);
    TextView localTextView11 = (TextView)findViewById(R.id.statsAllHintsPercent);
    paramBundle = (TextView)findViewById(R.id.statsUsedHints);
    TextView localTextView1 = (TextView)findViewById(R.id.statsUsedHintsPercent);
    TextView localTextView12 = (TextView)findViewById(R.id.statsGuessTries);
    TextView localTextView13 = (TextView)findViewById(R.id.statsGuessTriesPercent);
    TextView localTextView14 = (TextView)findViewById(R.id.statsPerfectGuessCount);
    TextView localTextView15 = (TextView)findViewById(R.id.statsPerfectGuessCountPercent);
    Object localObject1 = (TextView)findViewById(R.id.installTime);
    TextView localTextView2 = (TextView)findViewById(R.id.liveAppInDays);
    int j = getScoreService().getCompletedLogosCount(getApplicationContext());
    int k = getScoreUtilProvider().getBrandsCount(getApplicationContext());
    int m = (int)Math.ceil(j / k * 100.0F);
    int n = getScoreService().getCompletedPoints(this);
    int i1 = countAllScore(getScoreUtilProvider());
    int i2 = (int)Math.ceil(n / i1 * 100.0F);
    int i3 = countLevelsUnlocked(j, getScoreUtilProvider());
    int i4 = getScoreUtilProvider().getLevelsInfo(getApplicationContext()).length;
    int i5 = countLevelsCompleted(getScoreUtilProvider());
    int i6 = getScoreUtilProvider().getAvailibleHintsCount(this);
    getScoreUtilProvider().getBrandsCount(getApplicationContext());
    int i7 = countUsedHints();
    int i = 100;
    if (i6 > 0) {
      i = (int)Math.ceil(i7 / (i6 + i7) * 100.0F);
    }
    int i8 = ((SharedPreferences)localObject2).getInt("perfectGuess", 0);
    int i9 = (int)Math.ceil(i8 / j * 100.0F);
    int i10 = ((SharedPreferences)localObject2).getInt("guessTries", 0);
    ((TextView)localObject3).setText(j + "/" + k);
    localTextView3.setText(m + "%");
    localTextView4.setText(n + "/" + i1);
    localTextView5.setText(i2 + "%");
    localTextView6.setText(i3 + "/" + i4);
    localTextView7.setText("");
    localTextView8.setText(i5 + "/" + i4);
    localTextView9.setText("");
    localTextView10.setText(i6 + "");
    localTextView11.setText("");
    localTextView12.setText(i10 + "");
    localTextView13.setText("");
    localTextView14.setText(i8 + "");
    localTextView15.setText(i9 + "%");
    ((TextView)findViewById(R.id.menuInfo)).setText(getString(R.string.statistics));
    ((TextView)findViewById(R.id.hintsLabelLevel)).setText(getResources().getString(R.string.logos));
    long l = getInstallTime(getApplicationContext());
    if (l == -1L)
    {
      findViewById(R.id.installTimeContainer).setVisibility(8);
      findViewById(R.id.installTimeSep).setVisibility(8);
      findViewById(R.id.liveAppInDaysContainer).setVisibility(8);
      findViewById(R.id.liveAppInDaysSep).setVisibility(8);
    }
    for (;;)
    {
      localObject1 = new GregorianCalendar(2013, 9, 4).getTime();
      if (!new Date().after((Date)localObject1)) {
        break;
      }
      paramBundle.setText(i7 + "");
      localTextView1.setText(i + "%");
      return;
      localObject2 = new SimpleDateFormat();
      localObject3 = new Date(l);
      ((TextView)localObject1).setText(localObject2.format(localObject3).split(" ")[0]);
      localTextView2.setText(daysBetween((Date)localObject3, new Date()) + 1 + " " + getString(R.string.days));
    }
    findViewById(R.id.statsUsedHintsContainer).setVisibility(8);
    findViewById(R.id.statsUsedHintsSep).setVisibility(8);
  }
  
  public void onResume()
  {
    super.onResume();
    this.bugSense.addCrashExtraData("activity", getClass().getSimpleName());
    getMenuService().refreshScore(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/StatisticsActivityCommons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */