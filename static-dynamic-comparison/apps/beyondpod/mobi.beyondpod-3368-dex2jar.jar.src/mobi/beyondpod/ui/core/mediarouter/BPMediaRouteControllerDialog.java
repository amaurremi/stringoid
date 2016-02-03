package mobi.beyondpod.ui.core.mediarouter;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.MediaRouteControllerDialog;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import mobi.beyondpod.R.id;
import mobi.beyondpod.R.string;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public class BPMediaRouteControllerDialog
  extends MediaRouteControllerDialog
{
  private static final String TAG = "MediaRouteControllerDialog";
  
  public BPMediaRouteControllerDialog(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public BPMediaRouteControllerDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public View onCreateMediaControlView(Bundle paramBundle)
  {
    if (CoreHelper.ApiLevel() < 11)
    {
      ((Button)findViewById(R.id.media_route_disconnect_button)).setVisibility(8);
      paramBundle = new Button(getContext());
      paramBundle.setText(R.string.mr_media_route_controller_disconnect);
      paramBundle.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = MediaRouter.getInstance(BPMediaRouteControllerDialog.this.getContext());
          if (paramAnonymousView.getSelectedRoute().isSelected()) {
            paramAnonymousView.getDefaultRoute().select();
          }
          BPMediaRouteControllerDialog.this.dismiss();
        }
      });
      return paramBundle;
    }
    return null;
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(getContext().getResources().getString(R.string.cc_casting_to, new Object[] { paramCharSequence }));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/mediarouter/BPMediaRouteControllerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */