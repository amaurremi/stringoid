package com.quoord.gif;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;

import java.io.InputStream;

public class GifDrawable
        extends Drawable
        implements GifAction, Drawable.Callback {
    private static long DEFAULT_DELAY = 100L;
    public static Activity context;
    private Rect _boundsRect = null;
    private boolean _inSchedule = false;
    private int _resID;
    private GifView.GifImageType animationType = GifView.GifImageType.SYNC_DECODER;
    private long beginTime = 0L;
    private View containerView;
    private long currDelayTime = 0L;
    private Bitmap currentImage = null;
    private GifFrame currframe;
    private GifDecoder gifDecoder = null;
    private boolean isRun = true;
    private boolean isStart = false;
    public boolean parseResult = true;
    private boolean pause = false;
    private long prevFrameTime = 0L;
    private Rect rect = null;
    private Runnable run;
    private int showHeight = -1;
    private int showWidth = -1;
    private Runnable todo;
    private Handler uihandler;
    private Drawable who;

    public GifDrawable() {
        setCallback(this);
        this.uihandler = new Handler() {
            public void handleMessage(Message paramAnonymousMessage) {
                GifDrawable.this._inSchedule = false;
                GifDrawable.this.containerView.invalidate();
            }
        };
        this.run = new Runnable() {
            public void run() {
                GifDrawable.this.prevFrameTime = SystemClock.uptimeMillis();
                GifDrawable.this.currDelayTime = GifDrawable.this.gifDecoder.getCurrentFrame().delay;
                if (GifDrawable.this.currDelayTime == 0L) {
                    GifDrawable.this.currDelayTime = GifDrawable.DEFAULT_DELAY;
                }
                GifDrawable.this.gifDecoder.next();
                Message localMessage = GifDrawable.this.uihandler.obtainMessage();
                GifDrawable.this.uihandler.sendMessage(localMessage);
            }
        };
    }

    private void setGifDecoderImage(InputStream paramInputStream) {
        if (this.gifDecoder != null) {
            this.gifDecoder.free();
            this.gifDecoder = null;
        }
        this.gifDecoder = new GifDecoder(paramInputStream, this);
        this.gifDecoder.run();
    }

    private void setGifDecoderImage(byte[] paramArrayOfByte) {
        if (this.gifDecoder != null) {
            this.gifDecoder.free();
            this.gifDecoder = null;
        }
        this.gifDecoder = new GifDecoder(paramArrayOfByte, this);
        this.gifDecoder.run();
    }

    public void draw(Canvas paramCanvas) {
        if (this.gifDecoder.getImage() == null) {
        }
        long l;
        do {
            return;
            if ((this.gifDecoder == null) || (this.gifDecoder.getCurrentFrame() == null)) {
                setGifImage(this._resID);
            }
            l = SystemClock.uptimeMillis();
            if (this.prevFrameTime == 0L) {
                this.prevFrameTime = l;
            }
            this.currframe = this.gifDecoder.getCurrentFrame();
        } while (this.currframe == null);
        this.currentImage = this.currframe.image;
        int i = paramCanvas.getSaveCount();
        paramCanvas.save();
        if (this.showWidth == -1) {
            paramCanvas.drawBitmap(this.currentImage, 0.0F, 0.0F, null);
        }
        for (; ; ) {
            paramCanvas.restoreToCount(i);
            if (this._inSchedule) {
                break;
            }
            this.currDelayTime = this.gifDecoder.getCurrentFrame().delay;
            if (this.currDelayTime == 0L) {
                this.currDelayTime = DEFAULT_DELAY;
            }
            scheduleSelf(this.run, Math.max(0L, this.currDelayTime - (l - this.prevFrameTime)));
            return;
            paramCanvas.drawBitmap(this.currentImage, null, this.rect, null);
        }
    }

    public int getIntrinsicHeight() {
        return this.gifDecoder.height;
    }

    public int getIntrinsicWidth() {
        return this.gifDecoder.width;
    }

    public int getMinimumHeight() {
        return this.gifDecoder.height;
    }

    public int getMinimumWidth() {
        return this.gifDecoder.width;
    }

    public int getOpacity() {
        return -2;
    }

    public void invalidateDrawable(Drawable paramDrawable) {
        this.todo.run();
    }

    public void parseOk(boolean paramBoolean, int paramInt) {
        setBounds(0, 0, this.gifDecoder.width, this.gifDecoder.height);
    }

    public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, final long paramLong) {
        this.who = paramDrawable;
        this.todo = paramRunnable;
        this._inSchedule = true;
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(paramLong);
                    this.val$who.invalidateSelf();
                    return;
                } catch (InterruptedException localInterruptedException) {
                    localInterruptedException.printStackTrace();
                }
            }
        }) {
        }.start();
    }

    public void setAlpha(int paramInt) {
    }

    public void setColorFilter(ColorFilter paramColorFilter) {
    }

    public void setContainerView(View paramView) {
        this.containerView = paramView;
    }

    public void setGifImage(int paramInt) {
        try {
            this._resID = paramInt;
            setGifDecoderImage(context.getResources().openRawResource(this._resID));
            do {
                paramInt = this.gifDecoder.getStatus();
            } while (paramInt != -1);
            return;
        } catch (Exception localException) {
        }
    }

    public void setGifImage(InputStream paramInputStream) {
        setGifDecoderImage(paramInputStream);
        while (this.gifDecoder.getStatus() != -1) {
        }
    }

    public void setGifImage(byte[] paramArrayOfByte) {
        setGifDecoderImage(paramArrayOfByte);
    }

    public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/gif/GifDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */