package twitter4j;

import java.io.Serializable;

import twitter4j.conf.Configuration;

class AccountTotalsJSONImpl
        extends TwitterResponseImpl
        implements Serializable, AccountTotals {
    private static final long serialVersionUID = 4199733699237229892L;
    private final int favorites;
    private final int followers;
    private final int friends;
    private final int updates;

    private AccountTotalsJSONImpl(HttpResponse paramHttpResponse, JSONObject paramJSONObject) {
        super(paramHttpResponse);
        this.updates = ParseUtil.getInt("updates", paramJSONObject);
        this.followers = ParseUtil.getInt("followers", paramJSONObject);
        this.favorites = ParseUtil.getInt("favorites", paramJSONObject);
        this.friends = ParseUtil.getInt("friends", paramJSONObject);
    }

    AccountTotalsJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration) {
        this(paramHttpResponse, paramHttpResponse.asJSONObject());
        if (paramConfiguration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, paramHttpResponse.asJSONObject());
        }
    }

    AccountTotalsJSONImpl(JSONObject paramJSONObject) {
        this(null, paramJSONObject);
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
                return false;
            }
            paramObject = (AccountTotalsJSONImpl) paramObject;
            if (this.favorites != ((AccountTotalsJSONImpl) paramObject).favorites) {
                return false;
            }
            if (this.followers != ((AccountTotalsJSONImpl) paramObject).followers) {
                return false;
            }
            if (this.friends != ((AccountTotalsJSONImpl) paramObject).friends) {
                return false;
            }
        } while (this.updates == ((AccountTotalsJSONImpl) paramObject).updates);
        return false;
    }

    public int getFavorites() {
        return this.favorites;
    }

    public int getFollowers() {
        return this.followers;
    }

    public int getFriends() {
        return this.friends;
    }

    public int getUpdates() {
        return this.updates;
    }

    public int hashCode() {
        return ((this.updates * 31 + this.followers) * 31 + this.favorites) * 31 + this.friends;
    }

    public String toString() {
        return "AccountTotalsJSONImpl{updates=" + this.updates + ", followers=" + this.followers + ", favorites=" + this.favorites + ", friends=" + this.friends + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/AccountTotalsJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */