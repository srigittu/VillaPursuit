package service;

import java.util.List;

import org.hibernate.HibernateException;

import dao.ReviewDao;
import model.Advertisement;
import model.Review;;

public class ReviewService {

	ReviewDao reviewDao = new ReviewDao();
	public String addReview(Review review) throws HibernateException {
		reviewDao.insertReview(review);
        return "Address added successfully";
    }
	
	public boolean updateReview(Review review) throws HibernateException {
		return reviewDao.updateUserReview(review);
	}
	
	public List<Review> getAllReviews() throws HibernateException {
        List<Review> reviews = reviewDao.retrieveAllReviews();
        if (reviews.size() != 0) {
            return reviews;
        }
        return null;
	}
}
