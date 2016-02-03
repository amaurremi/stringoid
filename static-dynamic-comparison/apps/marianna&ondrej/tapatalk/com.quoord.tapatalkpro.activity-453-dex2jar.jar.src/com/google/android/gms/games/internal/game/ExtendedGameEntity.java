package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.a;

import java.util.ArrayList;

public final class ExtendedGameEntity
        extends GamesDowngradeableSafeParcel
        implements ExtendedGame {
    public static final ExtendedGameEntityCreator CREATOR = new ExtendedGameEntityCreatorCompat();
    private final long LA;
    private final String LB;
    private final ArrayList<GameBadgeEntity> LC;
    private final GameEntity Lt;
    private final int Lu;
    private final boolean Lv;
    private final int Lw;
    private final long Lx;
    private final long Ly;
    private final String Lz;
    private final int xH;

    ExtendedGameEntity(int paramInt1, GameEntity paramGameEntity, int paramInt2, boolean paramBoolean, int paramInt3, long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, ArrayList<GameBadgeEntity> paramArrayList) {
        this.xH = paramInt1;
        this.Lt = paramGameEntity;
        this.Lu = paramInt2;
        this.Lv = paramBoolean;
        this.Lw = paramInt3;
        this.Lx = paramLong1;
        this.Ly = paramLong2;
        this.Lz = paramString1;
        this.LA = paramLong3;
        this.LB = paramString2;
        this.LC = paramArrayList;
    }

    public ExtendedGameEntity(ExtendedGame paramExtendedGame) {
        this.xH = 1;
        Object localObject = paramExtendedGame.getGame();
        if (localObject == null) {
        }
        for (localObject = null; ; localObject = new GameEntity((Game) localObject)) {
            this.Lt = ((GameEntity) localObject);
            this.Lu = paramExtendedGame.gX();
            this.Lv = paramExtendedGame.gY();
            this.Lw = paramExtendedGame.gZ();
            this.Lx = paramExtendedGame.ha();
            this.Ly = paramExtendedGame.hb();
            this.Lz = paramExtendedGame.hc();
            this.LA = paramExtendedGame.hd();
            this.LB = paramExtendedGame.he();
            paramExtendedGame = paramExtendedGame.gW();
            int j = paramExtendedGame.size();
            this.LC = new ArrayList(j);
            int i = 0;
            while (i < j) {
                this.LC.add((GameBadgeEntity) ((GameBadge) paramExtendedGame.get(i)).freeze());
                i += 1;
            }
        }
    }

    static int a(ExtendedGame paramExtendedGame) {
        return fo.hashCode(new Object[]{paramExtendedGame.getGame(), Integer.valueOf(paramExtendedGame.gX()), Boolean.valueOf(paramExtendedGame.gY()), Integer.valueOf(paramExtendedGame.gZ()), Long.valueOf(paramExtendedGame.ha()), Long.valueOf(paramExtendedGame.hb()), paramExtendedGame.hc(), Long.valueOf(paramExtendedGame.hd()), paramExtendedGame.he()});
    }

    static boolean a(ExtendedGame paramExtendedGame, Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof ExtendedGame)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramExtendedGame == paramObject);
            paramObject = (ExtendedGame) paramObject;
            if ((!fo.equal(((ExtendedGame) paramObject).getGame(), paramExtendedGame.getGame())) || (!fo.equal(Integer.valueOf(((ExtendedGame) paramObject).gX()), Integer.valueOf(paramExtendedGame.gX()))) || (!fo.equal(Boolean.valueOf(((ExtendedGame) paramObject).gY()), Boolean.valueOf(paramExtendedGame.gY()))) || (!fo.equal(Integer.valueOf(((ExtendedGame) paramObject).gZ()), Integer.valueOf(paramExtendedGame.gZ()))) || (!fo.equal(Long.valueOf(((ExtendedGame) paramObject).ha()), Long.valueOf(paramExtendedGame.ha()))) || (!fo.equal(Long.valueOf(((ExtendedGame) paramObject).hb()), Long.valueOf(paramExtendedGame.hb()))) || (!fo.equal(((ExtendedGame) paramObject).hc(), paramExtendedGame.hc())) || (!fo.equal(Long.valueOf(((ExtendedGame) paramObject).hd()), Long.valueOf(paramExtendedGame.hd())))) {
                break;
            }
            bool1 = bool2;
        } while (fo.equal(((ExtendedGame) paramObject).he(), paramExtendedGame.he()));
        return false;
    }

    static String b(ExtendedGame paramExtendedGame) {
        return fo.e(paramExtendedGame).a("Game", paramExtendedGame.getGame()).a("Availability", Integer.valueOf(paramExtendedGame.gX())).a("Owned", Boolean.valueOf(paramExtendedGame.gY())).a("AchievementUnlockedCount", Integer.valueOf(paramExtendedGame.gZ())).a("LastPlayedServerTimestamp", Long.valueOf(paramExtendedGame.ha())).a("PriceMicros", Long.valueOf(paramExtendedGame.hb())).a("FormattedPrice", paramExtendedGame.hc()).a("FullPriceMicros", Long.valueOf(paramExtendedGame.hd())).a("FormattedFullPrice", paramExtendedGame.he()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public ArrayList<GameBadge> gW() {
        return new ArrayList(this.LC);
    }

    public int gX() {
        return this.Lu;
    }

    public boolean gY() {
        return this.Lv;
    }

    public int gZ() {
        return this.Lw;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public long ha() {
        return this.Lx;
    }

    public int hashCode() {
        return a(this);
    }

    public long hb() {
        return this.Ly;
    }

    public String hc() {
        return this.Lz;
    }

    public long hd() {
        return this.LA;
    }

    public String he() {
        return this.LB;
    }

    public GameEntity hf() {
        return this.Lt;
    }

    public ExtendedGame hg() {
        return this;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        int j = 0;
        if (!eK()) {
            ExtendedGameEntityCreator.a(this, paramParcel, paramInt);
            return;
        }
        this.Lt.writeToParcel(paramParcel, paramInt);
        paramParcel.writeInt(this.Lu);
        if (this.Lv) {
        }
        for (int i = 1; ; i = 0) {
            paramParcel.writeInt(i);
            paramParcel.writeInt(this.Lw);
            paramParcel.writeLong(this.Lx);
            paramParcel.writeLong(this.Ly);
            paramParcel.writeString(this.Lz);
            paramParcel.writeLong(this.LA);
            paramParcel.writeString(this.LB);
            int k = this.LC.size();
            paramParcel.writeInt(k);
            i = j;
            while (i < k) {
                ((GameBadgeEntity) this.LC.get(i)).writeToParcel(paramParcel, paramInt);
                i += 1;
            }
            break;
        }
    }

    static final class ExtendedGameEntityCreatorCompat
            extends ExtendedGameEntityCreator {
        public ExtendedGameEntity aq(Parcel paramParcel) {
            if ((ExtendedGameEntity.b(ExtendedGameEntity.gg())) || (ExtendedGameEntity.az(ExtendedGameEntity.class.getCanonicalName()))) {
                return super.aq(paramParcel);
            }
            GameEntity localGameEntity = (GameEntity) GameEntity.CREATOR.createFromParcel(paramParcel);
            int j = paramParcel.readInt();
            if (paramParcel.readInt() == 1) {
            }
            int k;
            long l1;
            long l2;
            String str1;
            long l3;
            String str2;
            ArrayList localArrayList;
            for (boolean bool = true; ; bool = false) {
                k = paramParcel.readInt();
                l1 = paramParcel.readLong();
                l2 = paramParcel.readLong();
                str1 = paramParcel.readString();
                l3 = paramParcel.readLong();
                str2 = paramParcel.readString();
                int m = paramParcel.readInt();
                localArrayList = new ArrayList(m);
                int i = 0;
                while (i < m) {
                    localArrayList.add(GameBadgeEntity.CREATOR.ar(paramParcel));
                    i += 1;
                }
            }
            return new ExtendedGameEntity(1, localGameEntity, j, bool, k, l1, l2, str1, l3, str2, localArrayList);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/internal/game/ExtendedGameEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */