/*

2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

*/

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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode();
        ListNode newNode = head;
        
        int r = 0,a = 0,c = 0;
        a = l1.val + l2.val;
        r = a % 10;
        c = a / 10;
        newNode.val = r;
        newNode.next = null;
        l1 = l1.next;
        l2 = l2.next;
        
        while(l1 != null && l2 != null){
            //System.out.println(l1.val + " " + l2.val);
            a = l1.val + l2.val + c;
            r = a % 10;
            c = a / 10;
            ListNode temp = new ListNode(r);
            temp.next = null;
            newNode.next = temp;
            newNode = temp;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null || l2 != null){
            while(l1 != null){
                a = l1.val + c;
                r = a % 10;
                c = a / 10;
                ListNode temp = new ListNode(r);
                temp.next = null;
                newNode.next = temp;
                newNode = temp;
                l1 = l1.next;
            }
            
            while(l2 != null){
                a = l2.val + c;
                r = a % 10;
                c = a / 10;
                ListNode temp = new ListNode(r);
                temp.next = null;
                newNode.next = temp;
                newNode = temp;
                l2 = l2.next;
            }
        }
        
        if(c == 1){
            ListNode temp = new ListNode(c);
            temp.next = null;
            newNode.next = temp;
        }
        
        return head;
    }
}
