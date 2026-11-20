class Twitter {
    class Tweet {
        int id;
        int time;
        Tweet(int id, int time) {
            this.id=id;
            this.time=time;
        }
    }
    private int timestamp;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<Tweet>> tweetMap;
    public Twitter() {
        this.timestamp=0;
        this.followMap=new HashMap<>();
        this.tweetMap=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        follow(userId, userId);
        if(!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }
        tweetMap.get(userId).add(new Tweet(tweetId, timestamp));
        timestamp++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed=new ArrayList<>();
        if(!followMap.containsKey(userId)) {
            return feed;
        }
        Set<Integer> followees=followMap.get(userId);
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a, b)->{
            Tweet tweetA=tweetMap.get(a[0]).get(a[1]);
            Tweet tweetB=tweetMap.get(b[0]).get(b[1]);
            return Integer.compare(tweetB.time, tweetA.time);
        });
        for(int followerId : followees) {
            if(tweetMap.containsKey(followerId)) {
                List<Tweet> tweets=tweetMap.get(followerId);
                if(!tweets.isEmpty()) {
                    int lastIdx=tweets.size()-1;
                    maxHeap.offer(new int[]{followerId, lastIdx});
                }
            }
        }
        while(!maxHeap.isEmpty() && feed.size()<10) {
            int[] curr=maxHeap.poll();
            int followerId=curr[0];
            int currIdx=curr[1];
            Tweet tweet=tweetMap.get(followerId).get(currIdx);
            feed.add(tweet.id);
            if(currIdx>0) {
                maxHeap.offer(new int[]{followerId, currIdx-1});
            }
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId) {
            return;
        }
        if(followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
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
