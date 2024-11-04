package ir.maktabsharif.service.impl;

import ir.maktabsharif.repository.BaseRepository;
import ir.maktabsharif.service.BaseService;

public class BaseServiceImpl <T> implements BaseService <T>{
    private BaseRepository<T> repository;

    public BaseServiceImpl(BaseRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public void save(T t) {
        try {

            repository.saveOrUpdate(t);

        }catch (Exception e) {
            System.out.println("data connection failed :( ");
        }
    }

}
