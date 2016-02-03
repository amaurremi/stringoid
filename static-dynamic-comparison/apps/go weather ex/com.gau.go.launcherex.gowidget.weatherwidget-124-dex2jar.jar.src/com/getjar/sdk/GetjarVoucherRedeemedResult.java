package com.getjar.sdk;

import com.getjar.sdk.utilities.StringUtility;

public class GetjarVoucherRedeemedResult
{
  private final int _keyIndex;
  private final String _licenseSignature;
  private final String _signedLicenseData;
  private final String _signedTransactionData;
  private final String _transactionSignature;
  
  public GetjarVoucherRedeemedResult(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("'keyIndex' can not be less than zero");
    }
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'transactionSignature' can not be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'signedTransactionData' can not be NULL or empty");
    }
    this._keyIndex = paramInt;
    this._transactionSignature = paramString1;
    this._signedTransactionData = paramString2;
    this._licenseSignature = paramString3;
    this._signedLicenseData = paramString4;
  }
  
  public int getKeyIndex()
  {
    return this._keyIndex;
  }
  
  public String getLicenseSignature()
  {
    return this._licenseSignature;
  }
  
  public String getSignedLicenseData()
  {
    return this._signedLicenseData;
  }
  
  public String getSignedTransactionData()
  {
    return this._signedTransactionData;
  }
  
  public String getTransactionSignature()
  {
    return this._transactionSignature;
  }
  
  public boolean hasLicense()
  {
    return (!StringUtility.isNullOrEmpty(this._signedLicenseData)) && (!StringUtility.isNullOrEmpty(this._licenseSignature));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/GetjarVoucherRedeemedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */