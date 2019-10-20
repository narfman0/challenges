package algs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestReorderList {
    @Test
    public void testReorderList() {
        int start = 120;
        ReorderList.ListNode head = new ReorderList.ListNode(start++), current = head;
        for(int i = 1; i<=10; i++){
            current.next = new ReorderList.ListNode(start++);
            current = current.next;
        }
        ReorderList.reorderList(head);
        assertEquals(120, head.val);
        assertEquals(130, head.next.val);
        assertEquals(121, head.next.next.val);
        assertEquals(129, head.next.next.next.val);
        assertEquals(122, head.next.next.next.next.val);
    }
}
