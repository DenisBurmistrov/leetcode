package ru.burmistrov.leetcode;

import java.util.StringJoiner;

//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode first = new ListNode(9, new ListNode(9, new ListNode(9, null)));
        ListNode second = new ListNode(9, new ListNode(9));
        System.out.println(first);
        System.out.println(second);
        System.out.println(addTwoNumber(first, second));
    }

    static ListNode addTwoNumber(ListNode first, ListNode second) {
        ListNode result = new ListNode();
        addTwoNumber(first, second, result, 0);
        return result;
    }

    static ListNode addTwoNumber(ListNode first, ListNode second, ListNode result, int additionalFromPrev) {
        if (first == null && second == null) {
            if (additionalFromPrev > 0) {
                result.setVal(additionalFromPrev);
            }
            return result;
        }
        int newVal;
        int firstVal = first == null ? 0 : first.getVal();
        int secondVal = second == null ? 0 : second.getVal();
        int sum = firstVal + secondVal + additionalFromPrev;
        if (sum >= 10) {
            newVal = sum % 10;
        } else {
            newVal = sum;
        }
        additionalFromPrev = sum / 10;
        if (result == null) {
            result = new ListNode();
        }
        result.setVal(newVal);
        ListNode firstNext = first != null ? first.getNext() : null;
        ListNode secondNext = second != null ? second.getNext() : null;
        if (firstNext != null || secondNext != null || additionalFromPrev > 0) {
            result.setNext(new ListNode());
        }

        return addTwoNumber(
                firstNext,
                secondNext,
                result.getNext(),
                additionalFromPrev
        );
    }
}


class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        stringJoiner.add(String.valueOf(val));
        ListNode temp = next;
        while (temp != null) {
            stringJoiner.add(String.valueOf(temp.getVal()));
            temp = temp.getNext();
        }
        return stringJoiner.toString();
    }
}
