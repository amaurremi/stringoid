package com.pocket.widget.premium;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.ideashower.readitlater.views.ResizeDetectRelativeLayout;
import com.ideashower.readitlater.views.RilButton;
import com.ideashower.readitlater.views.ThemedTextView;

public class PremiumPurchasedView
  extends ResizeDetectRelativeLayout
{
  private PremiumIconHeart a;
  
  public PremiumPurchasedView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PremiumPurchasedView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PremiumPurchasedView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(TextView paramTextView, CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      paramTextView.setVisibility(0);
      paramTextView.setText(paramCharSequence);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    LayoutInflater.from(getContext()).inflate(2130903168, this, true);
    this.a = ((PremiumIconHeart)findViewById(2131231123));
    ThemedTextView localThemedTextView = (ThemedTextView)findViewById(2131230768);
    TextView localTextView1 = (TextView)findViewById(2131230963);
    RilButton localRilButton = getButton();
    TextView localTextView2 = (TextView)findViewById(2131231124);
    if (!TextUtils.isEmpty(paramString1)) {
      localThemedTextView.setText(" " + paramString1 + " ");
    }
    a(localTextView1, paramString2);
    a(localRilButton, paramString3);
    a(localTextView2, paramString4);
    setVisibility(0);
  }
  
  public RilButton getButton()
  {
    return (RilButton)findViewById(2131230774);
  }
  
  public PremiumIconHeart getHeartIconSet()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/premium/PremiumPurchasedView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */