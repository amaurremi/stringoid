package com.bubble.in.app.billing.helper.trivialdrivesample;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.bubble.in.app.billing.helper.IabHelper;
import com.bubble.in.app.billing.helper.IabHelper.OnConsumeFinishedListener;
import com.bubble.in.app.billing.helper.IabHelper.OnIabPurchaseFinishedListener;
import com.bubble.in.app.billing.helper.IabHelper.OnIabSetupFinishedListener;
import com.bubble.in.app.billing.helper.IabHelper.QueryInventoryFinishedListener;
import com.bubble.in.app.billing.helper.IabResult;
import com.bubble.in.app.billing.helper.Inventory;
import com.bubble.in.app.billing.helper.Purchase;
import com.bubble.in.app.billing.helper.R.drawable;
import com.bubble.in.app.billing.helper.R.id;
import com.bubble.in.app.billing.helper.R.layout;

public class MainActivity
  extends Activity
{
  static final int RC_REQUEST = 10001;
  static final String SKU_GAS = "gas";
  static final String SKU_PREMIUM = "premium";
  static final String TAG = "TrivialDrive";
  static final int TANK_MAX = 4;
  static int[] TANK_RES_IDS = { R.drawable.gas0, R.drawable.gas1, R.drawable.gas2, R.drawable.gas3, R.drawable.gas4 };
  IabHelper.OnConsumeFinishedListener mConsumeFinishedListener = new IabHelper.OnConsumeFinishedListener()
  {
    public void onConsumeFinished(Purchase paramAnonymousPurchase, IabResult paramAnonymousIabResult)
    {
      int i = 4;
      Log.d("TrivialDrive", "Consumption finished. Purchase: " + paramAnonymousPurchase + ", result: " + paramAnonymousIabResult);
      if (paramAnonymousIabResult.isSuccess())
      {
        Log.d("TrivialDrive", "Consumption successful. Provisioning.");
        paramAnonymousPurchase = MainActivity.this;
        if (MainActivity.this.mTank == 4)
        {
          paramAnonymousPurchase.mTank = i;
          MainActivity.this.saveData();
          MainActivity.this.alert("You filled 1/4 tank. Your tank is now " + String.valueOf(MainActivity.this.mTank) + "/4 full!");
        }
      }
      for (;;)
      {
        MainActivity.this.updateUi();
        MainActivity.this.setWaitScreen(false);
        Log.d("TrivialDrive", "End consumption flow.");
        return;
        i = MainActivity.this.mTank + 1;
        break;
        MainActivity.this.complain("Error while consuming: " + paramAnonymousIabResult);
      }
    }
  };
  IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener()
  {
    public void onQueryInventoryFinished(IabResult paramAnonymousIabResult, Inventory paramAnonymousInventory)
    {
      Log.d("TrivialDrive", "Query inventory finished.");
      if (paramAnonymousIabResult.isFailure())
      {
        MainActivity.this.complain("Failed to query inventory: " + paramAnonymousIabResult);
        return;
      }
      Log.d("TrivialDrive", "Query inventory was successful.");
      MainActivity.this.mIsPremium = paramAnonymousInventory.hasPurchase("premium");
      StringBuilder localStringBuilder = new StringBuilder().append("User is ");
      if (MainActivity.this.mIsPremium) {}
      for (paramAnonymousIabResult = "PREMIUM";; paramAnonymousIabResult = "NOT PREMIUM")
      {
        Log.d("TrivialDrive", paramAnonymousIabResult);
        if (!paramAnonymousInventory.hasPurchase("gas")) {
          break;
        }
        Log.d("TrivialDrive", "We have gas. Consuming it.");
        MainActivity.this.mHelper.consumeAsync(paramAnonymousInventory.getPurchase("gas"), MainActivity.this.mConsumeFinishedListener);
        return;
      }
      MainActivity.this.updateUi();
      MainActivity.this.setWaitScreen(false);
      Log.d("TrivialDrive", "Initial inventory query finished; enabling main UI.");
    }
  };
  IabHelper mHelper;
  boolean mIsPremium = false;
  IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener()
  {
    public void onIabPurchaseFinished(IabResult paramAnonymousIabResult, Purchase paramAnonymousPurchase)
    {
      Log.d("TrivialDrive", "Purchase finished: " + paramAnonymousIabResult + ", purchase: " + paramAnonymousPurchase);
      if (paramAnonymousIabResult.isFailure())
      {
        MainActivity.this.complain("Error purchasing: " + paramAnonymousIabResult);
        MainActivity.this.setWaitScreen(false);
      }
      do
      {
        return;
        Log.d("TrivialDrive", "Purchase successful.");
        if (paramAnonymousPurchase.getSku().equals("gas"))
        {
          Log.d("TrivialDrive", "Purchase is gas. Starting gas consumption.");
          MainActivity.this.mHelper.consumeAsync(paramAnonymousPurchase, MainActivity.this.mConsumeFinishedListener);
          return;
        }
      } while (!paramAnonymousPurchase.getSku().equals("premium"));
      Log.d("TrivialDrive", "Purchase is premium upgrade. Congratulating user.");
      MainActivity.this.alert("Thank you for upgrading to premium!");
      MainActivity.this.mIsPremium = true;
      MainActivity.this.updateUi();
      MainActivity.this.setWaitScreen(false);
    }
  };
  int mTank;
  
  void alert(String paramString)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setMessage(paramString);
    localBuilder.setNeutralButton("OK", null);
    Log.d("TrivialDrive", "Showing alert dialog: " + paramString);
    localBuilder.create().show();
  }
  
  void complain(String paramString)
  {
    Log.e("TrivialDrive", "**** TrivialDrive Error: " + paramString);
    alert("Error: " + paramString);
  }
  
  void loadData()
  {
    this.mTank = getPreferences(0).getInt("tank", 2);
    Log.d("TrivialDrive", "Loaded data: tank = " + String.valueOf(this.mTank));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.d("TrivialDrive", "onActivityResult(" + paramInt1 + "," + paramInt2 + "," + paramIntent);
    if (!this.mHelper.handleActivityResult(paramInt1, paramInt2, paramIntent))
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    Log.d("TrivialDrive", "onActivityResult handled by IABUtil.");
  }
  
  public void onBuyGasButtonClicked(View paramView)
  {
    Log.d("TrivialDrive", "Buy gas button clicked.");
    if (this.mTank >= 4)
    {
      complain("Your tank is full. Drive around a bit!");
      return;
    }
    setWaitScreen(true);
    Log.d("TrivialDrive", "Launching purchase flow for gas.");
    this.mHelper.launchPurchaseFlow(this, "gas", 10001, this.mPurchaseFinishedListener);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_main);
    loadData();
    Log.d("TrivialDrive", "Creating IAB helper.");
    this.mHelper = new IabHelper(this, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkQyMoQI2VIM8lpAbbVcNh1L4F0RM2Kzmp2KV1U5iaE1UTvB9/uRuoIL34OY9CGwlUJ2JoShIK6428NUgAkKhq5utxfL0Nv2kKjHaQAEQYrWg1qsR/oe2G7JBMPVFJEph9mW3lmollQOAUCtOBEfLQRfUl2Ed3QOWkUw7In2HoqyQcBzVdj1iPeix/mtCqQoVJK4oe/spD8hPC7RXRIlgrbfxftfX29AQBNCTJ2Peq2RRZmGNPR5dJR1Q6SpvZKoV6FoeORBRr2A76Ag/ht7wg4/vpwUl6HofcUxol/oBhcyKHHrgo2y/boJ1/JnOj4IPGoHdubIsHPnDBMVMUUF8iwIDAQAB");
    this.mHelper.enableDebugLogging(true);
    Log.d("TrivialDrive", "Starting setup.");
    this.mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener()
    {
      public void onIabSetupFinished(IabResult paramAnonymousIabResult)
      {
        Log.d("TrivialDrive", "Setup finished.");
        if (!paramAnonymousIabResult.isSuccess())
        {
          MainActivity.this.complain("Problem setting up in-app billing: " + paramAnonymousIabResult);
          return;
        }
        Log.d("TrivialDrive", "Setup successful. Querying inventory.");
        MainActivity.this.mHelper.queryInventoryAsync(MainActivity.this.mGotInventoryListener);
      }
    });
  }
  
  public void onDestroy()
  {
    Log.d("TrivialDrive", "Destroying helper.");
    if (this.mHelper != null) {
      this.mHelper.dispose();
    }
    this.mHelper = null;
  }
  
  public void onDriveButtonClicked(View paramView)
  {
    Log.d("TrivialDrive", "Drive button clicked.");
    if (this.mTank <= 0)
    {
      alert("Oh, no! You are out of gas! Try buying some!");
      return;
    }
    this.mTank -= 1;
    saveData();
    alert("Vroooom, you drove a few miles.");
    updateUi();
    Log.d("TrivialDrive", "Vrooom. Tank is now " + this.mTank);
  }
  
  public void onUpgradeAppButtonClicked(View paramView)
  {
    Log.d("TrivialDrive", "Upgrade button clicked; launching purchase flow for upgrade.");
    setWaitScreen(true);
    this.mHelper.launchPurchaseFlow(this, "premium", 10001, this.mPurchaseFinishedListener);
  }
  
  void saveData()
  {
    SharedPreferences.Editor localEditor = getPreferences(0).edit();
    localEditor.putInt("tank", this.mTank);
    localEditor.commit();
    Log.d("TrivialDrive", "Saved data: tank = " + String.valueOf(this.mTank));
  }
  
  void setWaitScreen(boolean paramBoolean)
  {
    int j = 0;
    View localView = findViewById(R.id.screen_main);
    if (paramBoolean)
    {
      i = 8;
      localView.setVisibility(i);
      localView = findViewById(R.id.screen_wait);
      if (!paramBoolean) {
        break label51;
      }
    }
    label51:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      return;
      i = 0;
      break;
    }
  }
  
  public void updateUi()
  {
    Object localObject = (ImageView)findViewById(R.id.free_or_premium);
    if (this.mIsPremium)
    {
      i = R.drawable.premium;
      ((ImageView)localObject).setImageResource(i);
      localObject = findViewById(R.id.upgrade_button);
      if (!this.mIsPremium) {
        break label94;
      }
      i = 8;
      label45:
      ((View)localObject).setVisibility(i);
      if (this.mTank < TANK_RES_IDS.length) {
        break label99;
      }
    }
    label94:
    label99:
    for (int i = TANK_RES_IDS.length - 1;; i = this.mTank)
    {
      ((ImageView)findViewById(R.id.gas_gauge)).setImageResource(TANK_RES_IDS[i]);
      return;
      i = R.drawable.free;
      break;
      i = 0;
      break label45;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/in/app/billing/helper/trivialdrivesample/MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */