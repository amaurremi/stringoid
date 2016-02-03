package mobi.ifunny.search;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import mobi.ifunny.gallery.ContentAdapterFragment;
import mobi.ifunny.rest.content.FeedPagingList;
import mobi.ifunny.rest.content.RestError;

public abstract class a<D extends Parcelable, T extends FeedPagingList<D>>
        extends ContentAdapterFragment<D, T>
        implements uk.co.a.a.b.a.b {
    private String a;

    protected final void D() {
        if (TextUtils.isEmpty(this.a)) {
            I();
            return;
        }
        super.D();
    }

    public void a(String paramString) {
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.equals(this.a, paramString))) {
            this.a = paramString;
            e();
            if (A()) {
                g(0);
            }
        }
    }

    protected boolean a(int paramInt, RestError paramRestError) {
        if ((paramRestError != null) && (paramRestError.status == 400)) {
            Toast.makeText(getActivity(), 2131689887, 0).show();
            return true;
        }
        return super.a(paramInt, paramRestError);
    }

    public String b() {
        return this.a;
    }

    protected boolean b(RestError paramRestError) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramRestError != null) {
            bool1 = bool2;
            if (paramRestError.status == 400) {
                Toast.makeText(getActivity(), 2131689887, 0).show();
                bool1 = true;
            }
        }
        return bool1;
    }

    protected b c() {
        return (b) getParentFragment();
    }

    protected SearchFragment d() {
        return (SearchFragment) getParentFragment();
    }

    protected void h(int paramInt) {
        if (paramInt == 0) {
            F();
        }
    }

    protected void i(int paramInt) {
        if (paramInt == 0) {
            D();
        }
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putString("STATE_SEARCH_QUERY", this.a);
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        super.onViewCreated(paramView, paramBundle);
        e(getResources().getString(2131689542));
        I();
    }

    public void onViewStateRestored(Bundle paramBundle) {
        if (paramBundle != null) {
            this.a = paramBundle.getString("STATE_SEARCH_QUERY");
        }
        super.onViewStateRestored(paramBundle);
    }

    protected void r() {
        d().a(this);
    }

    protected void s() {
        d().c();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/search/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */