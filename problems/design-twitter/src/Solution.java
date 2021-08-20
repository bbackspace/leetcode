class Twitter {

    static class Tweet {
        int tweetIndex;
        int tweetId;

        static int globalTweetIdx;

        static {
            globalTweetIdx = 0;
        }

        Tweet(int tweetId) {
            tweetIndex = ++globalTweetIdx;
            this.tweetId = tweetId;
        }
        
        int getTweetIndex() {
            return tweetIndex;
        }
        
        int getTweetId() {
            return tweetId;
        }
    }
    
    static class User {
        int userId;
        
        User(int userId) {
            this.userId = userId;
        }
        
        int getUserId() {
            return userId;
        }
    }
    static class TweetsStore {
        Map<Integer, List<Tweet>> tweetsMap;
        
        TweetsStore() {
            tweetsMap = new HashMap<>();
        }
        
        void addTweet(User user, Tweet tweet) {
            List<Tweet> tweets = tweetsMap.get(user.getUserId());
            if (tweets == null) {
                tweets = new LinkedList<>();
            }
            tweets.add(tweet);
            if (tweets.size () > 10) {
                tweets.remove(0);
            }
            tweetsMap.put(user.getUserId(), tweets);
        }
        
        List<Tweet> getTweetsFor(User user) {
            if (tweetsMap.containsKey(user.getUserId())) {
                return tweetsMap.get(user.getUserId());
            }
            return new ArrayList<>();
        }
    }

    Map<Integer, Set<Integer>> followersMap;
    TweetsStore tweetsStore;

    /** Initialize your data structure here. */
    public Twitter() {
        followersMap = new HashMap<>();
        tweetsStore = new TweetsStore();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweetsStore.addTweet(new User(userId), new Tweet(tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        Set<Integer> followers = followersMap.get(userId);
        List<Tweet> tweets = new ArrayList<>();
        tweets.addAll(tweetsStore.getTweetsFor(new User(userId)));
        if (followers != null && followers.size() > 0) {
            for (Integer followee: followers) {
                tweets.addAll(tweetsStore.getTweetsFor(new User(followee)));
            }
        }
        newsFeed.addAll(tweets.stream()
                        .sorted(Comparator.comparingInt(Tweet::getTweetIndex).reversed())
                        .limit(10)
                        .map(Tweet::getTweetId)
                        .collect(Collectors.toList()));
        return newsFeed;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        Set<Integer> followers = followersMap.get(followerId);
        if (followers == null) {
            followers = new HashSet<>();
        }
        followers.add(followeeId);
        followersMap.put(followerId, followers);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        Set<Integer> followers = followersMap.get(followerId);
        if (followers == null) {
            return;
        }
        followers.remove(followeeId);
        followersMap.put(followerId, followers);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

