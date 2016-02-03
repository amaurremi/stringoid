package com.everimaging.fotorsdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.widget.lib.hlist.HListView;

public class FotorDragHListView
        extends HListView {
    private static final String ay = FotorDragHListView.class.getSimpleName();
    private static final FotorLoggerFactory.c az = FotorLoggerFactory.a(ay, FotorLoggerFactory.LoggerType.CONSOLE);
    private boolean aA;
    private int aB;
    private int aC;
    private int aD;
    private ImageView aE;
    private c aF;
    private d aG;
    private b aH;
    private a aI;
    private int aJ;
    private int aK;
    private int aL;
    private Handler aM = new Handler() {
        public void handleMessage(Message paramAnonymousMessage) {
            switch (paramAnonymousMessage.what) {
                default:
                case 1:
                    do {
                        return;
                        FotorDragHListView.a().c(new Object[]{"mDrag mode true"});
                        FotorDragHListView.a(FotorDragHListView.this, true);
                        FotorDragHListView.a(FotorDragHListView.this, FotorDragHListView.this.a(FotorDragHListView.a(FotorDragHListView.this), FotorDragHListView.b(FotorDragHListView.this)));
                    } while (FotorDragHListView.c(FotorDragHListView.this) == -1);
                    int i = FotorDragHListView.c(FotorDragHListView.this) - FotorDragHListView.this.getFirstVisiblePosition();
                    FotorDragHListView.b(FotorDragHListView.this, FotorDragHListView.a(FotorDragHListView.this) - FotorDragHListView.this.getChildAt(i).getLeft());
                    FotorDragHListView.c(FotorDragHListView.this, FotorDragHListView.d(FotorDragHListView.this) - FotorDragHListView.a(FotorDragHListView.this));
                    FotorDragHListView.a(FotorDragHListView.this, i, FotorDragHListView.a(FotorDragHListView.this));
                    FotorDragHListView.b(FotorDragHListView.this, FotorDragHListView.a(FotorDragHListView.this), 0);
                    return;
            }
            FotorDragHListView.a().c(new Object[]{"mDrag mode false"});
            FotorDragHListView.a(FotorDragHListView.this, false);
        }
    };

    public FotorDragHListView(Context paramContext) {
        super(paramContext);
    }

    public FotorDragHListView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public FotorDragHListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    private void a(long paramLong) {
        this.aA = false;
        if (this.aI == null) {
            this.aI = new a(null);
        }
        this.aM.postDelayed(this.aI, 600L - paramLong);
    }

    private void f(int paramInt1, int paramInt2) {
        if (this.aE != null) {
            WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams) this.aE.getLayoutParams();
            localLayoutParams.x = (paramInt1 - this.aD);
            localLayoutParams.y = paramInt2;
            ((WindowManager) getContext().getSystemService("window")).updateViewLayout(this.aE, localLayoutParams);
            if (this.aH != null) {
                this.aH.a(paramInt1, paramInt2, this);
            }
        }
    }

    private void g(int paramInt1, int paramInt2) {
        k(paramInt1);
        Object localObject = getChildAt(paramInt1);
        if (localObject == null) {
            return;
        }
        if (this.aH != null) {
            this.aH.a((View) localObject);
        }
        localObject = BitmapUtils.createBitmap((View) localObject);
        WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
        localLayoutParams.gravity = 83;
        localLayoutParams.x = (paramInt2 - this.aD);
        localLayoutParams.y = 0;
        localLayoutParams.height = -2;
        localLayoutParams.width = -2;
        localLayoutParams.flags = 920;
        localLayoutParams.format = -2;
        localLayoutParams.windowAnimations = 0;
        Context localContext = getContext();
        ImageView localImageView = new ImageView(localContext);
        localImageView.setImageBitmap((Bitmap) localObject);
        ((WindowManager) localContext.getSystemService("window")).addView(localImageView, localLayoutParams);
        this.aE = localImageView;
    }

    private void k(int paramInt) {
        if (this.aE != null) {
            if (this.aH != null) {
                this.aH.b(getChildAt(paramInt));
            }
            this.aE.setVisibility(8);
            ((WindowManager) getContext().getSystemService("window")).removeView(this.aE);
            this.aE.setImageDrawable(null);
            this.aE = null;
        }
    }

    private void z() {
        if (this.aI != null) {
            this.aM.removeCallbacks(this.aI);
        }
        if (this.aA) {
            this.aM.sendEmptyMessage(2);
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        int i = paramMotionEvent.getAction();
        int j = (int) paramMotionEvent.getX();
        int k = (int) paramMotionEvent.getY();
        switch (i) {
        }
        while (!this.aA) {
            return super.onTouchEvent(paramMotionEvent);
            this.aJ = j;
            this.aK = k;
            this.aL = ((int) paramMotionEvent.getRawX());
            a(0L);
            continue;
            if ((!this.aA) && (FloatMath.sqrt((j - this.aJ) * (j - this.aJ) + (k - this.aK) * (k - this.aK)) >= 10.0F)) {
                z();
                continue;
                z();
            }
        }
        switch (i) {
            default:
                this.aA = false;
                this.aC = a(j, k);
                k(this.aB - getFirstVisiblePosition());
                if ((this.aF != null) && (this.aB != -1) && (this.aC != -1)) {
                    this.aF.a(this.aB, this.aC);
                }
                break;
        }
        for (; ; ) {
            return true;
            f(j, 0);
        }
    }

    public void setDragListener(b paramb) {
        this.aH = paramb;
    }

    public void setDropListener(c paramc) {
        this.aF = paramc;
    }

    public void setRemoveListener(d paramd) {
        this.aG = paramd;
    }

    private class a
            implements Runnable {
        private a() {
        }

        public void run() {
            FotorDragHListView.e(FotorDragHListView.this).sendEmptyMessage(1);
        }
    }

    public static abstract interface b {
        public abstract void a(int paramInt1, int paramInt2, HListView paramHListView);

        public abstract void a(View paramView);

        public abstract void b(View paramView);
    }

    public static abstract interface c {
        public abstract void a(int paramInt1, int paramInt2);
    }

    public static abstract interface d {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/FotorDragHListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */