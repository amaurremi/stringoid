package com.mobeta.android.dslv;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class e
  extends d
{
  private a aoK;
  private b aoL;
  protected int[] dM;
  protected int[] dN;
  private int dO = -1;
  String[] dR;
  
  public e(Context paramContext, int paramInt1, Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt2)
  {
    super(paramContext, paramInt1, paramCursor, paramInt2);
    this.dN = paramArrayOfInt;
    this.dR = paramArrayOfString;
    a(paramCursor, paramArrayOfString);
  }
  
  private void a(Cursor paramCursor, String[] paramArrayOfString)
  {
    if (paramCursor != null)
    {
      int j = paramArrayOfString.length;
      if ((this.dM == null) || (this.dM.length != j)) {
        this.dM = new int[j];
      }
      int i = 0;
      while (i < j)
      {
        this.dM[i] = paramCursor.getColumnIndexOrThrow(paramArrayOfString[i]);
        i += 1;
      }
    }
    this.dM = null;
  }
  
  public void a(b paramb)
  {
    this.aoL = paramb;
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    b localb = this.aoL;
    int j = this.dN.length;
    int[] arrayOfInt1 = this.dM;
    int[] arrayOfInt2 = this.dN;
    int i = 0;
    View localView;
    if (i < j)
    {
      localView = paramView.findViewById(arrayOfInt2[i]);
      if (localView != null) {
        if (localb == null) {
          break label190;
        }
      }
    }
    label129:
    label150:
    label190:
    for (boolean bool = localb.setViewValue(localView, paramCursor, arrayOfInt1[i]);; bool = false)
    {
      if (!bool)
      {
        String str = paramCursor.getString(arrayOfInt1[i]);
        paramContext = str;
        if (str == null) {
          paramContext = "";
        }
        if (!(localView instanceof TextView)) {
          break label129;
        }
        setViewText((TextView)localView, paramContext);
      }
      for (;;)
      {
        i += 1;
        break;
        if (!(localView instanceof ImageView)) {
          break label150;
        }
        setViewImage((ImageView)localView, paramContext);
      }
      throw new IllegalStateException(localView.getClass().getName() + " is not a " + " view that can be bounds by this SimpleCursorAdapter");
      return;
    }
  }
  
  public CharSequence convertToString(Cursor paramCursor)
  {
    if (this.aoK != null) {
      return this.aoK.convertToString(paramCursor);
    }
    if (this.dO > -1) {
      return paramCursor.getString(this.dO);
    }
    return super.convertToString(paramCursor);
  }
  
  public void setViewImage(ImageView paramImageView, String paramString)
  {
    try
    {
      paramImageView.setImageResource(Integer.parseInt(paramString));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      paramImageView.setImageURI(Uri.parse(paramString));
    }
  }
  
  public void setViewText(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString);
  }
  
  public Cursor swapCursor(Cursor paramCursor)
  {
    a(paramCursor, this.dR);
    return super.swapCursor(paramCursor);
  }
  
  public static abstract interface a
  {
    public abstract CharSequence convertToString(Cursor paramCursor);
  }
  
  public static abstract interface b
  {
    public abstract boolean setViewValue(View paramView, Cursor paramCursor, int paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobeta/android/dslv/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */