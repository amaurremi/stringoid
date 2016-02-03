package com.getjar.sdk.data;

import com.getjar.sdk.GetjarLicense;
import com.getjar.sdk.utilities.StringUtility;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class LicenseInternal
  extends GetjarLicense
  implements Serializable
{
  private static final long serialVersionUID = -2979070449375236570L;
  private boolean isLicenseStale = false;
  
  public LicenseInternal() {}
  
  public LicenseInternal(String paramString1, int paramInt, String paramString2, String paramString3, Date paramDate1, Date paramDate2, Date paramDate3)
  {
    super(paramString1, paramInt, paramString2, paramString3, paramDate1, paramDate2, paramDate3);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this.itemId = paramObjectInputStream.readUTF();
    this.keyIndex = paramObjectInputStream.readInt();
    this.signedLicenseData = paramObjectInputStream.readUTF();
    this.licenseSignature = paramObjectInputStream.readUTF();
    this.creationTime = new Date(paramObjectInputStream.readLong());
    this.modificationTime = new Date(paramObjectInputStream.readLong());
    setLastServerSyncTime(new Date(paramObjectInputStream.readLong()));
    validateObjectState();
  }
  
  private void validateObjectState()
  {
    if (StringUtility.isNullOrEmpty(getItemId())) {
      throw new IllegalStateException("itemId cannot be null or empty");
    }
    if (getKeyIndex() < 0) {
      throw new IllegalStateException("keyIndex cannot be less than 0");
    }
    if (StringUtility.isNullOrEmpty(getSignedLicenseData())) {
      throw new IllegalStateException("signedLicenseData cannot be null or empty");
    }
    if (StringUtility.isNullOrEmpty(getLicenseSignature())) {
      throw new IllegalStateException("licenseSignature cannot be null or empty");
    }
    if (getCreationTime() == null) {
      throw new IllegalStateException("creationTime cannot be null");
    }
    if (getModificationTime() == null) {
      throw new IllegalStateException("modificationTime cannot be null");
    }
    if (getLastCheckedTime() == null) {
      throw new IllegalStateException("lastCheckedTime cannot be null");
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    validateObjectState();
    paramObjectOutputStream.writeUTF(getItemId());
    paramObjectOutputStream.writeInt(getKeyIndex());
    paramObjectOutputStream.writeUTF(getSignedLicenseData());
    paramObjectOutputStream.writeUTF(getLicenseSignature());
    paramObjectOutputStream.writeLong(getCreationTime().getTime());
    paramObjectOutputStream.writeLong(getModificationTime().getTime());
    paramObjectOutputStream.writeLong(getLastCheckedTime().getTime());
  }
  
  public boolean isStale()
  {
    return this.isLicenseStale;
  }
  
  public void setLastServerSyncTimeInternal()
  {
    setLastServerSyncTime(new Date());
  }
  
  public void setLicenseStale(boolean paramBoolean)
  {
    this.isLicenseStale = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/LicenseInternal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */