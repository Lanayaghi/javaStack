//Create a Project class that has the fields of name and description.
public class Project{    
    private String name;
    private String description;

     //Create an instance method called elevatorPitch that will return the name and description separated by a colon.
    public String elevatorPitch(){
    return this.name + this.description;
    }
    
    // Overload the constructor method in three different ways.
    public Project() {}

    public Project(String name) {
        this.name= name;
    }
    
    public Project(String name, String description) {
        this.name= name;
        this.description= description;
    }

    // Create getter and setters for each field
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name= name;
    }

    public String getDesc(){
        return this.description;
    }
    public void setDesc(String description){
        this.description= description;
    }


}