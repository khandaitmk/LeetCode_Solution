import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private int turn = 1;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition cv = lock.newCondition();

    public FizzBuzz(int n) {
        this.n = n;
        turn = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        lock.lock();
        try {
            while (turn <= n) {
                while (turn <= n && (turn % 3 != 0 || turn % 5 == 0)) {
                    cv.await();
                }
                if (turn > n) {
                    break;
                }
                printFizz.run();
                turn++;
                cv.signalAll();
            }
        } finally {
            cv.signalAll();
            lock.unlock();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        lock.lock();
        try {
            while (turn <= n) {
                while (turn <= n && (turn % 3 == 0 || turn % 5 != 0)) {
                    cv.await();
                }
                if (turn > n) {
                    break;
                }
                printBuzz.run();
                turn++;
                cv.signalAll();
            }
        } finally {
            cv.signalAll();
            lock.unlock();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        lock.lock();
        try {
            while (turn <= n) {
                while (turn <= n && (turn % 3 != 0 || turn % 5 != 0)) {
                    cv.await();
                }
                if (turn > n) {
                    break;
                }
                printFizzBuzz.run();
                turn++;
                cv.signalAll();
            }
        } finally {
            cv.signalAll();
            lock.unlock();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (turn <= n) {
                while (turn <= n && (turn % 3 == 0 || turn % 5 == 0)) {
                    cv.await();
                }
                if (turn > n) {
                    break;
                }
                printNumber.accept(turn);
                turn++;
                cv.signalAll();
            }
        } finally {
            cv.signalAll();
            lock.unlock();
        }
    }
}