package is.hi.hbv202g.assignment8;

/**
 * Class that represents a student user.
 * <p>
 * This class is to create a student user. </p>
 */

public class Student extends User{
    private boolean feePaid;

    public Student(String name, boolean feePaid){
        super(name);
        this.feePaid = feePaid;
    }

    /**
     * Returns if the fee has been paid.
     *
     * @return true if the fee has been paid or false if not
     */
    public boolean isFeePaid(){
        return this.feePaid;
    }

    /**
     * Sets if the fee has been paid.
     *
     * @param feePaid true if the fee has been paid and false if not
     */
    public void setFeePaid(boolean feePaid){
        this.feePaid = feePaid;
    }
}
