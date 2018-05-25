
package javaapplication5;

/**
 *
 * @author martin
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Person person1= new Person("Peter", 1990);
        
        // Achtung, wie bei Arrays ist das keine echte Kopie, sondern nur eine weitere Referenzauf die selbe Speicheradresse
        Person person2=person1;
        person2.setName("Hans");
        
        Person person3=new Person("Paula", 1996);
        System.out.println(person1.getName());
        System.out.println(person1.alter());
        System.out.println(Person.getCount());
    }
    
}
