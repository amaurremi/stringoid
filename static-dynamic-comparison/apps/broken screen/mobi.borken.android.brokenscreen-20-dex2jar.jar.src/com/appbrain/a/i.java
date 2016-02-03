package com.appbrain.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import cmn.q;
import com.appbrain.AppBrainActivity.a;
import com.appbrain.e.j.i;
import java.lang.ref.WeakReference;

public final class i
{
  private static WeakReference a;
  
  static void a(Activity paramActivity, j.i parami)
  {
    if ((a != null) && (a.get() == paramActivity)) {
      return;
    }
    a = new WeakReference(paramActivity);
    Intent localIntent = a.c(paramActivity);
    localIntent.putExtra("aa", parami.b());
    paramActivity.startActivity(localIntent);
  }
  
  static final class a
    extends AppBrainActivity.a
  {
    private final Activity a;
    private j.i b;
    private boolean c;
    
    a(Activity paramActivity)
    {
      this.a = paramActivity;
    }
    
    public final void a()
    {
      super.a();
      if ((!this.c) && (!t.a(this.b))) {
        this.a.finish();
      }
    }
    
    public final void a(Bundle paramBundle)
    {
      try
      {
        this.b = j.i.a(this.a.getIntent().getByteArrayExtra("aa"));
        this.c = this.a.getIntent().getBooleanExtra("fn", false);
        int i = q.b(16.0F);
        Object localObject = new TextView(this.a);
        ((TextView)localObject).setPadding(i, i, i, i);
        ((TextView)localObject).setTextSize(16.0F);
        ((TextView)localObject).setText(this.b.j());
        paramBundle = new ScrollView(this.a);
        paramBundle.addView((View)localObject);
        localObject = new LinearLayout(this.a);
        ((LinearLayout)localObject).setOrientation(1);
        ((LinearLayout)localObject).addView(paramBundle, new LinearLayout.LayoutParams(-1, 0, 1.0F));
        if (!this.b.o())
        {
          paramBundle = new Button(this.a);
          paramBundle.setText(z.b(this.a, this.b));
          paramBundle.setOnClickListener(new j(this));
        }
        for (;;)
        {
          ((LinearLayout)localObject).addView(paramBundle, -1, -2);
          this.a.setContentView((View)localObject);
          return;
          Button localButton1 = new Button(this.a);
          localButton1.setText(z.c(this.a, this.b));
          localButton1.setOnClickListener(new k(this));
          Button localButton2 = new Button(this.a);
          localButton2.setText(z.b(this.a, this.b));
          localButton2.setOnClickListener(new l(this));
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1, 1.0F);
          paramBundle = new LinearLayout(this.a);
          paramBundle.setOrientation(0);
          paramBundle.setBaselineAligned(false);
          if (Build.VERSION.SDK_INT < 11)
          {
            paramBundle.addView(localButton2, localLayoutParams);
            paramBundle.addView(localButton1, localLayoutParams);
          }
          else
          {
            paramBundle.addView(localButton1, localLayoutParams);
            paramBundle.addView(localButton2, localLayoutParams);
          }
        }
      }
      catch (com.appbrain.b.i paramBundle)
      {
        for (;;) {}
      }
    }
    
    public final void b()
    {
      if ((!this.c) && (this.a.isFinishing())) {
        i.a(false);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */