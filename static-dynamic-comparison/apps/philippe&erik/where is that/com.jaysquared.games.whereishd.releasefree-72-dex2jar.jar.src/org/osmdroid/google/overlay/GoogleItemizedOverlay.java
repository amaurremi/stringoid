package org.osmdroid.google.overlay;

import android.graphics.drawable.Drawable;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;
import java.util.ArrayList;

public class GoogleItemizedOverlay
  extends ItemizedOverlay
{
  private ArrayList<OverlayItem> mOverlays = new ArrayList();
  
  public GoogleItemizedOverlay(Drawable paramDrawable)
  {
    super(boundCenterBottom(paramDrawable));
  }
  
  public static void setOverlayMarkerCentered(OverlayItem paramOverlayItem, Drawable paramDrawable)
  {
    paramOverlayItem.setMarker(boundCenter(paramDrawable));
  }
  
  public void addOverlay(OverlayItem paramOverlayItem)
  {
    this.mOverlays.add(paramOverlayItem);
    populate();
  }
  
  protected OverlayItem createItem(int paramInt)
  {
    return (OverlayItem)this.mOverlays.get(paramInt);
  }
  
  public void removeAllItems()
  {
    this.mOverlays.clear();
  }
  
  public int size()
  {
    return this.mOverlays.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/google/overlay/GoogleItemizedOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */