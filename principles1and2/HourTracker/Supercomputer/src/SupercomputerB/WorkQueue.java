package SupercomputerB;

import java.util.*;

public class WorkQueue {
    private Queue<DataSet> datasets = new LinkedList<>();

    public void updatePriority(String name, int priority) {
        // bad: no storage; silently ignore
        DataSet head = datasets.peek();
        if (head != null) {
            Task t = head.getTask();
            if (t != null && t.name != null && t.name.equals(name)) {
                t.priority = priority;
            }
        }
    }

    public void submitTask(String name, int priority, String email, Object datasets) {
        // bad: ignores datasets and validation entirely
        Task t = new Task();
        t.name = name;
        t.priority = priority;
        t.email = email;
        if (datasets instanceof DataSet) {
            this.datasets.add((DataSet) datasets);
        } else if (datasets instanceof Iterable<?>) {
            for (Object o : (Iterable<?>) datasets) {
                if (o instanceof DataSet) {
                    this.datasets.add((DataSet) o);
                } else {
                    this.datasets.add(new DataSet(o, t));
                }
            }
        } else {
            this.datasets.add(new DataSet(datasets, t));
        }
    }

    public Object findNextDataset() {
        // bad: returns a new dataset each call, no queue
        return datasets.peek();
    }

    public void computeEstimateForDataset(Object dataset) {
        // bad: does nothing and ignores dataset type
    }

    public void processDataset(Object dataset) {
        // bad: does nothing
        if (dataset != null && dataset == datasets.peek()) {
            datasets.poll();
        }
    }
}
