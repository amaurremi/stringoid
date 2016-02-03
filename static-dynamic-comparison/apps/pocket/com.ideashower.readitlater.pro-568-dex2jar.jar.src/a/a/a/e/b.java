package a.a.a.e;

import a.a.a.d.f;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils.TruncateAt;
import android.util.TypedValue;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class b
  extends RelativeLayout
{
  protected RelativeLayout a = null;
  protected boolean b = false;
  protected boolean c = false;
  
  public b(Context paramContext)
  {
    this(paramContext, true);
  }
  
  public b(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, true, false);
  }
  
  public b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext);
    if (paramBoolean1) {
      setLayoutHorizontally(paramContext);
    }
    for (;;)
    {
      this.c = paramBoolean2;
      a(paramContext);
      b(paramContext);
      c(paramContext);
      d(this.a, paramContext);
      return;
      this.b = false;
    }
  }
  
  private void a(Context paramContext)
  {
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    setBackgroundColor(-1);
    setLayoutParams(paramContext);
  }
  
  private void a(RelativeLayout paramRelativeLayout, Context paramContext)
  {
    paramContext = new TextView(paramContext);
    paramContext.setId(4098);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    int i = (int)TypedValue.applyDimension(1, 20.0F, getResources().getDisplayMetrics());
    localLayoutParams.setMargins(i, i, i, 0);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setShadowLayer(1.0F, 0.0F, 1.0F, -1);
    paramContext.setSingleLine(true);
    paramContext.setTextColor(-16777216);
    paramContext.setTextSize(2, 20.0F);
    paramContext.setTypeface(null, 1);
    paramRelativeLayout.addView(paramContext);
  }
  
  private void b(Context paramContext)
  {
    this.a = new RelativeLayout(paramContext);
    this.a.setId(4097);
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.b)
    {
      localLayoutParams = new RelativeLayout.LayoutParams((int)TypedValue.applyDimension(1, 250.0F, getResources().getDisplayMetrics()), -1);
      localLayoutParams.addRule(9, -1);
      this.a.setPadding(0, 0, 0, 0);
    }
    for (;;)
    {
      this.a.setLayoutParams(localLayoutParams);
      this.a.setBackgroundColor(Color.rgb(230, 236, 239));
      a(this.a, paramContext);
      b(this.a, paramContext);
      c(this.a, paramContext);
      addView(this.a);
      return;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      this.a.setPadding(0, 0, 0, (int)TypedValue.applyDimension(1, 20.0F, getResources().getDisplayMetrics()));
    }
  }
  
  private void b(RelativeLayout paramRelativeLayout, Context paramContext)
  {
    paramContext = new TextView(paramContext);
    paramContext.setId(4099);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    int i = (int)TypedValue.applyDimension(1, 20.0F, getResources().getDisplayMetrics());
    localLayoutParams.setMargins(i, (int)TypedValue.applyDimension(1, 10.0F, getResources().getDisplayMetrics()), i, 0);
    localLayoutParams.addRule(3, 4098);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setShadowLayer(1.0F, 0.0F, 1.0F, -1);
    paramContext.setLines(2);
    paramContext.setLineSpacing(0.0F, 1.1F);
    paramContext.setTextColor(-16777216);
    paramContext.setTextSize(2, 16.0F);
    paramContext.setTypeface(null, 1);
    paramRelativeLayout.addView(paramContext);
  }
  
  private void c(Context paramContext)
  {
    WebView localWebView = new WebView(paramContext);
    localWebView.setId(4101);
    int i = (int)TypedValue.applyDimension(1, 400.0F, paramContext.getResources().getDisplayMetrics());
    if (this.c)
    {
      paramContext = new RelativeLayout.LayoutParams(-1, i);
      if (!this.b) {
        break label92;
      }
      paramContext.addRule(1, 4097);
    }
    for (;;)
    {
      paramContext.setMargins(0, 0, 0, 0);
      localWebView.setLayoutParams(paramContext);
      localWebView.setBackgroundColor(-1);
      addView(localWebView);
      return;
      i = -1;
      break;
      label92:
      paramContext.addRule(3, 4097);
    }
  }
  
  private void c(RelativeLayout paramRelativeLayout, Context paramContext)
  {
    paramContext = new Button(paramContext);
    paramContext.setId(4100);
    int i = (int)TypedValue.applyDimension(1, 20.0F, getResources().getDisplayMetrics());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)TypedValue.applyDimension(1, 120.0F, getResources().getDisplayMetrics()), -2);
    localLayoutParams.setMargins(i, i, i, i);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(3, 4099);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setBackgroundDrawable(getButtonSelector());
    paramContext.setText("Update");
    paramContext.setTextColor(-1);
    paramContext.setTextSize(2, 16.0F);
    paramRelativeLayout.addView(paramContext);
  }
  
  private void d(RelativeLayout paramRelativeLayout, Context paramContext)
  {
    int i = (int)TypedValue.applyDimension(1, 3.0F, getResources().getDisplayMetrics());
    ImageView localImageView = new ImageView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.b)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(1, -1);
      localLayoutParams.addRule(11, -1);
      localImageView.setBackgroundDrawable(new ColorDrawable(-16777216));
      localImageView.setLayoutParams(localLayoutParams);
      paramRelativeLayout.addView(localImageView);
      paramRelativeLayout = new ImageView(paramContext);
      paramContext = new RelativeLayout.LayoutParams(-1, i);
      if (!this.b) {
        break label159;
      }
      paramContext.addRule(10, -1);
    }
    for (;;)
    {
      paramRelativeLayout.setLayoutParams(paramContext);
      paramRelativeLayout.setBackgroundDrawable(f.a());
      addView(paramRelativeLayout);
      return;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, i);
      localLayoutParams.addRule(10, -1);
      localImageView.setBackgroundDrawable(f.a());
      break;
      label159:
      paramContext.addRule(3, 4097);
    }
  }
  
  private Drawable getButtonSelector()
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
    localStateListDrawable.addState(new int[] { -16842919 }, localColorDrawable);
    localColorDrawable = new ColorDrawable(-12303292);
    localStateListDrawable.addState(new int[] { -16842919, 16842908 }, localColorDrawable);
    localColorDrawable = new ColorDrawable(-7829368);
    localStateListDrawable.addState(new int[] { 16842919 }, localColorDrawable);
    return localStateListDrawable;
  }
  
  private void setLayoutHorizontally(Context paramContext)
  {
    if (getResources().getConfiguration().orientation == 2)
    {
      this.b = true;
      return;
    }
    this.b = false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/a/a/a/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */