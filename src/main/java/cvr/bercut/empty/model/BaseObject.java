package cvr.bercut.empty.model;

import cvr.bercut.empty.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "base_object", schema = Constant.SYS_SCHEMA)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn()
@NamedQuery(name = "BaseObject.All",
        query = "SELECT e FROM BaseObject e ")
public class BaseObject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name",length = Constant.LENGHT_NAME)
    private String name;

    @Column(name = "description")
    private String description;

//    public String getDtype(){
//        return this.getClass().getTypeName();
//    }
}
