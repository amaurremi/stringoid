package com.chiralcode.colorpicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;

public class ColorPicker
  extends View
{
  private final int eK = 2;
  private final int eL = 5;
  private final int eM = 10;
  private final int eO = 4;
  private Paint eP;
  private Paint eQ;
  private Paint eR;
  private Paint eS;
  private RectF eT;
  private Paint eU;
  private Paint eV;
  private RectF eW;
  private RectF eX;
  private Path eY;
  private Path eZ;
  private Path fa;
  private Bitmap fb;
  private int fc;
  private int fd;
  private int fe;
  private int ff;
  private int fg;
  private int fh;
  private int fi;
  private Matrix fj;
  private float[] fk = { 0.0F, 0.0F, 1.0F };
  
  public ColorPicker(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ColorPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ColorPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void a(Canvas paramCanvas)
  {
    int i = getWidth() / 2;
    int j = getHeight() / 2;
    double d2 = (this.fk[2] - 0.5F) * 3.141592653589793D;
    double d6 = 0.032724923474893676D + d2;
    double d5 = d2 - 0.032724923474893676D;
    double d1 = Math.cos(d2) * this.fg;
    d2 = Math.sin(d2) * this.fg;
    double d3 = Math.cos(d6);
    double d4 = this.fg + this.ff;
    d6 = Math.sin(d6);
    double d7 = this.fg + this.ff;
    double d8 = Math.cos(d5);
    double d9 = this.fg + this.ff;
    d5 = Math.sin(d5);
    double d10 = this.fg + this.ff;
    this.fa.reset();
    this.fa.moveTo((float)d1 + i, (float)d2 + j);
    this.fa.lineTo((float)(d3 * d4) + i, (float)(d6 * d7) + j);
    this.fa.lineTo((float)(d8 * d9) + i, (float)(d5 * d10) + j);
    Path localPath = this.fa;
    float f1 = (float)d1;
    float f2 = i;
    float f3 = (float)d2;
    localPath.lineTo(f2 + f1, j + f3);
    this.eV.setColor(Color.HSVToColor(this.fk));
    this.eV.setStyle(Paint.Style.FILL);
    paramCanvas.drawPath(this.fa, this.eV);
    this.eV.setStyle(Paint.Style.STROKE);
    this.eV.setStrokeJoin(Paint.Join.ROUND);
    this.eV.setColor(-16777216);
    paramCanvas.drawPath(this.fa, this.eV);
  }
  
  private void init()
  {
    this.eS = new Paint();
    this.eS.setStyle(Paint.Style.STROKE);
    this.eS.setStrokeWidth(2.0F);
    this.eS.setARGB(128, 0, 0, 0);
    this.eU = new Paint();
    this.eU.setStyle(Paint.Style.STROKE);
    this.eU.setStrokeWidth(2.0F);
    this.eV = new Paint();
    this.eP = new Paint();
    this.eP.setAntiAlias(true);
    this.eP.setDither(true);
    this.eQ = new Paint();
    this.eQ.setAntiAlias(true);
    this.eQ.setDither(true);
    this.eR = new Paint();
    this.eR.setAntiAlias(true);
    this.eY = new Path();
    this.eZ = new Path();
    this.fa = new Path();
    this.eW = new RectF();
    this.eX = new RectF();
    this.eT = new RectF();
  }
  
  private Bitmap l(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Object localObject = new int[13];
    float[] arrayOfFloat = new float[3];
    float[] tmp23_21 = arrayOfFloat;
    tmp23_21[0] = 0.0F;
    float[] tmp27_23 = tmp23_21;
    tmp27_23[1] = 1.0F;
    float[] tmp31_27 = tmp27_23;
    tmp31_27[2] = 1.0F;
    tmp31_27;
    int i = 0;
    while (i < localObject.length)
    {
      arrayOfFloat[0] = ((i * 30 + 180) % 360);
      localObject[i] = Color.HSVToColor(arrayOfFloat);
      i += 1;
    }
    localObject[12] = localObject[0];
    localObject = new ComposeShader(new SweepGradient(paramInt1 / 2, paramInt2 / 2, (int[])localObject, null), new RadialGradient(paramInt1 / 2, paramInt2 / 2, this.fi, -1, 16777215, Shader.TileMode.CLAMP), PorterDuff.Mode.SRC_OVER);
    this.eP.setShader((Shader)localObject);
    new Canvas(localBitmap).drawCircle(paramInt1 / 2, paramInt2 / 2, this.fi, this.eP);
    return localBitmap;
  }
  
  public int getColor()
  {
    return Color.HSVToColor(this.fk);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getWidth() / 2;
    int j = getHeight() / 2;
    paramCanvas.drawBitmap(this.fb, i - this.fi, j - this.fi, null);
    this.eR.setColor(Color.HSVToColor(this.fk));
    paramCanvas.drawPath(this.eY, this.eR);
    float f1 = this.fk[0];
    float f2 = this.fk[1];
    SweepGradient localSweepGradient = new SweepGradient(i, j, new int[] { -16777216, Color.HSVToColor(new float[] { f1, f2, 1.0F }), -1 }, null);
    localSweepGradient.setLocalMatrix(this.fj);
    this.eQ.setShader(localSweepGradient);
    paramCanvas.drawPath(this.eZ, this.eQ);
    f1 = (float)Math.toRadians(this.fk[0]);
    int m = (int)(-Math.cos(f1) * this.fk[1] * this.fi);
    int k = (int)(-Math.sin(f1) * this.fk[1] * this.fi);
    f1 = 0.075F * this.fi;
    m = (int)(m + i - f1 / 2.0F);
    k = (int)(k + j - f1 / 2.0F);
    this.eT.set(m, k, m + f1, k + f1);
    paramCanvas.drawOval(this.eT, this.eS);
    this.eU.setColor(Color.HSVToColor(new float[] { 0.0F, 0.0F, 1.0F - this.fk[2] }));
    double d = (this.fk[2] - 0.5F) * 3.141592653589793D;
    f1 = (float)Math.cos(d);
    f2 = (float)Math.sin(d);
    float f3 = this.fh;
    float f4 = i;
    float f5 = this.fh;
    float f6 = j;
    float f7 = this.fg;
    float f8 = i;
    float f9 = this.fg;
    paramCanvas.drawLine(f3 * f1 + f4, f5 * f2 + f6, f1 * f7 + f8, j + f9 * f2, this.eU);
    if (this.ff > 0) {
      a(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    setMeasuredDimension(paramInt1, paramInt1);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.fk = paramParcelable.getFloatArray("color");
      super.onRestoreInstanceState(paramParcelable.getParcelable("super"));
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putFloatArray("color", this.fk);
    localBundle.putParcelable("super", super.onSaveInstanceState());
    return localBundle;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = paramInt1 / 2;
    paramInt4 = paramInt2 / 2;
    this.fd = (paramInt1 * 5 / 100);
    this.fe = (paramInt1 * 2 / 100);
    this.ff = (paramInt1 * 4 / 100);
    this.fc = (paramInt1 * 10 / 100);
    this.fg = (paramInt1 / 2 - this.fe - this.ff);
    this.fh = (this.fg - this.fc);
    this.fi = (this.fh - this.fd);
    this.eW.set(paramInt3 - this.fg, paramInt4 - this.fg, this.fg + paramInt3, this.fg + paramInt4);
    this.eX.set(paramInt3 - this.fh, paramInt4 - this.fh, paramInt3 + this.fh, paramInt4 + this.fh);
    this.fb = l(this.fi * 2, this.fi * 2);
    this.fj = new Matrix();
    this.fj.preRotate(270.0F, paramInt1 / 2, paramInt2 / 2);
    this.eY.arcTo(this.eW, 270.0F, -180.0F);
    this.eY.arcTo(this.eX, 90.0F, 180.0F);
    this.eZ.arcTo(this.eW, 270.0F, 180.0F);
    this.eZ.arcTo(this.eX, 90.0F, -180.0F);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    int k;
    int j;
    double d;
    do
    {
      int i;
      do
      {
        return bool1;
        i = (int)paramMotionEvent.getX();
        k = (int)paramMotionEvent.getY();
        j = i - getWidth() / 2;
        k -= getHeight() / 2;
        d = Math.sqrt(j * j + k * k);
        if (d <= this.fi)
        {
          this.fk[0] = ((float)(Math.toDegrees(Math.atan2(k, j)) + 180.0D));
          this.fk[1] = Math.max(0.0F, Math.min(1.0F, (float)(d / this.fi)));
          invalidate();
          return true;
        }
        bool1 = bool2;
      } while (i < getWidth() / 2);
      bool1 = bool2;
    } while (d < this.fh);
    this.fk[2] = ((float)Math.max(0.0D, Math.min(1.0D, Math.atan2(k, j) / 3.141592653589793D + 0.5D)));
    invalidate();
    return true;
  }
  
  public void setColor(int paramInt)
  {
    Color.colorToHSV(paramInt, this.fk);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/chiralcode/colorpicker/ColorPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */