package mobi.beyondpod.ui.dialogs;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.RssFeedCache;
import mobi.beyondpod.ui.core.volley.DiskBasedCacheBP;

public class ClearCachesDialog
{
  private static final String CACHE_CLEARED = CoreHelper.LoadResourceString(2131297005);
  private Context _Context;
  
  private ClearCachesDialog(Context paramContext)
  {
    this._Context = paramContext;
  }
  
  private Dialog CreateDialog()
  {
    final View localView = LayoutInflater.from(this._Context).inflate(2130903094, null);
    Button localButton1 = (Button)localView.findViewById(2131230904);
    Button localButton2 = (Button)localView.findViewById(2131230905);
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        RssFeedCache.DeleteCacheForAllFeeds();
        Toast.makeText(localView.getContext(), ClearCachesDialog.CACHE_CLEARED, 0).show();
      }
    });
    localButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        FeedRepository.ClearTrackImageCaches();
        DiskBasedCacheBP.deleteCachedFiles();
        Toast.makeText(localView.getContext(), ClearCachesDialog.CACHE_CLEARED, 0).show();
      }
    });
    return new AlertDialog.Builder(this._Context).setIcon(17301659).setTitle(2131296767).setView(localView).create();
  }
  
  public static void ShowDialog(Context paramContext)
  {
    new ClearCachesDialog(paramContext).CreateDialog().show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/ClearCachesDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */