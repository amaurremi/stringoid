package com.bumptech.glide.resize.bitmap_recycle;

import android.graphics.Bitmap;

import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;

public class SerialBitmapReferenceCounter
        implements BitmapReferenceCounter {
    private final Map<Bitmap, InnerTracker> counter = new WeakHashMap();
    private final InnerTrackerPool pool = new InnerTrackerPool(null);
    private final BitmapPool target;

    public SerialBitmapReferenceCounter(BitmapPool paramBitmapPool) {
        this.target = paramBitmapPool;
    }

    private void initBitmap(Bitmap paramBitmap) {
        if ((InnerTracker) this.counter.get(paramBitmap) == null) {
            this.counter.put(paramBitmap, this.pool.get());
        }
    }

    private void recycle(InnerTracker paramInnerTracker, Bitmap paramBitmap) {
        if (!this.target.put(paramBitmap)) {
            paramBitmap.recycle();
        }
        this.counter.remove(paramBitmap);
        this.pool.release(paramInnerTracker);
    }

    public void acquireBitmap(Bitmap paramBitmap) {
        initBitmap(paramBitmap);
        ((InnerTracker) this.counter.get(paramBitmap)).acquire();
    }

    public void releaseBitmap(Bitmap paramBitmap) {
        InnerTracker localInnerTracker = (InnerTracker) this.counter.get(paramBitmap);
        if (localInnerTracker.release()) {
            recycle(localInnerTracker, paramBitmap);
        }
    }

    private static class InnerTracker {
        private int refs = 0;

        public void acquire() {
            this.refs += 1;
        }

        public boolean release() {
            this.refs -= 1;
            return this.refs == 0;
        }
    }

    private static class InnerTrackerPool {
        private LinkedList<SerialBitmapReferenceCounter.InnerTracker> pool = new LinkedList();

        public SerialBitmapReferenceCounter.InnerTracker get() {
            SerialBitmapReferenceCounter.InnerTracker localInnerTracker2 = (SerialBitmapReferenceCounter.InnerTracker) this.pool.poll();
            SerialBitmapReferenceCounter.InnerTracker localInnerTracker1 = localInnerTracker2;
            if (localInnerTracker2 == null) {
                localInnerTracker1 = new SerialBitmapReferenceCounter.InnerTracker(null);
            }
            return localInnerTracker1;
        }

        public void release(SerialBitmapReferenceCounter.InnerTracker paramInnerTracker) {
            this.pool.offer(paramInnerTracker);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/resize/bitmap_recycle/SerialBitmapReferenceCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */