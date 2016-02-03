package logo.quiz.commons.inapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import logo.quiz.commons.R.string;

public abstract class InAppProduct
  implements InApp
{
  public static final String IAB_SETTINGS_FILE_NAME = "IAB_EXPERT_MODE_SETTINGS_FILE_NAME";
  protected Context context;
  private String price;
  private String priceSettingsKey;
  private String productId;
  
  public InAppProduct(String paramString1, String paramString2, Context paramContext)
  {
    this.productId = paramString1;
    this.priceSettingsKey = paramString2;
    this.context = paramContext;
  }
  
  public String getPrice()
  {
    return PreferenceManager.getDefaultSharedPreferences(this.context).getString(getPriceSettingsKey(), this.context.getResources().getString(R.string.buy));
  }
  
  protected String getPriceSettingsKey()
  {
    return this.priceSettingsKey;
  }
  
  public String getProductId()
  {
    return this.productId;
  }
  
  public boolean isPurchased()
  {
    return this.context.getSharedPreferences("IAB_EXPERT_MODE_SETTINGS_FILE_NAME", 0).getBoolean(getProductId(), false);
  }
  
  public void setPrice(String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
    localEditor.putString(getPriceSettingsKey(), paramString);
    localEditor.commit();
  }
  
  public void setPurchase()
  {
    SharedPreferences.Editor localEditor = this.context.getSharedPreferences("IAB_EXPERT_MODE_SETTINGS_FILE_NAME", 0).edit();
    localEditor.putBoolean(getProductId(), true);
    localEditor.commit();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/inapp/InAppProduct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */