package mobi.ifunny.studio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.OnClick;

import java.util.Map;

import mobi.ifunny.b.g;
import mobi.ifunny.main.i;
import mobi.ifunny.social.auth.AuthActivity;
import mobi.ifunny.util.r;

public class StudioFragment
        extends i {
    private static final String a = StudioFragment.class.getSimpleName();
    private static final SparseArray<String> b = new l();
    private static final SparseArray<Class<? extends Activity>> c = new m();
    private static final Map<String, Class<? extends Activity>> d = new n();

    private Bundle a(String paramString) {
        Bundle localBundle = new Bundle();
        localBundle.putString("auth.action", paramString);
        return localBundle;
    }

    private void a(Bundle paramBundle) {
        Intent localIntent = new Intent(getActivity(), AuthActivity.class);
        localIntent.putExtra("intent.callback.params", paramBundle);
        startActivityForResult(localIntent, 0);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        switch (paramInt1) {
            default:
                super.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
        do {
            do {
                return;
            } while ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.hasExtra("auth.action")));
            paramIntent = paramIntent.getStringExtra("auth.action");
            paramIntent = (Class) d.get(paramIntent);
        } while (paramIntent == null);
        startActivity(new Intent(getActivity(), paramIntent));
    }

    @OnClick({2131493304, 2131493305, 2131493306, 2131493307, 2131493310, 2131493309, 2131493311})
    public void onClick(View paramView) {
        int i = paramView.getId();
        paramView = getActivity();
        Class localClass;
        if (r.a()) {
            localClass = (Class) c.get(i);
            if (localClass != null) {
            }
        }
        do {
            return;
            startActivity(new Intent(paramView, localClass));
            return;
            paramView = (String) b.get(i);
        } while (paramView == null);
        a(a(paramView));
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setHasOptionsMenu(true);
        if (paramBundle == null) {
            g.a(getActivity(), "Studio");
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903165, paramViewGroup, false);
        ButterKnife.inject(this, paramLayoutInflater);
        return paramLayoutInflater;
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/StudioFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */