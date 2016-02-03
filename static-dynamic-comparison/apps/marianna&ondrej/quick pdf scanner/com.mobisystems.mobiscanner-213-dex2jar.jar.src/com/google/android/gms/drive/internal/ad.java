package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.j.c;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.b.b;
import com.google.android.gms.drive.d.a;
import com.google.android.gms.drive.h;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.a;
import com.google.android.gms.drive.query.b;

public class ad
  extends ae
  implements com.google.android.gms.drive.d
{
  public ad(DriveId paramDriveId)
  {
    super(paramDriveId);
  }
  
  public com.google.android.gms.common.api.d<d.a> a(com.google.android.gms.common.api.c paramc, final h paramh, final Contents paramContents)
  {
    if (paramh == null) {
      throw new IllegalArgumentException("MetatadataChangeSet must be provided.");
    }
    if (paramContents == null) {
      throw new IllegalArgumentException("Contents must be provided.");
    }
    if ("application/vnd.google-apps.folder".equals(paramh.getMimeType())) {
      throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
    }
    paramc.b(new z()
    {
      protected void a(aa paramAnonymousaa)
      {
        paramContents.close();
        paramAnonymousaa.nn().a(new CreateFileRequest(ad.this.mV(), paramh.na(), paramContents), new ad.a(this));
      }
      
      public d.a g(Status paramAnonymousStatus)
      {
        return new ad.b(paramAnonymousStatus, null);
      }
    });
  }
  
  public com.google.android.gms.common.api.d<b.b> a(com.google.android.gms.common.api.c paramc, Query paramQuery)
  {
    Query.a locala = new Query.a().a(b.a(com.google.android.gms.drive.query.c.uj, mV()));
    if (paramQuery != null)
    {
      if (paramQuery.nv() != null) {
        locala.a(paramQuery.nv());
      }
      locala.av(paramQuery.nw());
    }
    return new y().b(paramc, locala.nx());
  }
  
  private static class a
    extends p
  {
    private final j.c<d.a> tu;
    
    public a(j.c<d.a> paramc)
    {
      this.tu = paramc;
    }
    
    public void a(OnDriveIdResponse paramOnDriveIdResponse)
    {
      this.tu.H(new ad.b(Status.rc, new ab(paramOnDriveIdResponse.mV())));
    }
    
    public void c(Status paramStatus)
    {
      this.tu.H(new ad.b(paramStatus, null));
    }
  }
  
  private static class b
    implements d.a
  {
    private final com.google.android.gms.drive.c tN;
    private final Status ty;
    
    public b(Status paramStatus, com.google.android.gms.drive.c paramc)
    {
      this.ty = paramStatus;
      this.tN = paramc;
    }
    
    public com.google.android.gms.drive.c mS()
    {
      return this.tN;
    }
    
    public Status mq()
    {
      return this.ty;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/internal/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */