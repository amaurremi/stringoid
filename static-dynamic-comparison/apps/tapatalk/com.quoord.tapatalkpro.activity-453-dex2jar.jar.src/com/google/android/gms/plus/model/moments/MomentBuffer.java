package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.ig;

public final class MomentBuffer
        extends DataBuffer<Moment> {
    public MomentBuffer(DataHolder paramDataHolder) {
        super(paramDataHolder);
    }

    public Moment get(int paramInt) {
        return new ig(this.BB, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/plus/model/moments/MomentBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */