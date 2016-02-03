package com.mobisystems.pdf.signatures;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import com.mobisystems.pdf.R.string;

public class PDFSignatureStrings
{
  private static boolean mInitialized = false;
  private static SparseArray<String> mSigModStatusArray;
  private static SparseArray<String> mSigStatusArray;
  private static SparseArray<String> mSigTypeArray;
  
  public static void init(Context paramContext)
  {
    if (mInitialized) {
      return;
    }
    paramContext = paramContext.getResources();
    mSigTypeArray = new SparseArray();
    mSigTypeArray.append(0, paramContext.getString(R.string.pdf_sig_type_unknown));
    mSigTypeArray.append(1, paramContext.getString(R.string.pdf_sig_type_certification));
    mSigTypeArray.append(2, paramContext.getString(R.string.pdf_sig_type_approval));
    mSigTypeArray.append(3, paramContext.getString(R.string.pdf_sig_type_usage_rights));
    mSigTypeArray.append(4, paramContext.getString(R.string.pdf_sig_type_time_stamp));
    mSigStatusArray = new SparseArray();
    mSigStatusArray.append(0, paramContext.getString(R.string.pdf_sig_status_unknown));
    mSigStatusArray.append(1, paramContext.getString(R.string.pdf_sig_status_not_signed));
    mSigStatusArray.append(2, paramContext.getString(R.string.pdf_sig_status_verified));
    mSigStatusArray.append(3, paramContext.getString(R.string.pdf_sig_status_invalid));
    mSigModStatusArray = new SparseArray();
    mSigModStatusArray.append(0, paramContext.getString(R.string.pdf_sig_mod_status_unknown));
    mSigModStatusArray.append(1, paramContext.getString(R.string.pdf_sig_mod_status_ok));
    mSigModStatusArray.append(2, paramContext.getString(R.string.pdf_sig_mod_status_failure));
    mSigModStatusArray.append(3, paramContext.getString(R.string.pdf_sig_mod_status_unexpected));
    mSigModStatusArray.append(4, paramContext.getString(R.string.pdf_sig_mod_status_invalid_revision));
    mInitialized = true;
  }
  
  public static String sigModStatus(int paramInt)
  {
    return (String)mSigModStatusArray.get(paramInt, "???");
  }
  
  public static String sigStatus(int paramInt)
  {
    return (String)mSigStatusArray.get(paramInt, "???");
  }
  
  public static String sigType(int paramInt)
  {
    return (String)mSigTypeArray.get(paramInt, "???");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/signatures/PDFSignatureStrings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */