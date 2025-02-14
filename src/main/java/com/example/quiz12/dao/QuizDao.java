package com.example.quiz12.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.quiz12.entity.Quiz;

import jakarta.transaction.Transactional;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{
	
//	/**
//	 * 1. 因為透過 join 來取得跨表的欄位，所以 nativeQuery 只能是 false <br>
//	 * 2. nativeQuery = false，語法中表的名稱會改成 Entity class 的名稱，欄位名稱則是 Entity 的屬性變數名稱
//	 * 3. nativeQuery = false 時，用來裝載的類別 SearchVo 必須要透過 new
//	 * 4. 因為 SearchVo 沒有被 Spring boot 託管，所以要跟加上路徑
//	 */
//	@Query(value = "select new com.example.quiz12.vo.SearchVo(quizId, name, description, "//
//			+ " startDate, endDate,	published, questionList)" //
//			+ " from Quiz join Question on Quiz.id = Question.quizId", //
//			nativeQuery = false)
//	public List<SearchVo> getAll();
	
	@Query(value = "select * from quiz", nativeQuery = true)
	public List<Quiz> getAllQuiz();
	@Query(value = "select * from quiz where name like %?1% and start_date >= ?2 and end_date <= ?3", nativeQuery = true)
	public List<Quiz> getQuiz(String name, LocalDate startDate , LocalDate endDate );
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM quiz WHERE id in(?1)",nativeQuery = true)
	public int deleteByQuizIdIn(List<Integer> quizIds);
	
	@Query(value = "SELECT COUNT(id) FROM quiz WHERE id = ?1",nativeQuery = true)
	public int selectCount(int quizId);
	//查找 id 以及 published = true 的問卷
	@Query(value = "SELECT COUNT(id) FROM quiz WHERE id = ?1 AND published = true",nativeQuery = true)
	public int selectCountIspublished(int quizId);
	@Query(value = "UPDATE quiz SET name = ?1, description = ?2, startDate = ?3, endDate = ?4, published = ?5 WHERE id = id",nativeQuery = true)
	public int UpdateById(String name , String description , LocalDate startDate ,LocalDate endDate , boolean published,int id);
}
