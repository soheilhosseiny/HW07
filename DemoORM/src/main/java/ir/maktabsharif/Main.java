package ir.maktabsharif;

import ir.maktabsharif.model.Course;
import ir.maktabsharif.model.Student;
import ir.maktabsharif.repository.BaseRepository;
import ir.maktabsharif.repository.impl.BaseRepositoryImpl;
import ir.maktabsharif.service.BaseService;
import ir.maktabsharif.service.impl.BaseServiceImpl;
import ir.maktabsharif.util.EntityManagerProvider;

import javax.persistence.*;

public class Main {

    public static void main(String[] args) {

        Course course = Course
                .builder()
                .title("java")
                .unit(1000)
                .build();

        BaseService<Course> baseService = new BaseServiceImpl<>(new BaseRepositoryImpl<Course>(new EntityManagerProvider()));
        baseService.save(course);

        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("jdbc-postgres");
        EntityManager em = emf.createEntityManager();
        emf.close();*/

    }

}
