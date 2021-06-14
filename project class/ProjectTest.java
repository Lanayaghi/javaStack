public class ProjectTest{
    public static void main(String[] args) {
        Project one = new Project("this is a project name', 'this a project description");
        System.out.println( one );
    
    Project two = new Project();
    two.setName("AXSOS");
    two.setDesc("private sector");
    System.out.println(two.elevatorPitch());
}
}