package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;

public final class RoomEntity
  extends GamesDowngradeableSafeParcel
  implements Room
{
  public static final Parcelable.Creator<RoomEntity> CREATOR = new RoomEntityCreatorCompat();
  private final int BR;
  private final String Tg;
  private final String WF;
  private final long abO;
  private final ArrayList<ParticipantEntity> abR;
  private final int abS;
  private final Bundle ach;
  private final String acl;
  private final int acm;
  private final int acn;
  
  RoomEntity(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, String paramString3, int paramInt3, Bundle paramBundle, ArrayList<ParticipantEntity> paramArrayList, int paramInt4)
  {
    this.BR = paramInt1;
    this.WF = paramString1;
    this.acl = paramString2;
    this.abO = paramLong;
    this.acm = paramInt2;
    this.Tg = paramString3;
    this.abS = paramInt3;
    this.ach = paramBundle;
    this.abR = paramArrayList;
    this.acn = paramInt4;
  }
  
  public RoomEntity(Room paramRoom)
  {
    this.BR = 2;
    this.WF = paramRoom.getRoomId();
    this.acl = paramRoom.getCreatorId();
    this.abO = paramRoom.getCreationTimestamp();
    this.acm = paramRoom.getStatus();
    this.Tg = paramRoom.getDescription();
    this.abS = paramRoom.getVariant();
    this.ach = paramRoom.getAutoMatchCriteria();
    ArrayList localArrayList = paramRoom.getParticipants();
    int j = localArrayList.size();
    this.abR = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      this.abR.add((ParticipantEntity)((Participant)localArrayList.get(i)).freeze());
      i += 1;
    }
    this.acn = paramRoom.getAutoMatchWaitEstimateSeconds();
  }
  
  static int a(Room paramRoom)
  {
    return m.hashCode(new Object[] { paramRoom.getRoomId(), paramRoom.getCreatorId(), Long.valueOf(paramRoom.getCreationTimestamp()), Integer.valueOf(paramRoom.getStatus()), paramRoom.getDescription(), Integer.valueOf(paramRoom.getVariant()), paramRoom.getAutoMatchCriteria(), paramRoom.getParticipants(), Integer.valueOf(paramRoom.getAutoMatchWaitEstimateSeconds()) });
  }
  
  static int a(Room paramRoom, String paramString)
  {
    ArrayList localArrayList = paramRoom.getParticipants();
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      Participant localParticipant = (Participant)localArrayList.get(i);
      if (localParticipant.getParticipantId().equals(paramString)) {
        return localParticipant.getStatus();
      }
      i += 1;
    }
    throw new IllegalStateException("Participant " + paramString + " is not in room " + paramRoom.getRoomId());
  }
  
  static boolean a(Room paramRoom, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Room)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramRoom == paramObject);
      paramObject = (Room)paramObject;
      if ((!m.equal(((Room)paramObject).getRoomId(), paramRoom.getRoomId())) || (!m.equal(((Room)paramObject).getCreatorId(), paramRoom.getCreatorId())) || (!m.equal(Long.valueOf(((Room)paramObject).getCreationTimestamp()), Long.valueOf(paramRoom.getCreationTimestamp()))) || (!m.equal(Integer.valueOf(((Room)paramObject).getStatus()), Integer.valueOf(paramRoom.getStatus()))) || (!m.equal(((Room)paramObject).getDescription(), paramRoom.getDescription())) || (!m.equal(Integer.valueOf(((Room)paramObject).getVariant()), Integer.valueOf(paramRoom.getVariant()))) || (!m.equal(((Room)paramObject).getAutoMatchCriteria(), paramRoom.getAutoMatchCriteria())) || (!m.equal(((Room)paramObject).getParticipants(), paramRoom.getParticipants()))) {
        break;
      }
      bool1 = bool2;
    } while (m.equal(Integer.valueOf(((Room)paramObject).getAutoMatchWaitEstimateSeconds()), Integer.valueOf(paramRoom.getAutoMatchWaitEstimateSeconds())));
    return false;
  }
  
  static String b(Room paramRoom)
  {
    return m.h(paramRoom).a("RoomId", paramRoom.getRoomId()).a("CreatorId", paramRoom.getCreatorId()).a("CreationTimestamp", Long.valueOf(paramRoom.getCreationTimestamp())).a("RoomStatus", Integer.valueOf(paramRoom.getStatus())).a("Description", paramRoom.getDescription()).a("Variant", Integer.valueOf(paramRoom.getVariant())).a("AutoMatchCriteria", paramRoom.getAutoMatchCriteria()).a("Participants", paramRoom.getParticipants()).a("AutoMatchWaitEstimateSeconds", Integer.valueOf(paramRoom.getAutoMatchWaitEstimateSeconds())).toString();
  }
  
  static String b(Room paramRoom, String paramString)
  {
    paramRoom = paramRoom.getParticipants();
    int j = paramRoom.size();
    int i = 0;
    while (i < j)
    {
      Participant localParticipant = (Participant)paramRoom.get(i);
      Player localPlayer = localParticipant.getPlayer();
      if ((localPlayer != null) && (localPlayer.getPlayerId().equals(paramString))) {
        return localParticipant.getParticipantId();
      }
      i += 1;
    }
    return null;
  }
  
  static Participant c(Room paramRoom, String paramString)
  {
    ArrayList localArrayList = paramRoom.getParticipants();
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      Participant localParticipant = (Participant)localArrayList.get(i);
      if (localParticipant.getParticipantId().equals(paramString)) {
        return localParticipant;
      }
      i += 1;
    }
    throw new IllegalStateException("Participant " + paramString + " is not in match " + paramRoom.getRoomId());
  }
  
  static ArrayList<String> c(Room paramRoom)
  {
    paramRoom = paramRoom.getParticipants();
    int j = paramRoom.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(((Participant)paramRoom.get(i)).getParticipantId());
      i += 1;
    }
    return localArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Room freeze()
  {
    return this;
  }
  
  public Bundle getAutoMatchCriteria()
  {
    return this.ach;
  }
  
  public int getAutoMatchWaitEstimateSeconds()
  {
    return this.acn;
  }
  
  public long getCreationTimestamp()
  {
    return this.abO;
  }
  
  public String getCreatorId()
  {
    return this.acl;
  }
  
  public String getDescription()
  {
    return this.Tg;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    jv.b(this.Tg, paramCharArrayBuffer);
  }
  
  public Participant getParticipant(String paramString)
  {
    return c(this, paramString);
  }
  
  public String getParticipantId(String paramString)
  {
    return b(this, paramString);
  }
  
  public ArrayList<String> getParticipantIds()
  {
    return c(this);
  }
  
  public int getParticipantStatus(String paramString)
  {
    return a(this, paramString);
  }
  
  public ArrayList<Participant> getParticipants()
  {
    return new ArrayList(this.abR);
  }
  
  public String getRoomId()
  {
    return this.WF;
  }
  
  public int getStatus()
  {
    return this.acm;
  }
  
  public int getVariant()
  {
    return this.abS;
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
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!gQ()) {
      RoomEntityCreator.a(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      paramParcel.writeString(this.WF);
      paramParcel.writeString(this.acl);
      paramParcel.writeLong(this.abO);
      paramParcel.writeInt(this.acm);
      paramParcel.writeString(this.Tg);
      paramParcel.writeInt(this.abS);
      paramParcel.writeBundle(this.ach);
      int j = this.abR.size();
      paramParcel.writeInt(j);
      int i = 0;
      while (i < j)
      {
        ((ParticipantEntity)this.abR.get(i)).writeToParcel(paramParcel, paramInt);
        i += 1;
      }
    }
  }
  
  static final class RoomEntityCreatorCompat
    extends RoomEntityCreator
  {
    public RoomEntity co(Parcel paramParcel)
    {
      if ((RoomEntity.b(RoomEntity.jQ())) || (RoomEntity.bt(RoomEntity.class.getCanonicalName()))) {
        return super.co(paramParcel);
      }
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      long l = paramParcel.readLong();
      int j = paramParcel.readInt();
      String str3 = paramParcel.readString();
      int k = paramParcel.readInt();
      Bundle localBundle = paramParcel.readBundle();
      int m = paramParcel.readInt();
      ArrayList localArrayList = new ArrayList(m);
      int i = 0;
      while (i < m)
      {
        localArrayList.add(ParticipantEntity.CREATOR.createFromParcel(paramParcel));
        i += 1;
      }
      return new RoomEntity(2, str1, str2, l, j, str3, k, localBundle, localArrayList, -1);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RoomEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */