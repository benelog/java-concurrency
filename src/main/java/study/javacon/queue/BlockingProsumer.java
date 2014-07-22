package study.javacon.queue;
import java.util.Random;  
import java.util.concurrent.ArrayBlockingQueue;  
import java.util.concurrent.BlockingQueue;  
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
public class BlockingProsumer {  
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);  
      
    public static void main(String[] args) {  
        Consumer c1 = new Consumer("1", queue);  
        Consumer c2 = new Consumer("2", queue);  
        Consumer c3 = new Consumer("3", queue);  
          
        Producer p1 = new Producer(queue);  
        
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        threadPool.execute(c1);
        threadPool.execute(c2);
        threadPool.execute(c3);
        threadPool.execute(p1);
    }  
      
    // 생산자. - 무언가를 열심히 만들어 낸다.  
    static class Producer implements Runnable {  
        // INDEX  
        private volatile static int i = 1;  
          
        private BlockingQueue<Integer> queue;  
          
        public Producer(BlockingQueue<Integer> queue) {  
            this.queue = queue;  
        }  
          
        public void run() {  
            // 임의의 시간마다 데이터를 넣어 준다.  
            while(true) {  
                try {  
                    Thread.sleep(new Random().nextInt(500));  
                    queue.put(i++); 
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
  
            }  
        }  
    }  
      
      
    // 소비자.. 생산해 낸 것을 열심히 사용하자.  
    static class Consumer implements Runnable {  
        private BlockingQueue<Integer> queue;  
        private String name;  
        public Consumer(String name, BlockingQueue<Integer> queue) {  
            this.name = name;  
            this.queue = queue;  
        }  
          
        public void run() {  
            while ( true ) {  
                try {  
                    Integer index = queue.take();  
                    System.err.println("Consumer : " + name + "\tIndex : " + index);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }  
      
}  