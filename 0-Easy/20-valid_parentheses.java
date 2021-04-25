class Solution {
    public boolean isValid(String s) {
        ArrayList<Character> openings = new ArrayList(Arrays.asList('(','{','['));
        ArrayList<Character> closings = new ArrayList(Arrays.asList(')','}',']'));

        int count = 0;
        Stack<Integer> lastOpenedIndex = new Stack<Integer>();

        for(char c : s.toCharArray() )
        {
            if(openings.contains(c)){
                count++;
                lastOpenedIndex.push(openings.indexOf(c));
            }
            else if(closings.contains(c)){
                if (count == 0 || closings.indexOf(c) != lastOpenedIndex.pop()) return false;
                count--;
            }
            else return false;
        }

        if(count != 0 ) return false;
        return true;
    }
}