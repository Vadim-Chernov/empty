package cvr.bercut.empty.model;

import cvr.bercut.empty.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "role_object", schema = Constant.SYS_SCHEMA)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorValue("Role")

@Data
@AllArgsConstructor
//@NoArgsConstructor


public class Role extends BaseObject {

    @Override
    public String toString() {
        return getName();
    }

}
