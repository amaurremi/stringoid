package com.quoord.tools.gallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.widget.OverScroller;
import android.widget.Scroller;

public abstract class ScrollerProxy {
    public static ScrollerProxy getScroller(Context paramContext) {
        if (Build.VERSION.SDK_INT < 9) {
            return new PreGingerScroller(paramContext);
        }
        return new GingerScroller(paramContext);
    }

    public abstract boolean computeScrollOffset();

    public abstract void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);

    public abstract void forceFinished(boolean paramBoolean);

    public abstract int getCurrX();

    public abstract int getCurrY();

    @TargetApi(9)
    private static class GingerScroller
            extends ScrollerProxy {
        private OverScroller mScroller;

        public GingerScroller(Context paramContext) {
            this.mScroller = new OverScroller(paramContext);
        }

        public boolean computeScrollOffset() {
            return this.mScroller.computeScrollOffset();
        }

        public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10) {
            this.mScroller.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
        }

        public void forceFinished(boolean paramBoolean) {
            this.mScroller.forceFinished(paramBoolean);
        }

        public int getCurrX() {
            return this.mScroller.getCurrX();
        }

        public int getCurrY() {
            return this.mScroller.getCurrY();
        }
    }

    private static class PreGingerScroller
            extends ScrollerProxy {
        private Scroller mScroller;

        public PreGingerScroller(Context paramContext) {
            this.mScroller = new Scroller(paramContext);
        }

        public boolean computeScrollOffset() {
            return this.mScroller.computeScrollOffset();
        }

        public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10) {
            this.mScroller.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
        }

        public void forceFinished(boolean paramBoolean) {
            this.mScroller.forceFinished(paramBoolean);
        }

        public int getCurrX() {
            return this.mScroller.getCurrX();
        }

        public int getCurrY() {
            return this.mScroller.getCurrY();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/gallery/ScrollerProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */