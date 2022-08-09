/*Mary Czelusniak
    Advanced Java
 */
public class RegisteredPerson extends Person {
    private String govID;

    public RegisteredPerson(String firstName, String lastName, OCCCDate dob, String govID){

        super(firstName, lastName, dob);
        this.govID = govID;
    }
    public RegisteredPerson(Person p, String govID){
        super(p);
        this.govID = govID;
    }

    @Override
    public String toString(){
        return super.toString() + " [" + govID + "]";
    }


    public RegisteredPerson(RegisteredPerson p){
        super(p);
        govID = p.govID;

    }
    //TODO: as per intruction, compare all shared values from
    // Person and RegisteredPerson
    public boolean equals(RegisteredPerson p){
        return govID.equalsIgnoreCase(p.govID) && super.equals(p);
    }
    public boolean equals(Person p){
        return super.equals(p);
    }

    public String getGovID(){
        return govID;
    }

}
