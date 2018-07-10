package com.cs.mvc.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * 初始化数据Service，将常用数据缓存到内存中
 */
@Service
public class InitData implements ApplicationListener<ContextRefreshedEvent> {

	private Logger Logger = LoggerFactory.getLogger(InitData.class);
	
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            try {
                Logger.info("----------------------初始化数据成功----------------------");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
