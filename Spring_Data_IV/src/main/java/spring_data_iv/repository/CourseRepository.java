package spring_data_iv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring_data_iv.entity.Course;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course, Long> {
    //drive queries

    List<Course> findCoursesByCategory(String category);
    List<Course> findByCategoryOrderByName(String category);
    boolean existsByName(String name);
    int countByCategory(String category);
    List<Course> findCourseByDescriptionStartsWith(String description);


    //JPQL queries
    @Query("select c From Course c Where c.rating = ?1")
    List<Course>retireByRate(int rating);// ?1-> first of the parameter ,?2-> second of the parameter

    @Query("select c from  Course c where c.name like %?1%")
    List<Course> retireByContains(String name);// like %?1%  -> contains,startsWith,endsWith
}
