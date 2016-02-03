package mobi.ifunny.view;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class j {
    private final int a;
    private View b;
    private String c;
    private Drawable d;
    private boolean e;

    public j(int paramInt, String paramString) {
        this(paramInt, paramString, null);
    }

    public j(int paramInt, String paramString, Drawable paramDrawable) {
        this.a = paramInt;
        this.c = paramString;
        this.d = paramDrawable;
    }

    private View a() {
        return this.b;
    }

    public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup) {
        if (this.b == null) {
            this.b = paramLayoutInflater.inflate(this.a, paramViewGroup, false);
        }
        a(this.b);
        a(this.b, this.c);
        a(this.b, this.d);
        a(false);
        return this.b;
    }

    protected void a(View paramView) {
    }

    protected abstract void a(View paramView, Drawable paramDrawable);

    protected abstract void a(View paramView, String paramString);

    protected void a(boolean paramBoolean) {
        this.e = paramBoolean;
    }

    public String b() {
        return this.c;
    }

    public void b(String paramString) {
        this.c = paramString;
        a(this.b, paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */