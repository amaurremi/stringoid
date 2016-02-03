package logo.quiz.commons;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.bluebird.mobile.tools.cache.BitmapCache;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoTools;
import com.squareup.picasso.RequestCreator;
import logo.quiz.commons.image.loader.PicassoOwnCache;
import logo.quiz.commons.utils.CacheFactory;
import logo.quiz.commons.utils.DeviceUtils;
import logo.quiz.commons.utils.image.AsyncDrawable;
import logo.quiz.commons.utils.image.BitmapWorkerTask;
import logo.quiz.commons.utils.image.ImageUtils;

public class ImageAdapterCommons
  extends BaseAdapter
{
  public static final String IS_LOWER_MEMORY_DEVICE = "isLowerMemoryDevice";
  private BitmapCache appImageCache;
  protected Context context;
  boolean hasLogoSize = false;
  public int imageCompressSize = 80;
  private boolean isLowerMemoryDevice = false;
  private boolean isTablet = false;
  protected LayoutInflater layoutInflater;
  private BrandTO[] levelBrands;
  int lowTargetWidth;
  private Picasso picasso;
  RequestCreator picassoRequest;
  private final Bitmap placeHolderBitmap;
  private final BitmapDrawable placeHolderBitmapDrawable;
  int targetWidth;
  
  public ImageAdapterCommons(int paramInt, Activity paramActivity, ScoreUtilProvider paramScoreUtilProvider)
  {
    this.context = paramActivity.getApplicationContext();
    this.layoutInflater = ((LayoutInflater)this.context.getSystemService("layout_inflater"));
    int i = LevelUtil.getActiveLevel();
    this.levelBrands = paramScoreUtilProvider.getBrands(this.context, i);
    this.imageCompressSize = paramInt;
    this.placeHolderBitmap = ImageUtils.decodeSampledBitmapFromResource(paramActivity.getResources(), R.drawable.loading_logo, paramInt, paramInt);
    this.placeHolderBitmapDrawable = new BitmapDrawable(paramActivity.getResources(), this.placeHolderBitmap);
    this.appImageCache = CacheFactory.getAppCache(this.context);
    this.isTablet = DeviceUtils.isTablet(this.context);
    this.picasso = PicassoOwnCache.with(this.context);
    this.isLowerMemoryDevice = PreferenceManager.getDefaultSharedPreferences(this.context).getBoolean("isLowerMemoryDevice", false);
  }
  
  private void loadBitmap(ImageView paramImageView, int paramInt, String paramString, boolean paramBoolean)
  {
    Object localObject = ImageUtils.getImageFromCache(paramString);
    if (localObject != null) {
      paramImageView.setImageBitmap((Bitmap)localObject);
    }
    while (!BitmapWorkerTask.cancelPotentialWork(paramString, paramImageView)) {
      return;
    }
    if ((paramBoolean) && (!this.isTablet)) {}
    for (int i = this.imageCompressSize * 2;; i = this.imageCompressSize)
    {
      localObject = new BitmapWorkerTask(paramImageView, i, this.context.getResources(), this.context);
      paramImageView.setImageDrawable(new AsyncDrawable(this.context.getResources(), this.placeHolderBitmap, (BitmapWorkerTask)localObject));
      ((BitmapWorkerTask)localObject).execute(new String[] { String.valueOf(paramInt), paramString });
      return;
    }
  }
  
  private void loadBitmapPicasso(final BrandTO paramBrandTO, final ImageView paramImageView)
  {
    if (this.picasso == null) {
      this.picasso = PicassoOwnCache.with(this.context);
    }
    int i;
    label66:
    label96:
    RequestCreator localRequestCreator;
    if (paramBrandTO.getDrawable() == -1)
    {
      this.picassoRequest = this.picasso.load(paramBrandTO.getDrawableString());
      if (!this.hasLogoSize)
      {
        if (!this.context.getResources().getBoolean(R.bool.isLowDensityDevice)) {
          break label185;
        }
        i = 1;
        j = paramImageView.getMeasuredWidth();
        if (j == 0) {
          break label190;
        }
        this.targetWidth = (j / i);
        this.lowTargetWidth = j;
        this.hasLogoSize = true;
      }
      localRequestCreator = this.picassoRequest.placeholder(this.placeHolderBitmapDrawable).error(R.drawable.no_internet).noFade();
      if (!paramBrandTO.isLowQuality()) {
        break label217;
      }
      i = this.lowTargetWidth;
      label130:
      if (!paramBrandTO.isLowQuality()) {
        break label225;
      }
    }
    label185:
    label190:
    label217:
    label225:
    for (int j = this.lowTargetWidth;; j = this.targetWidth)
    {
      localRequestCreator.resize(i, j).into(paramImageView, new Callback()
      {
        public void onError()
        {
          ImageAdapterCommons.this.onOutOfMemoryError(paramImageView, paramBrandTO);
        }
        
        public void onSuccess() {}
      });
      return;
      this.picassoRequest = this.picasso.load(getLogoDrawableId(paramBrandTO));
      break;
      i = 2;
      break label66;
      this.targetWidth = (DeviceUtilCommons.getLogoSize(this.context) / i);
      this.lowTargetWidth = DeviceUtilCommons.getLogoSize(this.context);
      break label96;
      i = this.targetWidth;
      break label130;
    }
  }
  
  private void onOutOfMemoryError(ImageView paramImageView, BrandTO paramBrandTO)
  {
    this.isLowerMemoryDevice = true;
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
    localEditor.putBoolean("isLowerMemoryDevice", true);
    localEditor.commit();
    PicassoTools.clearCache(this.picasso);
    loadBitmap(paramImageView, getLogoDrawableId(paramBrandTO), paramBrandTO.getImgName(), paramBrandTO.isLowQuality());
  }
  
  public int getCount()
  {
    return this.levelBrands.length;
  }
  
  public BrandTO getItem(int paramInt)
  {
    return this.levelBrands[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  protected int getLogoDrawableId(BrandTO paramBrandTO)
  {
    return paramBrandTO.getDrawable();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    BrandTO localBrandTO;
    ImageView localImageView;
    if (paramView == null)
    {
      paramViewGroup = new ViewHolder();
      paramView = this.layoutInflater.inflate(DeviceUtilCommons.getLayoutIdByName("logos_list_item", this.context), null);
      paramViewGroup.setImageView((ImageView)paramView.findViewById(R.id.list_item));
      paramViewGroup.setCorrectView((ImageView)paramView.findViewById(R.id.list_item_correct));
      paramViewGroup.setStarsView((ImageView)paramView.findViewById(R.id.list_item_stars));
      paramView.setTag(paramViewGroup);
      localBrandTO = this.levelBrands[paramInt];
      localImageView = paramViewGroup.getStarsView();
      if (!localBrandTO.isComplete()) {
        break label229;
      }
      paramViewGroup.getCorrectView().setVisibility(0);
      if (this.context.getResources().getBoolean(R.bool.isListLogoAlpha)) {
        paramViewGroup.getImageView().setAlpha(1.0F);
      }
      if (localImageView != null) {
        localImageView.setImageBitmap(this.appImageCache.getBitmap(DeviceUtilCommons.getDrawableIdByName("grid_item_complete_bg_" + localBrandTO.getLevel(this.context), this.context)));
      }
    }
    for (;;)
    {
      if (!this.isLowerMemoryDevice) {
        break label320;
      }
      loadBitmap(paramViewGroup.getImageView(), getLogoDrawableId(localBrandTO), localBrandTO.getImgName(), localBrandTO.isLowQuality());
      return paramView;
      paramViewGroup = (ViewHolder)paramView.getTag();
      break;
      label229:
      paramViewGroup.getCorrectView().setVisibility(4);
      if (this.context.getResources().getBoolean(R.bool.isListLogoAlpha)) {
        paramViewGroup.getImageView().setAlpha(0.7F);
      }
      if (localImageView != null) {
        paramViewGroup.getStarsView().setImageBitmap(this.appImageCache.getBitmap(DeviceUtilCommons.getDrawableIdByName("grid_item_bg_" + localBrandTO.getLevel(this.context), this.context)));
      }
    }
    label320:
    loadBitmapPicasso(localBrandTO, paramViewGroup.getImageView());
    return paramView;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/ImageAdapterCommons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */