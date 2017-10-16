package kmitl.lab07.surasee2012.mylazyinstagram.api;

/**
 * Created by Gun on 10/6/2017.
 */

public class UserProfile {

    private String user;
    private String post;
    private String following;
    private String follower;
    private String bio;
    private String urlProfile;
    private Posts[] posts;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getUrlProfile() {
        return urlProfile;
    }

    public void setUrlProfile(String urlProfile) {
        this.urlProfile = urlProfile;
    }

    public Posts[] getPosts() {
        return posts;
    }

    public void setPosts(Posts[] posts) {
        this.posts = posts;
    }
}
