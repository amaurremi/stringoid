package mobi.ifunny.comments;

import android.os.Bundle;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import mobi.ifunny.b.g;
import mobi.ifunny.gallery.GalleryFragment;
import mobi.ifunny.gallery.fragment.p;
import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.IFunny;
import uk.co.a.a.b.a.b;

public class ah
        extends p
        implements u, b {
    private String b;
    private CommentsFragment c;

    public static ah a(Bundle paramBundle) {
        ah localah = new ah();
        localah.setArguments(paramBundle);
        return localah;
    }

    public void a(IFunny paramIFunny) {
        f().s();
    }

    public void a(IFunny paramIFunny, Comment paramComment) {
    }

    public void b() {
        this.c.e();
    }

    public void b(boolean paramBoolean) {
        f().b(paramBoolean);
    }

    public void c() {
        this.c.J();
    }

    public void d() {
        this.c.n();
    }

    public void o() {
        f().a(this);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (this.a != null) {
            this.b = this.a.getString("ARG_SHOW_COMMENT_ID");
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(2130903096, paramViewGroup, false);
    }

    public void onRefreshStarted(View paramView) {
    }

    public void onViewStateRestored(Bundle paramBundle) {
        super.onViewStateRestored(paramBundle);
        paramBundle = getChildFragmentManager();
        this.c = ((CommentsFragment) paramBundle.a("TAG_COMMENTS"));
        if (this.c == null) {
            this.c = ae.d(this.b);
            ab localab = paramBundle.a();
            localab.a(2131493070, this.c, "TAG_COMMENTS");
            localab.c();
            paramBundle.b();
        }
        this.c.setUserVisibleHint(getUserVisibleHint());
    }

    public void p() {
        f().b(this);
    }

    public void setUserVisibleHint(boolean paramBoolean) {
        super.setUserVisibleHint(paramBoolean);
        if (this.c != null) {
            this.c.setUserVisibleHint(paramBoolean);
        }
        if (paramBoolean) {
            g.b(getActivity(), "Comments");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */