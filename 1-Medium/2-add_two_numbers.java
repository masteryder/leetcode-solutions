/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.math.BigInteger;

// This solution uses the BigInteger library which is probably not what they had in mind, but it works :)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        BigInteger num1 = BigInteger.ZERO;
        BigInteger num2 = BigInteger.ZERO;
        
        ListNode curL1 = l1;
        BigInteger multiplicator = BigInteger.ONE;
        while(curL1 != null){
            num1 = num1.add(multiplicator.multiply(BigInteger.valueOf(curL1.val)));
            multiplicator = multiplicator.multiply(BigInteger.valueOf(10));
            curL1 = curL1.next;
        }
        
        multiplicator = BigInteger.ONE;
        ListNode curL2 = l2;
        while(curL2 != null){
            num2 = num2.add(multiplicator.multiply(BigInteger.valueOf(curL2.val)));
            multiplicator = multiplicator.multiply(BigInteger.valueOf(10));
            curL2 = curL2.next;
        }
        
        // get the actual sum as an integer
        BigInteger iRes = num1.add(num2);
        
        ListNode resList = new ListNode();
        
        int nbDigits = 0;
        multiplicator = BigInteger.ONE;
        
        while(true){
            if(iRes.compareTo(multiplicator) >= 0){
                nbDigits+=1;
                multiplicator = multiplicator.multiply(BigInteger.valueOf(10));
            }
            else {
                break;
            }
        }
        
        ListNode curListEl = resList;
        for(int i = 0; i < nbDigits; i++){
            if(i > 0){
                curListEl.next = new ListNode();
                curListEl = curListEl.next;
            }
            curListEl.val = iRes.mod(BigInteger.valueOf(10)).intValue();
            iRes = iRes.divide(BigInteger.valueOf(10));
        }
        return resList;
    }
}