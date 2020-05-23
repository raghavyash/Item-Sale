package com.raghav.lnt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raghav.lnt.dao.BlogServiceDao;
import com.raghav.lnt.entity.BlogCommentEntity;
import com.raghav.lnt.entity.BlogEntity;
import com.raghav.lnt.entity.QueryEntity;
import com.raghav.lnt.mapper.BlogCommentMapper;
import com.raghav.lnt.mapper.BlogMapper;
import com.raghav.lnt.mapper.QueryMapper;
import com.raghav.lnt.model.BlogCommentModel;
import com.raghav.lnt.model.BlogModel;
import com.raghav.lnt.model.QueryModel;
import com.raghav.lnt.model.SearchBlogDTO;
import com.raghav.lnt.repository.BlogCommentRepository;
import com.raghav.lnt.repository.BlogRepository;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
	@Autowired
	BlogRepository blogRepository;
	
	@Autowired
	BlogServiceDao blogServiceDao;

	public BlogModel saveBlog(BlogModel model) {
		BlogModel model2 = null;
		BlogEntity entity = BlogMapper.blogModelToEntity(model);
		BlogEntity entity2 = blogRepository.save(entity);
		if (entity2 != null) {
			model2=	BlogMapper.blogEntityToModel(entity2);
		}
		return model2;

	}
   
	public BlogModel getBlogDetailById(Long id) {
		BlogModel model = null;
		BlogEntity entity = blogRepository.getBlogDetailByBlogId(id);
		if (entity != null) {
			model = BlogMapper.blogEntityToModel(entity);
		}
		return model;
	}
	public List<BlogModel> getBlogDetailListByBlogTypeId(Long id){
		List<BlogModel> list = null;
		List<BlogEntity> dbList = blogRepository.getBlogDetailListByBlogTypeId(id);
		if (dbList != null) {
			list = BlogMapper.blogDetailList(dbList);
		}
		return list;
	}
	public List<BlogModel> getBlogDetailListByUserId(Long userId) {
		List<BlogModel> list = null;
		List<BlogEntity> dbList = blogRepository.findBlogByUserId(userId);
		if (dbList != null) {
			list = BlogMapper.blogDetailList(dbList);
		}
		return list;
	}
	public	List<BlogModel> getQueryDetailListWithoutUserId(){
		List<BlogModel> list = null;
		List<BlogEntity> dbList = blogRepository.findBlogListWithoutUserId();
		if (dbList != null) {
			//Set<QueryEntity> setList= new HashSet<QueryEntity>(dbList);
			list = BlogMapper.blogDetailList(dbList);
		}
		return list;
	}
	public List<BlogModel> searchBlogDetailList(Long id ,String search) {
		List<BlogModel> list = null;
		List<BlogEntity> dbList= null;   
		if(id!= null && search== null){
			 dbList = blogRepository.searchBlogListById(id);
	         }else{
	         dbList = blogRepository.searchBlogListByIdWithName(id, search);
	         }
			if (dbList != null) {
				list = BlogMapper.blogDetailList(dbList);
		}
		return list;
	}
    
	public List<BlogModel> searchBlog(SearchBlogDTO dto) {
		List<BlogModel> list = null;
		List<BlogEntity> dbList= blogServiceDao.searchBlog(dto);
		if (dbList != null) {
			list = BlogMapper.blogDetailList(dbList);
	}
		return list;
	}
 
	
	public List<BlogModel> getTopCountBlogDetailList() {
		List<BlogModel> dbList=	blogServiceDao.getTopCountBlogDetailList();
		return dbList;
	}
	public List<BlogModel> getBlogTypeCountList() {
		List<BlogModel> dbList=	blogServiceDao.getBlogTypeCountList();
		return dbList;
	}
}
