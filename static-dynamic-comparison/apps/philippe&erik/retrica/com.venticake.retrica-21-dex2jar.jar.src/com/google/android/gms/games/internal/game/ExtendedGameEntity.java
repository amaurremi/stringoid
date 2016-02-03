package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;
import java.util.ArrayList;

public final class ExtendedGameEntity
  extends GamesDowngradeableSafeParcel
  implements ExtendedGame
{
  public static final ExtendedGameEntityCreator CREATOR = new a();
  private final long RA;
  private final String RB;
  private final ArrayList<GameBadgeEntity> RC;
  private final SnapshotMetadataEntity RD;
  private final GameEntity Rt;
  private final int Ru;
  private final boolean Rv;
  private final int Rw;
  private final long Rx;
  private final long Ry;
  private final String Rz;
  private final int xM;
  
  ExtendedGameEntity(int paramInt1, GameEntity paramGameEntity, int paramInt2, boolean paramBoolean, int paramInt3, long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, ArrayList<GameBadgeEntity> paramArrayList, SnapshotMetadataEntity paramSnapshotMetadataEntity)
  {
    this.xM = paramInt1;
    this.Rt = paramGameEntity;
    this.Ru = paramInt2;
    this.Rv = paramBoolean;
    this.Rw = paramInt3;
    this.Rx = paramLong1;
    this.Ry = paramLong2;
    this.Rz = paramString1;
    this.RA = paramLong3;
    this.RB = paramString2;
    this.RC = paramArrayList;
    this.RD = paramSnapshotMetadataEntity;
  }
  
  public ExtendedGameEntity(ExtendedGame paramExtendedGame)
  {
    this.xM = 2;
    Object localObject1 = paramExtendedGame.getGame();
    if (localObject1 == null)
    {
      localObject1 = null;
      this.Rt = ((GameEntity)localObject1);
      this.Ru = paramExtendedGame.hR();
      this.Rv = paramExtendedGame.hS();
      this.Rw = paramExtendedGame.hT();
      this.Rx = paramExtendedGame.hU();
      this.Ry = paramExtendedGame.hV();
      this.Rz = paramExtendedGame.hW();
      this.RA = paramExtendedGame.hX();
      this.RB = paramExtendedGame.hY();
      localObject1 = paramExtendedGame.hZ();
      if (localObject1 != null) {
        break label213;
      }
    }
    label213:
    for (localObject1 = localObject2;; localObject1 = new SnapshotMetadataEntity((SnapshotMetadata)localObject1))
    {
      this.RD = ((SnapshotMetadataEntity)localObject1);
      paramExtendedGame = paramExtendedGame.hQ();
      int j = paramExtendedGame.size();
      this.RC = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        this.RC.add((GameBadgeEntity)((GameBadge)paramExtendedGame.get(i)).freeze());
        i += 1;
      }
      localObject1 = new GameEntity((Game)localObject1);
      break;
    }
  }
  
  static int a(ExtendedGame paramExtendedGame)
  {
    return hk.hashCode(new Object[] { paramExtendedGame.getGame(), Integer.valueOf(paramExtendedGame.hR()), Boolean.valueOf(paramExtendedGame.hS()), Integer.valueOf(paramExtendedGame.hT()), Long.valueOf(paramExtendedGame.hU()), Long.valueOf(paramExtendedGame.hV()), paramExtendedGame.hW(), Long.valueOf(paramExtendedGame.hX()), paramExtendedGame.hY() });
  }
  
  static boolean a(ExtendedGame paramExtendedGame, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof ExtendedGame)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramExtendedGame == paramObject);
      paramObject = (ExtendedGame)paramObject;
      if ((!hk.equal(((ExtendedGame)paramObject).getGame(), paramExtendedGame.getGame())) || (!hk.equal(Integer.valueOf(((ExtendedGame)paramObject).hR()), Integer.valueOf(paramExtendedGame.hR()))) || (!hk.equal(Boolean.valueOf(((ExtendedGame)paramObject).hS()), Boolean.valueOf(paramExtendedGame.hS()))) || (!hk.equal(Integer.valueOf(((ExtendedGame)paramObject).hT()), Integer.valueOf(paramExtendedGame.hT()))) || (!hk.equal(Long.valueOf(((ExtendedGame)paramObject).hU()), Long.valueOf(paramExtendedGame.hU()))) || (!hk.equal(Long.valueOf(((ExtendedGame)paramObject).hV()), Long.valueOf(paramExtendedGame.hV()))) || (!hk.equal(((ExtendedGame)paramObject).hW(), paramExtendedGame.hW())) || (!hk.equal(Long.valueOf(((ExtendedGame)paramObject).hX()), Long.valueOf(paramExtendedGame.hX())))) {
        break;
      }
      bool1 = bool2;
    } while (hk.equal(((ExtendedGame)paramObject).hY(), paramExtendedGame.hY()));
    return false;
  }
  
  static String b(ExtendedGame paramExtendedGame)
  {
    return hk.e(paramExtendedGame).a("Game", paramExtendedGame.getGame()).a("Availability", Integer.valueOf(paramExtendedGame.hR())).a("Owned", Boolean.valueOf(paramExtendedGame.hS())).a("AchievementUnlockedCount", Integer.valueOf(paramExtendedGame.hT())).a("LastPlayedServerTimestamp", Long.valueOf(paramExtendedGame.hU())).a("PriceMicros", Long.valueOf(paramExtendedGame.hV())).a("FormattedPrice", paramExtendedGame.hW()).a("FullPriceMicros", Long.valueOf(paramExtendedGame.hX())).a("FormattedFullPrice", paramExtendedGame.hY()).a("Snapshot", paramExtendedGame.hZ()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public ArrayList<GameBadge> hQ()
  {
    return new ArrayList(this.RC);
  }
  
  public int hR()
  {
    return this.Ru;
  }
  
  public boolean hS()
  {
    return this.Rv;
  }
  
  public int hT()
  {
    return this.Rw;
  }
  
  public long hU()
  {
    return this.Rx;
  }
  
  public long hV()
  {
    return this.Ry;
  }
  
  public String hW()
  {
    return this.Rz;
  }
  
  public long hX()
  {
    return this.RA;
  }
  
  public String hY()
  {
    return this.RB;
  }
  
  public SnapshotMetadata hZ()
  {
    return this.RD;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public GameEntity ia()
  {
    return this.Rt;
  }
  
  public ExtendedGame ib()
  {
    return this;
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
    int j = 0;
    if (!fr())
    {
      ExtendedGameEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    this.Rt.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.Ru);
    if (this.Rv) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.Rw);
      paramParcel.writeLong(this.Rx);
      paramParcel.writeLong(this.Ry);
      paramParcel.writeString(this.Rz);
      paramParcel.writeLong(this.RA);
      paramParcel.writeString(this.RB);
      int k = this.RC.size();
      paramParcel.writeInt(k);
      i = j;
      while (i < k)
      {
        ((GameBadgeEntity)this.RC.get(i)).writeToParcel(paramParcel, paramInt);
        i += 1;
      }
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/game/ExtendedGameEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */