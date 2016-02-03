package com.pocket.q.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.ideashower.readitlater.util.j;

public class k
  extends o
{
  private final TextView a;
  
  public k(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2130903159, this);
    this.a = ((TextView)findViewById(2131230902));
    a(getInnerCellPaddingLeft(), 0, getInnerCellPaddingRight(), 0);
    setMinimumHeight(getResources().getDimensionPixelSize(2131296326));
    setDividerHeight(j.a(2.0F));
    setDividerOffset(j.a(1.0F));
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    setBottomDividerEnabled(true);
    super.dispatchDraw(paramCanvas);
  }
  
  public void setLabel(String paramString)
  {
    this.a.setText(paramString.toUpperCase());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/q/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */