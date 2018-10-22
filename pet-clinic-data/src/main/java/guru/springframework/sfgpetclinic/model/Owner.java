package guru.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="telephone")
    private String telephone;

    @OneToMany( cascade= CascadeType.ALL, mappedBy="owner")
    private Set<Pet> pets = new HashSet<Pet>();

    public Pet getPet(String name){
        return getPet( name, false);
    }

    public Pet getPet(String name, boolean ignoreNew)
    {
        name = name.toLowerCase();
        for ( Pet pet : pets )
        {
           if (!ignoreNew || !pet.isNew())
           {
               String compName = pet.getName();
               compName = compName.toLowerCase();
               if( compName.equals((name)))
               {
                   return pet;
               }
           }
        }
        return null;
    }
}