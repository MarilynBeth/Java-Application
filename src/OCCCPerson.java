/*Mary Czelusniak
    Advanced Java
 */
public class OCCCPerson extends RegisteredPerson {
    private String studentID;
    public OCCCPerson(RegisteredPerson p, String studentID){
        super(p);
        this.studentID = studentID;
    }
    //copy constructor
    public OCCCPerson(OCCCPerson p){
        super(p);
        studentID = p.studentID;
    }
    //TODO:ALL SHARED VALUES
    public boolean equals(OCCCPerson p) {
        return studentID.equalsIgnoreCase(p.studentID) && super.equals(p);
    }
    public boolean equals(RegisteredPerson p) {
        return super.equals(p);
    }


    public boolean equals(Person p) {
        return super.equals(p);
    }

    @Override
    public String toString(){
        return super.toString() + " [" + studentID + "]";
    }

}
