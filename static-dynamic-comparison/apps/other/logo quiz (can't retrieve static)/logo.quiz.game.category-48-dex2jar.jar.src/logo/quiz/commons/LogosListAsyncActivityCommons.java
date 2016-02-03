package logo.quiz.commons;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.bluebird.mobile.tools.cache.BitmapCache;
import com.bubble.bugsense.BugSense;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import logo.quiz.commons.image.loader.PicassoOwnCache;
import logo.quiz.commons.utils.CacheFactory;
import logo.quiz.commons.utils.HouseAdUtils;
import logo.quiz.commons.utils.menu.MenuService;

public abstract class LogosListAsyncActivityCommons
  extends LogoQuizAbstractActivity
{
  private BitmapCache appImageCache;
  HouseAdUtils houseAdUtils;
  private BrandTO[] levelBrands;
  protected AbsListView listView;
  protected String logosFormActivityName = "LogosFormActivity";
  private LayoutInflater mInflater;
  Activity myActivity;
  
  private void refreshLogosGrid()
  {
    ((GridView)findViewById(R.id.logosGridView)).invalidateViews();
    getMenuService().refreshScore(this);
  }
  
  protected BrandTO[] getActiveLevelBrands()
  {
    int i = LevelUtil.getActiveLevel();
    return getScoreUtilProvider().getBrands(this, i);
  }
  
  protected int getBrandDrawable(BrandTO paramBrandTO)
  {
    return paramBrandTO.getDrawable();
  }
  
  protected String getBrandDrawableString(BrandTO paramBrandTO)
  {
    return paramBrandTO.getDrawableString();
  }
  
  public String getLogosFormActivityName()
  {
    return this.logosFormActivityName;
  }
  
  protected abstract ScoreUtilProvider getScoreUtilProvider();
  
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
    this.houseAdUtils = new HouseAdUtils(this.adserwer, this);
    this.houseAdUtils.anim(300);
    this.myActivity = this;
    this.mInflater = ((LayoutInflater)getSystemService("layout_inflater"));
    this.levelBrands = getActiveLevelBrands();
    this.appImageCache = CacheFactory.getAppCache(getApplicationContext());
    this.listView = ((GridView)findViewById(R.id.logosGridView));
    if (Build.VERSION.SDK_INT > 10) {
      this.listView.setOverScrollMode(2);
    }
    ((GridView)this.listView).setAdapter(new ImageAdapter());
    this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        BrandTO localBrandTO = (BrandTO)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
        PreferenceManager.getDefaultSharedPreferences(LogosListAsyncActivityCommons.this);
        paramAnonymousView = LogosListAsyncActivityCommons.this.getLogosFormActivityName();
        paramAnonymousAdapterView = paramAnonymousView;
        if (paramAnonymousView.equals("LogosFormActivity")) {
          if (!LogosListAsyncActivityCommons.this.getResources().getBoolean(R.bool.isSystemKeyboardOnGuessForm)) {
            break label145;
          }
        }
        label145:
        for (paramAnonymousAdapterView = "LogosFormOldActivity";; paramAnonymousAdapterView = "LogosFormActivity")
        {
          paramAnonymousAdapterView = new Intent(LogosListAsyncActivityCommons.this.getApplicationContext(), DeviceUtilCommons.getClassByName(LogosListAsyncActivityCommons.this.getApplicationContext(), paramAnonymousAdapterView));
          paramAnonymousAdapterView.putExtra("position", paramAnonymousInt);
          paramAnonymousAdapterView.putExtra("brandPosition", localBrandTO.getBrandPosition());
          paramAnonymousAdapterView.putExtra("brandNames", localBrandTO.getNames());
          paramAnonymousAdapterView.putExtra("brandDrawable", localBrandTO.getDrawable());
          paramAnonymousAdapterView.putExtra("brandTO", localBrandTO);
          LogosListAsyncActivityCommons.this.startActivityForResult(paramAnonymousAdapterView, paramAnonymousInt);
          return;
        }
      }
    });
    getMenuService().switchScore(this);
    paramBundle = getScoreUtilProvider().getLevelsInfo(getApplicationContext())[(LevelUtil.getActiveLevel() - 1)];
    TextView localTextView = (TextView)findViewById(R.id.menuInfo);
    if (paramBundle.getTo() == -1) {
      localTextView.setText(paramBundle.getCategory());
    }
    for (;;)
    {
      ((TextView)findViewById(R.id.hintsLabelLevel)).setText(getResources().getString(R.string.logos));
      return;
      localTextView.setText(getString(R.string.level) + " " + paramBundle.getId());
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.bugSense.addCrashExtraData("activity", getClass().getSimpleName());
    getMenuService().refreshScore(this);
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public class ImageAdapter
    extends BaseAdapter
  {
    public ImageAdapter() {}
    
    public int getCount()
    {
      return LogosListAsyncActivityCommons.this.getActiveLevelBrands().length;
    }
    
    public BrandTO getItem(int paramInt)
    {
      Object localObject = LogosListAsyncActivityCommons.this.getActiveLevelBrands();
      try
      {
        if (localObject.length == paramInt) {
          return localObject[(paramInt - 1)];
        }
        localObject = localObject[paramInt];
        return (BrandTO)localObject;
      }
      catch (Exception localException) {}
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = LogosListAsyncActivityCommons.this.mInflater.inflate(DeviceUtilCommons.getLayoutIdByName("logos_list_item", LogosListAsyncActivityCommons.this.myActivity), paramViewGroup, false);
        paramViewGroup = new LogosListAsyncActivityCommons.ViewHolder(LogosListAsyncActivityCommons.this);
        paramViewGroup.setImageView((ImageView)paramView.findViewById(R.id.list_item));
        paramViewGroup.setStarsView((ImageView)paramView.findViewById(R.id.list_item_stars));
        localObject = (ImageView)paramView.findViewById(R.id.list_item_correct);
        ((ImageView)localObject).setImageBitmap(LogosListAsyncActivityCommons.this.appImageCache.getBitmap(R.drawable.correct));
        paramViewGroup.setCorrectView((ImageView)localObject);
        paramView.setTag(paramViewGroup);
      }
      try
      {
        localObject = LogosListAsyncActivityCommons.this.levelBrands[paramInt];
        if (((BrandTO)localObject).isComplete())
        {
          paramInt = ((BrandTO)localObject).getLevelStars(LogosListAsyncActivityCommons.this.getApplicationContext());
          if (paramInt > 1)
          {
            paramViewGroup.getStarsView().setImageBitmap(LogosListAsyncActivityCommons.this.appImageCache.getBitmap(DeviceUtilCommons.getDrawableIdByName("grid_item_complete_bg_" + (paramInt - 1), LogosListAsyncActivityCommons.this.getApplicationContext())));
            paramViewGroup.getStarsView().setVisibility(0);
            label203:
            paramViewGroup.getCorrectView().setVisibility(0);
          }
        }
        for (;;)
        {
          Picasso localPicasso = PicassoOwnCache.with(LogosListAsyncActivityCommons.this.getApplicationContext());
          if (((BrandTO)localObject).getDrawable() == -1)
          {
            localObject = localPicasso.load(LogosListAsyncActivityCommons.this.getBrandDrawableString((BrandTO)localObject));
            ((RequestCreator)localObject).placeholder(R.drawable.loading_logo).error(R.drawable.no_internet).fit().centerCrop().into(paramViewGroup.getImageView());
            return paramView;
            paramViewGroup = (LogosListAsyncActivityCommons.ViewHolder)paramView.getTag();
            break;
            paramViewGroup.getStarsView().setImageBitmap(LogosListAsyncActivityCommons.this.appImageCache.getBitmap(DeviceUtilCommons.getDrawableIdByName("grid_item_complete_bg_1", LogosListAsyncActivityCommons.this.getApplicationContext())));
            paramViewGroup.getStarsView().setVisibility(4);
            break label203;
          }
          try
          {
            paramViewGroup.getStarsView().setImageBitmap(LogosListAsyncActivityCommons.this.appImageCache.getBitmap(DeviceUtilCommons.getDrawableIdByName("grid_item_bg_" + ((BrandTO)localObject).getLevel(LogosListAsyncActivityCommons.this.getApplicationContext()), LogosListAsyncActivityCommons.this.getApplicationContext())));
            paramViewGroup.getStarsView().setVisibility(4);
            paramViewGroup.getCorrectView().setVisibility(4);
            continue;
            localObject = localPicasso.load(Integer.parseInt(LogosListAsyncActivityCommons.this.getBrandDrawableString((BrandTO)localObject)));
          }
          catch (Exception localException)
          {
            for (;;) {}
          }
        }
      }
      catch (Exception paramViewGroup)
      {
        return paramView;
      }
    }
  }
  
  class ViewHolder
  {
    private ImageView correctView;
    private ImageView imageView;
    private ImageView starsView;
    
    ViewHolder() {}
    
    public ImageView getCorrectView()
    {
      return this.correctView;
    }
    
    public ImageView getImageView()
    {
      return this.imageView;
    }
    
    public ImageView getStarsView()
    {
      return this.starsView;
    }
    
    public void setCorrectView(ImageView paramImageView)
    {
      this.correctView = paramImageView;
    }
    
    public void setImageView(ImageView paramImageView)
    {
      this.imageView = paramImageView;
    }
    
    public void setStarsView(ImageView paramImageView)
    {
      this.starsView = paramImageView;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/LogosListAsyncActivityCommons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */