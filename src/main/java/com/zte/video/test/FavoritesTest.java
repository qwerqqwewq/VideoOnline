package com.zte.video.test;

import com.zte.video.dao.FavoritesDao;
import com.zte.video.entity.Favorites;
import com.zte.video.entity.User;
import com.zte.video.utils.CurrentDate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author:helloboy
 * Date:2019-06-27 11:18
 * Description:<描述>
 */
public class FavoritesTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        FavoritesDao favoritesDao = (FavoritesDao) context.getBean("favoritesDao");
        User user = new User();
        user.setId(1);
        Favorites favorites = new Favorites(CurrentDate.getCurrentDate(), null, "测试收藏夹","测试收藏夹的备注",user);

        favoritesDao.insertFavorites(favorites);
    }

}
