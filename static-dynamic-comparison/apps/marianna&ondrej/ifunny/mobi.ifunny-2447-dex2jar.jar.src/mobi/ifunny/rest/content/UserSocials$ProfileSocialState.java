package mobi.ifunny.rest.content;

public class UserSocials$ProfileSocialState {
    private int connectedCount;
    private String email;
    private String fbId;
    private String fbNick;
    private String gpId;
    private String gpNick;
    private boolean isFacebookConnected;
    private boolean isGPlusConnected;
    private boolean isTwitterConnected;
    private String twId;
    private String twNick;

    public String getEmail() {
        return this.email;
    }

    public String getFbId() {
        return this.fbId;
    }

    public String getFbNick() {
        return this.fbNick;
    }

    public String getGpId() {
        return this.gpId;
    }

    public String getGpNick() {
        return this.gpNick;
    }

    public String getTwId() {
        return this.twId;
    }

    public String getTwNick() {
        return this.twNick;
    }

    public boolean isFacebookConnected() {
        return this.isFacebookConnected;
    }

    public boolean isGPlusConnected() {
        return this.isGPlusConnected;
    }

    public boolean isLastNetworkConnected() {
        return this.connectedCount == 1;
    }

    public boolean isTwitterConnected() {
        return this.isTwitterConnected;
    }

    public void update(User paramUser) {
        if (paramUser.social != null) {
            this.connectedCount = 0;
            if (paramUser.social.fb == null) {
                break label180;
            }
            this.isFacebookConnected = true;
            this.connectedCount += 1;
            this.fbNick = paramUser.social.fb.nick;
            this.fbId = paramUser.social.fb.id;
            if (paramUser.social.tw == null) {
                break label198;
            }
            this.isTwitterConnected = true;
            this.connectedCount += 1;
            this.twNick = paramUser.social.tw.nick;
            this.twId = paramUser.social.tw.id;
            label118:
            if (paramUser.social.gplus == null) {
                break label216;
            }
            this.isGPlusConnected = true;
            this.connectedCount += 1;
            this.gpNick = paramUser.social.gplus.nick;
        }
        for (this.gpId = paramUser.social.gplus.id; ; this.gpId = null) {
            this.email = paramUser.email;
            return;
            label180:
            this.isFacebookConnected = false;
            this.fbNick = null;
            this.fbId = null;
            break;
            label198:
            this.isTwitterConnected = false;
            this.twNick = null;
            this.twId = null;
            break label118;
            label216:
            this.isGPlusConnected = false;
            this.gpNick = null;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/UserSocials$ProfileSocialState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */