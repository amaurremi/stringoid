package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider
  extends ContentProvider
{
  private static final String[] g = { "_display_name", "_size" };
  private static final File h = new File("/");
  private static HashMap<String, a> i = new HashMap();
  private a j;
  
  private static int a(String paramString)
  {
    if ("r".equals(paramString)) {
      return 268435456;
    }
    if (("w".equals(paramString)) || ("wt".equals(paramString))) {
      return 738197504;
    }
    if ("wa".equals(paramString)) {
      return 704643072;
    }
    if ("rw".equals(paramString)) {
      return 939524096;
    }
    if ("rwt".equals(paramString)) {
      return 1006632960;
    }
    throw new IllegalArgumentException("Invalid mode: " + paramString);
  }
  
  private static String[] a(String[] paramArrayOfString, int paramInt)
  {
    String[] arrayOfString = new String[paramInt];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramInt);
    return arrayOfString;
  }
  
  private static a b(Context paramContext, String paramString)
  {
    a locala1;
    synchronized (i)
    {
      a locala2 = (a)i.get(paramString);
      locala1 = locala2;
      if (locala2 != null) {}
    }
    try
    {
      locala1 = c(paramContext, paramString);
      i.put(paramString, locala1);
      return locala1;
    }
    catch (IOException paramContext)
    {
      throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
      paramContext = finally;
      throw paramContext;
    }
    catch (XmlPullParserException paramContext)
    {
      throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
    }
  }
  
  private static File buildPath(File paramFile, String... paramVarArgs)
  {
    int m = paramVarArgs.length;
    int k = 0;
    if (k < m)
    {
      String str = paramVarArgs[k];
      if (str == null) {
        break label40;
      }
      paramFile = new File(paramFile, str);
    }
    label40:
    for (;;)
    {
      k += 1;
      break;
      return paramFile;
    }
  }
  
  private static a c(Context paramContext, String paramString)
  {
    b localb = new b(paramString);
    XmlResourceParser localXmlResourceParser = paramContext.getPackageManager().resolveContentProvider(paramString, 128).loadXmlMetaData(paramContext.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
    if (localXmlResourceParser == null) {
      throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    }
    label226:
    for (;;)
    {
      int k = localXmlResourceParser.next();
      String str1;
      String str2;
      if (k != 1)
      {
        if (k != 2) {
          continue;
        }
        paramString = localXmlResourceParser.getName();
        str1 = localXmlResourceParser.getAttributeValue(null, "name");
        str2 = localXmlResourceParser.getAttributeValue(null, "path");
        if ("root-path".equals(paramString)) {
          paramString = buildPath(h, new String[] { str2 });
        }
      }
      for (;;)
      {
        if (paramString == null) {
          break label226;
        }
        localb.a(str1, paramString);
        break;
        if ("files-path".equals(paramString))
        {
          paramString = buildPath(paramContext.getFilesDir(), new String[] { str2 });
        }
        else if ("cache-path".equals(paramString))
        {
          paramString = buildPath(paramContext.getCacheDir(), new String[] { str2 });
        }
        else if ("external-path".equals(paramString))
        {
          paramString = buildPath(Environment.getExternalStorageDirectory(), new String[] { str2 });
          continue;
          return localb;
        }
        else
        {
          paramString = null;
        }
      }
    }
  }
  
  private static Object[] copyOf(Object[] paramArrayOfObject, int paramInt)
  {
    Object[] arrayOfObject = new Object[paramInt];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    return arrayOfObject;
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (paramProviderInfo.exported) {
      throw new SecurityException("Provider must not be exported");
    }
    if (!paramProviderInfo.grantUriPermissions) {
      throw new SecurityException("Provider must grant uri permissions");
    }
    this.j = b(paramContext, paramProviderInfo.authority);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (this.j.a(paramUri).delete()) {
      return 1;
    }
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    paramUri = this.j.a(paramUri);
    int k = paramUri.getName().lastIndexOf('.');
    if (k >= 0)
    {
      paramUri = paramUri.getName().substring(k + 1);
      paramUri = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramUri);
      if (paramUri != null) {
        return paramUri;
      }
    }
    return "application/octet-stream";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("No external inserts");
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    return ParcelFileDescriptor.open(this.j.a(paramUri), a(paramString));
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramString1 = this.j.a(paramUri);
    paramUri = paramArrayOfString1;
    if (paramArrayOfString1 == null) {
      paramUri = g;
    }
    paramArrayOfString2 = new String[paramUri.length];
    paramArrayOfString1 = new Object[paramUri.length];
    int i1 = paramUri.length;
    int m = 0;
    int k = 0;
    int n;
    if (m < i1)
    {
      paramString2 = paramUri[m];
      if ("_display_name".equals(paramString2))
      {
        paramArrayOfString2[k] = "_display_name";
        n = k + 1;
        paramArrayOfString1[k] = paramString1.getName();
        k = n;
      }
    }
    for (;;)
    {
      m += 1;
      break;
      if ("_size".equals(paramString2))
      {
        paramArrayOfString2[k] = "_size";
        n = k + 1;
        paramArrayOfString1[k] = Long.valueOf(paramString1.length());
        k = n;
        continue;
        paramUri = a(paramArrayOfString2, k);
        paramArrayOfString1 = copyOf(paramArrayOfString1, k);
        paramUri = new MatrixCursor(paramUri, 1);
        paramUri.addRow(paramArrayOfString1);
        return paramUri;
      }
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
  
  static abstract interface a
  {
    public abstract File a(Uri paramUri);
  }
  
  static class b
    implements FileProvider.a
  {
    private final String k;
    private final HashMap<String, File> l = new HashMap();
    
    public b(String paramString)
    {
      this.k = paramString;
    }
    
    public File a(Uri paramUri)
    {
      Object localObject2 = paramUri.getEncodedPath();
      int i = ((String)localObject2).indexOf('/', 1);
      Object localObject1 = Uri.decode(((String)localObject2).substring(1, i));
      localObject2 = Uri.decode(((String)localObject2).substring(i + 1));
      localObject1 = (File)this.l.get(localObject1);
      if (localObject1 == null) {
        throw new IllegalArgumentException("Unable to find configured root for " + paramUri);
      }
      paramUri = new File((File)localObject1, (String)localObject2);
      try
      {
        localObject2 = paramUri.getCanonicalFile();
        if (!((File)localObject2).getPath().startsWith(((File)localObject1).getPath())) {
          throw new SecurityException("Resolved path jumped beyond configured root");
        }
      }
      catch (IOException localIOException)
      {
        throw new IllegalArgumentException("Failed to resolve canonical path for " + paramUri);
      }
      return (File)localObject2;
    }
    
    public void a(String paramString, File paramFile)
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("Name must not be empty");
      }
      try
      {
        File localFile = paramFile.getCanonicalFile();
        this.l.put(paramString, localFile);
        return;
      }
      catch (IOException paramString)
      {
        throw new IllegalArgumentException("Failed to resolve canonical path for " + paramFile, paramString);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/content/FileProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */