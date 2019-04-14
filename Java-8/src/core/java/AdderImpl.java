package core.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;

public class AdderImpl implements Adder {
	 
    @Override
    public  String add(Function<String, String> f) {
        return f.apply("Welcome ");
    }
 
    @Override
    public void add(Consumer<Integer> f) {}
    
    public static void main(String[] args) {
    	AdderImpl a= new AdderImpl();
    	System.out.println(a.add(ab -> ab +"lambda"));
    	DateTimeFormatter formatter=DateTimeFormatter.ofPattern("EEEE",Locale.US);
        System.out.println(formatter.format(LocalDateTime.now()));
        
        DateTimeFormatter dateFormat=DateTimeFormatter.ISO_DATE;
        LocalDate dateOfBirth= LocalDate.of(2015,Month.FEBRUARY,31);
        System.out.println(dateFormat.format(dateOfBirth));
    }
}
