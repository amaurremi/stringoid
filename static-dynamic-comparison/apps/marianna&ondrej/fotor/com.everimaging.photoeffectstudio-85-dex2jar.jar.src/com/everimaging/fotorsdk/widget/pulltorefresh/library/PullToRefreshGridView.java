package com.everimaging.fotorsdk.widget.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.everimaging.fotorsdk.R.id;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.internal.a;

public class PullToRefreshGridView
        extends d<GridView> {
    public PullToRefreshGridView(Context paramContext) {
        super(paramContext);
    }

    public PullToRefreshGridView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public PullToRefreshGridView(Context paramContext, PullToRefreshBase.Mode paramMode) {
        super(paramContext, paramMode);
    }

    public PullToRefreshGridView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle) {
        super(paramContext, paramMode, paramAnimationStyle);
    }

    protected final GridView b(Context paramContext, AttributeSet paramAttributeSet) {
        if (Build.VERSION.SDK_INT >= 9) {
        }
        for (paramContext = new b(paramContext, paramAttributeSet); ; paramContext = new a(paramContext, paramAttributeSet)) {
            paramContext.setId(R.id.fotor_ptr_gridview);
            return paramContext;
        }
    }

    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        return PullToRefreshBase.Orientation.VERTICAL;
    }

    class a
            extends GridView
            implements a {
        public a(Context paramContext, AttributeSet paramAttributeSet) {
            super(paramAttributeSet);
        }

        public void setEmptyView(View paramView) {
            PullToRefreshGridView.this.setEmptyView(paramView);
        }

        public void setEmptyViewInternal(View paramView) {
            super.setEmptyView(paramView);
        }
    }

    @TargetApi(9)
    final class b
            extends PullToRefreshGridView.a {
        public b(Context paramContext, AttributeSet paramAttributeSet) {
            super(paramContext, paramAttributeSet);
        }

        protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean) {
            boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
            c.a(PullToRefreshGridView.this, paramInt1, paramInt3, paramInt2, paramInt4, paramBoolean);
            return bool;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/pulltorefresh/library/PullToRefreshGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */