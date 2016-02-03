package logo.quiz.commons;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import logo.quiz.commons.utils.DeviceUtils;
import logo.quiz.commons.utils.menu.MenuService;

public abstract class LogosListActivityCommons
  extends LogoQuizAbstractActivity
{
  protected String logosFormActivityName = "LogosFormActivity";
  private String logosListActivityName;
  private final int mobileCompressSize = 80;
  Activity myActivity;
  private final int tabletCompressSize = 150;
  
  private void refreshLogosGrid()
  {
    ((GridView)findViewById(R.id.logosGridView)).invalidateViews();
    getMenuService().refreshScore(this);
  }
  
  protected int getBrandDrawable(BrandTO paramBrandTO)
  {
    return paramBrandTO.getDrawable();
  }
  
  protected int getImageCompressSize()
  {
    if (DeviceUtils.isTablet(getApplicationContext())) {
      return getTabletCompressSize();
    }
    return getMobileCompressSize();
  }
  
  public String getLogosFormActivityName()
  {
    return this.logosFormActivityName;
  }
  
  public int getMobileCompressSize()
  {
    return 80;
  }
  
  protected abstract ScoreUtilProvider getScoreUtilProvider();
  
  public int getTabletCompressSize()
  {
    return 150;
  }
  
  protected boolean isAddmobOn()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 >= 0) {
      refreshLogosGrid();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    overridePendingTransition(0, 0);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    setAdmobShowDelay(3000);
    super.onCreate(paramBundle, R.layout.logos_list);
    this.myActivity = this;
    paramBundle = (GridView)findViewById(R.id.logosGridView);
    paramBundle.setAdapter(new ImageAdapterCommons(getImageCompressSize(), this, getScoreUtilProvider()));
    paramBundle.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = (BrandTO)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
        LogosListActivityCommons.this.onLogoClick(paramAnonymousInt, paramAnonymousAdapterView);
      }
    });
    if (Build.VERSION.SDK_INT > 10) {
      paramBundle.setOverScrollMode(2);
    }
    getMenuService().switchScore(this);
    paramBundle = getScoreUtilProvider().getLevelsInfo(getApplicationContext())[(LevelUtil.getActiveLevel() - 1)];
    TextView localTextView = (TextView)findViewById(R.id.menuInfo);
    if (localTextView != null)
    {
      if (paramBundle.getTo() != -1) {
        break label203;
      }
      localTextView.setText(paramBundle.getCategory());
    }
    for (;;)
    {
      ((TextView)findViewById(R.id.hintsLabelLevel)).setText(getResources().getString(R.string.logos));
      this.logosListActivityName = getIntent().getStringExtra("LOGOS_LIST_ACTIVITY_NAME");
      return;
      label203:
      localTextView.setText(getString(R.string.level) + " " + paramBundle.getId());
    }
  }
  
  protected void onLogoClick(int paramInt, BrandTO paramBrandTO)
  {
    openFormActivity(paramInt, paramBrandTO);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.logosListActivityName = paramIntent.getStringExtra("LOGOS_LIST_ACTIVITY_NAME");
  }
  
  public void onResume()
  {
    super.onResume();
    getMenuService().refreshScore(this);
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  protected void openFormActivity(int paramInt, BrandTO paramBrandTO)
  {
    String str = getLogosFormActivityName();
    Object localObject = str;
    if (str.equals("LogosFormActivity")) {
      if (!getResources().getBoolean(R.bool.isSystemKeyboardOnGuessForm)) {
        break label128;
      }
    }
    label128:
    for (localObject = "LogosFormOldActivity";; localObject = "LogosFormActivity")
    {
      localObject = new Intent(getApplicationContext(), DeviceUtilCommons.getClassByName(getApplicationContext(), (String)localObject));
      ((Intent)localObject).putExtra("position", paramInt);
      ((Intent)localObject).putExtra("brandPosition", paramBrandTO.getBrandPosition());
      ((Intent)localObject).putExtra("brandNames", paramBrandTO.getNames());
      ((Intent)localObject).putExtra("brandDrawable", paramBrandTO.getDrawable());
      ((Intent)localObject).putExtra("brandTO", paramBrandTO);
      ((Intent)localObject).putExtra("LOGOS_LIST_ACTIVITY_NAME", this.logosListActivityName);
      startActivityForResult((Intent)localObject, paramInt);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/LogosListActivityCommons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */