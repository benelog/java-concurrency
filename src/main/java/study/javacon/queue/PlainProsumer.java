package study.javacon.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
 
public class PlainProsumer {  
    private static List<Integer> queue = new ArrayList<Integer>();  
      
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
      
    static class Producer implements Runnable {  
        private volatile static int index = 1;  
          
        private List<Integer> queue;  
          
        public Producer(List<Integer> queue) {  
            this.queue = queue;  
        }  
          
        public void run() {  
            while(true) {  
                try {  
                    Thread.sleep(new Random().nextInt(1000));  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
 
                synchronized (queue) {  
                    queue.add(index++);  
                    queue.notify();   
                }  
            }  
        }  
    }  
      
    // 소비자.. 생산해 낸 것을 열심히 사용하자.  
    static class Consumer implements Runnable {  
        private List<Integer> queue;  
        private String name;  
        public Consumer(String name, List<Integer> queue) {  
            this.name = name;  
            this.queue = queue;  
        }  
          
        public void run() {  
            while ( true ) {  
                synchronized (queue) {  
                    try {  
                        // 데이터가 들어 있지 않고 비었다면 데이터가 올때까지 기다리자.   
                        if ( queue.isEmpty() ) {  
                                queue.wait();  
                        }  
                          
                        // 생산자에서 데이터를 집어 넣고 notify해 줘서 wait를 벗어나 아래의 코드가 수행된다.  
                        Integer index = queue.remove(0);  
                        System.err.println("Consumer : " + name + "\tCount : " + index);  
                          
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        }  
    }  
}  