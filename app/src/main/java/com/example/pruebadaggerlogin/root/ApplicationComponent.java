package com.example.pruebadaggerlogin.root;


import com.example.pruebadaggerlogin.login.LoginActivity;
import com.example.pruebadaggerlogin.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

/**Determina las dependencias que se van a injectar (Actividades, servicios, fragmentos..)*/
/**Se utiliza para asignar referencias a Actividades, servicios, fragmentos..*/

/**Se indica el modulo del cual depende el componente*/
@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {

    //Método de inyección
    void inject(LoginActivity target);
}
