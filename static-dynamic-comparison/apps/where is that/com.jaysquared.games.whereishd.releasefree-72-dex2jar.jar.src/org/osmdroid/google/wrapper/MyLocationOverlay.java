package org.osmdroid.google.wrapper;

import android.content.Context;
import com.google.android.maps.MapView;
import org.osmdroid.api.IMyLocationOverlay;

public class MyLocationOverlay
  extends com.google.android.maps.MyLocationOverlay
  implements IMyLocationOverlay
{
  public MyLocationOverlay(Context paramContext, MapView paramMapView)
  {
    super(paramContext, paramMapView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/google/wrapper/MyLocationOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */