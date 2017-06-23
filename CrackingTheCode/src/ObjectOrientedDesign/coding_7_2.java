package ObjectOrientedDesign;

import java.util.List;

/**
 * Created by amritachowdhury on 6/22/17.
 */
public class coding_7_2 {

    public abstract class Employee {
        private String name;
        private int id;
        private String address;
        private String phone;
    }

    private class Respondent extends Employee {
        private Manager boss;
    }
    private class Manager extends Employee {
        private List<Respondent> subordinates;
        private Director boss;
    }
    private class Director extends Employee {
        private List<Manager> subordinates;
    }
}
