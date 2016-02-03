package com.squareup.picasso;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

public class StatsSnapshot
{
  public final long averageDownloadSize;
  public final long averageOriginalBitmapSize;
  public final long averageTransformedBitmapSize;
  public final long cacheHits;
  public final long cacheMisses;
  public final int downloadCount;
  public final int maxSize;
  public final int originalBitmapCount;
  public final int size;
  public final long timeStamp;
  public final long totalDownloadSize;
  public final long totalOriginalBitmapSize;
  public final long totalTransformedBitmapSize;
  public final int transformedBitmapCount;
  
  public StatsSnapshot(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, int paramInt3, int paramInt4, int paramInt5, long paramLong9)
  {
    this.maxSize = paramInt1;
    this.size = paramInt2;
    this.cacheHits = paramLong1;
    this.cacheMisses = paramLong2;
    this.totalDownloadSize = paramLong3;
    this.totalOriginalBitmapSize = paramLong4;
    this.totalTransformedBitmapSize = paramLong5;
    this.averageDownloadSize = paramLong6;
    this.averageOriginalBitmapSize = paramLong7;
    this.averageTransformedBitmapSize = paramLong8;
    this.downloadCount = paramInt3;
    this.originalBitmapCount = paramInt4;
    this.transformedBitmapCount = paramInt5;
    this.timeStamp = paramLong9;
  }
  
  public void dump()
  {
    StringWriter localStringWriter = new StringWriter();
    dump(new PrintWriter(localStringWriter));
    Log.i("Picasso", localStringWriter.toString());
  }
  
  public void dump(PrintWriter paramPrintWriter)
  {
    paramPrintWriter.println("===============BEGIN PICASSO STATS ===============");
    paramPrintWriter.println("Memory Cache Stats");
    paramPrintWriter.print("  Max Cache Size: ");
    paramPrintWriter.println(this.maxSize);
    paramPrintWriter.print("  Cache Size: ");
    paramPrintWriter.println(this.size);
    paramPrintWriter.print("  Cache % Full: ");
    paramPrintWriter.println((int)Math.ceil(this.size / this.maxSize * 100.0F));
    paramPrintWriter.print("  Cache Hits: ");
    paramPrintWriter.println(this.cacheHits);
    paramPrintWriter.print("  Cache Misses: ");
    paramPrintWriter.println(this.cacheMisses);
    paramPrintWriter.println("Network Stats");
    paramPrintWriter.print("  Download Count: ");
    paramPrintWriter.println(this.downloadCount);
    paramPrintWriter.print("  Total Download Size: ");
    paramPrintWriter.println(this.totalDownloadSize);
    paramPrintWriter.print("  Average Download Size: ");
    paramPrintWriter.println(this.averageDownloadSize);
    paramPrintWriter.println("Bitmap Stats");
    paramPrintWriter.print("  Total Bitmaps Decoded: ");
    paramPrintWriter.println(this.originalBitmapCount);
    paramPrintWriter.print("  Total Bitmap Size: ");
    paramPrintWriter.println(this.totalOriginalBitmapSize);
    paramPrintWriter.print("  Total Transformed Bitmaps: ");
    paramPrintWriter.println(this.transformedBitmapCount);
    paramPrintWriter.print("  Total Transformed Bitmap Size: ");
    paramPrintWriter.println(this.totalTransformedBitmapSize);
    paramPrintWriter.print("  Average Bitmap Size: ");
    paramPrintWriter.println(this.averageOriginalBitmapSize);
    paramPrintWriter.print("  Average Transformed Bitmap Size: ");
    paramPrintWriter.println(this.averageTransformedBitmapSize);
    paramPrintWriter.println("===============END PICASSO STATS ===============");
    paramPrintWriter.flush();
  }
  
  public String toString()
  {
    return "StatsSnapshot{maxSize=" + this.maxSize + ", size=" + this.size + ", cacheHits=" + this.cacheHits + ", cacheMisses=" + this.cacheMisses + ", downloadCount=" + this.downloadCount + ", totalDownloadSize=" + this.totalDownloadSize + ", averageDownloadSize=" + this.averageDownloadSize + ", totalOriginalBitmapSize=" + this.totalOriginalBitmapSize + ", totalTransformedBitmapSize=" + this.totalTransformedBitmapSize + ", averageOriginalBitmapSize=" + this.averageOriginalBitmapSize + ", averageTransformedBitmapSize=" + this.averageTransformedBitmapSize + ", originalBitmapCount=" + this.originalBitmapCount + ", transformedBitmapCount=" + this.transformedBitmapCount + ", timeStamp=" + this.timeStamp + '}';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/picasso/StatsSnapshot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */