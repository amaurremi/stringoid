package com.vladium.emma.report;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class SourcePathCache
{
  private static final FileExtensionFilter FILE_EXTENSION_FILTER = new FileExtensionFilter(".java");
  private final Map m_packageCache;
  private final File[] m_sourcepath;
  
  public SourcePathCache(File[] paramArrayOfFile, boolean paramBoolean)
  {
    if (paramArrayOfFile == null) {
      throw new IllegalArgumentException("null input: sourcepath");
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfFile.length);
    int i = 0;
    while (i < paramArrayOfFile.length)
    {
      File localFile = paramArrayOfFile[i];
      if ((!paramBoolean) || ((localFile.isDirectory()) && (localFile.exists()))) {
        localArrayList.add(localFile);
      }
      i += 1;
    }
    this.m_sourcepath = new File[localArrayList.size()];
    localArrayList.toArray(this.m_sourcepath);
    this.m_packageCache = new HashMap();
  }
  
  public SourcePathCache(String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramArrayOfString == null) {
      throw new IllegalArgumentException("null input: sourcepath");
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfString.length);
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      File localFile = new File(paramArrayOfString[i]);
      if ((!paramBoolean) || ((localFile.isDirectory()) && (localFile.exists()))) {
        localArrayList.add(localFile);
      }
      i += 1;
    }
    this.m_sourcepath = new File[localArrayList.size()];
    localArrayList.toArray(this.m_sourcepath);
    this.m_packageCache = new HashMap();
  }
  
  private Set faultListing(File paramFile, String paramString)
  {
    File[] arrayOfFile = new File(paramFile, paramString.replace('/', File.separatorChar)).listFiles(FILE_EXTENSION_FILTER);
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      paramFile = Collections.EMPTY_SET;
      return paramFile;
    }
    paramString = new HashSet(arrayOfFile.length);
    int i = 0;
    for (;;)
    {
      paramFile = paramString;
      if (i >= arrayOfFile.length) {
        break;
      }
      paramString.add(arrayOfFile[i].getName());
      i += 1;
    }
  }
  
  public File find(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    if (paramString1 == null) {
      try
      {
        throw new IllegalArgumentException("null input: packageVMName");
      }
      finally {}
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("null input: name");
    }
    int i = this.m_sourcepath.length;
    if (i == 0)
    {
      localObject1 = localObject2;
      return (File)localObject1;
    }
    CacheEntry localCacheEntry = (CacheEntry)this.m_packageCache.get(paramString1);
    Object localObject1 = localCacheEntry;
    if (localCacheEntry == null)
    {
      localObject1 = new CacheEntry(this.m_sourcepath.length);
      this.m_packageCache.put(paramString1, localObject1);
    }
    Set[] arrayOfSet = ((CacheEntry)localObject1).m_listings;
    i = 0;
    for (;;)
    {
      localObject1 = localObject2;
      if (i >= arrayOfSet.length) {
        break;
      }
      localCacheEntry = arrayOfSet[i];
      localObject1 = localCacheEntry;
      if (localCacheEntry == null)
      {
        localObject1 = faultListing(this.m_sourcepath[i], paramString1);
        arrayOfSet[i] = localObject1;
      }
      if (((Set)localObject1).contains(paramString2))
      {
        paramString1 = new File(paramString1.replace('/', File.separatorChar), paramString2);
        localObject1 = new File(this.m_sourcepath[i], paramString1.getPath()).getAbsoluteFile();
        break;
      }
      i += 1;
    }
  }
  
  private static final class CacheEntry
  {
    final Set[] m_listings;
    
    CacheEntry(int paramInt)
    {
      this.m_listings = new Set[paramInt];
    }
  }
  
  private static final class FileExtensionFilter
    implements FileFilter
  {
    private final String m_extension;
    
    FileExtensionFilter(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("null input: extension");
      }
      String str = canonicalizeExtension(paramString);
      if (paramString.length() <= 1) {
        throw new IllegalArgumentException("empty input: extension");
      }
      this.m_extension = str;
    }
    
    private static String canonicalizeExtension(String paramString)
    {
      String str = paramString;
      if (paramString.charAt(0) != '.') {
        str = ".".concat(paramString);
      }
      return str;
    }
    
    public boolean accept(File paramFile)
    {
      if (paramFile.isDirectory()) {}
      int i;
      do
      {
        return false;
        paramFile = paramFile.getName();
        i = paramFile.lastIndexOf('.');
      } while (i <= 0);
      return this.m_extension.equals(paramFile.substring(i));
    }
    
    public String toString()
    {
      return super.toString() + ", extension = [" + this.m_extension + "]";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/SourcePathCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */