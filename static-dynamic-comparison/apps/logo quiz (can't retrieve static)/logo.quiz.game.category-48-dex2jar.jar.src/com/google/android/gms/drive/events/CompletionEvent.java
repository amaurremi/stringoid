package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.ae;
import com.google.android.gms.drive.internal.ae.a;
import com.google.android.gms.drive.internal.v;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.jy;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent
  implements SafeParcelable, ResourceEvent
{
  public static final Parcelable.Creator<CompletionEvent> CREATOR = new b();
  public static final int STATUS_CONFLICT = 2;
  public static final int STATUS_FAILURE = 1;
  public static final int STATUS_SUCCESS = 0;
  final int BR;
  final String Dd;
  final int Fa;
  final DriveId MO;
  final ParcelFileDescriptor NF;
  final ParcelFileDescriptor NG;
  final MetadataBundle NH;
  final ArrayList<String> NI;
  final IBinder NJ;
  private boolean NK = false;
  private boolean NL = false;
  private boolean NM = false;
  
  CompletionEvent(int paramInt1, DriveId paramDriveId, String paramString, ParcelFileDescriptor paramParcelFileDescriptor1, ParcelFileDescriptor paramParcelFileDescriptor2, MetadataBundle paramMetadataBundle, ArrayList<String> paramArrayList, int paramInt2, IBinder paramIBinder)
  {
    this.BR = paramInt1;
    this.MO = paramDriveId;
    this.Dd = paramString;
    this.NF = paramParcelFileDescriptor1;
    this.NG = paramParcelFileDescriptor2;
    this.NH = paramMetadataBundle;
    this.NI = paramArrayList;
    this.Fa = paramInt2;
    this.NJ = paramIBinder;
  }
  
  private void L(boolean paramBoolean)
  {
    hU();
    this.NM = true;
    jy.a(this.NF);
    jy.a(this.NG);
    if (this.NJ == null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder().append("No callback on ");
      if (paramBoolean) {}
      for (str = "snooze";; str = "dismiss")
      {
        v.q("CompletionEvent", str);
        return;
      }
    }
    StringBuilder localStringBuilder2;
    try
    {
      ae.a.X(this.NJ).L(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localStringBuilder2 = new StringBuilder().append("RemoteException on ");
      if (!paramBoolean) {}
    }
    for (String str = "snooze";; str = "dismiss")
    {
      v.q("CompletionEvent", str + ": " + localRemoteException);
      return;
    }
  }
  
  private void hU()
  {
    if (this.NM) {
      throw new IllegalStateException("Event has already been dismissed or snoozed.");
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void dismiss()
  {
    L(false);
  }
  
  public String getAccountName()
  {
    hU();
    return this.Dd;
  }
  
  public InputStream getBaseContentsInputStream()
  {
    hU();
    if (this.NF == null) {
      return null;
    }
    if (this.NK) {
      throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
    }
    this.NK = true;
    return new FileInputStream(this.NF.getFileDescriptor());
  }
  
  public DriveId getDriveId()
  {
    hU();
    return this.MO;
  }
  
  public InputStream getModifiedContentsInputStream()
  {
    hU();
    if (this.NG == null) {
      return null;
    }
    if (this.NL) {
      throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
    }
    this.NL = true;
    return new FileInputStream(this.NG.getFileDescriptor());
  }
  
  public MetadataChangeSet getModifiedMetadataChangeSet()
  {
    hU();
    if (this.NH != null) {
      return new MetadataChangeSet(this.NH);
    }
    return null;
  }
  
  public int getStatus()
  {
    hU();
    return this.Fa;
  }
  
  public List<String> getTrackingTags()
  {
    hU();
    return new ArrayList(this.NI);
  }
  
  public int getType()
  {
    return 2;
  }
  
  public void snooze()
  {
    L(true);
  }
  
  public String toString()
  {
    if (this.NI == null) {}
    for (String str = "<null>";; str = "'" + TextUtils.join("','", this.NI) + "'") {
      return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", new Object[] { this.MO, Integer.valueOf(this.Fa), str });
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/events/CompletionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */