/*

Reverse Nodes in k-Group

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

https://leetcode.com/problems/reverse-nodes-in-k-group/

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
    private void printListNode(ListNode root){
        ListNode t = root;
        while(t!=null){
            System.out.print(t.val + " ");
            t = t.next;
        }
        System.out.println();
    }
    private ListNode reverseLinkList(ListNode root, int k, ListNode p){
        //System.out.println(root.val);
        if(root == null)
            return null;
        ListNode prev = p;
        ListNode temp = root;
        int count = 1;
        while(count <= k && temp != null){
            count++;
            ListNode t = temp.next;
            temp.next = prev;
            prev = temp;
            temp = t;
        }
        return prev;
    }
    
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode fast = temp;
        if(k == 1 || head == null || head.next == null){
            return head;
        }
        while(true){
            int count = 1;
            while(fast!=null && count < k){
                count++;
                fast = fast.next;
            }
            
            if(fast != null){
                if(temp == head){
                    head = reverseLinkList(temp, k, fast.next);
                }
                else{
                    temp.next = reverseLinkList(temp.next, k, fast.next);
                }
                System.out.println(fast.val);
                printListNode(head);
                int c = 1;
                while(c < k){
                    c++;
                    fast = fast.next;
                }
                temp = fast;
                fast = fast.next;
            }else{
                break;
            }
            
        }
        return head;
    }
}
