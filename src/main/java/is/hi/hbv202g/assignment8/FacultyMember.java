package is.hi.hbv202g.assignment8;

/**
 * Class that represents a faculty member user.
 * <p>
 * This class is to create a faculty member and it also sets and gets the department. </p>
 */
public class FacultyMember extends User {
    private String department;
    public FacultyMember(String name, String department){
        super(name);
        this.department = department;
    }

    /**
     * Get the department.
     *
     * @return the department
     */
    public String getDepartment(){
        return department;
    }

    /**
     * Set the department.
     *
     * @param department the department
     */
    public void setDepartment(String department){
        this.department = department;
    }
}
