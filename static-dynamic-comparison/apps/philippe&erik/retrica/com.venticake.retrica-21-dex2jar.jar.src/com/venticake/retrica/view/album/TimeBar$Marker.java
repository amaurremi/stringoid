package com.venticake.retrica.view.album;

import java.util.ArrayList;

final class TimeBar$Marker
{
  public static final int TYPE_DAY = 2;
  public static final int TYPE_DOT = 3;
  public static final int TYPE_MONTH = 1;
  public final int day;
  public ArrayList<MediaItem> items;
  public final int month;
  public final float x;
  public final int year;
  
  TimeBar$Marker(float paramFloat, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.x = paramFloat;
    this.year = paramInt1;
    this.month = paramInt2;
    this.day = paramInt3;
    this.items = new ArrayList(paramInt5);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/TimeBar$Marker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */