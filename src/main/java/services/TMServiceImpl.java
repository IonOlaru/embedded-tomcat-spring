package services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ion Olaru
 *         Date: 2014/02/10 - 16:07
 */
@Service
public class TMServiceImpl implements TMService {

    @Override
    public List<String> loadAll() {
        List<String> list = new ArrayList<String>();
        list.add("January");
        list.add("February");
        list.add("March");
        list.add("April");
        list.add("May");
        return list;
    }
}
