package algs;

import java.util.HashMap;

public class ReorderList {
    public static class ListNode{
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }

        @Override public String toString(){
            return val + (next != null ? " -> " + next.val : "");
        }

        public int length(){
            if(next == null)
                return 0;
            return 1 + next.length();
        }
    }

    public static void reorderList(ListNode head) {
        HashMap<Integer, ListNode> nodeMap = new HashMap<>();
        ListNode n = head;
        int count = 0;
        while(n != null){
            nodeMap.put(count++, n);
            n = n.next;
        }
        for(int i=0, j=count-1; i<count && j >= i; i++){
            ListNode in = nodeMap.get(i);
            ListNode jn = nodeMap.get(j);
            in.next = i == j ? null : jn;
            if(jn != null && i != j)
                jn.next = nodeMap.get(i+1);
            j--;
        }
    }
}
