
package WorkAreas;

import Persona.Person;

public class WorkRequest {
    private String task;
    private Person performer;
    private Person originator;
    private String status;
    
    
    public WorkRequest(Person org, Person per, String t){
        performer = per;
        originator = org;
        task = t;
        status = "Pending";
    }
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Person getPerformer() {
        return performer;
    }

    public void setPerformer(Person performer) {
        this.performer = performer;
    }

    public Person getOriginator() {
        return originator;
    }

    public void setOriginator(Person originator) {
        this.originator = originator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

