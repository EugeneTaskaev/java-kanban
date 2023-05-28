package manager;

import java.util.List;

import task.Epic;
import task.Subtask;
import task.Task;

public interface TaskManager{

    List<Task> getHistory();

    void remove(int id);

    List<Task> getAllTasks();

    Task getTask(Integer id);

    void removeAllTasks();

    void removeTaskById(Integer id);

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

    void removeAllEpics();

    void removeEpicById(Integer id);

    void createEpic(Epic epic);

    void updateEpic(Epic epic);

    List<Subtask> getSubtaskOfEpic(Epic epic);

    Integer generateId();

}