package manager;

import task.Epic;
import task.StatusTrecker;
import task.Subtask;
import java.util.ArrayList;
import java.util.HashMap;



public class SubtaskManager {
    protected Integer counterIDSubTasks = 0;
    protected HashMap<Integer, Subtask> subTasks = new HashMap<>();
    protected EpicManager epicManager;

    public SubtaskManager(EpicManager epicManager) {
        this.epicManager = epicManager;
    }

    // Получение списка всех подзадач определённого эпика.
    public ArrayList<Subtask> findAllOfEpic(Epic epic) {
        return epicManager.epics.get(epic.getId()).getSubTasks();
    }

    // Удаление всех задач.
    public void deleteAll() {
        subTasks.clear();
    }

    // Получить подзадачу по ID

    public Subtask findById(Integer id) {
        return subTasks.get(id);
    }
    // Обновление подзадачи по ID
    public Subtask updateSubTask(Subtask task) {
        final Subtask originalTask = subTasks.get(task.getId());
        if (originalTask == null) {
            System.out.println("Задачи с таким ID не существует.");
            return null;
        }
        originalTask.setDescription(task.getDescription());
        originalTask.setName(task.getName());
        originalTask.setStatus(task.getStatus());
        epicManager.epics.get(task.getEpicID()).getSubTasks().remove(originalTask);
        epicManager.epics.get(task.getEpicID()).getSubTasks().add(task);
        refreshStatus(task);
        return originalTask;
    }

    // Создать подзадачу.
    public Subtask create(Subtask subtask, Epic epic) {
        final Subtask newSubTask = new Subtask(subtask.getName(), subtask.getDescription(), ++counterIDSubTasks, epic.getId());
        if (!subTasks.containsKey(newSubTask.getId())) {
            subTasks.put(newSubTask.getId(), newSubTask);
            epicManager.epics.get(epic.getId()).getSubTasks().add(/*newSubTask.getId(),*/ newSubTask);
        } else {
            System.out.println("Задача с таким ID уже существует");
            return null;
        }
        return newSubTask;
    }

    // Обновление статуса эпика в зависимости от статуса подзадач
    public void refreshStatus(Subtask task) {
        ArrayList<Subtask> subTasksOfEpic = epicManager.epics.get(task.getEpicID()).getSubTasks();
        int counterNew = 0;
        int counterDone = 0;
        for (Subtask subtask : subTasksOfEpic) {
            if (subtask.getStatus().equals(StatusTrecker.NEW)) {
                counterNew++;
            } else if (subtask.getStatus().equals(StatusTrecker.DONE)) {
                counterDone++;
            }
        }
        if (counterNew == subTasksOfEpic.size()) {
            epicManager.epics.get(task.getEpicID()).setStatus(StatusTrecker.NEW);
        } else if (counterDone == subTasksOfEpic.size()) {
            epicManager.epics.get(task.getEpicID()).setStatus(StatusTrecker.DONE);
        } else {
            epicManager.epics.get(task.getEpicID()).setStatus(StatusTrecker.IN_PROGRESS);
        }
    }

    // Удаление задачи по идентификатору.
    public Subtask deleteById(Integer id) {
        final Subtask deletedTask = subTasks.get(id);
        epicManager.epics.get(deletedTask.getEpicID()).getSubTasks().remove(deletedTask);
        subTasks.remove(id);
        return deletedTask;
    }
}