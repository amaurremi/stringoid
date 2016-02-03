package com.everimaging.fotorsdk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

public class LoadImageTask
        extends FotorAsyncTask<Void, Void, Bitmap> {
    private static final String TAG = LoadImageTask.class.getSimpleName();
    private String error;
    private FotorLoggerFactory.c logger = FotorLoggerFactory.a(TAG, FotorLoggerFactory.LoggerType.CONSOLE);
    private Drawable mBlurDrawable;
    private Context mContext;
    private ImageSize mImageSize;
    private OnLoadImageListener mListener;
    private int mMaxSize;
    private Uri mUri;

    public LoadImageTask(Context paramContext, Uri paramUri, int paramInt) {
        this.mUri = paramUri;
        this.mMaxSize = paramInt;
        this.mContext = paramContext;
    }

    protected Bitmap doInBackground(Void... paramVarArgs) {
        int i = -1;
        if (this.mMaxSize > 0) {
            i = this.mMaxSize;
        }
        int j = i;
        if (i <= 0) {
            j = getManagedMaxImageSize();
        }
        for (paramVarArgs = null; ; paramVarArgs = localException) {
            try {
                localObject1 = BitmapDecodeUtils.decode(this.mContext, this.mUri, j, j, this.mImageSize);
                if (localObject1 == null) {
                    continue;
                }
                paramVarArgs = (Void[]) localObject1;
                if (((Bitmap) localObject1).getConfig() == Bitmap.Config.ARGB_8888) {
                    continue;
                }
                paramVarArgs = (Void[]) localObject1;
                localObject2 = BitmapUtils.copy((Bitmap) localObject1, Bitmap.Config.ARGB_8888);
                if ((localObject2 == null) || (localObject2 == localObject1)) {
                    continue;
                }
                paramVarArgs = (Void[]) localObject1;
                ((Bitmap) localObject1).recycle();
                paramVarArgs = (Void[]) localObject2;
            } catch (Throwable localThrowable) {
                for (; ; ) {
                    try {
                        this.logger.a();
                        Object localObject1 = BitmapUtils.resizeBitmap(paramVarArgs, 60, 60, BitmapUtils.ResizeMode.ASPECT_FIT);
                        RenderScript localRenderScript = RenderScript.create(this.mContext);
                        if ((localObject1 == null) || (((Bitmap) localObject1).getConfig() == Bitmap.Config.ARGB_8888)) {
                            break;
                        }
                        Object localObject2 = BitmapUtils.copy((Bitmap) localObject1, Bitmap.Config.ARGB_8888);
                        if ((localObject1 == localObject2) || (localObject2 == null)) {
                            break;
                        }
                        ((Bitmap) localObject1).recycle();
                        localObject1 = localObject2;
                        Allocation localAllocation = Allocation.createFromBitmap(localRenderScript, (Bitmap) localObject1);
                        localObject2 = Allocation.createTyped(localRenderScript, localAllocation.getType());
                        ScriptIntrinsicBlur localScriptIntrinsicBlur = ScriptIntrinsicBlur.create(localRenderScript, Element.U8_4(localRenderScript));
                        localScriptIntrinsicBlur.setInput(localAllocation);
                        localScriptIntrinsicBlur.setRadius(25.0F);
                        localScriptIntrinsicBlur.forEach((Allocation) localObject2);
                        localObject1 = BitmapUtils.createBitmap((Bitmap) localObject1);
                        ((Allocation) localObject2).copyTo((Bitmap) localObject1);
                        this.mBlurDrawable = new BitmapDrawable(this.mContext.getResources(), (Bitmap) localObject1);
                        localRenderScript.destroy();
                        this.logger.c(new Object[]{"Do Gaussian blur use time:" + this.logger.b()});
                        return paramVarArgs;
                    } catch (Exception localException) {
                        return paramVarArgs;
                    }
                    localThrowable = localThrowable;
                    this.logger.e(new Object[]{"error", localThrowable.getMessage()});
                    this.error = localThrowable.getMessage();
                }
            }
            if (paramVarArgs != null) {
            }
            for (; ; ) {
            }
        }
    }

    protected int getManagedMaxImageSize() {
        int i = Math.max(DeviceUtils.getScreenWidth(), DeviceUtils.getScreenHeight());
        double d = SystemUtils.getApplicationTotalMemory();
        if (d >= 64.0D) {
            return Math.min(i, 1280);
        }
        if (d >= 32.0D) {
            return Math.min(i, 900);
        }
        return Math.min(i, 700);
    }

    protected void onPostExecute(Bitmap paramBitmap) {
        super.onPostExecute(paramBitmap);
        if (this.mListener != null) {
            if (paramBitmap == null) {
                break label93;
            }
            this.mListener.onLoadComplete(paramBitmap, this.mBlurDrawable, this.mImageSize);
        }
        for (; ; ) {
            if ((this.mImageSize.getOriginalWidth() == -1) || (this.mImageSize.getOriginalHeight() == -1)) {
                this.mImageSize.setOriginalSize(this.mImageSize.getNewWidth(), this.mImageSize.getNewHeight());
            }
            this.mListener = null;
            this.mUri = null;
            this.error = null;
            return;
            label93:
            this.mListener.onLoadError(this.error);
        }
    }

    protected void onPreExecute() {
        super.onPreExecute();
        if (this.mListener != null) {
            this.mListener.onLoadStart();
        }
        this.mImageSize = new ImageSize();
    }

    public void setOnLoadListener(OnLoadImageListener paramOnLoadImageListener) {
        this.mListener = paramOnLoadImageListener;
    }

    public static abstract interface OnLoadImageListener {
        public abstract void onLoadComplete(Bitmap paramBitmap, Drawable paramDrawable, ImageSize paramImageSize);

        public abstract void onLoadError(String paramString);

        public abstract void onLoadStart();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/LoadImageTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */