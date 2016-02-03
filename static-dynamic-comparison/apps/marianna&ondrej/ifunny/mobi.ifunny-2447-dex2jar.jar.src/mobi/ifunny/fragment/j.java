package mobi.ifunny.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ab;
import android.support.v4.app.g;
import android.support.v4.app.q;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.b.a.a.a.a;

import java.util.ArrayList;

import mobi.ifunny.profile.editor.cover.ChooseCoverActivity;
import mobi.ifunny.rest.content.MemeSource;
import mobi.ifunny.rest.content.WebImage;
import mobi.ifunny.social.auth.w;
import mobi.ifunny.studio.meme.MemeSourceActivity;
import mobi.ifunny.studio.source.WebSearchActivity;
import mobi.ifunny.util.ai;
import mobi.ifunny.util.an;
import mobi.ifunny.util.n;

public class j
        extends g
        implements AdapterView.OnItemClickListener, w {
    private static final int[] j = {2131690131, 2131689822, 2131689826, 2131689824, 2131690079, 2131689806, 2131690072, 2131689819, 2131689803};
    private k k;
    private ArrayList<Integer> l;
    private int m;
    private int n;

    public static i a(ArrayList<Integer> paramArrayList, int paramInt1, int paramInt2) {
        Bundle localBundle = new Bundle();
        localBundle.putIntegerArrayList("arg.sources", paramArrayList);
        localBundle.putInt("arg.request.code", paramInt1);
        localBundle.putInt("arg.dialog.title.id", paramInt2);
        paramArrayList = new i();
        paramArrayList.setArguments(localBundle);
        return paramArrayList;
    }

    private void d() {
        q localq = getFragmentManager();
        ab localab = localq.a();
        Fragment localFragment = getFragmentManager().a("TAG_FACEBOOK_AVATAR");
        if (localFragment != null) {
            localab.a(localFragment);
        }
        localFragment = getFragmentManager().a("TAG_TWITTER_AVATAR");
        if (localFragment != null) {
            localab.a(localFragment);
        }
        localFragment = getFragmentManager().a("TAG_GPLUS_AVATAR");
        if (localFragment != null) {
            localab.a(localFragment);
        }
        localab.c();
        localq.b();
    }

    public Dialog a(Bundle paramBundle) {
        paramBundle = new AlertDialog.Builder(getActivity());
        paramBundle.setTitle(this.n);
        Resources localResources = getResources();
        int i1 = this.l.size();
        String[] arrayOfString = new String[i1];
        int i = 0;
        while (i < i1) {
            arrayOfString[i] = localResources.getString(j[((Integer) this.l.get(i)).intValue()]);
            i += 1;
        }
        paramBundle.setItems(arrayOfString, null);
        paramBundle = paramBundle.create();
        paramBundle.getListView().setOnItemClickListener(this);
        return paramBundle;
    }

    protected void a(int paramInt) {
        Object localObject;
        switch (paramInt) {
            case 3:
            default:
                return;
            case 0:
                startActivityForResult(a.a(), 0);
                return;
            case 1:
                localObject = (mobi.ifunny.social.auth.a.c) n.a(getActivity(), getFragmentManager(), "TAG_FACEBOOK_AVATAR", mobi.ifunny.social.auth.a.c.class);
                ((mobi.ifunny.social.auth.a.c) localObject).setTargetFragment(this, paramInt);
                ((mobi.ifunny.social.auth.a.c) localObject).o();
                return;
            case 2:
                localObject = (mobi.ifunny.social.auth.d.c) n.a(getActivity(), getFragmentManager(), "TAG_TWITTER_AVATAR", mobi.ifunny.social.auth.d.c.class);
                ((mobi.ifunny.social.auth.d.c) localObject).setTargetFragment(this, paramInt);
                ((mobi.ifunny.social.auth.d.c) localObject).o();
                return;
            case 4:
                localObject = new Intent(getActivity(), WebSearchActivity.class);
                ((Intent) localObject).putExtra("intent.search_type", "pic");
                startActivityForResult((Intent) localObject, 4);
                return;
            case 5:
                startActivityForResult(new Intent(getActivity(), ChooseCoverActivity.class), 5);
                return;
            case 6:
                startActivityForResult(new Intent(getActivity(), MemeSourceActivity.class), 6);
                return;
        }
        if (this.k != null) {
            this.k.a(this.m);
        }
        a();
    }

    public void a(int paramInt, Uri paramUri) {
        d();
        if (this.k != null) {
            this.k.a(this.m, paramInt, paramUri);
        }
        a();
    }

    public void a(int paramInt, String paramString1, String paramString2) {
        d();
        if (paramInt == 1) {
            ai.a(getActivity(), paramString2, getString(2131689931));
        }
        for (; ; ) {
            a();
            return;
            if (paramInt == 2) {
                ai.a(getActivity(), paramString2, getString(2131689948));
            }
        }
    }

    public void b(int paramInt) {
        d();
        a();
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        switch (paramInt1) {
            case 1:
            case 2:
            case 3:
            default:
                super.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
        for (; ; ) {
            a();
            return;
            if ((paramInt2 == -1) && (paramIntent != null)) {
                paramIntent = an.a(paramIntent);
                if ((paramIntent != null) && (this.k != null)) {
                    this.k.a(this.m, paramInt1, paramIntent);
                    continue;
                    if ((paramInt2 == -1) && (paramIntent != null)) {
                        paramIntent = (WebImage) paramIntent.getParcelableExtra("intent.web_image");
                        if (paramIntent != null) {
                            paramIntent = Uri.parse(paramIntent.url);
                            if (this.k != null) {
                                this.k.a(this.m, paramInt1, paramIntent);
                                continue;
                                if ((paramInt2 == -1) && (paramIntent != null)) {
                                    paramIntent = (MemeSource) paramIntent.getParcelableExtra("intent.meme_source");
                                    if ((paramIntent != null) && (this.k != null)) {
                                        this.k.a(this.m, paramIntent);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void onAttach(Activity paramActivity) {
        super.onAttach(paramActivity);
        try {
            if ((paramActivity instanceof k)) {
                this.k = ((k) paramActivity);
                return;
            }
            if ((getTargetFragment() != null) && ((getTargetFragment() instanceof k))) {
                this.k = ((k) getTargetFragment());
                return;
            }
        } catch (ClassCastException paramActivity) {
            throw new IllegalStateException(paramActivity);
        }
        if ((getParentFragment() instanceof k)) {
            this.k = ((k) getParentFragment());
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getArguments();
        this.l = paramBundle.getIntegerArrayList("arg.sources");
        this.m = paramBundle.getInt("arg.request.code");
        this.n = paramBundle.getInt("arg.dialog.title.id");
    }

    public void onDetach() {
        super.onDetach();
        this.k = null;
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        a(((Integer) this.l.get(paramInt)).intValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/fragment/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */