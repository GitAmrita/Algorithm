package ObjectOrientedDesign;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by amritachowdhury on 6/22/17.
 */
public class coding_7_2 {

    public enum Rank {
        RESPONDER, MANAGER, DIRECTOR
    }

    public class Caller {
        private String name;
        private String phoneNumber;
    }

    public abstract class Employee {

        private Calls currentCall = null;
        protected Rank rank;

        public Employee() {}

        public Employee (CallHandler handler) {}

        public void receiveCall(Calls call) {}
        public void callCompleted() {}
        public void escalateAndReassign() {}
        public boolean assignNewCall() {return true;}
        public boolean isFree() {return currentCall == null;}
        public Rank getRank() {return this.rank;}
    }

    public class Responder extends Employee {
        public Responder() {
            super.rank = Rank.RESPONDER;
        }
    }

    public class Manager extends Employee {
        public Manager() {
            super.rank = Rank.MANAGER;
        }
    }

    public class Director extends Employee {
        public Director() {
            super.rank = Rank.DIRECTOR;
        }
    }

    public class Calls {
        private Rank rank;
        private Caller caller;
        private Employee handler;

        public Calls(Caller c) {
            this.rank = Rank.RESPONDER;
            this.caller = c;
        }

        public void setHandler(Employee e) {
            this.handler = e;
        }

        public void reply(String message) {}
        public Rank getRank() {return this.rank;}
        public int getValue() {
            if (this.rank == Rank.RESPONDER) {
                return 0;
            } else if (this.rank == Rank.MANAGER) {
                return 1;
            } else {
                return 2;
            }
        }
        public void setRank(Rank r) { this.rank = r;}
        public Rank incrementRank() {
            return this.rank == Rank.RESPONDER ? Rank.MANAGER : Rank.DIRECTOR;
        }
        public void disconnect() {}
    }

    public class CallHandler {

        private final int LEVELS = 3;

        private final int NUM_RESPONDENTS = 10;
        private final int NUM_MANAGERS = 4;
        private final int NUM_DIRECTORS = 2;

        public List<List<Employee>> employeeLevels;
        private List<Employee> responders = new LinkedList<>();
        private List<Employee> managers = new LinkedList<>();
        private List<Employee> directors = new LinkedList<>();

        public List<List<Calls>> callQueue;

        public CallHandler() {
            employeeLevels = new LinkedList<>();
            callQueue = new LinkedList<>();
            employeeLevels.add(responders);
            employeeLevels.add(managers);
            employeeLevels.add(directors);
        }

        public Employee getHandlerForCall(Calls call) {
            return responders.get(0); //check here which employee is available
        }

        public void dispatchCall(Caller caller) {
            Calls call = new Calls(caller);
            dispatchCall(call);
        }

        public void dispatchCall(Calls call) {
            Employee emp = getHandlerForCall(call);
            if (emp != null) {
                emp.receiveCall(call);
                call.setHandler(emp);
            } else {
                call.reply("please wait for a free caller");
                callQueue.get(call.getValue()).add(call);
            }
        }
    }
}
