Java concurrency 예제
=========
## 예제 출처
- [Effective Java 2nd edition](http://www.yes24.com/24/goods/2416238)
	- package: ej2
	- 원본 : <http://java.sun.com/docs/books/effective/effective2.zip>
- [Java concurrency in practice](http://www.yes24.com/24/goods/1550580)
	- package : net.jcip 
	- 원본 : <http://jcip.net/listings.html>, <http://jcip.net/jcip-examples-src.jar> 
- [Java 언어로 배우는 디자인 패턴 입문 멀티 쓰레드 편](http://www.yes24.com/24/goods/2922297)
	- package : jdm
	- 원본 : <http://ndisk.youngjin.com/bookcd/pds_view.asp?pcd=9788931436921>
- [유쾌한 자바 퍼즐러](http://www.yes24.com/24/Goods/2600965)
	- 원본 : <http://www.javapuzzlers.com/java-puzzlers.zip>
	- package : jpz
- [Concurrent Programming Distributed Applications 발표](http://www.infoq.com/presentations/Concurrent-Distributed-Applications-Spring
)
	- SpringOne 2GX 2010에서 David Syer와 Mark Fisher가 한 발표
	- 원본 : <http://git.springsource.org/s2gx-2010/concurrent-programming-distributed-applications/trees/master/concurrency>
	- package : s2gx
- [Think in java 4th Edition](http://www.yes24.com/24/Goods/263372)
	- 원본 <http://www.mindviewinc.com/TIJ4/CodeDownload.php>
- 나머지는 직접 작성한 예제

## 장별 예제 정리 링크

### 3. java.lang.Thread 바로 알기
- 쓰지 말아야할 것: Thread.stop
	- [PrimeGenerator.java](src/main/java/net/jcip/examples/PrimeGenerator.java) : 협력적으로 Thread를 멈추는 방식
- 잘 알고 쓸 것 : Thread.interrupt
	- [SelfInterruption.java](src/main/java/jpz/puzzle84/SelfInterruption.java) :  Thread.interrupted()의 혼란성을 보여줌 
	- [BrokenPrimeProducer.java](src/main/java/net/jcip/examples/BrokenPrimeProducer.java) : BlockingQueue가 blocking되어 있으면 중지되지 않는 쓰레드
	- [PrimeProducer.java](src/main/java/net/jcip/examples/PrimeProducer.java) : interrupt로 중지할 수 있는 쓰레드

### 4. 동기화와 가시성
- Sychronized
	- [NonreentrantDeadlock.java](src/main/java/net/jcip/examples/NonreentrantDeadlock.java) : synchronized 키워드에 의한 lock은 재진입가능하다는 것을 보여줌
	- [SyncDemo.java](src/main/java/study/javacon/SyncDemo.java) : synchronized로 선언된 Block이 동시에 실행되지 못함을 보여줌.
	- [PingPong.java](src/main/java/jpz/puzzle76/PingPong.java) : static method의 syncronized 키워드의 동작방식을 보여줌. 
- 가시성 확보
	- [StopThread.java(Broken)](src/main/java/ej2/item66/broken/StopThread.java) : static 변수이지만 가시성 확보가 안 되어서 한 스레드에서 write한 값이 다른 thread에서 안 보이는 현상을 보여줌.
	- [StopThread.java(Fix1)](src/main/java/ej2/item66/fix1/StopThread.java) : 가시성 문제를 synchronized 메소드를 이용해서 동기화 시켜서 해결
	- [StopThread.java(Fix2)](src/main/java/ej2/item66/fix2/StopThread.java) : 가시성 문제를 volatile 키워드를 이용해서 해결 
	- [Worker.java](src/main/java/jpz/puzzle77/Worker.java) : 가시성 확보, 동기화를 모두 했음에도 Thread.join이 호출되면 예상치 못한 동작이 발생함을 보여줌
	
### 5. Java concurrent API
- Executors
	- [TimingThreadPool.java](src/main/java/net/jcip/examples/TimingThreadPool.java) : ThreadPoolExecutor를 확장해서 시간측정 로깅 기능을 추가한 예제
- Callable
	- [Preloader.java](src/main/java/net/jcip/examples/Preloader.java) : Callable, FutureTask , Thread 생성,  Future.get의 사용예. 
- java.util.concurrent.locks패키지
	- [ReadWriterMap.java](src/main/java/net/jcip/examples/ReadWriterMap.java) : ReadWriteLock을 활용해서 Map을 동기화한 사례
- CountDownLatch
	- [TestHarness.java](src/main/java/net/jcip/examples/TestHarness.java) : CountDownLatch를 이용해서 여러 쓰레드로 작업을 실행하고, 최종 종료시간을 구함
	- [ConcurrentTimer.java](src/main/java/ej2/item69/ConcurrentTimer.java) : TestHarness와 유사한 역할이나 스레드 생성 후에 실행되는 구간을 측정하기 위해 단계를 하나 더 두었음.
- Semaphore
	- [BoundedHashSet.java](src/main/java/net/jcip/examples/BoundedHashSet.java) :  counting semaphore를 활용해 제한된 크기의 Set을 구현함.
- 다양한 동기화 방식
	- [CounterDemo.java](src/main/java/s2gx/counter/CounterDemo.java) : Counter의 동작을 확인하는 클래스
	- [LockingCounter.java](src/main/java/s2gx/counter/LockingCounter.java) : WriteLock을 이용한 Counter
	- [SynchronizedCounter.java](src/main/java/s2gx/counter/SynchronizedCounter.java) : synchronized 키워드를 이용한 클래스
	- [AtomicCounter.java](src/main/java/s2gx/counter/AtomicCounter.java) : AtomicInteger를 이용한 클래스

### 6. Thread 안전 클래스
- Iterator
	- [IteratorAccessor.java](src/main/java/study/javacon/IteratorAccessor.java) : java.util.ConcurrentModificationException를 드러내주는 예제
	- [HiddenIterator.java](src/main/java/net/jcip/examples/HiddenIterator.java) : Iterator를 명시적으로 호출하지 않았는데도 문제가 되는 경우
	- [HiddenIteratorAccessor.java](src/main/java/net/jcip/examples/HiddenIteratorAccessor.java) : HiddenIterator의 에러를 드러내주는 클래스
- BlockingQueue
	- [PlainProsumer.java](src/main/java/study/javacon/queue/PlainProsumer.java) : wait, notify를 이용한 큐
	- [BlockingProsumer.java](src/main/java/study/javacon/queue/BlockingProsumer.java) : BlockingQueue를 이용
	
- Atomic class
	- [SimulatedCAS.java](src/main/java/net/jcip/examples/SimulatedCAS.java) : CAS 동작의 로직을 보여줌.
	- [CasCounter.java](src/main/java/net/jcip/examples/CasCounter.java) : CAS 로직을 이용한 Counter
- 설계 원칙
	- StackDemo.java :  쓰레드에 한정되어야할 객체를 콜스택 안에서 local변수로 생성하여 메소드 파라미터로 넘김.
	- ThreadLocalDemo.java : ThreadLocal을 이용.	
### 7. Documentation
- JCIP annotation
	- [Memo.java](src/main/java/study/javacon/findbugs/Memo.java) : @Immutable로 선언했을 때 Findbugs를 경고를 보여줌 
	- [LoginInfo.java](src/main/java/study/javacon/findbugs/LoginInfo.java) : Thread-safe하지 않은 클래스
	- [UserService.java](src/main/java/study/javacon/findbugs/UserService.java) : Thread-safe하지 않은 클래스를 멤버변수로 사용하는 코드

### 8. 성능
- 락좁히기
	- [AttributeStore.java](src/main/java/net/jcip/examples/AttributeStore.java) : 메소드 단위로 넓게 synchronized 구간을 선엄함.
	- [BetterAttriebuteStore.java](src/main/java/net/jcip/examples/BetterAttributeStore.java) : AttributeStore.java에서 꼭 필요한 부분만 synchronized 구간을 잡음
- 락분할
	- [ServerStatusBeforeSplit.java](src/main/java/net/jcip/examples/ServerStatusBeforeSplit.java) : 메소드 단위로 넓게 synchronized 구간을 선엄함.
	- [ServerStatusAfterSplit.java](src/main/java/net/jcip/examples/ServerStatusAfterSplit.java) : 메소드별로 필요한 객체에만 synchronized를 걸어서 Lock을 분할.
- 락스트라이핑
	- [StripedMap.java](src/main/java/net/jcip/examples/StripedMap.java) : 락 스트라이핑을 적용한 Map
	- [DefectedStripedMap.java](src/main/java/study/javacon/DefectedStripedMap.java) : StripedMap에서 Hash방식을 바꿈
	- [DefectedStripedMapTest.java](src/main/java/study/javacon/DefectedStripedMapTest.java) : DefectedStripedMap의 오류를 드러내는 테스트
- 바쁜 대기 없애기
	- [SlowCountDownLatch.java](src/main/java/ej2/item72/SlowCountDownLatch.java) : CountDownLatch를 무식하게 구현.
	- [BaseBoundBuffer.java](src/main/java/net/jcip/examples/BaseBoundedBuffer.java) : 크기가 한정된 Buffer의 기본 구현.
	- [GrumpyBoundBuffer.java](src/main/java/net/jcip/examples/GrumpyBoundedBuffer.java) : 바쁜 대기
	- [SleepyBoundBuffer.java](src/main/java/net/jcip/examples/SleepyBoundBuffer.java) : Sleep을 이용해서 바쁜 대기를 약간 없앰
	- [BoundedBuffer.java](src/main/java/net/jcip/examples/BoundedBuffer.java) : wait, notify를 이용
	- [ConditionBoundBuffer.java](src/main/java/net/jcip/examples/ConditionBoundedBuffer.java) : Lock클래스를 이용
- 늦은 초기화
	- [Initialization.java](src/main/java/ej2/item71/Initialization.java) : lazy initialization의 여러 방식을 보여줌
	- [MySystem.java(Single)](src/main/java/jdm/appendixa/single/MySystem.java) : 초기화 메서드 전체에 동기화가 걸림.
	- [MySystem.java(Double Checked)](src/main/java/jdm/appendixa/doublechecked/MySystem.java) : doublechecked lock을 적용
	- [MySystem.java(Holder)](src/main/java/jdm/appendixa/holder/MySystem.java) : Holder패턴을 적용할려는 예정으로 있는 클래스
	- [ColorPoint.java](src/main/java/jpz/puzzle51/ColorPoint.java) : final필드에 값이 할당되기 전에도 읽는 것이 가능하고, 늦은 초기화가 필요한 경우를 보여줌.
