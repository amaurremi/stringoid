package com.google.android.gms.common.data;

import com.google.android.gms.internal.fq;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class a<T>
        implements Iterator<T> {
    private int BC;
    private final DataBuffer<T> mDataBuffer;

    public a(DataBuffer<T> paramDataBuffer) {
        this.mDataBuffer = ((DataBuffer) fq.f(paramDataBuffer));
        this.BC = -1;
    }

    public boolean hasNext() {
        return this.BC < this.mDataBuffer.getCount() - 1;
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.BC);
        }
        DataBuffer localDataBuffer = this.mDataBuffer;
        int i = this.BC + 1;
        this.BC = i;
        return (T) localDataBuffer.get(i);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/common/data/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */