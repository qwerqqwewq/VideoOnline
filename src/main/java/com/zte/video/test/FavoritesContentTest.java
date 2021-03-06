package com.zte.video.test;

import com.zte.video.dao.FavoritesContentDao;
import com.zte.video.entity.Favorites;
import com.zte.video.entity.FavoritesContent;
import com.zte.video.entity.Video;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author helloboy
 * Date:2019-06-27 14:52
 * Description:<描述>
 */
public class FavoritesContentTest {
    static private FavoritesContentDao favoritesContentDao = null;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        favoritesContentDao = (FavoritesContentDao) context.getBean("favoritesContentDao");
        System.out.println(favoritesContentDao);

        //测试插入，已成功
        //insertTest();

        //测试选择所有，已成功
        //selectAllTest();

        //测试修改备注，已成功
        //updateTest();

        //测试删除，已成功
        //deleteTest();

    }

    public static void insertTest() {
        FavoritesContent favoritesContent = new FavoritesContent();
        favoritesContent.setId(1);
        Favorites favorites = new Favorites();
        favorites.setId(1);
        favoritesContent.setFavorites(favorites);
        favoritesContent.setInsertDate("just now");
        favoritesContent.setRemark(null);
        Video video = new Video();
        video.setId(1);
        favoritesContent.setVideo(video);
        favoritesContentDao.insertFavoritesContent(favoritesContent);
    }

    public static void selectAllTest() {
        List<FavoritesContent> favoritesContents = favoritesContentDao.selectAll();
        for (FavoritesContent favoritesContent : favoritesContents) {
            System.out.println(favoritesContent);
        }
    }
    public static void selectAllByIdTest() {
        Favorites favorites = new Favorites();
        favorites.setId(1);
        List<FavoritesContent> favoritesContents = favoritesContentDao.selectAllById(favorites);
        for (FavoritesContent favoritesContent : favoritesContents) {
            System.out.println(favoritesContent);
        }
    }
    public static void updateTest() {
        FavoritesContent favoritesContent = new FavoritesContent();
        favoritesContent.setId(1);
        if (favoritesContent.getId()==1) {
            favoritesContent.setRemark("22222222");
        }
        favoritesContentDao.updateFavoritesContent(favoritesContent);
    }

    public static void deleteTest() {
        FavoritesContent favoritesContent = new FavoritesContent();
        favoritesContent.setId(1);
        if (favoritesContent.getId()==1) {
            favoritesContentDao.deleteFavoritesContent(favoritesContent);
        }

    }

}
