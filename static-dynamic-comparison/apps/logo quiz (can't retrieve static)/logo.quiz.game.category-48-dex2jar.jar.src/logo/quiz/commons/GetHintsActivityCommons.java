package logo.quiz.commons;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import com.bluebird.mobile.tools.activities.ActivityAction;
import com.bubble.bugsense.BugSense;
import com.bubble.tapjoy.TapjoyAction;
import com.bubble.tapjoy.TapjoySupport;
import com.google.android.gms.plus.PlusOneButton;
import com.google.android.gms.plus.PlusOneButton.OnPlusOneClickListener;
import logo.quiz.commons.flurry.Flurry;
import logo.quiz.commons.inapp.InAppHints1;
import logo.quiz.commons.inapp.InAppHints2;
import logo.quiz.commons.inapp.InAppHints3;
import logo.quiz.commons.inapp.InAppHints4;
import logo.quiz.commons.tapjoy.TapjoyEarnedPointsNotifierImpl;
import logo.quiz.commons.utils.DeviceUtils;
import logo.quiz.commons.utils.menu.MenuService;

public abstract class GetHintsActivityCommons
  extends LogoQuizAbstractActivity
  implements InAppListener
{
  private HintsStoreButton googlePlusButton;
  private HintsStoreButton googlePlusButtonUsed;
  private HintsStoreButton[] inAppButtons;
  private InAppHelper inAppHelper;
  private HintsStoreButton likeButton;
  private HintsStoreButton likeButtonUsed;
  private TapjoySupport tapjoySupport;
  
  private void freeHintsClick(MyAdCommons paramMyAdCommons, boolean paramBoolean)
  {
    if (DeviceUtilCommons.isOnline(getApplicationContext()))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramMyAdCommons.getAdUrl()));
      localIntent.addFlags(1073741824);
      if (!paramBoolean)
      {
        SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor localEditor = localSharedPreferences.edit();
        localEditor.putBoolean(paramMyAdCommons.getAdId(), true);
        int i = localSharedPreferences.getInt("allHints", 0);
        localEditor.putInt("allHints", paramMyAdCommons.getHintsPerInstall() + i);
        localEditor.commit();
      }
      startActivity(localIntent);
      return;
    }
    DeviceUtilCommons.showLongToast(getString(R.string.you_have_to_be_online), getApplicationContext());
  }
  
  private TableRow getAlignmentRow()
  {
    TableRow localTableRow = getEmptyRow();
    ImageView localImageView = new ImageView(getApplicationContext());
    localImageView.setImageResource(R.drawable.promo_alignment);
    localTableRow.addView(localImageView);
    localImageView = new ImageView(getApplicationContext());
    localImageView.setImageResource(R.drawable.promo_alignment);
    localTableRow.addView(localImageView);
    localImageView = new ImageView(getApplicationContext());
    localImageView.setImageResource(R.drawable.promo_alignment);
    localTableRow.addView(localImageView);
    localImageView = new ImageView(getApplicationContext());
    localImageView.setImageResource(R.drawable.promo_alignment);
    localTableRow.addView(localImageView);
    return localTableRow;
  }
  
  private TableRow getEmptyRow()
  {
    TableRow localTableRow = new TableRow(getApplicationContext());
    localTableRow.setLayoutParams(new TableRow.LayoutParams(-1, -2, 1.0F));
    return localTableRow;
  }
  
  private TableLayout getEmptyTable()
  {
    TableLayout localTableLayout = new TableLayout(getApplicationContext());
    localTableLayout.setStretchAllColumns(true);
    localTableLayout.setPadding(DeviceUtilCommons.dip(2, getApplicationContext()), 0, DeviceUtilCommons.dip(2, getApplicationContext()), 0);
    localTableLayout.setLayoutParams(new TableLayout.LayoutParams(-1, -2, 17.0F));
    return localTableLayout;
  }
  
  private LinearLayout getHeader(String paramString1, String paramString2, int paramInt)
  {
    LinearLayout localLinearLayout = new LinearLayout(getApplicationContext());
    localLinearLayout.setGravity(16);
    if (DeviceUtils.isTablet(getApplicationContext())) {}
    for (float f = 25.0F;; f = 15.0F)
    {
      localLinearLayout.setPadding(DeviceUtilCommons.dp(f, getApplicationContext()), DeviceUtilCommons.dp(26.0F, getApplicationContext()), 0, DeviceUtilCommons.dp(12.0F, getApplicationContext()));
      TextView localTextView = new TextView(getApplicationContext());
      localTextView.setText(paramString1);
      localTextView.setTextSize(23.0F);
      localTextView.setTextColor(paramInt);
      localTextView.setShadowLayer(1.0F, 3.0F, 3.0F, 553648128);
      localTextView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/passing_notes.ttf"), 1);
      localLinearLayout.addView(localTextView);
      paramString1 = new TextView(getApplicationContext());
      paramString1.setPadding(DeviceUtilCommons.dip(6, getApplicationContext()), 0, 0, 0);
      paramString1.setText(paramString2);
      paramString1.setTextSize(16.0F);
      paramString1.setTextColor(-3618616);
      paramString1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/passing_notes.ttf"), 0);
      localLinearLayout.addView(paramString1);
      return localLinearLayout;
    }
  }
  
  private void onClickTapjoy()
  {
    if (DeviceUtilCommons.isOnline(getApplicationContext()))
    {
      this.tapjoySupport.showOffers();
      return;
    }
    DeviceUtilCommons.showLongToast(getString(R.string.you_have_to_be_online), getApplicationContext());
  }
  
  public void afterRefreshInventory() {}
  
  public void back(View paramView)
  {
    onBackPressed();
  }
  
  public void fbLikeClick()
  {
    Object localObject = getApplicationContext();
    if (DeviceUtilCommons.isOnline((Context)localObject))
    {
      localObject = PreferenceManager.getDefaultSharedPreferences((Context)localObject);
      if (!((SharedPreferences)localObject).getBoolean("like_on_fb", false))
      {
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
        localEditor.putBoolean("like_on_fb", true);
        localEditor.putInt("newHints", ((SharedPreferences)localObject).getInt("newHints", 0) + 3);
        localEditor.commit();
      }
      like(null);
      return;
    }
    DeviceUtilCommons.showLongToast(getString(R.string.you_have_to_be_online), getApplicationContext());
  }
  
  protected abstract ConstantsProvider getConstants();
  
  public LinearLayout getGooglePlusButton(final HintsStoreButton paramHintsStoreButton)
  {
    LinearLayout localLinearLayout = new LinearLayout(getApplicationContext());
    if (DeviceUtils.isTablet(getApplicationContext())) {
      localLinearLayout.setPadding(DeviceUtilCommons.dp(25.0F, getApplicationContext()), 0, DeviceUtilCommons.dip(25, getApplicationContext()), 0);
    }
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(17);
    Object localObject = (FrameLayout)getLayoutInflater().inflate(R.layout.google_plus_button, null, true);
    final PlusOneButton localPlusOneButton = (PlusOneButton)((FrameLayout)localObject).getChildAt(0);
    localPlusOneButton.setOnPlusOneClickListener(new PlusOneButton.OnPlusOneClickListener()
    {
      public void onPlusOneClick(Intent paramAnonymousIntent)
      {
        if (paramAnonymousIntent != null)
        {
          GetHintsActivityCommons.this.startActivityForResult(paramAnonymousIntent, 0);
          paramHintsStoreButton.onClick();
          return;
        }
        DeviceUtilCommons.showLongToast(GetHintsActivityCommons.this.getString(R.string.you_have_to_be_online), GetHintsActivityCommons.this.getApplicationContext());
      }
    });
    localPlusOneButton.initialize("https://play.google.com/store/apps/details?id=" + getPackageName(), 0);
    localLinearLayout.addView((View)localObject);
    localObject = new TextView(getApplicationContext());
    ((TextView)localObject).setTextColor(paramHintsStoreButton.getTextColor());
    ((TextView)localObject).setGravity(17);
    ((TextView)localObject).setText(paramHintsStoreButton.getText());
    localLinearLayout.addView((View)localObject);
    localObject = new Button(this);
    ((Button)localObject).setLayoutParams(new LinearLayout.LayoutParams(DeviceUtilCommons.dip(65, getApplicationContext()), -2));
    ((Button)localObject).setBackgroundResource(paramHintsStoreButton.getBottomImage());
    ((Button)localObject).setClickable(true);
    ((Button)localObject).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          localPlusOneButton.callOnClick();
          return;
        }
        catch (NoSuchMethodError paramAnonymousView)
        {
          Log.e("GetHintsActivityCommons", "buyHints error");
          paramAnonymousView.printStackTrace();
          DeviceUtilCommons.showLongToast(GetHintsActivityCommons.this.getString(R.string.store_problem_google_plus), GetHintsActivityCommons.this.getApplicationContext());
          return;
        }
        catch (Exception paramAnonymousView)
        {
          Log.e("GetHintsActivityCommons", "buyHints error");
          paramAnonymousView.printStackTrace();
          DeviceUtilCommons.showLongToast(GetHintsActivityCommons.this.getString(R.string.store_problem_google_plus), GetHintsActivityCommons.this.getApplicationContext());
        }
      }
    });
    ((Button)localObject).setTextSize(13.0F);
    ((Button)localObject).setTextColor(-1);
    ((Button)localObject).setTextScaleX(Float.valueOf(getApplicationContext().getResources().getString(R.string.buyButtonTextScaleX)).floatValue());
    ((Button)localObject).setText(paramHintsStoreButton.getPrice());
    localLinearLayout.addView((View)localObject);
    return localLinearLayout;
  }
  
  public LinearLayout getHintsStoreButton(final HintsStoreButton paramHintsStoreButton)
  {
    LinearLayout localLinearLayout = new LinearLayout(getApplicationContext());
    if (DeviceUtils.isTablet(getApplicationContext())) {
      localLinearLayout.setPadding(DeviceUtilCommons.dp(25.0F, getApplicationContext()), 0, DeviceUtilCommons.dip(25, getApplicationContext()), 0);
    }
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(17);
    Object localObject = new ImageView(getApplicationContext());
    ((ImageView)localObject).setImageResource(paramHintsStoreButton.getTopImage());
    ((ImageView)localObject).setClickable(true);
    ((ImageView)localObject).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramHintsStoreButton.onClick();
      }
    });
    localLinearLayout.addView((View)localObject);
    localObject = new TextView(getApplicationContext());
    ((TextView)localObject).setTextColor(paramHintsStoreButton.getTextColor());
    ((TextView)localObject).setGravity(17);
    ((TextView)localObject).setText(paramHintsStoreButton.getText());
    localLinearLayout.addView((View)localObject);
    localObject = new Button(this);
    ((Button)localObject).setLayoutParams(new LinearLayout.LayoutParams(DeviceUtilCommons.dip(65, getApplicationContext()), -2));
    ((Button)localObject).setBackgroundResource(paramHintsStoreButton.getBottomImage());
    ((Button)localObject).setClickable(true);
    ((Button)localObject).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          paramHintsStoreButton.onClick();
          return;
        }
        catch (Exception paramAnonymousView)
        {
          Log.e("GetHintsActivityCommons", "buyHints error");
          paramAnonymousView.printStackTrace();
          DeviceUtilCommons.showLongToast(GetHintsActivityCommons.this.getString(R.string.store_problem_with_buy_hints), GetHintsActivityCommons.this.getApplicationContext());
        }
      }
    });
    ((Button)localObject).setTextSize(13.0F);
    ((Button)localObject).setTextColor(-1);
    ((Button)localObject).setTextScaleX(Float.valueOf(getApplicationContext().getResources().getString(R.string.buyButtonTextScaleX)).floatValue());
    ((Button)localObject).setText(paramHintsStoreButton.getPrice());
    localLinearLayout.addView((View)localObject);
    return localLinearLayout;
  }
  
  protected abstract ScoreUtilProvider getScoreUtilProvider();
  
  public void googlePlusClick()
  {
    Object localObject = getApplicationContext();
    if (DeviceUtilCommons.isOnline((Context)localObject))
    {
      localObject = PreferenceManager.getDefaultSharedPreferences((Context)localObject);
      if (!((SharedPreferences)localObject).getBoolean("google_plus_on", false))
      {
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
        localEditor.putBoolean("google_plus_on", true);
        localEditor.putInt("newHints", ((SharedPreferences)localObject).getInt("newHints", 0) + 3);
        localEditor.commit();
      }
      return;
    }
    DeviceUtilCommons.showLongToast(getString(R.string.you_have_to_be_online), getApplicationContext());
  }
  
  public void like(View paramView)
  {
    try
    {
      paramView = new Intent("android.intent.action.VIEW", Uri.parse("fb://profile/" + getConstants().getFacebookProfileId()));
      paramView = new Intent("android.intent.action.VIEW", Uri.parse("http://www.facebook.com/pages/profile/" + getConstants().getFacebookProfileId()));
    }
    catch (Exception paramView)
    {
      try
      {
        paramView.addFlags(1073741824);
        paramView.addFlags(268435456);
        startActivity(paramView);
        return;
      }
      catch (Exception paramView)
      {
        for (;;) {}
      }
      paramView = paramView;
    }
    paramView.addFlags(1073741824);
    paramView.addFlags(268435456);
    startActivity(paramView);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.inAppHelper != null) && (this.inAppHelper.isInAppResult(paramInt1, paramInt2, paramIntent))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      return;
    }
  }
  
  public void onAdsOffButtonClicked(View paramView)
  {
    try
    {
      this.inAppHelper.buyAdsOff();
      return;
    }
    catch (Exception paramView)
    {
      Log.e("GetHintsActivityCommons", "buyAdsOff error");
      paramView.printStackTrace();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    overridePendingTransition(0, 0);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    super.onCreate(paramBundle, R.layout.get_hints);
    this.tapjoySupport = new TapjoySupport(new TapjoyEarnedPointsNotifierImpl(getMenuService(), this), this);
    this.tapjoySupport.enableTapjoy();
    addActivityActions(new ActivityAction[] { new TapjoyAction(this.tapjoySupport) });
    ((TextView)findViewById(R.id.menuInfo)).setText(getString(R.string.hints_store));
    ((TextView)findViewById(R.id.hintsLabelLevel)).setText(getResources().getString(R.string.hints));
    this.likeButton = new HintsStoreButton(R.drawable.promo_fb_like, getString(R.string.store_x_hints, new Object[] { Integer.valueOf(3) }), getResources().getColor(R.color.shop_button_labels_color), R.drawable.buy_icon, getString(R.string.store_free), new HintsStoreButtonOnClickListener()
    {
      public void onClick()
      {
        GetHintsActivityCommons.this.fbLikeClick();
      }
    }, null);
    this.likeButtonUsed = new HintsStoreButton(R.drawable.promo_fb_like_used, getString(R.string.store_x_hints, new Object[] { Integer.valueOf(3) }), getResources().getColor(R.color.shop_used_button_labels_color), R.drawable.buy_icon, getString(R.string.store_free), new HintsStoreButtonOnClickListener()
    {
      public void onClick()
      {
        GetHintsActivityCommons.this.fbLikeClick();
      }
    }, null);
    this.googlePlusButton = new HintsStoreButton(R.drawable.promo_fb_like, getString(R.string.store_x_hints, new Object[] { Integer.valueOf(3) }), getResources().getColor(R.color.shop_button_labels_color), R.drawable.buy_icon, getString(R.string.store_free), new HintsStoreButtonOnClickListener()
    {
      public void onClick()
      {
        GetHintsActivityCommons.this.googlePlusClick();
      }
    }, null);
    this.googlePlusButtonUsed = new HintsStoreButton(R.drawable.promo_fb_like_used, getString(R.string.store_x_hints, new Object[] { Integer.valueOf(3) }), getResources().getColor(R.color.shop_used_button_labels_color), R.drawable.buy_icon, getString(R.string.store_free), new HintsStoreButtonOnClickListener()
    {
      public void onClick()
      {
        GetHintsActivityCommons.this.googlePlusClick();
      }
    }, null);
    paramBundle = new InAppHints1(getApplicationContext());
    InAppHints2 localInAppHints2 = new InAppHints2(getApplicationContext());
    InAppHints3 localInAppHints3 = new InAppHints3(getApplicationContext());
    InAppHints4 localInAppHints4 = new InAppHints4(getApplicationContext());
    this.inAppButtons = new HintsStoreButton[4];
    this.inAppButtons[0 = new HintsStoreButton(R.drawable.inapp_1, "", getResources().getColor(R.color.shop_button_labels_color), R.drawable.buy_icon, paramBundle.getPrice(), new HintsStoreButtonOnClickListener()
    {
      public void onClick()
      {
        try
        {
          GetHintsActivityCommons.this.inAppHelper.buyHints("hints_1");
          return;
        }
        catch (Exception localException)
        {
          DeviceUtilCommons.showLongToast("", GetHintsActivityCommons.this.getApplicationContext());
          Log.e("GetHintsActivityCommons", "buyHints inapp_1 error");
          localException.printStackTrace();
          DeviceUtilCommons.showLongToast(GetHintsActivityCommons.this.getString(R.string.store_problem_with_buy_hints), GetHintsActivityCommons.this.getApplicationContext());
        }
      }
    }, null);
    this.inAppButtons[1 = new HintsStoreButton(R.drawable.inapp_2, "+50%", getResources().getColor(R.color.shop_button_labels_color), R.drawable.buy_icon, localInAppHints2.getPrice(), new HintsStoreButtonOnClickListener()
    {
      public void onClick()
      {
        try
        {
          GetHintsActivityCommons.this.inAppHelper.buyHints("hints_2");
          return;
        }
        catch (Exception localException)
        {
          Log.e("GetHintsActivityCommons", "buyHints inapp_2 error");
          localException.printStackTrace();
          DeviceUtilCommons.showLongToast(GetHintsActivityCommons.this.getString(R.string.store_problem_with_buy_hints), GetHintsActivityCommons.this.getApplicationContext());
        }
      }
    }, null);
    this.inAppButtons[2 = new HintsStoreButton(R.drawable.inapp_3, "+65%", getResources().getColor(R.color.shop_button_labels_color), R.drawable.buy_icon, localInAppHints3.getPrice(), new HintsStoreButtonOnClickListener()
    {
      public void onClick()
      {
        try
        {
          GetHintsActivityCommons.this.inAppHelper.buyHints("hints_3");
          return;
        }
        catch (Exception localException)
        {
          Log.e("GetHintsActivityCommons", "buyHints inapp_3 error");
          localException.printStackTrace();
          DeviceUtilCommons.showLongToast(GetHintsActivityCommons.this.getString(R.string.store_problem_with_buy_hints), GetHintsActivityCommons.this.getApplicationContext());
        }
      }
    }, null);
    this.inAppButtons[3 = new HintsStoreButton(R.drawable.inapp_4, "+75%", getResources().getColor(R.color.shop_button_labels_color), R.drawable.buy_icon, localInAppHints4.getPrice(), new HintsStoreButtonOnClickListener()
    {
      public void onClick()
      {
        try
        {
          GetHintsActivityCommons.this.inAppHelper.buyHints("hints_4");
          return;
        }
        catch (Exception localException)
        {
          Log.e("GetHintsActivityCommons", "buyHints inapp_4 error");
          localException.printStackTrace();
          DeviceUtilCommons.showLongToast(GetHintsActivityCommons.this.getString(R.string.store_problem_with_buy_hints), GetHintsActivityCommons.this.getApplicationContext());
        }
      }
    }, null);
  }
  
  public void onDestroy()
  {
    if (this.inAppHelper != null) {
      this.inAppHelper.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    this.bugSense.addCrashExtraData("activity", getClass().getSimpleName());
    LinearLayout localLinearLayout;
    try
    {
      this.inAppHelper = new InAppHelper(getConstants().getInAppPublicKey(), this, this);
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
      localLinearLayout = (LinearLayout)findViewById(R.id.freeHintsContainer);
      localLinearLayout.removeAllViews();
      localLinearLayout.addView(getHeader(getString(R.string.store_hints_pack), getString(R.string.store_hints_pack_text), getResources().getColor(R.color.header_hints_pack_color)));
      localObject1 = getEmptyTable();
      if (DeviceUtils.isTablet(getApplicationContext())) {
        ((TableLayout)localObject1).setStretchAllColumns(false);
      }
      localObject2 = getEmptyRow();
      ((TableLayout)localObject1).addView((View)localObject2);
      HintsStoreButton[] arrayOfHintsStoreButton = this.inAppButtons;
      int j = arrayOfHintsStoreButton.length;
      int i = 0;
      while (i < j)
      {
        ((TableRow)localObject2).addView(getHintsStoreButton(arrayOfHintsStoreButton[i]));
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("GetHintsActivityCommons", "onResume InAppHelper init error");
      }
      localLinearLayout.addView((View)localObject1);
      localLinearLayout.addView(getHeader(getString(R.string.store_free_hints), getString(R.string.store_free_hints_text), getResources().getColor(R.color.header_free_hints_color)));
      localObject1 = new LinearLayout(getApplicationContext());
      ((LinearLayout)localObject1).setOrientation(1);
      if (!DeviceUtils.isTablet(getApplicationContext())) {
        break label661;
      }
    }
    float f = 25.0F;
    ((LinearLayout)localObject1).setPadding(DeviceUtilCommons.dp(f, getApplicationContext()), 0, 0, 0);
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).gravity = 3;
    ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new ImageView(getApplicationContext());
    ((ImageView)localObject2).setImageResource(R.drawable.promo_tapjoy_full);
    ((ImageView)localObject2).setClickable(true);
    ((ImageView)localObject2).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        GetHintsActivityCommons.this.onClickTapjoy();
      }
    });
    ((LinearLayout)localObject1).addView((View)localObject2);
    localObject2 = new TextView(getApplicationContext());
    ((TextView)localObject2).setTextColor(getResources().getColor(R.color.shop_button_labels_color));
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setText(getString(R.string.store_get_for_free));
    ((LinearLayout)localObject1).addView((View)localObject2);
    localObject2 = new Button(this);
    ((Button)localObject2).setBackgroundResource(R.drawable.buy_icon);
    ((Button)localObject2).setClickable(true);
    ((Button)localObject2).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        GetHintsActivityCommons.this.onClickTapjoy();
      }
    });
    ((Button)localObject2).setText(getString(R.string.store_free));
    ((Button)localObject2).setTextSize(13.0F);
    ((Button)localObject2).setTextColor(-1);
    ((LinearLayout)localObject1).addView((View)localObject2);
    localLinearLayout.addView((View)localObject1);
    localLinearLayout.addView(getHeader(getString(R.string.store_specials), getString(R.string.store_specials_text), getResources().getColor(R.color.header_specials_color)));
    Object localObject1 = getEmptyTable();
    ((TableLayout)localObject1).setPadding(DeviceUtilCommons.dip(2, getApplicationContext()), 0, DeviceUtilCommons.dip(2, getApplicationContext()), DeviceUtilCommons.dip(25, getApplicationContext()));
    if (DeviceUtils.isTablet(getApplicationContext())) {
      ((TableLayout)localObject1).setStretchAllColumns(false);
    }
    ((TableLayout)localObject1).addView(getAlignmentRow());
    localObject2 = getEmptyRow();
    if (!localException.getBoolean("google_plus_on", false))
    {
      ((TableRow)localObject2).addView(getGooglePlusButton(this.googlePlusButton));
      label609:
      if (localException.getBoolean("like_on_fb", false)) {
        break label684;
      }
      ((TableRow)localObject2).addView(getHintsStoreButton(this.likeButton));
    }
    for (;;)
    {
      ((TableLayout)localObject1).addView((View)localObject2);
      localLinearLayout.addView((View)localObject1);
      getMenuService().refreshScore(this);
      return;
      label661:
      f = 15.0F;
      break;
      ((TableRow)localObject2).addView(getGooglePlusButton(this.googlePlusButtonUsed));
      break label609;
      label684:
      ((TableRow)localObject2).addView(getHintsStoreButton(this.likeButtonUsed));
    }
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void rate(View paramView)
  {
    Flurry.onEvent("Rate app");
    paramView = new Intent("android.intent.action.VIEW");
    paramView.setData(Uri.parse("market://details?id=" + getApplicationContext().getPackageName()));
    paramView.addFlags(1073741824);
    startActivity(paramView);
  }
  
  public void updateUiAfterBuy()
  {
    getMenuService().refreshScore(this);
  }
  
  private class HintsStoreButton
  {
    private int bottomImage;
    private GetHintsActivityCommons.HintsStoreButtonOnClickListener hintsStoreButtonOnClickListener;
    private String price;
    private CharSequence text;
    private int textColor;
    private int topImage;
    
    private HintsStoreButton(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3, String paramString, GetHintsActivityCommons.HintsStoreButtonOnClickListener paramHintsStoreButtonOnClickListener)
    {
      this.topImage = paramInt1;
      this.textColor = paramInt2;
      this.text = paramCharSequence;
      this.bottomImage = paramInt3;
      this.price = paramString;
      this.hintsStoreButtonOnClickListener = paramHintsStoreButtonOnClickListener;
    }
    
    public int getBottomImage()
    {
      return this.bottomImage;
    }
    
    public String getPrice()
    {
      return this.price;
    }
    
    public CharSequence getText()
    {
      return this.text;
    }
    
    public int getTextColor()
    {
      return this.textColor;
    }
    
    public int getTopImage()
    {
      return this.topImage;
    }
    
    public void onClick()
    {
      this.hintsStoreButtonOnClickListener.onClick();
    }
    
    public void setText(CharSequence paramCharSequence)
    {
      this.text = paramCharSequence;
    }
  }
  
  public static abstract interface HintsStoreButtonOnClickListener
  {
    public abstract void onClick();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/GetHintsActivityCommons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */