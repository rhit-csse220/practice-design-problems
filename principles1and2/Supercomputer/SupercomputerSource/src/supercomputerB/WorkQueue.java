package supercomputerB;

import java.util.*;

public class WorkQueue {
    private Queue<DataSet> datasets = new LinkedList<>();

    public void updatePriority(String name, int priority) {
        if (name == null) {
            return;
        }
        for (DataSet ds : datasets) {
            if (ds == null) {
                continue;
            }
            Task t = ds.getTask();
            if (t != null && t.name != null && t.name.equals(name)) {
                t.priority = priority;
                break;
            }
        }
    }

    public void submitTask(String name, int priority, String email, Object datasetsObject) {        // Improved: validate and create a Task/DataSet, then enqueue it
        if (name == null || email == null || datasetsObject == null) {
            return;
        }
        if (!(datasetsObject instanceof String)) {
            // This implementation expects the dataset payload to be a String
            return;
        }
        Task task = new Task();
        task.name = name;
        task.priority = priority;
        task.email = email;

        DataSet dataSet = new DataSet((String) datasetsObject, task);
        datasets.add(dataSet);
    }

    public Object findNextDataset() {
        return datasets.peek();
    }

    public void computeEstimateForDataset(Object dataset) {
        if (!(dataset instanceof DataSet)) {
            return;
        }
        DataSet ds = (DataSet) dataset;
        Task t = ds.getTask();
        if (t == null || ds.data == null) {
            return;
        }
        int estimate = Math.max(1, ds.data.length()) * Math.max(1, t.priority);
        System.out.println("[Estimate] Task '" + t.name + "' (priority " + t.priority + ") estimated cost: " + estimate);
    }

    public void processDataset(Object dataset) {
        if (!(dataset instanceof DataSet)) {
            return;
        }
        if (dataset == datasets.peek()) {
            DataSet ds = datasets.poll();
            Task t = (ds != null) ? ds.getTask() : null;
            String taskName = (t != null ? t.name : "<unknown>");
            System.out.println("[Process] Completed processing dataset for task '" + taskName + "'.");
        }
    }
}
