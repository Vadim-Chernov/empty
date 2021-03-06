/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvr.bercut.empty.model;

import cvr.bercut.empty.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author chernov
 */
@Entity
@Table(name = "user_object", schema = Constant.SYS_SCHEMA)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorValue("User")


@Data
@AllArgsConstructor
@NoArgsConstructor
//@DynamicUpdate

public class User extends BaseObject {


    @Column(length = Constant.LENGHT_PWD)
    private String parole;

    @ManyToOne
    private Role role;

    public User(String name, String parole) {
        setName(name);
        setParole(parole);
    }

    @Override
    public String toString() {
        return getName() + " " + role;
    }
}
