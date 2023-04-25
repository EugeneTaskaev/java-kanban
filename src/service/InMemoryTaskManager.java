package service;

import task.Epic;
import task.Subtask;
import task.Task;
import task.TaskStatus;
import utility.UtilityManagers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class InMemoryTaskManager implements TaskManager {

    private Long taskMaxId = 0L;
    private final Map<Long, Epic> epics = new HashMap<>(); // Создаю мап для эпиков: ключ(id), значение(эпик)
    private final Map<Long, Task> tasks = new HashMap<>();
    private final Map<Long, Subtask> subTasks = new HashMap<>();
    private final LinkedList<Task> history = new LinkedList<>();
    private HistoryManager historyManager = UtilityManagers.getHistoryManager();

    @Override
    public List<Epic> getAllEpic() {
        return (List<Epic>) epics.values();
    }

    @Override
    public void clearEpic() {
        clearSubtask();
        epics.clear();
    }

    @Override
    public Epic getEpicById(Long id) {
        Epic epic = epics.get(id);
        historyManager.addHistory(epic);
        return epic;
    }

    @Override
    public Epic addEpic(Epic epic) {
        epic.setId(taskMaxId++);
        if (epic != null && !epics.containsKey(epic.getId())) {
            epics.put(epic.getId(), epic);
        }
        return epic;
    }

    @Override
    public void updateEpic(Epic epic) {
        if (epics.containsKey(epic.getId())) { // проверят наличие эпика в мапе и если он есть, обноваляет его
            epics.put(epic.getId(), epic);
        }
    }

    @Override
    public Epic removeEpicById(Long id) {
        for (Subtask subTask : epics.get(id).getSubTasks()) {
            subTasks.remove(subTask.getId());
        }
        return epics.remove(id);
    }

    @Override
    public List<Subtask> getAllSubTask() {
        return (List<Subtask>) subTasks.values();
    }

    @Override
    public void clearSubtask() {
        for (Epic epic : epics.values()) {
            epic.getSubTasks().clear();
            epic.setStatus(String.valueOf(TaskStatus.NEW));
        }
        subTasks.clear();
    }

    @Override
    public Subtask getSubTaskById(Long id) {
        Subtask subtask = subTasks.get(id);
        historyManager.addHistory(subtask);
        return subtask;
    }

    @Override
    public Subtask addSubTask(Subtask subTask) {
        subTask.setId(taskMaxId++);//добавлению новый сабтаск в мапу и возвращаю добавленный сабтаск
        if (subTask != null && !subTasks.containsKey(subTask.getId())) {
            subTasks.put(subTask.getId(), subTask);
        }
        return subTask;
    }
// Подскажите как исправить даную ошибку!
    @Override
    public Subtask removeSubTaskById(Long id) {
        Subtask subTask = subTasks.get(id);
        int epic = subTask.getEpicID();
        if (epic.getSubTasks().size() == 1) {
            epic.setStatus(String.valueOf(TaskStatus.DONE)); //если закончились сабтаски, значит эпик готов
        }
        epic.getSubTasks().remove(subTask);
        return subTasks.remove(id);
    }

    @Override
    public Subtask updateSubTask(Subtask subTask) {
        int epic = subTask.getEpicID();
        boolean isDone = false;
        for (Subtask subTask1 : epic.getSubTasks())
            if (!subTask1.getStatus().equals(TaskStatus.DONE)) {
                isDone = true;
                break;
            }
        if (!isDone && subTask.getStatus().equals(TaskStatus.DONE)) {
            updateStatusEpic(epic, TaskStatus.DONE);
        }
        return subTasks.put(subTask.getId(), subTask);
    }

    @Override
    public List<Task> getAllTask() {
        return (List<Task>) tasks.values();
    }

    @Override
    public void clearTask() {
        tasks.clear();
    }

    @Override
    public Task getTaskById(Long id) {
        Task task = tasks.get(id);
        historyManager.addHistory(task);
        return task;
    }

    @Override
    public void updateStatusEpic(Epic epic, TaskStatus taskStatus) {
        epic.setStatus(String.valueOf(taskStatus));
    }

    @Override
    public Task addTask(Task task) {
        task.setId(taskMaxId++);//добавлению новый таск в мапу и возвращаю добавленный сабтаск
        if (task != null && !tasks.containsKey(task.getId())) {
            tasks.put(task.getId(), task);
        }
        return task;
    }

    @Override
    public Task removeTaskById(Long id) {
        return tasks.remove(id);
    }

    @Override
    public void updateTask(Task task) {
        if (tasks.containsKey(task.getId())) {
            tasks.put(task.getId(), task);
        }
    }

    @Override
    public List<Subtask> getAllSubtaskByEpic(Epic epic) {
        return epic.getSubTasks();
    }
}