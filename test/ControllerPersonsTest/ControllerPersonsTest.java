package ControllerPersonsTest;

import com.company.Exceptions.IdStatus;
import com.company.controller.ControllerPersons;
import com.company.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ControllerPersonsTest {
    @Test
    public void afisareTest() {
        ControllerPersons controllerPersons = new ControllerPersons();
        controllerPersons.afisare();
    }

    @Test
    public void findById() {
        ControllerPersons controllerPersons = new ControllerPersons();
        assertEquals(38, controllerPersons.findById(8).getVarsta());

    }

    @Test
    public void findByIdTest() {
        ControllerPersons controllerPersons = new ControllerPersons();
        assertEquals(null, controllerPersons.findById(20));

    }

    @Test
    public void addTest() throws IdStatus {
        ControllerPersons controllerPersons = new ControllerPersons();
        controllerPersons.addPersons(new Person(20, "flore", "denis", 12, "5142131"));
        assertEquals(12, controllerPersons.findById(20).getVarsta());
    }

    @Test
    public void addTestThrow() throws IdStatus {
        ControllerPersons controllerPersons = new ControllerPersons();
        assertThrows(IdStatus.class, () -> controllerPersons.addPersons(new Person(2, "flore", "denis", 12, "5142131")));
    }

    @Test
    public void stergereTest() throws IdStatus {
        ControllerPersons controllerPersons = new ControllerPersons();
        controllerPersons.stergerePersoana(6);
        assertEquals(null, controllerPersons.findById(6));
    }

    @Test
    public void stergereTestThrow() throws IdStatus {
        ControllerPersons controllerPersons = new ControllerPersons();
        assertThrows(IdStatus.class, () -> controllerPersons.stergerePersoana(20));
    }

    @Test
    public void updateTest() throws IdStatus {
        ControllerPersons controllerPersons = new ControllerPersons();
        controllerPersons.updatePersoana(8, 25);
        assertEquals(25, controllerPersons.findById(8).getVarsta());
    }

    @Test
    public void updateTestThrow() throws IdStatus {
        ControllerPersons controllerPersons = new ControllerPersons();
        assertThrows(IdStatus.class, () -> controllerPersons.updatePersoana(28, 25));
    }
    @Test
    public void nextIdTest(){
        ControllerPersons controllerPersons=new ControllerPersons();
        assertEquals(9,controllerPersons.nextId());
    }

}