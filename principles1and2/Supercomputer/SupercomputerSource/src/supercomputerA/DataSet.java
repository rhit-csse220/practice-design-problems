package SupercomputerSource.src.supercomputerA;

public class DataSet {
    //Can only store one task with each dataset resulting in duplicate tasks
    String taskName;
    int taskPriority;
    String taskEmail;
    Object data;

    void computeEstimate() {
        System.out.println("Estimate for " + taskName + ": " + taskPriority);
    }

    void processDataset() {
        System.out.println("Processing " + data);
    }
}
