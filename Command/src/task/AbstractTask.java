package task;

public abstract class AbstractTask implements Runnable {

    // abstract?
    public String[] args;

//    public AbstractTask(String... args) {
//        this.args = args;
//    }

    @Override
    public abstract void run();

}
