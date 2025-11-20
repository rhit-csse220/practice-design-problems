package SupercomputerSource.src.supercomputerB;

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
        System.out.println("=== Demonstrating WorkQueue doing everything (design flaw) ===");
        WorkQueue q = new WorkQueue();

        System.out.println("[1] Submitting task to WorkQueue");
        q.submitTask("dataset-42", 9, "owner@example.com", new Object());

        System.out.println("[2] Asking WorkQueue for the next dataset");
        Object ds = q.findNextDataset();
        System.out.println("    -> WorkQueue returned: " + ds);

        if (ds instanceof DataSet) {
            Task t = ((DataSet) ds).getTask();
            System.out.println("[3] Directly peeking into DataSet -> Task and updating via WorkQueue (message chain)");
            System.out.println("    -> Task name: " + t.name + ", old priority: " + t.priority);
            q.updatePriority(t.name, 10);
        } else {
            System.out.println("[3] Skipping priority update; dataset was not a DataSet instance");
        }

        System.out.println("[4] Requesting estimate from WorkQueue");
        q.computeEstimateForDataset(ds);

        System.out.println("[5] Telling WorkQueue to process the dataset");
        q.processDataset(ds);

        System.out.println("=== Done (note how WorkQueue handled submission, selection, estimation, processing) ===");
    }
}
