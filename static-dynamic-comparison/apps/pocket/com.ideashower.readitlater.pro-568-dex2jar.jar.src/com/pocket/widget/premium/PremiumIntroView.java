package com.pocket.widget.premium;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.ideashower.readitlater.a.e;
import com.ideashower.readitlater.views.ResizeDetectRelativeLayout;
import com.ideashower.readitlater.views.RilButton;
import com.ideashower.readitlater.views.ThemedTextView;

public class PremiumIntroView
  extends ResizeDetectRelativeLayout
{
  public PremiumIntroView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PremiumIntroView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PremiumIntroView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    findViewById(2131230774).setOnClickListener(null);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    LayoutInflater.from(getContext()).inflate(2130903165, this, true);
    findViewById(2131230774).setOnClickListener(paramOnClickListener);
    if (e.a()) {
      ((RilButton)findViewById(2131230774)).setText(2131493801);
    }
    paramOnClickListener = (ThemedTextView)findViewById(2131231098);
    String str = paramOnClickListener.getText().toString();
    paramOnClickListener.setText(" " + str + " ");
    setVisibility(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/premium/PremiumIntroView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */