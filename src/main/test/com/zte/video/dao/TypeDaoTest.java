package com.zte.video.dao;

import com.zte.video.entity.Type;
import com.zte.video.service.TypeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author:helloboy
 * Date:2019-06-25 15:41
 * Description:<描述>
 */
public class TypeDaoTest {

    @Autowired
    TypeService typeService;

    @Test
    public void testSelectAll() throws Exception {

    }

    @Test
    public void testInsertType() throws Exception {
        Type type = new Type();
        type.setType("快乐片");
        typeService.addType(type);
    }

    @Test
    public void testUpdateType() throws Exception {

    }
}