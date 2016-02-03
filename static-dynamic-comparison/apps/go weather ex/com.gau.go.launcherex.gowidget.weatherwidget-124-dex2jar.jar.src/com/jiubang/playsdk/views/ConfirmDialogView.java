package com.jiubang.playsdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.f;
import com.jiubang.playsdk.g;
import com.jiubang.playsdk.main.c;

public class ConfirmDialogView
  extends LinearLayout
{
  private TextView a;
  private View b;
  private View c;
  private int d;
  private String e;
  
  public ConfirmDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static ConfirmDialogView a(Context paramContext)
  {
    return (ConfirmDialogView)View.inflate(paramContext, g.c, null);
  }
  
  public int a()
  {
    return this.d;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.b.setOnClickListener(paramOnClickListener);
  }
  
  public void a(String paramString)
  {
    this.a.setText(paramString);
  }
  
  public String b()
  {
    return this.e;
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.c.setOnClickListener(paramOnClickListener);
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((TextView)findViewById(f.az));
    this.b = ((TextView)findViewById(f.p));
    this.b.setBackgroundResource(aa.a().b().l());
    this.c = ((TextView)findViewById(f.af));
    this.c.setBackgroundResource(aa.a().b().l());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/ConfirmDialogView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */