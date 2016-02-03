package mobi.beyondpod.ui.core;

import android.annotation.SuppressLint;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public abstract class WebViewPluginHelper
{
  public static void EnableBrowserPluginsIfNeeded(WebSettings paramWebSettings)
  {
    if (Configuration.EnableBrowserPlugins()) {
      getInstance().EnablePlugins(paramWebSettings, true);
    }
  }
  
  public static WebViewPluginHelper getInstance()
  {
    if (CoreHelper.ApiLevel() < 8) {
      return WebViewPluginHelper.OldStyle.Holder.sInstance;
    }
    return WebViewPluginHelper.NewStyle.Holder.sInstance;
  }
  
  public abstract void EnablePlugins(WebSettings paramWebSettings, boolean paramBoolean);
  
  private static class NewStyle
    extends WebViewPluginHelper
  {
    @SuppressLint({"NewApi"})
    public void EnablePlugins(WebSettings paramWebSettings, boolean paramBoolean)
    {
      if (Configuration.EnableBrowserPlugins()) {}
      for (WebSettings.PluginState localPluginState = WebSettings.PluginState.ON;; localPluginState = WebSettings.PluginState.OFF)
      {
        paramWebSettings.setPluginState(localPluginState);
        return;
      }
    }
    
    private static class Holder
    {
      private static final WebViewPluginHelper.NewStyle sInstance = new WebViewPluginHelper.NewStyle(null);
    }
  }
  
  private static class OldStyle
    extends WebViewPluginHelper
  {
    public void EnablePlugins(WebSettings paramWebSettings, boolean paramBoolean) {}
    
    private static class Holder
    {
      private static final WebViewPluginHelper.OldStyle sInstance = new WebViewPluginHelper.OldStyle(null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/WebViewPluginHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */