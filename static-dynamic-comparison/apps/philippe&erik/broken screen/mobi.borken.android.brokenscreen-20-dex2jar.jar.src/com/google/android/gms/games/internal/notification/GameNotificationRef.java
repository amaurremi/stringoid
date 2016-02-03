package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public final class GameNotificationRef
  extends d
  implements GameNotification
{
  GameNotificationRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public long getId()
  {
    return getLong("_id");
  }
  
  public String getText()
  {
    return getString("text");
  }
  
  public String getTitle()
  {
    return getString("title");
  }
  
  public int getType()
  {
    return getInteger("type");
  }
  
  public String jdMethod_if()
  {
    return getString("notification_id");
  }
  
  public String ig()
  {
    return getString("ticker");
  }
  
  public String ih()
  {
    return getString("coalesced_text");
  }
  
  public boolean ii()
  {
    return getInteger("acknowledged") > 0;
  }
  
  public boolean ij()
  {
    return getInteger("alert_level") == 0;
  }
  
  public String toString()
  {
    return hl.e(this).a("Id", Long.valueOf(getId())).a("NotificationId", jdMethod_if()).a("Type", Integer.valueOf(getType())).a("Title", getTitle()).a("Ticker", ig()).a("Text", getText()).a("CoalescedText", ih()).a("isAcknowledged", Boolean.valueOf(ii())).a("isSilent", Boolean.valueOf(ij())).toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/notification/GameNotificationRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */