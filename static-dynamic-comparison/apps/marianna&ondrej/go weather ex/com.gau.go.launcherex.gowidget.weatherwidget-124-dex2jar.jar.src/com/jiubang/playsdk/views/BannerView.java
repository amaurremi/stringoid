package com.jiubang.playsdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.a.x;
import com.jiubang.playsdk.e.a;
import com.jiubang.playsdk.e.d;
import com.jiubang.playsdk.f;
import com.jiubang.playsdk.imageload.KPNetworkImageView;
import java.util.List;

public class BannerView
  extends TouchMaskFrameLayout
  implements View.OnClickListener, q
{
  private KPNetworkImageView a;
  private com.jiubang.playsdk.e.e b;
  private d c;
  
  public BannerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public View a()
  {
    return this;
  }
  
  public void a(x paramx) {}
  
  public void a(d paramd)
  {
    if (paramd != null)
    {
      Object localObject = paramd.f();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = (com.jiubang.playsdk.e.e)((List)localObject).get(0);
        if (localObject != null)
        {
          this.a.a(com.jiubang.playsdk.e.g);
          this.a.a(((com.jiubang.playsdk.e.e)localObject).a());
          this.b = ((com.jiubang.playsdk.e.e)localObject);
        }
      }
      this.c = paramd;
    }
  }
  
  public String b()
  {
    String str2 = "";
    String str1 = str2;
    if (this.b != null)
    {
      str1 = str2;
      if (this.b.f() != null) {
        str1 = this.b.f().c();
      }
    }
    return str1;
  }
  
  public void onClick(View paramView)
  {
    if (this.b != null) {
      aa.a().a(getContext(), this.b, this.c.a());
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((KPNetworkImageView)findViewById(f.o));
    setOnClickListener(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/BannerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */