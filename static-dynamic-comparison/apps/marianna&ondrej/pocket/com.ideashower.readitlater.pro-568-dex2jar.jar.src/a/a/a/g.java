package a.a.a;

public class g
{
  public static final String[] a = { "Crash Data", "The app found information about previous crashes. Would you like to send this data to the developer?", "Dismiss", "Send", "Download Failed", "The update could not be downloaded. Would you like to try again?", "Cancel", "Retry", "Please install the latest version to continue to use this app.", "Update Available", "Show information about the new update?", "Dismiss", "Show", "Build Expired", "This has build has expired. Please check HockeyApp for any updates.", "Feedback Failed", "Would you like to send your feedback again?" };
  
  public static String a(f paramf, int paramInt)
  {
    String str = null;
    if (paramf != null) {
      str = paramf.a(paramInt);
    }
    paramf = str;
    if (str == null)
    {
      paramf = str;
      if (paramInt >= 0)
      {
        paramf = str;
        if (paramInt <= a.length) {
          paramf = a[paramInt];
        }
      }
    }
    return paramf;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/a/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */