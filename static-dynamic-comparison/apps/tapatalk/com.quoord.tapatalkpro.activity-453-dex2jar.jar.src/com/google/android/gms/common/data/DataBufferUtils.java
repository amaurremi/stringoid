package com.google.android.gms.common.data;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Iterator;

public final class DataBufferUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> paramDataBuffer) {
        ArrayList localArrayList = new ArrayList(paramDataBuffer.getCount());
        try {
            Iterator localIterator = paramDataBuffer.iterator();
            while (localIterator.hasNext()) {
                localArrayList.add(((Freezable) localIterator.next()).freeze());
            }
        } finally {
            paramDataBuffer.close();
        }
        return localArrayList1;
    }

    public static boolean hasNextPage(DataBuffer<?> paramDataBuffer) {
        paramDataBuffer = paramDataBuffer.getMetadata();
        return (paramDataBuffer != null) && (paramDataBuffer.getString("next_page_token") != null);
    }

    public static boolean hasPrevPage(DataBuffer<?> paramDataBuffer) {
        paramDataBuffer = paramDataBuffer.getMetadata();
        return (paramDataBuffer != null) && (paramDataBuffer.getString("prev_page_token") != null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/common/data/DataBufferUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */