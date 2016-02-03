package com.google.android.gms.plus.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.d;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.model.people.PersonBuffer;

final class s
  extends hb<d>.d<a.d<People.LoadPeopleResult>>
  implements People.LoadPeopleResult
{
  private final Status b;
  private final String c;
  private PersonBuffer d;
  
  public s(a.d<People.LoadPeopleResult> paramd, Status paramStatus, DataHolder paramDataHolder, String paramString)
  {
    super(paramd, paramStatus, paramString);
    this.b = paramDataHolder;
    String str;
    this.c = str;
  }
  
  protected void a(a.d<People.LoadPeopleResult> paramd, DataHolder paramDataHolder)
  {
    if (paramDataHolder != null) {}
    for (paramDataHolder = new PersonBuffer(paramDataHolder);; paramDataHolder = null)
    {
      this.d = paramDataHolder;
      paramd.a(this);
      return;
    }
  }
  
  public String getNextPageToken()
  {
    return this.c;
  }
  
  public PersonBuffer getPersonBuffer()
  {
    return this.d;
  }
  
  public Status getStatus()
  {
    return this.b;
  }
  
  public void release()
  {
    if (this.d != null) {
      this.d.close();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/internal/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */