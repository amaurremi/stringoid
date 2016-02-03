package mobi.ifunny.gallery.fragment;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.ab;
import android.support.v4.app.k;
import android.support.v4.app.q;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

import mobi.ifunny.comments.ah;
import mobi.ifunny.fragment.FragmentPage;
import mobi.ifunny.gallery.GalleryFragment;
import mobi.ifunny.gallery.view.GalleryItemFrameLayout;
import mobi.ifunny.rest.content.IFunny;

public abstract class f
        extends FragmentPage {
    protected static final String a = f.class.getSimpleName();
    protected IFunny b;
    private l c = l.a;
    private Animator d;
    private GalleryItemFrameLayout e;
    private GalleryItemFrameLayout f;
    private GalleryItemFrameLayout g;
    private o h;
    private IFunnyWorkInfoFragment i;
    private ah j;
    private m k;

    private String a(String paramString) {
        return paramString + this.b.uniqueId;
    }

    private void a(View paramView) {
        paramView.setTranslationX(0.0F);
        paramView.setTranslationY(0.0F);
    }

    private void n() {
        if (this.d != null) {
            this.d.removeAllListeners();
            this.d.cancel();
            this.d = null;
        }
    }

    private Animator o() {
        switch (k.b[this.c.ordinal()]) {
            default:
                return null;
            case 1:
                return p();
            case 2:
                return q();
            case 3:
                return r();
        }
        return s();
    }

    private Animator p() {
        AnimatorSet localAnimatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), 2131034124);
        localAnimatorSet.setTarget(this.e);
        Object localObject1 = localAnimatorSet.getChildAnimations().iterator();
        while (((Iterator) localObject1).hasNext()) {
            localObject2 = (Animator) ((Iterator) localObject1).next();
            if ((localObject2 instanceof ObjectAnimator)) {
                localObject2 = (ObjectAnimator) localObject2;
                if (TextUtils.equals(((ObjectAnimator) localObject2).getPropertyName(), "translationY")) {
                    ((ObjectAnimator) localObject2).setFloatValues(new float[]{0.0F, this.e.getMeasuredHeight()});
                }
            }
        }
        localObject1 = (AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), 2131034114);
        ((AnimatorSet) localObject1).setTarget(this.f);
        Object localObject2 = k();
        if (localObject2 != null) {
            ((GalleryFragment) localObject2).a(0.0F, true);
        }
        localObject2 = new AnimatorSet();
        ((AnimatorSet) localObject2).playTogether(new Animator[]{localAnimatorSet, localObject1});
        ((AnimatorSet) localObject2).addListener(new g(this));
        return (Animator) localObject2;
    }

    private Animator q() {
        AnimatorSet localAnimatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), 2131034124);
        localAnimatorSet.setTarget(this.f);
        Object localObject1 = localAnimatorSet.getChildAnimations().iterator();
        while (((Iterator) localObject1).hasNext()) {
            localObject2 = (Animator) ((Iterator) localObject1).next();
            if ((localObject2 instanceof ObjectAnimator)) {
                localObject2 = (ObjectAnimator) localObject2;
                if (TextUtils.equals(((ObjectAnimator) localObject2).getPropertyName(), "translationY")) {
                    ((ObjectAnimator) localObject2).setFloatValues(new float[]{0.0F, -this.f.getMeasuredHeight()});
                }
            }
        }
        localObject1 = (AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), 2131034114);
        ((AnimatorSet) localObject1).setTarget(this.e);
        Object localObject2 = k();
        if (localObject2 != null) {
            ((GalleryFragment) localObject2).a(1.0F, true);
        }
        localObject2 = new AnimatorSet();
        ((AnimatorSet) localObject2).playTogether(new Animator[]{localAnimatorSet, localObject1});
        ((AnimatorSet) localObject2).addListener(new h(this));
        return (Animator) localObject2;
    }

    private Animator r() {
        AnimatorSet localAnimatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), 2131034124);
        localAnimatorSet.setTarget(this.e);
        Object localObject1 = localAnimatorSet.getChildAnimations().iterator();
        while (((Iterator) localObject1).hasNext()) {
            localObject2 = (Animator) ((Iterator) localObject1).next();
            if ((localObject2 instanceof ObjectAnimator)) {
                localObject2 = (ObjectAnimator) localObject2;
                if (TextUtils.equals(((ObjectAnimator) localObject2).getPropertyName(), "translationY")) {
                    ((ObjectAnimator) localObject2).setFloatValues(new float[]{0.0F, -this.e.getMeasuredHeight()});
                }
            }
        }
        localObject1 = (AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), 2131034114);
        ((AnimatorSet) localObject1).setTarget(this.g);
        Object localObject2 = k();
        if (localObject2 != null) {
            ((GalleryFragment) localObject2).a(0.0F, true);
        }
        localObject2 = new AnimatorSet();
        ((AnimatorSet) localObject2).playTogether(new Animator[]{localAnimatorSet, localObject1});
        ((AnimatorSet) localObject2).addListener(new i(this));
        return (Animator) localObject2;
    }

    private Animator s() {
        AnimatorSet localAnimatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), 2131034124);
        localAnimatorSet.setTarget(this.g);
        Object localObject1 = localAnimatorSet.getChildAnimations().iterator();
        while (((Iterator) localObject1).hasNext()) {
            localObject2 = (Animator) ((Iterator) localObject1).next();
            if ((localObject2 instanceof ObjectAnimator)) {
                localObject2 = (ObjectAnimator) localObject2;
                if (TextUtils.equals(((ObjectAnimator) localObject2).getPropertyName(), "translationY")) {
                    ((ObjectAnimator) localObject2).setFloatValues(new float[]{0.0F, this.g.getMeasuredHeight()});
                }
            }
        }
        localObject1 = (AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), 2131034114);
        ((AnimatorSet) localObject1).setTarget(this.e);
        Object localObject2 = k();
        if (localObject2 != null) {
            ((GalleryFragment) localObject2).a(1.0F, true);
        }
        localObject2 = new AnimatorSet();
        ((AnimatorSet) localObject2).playTogether(new Animator[]{localAnimatorSet, localObject1});
        ((AnimatorSet) localObject2).addListener(new j(this));
        return (Animator) localObject2;
    }

    protected abstract o a(Bundle paramBundle);

    public void a(int paramInt) {
        if (b()) {
            return;
        }
        this.h.a(paramInt);
    }

    protected void a(boolean paramBoolean) {
        if (paramBoolean) {
            k().i(this.b);
        }
    }

    public void a(boolean paramBoolean1, boolean paramBoolean2) {
        if (b()) {
            return;
        }
        this.h.a(paramBoolean1, paramBoolean2);
    }

    protected IFunnyWorkInfoFragment b(Bundle paramBundle) {
        return IFunnyWorkInfoFragment.a(paramBundle);
    }

    public boolean b() {
        return false;
    }

    protected ah c(Bundle paramBundle) {
        return ah.a(paramBundle);
    }

    public m c() {
        return this.k;
    }

    public void d() {
        if ((this.c != l.a) || (this.k != m.a)) {
        }
        while (b()) {
            return;
        }
        this.i.b(false);
        this.k = m.c;
        this.e.setVisibility(0);
        this.f.setVisibility(0);
        this.g.setVisibility(8);
        this.c = l.b;
        this.d = o();
        this.d.start();
    }

    public void e() {
        if ((this.c != l.a) || (this.k != m.c)) {
        }
        while (b()) {
            return;
        }
        this.k = m.a;
        this.e.setVisibility(0);
        this.f.setVisibility(0);
        this.c = l.c;
        this.d = o();
        this.d.start();
    }

    public void f() {
        if ((this.c != l.a) || (this.k != m.a)) {
        }
        while (b()) {
            return;
        }
        this.k = m.b;
        this.e.setVisibility(0);
        this.f.setVisibility(8);
        this.g.setVisibility(0);
        this.j.b();
        this.c = l.d;
        this.d = o();
        this.d.start();
    }

    public void g() {
        if ((this.c != l.a) || (this.k != m.b)) {
        }
        while (b()) {
            return;
        }
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.g.getWindowToken(), 0);
        this.k = m.a;
        this.e.setVisibility(0);
        this.f.setVisibility(8);
        this.g.setVisibility(0);
        this.c = l.e;
        this.d = o();
        this.d.start();
    }

    public void h() {
        n();
        this.k = m.a;
        this.e.setVisibility(0);
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.h.b();
        a(this.g);
        a(this.f);
        this.c = l.a;
        this.i.setUserVisibleHint(false);
        this.j.setUserVisibleHint(false);
        this.h.setUserVisibleHint(getUserVisibleHint());
    }

    public void i() {
        if (!f("task.save")) {
            Toast.makeText(getActivity(), 2131689634, 0).show();
            new n(this, "task.save", this.b).execute(new Void[0]);
        }
    }

    public final IFunny j() {
        return this.b;
    }

    public final GalleryFragment k() {
        return (GalleryFragment) getParentFragment();
    }

    public IFunnyWorkInfoFragment l() {
        return this.i;
    }

    public ah m() {
        return this.j;
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getArguments();
        this.b = ((IFunny) paramBundle.getParcelable("arg.content"));
        paramBundle = (Bundle) paramBundle.getParcelable("arg.option.args");
        if (paramBundle != null) {
            this.k = ((m) paramBundle.getSerializable("arg.origin.flipState"));
        }
        if (this.k == null) {
            this.k = m.a;
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = (ViewGroup) paramLayoutInflater.inflate(2130903123, paramViewGroup, false);
        paramViewGroup = (GalleryFragment) getParentFragment();
        this.e = ((GalleryItemFrameLayout) paramLayoutInflater.findViewById(2131493145));
        this.e.setSwipeListener(paramViewGroup);
        this.e.setTapListener(paramViewGroup);
        this.f = ((GalleryItemFrameLayout) paramLayoutInflater.findViewById(2131493146));
        this.f.setSwipeListener(paramViewGroup);
        this.g = ((GalleryItemFrameLayout) paramLayoutInflater.findViewById(2131493147));
        this.g.setSwipeListener(paramViewGroup);
        return paramLayoutInflater;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDestroyView() {
        super.onDestroyView();
        n();
        if (this.e != null) {
            this.e.setSwipeListener(null);
            this.e.setTapListener(null);
        }
        if (this.f != null) {
            this.f.setSwipeListener(null);
        }
        if (this.g != null) {
            this.g.setSwipeListener(null);
        }
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        if (b()) {
            return;
        }
        paramBundle.putSerializable("STATE_FLIPPED", this.k);
    }

    public void onViewStateRestored(Bundle paramBundle) {
        boolean bool2 = true;
        super.onViewStateRestored(paramBundle);
        if (b()) {
            return;
        }
        q localq = getChildFragmentManager();
        if (paramBundle != null) {
            this.k = ((m) paramBundle.getSerializable("STATE_FLIPPED"));
        }
        this.i = ((IFunnyWorkInfoFragment) localq.a(a("COVER_TAG")));
        this.h = ((o) localq.a(a("CONTENT_TAG")));
        this.j = ((ah) localq.a(a("COMMENTS_TAG")));
        if ((this.h == null) || (this.i == null) || (this.j == null)) {
            paramBundle = localq.a();
            if (this.h == null) {
                this.h = a(getArguments());
                paramBundle.a(2131493145, this.h, a("CONTENT_TAG"));
            }
            if (this.i == null) {
                this.i = b(getArguments());
                paramBundle.a(2131493146, this.i, a("COVER_TAG"));
            }
            if (this.j == null) {
                this.j = c(getArguments());
                paramBundle.a(2131493147, this.j, a("COMMENTS_TAG"));
            }
            paramBundle.b();
            localq.b();
        }
        paramBundle = k();
        switch (k.a[this.k.ordinal()]) {
            default:
                paramBundle = this.h;
                if ((getUserVisibleHint()) && (this.k == m.a)) {
                    bool1 = true;
                    label316:
                    paramBundle.setUserVisibleHint(bool1);
                    paramBundle = this.i;
                    if ((!getUserVisibleHint()) || (this.k != m.c)) {
                        break label511;
                    }
                    bool1 = true;
                    label345:
                    paramBundle.setUserVisibleHint(bool1);
                    paramBundle = this.j;
                    if ((!getUserVisibleHint()) || (this.k != m.b)) {
                        break label516;
                    }
                }
                break;
        }
        label511:
        label516:
        for (boolean bool1 = bool2; ; bool1 = false) {
            paramBundle.setUserVisibleHint(bool1);
            return;
            this.f.setVisibility(0);
            this.e.setVisibility(8);
            this.g.setVisibility(8);
            if (!getUserVisibleHint()) {
                break;
            }
            paramBundle.a(0.0F, false);
            break;
            this.f.setVisibility(8);
            this.e.setVisibility(0);
            this.g.setVisibility(8);
            if (!getUserVisibleHint()) {
                break;
            }
            paramBundle.a(1.0F, false);
            break;
            this.f.setVisibility(8);
            this.e.setVisibility(8);
            this.g.setVisibility(0);
            if (!getUserVisibleHint()) {
                break;
            }
            paramBundle.a(0.0F, false);
            break;
            bool1 = false;
            break label316;
            bool1 = false;
            break label345;
        }
    }

    public void setUserVisibleHint(boolean paramBoolean) {
        boolean bool2 = true;
        super.setUserVisibleHint(paramBoolean);
        if (b()) {
        }
        boolean bool1;
        label79:
        do {
            return;
            if (this.h != null) {
                localObject = this.h;
                if ((!paramBoolean) || (this.k != m.a)) {
                    break;
                }
                bool1 = true;
                ((o) localObject).setUserVisibleHint(bool1);
            }
            if (this.i != null) {
                localObject = this.i;
                if ((!paramBoolean) || (this.k != m.c)) {
                    break label126;
                }
                bool1 = true;
                ((IFunnyWorkInfoFragment) localObject).setUserVisibleHint(bool1);
            }
        } while (this.j == null);
        Object localObject = this.j;
        if ((paramBoolean) && (this.k == m.b)) {
        }
        for (paramBoolean = bool2; ; paramBoolean = false) {
            ((ah) localObject).setUserVisibleHint(paramBoolean);
            return;
            bool1 = false;
            break;
            label126:
            bool1 = false;
            break label79;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */