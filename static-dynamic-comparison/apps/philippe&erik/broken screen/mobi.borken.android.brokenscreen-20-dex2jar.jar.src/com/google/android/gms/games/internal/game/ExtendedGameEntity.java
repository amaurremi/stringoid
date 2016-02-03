package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import java.util.ArrayList;

public final class ExtendedGameEntity
  extends GamesDowngradeableSafeParcel
  implements ExtendedGame
{
  public static final ExtendedGameEntityCreator CREATOR = new ExtendedGameEntityCreatorCompat();
  private final SnapshotMetadataEntity RA;
  private final GameEntity Rq;
  private final int Rr;
  private final boolean Rs;
  private final int Rt;
  private final long Ru;
  private final long Rv;
  private final String Rw;
  private final long Rx;
  private final String Ry;
  private final ArrayList<GameBadgeEntity> Rz;
  private final int xJ;
  
  ExtendedGameEntity(int paramInt1, GameEntity paramGameEntity, int paramInt2, boolean paramBoolean, int paramInt3, long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, ArrayList<GameBadgeEntity> paramArrayList, SnapshotMetadataEntity paramSnapshotMetadataEntity)
  {
    this.xJ = paramInt1;
    this.Rq = paramGameEntity;
    this.Rr = paramInt2;
    this.Rs = paramBoolean;
    this.Rt = paramInt3;
    this.Ru = paramLong1;
    this.Rv = paramLong2;
    this.Rw = paramString1;
    this.Rx = paramLong3;
    this.Ry = paramString2;
    this.Rz = paramArrayList;
    this.RA = paramSnapshotMetadataEntity;
  }
  
  public ExtendedGameEntity(ExtendedGame paramExtendedGame)
  {
    this.xJ = 2;
    Object localObject1 = paramExtendedGame.getGame();
    if (localObject1 == null)
    {
      localObject1 = null;
      this.Rq = ((GameEntity)localObject1);
      this.Rr = paramExtendedGame.hM();
      this.Rs = paramExtendedGame.hN();
      this.Rt = paramExtendedGame.hO();
      this.Ru = paramExtendedGame.hP();
      this.Rv = paramExtendedGame.hQ();
      this.Rw = paramExtendedGame.hR();
      this.Rx = paramExtendedGame.hS();
      this.Ry = paramExtendedGame.hT();
      localObject1 = paramExtendedGame.hU();
      if (localObject1 != null) {
        break label213;
      }
    }
    label213:
    for (localObject1 = localObject2;; localObject1 = new SnapshotMetadataEntity((SnapshotMetadata)localObject1))
    {
      this.RA = ((SnapshotMetadataEntity)localObject1);
      paramExtendedGame = paramExtendedGame.hL();
      int j = paramExtendedGame.size();
      this.Rz = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        this.Rz.add((GameBadgeEntity)((GameBadge)paramExtendedGame.get(i)).freeze());
        i += 1;
      }
      localObject1 = new GameEntity((Game)localObject1);
      break;
    }
  }
  
  static int a(ExtendedGame paramExtendedGame)
  {
    return hl.hashCode(new Object[] { paramExtendedGame.getGame(), Integer.valueOf(paramExtendedGame.hM()), Boolean.valueOf(paramExtendedGame.hN()), Integer.valueOf(paramExtendedGame.hO()), Long.valueOf(paramExtendedGame.hP()), Long.valueOf(paramExtendedGame.hQ()), paramExtendedGame.hR(), Long.valueOf(paramExtendedGame.hS()), paramExtendedGame.hT() });
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
      if ((!hl.equal(((ExtendedGame)paramObject).getGame(), paramExtendedGame.getGame())) || (!hl.equal(Integer.valueOf(((ExtendedGame)paramObject).hM()), Integer.valueOf(paramExtendedGame.hM()))) || (!hl.equal(Boolean.valueOf(((ExtendedGame)paramObject).hN()), Boolean.valueOf(paramExtendedGame.hN()))) || (!hl.equal(Integer.valueOf(((ExtendedGame)paramObject).hO()), Integer.valueOf(paramExtendedGame.hO()))) || (!hl.equal(Long.valueOf(((ExtendedGame)paramObject).hP()), Long.valueOf(paramExtendedGame.hP()))) || (!hl.equal(Long.valueOf(((ExtendedGame)paramObject).hQ()), Long.valueOf(paramExtendedGame.hQ()))) || (!hl.equal(((ExtendedGame)paramObject).hR(), paramExtendedGame.hR())) || (!hl.equal(Long.valueOf(((ExtendedGame)paramObject).hS()), Long.valueOf(paramExtendedGame.hS())))) {
        break;
      }
      bool1 = bool2;
    } while (hl.equal(((ExtendedGame)paramObject).hT(), paramExtendedGame.hT()));
    return false;
  }
  
  static String b(ExtendedGame paramExtendedGame)
  {
    return hl.e(paramExtendedGame).a("Game", paramExtendedGame.getGame()).a("Availability", Integer.valueOf(paramExtendedGame.hM())).a("Owned", Boolean.valueOf(paramExtendedGame.hN())).a("AchievementUnlockedCount", Integer.valueOf(paramExtendedGame.hO())).a("LastPlayedServerTimestamp", Long.valueOf(paramExtendedGame.hP())).a("PriceMicros", Long.valueOf(paramExtendedGame.hQ())).a("FormattedPrice", paramExtendedGame.hR()).a("FullPriceMicros", Long.valueOf(paramExtendedGame.hS())).a("FormattedFullPrice", paramExtendedGame.hT()).a("Snapshot", paramExtendedGame.hU()).toString();
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
    return this.xJ;
  }
  
  public ArrayList<GameBadge> hL()
  {
    return new ArrayList(this.Rz);
  }
  
  public int hM()
  {
    return this.Rr;
  }
  
  public boolean hN()
  {
    return this.Rs;
  }
  
  public int hO()
  {
    return this.Rt;
  }
  
  public long hP()
  {
    return this.Ru;
  }
  
  public long hQ()
  {
    return this.Rv;
  }
  
  public String hR()
  {
    return this.Rw;
  }
  
  public long hS()
  {
    return this.Rx;
  }
  
  public String hT()
  {
    return this.Ry;
  }
  
  public SnapshotMetadata hU()
  {
    return this.RA;
  }
  
  public GameEntity hV()
  {
    return this.Rq;
  }
  
  public ExtendedGame hW()
  {
    return this;
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
    int j = 0;
    if (!fm())
    {
      ExtendedGameEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    this.Rq.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.Rr);
    if (this.Rs) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.Rt);
      paramParcel.writeLong(this.Ru);
      paramParcel.writeLong(this.Rv);
      paramParcel.writeString(this.Rw);
      paramParcel.writeLong(this.Rx);
      paramParcel.writeString(this.Ry);
      int k = this.Rz.size();
      paramParcel.writeInt(k);
      i = j;
      while (i < k)
      {
        ((GameBadgeEntity)this.Rz.get(i)).writeToParcel(paramParcel, paramInt);
        i += 1;
      }
      break;
    }
  }
  
  static final class ExtendedGameEntityCreatorCompat
    extends ExtendedGameEntityCreator
  {
    public ExtendedGameEntity bg(Parcel paramParcel)
    {
      if ((ExtendedGameEntity.b(ExtendedGameEntity.gM())) || (ExtendedGameEntity.aQ(ExtendedGameEntity.class.getCanonicalName()))) {
        return super.bg(paramParcel);
      }
      GameEntity localGameEntity = (GameEntity)GameEntity.CREATOR.createFromParcel(paramParcel);
      int j = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      int k;
      long l1;
      long l2;
      String str1;
      long l3;
      String str2;
      ArrayList localArrayList;
      for (boolean bool = true;; bool = false)
      {
        k = paramParcel.readInt();
        l1 = paramParcel.readLong();
        l2 = paramParcel.readLong();
        str1 = paramParcel.readString();
        l3 = paramParcel.readLong();
        str2 = paramParcel.readString();
        int m = paramParcel.readInt();
        localArrayList = new ArrayList(m);
        int i = 0;
        while (i < m)
        {
          localArrayList.add(GameBadgeEntity.CREATOR.bh(paramParcel));
          i += 1;
        }
      }
      return new ExtendedGameEntity(2, localGameEntity, j, bool, k, l1, l2, str1, l3, str2, localArrayList, null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/game/ExtendedGameEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */