package mobi.beyondpod.ui.core.mediarouter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.MediaRouteChooserDialog;
import android.support.v7.app.MediaRouteChooserDialogFragment;

public class BPMediaRouteChooserDialogFragment
  extends MediaRouteChooserDialogFragment
{
  private static final String TAG = BPMediaRouteChooserDialogFragment.class.getSimpleName();
  private MediaRouteChooserDialog mChooserDialog;
  
  public MediaRouteChooserDialog onCreateChooserDialog(Context paramContext, Bundle paramBundle)
  {
    this.mChooserDialog = new BPMediaRouteChooserDialog(paramContext);
    return this.mChooserDialog;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/mediarouter/BPMediaRouteChooserDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */