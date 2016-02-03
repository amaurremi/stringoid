package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.ui.NonSwipeableViewPager;
import com.quoord.tapatalkpro.ui.ScaleImageView;
import com.quoord.tapatalkpro.util.ImageInThreadLoader;
import com.quoord.tapatalkpro.util.ImageItem;
import com.quoord.tapatalkpro.util.Util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ViewPagerAdapter
        extends PagerAdapter
        implements View.OnTouchListener {
    static final int DRAG = 1;
    static final float MAX_SCALE = 4.0F;
    static final int NONE = 0;
    static final int ZOOM = 2;
    private int checkedId = 0;
    long currentTime;
    float dist = 1.0F;
    DisplayMetrics dm;
    private boolean isChecked = false;
    private ArrayList<String> mData;
    private ArrayList mImageList = new ArrayList();
    private HashMap<Integer, Matrix> mMatrixMap = new HashMap();
    private HashMap<Integer, Matrix> mSaveMatrixMap = new HashMap();
    PointF mid = new PointF();
    float minScaleR;
    int mode = 0;
    float oldDist = 1.0F;
    private NonSwipeableViewPager pager;
    PointF prev = new PointF();
    PointF start = new PointF();
    private Activity thisActivity;
    Bitmap thisBitMap;

    public ViewPagerAdapter() {
    }

    public ViewPagerAdapter(Activity paramActivity, ForumStatus paramForumStatus, ArrayList<String> paramArrayList, NonSwipeableViewPager paramNonSwipeableViewPager, int paramInt) {
        this.thisActivity = paramActivity;
        this.mData = paramArrayList;
        this.pager = paramNonSwipeableViewPager;
        this.checkedId = paramInt;
        this.dm = new DisplayMetrics();
        paramActivity.getWindowManager().getDefaultDisplay().getMetrics(this.dm);
    }

    private void CheckView(boolean paramBoolean) {
        float[] arrayOfFloat = new float[9];
        ((Matrix) this.mMatrixMap.get(Integer.valueOf(this.pager.getCurrentItem()))).getValues(arrayOfFloat);
        if ((this.mode == 2) || (paramBoolean)) {
            if (arrayOfFloat[0] < this.minScaleR) {
                ((Matrix) this.mMatrixMap.get(Integer.valueOf(this.pager.getCurrentItem()))).setScale(this.minScaleR, this.minScaleR);
            }
            float f = arrayOfFloat[0];
        }
        center();
    }

    private void center() {
        center(true, true, null);
    }

    private void center(Matrix paramMatrix) {
        center(true, true, paramMatrix);
    }

    private void midPoint(PointF paramPointF, MotionEvent paramMotionEvent) {
        float f1 = paramMotionEvent.getX(0);
        float f2 = paramMotionEvent.getX(1);
        float f3 = paramMotionEvent.getY(0);
        float f4 = paramMotionEvent.getY(1);
        paramPointF.set((f1 + f2) / 2.0F, (f3 + f4) / 2.0F);
    }

    private void minZoom() {
        float f3 = ((LinearLayout) getCurrentImage().getParent()).getMeasuredWidth();
        float f2 = ((LinearLayout) getCurrentImage().getParent()).getMeasuredHeight();
        float f1 = f3;
        if (f3 == 0.0F) {
            f1 = this.dm.widthPixels;
            f2 = this.dm.heightPixels;
        }
        this.minScaleR = Math.min(f1 / ((BitmapDrawable) getCurrentImage().getDrawable()).getBitmap().getWidth(), f2 / ((BitmapDrawable) getCurrentImage().getDrawable()).getBitmap().getHeight());
        if (this.minScaleR < 1.0D) {
            ((Matrix) this.mMatrixMap.get(Integer.valueOf(this.pager.getCurrentItem()))).postScale(this.minScaleR, this.minScaleR);
        }
        if (this.minScaleR > 2.0F) {
            this.minScaleR = 2.0F;
        }
    }

    private float spacing(MotionEvent paramMotionEvent) {
        float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
        float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
        return FloatMath.sqrt(f1 * f1 + f2 * f2);
    }

    protected void center(boolean paramBoolean1, boolean paramBoolean2, Matrix paramMatrix) {
        Matrix localMatrix = new Matrix();
        RectF localRectF;
        float f3;
        float f2;
        float f1;
        int i;
        if (paramMatrix == null) {
            localMatrix.set((Matrix) this.mMatrixMap.get(Integer.valueOf(this.pager.getCurrentItem())));
            localRectF = new RectF(0.0F, 0.0F, this.thisBitMap.getWidth(), this.thisBitMap.getHeight());
            localMatrix.mapRect(localRectF);
            float f6 = localRectF.height();
            float f5 = localRectF.width();
            float f4 = 0.0F;
            f3 = 0.0F;
            f2 = 0.0F;
            f1 = 0.0F;
            if (paramBoolean2) {
                int j = ((View) ((ImageView) this.mImageList.get(this.pager.getCurrentItem())).getParent()).getHeight();
                i = j;
                if (j == 0) {
                    i = this.dm.heightPixels;
                }
                if (f6 >= i) {
                    break label277;
                }
                f1 = (i - f6) / 2.0F - localRectF.top;
                label174:
                if (f6 <= i) {
                    break label342;
                }
                this.pager.setSwipe(false);
                f2 = f1;
            }
            label195:
            f1 = f4;
            if (paramBoolean1) {
                i = this.dm.widthPixels;
                if (f5 >= i) {
                    break label357;
                }
                f1 = (i - f5) / 2.0F - localRectF.left;
                label237:
                if (f5 <= i) {
                    break label408;
                }
                this.pager.setSwipe(false);
            }
        }
        for (; ; ) {
            if (paramMatrix == null) {
                break label419;
            }
            paramMatrix.postTranslate(f1, f2);
            return;
            localMatrix.set(paramMatrix);
            break;
            label277:
            if (localRectF.top > 0.0F) {
                f1 = -localRectF.top;
                break label174;
            }
            if (localRectF.bottom >= i) {
                break label174;
            }
            f1 = ((ImageView) this.mImageList.get(this.pager.getCurrentItem())).getHeight() - localRectF.bottom;
            break label174;
            label342:
            this.pager.setSwipe(true);
            f2 = f1;
            break label195;
            label357:
            if (localRectF.left > 0.0F) {
                f1 = -localRectF.left;
                break label237;
            }
            f1 = f3;
            if (localRectF.right >= i) {
                break label237;
            }
            f1 = i - localRectF.right;
            break label237;
            label408:
            this.pager.setSwipe(true);
        }
        label419:
        ((Matrix) this.mMatrixMap.get(Integer.valueOf(this.pager.getCurrentItem()))).postTranslate(f1, f2);
    }

    public void destroyItem(View paramView, int paramInt, Object paramObject) {
    }

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
        super.destroyItem(paramViewGroup, paramInt, paramObject);
    }

    public void finishUpdate(ViewGroup paramViewGroup) {
        this.minScaleR = 0.0F;
        if ((this.checkedId != 0) && (this.pager.getCurrentItem() != this.checkedId)) {
            this.pager.setCurrentItem(this.checkedId);
            this.thisActivity.setTitle(this.checkedId + 1 + "/" + this.mData.size());
            this.checkedId = 0;
            return;
        }
        this.thisActivity.setTitle(((ViewPager) paramViewGroup).getCurrentItem() + 1 + "/" + this.mData.size());
    }

    public int getCount() {
        return this.mData.size();
    }

    public ImageView getCurrentImage() {
        return (ImageView) this.mImageList.get(this.pager.getCurrentItem());
    }

    public Matrix getCurrentMatrix() {
        return (Matrix) this.mMatrixMap.get(Integer.valueOf(this.pager.getCurrentItem()));
    }

    public Matrix getCurrentSavedMatrix() {
        return (Matrix) this.mSaveMatrixMap.get(Integer.valueOf(this.pager.getCurrentItem()));
    }

    public void initialView() {
        getCurrentMatrix().set(((ImageView) this.mImageList.get(this.pager.getCurrentItem())).getImageMatrix());
        center();
        minZoom();
        CheckView(true);
        ((ImageView) this.mImageList.get(this.pager.getCurrentItem())).setScaleType(ImageView.ScaleType.MATRIX);
    }

    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
        if (paramViewGroup.getChildAt(paramInt) == null) {
            if (ImageInThreadLoader.getImageType((String) this.mData.get(paramInt)) != ImageItem.GIF) {
                localObject = this.thisActivity.getLayoutInflater().inflate(2130903431, null);
                ((ViewPager) paramViewGroup).addView((View) localObject, paramInt);
                paramViewGroup = (ScaleImageView) ((View) localObject).findViewById(2131231730);
                paramViewGroup.setAdapter(this);
                paramViewGroup.setOnTouchListener(this);
                setImage(paramInt, paramViewGroup);
                this.mImageList.add(paramViewGroup);
                Matrix localMatrix1 = new Matrix();
                Matrix localMatrix2 = new Matrix();
                this.mMatrixMap.put(Integer.valueOf(this.mImageList.indexOf(paramViewGroup)), localMatrix1);
                this.mSaveMatrixMap.put(Integer.valueOf(this.mImageList.indexOf(paramViewGroup)), localMatrix2);
                paramViewGroup.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                paramViewGroup.setImageMatrix(localMatrix1);
                paramViewGroup.setBackgroundColor(-1);
                center(localMatrix1);
                return localObject;
            }
            Object localObject = setWebView(paramInt, new WebView(this.thisActivity));
            this.mImageList.add(localObject);
            ((ViewPager) paramViewGroup).addView((View) localObject, paramInt);
            return localObject;
        }
        return paramViewGroup.getChildAt(paramInt);
    }

    public boolean isViewFromObject(View paramView, Object paramObject) {
        return paramView.equals(paramObject);
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
        if (((ImageView) paramView).getScaleType() == ImageView.ScaleType.CENTER_INSIDE) {
            getCurrentMatrix().set(((ImageView) this.mImageList.get(this.pager.getCurrentItem())).getImageMatrix());
            center();
            minZoom();
            CheckView(true);
            ((ImageView) this.mImageList.get(this.pager.getCurrentItem())).setScaleType(ImageView.ScaleType.MATRIX);
        }
        if ((this.mImageList.get(this.pager.getCurrentItem()) instanceof ImageView)) {
            switch (paramMotionEvent.getAction() & 0xFF) {
            }
        }
        for (; ; ) {
            ((ImageView) this.mImageList.get(this.pager.getCurrentItem())).setImageMatrix((Matrix) this.mMatrixMap.get(Integer.valueOf(this.pager.getCurrentItem())));
            CheckView(false);
            return true;
            ((Matrix) this.mSaveMatrixMap.get(Integer.valueOf(this.pager.getCurrentItem()))).set((Matrix) this.mMatrixMap.get(Integer.valueOf(this.pager.getCurrentItem())));
            this.prev.set(paramMotionEvent.getX(), paramMotionEvent.getY());
            this.mode = 1;
            continue;
            this.dist = spacing(paramMotionEvent);
            if (spacing(paramMotionEvent) > 10.0F) {
                ((Matrix) this.mSaveMatrixMap.get(Integer.valueOf(this.pager.getCurrentItem()))).set((Matrix) this.mMatrixMap.get(Integer.valueOf(this.pager.getCurrentItem())));
                midPoint(this.mid, paramMotionEvent);
                this.mode = 2;
                continue;
                if ((this.mode == 1) && (System.currentTimeMillis() - this.currentTime < 400L)) {
                    minZoom();
                    ((Matrix) this.mMatrixMap.get(Integer.valueOf(this.pager.getCurrentItem()))).setScale(this.minScaleR, this.minScaleR);
                    CheckView(false);
                    center();
                }
                for (; ; ) {
                    this.mode = 0;
                    break;
                    this.currentTime = System.currentTimeMillis();
                }
                if (this.mode == 1) {
                    ((Matrix) this.mMatrixMap.get(Integer.valueOf(this.pager.getCurrentItem()))).set((Matrix) this.mSaveMatrixMap.get(Integer.valueOf(this.pager.getCurrentItem())));
                    ((Matrix) this.mMatrixMap.get(Integer.valueOf(this.pager.getCurrentItem()))).postTranslate(paramMotionEvent.getX() - this.prev.x, paramMotionEvent.getY() - this.prev.y);
                } else if (this.mode == 2) {
                    float f = spacing(paramMotionEvent);
                    if (f > 10.0F) {
                        ((Matrix) this.mMatrixMap.get(Integer.valueOf(this.pager.getCurrentItem()))).set((Matrix) this.mSaveMatrixMap.get(Integer.valueOf(this.pager.getCurrentItem())));
                        f /= this.dist;
                        ((Matrix) this.mMatrixMap.get(Integer.valueOf(this.pager.getCurrentItem()))).postScale(f, f, this.mid.x, this.mid.y);
                    }
                }
            }
        }
    }

    public void setImage(int paramInt, ImageView paramImageView) {
        String str = (String) this.mData.get(paramInt);
        this.thisBitMap = null;
        this.thisBitMap = Util.getRemotePicFullScreen((String) this.mData.get(paramInt));
        paramImageView.setImageBitmap(this.thisBitMap);
    }

    public LinearLayout setWebView(int paramInt, WebView paramWebView) {
        LinearLayout localLinearLayout = new LinearLayout(this.thisActivity);
        localLinearLayout.setOrientation(1);
        localLinearLayout.setGravity(17);
        String str = (String) this.mData.get(paramInt);
        if (!new File(str + ".gif").exists()) {
        }
        try {
            Util.copyFile(new File(str), new File(str + ".gif"));
            Object localObject = new BitmapFactory.Options();
            ((BitmapFactory.Options) localObject).inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, (BitmapFactory.Options) localObject);
            d = ((BitmapFactory.Options) localObject).outWidth;
            localObject = new DisplayMetrics();
            this.thisActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics) localObject);
            if (((DisplayMetrics) localObject).densityDpi < 320) {
                d *= 1.5D;
                localObject = new LinearLayout.LayoutParams((int) d, -2);
                ((LinearLayout.LayoutParams) localObject).gravity = 17;
                paramWebView.loadUrl("file:///" + str + ".gif");
                paramWebView.setLayoutParams((ViewGroup.LayoutParams) localObject);
                localLinearLayout.addView(paramWebView);
                return localLinearLayout;
            }
        } catch (IOException localIOException) {
            for (; ; ) {
                double d;
                localIOException.printStackTrace();
                continue;
                d *= 2.0D;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/ViewPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */