package com.facebook.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.android.R.drawable;
import com.facebook.android.R.id;

import java.lang.ref.WeakReference;

public class ToolTipPopup {
    public static final long DEFAULT_POPUP_DISPLAY_TIME = 6000L;
    private final WeakReference<View> mAnchorViewRef;
    private final Context mContext;
    private long mNuxDisplayTime = 6000L;
    private ToolTipPopup.PopupContentView mPopupContent;
    private PopupWindow mPopupWindow;
    private final ViewTreeObserver.OnScrollChangedListener mScrollListener = new ToolTipPopup
    .1(this);
    private ToolTipPopup.Style mStyle = ToolTipPopup.Style.BLUE;
    private final String mText;

    public ToolTipPopup(String paramString, View paramView) {
        this.mText = paramString;
        this.mAnchorViewRef = new WeakReference(paramView);
        this.mContext = paramView.getContext();
    }

    private void registerObserver() {
        unregisterObserver();
        if (this.mAnchorViewRef.get() != null) {
            ((View) this.mAnchorViewRef.get()).getViewTreeObserver().addOnScrollChangedListener(this.mScrollListener);
        }
    }

    private void unregisterObserver() {
        if (this.mAnchorViewRef.get() != null) {
            ((View) this.mAnchorViewRef.get()).getViewTreeObserver().removeOnScrollChangedListener(this.mScrollListener);
        }
    }

    private void updateArrows() {
        if ((this.mPopupWindow != null) && (this.mPopupWindow.isShowing())) {
            if (this.mPopupWindow.isAboveAnchor()) {
                this.mPopupContent.showBottomArrow();
            }
        } else {
            return;
        }
        this.mPopupContent.showTopArrow();
    }

    public void dismiss() {
        unregisterObserver();
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
        }
    }

    public void setNuxDisplayTime(long paramLong) {
        this.mNuxDisplayTime = paramLong;
    }

    public void setStyle(ToolTipPopup.Style paramStyle) {
        this.mStyle = paramStyle;
    }

    public void show() {
        if (this.mAnchorViewRef.get() != null) {
            this.mPopupContent = new ToolTipPopup.PopupContentView(this, this.mContext);
            ((TextView) this.mPopupContent.findViewById(R.id.com_facebook_tooltip_bubble_view_text_body)).setText(this.mText);
            if (this.mStyle != ToolTipPopup.Style.BLUE) {
                break label258;
            }
            ToolTipPopup.PopupContentView.access$300(this.mPopupContent).setBackgroundResource(R.drawable.com_facebook_tooltip_blue_background);
            ToolTipPopup.PopupContentView.access$400(this.mPopupContent).setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
            ToolTipPopup.PopupContentView.access$500(this.mPopupContent).setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);
            ToolTipPopup.PopupContentView.access$600(this.mPopupContent).setImageResource(R.drawable.com_facebook_tooltip_blue_xout);
        }
        for (; ; ) {
            View localView = ((Activity) this.mContext).getWindow().getDecorView();
            int i = localView.getWidth();
            int j = localView.getHeight();
            registerObserver();
            this.mPopupContent.onMeasure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(j, Integer.MIN_VALUE));
            this.mPopupWindow = new PopupWindow(this.mPopupContent, this.mPopupContent.getMeasuredWidth(), this.mPopupContent.getMeasuredHeight());
            this.mPopupWindow.showAsDropDown((View) this.mAnchorViewRef.get());
            updateArrows();
            if (this.mNuxDisplayTime > 0L) {
                this.mPopupContent.postDelayed(new ToolTipPopup .2 (this), this.mNuxDisplayTime);
            }
            this.mPopupWindow.setTouchable(true);
            this.mPopupContent.setOnClickListener(new ToolTipPopup .3 (this));
            return;
            label258:
            ToolTipPopup.PopupContentView.access$300(this.mPopupContent).setBackgroundResource(R.drawable.com_facebook_tooltip_black_background);
            ToolTipPopup.PopupContentView.access$400(this.mPopupContent).setImageResource(R.drawable.com_facebook_tooltip_black_bottomnub);
            ToolTipPopup.PopupContentView.access$500(this.mPopupContent).setImageResource(R.drawable.com_facebook_tooltip_black_topnub);
            ToolTipPopup.PopupContentView.access$600(this.mPopupContent).setImageResource(R.drawable.com_facebook_tooltip_black_xout);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/ToolTipPopup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */