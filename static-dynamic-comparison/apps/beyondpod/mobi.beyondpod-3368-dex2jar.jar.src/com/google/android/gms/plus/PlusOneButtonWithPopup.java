package com.google.android.gms.plus;

import android.app.PendingIntent;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.hq;
import com.google.android.gms.internal.hq.a;
import com.google.android.gms.internal.ht;

public final class PlusOneButtonWithPopup
  extends ViewGroup
{
  private View DB;
  private int DC;
  private View.OnClickListener DH;
  private String iH;
  private String jG;
  private int mSize;
  
  public PlusOneButtonWithPopup(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PlusOneButtonWithPopup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mSize = PlusOneButton.getSize(paramContext, paramAttributeSet);
    this.DC = PlusOneButton.getAnnotation(paramContext, paramAttributeSet);
    this.DB = new PlusOneDummyView(paramContext, this.mSize);
    addView(this.DB);
  }
  
  private int c(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    switch (i)
    {
    default: 
      return paramInt1;
    }
    return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1) - paramInt2, i);
  }
  
  private void eL()
  {
    if (this.DB != null) {
      removeView(this.DB);
    }
    this.DB = ht.a(getContext(), this.mSize, this.DC, this.iH, this.jG);
    if (this.DH != null) {
      setOnClickListener(this.DH);
    }
    addView(this.DB);
  }
  
  private hq eM()
    throws RemoteException
  {
    hq localhq = hq.a.aw((IBinder)this.DB.getTag());
    if (localhq == null)
    {
      if (Log.isLoggable("PlusOneButtonWithPopup", 5)) {
        Log.w("PlusOneButtonWithPopup", "Failed to get PlusOneDelegate");
      }
      throw new RemoteException();
    }
    return localhq;
  }
  
  public void cancelClick()
  {
    if (this.DB != null) {}
    try
    {
      eM().cancelClick();
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  public PendingIntent getResolution()
  {
    if (this.DB != null) {
      try
      {
        PendingIntent localPendingIntent = eM().getResolution();
        return localPendingIntent;
      }
      catch (RemoteException localRemoteException) {}
    }
    return null;
  }
  
  public void initialize(String paramString1, String paramString2)
  {
    eg.b(paramString1, "Url must not be null");
    this.iH = paramString1;
    this.jG = paramString2;
    eL();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.DB.layout(getPaddingLeft(), getPaddingTop(), paramInt3 - paramInt1 - getPaddingRight(), paramInt4 - paramInt2 - getPaddingBottom());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getPaddingLeft() + getPaddingRight();
    int j = getPaddingTop() + getPaddingBottom();
    this.DB.measure(c(paramInt1, i), c(paramInt2, j));
    setMeasuredDimension(i + this.DB.getMeasuredWidth(), j + this.DB.getMeasuredHeight());
  }
  
  public void reinitialize()
  {
    if (this.DB != null) {}
    try
    {
      eM().reinitialize();
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  public void setAnnotation(int paramInt)
  {
    this.DC = paramInt;
    eL();
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.DH = paramOnClickListener;
    this.DB.setOnClickListener(paramOnClickListener);
  }
  
  public void setSize(int paramInt)
  {
    this.mSize = paramInt;
    eL();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/plus/PlusOneButtonWithPopup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */