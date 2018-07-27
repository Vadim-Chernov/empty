package cvr.bercut.empty.service;

import cvr.bercut.empty.model.BaseObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDataService {

    List<BaseObject> addDefaultObjects();

    String fetchDataByLastName(String lastName);

    List<BaseObject> findAll();

    BaseObject findById(long id);
    
}
