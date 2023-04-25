package utility;

import service.HistoryManager;
import service.InMemoryHistoryManager;
import service.InMemoryTaskManager;
import service.TaskManager;

public class UtilityManagers {

    public static TaskManager getManager(){
        return new InMemoryTaskManager();
    }

    public static HistoryManager getHistoryManager(){
        return new InMemoryHistoryManager();
    }
}