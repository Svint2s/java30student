package telran.java30.student.dao;

import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import telran.java30.student.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	Stream<Student> findByName(String name);
	
	Stream<Student> findByNameRegex(String regex);
	
	long countStudentByName(String name);
	
	@Query("{'?1':{'$gte':?2}}")
	Stream<Student> findByExamScores(String exam, int score);
}
