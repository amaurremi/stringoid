package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.internal.fq;

import java.util.ArrayList;
import java.util.Arrays;

public final class RoomConfig {
    private final String IV;
    private final RoomUpdateListener MK;
    private final RoomStatusUpdateListener ML;
    private final RealTimeMessageReceivedListener MM;
    private final String[] MN;
    private final Bundle MO;
    private final boolean MP;
    private final int My;

    private RoomConfig(Builder paramBuilder) {
        this.MK = paramBuilder.MK;
        this.ML = paramBuilder.ML;
        this.MM = paramBuilder.MM;
        this.IV = paramBuilder.MQ;
        this.My = paramBuilder.My;
        this.MO = paramBuilder.MO;
        this.MP = paramBuilder.MP;
        int i = paramBuilder.MR.size();
        this.MN = ((String[]) paramBuilder.MR.toArray(new String[i]));
        if (this.MM == null) {
            fq.a(this.MP, "Must either enable sockets OR specify a message listener");
        }
    }

    public static Builder builder(RoomUpdateListener paramRoomUpdateListener) {
        return new Builder(paramRoomUpdateListener, null);
    }

    public static Bundle createAutoMatchCriteria(int paramInt1, int paramInt2, long paramLong) {
        Bundle localBundle = new Bundle();
        localBundle.putInt("min_automatch_players", paramInt1);
        localBundle.putInt("max_automatch_players", paramInt2);
        localBundle.putLong("exclusive_bit_mask", paramLong);
        return localBundle;
    }

    public Bundle getAutoMatchCriteria() {
        return this.MO;
    }

    public String getInvitationId() {
        return this.IV;
    }

    public String[] getInvitedPlayerIds() {
        return this.MN;
    }

    public RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.MM;
    }

    public RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.ML;
    }

    public RoomUpdateListener getRoomUpdateListener() {
        return this.MK;
    }

    public int getVariant() {
        return this.My;
    }

    public boolean isSocketEnabled() {
        return this.MP;
    }

    public static final class Builder {
        final RoomUpdateListener MK;
        RoomStatusUpdateListener ML;
        RealTimeMessageReceivedListener MM;
        Bundle MO;
        boolean MP = false;
        String MQ = null;
        ArrayList<String> MR = new ArrayList();
        int My = -1;

        private Builder(RoomUpdateListener paramRoomUpdateListener) {
            this.MK = ((RoomUpdateListener) fq.b(paramRoomUpdateListener, "Must provide a RoomUpdateListener"));
        }

        public Builder addPlayersToInvite(ArrayList<String> paramArrayList) {
            fq.f(paramArrayList);
            this.MR.addAll(paramArrayList);
            return this;
        }

        public Builder addPlayersToInvite(String... paramVarArgs) {
            fq.f(paramVarArgs);
            this.MR.addAll(Arrays.asList(paramVarArgs));
            return this;
        }

        public RoomConfig build() {
            return new RoomConfig(this, null);
        }

        public Builder setAutoMatchCriteria(Bundle paramBundle) {
            this.MO = paramBundle;
            return this;
        }

        public Builder setInvitationIdToAccept(String paramString) {
            fq.f(paramString);
            this.MQ = paramString;
            return this;
        }

        public Builder setMessageReceivedListener(RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener) {
            this.MM = paramRealTimeMessageReceivedListener;
            return this;
        }

        public Builder setRoomStatusUpdateListener(RoomStatusUpdateListener paramRoomStatusUpdateListener) {
            this.ML = paramRoomStatusUpdateListener;
            return this;
        }

        public Builder setSocketCommunicationEnabled(boolean paramBoolean) {
            this.MP = paramBoolean;
            return this;
        }

        public Builder setVariant(int paramInt) {
            if ((paramInt == -1) || (paramInt > 0)) {
            }
            for (boolean bool = true; ; bool = false) {
                fq.b(bool, "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
                this.My = paramInt;
                return this;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RoomConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */