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
//@ToString()

@Entity
@Table(name = "base_object", schema = Constant.SYS_SCHEMA)
@Inheritance(strategy = InheritanceType.JOINED)
//@MappedSuperclass
@DiscriminatorColumn
public class BaseObject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name",length = Constant.LENGHT_NAME)
    private String name;

    @Column(name = "description")
    private String description;

//    @Column(name = "DTYPE",length = Constant.LENGHT_NAME)
//    private String dtype;
    public String getDtype(){
        return this.getClass().getTypeName();
    }
}
