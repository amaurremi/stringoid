package android.support.v7.internal.widget;

import android.content.Context;
import android.support.v7.b.c;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;

class x
        extends ListView {
    private boolean a;
    private boolean b;

    public x(Context paramContext, boolean paramBoolean) {
        super(paramContext, null, c.dropDownListViewStyle);
        this.b = paramBoolean;
        setCacheColorHint(0);
    }

    final int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        paramInt2 = getListPaddingTop();
        int i = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        paramInt3 = getDividerHeight();
        Object localObject = getDivider();
        ListAdapter localListAdapter = getAdapter();
        if (localListAdapter == null) {
            paramInt1 = paramInt2 + i;
            return paramInt1;
        }
        paramInt2 = i + paramInt2;
        label64:
        int j;
        label85:
        int m;
        if ((paramInt3 > 0) && (localObject != null)) {
            j = 0;
            localObject = null;
            int k = 0;
            int n = localListAdapter.getCount();
            i = 0;
            if (i >= n) {
                break label283;
            }
            m = localListAdapter.getItemViewType(i);
            if (m == k) {
                break label285;
            }
            localObject = null;
            k = m;
            label117:
            localObject = localListAdapter.getView(i, (View) localObject, this);
            ViewGroup.LayoutParams localLayoutParams = ((View) localObject).getLayoutParams();
            if ((localLayoutParams == null) || (localLayoutParams.height <= 0)) {
                break label237;
            }
            m = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
            label163:
            ((View) localObject).measure(paramInt1, m);
            if (i <= 0) {
                break label288;
            }
            paramInt2 += paramInt3;
        }
        label237:
        label283:
        label285:
        label288:
        for (; ; ) {
            paramInt2 += ((View) localObject).getMeasuredHeight();
            if (paramInt2 >= paramInt4) {
                paramInt1 = paramInt4;
                if (paramInt5 < 0) {
                    break;
                }
                paramInt1 = paramInt4;
                if (i <= paramInt5) {
                    break;
                }
                paramInt1 = paramInt4;
                if (j <= 0) {
                    break;
                }
                paramInt1 = paramInt4;
                if (paramInt2 == paramInt4) {
                    break;
                }
                return j;
                paramInt3 = 0;
                break label64;
                m = View.MeasureSpec.makeMeasureSpec(0, 0);
                break label163;
            }
            m = j;
            if (paramInt5 >= 0) {
                m = j;
                if (i >= paramInt5) {
                    m = paramInt2;
                }
            }
            i += 1;
            j = m;
            break label85;
            return paramInt2;
            break label117;
        }
    }

    public boolean hasFocus() {
        return (this.b) || (super.hasFocus());
    }

    public boolean hasWindowFocus() {
        return (this.b) || (super.hasWindowFocus());
    }

    public boolean isFocused() {
        return (this.b) || (super.isFocused());
    }

    public boolean isInTouchMode() {
        return ((this.b) && (this.a)) || (super.isInTouchMode());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */