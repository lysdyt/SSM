package com.yt.commons;

import com.entity.mapper.UsersMapper;
import com.yt.commons.cache.ShardedJedisCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.ShardedJedisPool;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring.xml" })
public class UtilsTest {


    @Autowired
    private ShardedJedisPool shardedJedisPool;


    @Autowired
    private UsersMapper usersMapper;

    private  static int num=0;

    public static void t(){
        try {
            Thread.sleep(2);
        } catch (Exception ex){

        }

        num++;
    }

    @Test
    public void test(){

        /*ShardedJedis jedis=shardedJedisPool.getResource();
        jedis.set("yi","111");
        Utils.log.info(jedis.get("yi"));

        Utils.log.info(jedis.get("yt"));
        Utils.log.info("");*/
        ApplicationContextUtils.getBean("applicationContextUtils");
        for (int i = 0; i < 1000; i++) {
            final Date date=new Date();
            final String string="redis-"+new SimpleDateFormat("mm:ss SSS").format(date).toString();

            new Thread(new Runnable() {
                @Override
                public void run() {

                    UtilsTest.t();
                }
            }).start();
        }

        Utils.log.info(""+num);
    }

}