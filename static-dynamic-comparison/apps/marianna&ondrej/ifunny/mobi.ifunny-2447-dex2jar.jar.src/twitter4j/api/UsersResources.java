package twitter4j.api;

import java.io.File;
import java.io.InputStream;

import twitter4j.AccountSettings;
import twitter4j.IDs;
import twitter4j.PagableResponseList;
import twitter4j.ResponseList;
import twitter4j.User;

public abstract interface UsersResources {
    public abstract User createBlock(long paramLong);

    public abstract User createBlock(String paramString);

    public abstract User createMute(long paramLong);

    public abstract User createMute(String paramString);

    public abstract User destroyBlock(long paramLong);

    public abstract User destroyBlock(String paramString);

    public abstract User destroyMute(long paramLong);

    public abstract User destroyMute(String paramString);

    public abstract AccountSettings getAccountSettings();

    public abstract IDs getBlocksIDs();

    public abstract IDs getBlocksIDs(long paramLong);

    public abstract PagableResponseList<User> getBlocksList();

    public abstract PagableResponseList<User> getBlocksList(long paramLong);

    public abstract ResponseList<User> getContributees(long paramLong);

    public abstract ResponseList<User> getContributees(String paramString);

    public abstract ResponseList<User> getContributors(long paramLong);

    public abstract ResponseList<User> getContributors(String paramString);

    public abstract IDs getMutesIDs(long paramLong);

    public abstract PagableResponseList<User> getMutesList(long paramLong);

    public abstract ResponseList<User> lookupUsers(long[] paramArrayOfLong);

    public abstract ResponseList<User> lookupUsers(String[] paramArrayOfString);

    public abstract void removeProfileBanner();

    public abstract ResponseList<User> searchUsers(String paramString, int paramInt);

    public abstract User showUser(long paramLong);

    public abstract User showUser(String paramString);

    public abstract AccountSettings updateAccountSettings(Integer paramInteger, Boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4);

    public abstract User updateProfile(String paramString1, String paramString2, String paramString3, String paramString4);

    public abstract User updateProfileBackgroundImage(File paramFile, boolean paramBoolean);

    public abstract User updateProfileBackgroundImage(InputStream paramInputStream, boolean paramBoolean);

    public abstract void updateProfileBanner(File paramFile);

    public abstract void updateProfileBanner(InputStream paramInputStream);

    public abstract User updateProfileColors(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);

    public abstract User updateProfileImage(File paramFile);

    public abstract User updateProfileImage(InputStream paramInputStream);

    public abstract User verifyCredentials();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/api/UsersResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */