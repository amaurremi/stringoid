package mobi.ifunny.gallery.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.ButterKnife;

import java.util.ArrayList;
import java.util.List;

import mobi.ifunny.b.g;
import mobi.ifunny.k.m;
import mobi.ifunny.main.IFunnyMenuActivity;
import mobi.ifunny.main.a.b;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.IFunnyList;
import mobi.ifunny.rest.content.IFunnyMeanwhileFeed;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Feeds;
import mobi.ifunny.util.a.a;
import mobi.ifunny.util.ah;
import mobi.ifunny.util.cache.IFunnyCache.ListEntry;

public class aa
        extends f
        implements View.OnClickListener {
    private static final String c = aa.class.getSimpleName();
    private static boolean h = false;
    private m<ImageView, Bitmap> d;
    private mobi.ifunny.k.d e;
    private IFunnyList f;
    private List<View> g;

    private int a(View paramView) {
        for (paramView = paramView.getParent(); (paramView instanceof View); paramView = paramView.getParent()) {
            paramView = (View) paramView;
            int i = this.g.indexOf(paramView);
            if (i >= 0) {
                return i;
            }
        }
        return -1;
    }

    private void a(List<IFunny> paramList) {
        boolean bool = ah.c(getActivity());
        int j = Math.min(this.g.size(), paramList.size());
        int i = 0;
        while (i < j) {
            View localView = (View) this.g.get(i);
            IFunny localIFunny = (IFunny) paramList.get(i);
            ImageView localImageView = (ImageView) ButterKnife.findById(localView, 2131492972);
            a locala = new a(localIFunny.getThumbUrl(bool));
            this.d.a(localImageView, new mobi.ifunny.k.r(this.e, locala));
            if (localIFunny.isVideoContent()) {
                ((ImageView) ButterKnife.findById(localView, 2131493167)).setVisibility(0);
            }
            if (localIFunny.isGifContent()) {
                ((ImageView) ButterKnife.findById(localView, 2131493168)).setVisibility(0);
            }
            i += 1;
        }
    }

    private void n() {
        if (!f("TASK_REQUEST_MEANWHILE")) {
            mobi.ifunny.d.c(c, "requestMeanwhile");
            IFunnyRestRequest.Feeds.getMeanwhile(this, "TASK_REQUEST_MEANWHILE", 6, new ac(null));
        }
    }

    protected o a(Bundle paramBundle) {
        return null;
    }

    protected void a(IFunnyMeanwhileFeed paramIFunnyMeanwhileFeed) {
        this.f = paramIFunnyMeanwhileFeed.getContent();
        a(this.f.items);
    }

    protected void a(boolean paramBoolean) {
        super.a(paramBoolean);
        if ((paramBoolean) && (!h)) {
            g.a(getActivity(), "meanwhile_in_collective", "show");
            h = true;
        }
    }

    public boolean b() {
        return true;
    }

    public void onClick(View paramView) {
        if (this.f == null) {
        }
        int i;
        do {
            return;
            i = a(paramView);
        } while ((i < 0) || (i >= this.f.items.size()));
        paramView = new IFunnyCache.ListEntry();
        paramView.a(this.f);
        paramView.a = i;
        Intent localIntent = new Intent(getActivity(), IFunnyMenuActivity.class);
        localIntent.putExtra("intent.start_fragment", b.c);
        localIntent.putExtra("intent.start_data", paramView);
        localIntent.addFlags(67108864);
        startActivity(localIntent);
        g.a(getActivity(), "meanwhile_in_collective", "thumbnail_tap");
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.e = new mobi.ifunny.k.d();
        this.d = new m(4, 10000);
        this.d.a(new ab(this));
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903129, paramViewGroup, false);
        ButterKnife.inject(this, paramLayoutInflater);
        paramViewGroup = (ViewGroup) paramLayoutInflater;
        this.g = new ArrayList();
        int i = 0;
        while (i < paramViewGroup.getChildCount()) {
            Object localObject = paramViewGroup.getChildAt(i);
            if ((localObject instanceof ViewGroup)) {
                localObject = (ViewGroup) localObject;
                int j = 0;
                while (j < ((ViewGroup) localObject).getChildCount()) {
                    View localView = ((ViewGroup) localObject).getChildAt(j);
                    this.g.add(localView);
                    localView = localView.findViewById(2131492972);
                    localView.setOnClickListener(this);
                    localView.getBackground().setLevel(mobi.ifunny.util.r.b(1, 6));
                    j += 1;
                }
            }
            i += 1;
        }
        mobi.ifunny.d.c(c, "Finded " + this.g.size() + " meanwhile items");
        if (paramBundle == null) {
            n();
            return paramLayoutInflater;
        }
        this.f = ((IFunnyList) paramBundle.getParcelable("state.list"));
        if (this.f == null) {
            n();
            return paramLayoutInflater;
        }
        a(this.f.items);
        return paramLayoutInflater;
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
        this.g = null;
        this.d.b();
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putParcelable("state.list", this.f);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */