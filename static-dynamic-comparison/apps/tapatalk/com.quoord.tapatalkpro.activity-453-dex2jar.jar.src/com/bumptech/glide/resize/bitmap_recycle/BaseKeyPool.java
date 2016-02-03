package com.bumptech.glide.resize.bitmap_recycle;

import android.os.Build.VERSION;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

abstract class BaseKeyPool<T extends Poolable> {
    private static final int MAX_SIZE = 20;
    private final Queue<T> keyPool;

    public BaseKeyPool() {
        if (Build.VERSION.SDK_INT >= 9) {
            this.keyPool = new ArrayDeque(20);
            return;
        }
        this.keyPool = new LinkedList();
    }

    protected abstract T create();

    protected T get() {
        Poolable localPoolable2 = (Poolable) this.keyPool.poll();
        Poolable localPoolable1 = localPoolable2;
        if (localPoolable2 == null) {
            localPoolable1 = create();
        }
        return localPoolable1;
    }

    public void offer(T paramT) {
        if (this.keyPool.size() < 20) {
            this.keyPool.offer(paramT);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/resize/bitmap_recycle/BaseKeyPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */