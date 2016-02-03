package org.osmdroid.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class GEMFFile
{
  private static final int FILE_COPY_BUFFER_SIZE = 1024;
  private static final long FILE_SIZE_LIMIT = 1073741824L;
  private static final int TILE_SIZE = 256;
  private static final int U32_SIZE = 4;
  private static final int U64_SIZE = 8;
  private static final int VERSION = 4;
  private int mCurrentSource = 0;
  private final List<String> mFileNames = new ArrayList();
  private final List<Long> mFileSizes = new ArrayList();
  private final List<RandomAccessFile> mFiles = new ArrayList();
  private final String mLocation;
  private final List<GEMFRange> mRangeData = new ArrayList();
  private boolean mSourceLimited = false;
  private final LinkedHashMap<Integer, String> mSources = new LinkedHashMap();
  
  public GEMFFile(File paramFile)
    throws FileNotFoundException, IOException
  {
    this(paramFile.getAbsolutePath());
  }
  
  public GEMFFile(String paramString)
    throws FileNotFoundException, IOException
  {
    this.mLocation = paramString;
    openFiles();
    readHeader();
  }
  
  public GEMFFile(String paramString, List<File> paramList)
    throws FileNotFoundException, IOException
  {
    this.mLocation = paramString;
    LinkedHashMap localLinkedHashMap1 = new LinkedHashMap();
    paramList = paramList.iterator();
    int m;
    Object localObject6;
    Object localObject8;
    Object localObject9;
    int k;
    while (paramList.hasNext())
    {
      localObject1 = (File)paramList.next();
      localLinkedHashMap2 = new LinkedHashMap();
      localObject2 = ((File)localObject1).listFiles();
      m = localObject2.length;
      i = 0;
      if (i < m)
      {
        Object localObject3 = localObject2[i];
        for (;;)
        {
          Object localObject7;
          int i1;
          Object localObject10;
          try
          {
            Integer.parseInt(((File)localObject3).getName());
            localObject5 = new LinkedHashMap();
            localObject6 = ((File)localObject3).listFiles();
            int n = localObject6.length;
            j = 0;
            if (j >= n) {
              break label352;
            }
            localObject7 = localObject6[j];
          }
          catch (NumberFormatException localNumberFormatException1) {}
          try
          {
            Integer.parseInt(((File)localObject7).getName());
            localObject8 = new LinkedHashMap();
            localObject9 = ((File)localObject7).listFiles();
            i1 = localObject9.length;
            k = 0;
            if (k >= i1) {
              break label329;
            }
            localObject10 = localObject9[k];
          }
          catch (NumberFormatException localNumberFormatException2) {}
          try
          {
            Integer.parseInt(((File)localObject10).getName().substring(0, ((File)localObject10).getName().indexOf('.')));
            ((LinkedHashMap)localObject8).put(Integer.valueOf(Integer.parseInt(((File)localObject10).getName().substring(0, ((File)localObject10).getName().indexOf('.')))), localObject10);
          }
          catch (NumberFormatException localNumberFormatException3)
          {
            continue;
          }
          k += 1;
        }
        for (;;)
        {
          i += 1;
          break;
          for (;;)
          {
            j += 1;
            break;
            label329:
            ((LinkedHashMap)localObject5).put(new Integer(localNumberFormatException2.getName()), localObject8);
          }
          label352:
          localLinkedHashMap2.put(Integer.valueOf(Integer.parseInt(localNumberFormatException1.getName())), localObject5);
        }
      }
      localLinkedHashMap1.put(((File)localObject1).getName(), localLinkedHashMap2);
    }
    Object localObject4 = new LinkedHashMap();
    LinkedHashMap localLinkedHashMap2 = new LinkedHashMap();
    int i = 0;
    paramList = localLinkedHashMap1.keySet().iterator();
    while (paramList.hasNext())
    {
      localObject1 = (String)paramList.next();
      ((LinkedHashMap)localObject4).put(localObject1, new Integer(i));
      localLinkedHashMap2.put(new Integer(i), localObject1);
      i += 1;
    }
    Object localObject2 = new ArrayList();
    Object localObject5 = localLinkedHashMap1.keySet().iterator();
    if (((Iterator)localObject5).hasNext())
    {
      localObject6 = (String)((Iterator)localObject5).next();
      Iterator localIterator = ((LinkedHashMap)localLinkedHashMap1.get(localObject6)).keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject8 = (Integer)localIterator.next();
        localObject9 = new LinkedHashMap();
        paramList = new TreeSet(((LinkedHashMap)((LinkedHashMap)localLinkedHashMap1.get(localObject6)).get(localObject8)).keySet()).iterator();
        while (paramList.hasNext())
        {
          localObject1 = (Integer)paramList.next();
          localObject11 = new ArrayList();
          localObject12 = ((LinkedHashMap)((LinkedHashMap)((LinkedHashMap)localLinkedHashMap1.get(localObject6)).get(localObject8)).get(localObject1)).keySet().iterator();
          while (((Iterator)localObject12).hasNext()) {
            ((List)localObject11).add((Integer)((Iterator)localObject12).next());
          }
          if (((List)localObject11).size() != 0)
          {
            Collections.sort((List)localObject11);
            if (!((LinkedHashMap)localObject9).containsKey(localObject11)) {
              ((LinkedHashMap)localObject9).put(localObject11, new ArrayList());
            }
            ((List)((LinkedHashMap)localObject9).get(localObject11)).add(localObject1);
          }
        }
        Object localObject11 = new LinkedHashMap();
        Object localObject12 = ((LinkedHashMap)localObject9).keySet().iterator();
        Object localObject13;
        while (((Iterator)localObject12).hasNext())
        {
          localObject13 = (List)((Iterator)localObject12).next();
          TreeSet localTreeSet = new TreeSet((Collection)((LinkedHashMap)localObject9).get(localObject13));
          paramList = new ArrayList();
          i = ((Integer)localTreeSet.first()).intValue();
          if (i < ((Integer)localTreeSet.last()).intValue() + 1)
          {
            if (localTreeSet.contains(new Integer(i)))
            {
              paramList.add(new Integer(i));
              localObject1 = paramList;
            }
            for (;;)
            {
              i += 1;
              paramList = (List<File>)localObject1;
              break;
              localObject1 = paramList;
              if (paramList.size() > 0)
              {
                ((LinkedHashMap)localObject11).put(localObject13, paramList);
                localObject1 = new ArrayList();
              }
            }
          }
          if (paramList.size() > 0) {
            ((LinkedHashMap)localObject11).put(localObject13, paramList);
          }
        }
        localObject11 = ((LinkedHashMap)localObject11).keySet().iterator();
        while (((Iterator)localObject11).hasNext())
        {
          paramList = (List)((Iterator)localObject11).next();
          localObject12 = new TreeSet(paramList);
          localObject13 = new TreeSet((Collection)((LinkedHashMap)localObject9).get(paramList));
          paramList = new GEMFRange(null);
          paramList.zoom = ((Integer)localObject8);
          paramList.sourceIndex = ((Integer)((LinkedHashMap)localObject4).get(localObject6));
          paramList.xMin = ((Integer)((TreeSet)localObject13).first());
          paramList.xMax = ((Integer)((TreeSet)localObject13).last());
          i = ((Integer)((TreeSet)localObject12).first()).intValue();
          if (i < ((Integer)((TreeSet)localObject12).last()).intValue() + 1)
          {
            if (((TreeSet)localObject12).contains(new Integer(i)))
            {
              if (paramList.yMin == null) {
                paramList.yMin = Integer.valueOf(i);
              }
              paramList.yMax = Integer.valueOf(i);
              localObject1 = paramList;
            }
            for (;;)
            {
              i += 1;
              paramList = (List<File>)localObject1;
              break;
              localObject1 = paramList;
              if (paramList.yMin != null)
              {
                ((List)localObject2).add(paramList);
                localObject1 = new GEMFRange(null);
                ((GEMFRange)localObject1).zoom = ((Integer)localObject8);
                ((GEMFRange)localObject1).sourceIndex = ((Integer)((LinkedHashMap)localObject4).get(localObject6));
                ((GEMFRange)localObject1).xMin = ((Integer)((TreeSet)localObject13).first());
                ((GEMFRange)localObject1).xMax = ((Integer)((TreeSet)localObject13).last());
              }
            }
          }
          if (paramList.yMin != null) {
            ((List)localObject2).add(paramList);
          }
        }
      }
    }
    i = 0;
    paramList = ((LinkedHashMap)localObject4).keySet().iterator();
    while (paramList.hasNext()) {
      i += ((String)paramList.next()).length() + 8;
    }
    long l1 = i + 12 + ((List)localObject2).size() * 32 + 4;
    paramList = ((List)localObject2).iterator();
    if (paramList.hasNext())
    {
      localObject1 = (GEMFRange)paramList.next();
      ((GEMFRange)localObject1).offset = Long.valueOf(l1);
      i = ((GEMFRange)localObject1).xMin.intValue();
      l2 = l1;
      for (;;)
      {
        l1 = l2;
        if (i >= ((GEMFRange)localObject1).xMax.intValue() + 1) {
          break;
        }
        j = ((GEMFRange)localObject1).yMin.intValue();
        while (j < ((GEMFRange)localObject1).yMax.intValue() + 1)
        {
          l2 += 12L;
          j += 1;
        }
        i += 1;
      }
    }
    paramList = new RandomAccessFile(paramString, "rw");
    paramList.writeInt(4);
    paramList.writeInt(256);
    paramList.writeInt(((LinkedHashMap)localObject4).size());
    Object localObject1 = ((LinkedHashMap)localObject4).keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject5 = (String)((Iterator)localObject1).next();
      paramList.writeInt(((Integer)((LinkedHashMap)localObject4).get(localObject5)).intValue());
      paramList.writeInt(((String)localObject5).length());
      paramList.write(((String)localObject5).getBytes());
    }
    paramList.writeInt(((List)localObject2).size());
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (GEMFRange)((Iterator)localObject1).next();
      paramList.writeInt(((GEMFRange)localObject4).zoom.intValue());
      paramList.writeInt(((GEMFRange)localObject4).xMin.intValue());
      paramList.writeInt(((GEMFRange)localObject4).xMax.intValue());
      paramList.writeInt(((GEMFRange)localObject4).yMin.intValue());
      paramList.writeInt(((GEMFRange)localObject4).yMax.intValue());
      paramList.writeInt(((GEMFRange)localObject4).sourceIndex.intValue());
      paramList.writeLong(((GEMFRange)localObject4).offset.longValue());
    }
    localObject1 = ((List)localObject2).iterator();
    long l3 = l1;
    long l2 = l3;
    if (((Iterator)localObject1).hasNext())
    {
      localObject4 = (GEMFRange)((Iterator)localObject1).next();
      i = ((GEMFRange)localObject4).xMin.intValue();
      for (;;)
      {
        l3 = l2;
        if (i >= ((GEMFRange)localObject4).xMax.intValue() + 1) {
          break;
        }
        j = ((GEMFRange)localObject4).yMin.intValue();
        while (j < ((GEMFRange)localObject4).yMax.intValue() + 1)
        {
          paramList.writeLong(l2);
          l3 = ((File)((LinkedHashMap)((LinkedHashMap)((LinkedHashMap)localLinkedHashMap1.get(localLinkedHashMap2.get(((GEMFRange)localObject4).sourceIndex))).get(((GEMFRange)localObject4).zoom)).get(Integer.valueOf(i))).get(Integer.valueOf(j))).length();
          paramList.writeInt((int)l3);
          l2 += l3;
          j += 1;
        }
        i += 1;
      }
    }
    localObject4 = new byte['Ѐ'];
    int j = 0;
    localObject2 = ((List)localObject2).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject5 = (GEMFRange)((Iterator)localObject2).next();
      i = ((GEMFRange)localObject5).xMin.intValue();
      localObject1 = paramList;
      k = j;
      l2 = l1;
      for (;;)
      {
        l1 = l2;
        j = k;
        paramList = (List<File>)localObject1;
        if (i >= ((GEMFRange)localObject5).xMax.intValue() + 1) {
          break;
        }
        j = ((GEMFRange)localObject5).yMin.intValue();
        paramList = (List<File>)localObject1;
        l1 = l2;
        while (j < ((GEMFRange)localObject5).yMax.intValue() + 1)
        {
          l2 = ((File)((LinkedHashMap)((LinkedHashMap)((LinkedHashMap)localLinkedHashMap1.get(localLinkedHashMap2.get(((GEMFRange)localObject5).sourceIndex))).get(((GEMFRange)localObject5).zoom)).get(Integer.valueOf(i))).get(Integer.valueOf(j))).length();
          if (l1 + l2 > 1073741824L)
          {
            paramList.close();
            k += 1;
            paramList = new RandomAccessFile(paramString + "-" + k, "rw");
          }
          for (l1 = 0L;; l1 += l2)
          {
            localObject1 = new FileInputStream((File)((LinkedHashMap)((LinkedHashMap)((LinkedHashMap)localLinkedHashMap1.get(localLinkedHashMap2.get(((GEMFRange)localObject5).sourceIndex))).get(((GEMFRange)localObject5).zoom)).get(Integer.valueOf(i))).get(Integer.valueOf(j)));
            for (m = ((FileInputStream)localObject1).read((byte[])localObject4, 0, 1024); m != -1; m = ((FileInputStream)localObject1).read((byte[])localObject4, 0, 1024)) {
              paramList.write((byte[])localObject4, 0, m);
            }
          }
          ((FileInputStream)localObject1).close();
          j += 1;
        }
        i += 1;
        l2 = l1;
        localObject1 = paramList;
      }
    }
    paramList.close();
    openFiles();
    readHeader();
  }
  
  private void openFiles()
    throws FileNotFoundException
  {
    File localFile = new File(this.mLocation);
    this.mFiles.add(new RandomAccessFile(localFile, "r"));
    this.mFileNames.add(localFile.getPath());
    int i = 0;
    for (;;)
    {
      i += 1;
      localFile = new File(this.mLocation + "-" + i);
      if (!localFile.exists()) {
        break;
      }
      this.mFiles.add(new RandomAccessFile(localFile, "r"));
      this.mFileNames.add(localFile.getPath());
    }
  }
  
  private void readHeader()
    throws IOException
  {
    RandomAccessFile localRandomAccessFile1 = (RandomAccessFile)this.mFiles.get(0);
    Object localObject = this.mFiles.iterator();
    while (((Iterator)localObject).hasNext())
    {
      RandomAccessFile localRandomAccessFile2 = (RandomAccessFile)((Iterator)localObject).next();
      this.mFileSizes.add(Long.valueOf(localRandomAccessFile2.length()));
    }
    int i = localRandomAccessFile1.readInt();
    if (i != 4) {
      throw new IOException("Bad file version: " + i);
    }
    i = localRandomAccessFile1.readInt();
    if (i != 256) {
      throw new IOException("Bad tile size: " + i);
    }
    int j = localRandomAccessFile1.readInt();
    i = 0;
    while (i < j)
    {
      int k = localRandomAccessFile1.readInt();
      int m = localRandomAccessFile1.readInt();
      localObject = new byte[m];
      localRandomAccessFile1.read((byte[])localObject, 0, m);
      localObject = new String((byte[])localObject);
      this.mSources.put(new Integer(k), localObject);
      i += 1;
    }
    j = localRandomAccessFile1.readInt();
    i = 0;
    while (i < j)
    {
      localObject = new GEMFRange(null);
      ((GEMFRange)localObject).zoom = Integer.valueOf(localRandomAccessFile1.readInt());
      ((GEMFRange)localObject).xMin = Integer.valueOf(localRandomAccessFile1.readInt());
      ((GEMFRange)localObject).xMax = Integer.valueOf(localRandomAccessFile1.readInt());
      ((GEMFRange)localObject).yMin = Integer.valueOf(localRandomAccessFile1.readInt());
      ((GEMFRange)localObject).yMax = Integer.valueOf(localRandomAccessFile1.readInt());
      ((GEMFRange)localObject).sourceIndex = Integer.valueOf(localRandomAccessFile1.readInt());
      ((GEMFRange)localObject).offset = Long.valueOf(localRandomAccessFile1.readLong());
      this.mRangeData.add(localObject);
      i += 1;
    }
  }
  
  public void acceptAnySource()
  {
    this.mSourceLimited = false;
  }
  
  public void close()
    throws IOException
  {
    Iterator localIterator = this.mFiles.iterator();
    while (localIterator.hasNext()) {
      ((RandomAccessFile)localIterator.next()).close();
    }
  }
  
  public InputStream getInputStream(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    Iterator localIterator = this.mRangeData.iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (GEMFRange)localIterator.next();
    } while ((paramInt3 != ((GEMFRange)localObject1).zoom.intValue()) || (paramInt1 < ((GEMFRange)localObject1).xMin.intValue()) || (paramInt1 > ((GEMFRange)localObject1).xMax.intValue()) || (paramInt2 < ((GEMFRange)localObject1).yMin.intValue()) || (paramInt2 > ((GEMFRange)localObject1).yMax.intValue()) || ((this.mSourceLimited) && (((GEMFRange)localObject1).sourceIndex.intValue() != this.mCurrentSource)));
    if (localObject1 == null) {
      return null;
    }
    try
    {
      paramInt3 = ((GEMFRange)localObject1).yMax.intValue();
      int i = ((GEMFRange)localObject1).yMin.intValue();
      long l1 = (paramInt1 - ((GEMFRange)localObject1).xMin.intValue()) * (paramInt3 + 1 - i) + (paramInt2 - ((GEMFRange)localObject1).yMin.intValue());
      long l2 = ((GEMFRange)localObject1).offset.longValue();
      localObject1 = (RandomAccessFile)this.mFiles.get(0);
      ((RandomAccessFile)localObject1).seek(l1 * 12L + l2);
      l1 = ((RandomAccessFile)localObject1).readLong();
      paramInt3 = ((RandomAccessFile)localObject1).readInt();
      localObject1 = (RandomAccessFile)this.mFiles.get(0);
      paramInt1 = 0;
      paramInt2 = 0;
      l2 = l1;
      if (l1 > ((Long)this.mFileSizes.get(0)).longValue())
      {
        i = this.mFileSizes.size();
        paramInt1 = paramInt2;
        while ((paramInt1 < i - 1) && (l1 > ((Long)this.mFileSizes.get(paramInt1)).longValue()))
        {
          l1 -= ((Long)this.mFileSizes.get(paramInt1)).longValue();
          paramInt1 += 1;
        }
        localObject1 = (RandomAccessFile)this.mFiles.get(paramInt1);
        l2 = l1;
      }
      ((RandomAccessFile)localObject1).seek(l2);
      localObject1 = new GEMFInputStream((String)this.mFileNames.get(paramInt1), l2, paramInt3);
      return (InputStream)localObject1;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public String getName()
  {
    return this.mLocation;
  }
  
  public LinkedHashMap<Integer, String> getSources()
  {
    return this.mSources;
  }
  
  public Set<Integer> getZoomLevels()
  {
    TreeSet localTreeSet = new TreeSet();
    Iterator localIterator = this.mRangeData.iterator();
    while (localIterator.hasNext()) {
      localTreeSet.add(((GEMFRange)localIterator.next()).zoom);
    }
    return localTreeSet;
  }
  
  public void selectSource(int paramInt)
  {
    if (this.mSources.containsKey(new Integer(paramInt)))
    {
      this.mSourceLimited = true;
      this.mCurrentSource = paramInt;
    }
  }
  
  class GEMFInputStream
    extends InputStream
  {
    RandomAccessFile raf;
    int remainingBytes;
    
    GEMFInputStream(String paramString, long paramLong, int paramInt)
      throws IOException
    {
      this.raf = new RandomAccessFile(paramString, "r");
      this.raf.seek(paramLong);
      this.remainingBytes = paramInt;
    }
    
    public int available()
    {
      return this.remainingBytes;
    }
    
    public void close()
      throws IOException
    {
      this.raf.close();
    }
    
    public boolean markSupported()
    {
      return false;
    }
    
    public int read()
      throws IOException
    {
      if (this.remainingBytes > 0)
      {
        this.remainingBytes -= 1;
        return this.raf.read();
      }
      throw new IOException("End of stream");
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      RandomAccessFile localRandomAccessFile = this.raf;
      int i = paramInt2;
      if (paramInt2 > this.remainingBytes) {
        i = this.remainingBytes;
      }
      paramInt1 = localRandomAccessFile.read(paramArrayOfByte, paramInt1, i);
      this.remainingBytes -= paramInt1;
      return paramInt1;
    }
    
    public long skip(long paramLong)
    {
      return 0L;
    }
  }
  
  private class GEMFRange
  {
    Long offset;
    Integer sourceIndex;
    Integer xMax;
    Integer xMin;
    Integer yMax;
    Integer yMin;
    Integer zoom;
    
    private GEMFRange() {}
    
    public String toString()
    {
      return String.format("GEMF Range: source=%d, zoom=%d, x=%d-%d, y=%d-%d, offset=0x%08X", new Object[] { this.sourceIndex, this.zoom, this.xMin, this.xMax, this.yMin, this.yMax, this.offset });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/util/GEMFFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */