package mobi.ifunny.studio.comics.view;

import android.util.Pair;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import mobi.ifunny.view.a.a;

class e
        extends GestureDetector.SimpleOnGestureListener {
    private e(HorizontalAdapterView paramHorizontalAdapterView) {
    }

    public boolean onDown(MotionEvent paramMotionEvent) {
        HorizontalAdapterView.a(this.a, 0);
        this.a.a.a(true);
        return true;
    }

    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
        if ((HorizontalAdapterView.a(this.a)) && (this.a.getChildCount() > 0)) {
            HorizontalAdapterView.b(this.a, 0);
            if (paramFloat1 <= 'ߐ') {
                break label97;
            }
            paramFloat1 = 'ߐ';
            if (paramFloat1 >= -'ߐ') {
                break label100;
            }
            paramFloat1 = -'ߐ';
        }
        label97:
        label100:
        for (; ; ) {
            this.a.a.a(0, 0, (int) -paramFloat1, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            this.a.invalidate();
            this.a.requestLayout();
            return true;
            break;
        }
    }

    public void onLongPress(MotionEvent paramMotionEvent) {
        int j = this.a.getChildCount();
        int i = 0;
        for (; ; ) {
            if (i < j) {
                View localView = this.a.getChildAt(i);
                if (!HorizontalAdapterView.a(this.a, paramMotionEvent, localView)) {
                }
            } else {
                return;
            }
            i += 1;
        }
    }

    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
        if (HorizontalAdapterView.a(this.a)) {
            HorizontalAdapterView.c(this.a, (int) paramFloat1);
            this.a.invalidate();
            this.a.requestLayout();
        }
        return true;
    }

    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent) {
        int i = 0;
        for (; ; ) {
            View localView;
            Object localObject;
            if (i < this.a.getChildCount()) {
                localView = this.a.getChildAt(i);
                if (!HorizontalAdapterView.a(this.a, paramMotionEvent, localView)) {
                    break label170;
                }
                paramMotionEvent = this.a.getOnItemClickListener();
                if (paramMotionEvent != null) {
                    localObject = HorizontalAdapterView.c(this.a).a(localView, HorizontalAdapterView.b(this.a));
                    i = -1;
                    if (localObject != null) {
                        i = ((Integer) ((Pair) localObject).first).intValue();
                        int j = ((Integer) ((Pair) localObject).second).intValue();
                        i = HorizontalAdapterView.d(this.a)[i] + (j + 1) * HorizontalAdapterView.b(this.a);
                    }
                    localObject = this.a;
                    if (i >= 0) {
                        break label152;
                    }
                }
            }
            label152:
            for (long l = -1L; ; l = HorizontalAdapterView.e(this.a).getItemId(i)) {
                paramMotionEvent.onItemClick((AdapterView) localObject, localView, i, l);
                return true;
            }
            label170:
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/view/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */