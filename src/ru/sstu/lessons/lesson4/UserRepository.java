package ru.sstu.lessons.lesson4;

/**
 * бд для пользователей
 */
public class UserRepository {
    private static User[] users = new User[100];//статический массив пользователй
    private static int count;//количество пользователей

    /**
     * Заполнение массива пользователями
     */
    static {
        users[count] = new User("Ivan", 35, 3000);
        users[count].addDocument(DocumentRepository.getDocumentByInd(0));
        count++;

        users[count] = new User("Vasya", 19, 3000);
        users[count].addDocument(DocumentRepository.getDocumentByInd(0));
        count++;

        users[count] = new User("Petr", 34, 3000);
        users[count].addDocument(DocumentRepository.getDocumentByInd(1));
        count++;

        users[count] = new User("Pasha", 25, 3000);
        users[count].addDocument(DocumentRepository.getDocumentByInd(1));
        count++;
    }

    /**
     * добавление нового пользователя в бд
     * @param u
     */
    static void add(User u) {
        users[count] = u;
        count++;
    }

    /**
     * поиск пользователя по его номеру
     * @param ind
     * @return
     */
    static User getUserByInd(int ind) {
        return users[ind];
    }

    /**
     * получение всех пользователей БД
     * @return
     */
    static User[] getUsers() {
        User[] users1 = new User[count];
        for (int i = 0; i < count; i++) {
            users1[i] = users[i];
        }
        return users1;
    }

    /**
     * Получение молодых пользователей
     * @return
     */
    static User[] getUserMolod() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (users[i].getAge() > 18 && users[i].getAge() < 35) {
                c++;
            }
        }
        if (c == 0) return null;
        User[] m = new User[c];
        for (int i = 0, j = 0; i < count; i++) {
            if (users[i].getAge() > 18 && users[i].getAge() < 35) {
                m[j] = users[i];
                j++;
            }
        }
        return m;
    }

    /**
     * Уделение пользователя по его номеру
     * @param ind
     */
    static void remove(int ind) {
        for (int i = ind; i < count - 1; i++) {
            users[i] = users[i + 1];
        }
        count--;
    }


}
