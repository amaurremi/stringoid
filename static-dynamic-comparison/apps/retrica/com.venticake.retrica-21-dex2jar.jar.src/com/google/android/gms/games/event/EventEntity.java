package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;
import com.google.android.gms.internal.ik;

public final class EventEntity
  implements SafeParcelable, Event
{
  public static final EventEntityCreator CREATOR = new EventEntityCreator();
  private final String MC;
  private final String Mp;
  private final Uri Mr;
  private final String Ni;
  private final PlayerEntity Nj;
  private final long Nk;
  private final String Nl;
  private final boolean Nm;
  private final String mName;
  private final int xM;
  
  EventEntity(int paramInt, String paramString1, String paramString2, String paramString3, Uri paramUri, String paramString4, Player paramPlayer, long paramLong, String paramString5, boolean paramBoolean)
  {
    this.xM = paramInt;
    this.Ni = paramString1;
    this.mName = paramString2;
    this.Mp = paramString3;
    this.Mr = paramUri;
    this.MC = paramString4;
    this.Nj = new PlayerEntity(paramPlayer);
    this.Nk = paramLong;
    this.Nl = paramString5;
    this.Nm = paramBoolean;
  }
  
  public EventEntity(Event paramEvent)
  {
    this.xM = 1;
    this.Ni = paramEvent.getEventId();
    this.mName = paramEvent.getName();
    this.Mp = paramEvent.getDescription();
    this.Mr = paramEvent.getIconImageUri();
    this.MC = paramEvent.getIconImageUrl();
    this.Nj = ((PlayerEntity)paramEvent.getPlayer().freeze());
    this.Nk = paramEvent.getValue();
    this.Nl = paramEvent.getFormattedValue();
    this.Nm = paramEvent.isVisible();
  }
  
  static int a(Event paramEvent)
  {
    return hk.hashCode(new Object[] { paramEvent.getEventId(), paramEvent.getName(), paramEvent.getDescription(), paramEvent.getIconImageUri(), paramEvent.getIconImageUrl(), paramEvent.getPlayer(), Long.valueOf(paramEvent.getValue()), paramEvent.getFormattedValue(), Boolean.valueOf(paramEvent.isVisible()) });
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
      if ((!hk.equal(((Event)paramObject).getEventId(), paramEvent.getEventId())) || (!hk.equal(((Event)paramObject).getName(), paramEvent.getName())) || (!hk.equal(((Event)paramObject).getDescription(), paramEvent.getDescription())) || (!hk.equal(((Event)paramObject).getIconImageUri(), paramEvent.getIconImageUri())) || (!hk.equal(((Event)paramObject).getIconImageUrl(), paramEvent.getIconImageUrl())) || (!hk.equal(((Event)paramObject).getPlayer(), paramEvent.getPlayer())) || (!hk.equal(Long.valueOf(((Event)paramObject).getValue()), Long.valueOf(paramEvent.getValue()))) || (!hk.equal(((Event)paramObject).getFormattedValue(), paramEvent.getFormattedValue()))) {
        break;
      }
      bool1 = bool2;
    } while (hk.equal(Boolean.valueOf(((Event)paramObject).isVisible()), Boolean.valueOf(paramEvent.isVisible())));
    return false;
  }
  
  static String b(Event paramEvent)
  {
    return hk.e(paramEvent).a("Id", paramEvent.getEventId()).a("Name", paramEvent.getName()).a("Description", paramEvent.getDescription()).a("IconImageUri", paramEvent.getIconImageUri()).a("IconImageUrl", paramEvent.getIconImageUrl()).a("Player", paramEvent.getPlayer()).a("Value", Long.valueOf(paramEvent.getValue())).a("FormattedValue", paramEvent.getFormattedValue()).a("isVisible", Boolean.valueOf(paramEvent.isVisible())).toString();
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
    return this.Mp;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    ik.b(this.Mp, paramCharArrayBuffer);
  }
  
  public String getEventId()
  {
    return this.Ni;
  }
  
  public String getFormattedValue()
  {
    return this.Nl;
  }
  
  public void getFormattedValue(CharArrayBuffer paramCharArrayBuffer)
  {
    ik.b(this.Nl, paramCharArrayBuffer);
  }
  
  public Uri getIconImageUri()
  {
    return this.Mr;
  }
  
  public String getIconImageUrl()
  {
    return this.MC;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public void getName(CharArrayBuffer paramCharArrayBuffer)
  {
    ik.b(this.mName, paramCharArrayBuffer);
  }
  
  public Player getPlayer()
  {
    return this.Nj;
  }
  
  public long getValue()
  {
    return this.Nk;
  }
  
  public int getVersionCode()
  {
    return this.xM;
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
    return this.Nm;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/event/EventEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */