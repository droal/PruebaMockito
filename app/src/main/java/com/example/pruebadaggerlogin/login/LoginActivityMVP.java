package com.example.pruebadaggerlogin.login;

public interface LoginActivityMVP {


    interface View{
        String getFirstName();
        String getLastName();

        void showUserNotAvailable();
        void showInputError();
        void showUserSaved();

        void setFirstName(String firstNAme);
        void setLastName(String lastName);
    }

    interface Presenter{
        void setView(LoginActivityMVP.View view);
        void loginButtonClicked();
        void getCurrentUser();
    }

    interface Model{
        void createUser(String firstName, String lastName);

        UserPojo getUser();
    }
}
