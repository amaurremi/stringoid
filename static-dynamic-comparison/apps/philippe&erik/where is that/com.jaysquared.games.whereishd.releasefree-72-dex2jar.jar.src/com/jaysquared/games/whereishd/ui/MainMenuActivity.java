package com.jaysquared.games.whereishd.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.google.analytics.tracking.android.EasyTracker;
import com.jaysquared.games.whereishd.ApplicationManager;
import com.jaysquared.games.whereishd.GameManager;
import com.jaysquared.games.whereishd.ReleaseConfiguration;
import com.jaysquared.games.whereishd.ads.MoPubInterstitialAd;
import com.jaysquared.games.whereishd.db.Categories;
import com.jaysquared.games.whereishd.db.CategoriesUserdata;
import com.jaysquared.games.whereishd.db.DatabaseManager;
import com.jaysquared.games.whereishd.utils.GamePlayMode;
import com.jaysquared.games.whereishd.utils.PayStatus;
import com.jaysquared.games.whereishd.utils.PersistantSettings;
import com.jaysquared.games.whereishd.utils.SLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.osmdroid.util.BoundingBoxE6;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedIconOverlay.OnItemGestureListener;
import org.osmdroid.views.overlay.ItemizedOverlay;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.OverlayItem.HotspotPlace;

public class MainMenuActivity
  extends MapDbBaseActivity
  implements RadioGroup.OnCheckedChangeListener
{
  private static final String LOG_TAG = MainMenuActivity.class.getSimpleName();
  private static final int REQUEST_CODE_ONE = 1;
  public static final int RESULT_START_NEW_AND_CLOSE = 90001;
  private FrameLayout banner_hd;
  private List<Categories> categories;
  private ItemizedOverlay<OverlayItem> categoryOverlay;
  private ItemizedOverlay<OverlayItem> detailCategoryOverlay;
  Handler handler;
  private ImageButton infoBtn;
  private MoPubInterstitialAd interstitialAd;
  private Button learningBtn;
  public GestureDetector mGestureDetector;
  private Button multiplayerBtn;
  private Button quickStartBtn;
  private ImageButton settingsBtn;
  
  @SuppressLint({"DefaultLocale"})
  private void addDetailOverlay(Categories paramCategories)
  {
    SLog.d(LOG_TAG, "categories add detail overlay");
    Object localObject = DatabaseManager.getInstance().getCategoryUserdata(paramCategories.getUuid());
    removeDetailCategoryOverlay();
    ArrayList localArrayList = new ArrayList();
    OverlayItem localOverlayItem = new OverlayItem(paramCategories.getTitle(), paramCategories.getUuid(), paramCategories.getIconPoint());
    localOverlayItem.setMarkerHotspot(OverlayItem.HotspotPlace.BOTTOM_CENTER);
    String str1 = str(2131427405);
    if (((CategoriesUserdata)localObject).getHighscore() != 0) {
      str1 = String.format("%,d", new Object[] { Integer.valueOf(((CategoriesUserdata)localObject).getHighscore()) });
    }
    int i = getBubbleBackgroundResource(paramCategories);
    localObject = "drawable/info_".concat(paramCategories.getIcon());
    Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), getResources().getIdentifier((String)localObject, null, getPackageName()));
    String[] arrayOfString = paramCategories.getTitle().split(">");
    String str2 = "";
    String str3 = "";
    localObject = str2;
    paramCategories = str3;
    if (arrayOfString != null)
    {
      localObject = str2;
      paramCategories = str3;
      if (arrayOfString.length > 1)
      {
        localObject = arrayOfString[0];
        paramCategories = arrayOfString[1];
      }
    }
    paramCategories = renderDetailView(str1, localBitmap, (String)localObject, paramCategories, i);
    localOverlayItem.setMarker(new BitmapDrawable(getResources(), paramCategories));
    localArrayList.add(localOverlayItem);
    this.detailCategoryOverlay = new ItemizedIconOverlay(localArrayList, new ItemizedIconOverlay.OnItemGestureListener()
    {
      public boolean onItemLongPress(int paramAnonymousInt, OverlayItem paramAnonymousOverlayItem)
      {
        return true;
      }
      
      public boolean onItemSingleTapUp(int paramAnonymousInt, OverlayItem paramAnonymousOverlayItem)
      {
        SLog.d(MainMenuActivity.LOG_TAG, "categories on item single tap up");
        MainMenuActivity.this.startGame(paramAnonymousOverlayItem.getSnippet(), false);
        return true;
      }
    }, this.resourceProxy);
    this.mapView.getOverlays().add(this.detailCategoryOverlay);
    this.mapView.invalidate();
  }
  
  private int getBubbleBackgroundResource(Categories paramCategories)
  {
    paramCategories = DatabaseManager.getInstance().getCategoryUserdata(paramCategories.getUuid());
    if (paramCategories.getHighscore() == 0) {
      return 2130837607;
    }
    if (paramCategories.getHighscore() >= 200000.0D) {
      return 2130837613;
    }
    if (paramCategories.getHighscore() >= 120000.0D) {
      return 2130837617;
    }
    return 2130837621;
  }
  
  private int getBubbleResource(Categories paramCategories)
  {
    paramCategories = DatabaseManager.getInstance().getCategoryUserdata(paramCategories.getUuid());
    if (paramCategories.getHighscore() == 0) {
      return 2130837604;
    }
    if (paramCategories.getHighscore() >= 200000.0D) {
      return 2130837611;
    }
    if (paramCategories.getHighscore() >= 120000.0D) {
      return 2130837615;
    }
    return 2130837619;
  }
  
  public static Bitmap loadBitmapFromView(View paramView)
  {
    Bitmap localBitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(localBitmap));
    return localBitmap;
  }
  
  private void refreshGamePlay()
  {
    switch (ApplicationManager.getInstance().getGameManager().getGamePlayMode())
    {
    default: 
      return;
    case ???: 
      this.multiplayerBtn.setText(str(2131427396) + " " + str(2131427395));
      this.multiplayerBtn.setBackgroundResource(2130837644);
      this.learningBtn.setText(str(2131427382));
      this.learningBtn.setBackgroundResource(2130837598);
      this.quickStartBtn.setText(str(2131427408));
      this.quickStartBtn.setBackgroundResource(2130837598);
      return;
    case ???: 
      this.multiplayerBtn.setText(str(2131427396));
      this.multiplayerBtn.setBackgroundResource(2130837598);
      this.learningBtn.setText(str(2131427382) + " " + str(2131427395));
      this.learningBtn.setBackgroundResource(2130837644);
      this.quickStartBtn.setText(str(2131427408));
      this.quickStartBtn.setBackgroundResource(2130837598);
      return;
    }
    this.multiplayerBtn.setText(str(2131427396));
    this.multiplayerBtn.setBackgroundResource(2130837598);
    this.learningBtn.setText(str(2131427382));
    this.learningBtn.setBackgroundResource(2130837598);
    this.quickStartBtn.setBackgroundResource(2130837598);
  }
  
  private Bitmap renderDetailView(String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, int paramInt)
  {
    LinearLayout localLinearLayout = (LinearLayout)((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903065, null);
    ((LinearLayout)localLinearLayout.findViewWithTag("inner")).setBackgroundDrawable(getResources().getDrawable(paramInt));
    Typeface localTypeface = ApplicationManager.getInstance().getGameManager().getTypeface();
    TextView localTextView = (TextView)localLinearLayout.findViewWithTag("title");
    localTextView.setTypeface(localTypeface);
    localTextView.setText(paramString1);
    ((ImageView)localLinearLayout.findViewWithTag("icon")).setImageBitmap(paramBitmap);
    paramString1 = (TextView)localLinearLayout.findViewWithTag("category");
    paramString1.setTypeface(localTypeface);
    paramString1.setText(paramString2);
    paramString1 = (TextView)localLinearLayout.findViewWithTag("subcategory");
    paramString1.setTypeface(localTypeface);
    paramString1.setText(paramString3);
    ((Button)localLinearLayout.findViewWithTag("start")).setTypeface(localTypeface);
    localLinearLayout.measure(-2, -2);
    localLinearLayout.layout(0, 0, localLinearLayout.getMeasuredWidth(), localLinearLayout.getMeasuredHeight());
    paramString1 = Bitmap.createBitmap(localLinearLayout.getMeasuredWidth(), localLinearLayout.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    localLinearLayout.draw(new Canvas(paramString1));
    return paramString1;
  }
  
  private void setupCategories()
  {
    this.categories = DatabaseManager.getInstance().getAllCategories();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.categories.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Categories)localIterator.next();
      int i = getBubbleResource((Categories)localObject1);
      OverlayItem localOverlayItem = new OverlayItem(((Categories)localObject1).getTitle(), ((Categories)localObject1).getUuid(), ((Categories)localObject1).getIconPoint());
      localOverlayItem.setMarkerHotspot(OverlayItem.HotspotPlace.BOTTOM_CENTER);
      Object localObject2 = "drawable/".concat(((Categories)localObject1).getIcon());
      Resources localResources = getResources();
      localObject1 = BitmapFactory.decodeResource(localResources, i).copy(Bitmap.Config.ARGB_8888, true);
      localObject2 = BitmapFactory.decodeResource(localResources, localResources.getIdentifier((String)localObject2, null, getPackageName()));
      new Canvas((Bitmap)localObject1).drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, new Paint());
      localObject1 = new BitmapDrawable(getResources(), (Bitmap)localObject1);
      ((BitmapDrawable)localObject1).setAlpha(230);
      localOverlayItem.setMarker((Drawable)localObject1);
      localArrayList.add(localOverlayItem);
    }
    this.categoryOverlay = new ItemizedIconOverlay(localArrayList, new ItemizedIconOverlay.OnItemGestureListener()
    {
      public boolean onItemLongPress(int paramAnonymousInt, OverlayItem paramAnonymousOverlayItem)
      {
        SLog.d(MainMenuActivity.LOG_TAG, "categories on item long press");
        MainMenuActivity.this.showDetails(paramAnonymousOverlayItem);
        return true;
      }
      
      public boolean onItemSingleTapUp(int paramAnonymousInt, OverlayItem paramAnonymousOverlayItem)
      {
        SLog.d(MainMenuActivity.LOG_TAG, "categories on item single tap up");
        MainMenuActivity.this.showDetails(paramAnonymousOverlayItem);
        return true;
      }
    }, this.resourceProxy);
    this.mapView.getOverlays().add(this.categoryOverlay);
  }
  
  private void setupViews()
  {
    this.settingsBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(MainMenuActivity.this, SettingsDialogActivity.class);
        MainMenuActivity.this.startActivityForResult(paramAnonymousView, 1);
      }
    });
    this.infoBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(MainMenuActivity.this, InfoDialogActivity.class);
        MainMenuActivity.this.startActivityForResult(paramAnonymousView, 1);
      }
    });
    this.multiplayerBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = ApplicationManager.getInstance().getGameManager();
        if (paramAnonymousView.getGamePlayMode() == GamePlayMode.MULTIPLAYER)
        {
          paramAnonymousView.setGamePlayMode(GamePlayMode.UNSET);
          MainMenuActivity.this.refreshGamePlay();
          return;
        }
        paramAnonymousView = new Intent(MainMenuActivity.this, MultiplayerDialogActivity.class);
        MainMenuActivity.this.startActivityForResult(paramAnonymousView, 1);
      }
    });
    this.learningBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ApplicationManager.getInstance().getGameManager().getGamePlayMode() == GamePlayMode.LEARNINGMODE) {
          ApplicationManager.getInstance().getGameManager().setGamePlayMode(GamePlayMode.UNSET);
        }
        for (;;)
        {
          MainMenuActivity.this.refreshGamePlay();
          return;
          ApplicationManager.getInstance().getGameManager().setGamePlayMode(GamePlayMode.LEARNINGMODE);
        }
      }
    });
    this.quickStartBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ApplicationManager.getInstance().getGameManager().setGamePlayMode(GamePlayMode.QUICKGAME);
        paramAnonymousView = new Intent(MainMenuActivity.this, GameActivity.class);
        Bundle localBundle = new Bundle();
        localBundle.putString("category_id", "bd40c4f3-fdaa-11e2-a684-bc764e04eb87");
        if (ApplicationManager.getInstance().getGameManager().getGamePlayMode() == GamePlayMode.MULTIPLAYER) {
          localBundle.putString("play", "multiplayer");
        }
        paramAnonymousView.putExtras(localBundle);
        MainMenuActivity.this.startActivity(paramAnonymousView);
        MainMenuActivity.this.finish();
      }
    });
  }
  
  private void showDetails(OverlayItem paramOverlayItem)
  {
    addDetailOverlay(DatabaseManager.getInstance().getCategory(paramOverlayItem.getSnippet()));
  }
  
  private void startGame(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    if (paramString != null) {
      localBundle.putString("category_id", paramString);
    }
    if (ApplicationManager.getInstance().getGameManager().getGamePlayMode() == GamePlayMode.LEARNINGMODE)
    {
      startLearningModeDialog(localBundle);
      return;
    }
    paramString = new Intent(this, GameActivity.class);
    if (paramBoolean)
    {
      localBundle.putString("Play", "MultiPlayer");
      ApplicationManager.getInstance().getGameManager().setGamePlayMode(GamePlayMode.MULTIPLAYER);
    }
    if (ApplicationManager.getInstance().getGameManager().getGamePlayMode() == GamePlayMode.MULTIPLAYER) {
      localBundle.putString("play", "multiplayer");
    }
    for (;;)
    {
      paramString.putExtras(localBundle);
      startActivity(paramString);
      finish();
      return;
      ApplicationManager.getInstance().getGameManager().setGamePlayMode(GamePlayMode.QUICKGAME);
    }
  }
  
  private void startLearningModeDialog(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this, LearningModeDialogActivity.class);
    localIntent.putExtras(paramBundle);
    startActivityForResult(localIntent, 1);
  }
  
  public void loadView()
  {
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        if (MainMenuActivity.this.mapView.getBoundingBox().getLatNorthE6() > 0)
        {
          BoundingBoxE6 localBoundingBoxE6 = new BoundingBoxE6(55.0D, 120.0D, 10.0D, -120.0D);
          MainMenuActivity.this.mapView.zoomToBoundingBox(localBoundingBoxE6);
        }
        for (;;)
        {
          ((FrameLayout)MainMenuActivity.this.findViewById(2131230811)).setVisibility(8);
          return;
          MainMenuActivity.this.handler.postDelayed(this, 500L);
        }
      }
    };
    this.handler.postDelayed(local1, 500L);
    SLog.d(LOG_TAG, "jmap loadview");
    setupCategories();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    SLog.v(LOG_TAG, "onActivityResult");
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt2 == -1)
      {
        refreshGamePlay();
      }
      else if (paramInt2 == 90001)
      {
        Log.v(LOG_TAG, "Result: start new activity and close");
        startActivity(paramIntent);
        finish();
      }
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt) {}
  
  public void onCreate(Bundle paramBundle)
  {
    SLog.d(LOG_TAG, "Creating activity...");
    this.handler = new Handler();
    setContentView(2130903074);
    this.frameLayout = ((FrameLayout)findViewById(2131230880));
    super.onCreate(paramBundle);
    paramBundle = ApplicationManager.getInstance().getGameManager().getTypeface();
    this.settingsBtn = ((ImageButton)findViewById(2131230883));
    this.infoBtn = ((ImageButton)findViewById(2131230884));
    this.multiplayerBtn = ((Button)findViewById(2131230885));
    this.multiplayerBtn.setTypeface(paramBundle);
    ((TextView)findViewById(2131230882)).setTypeface(paramBundle);
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131230881);
    if (Build.VERSION.SDK_INT <= 10) {
      localFrameLayout.setVisibility(8);
    }
    this.learningBtn = ((Button)findViewById(2131230886));
    this.learningBtn.setTypeface(paramBundle);
    this.quickStartBtn = ((Button)findViewById(2131230887));
    this.quickStartBtn.setTypeface(paramBundle);
    this.banner_hd = localFrameLayout;
    if (ApplicationManager.getInstance().getSettings().getPayStatus() == PayStatus.NOADS) {
      this.banner_hd.setBackgroundResource(2130837736);
    }
    setupViews();
    paramBundle = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
    switch (paramBundle.densityDpi)
    {
    }
    for (;;)
    {
      if (this.created) {
        loadView();
      }
      refreshGamePlay();
      return;
      SLog.d(LOG_TAG, "main low density");
      continue;
      SLog.d(LOG_TAG, "main medium density");
      continue;
      SLog.d(LOG_TAG, "main high density");
      continue;
      SLog.d(LOG_TAG, "main xhigh density");
      continue;
      SLog.d(LOG_TAG, "main xxhigh density");
    }
  }
  
  protected void onDestroy()
  {
    SLog.d(LOG_TAG, "Destroying activity...");
    if (this.interstitialAd != null) {
      this.interstitialAd.stop();
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.interstitialAd != null)
    {
      SLog.i(LOG_TAG, "Pausing ads...");
      this.interstitialAd.pauseShowing();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    ReleaseConfiguration.isReadyForRelease(this);
    if (ApplicationManager.getInstance().getSettings().getPayStatus() != PayStatus.NOADS) {
      if (this.interstitialAd == null)
      {
        if (!ApplicationManager.getInstance().getGameManager().isTablet()) {
          break label99;
        }
        SLog.i(LOG_TAG, "Setting up ads for tablets...");
      }
    }
    for (this.interstitialAd = new MoPubInterstitialAd(this, "e4f45acc5fae45b09cec4e981b864737", true);; this.interstitialAd = new MoPubInterstitialAd(this, "308f6009b0c94ccd87dab536c8310816", true))
    {
      this.interstitialAd.setTestMode(false);
      this.interstitialAd.startPreloading();
      this.interstitialAd.show(90000L, 120000L, true, true);
      return;
      label99:
      SLog.i(LOG_TAG, "Setting up ads for phones...");
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    EasyTracker.getInstance(this).activityStart(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    EasyTracker.getInstance(this).activityStop(this);
  }
  
  public void removeDetailCategoryOverlay()
  {
    if (this.mapView == null) {
      return;
    }
    this.mapView.getOverlays().remove(this.detailCategoryOverlay);
    this.mapView.invalidate();
    this.handler.removeCallbacksAndMessages(null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/ui/MainMenuActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */