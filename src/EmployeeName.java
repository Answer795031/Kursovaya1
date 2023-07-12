public class EmployeeName{

    private String name;
    private String surname;
    private String patron;


    public EmployeeName(String surname, String name, String patron){

        this.name = name;
        this.patron = patron;
        this.surname = surname;

    }

    public String toString(){

        return getSurname() + " " + getName() + " " + getPatron();
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPatron(){
        return this.patron;
    }

    public void setPatron(String patron){
        this.patron = patron;
    }

    public String getSurname(){
        return this.surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

}