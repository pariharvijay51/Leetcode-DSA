class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer,String> map=new HashMap<>();
         int n=heights.length;
        for(int i=0;i<n;i++){
            map.put(heights[i],names[i]);
        }

        Arrays.sort(heights);
        String Result[]=new String[n];
        for(int i=0;i<n;i++){
         Result[i]= map.get(heights[n-i-1]);

        }
        return Result;
    }


}