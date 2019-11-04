package javaConcurrencePractice.ch5;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 通过CyclicBarrier协调细胞自动衍生系统中的计算
 */
public class CellularAutomata {
    private final Board mainBoard;
    private final CyclicBarrier barrier;
    private final Worker[] workers;

    public CellularAutomata(Board board) {
        this.mainBoard = board;
        int count = Runtime.getRuntime().availableProcessors();
        this.barrier = new CyclicBarrier(count, mainBoard::commitNewValues);
        this.workers = new Worker[count];
        for (int i = 0; i < count; i++) {
            workers[i] = new Worker(mainBoard.getSubBoard(count, i));
        }
    }

    private class Board {
        boolean hashConverged() {
            return true;
        }

        int getMaxX() {
            return 100;
        }

        int getMaxY() {
            return 100;
        }

        void setNewValue(int x, int y, int newValue) {

        }

        void commitNewValues() {

        }

        Board getSubBoard(int count, int index) {
            return null;
        }

        void wairForConvergence() {}
    }

    private class Worker implements Runnable {
        private final Board board;

        Worker(Board board) {
            this.board = board;
        }

        @Override
        public void run() {
            while (!board.hashConverged()) {
                for (int x = 0; x < board.getMaxX(); x++) {
                    for (int y = 0; y < board.getMaxY(); y++) {
                        board.setNewValue(x, y, computeValue(x, y));
                    }
                }
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    return;
                }
            }
        }

        int computeValue(int x, int y) {
            return 0;
        }
    }

    public void start() {
        for (Worker worker : workers) {
            new Thread(worker).start();
            mainBoard.wairForConvergence();
        }
    }
}
