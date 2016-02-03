package com.venticake.retrica.view.album;

import java.util.ArrayList;
import java.util.Arrays;

public final class ArrayUtils
{
  public static void clear(Object[] paramArrayOfObject)
  {
    int j = paramArrayOfObject.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      paramArrayOfObject[i] = null;
      i += 1;
    }
  }
  
  public static final void computeSortedIntersection(ArrayList<MediaItem> paramArrayList1, ArrayList<MediaItem> paramArrayList2, int paramInt, ArrayList<MediaItem> paramArrayList3, MediaItem[] paramArrayOfMediaItem)
  {
    int k = paramArrayOfMediaItem.length - 1;
    int j = Math.min(paramArrayList2.size(), paramArrayOfMediaItem.length * 2);
    int i = 0;
    MediaItem localMediaItem1;
    for (;;)
    {
      if (i >= j)
      {
        int m = paramArrayList1.size();
        i = 0;
        if (i < m) {
          break;
        }
        Arrays.fill(paramArrayOfMediaItem, null);
        return;
      }
      localMediaItem1 = (MediaItem)paramArrayList2.get(i);
      if (localMediaItem1 != null) {
        paramArrayOfMediaItem[(localMediaItem1.hashCode() & k)] = localMediaItem1;
      }
      i += 1;
    }
    MediaItem localMediaItem2 = (MediaItem)paramArrayList1.get(i);
    if (localMediaItem2 == null) {}
    label108:
    label204:
    for (;;)
    {
      i += 1;
      break;
      if (paramArrayOfMediaItem != null) {}
      for (localMediaItem1 = paramArrayOfMediaItem[(localMediaItem2.hashCode() & k)];; localMediaItem1 = null)
      {
        if ((localMediaItem1 == null) || (((localMediaItem1.mId == -1L) || (localMediaItem1.mId != localMediaItem2.mId)) && (!contains(paramArrayList2, localMediaItem2)))) {
          break label204;
        }
        paramArrayList3.add(localMediaItem2);
        j = paramInt - 1;
        paramInt = j;
        if (j != 0) {
          break label108;
        }
        break;
      }
    }
  }
  
  public static final boolean contains(ArrayList<MediaItem> paramArrayList, MediaItem paramMediaItem)
  {
    int j = paramArrayList.size();
    if (paramMediaItem.mId == -1L) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return false;
      }
      MediaItem localMediaItem = (MediaItem)paramArrayList.get(i);
      if (paramMediaItem.mId == localMediaItem.mId) {
        return true;
      }
      i += 1;
    }
  }
  
  public static final boolean contains(Object[] paramArrayOfObject, Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        if (paramObject.equals(paramArrayOfObject[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/ArrayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */