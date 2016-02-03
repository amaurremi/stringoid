package com.quoord.tapatalkpro.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.quoord.tapatalkpro.activity.forum.ThreadActivity;
import com.quoord.tapatalkpro.activity.forum.ThreadOuterFragment;
import com.quoord.tapatalkpro.activity.forum.conversation.ConverSationActivity;
import com.quoord.tapatalkpro.activity.forum.conversation.ConversationOuterFragment;
import com.quoord.tapatalkpro.bean.BaseBean;
import com.quoord.tapatalkpro.util.Util;

public class CustomImageViewLayout
        extends ImageView {
    private Activity _context;
    public String _customUrl;
    private BaseBean bean;
    private int[] coords = new int[2];
    private boolean isSetWidth = false;
    private boolean isSmall = false;
    boolean needBackground = false;
    private Rect r = new Rect();

    public CustomImageViewLayout(Context paramContext) {
        super(paramContext);
        this._context = ((Activity) paramContext);
    }

    public CustomImageViewLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this._context = ((Activity) paramContext);
    }

    @SuppressLint({"WrongCall"})
    public void draw(Canvas paramCanvas) {
        if ((this.bean == null) || (this.bean.getLocalIconUri() == null)) {
            this.bean = new BaseBean();
            this.bean.setLocalIconUri(this._customUrl);
        }
        getLocationInWindow(this.coords);
        int i = this.coords[1];
        if (i < -(getMeasuredHeight() - 100)) {
            if (this.bean.getIcon() != null) {
                recyle();
            }
        }
        do {
            do {
                return;
                if (i <= this._context.getWindowManager().getDefaultDisplay().getHeight() - 30) {
                    break;
                }
            } while (this.bean.getIcon() == null);
            recyle();
            return;
            Bitmap localBitmap;
            if ((this.bean.getLocalIconUri() == null) && (this.bean.getIcon() == null)) {
                localBitmap = BitmapFactory.decodeResource(this._context.getResources(), 2130837846);
                this.bean.setIcon(localBitmap);
                this.r.top = 0;
                this.r.left = 0;
                this.r.right = getWidth();
                this.r.bottom = getHeight();
                paramCanvas.drawBitmap(localBitmap, null, this.r, null);
                super.onDraw(paramCanvas);
                return;
            }
            if ((this.bean.getLocalIconUri() != null) && (this.bean.getLocalIconUri().equals("BROKEN")) && (this.bean.getIcon() == null)) {
                localBitmap = BitmapFactory.decodeResource(this._context.getResources(), 2130837846);
                this.bean.setIcon(localBitmap);
                this.r.top = 0;
                this.r.left = 0;
                this.r.right = getWidth();
                this.r.bottom = getHeight();
                paramCanvas.drawBitmap(localBitmap, null, this.r, null);
                super.onDraw(paramCanvas);
                return;
            }
            if ((this.bean.getIcon() != null) || (this.bean.getLocalIconUri() == null) || (this._customUrl.equalsIgnoreCase("BROKEN")) || (this.bean.getLocalIconUri().length() <= 0)) {
                break;
            }
        }
        while ((((this._context instanceof ThreadActivity)) && (((ThreadActivity) this._context).outerFragment.getScrollState() != 0)) || (((this._context instanceof ConverSationActivity)) && (((ConverSationActivity) this._context).convsationFragment.getScrollState() != 0)));
        if (this.isSmall) {
            this.bean.setIcon(Util.getRemotePicSmall(this.bean.getLocalIconUri()));
            label452:
            if ((this.bean.getIcon() == null) && (!this._customUrl.equalsIgnoreCase("BROKEN"))) {
                this.bean.setLocalIconUri(null);
                this._customUrl = null;
            }
            setScaleType(ImageView.ScaleType.FIT_XY);
            this.r.top = 0;
            this.r.left = 0;
            this.r.right = getWidth();
            this.r.bottom = getHeight();
            if (this.bean.getIcon() != null) {
                paramCanvas.drawBitmap(this.bean.getIcon(), null, this.r, null);
            }
        }
        for (; ; ) {
            int j;
            try {
                super.onDraw(paramCanvas);
                if ((this.isSetWidth) || (!this.needBackground) || (this.bean.getIcon() == null) || (this.bean.getIcon().getWidth() <= 1) || (this.bean.getIcon().isRecycled())) {
                    break;
                }
                this.isSetWidth = true;
                j = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth() - 20;
                this.bean.getIcon().getHeight();
                if (j <= this.bean.getIcon().getWidth() * 2) {
                    break label841;
                }
                j = this.bean.getIcon().getWidth() * 2;
                i = this.bean.getIcon().getHeight() * 2;
                setLayoutParams(new LinearLayout.LayoutParams(j, i));
                ((View) getParent()).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                return;
            } catch (Exception paramCanvas) {
                this.bean.setIcon(null);
                paramCanvas.printStackTrace();
                return;
            }
            this.bean.setIcon(Util.getRemotePic(this.bean.getLocalIconUri()));
            break label452;
            setScaleType(ImageView.ScaleType.FIT_XY);
            this.r.top = 0;
            this.r.left = 0;
            this.r.right = getWidth();
            this.r.bottom = getHeight();
            if (this.bean.getIcon() != null) {
                paramCanvas.drawBitmap(this.bean.getIcon(), null, this.r, null);
                continue;
                label841:
                if ((j > this.bean.getIcon().getWidth()) && (j < this.bean.getIcon().getWidth() * 2)) {
                    j = this.bean.getIcon().getWidth();
                    i = this.bean.getIcon().getHeight();
                } else {
                    i = this.bean.getIcon().getHeight() * j / this.bean.getIcon().getWidth();
                }
            }
        }
    }

    public void forceDraw() {
        setImageDrawable(new ColorDrawable(17170445));
    }

    public String getCustomUrl() {
        return this._customUrl;
    }

    public void recyle() {
        if ((getDrawable() instanceof BitmapDrawable)) {
            BitmapDrawable localBitmapDrawable = (BitmapDrawable) getDrawable();
            if ((localBitmapDrawable != null) && (this._customUrl != null)) {
                if (this.bean != null) {
                    if ((this.bean.getIcon() != null) && (!this.bean.getIcon().isRecycled())) {
                        setLayoutParams(new LinearLayout.LayoutParams(getWidth(), getHeight()));
                    }
                    this.bean.setIcon(null);
                }
                if (localBitmapDrawable.getBitmap() != null) {
                    localBitmapDrawable.getBitmap().recycle();
                }
                System.gc();
            }
        }
        for (; ; ) {
            setImageDrawable(new ColorDrawable(17170445));
            return;
            if ((this.bean != null) && (this.bean.getIcon() != null) && (!this.bean.getIcon().isRecycled())) {
                setLayoutParams(new LinearLayout.LayoutParams(getWidth(), getHeight()));
                this.bean.getIcon().recycle();
                this.bean.setIcon(null);
            }
        }
    }

    public void setCustomUrl(String paramString) {
        this._customUrl = paramString;
    }

    public void setNeedbackground() {
        this.needBackground = true;
    }

    public void setSmall() {
        this.isSmall = true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ui/CustomImageViewLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */