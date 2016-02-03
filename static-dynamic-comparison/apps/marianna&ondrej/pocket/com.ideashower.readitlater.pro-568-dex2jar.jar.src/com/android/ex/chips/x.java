package com.android.ex.chips;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;

@TargetApi(11)
public class x
  extends CursorAdapter
{
  private final LayoutInflater a;
  private final long b;
  private int c;
  private y d;
  
  private View a()
  {
    return this.a.inflate(2130903079, null);
  }
  
  public static HashMap a(Context paramContext, ArrayList paramArrayList)
  {
    w localw = v.a();
    int j = Math.min(50, paramArrayList.size());
    String[] arrayOfString = new String[j];
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = Rfc822Tokenizer.tokenize(((String)paramArrayList.get(i)).toLowerCase());
      if (localObject.length > 0) {}
      for (localObject = localObject[0].getAddress();; localObject = (String)paramArrayList.get(i))
      {
        arrayOfString[i] = localObject;
        localStringBuilder.append("?");
        if (i < j - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
        break;
      }
    }
    if (Log.isLoggable("RecipAlternates", 3)) {
      Log.d("RecipAlternates", "Doing reverse lookup for " + arrayOfString.toString());
    }
    paramArrayList = new HashMap();
    paramContext = paramContext.getContentResolver().query(localw.c(), localw.a(), localw.a()[1] + " IN (" + localStringBuilder.toString() + ")", arrayOfString, null);
    if (paramContext != null) {}
    try
    {
      if (paramContext.moveToFirst())
      {
        boolean bool;
        do
        {
          localObject = paramContext.getString(1);
          paramArrayList.put(localObject, aa.a(paramContext.getString(0), paramContext.getString(1), paramContext.getLong(4), paramContext.getLong(5), paramContext.getString(7)));
          if (Log.isLoggable("RecipAlternates", 3)) {
            Log.d("RecipAlternates", "Received reverse look up information for " + (String)localObject + " RESULTS: " + " NAME : " + paramContext.getString(0) + " CONTACT ID : " + paramContext.getLong(4) + " ADDRESS :" + paramContext.getString(1));
          }
          bool = paramContext.moveToNext();
        } while (bool);
      }
      return paramArrayList;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  public aa a(int paramInt)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    return aa.a(localCursor.getString(0), localCursor.getString(1), localCursor.getLong(4), localCursor.getLong(5), localCursor.getString(7));
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    int i = paramCursor.getPosition();
    paramContext = (TextView)paramView.findViewById(2131230915);
    ImageView localImageView = (ImageView)paramView.findViewById(2131230733);
    aa localaa = a(i);
    if (i == 0)
    {
      paramContext.setText(paramCursor.getString(0));
      paramContext.setVisibility(0);
      localImageView.setImageURI(localaa.f());
    }
    for (;;)
    {
      ((TextView)paramView.findViewById(2131230916)).setText(paramCursor.getString(1));
      return;
      paramContext.setVisibility(8);
    }
  }
  
  public long getItemId(int paramInt)
  {
    Cursor localCursor = getCursor();
    if (localCursor.moveToPosition(paramInt)) {
      localCursor.getLong(5);
    }
    return -1L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = a();
    }
    if (localCursor.getLong(5) == this.b)
    {
      this.c = paramInt;
      if (this.d != null) {
        this.d.b(this.c);
      }
    }
    bindView(paramViewGroup, paramViewGroup.getContext(), localCursor);
    return paramViewGroup;
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */