package com.venticake.retrica;

import android.app.Activity;
import android.location.Location;

public abstract class e
  extends Activity
  implements d
{
  public void logEventPhotoTaken(final Location paramLocation)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        jdField_this.logEventPhotoTaken(paramLocation);
      }
    }).start();
  }
  
  protected void onPause()
  {
    super.onPause();
    c.b(this, this);
  }
  
  protected void onResume()
  {
    super.onResume();
    c.a(this, this);
  }
  
  protected void onStart()
  {
    super.onStart();
    c.a(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    c.b(this);
  }
  
  public boolean shouldDisplayAd()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */