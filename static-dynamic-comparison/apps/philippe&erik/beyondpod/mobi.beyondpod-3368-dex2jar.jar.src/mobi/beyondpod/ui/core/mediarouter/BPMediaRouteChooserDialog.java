package mobi.beyondpod.ui.core.mediarouter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.MediaRouteChooserDialog;
import mobi.beyondpod.R.string;
import mobi.beyondpod.services.player.PlayList;

public class BPMediaRouteChooserDialog
  extends MediaRouteChooserDialog
{
  private static final String TAG = "MediaRouteChooserDialog";
  
  public BPMediaRouteChooserDialog(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public BPMediaRouteChooserDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (PlayList.IsCurrentlyPlaying())
    {
      super.setTitle(getContext().getResources().getString(R.string.cc_cast_to));
      return;
    }
    super.setTitle(paramCharSequence);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/mediarouter/BPMediaRouteChooserDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */