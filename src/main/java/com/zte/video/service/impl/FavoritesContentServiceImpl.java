package com.zte.video.service.impl;

import com.zte.video.dao.FavoritesContentDao;
import com.zte.video.entity.Favorites;
import com.zte.video.entity.FavoritesContent;
import com.zte.video.service.FavoritesContentService;
import com.zte.video.utils.CurrentDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:helloboy
 * @Date:2019-06-26 8:54
 * Description:<描述>
 */
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class FavoritesContentServiceImpl implements FavoritesContentService {
    @Autowired
    private FavoritesContentDao favoritescontentDao;

    /**
     * 查询所有收藏夹内容
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public List<FavoritesContent> findAll(){
        return favoritescontentDao.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public List<FavoritesContent> findAllById(Favorites favorites) {
        return favoritescontentDao.selectAllById(favorites);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int addFavoritesContent(FavoritesContent favoritescontent) {
        favoritescontent.setInsertDate(CurrentDate.getCurrentDate());
        return favoritescontentDao.insertFavoritesContent(favoritescontent);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int modifyFavoritesContent(FavoritesContent favoritescontent) {
        return favoritescontentDao.updateFavoritesContent(favoritescontent);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int updateFavoritesContent(FavoritesContent favoritescontent) {
        return favoritescontentDao.deleteFavoritesContent(favoritescontent);
    }

}
