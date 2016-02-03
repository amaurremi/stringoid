package mobi.beyondpod.ui.core.mediarouter;

import android.support.v7.app.MediaRouteChooserDialogFragment;
import android.support.v7.app.MediaRouteDialogFactory;

public class BPMediaRouteDialogFactory
  extends MediaRouteDialogFactory
{
  private static final String TAG = BPMediaRouteDialogFactory.class.getSimpleName();
  private static final BPMediaRouteDialogFactory sDefault = new BPMediaRouteDialogFactory();
  
  public static BPMediaRouteDialogFactory getDefault()
  {
    return sDefault;
  }
  
  public MediaRouteChooserDialogFragment onCreateChooserDialogFragment()
  {
    return new BPMediaRouteChooserDialogFragment();
  }
  
  public BPMediaRouteControllerDialogFragment onCreateControllerDialogFragment()
  {
    return new BPMediaRouteControllerDialogFragment();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/mediarouter/BPMediaRouteDialogFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */