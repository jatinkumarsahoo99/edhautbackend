package com.edhaut.mysql.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edhaut.mysql.entity.ScheduledClass;

@Repository
public interface ScheduledClassRepo extends JpaRepository<ScheduledClass, String> {
	
	/*
	 * default List<ScheduledClass> findByClassDate(String classDate) throws
	 * ParseException { DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 * Date convertedDate = dateFormat.parse(classDate); return
	 * findByClassDate(convertedDate); }
	 */
	
	@Query(value = "SELECT * FROM tbl_scheduled_class p where p.classNameId = :classNameId and p.classStartDate = :classStartDate",nativeQuery = true)
	    List<ScheduledClass> findByclassStartDateWithClassId(@Param("classStartDate") Date classStartDate,@Param("classNameId") String classNameId);
}
