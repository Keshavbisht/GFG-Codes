// User function Template for Java
class Solution {
    static String lexicographicallySmallest(String S, int k) {
        // code here
        
        int n = S.length();
        if((n & (n-1)) == 0){
            k = k/2;
        }
        else{
            k = k*2;
        }
        if(n <= k) return "-1";
        Stack<Character> st = new Stack<>();
        for(int i = 0; i< S.length(); i++){
            char temp = S.charAt(i);
            while(!st.isEmpty() && k > 0 && temp < st.peek()){
                st.pop();
                k--;
            }
            st.push(temp);
        }
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        if (sb.length() == 0) return "-1";
        return sb.reverse().toString();
    }
}