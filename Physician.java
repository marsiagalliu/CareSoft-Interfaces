
import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {

    @Override
    public boolean assignPin(int pin) {
        if (pin > 1000 && pin < 9999){
            this.pin = pin;
            return  true;
        }
        return false;
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        if (confirmedAuthID == id){
            return true;
        }
        return false;
    }
    //... imports class definition...

    // Inside class:
    private ArrayList<String> patientNotes;

    public Physician(Integer id) {
        this.id = id;
    }

    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
                "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    // TO DO: Setters & Getters


    public ArrayList<String> getPatientNotes() {
        return patientNotes;
    }

    public void setPatientNotes(ArrayList<String> patientNotes) {
        this.patientNotes = patientNotes;
    }
}
