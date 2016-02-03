package mobi.ifunny.a;

import android.view.View;

public abstract class b {
    private View a;

    public void a() {
    }

    public void a(View paramView) {
        if (paramView == null) {
            throw new IllegalStateException();
        }
        this.a = paramView;
    }

    protected abstract void a(boolean paramBoolean);

    public void b() {
    }

    public abstract void b(boolean paramBoolean);

    public void c() {
    }

    public void c(boolean paramBoolean) {
        int j = this.a.getVisibility();
        if (paramBoolean) {
        }
        for (int i = 0; ; i = 8) {
            if (i != j) {
                this.a.setVisibility(i);
                a(paramBoolean);
            }
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */