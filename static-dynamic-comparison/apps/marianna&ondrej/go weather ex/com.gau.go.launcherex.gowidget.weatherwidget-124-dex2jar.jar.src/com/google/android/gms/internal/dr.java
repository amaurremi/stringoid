package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class dr
{
  private final Context mContext;
  private int mState = 0;
  private String rh;
  private final float ri;
  private float rj;
  private float rk;
  private float rl;
  
  public dr(Context paramContext)
  {
    this.mContext = paramContext;
    this.ri = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public dr(Context paramContext, String paramString)
  {
    this(paramContext);
    this.rh = paramString;
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (paramInt == 0)
    {
      this.mState = 0;
      this.rj = paramFloat1;
      this.rk = paramFloat2;
      this.rl = paramFloat2;
    }
    label24:
    label224:
    do
    {
      do
      {
        break label24;
        do
        {
          return;
        } while (this.mState == -1);
        if (paramInt != 2) {
          break;
        }
        if (paramFloat2 > this.rk) {
          this.rk = paramFloat2;
        }
        while (this.rk - this.rl > 30.0F * this.ri)
        {
          this.mState = -1;
          return;
          if (paramFloat2 < this.rl) {
            this.rl = paramFloat2;
          }
        }
        if ((this.mState == 0) || (this.mState == 2)) {
          if (paramFloat1 - this.rj >= 50.0F * this.ri) {
            this.rj = paramFloat1;
          }
        }
        for (this.mState += 1;; this.mState += 1)
        {
          do
          {
            if ((this.mState != 1) && (this.mState != 3)) {
              break label224;
            }
            if (paramFloat1 <= this.rj) {
              break;
            }
            this.rj = paramFloat1;
            return;
          } while (((this.mState != 1) && (this.mState != 3)) || (paramFloat1 - this.rj > -50.0F * this.ri));
          this.rj = paramFloat1;
        }
      } while ((this.mState != 2) || (paramFloat1 >= this.rj));
      this.rj = paramFloat1;
      return;
    } while ((paramInt != 1) || (this.mState != 4));
    showDialog();
  }
  
  private void showDialog()
  {
    Object localObject2;
    final Object localObject1;
    if (!TextUtils.isEmpty(this.rh))
    {
      localObject2 = new Uri.Builder().encodedQuery(this.rh).build();
      localObject1 = new StringBuilder();
      localObject2 = dq.b((Uri)localObject2);
      Iterator localIterator = ((Map)localObject2).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((StringBuilder)localObject1).append(str).append(" = ").append((String)((Map)localObject2).get(str)).append("\n\n");
      }
      localObject1 = ((StringBuilder)localObject1).toString().trim();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    for (;;)
    {
      localObject2 = new AlertDialog.Builder(this.mContext);
      ((AlertDialog.Builder)localObject2).setMessage((CharSequence)localObject1);
      ((AlertDialog.Builder)localObject2).setTitle("Ad Information");
      ((AlertDialog.Builder)localObject2).setPositiveButton("Share", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          dr.a(dr.this).startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", localObject1), "Share via"));
        }
      });
      ((AlertDialog.Builder)localObject2).setNegativeButton("Close", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      ((AlertDialog.Builder)localObject2).create().show();
      return;
      localObject1 = "No debug information";
      continue;
      localObject1 = "No debug information";
    }
  }
  
  public void c(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getHistorySize();
    int i = 0;
    while (i < j)
    {
      a(paramMotionEvent.getActionMasked(), paramMotionEvent.getHistoricalX(0, i), paramMotionEvent.getHistoricalY(0, i));
      i += 1;
    }
    a(paramMotionEvent.getActionMasked(), paramMotionEvent.getX(), paramMotionEvent.getY());
  }
  
  public void t(String paramString)
  {
    this.rh = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/dr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */