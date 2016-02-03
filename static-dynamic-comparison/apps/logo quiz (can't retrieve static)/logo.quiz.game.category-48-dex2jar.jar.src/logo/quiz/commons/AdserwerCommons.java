package logo.quiz.commons;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Point;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.view.animation.DecelerateInterpolator;
import com.bluebird.bubble.adserwer.tools.ads.Ad;
import com.bubble.adserwer.AdserwerBubble;
import com.bubble.keyboard.utils.DeviceUtils;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import java.util.Iterator;
import java.util.List;

public abstract class AdserwerCommons
{
  private static final String AD_SYSTEM = "adSystem";
  public static final int FREE_HINTS_FOR_FACEBOOK_LIKE = 3;
  public static final int FREE_HINTS_FOR_GOOGLE_PLUS = 3;
  public static final int FREE_HINTS_FOR_RATE_APP = 4;
  public static final String MARKET_URL = "market://details?id=";
  public static String REMOVE_AD_ID = "";
  public static String adId = "ad12";
  public static String adUrl;
  static final FlipAnimator flipAnimator = new FlipAnimator(90.0F, 0.0F, 0.0F, 0.0F);
  
  static
  {
    adUrl = "market://details?id=brain.teasers.logic.puzzles.riddles";
  }
  
  public static void checkNewHints(Activity paramActivity, AdserwerBubble paramAdserwerBubble)
  {
    Context localContext = paramActivity.getApplicationContext();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(localContext);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    if (localSharedPreferences.getBoolean("1hint", false))
    {
      localEditor.putBoolean("1hint", false);
      DeviceUtilCommons.showShortToast(localContext.getString(R.string.adserwer_nice_get_new_hint), localContext);
    }
    int i = 0;
    boolean bool = localSharedPreferences.getBoolean("firstRun", true);
    paramAdserwerBubble = paramAdserwerBubble.getAllAds().iterator();
    while (paramAdserwerBubble.hasNext())
    {
      Ad localAd = (Ad)paramAdserwerBubble.next();
      String str = localAd.getAdUrl();
      k = localAd.getAdUrl().indexOf('=');
      if (localAd.getAdUrl().indexOf('&') == -1) {}
      for (j = localAd.getAdUrl().length();; j = localAd.getAdUrl().indexOf('&'))
      {
        if ((!DeviceUtilCommons.isPackageExists(str.substring(k + 1, j), localContext)) || (localSharedPreferences.getBoolean(String.valueOf(localAd.getId()), false))) {
          break label238;
        }
        localEditor.putBoolean(String.valueOf(localAd.getId()), true);
        localEditor.commit();
        if (!bool) {
          break label240;
        }
        localEditor.putBoolean("firstRun", false);
        break;
      }
      label238:
      continue;
      label240:
      if (localAd.isClicked())
      {
        j = localSharedPreferences.getInt("allHints", 0);
        localEditor.putInt("allHints", localAd.getPrizePerInstall() + j);
        i += localAd.getPrizePerInstall();
      }
    }
    int k = localSharedPreferences.getInt("newHints", 0);
    int j = i;
    if (k > 0)
    {
      localEditor.putInt("allHints", localSharedPreferences.getInt("allHints", 0) + k);
      localEditor.putInt("newHints", 0);
      j = i + k;
    }
    if (j > 0) {
      DeviceUtilCommons.showLongToast(localContext.getString(R.string.adserwer_you_get_x_new_hints, new Object[] { Integer.valueOf(j) }), paramActivity.getApplicationContext());
    }
    localEditor.commit();
  }
  
  public static int getAdDelayMillis(Context paramContext)
  {
    return 10;
  }
  
  public static AdView getAdmob(Activity paramActivity, String paramString, AdListener paramAdListener)
  {
    AdView localAdView = new AdView(paramActivity);
    localAdView.setAdUnitId(paramString);
    if (DeviceUtils.isTablet(paramActivity.getApplicationContext())) {}
    for (paramActivity = AdSize.SMART_BANNER;; paramActivity = AdSize.BANNER)
    {
      localAdView.setAdSize(paramActivity);
      paramActivity = new AdRequest.Builder().build();
      localAdView.setAdListener(paramAdListener);
      localAdView.loadAd(paramActivity);
      return localAdView;
    }
  }
  
  public static Intent getPromoIntent(Context paramContext)
  {
    return getPromoIntent(adId, adUrl, true, paramContext);
  }
  
  public static Intent getPromoIntent(String paramString1, String paramString2, boolean paramBoolean, Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString2));
    localIntent.addFlags(1073741824);
    if (paramBoolean)
    {
      paramString2 = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramString2.putBoolean(paramString1, true);
      paramString2.commit();
    }
    return localIntent;
  }
  
  private static void initFlipAnimator(Activity paramActivity)
  {
    flipAnimator.setDuration(500L);
    flipAnimator.setFillAfter(true);
    flipAnimator.setInterpolator(new DecelerateInterpolator());
    flipAnimator.setmCenterX(DeviceUtilCommons.getDeviceSize(paramActivity.getApplicationContext()).x / 2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/AdserwerCommons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */