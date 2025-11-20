package supercomputerB;

public class SupercomputerMain {
    private static final WorkQueue workQueue = new WorkQueue();

    public void handleProcessNextDataset() {
        Object ds = workQueue.findNextDataset();            // message chain / raw Object
        workQueue.computeEstimateForDataset(ds);            // no type checks
        workQueue.processDataset(ds);                       // void processing
    }

    public void handleSubmitTask(String name, int priority, String email, Object datasets) {
        workQueue.submitTask(name, priority, email, datasets); // forwards everything
    }

    public void handleUpdatePriority(String name, int priority) {
        workQueue.updatePriority(name, priority);           // blind delegation
    }

    public static void main(String[] args) {
        SupercomputerMain controller = new SupercomputerMain();

        // WorkQueue builds Task and DataSet and stores them; controller just forwards parameters.
        controller.handleSubmitTask("dataset-42", 5, "owner@example.com", "raw data for dataset-42");

        // Controller receives a raw Object from WorkQueue, then has to know about DataSet and Task
        // to look inside them (message chain, WorkQueue owns selection and structure).
        Object ds = workQueue.findNextDataset();

        // WorkQueue also owns estimation and processing logic; controller simply delegates.
        controller.handleProcessNextDataset();

        // DataSet itself still has almost no behavior: it mainly holds data and a Task reference.
        // Most of the real work (submission, selection, estimation, processing) lives in WorkQueue.
    }
}
