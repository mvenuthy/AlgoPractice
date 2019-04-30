/*
    Algorithm
    - Traverse the entire array and store the elements in the array into a hashmap with <key, value> pairs
    - Key would be the element in the array and value would be the number of times it occurs in the array
    - Use the count of each element as the key and the values as a list of values and add it to a treemap.
    - Add the first k entries from the treemap into a list
    - Return the list
*/

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
          Map<Integer, Integer> unsort = new HashMap<Integer, Integer>();
          for(int n:nums){
              unsort.put(n, unsort.getOrDefault(n,0)+1);
          }
          
          TreeMap<Integer, List<Integer>> sortedMap = new TreeMap<>();
          for(int num:unsort.keySet()){
            int count = unsort.get(num);
            if(!sortedMap.containsKey(count)){
                sortedMap.put(count, new LinkedList<>());      
            }  
            sortedMap.get(count).add(num);
          }        
    
          List<Integer> resultList = new ArrayList<>();
          while(resultList.size() < k){
              Map.Entry<Integer, List<Integer>> entry = sortedMap.pollLastEntry();
              resultList.addAll(entry.getValue());
          }
        
          return resultList;
    }
}
