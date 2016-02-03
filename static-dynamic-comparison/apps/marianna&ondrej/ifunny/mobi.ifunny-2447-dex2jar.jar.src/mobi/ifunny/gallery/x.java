package mobi.ifunny.gallery;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.widget.ImageView;

public class x {
    private final ImageView a;
    private AnimatorSet b;
    private AnimatorSet c;
    private AnimatorSet d;
    private AnimatorSet e;
    private AnimatorSet f;
    private AnimatorSet g;

    public x(Context paramContext, ImageView paramImageView) {
        this.a = paramImageView;
        if (Build.VERSION.SDK_INT >= 19) {
            paramImageView = new Paint(3);
            this.a.setLayerType(1, paramImageView);
        }
        paramImageView = AnimatorInflater.loadAnimator(paramContext, 2131034116);
        paramImageView.setTarget(this.a);
        paramImageView.addListener(new y(this));
        Animator localAnimator = AnimatorInflater.loadAnimator(paramContext, 2131034117);
        localAnimator.setTarget(this.a);
        localAnimator.addListener(new z(this));
        this.b = new AnimatorSet();
        this.b.playSequentially(new Animator[]{paramImageView, localAnimator});
        this.c = ((AnimatorSet) AnimatorInflater.loadAnimator(paramContext, 2131034118));
        this.c.setTarget(this.a);
        this.c.addListener(new aa(this));
        paramImageView = AnimatorInflater.loadAnimator(paramContext, 2131034116);
        paramImageView.setTarget(this.a);
        paramImageView.addListener(new ab(this));
        localAnimator = AnimatorInflater.loadAnimator(paramContext, 2131034117);
        localAnimator.setTarget(this.a);
        localAnimator.addListener(new ac(this));
        this.d = new AnimatorSet();
        this.d.playSequentially(new Animator[]{paramImageView, localAnimator});
        this.e = ((AnimatorSet) AnimatorInflater.loadAnimator(paramContext, 2131034118));
        this.e.setTarget(this.a);
        this.e.addListener(new ad(this));
        paramImageView = AnimatorInflater.loadAnimator(paramContext, 2131034116);
        paramImageView.setTarget(this.a);
        paramImageView.addListener(new ae(this));
        localAnimator = AnimatorInflater.loadAnimator(paramContext, 2131034117);
        localAnimator.setTarget(this.a);
        localAnimator.addListener(new af(this));
        this.f = new AnimatorSet();
        this.f.playSequentially(new Animator[]{paramImageView, localAnimator});
        this.g = ((AnimatorSet) AnimatorInflater.loadAnimator(paramContext, 2131034118));
        this.g.setTarget(this.a);
        this.g.addListener(new ag(this));
    }

    private void h() {
        this.a.setVisibility(4);
    }

    private void i() {
        this.b.cancel();
        this.c.cancel();
        this.d.cancel();
        this.e.cancel();
        this.f.cancel();
        this.g.cancel();
    }

    public void a() {
        i();
        this.b.start();
    }

    public void b() {
        i();
        this.c.start();
    }

    public void c() {
        i();
        this.d.start();
    }

    public void d() {
        i();
        this.e.start();
    }

    public void e() {
        i();
        this.f.start();
    }

    public void f() {
        i();
        this.g.start();
    }

    public void g() {
        if (this.b != null) {
            this.b.removeAllListeners();
            this.b.cancel();
            this.b = null;
        }
        if (this.c != null) {
            this.c.removeAllListeners();
            this.c.cancel();
            this.c = null;
        }
        if (this.d != null) {
            this.d.removeAllListeners();
            this.d.cancel();
            this.d = null;
        }
        if (this.e != null) {
            this.e.removeAllListeners();
            this.e.cancel();
            this.e = null;
        }
        if (this.f != null) {
            this.f.removeAllListeners();
            this.f.cancel();
            this.f = null;
        }
        if (this.g != null) {
            this.g.removeAllListeners();
            this.g.cancel();
            this.g = null;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */