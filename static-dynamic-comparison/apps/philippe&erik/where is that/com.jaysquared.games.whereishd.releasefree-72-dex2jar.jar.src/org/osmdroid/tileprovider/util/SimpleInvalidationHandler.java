package org.osmdroid.tileprovider.util;

import android.os.Handler;
import android.os.Message;
import android.view.View;

public class SimpleInvalidationHandler
  extends Handler
{
  private final View mView;
  
  public SimpleInvalidationHandler(View paramView)
  {
    this.mView = paramView;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.mView.invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/util/SimpleInvalidationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */