
package service;

import task.Epic;
import task.Subtask;
import task.Task;
import task.TaskStatus;

import java.util.List;

public interface TaskManager {

    List<Epic> getAllEpic();

    void clearEpic();

    Epic getEpicById(Long id);

    Epic addEpic(Epic epic);

    void updateEpic(Epic epic);

    Epic removeEpicById(Long id);

    List<Subtask> getAllSubTask();

    void clearSubtask();

    Subtask getSubTaskById(Long id);

    Subtask addSubTask(Subtask subTask);

    Subtask removeSubTaskById(Long id);

    Subtask updateSubTask(Subtask subTask);

    List<Task> getAllTask();

    void clearTask();

    Task getTaskById(Long id);

    void updateStatusEpic(Epic epic, TaskStatus taskStatus);

    Task addTask(Task task);

    Task removeTaskById(Long id);

    void updateTask(Task task);

    List<Subtask> getAllSubtaskByEpic(Epic epic);
}