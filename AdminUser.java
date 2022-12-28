
import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser,HIPAACompliantAdmin {

    public AdminUser(int i) {
        super();
    }

    @Override
    public ArrayList<String> reportSecurityIncidents() {
        return securityIncidents;
    }

    @Override
    public boolean assignPin(int pin) {
        if (pin > 100000){
            this.pin = pin;
            return true;
        }
        return false;
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        if (confirmedAuthID == id){
            return true;
        }
        authIncident();
        return false;
    }
    //... imports class definition...

    // Inside class:
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();

    // TO DO: Implement a constructor that takes an ID and a role

    public AdminUser(Integer id) {
        this.id = id;
    }

    public AdminUser(String role) {
        this.role = role;
    }

    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!

    public void newIncident(String notes) {
        String report = String.format(
                "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n",
                new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
                "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n",
                new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

    // TO DO: Setters & Getters


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<String> getSecurityIncidents() {
        return securityIncidents;
    }

    public void setSecurityIncidents(ArrayList<String> securityIncidents) {
        this.securityIncidents = securityIncidents;
    }
}

