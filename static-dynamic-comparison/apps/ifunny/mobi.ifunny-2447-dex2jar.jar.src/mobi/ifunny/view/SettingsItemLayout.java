package mobi.ifunny.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import mobi.ifunny.j;

public class SettingsItemLayout
        extends RelativeLayout {
    private final int a;
    private ViewGroup b;
    private ViewSwitcher c;
    private TextView d;
    private EditText e;
    private TextView f;
    private ImageView g;
    private TextView h;
    private ViewGroup i;
    private ImageView j;
    private TextView k;
    private TextView l;
    private View m;

    public SettingsItemLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        setBackgroundResource(2130837870);
        this.a = paramContext.getResources().getDimensionPixelOffset(2131427484);
        ((LayoutInflater) paramContext.getSystemService("layout_inflater")).inflate(2130903161, this);
        paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, j.mobi_ifunny_view_SettingsItemLayout, 0, 0);
        for (; ; ) {
            String str2;
            String str3;
            try {
                paramAttributeSet = Integer.valueOf(paramContext.getResourceId(1, 0));
                String str1 = paramContext.getString(2);
                str2 = paramContext.getString(3);
                str3 = paramContext.getString(4);
                boolean bool2 = paramContext.getBoolean(6, true);
                String str4 = paramContext.getString(5);
                int n = paramContext.getInteger(0, 0);
                paramContext.recycle();
                this.b = ((ViewGroup) findViewById(2131493296));
                this.c = ((ViewSwitcher) findViewById(2131493298));
                this.d = ((TextView) findViewWithTag("item_left_text_plain"));
                this.e = ((EditText) findViewWithTag("item_left_text_editable"));
                paramContext = (ImageView) findViewById(2131493297);
                if (paramAttributeSet.intValue() == 0) {
                    paramContext.setVisibility(8);
                    setLeftText(str1);
                    switch (n) {
                        default:
                            if (n == 3) {
                                break label326;
                            }
                            bool1 = true;
                            setClickable(bool1);
                            if ((str4 != null) && (str4.length() > 0)) {
                                a(str4);
                            }
                            if (bool2) {
                                a(n);
                            }
                            return;
                    }
                }
            } finally {
                paramContext.recycle();
            }
            paramContext.setImageResource(paramAttributeSet.intValue());
            continue;
            b();
            setRightText(str2);
            continue;
            c();
            continue;
            a();
            setEditableHint(str3);
            continue;
            d();
            continue;
            label326:
            boolean bool1 = false;
        }
    }

    private void a(int paramInt) {
        this.m = new View(getContext());
        Object localObject = new RelativeLayout.LayoutParams(-1, this.a);
        int n;
        if (this.h != null) {
            n = 2131492876;
            ((RelativeLayout.LayoutParams) localObject).addRule(3, n);
            this.m.setLayoutParams((ViewGroup.LayoutParams) localObject);
            localObject = this.m;
            if (paramInt != 3) {
                break label85;
            }
        }
        label85:
        for (paramInt = 2131361835; ; paramInt = 2131361873) {
            ((View) localObject).setBackgroundResource(paramInt);
            addView(this.m);
            return;
            n = 2131493296;
            break;
        }
    }

    private void a(String paramString) {
        TextView localTextView = new TextView(getContext());
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(3, 2131493296);
        localTextView.setLayoutParams(localLayoutParams);
        localTextView.setText(paramString);
        localTextView.setId(2131492876);
        localTextView.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131427460));
        addView(localTextView);
        this.h = localTextView;
    }

    private void b() {
        TextView localTextView = new TextView(getContext());
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(15);
        localTextView.setLayoutParams(localLayoutParams);
        localTextView.setPadding(0, 0, getContext().getResources().getDimensionPixelSize(2131427460), 0);
        localTextView.setTextSize(2, 14.0F);
        this.b.addView(localTextView);
        this.f = localTextView;
    }

    private void c() {
        ImageView localImageView = new ImageView(getContext());
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(15);
        localImageView.setLayoutParams(localLayoutParams);
        localImageView.setImageResource(2130837914);
        localImageView.setPadding(0, 0, getContext().getResources().getDimensionPixelSize(2131427460), 0);
        this.b.addView(localImageView);
        this.g = localImageView;
    }

    private void d() {
        this.i = ((ViewGroup) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(2130903162, this.b, false));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(15);
        this.i.setLayoutParams(localLayoutParams);
        this.b.addView(this.i);
        this.j = ((ImageView) this.i.findViewById(2131493299));
        this.k = ((TextView) this.i.findViewById(2131493300));
        this.l = ((TextView) this.i.findViewById(2131493301));
    }

    public void a() {
        this.c.showNext();
    }

    protected void dispatchDraw(Canvas paramCanvas) {
        super.dispatchDraw(paramCanvas);
        if (!isEnabled()) {
            paramCanvas.drawColor(getResources().getColor(2131361875));
        }
    }

    public View getBottomLine() {
        return this.m;
    }

    public ImageView getCheckboxView() {
        return this.g;
    }

    public TextView getDescriptionView() {
        return this.h;
    }

    public EditText getLeftTextEditView() {
        return this.e;
    }

    public TextView getLeftTextPlainView() {
        return this.d;
    }

    public TextView getRightTextView() {
        return this.f;
    }

    public ViewGroup getSwitcherView() {
        return this.i;
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
    }

    public void setCheckboxState(boolean paramBoolean) {
        ImageView localImageView;
        if (this.g != null) {
            localImageView = this.g;
            if (!paramBoolean) {
                break label26;
            }
        }
        label26:
        for (int n = 2130837915; ; n = 2130837914) {
            localImageView.setImageResource(n);
            return;
        }
    }

    public void setEditableHint(String paramString) {
        this.e.setHint(paramString);
    }

    public void setLeftText(String paramString) {
        this.d.setText(paramString);
        this.e.setText(paramString);
    }

    public void setRightText(String paramString) {
        if (this.f != null) {
            this.f.setText(paramString);
        }
    }

    public void setSwitcherState(boolean paramBoolean) {
        int i1 = 0;
        Object localObject;
        if (this.j != null) {
            localObject = this.j;
            if (paramBoolean) {
                n = 2130837915;
                ((ImageView) localObject).setImageResource(n);
            }
        } else if ((this.k != null) && (this.l != null)) {
            localObject = this.k;
            if (!paramBoolean) {
                break label87;
            }
            n = 8;
            label56:
            ((TextView) localObject).setVisibility(n);
            localObject = this.l;
            if (!paramBoolean) {
                break label92;
            }
        }
        label87:
        label92:
        for (int n = i1; ; n = 8) {
            ((TextView) localObject).setVisibility(n);
            return;
            n = 2130837914;
            break;
            n = 0;
            break label56;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/SettingsItemLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */