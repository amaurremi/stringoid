package mobi.ifunny.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class ProgressAndEmptyFragment
        extends Fragment {
    private m a;
    private int b;
    private int c;
    @InjectView(2131493093)
    View emptyLayout;
    @InjectView(2131493094)
    TextView emptyTextView;
    @InjectView(2131493254)
    View progress;

    public static ProgressAndEmptyFragment a(m paramm, int paramInt1, int paramInt2) {
        ProgressAndEmptyFragment localProgressAndEmptyFragment = new ProgressAndEmptyFragment();
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("ARG_INITIAL_STATE", paramm);
        localBundle.putInt("ARG_EMPTY_TEXT", paramInt1);
        localBundle.putInt("ARG_EMPTY_DRAWABLE", paramInt2);
        localProgressAndEmptyFragment.setArguments(localBundle);
        return localProgressAndEmptyFragment;
    }

    public void a() {
        this.a = m.a;
        this.progress.setVisibility(0);
        this.emptyLayout.setVisibility(8);
    }

    public void b() {
        this.a = m.b;
        this.progress.setVisibility(8);
        this.emptyLayout.setVisibility(0);
        this.emptyTextView.setText(this.b);
        this.emptyTextView.setCompoundDrawablesWithIntrinsicBounds(0, this.c, 0, 0);
    }

    public m c() {
        return this.a;
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getArguments();
        this.a = ((m) paramBundle.getSerializable("ARG_INITIAL_STATE"));
        if (this.a == null) {
            this.a = m.a;
        }
        this.b = paramBundle.getInt("ARG_EMPTY_TEXT");
        this.c = paramBundle.getInt("ARG_EMPTY_DRAWABLE");
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903148, paramViewGroup, false);
        ButterKnife.inject(this, paramLayoutInflater);
        return paramLayoutInflater;
    }

    public void onResume() {
        super.onResume();
        switch (l.a[this.a.ordinal()]) {
            default:
                return;
            case 1:
                a();
                return;
        }
        b();
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putSerializable("STATE_STATE", this.a);
    }

    public void onViewStateRestored(Bundle paramBundle) {
        super.onViewStateRestored(paramBundle);
        if (paramBundle != null) {
            this.a = ((m) paramBundle.getSerializable("STATE_STATE"));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/fragment/ProgressAndEmptyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */