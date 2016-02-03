package com.mobisystems.mobiscanner.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.mobisystems.mobiscanner.common.c;

public class CameraShutterView
  extends View
{
  private static int aKq;
  private static int aKr;
  private static int aKs;
  private static int aKt;
  private ShapeDrawable aKu;
  private final c mLog = new c(this);
  
  public CameraShutterView(Context paramContext)
  {
    super(paramContext);
    aKq = paramContext.getResources().getDimensionPixelSize(2131230800);
    aKr = 0;
    aKs = paramContext.getResources().getColor(2131427366);
    aKt = paramContext.getResources().getInteger(2131492868);
  }
  
  private void j(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.aKu = new ShapeDrawable(new RectShape());
    Paint localPaint = this.aKu.getPaint();
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(0.0F);
    localPaint.setColor(aKr);
    this.aKu.setBounds(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
  
  public void EW()
  {
    this.mLog.dl("animateShutter called");
    startAnimation(new a(aKt, 0, aKq));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.aKu.draw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      this.mLog.dl("onLayout called, l=" + paramInt1 + ", t=" + paramInt2 + ", r=" + paramInt3 + ", b=" + paramInt4);
      j(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public class a
    extends Animation
  {
    private int aKv;
    private int aKw;
    private boolean azH = false;
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      setDuration(paramInt1);
      this.aKv = paramInt2;
      this.aKw = paramInt3;
    }
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      super.applyTransformation(paramFloat, paramTransformation);
      if (paramFloat < 0.5F)
      {
        paramTransformation = CameraShutterView.a(CameraShutterView.this).getPaint();
        paramTransformation.setStrokeWidth(this.aKv + (this.aKw - this.aKv) * 2 * paramFloat);
        paramTransformation.setColor(CameraShutterView.JD());
        CameraShutterView.this.invalidate();
      }
      do
      {
        return;
        if (paramFloat < 1.0F)
        {
          paramTransformation = CameraShutterView.a(CameraShutterView.this).getPaint();
          paramTransformation.setStrokeWidth(this.aKw - (this.aKw - this.aKv) * 2 * (paramFloat - 0.5F));
          paramTransformation.setColor(CameraShutterView.JD());
          CameraShutterView.this.invalidate();
          return;
        }
      } while (this.azH);
      paramTransformation = CameraShutterView.a(CameraShutterView.this).getPaint();
      paramTransformation.setStrokeWidth(0.0F);
      paramTransformation.setColor(CameraShutterView.JE());
      CameraShutterView.this.invalidate();
      this.azH = true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/view/CameraShutterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */