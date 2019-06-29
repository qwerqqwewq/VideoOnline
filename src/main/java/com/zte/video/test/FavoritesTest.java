package com.zte.video.test;

import com.zte.video.dao.FavoritesDao;
import com.zte.video.entity.Favorites;
import com.zte.video.entity.User;
import com.zte.video.utils.CurrentDate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Author:helloboy
 * Date:2019-06-27 11:18
 * Description:<描述>
 */
public class FavoritesTest {

    private static FavoritesDao favoritesDao;
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        favoritesDao = (FavoritesDao) context.getBean("favoritesDao");

        selectById();
        selectAll();
        insert();
        update();
        delete();

    }

    public static void selectAll() {
        List<Favorites> favorites=favoritesDao.selectAll();
        for (Favorites favorites1:favorites){
            System.out.println(favorites1);
        }


    }
    public static void selectById(){
        User user=new User();
        user.setId(3);
        List<Favorites> favorites=favoritesDao.selectById(user);
        for(Favorites favorites1:favorites){
            System.out.println(favorites1);
        }
    }
    public static void insert(){
        User user=new User();
        user.setId(1);
        Favorites favorites = new Favorites(CurrentDate.getCurrentDate(),2,"name","remark",user);
        favoritesDao.insertFavorites(favorites);

    }
    public static void delete(){
        Favorites favorites=new Favorites();
        favorites.setId(1);
        favoritesDao.deleteFavorites(favorites);

    }
    public static void update(){
        User user=new User();
        Favorites favorites = new Favorites(CurrentDate.getCurrentDate(),1,"name1","remark1",user);
        favoritesDao.updateFavorites(favorites);
    }

}
