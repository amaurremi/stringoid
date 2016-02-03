package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;

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
  
  public String li()
  {
    return getString("notification_id");
  }
  
  public String lj()
  {
    return getString("ticker");
  }
  
  public String lk()
  {
    return getString("coalesced_text");
  }
  
  public boolean ll()
  {
    return getInteger("acknowledged") > 0;
  }
  
  public boolean lm()
  {
    return getInteger("alert_level") == 0;
  }
  
  public String toString()
  {
    return m.h(this).a("Id", Long.valueOf(getId())).a("NotificationId", li()).a("Type", Integer.valueOf(getType())).a("Title", getTitle()).a("Ticker", lj()).a("Text", getText()).a("CoalescedText", lk()).a("isAcknowledged", Boolean.valueOf(ll())).a("isSilent", Boolean.valueOf(lm())).toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/notification/GameNotificationRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */