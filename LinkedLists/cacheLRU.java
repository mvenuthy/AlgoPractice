/*  Create a LRU Cache 


*/


class LRUCache {
    
    private class dListNode{
        int key;
        int value;
        dListNode next;
        dListNode prev;
    }
    
    private HashMap<Integer,dListNode> keyMap = new HashMap<Integer,dListNode>();
    private dListNode dummyHead;
    private dListNode dummyTail;
    private int totalItemsInCache;
    private int maxCapacity;
      
    public LRUCache(int capacity) {
        totalItemsInCache = 0;
        this.maxCapacity = capacity;
        
        dummyHead = new dListNode();
        dummyHead.prev = null;
        
        dummyTail = new dListNode();
        dummyTail.next = null;
        
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
            
    }
    
    public int get(int key) {
        dListNode node = keyMap.get(key);
        boolean isIteminCache = (node != null);
        
        if(isIteminCache == false){return -1;}
        movetoHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        dListNode node = keyMap.get(key);
        boolean isIteminCache = (node != null);
        
        if(isIteminCache == false){
            dListNode newNode = new dListNode();
            newNode.value = value;
            newNode.key = key;
            keyMap.put(key,newNode);
            addNode(newNode);            
            totalItemsInCache++;            
            if(totalItemsInCache > maxCapacity){
                removeCacheEntry();   
            }        
        }else{
            node.value = value;
            movetoHead(node);
        }               
    }
    
    private void addNode(dListNode node){
        dListNode temp = dummyHead.next;
        node.next = temp;
        node.prev = dummyHead;
        temp.prev = node;        
        dummyHead.next = node;
    }
    
    private void removeNode(dListNode node){
        dListNode prevTemp = node.prev;
        dListNode nextTemp = node.next;
        prevTemp.next = nextTemp;
        nextTemp.prev = prevTemp;
    }
    
    private dListNode removeTailEntry(){
        dListNode itemRemoved = dummyTail.prev;
        removeNode(itemRemoved);
        return itemRemoved;
    }
    
    private void removeCacheEntry(){
        dListNode nodeRemoved = removeTailEntry();
        keyMap.remove(nodeRemoved.key);
        --totalItemsInCache;
    }
    
    private void movetoHead(dListNode node){
        removeNode(node);
        addNode(node);
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
