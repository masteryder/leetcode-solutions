class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a new map of <String, Array<Integer>() that will hold our indices
        // go through list of words
            // for each create a new string that is equal to the word but with its characters in alphabetical order
            // if map contains word, then add index to the Integer list, otherwise create new map entry and add current index to it.
        // Iterate over the values of the map and create result array based on indices
        HashMap<String, ArrayList<Integer>> anagram_indices = new HashMap();
        for(int i = 0; i< strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            if(!anagram_indices.containsKey(sortedString)){
                anagram_indices.put(sortedString, new ArrayList<Integer>());
            }
            anagram_indices.get(sortedString).add(i);
        }
        List<List<String>> result = new ArrayList();
                                  
        for(String sortedString : anagram_indices.keySet()){
            ArrayList<String> cur_anagrams = new ArrayList();
            for(int index : anagram_indices.get(sortedString)){
                cur_anagrams.add(strs[index]);
            }
            result.add(cur_anagrams);
        }
        return result;
    }
}