package manager;

/**
 * Утилитарный класс управления.
 */
public final class Managers {
        public static TaskManager getInMemoryTaskManager(HistoryManager historyManager) {
            return new InMemoryTaskManager(historyManager);
        }

        public static HistoryManager getDefaultHistory() {
            return new InMemoryHistoryManager();
        }
    }