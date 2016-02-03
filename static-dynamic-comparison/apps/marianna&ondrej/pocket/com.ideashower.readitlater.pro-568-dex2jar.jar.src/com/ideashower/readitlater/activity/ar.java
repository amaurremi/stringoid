package com.ideashower.readitlater.activity;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.ideashower.readitlater.e.t;
import com.ideashower.readitlater.reader.f;

public class ar
  extends at
{
  private int ad;
  
  public ar(ReaderFragment paramReaderFragment)
  {
    super(paramReaderFragment);
  }
  
  public AlertDialog.Builder a(AlertDialog.Builder paramBuilder)
  {
    final int i = l().getInt("imageNum");
    this.Z = l().getString("clickedUrl");
    if (ReaderFragment.v(this.Y) == null) {
      ReaderFragment.b(this.Y, new String[] { c(2131493491), c(2131493465) });
    }
    paramBuilder.setItems(ReaderFragment.v(this.Y), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        default: 
          return;
        case 0: 
          ImageViewerActivity.a(ar.this.m(), t.b(ReaderFragment.c(ar.this.Y).h()), i);
          return;
        }
        ReaderFragment.a(ar.this.Y, ar.this.Z, true);
      }
    });
    return paramBuilder;
  }
  
  public void b(int paramInt)
  {
    this.ad = paramInt;
  }
  
  protected Bundle l(Bundle paramBundle)
  {
    paramBundle.putInt("imageNum", this.ad);
    return super.l(paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */