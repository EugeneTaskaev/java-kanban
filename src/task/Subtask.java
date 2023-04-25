package task;
import java.util.Objects;

public class Subtask extends Task {
    protected int epicID;
    public Subtask(String name, String description, Integer id, int epicID) {
        super(name, description, id);
        this.epicID = epicID;
    }
    public Epic getEpicID() {
        return epicID;
        // Подскажите как исправить эту проблему когда меняю Epic выдает ошибку InMemoryTaskManager как исправлю там ошибку выдает ошибку тут или в мейне.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subtask)) return false;
        if (!super.equals(o)) return false;
        Subtask subtask = (Subtask) o;
        return Objects.equals(getEpicID(), subtask.getEpicID());
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getEpicID());
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "epicID=" + epicID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status='" + status + '\'' +
                '}';
    }

    public void setEpicID(Epic epicID) {
        this.epicID = epicID;
    }
}
