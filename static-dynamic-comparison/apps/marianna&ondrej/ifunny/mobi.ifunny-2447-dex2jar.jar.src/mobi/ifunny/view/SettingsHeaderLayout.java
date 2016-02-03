package mobi.ifunny.view;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import mobi.ifunny.j;

public class SettingsHeaderLayout
        extends LinearLayout {
    public SettingsHeaderLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        setOrientation(1);
        ((LayoutInflater) paramContext.getSystemService("layout_inflater")).inflate(2130903160, this);
        paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, j.mobi_ifunny_view_SettingsHeaderLayout, 0, 0);
        try {
            String str = paramContext.getString(0);
            paramAttributeSet = paramContext.getString(1);
            paramContext.recycle();
            ((TextView) findViewById(2131493294)).setText(str);
            if (!TextUtils.isEmpty(paramAttributeSet)) {
                paramContext = (TextView) findViewById(2131493295);
                paramContext.setText(paramAttributeSet);
                paramContext.setVisibility(0);
            }
            return;
        } finally {
            paramContext.recycle();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/SettingsHeaderLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */