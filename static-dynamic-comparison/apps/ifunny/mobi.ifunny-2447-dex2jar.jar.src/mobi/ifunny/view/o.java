package mobi.ifunny.view;

import android.graphics.Matrix;
import android.support.v4.view.bd;
import android.widget.Scroller;

class o
        implements Runnable {
    o(PinchImageView paramPinchImageView) {
    }

    public void run() {
        if (PinchImageView.a(this.a).isFinished()) {
        }
        boolean bool;
        do {
            return;
            bool = PinchImageView.a(this.a).computeScrollOffset();
            int i = PinchImageView.a(this.a).getCurrX();
            int j = PinchImageView.a(this.a).getCurrY();
            PinchImageView.i(this.a).getValues(PinchImageView.j(this.a));
            float f1 = PinchImageView.j(this.a)[2];
            float f2 = PinchImageView.j(this.a)[5];
            PinchImageView.i(this.a).postTranslate(i - f1, j - f2);
            this.a.setImageMatrix(PinchImageView.i(this.a));
        } while (!bool);
        bd.a(this.a, this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */