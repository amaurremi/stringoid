package mobi.ifunny.userlists;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import butterknife.ButterKnife;

import java.util.List;

import mobi.ifunny.gallery.GalleryActivity;
import mobi.ifunny.gallery.e;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.content.UserFeed;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Subscriptions;
import mobi.ifunny.social.auth.AuthActivity;
import mobi.ifunny.social.auth.l;
import mobi.ifunny.util.v;
import mobi.ifunny.view.DynamicListView;
import mobi.ifunny.view.a;
import uk.co.a.a.a.a.c;
import uk.co.a.a.b.a.b;

public abstract class g<T extends UserFeed>
        extends e<User, T>
        implements View.OnClickListener, a, b {
    protected int a;
    private int b;
    private c c;

    private int a(List<User> paramList, String paramString) {
        int j = paramList.size();
        int i = 0;
        while (i < j) {
            if (TextUtils.equals(((User) paramList.get(i)).id, paramString)) {
                return i;
            }
            i += 1;
        }
        return -1;
    }

    private Bundle a(String paramString1, String paramString2) {
        Bundle localBundle = new Bundle();
        localBundle.putString("auth.action", paramString1);
        localBundle.putString("auth.uid", paramString2);
        return localBundle;
    }

    private void a(String paramString) {
        IFunnyRestRequest.Subscriptions.subscribeUser(this, "rest.subscribeUser", paramString, new i(paramString, null));
    }

    private void b(String paramString) {
        int i = a(((UserFeed) B()).getList(), paramString);
        ((User) ((UserFeed) B()).getList().get(i)).is_in_subscriptions = true;
        paramString = c(i);
        if (paramString != null) {
            paramString.b();
        }
    }

    private UserListAdapter.ViewHolder c(int paramInt) {
        View localView = this.g.a(paramInt);
        if (localView == null) {
            return null;
        }
        return (UserListAdapter.ViewHolder) localView.getTag();
    }

    private void c(Bundle paramBundle) {
        Intent localIntent = new Intent(getActivity(), AuthActivity.class);
        localIntent.putExtra("intent.callback.params", paramBundle);
        startActivityForResult(localIntent, 0);
    }

    private void c(String paramString) {
        int i = a(((UserFeed) B()).getList(), paramString);
        paramString = (User) ((UserFeed) B()).getList().get(i);
        paramString.is_in_subscriptions = false;
        UserListAdapter.ViewHolder localViewHolder = c(i);
        if (localViewHolder != null) {
            localViewHolder.a(paramString.is_banned);
        }
    }

    private void g(String paramString) {
        IFunnyRestRequest.Subscriptions.unsubscribeUser(this, "rest.unsubscribeUser", paramString, new j(paramString, null));
    }

    private void h(String paramString) {
        int i = a(((UserFeed) B()).getList(), paramString);
        paramString = (User) ((UserFeed) B()).getList().get(i);
        paramString.is_in_subscriptions = false;
        UserListAdapter.ViewHolder localViewHolder = c(i);
        if (localViewHolder != null) {
            localViewHolder.a(paramString.is_banned);
        }
    }

    private void i(String paramString) {
        int i = a(((UserFeed) B()).getList(), paramString);
        ((User) ((UserFeed) B()).getList().get(i)).is_in_subscriptions = true;
        paramString = c(i);
        if (paramString != null) {
            paramString.b();
        }
    }

    protected final void D() {
        super.D();
        if (f(q())) {
            this.c.a(true);
        }
    }

    protected abstract void a(int paramInt);

    protected void a(int paramInt, T paramT) {
        super.a(paramInt, paramT);
        if ((paramT != null) && (paramInt == 0)) {
            this.a = paramT.getUsersCount();
            a(this.a);
        }
    }

    protected void a(AdapterView<?> paramAdapterView, View paramView, int paramInt) {
    }

    protected void a(T paramT) {
        super.a(paramT);
        if (paramT != null) {
            this.a = paramT.getUsersCount();
            a(this.a);
        }
    }

    protected UserListAdapter<T> b() {
        return new UserListAdapter(N(), this);
    }

    public void b(int paramInt) {
        this.a = paramInt;
    }

    protected UserListAdapter<T> c() {
        return (UserListAdapter) super.i();
    }

    protected int o() {
        return this.b;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.b = getResources().getInteger(2131558431);
        paramBundle = new uk.co.a.a.b.f();
        paramBundle.a(0.85F);
        paramBundle.a();
        this.c = new c(getActivity(), paramBundle.b());
        this.c.a(this);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        int i = -1;
        switch (paramInt1) {
            default:
                super.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
        do {
            return;
        } while ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.hasExtra("auth.action")));
        String str = paramIntent.getStringExtra("auth.action");
        paramIntent = paramIntent.getStringExtra("auth.uid");
        switch (str.hashCode()) {
            default:
                paramInt1 = i;
        }
        for (; ; ) {
            switch (paramInt1) {
                default:
                    return;
                case 0:
                    a(paramIntent);
                    return;
                paramInt1 = i;
                if (str.equals("subscribe")) {
                    paramInt1 = 0;
                    continue;
                    paramInt1 = i;
                    if (str.equals("unsubscribe")) {
                        paramInt1 = 1;
                    }
                }
                break;
            }
        }
        g(paramIntent);
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            default:
                return;
            case 2131493355:
            case 2131493358:
                paramView = (String) paramView.getTag();
                v.a(getActivity(), paramView);
                return;
            case 2131493353:
                paramView = ((UserListAdapter.ViewHolder) paramView.getTag()).a.id;
                v.a(getActivity(), paramView);
                return;
            case 2131493361:
                paramView = (String) paramView.getTag();
                if (l.a().h()) {
                    a(paramView);
                    return;
                }
                c(a("subscribe", paramView));
                return;
            case 2131493362:
                paramView = (String) paramView.getTag();
                if (l.a().h()) {
                    g(paramView);
                    return;
                }
                c(a("unsubscribe", paramView));
                return;
        }
        paramView = (f) paramView.getTag();
        String str = paramView.h;
        Intent localIntent = new Intent(getActivity(), GalleryActivity.class);
        localIntent.putExtra("intent.gallery.type", 20);
        localIntent.putExtra("arg.uid", str);
        localIntent.putExtra("ARG_SELECTED_ID", ((IFunny) paramView.e).id);
        startActivity(localIntent);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setHasOptionsMenu(true);
        this.b = getResources().getInteger(2131558431);
    }

    public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
        super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
        paramMenuInflater.inflate(2131820570, paramMenu);
    }

    public void onDestroy() {
        super.onDestroy();
        this.c.f();
        this.c = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        J();
        return true;
    }

    public void onRefreshStarted(View paramView) {
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putInt("SAVE_USERS_COUNT", this.a);
    }

    public void onViewStateRestored(Bundle paramBundle) {
        super.onViewStateRestored(paramBundle);
        if (paramBundle != null) {
            this.a = paramBundle.getInt("SAVE_USERS_COUNT");
        }
        a(this.a);
    }

    protected void r() {
        this.c.a(true);
    }

    protected void s() {
        this.c.d();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/userlists/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */