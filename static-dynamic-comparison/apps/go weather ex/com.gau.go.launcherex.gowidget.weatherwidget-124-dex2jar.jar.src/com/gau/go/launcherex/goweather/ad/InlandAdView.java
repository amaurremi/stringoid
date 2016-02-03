package com.gau.go.launcherex.goweather.ad;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gau.go.launcherex.goweather.ad.a.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InlandAdView
  extends LinearLayout
{
  private Context a;
  private com.gau.go.launcherex.goweather.ad.a.a b;
  private int c = -1;
  private TextView d;
  private ImageView e;
  private Bitmap f;
  private boolean g = false;
  private boolean h = false;
  private Runnable i;
  private a j;
  
  public InlandAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    this.j = new a(this.a);
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    float f1 = getContext().getResources().getDisplayMetrics().density * 52.0F / k;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f1);
    return Bitmap.createBitmap(paramBitmap, 0, 0, k, m, localMatrix, true);
  }
  
  private String d()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = this.a.getFileStreamPath("ad_image");
    InputStreamReader localInputStreamReader;
    BufferedReader localBufferedReader;
    if ((localObject != null) && (((File)localObject).exists())) {
      try
      {
        localObject = new FileInputStream((File)localObject);
        localInputStreamReader = new InputStreamReader((InputStream)localObject);
        localBufferedReader = new BufferedReader(localInputStreamReader);
        for (;;)
        {
          String str = localBufferedReader.readLine();
          if (str == null) {
            break;
          }
          localStringBuffer.append(str);
        }
        return localStringBuffer.toString();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    for (;;)
    {
      localBufferedReader.close();
      localInputStreamReader.close();
      localIOException.close();
    }
  }
  
  public void a()
  {
    setVisibility(4);
    this.h = true;
  }
  
  public void a(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      b localb = (b)this.b.f().get(paramInt);
      if (localb != null) {
        this.d.setText(localb.b);
      }
    }
  }
  
  public void a(com.gau.go.launcherex.goweather.ad.a.a parama)
  {
    if (parama != null)
    {
      this.g = true;
      this.b = parama;
      if (this.f == null)
      {
        this.f = h.a(d());
        if (this.f != null) {
          this.f = a(this.f);
        }
      }
      this.e.setImageBitmap(this.f);
      if (this.i == null) {
        this.i = new j(this);
      }
    }
  }
  
  public void b()
  {
    postDelayed(this.i, 10000L);
  }
  
  public void c()
  {
    this.j.a(this.b.e());
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.d = ((TextView)findViewById(2131231685));
    this.e = ((ImageView)findViewById(2131231686));
    this.e.setOnClickListener(new i(this));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/ad/InlandAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */