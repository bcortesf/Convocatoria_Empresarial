package com.bryancfz.wishlist.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bryancfz.wishlist.apirest.models.dao.IRecordWishListDao;
import com.bryancfz.wishlist.apirest.models.entity.RecordWishList;


@Service
public class RecordWishListImpl implements IRecordWishListService{
	
	@Autowired
	private IRecordWishListDao recordWishListDao;

	@Override
	public List<RecordWishList> findAll_() {
		return (List<RecordWishList>)this.recordWishListDao.findAll();
	}

}
