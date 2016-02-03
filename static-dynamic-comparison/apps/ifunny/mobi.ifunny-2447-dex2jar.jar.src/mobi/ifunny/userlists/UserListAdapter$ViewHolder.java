package mobi.ifunny.userlists;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

import java.util.List;

import mobi.ifunny.k.a;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.User;

public class UserListAdapter$ViewHolder {
    public User a;
    @InjectView(2131493357)
    public ImageView avatarView;
    @InjectView(2131493356)
    public View avatarViewBackground;
    @InjectView(2131493355)
    public View avatarViewLayout;
    public View b;
    @InjectView(2131493359)
    public ImageView nickIsVerifiedView;
    @InjectView(2131493358)
    public TextView nickView;
    @InjectView(2131493360)
    public TextView numView;
    @InjectView(2131493361)
    public View subscribeBtn;
    @InjectView(2131493362)
    public View unsubscribeBtn;
    @InjectView(2131493363)
    public GridView worksGrid;

    public UserListAdapter$ViewHolder(LayoutInflater paramLayoutInflater, int paramInt, View paramView, List<IFunny> paramList, View.OnClickListener paramOnClickListener, String paramString, a parama) {
        this.b = paramView;
        ButterKnife.inject(this, paramView);
        paramLayoutInflater = new e(paramLayoutInflater, paramOnClickListener, paramInt, paramList, paramString, parama);
        this.worksGrid.setAdapter(paramLayoutInflater);
        this.worksGrid.setRecyclerListener(paramLayoutInflater);
        paramView.setTag(this);
    }

    public e a() {
        return (e) this.worksGrid.getAdapter();
    }

    public void a(boolean paramBoolean) {
        View localView = this.subscribeBtn;
        if (paramBoolean) {
        }
        for (int i = 8; ; i = 0) {
            localView.setVisibility(i);
            this.unsubscribeBtn.setVisibility(8);
            return;
        }
    }

    public void b() {
        this.subscribeBtn.setVisibility(8);
        this.unsubscribeBtn.setVisibility(0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/userlists/UserListAdapter$ViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */