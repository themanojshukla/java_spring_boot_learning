package day4.extraCodeReferences;

import java.time.Duration;
import java.util.stream.IntStream;

public class Task implements Runnable {

    private final int taskNumber;

    public Task(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void run() {
//        System.out.println("[" + new Date() + "]" + " Starting Task #" + taskNumber + " Thread #" + Thread.currentThread());
        try {
            Thread.sleep(Duration.ofMillis(5000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
//        System.out.println("[" + new Date() + "]" + "Ending Task #" + taskNumber + " Thread #" + Thread.currentThread());

    }

    public static void main(String[] args) throws InterruptedException {
        var virtualThreads = IntStream.rangeClosed(1, 5)
                .mapToObj(taskNumber -> Thread.ofPlatform().unstarted(new Task(taskNumber))).toList();

        virtualThreads.forEach(Thread::start);
        for (Thread t : virtualThreads) {
            t.join();
        }
    }
}