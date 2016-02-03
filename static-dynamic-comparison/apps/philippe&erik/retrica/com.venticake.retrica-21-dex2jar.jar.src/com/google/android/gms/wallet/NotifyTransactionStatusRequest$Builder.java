package com.google.android.gms.wallet;

import android.text.TextUtils;
import com.google.android.gms.internal.hm;

public final class NotifyTransactionStatusRequest$Builder
{
  private NotifyTransactionStatusRequest$Builder(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest) {}
  
  public NotifyTransactionStatusRequest build()
  {
    boolean bool2 = true;
    if (!TextUtils.isEmpty(this.ajS.aiQ))
    {
      bool1 = true;
      hm.b(bool1, "googleTransactionId is required");
      if ((this.ajS.status < 1) || (this.ajS.status > 8)) {
        break label64;
      }
    }
    label64:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      hm.b(bool1, "status is an unrecognized value");
      return this.ajS;
      bool1 = false;
      break;
    }
  }
  
  public Builder setDetailedReason(String paramString)
  {
    this.ajS.ajR = paramString;
    return this;
  }
  
  public Builder setGoogleTransactionId(String paramString)
  {
    this.ajS.aiQ = paramString;
    return this;
  }
  
  public Builder setStatus(int paramInt)
  {
    this.ajS.status = paramInt;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/NotifyTransactionStatusRequest$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */