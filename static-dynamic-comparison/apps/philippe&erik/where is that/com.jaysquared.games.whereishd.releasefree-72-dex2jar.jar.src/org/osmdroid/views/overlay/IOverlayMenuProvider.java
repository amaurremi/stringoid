package org.osmdroid.views.overlay;

import android.view.Menu;
import android.view.MenuItem;
import org.osmdroid.views.MapView;

public abstract interface IOverlayMenuProvider
{
  public abstract boolean isOptionsMenuEnabled();
  
  public abstract boolean onCreateOptionsMenu(Menu paramMenu, int paramInt, MapView paramMapView);
  
  public abstract boolean onOptionsItemSelected(MenuItem paramMenuItem, int paramInt, MapView paramMapView);
  
  public abstract boolean onPrepareOptionsMenu(Menu paramMenu, int paramInt, MapView paramMapView);
  
  public abstract void setOptionsMenuEnabled(boolean paramBoolean);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/IOverlayMenuProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */