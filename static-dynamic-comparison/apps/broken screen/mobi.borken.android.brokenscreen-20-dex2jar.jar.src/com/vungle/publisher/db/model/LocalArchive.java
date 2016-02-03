package com.vungle.publisher.db.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.vungle.publisher.as;
import com.vungle.publisher.at.b;
import com.vungle.publisher.bk;
import com.vungle.publisher.bl;
import com.vungle.publisher.bl.a;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.protocol.message.RequestLocalAdResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

public class LocalArchive
  extends BaseViewable<LocalAd, LocalVideo, RequestLocalAdResponse>
  implements as
{
  ArchiveEntry[] e;
  boolean f;
  boolean g;
  boolean h;
  @Inject
  Factory i;
  @Inject
  ArchiveEntry.Factory j;
  @Inject
  LocalAd.Factory k;
  @Inject
  LocalViewableDelegate l;
  
  private boolean D()
  {
    File localFile = this.l.b();
    try
    {
      final ArrayList localArrayList = new ArrayList();
      bl.a(this.l.b(), new File(w()), new bl.a[] { new bl.a()
      {
        public final void a(File paramAnonymousFile, long paramAnonymousLong)
        {
          Logger.v("VunglePrepare", "extracted " + paramAnonymousFile + ": " + paramAnonymousLong + " bytes");
          List localList = localArrayList;
          Object localObject = LocalArchive.this.j;
          LocalArchive localLocalArchive = LocalArchive.this;
          int i = (int)paramAnonymousLong;
          localObject = ((ArchiveEntry.Factory)localObject).a();
          ((ArchiveEntry)localObject).a = localLocalArchive;
          ((ArchiveEntry)localObject).b = paramAnonymousFile.getName();
          ((ArchiveEntry)localObject).c = Integer.valueOf(i);
          localList.add(localObject);
        }
      } });
      a((ArchiveEntry[])localArrayList.toArray(new ArchiveEntry[localArrayList.size()]), true);
      return true;
    }
    catch (IOException localIOException)
    {
      Logger.w("VunglePrepare", "error extracting " + localFile, localIOException);
    }
    return false;
  }
  
  private void a(ArchiveEntry[] paramArrayOfArchiveEntry, boolean paramBoolean)
  {
    this.e = paramArrayOfArchiveEntry;
    this.g = paramBoolean;
    this.f = true;
  }
  
  public final boolean A()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.l.g())
    {
      bool1 = bool2;
      if (D()) {
        bool1 = C();
      }
    }
    return bool1;
  }
  
  public final boolean B()
  {
    return this.l.f();
  }
  
  public final boolean C()
  {
    ArchiveEntry[] arrayOfArchiveEntry = q();
    int n = arrayOfArchiveEntry.length;
    int m = 0;
    while (m < n)
    {
      ArchiveEntry localArchiveEntry = arrayOfArchiveEntry[m];
      Object localObject = bk.a(new Object[] { localArchiveEntry.a.w(), localArchiveEntry.b });
      boolean bool;
      if (localObject == null)
      {
        localObject = null;
        if (localArchiveEntry.c != null) {
          break label116;
        }
        Logger.w("VunglePrepare", localObject + " size is null");
        bool = false;
      }
      for (;;)
      {
        if (bool) {
          break label234;
        }
        return false;
        localObject = new File((String)localObject);
        break;
        label116:
        int i1 = (int)((File)localObject).length();
        int i2 = localArchiveEntry.c.intValue();
        if (i1 == i2) {}
        for (bool = true;; bool = false)
        {
          if (!bool) {
            break label185;
          }
          Logger.v("VunglePrepare", localObject + " size verified " + i1);
          break;
        }
        label185:
        Logger.d("VunglePrepare", localObject + " size " + i1 + " doesn't match expected " + i2);
        bool = ((File)localObject).exists();
      }
      label234:
      m += 1;
    }
    return true;
  }
  
  protected final ContentValues a(boolean paramBoolean)
  {
    ContentValues localContentValues = super.a(paramBoolean);
    this.l.a(localContentValues);
    return localContentValues;
  }
  
  public final void a(Integer paramInteger)
  {
    this.l.d = paramInteger;
  }
  
  public final void a(String paramString)
  {
    this.l.c = paramString;
  }
  
  public final String j()
  {
    return this.l.c;
  }
  
  public final String k()
  {
    return "zip";
  }
  
  public final int l()
  {
    int m = super.l();
    if (m == 1)
    {
      if (!this.h) {
        break label173;
      }
      this.j.a((Integer)this.n);
      localObject = w();
      Logger.d("VungleDatabase", "deleting " + this.c + " directory " + (String)localObject);
      if (!bk.a(w())) {
        break label137;
      }
      Logger.v("VungleDatabase", "deleting " + this.c + " directory " + (String)localObject);
      this.e = null;
      this.h = true;
      Logger.v("VungleDatabase", "resetting areArchiveEntriesDeleted = false");
      this.h = false;
    }
    label137:
    label173:
    while (!this.g) {
      for (;;)
      {
        return m;
        Logger.w("VungleDatabase", "failed to delete " + this.c + " directory " + (String)localObject);
      }
    }
    Object localObject = this.j;
    ArchiveEntry.Factory.a(this.e);
    Logger.v("VungleDatabase", "resetting areArchiveEntriesNew = false");
    this.g = false;
    return m;
  }
  
  protected final StringBuilder n()
  {
    StringBuilder localStringBuilder = super.n();
    this.l.a(localStringBuilder);
    return localStringBuilder;
  }
  
  public final ArchiveEntry[] q()
  {
    if (!this.f) {
      a(this.j.a(this), false);
    }
    return this.e;
  }
  
  public final String w()
  {
    return bk.a(new Object[] { this.l.a(), this.c });
  }
  
  public final String x()
  {
    return this.l.c();
  }
  
  public final void y()
  {
    this.l.d();
  }
  
  public final boolean z()
  {
    return this.l.e();
  }
  
  @Singleton
  static class Factory
    extends BaseViewable.Factory<LocalAd, LocalArchive, LocalVideo, RequestLocalAdResponse>
  {
    @Inject
    Provider<LocalArchive> a;
    @Inject
    LocalViewableDelegate.Factory c;
    
    private LocalArchive a(LocalArchive paramLocalArchive, Cursor paramCursor, boolean paramBoolean)
    {
      super.a(paramLocalArchive, paramCursor, paramBoolean);
      paramLocalArchive.l.a(paramCursor);
      if (paramBoolean) {
        paramLocalArchive.q();
      }
      return paramLocalArchive;
    }
    
    private LocalArchive c()
    {
      LocalArchive localLocalArchive = (LocalArchive)this.a.get();
      localLocalArchive.l = this.c.a(localLocalArchive);
      return localLocalArchive;
    }
    
    final LocalArchive a(LocalAd paramLocalAd, RequestLocalAdResponse paramRequestLocalAdResponse, at.b paramb)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      String str;
      if (paramRequestLocalAdResponse != null) {
        switch (LocalArchive.2.a[paramb.ordinal()])
        {
        default: 
          throw new IllegalArgumentException("cannot create archive of type: " + paramb);
        case 1: 
          str = paramRequestLocalAdResponse.t;
          localObject1 = localObject2;
          if (str != null)
          {
            localObject1 = (LocalArchive)super.a(paramLocalAd, paramRequestLocalAdResponse);
            ((LocalArchive)localObject1).c = paramb;
            ((LocalArchive)localObject1).a(str);
          }
          break;
        }
      }
      do
      {
        return (LocalArchive)localObject1;
        str = paramRequestLocalAdResponse.u;
        localObject1 = localObject2;
      } while (str == null);
      paramLocalAd = (LocalArchive)super.a(paramLocalAd, paramRequestLocalAdResponse);
      paramLocalAd.c = paramb;
      paramLocalAd.a(str);
      return paramLocalAd;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/LocalArchive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */