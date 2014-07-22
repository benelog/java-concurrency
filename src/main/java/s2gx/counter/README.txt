Thread Safety:
   * UnsafeCounter is not thread safe
   * run CounterDemo with multiple threads to witness
   * The other 2 implementations are thread safe, each using a different approach:
        - SynchronizedCounter uses the 'synchronized' keyword
        - LockingCounter uses a write lock instance
        - AtomicCounter delegates to an AtomicInteger

The CounterDemo can also be modified to demonstrate a Performance Myth-buster:
   Myth: "More threads means better performance"
   Q: what happens when we replace the multithreaded Executor with a single thread?
   A: it's FASTER!

The reason is that the high number of threads causes a high degree of context switching. In this case, the task is CPU-bound anyways, so adding the overhead of
context switching actually hinders performance. The process can be optimized, as
can any non I/O bound process, by basing the thread pool size on the number of
processors available for execution.

Trick question: is the single-thread executor version "Thread Safe"?
A: sort of, but it's dangerous to rely upon the assumption that only one thread will
ever be accessing the Counter's increment method. It's better to have thread-safety
at the level of the Counter itself.
