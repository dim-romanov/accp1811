package ru.sstu.lessons.lesson12.ui;

public class View {
    public UserView userView = new UserView();

    public void view() {
        while (true) {

//read command
            userView.showUsers();
        }
    }

    public static void main(String[] args) {
        new View().view();
    }


}
