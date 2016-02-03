package a.a.a.e;

import a.a.a.d.f;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class a
  extends RelativeLayout
{
  public a(Context paramContext, String paramString)
  {
    super(paramContext);
    a(paramContext);
    b(paramContext);
    a(paramContext, paramString);
  }
  
  private void a(Context paramContext)
  {
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    setBackgroundColor(-1);
    setLayoutParams(paramContext);
  }
  
  private void a(Context paramContext, String paramString)
  {
    int i = (int)TypedValue.applyDimension(1, 20.0F, getResources().getDisplayMetrics());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(13, -1);
    localLayoutParams.setMargins(i, i, i, i);
    paramContext = new TextView(paramContext);
    paramContext.setGravity(17);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setText(paramString);
    paramContext.setTextColor(-16777216);
    addView(paramContext);
  }
  
  private void b(Context paramContext)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)TypedValue.applyDimension(1, 3.0F, getResources().getDisplayMetrics()));
    localLayoutParams.addRule(10, -1);
    paramContext = new ImageView(paramContext);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setBackgroundDrawable(f.a());
    addView(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/a/a/a/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */