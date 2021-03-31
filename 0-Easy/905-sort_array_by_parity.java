class Solution {
    public int[] sortArrayByParity(int[] A) {
        int pointerA = 0;
        int pointerB = A.length-1;

        while(pointerA < pointerB)
        {
            if(A[pointerA] %2 !=0)
            {
                int placeholder = A[pointerA];
                A[pointerA] = A[pointerB];
                A[pointerB] = placeholder;
                pointerB--;
            }
            else{
                pointerA++;
            }
        }
        return A;
    }
}