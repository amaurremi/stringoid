package com.mobisystems.mobiscanner.controller;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.a;
import com.google.android.gms.drive.b;
import com.google.android.gms.drive.b.a;
import com.google.android.gms.drive.d.a;
import com.google.android.gms.drive.h.a;

class h
  implements g<b.a>
{
  private static final com.mobisystems.mobiscanner.common.c apd = new com.mobisystems.mobiscanner.common.c();
  private final DriveId azO;
  private String azP;
  private String azQ;
  private com.google.android.gms.common.api.c azR;
  private g<d.a> azS;
  
  h(String paramString1, String paramString2, com.google.android.gms.common.api.c paramc, DriveId paramDriveId, g<d.a> paramg)
  {
    this.azP = paramString1;
    this.azQ = paramString2;
    this.azR = paramc;
    this.azS = paramg;
    this.azO = paramDriveId;
  }
  
  public void a(b.a parama)
  {
    apd.dl("onResult result = " + parama.mq().toString());
    if (!parama.mq().mu())
    {
      apd.dl("Error while trying to create new file contents");
      return;
    }
    com.google.android.gms.drive.h localh = new h.a().ar(this.azP).as(this.azQ).nb();
    a.sO.b(this.azR, this.azO).a(this.azR, localh, parama.mQ()).a(this.azS);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */