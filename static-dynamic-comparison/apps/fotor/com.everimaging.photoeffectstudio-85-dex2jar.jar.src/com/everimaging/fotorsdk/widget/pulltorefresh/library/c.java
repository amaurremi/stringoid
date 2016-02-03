package com.everimaging.fotorsdk.widget.pulltorefresh.library;

import android.annotation.TargetApi;
import android.view.View;

@TargetApi(9)
public final class c {
    public static void a(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat, boolean paramBoolean) {
        PullToRefreshBase.Mode localMode;
        switch (1. a[paramPullToRefreshBase.getPullToRefreshScrollDirection().ordinal()])
        {
            default:
                int i = paramPullToRefreshBase.getScrollY();
                paramInt2 = paramInt4;
                paramInt1 = paramInt3;
                paramInt3 = i;
                if ((paramPullToRefreshBase.h()) && (!paramPullToRefreshBase.i())) {
                    localMode = paramPullToRefreshBase.getMode();
                    if ((!localMode.permitsPullToRefresh()) || (paramBoolean) || (paramInt1 == 0)) {
                        break label213;
                    }
                    paramInt1 += paramInt2;
                    if (paramInt1 >= 0 - paramInt6) {
                        break label134;
                    }
                    if (localMode.showHeaderLoadingLayout()) {
                        if (paramInt3 == 0) {
                            paramPullToRefreshBase.a(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
                        }
                        paramPullToRefreshBase.setHeaderScroll((int) ((paramInt3 + paramInt1) * paramFloat));
                    }
                }
                break;
        }
        label134:
        label181:
        label213:
        while ((!paramBoolean) || (PullToRefreshBase.State.OVERSCROLLING != paramPullToRefreshBase.getState())) {
            do {
                do {
                    return;
                    paramInt3 = paramPullToRefreshBase.getScrollX();
                    break;
                    if (paramInt1 <= paramInt5 + paramInt6) {
                        break label181;
                    }
                } while (!localMode.showFooterLoadingLayout());
                if (paramInt3 == 0) {
                    paramPullToRefreshBase.a(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
                }
                paramPullToRefreshBase.setHeaderScroll((int) ((paramInt3 + paramInt1 - paramInt5) * paramFloat));
                return;
            } while ((Math.abs(paramInt1) > paramInt6) && (Math.abs(paramInt1 - paramInt5) > paramInt6));
            paramPullToRefreshBase.a(PullToRefreshBase.State.RESET, new boolean[0]);
            return;
        }
        paramPullToRefreshBase.a(PullToRefreshBase.State.RESET, new boolean[0]);
    }

    public static void a(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {
        a(paramPullToRefreshBase, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 0, 1.0F, paramBoolean);
    }

    public static void a(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
        a(paramPullToRefreshBase, paramInt1, paramInt2, paramInt3, paramInt4, 0, paramBoolean);
    }

    static boolean a(View paramView) {
        return paramView.getOverScrollMode() != 2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/pulltorefresh/library/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */