package logo.quiz.commons;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;
import com.bubble.in.app.billing.helper.IabHelper;
import com.bubble.in.app.billing.helper.IabHelper.OnConsumeFinishedListener;
import com.bubble.in.app.billing.helper.IabHelper.OnIabPurchaseFinishedListener;
import com.bubble.in.app.billing.helper.IabHelper.OnIabSetupFinishedListener;
import com.bubble.in.app.billing.helper.IabHelper.QueryInventoryFinishedListener;
import com.bubble.in.app.billing.helper.IabResult;
import com.bubble.in.app.billing.helper.Inventory;
import com.bubble.in.app.billing.helper.Purchase;
import com.bubble.in.app.billing.helper.SkuDetails;
import com.bubble.in.app.billing.helper.TestProducts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import logo.quiz.commons.inapp.InAppHints1;
import logo.quiz.commons.inapp.InAppHints2;
import logo.quiz.commons.inapp.InAppHints3;
import logo.quiz.commons.inapp.InAppHints4;
import logo.quiz.commons.inapp.InAppProduct;

public class InAppHelper
{
  public static final String BUY_HINTS_COUNT = "buy_hints_count";
  static final String IAB_ADS_OFF = "ads_off";
  static final String IAB_ALL_LEVELS_UNLOCK = "all_levels_unlock";
  public static final String IS_INN_APP_SETUP = "IS_INN_APP_SETUP";
  static final int RC_REQUEST = 10002;
  private Activity activity;
  private List<InAppProduct> gameInAppProducts = new ArrayList();
  private InAppListener inAppListener = null;
  boolean isAdsOff = false;
  IabHelper.OnConsumeFinishedListener mConsumeFinishedListener = new IabHelper.OnConsumeFinishedListener()
  {
    public void onConsumeFinished(Purchase paramAnonymousPurchase, IabResult paramAnonymousIabResult)
    {
      int j;
      int i;
      if (paramAnonymousIabResult.isSuccess())
      {
        j = 0;
        if (!paramAnonymousPurchase.getSku().equals("hints_1")) {
          break label94;
        }
        i = 50;
      }
      for (;;)
      {
        if (i != 0)
        {
          InAppHelper.this.addNewHints(i);
          DeviceUtilCommons.alert(InAppHelper.this.activity.getString(R.string.adserwer_you_get_x_new_hints, new Object[] { Integer.valueOf(i) }), InAppHelper.this.activity);
        }
        if (InAppHelper.this.inAppListener != null) {
          InAppHelper.this.inAppListener.updateUiAfterBuy();
        }
        return;
        label94:
        if (paramAnonymousPurchase.getSku().equals("hints_2"))
        {
          i = 120;
        }
        else if (paramAnonymousPurchase.getSku().equals("hints_3"))
        {
          i = 300;
        }
        else if (paramAnonymousPurchase.getSku().equals("hints_4"))
        {
          i = 800;
        }
        else
        {
          if (!paramAnonymousPurchase.getSku().equals(TestProducts.purchased)) {
            break;
          }
          i = 50;
        }
      }
      paramAnonymousIabResult = InAppHelper.this.gameInAppProducts.iterator();
      for (;;)
      {
        i = j;
        if (!paramAnonymousIabResult.hasNext()) {
          break;
        }
        InAppProduct localInAppProduct = (InAppProduct)paramAnonymousIabResult.next();
        if (paramAnonymousPurchase.getSku().equals(localInAppProduct.getProductId())) {
          localInAppProduct.setPurchase();
        }
      }
    }
  };
  IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener()
  {
    public void onQueryInventoryFinished(IabResult paramAnonymousIabResult, Inventory paramAnonymousInventory)
    {
      if (paramAnonymousIabResult.isFailure()) {
        DeviceUtilCommons.complain("Failed to query inventory: " + paramAnonymousIabResult, InAppHelper.this.activity);
      }
      do
      {
        return;
        if (paramAnonymousInventory.hasDetails("hints_1")) {
          new InAppHints1(InAppHelper.this.activity.getApplicationContext()).setPrice(paramAnonymousInventory.getSkuDetails("hints_1").getPrice());
        }
        if (paramAnonymousInventory.hasDetails("hints_2")) {
          new InAppHints2(InAppHelper.this.activity.getApplicationContext()).setPrice(paramAnonymousInventory.getSkuDetails("hints_2").getPrice());
        }
        if (paramAnonymousInventory.hasDetails("hints_3")) {
          new InAppHints3(InAppHelper.this.activity.getApplicationContext()).setPrice(paramAnonymousInventory.getSkuDetails("hints_3").getPrice());
        }
        if (paramAnonymousInventory.hasDetails("hints_4")) {
          new InAppHints4(InAppHelper.this.activity.getApplicationContext()).setPrice(paramAnonymousInventory.getSkuDetails("hints_4").getPrice());
        }
        paramAnonymousIabResult = InAppHelper.this.gameInAppProducts.iterator();
        InAppProduct localInAppProduct;
        while (paramAnonymousIabResult.hasNext())
        {
          localInAppProduct = (InAppProduct)paramAnonymousIabResult.next();
          if (paramAnonymousInventory.hasDetails(localInAppProduct.getProductId())) {
            localInAppProduct.setPrice(paramAnonymousInventory.getSkuDetails(localInAppProduct.getProductId()).getPrice());
          }
        }
        InAppHelper.this.isAdsOff = paramAnonymousInventory.hasPurchase("ads_off");
        if (InAppHelper.this.mHelper != null)
        {
          if (paramAnonymousInventory.hasPurchase("hints_1")) {
            InAppHelper.this.mHelper.consumeAsync(paramAnonymousInventory.getPurchase("hints_1"), InAppHelper.this.mConsumeFinishedListener);
          }
          if (paramAnonymousInventory.hasPurchase("hints_2")) {
            InAppHelper.this.mHelper.consumeAsync(paramAnonymousInventory.getPurchase("hints_2"), InAppHelper.this.mConsumeFinishedListener);
          }
          if (paramAnonymousInventory.hasPurchase("hints_3")) {
            InAppHelper.this.mHelper.consumeAsync(paramAnonymousInventory.getPurchase("hints_3"), InAppHelper.this.mConsumeFinishedListener);
          }
          if (paramAnonymousInventory.hasPurchase("hints_4")) {
            InAppHelper.this.mHelper.consumeAsync(paramAnonymousInventory.getPurchase("hints_4"), InAppHelper.this.mConsumeFinishedListener);
          }
          paramAnonymousIabResult = InAppHelper.this.gameInAppProducts.iterator();
          while (paramAnonymousIabResult.hasNext())
          {
            localInAppProduct = (InAppProduct)paramAnonymousIabResult.next();
            if (paramAnonymousInventory.hasPurchase(localInAppProduct.getProductId())) {
              InAppHelper.this.mHelper.consumeAsync(paramAnonymousInventory.getPurchase(localInAppProduct.getProductId()), InAppHelper.this.mConsumeFinishedListener);
            }
          }
        }
      } while (InAppHelper.this.inAppListener == null);
      InAppHelper.this.inAppListener.afterRefreshInventory();
    }
  };
  private IabHelper mHelper;
  IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener()
  {
    public void onIabPurchaseFinished(IabResult paramAnonymousIabResult, Purchase paramAnonymousPurchase)
    {
      if (paramAnonymousIabResult.isFailure()) {
        return;
      }
      InAppHelper.this.mHelper.consumeAsync(paramAnonymousPurchase, InAppHelper.this.mConsumeFinishedListener);
    }
  };
  
  public InAppHelper(final String paramString, final Activity paramActivity)
  {
    this.activity = paramActivity;
    this.mHelper = new IabHelper(paramActivity, paramString);
    paramString = getIds(this.gameInAppProducts);
    this.mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener()
    {
      public void onIabSetupFinished(IabResult paramAnonymousIabResult)
      {
        if ((paramAnonymousIabResult == null) || (!paramAnonymousIabResult.isSuccess()))
        {
          DeviceUtilCommons.complain("Problem setting up in-app billing: " + paramAnonymousIabResult, paramActivity);
          return;
        }
        try
        {
          InAppHelper.this.mHelper.queryInventoryAsync(InAppHelper.this.mGotInventoryListener, paramString);
          return;
        }
        catch (Exception paramAnonymousIabResult)
        {
          Log.e("InAppHelper", "mHelper.queryInventoryAsync 1 error");
        }
      }
    });
  }
  
  public InAppHelper(String paramString, InAppListener paramInAppListener, Activity paramActivity)
  {
    this(paramString, paramInAppListener, paramActivity, new ArrayList());
  }
  
  public InAppHelper(final String paramString, InAppListener paramInAppListener, final Activity paramActivity, List<InAppProduct> paramList)
  {
    this.activity = paramActivity;
    this.inAppListener = paramInAppListener;
    this.gameInAppProducts = paramList;
    this.mHelper = new IabHelper(paramActivity, paramString);
    paramString = getIds(paramList);
    this.mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener()
    {
      public void onIabSetupFinished(IabResult paramAnonymousIabResult)
      {
        if ((paramAnonymousIabResult == null) || (!paramAnonymousIabResult.isSuccess()))
        {
          DeviceUtilCommons.complain("Problem setting up in-app billing: " + paramAnonymousIabResult, paramActivity);
          return;
        }
        try
        {
          InAppHelper.this.mHelper.queryInventoryAsync(InAppHelper.this.mGotInventoryListener, paramString);
          return;
        }
        catch (Exception paramAnonymousIabResult)
        {
          Log.e("InAppHelper", "mHelper.queryInventoryAsync 2 error");
        }
      }
    });
  }
  
  public static int getBuyHintsCount(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("buy_hints_count", 0);
  }
  
  private List<String> getIds(List<InAppProduct> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((InAppProduct)paramList.next()).getProductId());
    }
    return localArrayList;
  }
  
  public void addNewHints(int paramInt)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.activity.getApplicationContext());
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.putInt("allHints", localSharedPreferences.getInt("allHints", 0) + paramInt);
    localEditor.putInt("buy_hints_count", localSharedPreferences.getInt("buy_hints_count", 0) + paramInt);
    localEditor.commit();
  }
  
  public void buyAdsOff()
  {
    this.mHelper.launchPurchaseFlow(this.activity, "ads_off", 10002, this.mPurchaseFinishedListener);
  }
  
  public void buyExtraLevel(InAppProduct paramInAppProduct)
  {
    if (!paramInAppProduct.isPurchased()) {
      this.mHelper.launchPurchaseFlow(this.activity, paramInAppProduct.getProductId(), 10002, this.mPurchaseFinishedListener);
    }
  }
  
  public void buyHints(String paramString)
  {
    this.mHelper.launchPurchaseFlow(this.activity, paramString, 10002, this.mPurchaseFinishedListener);
  }
  
  public boolean isInAppResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    if (this.mHelper != null) {}
    try
    {
      bool = this.mHelper.handleActivityResult(paramInt1, paramInt2, paramIntent);
      return bool;
    }
    catch (Exception paramIntent) {}
    return false;
  }
  
  public void onDestroy()
  {
    try
    {
      if (this.mHelper != null) {
        this.mHelper.dispose();
      }
      this.mHelper = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void testCancled()
  {
    this.mHelper.launchPurchaseFlow(this.activity, TestProducts.canceled, 10002, this.mPurchaseFinishedListener);
  }
  
  public void testItemUnavailable()
  {
    this.mHelper.launchPurchaseFlow(this.activity, TestProducts.itemUnavailable, 10002, this.mPurchaseFinishedListener);
  }
  
  public void testPurchased()
  {
    this.mHelper.launchPurchaseFlow(this.activity, TestProducts.purchased, 10002, this.mPurchaseFinishedListener);
  }
  
  public void testRefunded()
  {
    this.mHelper.launchPurchaseFlow(this.activity, TestProducts.refunded, 10002, this.mPurchaseFinishedListener);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/InAppHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */