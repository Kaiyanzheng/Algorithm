package foundation.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FifoReadWriteLock {

    /**
     * This algorithm is fair because the readers can't block a writer indefinitely.
     * Once a writer indicates that it wants to acquire the lock, no more readers can acquire the lock.
     * After that the writer simply waits for the last remaining readers to finish up before continuing.
     * Note that there's still the possibility of a writer indefinitely blocking another writer.
     * That's a fairly rare case but the algorithm could be improved to take that into account.
     *
     *
     * So I re-read your question and realised that I partly (badly) answered it with the algorithm presented below.
     * So here's my second attempt.
     *
     * The algorithm, you described is fairly similar to the simple version presented in the book I mentioned.
     * The only problem is that
     * A) it's not fair
     * B) I'm not sure how you would implement wait until recursive mutex has lock count zero.
     * For A), see above and for B), the book uses a single int to keep track of the readers and a condition variable to do the signalling.
     */


    /** @condition
     * initialized using the lock.
     * when a thread calls condition.await(),
     * it gives up its ownership of the lock.
     * Once it's woken up by a call to condition.signalAll()
     * the thread will resume once it has reacquired the lock.
     *
     * @readAcquires
     * @readReleases
     * keep track of the # of threads that have acquired and released the read lock.
     * When these are equal, no thread has the read lock.
     *
     * @writer
     * indicates that a thread is trying to acquire the write lock or it already has it.
     */

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition(); // This is the condition variable.
    private volatile int readAcquires = 0;
    private volatile int readReleases = 0;
    private volatile boolean writer = false;

    public void readLock () throws InterruptedException{
        lock.lock();
        try {
            while(writer) {        // checks to see if a writer is holding the lock or is trying to acquire it.
                condition.await(); // waits until the writer is done
            }
            readAcquires++;        // claims the lock for the readers by incrementing the readAcquires variable.
        } finally {
            lock.unlock();
        }
    }

    public void readUnlock () {
        lock.lock();
        try {
            readReleases++;
            if (readAcquires == readReleases) { // if there's no more readers, it notifies any writers that may be waiting.
                condition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public void writeLock () throws InterruptedException{
        lock.lock();
        try {
            while (writer) {       // check whether any other writer is active.
                condition.await(); // wait until the other writer is done.
            }
            writer = true;         // indicates that it wants the lock by setting writer to true (note that it doesn't hold it yet).
            while (readAcquires != readReleases) {
                condition.await(); // waits until there's no more readers before continuing.
            }
        } finally {
            lock.unlock();
        }
    }

    public void writeUnlock() {
        writer = false;
        condition.signalAll();
    }
}