package com.bumptech.glide;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.bumptech.glide.presenter.target.SimpleTarget;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class ListPreloader<T>
        implements AbsListView.OnScrollListener {
    private final Context context;
    private boolean isIncreasing = true;
    private int lastEnd;
    private int lastFirstVisible;
    private int lastStart;
    private final int maxPreload;
    private final PreloadTargetQueue preloadTargetQueue;
    private int totalItemCount;

    public ListPreloader(Context paramContext, int paramInt) {
        this.context = paramContext;
        this.maxPreload = paramInt;
        this.preloadTargetQueue = new PreloadTargetQueue(paramInt, null);
    }

    private void cancelAll() {
        int i = 0;
        for (; ; ) {
            if (i >= this.maxPreload) {
                return;
            }
            Glide.cancel(this.preloadTargetQueue.next(0, 0));
            i += 1;
        }
    }

    private void preload(int paramInt1, int paramInt2) {
        int i;
        int j;
        List localList;
        if (paramInt1 < paramInt2) {
            i = Math.max(this.lastEnd, paramInt1);
            j = paramInt2;
            j = Math.min(this.totalItemCount, j);
            i = Math.min(this.totalItemCount, Math.max(0, i));
            localList = getItems(i, j);
            if (paramInt1 >= paramInt2) {
                break label111;
            }
            paramInt2 = localList.size();
            paramInt1 = 0;
            label65:
            if (paramInt1 < paramInt2) {
                break label97;
            }
        }
        for (; ; ) {
            this.lastStart = i;
            this.lastEnd = j;
            return;
            i = paramInt2;
            j = Math.min(this.lastStart, paramInt1);
            break;
            label97:
            preloadItem(localList, paramInt1);
            paramInt1 += 1;
            break label65;
            label111:
            paramInt1 = localList.size() - 1;
            while (paramInt1 >= 0) {
                preloadItem(localList, paramInt1);
                paramInt1 -= 1;
            }
        }
    }

    private void preload(int paramInt, boolean paramBoolean) {
        if (this.isIncreasing != paramBoolean) {
            this.isIncreasing = paramBoolean;
            cancelAll();
        }
        if (paramBoolean) {
        }
        for (int i = this.maxPreload; ; i = -this.maxPreload) {
            preload(paramInt, i + paramInt);
            return;
        }
    }

    private void preloadItem(List<T> paramList, int paramInt) {
        paramList = paramList.get(paramInt);
        int[] arrayOfInt = getDimensions(paramList);
        if (arrayOfInt != null) {
            getRequest(paramList).into(this.preloadTargetQueue.next(arrayOfInt[0], arrayOfInt[1])).with(this.context);
        }
    }

    protected abstract int[] getDimensions(T paramT);

    protected abstract List<T> getItems(int paramInt1, int paramInt2);

    protected abstract Glide.Request<T> getRequest(T paramT);

    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
        this.totalItemCount = paramInt3;
        if (paramInt1 > this.lastFirstVisible) {
            preload(paramInt1 + paramInt2, true);
        }
        for (; ; ) {
            this.lastFirstVisible = paramInt1;
            return;
            if (paramInt1 < this.lastFirstVisible) {
                preload(paramInt1, false);
            }
        }
    }

    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    }

    private static class PreloadTarget
            extends SimpleTarget {
        private int photoHeight;
        private int photoWidth;

        protected int[] getSize() {
            return new int[]{this.photoWidth, this.photoHeight};
        }

        public void onImageReady(Bitmap paramBitmap) {
        }
    }

    private static class PreloadTargetQueue {
        private final Queue<ListPreloader.PreloadTarget> queue;

        @TargetApi(9)
        private PreloadTargetQueue(int paramInt) {
            int i;
            if (Build.VERSION.SDK_INT >= 9) {
                this.queue = new ArrayDeque(paramInt);
                i = 0;
            }
            for (; ; ) {
                if (i >= paramInt) {
                    return;
                    this.queue = new LinkedList();
                    break;
                }
                this.queue.offer(new ListPreloader.PreloadTarget(null));
                i += 1;
            }
        }

        public ListPreloader.PreloadTarget next(int paramInt1, int paramInt2) {
            ListPreloader.PreloadTarget localPreloadTarget = (ListPreloader.PreloadTarget) this.queue.poll();
            this.queue.offer(localPreloadTarget);
            localPreloadTarget.photoWidth = paramInt1;
            localPreloadTarget.photoHeight = paramInt2;
            return localPreloadTarget;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/ListPreloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */