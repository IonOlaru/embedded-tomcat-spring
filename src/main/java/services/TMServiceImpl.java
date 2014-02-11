package services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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

    @PostConstruct
    public void init() {
        System.out.println("Initializing bean...");
        System.out.println("Bean initialized.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying bean...");
        System.out.println("Bean destroyed.");
    }
}
