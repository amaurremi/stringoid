package mobi.ifunny.view;

import android.support.v4.view.bd;

import java.util.concurrent.atomic.AtomicBoolean;

class w
        implements Runnable {
    private w(ProgressBar paramProgressBar) {
    }

    public void run() {
        if ((!ProgressBar.a(this.a).get()) && (this.a.getVisibility() == 0) && (this.a.getWindowVisibility() == 0)) {
            ProgressBar.a(this.a, (ProgressBar.b(this.a) + 4) % 360);
            bd.c(this.a);
            this.a.postDelayed(this, 25L);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */