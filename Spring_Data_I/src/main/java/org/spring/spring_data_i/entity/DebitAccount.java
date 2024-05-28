package org.spring.spring_data_i.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;

import java.math.BigDecimal;
/*extends is used to indicate that one class inherits from another class.
 Inheritance means that the subclass will obtain all the properties and methods of the parent class (superclass).*/

/*An interface is a purely abstract type that only contains method declarations without concrete implementations.
The class must implement the methods in the interface*/

@Entity
public class DebitAccount extends Account
    {
    private BigDecimal overDraftFee;
    }
