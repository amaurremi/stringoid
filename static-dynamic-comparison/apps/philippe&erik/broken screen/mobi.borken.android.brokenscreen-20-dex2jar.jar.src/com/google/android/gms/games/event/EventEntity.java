package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.il;

public final class EventEntity
  implements SafeParcelable, Event
{
  public static final EventEntityCreator CREATOR = new EventEntityCreator();
  private final String Mm;
  private final Uri Mo;
  private final String Mz;
  private final String Nf;
  private final PlayerEntity Ng;
  private final long Nh;
  private final String Ni;
  private final boolean Nj;
  private final String mName;
  private final int xJ;
  
  EventEntity(int paramInt, String paramString1, String paramString2, String paramString3, Uri paramUri, String paramString4, Player paramPlayer, long paramLong, String paramString5, boolean paramBoolean)
  {
    this.xJ = paramInt;
    this.Nf = paramString1;
    this.mName = paramString2;
    this.Mm = paramString3;
    this.Mo = paramUri;
    this.Mz = paramString4;
    this.Ng = new PlayerEntity(paramPlayer);
    this.Nh = paramLong;
    this.Ni = paramString5;
    this.Nj = paramBoolean;
  }
  
  public EventEntity(Event paramEvent)
  {
    this.xJ = 1;
    this.Nf = paramEvent.getEventId();
    this.mName = paramEvent.getName();
    this.Mm = paramEvent.getDescription();
    this.Mo = paramEvent.getIconImageUri();
    this.Mz = paramEvent.getIconImageUrl();
    this.Ng = ((PlayerEntity)paramEvent.getPlayer().freeze());
    this.Nh = paramEvent.getValue();
    this.Ni = paramEvent.getFormattedValue();
    this.Nj = paramEvent.isVisible();
  }
  
  static int a(Event paramEvent)
  {
    return hl.hashCode(new Object[] { paramEvent.getEventId(), paramEvent.getName(), paramEvent.getDescription(), paramEvent.getIconImageUri(), paramEvent.getIconImageUrl(), paramEvent.getPlayer(), Long.valueOf(paramEvent.getValue()), paramEvent.getFormattedValue(), Boolean.valueOf(paramEvent.isVisible()) });
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
      if ((!hl.equal(((Event)paramObject).getEventId(), paramEvent.getEventId())) || (!hl.equal(((Event)paramObject).getName(), paramEvent.getName())) || (!hl.equal(((Event)paramObject).getDescription(), paramEvent.getDescription())) || (!hl.equal(((Event)paramObject).getIconImageUri(), paramEvent.getIconImageUri())) || (!hl.equal(((Event)paramObject).getIconImageUrl(), paramEvent.getIconImageUrl())) || (!hl.equal(((Event)paramObject).getPlayer(), paramEvent.getPlayer())) || (!hl.equal(Long.valueOf(((Event)paramObject).getValue()), Long.valueOf(paramEvent.getValue()))) || (!hl.equal(((Event)paramObject).getFormattedValue(), paramEvent.getFormattedValue()))) {
        break;
      }
      bool1 = bool2;
    } while (hl.equal(Boolean.valueOf(((Event)paramObject).isVisible()), Boolean.valueOf(paramEvent.isVisible())));
    return false;
  }
  
  static String b(Event paramEvent)
  {
    return hl.e(paramEvent).a("Id", paramEvent.getEventId()).a("Name", paramEvent.getName()).a("Description", paramEvent.getDescription()).a("IconImageUri", paramEvent.getIconImageUri()).a("IconImageUrl", paramEvent.getIconImageUrl()).a("Player", paramEvent.getPlayer()).a("Value", Long.valueOf(paramEvent.getValue())).a("FormattedValue", paramEvent.getFormattedValue()).a("isVisible", Boolean.valueOf(paramEvent.isVisible())).toString();
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
    return this.Mm;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Mm, paramCharArrayBuffer);
  }
  
  public String getEventId()
  {
    return this.Nf;
  }
  
  public String getFormattedValue()
  {
    return this.Ni;
  }
  
  public void getFormattedValue(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Ni, paramCharArrayBuffer);
  }
  
  public Uri getIconImageUri()
  {
    return this.Mo;
  }
  
  public String getIconImageUrl()
  {
    return this.Mz;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public void getName(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.mName, paramCharArrayBuffer);
  }
  
  public Player getPlayer()
  {
    return this.Ng;
  }
  
  public long getValue()
  {
    return this.Nh;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
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
    return this.Nj;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/event/EventEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */