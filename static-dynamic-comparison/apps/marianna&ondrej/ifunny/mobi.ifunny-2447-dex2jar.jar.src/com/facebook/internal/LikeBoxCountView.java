package com.facebook.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.android.R.color;
import com.facebook.android.R.dimen;

public class LikeBoxCountView
        extends FrameLayout {
    private int additionalTextPadding;
    private Paint borderPaint;
    private float borderRadius;
    private float caretHeight;
    private LikeBoxCountView.LikeBoxCountViewCaretPosition caretPosition = LikeBoxCountView.LikeBoxCountViewCaretPosition.LEFT;
    private float caretWidth;
    private TextView likeCountLabel;
    private int textPadding;

    public LikeBoxCountView(Context paramContext) {
        super(paramContext);
        initialize(paramContext);
    }

    private void drawBorder(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
        Path localPath = new Path();
        float f = this.borderRadius * 2.0F;
        localPath.addArc(new RectF(paramFloat1, paramFloat2, paramFloat1 + f, paramFloat2 + f), -180.0F, 90.0F);
        if (this.caretPosition == LikeBoxCountView.LikeBoxCountViewCaretPosition.TOP) {
            localPath.lineTo((paramFloat3 - paramFloat1 - this.caretWidth) / 2.0F + paramFloat1, paramFloat2);
            localPath.lineTo((paramFloat3 - paramFloat1) / 2.0F + paramFloat1, paramFloat2 - this.caretHeight);
            localPath.lineTo((paramFloat3 - paramFloat1 + this.caretWidth) / 2.0F + paramFloat1, paramFloat2);
        }
        localPath.lineTo(paramFloat3 - this.borderRadius, paramFloat2);
        localPath.addArc(new RectF(paramFloat3 - f, paramFloat2, paramFloat3, paramFloat2 + f), -90.0F, 90.0F);
        if (this.caretPosition == LikeBoxCountView.LikeBoxCountViewCaretPosition.RIGHT) {
            localPath.lineTo(paramFloat3, (paramFloat4 - paramFloat2 - this.caretWidth) / 2.0F + paramFloat2);
            localPath.lineTo(this.caretHeight + paramFloat3, (paramFloat4 - paramFloat2) / 2.0F + paramFloat2);
            localPath.lineTo(paramFloat3, (paramFloat4 - paramFloat2 + this.caretWidth) / 2.0F + paramFloat2);
        }
        localPath.lineTo(paramFloat3, paramFloat4 - this.borderRadius);
        localPath.addArc(new RectF(paramFloat3 - f, paramFloat4 - f, paramFloat3, paramFloat4), 0.0F, 90.0F);
        if (this.caretPosition == LikeBoxCountView.LikeBoxCountViewCaretPosition.BOTTOM) {
            localPath.lineTo((paramFloat3 - paramFloat1 + this.caretWidth) / 2.0F + paramFloat1, paramFloat4);
            localPath.lineTo((paramFloat3 - paramFloat1) / 2.0F + paramFloat1, this.caretHeight + paramFloat4);
            localPath.lineTo((paramFloat3 - paramFloat1 - this.caretWidth) / 2.0F + paramFloat1, paramFloat4);
        }
        localPath.lineTo(this.borderRadius + paramFloat1, paramFloat4);
        localPath.addArc(new RectF(paramFloat1, paramFloat4 - f, f + paramFloat1, paramFloat4), 90.0F, 90.0F);
        if (this.caretPosition == LikeBoxCountView.LikeBoxCountViewCaretPosition.LEFT) {
            localPath.lineTo(paramFloat1, (paramFloat4 - paramFloat2 + this.caretWidth) / 2.0F + paramFloat2);
            localPath.lineTo(paramFloat1 - this.caretHeight, (paramFloat4 - paramFloat2) / 2.0F + paramFloat2);
            localPath.lineTo(paramFloat1, (paramFloat4 - paramFloat2 - this.caretWidth) / 2.0F + paramFloat2);
        }
        localPath.lineTo(paramFloat1, this.borderRadius + paramFloat2);
        paramCanvas.drawPath(localPath, this.borderPaint);
    }

    private void initialize(Context paramContext) {
        setWillNotDraw(false);
        this.caretHeight = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_caret_height);
        this.caretWidth = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_caret_width);
        this.borderRadius = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_border_radius);
        this.borderPaint = new Paint();
        this.borderPaint.setColor(getResources().getColor(R.color.com_facebook_likeboxcountview_border_color));
        this.borderPaint.setStrokeWidth(getResources().getDimension(R.dimen.com_facebook_likeboxcountview_border_width));
        this.borderPaint.setStyle(Paint.Style.STROKE);
        initializeLikeCountLabel(paramContext);
        addView(this.likeCountLabel);
        setCaretPosition(this.caretPosition);
    }

    private void initializeLikeCountLabel(Context paramContext) {
        this.likeCountLabel = new TextView(paramContext);
        paramContext = new FrameLayout.LayoutParams(-1, -1);
        this.likeCountLabel.setLayoutParams(paramContext);
        this.likeCountLabel.setGravity(17);
        this.likeCountLabel.setTextSize(0, getResources().getDimension(R.dimen.com_facebook_likeboxcountview_text_size));
        this.likeCountLabel.setTextColor(getResources().getColor(R.color.com_facebook_likeboxcountview_text_color));
        this.textPadding = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeboxcountview_text_padding);
        this.additionalTextPadding = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeboxcountview_caret_height);
    }

    private void setAdditionalTextPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.likeCountLabel.setPadding(this.textPadding + paramInt1, this.textPadding + paramInt2, this.textPadding + paramInt3, this.textPadding + paramInt4);
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        int m = getPaddingTop();
        int k = getPaddingLeft();
        int j = getWidth() - getPaddingRight();
        int i = getHeight() - getPaddingBottom();
        switch (LikeBoxCountView
        .1.$SwitchMap$com$facebook$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition[this.caretPosition.ordinal()])
        {
        }
        for (; ; ) {
            drawBorder(paramCanvas, k, m, j, i);
            return;
            i = (int) (i - this.caretHeight);
            continue;
            k = (int) (k + this.caretHeight);
            continue;
            m = (int) (m + this.caretHeight);
            continue;
            j = (int) (j - this.caretHeight);
        }
    }

    public void setCaretPosition(LikeBoxCountView.LikeBoxCountViewCaretPosition paramLikeBoxCountViewCaretPosition) {
        this.caretPosition = paramLikeBoxCountViewCaretPosition;
        switch (LikeBoxCountView
        .1.$SwitchMap$com$facebook$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition[paramLikeBoxCountViewCaretPosition.ordinal()])
        {
            default:
                return;
            case 1:
                setAdditionalTextPadding(this.additionalTextPadding, 0, 0, 0);
                return;
            case 2:
                setAdditionalTextPadding(0, this.additionalTextPadding, 0, 0);
                return;
            case 3:
                setAdditionalTextPadding(0, 0, this.additionalTextPadding, 0);
                return;
        }
        setAdditionalTextPadding(0, 0, 0, this.additionalTextPadding);
    }

    public void setText(String paramString) {
        this.likeCountLabel.setText(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeBoxCountView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */