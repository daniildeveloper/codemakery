
package codemakery.adress.model;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Person
 *
 * @author Lama
 */
public class Person {
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty street;
    private IntegerProperty postalCode;
    private StringProperty city;
    
    /**
     * ObjectProperty Type LocalDate is part of new Date and Time API from JDK8
     */
    private ObjectProperty<LocalDate> birthday;
    
    /**
     * Default constructor
     */
    public Person(){
        this(null, null);
    }
    
    /**
     * Constructor with some initialize Data
     * @param firstName имя человека
     * @param lastName фамилия человека
     */
    
    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        // Some initial dummy data, just for convenient testing.
        this.street = new SimpleStringProperty("some street");
        this.postalCode = new SimpleIntegerProperty(1234);
        this.city = new SimpleStringProperty("some city");
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
    }

    /**
     * @return the firstName
     */
    public StringProperty getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(StringProperty firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public StringProperty getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(StringProperty lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the street
     */
    public StringProperty getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(StringProperty street) {
        this.street = street;
    }

    /**
     * @return the postalCode
     */
    public IntegerProperty getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(IntegerProperty postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the city
     */
    public StringProperty getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(StringProperty city) {
        this.city = city;
    }

    /**
     * @return the birthday
     */
    public ObjectProperty<LocalDate> getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(ObjectProperty<LocalDate> birthday) {
        this.birthday = birthday;
    }

}
