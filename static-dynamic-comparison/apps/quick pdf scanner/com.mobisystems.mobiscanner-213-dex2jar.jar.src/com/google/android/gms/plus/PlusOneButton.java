package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.internal.df;
import com.google.android.gms.plus.internal.g;

public final class PlusOneButton
  extends FrameLayout
{
  private String Fv;
  private int U;
  private View VX;
  private int VY;
  private int VZ;
  private b Wa;
  
  public PlusOneButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PlusOneButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.U = c(paramContext, paramAttributeSet);
    this.VY = d(paramContext, paramAttributeSet);
    this.VZ = -1;
    A(getContext());
    if (isInEditMode()) {}
  }
  
  private void A(Context paramContext)
  {
    if (this.VX != null) {
      removeView(this.VX);
    }
    this.VX = g.a(paramContext, this.U, this.VY, this.Fv, this.VZ);
    a(this.Wa);
    addView(this.VX);
  }
  
  protected static int c(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = df.a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", paramContext, paramAttributeSet, true, false, "PlusOneButton");
    if ("SMALL".equalsIgnoreCase(paramContext)) {
      return 0;
    }
    if ("MEDIUM".equalsIgnoreCase(paramContext)) {
      return 1;
    }
    if ("TALL".equalsIgnoreCase(paramContext)) {
      return 2;
    }
    return 3;
  }
  
  protected static int d(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i = 0;
    paramContext = df.a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", paramContext, paramAttributeSet, true, false, "PlusOneButton");
    if ("INLINE".equalsIgnoreCase(paramContext)) {
      i = 2;
    }
    while ("NONE".equalsIgnoreCase(paramContext)) {
      return i;
    }
    return 1;
  }
  
  public void a(b paramb)
  {
    this.Wa = paramb;
    this.VX.setOnClickListener(new a(paramb));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.VX.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = this.VX;
    measureChild(localView, paramInt1, paramInt2);
    setMeasuredDimension(localView.getMeasuredWidth(), localView.getMeasuredHeight());
  }
  
  protected class a
    implements View.OnClickListener, PlusOneButton.b
  {
    private final PlusOneButton.b Wb;
    
    public a(PlusOneButton.b paramb)
    {
      this.Wb = paramb;
    }
    
    public void b(Intent paramIntent)
    {
      Context localContext = PlusOneButton.this.getContext();
      if (((localContext instanceof Activity)) && (paramIntent != null)) {
        ((Activity)localContext).startActivityForResult(paramIntent, PlusOneButton.b(PlusOneButton.this));
      }
    }
    
    public void onClick(View paramView)
    {
      paramView = (Intent)PlusOneButton.a(PlusOneButton.this).getTag();
      if (this.Wb != null)
      {
        this.Wb.b(paramView);
        return;
      }
      b(paramView);
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(Intent paramIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/plus/PlusOneButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */