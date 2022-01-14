package lzy.cs.algorithm.leetcode.list.medium;

import lzy.cs.algorithm.ListNode;

import java.util.HashMap;
import java.util.Map;

import static lzy.cs.algorithm.ListNodeOPT.printList;

// h-1,1-2,2-r
// h-2,2-1,1-r
// h-1,1-3,3-r
// h-3,3-4,4-r

public class question146_LRUCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }
}

// 1-1,2,2
// 2,2-1,1
// 1,1-3,3
// 3,3-4,4
class LRUCache {

    class DbListNode {
        int key;
        int value;
        DbListNode prev;
        DbListNode next;

        public DbListNode(int key,int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        public DbListNode(int key,int value, DbListNode prev, DbListNode next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public int capacity = 0;
    public Map<Integer, DbListNode> map;
    public DbListNode dummyHead = null;
    public DbListNode dummyRear = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        dummyHead = new DbListNode(-1,-1);
        dummyRear = new DbListNode(-1,-1);
        dummyHead.prev = null;
        dummyHead.next = dummyRear;
        dummyRear.prev = dummyHead;
        dummyRear.next = null;
    }

    // h - 1,1 - 2,2 - 3,3 - 4,4 - r
    public int get(int key) {
        if (map.containsKey(key)){
            int value = map.get(key).value;
            DbListNodeMoveToRear(map.get(key),this.dummyRear);
            return value;
        }else {
            return -1;
        }
    }

    // h - 1,1 - 2,2 - 3,3 - r
    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.get(key).value = value;
            DbListNodeMoveToRear(map.get(key),this.dummyRear);
        }else {
            DbListNode newNode = new DbListNode(key,value);
            DbListAddNodeToRear(newNode,this.dummyRear);
            if (map.size() >= this.capacity){
                map.remove(this.dummyHead.next.key);
                this.dummyHead = this.dummyHead.next;
                this.dummyHead.prev = null;
                this.dummyHead.key = -1;
                this.dummyHead.value = -1;

            }
            map.put(key,newNode);
        }
    }


    // h - 1,1 - 2,2 - 3,3 - 4,4 - r
    // h - 1,1 - r
    public void DbListNodeMoveToRear(DbListNode node,DbListNode dummyRear){
        DbListNode prevNode = node.prev;
        prevNode.next = node.next;
        node.next.prev = prevNode;
        DbListAddNodeToRear(node,dummyRear);
    }

    // h - 1,1 - 2,2 - 3,3 - r
    public void DbListAddNodeToRear(DbListNode node,DbListNode dummyRear){
        DbListNode lastNode = dummyRear.prev;
        node.next = dummyRear;
        node.prev = lastNode;
        lastNode.next = node;
        dummyRear.prev = node;
    }
}
