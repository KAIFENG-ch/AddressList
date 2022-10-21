package com.example.addresslist.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;

import java.util.Date;

public class SystemLogAspect {

    public static ThreadLocal<Date> beginTimeThreadLocal = new NamedThreadLocal<Date>("Thread local beginTime");

}
