package com.quoord.tapatalkpro.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListItemRemoveAnimatorController {
    private long mAnimationTime = 0L;
    private DismissCallbacks mCallbacks = null;
    private int mDismissAnimationRefCount = 0;
    private ListView mListView = null;
    private List<PendingDismissData> mPendingDismisses = new ArrayList();

    public ListItemRemoveAnimatorController(ListView paramListView, DismissCallbacks paramDismissCallbacks) {
        this.mListView = paramListView;
        this.mCallbacks = paramDismissCallbacks;
        this.mAnimationTime = 200L;
    }

    private void performDismiss(final View paramView, int paramInt) {
        final ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
        final int i = paramView.getHeight();
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[]{i, 1}).setDuration(this.mAnimationTime);
        localValueAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator paramAnonymousAnimator) {
                super.onAnimationEnd(paramAnonymousAnimator);
                paramAnonymousAnimator = ListItemRemoveAnimatorController.this;
                paramAnonymousAnimator.mDismissAnimationRefCount -= 1;
                int i;
                if (ListItemRemoveAnimatorController.this.mDismissAnimationRefCount == 0) {
                    Collections.sort(ListItemRemoveAnimatorController.this.mPendingDismisses);
                    paramAnonymousAnimator = new int[ListItemRemoveAnimatorController.this.mPendingDismisses.size()];
                    i = ListItemRemoveAnimatorController.this.mPendingDismisses.size() - 1;
                    if (i >= 0) {
                        break label129;
                    }
                    ListItemRemoveAnimatorController.this.mCallbacks.onDismiss(ListItemRemoveAnimatorController.this.mListView, paramAnonymousAnimator);
                    paramAnonymousAnimator = ListItemRemoveAnimatorController.this.mPendingDismisses.iterator();
                }
                for (; ; ) {
                    if (!paramAnonymousAnimator.hasNext()) {
                        ListItemRemoveAnimatorController.this.mPendingDismisses.clear();
                        return;
                        label129:
                        paramAnonymousAnimator[i] = ((ListItemRemoveAnimatorController.PendingDismissData) ListItemRemoveAnimatorController.this.mPendingDismisses.get(i)).position;
                        i -= 1;
                        break;
                    }
                    ListItemRemoveAnimatorController.PendingDismissData localPendingDismissData = (ListItemRemoveAnimatorController.PendingDismissData) paramAnonymousAnimator.next();
                    localPendingDismissData.view.setAlpha(1.0F);
                    localPendingDismissData.view.setTranslationX(0.0F);
                    ViewGroup.LayoutParams localLayoutParams = localPendingDismissData.view.getLayoutParams();
                    localLayoutParams.height = i;
                    localPendingDismissData.view.setLayoutParams(localLayoutParams);
                }
            }
        });
        localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator) {
                localLayoutParams.height = ((Integer) paramAnonymousValueAnimator.getAnimatedValue()).intValue();
                paramView.setLayoutParams(localLayoutParams);
            }
        });
        this.mPendingDismisses.add(new PendingDismissData(paramInt, paramView));
        localValueAnimator.start();
    }

    public void removeItem(final View paramView, final int paramInt) {
        if (paramView == null) {
            paramView = new int[paramInt];
            this.mCallbacks.onDismiss(this.mListView, paramView);
            return;
        }
        this.mDismissAnimationRefCount += 1;
        paramView.animate().alpha(0.0F).setDuration(this.mAnimationTime).setListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator paramAnonymousAnimator) {
                super.onAnimationStart(paramAnonymousAnimator);
                ListItemRemoveAnimatorController.this.performDismiss(paramView, paramInt);
            }
        });
    }

    public void setAnimationTime(long paramLong) {
        this.mAnimationTime = paramLong;
    }

    public static abstract interface DismissCallbacks {
        public abstract void onDismiss(ListView paramListView, int[] paramArrayOfInt);
    }

    private class PendingDismissData
            implements Comparable<PendingDismissData> {
        public int position;
        public View view;

        public PendingDismissData(int paramInt, View paramView) {
            this.position = paramInt;
            this.view = paramView;
        }

        public int compareTo(PendingDismissData paramPendingDismissData) {
            return paramPendingDismissData.position - this.position;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ui/ListItemRemoveAnimatorController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */