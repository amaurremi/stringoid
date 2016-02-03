package com.everimaging.fotor.settings;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.method.ScrollingMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.everimaging.fotor.App;
import com.everimaging.fotor.b;
import com.everimaging.fotor.c.e;

public class AboutActivity
        extends b
        implements View.OnClickListener {
    private TextView a;
    private View b;
    private TextView c;
    private ImageButton d;

    public void onClick(View paramView) {
        if (paramView == this.a) {
            this.b.setVisibility(0);
        }
        while (paramView != this.d) {
            return;
        }
        this.b.setVisibility(8);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903210);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((TextView) findViewById(2131558869)).setText(getString(2131296627, new Object[]{App.b.b()}));
        this.a = ((TextView) findViewById(2131558870));
        paramBundle = new SpannableStringBuilder();
        paramBundle.append(this.a.getText());
        paramBundle.setSpan(new URLSpan("#"), 0, paramBundle.length(), 33);
        this.a.setText(paramBundle, TextView.BufferType.SPANNABLE);
        this.b = findViewById(2131558871);
        this.b.setOnClickListener(e.a());
        this.a.setOnClickListener(this);
        this.c = ((TextView) findViewById(2131558872));
        this.c.setText(Html.fromHtml(getString(2131296542)));
        this.c.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.b.setVisibility(8);
        this.d = ((ImageButton) findViewById(2131558873));
        this.d.setOnClickListener(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/settings/AboutActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */