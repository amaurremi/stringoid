package mobi.borken.android.adsupport;

import android.app.Activity;
import android.content.res.AssetManager;
import android.view.ViewGroup;
import java.io.IOException;
import java.util.Properties;

public abstract class AdSupportedActivity
  extends Activity
{
  private ViewGroup adContainer;
  private Properties properties;
  
  public abstract void addTestDevice(String paramString);
  
  protected ViewGroup getAdContainer()
  {
    return this.adContainer;
  }
  
  protected Properties getProperties()
  {
    return this.properties;
  }
  
  protected boolean hasProperty(String paramString)
  {
    return this.properties.containsKey(paramString);
  }
  
  protected void hideAd()
  {
    getAdContainer().setVisibility(8);
  }
  
  protected void initAdControl(int paramInt)
    throws IOException
  {
    initAdControl(paramInt, "ads.properties");
  }
  
  protected void initAdControl(int paramInt, String paramString)
    throws IOException
  {
    this.adContainer = ((ViewGroup)ViewGroup.class.cast(findViewById(paramInt)));
    this.properties = new Properties();
    try
    {
      paramString = getAssets().open(paramString);
      if (paramString != null) {
        this.properties.load(paramString);
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public abstract void param(String paramString1, String paramString2);
  
  protected void showAd()
  {
    getAdContainer().setVisibility(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/mobi/borken/android/adsupport/AdSupportedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */