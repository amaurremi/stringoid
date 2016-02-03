package mobi.ifunny.intro;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.support.v4.view.ViewPager;
import android.support.v4.view.cg;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

import java.util.ArrayList;

import mobi.ifunny.h;

public class IntroFragment
        extends g {
    @InjectView(2131493155)
    protected TextView introBottomText;
    @InjectView(2131493154)
    protected ViewGroup introMainText;
    @InjectView(2131493153)
    protected ImageView introSmile;
    private AnimatorSet j;
    private AnimatorSet k;
    private cg l = new c(this);

    public static IntroFragment d() {
        Bundle localBundle = new Bundle();
        IntroFragment localIntroFragment = new IntroFragment();
        localIntroFragment.setArguments(localBundle);
        return localIntroFragment;
    }

    private void e() {
        h.a().b("pref.intro.was.shown", true);
        a();
    }

    public void onCancel(DialogInterface paramDialogInterface) {
        getActivity().onBackPressed();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        a(1, 2131755188);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramViewGroup = paramLayoutInflater.inflate(2130903125, paramViewGroup, true);
        paramBundle = (ViewPager) paramViewGroup.findViewById(2131493151);
        paramBundle.setOnPageChangeListener(this.l);
        View localView = paramLayoutInflater.inflate(2130903127, paramBundle, false);
        paramLayoutInflater = paramLayoutInflater.inflate(2130903126, paramBundle, false);
        ButterKnife.inject(this, localView);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localView);
        localArrayList.add(paramLayoutInflater);
        paramBundle.setAdapter(new d(this, localArrayList));
        this.j = ((AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), 2131034115));
        this.j.setTarget(this.introSmile);
        this.j.addListener(new a(this));
        this.j.start();
        this.introMainText.animate().setStartDelay(200L).setDuration(100L).alpha(1.0F).start();
        this.introBottomText.animate().setStartDelay(400L).setDuration(400L).alpha(1.0F).start();
        this.k = new AnimatorSet();
        this.k.playSequentially(new Animator[]{ObjectAnimator.ofFloat(localView, "translationX", new float[]{0.0F, -50.0F}).setDuration(250L), ObjectAnimator.ofFloat(localView, "translationX", new float[]{-50.0F, 0.0F}).setDuration(100L), ObjectAnimator.ofFloat(localView, "translationX", new float[]{0.0F, -10.0F}).setDuration(50L), ObjectAnimator.ofFloat(localView, "translationX", new float[]{-10.0F, 0.0F}).setDuration(20L)});
        this.k.setStartDelay(3000L);
        this.k.addListener(new b(this));
        this.k.start();
        return paramViewGroup;
    }

    public void onDetach() {
        super.onDetach();
        this.j.cancel();
        this.j.removeAllListeners();
        this.k.cancel();
        this.k.removeAllListeners();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/intro/IntroFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */