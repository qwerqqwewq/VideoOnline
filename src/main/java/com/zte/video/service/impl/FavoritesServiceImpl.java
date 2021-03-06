package com.zte.video.service.impl;

import com.zte.video.dao.FavoritesDao;
import com.zte.video.entity.Favorites;
import com.zte.video.entity.User;
import com.zte.video.service.FavoritesService;
import com.zte.video.utils.CurrentDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:helloboy
 * @Date:2019-06-25 17:09
 * Description:<描述>
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class FavoritesServiceImpl implements FavoritesService {
    @Autowired
    private FavoritesDao favoritesDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    /**
     * 查询所有收藏夹
     */
    public List<Favorites> findAll() {
        return favoritesDao.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public List<Favorites> findById(User user) {
        return favoritesDao.selectById(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int addFavorites(Favorites favorites) {
        favorites.setCreateDate(CurrentDate.getCurrentDate());
        return favoritesDao.insertFavorites(favorites);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int modifyFavorites(Favorites favorites) {
        return favoritesDao.updateFavorites(favorites);
    }


    @Override
    public int removeFavorites(Integer id) {
        return favoritesDao.deleteFavorites(id);
    }


}
