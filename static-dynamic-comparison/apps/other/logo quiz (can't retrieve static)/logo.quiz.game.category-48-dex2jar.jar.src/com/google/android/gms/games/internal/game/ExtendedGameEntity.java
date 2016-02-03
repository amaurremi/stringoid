package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import java.util.ArrayList;

public final class ExtendedGameEntity
  extends GamesDowngradeableSafeParcel
  implements ExtendedGame
{
  public static final ExtendedGameEntityCreator CREATOR = new ExtendedGameEntityCreatorCompat();
  private final int BR;
  private final GameEntity aan;
  private final int aao;
  private final boolean aap;
  private final int aaq;
  private final long aar;
  private final long aas;
  private final String aat;
  private final long aau;
  private final String aav;
  private final ArrayList<GameBadgeEntity> aaw;
  private final SnapshotMetadataEntity aax;
  
  ExtendedGameEntity(int paramInt1, GameEntity paramGameEntity, int paramInt2, boolean paramBoolean, int paramInt3, long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, ArrayList<GameBadgeEntity> paramArrayList, SnapshotMetadataEntity paramSnapshotMetadataEntity)
  {
    this.BR = paramInt1;
    this.aan = paramGameEntity;
    this.aao = paramInt2;
    this.aap = paramBoolean;
    this.aaq = paramInt3;
    this.aar = paramLong1;
    this.aas = paramLong2;
    this.aat = paramString1;
    this.aau = paramLong3;
    this.aav = paramString2;
    this.aaw = paramArrayList;
    this.aax = paramSnapshotMetadataEntity;
  }
  
  public ExtendedGameEntity(ExtendedGame paramExtendedGame)
  {
    this.BR = 2;
    Object localObject1 = paramExtendedGame.getGame();
    if (localObject1 == null)
    {
      localObject1 = null;
      this.aan = ((GameEntity)localObject1);
      this.aao = paramExtendedGame.kP();
      this.aap = paramExtendedGame.kQ();
      this.aaq = paramExtendedGame.kR();
      this.aar = paramExtendedGame.kS();
      this.aas = paramExtendedGame.kT();
      this.aat = paramExtendedGame.kU();
      this.aau = paramExtendedGame.kV();
      this.aav = paramExtendedGame.kW();
      localObject1 = paramExtendedGame.kX();
      if (localObject1 != null) {
        break label213;
      }
    }
    label213:
    for (localObject1 = localObject2;; localObject1 = new SnapshotMetadataEntity((SnapshotMetadata)localObject1))
    {
      this.aax = ((SnapshotMetadataEntity)localObject1);
      paramExtendedGame = paramExtendedGame.kO();
      int j = paramExtendedGame.size();
      this.aaw = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        this.aaw.add((GameBadgeEntity)((GameBadge)paramExtendedGame.get(i)).freeze());
        i += 1;
      }
      localObject1 = new GameEntity((Game)localObject1);
      break;
    }
  }
  
  static int a(ExtendedGame paramExtendedGame)
  {
    return m.hashCode(new Object[] { paramExtendedGame.getGame(), Integer.valueOf(paramExtendedGame.kP()), Boolean.valueOf(paramExtendedGame.kQ()), Integer.valueOf(paramExtendedGame.kR()), Long.valueOf(paramExtendedGame.kS()), Long.valueOf(paramExtendedGame.kT()), paramExtendedGame.kU(), Long.valueOf(paramExtendedGame.kV()), paramExtendedGame.kW() });
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
      if ((!m.equal(((ExtendedGame)paramObject).getGame(), paramExtendedGame.getGame())) || (!m.equal(Integer.valueOf(((ExtendedGame)paramObject).kP()), Integer.valueOf(paramExtendedGame.kP()))) || (!m.equal(Boolean.valueOf(((ExtendedGame)paramObject).kQ()), Boolean.valueOf(paramExtendedGame.kQ()))) || (!m.equal(Integer.valueOf(((ExtendedGame)paramObject).kR()), Integer.valueOf(paramExtendedGame.kR()))) || (!m.equal(Long.valueOf(((ExtendedGame)paramObject).kS()), Long.valueOf(paramExtendedGame.kS()))) || (!m.equal(Long.valueOf(((ExtendedGame)paramObject).kT()), Long.valueOf(paramExtendedGame.kT()))) || (!m.equal(((ExtendedGame)paramObject).kU(), paramExtendedGame.kU())) || (!m.equal(Long.valueOf(((ExtendedGame)paramObject).kV()), Long.valueOf(paramExtendedGame.kV())))) {
        break;
      }
      bool1 = bool2;
    } while (m.equal(((ExtendedGame)paramObject).kW(), paramExtendedGame.kW()));
    return false;
  }
  
  static String b(ExtendedGame paramExtendedGame)
  {
    return m.h(paramExtendedGame).a("Game", paramExtendedGame.getGame()).a("Availability", Integer.valueOf(paramExtendedGame.kP())).a("Owned", Boolean.valueOf(paramExtendedGame.kQ())).a("AchievementUnlockedCount", Integer.valueOf(paramExtendedGame.kR())).a("LastPlayedServerTimestamp", Long.valueOf(paramExtendedGame.kS())).a("PriceMicros", Long.valueOf(paramExtendedGame.kT())).a("FormattedPrice", paramExtendedGame.kU()).a("FullPriceMicros", Long.valueOf(paramExtendedGame.kV())).a("FormattedFullPrice", paramExtendedGame.kW()).a("Snapshot", paramExtendedGame.kX()).toString();
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
  
  public ArrayList<GameBadge> kO()
  {
    return new ArrayList(this.aaw);
  }
  
  public int kP()
  {
    return this.aao;
  }
  
  public boolean kQ()
  {
    return this.aap;
  }
  
  public int kR()
  {
    return this.aaq;
  }
  
  public long kS()
  {
    return this.aar;
  }
  
  public long kT()
  {
    return this.aas;
  }
  
  public String kU()
  {
    return this.aat;
  }
  
  public long kV()
  {
    return this.aau;
  }
  
  public String kW()
  {
    return this.aav;
  }
  
  public SnapshotMetadata kX()
  {
    return this.aax;
  }
  
  public GameEntity kY()
  {
    return this.aan;
  }
  
  public ExtendedGame kZ()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 0;
    if (!gQ())
    {
      ExtendedGameEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    this.aan.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.aao);
    if (this.aap) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.aaq);
      paramParcel.writeLong(this.aar);
      paramParcel.writeLong(this.aas);
      paramParcel.writeString(this.aat);
      paramParcel.writeLong(this.aau);
      paramParcel.writeString(this.aav);
      int k = this.aaw.size();
      paramParcel.writeInt(k);
      i = j;
      while (i < k)
      {
        ((GameBadgeEntity)this.aaw.get(i)).writeToParcel(paramParcel, paramInt);
        i += 1;
      }
      break;
    }
  }
  
  static final class ExtendedGameEntityCreatorCompat
    extends ExtendedGameEntityCreator
  {
    public ExtendedGameEntity cg(Parcel paramParcel)
    {
      if ((ExtendedGameEntity.b(ExtendedGameEntity.jQ())) || (ExtendedGameEntity.bt(ExtendedGameEntity.class.getCanonicalName()))) {
        return super.cg(paramParcel);
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
          localArrayList.add(GameBadgeEntity.CREATOR.ch(paramParcel));
          i += 1;
        }
      }
      return new ExtendedGameEntity(2, localGameEntity, j, bool, k, l1, l2, str1, l3, str2, localArrayList, null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/game/ExtendedGameEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */