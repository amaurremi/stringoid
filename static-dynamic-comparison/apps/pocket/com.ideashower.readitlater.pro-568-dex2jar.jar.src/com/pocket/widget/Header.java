package com.pocket.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.ThemedTextView;

public class Header
  extends ThemedTextView
{
  private Paint a;
  private int b;
  
  public Header(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public Header(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public Header(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public static Header a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramContext.getString(paramInt));
  }
  
  public static Header a(Context paramContext, String paramString)
  {
    paramContext = (Header)LayoutInflater.from(paramContext).inflate(2130903143, null);
    paramContext.setText(paramString.toUpperCase());
    return paramContext;
  }
  
  private void a()
  {
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.b = j.a(1.0F);
    b();
    setText(getText().toString().toUpperCase());
  }
  
  private void b()
  {
    this.a.setColor(getPaint().getColor());
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    b();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawRect(0.0F, getHeight() - this.b, getWidth(), getHeight(), this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/Header.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */