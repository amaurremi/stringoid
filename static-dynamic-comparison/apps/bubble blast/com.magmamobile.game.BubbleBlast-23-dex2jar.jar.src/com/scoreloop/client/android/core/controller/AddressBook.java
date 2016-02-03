package com.scoreloop.client.android.core.controller;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.Contacts.ContactMethods;
import com.scoreloop.client.android.core.utils.Base64;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class AddressBook
{
  private static final String[] a = { "data" };
  private static AddressBook b;
  private List<String> c;
  private String d;
  private MessageDigest e;
  private HashAlgorithm f;
  
  public AddressBook()
  {
    a(HashAlgorithm.SHA1);
  }
  
  public static AddressBook a()
  {
    if (b == null) {
      b = new AddressBook();
    }
    return b;
  }
  
  private String b(String paramString)
  {
    return paramString.trim().replaceAll("\t", "").toLowerCase();
  }
  
  private void c(Context paramContext)
  {
    d(paramContext);
  }
  
  private void c(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    this.e.reset();
    try
    {
      this.e.update(b(paramString).getBytes("UTF8"));
      if (this.d != null) {
        this.e.update(this.d.getBytes("UTF8"));
      }
      this.c.add(Base64.a(this.e.digest()));
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalStateException("Unsupported encoding");
    }
  }
  
  private void d(Context paramContext)
  {
    if (this.e == null) {
      this.e = HashAlgorithm.a(this.f);
    }
    this.c = new ArrayList();
    paramContext = b(paramContext).iterator();
    while (paramContext.hasNext()) {
      c((String)paramContext.next());
    }
  }
  
  public List<String> a(Context paramContext)
  {
    c(paramContext);
    return this.c;
  }
  
  public void a(HashAlgorithm paramHashAlgorithm)
  {
    if ((paramHashAlgorithm != this.f) || (this.e == null))
    {
      this.f = paramHashAlgorithm;
      this.e = null;
    }
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  protected List<String> b(Context paramContext)
  {
    paramContext = paramContext.getContentResolver().query(Contacts.ContactMethods.CONTENT_EMAIL_URI, a, null, null, null);
    ArrayList localArrayList = new ArrayList();
    if (paramContext != null)
    {
      int i = paramContext.getColumnIndex("data");
      if (paramContext.moveToFirst()) {
        do
        {
          localArrayList.add(paramContext.getString(i));
        } while (paramContext.moveToNext());
      }
    }
    return localArrayList;
  }
  
  public static enum HashAlgorithm
  {
    private final String a;
    
    private HashAlgorithm(String paramString)
    {
      this.a = paramString;
    }
    
    private MessageDigest a()
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance(this.a);
        return localMessageDigest;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        throw new IllegalStateException("Failed to create a MessageDigest");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/AddressBook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */