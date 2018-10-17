package guru.springframework.sfgpetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID> {

    protected Map<ID, T> map = new HashMap<>();

    Set<T> finaAll()
    {
        return new HashSet<>( map.values());
    }

    T findById( ID id){
        return map.get(id);
    }


}
