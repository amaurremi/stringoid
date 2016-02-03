package mobi.ifunny.profile;

import android.support.v4.app.k;
import mobi.ifunny.b.g;

class m
        implements Runnable {
    m(l paraml, int paramInt) {
    }

    public void run() {
        k localk;
        String str;
        switch (this.a) {
            default:
                return;
            case 0:
                localk = this.b.getActivity();
                if (this.b.d) {
                }
                for (str = "MyProfile"; ; str = "UserProfile") {
                    g.a(localk, str);
                    return;
                }
            case 1:
                localk = this.b.getActivity();
                if (this.b.d) {
                }
                for (str = "MyProfileInfo"; ; str = "UserProfileInfo") {
                    g.a(localk, str);
                    return;
                }
            case 2:
                g.a(this.b.getActivity(), "MyProfileNews");
                return;
            case 3:
                g.a(this.b.getActivity(), "MyProfileSmiles");
                return;
        }
        g.a(this.b.getActivity(), "MyProfileComments");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */