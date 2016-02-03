package mobi.ifunny.search;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.List;

import mobi.ifunny.gallery.ContentAdapterFragment;
import mobi.ifunny.gallery.GalleryActivity;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.Paging;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.content.SearchResponse.SearchCounters;
import mobi.ifunny.rest.content.SearchUsersResponce;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.content.UserList;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Search;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Subscriptions;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.social.auth.AuthActivity;
import mobi.ifunny.userlists.UserListAdapter;
import mobi.ifunny.userlists.UserListAdapter.ViewHolder;
import mobi.ifunny.userlists.f;
import mobi.ifunny.util.v;
import mobi.ifunny.view.DynamicListView;

public class i
        extends a<User, SearchUsersResponce>
        implements View.OnClickListener, mobi.ifunny.view.a {
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

    private void a(int paramInt) {
        ((User) ((SearchUsersResponce) B()).users.items.get(paramInt)).is_in_subscriptions = true;
        c(paramInt).b();
    }

    private void a(String paramString, int paramInt) {
        IFunnyRestRequest.Subscriptions.subscribeUser(this, "rest.subscribeUser", paramString, new k(paramInt, null));
    }

    private void b(int paramInt) {
        User localUser = (User) ((SearchUsersResponce) B()).users.items.get(paramInt);
        localUser.is_in_subscriptions = false;
        c(paramInt).a(localUser.is_banned);
    }

    private void b(String paramString, int paramInt) {
        IFunnyRestRequest.Subscriptions.unsubscribeUser(this, "rest.unsubscribeUser", paramString, new l(paramInt, null));
    }

    private UserListAdapter.ViewHolder c(int paramInt) {
        return (UserListAdapter.ViewHolder) f().a(paramInt).getTag();
    }

    private void k() {
        Intent localIntent = new Intent(getActivity(), AuthActivity.class);
        localIntent.setFlags(536870912);
        startActivity(localIntent);
    }

    private void k(int paramInt) {
        User localUser = (User) ((SearchUsersResponce) B()).users.items.get(paramInt);
        localUser.is_in_subscriptions = false;
        c(paramInt).a(localUser.is_banned);
    }

    private void l(int paramInt) {
        ((User) ((SearchUsersResponce) B()).users.items.get(paramInt)).is_in_subscriptions = true;
        c(paramInt).b();
    }

    public void O() {
        g(1);
    }

    public void P() {
        g(-1);
    }

    protected void a(int paramInt, SearchUsersResponce paramSearchUsersResponce) {
        boolean bool1 = true;
        boolean bool3 = true;
        boolean bool2 = true;
        super.a(paramInt, paramSearchUsersResponce);
        DynamicListView localDynamicListView = f();
        UserList localUserList;
        if (paramInt == 1) {
            localDynamicListView.a();
            if ((paramSearchUsersResponce != null) && (paramSearchUsersResponce.users != null)) {
                localUserList = paramSearchUsersResponce.users;
                if (paramInt != 0) {
                    break label146;
                }
                c().a(paramSearchUsersResponce.num.content);
                c().d(paramSearchUsersResponce.num.users);
                if (localUserList.paging.hasNext) {
                    break label136;
                }
                bool1 = true;
                label96:
                localDynamicListView.setInnerAdapterFilledAtEnd(bool1);
                if (localUserList.paging.hasPrev) {
                    break label141;
                }
            }
        }
        label136:
        label141:
        for (bool1 = bool2; ; bool1 = false) {
            localDynamicListView.setInnerAdapterFilledAtStart(bool1);
            return;
            if (paramInt != -1) {
                break;
            }
            localDynamicListView.b();
            break;
            bool1 = false;
            break label96;
        }
        label146:
        if (paramInt == 1) {
            if (!localUserList.paging.hasNext) {
            }
            for (; ; ) {
                localDynamicListView.setInnerAdapterFilledAtEnd(bool1);
                return;
                bool1 = false;
            }
        }
        if (!localUserList.paging.hasPrev) {
        }
        for (bool1 = bool3; ; bool1 = false) {
            localDynamicListView.setInnerAdapterFilledAtStart(bool1);
            return;
        }
    }

    protected void a(AdapterView paramAdapterView, View paramView, int paramInt) {
    }

    protected void a(SearchUsersResponce paramSearchUsersResponce) {
        boolean bool2 = true;
        super.a(paramSearchUsersResponce);
        DynamicListView localDynamicListView;
        if (paramSearchUsersResponce != null) {
            localDynamicListView = f();
            UserList localUserList = paramSearchUsersResponce.users;
            c().a(paramSearchUsersResponce.num.content);
            c().d(paramSearchUsersResponce.num.users);
            if (localUserList.paging.hasNext) {
                break label94;
            }
            bool1 = true;
            localDynamicListView.setInnerAdapterFilledAtEnd(bool1);
            if (localUserList.paging.hasPrev) {
                break label99;
            }
        }
        label94:
        label99:
        for (boolean bool1 = bool2; ; bool1 = false) {
            localDynamicListView.setInnerAdapterFilledAtStart(bool1);
            return;
            bool1 = false;
            break;
        }
    }

    protected void a(boolean paramBoolean) {
        boolean bool = true;
        super.a(paramBoolean);
        DynamicListView localDynamicListView;
        if ((paramBoolean) && (B() != null)) {
            localDynamicListView = f();
            if (((SearchUsersResponce) B()).hasNext()) {
                break label108;
            }
            paramBoolean = true;
            localDynamicListView.setInnerAdapterFilledAtEnd(paramBoolean);
            if (((SearchUsersResponce) B()).hasPrev()) {
                break label113;
            }
        }
        label108:
        label113:
        for (paramBoolean = bool; ; paramBoolean = false) {
            localDynamicListView.setInnerAdapterFilledAtStart(paramBoolean);
            c().a(((SearchUsersResponce) B()).num.content);
            c().d(((SearchUsersResponce) B()).num.users);
            return;
            paramBoolean = false;
            break;
        }
    }

    protected boolean a(int paramInt, RestError paramRestError) {
        DynamicListView localDynamicListView = f();
        if (paramInt == 1) {
            localDynamicListView.a();
        }
        for (; ; ) {
            return super.a(paramInt, paramRestError);
            if (paramInt == -1) {
                localDynamicListView.b();
            } else {
                c().d(0);
            }
        }
    }

    protected <K extends ContentAdapterFragment<User, SearchUsersResponce>> boolean a(String paramString1, String paramString2, String paramString3, RestHttpHandler<SearchUsersResponce, K> paramRestHttpHandler) {
        if (TextUtils.isEmpty(b())) {
            return false;
        }
        IFunnyRestRequest.Search.searchUsers(this, paramString3, b(), o(), paramString1, paramString2, paramRestHttpHandler);
        return true;
    }

    public void e() {
        super.e();
        DynamicListView localDynamicListView = f();
        localDynamicListView.a();
        localDynamicListView.b();
    }

    protected DynamicListView f() {
        return (DynamicListView) super.E();
    }

    protected UserListAdapter<SearchUsersResponce> g() {
        return (UserListAdapter) super.i();
    }

    protected UserListAdapter<SearchUsersResponce> h() {
        return new UserListAdapter(f(), this);
    }

    public void onClick(View paramView) {
        int i;
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
                if (!mobi.ifunny.social.auth.l.a().h()) {
                    k();
                    return;
                }
                i = a(((SearchUsersResponce) B()).users.items, paramView);
                a(paramView, i);
                a(i);
                return;
            case 2131493362:
                paramView = (String) paramView.getTag();
                if (!mobi.ifunny.social.auth.l.a().h()) {
                    k();
                    return;
                }
                i = a(((SearchUsersResponce) B()).users.items, paramView);
                b(paramView, i);
                k(i);
                return;
        }
        paramView = (f) paramView.getTag();
        Intent localIntent = new Intent(getActivity(), GalleryActivity.class);
        localIntent.putExtra("intent.gallery.type", 20);
        localIntent.putExtra("arg.uid", paramView.h);
        localIntent.putExtra("ARG_SELECTED_ID", ((IFunny) paramView.e).id);
        startActivity(localIntent);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903100, paramViewGroup, false);
        paramViewGroup = (DynamicListView) paramLayoutInflater.findViewById(2131493012);
        paramViewGroup.setRequestAtLeastItemsAtEnd(o() / 2);
        paramViewGroup.setDynamicAdapterViewListener(this);
        paramViewGroup.setAutomaticRequestAtStart(true);
        paramViewGroup.setAutomaticRequestAtEnd(true);
        a(paramViewGroup);
        return paramLayoutInflater;
    }

    public void onRefreshStarted(View paramView) {
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        super.onViewCreated(paramView, paramBundle);
        e(getResources().getString(2131689895));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/search/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */