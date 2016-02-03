package mobi.beyondpod.rsscore;

import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.Version;

public class BackupManifest
{
  static final String ManifestName = "BackupManifest.txt";
  private static final String TAG = BackupManifest.class.getSimpleName();
  private static final String _ManifestDeviceLabel = "[Device]";
  private static final String _ManifestFileNamesLabel = "[FileNames]";
  private static final String _ManifestFileNumLabel = "[FileNum]";
  private static final String _ManifestFilesSizesLabel = "[FileSizes]";
  private static final String _ManifestFilesTotalSizeLabel = "[TotalSize]";
  private static final String _ManifestRootPathLabel = "[RootPath]";
  private static final String _ManifestTimeLabel = "[TimeStamp]";
  private static final String _ManifestVersionLabel = "[Version]";
  public Date BackupTime;
  public String Device = "N/A";
  public int FileCount;
  FileInfo[] Files;
  public String RepositoryRootPath;
  public long TotlaFileSize;
  public Version VersionCode;
  
  BackupManifest()
  {
    this.FileCount = -1;
  }
  
  public BackupManifest(File paramFile)
    throws Exception
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      throw new IllegalArgumentException("Manifest file is missing");
    }
    Object localObject1 = new FileReader(paramFile);
    paramFile = CharBuffer.allocate((int)paramFile.length());
    CoreHelper.WriteTraceEntry(TAG, "Reading backup manifest...");
    int i = ((FileReader)localObject1).read(paramFile);
    ((FileReader)localObject1).close();
    if (i <= 0) {
      throw new IOException("Unable to read anything from manifest file.");
    }
    paramFile.rewind();
    Object localObject2 = paramFile.toString();
    localObject1 = new String[0];
    paramFile = new long[0];
    String[] arrayOfString = ((String)localObject2).split("[\\r\\n]+");
    int j = 0;
    if (j >= arrayOfString.length)
    {
      label123:
      if (this.FileCount == 0) {
        throw new IllegalArgumentException("Manifest is empty!");
      }
    }
    else
    {
      File localFile;
      if (arrayOfString[j].charAt(0) == '#')
      {
        localFile = paramFile;
        localObject2 = localObject1;
        i = j;
      }
      for (;;)
      {
        j = i + 1;
        localObject1 = localObject2;
        paramFile = localFile;
        break;
        if (arrayOfString[j].equals("[Version]"))
        {
          i = j + 1;
          this.VersionCode = new Version(arrayOfString[i]);
          localObject2 = localObject1;
          localFile = paramFile;
        }
        else if (arrayOfString[j].equals("[TimeStamp]"))
        {
          i = j + 1;
          this.BackupTime = DateTime.TryParseDateTimeWithFormat(arrayOfString[i], DateTime.RFC822DATEFORMATUTC);
          localObject2 = localObject1;
          localFile = paramFile;
        }
        else if (arrayOfString[j].equals("[RootPath]"))
        {
          i = j + 1;
          this.RepositoryRootPath = new String(arrayOfString[i]);
          localObject2 = localObject1;
          localFile = paramFile;
        }
        else if (arrayOfString[j].equals("[FileNum]"))
        {
          i = j + 1;
          this.FileCount = new Scanner(arrayOfString[i]).nextInt();
          localObject2 = localObject1;
          localFile = paramFile;
        }
        else if (arrayOfString[j].equals("[FileNames]"))
        {
          i = j + 1;
          localObject2 = arrayOfString[i].split(",");
          localFile = paramFile;
        }
        else
        {
          if (arrayOfString[j].equals("[FileSizes]"))
          {
            int k = j + 1;
            Scanner localScanner = new Scanner(arrayOfString[k]);
            if (this.FileCount <= 0) {
              break label123;
            }
            paramFile = new long[this.FileCount];
            j = 0;
            for (;;)
            {
              i = k;
              localObject2 = localObject1;
              localFile = paramFile;
              if (j >= this.FileCount) {
                break;
              }
              i = k;
              localObject2 = localObject1;
              localFile = paramFile;
              if (!localScanner.hasNextLong()) {
                break;
              }
              paramFile[j] = localScanner.nextLong();
              j += 1;
            }
          }
          if (arrayOfString[j].equals("[TotalSize]"))
          {
            i = j + 1;
            this.TotlaFileSize = new Scanner(arrayOfString[i]).nextLong();
            localObject2 = localObject1;
            localFile = paramFile;
          }
          else
          {
            i = j;
            localObject2 = localObject1;
            localFile = paramFile;
            if (arrayOfString[j].equals("[Device]"))
            {
              i = j + 1;
              this.Device = arrayOfString[i];
              localObject2 = localObject1;
              localFile = paramFile;
            }
          }
        }
      }
    }
    if ((this.FileCount != localObject1.length) || (this.FileCount != paramFile.length)) {
      throw new IllegalArgumentException("Invalid or corrupted manifest!");
    }
    i = 0;
    for (;;)
    {
      if (i == this.FileCount) {
        return;
      }
      this.Files = new FileInfo[this.FileCount];
      this.Files[i] = new FileInfo(localObject1[i], paramFile[i]);
      i += 1;
    }
  }
  
  static File CreateManifest(String paramString, File[] paramArrayOfFile)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return null;
    }
    paramString = new File(paramString, "BackupManifest.txt");
    if (paramString.exists())
    {
      CoreHelper.WriteTraceEntry(TAG, "Deleting pre-existing manifest file.");
      paramString.delete();
    }
    for (;;)
    {
      Object localObject;
      ArrayList localArrayList;
      long l1;
      int i;
      try
      {
        CoreHelper.WriteTraceEntry(TAG, "Creating new manifest file.");
        paramString.createNewFile();
        try
        {
          PrintWriter localPrintWriter = new PrintWriter(new FileWriter(paramString));
          CoreHelper.WriteTraceEntry(TAG, "Begin writing to manifest file.");
          localPrintWriter.println("# Version: " + Configuration.ProductVersionAsString());
          localPrintWriter.println("[Version]");
          localPrintWriter.println(Configuration.ProductVersion());
          localObject = new Date();
          localPrintWriter.println("[TimeStamp]");
          localPrintWriter.println(DateTime.ToRFC822UTCString((Date)localObject));
          localPrintWriter.println("[RootPath]");
          localPrintWriter.println(Configuration.BeyondPodPublicStorageRootPath());
          localObject = new ArrayList(paramArrayOfFile.length);
          localArrayList = new ArrayList(paramArrayOfFile.length);
          l1 = 0L;
          int j = paramArrayOfFile.length;
          i = 0;
          if (i >= j)
          {
            localPrintWriter.println("[FileNum]");
            localPrintWriter.println(paramArrayOfFile.length);
            localPrintWriter.println("[TotalSize]");
            localPrintWriter.println(String.valueOf(l1));
            localPrintWriter.println("[FileNames]");
            localPrintWriter.println(TextUtils.join(",", (Iterable)localObject));
            localPrintWriter.println("[FileSizes]");
            localPrintWriter.println(TextUtils.join(",", localArrayList));
            localPrintWriter.println("[Device]");
            localPrintWriter.println(Build.MANUFACTURER + " " + Build.MODEL);
            localPrintWriter.close();
            CoreHelper.WriteTraceEntry(TAG, "Finished writing to manifest file.");
            return paramString;
          }
        }
        catch (IOException paramString)
        {
          return null;
        }
        localFile = paramArrayOfFile[i];
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      File localFile;
      ((ArrayList)localObject).add(localFile.getName());
      localArrayList.add(Long.valueOf(localFile.length()));
      long l2 = localFile.length();
      l1 += l2;
      i += 1;
    }
  }
  
  public String toString()
  {
    return String.format("Backup Manifest data: Backup of version: %s from %s (%s files, total size %s bytes)", new Object[] { this.VersionCode.toString(), this.BackupTime, Integer.valueOf(this.FileCount), Long.valueOf(this.TotlaFileSize) });
  }
  
  public static class FileInfo
  {
    public String FileName;
    public long FileSize;
    
    public FileInfo(String paramString, long paramLong)
    {
      this.FileName = paramString;
      this.FileSize = paramLong;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/BackupManifest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */