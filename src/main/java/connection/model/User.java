package connection.model;

public class User {

    private Long id;
    private String fName;
    private String lName;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getfName(){
        return fName;
    }

    public void setfName(String fName){
        this.fName = fName;
    }

    public String getlName(){
        return lName;
    }

    public void setlName(String lName){
        this.lName = lName;
    }

    public User(){

    }

    public User(Long id, String fName, String lName){
        this.id=id;
        this.fName=fName;
        this.lName=lName;
    }

}
