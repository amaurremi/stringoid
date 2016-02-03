package com.pocket.widget.premium;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.ideashower.readitlater.util.i;
import com.ideashower.readitlater.views.ResizeDetectRelativeLayout;
import com.ideashower.readitlater.views.RilButton;
import com.pocket.billing.google.GooglePremiumProduct;
import com.pocket.billing.google.a;
import com.pocket.stats.k;
import com.pocket.widget.RainbowProgressCircleView;

public class PremiumUpgradeView
  extends ResizeDetectRelativeLayout
  implements View.OnClickListener, com.pocket.billing.f
{
  private RainbowProgressCircleView a;
  private RilButton b;
  private RilButton c;
  private RilButton d;
  private View e;
  private com.pocket.billing.e f;
  private PremiumUpgradeBlockView g;
  private ImageView h;
  private PremiumUpgradeBlockView i;
  private ImageView j;
  private PremiumUpgradeBlockView k;
  private ImageView l;
  private Bundle m;
  private com.pocket.billing.f n;
  private GooglePremiumProduct o;
  private String p;
  private boolean q;
  private boolean r;
  private View s;
  
  public PremiumUpgradeView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PremiumUpgradeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PremiumUpgradeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(RilButton paramRilButton, int paramInt, com.pocket.billing.d paramd)
  {
    String str = paramd.a();
    Object localObject = getResources().getString(paramInt);
    localObject = new SpannableString(str + "\n" + (String)localObject);
    ((Spannable)localObject).setSpan(new RelativeSizeSpan(0.68F), str.length(), ((Spannable)localObject).length(), 34);
    paramRilButton.setText((CharSequence)localObject);
    paramRilButton.setTag(paramd);
    paramRilButton.setVisibility(0);
  }
  
  private void a(GooglePremiumProduct paramGooglePremiumProduct)
  {
    this.o = paramGooglePremiumProduct;
    String str = paramGooglePremiumProduct.a();
    if (paramGooglePremiumProduct.f().equals(a.a.b)) {
      com.pocket.stats.d.h.a(str, this.p);
    }
    while (!paramGooglePremiumProduct.f().equals(a.a.c)) {
      return;
    }
    com.pocket.stats.d.i.a(str, this.p);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.o == null) {
      return;
    }
    boolean bool = this.o.f().equals(a.a.b);
    String str = this.o.a();
    if (paramBoolean)
    {
      if (bool)
      {
        com.pocket.stats.d.j.a(str, this.p);
        return;
      }
      com.pocket.stats.d.k.a(str, this.p);
      return;
    }
    if (bool)
    {
      com.pocket.stats.d.l.a(str, this.p);
      return;
    }
    com.pocket.stats.d.m.a(str, this.p);
  }
  
  private void g()
  {
    TextView localTextView = (TextView)findViewById(2131231107);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localTextView.getText());
    com.pocket.text.c localc = new com.pocket.text.c();
    localc.a(i.a(i.b));
    localSpannableStringBuilder.setSpan(localc, 0, "pocket".length(), 18);
    localTextView.setText(localSpannableStringBuilder);
  }
  
  private void h()
  {
    if (this.f.e())
    {
      this.n.c();
      return;
    }
    setButtonState(f.a);
    this.f.c();
  }
  
  private void i()
  {
    if (this.o == null) {}
    while (this.q) {
      return;
    }
    this.q = true;
    boolean bool = this.o.f().equals(a.a.b);
    String str = this.o.a();
    if (bool)
    {
      com.pocket.stats.d.n.a(str, this.p);
      return;
    }
    com.pocket.stats.d.o.a(str, this.p);
  }
  
  private void setButtonState(f paramf)
  {
    int i2 = 8;
    switch (1.a[paramf.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.a.setVisibility(0);
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      this.e.setVisibility(8);
      return;
    case 2: 
      this.a.setVisibility(8);
      this.b.setVisibility(0);
      this.c.setVisibility(8);
      this.e.setVisibility(8);
      return;
    case 3: 
      this.a.setVisibility(8);
      this.b.setVisibility(8);
      paramf = this.c;
      if (this.c.getText().length() > 0) {}
      for (int i1 = 0;; i1 = 8)
      {
        paramf.setVisibility(i1);
        paramf = this.e;
        i1 = i2;
        if (this.d.getText().length() > 0) {
          i1 = 0;
        }
        paramf.setVisibility(i1);
        if ((!(this.d.getTag() instanceof GooglePremiumProduct)) || (!((GooglePremiumProduct)this.d.getTag()).i().equalsIgnoreCase("USD"))) {
          break;
        }
        this.s.setVisibility(0);
        return;
      }
      this.s.setVisibility(4);
      return;
    }
    this.a.setVisibility(8);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.e.setVisibility(8);
  }
  
  public void a()
  {
    setButtonState(f.b);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.f.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Activity paramActivity, String paramString, com.pocket.billing.f paramf)
  {
    this.n = paramf;
    this.p = paramString;
    LayoutInflater.from(getContext()).inflate(2130903166, this, true);
    g();
    this.a = ((RainbowProgressCircleView)findViewById(2131230758));
    this.b = ((RilButton)findViewById(2131231109));
    this.c = ((RilButton)findViewById(2131231110));
    this.d = ((RilButton)findViewById(2131231113));
    this.e = findViewById(2131231111);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.s = findViewById(2131231112);
    this.g = ((PremiumUpgradeBlockView)findViewById(2131231116));
    this.h = ((ImageView)findViewById(2131231119));
    this.i = ((PremiumUpgradeBlockView)findViewById(2131231117));
    this.j = ((ImageView)findViewById(2131231120));
    this.k = ((PremiumUpgradeBlockView)findViewById(2131231118));
    this.l = ((ImageView)findViewById(2131231121));
    this.s.setBackgroundDrawable(new e(this));
    this.s.setVisibility(4);
    setButtonState(f.a);
    this.f = new com.pocket.billing.e(paramActivity, this, this.m);
  }
  
  public void a(com.pocket.billing.g paramg)
  {
    this.n.a(paramg);
    if (paramg == com.pocket.billing.g.c) {
      i();
    }
  }
  
  public void a(com.pocket.billing.google.g paramg)
  {
    if (paramg.a() != null)
    {
      a(this.c, 2131493309, paramg.a());
      if (paramg.b() != null) {
        a(this.d, 2131493310, paramg.b());
      }
    }
    for (;;)
    {
      this.r = true;
      setButtonState(f.c);
      return;
      if (paramg.b() != null) {
        a(this.c, 2131493310, paramg.b());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.r) {
      setButtonState(f.c);
    }
    for (;;)
    {
      b(paramBoolean);
      return;
      setButtonState(f.b);
    }
  }
  
  public void b()
  {
    this.n.c();
  }
  
  public void c() {}
  
  public void d()
  {
    this.n.d();
    i();
  }
  
  public void e()
  {
    this.n.e();
  }
  
  public void f()
  {
    if (this.f != null) {
      this.f.f();
    }
  }
  
  public ImageView getCircleArchive()
  {
    return this.h;
  }
  
  public ImageView getCircleSearch()
  {
    return this.j;
  }
  
  public ImageView getCircleTags()
  {
    return this.l;
  }
  
  public PremiumUpgradeBlockView getDetailsArchive()
  {
    return this.g;
  }
  
  public PremiumUpgradeBlockView getDetailsSearch()
  {
    return this.i;
  }
  
  public PremiumUpgradeBlockView getDetailsTags()
  {
    return this.k;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.b) {
      h();
    }
    while ((paramView != this.c) && (paramView != this.d)) {
      return;
    }
    this.n.a(com.pocket.billing.g.a);
    paramView = (com.pocket.billing.d)paramView.getTag();
    a((GooglePremiumProduct)paramView);
    this.f.a(paramView);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    Parcelable localParcelable = paramParcelable;
    if ((paramParcelable instanceof Bundle))
    {
      this.m = ((Bundle)paramParcelable);
      this.o = ((GooglePremiumProduct)this.m.getParcelable("pendingPurchase"));
      this.p = this.m.getString("asource");
      localParcelable = this.m.getParcelable("superState");
    }
    super.onRestoreInstanceState(localParcelable);
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("superState", super.onSaveInstanceState());
    if (this.f != null) {
      this.f.a(localBundle);
    }
    localBundle.putParcelable("pendingPurchase", this.o);
    localBundle.putString("asource", this.p);
    return localBundle;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/premium/PremiumUpgradeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */