package com.company;

import com.company.SubForos.ManagerSubForosTest;
import com.company.SubForos.SubForoTest;
import com.company.Users.ManagerUsuarioTest;
import com.company.Users.UsuarioTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        ManagerSubForosTest.class,
        UsuarioTest.class,
        ManagerUsuarioTest.class,
        SubForoTest.class,
        EntradaAbstractaTest.class
})
public class AllTest {
}
