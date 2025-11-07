package SupercomputerB;

public class DataSet {
    public Object data;
    private Task task;

    public DataSet(Object data, Task task) {
        this.data = data;
        this.task = task;
    }

    public Task getTask() {
        return task;
    }
}
