class Foo {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition cv = lock.newCondition();
    private int turn = 0;

    public Foo() {
        turn = 0;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();

        try{
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        turn = 1;
        cv.signalAll();
        }finally{
        lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try{
            // printSecond.run() outputs "second". Do not change or remove this line.
        while(turn != 1){
            cv.await();
        }
        printSecond.run();
        turn = 2;
        cv.signalAll();
        }finally{
        lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try{
        // printThird.run() outputs "third". Do not change or remove this line.
        while(turn != 2){
            cv.await();
        }
        printThird.run();
        }finally{
        lock.unlock();
        }
    }
}