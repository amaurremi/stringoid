package com.mobisystems.mobiscanner.controller;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.g;
import com.google.android.gms.drive.a;
import com.google.android.gms.drive.b;
import com.google.android.gms.drive.d.a;

class z
  implements g<d.a>
{
  private static final com.mobisystems.mobiscanner.common.c apd = new com.mobisystems.mobiscanner.common.c();
  private aa aCI;
  private aa.a aCJ;
  private String azP;
  private com.google.android.gms.common.api.c azR;
  private Context mContext;
  
  public z(com.google.android.gms.common.api.c paramc, aa paramaa, Context paramContext, String paramString, aa.a parama)
  {
    this.azR = paramc;
    this.aCI = paramaa;
    this.mContext = paramContext;
    this.azP = paramString;
    this.aCJ = parama;
  }
  
  public void a(d.a parama)
  {
    if (!parama.mq().mu())
    {
      apd.dl("Error while trying to create the file");
      return;
    }
    parama = parama.mS().mV();
    com.google.android.gms.drive.c localc = a.sO.a(this.azR, parama);
    if (this.aCI == null) {
      this.aCI = new aa(parama, this.azR, this.mContext, this.azP, this.aCJ);
    }
    localc.a(this.azR, 536870912, null).a(this.aCI);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */