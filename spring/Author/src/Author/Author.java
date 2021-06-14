package Author;

public class Author implements Comparable<Author> {
	protected  String first_name;
	protected String last_name;
	protected String book_name;
	
public Author(String first_name, String last_name, String book_name){
	this.first_name = first_name;
	this.last_name = last_name;
	this.book_name = book_name;
}

@Override
public int compareTo(Author o) {
	if(this.first_name== o.first_name)  
		return 0;  
   else if( first_name.compareTo (o.first_name)< 0) 
		return -1;
   else  
		return 1; 
	
}






}
