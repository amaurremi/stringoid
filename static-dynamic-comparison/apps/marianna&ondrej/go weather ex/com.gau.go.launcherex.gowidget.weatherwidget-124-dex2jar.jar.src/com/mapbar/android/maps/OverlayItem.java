package com.mapbar.android.maps;

import android.graphics.drawable.Drawable;

public class OverlayItem
{
  public static final int ITEM_STATE_FOCUSED_MASK = 4;
  public static final int ITEM_STATE_PRESSED_MASK = 1;
  public static final int ITEM_STATE_SELECTED_MASK = 2;
  private static final int[][] a = { { -16842908, -16842913, -16842919 }, { -16842908, -16842913, 16842919 }, { -16842908, 16842913, -16842919 }, { -16842908, 16842913, 16842919 }, { 16842908, -16842913, -16842919 }, { 16842908, -16842913, 16842919 }, { 16842908, 16842913, -16842919 }, { 16842908, 16842913, 16842919 } };
  protected Drawable mMarker = null;
  protected final GeoPoint mPoint;
  protected final String mSnippet;
  protected final String mTitle;
  
  public OverlayItem(GeoPoint paramGeoPoint, String paramString1, String paramString2)
  {
    this.mPoint = paramGeoPoint;
    this.mTitle = paramString1;
    this.mSnippet = paramString2;
  }
  
  public static void setState(Drawable paramDrawable, int paramInt)
  {
    paramDrawable.setState(a[paramInt]);
  }
  
  public Drawable getMarker(int paramInt)
  {
    if (this.mMarker != null) {
      setState(this.mMarker, paramInt);
    }
    return this.mMarker;
  }
  
  public GeoPoint getPoint()
  {
    return this.mPoint;
  }
  
  public String getSnippet()
  {
    return this.mSnippet;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public String routableAddress()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mPoint.getLatitudeE6() / 1000000.0F);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.mPoint.getLongitudeE6() / 1000000.0F);
    return localStringBuilder.toString();
  }
  
  public void setMarker(Drawable paramDrawable)
  {
    this.mMarker = paramDrawable;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/OverlayItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */