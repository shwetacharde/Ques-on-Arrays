class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> prev=null;
        for(int i=0; i<numRows ;i++){
            List<Integer> a = new ArrayList<>();
            for(int j=0; j<=i ; j++){
                if(j==0 || j==i)
                    a.add(1);
                else
                   a.add(prev.get(j-1) + prev.get(j));
            }
            prev=a;
            lst.add(a);
        }
        return lst;
    }
}
