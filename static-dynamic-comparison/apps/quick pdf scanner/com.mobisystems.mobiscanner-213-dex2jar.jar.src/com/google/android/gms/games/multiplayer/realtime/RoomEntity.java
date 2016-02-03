package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.cz.a;
import com.google.android.gms.internal.fy;
import java.util.ArrayList;

public final class RoomEntity
  extends fy
  implements Room
{
  public static final Parcelable.Creator<RoomEntity> CREATOR = new a();
  private final int qh;
  private final long vN;
  private final ArrayList<ParticipantEntity> vQ;
  private final int vR;
  private final String vf;
  private final String wj;
  private final String wk;
  private final int wl;
  private final Bundle wm;
  private final int wn;
  
  RoomEntity(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, String paramString3, int paramInt3, Bundle paramBundle, ArrayList<ParticipantEntity> paramArrayList, int paramInt4)
  {
    this.qh = paramInt1;
    this.wj = paramString1;
    this.wk = paramString2;
    this.vN = paramLong;
    this.wl = paramInt2;
    this.vf = paramString3;
    this.vR = paramInt3;
    this.wm = paramBundle;
    this.vQ = paramArrayList;
    this.wn = paramInt4;
  }
  
  public RoomEntity(Room paramRoom)
  {
    this.qh = 2;
    this.wj = paramRoom.oo();
    this.wk = paramRoom.op();
    this.vN = paramRoom.oa();
    this.wl = paramRoom.getStatus();
    this.vf = paramRoom.getDescription();
    this.vR = paramRoom.oc();
    this.wm = paramRoom.oq();
    ArrayList localArrayList = paramRoom.oe();
    int j = localArrayList.size();
    this.vQ = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      this.vQ.add((ParticipantEntity)((Participant)localArrayList.get(i)).mM());
      i += 1;
    }
    this.wn = paramRoom.or();
  }
  
  static int a(Room paramRoom)
  {
    return cz.hashCode(new Object[] { paramRoom.oo(), paramRoom.op(), Long.valueOf(paramRoom.oa()), Integer.valueOf(paramRoom.getStatus()), paramRoom.getDescription(), Integer.valueOf(paramRoom.oc()), paramRoom.oq(), paramRoom.oe(), Integer.valueOf(paramRoom.or()) });
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
      if ((!cz.b(((Room)paramObject).oo(), paramRoom.oo())) || (!cz.b(((Room)paramObject).op(), paramRoom.op())) || (!cz.b(Long.valueOf(((Room)paramObject).oa()), Long.valueOf(paramRoom.oa()))) || (!cz.b(Integer.valueOf(((Room)paramObject).getStatus()), Integer.valueOf(paramRoom.getStatus()))) || (!cz.b(((Room)paramObject).getDescription(), paramRoom.getDescription())) || (!cz.b(Integer.valueOf(((Room)paramObject).oc()), Integer.valueOf(paramRoom.oc()))) || (!cz.b(((Room)paramObject).oq(), paramRoom.oq())) || (!cz.b(((Room)paramObject).oe(), paramRoom.oe()))) {
        break;
      }
      bool1 = bool2;
    } while (cz.b(Integer.valueOf(((Room)paramObject).or()), Integer.valueOf(paramRoom.or())));
    return false;
  }
  
  static String b(Room paramRoom)
  {
    return cz.M(paramRoom).a("RoomId", paramRoom.oo()).a("CreatorId", paramRoom.op()).a("CreationTimestamp", Long.valueOf(paramRoom.oa())).a("RoomStatus", Integer.valueOf(paramRoom.getStatus())).a("Description", paramRoom.getDescription()).a("Variant", Integer.valueOf(paramRoom.oc())).a("AutoMatchCriteria", paramRoom.oq()).a("Participants", paramRoom.oe()).a("AutoMatchWaitEstimateSeconds", Integer.valueOf(paramRoom.or())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public String getDescription()
  {
    return this.vf;
  }
  
  public int getStatus()
  {
    return this.wl;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public int lX()
  {
    return this.qh;
  }
  
  public long oa()
  {
    return this.vN;
  }
  
  public int oc()
  {
    return this.vR;
  }
  
  public ArrayList<Participant> oe()
  {
    return new ArrayList(this.vQ);
  }
  
  public String oo()
  {
    return this.wj;
  }
  
  public String op()
  {
    return this.wk;
  }
  
  public Bundle oq()
  {
    return this.wm;
  }
  
  public int or()
  {
    return this.wn;
  }
  
  public Room os()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!qp()) {
      b.a(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      paramParcel.writeString(this.wj);
      paramParcel.writeString(this.wk);
      paramParcel.writeLong(this.vN);
      paramParcel.writeInt(this.wl);
      paramParcel.writeString(this.vf);
      paramParcel.writeInt(this.vR);
      paramParcel.writeBundle(this.wm);
      int j = this.vQ.size();
      paramParcel.writeInt(j);
      int i = 0;
      while (i < j)
      {
        ((ParticipantEntity)this.vQ.get(i)).writeToParcel(paramParcel, paramInt);
        i += 1;
      }
    }
  }
  
  static final class a
    extends b
  {
    public RoomEntity ac(Parcel paramParcel)
    {
      if ((RoomEntity.a(RoomEntity.nR())) || (RoomEntity.aw(RoomEntity.class.getCanonicalName()))) {
        return super.ac(paramParcel);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RoomEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */