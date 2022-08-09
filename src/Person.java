/*Mary Czelusniak
    Advanced Java
 */
public class Person {
    private String firstName;
    private String lastName;
    private OCCCDate dob;


    public Person(String firstName, String lastName, OCCCDate dob){
        this.firstName = firstName;
        this.lastName  = lastName;

        this.dob = new OCCCDate(dob);
        this.dob.setDayName(OCCCDate.HIDE_DAY_NAME);
    }

    // copy constructor
    public Person(Person p){
        firstName = p.firstName;
        lastName  = p.lastName;
        dob = new OCCCDate(p.getDOB());
        dob.setDayName(OCCCDate.HIDE_DAY_NAME);
    }
//getter and setter
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }


    public OCCCDate getDOB(){
        return dob;
    }

    public int getAge(){
        return dob.getDifferenceInYears(dob);
    }


    public boolean equals(Person p){

        return  firstName.equalsIgnoreCase(p.firstName) &&
                lastName.equalsIgnoreCase(p.lastName) && dob.equals(p.getDOB());
    }


    @Override
    public String toString(){

        return lastName + ", " + firstName + "  ( " + dob.toString() + " )" ;
    }
//eat, sleep, play, run, only showing first name for clarity
    public void eat(){
        System.out.println( getClass().getName() + " "
                + getFirstName() + " is eating!" );
    }
    public void sleep(){
        System.out.println( getClass().getName() + " "
                + getFirstName() + " is in a coma!" );
    }
    public void play(){
        System.out.println( getClass().getName() + " "
                + getFirstName() + " is playing Elden Ring!" );
    }
    public void run(){
        System.out.println( getClass().getName() + " "
                + getFirstName() + " is running!" );
    }



}
