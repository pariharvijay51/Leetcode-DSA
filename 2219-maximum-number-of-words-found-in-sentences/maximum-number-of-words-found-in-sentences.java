class Solution {
    public int mostWordsFound(String[] sentences) {
      int maxlength=0;
      for(int i=0;i<sentences.length;i++){
         int count=sentences[i].split(" ").length;
         if(count>maxlength){
            maxlength = count;
         }
      }
      return maxlength;
    }
}