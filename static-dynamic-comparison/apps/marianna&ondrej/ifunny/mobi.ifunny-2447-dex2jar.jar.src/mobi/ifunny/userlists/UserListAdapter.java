package mobi.ifunny.userlists;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mobi.ifunny.gallery.h;
import mobi.ifunny.k.a;
import mobi.ifunny.k.x;
import mobi.ifunny.rest.content.FeedPagingList;
import mobi.ifunny.rest.content.IFunnyList;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.social.auth.l;
import mobi.ifunny.util.r;

public class UserListAdapter<T extends FeedPagingList<User>>
        extends mobi.ifunny.gallery.a.f<User, T> {
    protected LayoutInflater a;
    protected View.OnClickListener b;
    private a c;
    private int e;
    private Resources f;

    public UserListAdapter(AbsListView paramAbsListView, View.OnClickListener paramOnClickListener) {
        super(paramAbsListView, 2, 5000);
        Context localContext = paramAbsListView.getContext();
        this.f = localContext.getResources();
        this.e = this.f.getInteger(2131558430);
        this.b = paramOnClickListener;
        this.a = LayoutInflater.from(localContext);
        this.c = new a(new mobi.ifunny.gallery.a.c(paramAbsListView.getContext()), new x(), 3, 8000);
    }

    public View a(int paramInt, h<User> paramh, View paramView, ViewGroup paramViewGroup) {
        if (paramView == null) {
            paramViewGroup = this.a.inflate(2130903181, paramViewGroup, false);
            paramh = new UserListAdapter.ItemViewHolder(paramViewGroup, (String) paramh.c);
            paramViewGroup.setTag(paramh);
            paramh.textView.setText(paramh.a);
        }
        UserListAdapter.ItemViewHolder localItemViewHolder;
        do {
            return paramViewGroup;
            localItemViewHolder = (UserListAdapter.ItemViewHolder) paramView.getTag();
            paramViewGroup = paramView;
        } while (TextUtils.equals(localItemViewHolder.a, (CharSequence) paramh.c));
        localItemViewHolder.a = ((String) paramh.c);
        localItemViewHolder.textView.setText(localItemViewHolder.a);
        return paramView;
    }

    protected a a(AbsListView paramAbsListView, int paramInt1, int paramInt2) {
        return new a(new mobi.ifunny.comments.f(paramAbsListView.getContext(), new mobi.ifunny.util.c(paramAbsListView.getContext())), new mobi.ifunny.k.g(), paramInt1, paramInt2);
    }

    public void a() {
        if (this.d == null) {
        }
        label77:
        for (; ; ) {
            return;
            int j = this.d.size();
            int i = 0;
            if (i < j) {
                h localh = (h) this.d.get(i);
                if ((localh == null) || (localh.b != 1)) {
                }
            }
            for (; ; ) {
                if (i < 0) {
                    break label77;
                }
                this.d.remove(i);
                return;
                i += 1;
                break;
                i = -1;
            }
        }
    }

    public void a(String paramString) {
        a(new h(new User(), 1, paramString));
    }

    public View c(int paramInt, h<User> paramh, View paramView, ViewGroup paramViewGroup) {
        User localUser = (User) paramh.a;
        Object localObject1;
        label65:
        label108:
        Object localObject2;
        if (localUser.is_banned) {
            paramh = null;
            String str = localUser.id;
            if (paramView != null) {
                break label417;
            }
            paramViewGroup = this.a.inflate(2130903182, paramViewGroup, false);
            localObject1 = this.a;
            paramInt = this.e;
            if (localUser.content != null) {
                break label405;
            }
            paramView = null;
            paramView = new UserListAdapter.ViewHolder((LayoutInflater) localObject1, paramInt, paramViewGroup, paramView, this.b, localUser.id, this.c);
            paramView.a = localUser;
            paramViewGroup.setTag(paramView);
            localObject1 = str;
            paramView.b.setOnClickListener(this.b);
            paramView.nickView.setOnClickListener(this.b);
            paramView.unsubscribeBtn.setOnClickListener(this.b);
            paramView.subscribeBtn.setOnClickListener(this.b);
            paramView.unsubscribeBtn.setTag(localUser.id);
            paramView.subscribeBtn.setTag(localUser.id);
            paramView.nickView.setText(localUser.nick);
            paramView.nickView.setTag(localUser.id);
            localObject2 = paramView.nickIsVerifiedView;
            if (!localUser.is_verified) {
                break label452;
            }
            paramInt = 0;
            label216:
            ((ImageView) localObject2).setVisibility(paramInt);
            paramView.numView.setText(r.b(this.f, 2131623949, 2131690181, localUser.total_posts));
            if (TextUtils.equals(l.a().d(), localUser.id)) {
                break label470;
            }
            if (!localUser.is_in_subscriptions) {
                break label458;
            }
            paramView.b();
            label274:
            if (localUser.is_banned) {
                paramView.numView.setText(this.f.getString(2131690180));
            }
            paramView.avatarViewLayout.setOnClickListener(this.b);
            paramView.avatarViewLayout.setTag(str);
            a(new mobi.ifunny.comments.g(paramView.avatarView, paramView.avatarViewBackground, paramh, localUser), paramViewGroup);
            localObject2 = paramView.a();
            if (TextUtils.equals(str, (CharSequence) localObject1)) {
                break label503;
            }
            if (localUser.content != null) {
                break label491;
            }
            paramh = null;
            label368:
            ((e) localObject2).a(paramh, str, true);
        }
        for (; ; ) {
            if (((e) localObject2).getCount() <= 0) {
                break label511;
            }
            paramView.worksGrid.setVisibility(0);
            return paramViewGroup;
            paramh = localUser.getPhotoThumbSmallUrl();
            break;
            label405:
            paramView = localUser.content.items;
            break label65;
            label417:
            localObject2 = (UserListAdapter.ViewHolder) paramView.getTag();
            localObject1 = ((UserListAdapter.ViewHolder) localObject2).a.id;
            ((UserListAdapter.ViewHolder) localObject2).a = localUser;
            paramViewGroup = paramView;
            paramView = (View) localObject2;
            break label108;
            label452:
            paramInt = 8;
            break label216;
            label458:
            paramView.a(localUser.is_banned);
            break label274;
            label470:
            paramView.subscribeBtn.setVisibility(8);
            paramView.unsubscribeBtn.setVisibility(8);
            break label274;
            label491:
            paramh = localUser.content.items;
            break label368;
            label503:
            ((e) localObject2).notifyDataSetChanged();
        }
        label511:
        paramView.worksGrid.setVisibility(8);
        return paramViewGroup;
    }

    public void g() {
        super.g();
        this.c.b();
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public void h() {
        super.h();
        this.c.c();
    }

    public void notifyDataSetChanged() {
        h();
        super.notifyDataSetChanged();
    }

    public void onMovedToScrapHeap(View paramView) {
        super.onMovedToScrapHeap(paramView);
        paramView = paramView.getTag();
        if ((paramView != null) && ((paramView instanceof UserListAdapter.ViewHolder))) {
            paramView = ((UserListAdapter.ViewHolder) paramView).a.id;
            if (!TextUtils.isEmpty(paramView)) {
                this.c.a(paramView);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/userlists/UserListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */