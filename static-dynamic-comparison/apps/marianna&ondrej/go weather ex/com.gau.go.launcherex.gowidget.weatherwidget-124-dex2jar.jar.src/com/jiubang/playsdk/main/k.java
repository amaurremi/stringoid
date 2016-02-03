package com.jiubang.playsdk.main;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.jiubang.playsdk.f;

public class k
{
  private final View a;
  private View b;
  private final int c;
  private final Handler d = new Handler();
  private final int e;
  private int f;
  private volatile boolean g = false;
  private q h;
  private p i;
  private final View.OnClickListener j = new l(this);
  private final View.OnClickListener k = new m(this);
  private final View.OnClickListener l = new n(this);
  
  private k(View paramView1, View paramView2, int paramInt1, int paramInt2, q paramq, p paramp)
  {
    this.a = paramView1;
    this.b = paramView2;
    this.c = paramInt1;
    this.e = paramInt2;
    this.h = paramq;
    this.i = paramp;
    c();
  }
  
  public k(View paramView1, View paramView2, q paramq, p paramp)
  {
    this(paramView1, paramView2, f.ag, f.aB, paramq, paramp);
  }
  
  private void a(int paramInt, String paramString)
  {
    this.g = false;
    if (paramInt == this.f) {
      return;
    }
    switch (this.f)
    {
    default: 
      throw new IllegalStateException("Invalid mode " + paramInt + "should be LOADING_MODE, ERROR_MODE, DATA_MODE, or BLANK_MODE");
    case 0: 
      b(false);
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalStateException("Invalid mode " + paramInt + "should be LOADING_MODE, ERROR_MODE, DATA_MODE, or BLANK_MODE");
        a(false, null);
        continue;
        a(false);
      }
    }
    b(true);
    for (;;)
    {
      this.f = paramInt;
      return;
      a(true, paramString);
      continue;
      a(true);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    if (paramBoolean)
    {
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (this.c <= 0) {
      return;
    }
    a(paramBoolean, true);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    View localView = this.a.findViewById(this.c);
    Button localButton1 = (Button)localView.findViewById(f.aj);
    Object localObject = (TextView)localView.findViewById(f.C);
    localObject = (Button)localView.findViewById(f.i);
    Button localButton2 = (Button)localView.findViewById(f.A);
    if (!paramBoolean1)
    {
      localView.setVisibility(8);
      localButton1.setOnClickListener(null);
      ((Button)localObject).setOnClickListener(null);
      localButton2.setOnClickListener(null);
      return;
    }
    localView.setVisibility(0);
    localButton1.setVisibility(0);
    localButton1.setOnClickListener(this.j);
    localButton2.setOnClickListener(this.l);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.e <= 0) {}
    View localView;
    do
    {
      return;
      localView = this.a.findViewById(this.e);
    } while (localView == null);
    if (paramBoolean)
    {
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void c()
  {
    this.f = 3;
    b(false);
    a(false, null);
    a(false);
  }
  
  public void a()
  {
    a(2, null);
  }
  
  public void a(int paramInt)
  {
    this.g = true;
    this.d.postDelayed(new o(this), paramInt);
  }
  
  public void a(String paramString)
  {
    a(1, paramString);
  }
  
  public void b()
  {
    a(0, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/main/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */