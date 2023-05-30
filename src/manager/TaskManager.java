package manager;

import task.Epic;
import task.Subtask;
import task.Task;

import java.util.List;
import java.util.Optional;

public interface TaskManager{

    void printTasks();

    void printEpics();

    void printSubtasks();

    List<Task> getHistory(); //получить историю



    void remove(int id); //удалять

    Task getTaskById(int id);

    int generateId();

    List<Task> getAllTasks(); //получить все задачи


    void removeTaskById(int id);

    void removeEpicById(int id);

    void removeSubtaskById(int id);

    void removeAllTasks(); //удалить все задачи

    Task removeTaskById(Integer id); //удалить задачу по ид

    int createTask(Task task); //создать задачу


    List<Subtask> getAllSubtasksByEpicId(int id);

    void updateTask(Task task); //обновить задачу

    List<Subtask> getAllSubtasks(); //получить все подзадачи

    Optional<Subtask> getSubtask(Integer id);//получить подзадачу

    Subtask getSubtaskById(int id); // получение подзадачи по id

    void removeAllSubtasks(); //удалить все подзадачи

    void removeSubtaskById(Integer id); //удалить подзадачу по ид

    int createSubtask(Subtask subtask); //создать подзадачу

    void updateStatusEpic(Epic epic);

    void updateSubtask(Subtask subtask); //обновить подзадачу

    List<Epic> getAllEpics(); //получить все эпики

    Epic getEpicById(int id); // получение эпика по id

    void removeAllEpics(); //удалить все эпики

    void removeEpicById(Integer id); //удалить эпик по ид

    int createEpic(Epic epic); //создать эпик

    void updateEpic(Epic epic); //обновить эпик

}


