package com.facebook.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.a.n;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.android.R.color;
import com.facebook.android.R.dimen;
import com.facebook.android.R.styleable;
import com.facebook.internal.LikeActionController;
import com.facebook.internal.LikeBoxCountView;
import com.facebook.internal.LikeBoxCountView.LikeBoxCountViewCaretPosition;
import com.facebook.internal.LikeButton;
import com.facebook.internal.Utility;

public class LikeView
        extends FrameLayout {
    private static final int NO_FOREGROUND_COLOR = -1;
    private LikeView.AuxiliaryViewPosition auxiliaryViewPosition = LikeView.AuxiliaryViewPosition.DEFAULT;
    private BroadcastReceiver broadcastReceiver;
    private LinearLayout containerView;
    private LikeView.LikeActionControllerCreationCallback creationCallback;
    private int edgePadding;
    private int foregroundColor = -1;
    private LikeView.HorizontalAlignment horizontalAlignment = LikeView.HorizontalAlignment.DEFAULT;
    private int internalPadding;
    private LikeActionController likeActionController;
    private LikeBoxCountView likeBoxCountView;
    private LikeButton likeButton;
    private LikeView.Style likeViewStyle = LikeView.Style.DEFAULT;
    private String objectId;
    private LikeView.OnErrorListener onErrorListener;
    private TextView socialSentenceView;

    public LikeView(Context paramContext) {
        super(paramContext);
        initialize(paramContext);
    }

    public LikeView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        parseAttributes(paramAttributeSet);
        initialize(paramContext);
    }

    private void associateWithLikeActionController(LikeActionController paramLikeActionController) {
        this.likeActionController = paramLikeActionController;
        this.broadcastReceiver = new LikeView.LikeControllerBroadcastReceiver(this, null);
        paramLikeActionController = n.a(getContext());
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.facebook.sdk.LikeActionController.UPDATED");
        localIntentFilter.addAction("com.facebook.sdk.LikeActionController.DID_ERROR");
        localIntentFilter.addAction("com.facebook.sdk.LikeActionController.DID_RESET");
        paramLikeActionController.a(this.broadcastReceiver, localIntentFilter);
    }

    private Bundle getAnalyticsParameters() {
        Bundle localBundle = new Bundle();
        localBundle.putString("style", this.likeViewStyle.toString());
        localBundle.putString("auxiliary_position", this.auxiliaryViewPosition.toString());
        localBundle.putString("horizontal_alignment", this.horizontalAlignment.toString());
        localBundle.putString("object_id", Utility.coerceValueIfNullOrEmpty(this.objectId, ""));
        return localBundle;
    }

    public static boolean handleOnActivityResult(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent) {
        return LikeActionController.handleOnActivityResult(paramContext, paramInt1, paramInt2, paramIntent);
    }

    private void initialize(Context paramContext) {
        this.edgePadding = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeview_edge_padding);
        this.internalPadding = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeview_internal_padding);
        if (this.foregroundColor == -1) {
            this.foregroundColor = getResources().getColor(R.color.com_facebook_likeview_text_color);
        }
        setBackgroundColor(0);
        this.containerView = new LinearLayout(paramContext);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.containerView.setLayoutParams(localLayoutParams);
        initializeLikeButton(paramContext);
        initializeSocialSentenceView(paramContext);
        initializeLikeCountView(paramContext);
        this.containerView.addView(this.likeButton);
        this.containerView.addView(this.socialSentenceView);
        this.containerView.addView(this.likeBoxCountView);
        addView(this.containerView);
        setObjectIdForced(this.objectId);
        updateLikeStateAndLayout();
    }

    private void initializeLikeButton(Context paramContext) {
        if (this.likeActionController != null) {
        }
        for (boolean bool = this.likeActionController.isObjectLiked(); ; bool = false) {
            this.likeButton = new LikeButton(paramContext, bool);
            this.likeButton.setOnClickListener(new LikeView .1 (this));
            paramContext = new LinearLayout.LayoutParams(-2, -2);
            this.likeButton.setLayoutParams(paramContext);
            return;
        }
    }

    private void initializeLikeCountView(Context paramContext) {
        this.likeBoxCountView = new LikeBoxCountView(paramContext);
        paramContext = new LinearLayout.LayoutParams(-1, -1);
        this.likeBoxCountView.setLayoutParams(paramContext);
    }

    private void initializeSocialSentenceView(Context paramContext) {
        this.socialSentenceView = new TextView(paramContext);
        this.socialSentenceView.setTextSize(0, getResources().getDimension(R.dimen.com_facebook_likeview_text_size));
        this.socialSentenceView.setMaxLines(2);
        this.socialSentenceView.setTextColor(this.foregroundColor);
        this.socialSentenceView.setGravity(17);
        paramContext = new LinearLayout.LayoutParams(-2, -1);
        this.socialSentenceView.setLayoutParams(paramContext);
    }

    private void parseAttributes(AttributeSet paramAttributeSet) {
        if ((paramAttributeSet == null) || (getContext() == null)) {
        }
        do {
            return;
            paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.com_facebook_like_view);
        } while (paramAttributeSet == null);
        this.objectId = Utility.coerceValueIfNullOrEmpty(paramAttributeSet.getString(R.styleable.com_facebook_like_view_object_id), null);
        this.likeViewStyle = LikeView.Style.fromInt(paramAttributeSet.getInt(R.styleable.com_facebook_like_view_style, LikeView.Style.access$000(LikeView.Style.DEFAULT)));
        if (this.likeViewStyle == null) {
            throw new IllegalArgumentException("Unsupported value for LikeView 'style'");
        }
        this.auxiliaryViewPosition = LikeView.AuxiliaryViewPosition.fromInt(paramAttributeSet.getInt(R.styleable.com_facebook_like_view_auxiliary_view_position, LikeView.AuxiliaryViewPosition.access$100(LikeView.AuxiliaryViewPosition.DEFAULT)));
        if (this.auxiliaryViewPosition == null) {
            throw new IllegalArgumentException("Unsupported value for LikeView 'auxiliary_view_position'");
        }
        this.horizontalAlignment = LikeView.HorizontalAlignment.fromInt(paramAttributeSet.getInt(R.styleable.com_facebook_like_view_horizontal_alignment, LikeView.HorizontalAlignment.access$200(LikeView.HorizontalAlignment.DEFAULT)));
        if (this.horizontalAlignment == null) {
            throw new IllegalArgumentException("Unsupported value for LikeView 'horizontal_alignment'");
        }
        this.foregroundColor = paramAttributeSet.getColor(R.styleable.com_facebook_like_view_foreground_color, -1);
        paramAttributeSet.recycle();
    }

    private void setObjectIdForced(String paramString) {
        tearDownObjectAssociations();
        this.objectId = paramString;
        if (Utility.isNullOrEmpty(paramString)) {
            return;
        }
        this.creationCallback = new LikeView.LikeActionControllerCreationCallback(this, null);
        LikeActionController.getControllerForObjectId(getContext(), paramString, this.creationCallback);
    }

    private void tearDownObjectAssociations() {
        if (this.broadcastReceiver != null) {
            n.a(getContext()).a(this.broadcastReceiver);
            this.broadcastReceiver = null;
        }
        if (this.creationCallback != null) {
            this.creationCallback.cancel();
            this.creationCallback = null;
        }
        this.likeActionController = null;
    }

    private void toggleLike() {
        if (this.likeActionController != null) {
            Activity localActivity = (Activity) getContext();
            this.likeActionController.toggleLike(localActivity, getAnalyticsParameters());
        }
    }

    private void updateBoxCountCaretPosition() {
        switch (LikeView
        .2.$SwitchMap$com$facebook$widget$LikeView$AuxiliaryViewPosition[this.auxiliaryViewPosition.ordinal()])
        {
            default:
                return;
            case 1:
                this.likeBoxCountView.setCaretPosition(LikeBoxCountView.LikeBoxCountViewCaretPosition.BOTTOM);
                return;
            case 2:
                this.likeBoxCountView.setCaretPosition(LikeBoxCountView.LikeBoxCountViewCaretPosition.TOP);
                return;
        }
        LikeBoxCountView localLikeBoxCountView = this.likeBoxCountView;
        if (this.horizontalAlignment == LikeView.HorizontalAlignment.RIGHT) {
        }
        for (LikeBoxCountView.LikeBoxCountViewCaretPosition localLikeBoxCountViewCaretPosition = LikeBoxCountView.LikeBoxCountViewCaretPosition.RIGHT; ; localLikeBoxCountViewCaretPosition = LikeBoxCountView.LikeBoxCountViewCaretPosition.LEFT) {
            localLikeBoxCountView.setCaretPosition(localLikeBoxCountViewCaretPosition);
            return;
        }
    }

    private void updateLayout() {
        int j = 1;
        Object localObject1 = (FrameLayout.LayoutParams) this.containerView.getLayoutParams();
        Object localObject2 = (LinearLayout.LayoutParams) this.likeButton.getLayoutParams();
        int i;
        if (this.horizontalAlignment == LikeView.HorizontalAlignment.LEFT) {
            i = 3;
            ((FrameLayout.LayoutParams) localObject1).gravity = (i | 0x30);
            ((LinearLayout.LayoutParams) localObject2).gravity = i;
            this.socialSentenceView.setVisibility(8);
            this.likeBoxCountView.setVisibility(8);
            if ((this.likeViewStyle != LikeView.Style.STANDARD) || (this.likeActionController == null) || (Utility.isNullOrEmpty(this.likeActionController.getSocialSentence()))) {
                break label257;
            }
            localObject1 = this.socialSentenceView;
            label104:
            ((View) localObject1).setVisibility(0);
            ((LinearLayout.LayoutParams) ((View) localObject1).getLayoutParams()).gravity = i;
            localObject2 = this.containerView;
            i = j;
            if (this.auxiliaryViewPosition == LikeView.AuxiliaryViewPosition.INLINE) {
                i = 0;
            }
            ((LinearLayout) localObject2).setOrientation(i);
            if ((this.auxiliaryViewPosition != LikeView.AuxiliaryViewPosition.TOP) && ((this.auxiliaryViewPosition != LikeView.AuxiliaryViewPosition.INLINE) || (this.horizontalAlignment != LikeView.HorizontalAlignment.RIGHT))) {
                break label299;
            }
            this.containerView.removeView(this.likeButton);
            this.containerView.addView(this.likeButton);
        }
        for (; ; ) {
            switch (LikeView
            .2.$SwitchMap$com$facebook$widget$LikeView$AuxiliaryViewPosition[this.auxiliaryViewPosition.ordinal()])
            {
                default:
                    label257:
                    do {
                        return;
                        if (this.horizontalAlignment == LikeView.HorizontalAlignment.CENTER) {
                            i = 1;
                            break;
                        }
                        i = 5;
                        break;
                    }
                    while ((this.likeViewStyle != LikeView.Style.BOX_COUNT) || (this.likeActionController == null) || (Utility.isNullOrEmpty(this.likeActionController.getLikeCountString())));
                    updateBoxCountCaretPosition();
                    localObject1 = this.likeBoxCountView;
                    break label104;
                label299:
                this.containerView.removeView((View) localObject1);
                this.containerView.addView((View) localObject1);
            }
        }
        ((View) localObject1).setPadding(this.edgePadding, this.edgePadding, this.edgePadding, this.internalPadding);
        return;
        ((View) localObject1).setPadding(this.edgePadding, this.internalPadding, this.edgePadding, this.edgePadding);
        return;
        if (this.horizontalAlignment == LikeView.HorizontalAlignment.RIGHT) {
            ((View) localObject1).setPadding(this.edgePadding, this.edgePadding, this.internalPadding, this.edgePadding);
            return;
        }
        ((View) localObject1).setPadding(this.internalPadding, this.edgePadding, this.edgePadding, this.edgePadding);
    }

    private void updateLikeStateAndLayout() {
        if (this.likeActionController == null) {
            this.likeButton.setLikeState(false);
            this.socialSentenceView.setText(null);
            this.likeBoxCountView.setText(null);
        }
        for (; ; ) {
            updateLayout();
            return;
            this.likeButton.setLikeState(this.likeActionController.isObjectLiked());
            this.socialSentenceView.setText(this.likeActionController.getSocialSentence());
            this.likeBoxCountView.setText(this.likeActionController.getLikeCountString());
        }
    }

    public LikeView.OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    protected void onDetachedFromWindow() {
        setObjectId(null);
        super.onDetachedFromWindow();
    }

    public void setAuxiliaryViewPosition(LikeView.AuxiliaryViewPosition paramAuxiliaryViewPosition) {
        if (paramAuxiliaryViewPosition != null) {
        }
        for (; ; ) {
            if (this.auxiliaryViewPosition != paramAuxiliaryViewPosition) {
                this.auxiliaryViewPosition = paramAuxiliaryViewPosition;
                updateLayout();
            }
            return;
            paramAuxiliaryViewPosition = LikeView.AuxiliaryViewPosition.DEFAULT;
        }
    }

    public void setForegroundColor(int paramInt) {
        if (this.foregroundColor != paramInt) {
            this.socialSentenceView.setTextColor(paramInt);
        }
    }

    public void setHorizontalAlignment(LikeView.HorizontalAlignment paramHorizontalAlignment) {
        if (paramHorizontalAlignment != null) {
        }
        for (; ; ) {
            if (this.horizontalAlignment != paramHorizontalAlignment) {
                this.horizontalAlignment = paramHorizontalAlignment;
                updateLayout();
            }
            return;
            paramHorizontalAlignment = LikeView.HorizontalAlignment.DEFAULT;
        }
    }

    public void setLikeViewStyle(LikeView.Style paramStyle) {
        if (paramStyle != null) {
        }
        for (; ; ) {
            if (this.likeViewStyle != paramStyle) {
                this.likeViewStyle = paramStyle;
                updateLayout();
            }
            return;
            paramStyle = LikeView.Style.DEFAULT;
        }
    }

    public void setObjectId(String paramString) {
        paramString = Utility.coerceValueIfNullOrEmpty(paramString, null);
        if (!Utility.areObjectsEqual(paramString, this.objectId)) {
            setObjectIdForced(paramString);
            updateLikeStateAndLayout();
        }
    }

    public void setOnErrorListener(LikeView.OnErrorListener paramOnErrorListener) {
        this.onErrorListener = paramOnErrorListener;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/LikeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */