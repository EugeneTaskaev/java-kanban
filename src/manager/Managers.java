package manager;

import task.Task;

import java.util.Set;

/**
 * Утилитарный класс управления.
 */
public class Managers {

    public static TaskManager getInMemoryTaskManager(HistoryManager defaultHistory) {
        return new InMemoryTaskManager() {
            @Override
            public void removeAllTasks() {

            }

            @Override
            public Set<Task> getPrioritizedTasks() {
                return null;
            }
        };
    }

    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }

}