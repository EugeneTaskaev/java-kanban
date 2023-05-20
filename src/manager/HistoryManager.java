package manager;

import java.util.List;
import java.util.Optional;
import task.Task;

public interface HistoryManager {

    void add(Optional<? extends Task> optionalTask);

    void add(Task task);

    void remove(int id);

    void removeAll();

    List<Task> getHistory();

}
