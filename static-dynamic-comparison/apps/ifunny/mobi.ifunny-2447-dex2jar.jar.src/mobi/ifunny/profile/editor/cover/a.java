package mobi.ifunny.profile.editor.cover;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.k;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import mobi.ifunny.l.e;
import mobi.ifunny.rest.content.CoverFeed;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Account;

public class a
        extends e
        implements AdapterView.OnItemClickListener {
    private d a;
    private GridView b;

    private void b() {
        if (!f("cover.feed")) {
            IFunnyRestRequest.Account.coverFeed(this, "cover.feed", new c(null));
        }
    }

    protected void a(CoverFeed paramCoverFeed) {
        this.a.a(paramCoverFeed.covers);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        switch (paramInt1) {
            default:
                super.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
        do {
            return;
        } while (paramInt2 != -1);
        k localk = getActivity();
        localk.setResult(-1, paramIntent);
        localk.finish();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.a = new d();
        b();
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903074, paramViewGroup, false);
        this.b = ((GridView) paramLayoutInflater);
        this.b.setAdapter(this.a);
        this.b.setOnItemClickListener(this);
        return paramLayoutInflater;
    }

    public void onDestroyView() {
        this.b = null;
        this.a.a();
        super.onDestroyView();
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        paramView = this.a.b(paramInt);
        paramAdapterView = getActivity();
        if (TextUtils.isEmpty(paramView)) {
            paramAdapterView.setResult(0);
        }
        for (; ; ) {
            paramAdapterView.finish();
            return;
            paramView = Uri.parse(paramView);
            Intent localIntent = new Intent();
            localIntent.setData(paramView);
            paramAdapterView.setResult(-1, localIntent);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/editor/cover/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */