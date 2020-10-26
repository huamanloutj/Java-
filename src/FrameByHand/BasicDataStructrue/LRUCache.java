package FrameByHand.BasicDataStructrue;

import java.util.HashMap;

class LRUCache {
    class DLinkNode{
        int key;
        int value;
        DLinkNode pre,next;
        DLinkNode(){}
        DLinkNode(int key,int value){ this.key = key; this.value = value;}
    }
    int capacity;
    int size;
    HashMap<Integer,DLinkNode> cache = new HashMap<Integer,DLinkNode>();
    DLinkNode head,tail;

    public LRUCache(int capacity) {
        size = 0;
        this.capacity =  capacity;
        head  = new DLinkNode();
        tail  = new DLinkNode();
        head.next = tail;
        tail.pre = head;
    }
    public void addToHead(DLinkNode node){
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }
    public void moveToHead(DLinkNode node){
        removeNode(node);
        addToHead(node);
    }
    public void removeNode(DLinkNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    public DLinkNode removeTail(){
        DLinkNode tailNode = tail.pre;
        //得到节点然后删除，返回最后一个节点谁是谁
        removeNode(tailNode);
        return tailNode;
    }
    public int get(int key) {
        DLinkNode node  = cache.get(key);
        if (node == null)
            return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node == null){
            DLinkNode newNode = new DLinkNode(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            size ++;
            if (size > capacity){
                DLinkNode tailNode = removeTail();
                cache.remove(tailNode.key);
                size --;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
