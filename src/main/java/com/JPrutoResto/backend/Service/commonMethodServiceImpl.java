package com.JPrutoResto.backend.Service;





import com.JPrutoResto.backend.Entity.Packages;
import com.JPrutoResto.backend.Repository.packageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class commonMethodServiceImpl implements commonMethodService {

    @Autowired
    private packageRepository packageRepository;

    @Override
    public String addPackage(Packages packages) {
        packageRepository.save(packages);
        return "Added";
    }
}
