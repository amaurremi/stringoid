package mobi.ifunny.profile;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import mobi.ifunny.view.j;

class w
        extends j {
    private ImageView a;
    private TextView b;
    private TextView c;
    private int d;
    private int e;

    private w(Resources paramResources, Drawable paramDrawable, String paramString) {
        super(2130903147, paramString, paramDrawable);
        this.d = paramResources.getColor(2131361796);
        this.e = paramResources.getColor(2131361899);
    }

    protected void a() {
        if (this.c != null) {
            this.c.setText("");
            this.c.setVisibility(8);
        }
    }

    protected void a(View paramView) {
        this.a = ((ImageView) paramView.findViewById(2131493252));
        this.b = ((TextView) paramView.findViewById(2131493253));
        this.c = ((TextView) paramView.findViewById(2131493195));
    }

    protected void a(View paramView, Drawable paramDrawable) {
        this.a.setImageDrawable(paramDrawable);
    }

    protected void a(View paramView, String paramString) {
        if (this.b != null) {
            this.b.setText(paramString);
        }
    }

    protected void a(String paramString) {
        if (this.c != null) {
            this.c.setText(paramString);
            this.c.setVisibility(0);
        }
    }

    public void a(boolean paramBoolean) {
        super.a(paramBoolean);
        Object localObject = this.a.getDrawable();
        float f;
        if (paramBoolean) {
            i = 1;
            ((Drawable) localObject).setLevel(i);
            localObject = this.a;
            if (!paramBoolean) {
                break label79;
            }
            f = 1.0F;
            label39:
            ((ImageView) localObject).setAlpha(f);
            if (this.b != null) {
                localObject = this.b;
                if (!paramBoolean) {
                    break label85;
                }
            }
        }
        label79:
        label85:
        for (int i = this.e; ; i = this.d) {
            ((TextView) localObject).setTextColor(i);
            return;
            i = 0;
            break;
            f = 0.6F;
            break label39;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */