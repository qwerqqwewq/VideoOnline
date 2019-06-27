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
        video.setId(6);
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
        favorites.setId(2);
        List<FavoritesContent> favoritesContents = favoritesContentDao.selectAllById(favorites);
        for (FavoritesContent favoritesContent : favoritesContents) {
            System.out.println(favoritesContent);
        }
    }
    public static void updateTest() {
        FavoritesContent favoritesContent = new FavoritesContent();
        favoritesContent.setRemark("11111111");
        favoritesContentDao.updateFavoritesContent(favoritesContent);
    }
    public static void deleteTest() {
        FavoritesContent favoritesContent = new FavoritesContent();
        Video video = new Video();
        video.setId(3);
        favoritesContent.setVideo(video);
        favoritesContentDao.deleteFavoritesContent(favoritesContent);
    }

}
