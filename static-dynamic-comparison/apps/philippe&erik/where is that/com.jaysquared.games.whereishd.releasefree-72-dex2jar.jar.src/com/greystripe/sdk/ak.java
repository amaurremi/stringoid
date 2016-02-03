package com.greystripe.sdk;

import android.net.Uri;
import android.widget.MediaController;

final class ak
  implements Runnable
{
  ak(aj paramaj, String paramString) {}
  
  public final void run()
  {
    this.b.a = new y(aj.a(this.b).getContext());
    this.b.a.setVideoURI(Uri.parse(this.a));
    this.b.a.setOnErrorListener(this.b);
    this.b.a.a(this.b);
    MediaController localMediaController = new MediaController(aj.a(this.b).getContext());
    localMediaController.setAnchorView(this.b.a);
    this.b.a.setMediaController(localMediaController);
    aj.a(this.b).removeAllViews();
    aj.a(this.b).addView(this.b.a);
    this.b.a.start();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */