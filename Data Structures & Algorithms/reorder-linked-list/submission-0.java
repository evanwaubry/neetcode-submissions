class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }
        // ^^ important base case so we dont break if theres only 1 value

        ListNode fast = head;
        ListNode slow = head;
        //we divide this into two halves using the fast and slow pointer approach, which can identify the middle of the list

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //now we split the list here
        ListNode second = slow.next;
        slow.next = null; //disconnects the 2 lists. important since it would iterate through the entire thing if this bit isnt here

        //slow will find the middle node at the end of this equation. we can now reverse the second half

        ListNode prev = null;
        ListNode curr = second;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //the second half of the list is now reordered, so we can now assign each value from prev and head to a value
        ListNode first = head;
        second = prev;

        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }
}