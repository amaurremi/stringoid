package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.a;
import com.google.android.gms.internal.gm;

import java.util.ArrayList;

public final class LeaderboardEntity
        implements Leaderboard {
    private final String HA;
    private final Uri HF;
    private final String HQ;
    private final String LP;
    private final int LQ;
    private final ArrayList<LeaderboardVariantEntity> LR;
    private final Game LS;

    public LeaderboardEntity(Leaderboard paramLeaderboard) {
        this.LP = paramLeaderboard.getLeaderboardId();
        this.HA = paramLeaderboard.getDisplayName();
        this.HF = paramLeaderboard.getIconImageUri();
        this.HQ = paramLeaderboard.getIconImageUrl();
        this.LQ = paramLeaderboard.getScoreOrder();
        Object localObject = paramLeaderboard.getGame();
        if (localObject == null) {
        }
        for (localObject = null; ; localObject = new GameEntity((Game) localObject)) {
            this.LS = ((Game) localObject);
            paramLeaderboard = paramLeaderboard.getVariants();
            int j = paramLeaderboard.size();
            this.LR = new ArrayList(j);
            int i = 0;
            while (i < j) {
                this.LR.add((LeaderboardVariantEntity) ((LeaderboardVariant) paramLeaderboard.get(i)).freeze());
                i += 1;
            }
        }
    }

    static int a(Leaderboard paramLeaderboard) {
        return fo.hashCode(new Object[]{paramLeaderboard.getLeaderboardId(), paramLeaderboard.getDisplayName(), paramLeaderboard.getIconImageUri(), Integer.valueOf(paramLeaderboard.getScoreOrder()), paramLeaderboard.getVariants()});
    }

    static boolean a(Leaderboard paramLeaderboard, Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof Leaderboard)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramLeaderboard == paramObject);
            paramObject = (Leaderboard) paramObject;
            if ((!fo.equal(((Leaderboard) paramObject).getLeaderboardId(), paramLeaderboard.getLeaderboardId())) || (!fo.equal(((Leaderboard) paramObject).getDisplayName(), paramLeaderboard.getDisplayName())) || (!fo.equal(((Leaderboard) paramObject).getIconImageUri(), paramLeaderboard.getIconImageUri())) || (!fo.equal(Integer.valueOf(((Leaderboard) paramObject).getScoreOrder()), Integer.valueOf(paramLeaderboard.getScoreOrder())))) {
                break;
            }
            bool1 = bool2;
        } while (fo.equal(((Leaderboard) paramObject).getVariants(), paramLeaderboard.getVariants()));
        return false;
    }

    static String b(Leaderboard paramLeaderboard) {
        return fo.e(paramLeaderboard).a("LeaderboardId", paramLeaderboard.getLeaderboardId()).a("DisplayName", paramLeaderboard.getDisplayName()).a("IconImageUri", paramLeaderboard.getIconImageUri()).a("IconImageUrl", paramLeaderboard.getIconImageUrl()).a("ScoreOrder", Integer.valueOf(paramLeaderboard.getScoreOrder())).a("Variants", paramLeaderboard.getVariants()).toString();
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public String getDisplayName() {
        return this.HA;
    }

    public void getDisplayName(CharArrayBuffer paramCharArrayBuffer) {
        gm.b(this.HA, paramCharArrayBuffer);
    }

    public Game getGame() {
        return this.LS;
    }

    public Uri getIconImageUri() {
        return this.HF;
    }

    public String getIconImageUrl() {
        return this.HQ;
    }

    public String getLeaderboardId() {
        return this.LP;
    }

    public int getScoreOrder() {
        return this.LQ;
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList(this.LR);
    }

    public Leaderboard hC() {
        return this;
    }

    public int hashCode() {
        return a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return b(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */