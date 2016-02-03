package twitter4j.api;

import java.io.File;
import java.io.InputStream;

import twitter4j.AccountSettings;
import twitter4j.IDs;
import twitter4j.PagableResponseList;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.User;

public abstract interface UsersResources {
    public abstract User createBlock(long paramLong)
            throws TwitterException;

    public abstract User createBlock(String paramString)
            throws TwitterException;

    public abstract User destroyBlock(long paramLong)
            throws TwitterException;

    public abstract User destroyBlock(String paramString)
            throws TwitterException;

    public abstract AccountSettings getAccountSettings()
            throws TwitterException;

    public abstract IDs getBlocksIDs()
            throws TwitterException;

    public abstract IDs getBlocksIDs(long paramLong)
            throws TwitterException;

    public abstract PagableResponseList<User> getBlocksList()
            throws TwitterException;

    public abstract PagableResponseList<User> getBlocksList(long paramLong)
            throws TwitterException;

    public abstract ResponseList<User> getContributees(long paramLong)
            throws TwitterException;

    public abstract ResponseList<User> getContributees(String paramString)
            throws TwitterException;

    public abstract ResponseList<User> getContributors(long paramLong)
            throws TwitterException;

    public abstract ResponseList<User> getContributors(String paramString)
            throws TwitterException;

    public abstract ResponseList<User> lookupUsers(long[] paramArrayOfLong)
            throws TwitterException;

    public abstract ResponseList<User> lookupUsers(String[] paramArrayOfString)
            throws TwitterException;

    public abstract void removeProfileBanner()
            throws TwitterException;

    public abstract ResponseList<User> searchUsers(String paramString, int paramInt)
            throws TwitterException;

    public abstract User showUser(long paramLong)
            throws TwitterException;

    public abstract User showUser(String paramString)
            throws TwitterException;

    public abstract AccountSettings updateAccountSettings(Integer paramInteger, Boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
            throws TwitterException;

    public abstract User updateProfile(String paramString1, String paramString2, String paramString3, String paramString4)
            throws TwitterException;

    public abstract User updateProfileBackgroundImage(File paramFile, boolean paramBoolean)
            throws TwitterException;

    public abstract User updateProfileBackgroundImage(InputStream paramInputStream, boolean paramBoolean)
            throws TwitterException;

    public abstract void updateProfileBanner(File paramFile)
            throws TwitterException;

    public abstract void updateProfileBanner(InputStream paramInputStream)
            throws TwitterException;

    public abstract User updateProfileColors(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
            throws TwitterException;

    public abstract User updateProfileImage(File paramFile)
            throws TwitterException;

    public abstract User updateProfileImage(InputStream paramInputStream)
            throws TwitterException;

    public abstract User verifyCredentials()
            throws TwitterException;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/api/UsersResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */