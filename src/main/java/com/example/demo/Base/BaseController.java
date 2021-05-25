package com.example.demo.Base;

import com.example.demo.util.IdGeneratorUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    private IdGeneratorUtils idGeneratorUtils;

    public IdGeneratorUtils getIdGeneratorUtils() {
        return idGeneratorUtils;

    }
}
