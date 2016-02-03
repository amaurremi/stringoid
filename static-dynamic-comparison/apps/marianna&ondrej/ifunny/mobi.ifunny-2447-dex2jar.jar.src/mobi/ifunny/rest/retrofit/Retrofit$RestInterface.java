package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.Features;
import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.CommentsFeedImpl;
import mobi.ifunny.rest.content.CoverFeed;
import mobi.ifunny.rest.content.DeleteResponcesList;
import mobi.ifunny.rest.content.GetComment;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.IFunnyFeed;
import mobi.ifunny.rest.content.IFunnyMeanwhileFeed;
import mobi.ifunny.rest.content.MemeSourcesFeed;
import mobi.ifunny.rest.content.MyCommented;
import mobi.ifunny.rest.content.NewsFeed;
import mobi.ifunny.rest.content.NickAvailability;
import mobi.ifunny.rest.content.RageMetaWrapper;
import mobi.ifunny.rest.content.RepliesFeed;
import mobi.ifunny.rest.content.RepublishedCounter;
import mobi.ifunny.rest.content.RepublishersFeed;
import mobi.ifunny.rest.content.SearchResponse;
import mobi.ifunny.rest.content.SearchUsersResponce;
import mobi.ifunny.rest.content.Shares;
import mobi.ifunny.rest.content.SmilersFeed;
import mobi.ifunny.rest.content.SmilesCounter;
import mobi.ifunny.rest.content.SubscriptionsUserFeed;
import mobi.ifunny.rest.content.TaskInfo;
import mobi.ifunny.rest.content.UploadedCover;
import mobi.ifunny.rest.content.UploadedPhoto;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.content.WebImageFeed;
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.mime.TypedOutput;

abstract interface Retrofit$RestInterface {
    @PUT("/content/{cid}/comments/{id}/abuses")
    public abstract RestResponse<Void> abuseComment(@Path("cid") String paramString1, @Path("id") String paramString2);

    @Multipart
    @POST("/content")
    public abstract RestResponse<TaskInfo> addCaption(@Part("type") String paramString1, @Part("title") String paramString2, @Part("image") TypedOutput paramTypedOutput1, @Part("draft") TypedOutput paramTypedOutput2, @Part("text") String paramString3);

    @Multipart
    @POST("/content")
    public abstract RestResponse<TaskInfo> addComics(@Part("type") String paramString1, @Part("title") String paramString2, @Part("image") TypedOutput paramTypedOutput1, @Part("draft") TypedOutput paramTypedOutput2, @Part("texts") String paramString3, @Part("src_ids") String paramString4);

    @FormUrlEncoded
    @POST("/content/{id}/comments")
    public abstract RestResponse<Comment> addComment(@Path("id") String paramString1, @Field("text") String paramString2);

    @Multipart
    @POST("/content")
    public abstract RestResponse<TaskInfo> addGifCaption(@Part("type") String paramString1, @Part("title") String paramString2, @Part("image") TypedOutput paramTypedOutput, @Part("text") String paramString3);

    @Multipart
    @POST("/content")
    public abstract RestResponse<TaskInfo> addImage(@Part("type") String paramString1, @Part("title") String paramString2, @Part("image") TypedOutput paramTypedOutput, @Part("url") String paramString3);

    @Multipart
    @POST("/content")
    public abstract RestResponse<TaskInfo> addMeme(@Part("type") String paramString1, @Part("title") String paramString2, @Part("image") TypedOutput paramTypedOutput1, @Part("draft") TypedOutput paramTypedOutput2, @Part("top_text") String paramString3, @Part("bottom_text") String paramString4, @Part("src_id") String paramString5);

    @FormUrlEncoded
    @POST("/content/{cid}/comments/{id}/replies")
    public abstract RestResponse<Comment> addReplyToComment(@Path("cid") String paramString1, @Path("id") String paramString2, @Field("text") String paramString3);

    @Multipart
    @POST("/content")
    public abstract RestResponse<TaskInfo> addVideo(@Part("type") String paramString1, @Part("title") String paramString2, @Part("video_provider") String paramString3, @Part("vid") String paramString4, @Part("screens") String paramString5, @Part("length") String paramString6);

    @GET("/users/nicks_available")
    public abstract RestResponse<NickAvailability> checkNick(@Query("nick") String paramString);

    @FormUrlEncoded
    @POST("/stats/collect")
    public abstract RestResponse<Void> collectStats(@Field("data") String paramString);

    @FormUrlEncoded
    @POST("/content/{id}/stat")
    public abstract RestResponse<Void> contentStat(@Path("id") String paramString1, @Field("op") String paramString2, @Field("share_type") String paramString3);

    @DELETE("/account/cover")
    public abstract RestResponse<Void> deleteAccountCover();

    @DELETE("/account/photo")
    public abstract RestResponse<Void> deleteAccountPhoto();

    @DELETE("/account/socials/{network}")
    public abstract RestResponse<Void> deleteAccountSocials(@Path("network") String paramString);

    @DELETE("/content/{cid}/comments/{id}")
    public abstract RestResponse<Void> deleteComment(@Path("cid") String paramString1, @Path("id") String paramString2);

    @FormUrlEncoded
    @POST("/content/{cid}/comments")
    public abstract RestResponse<DeleteResponcesList> deleteComments(@Path("cid") String paramString1, @Query("method") String paramString2, @Field("id") String paramString3);

    @DELETE("/content/{id}")
    public abstract RestResponse<Void> deleteContent(@Path("id") String paramString);

    @DELETE("/app/push_token")
    public abstract RestResponse<Void> deletePushToken();

    @DELETE("/content/{cid}/republished")
    public abstract RestResponse<RepublishedCounter> deleteRepublishedContent(@Path("cid") String paramString1, @Query("from") String paramString2);

    @DELETE("/content/{id}/smiles")
    public abstract RestResponse<SmilesCounter> deleteSmile(@Path("id") String paramString1, @Query("from") String paramString2);

    @DELETE("/content/{cid}/comments/{id}/smiles")
    public abstract RestResponse<SmilesCounter> deleteSmileComment(@Path("cid") String paramString1, @Path("id") String paramString2);

    @DELETE("/content/{id}/unsmiles")
    public abstract RestResponse<SmilesCounter> deleteUnsmile(@Path("id") String paramString1, @Query("from") String paramString2);

    @DELETE("/content/{cid}/comments/{id}/unsmiles")
    public abstract RestResponse<SmilesCounter> deleteUnsmileComment(@Path("cid") String paramString1, @Path("id") String paramString2);

    @DELETE("/users/my/blocked/{id}")
    public abstract RestResponse<Void> deleteUserBlock(@Path("id") String paramString);

    @DELETE("/users/{uid}/subscribers")
    public abstract RestResponse<Void> deleteUserFromSubscribers(@Path("uid") String paramString);

    @GET("/account")
    public abstract RestResponse<User> getAccount();

    @GET("/users/by_nick/{nick}")
    public abstract RestResponse<User> getByNick(@Path("nick") String paramString);

    @FormUrlEncoded
    @POST("/feeds/collective")
    public abstract RestResponse<IFunnyFeed> getCollective(@Field("limit") int paramInt, @Field("prev") String paramString1, @Field("next") String paramString2);

    @GET("/sources/comics")
    public abstract RestResponse<RageMetaWrapper> getComicsSources();

    @GET("/content/{contentId}/comments/{id}")
    public abstract RestResponse<GetComment> getComment(@Path("contentId") String paramString1, @Path("id") String paramString2);

    @GET("/content/{id}/comments")
    public abstract RestResponse<CommentsFeedImpl> getComments(@Path("id") String paramString1, @Query("limit") int paramInt, @Query("show") String paramString2, @Query("prev") String paramString3, @Query("next") String paramString4);

    @GET("/content/{id}")
    public abstract RestResponse<IFunny> getContent(@Path("id") String paramString);

    @GET("/counters")
    public abstract RestResponse<RestNotification.Counters> getCounters();

    @GET("/account/default_covers")
    public abstract RestResponse<CoverFeed> getCovers();

    @GET("/feeds/featured")
    public abstract RestResponse<IFunnyFeed> getFeatured(@Query("limit") int paramInt, @Query("prev") String paramString1, @Query("next") String paramString2);

    @GET("/app/features")
    public abstract RestResponse<Features> getFeatures();

    @GET("/feeds/collective/meanwhile")
    public abstract RestResponse<IFunnyMeanwhileFeed> getMeanwhile(@Query("limit") int paramInt);

    @GET("/sources/memes")
    public abstract RestResponse<MemeSourcesFeed> getMemeSources(@Query("cat") String paramString1, @Query("limit") int paramInt, @Query("prev") String paramString2, @Query("next") String paramString3);

    @GET("/users/my/comments")
    public abstract RestResponse<MyCommented> getMyComments(@Query("limit") int paramInt, @Query("prev") String paramString1, @Query("next") String paramString2);

    @GET("/news/my")
    public abstract RestResponse<NewsFeed> getMyNews(@Query("limit") int paramInt, @Query("prev") String paramString1, @Query("next") String paramString2);

    @GET("/users/my/content_smiles")
    public abstract RestResponse<IFunnyFeed> getMySmiles(@Query("limit") int paramInt, @Query("prev") String paramString1, @Query("next") String paramString2);

    @GET("/feeds/popular")
    public abstract RestResponse<IFunnyFeed> getPopular(@Query("limit") int paramInt, @Query("prev") String paramString1, @Query("next") String paramString2);

    @GET("/content/{cid}/comments/{id}/replies")
    public abstract RestResponse<RepliesFeed> getReplies(@Path("cid") String paramString1, @Path("id") String paramString2, @Query("limit") int paramInt, @Query("show") String paramString3, @Query("prev") String paramString4, @Query("next") String paramString5);

    @GET("/content/{cid}/republished")
    public abstract RestResponse<RepublishersFeed> getRepublishers(@Path("cid") String paramString1, @Query("limit") int paramInt, @Query("prev") String paramString2, @Query("next") String paramString3);

    @GET("/app/shares")
    public abstract RestResponse<Shares> getShares();

    @GET("/content/{cid}/smiles")
    public abstract RestResponse<SmilersFeed> getSmilers(@Path("cid") String paramString1, @Query("limit") int paramInt, @Query("prev") String paramString2, @Query("next") String paramString3);

    @GET("/users/{id}/subscribers")
    public abstract RestResponse<SubscriptionsUserFeed> getSubscribers(@Path("id") String paramString1, @Query("limit") int paramInt, @Query("prev") String paramString2, @Query("next") String paramString3);

    @GET("/users/{id}/subscriptions")
    public abstract RestResponse<SubscriptionsUserFeed> getSubscriptions(@Path("id") String paramString1, @Query("limit") int paramInt, @Query("prev") String paramString2, @Query("next") String paramString3);

    @GET("/tasks/{id}")
    public abstract RestResponse<TaskInfo> getTask(@Path("id") String paramString);

    @GET("/timelines/users/{uid}")
    public abstract RestResponse<IFunnyFeed> getTimelineForUser(@Path("uid") String paramString1, @Query("limit") int paramInt, @Query("prev") String paramString2, @Query("next") String paramString3);

    @GET("/timelines/home")
    public abstract RestResponse<IFunnyFeed> getTimelineHome(@Query("limit") int paramInt, @Query("prev") String paramString1, @Query("next") String paramString2);

    @GET("/users/{id}")
    public abstract RestResponse<User> getUser(@Path("id") String paramString);

    @FormUrlEncoded
    @POST("/account/password_change_request")
    public abstract RestResponse<Void> passwordChange(@Field("email") String paramString);

    @FormUrlEncoded
    @POST("/app/shares")
    public abstract RestResponse<Shares> post(@Field("type") String paramString);

    @PUT("/content/{id}/abuses")
    public abstract RestResponse<Void> putAbuse(@Path("id") String paramString1, @Query("from") String paramString2);

    @FormUrlEncoded
    @PUT("/account")
    public abstract RestResponse<Void> putAccount(@Field("nick") String paramString1, @Field("about") String paramString2);

    @Multipart
    @PUT("/account/cover")
    public abstract RestResponse<UploadedCover> putAccountCover(@Part("cover") TypedOutput paramTypedOutput);

    @FormUrlEncoded
    @PUT("/account/email")
    public abstract RestResponse<Void> putAccountEmail(@Field("email") String paramString);

    @Multipart
    @PUT("/account/photo")
    public abstract RestResponse<UploadedPhoto> putAccountPhoto(@Part("photo") TypedOutput paramTypedOutput);

    @FormUrlEncoded
    @PUT("/account/socials/{network}")
    public abstract RestResponse<Void> putAccountSocials(@Path("network") String paramString1, @Field("client_id") String paramString2, @Field("client_token") String paramString3, @Field("client_token_secret") String paramString4, @Field("is_hidden") int paramInt);

    @FormUrlEncoded
    @PUT("/app/push_token")
    public abstract RestResponse<Void> putPushToken(@Field("type") String paramString1, @Field("token") String paramString2);

    @PUT("/content/{id}/smiles")
    public abstract RestResponse<SmilesCounter> putSmile(@Path("id") String paramString1, @Query("from") String paramString2);

    @PUT("/content/{cid}/comments/{id}/smiles")
    public abstract RestResponse<SmilesCounter> putSmileComment(@Path("cid") String paramString1, @Path("id") String paramString2);

    @PUT("/content/{id}/unsmiles")
    public abstract RestResponse<SmilesCounter> putUnsmile(@Path("id") String paramString1, @Query("from") String paramString2);

    @PUT("/content/{cid}/comments/{id}/unsmiles")
    public abstract RestResponse<SmilesCounter> putUnsmileComment(@Path("cid") String paramString1, @Path("id") String paramString2);

    @PUT("/users/{id}/abuses")
    public abstract RestResponse<Void> putUserAbuse(@Path("id") String paramString);

    @PUT("/users/my/blocked/{id}")
    public abstract RestResponse<Void> putUserBlock(@Path("id") String paramString);

    @PUT("/users/{uid}/subscribers")
    public abstract RestResponse<Void> putUserToSubscribers(@Path("uid") String paramString);

    @FormUrlEncoded
    @POST("/users")
    public abstract RestResponse<Void> register(@Field("reg_type") String paramString1, @Field("nick") String paramString2, @Field("email") String paramString3, @Field("client_id") String paramString4, @Field("client_token") String paramString5, @Field("client_token_secret") String paramString6, @Field("password") String paramString7);

    @POST("/content/{cid}/republished")
    public abstract RestResponse<RepublishedCounter> republishContent(@Path("cid") String paramString1, @Query("from") String paramString2);

    @GET("/search/content")
    public abstract RestResponse<SearchResponse> searchContent(@Query("q") String paramString1, @Query("limit") int paramInt, @Query("prev") String paramString2, @Query("next") String paramString3, @Query("counters") String paramString4);

    @GET("/search/sources/memes")
    public abstract RestResponse<MemeSourcesFeed> searchMemeSources(@Query("q") String paramString1, @Query("limit") int paramInt, @Query("prev") String paramString2, @Query("next") String paramString3);

    @GET("/search/users")
    public abstract RestResponse<SearchUsersResponce> searchUser(@Query("q") String paramString1, @Query("limit") int paramInt, @Query("prev") String paramString2, @Query("next") String paramString3, @Query("counters") String paramString4);

    @GET("/search/web_images")
    public abstract RestResponse<WebImageFeed> searchWebImages(@Query("q") String paramString1, @Query("type") String paramString2, @Query("prev") String paramString3, @Query("next") String paramString4);

    @GET("/test/{running_test}")
    public abstract RestResponse<Void> setRunningTest(@Path("running_test") String paramString1, @Query("info") String paramString2);

    @FormUrlEncoded
    @POST("/users/{id}/shares")
    public abstract RestResponse<Void> shareProfile(@Path("id") String paramString1, @Field("type") String paramString2);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/Retrofit$RestInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */