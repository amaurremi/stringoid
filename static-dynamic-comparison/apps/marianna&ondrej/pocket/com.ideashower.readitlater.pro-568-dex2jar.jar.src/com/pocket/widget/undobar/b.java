package com.pocket.widget.undobar;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.ideashower.readitlater.util.j;

public class b
  implements View.OnClickListener, View.OnTouchListener
{
  private WindowManager a;
  private c b;
  private Context c;
  private View d;
  private View e;
  private View f;
  private TextView g;
  private TextView h;
  private Button i;
  private Handler j = new Handler();
  private Runnable k = new Runnable()
  {
    public void run()
    {
      b.this.b();
    }
  };
  
  protected b(Context paramContext, String paramString1, String paramString2, c paramc)
  {
    this.c = paramContext;
    this.b = paramc;
    this.a = ((WindowManager)paramContext.getSystemService("window"));
    this.d = LayoutInflater.from(this.c).inflate(2130903114, null);
    this.i = ((Button)this.d.findViewById(2131230979));
    this.i.setOnClickListener(this);
    this.i.setOnTouchListener(this);
    this.f = this.d.findViewById(2131230975);
    this.e = this.d.findViewById(2131230977);
    this.g = ((TextView)this.d.findViewById(2131230978));
    this.g.setText(paramString1);
    this.h = ((TextView)this.d.findViewById(2131230980));
    this.h.setText(paramString2);
    if (j.c())
    {
      this.g.setMinimumWidth(j.a(200.0F));
      if (j.a(true))
      {
        this.i.setTextSize(j.a(14.0F));
        this.g.setTextSize(j.a(14.0F));
        this.h.setTextSize(j.a(14.0F));
        this.f.setPadding(0, 0, 0, j.a(40.0F));
      }
    }
  }
  
  protected void a()
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -2, 2002, 264, -3);
    localLayoutParams.gravity = 81;
    localLayoutParams.windowAnimations = 16973828;
    this.d.setVisibility(0);
    this.a.addView(this.d, localLayoutParams);
    this.d.setVisibility(0);
    this.j.removeCallbacks(this.k);
    this.j.postDelayed(this.k, 5000L);
  }
  
  protected void b()
  {
    this.j.removeCallbacks(this.k);
    this.d.setVisibility(8);
    if (this.b != null) {
      this.b.a();
    }
    try
    {
      this.a.removeView(this.d);
      return;
    }
    catch (Exception localException)
    {
      this.d.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.b != null) {
      this.b.b();
    }
    this.e.setVisibility(8);
    this.h.setVisibility(0);
    this.j.removeCallbacks(this.k);
    this.j.postDelayed(this.k, 2000L);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.j.removeCallbacks(this.k);
    if (paramMotionEvent.getAction() == 1) {
      this.j.postDelayed(this.k, 2000L);
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/undobar/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */