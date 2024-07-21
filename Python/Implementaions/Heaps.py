class Heaps:
    def __init__(self,arrr:list=None) -> None:
        self.heap:list= []
        self.heapSize:int= 0;
        if arrr is not None:
            self.heap=arrr[:];
            self.heapSize=len(self.heap);
    
    def build_max_heap(self):
        i:int 
        for i in range(self.heapSize//2-1,-1,-1):
            self.heapify_down(i)
            
    def heapify_up(self,index:int):
        parent= (index-1)//2
        val = self.heap[index]
        while(index > 0 and val > self.heap[parent]):
            self.heap[index]=self.heap[parent]
            index=parent;
            parent=(index-1)//2
        self.heap[index]=val
        
    def insert(self,value:int)->None:
        self.heap.append(value)
        self.heapSize+=1
        self.heapify_up(self.heapSize-1)
        
    def heapsort(self)->None:
        self.build_max_heap()
        ogHeight = self.heapSize
        for i in range(self.heapSize-1,0,-1):
            val = self.heap[0]
            self.heap[0]=self.heap[i]
            self.heap[i]=val
            self.heapSize-=1
            self.heapify_down(0)
        self.heapSize=ogHeight
    def heapify_down(self,index:int):
        left:int = (index*2)+1
        right:int = (index*2)+2
        largest=index;
        if left<self.heapSize and self.heap[left]>self.heap[largest] :
            largest=left
        if right<self.heapSize and self.heap[right]>self.heap[largest] :
            largest=right;
        if largest != index:
            temp = self.heap[index]
            self.heap[index]=self.heap[largest]
            self.heap[largest]=temp;
            self.heapify_down(largest)

    def delete_max(self):
        if self.isEmpty():
            return None
        maxValue = self.heap[0]
        lastValue = self.heap[self.heapSize-1]
        self.heapSize-=1
        if not self.isEmpty():
            self.heap[0]=lastValue;
            self.heapify_down(0)
        return maxValue
    def peek(self):
        if self.isEmpty():
            return None
        return self.heap[0]
            
    def get_size(self)->int:
        return self.heapSize
    def get_heap(self)->list:
        return self.heap;
    def isEmpty(self)->bool:
        return self.heapSize == 0
            
