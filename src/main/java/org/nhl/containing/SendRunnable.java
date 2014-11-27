package org.nhl.containing;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 */
public class SendRunnable implements Runnable {
    PrintWriter out;
    ConcurrentLinkedQueue<String> queue;

    private boolean running;

    public SendRunnable(PrintWriter out) {
        this.out = out;
        this.queue = new ConcurrentLinkedQueue<String>();
    }

    @Override
    public void run() {
        String outputLine;
        running = true;

        while (running) {
            outputLine = queue.poll();
            if (outputLine == null) {
                try {
                    Thread.sleep(500);
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            } else {
                // Send outputLine to client
                out.write(outputLine);
                System.out.println("Sent " + outputLine);
            }
        }
    }

    public void stop() {
        running = false;
    }

    public void writeMessage(String message) {
        queue.add(message);
    }
}
