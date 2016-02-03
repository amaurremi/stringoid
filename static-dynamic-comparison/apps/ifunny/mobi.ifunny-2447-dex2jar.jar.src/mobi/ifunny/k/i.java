package mobi.ifunny.k;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.ImageView;

public abstract class i<V extends Drawable, Req extends l<V>> {
    private int a;
    private int b;

    protected i(Context paramContext) {
        this.a = paramContext.getResources().getInteger(17694720);
        this.b = this.a;
    }

    public void a(int paramInt) {
        this.b = paramInt;
    }

    protected void a(ImageView paramImageView, Req paramReq, V paramV, boolean paramBoolean) {
    }

    protected void a(Req paramReq) {
    }

    protected abstract void a(Req paramReq, V paramV);

    protected abstract void a(Req paramReq, boolean paramBoolean);

    protected boolean a() {
        return false;
    }

    protected void b(Req paramReq) {
    }

    protected void b(Req paramReq, V paramV) {
    }

    protected boolean b() {
        return false;
    }

    protected void c(Req paramReq) {
        Animator localAnimator2 = d(paramReq);
        if ((!b()) || (paramReq.b() == null) || (paramReq.b() == paramReq.a())) {
        }
        for (Animator localAnimator1 = null; (localAnimator2 == null) && (localAnimator1 == null); localAnimator1 = e(paramReq)) {
            return;
        }
        if ((localAnimator1 == null) && (localAnimator2 != null)) {
            paramReq.a(localAnimator2);
            localAnimator2.start();
            return;
        }
        if ((localAnimator2 == null) && (localAnimator1 != null)) {
            paramReq.a(localAnimator1);
            localAnimator1.start();
            return;
        }
        AnimatorSet localAnimatorSet = new AnimatorSet();
        if (c()) {
            localAnimatorSet.playSequentially(new Animator[]{localAnimator2, localAnimator1});
        }
        for (; ; ) {
            paramReq.a(localAnimatorSet);
            localAnimatorSet.start();
            return;
            localAnimatorSet.playTogether(new Animator[]{localAnimator2, localAnimator1});
        }
    }

    protected boolean c() {
        return false;
    }

    public int d() {
        return this.a;
    }

    protected Animator d(Req paramReq) {
        ImageView localImageView = paramReq.a();
        localImageView.setAlpha(0.1F);
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localImageView, View.ALPHA, new float[]{1.0F});
        if (Build.VERSION.SDK_INT >= 18) {
            localObjectAnimator.setAutoCancel(true);
        }
        localObjectAnimator.setDuration(this.a);
        localObjectAnimator.addListener(new j(this, localImageView, paramReq));
        return localObjectAnimator;
    }

    protected Animator e(Req paramReq) {
        View localView = paramReq.b();
        localView.setAlpha(1.0F);
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localView, View.ALPHA, new float[]{0.0F});
        if (Build.VERSION.SDK_INT >= 18) {
            localObjectAnimator.setAutoCancel(true);
        }
        localObjectAnimator.setDuration(this.b);
        localObjectAnimator.addListener(new k(this, localView, paramReq));
        return localObjectAnimator;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/k/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */