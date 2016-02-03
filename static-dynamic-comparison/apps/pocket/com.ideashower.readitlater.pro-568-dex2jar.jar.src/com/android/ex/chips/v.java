package com.android.ex.chips;

import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import com.ideashower.readitlater.util.a;

public class v
{
  private static final w a;
  private static final w b;
  
  static
  {
    Uri localUri1 = ContactsContract.CommonDataKinds.Email.CONTENT_FILTER_URI;
    Uri localUri2 = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
    a = new w(new String[] { "display_name", "data1", "data2", "data3", "contact_id", "_id", "display_name_source", "photo_thumb_uri" }, localUri1, localUri2) {};
    localUri1 = ContactsContract.CommonDataKinds.Email.CONTENT_FILTER_URI;
    localUri2 = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
    b = new w(new String[] { "display_name", "data1", "data2", "data3", "contact_id", "_id", "display_name_source", "photo_id" }, localUri1, localUri2) {};
  }
  
  public static w a()
  {
    if (a.e()) {
      return a;
    }
    return b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */