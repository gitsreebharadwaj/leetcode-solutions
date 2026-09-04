class DisjointSet {
    int[] rank;
    int[] size;
    int[] parent;
    DisjointSet(int n) {
        rank=new int[n];
        size=new int[n];
        parent=new int[n];
        for(int i=0; i<n; i++) {
            rank[i]=0;
            size[i]=1;
            parent[i]=i;
        }
    }
    int findUParent(int node) {
        if(node==parent[node]) {
            return node;
        }
        return parent[node]=findUParent(parent[node]);
    }
    void unionDirect(int u, int v) {
        int upu=findUParent(u);
        int upv=findUParent(v);
        if(upu!=upv) {
            parent[upu]=upv;
        }
    }
    void unionByRank(int u, int v) {
        int upu=findUParent(u);
        int upv=findUParent(v);
        if(upu==upv) {
            return;
        }
        if(rank[upu]<rank[upv]) {
            parent[upu]=upv;
        }
        else if(rank[upv]<rank[upu]) {
            parent[upv]=upu;
        }
        else {
            parent[upv]=upu;
            rank[upu]+=1;
        }
    }
    void unionBySize(int u, int v) {
        int upu=findUParent(u);
        int upv=findUParent(v);
        if(upu==upv) {
            return;
        }
        if(size[upu]<size[upv]) {
            parent[upu]=upv;
            size[upv]+=size[upu];
        }
        else {
            parent[upv]=upu;
            size[upu]+=size[upv];
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DisjointSet ds=new DisjointSet(accounts.size());
        Map<String, Integer> map=new HashMap<>();
        for(int i=0; i<accounts.size(); i++) {
            for(int j=1; j<accounts.get(i).size(); j++) {
                String mail=accounts.get(i).get(j);
                if(!map.containsKey(mail)) {
                    map.put(mail, i);
                }
                else {
                    ds.unionBySize(i, map.get(mail));
                }
            }
        }
        List<List<String>> mergedMails=new ArrayList<>();
        for(int i=0; i<accounts.size(); i++) {
            mergedMails.add(new ArrayList<>());
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String mail=entry.getKey();
            int owner=ds.findUParent(entry.getValue());
            mergedMails.get(owner).add(mail);
        }
        List<List<String>> ans=new ArrayList<>();
        for(int i=0; i<accounts.size(); i++) {
            if(mergedMails.get(i).size()==0) {
                continue;
            }
            Collections.sort(mergedMails.get(i));
            List<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it : mergedMails.get(i)) {
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}
