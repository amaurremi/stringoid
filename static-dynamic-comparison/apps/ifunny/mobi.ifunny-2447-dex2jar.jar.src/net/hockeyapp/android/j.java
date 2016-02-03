package net.hockeyapp.android;

public class j {
    public static final String[] a = {"Crash Data", "The app found information about previous crashes. Would you like to send this data to the developer?", "Dismiss", "Send", "Download Failed", "The update could not be downloaded. Would you like to try again?", "Cancel", "Retry", "Please install the latest version to continue to use this app.", "Update Available", "Show information about the new update?", "Dismiss", "Show", "Build Expired", "This has build has expired. Please check HockeyApp for any updates.", "Feedback Failed", "Would you like to send your feedback again?"};

    public static String a(i parami, int paramInt) {
        String str = null;
        if (parami != null) {
            str = parami.a(paramInt);
        }
        parami = str;
        if (str == null) {
            parami = str;
            if (paramInt >= 0) {
                parami = str;
                if (paramInt <= a.length) {
                    parami = a[paramInt];
                }
            }
        }
        return parami;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/net/hockeyapp/android/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */