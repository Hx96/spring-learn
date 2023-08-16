package com.hx.ddd.app.testspel;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 工人持有人
 *
 * @author kyle
 * @date 2023/08/16
 */
@Component("workersHolder")
public class WorkersHolder {
    public List<String> workers = new LinkedList<>();
    public Map<String, Integer> salaryByWorkers = new HashMap<>();

    public WorkersHolder() {
        workers.add("John");
        workers.add("Susie");
        workers.add("Alex");
        workers.add("George");

        salaryByWorkers.put("John", 35000);
        salaryByWorkers.put("Susie", 47000);
        salaryByWorkers.put("Alex", 12000);
        salaryByWorkers.put("George", 14000);
    }

    //Getters and setters
}

