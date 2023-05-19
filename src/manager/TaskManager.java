package manager;

import java.util.List;
import java.util.Set;

import task.Epic;
import task.Task;
import task.Subtask;
import task.Task;

public interface TaskManager{

    List<Task> getHistory();

    void remove(int id);

    List<Task> getAllTasks(Node delNode);

    Task getTask(Integer id);

    void removeAllTasks(List<Task> delNode);

    // Удаление подзадач по ID.
    void removeAllSubtasksId(Integer id);

    // Удаление эпика по ID.
    void removeAllEpicsId(Integer id);

    // Удаление задачи по ID.
    abstract void removeTaskById(Integer id);

    void createTask(Task task);

    void updateTask(Task task);

    List<Subtask> getAllSubtasks();

    Subtask getSubtask(Integer id);

    void removeAllSubtasks();

    void removeSubtaskById(Integer id);

    void createSubtask(Subtask subtask);

    void updateSubtask(Subtask subtask);

    List<Epic> getAllEpics();

    Epic getEpic(Integer id);

    // Удаление всех подзадач.
    void removeAllTasks();

    void removeAllEpics();

    void removeEpicById(Integer id);

    void createEpic(Epic epic);

    void updateEpic(Epic epic);

    List<Subtask> getSubtaskOfEpic(Epic epic);

    Integer generateId();

    Set<Task> getPrioritizedTasks();

    // Удаление всей истории.
    void removeFromHistory();
}