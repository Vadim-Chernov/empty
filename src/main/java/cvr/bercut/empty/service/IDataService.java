package cvr.bercut.empty.service;

import cvr.bercut.empty.model.BaseObject;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IDataService {

    List<BaseObject> addDefaultObjects();

    String fetchDataByLastName(String lastName);

    List<BaseObject> findAll();

    String findById(long id);
    
}
