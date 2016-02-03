package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.jv;

public final class EventEntity
  implements SafeParcelable, Event
{
  public static final EventEntityCreator CREATOR = new EventEntityCreator();
  private final int BR;
  private final String Tg;
  private final Uri UW;
  private final PlayerEntity VW;
  private final String Vh;
  private final String Wb;
  private final long Wc;
  private final String Wd;
  private final boolean We;
  private final String mName;
  
  EventEntity(int paramInt, String paramString1, String paramString2, String paramString3, Uri paramUri, String paramString4, Player paramPlayer, long paramLong, String paramString5, boolean paramBoolean)
  {
    this.BR = paramInt;
    this.Wb = paramString1;
    this.mName = paramString2;
    this.Tg = paramString3;
    this.UW = paramUri;
    this.Vh = paramString4;
    this.VW = new PlayerEntity(paramPlayer);
    this.Wc = paramLong;
    this.Wd = paramString5;
    this.We = paramBoolean;
  }
  
  public EventEntity(Event paramEvent)
  {
    this.BR = 1;
    this.Wb = paramEvent.getEventId();
    this.mName = paramEvent.getName();
    this.Tg = paramEvent.getDescription();
    this.UW = paramEvent.getIconImageUri();
    this.Vh = paramEvent.getIconImageUrl();
    this.VW = ((PlayerEntity)paramEvent.getPlayer().freeze());
    this.Wc = paramEvent.getValue();
    this.Wd = paramEvent.getFormattedValue();
    this.We = paramEvent.isVisible();
  }
  
  static int a(Event paramEvent)
  {
    return m.hashCode(new Object[] { paramEvent.getEventId(), paramEvent.getName(), paramEvent.getDescription(), paramEvent.getIconImageUri(), paramEvent.getIconImageUrl(), paramEvent.getPlayer(), Long.valueOf(paramEvent.getValue()), paramEvent.getFormattedValue(), Boolean.valueOf(paramEvent.isVisible()) });
  }
  
  static boolean a(Event paramEvent, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Event)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramEvent == paramObject);
      paramObject = (Event)paramObject;
      if ((!m.equal(((Event)paramObject).getEventId(), paramEvent.getEventId())) || (!m.equal(((Event)paramObject).getName(), paramEvent.getName())) || (!m.equal(((Event)paramObject).getDescription(), paramEvent.getDescription())) || (!m.equal(((Event)paramObject).getIconImageUri(), paramEvent.getIconImageUri())) || (!m.equal(((Event)paramObject).getIconImageUrl(), paramEvent.getIconImageUrl())) || (!m.equal(((Event)paramObject).getPlayer(), paramEvent.getPlayer())) || (!m.equal(Long.valueOf(((Event)paramObject).getValue()), Long.valueOf(paramEvent.getValue()))) || (!m.equal(((Event)paramObject).getFormattedValue(), paramEvent.getFormattedValue()))) {
        break;
      }
      bool1 = bool2;
    } while (m.equal(Boolean.valueOf(((Event)paramObject).isVisible()), Boolean.valueOf(paramEvent.isVisible())));
    return false;
  }
  
  static String b(Event paramEvent)
  {
    return m.h(paramEvent).a("Id", paramEvent.getEventId()).a("Name", paramEvent.getName()).a("Description", paramEvent.getDescription()).a("IconImageUri", paramEvent.getIconImageUri()).a("IconImageUrl", paramEvent.getIconImageUrl()).a("Player", paramEvent.getPlayer()).a("Value", Long.valueOf(paramEvent.getValue())).a("FormattedValue", paramEvent.getFormattedValue()).a("isVisible", Boolean.valueOf(paramEvent.isVisible())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Event freeze()
  {
    return this;
  }
  
  public String getDescription()
  {
    return this.Tg;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    jv.b(this.Tg, paramCharArrayBuffer);
  }
  
  public String getEventId()
  {
    return this.Wb;
  }
  
  public String getFormattedValue()
  {
    return this.Wd;
  }
  
  public void getFormattedValue(CharArrayBuffer paramCharArrayBuffer)
  {
    jv.b(this.Wd, paramCharArrayBuffer);
  }
  
  public Uri getIconImageUri()
  {
    return this.UW;
  }
  
  public String getIconImageUrl()
  {
    return this.Vh;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public void getName(CharArrayBuffer paramCharArrayBuffer)
  {
    jv.b(this.mName, paramCharArrayBuffer);
  }
  
  public Player getPlayer()
  {
    return this.VW;
  }
  
  public long getValue()
  {
    return this.Wc;
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isVisible()
  {
    return this.We;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    EventEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/event/EventEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */