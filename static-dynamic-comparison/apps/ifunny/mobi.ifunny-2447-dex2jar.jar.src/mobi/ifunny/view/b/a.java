package mobi.ifunny.view.b;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import mobi.ifunny.j;
import mobi.ifunny.view.ProgressBar;
import mobi.ifunny.view.v;

public class a
        extends AlertDialog {
    private Context a;
    private boolean b;
    private boolean c;
    private ProgressBar d;
    private TextView e;
    private int f;
    private CharSequence g;

    public a(Context paramContext, int paramInt) {
        super(paramContext, paramInt);
        this.a = paramContext;
    }

    private void a() {
    }

    public void a(int paramInt) {
        if (this.b) {
            this.d.setPercent(paramInt);
            a();
            return;
        }
        this.f = paramInt;
    }

    public final void a(boolean paramBoolean) {
        this.c = paramBoolean;
        ProgressBar localProgressBar;
        if (this.d != null) {
            localProgressBar = this.d;
            if (!paramBoolean) {
                break label31;
            }
        }
        label31:
        for (v localv = v.b; ; localv = v.a) {
            localProgressBar.setMode(localv);
            return;
        }
    }

    protected void onCreate(Bundle paramBundle) {
        Object localObject1 = LayoutInflater.from(this.a);
        Object localObject2 = getContext().obtainStyledAttributes(null, j.ProgressDialog);
        int i = ((TypedArray) localObject2).getResourceId(0, 2130903149);
        ((TypedArray) localObject2).recycle();
        localObject2 = ((LayoutInflater) localObject1).inflate(i, null);
        this.d = ((ProgressBar) ((View) localObject2).findViewById(16908301));
        ProgressBar localProgressBar = this.d;
        if (this.c) {
        }
        for (localObject1 = v.b; ; localObject1 = v.a) {
            localProgressBar.setMode((v) localObject1);
            this.e = ((TextView) ((View) localObject2).findViewById(2131493256));
            setView((View) localObject2);
            if (this.f > 0) {
                a(this.f);
            }
            if (this.g != null) {
                setMessage(this.g);
            }
            a();
            super.onCreate(paramBundle);
            return;
        }
    }

    public void onStart() {
        super.onStart();
        this.b = true;
    }

    protected void onStop() {
        super.onStop();
        this.b = false;
    }

    public void setMessage(CharSequence paramCharSequence) {
        if (this.d != null) {
            this.e.setText(paramCharSequence);
            return;
        }
        this.g = paramCharSequence;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */