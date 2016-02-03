package mobi.beyondpod.ui.core.mediarouter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.MediaRouteControllerDialog;
import android.support.v7.app.MediaRouteControllerDialogFragment;

public class BPMediaRouteControllerDialogFragment
  extends MediaRouteControllerDialogFragment
{
  private static final String TAG = BPMediaRouteControllerDialogFragment.class.getSimpleName();
  private MediaRouteControllerDialog mControllerDialog;
  
  public MediaRouteControllerDialog onCreateControllerDialog(Context paramContext, Bundle paramBundle)
  {
    this.mControllerDialog = new BPMediaRouteControllerDialog(paramContext);
    this.mControllerDialog.setVolumeControlEnabled(true);
    return this.mControllerDialog;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/mediarouter/BPMediaRouteControllerDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */